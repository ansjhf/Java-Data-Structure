import com.DataStructure.SimpleSort.SimpleSort;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[15];
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            arr[i] = (int) Math.floor((random.nextDouble() * 1000));
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] sortArr = SimpleSort.InsertSort(arr);
        for (int i : sortArr) {
            System.out.print(i + " ");
        }
    }

}
