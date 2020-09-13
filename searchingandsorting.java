public class searchingandsorting {
    /*
    +++++++++++++++++++++++++++++++++++++++++++++
    Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return helper(nums2,nums1);
        return helper(nums1,nums2);
    }
    public double helper(int nums1[],int nums2[]) {
         int n=nums1.length;
         int m=nums2.length;
        int gl=(n+m+1)/2;
        int i=0;
        int j=n;
        double ans=0;

        while(i<=j) {
            int mid1=(i+j)/2;
            int mid2=gl-mid1;
             if(mid1>=n) break;
            if(mid2-1>=0&&nums1[mid1]<nums2[mid2-1]) {
                i=mid1+1;
            }else if(mid1-1>=0&&nums1[mid1-1]>nums2[mid2]) {
                j=mid1-1;
            }else {
                break;
            }
          }
                int mid1=(i+j)/2;
                int mid2=gl-mid1;
                double max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                if(mid1-1>=0) max = nums1[mid1-1];
                if(mid2-1>=0) max = Math.max(max, nums2[mid2-1]);
                 if(mid1<n) min = nums1[mid1];
                if(mid2<m) min = Math.min(min, nums2[mid2]);
                if((n+m)%2==0) ans=(max+min)/2;
                else ans=max;
        return ans;
    }
    +++++++++++++++++++++++++++++++++++++++++++++
    Capacity To Ship Packages Within D Days
    public int shipWithinDays(int[] weights, int D) {
        int n=weights.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++) {
          sum+=weights[i];
            max=Math.max(max,weights[i]);
        }
        int lo=max;
        int hi=sum;
        int ans=-1;
        while(lo<=hi) {
            int mid=(lo+hi)/2;
            int temp=0;
            int reqday=1;
            for(int val:weights) {
                if(temp+val>mid) {
                   reqday+=1;
                    temp=0;
                }
                temp+=val;
            }
            if(reqday>D) {
                lo=mid+1;
            }
            else if(reqday<=D) {
                ans=mid;
                hi=mid-1;
            }
        }
        return ans;
    }
    +++++++++++++++++++++++++++++++++++++++++++++
    Split Array Largest Sum
    public int splitArray(int[] nums, int m) {
        int n=nums.length;
        long max=-20000;
        long sum=0;
        for(int i=0;i<n;i++) {
          sum+=nums[i];
          max=Math.max(max,nums[i]);
        }
        long lo=max;
        long hi=sum;
        long ans=-1;
        while(lo<=hi) {
            long mid=lo+(hi-lo)/2;
            long temp=0;
            long reqday=1;
            for(int val:nums) {
                if(temp+val>mid) {
                   reqday+=1;
                    temp=0;
                }
                temp+=val;
            }
            if(reqday>m) {
                lo=mid+1;
            }
            else if(reqday<=m) {
                ans=mid;
                hi=mid-1;
            }
        }
        int ans2=(int) ans;
        return ans2;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++
    Koko Eating Bananas
    public int minEatingSpeed(int[] piles, int H) {
        int hi=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++) {
             hi=Math.max(hi,piles[i]);
        }
        int lo=1;
        int ans=-1;
        while(lo<=hi) {
         int mid=(lo+hi)/2;
            int hours=0;
         for(int val:piles) {
             int x=(int)Math.ceil((val*1.0)/mid);
             hours+=x;
         }
         if(hours>H) {
             lo=mid+1;
         }
         else {
             ans=mid;
             hi=mid-1;
         }
        }
        return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++
    Find the Smallest Divisor Given a Threshold
    public int smallestDivisor(int[] nums, int threshold) {
         int hi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
             hi=Math.max(hi,nums[i]);
        }
        int lo=1;
        int ans=-1;
        while(lo<=hi) {
         int mid=(lo+hi)/2;
            int divisor=0;
         for(int val:nums) {
             int x=(int)Math.ceil((val*1.0)/mid);
             divisor+=x;
         }
         if(divisor>threshold) {
             lo=mid+1;
         }
         else {
             ans=mid;
             hi=mid-1;
         }
        }
        return ans;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int search(int[] a, int t) {
        int n = a.length;
        int s = 0, e = n-1;
        while(s<e) {
        	int m = (s+e)/2;
        	if(a[m]>a[e]) {
        		s = m+1;
        	} else e = m;
        }
        int p = s;
        s = 0; e = p-1;
        while(s<=e) {
        	int m = (s+e)/2;
            if(a[m]==t) return m;
            else if(t<a[m]) e = m-1;
            else s = m+1;
        }
        s = p; e = n-1;
        while(s<=e) {
        	int m = (s+e)/2;
            if(a[m]==t) return m;
            else if(t<a[m]) e = m-1;
            else s = m+1;
        }
        return -1;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    counting sort
    public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    int size=s.nextInt();
    int a[]=new int[size];
    for(int i=0;i<size;i++) {
        a[i]=s.nextInt();
    }
    int freq[]=new int[size+1];
    for(int i=0;i<size;i++) {
        freq[a[i]]++;
    }
    int pref[]=new int[size+1];
    pref[0]=freq[0];
    for(int i=1;i<=size;i++) {
        pref[i]=pref[i-1]+freq[i];
    }
    int ans[]=new int[size];
    for(int i=0;i<size;i++) {
        int x=a[i];
        ans[pref[x]-1]=x;
        pref[x]--;
    }
    for(int val:ans) {
        System.out.print(val+" ");
    }
       s.close(); 
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    merge sort
    public static void mergeSort(int[] input){
		mergeSort(input,0,input.length-1);
	}
    public static void mergeSort(int[] input,int start,int end) {
        if(start>=end) {
            return;
        }
        int mid=(start+end)/2;
        mergeSort(input,start,mid);
        mergeSort(input,mid+1,end);
        merge(input,start,end);
    }
    public static void merge(int[] input,int start,int end) {
        int mid=(start+end)/2;
        int i=start;
        int j=mid+1;
        int ans[]=new int[end-start+1];
            int k=0;
        while(i<=mid&&j<=end) {
            if(input[i]<input[j]) {
                ans[k]=input[i];
                k++;
                i++;
            }
            else if(input[i]>input[j]) {
                ans[k]=input[j];
                k++;
                j++;
            }
            else {
                ans[k]=input[i];
                k++;
                i++;
                ans[k]=input[j];
                k++;
                j++;
            }
        }
        for(int l=i;l<=mid;l++) {
            ans[k]=input[l];
            k++;
        }
        for(int l=j;l<=end;l++) {
            ans[k]=input[l];
            k++;
        }
        i=start;
        for(int l=0;l<ans.length;l++) {
            input[i]=ans[l];
            i++;
        }
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++
     public static void mergeSort(int[] input){
		mergeSort(input,0,input.length-1);
	}
    public static void mergeSort(int[] input,int start,int end) {
        if(start>=end) {
            return;
        }
        int mid=(start+end)/2;
        mergeSort(input,start,mid);
        mergeSort(input,mid+1,end);
        merge(input,start,end);
    }
    public static void merge(int[] input,int start,int end) {
        int mid=(start+end)/2;
        int i=mid;
        int j=end;
        while(i>=start&&j>=mid+1) {
            if(input[i]>input[j]){
                count+=j-mid;
                i--;
            }
            else j--;
        }
        i=start;
        j=mid+1;
        int ans[]=new int[end-start+1];
            int k=0;
        while(i<=mid&&j<=end) {
            if(input[i]<input[j]) {
                ans[k]=input[i];
                k++;
                i++;
            }
            else if(input[i]>input[j]) {
                ans[k]=input[j];
                k++;
                j++;
            }
            else {
                ans[k]=input[i];
                k++;
                i++;
                ans[k]=input[j];
                k++;
                j++;
            }
        }
        for(int l=i;l<=mid;l++) {
            ans[k]=input[l];
            k++;
        }
        for(int l=j;l<=end;l++) {
            ans[k]=input[l];
            k++;
        }
        
        i=start;
        for(int l=0;l<ans.length;l++) {
            input[i]=ans[l];
            i++;
        }
    }
    static long count;
	public static void main (String[] args) {
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
	   while(t-->0) {
	       int n=s.nextInt();
	       int a[]=new int[n];
	       for(int i=0;i<n;i++) a[i]=s.nextInt();
	       count=0;
	       mergeSort(a);
	       System.out.println(count);
	   }
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     */

}