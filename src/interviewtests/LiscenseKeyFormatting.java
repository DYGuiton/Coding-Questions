package interviewtests;

/**
 * Question:
 *
 * We are given a string S consisting of N characters and an integer K. The
 * string represents a software license key which we would like to format. The
 * string is composed of alphanumerical characters and/or dashes. The dashes
 * split the alphanumerical characters within the string into groups (i.e. if
 * there are M dashes, the string is split into M+1 groups). The dashes in the
 * given string are possibly misplaced.
 *
 * We want each group of characters to be of length K (except for possibly the
 * first group, which could be shorter, but still must contain at least one
 * character). To satisfy this requirement, we will reinsert the dashes.
 * Additionally, all the lower case letters in the string must be converted to
 * upper case.
 *
 * For example, in the license key "2-4A0r7-4k" there are two dashes which split
 * it into three groups of lengths 1, 5 and 2, respectively. If we want each
 * group to be of length 4, then we would have to reinsert the dashes. Thus, for
 * K = 4, the correctly formatted string is "24A0-R74K".
 *
 * Write a function:
 *
 * class Solution { public String solution(String S, int K); }
 *
 * that, given a non-empty string S consisting of N characters, representing a
 * license key to format, and an integer K, returns the license key formatted
 * according to the description above.
 *
 * For example, given S = "2-4A0r7-4k" and K = 4, the function should return
 * "24A0-R74K", and for K = 3, the function should return "24-A0R-74K" as the
 * first group could be shorter. Given S = "r" and K = 1, the function should
 * return "R".
 *
 * Assume that:
 *
 * N and K are integers within the range [1..300,000]; string S consists only of
 * alphanumerical characters (a−z and/or A−Z and/or 0−9) and/or dashes (-);
 * string S contains at least one alphanumerical character. Complexity:
 *
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N) (not counting the storage required for input arguments).
 *
 *
 *
 *
 * Solution Steps:
 *
 * 1. Send the String to method "solution" for processing
 *
 * 2. Perform pre-processing a) replace all instances of "-" with "" //The
 * initial dashes are essentially useless as we are reformatting the entire
 * string b) Switch all letters to UpperCase //Good to keep a standard format
 * with all uppercases(Google asks for this I think)
 *
 * 3. Create a StringBuilder object where new string will be effeciently stored
 * //Strings are immutable which make editing them inefficient. //StringBuilder
 * objects are mutable and can be change very easily(See StringBuilder
 * Documentation)
 *
 * 4. Append each char from inital Liscence Key, placing dashes after every 4
 * characters a) Create for loop spanning the length of the initial Liscence
 * Key-1 //be sure to start i at 1 b) Create Kmod int to keep track of whether
 * or not we are on the next 4th char //we start at 1 so that aren't starting
 * with 0 mod 4 c) Append char at i from String d) If kmod = 0(we are on the
 * next 4th char) append in a "-" as per the guidelines
 *
 * 5) Return sb.toString()
 */
public class LiscenseKeyFormatting {

    public LiscenseKeyFormatting() {
        String s1 = "2-4A0-r7-4k";

        System.out.println(solution2("2-4A0-r7-4k", 4));
        System.out.println(solution2("24-A0-r7-4k", 3));//solution 1 doesn't work here.
        System.out.println(solution2("assdfajnc;akjnc;alsreimdsm,;f4350", 4));
    }

    private String solution(String S, int K) {
        //2 of 3 requirements method
        S = S.replace("-", "");
        S = S.toUpperCase();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= S.length() - 1; i++) {
            int kmod = (i + 1) % K;
            sb.append(S.charAt(i));
            if (kmod == 0) {
                if (i != S.length() - 1) {
                    sb.append("-");
                }
            }
        }
        return sb.toString();
    }

    private String solution2(String S, int K) {
        //all requirements method
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (sb.length() % (K + 1) == K) {
                    sb.append('-');
                } else {
                    sb.append("");
                }
                sb.append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }

}
