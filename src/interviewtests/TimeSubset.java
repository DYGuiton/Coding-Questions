package interviewtests;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Yurichi
 */
public class TimeSubset {

    public TimeSubset() {
        System.out.println(Solution("11:01"));

    }

    private String Solution(String s) {
        String nuS = s.replace(":", "");
        char[] timeArray = nuS.toCharArray();
        Integer[] timeInts = new Integer[nuS.length()];
        Integer[] sortedInts = new Integer[nuS.length()];
        for (int i = 0; i < timeArray.length; i++) {
            timeInts[i] = Integer.parseInt("" + timeArray[i]);
            sortedInts[i] = Integer.parseInt("" + timeArray[i]);
        }

        Arrays.sort(sortedInts, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i <timeInts.length ; i++) {
//            sb.append(sortedInts[i]);
//        }

        for (int i = timeInts.length - 1; i > 0; i--) {
            Integer nuInt = 0;
            boolean changed = false;
            for (int j = 0; j < sortedInts.length; j++) {
                if (sortedInts[j] < timeInts[i]) {
                    if (sortedInts[j] >= nuInt) {
                        nuInt = sortedInts[j];
                        changed = !changed;
                    }
                }
            }
            if (nuInt < timeInts[i] && changed == true) {
                timeInts[i] = nuInt;
                break;
            }

        }

        sb.append(timeInts[0]);
        sb.append(timeInts[1]);
        sb.append(":");
        sb.append(timeInts[2]);
        sb.append(timeInts[3]);

        return sb.toString();

    }

}
