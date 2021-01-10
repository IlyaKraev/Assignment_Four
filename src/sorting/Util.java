package sorting;

import java.util.List;
import models.random.RandomTShirt;


public class Util {

        List<RandomTShirt>[] invert(List<RandomTShirt>[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            List<RandomTShirt> temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return (arr);
    }
}
