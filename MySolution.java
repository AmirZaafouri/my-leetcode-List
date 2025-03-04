/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */
import java.util.HashMap;
import java.util.Map;


public class MySolution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        String x = "aaabbaaa";
        int[] A = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        String[] str = new String[] { "2", "1", "+", "3", "*" };
        ListNode he1 = new ListNode(1);
        ListNode he2 = new ListNode(2);
        ListNode he3 = new ListNode(3);
        ListNode he4 = new ListNode(4);
        ListNode he5 = new ListNode(5, null);
        he1.next = he2;
        he2.next = he3;
        he3.next = he4;
        he4.next = he5;
        ///////////////////=================  TREE   ===================//////////////////////
        // Create a sample tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Calculate the sum of all nodes in the tree
        DFS(root);
        // System.out.println("Total Sum of Tree: " + totalSum);
        // System.out.println("Hello, World :" + longestConsecutive(A));
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> DicElements = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!DicElements.containsValue(nums[i]))
                DicElements.put(i, nums[i]);
            if (DicElements.containsValue(nums[i] + 1) || DicElements.containsValue(nums[i] - 1))
                cnt += 2;
        }
        return cnt;

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head.next;
        ListNode prev = head;
        int compared = head.val;
        while (cur != null) {
            if (compared == cur.val) {
                prev.next = cur.next;
            }
            else {
                compared = cur.val;
                prev = prev.next;
            }
            cur = cur.next;

        }

        return head;

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dumy = new ListNode(-1, head);
        ListNode prev = dumy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            // save ptrs
            ListNode aux = cur.next.next;
            ListNode second = cur.next;
            // Start swap
            second.next = cur;
            cur.next = aux;
            prev.next = second;
            // update ptrs
            prev = cur;
            cur = aux;
        }
        return dumy.next;
    }

    public static ListNode oddEvenList(ListNode head) {
        int counter = 1;
        ListNode cur = head;
        ListNode Odd = new ListNode(-1);
        ListNode NoOdd = new ListNode(-1);
        ListNode parcOdd = Odd;
        ListNode parcNoOdd = NoOdd;
        while (cur != null) {
            if (counter % 2 == 1) {
                parcOdd.next = cur;
                parcOdd = parcOdd.next;
            }
            else {
                parcNoOdd.next = cur;
                parcNoOdd = parcNoOdd.next;
            }
            cur = cur.next;
            counter++;
        }
        parcOdd.next = NoOdd.next;
        parcNoOdd.next = null; // Break the cycle
        return Odd.next;

    }

    public static ListNode rotateRight(ListNode head, int NbrNodes) {
        if (head == null || head.next == null || NbrNodes == 0) {
            return head;
        }
        ListNode hold = head;
        ListNode cur = head;
        int countNodes = 1;
        while (cur.next != null) {
            countNodes++;
            cur = cur.next;
        }
        int breaking = NbrNodes % countNodes;
        if (breaking == 0)
            return head;
        for (int i = 0; i < breaking; i++) {
            hold = hold.next;
        }
        ListNode res = hold.next;
        hold.next = null;
        cur.next = head;
        return res;
    }

    public static int findClosestNumber(int[] nums) {
        int close0 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(close0) >= Math.abs(nums[i])) {
                close0 = nums[i];
            }
            else if (close0 == Math.abs(nums[i])) {
                close0 = close0 > nums[i] ? close0 : nums[i];
            }
        }
        return close0;
    }

    public static int maxRepOpt1(String text) {
        StringBuilder build = new StringBuilder();
        char reptitve = text.charAt(0);
        int nbrswapp = 0;
        for (int i = 0; i < text.length(); i++) {
            if (nbrswapp == 3)
                break;
            char cr = text.charAt(i);
            if (cr == reptitve) {
                build.append(reptitve);
            }
            else {
                nbrswapp++;
            }

        }
        return build.length();
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int L = 0;
        int R = s.length() - 1;
        while (!(L > R)) {
            int asciiCodeL = (int) s.charAt(L);
            int asciiCodeR = (int) s.toLowerCase().charAt(R);
            if (!(asciiCodeL >= 48 && asciiCodeL <= 57) && !(asciiCodeL >= 97
                    && asciiCodeL <= 122)) {
                L++;
                continue;
            }
            if (!(asciiCodeR >= 48 && asciiCodeR <= 57) && !(asciiCodeR >= 97
                    && asciiCodeR <= 122)) {
                R--;
                continue;
            }
            if (s.toLowerCase().charAt(L) == s.toLowerCase().charAt(R)) {
                R--;
                L++;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int L = 0;
        int R = numbers.length - 1;
        if (R < 1)
            return new int[] { };
        while (!(L > R)) {
            if (numbers[L] + numbers[R] == target)
                return new int[] { L + 1, R + 1 };
            if (numbers[L] + numbers[R] > target)
                R--;
            else
                L++;

        }
        return new int[] { };

    }

    public static int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int max = 0;
        while (!(L > R)) {
            if (height[L] > height[R]) {
                max = Math.max(height[R] * (R - L), max);
                R--;
            }
            else {
                max = Math.max(height[L] * (R - L), max);
                L++;
            }


        }
        return max;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode L = dumy.next;
        ListNode R = dumy.next;
        for (int i = 0; i < right; i++) {
            R = R.next;
        }
        for (int j = 1; j < left - 1; j++) {
            L = L.next;
        }
        ListNode curr = L.next;
        ListNode prev = R;
        for (int k = 0; k < right - left + 1; k++) {
            ListNode Hold = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Hold;
        }
        // prev.next = R;
        L.next = prev;
        return dumy.next;
    }

    public static boolean isPalindrome(ListNode head) {
        int[] Numbr = new int[10];
        ListNode curr = head;
        while (curr != null) {
            Numbr[curr.val] = Numbr[curr.val] + 1;
            curr = curr.next;
        }
        int oddCount = 0;
        for (int i : Numbr) {
            if (i % 2 != 0)
                oddCount++;
            if (oddCount > 1)
                return false;
        }

        return true;

    }

    public static ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        ListNode Heads = head;
        ListNode SwapEndNode = null;
        int nbNode = 1;
        while (cur != null && cur.next != null) {
            if (cur.next.next == null) {
                SwapEndNode = cur.next;
                cur.next = null;
            }
            nbNode++;
            cur = cur.next;
        }

        SwapEndNode.next = head;
        return SwapEndNode;
    }

    public static int trap(int[] height) {
        int[] shiftLeft = new int[height.length];
        int[] shiftRight = new int[height.length];
        int maxR = height[0];
        int maxL = height[height.length - 1];
        int trappedWater = 0;
        for (int i = 1, j = height.length - 2; i < height.length && j >= 0; i++, j--) {
            maxR = Math.max(maxR, height[i]);
            maxL = Math.max(maxL, height[j]);
            shiftRight[i] = maxR;
            shiftLeft[j] = maxL;
        }
        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(shiftLeft[i], shiftRight[i]);
            trappedWater += minHeight - height[i];
        }
        return trappedWater;

    }

    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int[] scores = new int[operations.length];

        for (String op : operations) {
            if (isInteger(op)) {
                stack.push(Integer.valueOf(op));
            }
            else if (op == "C") {
                stack.pop();
            }
            else if (op == "D") {
                stack.push(stack.peek() * 2);
            }
            else if (op == "+") {
                int hide = stack.pop();
                int sum = hide + stack.peek();
                stack.push(hide);
                stack.push(sum);
            }
        }
        int totalScore = 0;
        for (int score : stack) {
            totalScore += score;
        }
        return totalScore;

    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);  // Try to parse the string
            return true;  // It's a valid integer
        }
        catch (NumberFormatException e) {
            return false;  // Not a valid integer
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Get the character at index i
            if (c == '{' || c == '[' || c == '(')
                stack.push(c);
            if (c == '}' || c == ']' || c == ')')
                stack.pop();
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (isInteger(s))
                stack.push(Integer.valueOf(s));
            else {
                int pop = stack.pop();
                if (s.equals("+"))
                    stack.push(stack.pop() + pop);
                if (s.equals("*"))
                    stack.push(stack.pop() * pop);
                if (s.equals("/"))
                    stack.push(stack.pop() / pop);
            }
        }
        return stack.pop();
    }

    public ListNode mergeTwoLists(ListNode L1, ListNode L2) {
        // return L1 ==null ? L2 : L1;
        ListNode dumy = new ListNode(-1);
        ListNode Keepalive = dumy;
        while (L1 != null && L2 != null) {
            if (L1.val > L2.val) {
                Keepalive.next = L2;
                L2 = L2.next;
            }
            else {
                Keepalive.next = L1;
                L1 = L1.next;
            }
            Keepalive = Keepalive.next;
        }
        if (L1 != null) {
            Keepalive.next = L1;
        }
        if (L2 != null) {
            Keepalive.next = L2;
        }
        return dumy.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode slow = head;
        int cntNodes = n - 1;
        while (cur.next != null) {
            if (cntNodes <= 0) {
                slow = slow.next;
            }
            cur = cur.next;
            cntNodes--;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static int longestOnes(int[] nums, int k) {
        int L = 0;
        int R = 0;
        int counting0 = 0;
        int max = 0;
        int Nbr1 = 0;
        while (R < nums.length) {
            // Counting 1
            if (nums[R] == 1) {
                R++;
                Nbr1++;
                continue;
                // Counting 0
            }
            else if (counting0 < k) {
                counting0++;
                R++;
                Nbr1++;
            }
            max = Math.max(max, Nbr1);
            // Counting Adjust size
            while (counting0 > k) {
                if (nums[L] == 0) {
                    counting0--;
                    L++;
                    Nbr1--;
                }
                else {
                    L++;
                    Nbr1--;
                }
            }

        }


        return max;

    }


    /*==================  TREE ====================*/
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    public static int sumTree(TreeNode node) {
        if (node == null) {
            return 0; // Base case: if the node is null, return 0
        }
        // Create a sample tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        // Recursive calls for left and right subtrees
        int leftSum = sumTree(node.left);
        int rightSum = sumTree(node.right);

        // Calculate the total sum for the current node
        int total = node.value + leftSum + rightSum;

        // Print debug information
        System.out.println(
                "Node(" + node.value + ") -> Left Sum: " + leftSum + ", Right Sum: " + rightSum
                        + ", Total: " + total);

        return total;
    }

    public static void DFS(TreeNode node) {
        if (node == null) {
            return; // Base case: if the node is null, return 0
        }
        // Create a sample tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        // Recursive calls for left and right subtrees
        int leftSum = sumTree(node.left);
        int rightSum = sumTree(node.right);
        // Print debug information
        System.out.println(
                "Node(" + node.value + ")");
    }

    public static void BFS(TreeNode node) {
        Queue<TreeNode> queue = new Queue<>();
        if (node == null) {
            return; // Base case: if the node is null, return 0
        }
        // Create a sample tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        // Recursive calls for left and right subtrees
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            TreeNode peakNode = queue.dequeue();
            System.out.println(
                    "Node( " + peakNode.value + " ,");
            if (peakNode.left != null)
                queue.enqueue(peakNode.left);
            if (peakNode.right != null)
                queue.enqueue(peakNode.right);
        }
        System.out.print(" )");
        ;
    }

    public Character nonRepeatedCharacter(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        Map<Character, Integer> DicCharacter = new HashMap<>();

        // Count the frequency of each character
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            DicCharacter.put(currentChar, DicCharacter.getOrDefault(currentChar, 0) + 1);
        }

        // Find the first character with a count of 1
        for (int i = 0; i < str.length(); i++) {
            if (DicCharacter.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }

        return null; // Return null if no unique character is found

    }
    
}
