public class Dp {
    /*
    ++++++++++++++++++++++++++++++++++++++++++++++++++++
    Climbing Stairs
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++) dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++
    Jump game II
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++) {
            for(int j=1;j<=nums[i];j++) {
                if(i+j<n) {
                    dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                }
            }
        }
        return dp[n-1];
    }
    o(n)
    public int jump(int[] nums) {
        int n=nums.length;
        int  ans=0;
        int cend=0;
        int cmax=0;
        for(int i=0;i<n;i++) {
            cmax=Math.max(cmax,i+nums[i]);
            if(i==cend&&cend!=n-1) {
                ans++;
                cend=cmax;
            }
        }
        return ans; 
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Minimum Path Sum
    public int minPathSum(int[][] grid) {
         int m=grid.length;
         int n=grid[0].length;
        int dp[][]=new int[m][n];
         dp[m-1][n-1]=grid[m-1][n-1];
         for(int i=n-2;i>=0;i--) {
             dp[m-1][i]=grid[m-1][i]+dp[m-1][i+1];
         }
         for(int i=m-2;i>=0;i--) {
             dp[i][n-1]=grid[i][n-1]+dp[i+1][n-1];
         }
         for(int i=m-2;i>=0;i--) {
             for(int j=n-2;j>=0;j--) {
                 dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
             }
         }
         return dp[0][0];
    }
         //for printing the path
        String str="";
        int i=0,j=0;
        while(!(i==n-1&&j==m-1)) {
          int x=dp[i][j]-grid[i][j];
          if(j+1<m&&dp[i][j+1]==x){
              j++;
              str+='R';
          } 
          else if(i+1<n&&dp[i+1][j]==x){
              i++;
              str+='B';
          } 
        }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Largest square formed in a matrix
    public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    int m=s.nextInt();
		    int a[][]=new int[n][m];
		    for(int i=0;i<n;i++) {
		        for(int j=0;j<m;j++) {
		          a[i][j]=s.nextInt();
		        }
		    }
		     int ans=0;
		    int dp[][]=new int[n][m];
		    for(int i=0;i<m;i++) {
		       dp[n-1][i]=a[n-1][i];
		        ans=Math.max(ans,dp[n-1][i]);
		    }
		    for(int i=0;i<n;i++) {
		        dp[i][m-1]=a[i][m-1];
		        ans=Math.max(ans, dp[i][m-1]);
		    }
		    for(int i=n-2;i>=0;i--) {
		        for(int j=m-2;j>=0;j--) {
		            if(a[i][j]==0) continue;
		            dp[i][j]=Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i+1][j+1]))+a[i][j];
		            ans=Math.max(ans,dp[i][j]);
		        }
		    }
		    System.out.println(ans);
		}
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    knapsack
    public static int knapsack(int[] weight,int value[],int maxweight) {
        int dp[][]=new int[maxweight+1][weight.length+1];
        for(int i=1;i<=maxweight;i++) {
            for(int j=1;j<=weight.length;j++) {
                if(weight[j-1]>i) dp[i][j]=dp[i][j-1];
                else {
                    int x=dp[i][j-1]; //exclude
                    int y=dp[i-weight[j-1]][j-1]+value[j-1]; //include
                    dp[i][j]=Math.max(x,y);
                }
            } 
        }
        return dp[maxweight][weight.length];
    }
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Fractional Knapsack
	static class Pair implements Comparable<Pair> {
    double wt;
    double cost;
    double ratio;
    Pair(double wt,double cost) {
        this.wt=wt;
        this.cost=cost;
        this.ratio=cost/wt;
    }
    @Override
    public int compareTo(Pair o) {
        if(this.ratio<o.ratio) return 1;
        else if(this.ratio>o.ratio) return -1;
        else return 0;
    }
}
   public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0) {
            int n=s.nextInt();
            int w=s.nextInt();
            int wt[]=new int[n];
            int val[]=new int[n];
            for(int i=0;i<n;i++){
                val[i]=s.nextInt();
                wt[i]=s.nextInt();
            }
            Pair a[]=new Pair[n];
            for(int i=0;i<n;i++) {
                a[i]=new Pair(wt[i],val[i]);
            }
            Arrays.sort(a);
            double ans=0;
            int i=0;
            double weightleft=w;
            while(weightleft>0&&i<n) {
                if(weightleft>a[i].wt) {
                    ans+=a[i].cost;
                    weightleft=weightleft-a[i].wt;
                }
                else {
                    ans+=(a[i].cost*weightleft*1.0)/a[i].wt;
                    break;
                }
                i++;
            }
            System.out.println((double)Math.round(ans*100)/100);
        }
    }
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     Longest Increasing Subsequence
    // public int lengthOfLIS(int[] nums) { //O(n2) approach
    //     int n=nums.length;
    //     if(n==0) return 0;
    //     int dp[]=new int[n];
    //     Arrays.fill(dp,1);
    //     int max=1;
    //     for(int i=1;i<n;i++) {
    //         for(int j=0;j<i;j++) {
    //             if(nums[i]>nums[j]) {
    //                 dp[i]=Math.max(dp[i],dp[j]+1);
    //                 max=Math.max(max,dp[i]);
    //             }
    //         }
    //     }
    //     return max;
    // }
    public int lengthOfLIS(int[] nums) {  //O(nlogn) approach
        int minval[]=new int[nums.length];
        int ans=0;
        for(int val:nums) {
            int lo=0;
            int hi=ans;
            while(lo<hi) {
                int mid=(lo+hi)/2;
                if(minval[mid]<val) {
                    lo=mid+1;
                }else hi=mid;
            }
            minval[lo]=val;
            if(lo==ans) ans++;
        }
        return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Building bridges
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Russian Doll Envelopes (same question as building bridges)
    static class Pair implements Comparable<Pair>{
        int width;
        int height;
        Pair(int width,int height) {
            this.width=width;
            this.height=height;
        }
        @Override
        public int compareTo(Pair o) {
            if(this.width>o.width) return 1;
            else if(this.width<o.width) return -1;
            else {
                if(this.height>o.height) return -1;
                else return 1;
            }
        }
    }
    public int lis(Pair p[]) {
        int minval[]=new int[p.length];
        int ans=0;
        for(Pair x:p) {
            int val=x.height;
            int lo=0;
            int hi=ans;
            while(lo<hi) {
                int mid=(lo+hi)/2;
                if(minval[mid]<val) {
                    lo=mid+1;
                }else hi=mid;
            }
            minval[lo]=val;
            if(lo==ans) ans++;
        }
        return ans;
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        Pair a[]=new Pair[n];
        for(int i=0;i<n;i++) {
            a[i]=new Pair(envelopes[i][0],envelopes[i][1]);
        }
        Arrays.sort(a);
        return lis(a);
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    box stacking
    static class Pair implements Comparable<Pair>{
        int l;
        int b;
        int h;
        Pair(int l,int b,int h) {
            this.l=l;
            this.b=b;
            this.h=h;
        }
       @Override
        public int compareTo(Pair o) {
            if(this.l>o.l) return 1;
            else if(this.l<o.l) return -1;
            else  {
                if(this.b>o.b) return -1;
                else return 1;
            }
        }
    }
    public static int lis(Pair a[]) {
        int n=a.length;
        int dp[]=new int [n];
        for(int i=0;i<n;i++) {
            dp[i]=a[i].h;
        }
        int max=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
               if(a[i].b>a[j].b) {
                   dp[i]=Math.max(dp[i],a[i].h+dp[j]);
                  // System.out.println(dp[i]);
                   max=Math.max(max,dp[i]);
               }
            }
        }
        return max;
    }
    public static int maxHeight(int height[], int width[], int length[], int n)
   {
       Pair a[]=new Pair[n*3];
       int k=0;
       for(int i=0;i<n;i++) {
           int temp[]=new int[3];
            temp[0]=height[i];
            temp[1]=width[i];
            temp[2]=length[i];
            Arrays.sort(temp);
            a[k++]=new Pair(temp[1],temp[0],temp[2]);
            a[k++]=new Pair(temp[2],temp[0],temp[1]);
            a[k++]=new Pair(temp[2],temp[1],temp[0]);
       }
       Arrays.sort(a);

       return lis(a);
   }
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Minimum number of increasing subsequences
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       int n=s.nextInt();
       int a[]=new int[n];
       for(int i=0;i<n;i++) a[i]=s.nextInt();
       int dp[]=new int[n];
       for(int i=0;i<n;i++) dp[i]=1;
       for(int i=1;i<n;i++) {
          for(int j=0;j<i;j++) {
             if(a[i]<a[j]) {
                dp[i]=Math.max(dp[i],dp[j]+1);
             }
          }
       }
       System.out.println(dp[n-1]);
       s.close();
   }
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Maximum sum alternating subsequence
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       int n=s.nextInt();
       int a[]=new int[n];
       for(int i=0;i<n;i++) a[i]=s.nextInt();
       int inc[]=new int[n];
       int dec[]=new int[n];
       inc[0]=a[0];
       dec[0]=a[0];
       boolean isdec=true;
       for(int i=1;i<n;i++) {
         int count=0;
          if(isdec) {
            for(int j=0;j<i;j++) {
               if(a[i]<a[j]) {
                  dec[i]=Math.max(dec[i],inc[j]+a[i]);
                  count++;
               }  
            } 
          }else {
            for(int j=0;j<i;j++) {
               if(a[i]>a[j]) {
                  inc[i]=Math.max(inc[i],dec[j]+a[i]);
                  count++;
               }  
            }
          }
          if(count>0) isdec=!isdec;
       }
       System.out.println(Math.max(inc[n-1],dec[n-1]));
       s.close();
   }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      Best Time to Buy and Sell Stock
      public int maxProfit(int[] prices) {
        int T_i10=0;
        int T_i11=Integer.MIN_VALUE;
        for(int val:prices) {
            int newT_i10=Math.max(T_i10,T_i11+val);
            int newT_i11=Math.max(T_i11,-val);
            T_i10=newT_i10;
            T_i11=newT_i11;
        }
        return T_i10;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Best Time to Buy and Sell Stock II
    public int maxProfit(int[] prices) {
        int T_ik0=0;
        int T_ik1=Integer.MIN_VALUE;
        for(int val:prices) {
            int temp=T_ik0;
            int newT_ik0=Math.max(T_ik0,T_ik1+val);
            int newT_ik1=Math.max(T_ik1,temp-val);
            T_ik0=newT_ik0;
            T_ik1=newT_ik1;
        }
        return T_ik0;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Best Time to Buy and Sell Stock III
    public int maxProfit(int[] prices) {
        int T_i10=0;
        int T_i20=0;
        int T_i11=Integer.MIN_VALUE;
        int T_i21=Integer.MIN_VALUE;
        for(int val:prices) {
            T_i20=Math.max(T_i20,T_i21+val);
            T_i21=Math.max(T_i21,T_i10-val);
            T_i10=Math.max( T_i10, T_i11+val);
            T_i11=Math.max( T_i11,-val);
        }
        return  T_i20;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Best Time to Buy and Sell Stock with Transaction Fee
    public int maxProfit(int[] prices, int fee) {
         int T_ik0=0;
        int T_ik1=Integer.MIN_VALUE;
        for(int val:prices) {
            int temp=T_ik0;
            int newT_ik0=Math.max(T_ik0,T_ik1+val);
            int newT_ik1=Math.max(T_ik1,temp-val-fee);
            T_ik0=newT_ik0;
            T_ik1=newT_ik1;
        }
        return T_ik0;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Best Time to Buy and Sell Stock with Cooldown
    public int maxProfit(int[] prices) {
        int T_ik0=0;
        int T_ik1=Integer.MIN_VALUE;
        int T_ik0_old=0;
        for(int val:prices) {
            int temp=T_ik0;
            T_ik0=Math.max(T_ik0,T_ik1+val);
            T_ik1=Math.max(T_ik1,T_ik0_old-val);
            T_ik0_old=temp;
        }
        return T_ik0;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Paint fence
    public int numWays(int n, int k) {
        if(k==1&&n>2) return 0;
        if(k==1) return k;
        if(n==1) return k;
        int same=k;
        int diff=k*(k-1);
        for(int i=2;i<n;i++) {
            int temp=same;
            same=diff;
            diff=(temp+diff)*(k-1);
        }
        return diff+same;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Paint house
     public int minCost(int[][] a) {
        int n=a.length;
        if(n==0) return 0;
        for(int i=1;i<n;i++) {
            for(int j=0;j<3;j++) {
                if(j==0) {
                    a[i][j]=Math.min(a[i-1][1],a[i-1][2])+a[i][j];
                }
                else if(j==1) {
                    a[i][j]=Math.min(a[i-1][0],a[i-1][2])+a[i][j];
                }
                else {
                     a[i][j]=Math.min(a[i-1][0],a[i-1][1])+a[i][j];
                }
            }
        }
        return Math.min(a[n-1][0],Math.min(a[n-1][1],a[n-1][2]));
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    paint house II
    public int minCostII(int[][] costs) {
        int min=Integer.MAX_VALUE;
        int secmin=Integer.MAX_VALUE;
        int n=costs.length;
        if(n==0) return 0;
        for(int j=0;j<costs[0].length;j++) {
            if(min>costs[0][j]) {
                secmin=min;
                min=costs[0][j];
            }
            else {
                secmin=Math.min(secmin,costs[0][j]);
            }
        }
        for(int i=1;i<n;i++) {
            int tempmin=Integer.MAX_VALUE;
            int tempsecmin=Integer.MAX_VALUE;
            for(int j=0;j<costs[0].length;j++) {
                if(costs[i-1][j]==min) {
                    costs[i][j]+=secmin;
                    if(tempmin>costs[i][j]) {
                        tempsecmin=tempmin;
                        tempmin=costs[i][j];
                    }else {
                        tempsecmin=Math.min(tempsecmin,costs[i][j]);
                    }
                }else {
                    costs[i][j]+=min;
                    if(tempmin>costs[i][j]) {
                        tempsecmin=tempmin;
                        tempmin=costs[i][j];
                    }else {
                        tempsecmin=Math.min(tempsecmin,costs[i][j]);
                    }
                }
            }
            min=tempmin;
            secmin=tempsecmin;
        }
        return min;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Consecutive 1's not allowed
    static int mod=1000000007;
	public static void main (String[] args) {
	  Scanner s=new Scanner(System.in);
	  int t=s.nextInt();
	  while(t-->0) {
	      int n=s.nextInt();
	      int zero=1;
	      int one=1;
	      if(n==1){
	          System.out.println("2");
	          continue;
	      }
	      for(int i=2;i<=n;i++) {
	          int temp=zero;
	          zero=((zero%mod)+(one%mod))%mod;
	          one=temp;
	      }
	      System.out.println((zero+one)%mod);
	  }
	}
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Unique BST's
	public static void main (String[] args) {
	  Scanner s=new Scanner(System.in);
	  int t=s.nextInt();
	  while(t-->0) {
	      int n=s.nextInt();
	      int c[]=new int[n+1];
	      c[0]=1;
	      c[1]=1;
	      for(int i=2;i<=n;i++) {
	          for(int j=0;j<i;j++) {
	              c[i]+=c[j]*c[i-j-1];
	          }
	      }
	      System.out.println(c[n]);
	  }
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Burst Balloons
    public int maxCoins(int[] nums) {   //memorization
        int a[]=new int[nums.length+2];
        a[0]=1;
        a[a.length-1]=1;
        for(int i=0;i<nums.length;i++) {
            a[i+1]=nums[i];
        }
        return helper(a,0,a.length-1,new int[a.length][a.length]);
    }
    public int helper(int a[],int left,int right,int dp[][]) {
        if(left+1==right) return 0;
        int ans=0;
        if(dp[left][right]!=0)  return dp[left][right];
        for(int i=left+1;i<right;i++) {
            int ans1=helper(a,left,i,dp);
            int ans2=helper(a,i,right,dp);
            int temp=a[left]*a[i]*a[right];
            ans=Math.max(ans,ans1+ans2+temp);
        }
        dp[left][right]=ans;
        return ans;
    }
    //dp solution 
    public int maxCoins(int[] nums) {
        int A[]=new int[nums.length+2];
        A[0]=1;
        A[A.length-1]=1;
        for(int i=0;i<nums.length;i++) {
            A[i+1]=nums[i];
        }
        int n=A.length;
        int dp[][]=new int[n][n];
        for(int gap=2;gap<n;gap++) {
            for(int left=0;left<=n-gap-1;left++) {
                int right=left+gap;
                for(int i=left+1;i<right;i++) {
                    int a=dp[left][i];
                    int b=dp[i][right];
                    dp[left][right]=Math.max(dp[left][right],a+b+A[left]*A[i]*A[right]);
                }
            }
        }
        return dp[0][n-1]; 
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Minimum Score Triangulation of Polygon
    public int minScoreTriangulation(int[] A) {
        int n=A.length;
        if(n==2) return 0;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int gap=2;gap<n;gap++) {
            for(int left=0;left<=n-gap-1;left++) {
                int right=left+gap;
                for(int i=left+1;i<right;i++) {
                    int a=dp[left][i];
                    int b=dp[i][right];
                    if(dp[left][i]==Integer.MAX_VALUE) a=0;
                    if(dp[i][right]==Integer.MAX_VALUE) b=0;
                    dp[left][right]=Math.min(dp[left][right],a+b+A[left]*A[i]*A[right]);
                }
            }
        }
        return dp[0][n-1];
    }
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	boolean parenthesization
	int T[][];
     int F[][];
     public void check(char a,int left,int right,int i) {
         if(a=='|') {
             T[left][right]+=(T[left][i]*F[i+1][right])+(F[left][i]*T[i+1][right])+(T[left][i]*T[i+1][right]);
              F[left][right]+=(F[left][i]*F[i+1][right]);
         }
         else if(a=='&') {
             T[left][right]+=(T[left][i]*T[i+1][right]);
             F[left][right]+=(F[left][i]*T[i+1][right])+(T[left][i]*F[i+1][right])+(F[left][i]*F[i+1][right]);
         }
         else {
               T[left][right]+=(T[left][i]*F[i+1][right])+(F[left][i]*T[i+1][right]);
             F[left][right]+=(T[left][i]*T[i+1][right])+(F[left][i]*F[i+1][right]);
         }
     }
    public int countParenth(char[] symb, char[] oper) {
        int n=symb.length;
        T=new int[n][n];
        F=new int[n][n];
        for(int gap=0;gap<n;gap++) {
            int left = 0, right = gap;
            while(right<n){
                if(left==right){
                    if(symb[left]=='T') {
                       T[left][right]=1;
                       F[left][right]=0;
                    }else {
                       T[left][right]=0;
                       F[left][right]=1;
                    }
                }
                else{
                    for(int i=left;i<right;i++) {
                        check(oper[i],left,right,i);
                    }
                }
                left++; right++;
            }
        }
        return T[0][n-1];
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Minimum and Maximum values of an expression with * and +
    public static void main (String[] args) {
	  Scanner s=new Scanner(System.in);
	  String st=s.next();
	  int size=0;
	  int osize=0;
	  for(int i=0;i<st.length();i++) {
	      if(st.charAt(i)-'0'>=0&&st.charAt(i)-'0'<=9) {
	          size++;
	      }else osize++;
	  }
	  char symb[]=new char[size];
	  char oper[]=new char[osize];
	  int k=0;
	  int l=0;
	  for(int i=0;i<st.length();i++) {
	      if(st.charAt(i)-'0'>=0&&st.charAt(i)-'0'<=9) {
	         symb[k++]=st.charAt(i);
	      }else {
	         oper[l++]=st.charAt(i);
	      }
	  }
	  int n=symb.length;
	  int min[][]=new int[n][n];
	  int max[][]=new int[n][n];
	  for(int i=0;i<n;i++) {
	      for(int j=0;j<n;j++) {
	         min[i][j]=Integer.MAX_VALUE;
	      }
	  }
	  for(int i=0;i<n;i++) {
	      for(int j=0;j<n;j++) {
	         max[i][j]=Integer.MIN_VALUE;
	      }
	  }
	  for(int gap=0;gap<n;gap++) {
	      int left=0;
	      int right=gap;
	      while(right<n) {
	          if(left==right) {
	              min[left][right]=Math.min(symb[left]-'0',min[left][right]);
	              max[left][right]=Math.max(symb[left]-'0',max[left][right]);
	          }else {
	              for(int i=left;i<right;i++) {
	                  if(oper[i]=='+') {
	                      min[left][right]=Math.min(min[left][right],min[left][i]+min[i+1][right]);
	                      max[left][right]=Math.max(max[left][right],max[left][i]+max[i+1][right]);
	                  }else {
	                      min[left][right]=Math.min(min[left][right],min[left][i]*min[i+1][right]);
	                      max[left][right]=Math.max(max[left][right],max[left][i]*max[i+1][right]);
	                  }
	              }
	          }
	          left++;
	          right++;
	      }
	  }
	  System.out.println(min[0][n-1]+" "+max[0][n-1]);
	}
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++
    ugly number
    public static void main (String[] args) {
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
	   while(t-->0) {
	       int n=s.nextInt();
	       long dp[]=new long [n];
	       int i2=0;
	       int i3=0;
	       int i5=0;
	       dp[0]=1;
	       for(int i=1;i<n;i++) {
	          dp[i]=Math.min(dp[i2]*2,Math.min(dp[i3]*3,dp[i5]*5));
	          if(dp[i]==dp[i2]*2) {
	              i2++;
	          }
	          if(dp[i]==dp[i3]*3) {
	              i3++;
	          }
	           if(dp[i]==dp[i5]*5) {
	              i5++;
	          }
	       }
	       System.out.println(dp[n-1]);
	   }
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    super ugly number
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       int n=s.nextInt();
       int arr[]=new int[n];
       Arrays.fill(arr,Integer.MAX_VALUE);
       arr[0]=1;
       int prime[]={2,3,5};
       int index[]=new int[prime.length];
       for(int i=1;i<n;i++) {
          for(int j=0;j<prime.length;j++) {
             arr[i]=Math.min(arr[i],arr[index[j]]*prime[j]);
          }
          for(int j=0;j<index.length;j++) {
           if(arr[index[j]]*prime[j]==arr[i]) {
                index[j]++;
           }
         }
       }
       System.out.println(arr[n-1]);
       s.close();
   }
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     Friends Pairing Problem
   	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int mod=1000000007;
		while(t-->0) {
		    int n=s.nextInt();
		    long dp[]=new long[n+1];
		    dp[1]=1;
		    dp[2]=2;
		    for(int i=3;i<=n;i++) {
		        dp[i]=(dp[i-1]%mod+((i-1)*(dp[i-2]%mod))%mod)%mod;
		    }
		    System.out.println(dp[n]%mod);
		}
	}
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Cherry Pickup
    public int cherryPickup(int[][] grid) {
         int n=grid.length;
        int ans= cherry(grid,0,0,0,new int[n][n][n]);
        if(ans<0) return 0;
        return ans;
    }
    public int cherry(int [][]grid,int r1,int c1,int r2,int dp[][][]) {
        int n=grid.length;
        int m=grid[0].length;
        int c2=r1+c1-r2;
        if(r1>=n||r2>=n||c1>=m||c2>=m||grid[r1][c1]==-1||grid[r2][c2]==-1) return Integer.MIN_VALUE;
        if(r1==n-1&&c1==m-1) return grid[r1][c1];
        if(r2==n-1&&c2==m-1) return grid[r2][c2];
        if(dp[r1][c1][r2]!=0) return dp[r1][c1][r2];
        int ans=0;
        ans+=grid[r1][c1];
        if(r1!=r2||c1!=c2) ans+=grid[r2][c2];
        int temp1=cherry(grid,r1,c1+1,r2+1,dp);
        int temp2=cherry(grid,r1+1,c1,r2,dp);
        int temp3=cherry(grid,r1+1,c1,r2+1,dp);
        int temp4=cherry(grid,r1,c1+1,r2,dp);
        ans+=Math.max(temp1,Math.max(temp2,Math.max(temp3,temp4)));
        dp[r1][c1][r2]=ans;
        return ans;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Longest Common Subsequence
     public int longestCommonSubsequence(String text1, String text2) {
       int dp[][]=new int[text1.length()+1][text2.length()+1];
      for(int i=text1.length()-1;i>=0;i--){
          for(int j=text2.length()-1;j>=0;j--) {
              if(text1.charAt(i)==text2.charAt(j)) {
                  dp[i][j]=1+dp[i+1][j+1];
              }
              else {
                  dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j]);
              }
          }
      }
        return dp[0][0];
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    LCS of three strings
    public static void main (String[] args) {
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
	   while(t-->0) {
          int a=s.nextInt();
          int b=s.nextInt();
          int c=s.nextInt();
	       String s1[]=new String[3];
	       s1[0]=s.next();
	       s1[1]=s.next();
	       s1[2]=s.next();
	       //System.out.println(s1[0]+" "+s1[1]+" "+s1[2]);
	      int dp[][][]=new int[a+1][b+1][c+1];
	      for(int i=s1[0].length()-1;i>=0;i--) {
	          for(int j=s1[1].length()-1;j>=0;j--) {
	              for(int k=s1[2].length()-1;k>=0;k--) {
	                  if(s1[0].charAt(i)==s1[1].charAt(j)&&s1[1].charAt(j)==s1[2].charAt(k)){
	                      dp[i][j][k]=1+dp[i+1][j+1][k+1];
	                  }
	                  else{
	                      dp[i][j][k]=Math.max(dp[i+1][j][k],Math.max(dp[i][j+1][k],dp[i][j][k+1]));
	                  }
	              }
	          }
	      }
	      System.out.println(dp[0][0][0]);
      }
      s.close();
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Longest Palindromic Subsequence
    public int longestCommonSubsequence(String text1, String text2) {
       int dp[][]=new int[text1.length()+1][text2.length()+1];
      for(int i=text1.length()-1;i>=0;i--){
          for(int j=text2.length()-1;j>=0;j--) {
              if(text1.charAt(i)==text2.charAt(j)) {
                  dp[i][j]=1+dp[i+1][j+1];
              }
              else {
                  dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j]);
              }
          }
      }
        return dp[0][0];
    }
    public int longestPalindromeSubseq(String s) {
        String s2="";
        for(int i=s.length()-1;i>=0;i--) s2+=s.charAt(i);
        return longestCommonSubsequence(s,s2);
        
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Egg dropping
    public static void main (String[] args) {
	   Scanner s=new Scanner(System.in);
      int e=s.nextInt();
      int f=s.nextInt();
      int dp[][]=new int[e+1][f+1];
      for(int eggs=1;eggs<=e;eggs++) {
         for(int floor=1;floor<=f;floor++) {
            if(floor==1) {
               dp[eggs][floor]=1;
            }
            else if(eggs==1) {
               dp[eggs][floor]=floor;
            }
            else {
               int min=Integer.MAX_VALUE;
               for(int k=1;k<=floor;k++) {
                  int eggbreak=dp[eggs-1][k-1];
                  int eggsurvive=dp[eggs][floor-k];
                  if(Math.max(eggbreak,eggsurvive)<min) {
                     min=Math.max(eggbreak,eggsurvive);
                  }
               }
               dp[eggs][floor]=min+1;
            }
         }

      }
      System.out.println(dp[e][f]);
      s.close();
	}
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Edit distance
    public int minDistance(String s, String t) {
        int m = s.length();
		int n = t.length();
		int storage[][] = new int[ m + 1][n + 1];
		for(int j = 0; j <n; j++){
			storage[m][j] =n-j;
		}
		for(int i = 0; i <m; i++){
			storage[i][n] = m-i;
		}
		
		for(int i = m-1; i >= 0; i--){
			for(int j = n-1; j >= 0; j--){
				if(s.charAt(i) == t.charAt(j)){
					storage[i][j] = storage[i+1][j+1];
				}else{
					storage[i][j] = 1 + Math.min(storage[i][j+1], 
							Math.min(storage[i+1][j], storage[i+1][j+1]));
				}
			}
		}
        
		return storage[0][0];
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    2 Keys Keyboard
    public void seive() {
        int max=1001;
        boolean prime[]=new boolean[max];
        for(int i=2;i*i<max;i++) {
            if(!prime[i]) {
                for(int j=i*i;j<max;j+=i) prime[j]=true;
            }
        }
        list=new ArrayList<>();
        list.add(2);
        for(int i=3;i<max;i+=2) {
            if(!prime[i]) list.add(i);
        }
    }
    ArrayList<Integer> list;
    public int minSteps(int n) {
        seive();
        int ans=0;
        while(n>1) {
            for(int i=0;i<list.size();i++) {
                if(n%list.get(i)==0) {
                    ans+=list.get(i);
                    n/=list.get(i);
                    break;
                }
            }
        }
        return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Count All Palindromic Subsequence in a given String
    public  static int countpalindromicsubsequence(String s) {
		int n=s.length();
		int dp[][]=new int[n+1][n+1];
		for(int i=0;i<n;i++) {
         dp[i][i]=1;
		}
		for(int gap=2;gap<=n;gap++) {
			for(int i=0;i<=n-gap;i++) {
				int j=i+gap-1;
				if(s.charAt(i)==s.charAt(j)) {
					dp[i][j]=dp[i+1][j]+dp[i][j-1]+1;
				}else {
					dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
				}
			}
		}
		return dp[0][n-1];
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Count Different Palindromic Subsequences
    public int countPalindromicSubsequences(String s) {
        int mod=1000000007;
        int n=s.length();
		long dp[][]=new long[n+1][n+1];
		for(int i=0;i<n;i++) {
         dp[i][i]=1;
		}
		for(int gap=2;gap<=n;gap++) {
			for(int i=0;i<=n-gap;i++) {
				int j=i+gap-1;
				if(s.charAt(i)==s.charAt(j)) {
					int ni =i+1;
                    int nj =j-1;
                    while(ni<j&&s.charAt(i)!=s.charAt(ni)) {
                        ni++;
                    }
                    while(nj>i&&s.charAt(j)!=s.charAt(nj)) {
                        nj--;
                    }
                    if(ni>nj) {
                        //System.out.println("no");
                        dp[i][j] = (2*dp[i+1][j-1])%mod + 2;
                    }
                    else if(ni==nj&&s.charAt(i)==s.charAt(ni)) {
                        //System.out.println("one");
                        dp[i][j] = (2*dp[i+1][j-1])%mod + 1;
                    }else {
                        //System.out.println("multiple");
                        dp[i][j] = ((2*dp[i+1][j-1])%mod - dp[ni+1][nj-1]+mod)%mod;
                    }
				}else {
					dp[i][j] = ((dp[i+1][j] + dp[i][j-1])%mod - 
                                    dp[i+1][j-1]+mod)%mod;
				}
                dp[i][j]=dp[i][j]%mod;
			}
		}
		return (int)dp[0][n-1]%mod;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Count subsequences of type a^i b^j c^k 
    static int f(String s) {
		int n = s.length();
		int aCount = 0, bCount = 0, cCount = 0;
		for(int i=0; i<n; i++) {
			char c = s.charAt(i);
			if(c=='a') {
				aCount = 1 + 2*aCount;
			} else if(c=='b') {
				bCount = aCount + 2*bCount;
			} else if(c=='c') {
				cCount = bCount + 2*cCount;
			}
		}
		return cCount;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Highway Billboard Problem
    public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		int n=s.nextInt();
		int x[]=new int[n];
		for(int i=0;i<n;i++) x[i]=s.nextInt();
		int rev[]=new int[n];
		for(int i=0;i<n;i++) rev[i]=s.nextInt();
		int dp[]=new int[m+1];
		int t=s.nextInt();
		int j=0;
		for(int i=1;i<=m;i++) {
			if(j<n) {
				if(x[j]!=i) {
					dp[i]=dp[i-1];
				}else {
					if(i<=t) {
						dp[i]=Math.max(dp[i-1],rev[j]);
					}else dp[i]=Math.max(dp[i-t-1]+rev[j],dp[i-1]);
	
					j++;
				}
			}
			else {
				dp[i]=dp[i-1];
			}
            
		}
		System.out.println(dp[m]);
		s.close();
	}
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Frog Jump
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
         int n=stones.length;
        for(int i=0;i<n;i++) {
            map.put(stones[i],new HashSet<Integer>());
        }
        HashSet<Integer> temp=map.get(0);
        temp.add(1);
        for(int i=0;i<n;i++) {
            HashSet<Integer> set=map.get(stones[i]);
            for(int jump:set) {
                int nextspot=jump+stones[i];
                if(nextspot==stones[n-1]) return true;
                if(map.containsKey(nextspot)) {
                     HashSet<Integer> temp2=map.get(nextspot);
                    if(jump-1>0) {
                       temp2.add(jump-1);
                    }
                     temp2.add(jump);
                     temp2.add(jump+1);
                }
               
            }
        }
        return false;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Wildcard Matching
    public boolean isMatch(String s, String p) {

		int n = s.length(), m = p.length();

		boolean dp[][] = new boolean[n + 1][m + 1];

		dp[0][0] = true;
		boolean seen = false;
		for (int i = 1; i <= m; i++) {
			if(p.charAt(i - 1) == '*' && ! seen) {
				dp[0][i] = true;
			}else {
				dp[0][i] = false;
				seen = true;
			}
		}	

		for (int i = 1; i <= n; i++)
			dp[i][0] = false;

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= m; j++) {

				if (s.charAt(i - 1) == p.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}

			}
			
		}
		return dp[n][m];
	
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    KMP 
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
			String str=s.next();
			String pat=s.next();
             String st=pat+'#'+str;
             int lps[]=new int[st.length()];
             int i=1;
             int len=0;
             while(i<st.length()) {
             	if(st.charAt(i)==st.charAt(len)) {
             		len++;
             		lps[i]=len;
             		i++;
             	}
             	else {
             		if(len>0) {
             			len=lps[len-1];
             		}
             		else {
             			lps[i]=0;
             			i++;
             		}
             	}
             }
             int count=0;
             ArrayList<Integer> l=new ArrayList<>();
             for(i=pat.length()+1;i<st.length();i++) {
             	if(lps[i]==pat.length()) {
             		count++;
             		l.add(i-pat.length());
             	}
             }
             if(count>0) System.out.println(count);
             else System.out.println("Not Found");
             for(int j:l) {
             	System.out.println(j-pat.length()+1+" ");
             }
             System.out.println();
		}
		s.close();
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Shortest Palindrome
    public int[] lps(String s) {
        int ans[]=new int[s.length()];
        int i=1;
        int len=0;
        while(i<s.length()) {
            if(s.charAt(i)==s.charAt(len)) {
                len++;
                ans[i]=len;
                i++;
            }else {
                if(len>0) {
                    len=ans[len-1];
                }else {
                    ans[i]=0;
                    i++;
                }
            }
        }
        return ans;
    }
    public String shortestPalindrome(String s) {
        String str=s+'#';
        String temp="";
        for(int i=s.length()-1;i>=0;i--) {
            temp+=s.charAt(i);
        }
        str+=temp;
        int a[]=lps(str);
        int ans=a[str.length()-1];
        String st= s.substring(ans);
        String reverse="";
        for(int i=st.length()-1;i>=0;i--) {
            reverse+=st.charAt(i);
        }
         return reverse+s;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    z algo
    public static int[] Zalgo(String st) {
        int n=st.length();
        int z[]=new int[n];
        int l=0;
        int r=0;
        for(int i=1;i<n;i++) {
            if(i<=r) {
                z[i]=Math.min(z[0+i-l],r-i+1);
            }
            while(i+z[i]<n&&st.charAt(z[i])==st.charAt(i+z[i])) {
                z[i]++;
            }
            if(i+z[i]-1>r) {
                l=i;
                r=i+z[i]-1;
            }
        }
        return z;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Chef and Secret Password
    class Codechef
{    public static int[] Zalgo(String st) {
        int n=st.length();
        int z[]=new int[n];
        int l=0;
        int r=0;
        for(int i=1;i<n;i++) {
            if(i<=r) {
                z[i]=Math.min(z[0+i-l],r-i+1);
            }
            while(i+z[i]<n&&st.charAt(z[i])==st.charAt(i+z[i])) {
                z[i]++;
            }
            if(i+z[i]-1>r) {
                l=i;
                r=i+z[i]-1;
            }
        }
        return z;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int size=s.nextInt();
		    String st=s.next();
		    int z[]=Zalgo(st);
		    int min=Integer.MAX_VALUE;
		    int index=-1;
		    for(int i=1;i<z.length;i++) {
		        if(min>z[i]&&z[i]!=0) {
		            min=z[i];
		            index=i;
		        }
		    }
		    if(min==Integer.MAX_VALUE) {
		        System.out.println(st);
		        continue;
		    }
		    System.out.println(st.substring(index,index+min));
		}
	}
}
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Manacher’s Algorithm
public static int[] Manacher(String st) {
        int n=st.length();
        int p[]=new int[n];
        int r=0;
        int c=0;
        int l=0;
        for(int i=1;i<n;i++) {
            int idash=2*c-i;
            if(i<r) {
                p[i]=Math.min(p[idash],r-i);
            }
            while(i+(1+p[i])<n&&i-(1+p[i])>=0&&st.charAt(i+(1+p[i]))==st.charAt(i-(1-p[i]))) {
                p[i]++;
            }
            if(i+p[i]>r) {
                c=i;
                l=i-p[i];
                r=i+p[i];
            }
        }
        return p;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Tri Tiling
    public static int tiling(int n) {
        int dp[][]=new int[8][n];
        dp[0][0]=1;
        dp[3][0]=1;
        dp[6][0]=1;
        for(int i=1;i<n;i++) {
            for(int j=0;j<8;j++) {
                if(j==0) {
                    dp[0][i]+=dp[7][i-1];
                }else if(j==1) {
                    dp[1][i]+=dp[6][i-1];
                }
                else if(j==2) {
                    dp[2][i]+=dp[5][i-1];
                }
                else if(j==3) {
                    dp[3][i]+=dp[7][i-1];
                    dp[3][i]+=dp[4][i-1];
                }
                else if(j==4) {
                    dp[4][i]+=dp[3][i-1];
                }
                else if(j==5) {
                    dp[5][i]+=dp[2][i-1];
                }
                else if(j==6) {
                    dp[6][i]+=dp[7][i-1];
                    dp[6][i]+=dp[1][i-1];
                }
                else if(j==7) {
                    dp[7][i]+=dp[0][i-1];
                    dp[7][i]+=dp[3][i-1];
                    dp[7][i]+=dp[6][i-1];
                }
                
            }
            
        }
        return dp[7][n-1];
    }
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        while(n!=-1) {
            if(n==0) {
                System.out.println("1");
            }else {
                System.out.println(tiling(n));
            }
            n=s.nextInt();
        }
        s.close();
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Scramble String
    public boolean isScramble(String s1, String s2) {
       map=new HashMap<>();
       if(s1.length()!=s2.length()) return false;
       return helper(s1,s2);
    }
    HashMap<String,Boolean> map;
    public boolean helper(String s1, String s2) {
        String key=s1+'*'+s2;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        if(s1.equals(s2)){
             map.put(key,true);
            return true;
        } 
        int n=s1.length();
        int fmap1[]=new int[256];
        int fmap2[]=new int[256];
        for(int i=0;i<n;i++) {
            fmap1[s1.charAt(i)-'a']++;
            fmap2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<256;i++) {
            if(fmap1[i]!=fmap2[i]){
                map.put(key,false);
                return false;
            }
        }
        for(int i=1;i<n;i++) { 
            if(helper(s1.substring(0,i),s2.substring(0,i))&&helper(s1.substring(i),s2.substring(i))) {
                 map.put(key,true);
                  return true;
            }
            if(helper(s1.substring(0,i),s2.substring(n-i))&&helper(s1.substring(i),s2.substring(0,n-i))) {
                 map.put(key,true);
                  return true;
            }
        }
        map.put(key,false);
        return false;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Coin Change
    public int coinChange(int[] coins, int amount) {
       int dp[]=new int[amount+1];
        Arrays.fill(dp,1000000000);
       dp[0]=0;
       for(int amt=1;amt<=amount;amt++) {
           for(int coin:coins) {
               if(coin<=amt) {
                   int remamount=amt-coin;
                    dp[amt]=Math.min(dp[amt],dp[remamount]+1);
               }
           }
       }
        if(dp[amount]==1000000000) return -1;
        return dp[amount];
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Coin Change 2
    public int change(int amount, int[] coins) {
        int dp[]=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++) {
            for(int j=coins[i];j<dp.length;j++) {
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Unbounded Knapsack
    public static void main (String[] args) {
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
	   while(t-->0) {
	       int n=s.nextInt();
	       int maxweight=s.nextInt();
	       int wt[]=new int[n];
	       int val[]=new int[n];
	       for(int i=0;i<n;i++) val[i]=s.nextInt();
	       for(int i=0;i<n;i++) wt[i]=s.nextInt();
	       int dp[]=new int[maxweight+1];
	       for(int i=1;i<=maxweight;i++) {
	           for(int j=0;j<n;j++) {
	               if(wt[j]<=i) {
	                   int rem=i-wt[j];
	                   dp[i]=Math.max(dp[i],dp[rem]+val[j]);
	               }
	           }
	       }
	       System.out.println(dp[maxweight]);
	   }
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++
     */
}
