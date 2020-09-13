
public class GFG{ 
        /* Driver program to test above functions */
         public static void main(String []args){
              int a[]={9,10,7,6,4,8,1};
              int n=a.length;
              for(int i=1;i<=n-1;i++) {
                 for(int j=i;j>=1;j--) {
                     if(a[j]<a[j-1]) {
                        int temp=a[j];
                        a[j]=a[j-1];
                        a[j-1]=temp;
                     }
                 }
              }
              for(int i:a) {
                  System.out.print(i+" ");
              }
         }
    }