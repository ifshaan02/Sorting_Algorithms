package Sorting;

import java.util.Arrays;

public class RadixSort {

    public static void sort(int[] numbers) {
        int max = findMaximumNumberIn(numbers);
        int numberOfDigits = calculateNumberOfDigitsIn(max);

        int placeValue = 1;
        while (numberOfDigits-- > 0) {
            applyCountingSortOn(numbers, placeValue);
            placeValue *= 10;
        }
    }

    private static int findMaximumNumberIn(int[] numbers) {
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static int calculateNumberOfDigitsIn(int number) {
        return (int) Math.log10(number) + 1;
    }

    private static void applyCountingSortOn(int[] numbers, int placeValue) {
        int length = numbers.length;
        int range = 10; // decimal digits (0–9)

        int[] frequency = new int[range];
        int[] sortedValues = new int[length];

        // frequency count of digits
        for (int num : numbers) {
            int digit = (num / placeValue) % range;
            frequency[digit]++;
        }

        // prefix sum to determine positions
        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        // stable sort (traverse from right to left)
        for (int i = length - 1; i >= 0; i--) {
            int digit = (numbers[i] / placeValue) % range;
            sortedValues[frequency[digit] - 1] = numbers[i];
            frequency[digit]--;
        }

        // copy back
        System.arraycopy(sortedValues, 0, numbers, 0, length);
    }

    public static void main(String[] args) {
        int[] numbers = { 170, 45, 75, 90, 802, 24, 2, 66 };
        System.out.println("Unsorted: " + Arrays.toString(numbers));

        sort(numbers);

        System.out.println("Sorted:   " + Arrays.toString(numbers));
    }
}
