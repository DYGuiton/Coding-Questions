package interviewtests;

/** @author Yurichi*/
public class KEmptySlots {

    public KEmptySlots() {
        int[] array = new int[]{1,3,7,6,4,2,5};
        int K = 2;//Length of each group
        int M = 2;//# of groups
        System.out.println(kEmptySlots(array, K, M));
        
    }

    private int kEmptySlots(int[] array, int K, int M) {
        int length = array.length;
        if(length == 0 || K >= length){
            return -1;
        }
    }

}
