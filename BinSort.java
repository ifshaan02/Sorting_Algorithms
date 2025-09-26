package Sorting;

import java.util.*;

public class BinSort {

    static int findMax(int a[]){
        int max = a[0];
        for (int i=1;i<a.length;i++){
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }

    static void BSort(int a[], int n) {
        int max = findMax(a);

        // Create bins
        List<Integer>[] bin = new ArrayList[max + 1];
        for (int i = 0; i <= max; i++) {
            bin[i] = new ArrayList<>();
        }

        // Insert elements into bins
        for (int i = 0; i < n; i++) {
            bin[a[i]].add(a[i]);
        }

        // Collect elements back into array
        int j = 0;
        for (int i = 0; i <= max; i++) {
            while (!bin[i].isEmpty()) {
                a[j++] = bin[i].remove(0);
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {3, 4, 6, 10, 3, 6, 15};
        BSort(a, a.length);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
