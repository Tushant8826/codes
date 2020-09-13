public class hashmapandheap {
    /*
	  +++++++++++++++++++++++++++++++++++++++++++++++++
	  Rabbits in Forest
	  public int numRabbits(int[] a) {
        int n=a.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
          if(map.containsKey(a[i])) {
             map.put(a[i],map.get(a[i])+1);
          }
          else map.put(a[i],1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer> hi:map.entrySet()) {
            int grpsize=hi.getKey()+1;
           int grpcount=(int) Math.ceil((hi.getValue()*1.0)/grpsize);
            ans+=grpcount*grpsize;
        }
        return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    consecutiveOnes
    public static int consecutiveOnes(int[] a) {
        int n=a.length;
        int curr=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
          if(a[i]==1) curr++;
          else if(a[i]==0) curr=0;
          max=Math.max(max,curr);
        }
        return curr;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Subarray Sum Equals K
    public int subarraySum(int[] nums, int k) {
      HashMap<Integer,Integer> map=new HashMap<>();
      int n=nums.length;
      int pre[]=new int[n];
      pre[0]=nums[0];
      for(int i=1;i<n;i++) {
          pre[i]=pre[i-1]+nums[i];
      }
      map.put(0,1);
      int ans=0;

      for(int i=0;i<n;i++) {
         int prev=pre[i]-k;
         if(map.containsKey(prev)) {
             ans+=map.get(prev);
         }
          if(map.containsKey(pre[i])) {
              map.put(pre[i],map.get(pre[i])+1);
          }else {
              map.put(pre[i],1);
          }
      }
      return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++
    Sub-Array sum divisible by K
    public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    int k=s.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=s.nextInt();
		    //int k=s.nextInt();
		    HashMap<Integer,Integer> map=new HashMap<>();
              int pre[]=new int[n];
              pre[0]=a[0];
              for(int i=1;i<n;i++) {
                  pre[i]=pre[i-1]+a[i];
              }
              for(int i=0;i<n;i++) {
                  if(pre[i]<0){
                      pre[i]=pre[i]*-1;
                      pre[i]=pre[i]%k;
                      pre[i]=pre[i]*-1;
                      pre[i]=pre[i]+k;
                  }
                  pre[i]=pre[i]%k;
              }
//              for(int i=0;i<n;i++) {
//                  System.out.print(pre[i]+" ");
//              }
              System.out.println();
              map.put(0,1);
              int ans=0;
              for(int i=0;i<n;i++) {
                 int prev=pre[i];
                 if(map.containsKey(prev)) {
                     ans+=map.get(prev);
                 }
                  if(map.containsKey(pre[i])) {
                      map.put(pre[i],map.get(pre[i])+1);
                  }else {
                      map.put(pre[i],1);
                  }
              }
              System.out.println(ans);
		}
    }
    +++++++++++++++++++++++++++++++++++++++++++++
    K Closest Points to Origin
    class Solution {
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        double dis;
        Pair(int x,int y,double dis) {
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
        @Override 
        public int compareTo(Pair o) {
            if(this.dis<o.dis) return 1;
            else return -1;
        }
        
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> q=new PriorityQueue<>();
        int j=0;
        for(int i=0;i<K;i++) {
            double temp=points[j][0]*points[j][0]*1.0;
            double temp2=points[j][1]*points[j][1]*1.0;
            temp=Math.sqrt(temp+temp2);
            q.add(new Pair(points[j][0],points[j][1],temp));
            j++;
        }
        while(j<points.length) {
            double temp=points[j][0]*points[j][0]*1.0;
            double temp2=points[j][1]*points[j][1]*1.0;
            temp=Math.sqrt(temp+temp2);
            if(q.size()!=K) {
                q.add(new Pair(points[j][0],points[j][1],temp)); 
            }else {
               if(temp<q.peek().dis) {
                  q.poll();
                  q.add(new Pair(points[j][0],points[j][1],temp)); 
               } 
            }
            j++;
        }
        int ans[][]=new int[K][2];
        j=0;
        while(!q.isEmpty()) {
            Pair p=q.poll();
            ans[j][0]=p.x;
            ans[j][1]=p.y;
            j++;
        }
        return ans;
    }
}
	+++++++++++++++++++++++++++++++++++++++++++++
	Subarrays with equal 1s and 0s
	public static void main (String[] args) {
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
	   while(t-->0) {
	    int n=s.nextInt();
	    int a[]=new int[n];
	    for(int i=0;i<n;i++) a[i]=s.nextInt();
	    int prez[]=new int[n];
	    int preo[]=new int[n];
	    if(a[0]==0) prez[0]=1;
	    else preo[0]=1;
	    for(int i=1;i<n;i++) {
	        if(a[i]==0) {
	          prez[i]=prez[i-1]+1;
	          preo[i]=preo[i-1];
	        }
	        else {
	          prez[i]=prez[i-1];
	          preo[i]=preo[i-1]+1;
	        }
	    }

	    int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++) {
           int temp=prez[i]-preo[i];
           if(map.containsKey(temp)) {
              ans+=map.get(temp);
             map.put(temp,map.get(temp)+1);
           }
           else map.put(temp,1);
        }
        System.out.println(ans);
	   }
	}
	+++++++++++++++++++++++++++++++++++++++++++++
	Equal 0, 1 and 2
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
		    String s=sc.next();
		    int n=s.length();
		    int zero=0;
		    int one=0;
		    int two=0;
		    HashMap<String,Integer> map=new HashMap<>();
		    int ans=0;
		    map.put("0*0",1);
		    for(int i=0;i<n;i++) {
		        String str2="";
		        if(s.charAt(i)=='0') zero++;
		        else if(s.charAt(i)=='1') one++;
		        else two++;
		        int temp=zero-one;
		        int temp2=zero-two;
		        str2+=temp+"*"+(temp2);
		        //System.out.println(str2);
		        if(map.containsKey(str2)) {
		            ans+=map.get(str2);
		            map.put(str2,map.get(str2)+1);
		        }
		        else {
		            map.put(str2,1);
		        }
		    }
		    System.out.println(ans);
		}
	}
	+++++++++++++++++++++++++++++++++++++++++++++
	public int minRefuelStops(int target, int startfuel, int[][] stations) {
        int n=stations.length;
         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans=0;
        for(int i=0;i<n;i++) {
            while(startfuel<stations[i][0]&&startfuel<target&&!pq.isEmpty()) {
                    int max=pq.poll();
                    startfuel+=max;
                    ans++;
                }
            if(startfuel>=stations[i][0]) {
                pq.add(stations[i][1]);
            }
        }
        while(startfuel<target&&!pq.isEmpty()) {
             int max=pq.poll();
             startfuel+=max;
             ans++;
        }
        if(startfuel<target) return -1;
        return ans;
    }
    +++++++++++++++++++++++++++++++++++++++++++++
    Check Arithmetic Progression
    	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    //int a[]=new int[n];
		    PriorityQueue<Integer> q=new PriorityQueue<>();
		    for(int i=0;i<n;i++) {
		        int x=s.nextInt();
		        q.add(x);
		    }
		    int min=q.poll();
		    int secmin=0;
		    if(!q.isEmpty())  secmin=q.poll();
		    int d=secmin-min;
		    int prev=secmin;
		    boolean ans=false;
		    while(!q.isEmpty()) {
		        int top=q.poll();
		        if(top-prev!=d) {
		            ans=true;
		            break;
		        }
		        prev=top;
		    }
		    if(ans) System.out.println("NO");
		    else System.out.println("YES");

		}
    }
    ++++++++++++++++++++++++++++++++++++++++++++
    X of a Kind in a Deck of Cards
    public int gcd(int a,int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<deck.length;i++) {
            if(map.containsKey(deck[i])) {
                map.put(deck[i],map.get(deck[i])+1);
            }else {
                map.put(deck[i],1);
            }
        }
        ArrayList<Integer> li=new ArrayList<>(map.keySet());
        if(li.size()==1&&map.get(li.get(0))>=2) return true;
        if(li.size()==1&&map.get(li.get(0))<2) return false;
        int gc=gcd(map.get(li.get(0)),map.get(li.get(1)));
        for(int i=2;i<li.size();i++) {
           gc=gcd(gc,map.get(li.get(i)));
        }
        if(gc>=2) return true;
        return false;
        
    }
	++++++++++++++++++++++++++++++++++++++++++++
	Array of Doubled Pairs
	public boolean canReorderDoubled(int[] A) {
       Arrays.sort(A);
       int n=A.length;
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<n;i++) {
           if(map.containsKey(A[i])) map.put(A[i],map.get(A[i])+1);
           else map.put(A[i],1);
       }
       for(int i=0;i<n;i++) {
            if(map.get(A[i])==0) continue;
           if(A[i]<0) { 
               if(map.containsKey(A[i]/2)&&map.get(A[i]/2)>0) {
                   map.put(A[i],map.get(A[i])-1);
                   map.put(A[i]/2,map.get(A[i]/2)-1);
               }else return false;
           }else {
              if(map.containsKey(A[i]*2)&&map.get(A[i]*2)>0) {
                    map.put(A[i],map.get(A[i])-1);
                   map.put(A[i]*2,map.get(A[i]*2)-1);
               }else return false; 
           }
       }
        return true;
    }
    +++++++++++++++++++++++++++++++++++++++++++++
    Morning Assembly
    public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) {
		        a[i]=s.nextInt();
		    }
		    //longest common sub sequence in o(n)
		    HashMap<Integer,Integer> map=new HashMap<>();
		    int len=Integer.MIN_VALUE;
		    for(int i=0;i<n;i++) {
		        if(map.containsKey(a[i]-1)) {
		            map.put(a[i],map.get(a[i]-1)+1);
		            len=Math.max(len,map.get(a[i]));
		        }else{
		             len=Math.max(len,1);
		             map.put(a[i],1);
		        } 
		    }
		    System.out.println(n-len);
		    
		}
    }
    +++++++++++++++++++++++++++++++++++++++++++++
    Longest Consecutive Sequence
    public int longestConsecutive(int[] nums) {
        //if(nums.length==0) return 0;
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int i:nums) {
            map.put(i,true);
        }
        for(int i:nums) {
            if(map.containsKey(i-1)) map.put(i,false); 
        }
        int len=0;
        for(int i:nums) {
             int t=1;
            if(map.get(i)) {
                while(map.containsKey(i+t)) {
                    t++;
                }
                len=Math.max(len,t);
            }
        }
        return len;
    }
    +++++++++++++++++++++++++++++++++++++++++++++
    Brick Wall
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map=new HashMap<>();
         int max=0;
        for(List<Integer> li:wall) {
             int sum=0;
            for(int i=0;i<li.size()-1;i++) {
                sum+=li.get(i);
                if(map.containsKey(sum)) {
                    map.put(sum,map.get(sum)+1);
                    max=Math.max(max,map.get(sum));
                }else {
                    map.put(sum,1);
                    max=Math.max(max,1);
                }
            }
        }
        return wall.size()-max;
    }
    ++++++++++++++++++++++++++++++++++++++++++++
    Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
       int len=s.length();
       HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
       for(int i=0;i<len;i++) {
           if(map.containsKey(s.charAt(i))) {
               if(map.get(s.charAt(i))!=t.charAt(i)) return false;
           }
           else {
               if(!set.contains(t.charAt(i))){
                   map.put(s.charAt(i),t.charAt(i));
                   set.add(t.charAt(i));
               } else return false;


           }
       }
        return true;
    }
	+++++++++++++++++++++++++++++++++++++++++++++
	Grid Illumination
	public void remove(int x,int y){
                lampset.remove(x*n+y);
                if(row.get(x)==1) row.remove(x);
                else row.put(x,row.get(x)-1);
                if(col.get(y)==1) col.remove(y);
                else col.put(y,col.get(y)-1);
                if(d1.get(x-y)==1) d1.remove(x-y);
                else d1.put(x-y,d1.get(x-y)-1);
                if(d2.get(x+y)==1) d2.remove(x+y);
                else d2.put(x+y,d2.get(x+y)-1);
    }
    public void removeset(int x,int y){
        if (x+1<n&&lampset.contains((x + 1) * n + y)) {
			remove(x + 1, y);
		}
		if (x-1>=0&&lampset.contains((x - 1) * n + y)) {
			remove(x - 1, y);
		}
		if (y-1>=0&&lampset.contains((x) * n + (y - 1))) {
			remove(x, y - 1);
		}
		if (y+1<n&&lampset.contains((x) * n + (y + 1))) {
			remove(x, y + 1);
		}
		if (x-1>=0&&y-1>=0&&lampset.contains((x - 1) * n + (y - 1))) {
			remove(x - 1, y - 1);
		}
		if (x+1<n&&y-1>=0&&lampset.contains((x + 1) * n + (y - 1))) {
			remove(x + 1, y - 1);
		}
		if (x-1>=0&&y+1<n&&lampset.contains((x - 1) * n + (y + 1))) {
			remove(x - 1, y + 1);
		}
		if (x+1<n&&y+1<n&&lampset.contains((x + 1) * n + (y + 1))) {
			remove(x + 1, y + 1);
		}
    }
        int n;
        HashSet<Integer> lampset;
        HashMap<Integer,Integer> row;
        HashMap<Integer,Integer> col;
        HashMap<Integer,Integer> d1; //TopLeft to BottomRight
        HashMap<Integer,Integer> d2;  //topright to bottomleft
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        n=N;
        lampset=new HashSet<>();
        row=new HashMap<>();
        col=new HashMap<>();
        d1=new HashMap<>(); //TopLeft to BottomRight
        d2=new HashMap<>();  //topright to bottomleft
        int len=lamps.length;
        for(int i=0;i<len;i++) {
            int x=lamps[i][0];
            int y=lamps[i][1];
            int no=x*N+y;
            lampset.add(no);
            if(row.containsKey(x)) {
                row.put(x,row.get(x)+1);
            }else row.put(x,1);
            if(col.containsKey(y)) {
                col.put(y,col.get(y)+1);
            }else col.put(y,1);
            if(d2.containsKey(x+y)) {
                d2.put(x+y,d2.get(x+y)+1);
            }else d2.put(x+y,1);
            if(d1.containsKey(x-y)) {
                d1.put(x-y,d1.get(x-y)+1);
            }else d1.put(x-y,1);
        }
        len=queries.length;
        int a[]=new int[len];
        for(int i=0;i<len;i++) {
            int x=queries[i][0];
            int y=queries[i][1];
            if(lampset.contains(x*N+y)) {
                a[i]=1;
                 removeset(x,y);
                 remove(x,y);
            }
            else if(row.containsKey(x)||col.containsKey(y)||d2.containsKey(x+y)||d1.containsKey(x-y)) {
                a[i]=1;
                removeset(x,y);
            }else a[i]=0;
        }
        return a;
    }
	+++++++++++++++++++++++++++++++++++++++++++++
	Rearrange characters
	static class Pair implements Comparable<Pair>{
        char ch;
        int count;
        Pair(char ch,int count){
            this.ch=ch;
            this.count=count;
        }
        @Override
        public int compareTo(Pair o) {
            return this.count-o.count;
        }
    }
    public static int f(String s,int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else map.put(s.charAt(i),1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Character,Integer> hi:map.entrySet()) {
            pq.add(new Pair(hi.getKey(),hi.getValue()));
        }
        Queue<Pair> q=new LinkedList<>();
        String str="";
        for(int i=0;i<k;i++) {
            Pair p=pq.poll();
            str+=p.ch;
            p.count=p.count-1;
            q.add(p);
        }
        while(!pq.isEmpty()) {
            Pair front=pq.poll();
            str+= front.ch;
            front.count=front.count-1;
            if(!q.isEmpty()) pq.add(q.poll());
            if(front.count!=0) q.add(front);
        }
        if(!q.isEmpty()) {
            Pair p=q.poll();
            if(p.count>0) return 0;
            return 1;
        }

        return 1;
    }
    public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        int t=Integer.parseInt(s.nextLine());
        while(t-->0) {
            //System.out.println("hello");
            String str=s.nextLine();
            System.out.println(f(str,1));
        }
    }
	+++++++++++++++++++++++++++++++++++++++++++++
	Island Perimeter
	public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++) {

            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    int count=0;
                    if(i-1>=0&&grid[i-1][j]==1) {
                        count++;
                    }
                    if(i+1<n&&grid[i+1][j]==1) {
                        count++;
                    }
                    if(j-1>=0&&grid[i][j-1]==1) {
                        count++;
                    }
                    if(j+1<m&&grid[i][j+1]==1) {
                        count++;
                    }
                    ans+=4-count;
                }
            }
        }
        return ans;
    }
    +++++++++++++++++++++++++++++++++++++++++++++
    Maximum Frequency Stack
    class FreqStack {
    HashMap<Integer,Stack<Integer>> freq;
    HashMap<Integer,Integer> val;
    int max=0;
    public FreqStack() {
        freq=new HashMap<>();
        val=new HashMap<>();
    }
    public void push(int x) {
        if(val.containsKey(x)) {
            int temp=val.get(x)+1;
            max=Math.max(max,temp);
            val.put(x,temp);
            if(freq.containsKey(temp)) {
                Stack<Integer> st=freq.get(temp);
                st.add(x);
                freq.put(temp,st);
            }else {
                Stack<Integer> st=new Stack<>();
                st.add(x);
                freq.put(temp,st);
            }
        }
        else {
            val.put(x,1);
            max=Math.max(max,1);
            if(freq.containsKey(1)) {
                Stack<Integer> st=freq.get(1);
                st.add(x);
                freq.put(1,st);
            }else {
                Stack<Integer> st=new Stack<>();
                st.add(x);
                freq.put(1,st);
            }
        }
    }
    public int pop() {
        Stack<Integer> st=freq.get(max);
        int ans=st.pop();
        if(st.isEmpty()) {
            freq.remove(max);
            max--;
        }
        val.put(ans,val.get(ans)-1);
        if(val.get(ans)==0) {
            val.remove(ans);
        }
        return ans;
    }
}
++++++++++++++++++++++++++++++++++++++++++++++++
Length of the largest subarray with contiguous elements (distinct elements)
public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
         int n=s.nextInt();
         int a[]=new int[n];
         for(int i=0;i<n;i++) a[i]=s.nextInt();
         int ans=0;
        for(int i=0;i<n;i++) {
            int max=a[i];
            int min=a[i];
            for(int j=i;j<n;j++) {
               max=Math.max(max,a[j]);
               min=Math.min(min,a[j]);
               if((max-min+1)==(j-i+1)) ans=Math.max(ans,j-i+1);
            }
        }
        System.out.println(ans);
    }
    +++++++++++++++++++++++++++++++++++++++++++++
    Length of the largest subarray with contiguous elements(duplicate elemets)
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
         //int n=s.nextInt();
         int a[]={10, 12, 11};
         //for(int i=0;i<n;i++) a[i]=s.nextInt();
        int n=a.length;
         int ans=0;
        for(int i=0;i<n;i++) {
            int max=a[i];
            int min=a[i];
            HashSet<Integer> set =new HashSet<>();
            for(int j=i;j<n;j++) {
               max=Math.max(max,a[j]);
               min=Math.min(min,a[j]);
               if(set.contains(a[j])) break;
               else {
                   set.add(a[j]);
                   if((max-min+1)==(j-i+1)) ans=Math.max(ans,j-i+1);
               }
            }
        }
        System.out.println(ans);
    }
    ++++++++++++++++++++++++++++++++++++++++++++
    Sliding Window Maximum
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];
        for(int i=0;i<n;i++) {
            if(i%k==0) left[i]=nums[i];
            else left[i]=Math.max(left[i-1],nums[i]);
        }
        right[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--) {
            if((i+1)%k==0) right[i]=nums[i];
            else right[i]=Math.max(right[i+1],nums[i]);
        }
        int a[]=new int[n-k+1];
        for(int i=0;i<=n-k;i++) {
            if(i%k==0) a[i]=right[i];
            else a[i]=Math.max(right[i],left[i+k-1]);
        }
        return a;
    }
    ++++++++++++++++++++++++++++++++++++++++++++
    Trapping Rain Water
     public int trap(int[] height) {

        int n=height.length;
        if(n==0) return 0;
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=height[0];
        for(int i=1;i<n;i++) {
            left[i]=Math.max(left[i-1],height[i]);
        }
        right[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--) {
            right[i]=Math.max(right[i+1],height[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++) {
           ans+=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
	+++++++++++++++++++++++++++++++++++++++++++++
	Trapping Rain Water II
	class Solution {
    static class Pair implements Comparable<Pair>{
        int row;
        int col;
        int height;
        Pair(int row,int col,int height) {
            this.row=row;
            this.col=col;
            this.height=height;
        }
        @Override
        public int compareTo(Pair o) {
            return this.height-o.height;
        }
    }
    public void put(int oh,int ni,int nj,int nh) {
        if(oh<=nh){
            pq.add(new Pair(ni,nj,nh));
        }
        else {
            ans+=oh-nh;
            pq.add(new Pair(ni,nj,oh));
        }
    }
    int ans;
        PriorityQueue<Pair> pq;
    public int trapRainWater(int[][] height) {
        ans=0;
        int n=height.length;
        int m=height[0].length;
        boolean vis[][]=new boolean[n][m];
        pq=new PriorityQueue<>();
        for(int i=0;i<m;i++) {
            pq.add(new Pair(0,i,height[0][i]));
            vis[0][i]=true;
        }
        for(int i=0;i<m;i++) {
            pq.add(new Pair(n-1,i,height[n-1][i]));
            vis[n-1][i]=true;
        }
        for(int i=1;i<n-1;i++) {
            pq.add(new Pair(i,0,height[i][0]));
            vis[i][0]=true;
        }
        for(int i=1;i<n-1;i++) {
            pq.add(new Pair(i,m-1,height[i][m-1]));
            vis[i][m-1]=true;
        }
        while(!pq.isEmpty()) {
             Pair front=pq.poll();
             int i=front.row;
             int j=front.col;
             int h=front.height;
             if(i+1<n&&!vis[i+1][j]) {
                 vis[i+1][j]=true;
                 put(h,i+1,j,height[i+1][j]);
             }
             if(i-1>=0&&!vis[i-1][j]) {
                 vis[i-1][j]=true;
                 put(h,i-1,j,height[i-1][j]);
             }
             if(j-1>=0&&!vis[i][j-1]) {
                 vis[i][j-1]=true;
                 put(h,i,j-1,height[i][j-1]);
             }
             if(j+1<m&&!vis[i][j+1]) {
                vis[i][j+1]=true;
                 put(h,i,j+1,height[i][j+1]);
             }
        }
        return ans;
    }
}
+++++++++++++++++++++++++++++++++++++++++++++++++++
Line Reflection
public static boolean isReflected(int[][] points) {
        HashMap<String,Boolean> map=new HashMap<>();
        int n=points.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            min=Math.min(min,points[i][0]);
            max=Math.max(max,points[i][0]);
            String str= String.valueOf(points[i][0]);
            str+=".0";
            str+='*';
            str+=points[i][1];
            str+=".0";
            map.put(str,true);
        }
        double y=((min+max)*1.0)/2;
        for(int i=0;i<n;i++) {
            double x2=2*y-points[i][0];
            String str1= String.valueOf(points[i][0]);
            str1+=".0";
            str1+='*';
            str1+=points[i][1];
            str1+=".0";
            String str2= Double.toString(x2);
            str2+='*';
            str2+=points[i][1];
            str2+=".0";

            if(map.containsKey(str1)) {
                if(map.containsKey(str2)) {
                    map.remove(str2);
                    map.remove(str1);
                }else return false;
            }
        }
        return true;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++
    Kth Smallest Element in a Sorted Matrix
    class Solution {
    static class Pair implements Comparable<Pair> {
        int row;
        int col;
        int val;
        Pair(int row,int col,int val) {
            this.row=row;
            this.col=col;
            this.val=val;
        }
        @Override
        public int compareTo(Pair o) {
            return this.val-o.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            pq.add(new Pair(i,0,matrix[i][0]));
        }
        int count=0;
        while(!pq.isEmpty()) {
          Pair p=pq.poll();
            count++;
            int row=p.row;
            int col=p.col;
            int val=p.val;
            if(count==k) return val;
            if(col+1<n) {
                pq.add(new Pair(row,col+1,matrix[row][col+1]));
            }
        }
        return 0;
    }
}
++++++++++++++++++++++++++++++++++++++++++++++++
K-th Smallest Prime Fraction
class Solution {
    public class Pair implements Comparable<Pair>{
        int num;
        int den;
        Pair(int num,int den) {
            this.num=num;
            this.den=den;
        }
        @Override
        public int compareTo(Pair o) {
            return a[this.num]*a[o.den]-a[this.den]*a[o.num];
        }
    }
    int a[];
    public int[] kthSmallestPrimeFraction(int[] A, int K) {

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int n=A.length;
         a=new int[n];
        for(int i=0;i<n;i++) a[i]=A[i];
        for(int i=0;i<n-1;i++) {
            pq.add(new Pair(i,n-1));
        }
        int count=0;
        while(!pq.isEmpty()) {
            Pair p=pq.poll();
            count++;
            int num=p.num;
            int den=p.den;
            if(count==K) {
                int ans[]=new int[2];
                ans[0]=a[num];
                ans[1]=a[den];
                return ans;
            }
            if(den-1>num) {
                pq.add(new Pair(num,den-1));
            }
        }
        return new int[0];
    }
}
    +++++++++++++++++++++++++++++++++++++++++++++
    Bulb Switcher
    public int bulbSwitch(int n) {
        if(n==1||n==0) return n;
        int ans=1;
        for(long i=2;i<=n/2;i++){
           if(i*i<=n) ans++;
        }
        return ans;
    }
    +++++++++++++++++++++++++++++++++++++++++++++
    Pairs which are Divisible by 4
    public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
        while(t-->0) {
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) {
                a[i]=s.nextInt();
                a[i]=a[i]%4;
            }
            HashMap<Integer,Integer> map=new HashMap<>();
            int ans=0;
            for(int i=0;i<n;i++) {
                if(a[i]>0) {
                    if(map.containsKey(4-a[i])) {
                       ans+=map.get(4-a[i]);
                    }
                    if(map.containsKey(a[i])) {
                        map.put(a[i],map.get(a[i])+1);
                    }
                    else  map.put(a[i],1);
                }
                else {
                    if(map.containsKey(a[i])) {

                       ans+=map.get(a[i]);
                        map.put(a[i],map.get(a[i])+1);
                    }else  map.put(a[i],1);
                }
            }
            System.out.println(ans);
        }
	}
	+++++++++++++++++++++++++++++++++++++++++++++
	Pairs of Non Coinciding Points

	public static void main (String[] args) {
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
	   while(t-->0){
	       int n=s.nextInt();
	       HashMap<Integer,Integer> xaxis=new HashMap<>();
	       HashMap<Integer,Integer> yaxis=new HashMap<>();
	       HashMap<String,Integer> map=new HashMap<>();
	       int ans=0;
	       for(int i=0;i<n;i++) {
	           int x=s.nextInt();
	           int y=s.nextInt();
	           if(xaxis.containsKey(x)) {
	               ans+=xaxis.get(x);
	               xaxis.put(x,xaxis.get(x)+1);
	           }
	           else xaxis.put(x,1);
	           if(yaxis.containsKey(y)) {
	               ans+=yaxis.get(y);
	               yaxis.put(y,yaxis.get(y)+1);
	           }
	           else yaxis.put(y,1);
	           String str="";
	           str+=x;
	           str+="*";
	           str+=y;
	           if(map.containsKey(str)) {
	              ans-=map.get(str)*2;
	              map.put(str,map.get(str)+1);
	           }else map.put(str,1);
	       }
	       System.out.println(ans);
	   }
	}
	+++++++++++++++++++++++++++++++++++++++++++++
	Digit multiplier
	public static void main (String[] args) {
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
	   while(t-->0){
	       int n=s.nextInt();
	       int factor=9;
	       String str="";
	       if(n==1) str="1";
	       while(n>1&&factor>1) {
	           if(n%factor==0){
	               str=factor+str;
	               n/=factor;
	           }else factor--;
	       }
	       if(n==1) System.out.println(str);
	       else System.out.println("-1");
	   }
	}
	+++++++++++++++++++++++++++++++++++++++++++++
	Check if frequencies can be equal
	public static class Pair implements Comparable<Pair> {
    int key;
    int val;
    Pair(int key,int val) {
        this.key=key;
        this.val=val;
    }
    @Override
    public int compareTo(Pair o) {
        return this.val-o.val;
    }
    }
    public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            String str=s.next();
            int a[]=new int[26];
            HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0;i<str.length();i++) {
                if(map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i),map.get(str.charAt(i))+1);
                }else map.put(str.charAt(i),1);
            }
            HashMap<Integer,Integer> map2=new HashMap<>();
            for(Map.Entry<Character,Integer> hi:map.entrySet()) {
                if(map2.containsKey(hi.getValue())) {
                    map2.put(hi.getValue(),map2.get(hi.getValue())+1);
                }
                else map2.put(hi.getValue(),1);
            }
            if(map2.size()==1) {
                System.out.println("1");
            }else if(map2.size()==2) {
                Pair b[]=new Pair[2];
                int k=0;
                for(Map.Entry<Integer,Integer> hi:map2.entrySet()) {
                    b[k]=new Pair(hi.getKey(),hi.getValue());
                    k++;
                }
                //System.out.println(b[0].val+" "+b[1].val);
                Arrays.sort(b);
                if(b[0].val==1&&b[0].key==1) {
                    System.out.println("1");
                }else if(Math.abs(b[1].key-b[0].key)==1&&b[0].val==1) System.out.println("1");
                //else if(Math.abs(a[1]-a[0])==1&&(map2.get(b[1])==1||map.get(b[0])==1)) {
                //    System.out.println("1");
                //}
                else System.out.println("0");

            }
            else System.out.println("0");
        }

    }
    +++++++++++++++++++++++++++++++++++++++++++++
    A Simple Fraction
    public static void main (String[] args) {
	     Scanner s=new Scanner(System.in);
	     int t=s.nextInt();
	     while(t-->0) {
	         int num=s.nextInt();
	         int den=s.nextInt();
	         int x=num/den;
	         String ans="";
	         ans+=x;
	         if(num%den==0) {
	             System.out.println(ans);
	             continue;
	         }
	         String str="";
	         HashMap<Integer,Integer> map=new HashMap<>();
	         int rem=num%den;
	         int count=0;
	         while(!map.containsKey(rem)) {
	             map.put(rem,count);
	             count++;
	             num=rem*10;
	             x=num/den;
	             str+=x;
	             rem=num%den;
	         }
	         int index=map.get(rem);
	          String temp="";
	          temp+=ans+'.'+str.substring(0,index)+'('+str.substring(index)+')';
	         int indexofopenbracket=temp.indexOf('(');  //==> edges cases 
	         if(temp.length()-1-indexofopenbracket-1>1||str.charAt(index)!='0') {
	             ans+='.'+str.substring(0,index)+'('+str.substring(index)+')';
	         }else  ans+='.'+str.substring(0,str.length()-1);
	         System.out.println(ans);
	     }
	}
	+++++++++++++++++++++++++++++++++++++++++++++
	Find All Anagrams in a String
	 public List<Integer> findAnagrams(String s, String p) {
        if(s.length()==0||p.length()==0||p.length()-s.length()>0) return new ArrayList<>();
        HashMap<Character,Integer> txt=new HashMap<>();
         HashMap<Character,Integer> pat=new HashMap<>();
         for(int i=0;i<p.length();i++) {
             if(pat.containsKey(p.charAt(i))) {
                 pat.put(p.charAt(i),pat.get(p.charAt(i))+1);
             }else pat.put(p.charAt(i),1);
         }
        List<Integer> ans=new ArrayList<>();
        int matchcount=0;
        int i=0;int j=0;
        while(j<p.length()) {
            char ch=s.charAt(j);
            if(txt.containsKey(ch)) {
                txt.put(ch,txt.get(ch)+1);
                if(pat.containsKey(ch)&&pat.get(ch)>=txt.get(ch)) {
                    matchcount++;
                }
            }else {
                txt.put(ch,1);
                if(pat.containsKey(ch)&&pat.get(ch)>=1) {
                    matchcount++;
                }
            }
            j++;
        }
         if(matchcount==p.length()) ans.add(i);
        while(j<s.length()) {
            //release
            char ch=s.charAt(i);
           // System.out.println(ch);
            txt.put(ch,txt.get(ch)-1);
            if(pat.containsKey(ch)&&txt.get(ch)<pat.get(ch)) matchcount--;
            i++;

            //aquire
            ch=s.charAt(j);
            if(txt.containsKey(ch)) txt.put(ch,txt.get(ch)+1);
            else txt.put(ch,1);
            if(pat.containsKey(ch)&&txt.get(ch)<=pat.get(ch)) matchcount++;
            if(matchcount==p.length()) ans.add(i);
            j++;
        }
        return ans;

    }
    ++++++++++++++++++++++++++++++++++++++++++++++
    Anagram Palindrome
    public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    String str=s.next();
		    int a[]=new int[26];
		    for(int i=0;i<str.length();i++) {
		        a[str.charAt(i)-'a']++;
		    }
		    int odd=0;
		    for(int i=0;i<26;i++) {
		        if(a[i]%2==1) odd++;
		    }
		    if(odd>1) System.out.println("No");
		    else System.out.println("Yes");
		}
	}
	+++++++++++++++++++++++++++++++++++++++++++++
	 Group Anagrams
	public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        HashMap<String ,ArrayList<String>> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            String str=strs[i];
            int a[]=new int[26];
            for(int j=0;j<str.length();j++) {
                a[str.charAt(j)-'a']++;
            }
            String temp="";
            for(int j=0;j<26;j++) {
               temp+=a[j];
                temp+='*';
            }
            if(map.containsKey(temp)) {
                ArrayList<String> li=map.get(temp);
                li.add(str);
                map.put(temp,li);

            }else{
                ArrayList<String> li=new ArrayList<>();
                li.add(str);
                map.put(temp,li);
            }

        }
        List<List<String>> list=new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>> hi:map.entrySet()) {
            list.add(hi.getValue());
        }
        return list;
    }
    +++++++++++++++++++++++++++++++++++++++++++++
    Minimum window substring
    public static String minWindow(String s, String p) {
    if(s.length()==0||p.length()==0||p.length()>s.length()) return "";
    HashMap<Character,Integer> txt=new HashMap<>();
    HashMap<Character,Integer> pat=new HashMap<>();
    for(int i=0;i<p.length();i++) {
        if(pat.containsKey(p.charAt(i))) {
            pat.put(p.charAt(i),pat.get(p.charAt(i))+1);
        }else pat.put(p.charAt(i),1);
    }
    int matchcount=0;
    int i=0;
    int j=-1;
    int minlen=Integer.MAX_VALUE;
    int index=-1;
    while(j<s.length()) {

        if(matchcount!=p.length()) {
            j++;  ==> edge case
            if(j==s.length()) break;
            char ch=s.charAt(j);
            if(txt.containsKey(ch)) {
                txt.put(ch,txt.get(ch)+1);
                if(pat.containsKey(ch)&&pat.get(ch)>=txt.get(ch)) matchcount++;

            }else {
                txt.put(ch,1);
                if(pat.containsKey(ch)&&pat.get(ch)>=txt.get(ch)) matchcount++;
            }

        }else {

            if(minlen>j-i+1) {
                minlen=j-i+1;
                index=i;
            }
            char ch=s.charAt(i);
            //System.out.println(i);
            txt.put(ch,txt.get(ch)-1);
            if(pat.containsKey(ch)&&txt.get(ch)<pat.get(ch)) matchcount--;
            i++;
        }
    }
    if(index==-1) return "";
    return s.substring(index,index+minlen);
}
	+++++++++++++++++++++++++++++++++++++++++++++
	Smallest subarray with all occurrences of a most frequent element
	static class Pair {
        int frequency;
        int startindex;
        int endindex;
        Pair(int frequency,int startindex,int endindex) {
            this.endindex=endindex;
            this.startindex=startindex;
            this.frequency=frequency;
        }
    }
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=s.nextInt();
		    HashMap<Integer,Pair> map=new HashMap<>();
		    for(int i=0;i<n;i++) {
		        if(map.containsKey(a[i])) {
		            Pair p=map.get(a[i]);
		            p.frequency=p.frequency+1;
		            p.endindex=i;
		            map.put(a[i],p);
		        }else map.put(a[i],new Pair(1,i,i));
		    }
		    int maxfreq=0;
		    Pair max=null;
		    for(Map.Entry<Integer,Pair> hi:map.entrySet()) {
		        if(maxfreq<hi.getValue().frequency) {
		            maxfreq=hi.getValue().frequency;
		            max=hi.getValue();
		        }
		        else if(maxfreq==hi.getValue().frequency) {
		            int len1=hi.getValue().endindex-hi.getValue().startindex+1;
		            int len2=max.endindex-max.startindex+1;
		            if(len1<len2) {
		                max=hi.getValue();
		            }
		        }
		    }
		    for(int i=max.startindex;i<=max.endindex;i++) {
		        System.out.print(a[i]+" ");
		    }
		    System.out.println();
		}

	}
	+++++++++++++++++++++++++++++++++++++++++++++
	K-Anagrams
	 boolean areKAnagrams(String s1, String s2, int k)
     {
        if(s1.length()!=s2.length()) return false;
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s1.length();i++) {
            char ch=s1.charAt(i);
            if(map1.containsKey(ch)) {
                map1.put(ch,map1.get(ch)+1);
            }else map1.put(ch,1);
        }
        for(int i=0;i<s2.length();i++) {
            char ch=s2.charAt(i);
            if(map2.containsKey(ch)) {
                map2.put(ch,map2.get(ch)+1);
            }else map2.put(ch,1);
        }
        int ans=0;
        for(Map.Entry<Character,Integer> hi:map1.entrySet()) {
            if(map2.containsKey(hi.getKey())) {
                int x=map2.get(hi.getKey());
                x=hi.getValue()-x;
                if(x>0) ans+=x;
            }
            else ans+=hi.getValue();
        }
        if(ans<=k) return true;
         return false;
     }
     ++++++++++++++++++++++++++++++++++++++++++++
     Length of the longest substring
     public static void main (String[] args) {
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
	   while(t-->0) {
	      String str=s.next();
	      int i=0;
	      int j=0;
	      int maxlen=Integer.MIN_VALUE;
	      HashMap<Character,Integer> map=new HashMap<>();
	      boolean flag=false;
	      while(j<str.length()&&!flag) {
	         if(!flag) {
	            char ch=str.charAt(j);
	            if(map.containsKey(ch)) {
	                map.put(ch,map.get(ch)+1);
	                flag=!flag;
	            }else{
	                map.put(ch,1);
	                maxlen=Math.max(maxlen,j-i+1);
	                j++;
	            } 
	         }
	         if(flag) {
	             while(flag) {
	                 char ch=str.charAt(i);
    	             map.put(ch,map.get(ch)-1);
    	             if(map.get(ch)==1){
                       flag=!flag;   
    	             }
    	             else if(map.get(ch)<=0) {
    	                 map.remove(ch);
                   }
                   i++;
               }
               j++;
	         }
	      }
	      System.out.println(maxlen);
     }
     s.close();
	}
	+++++++++++++++++++++++++++++++++++++++++++++
	Insert Delete GetRandom O(1)
	class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }
     public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int removeindex=map.get(val);
        map.remove(val);
        int lastval=list.get(list.size()-1);
        list.set(removeindex,lastval);
        list.remove(list.size()-1);
        if(val!=lastval) map.put(lastval,removeindex);
        return true;
    }
    public int getRandom() {
        if(list.size()==0) return -1;
        int index=(int)(Math.random()*list.size());
        int x=index%(list.size());
        return list.get(x);
    }
}
    +++++++++++++++++++++++++++++++++++++++++++++
    Insert Delete GetRandom O(1) - Duplicates allowed
    class RandomizedCollection {

    HashMap<Integer,HashMap<Integer,Boolean>> map;
    ArrayList<Integer> list;
    public RandomizedCollection() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    public boolean insert(int val) {
        list.add(val);
        if(map.containsKey(val)) {
            HashMap<Integer,Boolean> temp=map.get(val);
            temp.put(list.size()-1,true);
        }else {
            HashMap<Integer,Boolean> temp=new HashMap<>();
            temp.put(list.size()-1,true);
            map.put(val,temp);
        }
        return true;
    }
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        HashMap<Integer,Boolean> temp=map.get(val);
        int removeindex=-1;
        for(int i:temp.keySet()) {
            removeindex = i;
            break;
        }
        if(removeindex==-1) return false;
        temp.remove(removeindex);
        if(temp.size()==0) map.remove(val);
        int lastindex=list.size()-1;
        int y=list.get(lastindex);
        list.set(removeindex,y);
        list.remove(list.size()-1);
        if(!map.containsKey(y)) return true;
        temp=map.get(y);
        temp.remove(lastindex);
        temp.put(removeindex,true);
        return true;
    }
    public int getRandom() {
        int index=(int)(Math.random()*list.size());
        int x=index%list.size();
        return list.get(x);
    }
}
	+++++++++++++++++++++++++++++++++++++++++++++
	Building Heap from Array
	static  int a[];
    public static  void swap(int x,int y) {
        int temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }
    public  static  void  downheapfy (int i,int n) {
        int parent=a[i];
        int leftchild=i*2+1;
        int rightchild=(i*2)+2;
        if(leftchild>=n)  return;
        else if(leftchild<n&&rightchild>=n) {
            if(parent<leftchild){
                swap(i,(i*2)+1);
                downheapfy((i*2)+1,n);
            }
        }else{
            if(parent>a[leftchild]&&parent<a[rightchild]) {
                swap(i,(i*2)+2);
                downheapfy((i*2)+2,n);
            }
            else if(parent<a[leftchild]&&parent>a[rightchild]) {
                swap(i,(i*2)+1);
                downheapfy((i*2)+1,n);
            }
            else if(parent<a[leftchild]&&parent<a[rightchild]) {
                if(a[leftchild]>=a[rightchild]) {
                    swap(i,(i*2)+1);
                    downheapfy((i*2)+1,n);
                }else{
                    swap(i,(i*2)+2);
                    downheapfy((i*2)+2,n);
                }
            }
        }
    }
    public  static  void buildHeap() {
        int start=(a.length/2)-1;
        for(int i=start;i>=0;i--) {
            downheapfy(i,a.length);
        }
    }
	+++++++++++++++++++++++++++++++++++++++++++++
	 */
}
