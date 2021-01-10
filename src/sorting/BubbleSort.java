package sorting;

import java.util.ArrayList;
import java.util.List;
import models.random.RandomTShirt;


public class BubbleSort {


    public List<Integer> bubbleSort(List<Integer> arr) {
        List<Integer> arr2 = new ArrayList<>(arr);
        int n = arr2.size(); // 5
        for (int i = 0; i < n - 1; i++) // i = 0, 1
        {
            for (int j = 0; j < n - i - 1; j++) // j = 5-0-1 = 4, 5-1-1 = 3
            {
                if (arr2.get(j) > arr2.get(j + 1)) {
                    // swap arr[j+1] and arr[j] 
                    int temp = arr2.get(j);
                    arr2.set(j, arr2.get(j + 1));  // arr[j] <- arr[j+1]
                    arr2.set(j + 1, temp); // arr[j+1] = temp; 
                }
            }
        }
        return (arr2);
    }

    private List<RandomTShirt> bubbleSortTShirtsBySize(List<RandomTShirt> arr, int sortingType) // sortingType = 0 - ASC
    // sortingType = 1 - DESC
    {
        List<RandomTShirt> arr2 = new ArrayList<>(arr);
        int n = arr2.size();
        switch (sortingType) {
            case 0:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (arr2.get(j).getSize().ordinal() > arr2.get(j + 1).getSize().ordinal()) {
                            // swap arr[j+1] and arr[j] 
                            RandomTShirt temp = arr2.get(j);
                            arr2.set(j, arr2.get(j + 1));  // arr[j] <- arr[j+1]
                            arr2.set(j + 1, temp); // arr[j+1] = temp; 
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (arr2.get(j).getSize().ordinal() < arr2.get(j + 1).getSize().ordinal()) {
                            // swap arr[j+1] and arr[j] 
                            RandomTShirt temp = arr2.get(j);
                            arr2.set(j, arr2.get(j + 1));  // arr[j] <- arr[j+1]
                            arr2.set(j + 1, temp); // arr[j+1] = temp; 
                        }
                    }
                }
                break;
        }

        return (arr2);
    }

    private List<RandomTShirt> bubbleSortTShirtsByColor(List<RandomTShirt> arr, int sortingType) // sortingType = 0 - ASC
    // sortingType = 1 - DESC
    {
        List<RandomTShirt> arr2 = new ArrayList<>(arr);
        int n = arr2.size();
        switch (sortingType) {
            case 0:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (arr2.get(j).getColor().ordinal() > arr2.get(j + 1).getColor().ordinal()) {
                            // swap arr[j+1] and arr[j] 
                            RandomTShirt temp = arr2.get(j);
                            arr2.set(j, arr2.get(j + 1));  // arr[j] <- arr[j+1]
                            arr2.set(j + 1, temp); // arr[j+1] = temp; 
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (arr2.get(j).getColor().ordinal() < arr2.get(j + 1).getColor().ordinal()) {
                            // swap arr[j+1] and arr[j] 
                            RandomTShirt temp = arr2.get(j);
                            arr2.set(j, arr2.get(j + 1));  // arr[j] <- arr[j+1]
                            arr2.set(j + 1, temp); // arr[j+1] = temp; 
                        }
                    }
                }
                break;
        }

        return (arr2);
    }

    private List<RandomTShirt> bubbleSortTShirtsByFabric(List<RandomTShirt> arr, int sortingType) // sortingType = 0 - ASC
    // sortingType = 1 - DESC
    {
        List<RandomTShirt> arr2 = new ArrayList<>(arr);
        int n = arr2.size();
        switch (sortingType) {
            case 0:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (arr2.get(j).getFabric().ordinal() > arr2.get(j + 1).getFabric().ordinal()) {
                            // swap arr[j+1] and arr[j] 
                            RandomTShirt temp = arr2.get(j);
                            arr2.set(j, arr2.get(j + 1));  // arr[j] <- arr[j+1]
                            arr2.set(j + 1, temp); // arr[j+1] = temp; 
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (arr2.get(j).getFabric().ordinal() < arr2.get(j + 1).getFabric().ordinal()) {
                            // swap arr[j+1] and arr[j] 
                            RandomTShirt temp = arr2.get(j);
                            arr2.set(j, arr2.get(j + 1));  // arr[j] <- arr[j+1]
                            arr2.set(j + 1, temp); // arr[j+1] = temp; 
                        }
                    }
                }
                break;
        }

        return (arr2);
    }

    public List<RandomTShirt> bubbleSortTShirts(List<RandomTShirt> arr, int sortingType, int sortByAttribute) {
        List<RandomTShirt> arr2 = new ArrayList<>(arr);
        if (sortingType == 0) {
            switch (sortByAttribute) {
                // Size
                case 0:
                    arr2 = bubbleSortTShirtsBySize(arr, 0);
                    break;
                // Color    
                case 1:
                    arr2 = bubbleSortTShirtsByColor(arr, 0);
                    break;
                // Fabric
                case 2:
                    arr2 = bubbleSortTShirtsByFabric(arr, 0);
                    break;
            }
        } else {
            switch (sortByAttribute) {
                // Size
                case 0:
                    arr2 = bubbleSortTShirtsBySize(arr, 1);
                    break;
                // Color    
                case 1:
                    arr2 = bubbleSortTShirtsByColor(arr, 1);
                    break;
                // Fabric
                case 2:
                    arr2 = bubbleSortTShirtsByFabric(arr, 1);
                    break;
            }
        }
        return (arr2);
    }
    
    private List<RandomTShirt> bubbleSortSizeColorFabric(List<RandomTShirt> arr, int sortingType) {// sortingType = 0 - ASC
        List<RandomTShirt> arr2 = new ArrayList<>(arr);
        
            
        
                            arr2 = bubbleSortTShirtsBySize(arr, 0);
                // Color    
                    arr2 = bubbleSortTShirtsByColor(arr, 0);
            // Fabric
             arr2 = bubbleSortTShirtsByFabric(arr, 0);

        
        return(arr2);
    }
}
