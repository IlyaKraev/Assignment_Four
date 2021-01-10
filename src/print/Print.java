package print;

import java.util.List;
import models.random.RandomTShirt;

public class Print {

    public void printList(List<RandomTShirt> arr) {
        int n = arr.size();
        for (int i = 0; i < n; ++i) {
            System.out.print(arr.get(i) + " \n");
        }
        System.out.println();
    }

    public void printArray(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
