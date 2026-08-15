# 📊 Visual Infographics & Real-World Use Cases: Rate Limiting Algorithms

This document contains highly detailed, professional infographics and architectural flowcharts for the five primary rate-limiting algorithms, along with real-world examples of which industry giants use each approach. 

These visual diagrams are fully compatible with GitHub and markdown viewers, allowing you to quickly visualize how traffic is throttled at FAANG-level scale [17].

---

## 🪙 1. The Token Bucket Algorithm

The **Token Bucket** is one of the most widely used algorithms due to its simplicity, low memory footprint, and ability to handle short bursts of traffic [23].

### 🏢 Real-World Use Case
*   **Used by:** **Amazon** [11] and **Stripe** [11].
*   **Why they use it:** It allows clients to occasionally burst their traffic (e.g., sending multiple rapid requests) as long as there are accumulated tokens in the bucket [13]. It is extremely memory-efficient, storing only two variables (tokens and last updated timestamp) per user [23].

### 🎨 Visual Architecture Infographic
![Token Bucket Algorithm](./token_bucket_diagram_v2.jpg)

### ⚙️ Algorithmic Decision Tree (Mermaid)
```mermaid
flowchart TD
    Start([Incoming Request]) --> GetState[Retrieve Bucket State: Token Count & Last Refill Timestamp]
    GetState --> CalculateRefill[Calculate New Tokens: <br/>TokensToAdd = ElapsedTime * RefillRate]
    CalculateRefill --> UpdateTokens[NewTokenCount = minCapacity, TokenCount + TokensToAdd]
    UpdateTokens --> CheckTokens{Are NewTokenCount >= 1?}
    
    CheckTokens -- Yes --> Allow[Decrement Token Count by 1 <br/>Update Last Refill Timestamp <br/>Allow Request]
    CheckTokens -- No --> Reject[Reject Request <br/>Return HTTP 429 Too Many Requests]
    
    Allow --> End([Process API Response])
    Reject --> End
    
    style Allow fill:#d4edda,stroke:#28a745,stroke-width:2px;
    style Reject fill:#f8d7da,stroke:#dc3545,stroke-width:2px;
```

---

## 🪣 2. The Leaking Bucket Algorithm

The **Leaking Bucket** uses a first-in, first-out (FIFO) queue to guarantee a constant, smooth rate of outgoing traffic, making it perfect for backend processing pipelines [13, 26].

### 🏢 Real-World Use Case
*   **Used by:** **Shopify** [15].
*   **Why they use it:** Shopify uses this for their REST Admin API to ensure that clients do not spike or overwhelm backend databases. Requests are smoothed to a stable, continuous outflow rate [15].

### 🎨 Visual Architecture Infographic
![Leaking Bucket Algorithm](./leaking_bucket_diagram_v2.jpg)

### ⚙️ Algorithmic Decision Tree (Mermaid)
```mermaid
flowchart TD
    Start([Incoming Request]) --> CheckQueue{Is Queue Size < Capacity B?}
    
    CheckQueue -- Yes --> Queue[Push Request to FIFO Queue]
    CheckQueue -- No --> Reject[Reject Request <br/>Return HTTP 429 Too Many Requests]
    
    Queue --> Consumer[Background Worker Pulls from Queue at Constant Rate R]
    Consumer --> Process[Forward Request to Backend Service]
    
    style Queue fill:#d4edda,stroke:#28a745,stroke-width:2px;
    style Reject fill:#f8d7da,stroke:#dc3545,stroke-width:2px;
```

---

## 🪟 3. The Fixed Window Counter Algorithm

The **Fixed Window Counter** divides the timeline into static, non-overlapping windows (e.g., 1 minute) and tracks the request count within each window [16].

### 🏢 Real-World Use Case
*   **Used by:** **Google Docs API** [3].
*   **Why they use it:** Google Docs uses a fixed-window quota system (e.g., 300 requests per user per 60 seconds) [3]. This works perfectly for resetting available quotas at human-friendly intervals (like at the start of a new minute or day) [18].

### 🎨 Visual Architecture Infographic
![Fixed Window Counter](./fixed_window_diagram_v2.jpg)

### ⚙️ Algorithmic Decision Tree (Mermaid)
```mermaid
flowchart TD
    Start([Incoming Request]) --> GetCurrentWindow[Calculate Current Window Timestamp <br/>Key = UserID:Timestamp]
    GetCurrentWindow --> CheckCounter{Is Counter Key in Cache?}
    
    CheckCounter -- Yes --> Increment[Increment Cache Counter]
    CheckCounter -- No --> Create[Set Counter to 1 <br/>Set Key Expiry to Window Size]
    
    Increment --> CheckLimit{Is Counter > Max Limit?}
    Create --> Allow[Allow Request]
    
    CheckLimit -- No --> Allow
    CheckLimit -- Yes --> Reject[Reject Request <br/>Return HTTP 429 Too Many Requests]
    
    style Allow fill:#d4edda,stroke:#28a745,stroke-width:2px;
    style Reject fill:#f8d7da,stroke:#dc3545,stroke-width:2px;
```

---

## 📜 4. The Sliding Window Log Algorithm

The **Sliding Window Log** solves the window boundary spike problem of the Fixed Window algorithm by tracking the exact timestamps of every request in a sorted set (usually Redis Sorted Sets `ZSET`) [18].

### 🏢 Real-World Use Case
*   **Used by:** **ClassDojo** [36].
*   **Why they use it:** ClassDojo uses rolling rate limits powered by Redis Sorted Sets [36] because they require absolute precision in rolling windows [20]. This prevents boundary-edge bursts and guarantees that a client can never exceed their rate limits within any rolling timeframe [18].

### 🎨 Visual Architecture Infographic
![Sliding Window Log](./sliding_window_log_diagram_v2.jpg)

### ⚙️ Algorithmic Decision Tree (Mermaid)
```mermaid
flowchart TD
    Start([Incoming Request]) --> CleanOld[Remove all logged timestamps <br/>older than: CurrentTime - WindowSize]
    CleanOld --> LogNew[Log current request timestamp]
    LogNew --> CountLogs[Count remaining active logs in sorted set]
    CountLogs --> CheckLimit{Is Log Count <= Max Limit?}
    
    CheckLimit -- Yes --> Allow[Allow Request]
    CheckLimit -- No --> Reject[Remove latest timestamp log <br/>Reject Request <br/>Return HTTP 429]
    
    style Allow fill:#d4edda,stroke:#28a745,stroke-width:2px;
    style Reject fill:#f8d7da,stroke:#dc3545,stroke-width:2px;
```

---

## 📊 5. The Sliding Window Counter Algorithm

The **Sliding Window Counter** is a memory-efficient hybrid of Fixed Window and Sliding Log [20]. It estimates the request rate mathematically based on the percentage of overlap between the current time and the two adjacent fixed windows.

### 🏢 Real-World Use Case
*   **Used by:** **Cloudflare** [23].
*   **Why they use it:** Cloudflare operates at a global scale, where tracking raw timestamp logs consumes far too much memory [20]. This hybrid algorithm requires checking only two counters per window, saving massive amounts of memory [22]. It provides a near-perfect approximation of the actual rate: Cloudflare's experiments across 400 million requests showed that only 0.003% of requests were wrongly allowed or throttled [23].

### 🎨 Visual Architecture Infographic
![Sliding Window Counter](./sliding_window_counter_diagram_v2.jpg)

### ⚙️ Algorithmic Decision Tree (Mermaid)
```mermaid
flowchart TD
    Start([Incoming Request]) --> GetOverlap[Retrieve Prev Window Count & Current Window Count]
    GetOverlap --> Math[Calculate Weight = 1.0 - CurrentWindowProgressPercentage]
    Math --> Estimate[Estimated Count = PrevCount * Weight + CurrentCount]
    Estimate --> CheckLimit{Is Estimated Count <= Max Limit?}
    
    CheckLimit -- Yes --> Increment[Increment Current Window Counter <br/>Allow Request]
    CheckLimit -- No --> Reject[Reject Request <br/>Return HTTP 429 Too Many Requests]
    
    style Increment fill:#d4edda,stroke:#28a745,stroke-width:2px;
    style Reject fill:#f8d7da,stroke:#dc3545,stroke-width:2px;
```
