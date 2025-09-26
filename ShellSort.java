package Sorting;

public class ShellSort {
    static void SSort(int a[],int n){
        int gap,i,j;

        for (gap=n/2;gap>0;gap/=2){
            for (i=gap;i<n;i++){
                int temp = a[i];
                j = i - gap;
                while (j>=0 && a[j] > temp){
                    a[j+gap] = a[j];
                    j=j-gap;
                }
                a[j+gap] = temp;
            }
        }
    }
    public static void main(String[] args) {

        int a[] = {2,5,10,3,6,7,9};
        SSort(a,a.length);
        for (int x:a){
            System.out.println(x);
        }
    }
}
