package interviewtests;

/**
 * Question:
 * 
 * Your task is to implement the function atoi. The function
 * takes a string(str) as argument and converts it to an integer and returns it.
 *
 * Input: The first line of input contains an integer T denoting the no of test
 * cases . Then T test cases follow. Each test case contains a string str .
 *
 * Output: For each test case in a new line output will be an integer denoting
 * the converted integer, if the input string is not a numerical string then
 * output will be -1.
 *
 * Constraints: 1<=T<=100 1<=length of (s,x)<=10
 *
 * Example(To be used only for expected output) : Input: 2 123 21a
 *
 * Output: 123 -1
 *
 * 
 * 
 * Solution Steps:
 * 
 * 
 * 
 */
public class ATOI {
    
    public ATOI(){
        System.out.println(atoi("1234"));
    }

    private int atoi(String ascii) {
        
        int returnMe = 0;
        for (int i = 0; i<ascii.length(); i++) {
            returnMe = returnMe*10+ascii.charAt(i) - '0';
        }
        
        return returnMe;
        
        

    }
}
