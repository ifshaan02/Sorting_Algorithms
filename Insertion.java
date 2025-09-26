package Sorting;

public class Insertion {

    static void insertSort(int arr[],int n){
        for (int i = 0; i<n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
    static void Rinsertion_sort(int[] arr, int i, int n) {
        // Base Case: i == n.
        if (i == n) return;

        int j = i;
        while (j > 0 && arr[j - 1] > arr[j]) {
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }

        Rinsertion_sort(arr, i + 1, n);

    }
    public static void main(String[] args) {

        int a[] = {3,2,6,4,9,1};
        int n = a.length;
        insertSort(a,n);
        for (int x:a){
            System.out.println(x);
        }
    }
}



//    public static void main(String args[]) {
//        int arr[] = {13, 46, 24, 52, 20, 9};
//        int n = arr.length;
//        System.out.println("Before Using insertion Sort: ");
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        insertion_sort(arr, n);
//    }