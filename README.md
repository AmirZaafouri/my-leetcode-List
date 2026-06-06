# 🚀 LeetCode DSA Roadmap - Java Solutions

This repository contains my solutions to the AlgoMap Data Structures & Algorithms Roadmap using Java.

## 🎯 Goal

- Master Data Structures & Algorithms
- Prepare for coding interviews
- Learn common problem-solving patterns
- Build a reusable algorithm template library
- Track my progress through the AlgoMap roadmap

---

# 📂 Repository Structure

```text
LeetCode-Roadmap/
│
├── Arrays-Strings/
├── HashMap-HashSet/
├── Two-Pointers/
├── Sliding-Window/
├── Stack/
├── LinkedList/
├── BinarySearch/
├── Trees/
├── Heap/
├── Backtracking/
├── Graph/
├── DynamicProgramming/
│
└── README.md
```

---

# 📚 DSA Patterns Cheat Sheet

---

## 1️⃣ Arrays & Strings

### Generic Traversal

```java
public void solve(int[] nums) {

    for (int i = 0; i < nums.length; i++) {

    }
}
```

### Common Techniques

- Traversal
- Prefix Sum
- Matrix Traversal
- String Manipulation

### Complexity

```text
Time: O(n)
Space: O(1)
```

---

## 2️⃣ HashMap & HashSet

### Frequency Counter

```java
Map<Integer, Integer> map = new HashMap<>();

for (int num : nums) {
    map.put(num, map.getOrDefault(num, 0) + 1);
}
```

### HashSet Lookup

```java
Set<Integer> set = new HashSet<>();

for (int num : nums) {

    if (set.contains(num)) {
        return;
    }

    set.add(num);
}
```

### Common Use Cases

- Two Sum
- Duplicate Detection
- Frequency Counting
- Grouping Problems

### Complexity

```text
Time: O(n)
Space: O(n)
```

---

## 3️⃣ Two Pointers

### Opposite Direction

```java
int left = 0;
int right = nums.length - 1;

while (left < right) {

    if (condition) {
        left++;
    } else {
        right--;
    }
}
```

### Same Direction

```java
int slow = 0;

for (int fast = 0; fast < nums.length; fast++) {

    if (condition) {

        nums[slow] = nums[fast];
        slow++;
    }
}
```

### Common Use Cases

- Sorted Arrays
- Remove Duplicates
- Palindrome Validation
- Pair Problems

---

## 4️⃣ Sliding Window

### Variable Window

```java
int left = 0;

for (int right = 0; right < nums.length; right++) {

    while (windowInvalid) {
        left++;
    }

    // update answer
}
```

### Fixed Window

```java
int sum = 0;
int k = 3;

for (int i = 0; i < nums.length; i++) {

    sum += nums[i];

    if (i >= k) {
        sum -= nums[i - k];
    }
}
```

### Common Use Cases

- Longest Substring
- Maximum Sum Subarray
- Minimum Window Substring

### Complexity

```text
Time: O(n)
Space: O(1)
```

---

## 5️⃣ Stack

### Generic Stack Pattern

```java
Stack<Integer> stack = new Stack<>();

for (int num : nums) {

    while (!stack.isEmpty() && condition) {
        stack.pop();
    }

    stack.push(num);
}
```

### Parentheses Validation

```java
Stack<Character> stack = new Stack<>();

for (char c : s.toCharArray()) {

    if (c == '(') {
        stack.push(c);
    } else {

        if (stack.isEmpty()) {
            return false;
        }

        stack.pop();
    }
}
```

### Common Use Cases

- Monotonic Stack
- Next Greater Element
- Parentheses Problems

---

## 6️⃣ Linked List

### Node Definition

```java
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
```

### Fast & Slow Pointer

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;
}
```

### Reverse Linked List

```java
ListNode prev = null;
ListNode curr = head;

while (curr != null) {

    ListNode next = curr.next;

    curr.next = prev;

    prev = curr;
    curr = next;
}

return prev;
```

---

## 7️⃣ Binary Search

### Standard Binary Search

```java
int left = 0;
int right = nums.length - 1;

while (left <= right) {

    int mid = left + (right - left) / 2;

    if (nums[mid] == target) {
        return mid;
    }

    if (nums[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
```

### Complexity

```text
Time: O(log n)
Space: O(1)
```

---

## 8️⃣ Trees

### TreeNode

```java
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
}
```

### DFS

```java
public void dfs(TreeNode root) {

    if (root == null) {
        return;
    }

    dfs(root.left);

    dfs(root.right);
}
```

### BFS

```java
Queue<TreeNode> queue = new LinkedList<>();

queue.offer(root);

while (!queue.isEmpty()) {

    TreeNode current = queue.poll();

    if (current.left != null) {
        queue.offer(current.left);
    }

    if (current.right != null) {
        queue.offer(current.right);
    }
}
```

### Traversals

```text
Preorder  : Root Left Right
Inorder   : Left Root Right
Postorder : Left Right Root
LevelOrder: BFS
```

---

## 9️⃣ Heap / Priority Queue

### Min Heap

```java
PriorityQueue<Integer> minHeap =
        new PriorityQueue<>();
```

### Max Heap

```java
PriorityQueue<Integer> maxHeap =
        new PriorityQueue<>(Collections.reverseOrder());
```

### Top K Pattern

```java
PriorityQueue<Integer> heap =
        new PriorityQueue<>();

for (int num : nums) {

    heap.offer(num);

    if (heap.size() > k) {
        heap.poll();
    }
}
```

### Complexity

```text
Insert: O(log n)
Remove: O(log n)
Peek: O(1)
```

---

## 🔟 Backtracking

### Subsets Template

```java
List<List<Integer>> result = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public void backtrack(int start) {

    result.add(new ArrayList<>(path));

    for (int i = start; i < nums.length; i++) {

        path.add(nums[i]);

        backtrack(i + 1);

        path.remove(path.size() - 1);
    }
}
```

### Permutations Template

```java
boolean[] used = new boolean[n];

public void dfs() {

    if (path.size() == n) {

        result.add(new ArrayList<>(path));
        return;
    }

    for (int i = 0; i < n; i++) {

        if (used[i]) {
            continue;
        }

        used[i] = true;
        path.add(nums[i]);

        dfs();

        path.remove(path.size() - 1);
        used[i] = false;
    }
}
```

### Golden Rule

```text
Choose
↓
Explore
↓
Unchoose (Backtrack)
```

---

## 1️⃣1️⃣ Graphs

### DFS

```java
public void dfs(int node) {

    visited[node] = true;

    for (int neighbor : graph.get(node)) {

        if (!visited[neighbor]) {
            dfs(neighbor);
        }
    }
}
```

### BFS

```java
Queue<Integer> queue = new LinkedList<>();

queue.offer(start);
visited[start] = true;

while (!queue.isEmpty()) {

    int node = queue.poll();

    for (int neighbor : graph.get(node)) {

        if (!visited[neighbor]) {

            visited[neighbor] = true;
            queue.offer(neighbor);
        }
    }
}
```

### Graph Representation

```java
Map<Integer, List<Integer>> graph =
        new HashMap<>();
```

### Common Problems

- Number of Islands
- Clone Graph
- Course Schedule
- Connected Components

---

## 1️⃣2️⃣ Dynamic Programming

### Memoization

```java
Map<Integer, Integer> memo = new HashMap<>();

public int dp(int n) {

    if (n <= 1) {
        return n;
    }

    if (memo.containsKey(n)) {
        return memo.get(n);
    }

    memo.put(
        n,
        dp(n - 1) + dp(n - 2)
    );

    return memo.get(n);
}
```

### Tabulation

```java
int[] dp = new int[n + 1];

dp[0] = 0;
dp[1] = 1;

for (int i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
}
```

### DP Thinking Process

```text
1. Define State
2. Find Transition
3. Define Base Cases
4. Memoization or Tabulation
5. Optimize Space
```

---

# 🧠 Problem Solving Checklist

Before coding:

```text
□ Understand the problem
□ Identify input/output
□ Find constraints
□ Brute force solution
□ Optimize
□ Choose pattern
□ Dry run
□ Code
□ Test edge cases
```

---

# 📊 Progress Tracker

| Topic | Status |
|---------|---------|
| Arrays & Strings | ⬜ |
| HashMap & HashSet | ⬜ |
| Two Pointers | ⬜ |
| Sliding Window | ⬜ |
| Stack | ⬜ |
| Linked List | ⬜ |
| Binary Search | ⬜ |
| Trees | ⬜ |
| Heap | ⬜ |
| Backtracking | ⬜ |
| Graphs | ⬜ |
| Dynamic Programming | ⬜ |

---

# 📝 Solution Template

Use this format for every problem:

```text
Problem:
Two Sum

Difficulty:
Easy

Pattern:
HashMap

Approach:
Store visited numbers in a HashMap and check complement.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Takeaway:
HashMap allows O(1) lookup.
```

---

# 🏆 Goal

- Solve the entire AlgoMap Roadmap
- Master common interview patterns
- Reach consistent LeetCode Medium solving ability
- Build strong problem-solving intuition
- Be interview ready for FAANG-level companies

---

Happy Coding 🚀
