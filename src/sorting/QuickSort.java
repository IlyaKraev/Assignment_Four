package sorting;

import java.util.ArrayList;
import java.util.List;
import models.random.RandomTShirt;

public class QuickSort extends Util {

    /* This function takes last element as pivot, places the pivot element at its correct position in sorted array, and places all 
       smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot */
    int partition(List<RandomTShirt> arr, int low, int high, int sortByAttribute, int sortingType) {
        RandomTShirt pivot = arr.get(high);
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) {
            if (sortingType == 0) { // ASC
                switch (sortByAttribute) {
                    // Size
                    case 0:
                        // If current element is smaller than the pivot 
                        if (arr.get(j).getSize().ordinal() < pivot.getSize().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            RandomTShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                        break;
                    // Color
                    case 1:
                        if (arr.get(j).getColor().ordinal() < pivot.getColor().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            RandomTShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                        break;
                    // Fabric
                    case 2:
                        if (arr.get(j).getFabric().ordinal() < pivot.getFabric().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            RandomTShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                        break;
                }
            } else { // DESC
                switch (sortByAttribute) {
                    // Size
                    case 0:
                        // If current element is smaller than the pivot 
                        if (arr.get(j).getSize().ordinal() > pivot.getSize().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            RandomTShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                        break;
                    // Color
                    case 1:
                        if (arr.get(j).getColor().ordinal() > pivot.getColor().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            RandomTShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                        break;
                    // Fabric
                    case 2:
                        if (arr.get(j).getFabric().ordinal() > pivot.getFabric().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            RandomTShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                        break;
                }
            }

        }

        // swap arr[i+1] and arr[high] (or pivot) 
        RandomTShirt temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    public List<RandomTShirt> quickSortTShirts(List<RandomTShirt> arr, int low, int high, int sortByAttribute, int sortingType) {

        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = 0;
            switch (sortingType) {
                // ASC
                case 0:

                    pi = partition(arr, low, high, sortByAttribute, 0); // part <--- Size, Color, Fabric

                    // Recursively sort elements before 
                    // partition and after partition 
                    quickSortTShirts(arr, low, pi - 1, sortByAttribute, 0);
                    quickSortTShirts(arr, pi + 1, high, sortByAttribute, 0);
                    break;
                // DESC
                case 1:
                    pi = partition(arr, low, high, sortByAttribute, 1); // part <--- Size, Color, Fabric

                    // Recursively sort elements before 
                    // partition and after partition 
                    quickSortTShirts(arr, low, pi - 1, sortByAttribute, 1);
                    quickSortTShirts(arr, pi + 1, high, sortByAttribute, 1);
                    break;
            }
        }

        return (arr);
    }

    public List<RandomTShirt> quickSortBySizeColorFabric(List<RandomTShirt> arr, int low, int high, int sortingType) {
        List<RandomTShirt> tShirts = new ArrayList<>();
        if (low < high) {
            switch (sortingType) {
                // ASC
                case 0:

                    List<RandomTShirt> arr2 = new ArrayList<>(quickSortTShirts(arr, low, high, 0, 0));
                    
                    for (RandomTShirt randomTShirt : quickSortTShirts(arr2, 0, 6, 0, 0)) {
                        tShirts.add(randomTShirt);
                    }

                    break;
                // DESC
                case 1:

                    List<RandomTShirt> arr3 = new ArrayList<>(quickSortTShirts(arr, low, high, 0, 1));
                    
                    for (RandomTShirt randomTShirt : quickSortTShirts(arr3, low, high, 0, 1)) {
                        
                        tShirts.add(randomTShirt);
                    }
                    break;
            }

        }
        return (tShirts);
    }
}
