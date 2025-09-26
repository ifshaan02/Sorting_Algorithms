package Sorting;

public class SelectionSort {
    static void Select(int a[],int n){
        for (int i=0;i<n-1;i++){
            int min = i;
            for (int j = i+1;j<n;j++){
                if (a[j]<a[min]){
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;

        }
        for (int i=0;i<n;i++){
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args) {

        int a[] = {4,2,7,5,1,3};
        int n = a.length;
        Select(a,n);
    }
}
