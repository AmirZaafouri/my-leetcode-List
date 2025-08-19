/* *****************************************************************************
 *  Name:              Amir Zaafouri
 *  Last modified:     Aout 19, 2025
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class JavaCheatSheet {

    /*====================================================================
     *  Section: Basic Variable
     *====================================================================*/
    int[] listnum = new int[] { 1, 2, 3, 5 };
    String[] liststringNum = new String[] { "1", "2", "3", "5" };

    String txt = "HELLO_WORLD";
    char c = txt.charAt(0); // retrieve first char

    int firstnumber = Integer.parseInt(liststringNum[0]); // "1" -> 1
    String firstnumberStr = String.valueOf(firstnumber);  // 1 -> "1"
    char firstnumberChr = firstnumberStr.charAt(0);       // "1" -> '1'

    public static void main(String[] args) {

        /*====================================================================
         *  Section: List (ArrayList)
         *====================================================================*/
        List<Integer> listNums = new ArrayList<>();
        listNums.add(1);               // add element
        listNums.add(1, 99); // insert at index
        int x = listNums.get(0);       // get element
        listNums.set(1, 50);           // update element
        listNums.remove(0);      // remove by index
        listNums.remove(Integer.valueOf(50)); // remove by value
        boolean has99 = listNums.contains(99);
        int size = listNums.size();
        listNums.clear();
        listNums.addAll(Arrays.asList(5, 2, 9, 1));
        Collections.sort(listNums);    // ascending sort
        Collections.sort(listNums, Collections.reverseOrder()); // descending

        /*====================================================================
         *  Section: Set (HashSet)
         *====================================================================*/
        Set<Integer> setNums = new HashSet<>();
        setNums.add(1);
        boolean exists = setNums.contains(2);
        setNums.remove(1);
        setNums.size();
        setNums.isEmpty();

        /*====================================================================
         *  Section: Stack (LIFO)
         *====================================================================*/
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        int top = stack.peek(); // see top
        int popped = stack.pop(); // remove top
        boolean empty = stack.isEmpty();

        /*====================================================================
         *  Section: Queue (FIFO) - LinkedList
         *====================================================================*/
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);   // Enqueue
        queue.offer(2);
        int head = queue.peek();   // see front
        int removed = queue.poll(); // Dequeue

        /*====================================================================
         *  Section: Map (HashMap)
         *====================================================================*/
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 5);
        int val = map.get("apple");
        map.getOrDefault("orange", 0); // safe get
        map.put("apple", map.getOrDefault("apple", 0) + 1);
        boolean hasKey = map.containsKey("banana");
        boolean hasValue = map.containsValue(5);
        map.remove("apple");
        map.size();
        map.isEmpty();

        // iterate
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        /*====================================================================
         *  Section: Conversion
         *====================================================================*/
        Integer[] arr = { 1, 2, 3 };
        List<Integer> arrToList = Arrays.asList(arr);  // Array -> List
        List<Integer> dynamicList = new ArrayList<>(arrToList);
        Integer[] backToArray = dynamicList.toArray(new Integer[0]);
    }
}
