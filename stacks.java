public class stacks {
	/*
	+++++++++++++++++++++++++++++++++++++++++++++++++++++
	next Greater on right
	public static void nextlargerelemnt(int a[]) {
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[a.length];
        st.push(0);
        for(int i=1;i<a.length;i++) {
            while(!st.isEmpty()&& a[st.peek()]<a[i]) {
                    int index=st.pop();
                    ans[index]=a[i];
                }
                st.push(i);
        }
        while(!st.isEmpty()) {
            int index=st.pop();
            ans[index]=-1;
        }
        for(int i=0;i<a.length;i++) System.out.println(a[i]+" "+ans[i]);
        System.out.println();
    }
    public static void main (String[] args) {
       Scanner s=new Scanner(System.in);
       int n=s.nextInt();
           int a[]=new int[n];
           for(int i=0;i<n;i++) a[i]=s.nextInt();
            nextlargerelemnt(a); 
	}
	public static int [] nextlargerelemntleft(int a[]) {
    	int n = a.length;
		int ans[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		for(int i=n-1; i>=0; i--) {
			while(!stack.isEmpty() && a[i]>a[stack.peek()]) {
				int element = stack.pop();
				ans[element] = a[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			int element = stack.pop();
			ans[element] = -1;
		}
        return ans;
    }
	public static int [] nextsmallerelemntright(int a[]) {
    	int n = a.length;
		int ans[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			while(!stack.isEmpty() && a[i]<a[stack.peek()]) {
				int element = stack.pop();
				ans[element] = a[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			int element = stack.pop();
			ans[element] = -1;
		}
        return ans;
    }
	public static int [] nextsmallerelemntleft(int a[]) {
	    	int n = a.length;
			int ans[] = new int[n];
			Stack<Integer> stack = new Stack<>();
			for(int i=n-1; i>=0; i--) {
				while(!stack.isEmpty() && a[i]<a[stack.peek()]) {
					int element = stack.pop();
					ans[element] = a[i];
				}
				stack.push(i);
			}
			while(!stack.isEmpty()) {
				int element = stack.pop();
				ans[element] = -1;
			}
	        return ans;
		}
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Next Greater Element II
	 public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        if(n==0) return new int[0];
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int ans[]=new int[n];
        for(int i=1;i<2*n;i++) {
            int num=nums[i%n];
            while(!st.isEmpty()&&nums[st.peek()]<num) {
                ans[st.pop()]=num;
            }
            if(i<n) st.push(i);
        }
        while(!st.isEmpty()) {
            ans[st.pop()]=-1;
        }
        return ans;
    }
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	Daily Temperatures
	public int[] dailyTemperatures(int[] T) {
        int n=T.length;
        if(n==0) return new int[0];
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int ans[]=new int[n];
        for(int i=1;i<n;i++) {
            int num=T[i];
            while(!st.isEmpty()&&T[st.peek()]<num) {
                int index=st.pop();
                ans[index]=i-index;
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            ans[st.pop()]=0;
        }
        return ans;
    }
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Stock span
	public static int [] stockSpan(int a[]) {
    	 int n = a.length;
 		int ans[] = new int[n];
		 Stack<Integer> stack = new Stack<>();
		 st.push(n-1);
 		for(int i=n-2; i>=0; i--) {
 			 while(!stack.isEmpty() && a[i]>a[stack.peek()]) {
  				int element = stack.pop();
  				ans[element] = element-i;
  			    }
  			    stack.push(i);  
 		}
 		while(!stack.isEmpty()) {
 			int element = stack.pop();
 			ans[element] = element+1; // 80 70 100 90 
 		}
         return ans;
    }
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Find maximum difference between nearest left and right smaller elements 
	public static int[] maxDiffbwleftright(int a[]) {
    	int n = a.length;
    	int ans[]=new int[n];
 		Stack<Integer> stack = new Stack<>();
 		for(int i=0; i<n; i++) {
 			 while(!stack.isEmpty() && a[i]<a[stack.peek()]) {
 				int element = stack.pop();
 				if(!stack.isEmpty()) ans[element] = Math.abs(a[stack.peek()]-a[i]);
 				else ans[element]=a[i];
 			 }
  			 stack.push(i);
 		}
 		while(!stack.isEmpty()) {
 			int element = stack.pop();
 			if(!stack.isEmpty()) ans[element] = a[stack.peek()];
 			else ans[element]=0;
 		}
        return ans;
	}
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Largest Rectangle in Histogram
	public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack();
        int n=heights.length;
        if(n==0) return 0;
        st.push(0);
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<n;i++) {
            int num=heights[i];
            while(!st.isEmpty()&&num<heights[st.peek()]) {
                int index=st.pop();
                if(!st.isEmpty()) {
                    ans=Math.max(ans,(i-st.peek()-1)*heights[index]);
                }else {
                    ans=Math.max(ans,i*heights[index]);
                }
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int index=st.pop();
            if(!st.isEmpty()) ans=Math.max(ans,(n-st.peek()-1)*heights[index]);
            else ans=Math.max(ans,heights[index]*n);
        }
        return ans;
    }
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack();
        int n=heights.length;
        if(n==0) return 0;
        st.push(0);
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<n;i++) {
            int num=heights[i];
            while(!st.isEmpty()&&num<heights[st.peek()]) {
                int index=st.pop();
                if(!st.isEmpty()) {
                    ans=Math.max(ans,(i-st.peek()-1)*heights[index]);
                }else {
                    ans=Math.max(ans,i*heights[index]);
                }
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int index=st.pop();
            if(!st.isEmpty()) ans=Math.max(ans,(n-st.peek()-1)*heights[index]);
            else ans=Math.max(ans,heights[index]*n);
        }
        return ans;
    }
    public static int maximalRectangle(char[][] matrix) {  //use of largestRectangleAreaofHistogram
    	                                            //above function is used in this largestRectangleArea
        int n=matrix.length;
        if(n==0) return 0;
        int m=matrix[0].length;
        int a[]=new int[m];
        int max=largestRectangleArea(a);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
               if(matrix[i][j]=='1') {
                 a[j]=a[j]+(int)matrix[i][j]-'0';
               }
                else {
                   a[j]=0;
                }
            }
            max=Math.max(max,largestRectangleArea(a));
        }
        return max;
	}
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Valid Parentheses
    public static boolean isValidparentheses(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='(') st.push(s.charAt(i));
            else {
                if(st.isEmpty()) return false;
                if(s.charAt(i)=='}') {
                    if(st.pop()!='{') return false;
                }
                else if(s.charAt(i)==']') {
                    if(st.pop()!='[') return false;
                }
                else if(s.charAt(i)==')') {
                    if(st.pop()!='(') return false;
                }
            }
        }
         if(st.size()==0) return true;
         else return false;
	 }
	 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 Length of the longest valid substring
    public static int longestValidsubstring(String s) {
        Stack<Integer> st=new Stack<>();
        st.add(-1);
        int max=0;
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='(') st.push(i);
        	else {
        		if(st.peek()!=-1&&s.charAt(st.peek())=='(') {
        			st.pop();
        			max=Math.max(max,i-st.peek());
        		}
        		else st.push(i);
        	}
        }
        return max;
	}
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Find if an expression has duplicate parenthesis or not
    public static boolean duplicateParenthesis(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)!=')') st.push(s.charAt(i));
        	else {
        		int count=0;
        		while(!st.isEmpty()&& st.peek()!='(') {
        			count++;
        			st.pop();
        		}
        		if(count==0) return true;
        		else st.pop();
        	}
        }
        return false;
	}
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Minimum number of bracket reversals needed to make an expression balanced
    public static int minNumberOfBracketReversals(String s) {
    	int n = s.length();
		if(n%2==1) return -1;  //  important case
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='{') st.push(s.charAt(i));
        	else {
        		if(!st.isEmpty()&&st.peek()=='{') st.pop();
        		else st.push(s.charAt(i));
        	}
        }
        int cc=0;
        int oc=0;
        char c1;
        while(!st.isEmpty()) {
        	c1=st.pop();
        	if(c1=='{') oc++;
        	else cc++;
        }
        if((cc%2)==0&&(oc%2==0)) return cc/2+oc/2;  
        return cc/2+oc/2+2; // }{ <== important case
	}
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Minimum Add to Make Parentheses Valid
    public static int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='(') st.push(s.charAt(i));
        	else {
        		if(!st.isEmpty()&&st.peek()=='(') st.pop();
        		else st.push(s.charAt(i));
        	}
        }
        return st.size();
	}
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Asteroid Collision
    public static int [] asteroidCollision(int a[]) {
		Stack<Integer> st=new Stack<>();
		   int n=a.length;
		   for(int i=0;i<n;i++) {
			   if(st.isEmpty()||a[i]>0 || st.peek()<0) st.push(a[i]);//
            else if(st.peek() <= -a[i]){
                if(st.peek()==-a[i]){
                    st.pop();
                }else{
                    st.pop();
                    i--;
                }
            }
		   }
		   int b[]=new int[st.size()];
		   for(int i=b.length-1;i>=0;i--) {
			   b[i]=st.pop();
		   }
		   return b;
	}
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Backspace String Compare
	 public static  boolean backspaceCompare(String s, String t) {
        int i=s.length()-1;
    	int j=t.length()-1;
    	while(true) {
    		int count=0;
    		while(i>=0) {
    		   	if(s.charAt(i)=='#') count++;
    		   	else {
    		   		if(count==0) break;
    		   		count--;
    		   	}
    		   	i--;
    		}
    		while(j>=0) {
    			if(t.charAt(j)=='#') count++;
    		   	else {
    		   		if(count==0) break;
    		   		count--;
    		   	}
    			j--;
    		}
            if(i==-1&&j==-1) break;
            if(i==-1||j==-1) return false;
    		if(s.charAt(i)!=t.charAt(j)) return false;
    		i--;
    		j--;

    	}
    	return true;
    }
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Remove K Digits
    public static  String removeKdigits(String s, int k) {
        int n=s.length();
 		if(n==0) return "";
         if(n==k) return "0";
 		Stack<Integer> st=new Stack<>();
 		st.push(s.charAt(0)-'0');
 		for(int i=1;i<n;i++) {
 			if(st.peek()<s.charAt(i)-'0') st.push(s.charAt(i)-'0');
 			else {
 				while(!st.isEmpty()&&st.peek()>s.charAt(i)-'0'&&k>0) {
 					st.pop();
 					k--;
 				}
 				st.push(s.charAt(i)-'0');
 			}
 		}
         while(k>0) {   // 112 k=1 tase case
             st.pop();
             k--;
         }
 		int t[]=new int[st.size()];
 		int m=st.size()-1;
 		for(int i=m;i>=0;i--) {
 			t[i]=st.pop();
 		}
 		int index=-1;
 		for(int i=0;i<t.length;i++) {
 			if(index==-1&&t[i]>0) index=i;
 		}
 		if(index==-1) return "0";   //10 1
 		String str="";
 		for(int i:t) {
 			str+=i;
 		}
         if(index==0) return str;
 		return str.substring(index);
     }
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Gas Station
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int pre = 0;
        for(int j=0;j<gas.length;j++) pre+=(gas[j]-cost[j]);
        if(pre<0) return -1;
        int i=0;
		int ans=0;
		int n=gas.length;
		int temp=0;
      //  int pre = 0;
		while(i<n) {
			temp+=(gas[i]-cost[i]);
			if(temp<0) {
				ans=i+1;
				temp = 0;
            }
			i++;
		}
		return ans;
	}  
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Car Fleet 
	static class Trip implements Comparable<Trip>{
        int dis;
        int speed;
        double time;
        Trip(int dis,int speed) {
            this.dis=dis;
            this.speed=speed;
        }
		@Override
		public int compareTo(Trip o) {
			return this.dis-o.dis;
		}
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        int n=speed.length;
        if(n==0) return 0;
        Trip[] tr=new Trip[n];
        for(int i=0;i<n;i++) {
            tr[i]=new Trip(position[i],speed[i]);
            double dist=target-position[i];
            tr[i].time=dist/speed[i];
        }
        Arrays.sort(tr);
        int ans=1;
        double time=tr[n-1].time;
        for(int i=n-2;i>=0;i--) {
        	if(time<tr[i].time) {
        		ans++;
        		time=tr[i].time;
        	}
        }
        return ans;
    }
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	First negative integer in every window of size k
    public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=s.nextInt();
		    int k=s.nextInt();
		    int neg=-1;
		    int i=n-1;
		    int temp=k;
		    while(i>=0&&temp>0) {
		        if(a[i]<0) {
		            neg=i;
		        }
		        temp--;
		        i--;
		    }
		    int b[]=new int[n-k+1];
		    for(i=n-k;i>=0;i--) {
		        if(a[i]<0) {
		            b[i]=a[i];
		            neg=i;
		        }
		        else if(a[i]>0&&neg>=i&&neg<=i+k-1) {
		            b[i]=a[neg];
		        }
		        else {
		            b[i]=0;
		        }
		    }
		    for(int j:b) {
		        System.out.print(j+" ");
		    }
		    System.out.println();
		}
	}
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Generate Binary Numbers
    public static void GenerateBinaryNumber(int n) {
        Queue<String> q=new LinkedList<>();
        q.add("1");
        int count=1;
        while(!q.isEmpty()) {
            String str=q.poll();
            count++;
            System.out.print(str+" ");
            if(count==n+1) {
                break;
            }
            q.add(str+'0');
            q.add(str+'1');
        }
        System.out.println();
    }
	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Maximum sum of smallest and second smallest in an array
    public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    long prev=0;
		    long max=Integer.MIN_VALUE;
		    for(int i=0;i<n;i++) {
		        long x=s.nextLong();
		        max=Math.max(max,x+prev);
		        prev=x;
		    }
		    System.out.println(max);
		}
	}
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Validate Stack Sequences
	public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();
        int n=pushed.length;
        int j=0;
        for(int i=0;i<n;i++) {
           st.push(pushed[i]);
            while(!st.isEmpty()&&st.peek()==popped[j]) {
                st.pop();
                j++;
            }
        }
        if(j!=n) return false;
        return true;
    }
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Reversing the first K elements of a Queue
    public Queue<Integer> reverseFirstk(Queue<Integer> q, int k)
    {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<k;i++) st.push(q.poll());
        for(int i=0;i<k;i++) q.add(st.pop());
        for(int i=0;i<q.size()-k;i++) {
            q.add(q.poll());
        }
        return q;
	}
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Min stack
	class MinStack {
    Stack<Integer> st;
    int min=Integer.MAX_VALUE;
    public MinStack() {
        st=new Stack<>();
        
    }
    public void push(int x) {
        if(x <= min) {
            st.push(min);
            min=x;
        }
        st.push(x);
    }
    public void pop() {
        int val=st.pop();
        
        if(val == min) {
            min=st.pop();
        }
        
    }  
    public int top() {
       return st.peek();
    }
    
    public int getMin() {
        return min;
    }
   }
   ++++++++++++++++++++++++++++++++++++++++++++++++
   Remove Duplicate Letters
   public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch,map.get(ch)+1);
            }else {
                map.put(ch,1);
            }
        }
        boolean vis[]=new boolean[26];
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if(s.isEmpty()) {
                st.push(ch);
                vis[ch-'a']=true;
                map.put(ch,map.get(ch)-1);
            }
            else{
               if(vis[ch-'a']) {
                   map.put(ch,map.get(ch)-1);
               }
               else {
                   while(!st.isEmpty()&&st.peek()-'0'>ch-'0'&&map.get(st.peek())>0) {
                      char rem=st.pop();
                      vis[rem-'a']=false;
                    }
                    st.push(ch);
                    vis[ch-'a']=true;
                    map.put(ch,map.get(ch)-1);
                  }
               }
        }
        char arr[]=new char[st.size()];
        int k=st.size()-1;
        while(!st.isEmpty()) {
            arr[k]=st.pop();
            k--;
        }
        return new String(arr);
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++
     */
}
