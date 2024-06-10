public class ReplaceWordLC648
{
	/*
		https://leetcode.com/problems/replace-words/description/
		Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
		Output: "the cat was rat by the bat"
	*/

	//Brute-Force O(N*M)
	public String replaceWords_brute(List<String> dictionary, String sentence) {

        String splits[] = sentence.split(" ");
        
        for(int i=0; i<splits.length; i++)
        {
            String currentWord = splits[i];
            for(int j=0; j<dictionary.size();j++)
            {
                String currentRoot = dictionary.get(j);

                if(currentRoot.substring(0,1).equals(currentWord.substring(0,1)))
                {
                    if(currentWord.length() >= currentRoot.length() 
                      && currentRoot.equals(currentWord.substring(0,currentRoot.length())))
                    {
                        if(currentRoot.length() < splits[i].length())
                            splits[i]=currentRoot;
                    }
                }
            }
        }
        
        sentence = "";
        for(String k : splits) sentence+=k+" ";
        return sentence.trim();
	}

	public String replaceWords(List<String> dictionary, String sentence)
	{

		
	}
}