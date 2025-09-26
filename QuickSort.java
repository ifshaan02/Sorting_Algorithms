package Sorting;

public class QuickSort {

    static int partition(int a[],int begin,int end){
        int pivot = a[begin];
        int i = begin;
        int j = end;

        while(i<j){
            while (i<=end-1 && a[i]<=pivot){
                i++;
            }
            while (j>=begin+1 && a[j]>pivot){
                j--;
            }
            if (i<j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[begin];
        a[begin] = a[j];
        a[j] = temp;
        return j;
    }

    static void qs(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }

    static void quickSort(int[] arr) {

        qs(arr, 0, arr.length - 1);
    }
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        int n = arr.length;

        System.out.println("Before Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        quickSort(arr);

        System.out.println("After Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
