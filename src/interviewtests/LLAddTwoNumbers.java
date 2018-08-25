package interviewtests;

import java.util.Random;
import java.util.Stack;

/**
 * @author Yurichi
 */
public class LLAddTwoNumbers {

    public LLAddTwoNumbers() {
        StringBuilder sb = new StringBuilder();
        ListNode L1 = createRandListNode();
        ListNode L2 = createRandListNode();

        ListNode curr = L1;
        while (curr != null) {
            sb.append(curr.val + ", ");
            curr = curr.next;
        }
        System.out.println(sb.toString());
        sb.delete(0, sb.length());

        curr = L2;
        while (curr != null) {
            sb.append(curr.val + ", ");
            curr = curr.next;
        }

        System.out.println(sb.toString());
        sb.delete(0, sb.length());

        ListNode sol = solution(L1, L2);

        while (sol != null) {
            sb.append(sol.val);
            sol = sol.next;
        }
        
        System.out.println(sb.toString());
    }

    private ListNode createRandListNode() {
        Random dice = new Random();
        ListNode returnMe = new ListNode(dice.nextInt(8)+1);
        returnMe.next = new ListNode(dice.nextInt(8)+1);
        returnMe.next.next = new ListNode(dice.nextInt(8)+1);

        return returnMe;
    }

    private ListNode solution(ListNode L1, ListNode L2) {
        Stack<Integer> s = new Stack<>();
        pushList(L1, s);
        pushList(L2, s);
        return stackToList(s);
    }

    private void pushList(ListNode L1, Stack<Integer> s) {
        ListNode curr = L1;
        int tens = 1;
        while (curr != null) {
            s.push(curr.val * tens);
            tens = tens * 10;
            curr = curr.next;
        }
    }

    private ListNode stackToList(Stack<Integer> s) {
        if (s.isEmpty()) {
            return null;
        }

        Integer value = new Integer(0);
        while (!s.isEmpty()) {
            value = value + s.pop();
        }

        String z = value.toString();
        char[] array = z.toCharArray();
        for (char c : array) {
            System.out.println(c);
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = array.length-1; i > -1; i--) {
            curr.val = Integer.parseInt("" + array[i]);
            if (i < array.length-1) {
                curr.next = new ListNode(0);
                curr = curr.next;
            }

        }

        return head;
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
