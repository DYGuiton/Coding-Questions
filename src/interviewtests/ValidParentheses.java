package interviewtests;

/**
 * @author Yurichi
 */
//leet code #20
//Question :Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Note that an empty string is also considered valid.


/**
 * Solution:
 * The problem should not be approached solely under the pretense that a stack will save everything.
 * The stack will be used to help us make comparisons.
 * 
 * 1. Initialize a new Stack of characters
 * 2. create a for loop that will run over each character in the string
 * 3. check for the left side representation of the paren type
 * 4. after checking, input the opposite side representation of the paren type
 *      into the stack.
 * 5. If we are given a char that is not a left side paren
 *      check if the stack is empty - This ensures that the stack wasn't empty to start
 *      pop the char off the stack and compare to the current char-
 *          B/C we know we don't have a left side paren, it must be a right side paren
 *          and b/c we've been putting only corresponding right side parens
 *          the popped item is either the char c or a different paren
 *          This ensures that we're looking at the correct paren
 * 6. Return whether or not the stack is empty
 *      This ensures that we're not returning true if there was any sort of mistake at the end.
 *      Not entirely sure this is necessary over just returning true if reaching that line of code.
 */

import java.util.Stack;



public class ValidParentheses {

    public ValidParentheses() {
        System.out.println("()() " + isValid("()()"));
        System.out.println("[()()] " + isValid("[()()]"));
        System.out.println("([)(]) " + isValid("([)(])"));
        System.out.println("({)(){ " + isValid("({)(){"));
    }

    private boolean isValid(String s) {
        Stack<Character> theStack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                theStack.push(')');
            } else if (c == '{') {
                theStack.push('}');
            } else if (c == '[') {
                theStack.push(']');
            } else if (theStack.isEmpty() || theStack.pop() != c) {
                return false;
            }
        }
        return true;
//        return theStack.isEmpty();
    }

}
