package tshirtsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.random.RandomTShirt;
import print.Print;
import sorting.BubbleSort;
import sorting.BucketSort;
import sorting.QuickSort;

public class PresentationOfResults {

    private Print print = new Print();

    public PresentationOfResults() {
        System.out.println("Assignment 4: Sorting Algorithms");
        navigate();
    }

    private void navigate() {
        Scanner sc = new Scanner(System.in);
        int c;

        StringBuilder sb = new StringBuilder();
        sb.append("Please select option: \n");
        sb.append("1. Quick Sort\n");
        sb.append("2. Bubble Sort\n");
        sb.append("3. Bucket Sort\n");
        sb.append("0. Exit\n");
        System.out.println(sb);

        while (!sc.hasNextInt()) {
            System.out.println("Invalid argument. Input '1-3 or 0'");
            sc.next();
        }
        c = sc.nextInt();
        while (!(c == 1) && !(c == 2) && !(c == 3) && !(c == 0)) {
            System.out.println("Invalid argument. Input '1-3 or 0'");
            c = sc.nextInt();
        }
        switch (c) {
            case 1:
                quickSort();
                break;
            case 2:
                bubbleSort();
                break;
            case 3:
                bucketSort();
                break;
            case 0:
                System.out.println("See you :)");
                System.exit(0);
                break;
        }
    }

    private List<RandomTShirt> printRandomTShirts() {
        List<RandomTShirt> randomTShirts = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            randomTShirts.add(new RandomTShirt());
        }
        return (randomTShirts);
    }

    private void quickSort() {
        QuickSort qs = new QuickSort();

        List<RandomTShirt> randomTShirts = new ArrayList<>(printRandomTShirts());
        System.out.println("----UNSORTED LIST----");
        print.printList(randomTShirts);

        System.out.println("----SORT BY SIZE ASCENDING----");
        print.printList(qs.quickSortTShirts(randomTShirts, 0, randomTShirts.size() - 1, 0, 0));

        System.out.println("----SORT BY SIZE DESCENDING----");

        print.printList(qs.quickSortTShirts(randomTShirts, 0, randomTShirts.size() - 1, 0, 1));

        System.out.println("----SORT BY COLOR ASCENDING----");
        qs.quickSortTShirts(randomTShirts, 0, randomTShirts.size() - 1, 1, 0);
        print.printList(randomTShirts);

        System.out.println("----SORT BY COLOR DESCENDING----");
        qs.quickSortTShirts(randomTShirts, 0, randomTShirts.size() - 1, 1, 1);
        print.printList(randomTShirts);

        System.out.println("----SORT BY FABRIC ASCENDING----");
        qs.quickSortTShirts(randomTShirts, 0, randomTShirts.size() - 1, 2, 0);
        print.printList(randomTShirts);

        System.out.println("----SORT BY FABRIC DESCENDING----");
        qs.quickSortTShirts(randomTShirts, 0, randomTShirts.size() - 1, 2, 1);
        print.printList(randomTShirts);

        System.out.println("----SORT BY SIZE, COLOR, FABRIC ASCENDING----");
        print.printList(qs.quickSortBySizeColorFabric(randomTShirts, 0, randomTShirts.size() - 1, 0));

        System.out.println("----SORT BY SIZE, COLOR, FABRIC DESCENDING----");
        print.printList(qs.quickSortBySizeColorFabric(randomTShirts, 0, randomTShirts.size() - 1, 1));
    }

    private void bubbleSort() {
        BubbleSort bbs = new BubbleSort();
        
        List<RandomTShirt> randomTShirts = new ArrayList<>(printRandomTShirts());

        System.out.println("----UNSORTED LIST----");
        print.printList(randomTShirts);

        System.out.println("----SORT BY SIZE ASCENDING----");
        print.printList(bbs.bubbleSortTShirts(randomTShirts, 0, 0));

        System.out.println("----SORT BY SIZE DESCENDING----");
        print.printList(bbs.bubbleSortTShirts(randomTShirts, 1, 0));

        System.out.println("----SORT BY COLOR ASCENDING----");
        print.printList(bbs.bubbleSortTShirts(randomTShirts, 0, 1));

        System.out.println("----SORT BY COLOR DESCENDING----");
        print.printList(bbs.bubbleSortTShirts(randomTShirts, 1, 1));

        System.out.println("----SORT BY FABRIC ASCENDING----");
        print.printList(bbs.bubbleSortTShirts(randomTShirts, 0, 2));

        System.out.println("----SORT BY FABRIC DESCENDING----");
        print.printList(bbs.bubbleSortTShirts(randomTShirts, 1, 2));

//        System.out.println("----SORT BY SIZE, COLOR, FABRIC ASCENDING----");
//        print.printList();
//
//        System.out.println("----SORT BY SIZE, COLOR, FABRIC DESCENDING----");
//        print.printList();
    }

    private void bucketSort() {
        BucketSort bs = new BucketSort();
        List<RandomTShirt> randomTShirts = new ArrayList<>(printRandomTShirts());

        System.out.println("----UNSORTED LIST----");
        print.printList(bs.bucketSortTShirts(randomTShirts, 0, 0));

        System.out.println("----SORT BY SIZE ASCENDING----");
        print.printList(bs.bucketSortTShirts(randomTShirts, 0, 1));

        System.out.println("----SORT BY SIZE DESCENDING----");
        print.printList(bs.bucketSortTShirts(randomTShirts, 1, 0));

        System.out.println("----SORT BY COLOR ASCENDING----");
        print.printList(bs.bucketSortTShirts(randomTShirts, 1, 1));

        System.out.println("----SORT BY COLOR DESCENDING----");
        print.printList(bs.bucketSortTShirts(randomTShirts, 1, 1));

        System.out.println("----SORT BY FABRIC ASCENDING----");
        print.printList(bs.bucketSortTShirts(randomTShirts, 2, 0));

        System.out.println("----SORT BY FABRIC DESCENDING----");
        print.printList(bs.bucketSortTShirts(randomTShirts, 2, 1));

        System.out.println("----SORT BY SIZE, COLOR, FABRIC ASCENDING----");
        print.printList(bs.bucketSortTShirtsBySizeThenColorThenFabric(randomTShirts, 0));

        System.out.println("----SORT BY SIZE, COLOR, FABRIC DESCENDING----");
        print.printList(bs.bucketSortTShirtsBySizeThenColorThenFabric(randomTShirts, 1));

    }

}
