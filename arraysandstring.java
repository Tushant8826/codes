public class arraysandstring {
    /*
    ++++++++++++++++++++++++++++++++++++++++++++++++++++
    Long Pressed Name
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while(j<typed.length()){
            if(i<name.length()&&name.charAt(i)==typed.charAt(j)) {
                i++;
                j++;
            }else {
                if(j>=1&&typed.charAt(j)==typed.charAt(j-1)) j++;  //"dfuyalc" "fuuyallc" <== j>=1 condtions
                else return false;
            }
        }
        if(i==name.length()-1) return false;  //"pyplrz" "ppyypllr" for this  condition
        return true;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    range-addition
     public int[] getModifiedArray(int length, int[][] updates) {
        int a[]=new int[length+1];
        int n=updates.length;
        for(int i=0;i<n;i++) {
            int startindex=updates[i][0];
            int endindex=updates[i][1];
            int val=updates[i][2];
            a[startindex]+=val;
            a[endindex+1]+=(-val);
        }
        int pre[]=new int[length];
        pre[0]=a[0];
        for(int i=1;i<length;i++) {
          pre[i]=pre[i-1]+a[i];
        }
        return pre;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Max Range Queries
    public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner s=new Scanner(System.in);
	    int t=s.nextInt();
	    while(t-->0) {
	        int n=s.nextInt();
	        int k=s.nextInt();
	        int a[]=new int[100002];
	        int l[]=new int[n];
	        int r[]=new int[n];
	        for(int i=0;i<n;i++) {
	            l[i]=s.nextInt();
    	      	r[i]=s.nextInt();
    	      	a[l[i]]++;
    	      	a[r[i]+1]--;
	        }
	       int totalnumbreofk=0;
	        for(int i=1;i<=100000;i++){
	            a[i]=a[i-1]+a[i];
	            if(a[i]==k) totalnumbreofk++;
	        }
	       int prefixcountK[]=new int[100002];
	       int prefixcountK1[]=new int[100002];
	       for(int i=1;i<=100000;i++) {
    		  prefixcountK[i]=prefixcountK[i-1];
    		  prefixcountK1[i]=prefixcountK1[i-1];
    		  if(a[i]==k) {
    			  prefixcountK[i]=prefixcountK[i-1]+1;
    		  }
    		  if(a[i]==(k+1)) prefixcountK1[i]=prefixcountK1[i-1]+1;
    	   }
    	   int max=Integer.MIN_VALUE;
    	   for (int i=0 ; i<n ; i++){
    		   int count=totalnumbreofk-(prefixcountK[r[i]]-prefixcountK[l[i]-1])+(prefixcountK1[r[i]]-prefixcountK1[l[i]-1]);
    		   max=Math.max(max,count);
    	   }
    	   System.out.println(max);

	    }
	}
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Rotate Array
	public void swap(int nums[],int start,int end) {
        if(start>=end) return ;
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
        swap(nums,start+1,end-1);
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        int index=n-1-k;
        swap(nums,0,index);
        swap(nums,index+1,n-1);
        swap(nums,0,n-1);
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Next Greater Element III
    class Solution {
    public void swap(char[] ch,int start,int end) {
        if(start>=end) return ;
        char temp=ch[start];
        ch[start]=ch[end];
        ch[end]=temp;
        swap(ch,start+1,end-1);
    }
    public int nextGreaterElement(int n) {
        String str=Integer.toString(n);
        char[] ch=str.toCharArray();
        int firstswapindex=-1;
        for(int i=str.length()-1;i>0;i--) {
            if(str.charAt(i)>str.charAt(i-1)) {
                firstswapindex=i-1;
                break;
            }
        }
        if(firstswapindex==-1) return -1;
        int nextgreater=-1;
        int nextgreaterindex=-1;
        for(int i=firstswapindex+1;i<str.length();i++) {
            if(str.charAt(firstswapindex)<str.charAt(i)) {
                nextgreaterindex=i;
            }
        }
        char temp=ch[firstswapindex];
        ch[firstswapindex]=ch[nextgreaterindex];
        ch[nextgreaterindex]=temp;
        swap(ch,firstswapindex+1,str.length()-1);
        long max=2147483647;
        long number = Long.parseLong(new String(ch));
        if(number>max) return -1;
        return (int)number;
    }
}
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Orderly Queue
    public  boolean isSmaller(String x, String y) {
		int lx = x.length();
		for(int i=0; i<lx; i++) {
			if(x.charAt(i)<y.charAt(i)) {
				return true;
			} else if(x.charAt(i)>y.charAt(i)) {
				return false;
			}
		}
		return false;
	}
    public String orderlyQueue(String S, int K) {
        char ch[]=S.toCharArray();
        if(K>=2) {
            Arrays.sort(ch);
            return new String(ch);
        }
        int n=S.length();
        String ans=S;
        for(int i=0;i<n;i++) {
            String temp=S.substring(1)+S.charAt(0);
            if(isSmaller(temp,ans)) {
                ans=temp;
            }
            S=temp;
        }
        return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    maximum sumsubarray
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return Integer.MIN_VALUE;
        int currmax=nums[0];
        int omax=nums[0];
        for(int i=1;i<nums.length;i++) {
            if(currmax<0) currmax=nums[i];
            else currmax+=nums[i];
            omax=Math.max(omax,currmax);
        }
        return omax;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    K-Concatenation
    public static long kadane (long a[]) {
        long curr=a[0];
        long omax=a[0];
        for(int i=1;i<a.length;i++) {
            if(curr<0) curr=a[i];
            else curr+=a[i];
            omax=Math.max(omax,curr);
        }
        return omax;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
	   while(t-->0) {
	       int n=s.nextInt();
	       int k=s.nextInt();
	       long a[]=new long[n];
	       long sum=0;
	       for(int i=0;i<n;i++) {
	           a[i]=s.nextLong();
	           sum+=a[i];
	       }
	       if(k==1){
	           System.out.println(kadane(a));
	           continue;
	       }
	       long b[]=new long[2*n];
	       for(int i=0;i<n;i++) b[i]=a[i];
	       for(int i=0;i<n;i++) b[i+a.length]=a[i];
	       long ans=0;
	       if(sum>=0) {
	           long x=kadane(b);
	           ans=x+(k-2)*sum;
	       }
	       else {
	           ans=kadane(b);
	       }
	       System.out.println(ans);
	   }
	}
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Container With Most Water
	public int maxArea(int[] height) {

        int i=0;
        int j=height.length-1;
        int max=0;
        while(i<j) {
            max=Math.max(max,(j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return max;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Remove Duplicates from Sorted Array
     public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
            int count=0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1]<nums[i]) {
                count++;
                nums[count]=nums[i];
            }
        }
        return count+1;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Product of Array Except Self
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int prefixproduct[]=new int[n];
        prefixproduct[0]=nums[0];
        for(int i=1;i<n;i++) {
            prefixproduct[i]=nums[i]*prefixproduct[i-1];
        }
        int suffixproduct=1;
        for(int i=n-1;i>=1;i--){
            prefixproduct[i]=prefixproduct[i-1]*suffixproduct;
            suffixproduct*=nums[i];
        }
        prefixproduct[0]=suffixproduct;
        return prefixproduct;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Find the number of jumps to reach X in the number line from zero
     public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        int x=s.nextInt();
        int i=0;
        int count=1;
        while(x-i>0) {
            i+=count;
            count++;
        }
        if((i-x)%2==0) {
            System.out.println(count-1);
        }else {
            i+=count;
            count++;
            if((i-x)%2==0) System.out.println(count-1);
            else System.out.println(count);
        }
    }
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Sieve of Eratosthenes
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		   boolean ans[]=new boolean[n+1];
		   for(int i=2;i*i<=n;i++) {
		       if(!ans[i]) {
		           for(int j=2*i;j<=n;j+=i) {
		               ans[j]=true;
		           }
		       }
		   }
		   for(int i=2;i<=n;i++) {
		       if(!ans[i]) System.out.print(i+" ");
		   }
		   System.out.println();
		}
	}
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Squares of a Sorted Array
	public int[] sortedSquares(int[] A) {
        int i=0;
        int n=A.length;
        int j=n-1;
        int ans[]=new int[n];
        int k=n-1;
        while(i<=j) {
            if(A[j]*A[j]>A[i]*A[i]) {
                ans[k]=A[j]*A[j];
                j--;
            }else {
                ans[k]=A[i]*A[i];
                i++;
            }
            k--;
        }
        return ans;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Fibonacci Number
    public void multiply(int A[][],int M[][]) {
        int fvalue=A[0][0]*M[0][0]+A[0][1]*M[1][0];
        int svalue=A[0][0]*M[0][1]+A[0][1]*M[1][1];
        int tvalue=A[1][0]*M[0][0]+A[1][1]*M[1][0];
        int lvalue=A[1][0]*M[0][1]+A[1][1]*M[1][1];
        A[0][0]=fvalue;
        A[0][1]=svalue;
        A[1][0]=tvalue;
        A[1][1]=lvalue;
    }
    public void power(int A[][],int n) {
        int ans[][]={{1,0},{0,1}};
        while(n!=1) {
            if(n%2==1) {
                multiply(ans,A);
                n--;
            }
            multiply(A,A);
            n=n/2;
        }
        multiply(A,ans);
    }
    public int fib(int N) {
        int A[][]={{1,1},{1,0}};
        if(N==0) return 0;
        if(N==1) return 1;
        power(A,N-1);
        return A[0][0];
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Binary Array Sorting
    public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=s.nextInt();
		    int i=0;
		    int j=0;
		    while(j<n) {
		        if(a[j]==1) j++;
		        else {
		            int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
		            i++;
		            j++;
		        }
		    }
		    String str="";
		    for(int k=0;k<n;k++) str+=a[k]+" ";
		    System.out.println(str);
		}
	}
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Sort an array of 0s, 1s and 2s
	public static void swap(int i,int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    static int a[];
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    a=new int[n];
		    for(int i=0;i<n;i++) a[i]=s.nextInt();
		    int i=0;
		    int j=0;
		    int k=n-1;
		    while(j<=k) {
		        if(a[j]==1) {
		            j++;
		        }
		        else if(a[j]==2) {
		            swap(j,k);
		            k--;
		        }
		        else {
		           swap(j,i);
		           i++;
		           j++;
		        }
		    }
		    String str="";
		    for(int l=0;l<n;l++) str+=a[l]+" ";
		    System.out.println(str);
		}
	}
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Sort Array By Parity
    public int[] sortArrayByParity(int[] a) {
        int n=a.length;
        int i=0;
        int j=0;
        while(j<n) {
            if(a[j]%2==1) {
                j++;
            }else {
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i++;
                j++;
            }
        }
        return a;

    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Optimal Division
    public String optimalDivision(int[] nums) {
      int n=nums.length;
      String str="";
      str+=nums[0];
        if(n==1) return str;
        if(n==2) {
            str+='/';
            str+=nums[1];
            return str;
        }
        str+="/(";
      for(int i=1;i<n;i++) {
          str+=nums[i];
          str+='/';
      }
      int len =str.length();
       str=str.substring(0,len-1);
       str+=')';
        return str;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Best Meeting Point
    public int minTotalDistance(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        ArrayList<Integer> row=new ArrayList<>();
        ArrayList<Integer> col=new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    row.add(i);
                }
            }
        }
        for(int j=0;j<m;j++) {
            for(int i=0;i<n;i++) {
                if(grid[i][j]==1) {
                    col.add(j);
                }
            }
        }
        int midrow=row.get(row.size()/2);
        int midcol=col.get(col.size()/2);
        //System.out.println(midrow+" "+midcol);
        int ans=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    ans+=Math.abs(midrow-i);
                    ans+=Math.abs(midcol-j);
                }
            }
        }
        return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Maximum Swap
    public int maximumSwap(int num) {
        String str=String.valueOf(num);
        char ch[]=str.toCharArray();
        int dippoint=-1;
        for(int i=1;i<ch.length;i++) {
            if(ch[i-1]-'0'<ch[i]-'0') {
                dippoint=i-1;
                break;
            }
        }
        if(dippoint==-1) return num;
        int greaterelementafterdip=-1;
        int index=-1;
        for(int i=dippoint+1;i<ch.length;i++) {
            if(greaterelementafterdip<=ch[i]-'0') {
                greaterelementafterdip=ch[i]-'0';
                index=i;
            }
        }
        for(int i=0;i<=dippoint;i++) {
            if(greaterelementafterdip>ch[i]-'0') {
                char temp=ch[i];
                ch[i]=ch[index];
                ch[index]=temp;
                break;
            }
        }
        int ans=Integer.parseInt(new String(ch));
        return ans;
    }
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Key Pair
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    int sum=s.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=s.nextInt();
		    Arrays.sort(a);
		    int i=0;
		    int j=n-1;
		    boolean ans=false;
		    while(i<j) {
		        if(a[i]+a[j]==sum) {
		            ans=true;
		            break;
		        }
		        else if(a[i]+a[j]>sum) j--;
		        else i++;
		    }
		    if(ans) System.out.println("Yes");
		    else System.out.println("No");
		}
	}
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Find Pair Given Difference
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    int diff=s.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=s.nextInt();
		    Arrays.sort(a);
		    int i=0;
		    int j=0;
		    boolean ans=false;
		    while(j<n) {
		        if(a[j]-a[i]==diff) {
		            ans=true;
		            break;
		        }
		        else if(a[j]-a[i]>diff) i++;
		        else j++;
		    }
		    if(ans) System.out.println("1");
		    else System.out.println("-1");
		}
	}
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Boats to Save People
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        Arrays.sort(people);
        int i=0;
        int j=n-1;
        int ans=0;
        while(i<=j) {
            if(people[i]+people[j]<=limit) {
                i++;
                j--;
            }
            else j--;
            ans++;
        }
        return ans;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Majority Element
    public int majorityElement(int[] nums) {
        int val=0;
        int count=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==val) {
                count++;
            }else {
                if(count>0) count--;
                else {
                    val=nums[i];
                    count=1;
                }
            }
        }
        count=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==val) count++;
        }
        if(count>nums.length/2) return val;
        return -1;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     Majority ElementII
     public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int val1=0;
        int count1=0;
        int val2=0;
        int count2=0;
        for(int i=0;i<n;i++) {
            if(val1==nums[i]) {
                count1++;
            }else if(val2==nums[i]) {
                count2++;
            }
            else if(count1==0) {
                val1=nums[i];
                count1=1;
            }
            else if(count2==0) {
                val2=nums[i];
                count2=1;
            }else {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<n;i++) {
            if(nums[i]==val1) count1++;
            else if(nums[i]==val2) count2++;
        }
        List<Integer> list=new ArrayList<>();
        if(count1>n/3&&count2>n/3)  {
            list.add(val1);
            list.add(val2);
        }else if(count1>n/3) list.add(val1);
        else if(count2>n/3) list.add(val2);
        return list;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Max Chunks To Make Sorted
    public int maxChunksToSorted(int[] arr) {
        int max=-1;
        int count=0;
        for(int i=0;i<arr.length;i++) {
            max=Math.max(arr[i],max);
            if(max==i) count++;
        }
        return count;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Max Chunks To Make Sorted II
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int maxfromleft[]=new int[n];
        int minfromright[]=new int[n];
        maxfromleft[0]=arr[0];
        for(int i=1;i<n;i++) {
            maxfromleft[i]=Math.max(maxfromleft[i-1],arr[i]);
        }
        minfromright[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--) {
            minfromright[i]=Math.min(minfromright[i+1],arr[i]);
        }
        int count=1;
        for(int i=0;i<n-1;i++) {
            if(maxfromleft[i]<=minfromright[i+1]) {
                count++;
            }
        }
        return count;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Number of Subarrays with Bounded Maximum
     public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int j=0;
        int smaller=0;
        int ans=0;
        for(int i=0;i<A.length;i++) {
            if(A[i]>=L&&A[i]<=R) {
                smaller=i-j+1;
                ans+=smaller;
            }
            else if(A[i]<L) {
                ans+=smaller;
            }
            else {
                j=i+1;
                smaller=0;
            }
        }
        return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Minimum Platforms
    public static void main (String[] args) {
	  Scanner s=new Scanner(System.in);
	  int t=s.nextInt();
	  while(t-->0) {
	      int n=s.nextInt();
	      int a[]=new int[2401];
	      for(int i=0;i<n;i++) {
	          int x=s.nextInt();
	          a[x]+=1;
	      }
	      int len=-1;
	      for(int i=0;i<n;i++) {
	          int x=s.nextInt();
	          len=Math.max(x,len);
	          a[x+1]+=-1;
	      }
	      int max=a[0];
	      for(int i=1;i<=len;i++) {
	          a[i]+=a[i-1];
	          max=Math.max(a[i],max);
	      }
	      System.out.println(max);
	  }
	}
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Maximum Product of Three Numbers
    public int maximumProduct(int[] a) {
        Arrays.sort(a);
        int n=a.length;
        int x=a[0]*a[1]*a[n-1];
        int y=a[n-1]*a[n-2]*a[n-3];
        return Math.max(x,y);
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Largest Number At Least Twice of Others
     public int dominantIndex(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        int max=0;
        int secondmax=-1;
        for(int i=1;i<n;i++){
            if(nums[max]<nums[i]) {
                secondmax=max;
                max=i;
            }
            else if(secondmax!=-1&&nums[i]>nums[secondmax]) {
                secondmax=i;
            }
            else if(secondmax==-1) secondmax=i;
        }
        if(secondmax!=-1&&nums[secondmax]*2<=nums[max]) return max;
        if(max>-1&&secondmax==-1) return 0;
        return -1;
    }
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Wiggle sort
	 public void swap(int nums[],int i,int j) {
         int temp=nums[i];
         nums[i]=nums[j];
         nums[j]=temp;
     }
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++) {
            if(i%2==0) {
                if(nums[i]>nums[i+1]) {
                    swap(nums,i,i+1);
                }
            }else {
                if(nums[i]<nums[i+1]) {
                    swap(nums,i,i+1);
                }
            }
        }
        // write your code here
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    max-consecutive-ones-ii
    public int findMaxConsecutiveOnes(int[] nums) {
        int index=-1;
        int ans=-1;
        int j=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                j=index+1;
                index=i;
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
        // write your code here
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Max Consecutive Ones III
     public int longestOnes(int[] A, int K) {
        Queue<Integer> q=new LinkedList<>();
        int j=0;
        int ans=-1;
        for(int i=0;i<A.length;i++) {
            if(A[i]==0) q.add(i);
            if(q.size()>K) {
                int front=q.poll();
                j=front+1;
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Partition Labels
	public List<Integer> partitionLabels(String S) {
        int n=S.length();
        HashMap<Character,Integer>  map=new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(S.charAt(i),i);
        }
        int end=-1;
        int j=0;
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<n;i++) {
           end=Math.max(end,map.get(S.charAt(i)));
           if(end==i) {
               li.add(i-j+1);
               j=i+1;
           }
        }
        return li;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Rotate Image
    public void rotate(int[][] matrix) {
      int n=matrix.length;
       //traspose of matrix
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(j>i) {
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }
        // for clock wise ==> row wise reverse
        for(int i=0;i<n;i++) {
            int j=0;
            int k=n-1;
            while(j<k) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]=temp;
                j++;
                k--;
            }
        }
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Consecutive Numbers Sum
    public int consecutiveNumbersSum(int N) {
        int ans=0;
        for(int k=1;k*k<2*N;k++) {
            if((N-(k*(k-1))/2)%k==0) ans++;
        }
        return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Maximum Product Subarray
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int prefpro=1;
        int suffpro=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            prefpro*=nums[i];
            max=Math.max(max,prefpro);
            if(nums[i]==0) prefpro=1;
        }
        for(int i=n-1;i>=0;i--) {
            suffpro*=nums[i];
            max=Math.max(max,suffpro);
            if(nums[i]==0)  suffpro=1;
        }
        return max;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Minimum Domino Rotations For Equal Row  (using four loops)
    public int minDominoRotations(int[] A, int[] B) {
        int val1=A[0];
        int val2=B[0];
        int n=A.length;
        int cost1=0;
        for(int i=0;i<n;i++) {
            if(A[i]==val1) continue;
            else {
                if(B[i]==val1) cost1++;
                else {
                    cost1=Integer.MAX_VALUE;
                    break;
                }
            }
        }
        int cost2=0;
        for(int i=0;i<n;i++) {
            if(A[i]==val2) continue;
            else {
                if(B[i]==val2) cost2++;
                else {
                    cost2=Integer.MAX_VALUE;
                    break;
                }
            }
        }
        int cost3=0;
        for(int i=0;i<n;i++) {
           if(B[i]==val1) continue;
            else {
                if(A[i]==val1) cost3++;
                else {
                    cost3=Integer.MAX_VALUE;
                    break;
                }
            }
        }
        int cost4=0;
        for(int i=0;i<n;i++) {
            if(B[i]==val2) continue;
            else {
                if(A[i]==val2) cost4++;
                else {
                    cost4=Integer.MAX_VALUE;
                    break;
                }
            }
        }
       // System.out.println(cost1+" "+cost2+" "+cost3+" "+cost4);
        int ans=Math.min(cost1,Math.min(cost2,Math.min(cost3,cost4)));
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Minimum Domino Rotations For Equal Row (using one loop)
     public int minDominoRotations(int[] A, int[] B) {
        int val1=A[0];
        int val2=B[0];
        int n=A.length;
        int cost1=0;
        int cost2=0;
        int cost3=0;
        int cost4=0;
        for(int i=0;i<n;i++) {
            if(cost1!=Integer.MAX_VALUE) {
                if(A[i]!=val1){
                    if(B[i]==val1) cost1++;
                    else cost1=Integer.MAX_VALUE;
                }
            }
            if(cost2!=Integer.MAX_VALUE) {
                if(A[i]!=val2) {
                    if(B[i]==val2) cost2++;
                    else cost2=Integer.MAX_VALUE;
                }
            }
            if(cost3!=Integer.MAX_VALUE) {
                if(B[i]!=val1) {
                    if(A[i]==val1) cost3++;
                    else cost3=Integer.MAX_VALUE;
                }
            }
            if(cost4!=Integer.MAX_VALUE) {
                if(B[i]!=val2){
                     if(A[i]==val2) cost4++;
                     else cost4=Integer.MAX_VALUE;
                }
            }

        }
        int ans=Math.min(cost1,Math.min(cost2,Math.min(cost3,cost4)));
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Reverse Vowels of a String
     public boolean checkvowel(char ch) {
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U') return true;
        return false;
    }
    public String reverseVowels(String s) {
        char ch[]=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j) {
            if(checkvowel(s.charAt(i))&&checkvowel(s.charAt(j))) {
                char temp=ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;
                j--;
            }
            else if(checkvowel(s.charAt(i))) {
                j--;
            }
            else if(checkvowel(s.charAt(j))) {
                i++;
            }
            else {
                i++;
                j--;
            }
        }
        return new String(ch);
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Pascal's Triangle II
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex==0) {
            List<Integer> li=new ArrayList<>();
            li.add(1);
            return li;
        }
        List<Integer> li=new ArrayList<>();
        li.add(1);
        li.add(1);
        for(int k=2;k<=rowIndex;k++) {
            for(int j=li.size()-1;j>=1;j--) {
                li.set(j,li.get(j)+li.get(j-1));
            }
            li.add(1);
        }
        return li;
    }
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Partition Array into Disjoint Intervals
	 public int partitionDisjoint(int[] A) {
        int currmax=A[0];
        int ans=0;
        int newmax=currmax;
        for(int i=1;i<A.length;i++) {
            newmax=Math.max(newmax,A[i]);
            if(currmax>A[i]) {
                ans=i;
                currmax=newmax;
            }
        }
        return ans+1;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Multiply Strings
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        char ch[]=new char[len1+len2];
        Arrays.fill(ch,'0');
        int j=len2-1;
        while (j>=0) {
            for(int i=len1-1;i>=0;i--) {
               int x=num1.charAt(i)-'0';
               int y=num2.charAt(j)-'0';
               int prod=x*y;
               int carryindex=i+j;
               int remindex=i+j+1;
               int elemrem=(ch[remindex]-'0')+prod;
               int carry=elemrem/10;
               int rem=elemrem%10;
               ch[carryindex]=(char)((ch[carryindex]-'0'+carry)+'0');
               ch[remindex]=(char)(rem+'0');
            }
            j--;
        }
        String ans= new String(ch);
        int index=-1;
        for(int i=0;i<ans.length();i++) {
            if(ans.charAt(i)-'0'>0) {
                index=i;
                break;
            }
        }
        if(index==-1) return "0";
        return ans.substring(index);
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Maximize Distance to Closest Person
    public int maxDistToClosest(int[] seats) {
        int index=-1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<seats.length;i++) {
            if(seats[i]==1&&index==-1) {
                max=Math.max(max,i);
                index=i;
            }
            else if(seats[i]==1) {
                int temp=(i+index)/2;
                max=Math.max(temp-index,max);
                index=i;
            }
        }
        max=Math.max(seats.length-1-index,max);
        return max;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Smallest Range Covering Elements from K Lists
    static class Pair implements Comparable<Pair>{
        int val;
        int i;
        int j;
        Pair(int val,int i,int j) {
            this.val=val;
            this.i=i;
            this.j=j;
        }
        @Override
        public int compareTo(Pair o) {
            return this.val-o.val;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> q=new PriorityQueue<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++) {
            int temp=nums.get(i).get(0);
            max=Math.max(max,temp);
            q.add(new Pair(temp,i,0));
        }
        int len=Integer.MAX_VALUE;
        int sp=0;
        int ep=0;
        while(!q.isEmpty()) {
            Pair p=q.poll();
            if(max-p.val<len) {
                len=max-p.val;
                sp=p.val;
                ep=max;
            }
            List<Integer> l=nums.get(p.i);
            int j=p.j;
            if(j==l.size()-1) break;
            max=Math.max(max,l.get(j+1));
            q.add(new Pair(l.get(j+1),p.i,j+1));
        }
        int ans[]=new int[2];
        ans[0]=sp;
        ans[1]=ep;
        return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Valid Palindrome II
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j) {
            if(s.charAt(i)==s.charAt(j)) {
                i++;
                j--;
            }
            else {
                boolean ans1=check(s,i,j-1);
                boolean ans2=check(s,i+1,j);
                if(ans1==false&&ans2==false) return false;
                return true;
            }
        }
        return true;
    }
    public boolean check(String s,int i,int j) {
        if(i>=j) {
            return true;
        }
        if(s.charAt(i)==s.charAt(j)) {
            return check(s,i+1,j-1);
        }
        return false;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Maximum Sum of Two Non-Overlapping Subarrays
     public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n=A.length;
        int prefix[]=new int[n];
        prefix[0]=A[0];
        for(int i=1;i<n;i++) {
            prefix[i]=prefix[i-1]+A[i];
        }
        int lsizemax=prefix[L-1];
        int msizemax=prefix[M-1];
        int omax=prefix[L+M-1];
        for(int i=L+M;i<A.length;i++) {
            msizemax=Math.max(msizemax,prefix[i-L]-prefix[i-L-M]);
            lsizemax=Math.max(lsizemax,prefix[i-M]-prefix[i-L-M]);
            int lsum=prefix[i]-prefix[i-L];
            int msum=prefix[i]-prefix[i-M];
            omax=Math.max(omax,Math.max(lsum+msizemax,msum+lsizemax));
        }
        return omax;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    First Missing Positive
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++) {
            int correctpos=nums[i]-1;
           while(nums[i]>=1&&nums[i]<=n&&nums[correctpos]!=nums[i]) {
                   int temp=nums[correctpos];
                   nums[correctpos]=nums[i];
                   nums[i]=temp;
                   correctpos=nums[i]-1;
           }
        }
        for(int i=0;i<n;i++) {
            if(i+1!=nums[i]) {
                return i+1;
            }
        }
        return n+1;
        
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Global and Local Inversions
    public boolean isIdealPermutation(int[] A) {
        for(int i=0;i<A.length;i++) {
            if(Math.abs(A[i]-i)>=2) return false;
        }
        return true;
    }
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     */
}
