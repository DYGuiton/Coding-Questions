package interviewtests;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yurichi
 */
public class GenerateParentheses {

    public GenerateParentheses() {
        genParentheses(3);
        genParentheses(4);
        genParentheses(5);
        
    }

    public List<String> genParentheses(int n) {
        ArrayList<String> theList = new ArrayList<>();

        generateList(theList, "", 0, 0, n);

        System.out.println("For parens n = " + n);
        for (String nextParens : theList) {
            System.out.println(nextParens);
        }
        
        return theList;
    }

    private void generateList(ArrayList theList, String curr, int l, int r, int n) {
        if (curr.length() == n*2) {
            theList.add(curr);
            return;
        }

        if (l < n) {
            generateList(theList, curr + "(", l + 1, r, n);
        }

        if (r < l) {
            generateList(theList, curr + ")", l, r + 1, n);
        }

    }

}
