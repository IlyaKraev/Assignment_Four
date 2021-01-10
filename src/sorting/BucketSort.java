package sorting;

import java.util.ArrayList;
import java.util.List;
import models.enums.Color;
import models.enums.Size;
import models.random.RandomTShirt;
import print.Print;

public class BucketSort extends Util {

    public List<RandomTShirt> bucketSortTShirts(List<RandomTShirt> randomTShirts, int sortByAttribute, int sortingType) {
        // Step 1 - Create buckets, Size.length
        int noOfBuckets = Size.values().length;

        // Step 1, create noOfBuckets buckets  
        List<RandomTShirt>[] buckets = new ArrayList[noOfBuckets];
        for (int i = 0; i < noOfBuckets; i++) { // noOfBuckets
            buckets[i] = new ArrayList<RandomTShirt>(); // initialize the buckets
        }

        // Step 2, divide into buckets
        for (RandomTShirt tShirt : randomTShirts) {
//              System.out.println(tShirt.getSize().ordinal()); // 3
            switch (sortByAttribute) {
                case 0:
                    buckets[tShirt.getSize().ordinal()].add(tShirt);
                    break;
                case 1:
                    buckets[tShirt.getColor().ordinal()].add(tShirt);
                    break;
                case 2:
                    buckets[tShirt.getFabric().ordinal()].add(tShirt);
                    break;
            }
        }

        // Step 3, print
        // just print the contents of each bucket
        List<RandomTShirt> bucketSorted = new ArrayList<>();
        if (sortingType == 0) {
            for (List<RandomTShirt> bucket : buckets) {
                bucketSorted.addAll(bucket);
            }

        } else {
            invert(buckets);
            for (List<RandomTShirt> bucket : buckets) {
                bucketSorted.addAll(bucket);
            }

        }
        return (bucketSorted);

    }

    public List<RandomTShirt> bucketSortTShirtsBySizeThenColorThenFabric(List<RandomTShirt> randomTShirts, int sortingType) {
        List<RandomTShirt> tShirts = new ArrayList<>();

        // Step 1 - Create noOfBuckets buckets, Size.length
        int noOfBuckets = Size.values().length;
        QuickSort qs = new QuickSort();

        List<RandomTShirt>[] buckets = new ArrayList[noOfBuckets];

        for (int i = 0; i < noOfBuckets; i++) { // noOfBuckets
            buckets[i] = new ArrayList<RandomTShirt>(); // initialize the buckets
        }

        switch (sortingType) {
            // ASC
            case 0:

                // Step 2, divide into buckets, Sort By Size
                for (RandomTShirt tShirt : randomTShirts) {
                    buckets[tShirt.getSize().ordinal()].add(tShirt);
                }

                // Step 3, Sort By Color
                for (List<RandomTShirt> bucket : buckets) {
                    bucket = bucketSortTShirts(bucket, 1, 0);
                    for (RandomTShirt randomTShirt : bucket) {
                        tShirts.add(randomTShirt);
                    }
                }
                break;

            // Step 4, Sort By Fabric
//                for (List<RandomTShirt> bucket : buckets) {
//                    List<RandomTShirt> bucketByFabric = new ArrayList<>(bucket);
//                    bucketSortTShirts(bucketByFabric, 2, 0);
//                    bucket = bucketByFabric;
//                }
//                 combine all the buckets to 1 List
            // DESC
            case 1:
                // Step 2, divide into buckets, Sort By Size
                for (RandomTShirt tShirt : randomTShirts) {
                    buckets[tShirt.getSize().ordinal()].add(tShirt);

                }
                qs.invert(buckets);

                // Step 3, Sort By Color
                for (List<RandomTShirt> bucket : buckets) {
                    bucket = bucketSortTShirts(bucket, 1, 1);
                    for (RandomTShirt randomTShirt : bucket) {
                        tShirts.add(randomTShirt);
                    }
                }

                // Step 4, Sort By Fabric
//                for (List<RandomTShirt> bucket : buckets) {
//                    List<RandomTShirt> bucketByFabric = new ArrayList<>(bucket);
//                    bucketSortTShirts(bucketByFabric, 2, 1);
//                    bucket = bucketByFabric;
//                }
                // combine all the buckets to 1 List
                break;

        }
        return (tShirts);
    }
}
