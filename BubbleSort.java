package Sorting;

public class BubbleSort {


    static void swap(int a[],int x,int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    static void Bubble(int a[],int n){
        int flag = 0;
        for (int i=0; i<n-1; i++){
            for (int j=0; j<n-i-1;j++){
                if (a[j] > a[j+1]){
                    swap(a,j,j+1);
                    flag = 1;
                }
            }
            if (flag==0)
                break;
        }
    }
    static void RecursiveBubble_sort(int[] arr, int n) {
        //Base case: range == 1.
        if (n == 1) return;

        int didSwap = 0;
        for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                didSwap = 1;
            }
        }

        // if no swapping happens.
        if (didSwap == 0) return;

        //Range reduced after recursion:
        RecursiveBubble_sort(arr, n - 1);

    }
    public static void main(String[] args) {
        int a[] = {3,7,9,10,6,5,12,4,11,2};
        RecursiveBubble_sort(a,a.length);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }
}


//    static void bubble_sort(int[] arr, int n) {
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = 0; j <= i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//
//        System.out.println("After bubble sort: ");
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }
//    public static void main(String args[]) {
//        int arr[] = {13, 46, 24, 52, 20, 9};
//        int n = arr.length;
//        System.out.println("Before Using Bubble Sort: ");
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        bubble_sort(arr, n);
//    }
