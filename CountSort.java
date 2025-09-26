package Sorting;

public class CountSort {


    static int findMax(int a[],int n){
        int max = a[0];
        for (int i=1;i<n;i++){
            if (a[i]>max){
                max = a[i];
            }
        }
        return max;
    }
    static void CSort(int a[],int n){

        int j=0;
        int max = findMax(a,n);
        int c[] = new int[max+1];

        for (int i=0;i<n;i++){
            c[a[i]]++;
        }

        for (int i=0;i<=max;i++){
            while (c[i] > 0){
                a[j++] = i;
                c[i]--;
            }
        }

    }
    public static void main(String[] args) {

        int a[] = {3,4,6,10,3,6,15};
        CSort(a,a.length);
        for (int x:a){
            System.out.println(x);
        }

    }
}
