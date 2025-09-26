package Sorting;

public class Merge {
    static void merge2(int a[],int l,int mid,int h){
        int i,j,k;
        int b[] = new int[a.length];
        i = l;
        j=mid+1;
        k=l;

        while (i<=mid && j<=h){
            if (a[i] < a[j]){
                b[k++] = a[i++];
            }
            else {
                b[k++] = a[j++];
            }
        }

        while (i <= mid) {
            b[k++] = a[i++];
        }
        while (j <= h) {
            b[k++] = a[j++];
        }

        for (i=l;i<=h;i++){
            a[i] = b[i];
        }
    }

    static  void IterativeMerge(int a[],int n){
        int p,i,l,mid,h;
        for (p=2;p<=n;p=p*2){
            for (i=0;i+p-1<n;i=i+p){
                l=i;
                h=i+p-1;
                mid = (l+h)/2;
                merge2(a,l,mid,h);
            }
        }
        if (p/2<n){
            merge2(a,0,(p/2)-1,n-1);
        }

        for (int s=0;s<a.length;s++){
            System.out.println(a[s]);
        }
    }

    static void RMerge(int a1[],int l,int h){


        if (l<h){
            int mid = (l+h)/2;
            RMerge(a1,l,mid);
            RMerge(a1,mid+1,h);
            merge2(a1,l,mid,h);

        }

    }

    public static void main(String[] args) {
        int a[] = {1, 3, 10, 14, 19, 56};  // Sorted
        int b[] = {1, 15, 32, 56, 90};

//        int a1[] = {2,5,8,12,3,6,7,10};//till index three it is sorted and from 4 it is sorted again
//        merge2(a1,0,3,7);


        int a2[] = {8,3,7,4,9,2,6,5};
        //IterativeMerge(a2,a2.length);

        RMerge(a2,0,a2.length-1);
        for (int x : a2) {
            System.out.print(x + " ");
        }
    }
}
