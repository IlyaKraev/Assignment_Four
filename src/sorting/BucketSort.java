package sorting;

import java.util.ArrayList;
import java.util.List;
import models.enums.Size;
import models.random.RandomTShirt;

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
        if (sortingType == 0) {
            List<RandomTShirt> bucketSorted = new ArrayList<>();
            for (List<RandomTShirt> bucket : buckets) {
                bucketSorted.addAll(bucket);
            }

            return (bucketSorted);
        } else {
            invert(buckets);
            List<RandomTShirt> bucketSorted = new ArrayList<>();
            for (List<RandomTShirt> bucket : buckets) {
                bucketSorted.addAll(bucket);
            }

            return (bucketSorted);

        }

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
                    qs.quickSortTShirts(bucket, 0, bucket.size() - 1, 1, 0);
                }

                // Step 4, Sort By Fabric
                for (List<RandomTShirt> bucket : buckets) {
                    List<RandomTShirt> bucketByFabric = new ArrayList<>(bucket);
                    bucketSortTShirts(bucketByFabric, 1, 0);
                    qs.quickSortTShirts(bucketByFabric, 0, bucketByFabric.size() - 1, 2, 0);

                    bucket = bucketByFabric;
                }

                // combine all the buckets to 1 List
                for (List<RandomTShirt> bucket : buckets) {
                    for (RandomTShirt tShirt : bucket) {
                        tShirts.add(tShirt);
                    }
                }
                break;
            // DESC
            case 1:
                // Step 2, divide into buckets, Sort By Size
                for (RandomTShirt tShirt : randomTShirts) {
                    buckets[tShirt.getSize().ordinal()].add(tShirt);
                }
                qs.invert(buckets);

                // Step 3, Sort By Color
                for (List<RandomTShirt> bucket : buckets) {
                    
                    qs.quickSortTShirts(bucket, 0, bucket.size() - 1, 1, 1);
                }

                // Step 4, Sort By Fabric
                for (List<RandomTShirt> bucket : buckets) {
                    List<RandomTShirt> bucketByFabric = new ArrayList<>(bucket);
                    bucketSortTShirts(bucketByFabric, 2, 1);
                }

                // combine all the buckets to 1 List
                for (List<RandomTShirt> bucket : buckets) {
                    for (RandomTShirt tShirt : bucket) {
                        tShirts.add(tShirt);
                    }
                }

                break;
        }
        return (tShirts);
    }
}
