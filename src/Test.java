import com.DataStructure.AdvanceSort.RadixSort;

public class Test {
    public static void main(String[] args) {

        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = (int)(Math.random()*1000);
        }

        for (int i : arr) {
            System.out.print(i+" ");
        }

        System.out.println();

        new RadixSort().Sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }

    }

}

