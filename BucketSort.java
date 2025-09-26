package Sorting;

import java.util.*;

public class BucketSort {

    // Hash function to map an integer into a bucket index
    private int hash(int value, int max, int bucketCount) {
        return value * (bucketCount - 1) / max;
    }


    // Find the maximum value in the input list
    private int findMax(List<Integer> input) {
        int max = Integer.MIN_VALUE;
        for (int num : input) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Main bucket sort method
    public List<Integer> sort(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        int maxValue = findMax(input);
        int bucketCount = (int) Math.sqrt(input.size());
        bucketCount = Math.max(bucketCount, 1); // ensure at least one bucket

        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : input) {
            int bucketIndex = hash(num, maxValue, bucketCount);
            buckets.get(bucketIndex).add(num);
        }

        Comparator<Integer> comparator = Comparator.naturalOrder();
        for (List<Integer> bucket : buckets) {
            bucket.sort(comparator);
        }

        List<Integer> sorted = new LinkedList<>();
        for (List<Integer> bucket : buckets) {
            sorted.addAll(bucket);
        }

        return sorted;
    }

    // Example usage
    public static void main(String[] args) {
        BucketSort sorter = new BucketSort();
        List<Integer> unsorted = Arrays.asList(80, 50, 60, 30, 20, 10, 70, 0, 40, 500, 600, 602, 200, 15);
        System.out.println("Unsorted: " + unsorted);

        List<Integer> sorted = sorter.sort(unsorted);
        System.out.println("Sorted: " + sorted);
    }
}
