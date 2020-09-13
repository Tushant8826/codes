public class graphs {
    /*
    ++++++++++++++++++++++++++++++++
     bipartite graph
    class Solution {
    boolean vis[];
    boolean grp[];
    public boolean isBipartite(int[][] graph) {
       int n=graph.length;
        vis=new boolean[n];
        grp=new boolean[n];
        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                boolean ans=helper(graph,i);
                if(!ans) return false;
            }
        }
        return true;
    }
    public boolean helper(int[][] graph,int si) {
        vis[si]=true;
        grp[si]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(si);
        while(!q.isEmpty()) {
            int front=q.poll();
            int m=graph[front].length;
            for(int i=0;i<m;i++) {
                if(!vis[graph[front][i]]) {
                   vis[graph[front][i]]=true;
                   grp[graph[front][i]]=!grp[front];
                   q.add(graph[front][i]);
                }
                else {
                    if(grp[graph[front][i]]==grp[front]) return false;
                }
            }
        }
        return true;
    }
}
++++++++++++++++++++++++++++++++++++++++++
  //Bus Routes
static class Pair{
        int busstop;
        int count;
        Pair(int busstop,int count) {
            this.busstop=busstop;
            this.count=count;
        }
    }
    static HashMap<Integer,ArrayList<Integer>> map;
    public static  int numBusesToDestination(int[][] routes, int S, int T) {
        map=new HashMap<>();
        int n=routes.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
           for(int j=0;j<routes[i].length;j++) {
               if(map.containsKey(routes[i][j])) {
                   ArrayList<Integer> li=map.get(routes[i][j]);
                   li.add(i+1);
                   map.put(routes[i][j],li);
                   max=Math.max(max,routes[i][j]);
               }
               else {
                   ArrayList<Integer> li=new ArrayList<>();
                   li.add(i+1);
                   map.put(routes[i][j],li);
                   max=Math.max(max,routes[i][j]);
               }
           }
        }
        boolean busstopvis[]=new boolean[max+1];
        boolean busnovis[]=new boolean [n+1];
        Queue<Pair> q=new LinkedList<>();
        Pair p=new Pair(S,0);
        q.add(p);
        busstopvis[S]=true;
        while(!q.isEmpty()) {
            Pair p1=q.poll();
            int busstop=p1.busstop;
            int count=p1.count;
            if(busstop==T) return count;
            ArrayList<Integer> busNolist=map.get(busstop);
            for(int i:busNolist) {
                if(!busnovis[i]) {
                    int a[]=routes[i-1];
                    for(int j:a) {
                        if(!busstopvis[j]) {
                            busnovis[i]=true;
                            busstopvis[j]=true;
                            Pair  p2=new Pair(j,count+1);
                            q.add(p2);
                        }
                    }
                }
            }
        }
        return -1;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    prism algo ==> MST
    static class Pair implements Comparable<Pair> {
		int node, weight;
		public Pair(int v, int c) {
			node = v; weight = c;
		}
		@Override
		public int compareTo(Pair p) {
			return this.weight - p.weight;
		}
	}
	public static int prism(ArrayList<ArrayList<Pair>> al,boolean vis[],int si) {

		 PriorityQueue<Pair> q=new PriorityQueue<>();
		 Pair p=new Pair(si,0);
		 q.add(p);
		 int ans=0;
		 while(!q.isEmpty()) {
			 Pair p1=q.poll();
			 if(vis[p1.node]) continue;
			 vis[p1.node]=true;
			 ans+=p1.weight;
			 ArrayList<Pair> li =al.get(p1.node);
			 for(Pair p2: li) {
				 if(!vis[p2.node]){
					 q.add(p2);
				 }
			 }
		 }
		 return ans;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int v=s.nextInt();
		int e=s.nextInt();
		ArrayList<ArrayList<Pair>> al = new ArrayList<>();
		for(int i=0;i<=v;i++) {
			al.add(new ArrayList<Pair>());
		}
	    for(int i=0;i<e;i++) {
	    	int x=s.nextInt();
	    	int y=s.nextInt();
	    	int weight=s.nextInt();
	    	Pair p1=new Pair(y,weight);
            Pair p2=new Pair(x,weight);
            al.get(x).add(p1);
            al.get(y).add(p2);
	    }
	    boolean vis[]=new boolean[v+1];
        System.out.println(prism(al,vis,1));
        s.close();
    }
    ++++++++++++++++++++++++++++++++++++++++++++++
    dijkstra algo
    
	++++++++++++++++++++++++++++++++++++++++++++++
	Chef and Reversing
	class Codechef
{   static class Pair implements Comparable<Pair> {
      int ver;
      int wt;
      Pair(int ver,int wt) {
          this.ver=ver;
          this.wt=wt;
      }
      @Override
      public int compareTo(Pair o) {
          return this.wt-o.wt;
      }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s=new Scanner(System.in);
		int v=s.nextInt();
		int e=s.nextInt();
		ArrayList<Pair> al[]=new ArrayList[v+1];
		for(int i=0;i<=v;i++) al[i]=new ArrayList<>();
		for(int i=0;i<e;i++) {
		    int x=s.nextInt();
		    int y=s.nextInt();
		    al[x].add(new Pair(y,0));
		    al[y].add(new Pair(x,1));
		}
		dijkstra algo
		PriorityQueue<Pair> pq=new PriorityQueue<>();
		pq.add(new Pair(1,0));
	    int vis[]=new int[v+1];
	    Arrays.fill(vis,-1);
	    while(!pq.isEmpty()) {
	        Pair p=pq.poll();
	        int vertex=p.ver;
	        int weight=p.wt;
	       // System.out.println(vertex+" "+weight);
	       if(vis[vertex]==-1) vis[vertex]=weight;
	        ArrayList<Pair> li=al[vertex];
	        for(Pair p1:li) {
	            if(vis[p1.ver]==-1){
	                pq.add(new Pair(p1.ver,p1.wt+weight));
	            }
	        }
	    }
	    if(vis[v]==-1) System.out.println("-1");
	    else System.out.println(vis[v]);
	}
}
	++++++++++++++++++++++++++++++++++++++++++
	Evaluate Division
	static class Pair {
		String vert;
		double wt;
		public Pair(String s, double w) {
			vert = s; wt = w;
		}
	}

    public double[] calcEquation(List<List<String>> equations,
    		double[] values, List<List<String>> queries) {
    	int n = values.length;
    	//implementing graph
    	HashMap<String, ArrayList<Pair>> g = new HashMap<>();
    	for(int i=0; i<n; i++) {
    		String a = equations.get(i).get(0);
    		String b = equations.get(i).get(1);
    		if(!g.containsKey(a)) {
    			g.put(a, new ArrayList<>());
    		}
    		if(!g.containsKey(b)) {
    			g.put(b, new ArrayList<>());
    		}
    		g.get(a).add(new Pair(b, values[i]));
    		g.get(b).add(new Pair(a, 1/values[i]));
    	}
    	//answering queries
    	int m = queries.size();
        double ans[] = new double[m];
        for(int i=0; i<m; i++) {
        	String a = queries.get(i).get(0);
        	String c = queries.get(i).get(1);
        	double cost = bfs(a, c, g);
        	ans[i] = cost;
        }
        return ans;
    }

    static double bfs(String a, String c, HashMap<String, ArrayList<Pair>> g) {
    	double cost = -1.0f;
        if(!g.containsKey(a) || !g.containsKey(c)) return cost;
    	Queue<Pair> q = new LinkedList<>();
    	HashSet<String> vis = new HashSet<>();
    	q.add(new Pair(a, 1.0));
    	while(!q.isEmpty()) {
    		Pair p = q.poll();
    		String x = p.vert;
    		double wt = p.wt;
    		if(vis.contains(x)) continue;
    		vis.add(x);
    		if(x.equals(c)) {
    			cost = wt;
    			break;
    		}
    		for(Pair i : g.get(x)) {
    			if(vis.contains(i.vert)) continue;
    			q.add(new Pair(i.vert, wt*i.wt));
    		}
    	}
    	return cost;
    }
	+++++++++++++++++++++++++++++++++++++++++++
	kosaRaju
	static Stack<Integer> stack;
    static int count;
    public int kosaraju(ArrayList<ArrayList<Integer>> adj, int N)
    {
         dfs(adj,N);
         ArrayList<ArrayList<Integer>> newList=new ArrayList<>();
         for(int i=0;i<N;i++) {
             ArrayList<Integer> li=new ArrayList<>();
             newList.add(li);
         }
         for(int i=0;i<N;i++) {
             for(int j=0;j<adj.get(i).size();j++) {
                 ArrayList<Integer> li=newList.get(adj.get(i).get(j));
                 li.add(i);
             }
         }
         count=0;
          boolean vis[]=new boolean[N];
          while(!stack.isEmpty()) {
              int x=stack.pop();
              if(!vis[x]) {
                  helper2(newList,x,vis);
                  count++;
              }
          }

        return count;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int N) {
    	stack=new Stack<>();
        boolean vis[]=new boolean[N];
        for(int i=0;i<N;i++) {
            if(!vis[i]) {
                helper(adj,i,vis);
                stack.push(i);
            }
        }
    }
    public static void helper(ArrayList<ArrayList<Integer>> adj,int st,boolean vis[]) {
        vis[st]=true;
        ArrayList<Integer> list=adj.get(st);
        for(int i:list) {
            if(!vis[i]) {
                helper(adj,i,vis);
               stack.push(i);
            }
        }
    }
    public static void helper2(ArrayList<ArrayList<Integer>> adj,int st,boolean vis[]) {
        vis[st]=true;
        ArrayList<Integer> list=adj.get(st);
        for(int i:list) {
            if(!vis[i]) {
                helper(adj,i,vis);
            }
        }
    }
	++++++++++++++++++++++++++++++++++++++++++++
	Mother vertex
	static int findMother(ArrayList<ArrayList<Integer>> g, int n)
    {
        dfs(g,n);
        boolean vis[]=new boolean[n];
        helper2(g,stack.peek(),vis);
        for(int i=0;i<n;i++) {
            if(!vis[i]) return -1;
        }
        return stack.peek();
    }
    static Stack<Integer> stack;
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int N) {
    	stack=new Stack<>();
        boolean vis[]=new boolean[N];
        for(int i=0;i<N;i++) {
            if(!vis[i]) {
                helper(adj,i,vis);
                stack.push(i);
            }
        }
    }
    public static void helper(ArrayList<ArrayList<Integer>> adj,int st,boolean vis[]) {
        vis[st]=true;
        ArrayList<Integer> list=adj.get(st);
        for(int i:list) {
            if(!vis[i]) {
               helper(adj,i,vis);
               stack.push(i);
            }
        }
    }
    public static void helper2(ArrayList<ArrayList<Integer>> adj,int st,boolean vis[]) {
        vis[st]=true;
        ArrayList<Integer> list=adj.get(st);
        for(int i:list) {
            if(!vis[i]) {
               helper2(adj,i,vis);
            }
        }
    }
	++++++++++++++++++++++++++++++++++++++++++++++++++++++
	topological sort DFS
	static int[] topoSort(ArrayList<ArrayList<Integer>> g, int n) {
        int ans[] = new int[n];
        boolean vis[] = new boolean[n];
        i = n-1;
        for(int j=0; j<n; j++) {
        	if(!vis[j]) {
        		dfs(g, n, vis, ans, j);
        		ans[i--] = j;
        	}
        }
        return ans;
    }

    static int i;
    static void dfs(ArrayList<ArrayList<Integer>> g, int n,
    		boolean vis[], int ans[], int x) {
    	vis[x] = true;
    	for(int j : g.get(x)) {
    		if(!vis[j]) {
    			dfs(g, n, vis, ans, j);
    			ans[i--] = j;
    		}
    	}
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++
    khans algo topological sort
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
       int indeg[]=new int[N];
       for(ArrayList<Integer> list:adj){
           for(int i:list){
               indeg[i]++;
           }
       }
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<N;i++) if(indeg[i]==0) q.add(i);
       int ans[]=new int[N];
       int k=0;
      while(!q.isEmpty()) {
           int front=q.poll();
           ans[k]=front;
           k++;
           ArrayList<Integer> li=adj.get(front);
           for(int i:li) {
               indeg[i]--;
               if(indeg[i]==0) q.add(i);
           }
      }
      return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++
    Course Schedule II
    public boolean cycle(ArrayList<ArrayList<Integer>> g,int start,boolean vis[]) {

        vis[start]=true;
        //for(int i=0;i<vis.length;i++) System.out.print(vis[i]+" ");
        for(int i :g.get(start)) {
           // System.out.println(i);
            if(vis[i]) {
                return true;
            }
            if( cycle(g,i,vis)) return true;
        }
        vis[start] = false; //[[1,0],[2,0],[0,2]]
        return false;
    }
    public  int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> g=new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            ArrayList<Integer> li=new ArrayList<>();
            g.add(li);
        }
        for(int i=0;i<prerequisites.length;i++) {
            int x=prerequisites[i][0];
            int y=prerequisites[i][1];
            ArrayList<Integer> li=g.get(y);
            li.add(x);
            g.add(li);
            boolean vis[]=new boolean[numCourses];
            if(cycle(g,y,vis)) return new int[0];
        }
        //check cycle

        //for(int i=0;i<numCourses;i++) System.out.print(vis[i]+" ");
        return topoSort(g,numCourses);
    }
    public int[] topoSort(ArrayList<ArrayList<Integer>> g, int n) {
        int ans[] = new int[n];
        boolean vis[] = new boolean[n];
        i = n-1;
        for(int j=0; j<n; j++) {
        	if(!vis[j]) {
        		dfs(g, n, vis, ans, j);
        		ans[i--] = j;
        	}
        }
        return ans;
    }
     int i;
    public void dfs(ArrayList<ArrayList<Integer>> g, int n,boolean vis[], int ans[], int x) {
    	vis[x] = true;
    	for(int j : g.get(x)) {
    		if(!vis[j]) {
    			dfs(g, n, vis, ans, j);
    			ans[i--] = j;
    		}
    	}
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++
    bellman ford
    class GFG {
    static class Pair {
        int u;
        int v;
        int wt;
        Pair(int u,int v,int wt) {
            this.u=u;
            this.v=v;
            this.wt=wt;
        }
    }
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int v=s.nextInt();
		    int e=s.nextInt();
		    int vis[]=new int[v];
		    for(int i=0;i<v;i++) {
		        vis[i]=Integer.MAX_VALUE;
		    }
		    vis[0]=0;
		    Pair a[]=new Pair[e];
		    boolean res=false;
		    for(int i=0;i<e;i++) {
		        int x=s.nextInt();
		        int y=s.nextInt();
		        int wt=s.nextInt();

		        if(x < v && y < v) {
		            Pair p =new Pair(x,y,wt);
		            a[i]=p;
		        }
		        else {
		            res=true;
		            System.out.println("0");
		            break;
		        }
		    }
		    if(res) continue;
		    for(int i=0;i<v-1;i++) {
		        for(int j=0;j<e;j++) {
		            Pair p=a[j];
		            int x=p.u;
		            int y=p.v;
		            int wt=p.wt;
		            if(vis[x]==Integer.MAX_VALUE) continue;
		            if(vis[x]+wt<vis[y]) vis[y]=vis[x]+wt;
		        }
		    }
		     boolean r=false;
		    for(int j=0;j<e;j++) {
		            Pair p=a[j];
		            int x=p.u;
		            int y=p.v;
		            int wt=p.wt;
		            if(vis[x]!=Integer.MAX_VALUE && vis[x]+wt<vis[y]) {
		                r=true;
		                System.out.println("1");
		                break;
		            }
		        }

		    if(!r) {
		        System.out.println("0");
		    }
		}
	}
}
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    rotten oranges
    class Pair {
        int row;
        int col;
        int time;
        Pair(int row,int col,int time) {
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==2) {
                    Pair p=new Pair(i,j,0);
                    q.add(p);
                    grid[i][j]=0;
                }
            }
        }
        int ans=0;
        while(!q.isEmpty()) {
            Pair p=q.poll();
            int row=p.row;
            int col=p.col;
            int time=p.time;
            ans=Math.max(ans,time);
            if(row+1<n&&grid[row+1][col]==1) {
                Pair p1=new Pair(row+1,col,time+1);
                q.add(p1);
                grid[row+1][col]=0;
            }
            if(row-1>=0&&grid[row-1][col]==1) {
                Pair p1=new Pair(row-1,col,time+1);
                q.add(p1);
                grid[row-1][col]=0;
            }
            if(col+1<m&&grid[row][col+1]==1) {
                Pair p1=new Pair(row,col+1,time+1);
                q.add(p1);
                grid[row][col+1]=0;
            }
            if(col-1>=0&&grid[row][col-1]==1) {
                Pair p1=new Pair(row,col-1,time+1);
                q.add(p1);
                grid[row][col-1]=0;
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                   ans=-1;
                }
            }
        }
        return ans;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++
    1020. Number of Enclaves

    class Solution {
    public int numEnclaves(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        for(int i=0;i<m;i++) {
            if(A[0][i]==1) {
                dfs(A,0,i);
            }
        }
        for(int i=0;i<m;i++) {
            if(A[n-1][i]==1) {
                dfs(A,n-1,i);
            }
        }
        for(int i=0;i<n;i++) {
            if(A[i][0]==1) {
                dfs(A,i,0);
            }
        }
        for(int i=0;i<n;i++) {
            if(A[i][m-1]==1) {
                dfs(A,i,m-1);
            }
        }
        int count=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(A[i][j]==1) count++;
            }
        }
        return count;
    }
    public void dfs(int A[][],int i,int j) {
        if(i>=0&&i<A.length&&j>=0&&j<A[0].length&&A[i][j]==1) {
            A[i][j]=0;
            dfs(A,i+1,j);
            dfs(A,i-1,j);
            dfs(A,i,j+1);
            dfs(A,i,j-1);
        }
        else return ;
    }
}
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
01 matrix
class Pair {
        int row;
        int col;
        int dis;
        Pair(int row,int col,int dis) {
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==0) {
                    Pair p=new Pair(i,j,0);
                    q.add(p);
                    grid[i][j]=0;
                }
            }
        }
        int ans[][]=new int[n][m];
        while(!q.isEmpty()) {
            Pair p=q.poll();
            int row=p.row;
            int col=p.col;
            int dis=p.dis;
            ans[row][col]=dis;
            if(row+1<n&&grid[row+1][col]==1) {
                Pair p1=new Pair(row+1,col,dis+1);
                q.add(p1);
                grid[row+1][col]=0;
            }
            if(row-1>=0&&grid[row-1][col]==1) {
                Pair p1=new Pair(row-1,col,dis+1);
                q.add(p1);
                grid[row-1][col]=0;
            }
            if(col+1<m&&grid[row][col+1]==1) {
                Pair p1=new Pair(row,col+1,dis+1);
                q.add(p1);
                grid[row][col+1]=0;
            }
            if(col-1>=0&&grid[row][col-1]==1) {
                Pair p1=new Pair(row,col-1,dis+1);
                q.add(p1);
                grid[row][col-1]=0;
            }
        }
        return ans;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++
    number islandsII
    public int find(int x) {
       if(x==parent[x]) return x;
       int px=find(parent[x]);
       parent[x]=px;
       return px;
   }
   public void union(int x,int y) {
       int lx=find(x);
       int ly=find(y);
       if(lx!=ly) {
           island--;
           if(rank[lx]>rank[ly]) parent[ly]=lx;
           else if(rank[lx]<rank[ly]) parent[lx]=ly;
           else {
               parent[lx]=ly;
               rank[ly]++;
           }
       }
   }
   int parent[];
   int rank[];
    int island=0;
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        if(operators==null || operators.length==0) return new ArrayList<>();
        parent=new int[n*m];
        rank=new int[n*m];
        for(int i=0;i<n*m;i++) {
            parent[i]=i;
            rank[i]=1;
        }
        List<Integer> returnlist=new ArrayList<>();
       int grid[][] = new int[n][m];
        for(int i=0;i<operators.length;i++) {
            int x=operators[i].x;
            int y=operators[i].y;
            int cellno1=x*m+y;
            if(grid[x][y]==1){               //3
                returnlist.add(island);      //3
                continue;                     //[[0,0],[0,1],[2,2],[2,2]]
            }
            grid[x][y]=1;
            island++;
            if(x+1<n&&grid[x+1][y]==1) {
               int cellno2=(x+1)*m+y;
               union(cellno1,cellno2);
            }
            if(x-1>=0&&grid[x-1][y]==1) {
                int cellno2=(x-1)*m+y;
                 union(cellno1,cellno2);
            }
            if(y+1<m&&grid[x][y+1]==1) {
                 int cellno2=x*m+(y+1);
                  union(cellno1,cellno2);
            }
            if(y-1>=0&&grid[x][y-1]==1) {
                int cellno2=x*m+(y-1);
                union(cellno1,cellno2);
            }
            returnlist.add(island);
        }
        return returnlist;
    }
    +++++++++++++++++++++++++++++++++++++++++++
    Regions Cut By Slashes
    class Solution {
  public int find(int x) {
       if(x==parent[x]) return x;
       int px=find(parent[x]);
       parent[x]=px;
       return px;
   }
   public void union(int x,int y) {
       int lx=find(x);
       int ly=find(y);
       if(lx!=ly) {
           if(rank[lx]>rank[ly]) parent[ly]=lx;
           else if(rank[lx]<rank[ly]) parent[lx]=ly;
           else {
               parent[lx]=ly;
               rank[ly]++;
           }
       }else count++;
   }
   int parent[];
   int rank[];
   int count;
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        parent=new int[(n+1)*(n+1)];
        rank=new int[(n+1)*(n+1)];
        for(int i=0;i<(n+1)*(n+1);i++) {
            parent[i]=i;
            rank[i]=1;
        }
         for(int i=0; i<n+1; i++) {
        	union(0, i); //0 row
        	union(0, (n*(n+1))+i); // n-1 row
        	union(0, (n+1)*i);  // 0 col
        	union(0, (n+1)*i+n);  // n-1 col
        }
        int ans=1; //region made by boundary
        for(int i=0;i<n;i++) {
            for(int j=0; j<grid[i].length();j++) {
                if(grid[i].charAt(j)=='/') {
                    int posA = (i+1)*(n+1)+j;
        			int posB = i*(n+1)+j+1;
                    int a = find(posA), b = find(posB);
        			if(a==b) ans++;
                    else union(posA, posB);
                }
                else if(grid[i].charAt(j)=='\\') {
                    int posA = i*(n+1)+j;
        			int posB = (i+1)*(n+1)+j+1;
                    int a = find(posA), b = find(posB);
        			if(a==b) ans++;
                    else union(posA, posB);

                }
            }
        }
        return ans;
    }
}
    +++++++++++++++++++++++++++++++++++++++++++
     Most Stones Removed with Same Row or Column
    class Solution {
   public int find(int x) {
       if(x==parent.get(x)) return x;
       int px=find(parent.get(x));
       parent.put(x,px);
       return px;
   }
   public void union(int x,int y) {
       int lx=find(x);
       int ly=find(y);
       if(lx!=ly) {
           set--;
           if(rank.get(lx)>rank.get(ly)) parent.put(ly,lx);
           else if(rank.get(lx)<rank.get(ly)) parent.put(lx,ly);
           else {
               parent.put(lx,ly);
               rank.put(ly,rank.get(ly)+1);
           }
       }
   }
    HashMap<Integer,Integer> parent;
    HashMap<Integer,Integer> rank;
    int set;
    public int removeStones(int[][] stones) {
        parent=new HashMap<>();
        rank=new HashMap<>();
        int n=stones.length;
        set=0;
        for(int i=0;i<n;i++) {
            int row=stones[i][0];
            int col=-stones[i][1]-1;
            if(!parent.containsKey(row)) {
                set++;
                parent.put(row,row);
                rank.put(row,1);
            }
            if(!parent.containsKey(col)) {
                parent.put(col,col);
                set++;
                rank.put(col,1);
            }
            union(row,col);
        }
        return n-set;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++
    Kruskal’s algo find for MST
class Main
{
	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		int wt;
		public Pair(int x, int y,int wt) {
			this.x=x;
			this.y=y;
			this.wt=wt;
		}
		@Override
		public int compareTo(Pair p) {
			if(this.wt<p.wt) {
				return -1;
			}else if(this.wt>p.wt) {
				return 1;
			}
			else {
				return this.x-p.x;
			}
		}
	}
	public static int find(int x) {
		if(x==parent[x]) return x;
		int px=find(parent[x]);
		parent[x]=px;
		return px;
	}
	public static void union(int a,int b) {
		int lx=find(a);
		int ly=find(b);
		if(lx!=ly) {
			if(rank[lx]>rank[ly]) {
				parent[ly]=lx;
			}else if(rank[lx]<rank[ly]) {
				parent[lx]=ly;
			}else {
				parent[lx]=ly;
				rank[ly]++;
			}
		}
	}
	static int parent[];
	static int rank[];
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int v=s.nextInt();
		int e=s.nextInt();
		parent=new int[v+1];
		rank=new int[v+1];
		Arrays.fill(rank,1);
		for(int i=0;i<=v;i++) {
			parent[i]=i;
		}
		 Pair pair[]=new Pair[e];
	    for(int i=0;i<e;i++) {
	    	int x=s.nextInt();
	    	int y=s.nextInt();
	    	int weight=s.nextInt();
	    	pair[i]=new Pair(x,y,weight);
	    }
	    Arrays.sort(pair);
	    int ans=0;
	    for(int i=0;i<e;i++) {
	    	int x=pair[i].x;
	    	int y=pair[i].y;
	    	int wt=pair[i].wt;
	    	int lx=find(x);
	    	int ly=find(y);
	    	if(lx==ly) continue;
	    	union(x,y);
	    	ans+=wt;
	    }
	    System.out.println(ans);
        s.close();
	}
}
    +++++++++++++++++++++++++++++++++++++++++++++++++++
    Job Sequencing Problem
    class GFG
{   
	static class Pair implements Comparable<Pair> {

	int jobid;
	int dead;
	int profit;
	Pair(int jobid,int dead,int profit) {
		this.jobid=jobid;
		this.dead=dead;
		this.profit=profit;
	}
	@Override
	public int compareTo(Pair p) {
		return p.profit-this.profit;
	}
	}
	public static int find(int x) {
		if(x==parent[x]) return x;
		int px=find(parent[x]);
		parent[x]=px;
		return px;
	}
	public static void union(int x,int y) {
		int lx=find(x);
		int ly=find(y);
		if(lx!=ly) {
            parent[ly]=lx;
		}
	}
	static int parent[];
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			Pair p[]=new Pair[n];
			int max=Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				int x=s.nextInt();
				int y=s.nextInt();
				max=Math.max(max,y);
				int z=s.nextInt();
				p[i]=new Pair(x,y,z);
			}
			Arrays.sort(p);
			parent=new int[max+1];
			for(int i=0;i<=max;i++) {
				parent[i]=i;
			}
			int ans=0;
			for(int i=0;i<n;i++) {
			   int lx=find(p[i].dead);
			   if(lx==0) continue;
			   ans+=p[i].profit;
			   union(find(lx-1),lx); 
			}
			System.out.println(ans);
		}
		s.close();
	}
}
    +++++++++++++++++++++++++++++++++++++++++++++++++++
Word Ladder
static class Pair {
        String word;
        int count;
        Pair(String word,int count) {
            this.word=word;
            this.count=count;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordset=new HashSet<>();
        for(String str:wordList) {
           wordset.add(str);
        }
        Queue<Pair> q=new LinkedList<>();
        Pair p=new Pair(beginWord,1);
        q.add(p);
        while(!q.isEmpty()) {
            Pair p1=q.poll();
            String word=p1.word;
            int count=p1.count;
            if(word.equals(endWord)) {
                return count;
            }
            wordset.remove(word);
            int n=word.length();
            for(int i=0;i<n;i++) {
                for(int j=0;j<26;j++) {
                   String y = word.substring(0,i) +(char)(j+'a') + word.substring(i+1,n);
                    if(wordset.contains(y)) {
                        wordset.remove(y);
                       Pair p2=new Pair(y,count+1);
                       q.add(p2);
                    }
                }
            }
        }
        return 0;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Eulerian Path in an Undirected Graph 
    public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		    int n=s.nextInt();
		    int even=0;
		    int odd=0;
		    for(int i=0;i<n;i++) {
		        int sum=0;
		        for(int j=0;j<n;j++) {
		           sum+=s.nextInt();
		        }
		        if(sum%2==0) even++;
		        else odd++;
		    }
		    if(odd==2){
		        System.out.println("1");
		    }
		    else {
		        System.out.println("0");
		    }
		}
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Euler Circuit in a Directed Graph
    public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int v=s.nextInt();
		int e=s.nextInt();
		int indeg[]=new int[v];
		int outdeg[]=new int[v];
		for(int i=0;i<e;i++) {
			int x=s.nextInt();
			int y=s.nextInt();
			outdeg[x]++;
			indeg[y]++;
		}
		boolean r=false;
		for(int i=0;i<v;i++) {
			if(indeg[i]!=outdeg[i]){
				r=true;
				System.out.println("0");
			} 
		}
		if(!r) System.out.println(1);
		s.close();
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Redundant Connection
    public int find(int x) {
       if(x==parent.get(x)) return x;
       int px=find(parent.get(x));
       parent.put(x,px);
       return px;
   }
   public void union(int x,int y) {
       int lx=find(x);
       int ly=find(y);
       if(lx!=ly) {
           
           if(rank.get(lx)>rank.get(ly)) parent.put(ly,lx);
           else if(rank.get(lx)<rank.get(ly)) parent.put(lx,ly);
           else {
               parent.put(lx,ly);
               rank.put(ly,rank.get(ly)+1);
           }
       }
   }
    HashMap<Integer,Integer> parent;
    HashMap<Integer,Integer> rank;
    public int[] findRedundantConnection(int[][] edges) {
         parent=new HashMap<>();
        rank=new HashMap<>();
        int n=edges.length;
        for(int i=0;i<n;i++) {
            int x=edges[i][0];
            int y=edges[i][1];
            if(!parent.containsKey(x)) {
               parent.put(x,x);
               rank.put(x,1);
            }
            if(!parent.containsKey(y)) {
               parent.put(y,y); 
                rank.put(y,1);
            }
            int a=find(x);
            int b=find(y);
            if(a==b) return edges[i];
            union(x,y);
        }
        return new int[0];
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Redundant Connection II
    public int find(int x) {
       if(x==parent[x]) return x;
       int px=find(parent[x]);
       parent[x]=px;
       return px;
   }
   public void union(int x,int y) {
       int lx=find(x);
       int ly=find(y);
       if(lx!=ly) {
           parent[lx]=ly;
       }
   }
   int parent[];
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n=edges.length;
        parent=new int[n+1];
        int indeg[]=new int[n+1];
        Arrays.fill(indeg,-1);
        int blacklist=-1;
        for(int i=1;i<=n;i++) {
            parent[i]=i;
            int x=edges[i-1][0];
            int y=edges[i-1][1];
            if(indeg[y]!=-1) blacklist=i-1;
            else indeg[y]=i-1;   
        }
        for(int i=1;i<=n;i++) {
            if(blacklist==i-1) continue;
            int x=edges[i-1][0];
            int y=edges[i-1][1];
            int a=find(x);
            int b=find(y);
            if(blacklist==-1&&a==b) return edges[i-1];
            if(a==b) return edges[indeg[edges[blacklist][1]]];
            union(a,b);
        }
       return edges[blacklist]; 
    }    
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Sliding Puzzle
    static class Pair{
        String str;
        int count;
        Pair(String str,int count){
            this.str=str;
            this.count=count;
        }
    }
    public String swap(String s,int i,int j) {
       // System.out.println("swap");
        if(i==j) return s;
        //if(i>j) return swap(s,j,i);
		// return s.substring(0,i)+s.charAt(j)+
		// s.substring(i+1,j)+s.charAt(i)+s.substring(j+1);
       String temp = s.substring(0,i) + s.charAt(j) + s.substring(i+1 , j) + s.charAt(i);
        if((j+1)!=s.length()){
            temp+= s.substring(j+1);
        }
        return temp;


    }

    public int slidingPuzzle(int[][] board) {
        String A="";
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                A+=board[i][j];
            }
        }
        String B="123450";
        int storage[][]={{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        HashSet<String> set=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        set.add(A);
        q.add(new Pair(A,0));
        while(!q.isEmpty()) {
            Pair p=q.poll();
            String front=p.str;
            int count=p.count;
             if(front.equals(B)) return count;
            int index=-1;
            for(int i=0;i<B.length();i++) {
                if(front.charAt(i)=='0')  {
                    index=i;
                    break;
                }

            }
            for(int i:storage[index]) {
                //System.out.print(i+" ");
                String temp="";
                if(i<index) temp=swap(front,i,index);
                else temp=swap(front,index,i);
                if(!set.contains(temp)) {
                    q.add(new Pair(temp,count+1));
                    set.add(temp);
                }
            }
        }
      return -1;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Sentence Similarity
     public int find(int x) {
       if(x==parent.get(x)) return x;
       int px=find(parent.get(x));
       parent.put(x,px);
       return px;
   }
   public void union(int x,int y) {
       int lx=find(x);
       int ly=find(y);
       if(lx!=ly) {
          parent.put(lx,ly);
       }
   }
    HashMap<Integer,Integer> parent;
    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
       parent=new HashMap<>();
       HashMap<String,Integer> map=new HashMap<>();
       int count=0;
       for(List<String> list:pairs) {
            String one=list.get(0);
            String two=list.get(1);
            if(!map.containsKey(one)) {
                parent.put(count,count);
                map.put(one,count);
                count++;
            }
            if(!map.containsKey(two)) {
                 parent.put(count,count);
                map.put(two,count);
                count++;
            }
            union(map.get(one),map.get(two));
       }
       for(int i=0;i<words1.length;i++) {
           if(!map.containsKey(words1[i])||!map.containsKey(words2[i])) return false;
           if(find(map.get(words1[i]))!=find(map.get(words2[i]))) return false;
       }
       return true;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Sort Items by Groups Respecting Dependencies
    public ArrayList<Integer> toplogicalSort(int start,int n) {    
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int front=q.poll();
            count++;
            if(front<n) returnlist.add(front);
            for(int j:map.get(front)) {
                indeg[j]--;
                if(indeg[j]==0) q.add(j);
            }
        }
        
        return returnlist;
    }
    int indeg[];
    int count = 0;
    ArrayList<Integer> returnlist;
    HashMap<Integer,HashSet<Integer>> map;
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        map=new HashMap<>();
        for(int i=0;i<n+m*2;i++){
            map.put(i,new HashSet<>());
        }
        for(int i=0;i<group.length;i++) {
          if(group[i]!=-1) {
            int sp=n+group[i];
            int ep=n+group[i]+m;
            map.get(sp).add(i);
            map.get(i).add(ep);
          }
        }
        for(int i=0;i<beforeItems.size();i++) {
            for(int item:beforeItems.get(i)) {
                int grpofbeforeitem=group[item];
                int grpofcurr=group[i];
                if(grpofbeforeitem==-1&&grpofcurr==-1) {
                    map.get(item).add(i);
                }
                else if(grpofbeforeitem==-1) {
                     int sp=n+grpofcurr;
                     map.get(item).add(sp);
                }
                else if(grpofcurr==-1) {
                    int ep=n+m+grpofbeforeitem;
                    map.get(ep).add(i);
                }
                else {
                    if(grpofbeforeitem==grpofcurr) {
                        map.get(item).add(i);
                    }else {
                        int sp=n+grpofcurr;
                         int ep=n+m+grpofbeforeitem;
                         map.get(ep).add(sp);
                    }
                }
            }
        }
        indeg=new int[map.size()];
        for(int i=0;i<map.size();i++) {
            for(int j:map.get(i)) {
                indeg[j]++;
            }
        }
        Queue<Integer> temp=new LinkedList<>();
        for(int i=0;i<map.size();i++) {
            if(indeg[i]==0){
                temp.add(i);
            }
        }
        returnlist=new ArrayList<>();
        while(!temp.isEmpty()) {
           ArrayList<Integer> temp2= toplogicalSort(temp.poll(),n);
        }
        if(count!=map.size()) { //if cycle is form in topollogical sort
            return new int[0];
        }
        int a[]=new int[returnlist.size()];
        int k=0;
        for(int i:returnlist) {
            a[k]=i;
            k++;
        }
        return a; 
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    As Far from Land as Possible
    static class Pair {
        int row;
        int col;
        int count;
        Pair(int row,int col,int count) {
            this.row=row;
            this.col=col;
            this.count=count;
        }
    }
    public int maxDistance(int[][] grid) {
        //0-1 BFS
       Queue<Pair> q=new LinkedList<>(); 
       int n=grid.length;
        int m=grid[0].length;
       for(int i=0;i<n;i++) {
          for(int j=0;j<m;j++) {
              if(grid[i][j]==1) {
                   //System.out.println("Row "+ i+"Col "+ j+"count "+0);
                  q.add(new Pair(i,j,0));
              }
          } 
       }
        if(q.isEmpty()||q.size()==n*m) return -1;
        int max=Integer.MIN_VALUE;
       while(!q.isEmpty()) {
           Pair p=q.poll();
           int row=p.row;
           int col=p.col;
           int count=p.count;
           //System.out.println("Row "+ row+"Col "+ col+"count "+count);
           max=Math.max(count,max);
           if(row+1<n&&grid[row+1][col]==0) {
              q.add(new Pair(row+1,col,count+1));
               grid[row+1][col]=1;
           }
           if(row-1>=0&&grid[row-1][col]==0) {
               q.add(new Pair(row-1,col,count+1));
               grid[row-1][col]=1;
           }
           if(col+1<m&&grid[row][col+1]==0) {
               q.add(new Pair(row,col+1,count+1));
               grid[row][col+1]=1;
           }
           if(col-1>=0&&grid[row][col-1]==0) {
               q.add(new Pair(row,col-1,count+1));
               grid[row][col-1]=1;
           }
       } 
        return max;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Possible Bipartition
      boolean vis[];
    boolean grp[];
    public boolean isBipartite(int n,ArrayList<Integer> a[]) {
        vis=new boolean[n+1];
        grp=new boolean[n+1];
        for(int i=1;i<a.length;i++) {
            if(!vis[i]) {
                boolean ans=helper(a,i);
                if(!ans) return false;
            }
        }
        return true;
    }
    public boolean helper(ArrayList<Integer> a[],int si) {
        vis[si]=true;
        grp[si]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(si);
        while(!q.isEmpty()) {
            int front=q.poll();
            ArrayList<Integer> li=a[front];
             for(int i:li) {
                 if(!vis[i]) {
                     vis[i]=true;
                     grp[i]=!grp[front];
                     q.add(i);
                 }
                 else {
                     if(grp[i]==grp[front]) return false;
                 }
             }
        }
        return true;
    }
    public boolean possibleBipartition(int N, int[][] dislikes) {
        ArrayList<Integer> a[]=new ArrayList[N+1];
        for(int i=0;i<=N;i++) {
            a[i]=new ArrayList<>();
        }
        for(int i=0;i<dislikes.length;i++) {
            int x=dislikes[i][0];
            int y=dislikes[i][1];
            ArrayList<Integer> li=a[x];
            ArrayList<Integer> l2=a[y];
            li.add(y);
            a[x]=li;
            l2.add(x);
            a[y]=l2;
        }
        return isBipartite(N,a);
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Shortest Bridge
    static class Pair {
        int row;
        int col;
        int dis;
        Pair(int row,int col,int dis) {
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public void dfs(int[][] A,int i,int j,int rep) {
        int n=A.length;
        int m=A[0].length;
        A[i][j]=rep;
        if(i+1<n&&A[i+1][j]==1) {
            dfs(A,i+1,j,rep);
        }
        if(i-1>=0&&A[i-1][j]==1) {
            dfs(A,i-1,j,rep);
        }
        if(j+1<m&&A[i][j+1]==1) {
            dfs(A,i,j+1,rep);
        }
        if(j-1>=0&&A[i][j-1]==1) {
            dfs(A,i,j-1,rep);
        }
    }
    public int shortestBridge(int[][] A) {
        int count=2;
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A[i].length;j++) {
                if(A[i][j]==1) {
                    dfs(A,i,j,count);
                    count++;
                }
            }
        }
        
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A[i].length;j++) {
                if(A[i][j]==2) {
                    //System.out.println("i:"+i+" j:"+j+" 0");
                    q.add(new Pair(i,j,0));
                }
            }
        }
        // for(int i=0;i<A.length;i++) {
        //     for(int j=0;j<A[i].length;j++) {
        //         System.out.print(A[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int n=A.length;
        int m=A[0].length;
        int min=Integer.MAX_VALUE;
        while(!q.isEmpty()) {
           Pair p=q.poll();
           int row=p.row;
           int col=p.col;
           int dis=p.dis;
          
            if(A[row][col]==3) {
                 System.out.println("i:"+row+" j:"+col+" dis:"+dis);
                 
            }
           if(row+1<n) {
               if(A[row+1][col]==0)  {
                   q.add(new Pair(row+1,col,dis+1));
                    A[row+1][col]=A[row][col];
               }else if(A[row+1][col]==3) min=Math.min(dis,min);  
           }
           if(row-1>=0) {
               if(A[row-1][col]==0)  {
                   q.add(new Pair(row-1,col,dis+1));
                    A[row-1][col]=A[row][col];
               }else if(A[row-1][col]==3) min=Math.min(dis,min); 
           }
           if(col+1<m) {
               if(A[row][col+1]==0)  {
                   q.add(new Pair(row,col+1,dis+1));
                   A[row][col+1]=A[row][col];
               }else if(A[row][col+1]==3) min=Math.min(dis,min);  
           }
           if(col-1>=0) {
               if(A[row][col-1]==0)  {
                  q.add(new Pair(row,col-1,dis+1));
                  A[row][col-1]=A[row][col];
               }else if(A[row][col-1]==3) min=Math.min(dis,min);  
           }
       } 
        return min;
        
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Floyd Warshall
    class GFG {
	static int INF = Integer.MAX_VALUE;
	static void print(int[][] a) {
		int m = a.length, n = a[0].length;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j]==1e7) {
					System.out.print("INF ");
				} else {
					System.out.print(a[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	static void floyd(int a[][]) {
		int n = a.length;
		for(int k=0; k<n; k++) {
			for(int x=0; x<n; x++) {
				if(x==k) continue;
				for(int y=0; y<n; y++) {
					if(y==k) continue;
					if(a[x][k]==INF || a[k][y]==INF) continue;
					a[x][y] = Math.min(a[x][y], a[x][k]+a[k][y]);
				}
			}
		}
	}

	public static void main(String[] args) {
		//System.out.println();
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
		    int n=sc.nextInt();
    		int a[][]=new int[n][n];
    		for(int i=0;i<n;i++) {
    		    for(int j=0;j<n;j++) {
    		        String str=sc.next();
    		         if(str.equals("INF")) {
    		             a[i][j]=INF;
    		         }
    		         else  {
    		             a[i][j]=Integer.parseInt(str);
    		         }
    		    }
    		}
            floyd(a);
             print(a);
		}
    }
    // with adjacency list but not submitted
    static int INF = Integer.MAX_VALUE;
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
		   ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		   int n=s.nextInt();
		   for(int i=0;i<=n;i++) {
		       adj.add(new ArrayList<>());
		   }
		   for(int i=1;i<=n;i++) {
		       for(int j=0;j<n;j++) {
		              String str=s.next();
    		         if(str.equals("INF")) adj.get(i).add(INF);
    		         else adj.get(i).add(Integer.parseInt(str));
		       }
		   }
		   for(int k=1;k<=n;k++) {
		       for(int u=1;u<=n;u++) {
		           if(u==k) continue;
		           for(int v=1;v<=n;v++) {
		               if(v==k) continue;
		             if(adj.get(u).get(k-1)==INF||adj.get(k).get(v-1)==INF) continue;
		             int x=Math.min(adj.get(u).get(v-1),adj.get(u).get(k-1)+adj.get(k).get(v-1));
		            adj.get(u).set(v-1,x);
		           }
		       }
		   }
		   for(int i=1;i<=n;i++) {
		       for(int j:adj.get(i)) {
		           if(j==1e7) {
					   System.out.print("INF ");
    				} else {
    					System.out.print(j+" ");
    				}
		       }
		       System.out.println();
		   }
		}
    } 
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Similar String Groups
    class Solution {
    public int find(int x) {
       if(x==parent.get(x)) return x;
       int px=find(parent.get(x));
       parent.put(x,px);
       return px;
   }
   public void union(int x,int y) {
       int lx=find(x);
       int ly=find(y);
       if(lx!=ly) {
           parent.put(lx,ly);
       }
   }
    HashMap<Integer,Integer> parent;
    public int numSimilarGroups(String[] A) {
        parent=new HashMap<>();
        HashMap<String,Integer> map=new HashMap<>();
        int kx = 0;
        for(String x : A) {
            if(!map.containsKey(x))  map.put(x,kx++);
        }
        for(int i=0;i<map.size();i++) {
            parent.put(i,i);
        }
        String temp[]=new String[map.size()];
        int l=0;
        for(Map.Entry<String,Integer> ho:map.entrySet()) {
            temp[l]=ho.getKey();
            l++;
        }
        int ans=temp.length;
        for(int i=0;i<temp.length-1;i++) {
            String str=temp[i];
           for(int j=i+1;j<temp.length;j++) {
               String str2=temp[j];
               if(str.length()!=str2.length()) continue;
               else {
                   int count=0;
                   for(int k=0;k<str.length();k++) {
                       if(str.charAt(k)!=str2.charAt(k)) count++;
                   }
                  // System.out.println(count);
                   if(count==2) {
                       if(find(map.get(str))!=find(map.get(str2))){
                            union(map.get(str),map.get(str2));
                            ans--;
                       }
                   }
               }

           }
        }
        return ans;
    }
}
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Reconstruct Itinerary
    public void dfs(String s) {
       // ArrayList<String> list=map.get(s);
        int size = map.get(s).size();
    	if(size<=0) return;
    	while(map.get(s).size()>0){
            String x = map.get(s).remove(map.get(s).size()-1);
    	    dfs(x);
        	l.add(x);
        }
    }
    List<String> l;
    HashMap<String ,ArrayList<String>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        map=new HashMap<>();
        for(List<String> p:tickets) {
            String x = p.get(0), y = p.get(1);
    		if(!map.containsKey(x)) {
    			map.put(x, new ArrayList<>());
    		}
    		if(!map.containsKey(y)) {
    			map.put(y, new ArrayList<>());
    		}
    		map.get(x).add(y);
        }
        for(Map.Entry<String,ArrayList<String>> hi:map.entrySet()) {
            Collections.sort(hi.getValue(), Collections.reverseOrder());
        }
        l=new ArrayList<>();
        if(!map.containsKey("JFK")) return l;
        dfs("JFK");
        l.add("JFK");
        Collections.reverse(l);
        return l;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Doctor Strange
    class GFG {
    static int parent[];
    static boolean point[];
    static int discovery[];
    static int low[];
    static int time;
    static boolean vis[];
    static int ap;
    static int source;
    static int children;
    public static void dfs(ArrayList<Integer> al[],int start) {
        int child = 0;
        vis[start]=true;
        discovery[start]=time;
        low[start] = time;
        time++;
        ArrayList<Integer> list=al[start];
        for(int i:list) {
            if(i==parent[start]) continue;


            if(!vis[i]) { //negibour not visted
                 child++;

                parent[i]=start;
                dfs(al,i);
                low[start]=Math.min(low[start],low[i]);
                if(parent[start]==-1 && child>1) {
                    point[start] = true;
                }
                if(parent[start]!=-1&&discovery[start]<=low[i]) {
                    point[start] = true;
                }
            }
            else {
                low[start]=Math.min(low[start],discovery[i]);
            }
        }
    }

	public static void main (String[] args) {
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
	   while(t-->0) {
	       int v=s.nextInt();
	       int e=s.nextInt();
	       ArrayList<Integer> al[]=new ArrayList[v+1];
	       for(int i=0;i<=v;i++){
	           al[i]=new ArrayList<>();
	       }
	       for(int i=0;i<e;i++) {
	           int x=s.nextInt();
	           int y=s.nextInt();
	           al[x].add(y);
	           al[y].add(x);
	       }
	       parent=new int[v+1];
	       point=new boolean[v+1];
	       discovery=new int[v+1];
	       low=new int[v+1];
	       vis=new boolean[v+1];
	       time=1;
	       ap=0;
	       children=0;
	       for(int i=1;i<=v;i++) {
	           low[i]=i;
	           parent[i] = -1;
	       }
	       for(int i=1;i<=v;i++) {
	           if(!vis[i]) {
	               //source=i;
	               dfs(al,i);
	           }
	       }
	       ap = 0;
	       //for(i)
	       //System.out.println("discovery");
	       for(int i=1;i<=v;i++) {
	         if(point[i]) ap++;
	       }
	       //System.out.println();
	       //System.out.println("parent");
	       //for(int i=1;i<=v;i++) {
	       //   System.out.print(parent[i]+" ");
	       //}
	       //System.out.println();
	       //System.out.println("low");
	       //for(int i=1;i<=v;i++) {
	       //   System.out.print(low[i]+" ");
	       //}
	       //if(children>=2) ap++;
	       System.out.println(ap);
	   }
	}
}
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Coloring A Border
    public void dfs(int[][] grid,int r0,int c0,int color,int org) {
        int n=grid.length;
        int m=grid[0].length;
        vis[r0][c0]=true;
        grid[r0][c0]=color;
        int count=0;
        if(c0+1<m&&(grid[r0][c0+1]==org||vis[r0][c0+1])) {
            if(!vis[r0][c0+1]) dfs(grid,r0,c0+1,color,org);
            count++;
        }
        if(r0+1<n&&(grid[r0+1][c0]==org||vis[r0+1][c0])) {
            if(!vis[r0+1][c0]) dfs(grid,r0+1,c0,color,org);
            count++;
        }
        if(c0-1>=0&&(grid[r0][c0-1]==org||vis[r0][c0-1])) {
            if(!vis[r0][c0-1]) dfs(grid,r0,c0-1,color,org);
            count++;
            
        }
        if(r0-1>=0&&(grid[r0-1][c0]==org||vis[r0-1][c0])) {
            if(!vis[r0-1][c0])  dfs(grid,r0-1,c0,color,org);
            count++; 
        }
        if(count==4) {
            grid[r0][c0]=org;
        }
    }
    boolean vis[][];
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int n=grid.length;
        int m=grid[0].length;
        vis=new boolean[n][m];
        dfs(grid,r0,c0,color,grid[r0][c0]);
        return grid;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Walls and Gates
    class Pair {
        int row;
        int col;
        int time;
        Pair(int row,int col,int time) {
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    int INF=2147483647;
    public void wallsAndGates(int[][] grid) {
         Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==0) {
                    Pair p=new Pair(i,j,0);
                    q.add(p);
                    grid[i][j]=0;
                }
            }
        }
        int ans=0;
        while(!q.isEmpty()) {
            Pair p=q.poll();
            int row=p.row;
            int col=p.col;
            int time=p.time;
            // grid[row][col]=Math.min(ans,time);
            if(row+1<n&&grid[row+1][col]==INF) {
                Pair p1=new Pair(row+1,col,time+1);
                q.add(p1);
                grid[row+1][col]=Math.min(grid[row+1][col],time+1);
            }
            if(row-1>=0&&grid[row-1][col]==INF) {
                Pair p1=new Pair(row-1,col,time+1);
                q.add(p1);
                grid[row-1][col]=Math.min(grid[row-1][col],time+1);
            }
            if(col+1<m&&grid[row][col+1]==INF) {
                Pair p1=new Pair(row,col+1,time+1);
                q.add(p1);
                grid[row][col+1]=Math.min(grid[row][col+1],time+1);
            }
            if(col-1>=0&&grid[row][col-1]==INF) {
                Pair p1=new Pair(row,col-1,time+1);
                q.add(p1);
                grid[row][col-1]=Math.min(grid[row][col-1],time+1);
            }
        }
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     K-Similar Strings
         String st;
        int count;
        Pair(String st,int count) {
            this.st=st;
            this.count=count;
        }
    } 
    public String swap(String st,int i,int j) {
        if(j==st.length()-1)  return st.substring(0,i)+st.charAt(j)+st.substring(i+1,j)+st.charAt(i);
        return st.substring(0,i)+st.charAt(j)+st.substring(i+1,j)+st.charAt(i)+st.substring(j+1);
    }
    public int kSimilarity(String A, String B) {
        Queue<Pair> q=new LinkedList<>();
        int n=A.length();
        q.add(new Pair(A,0));
        while(!q.isEmpty()) {
            Pair p=q.poll();
            String st=p.st;
            int count=p.count;
            if(st.equals(B)) return count;
            for(int i=0;i<n-1;i++) {
                if(st.charAt(i)!=B.charAt(i)) {
                    for(int j=i+1;j<n;j++) {
                        if(B.charAt(i)==st.charAt(j)) {
                           q.add(new Pair(swap(st,i,j),count+1));
                        }
                    }
                    break;
                }
            }
        }
        return 0;
    }
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Sliding Puzzle
    static class Pair{
        String str;
        int count;
        Pair(String str,int count){
            this.str=str;
            this.count=count;
        }
    }
    public String swap(String s,int i,int j) {
        String temp = s.substring(0,i) + s.charAt(j) + s.substring(i+1 , j) + s.charAt(i);
        if(j==s.length()-1) return temp;
        return temp+s.substring(j+1); 
    }
    
    public int slidingPuzzle(int[][] board) {
        String A="";
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                A+=board[i][j];
            }
        }
        String B="123450";
        int storage[][]={{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        HashSet<String> set=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        set.add(A);
        q.add(new Pair(A,0));
        while(!q.isEmpty()) {
            Pair p=q.poll();
            String front=p.str;
            int count=p.count;
             if(front.equals(B)) return count;
            int index=-1;
            for(int i=0;i<B.length();i++) {
                if(front.charAt(i)=='0')  {
                    index=i;
                    break;
                }
            }
            for(int i:storage[index]) {
                String temp="";
                if(i<index) temp=swap(front,i,index);
                else temp=swap(front,index,i);
                if(!set.contains(temp)) {
                    q.add(new Pair(temp,count+1));
                    set.add(temp);
                } 
            }
        }
      return -1;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Minimum Swaps to Sort
    static class Pair implements Comparable<Pair> {
        int data;
        int index;
        Pair(int data,int index) {
            this.data=data;
            this.index=index;
        }
        @Override 
        public int compareTo(Pair o) {
            return this.data-o.data;
        } 
    }
	public int minSwaps(int[] arr, int N) {
	    Pair a[]=new Pair[N];
	    for(int i=0;i<N;i++) {
	        a[i]=new Pair(arr[i],i);
	    }
	    Arrays.sort(a);
	    boolean vis[]=new boolean[N];
	    int mov=0;
	    for(int i=0;i<N;i++) {
	        if(a[i].index!=i&&!vis[i]) {
	            int cycle=0;
	            int j=i;
	            while(!vis[j]) {
	                vis[j]=true;
	                j=a[j].index;
	                cycle++;
	            }
	            cycle--;
	           mov+=cycle;
	        }else vis[i]=true;
	    }
	    return mov;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Minimize Malware Spread
    public int minMalwareSpread(int[][] graph, int[] initial) {
       set=new HashSet<>();
       for(int i:initial) set.add(i);
       int n=graph.length;
       boolean vis[]=new boolean[n];
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<n;i++) {
           if(!vis[i]) {
               count=0;
               val=-1;
               size=0;
               dfs(graph,i,vis);
               if(count==1) {
                   map.put(val,size); 
               }
           }
       }
      Arrays.sort(initial);
    if(map.size()==0) return initial[0];
        int ans=Integer.MAX_VALUE;
        int anscount=0;
        for(int i:map.keySet()) {
            if(anscount<map.get(i)) {
               anscount=map.get(i);
               ans=i;
            }
            else if(anscount==map.get(i)) {
                if(i<ans) ans=i;
            }
        }
        return ans;
    }
    int count;
    int val;
    int size;
    HashSet<Integer> set;
    public void dfs(int[][] graph,int st,boolean vis[]) {
       if(set.contains(st)) {
           val=st;
           count++;
        }
        vis[st]=true;
        size++;
       for(int i=0;i<graph.length;i++) {
           if(graph[st][i]==1&&!vis[i]) {
               dfs(graph,i,vis);
           } 
       }
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Find the Maximum Flow
    static int n, e, g[][];
	static void maxFlow() {
		int ans = 0, src = 0, dest = n-1;
		while(true) {
			//bfs part
			int par[] = new int[n];
			for(int i=0; i<n; i++) par[i] = -1;
			Queue<Integer> q = new LinkedList<>();
			q.add(src);
			par[src] = src;
			while(!q.isEmpty()) {
				int i = q.poll();
				for(int j=0; j<n; j++) {
					if(g[i][j]==0 || par[j]!=-1) continue;
					par[j] = i;
					q.add(j);
				}
			}
			if(par[dest]==-1) break;
			//evaluation
			int min = Integer.MAX_VALUE;
			for(int i=dest; i!=src; i=par[i]) {
				int j = par[i];
				min = Math.min(min, g[j][i]);
			}
			for(int i=dest; i!=src; i=par[i]) {
				int j = par[i];
				g[j][i] -= min;
				g[i][j] += min;
			}	
			ans += min;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		//System.out.println();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			e = sc.nextInt();
			g = new int[n][n];
			for(int i=0; i<e; i++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				int wt = sc.nextInt();
				g[x][y] += wt;
				g[y][x] += wt;
			}
			maxFlow();
		}
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Reconstruct Itinerary
    public void dfs(String s) {
       // ArrayList<String> list=map.get(s);
        int size = map.get(s).size();
    	if(size<=0) return;
    	while(map.get(s).size()>0){
            String x = map.get(s).remove(map.get(s).size()-1);
    	    dfs(x);
        	l.add(x);
        }
    }
    List<String> l;
    HashMap<String ,ArrayList<String>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        map=new HashMap<>();
        for(List<String> p:tickets) {
            String x = p.get(0), y = p.get(1);
    		if(!map.containsKey(x)) {
    			map.put(x, new ArrayList<>());
    		}
    		if(!map.containsKey(y)) {
    			map.put(y, new ArrayList<>());
    		}
    		map.get(x).add(y);
        }
        for(Map.Entry<String,ArrayList<String>> hi:map.entrySet()) {
            Collections.sort(hi.getValue(), Collections.reverseOrder());
        }
        l=new ArrayList<>();
        if(!map.containsKey("JFK")) return l;
        dfs("JFK");
        l.add("JFK");
        Collections.reverse(l);
        return l;
    }
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
*/
}
