
public class Trees {

    /*
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans=new ArrayList<>();
            TreeNode curr=root;
            while(curr!=null) {
                if(curr.left==null) {
                    ans.add(curr.val);
                    curr=curr.right;
                }else {
                    TreeNode currp1=curr.left;
                    while(currp1.right!=null&&currp1.right!=curr) {
                        currp1=currp1.right;
                    }
                    if(currp1.right==null) {
                        currp1.right=curr;
                        curr=curr.left;
                    }
                    else {
                        ans.add(curr.val);
                        currp1.right=null;
                        curr=curr.right;
                    }
                }
    
            }
            return ans;
        }
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Binary Tree Preorder Traversal
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans=new ArrayList<>();
            TreeNode curr=root;
            while(curr!=null) {
                if(curr.left==null) {
                    ans.add(curr.val);
                    curr=curr.right;
                }else {
                    TreeNode currp1=curr.left;
                    while(currp1.right!=null&&currp1.right!=curr) {
                        currp1=currp1.right;
                    }
                    if(currp1.right==null) {
                         ans.add(curr.val);
                        currp1.right=curr;
                        curr=curr.left;
                    }
                    else {
                        currp1.right=null;
                        curr=curr.right;
                    }
                }
    
            }
            return ans;
        }
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Binary Tree Postorder Traversal
        public List<Integer> reversepreorderTraversal(TreeNode root) {
            List<Integer> ans=new ArrayList<>();
            TreeNode curr=root;
            while(curr!=null) {
                if(curr.right==null) {
                    ans.add(curr.val);
                    curr=curr.left;
                }else {
                    TreeNode currp1=curr.right;
                    while(currp1.left!=null&&currp1.left!=curr) {
                        currp1=currp1.left;
                    }
                    if(currp1.left==null) {
                         ans.add(curr.val);
                        currp1.left=curr;
                        curr=curr.right;
                    }
                    else {
                        currp1.left=null;
                        curr=curr.left;
                    }
                }
    
            }
            return ans;
        }
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans=reversepreorderTraversal(root);
            Collections.reverse(ans);
            return ans;
        }
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Binary Tree Level Order Traversal
       public List<List<Integer>> levelOrder(TreeNode root) {
            if(root==null) return new ArrayList<>();
            List<List<Integer>> list=new ArrayList<>();
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()) {
                int count=q.size();
                List<Integer> li=new ArrayList<>();
                while(count-->0) {
                    TreeNode front=q.poll();
                    li.add(front.val);
                    if(front.left!=null) q.add(front.left);
                    if(front.right!=null) q.add(front.right);
                }
                list.add(li);
            }
            return list;
        }
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Binary Tree Maximum Path Sum
        class Solution {
            int max;
            public int maxPathSum(TreeNode root) {
               if(root==null) return 0;
               max=root.val;
               int ans=helper(root);
               return max;
            }
            public int helper(TreeNode root){
                if(root==null) return 0;
                int ans1=helper(root.left);
                int ans2=helper(root.right);
                max=Math.max(max,Math.max(ans1+root.val,Math.max(ans2+root.val,Math.max(root.val,ans1+ans2+root.val)))) ;
                return Math.max(ans1+root.val,Math.max(ans2+root.val,root.val));
            }
        }
        ++++++++++++++++++++++++++++++++++++++++++++++++
         All Nodes Distance K in Binary Tree
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            HashMap<TreeNode,TreeNode>  map=new HashMap<>();
            Queue<TreeNode> q=new LinkedList<>();
             map.put(root,null);
            q.add(root);
            while(!q.isEmpty()) {
                TreeNode front=q.poll();
                if(front.left!=null) {
                    q.add(front.left);
                    map.put(front.left,front);
                }
                if(front.right!=null) {
                    q.add(front.right);
                    map.put(front.right,front);
                }
            }
            q.clear();
            q.add(target);
            HashSet<TreeNode> set=new HashSet<>();
            int level=0;
            while(level!=K&&!q.isEmpty()) {
                int count=q.size();
                while(count-->0) {
                    TreeNode front=q.poll();
                    set.add(front);
                    if(front.left!=null&&!set.contains(front.left)){
                      //set.add(front.left);
                      q.add(front.left);
                    }
                    if(front.right!=null&&!set.contains(front.right)){
                        q.add(front.right);
                        //set.add(front.right);
                    }
                    // map.get(front) - front
                    if(map.get(front)!=null && !set.contains(map.get(front))) {
                        //set.add(map.get(front));
                        q.add(map.get(front));
                    }
                }
                level++;
            }
            List<Integer> li=new ArrayList<>();
            while(!q.isEmpty()) {
                li.add(q.poll().val);
            }
            return li;
        }
        +++++++++++++++++++++++++++++++++++++++++++++++++
        Binary Search Tree to Greater Sum Tree
        int sum;
        public TreeNode bstToGst(TreeNode root) {
            sum=0;
            helper(root);
            return root;
        }
        public void helper(TreeNode root) {
            if(root==null) {
                return ;
            }
            if(root.right!=null) {
                helper(root.right);
            }
            sum+=root.val;
            root.val=sum;
            if(root.left!=null) {
                helper(root.left);
            }
        }
        ++++++++++++++++++++++++++++++++++++++++++++++++++++
        Binary Tree Right Side View
        public List<Integer> rightSideView(TreeNode root) {
            if(root==null) return new ArrayList<>();
            List<Integer> li=new ArrayList<>();
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()) {
                int count=q.size();
                while(count-->0) {
                    TreeNode front=q.poll();
                    if(front.left!=null) q.add(front.left);
                    if(front.right!=null) q.add(front.right);
                    if(count==0) li.add(front.val);
                }
            }
            return li;
        }
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Left View of Binary Tree
        void leftView(Node root)
        {
            if(root==null) return ;
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()) {
                int count=q.size();
                boolean ans=true;
                while(count-->0) {
                    Node front=q.poll();
                    if(ans) {
                        System.out.print(front.data+" ");
                        ans=false;
                    }
                    if(front.left!=null) q.add(front.left);
                    if(front.right!=null) q.add(front.right);
                }
            }
        }
        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Top View
        static class Pair {
            Node  node;
            int level;
            Pair (Node node,int level) {
                this.node=node;
                this.level=level;
            }
        }
        static void topView(Node root)
        {
            if(root==null) return ;
            HashMap<Integer,Integer> map=new HashMap<>();
            Queue<Pair> q=new LinkedList<>();
            Pair p=new Pair(root,0);
            q.add(p);
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            while(!q.isEmpty()) {
                Pair p1=q.poll();
                Node front=p1.node;
                if(front==null) continue;
                int level=p1.level;
                max=Math.max(level,max);
                min=Math.min(level,min);
                if(!map.containsKey(level)) {
                    map.put(level,front.data);
                }
                if(front.left!=null) {
                    Pair p2=new Pair(front.left,level-1);
                    q.add(p2);
                }
                if(front.right!=null) {
                     Pair p2=new Pair(front.right,level+1);
                    q.add(p2);
                }
            }
            for(int i=min;i<=max;i++) {
                System.out.print(map.get(i)+" ");
            }
        }
        ++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Bottom views
        static void bottomView(Node root)
        {
            if(root==null) return ;
            HashMap<Integer,Integer> map=new HashMap<>();
            Queue<Pair> q=new LinkedList<>();
            Pair p=new Pair(root,0);
            q.add(p);
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            while(!q.isEmpty()) {
                Pair p1=q.poll();
                Node front=p1.node;
                if(front==null) continue;
                int level=p1.level;
                max=Math.max(level,max);
                min=Math.min(level,min);
                map.put(level,front.data);
                if(front.left!=null) {
                    Pair p2=new Pair(front.left,level-1);
                    q.add(p2);
                }
                if(front.right!=null) {
                     Pair p2=new Pair(front.right,level+1);
                    q.add(p2);
                }
            }
            for(int i=min;i<=max;i++) {
                System.out.print(map.get(i)+" ");
            }
        }
        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Vertical Order Traversal of a Binary Tree
       class Solution {
        static class Pair implements Comparable<Pair> {
            TreeNode node;
            int pos, lev;
            public Pair(TreeNode n, int p, int l) {
                node = n; pos = p; lev = l;
            }
            @Override
            public int compareTo(Pair p){
                if(this.lev==p.lev) {
                    if(p.pos==this.pos){
                        return this.node.val-p.node.val;
                    }
                    return this.pos-p.pos;
                }
                return this.lev-p.lev;
    
            }
        }
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            if(root==null) return list;
            PriorityQueue<Pair> q = new PriorityQueue<>();
            q.add(new Pair(root, 0, 0));
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            while(!q.isEmpty()) {
                int size = q.size();
                while(size-->0) {
                    Pair p = q.poll();
                    TreeNode n = p.node;
                    int y = p.pos;
                    if(!map.containsKey(y)) {
                        List<Integer> l = new ArrayList<>();
                        map.put(y,l);
                    }
                                     map.get(y).add(n.val);
                    if(n.left!=null) {
                        q.add(new Pair(n.left, y-1, p.lev+1));
                    }
                    if(n.right!=null) {
                        q.add(new Pair(n.right, y+1, p.lev+1));
                    }
                    min = Math.min(y, min);
                    max = Math.max(y, max);
                }
            }
            for(int i=min; i<=max; i++) {
                list.add(map.get(i));
            }
            return list;
        }
    }
        ++++++++++++++++++++++++++++++++++++++++++++++++++++
        public static void solve(BinaryTreeNode<Integer> root){
        if(root==null) return;
        System.out.print(root.data+" ");
		if(root.left!=null) {
             left(root.left);
        }
        leaf(root);
        if(root.right!=null) {
            right(root.right);
        }
	}
    public static void left(BinaryTreeNode<Integer> root) {
        if(root.left==null&&root.right==null) {
            return ;
        }
        System.out.print(root.data+" ");
        if(root.left!=null) {
            left(root.left);
        }else {
            left(root.right);
        }
    }
    public static void leaf(BinaryTreeNode<Integer> root) {
        
        if(root.left==null&&root.right==null) {
            System.out.print(root.data+" ");
            return ;
        }
         if(root.left!=null) {
            leaf(root.left);
        }
        if(root.right!=null) {
            leaf(root.right);
        }
    }
    public static void right(BinaryTreeNode<Integer> root) {
        if(root.left==null&&root.right==null) {
            return ;
        }
        if(root.right!=null) {
            right(root.right);
        }else {
            right(root.left);
        }
        System.out.print(root.data+" ");
    }
       +++++++++++++++++++++++++++++++++++++++++++++++
        Diagonal Traversal
        public class Solution {
        HashMap<Integer,ArrayList<Integer>> map;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        public int[] solve(TreeNode A) {
            if(A==null) return new int[0];
            map=new HashMap<>();
            helper(A,0);
            int sizeofArray=0;
            for(int i=max;i>=min;i--) {
                sizeofArray+=map.get(i).size();
            }
            int ans[]=new int[sizeofArray];
            int k=0;
            for(int i=max;i>=min;i--) {
                for(int j:map.get(i)) {
                    ans[k++] =j;
                }
            }
            return ans;
        }
        public void helper(TreeNode root,int level) {
            min=Math.min(min,level);
            max=Math.max(max,level);
             if(map.containsKey(level)) {
                 ArrayList<Integer> li=map.get(level);
                 li.add(root.val);
             }
             else {
                 ArrayList<Integer> li=new ArrayList<>();
                 li.add(root.val);
                 map.put(level,li);
             }
             if(root.left!=null) {
                 helper(root.left,level-1);
             }
             if(root.right!=null) {
                 helper(root.right,level);
             }
        }
    }
        ++++++++++++++++++++++++++++++++++++++++++
        binary Treecamera leetcode
        class Solution {
        int ans;
        public int minCameraCover(TreeNode root) {
            ans=0;
            int r= helper(root);
            if(r==1) return ans+1;
            return ans;
        }
        public int helper(TreeNode root) {
            if(root==null) return 3;
            int l=helper(root.left);
            int r=helper(root.right);
            if(l==1||r==1) {
                 ans++;
                 return 2;
            }
            else if(l==2||r==2) return 3;
            else return 1;
        }
    }
        //++++++++++++++++++++++++++++++++++++++++++++
        inorder-successor
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            find(root,p);
            return tempans;
        }
        TreeNode tempans;
         public void findleft(TreeNode root) {
            if(root==null) return ;
            tempans=root;
            if(root.left!=null) {
                findleft(root.left);
            }
        }
        public void find(TreeNode root,TreeNode p) {
            if(root==null) return ;
            if(root.val==p.val) {
                if(root.right!=null) {
                    findleft(root.right);
                }
            }
            else if(root.val<p.val&&root.right!=null) {
                find(root.right,p);
            }
            else if(root.val>p.val&&root.left!=null) {
                tempans=root;
                find(root.left,p);
            }
        }
        ++++++++++++++++++++++++++++++++++
        lca of bst
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null) return null;
            if(root.val<p.val&&root.val<q.val&&root.right!=null) return lowestCommonAncestor(root.right,p,q);
            else if(root.val>p.val&&root.val>q.val&&root.left!=null) return lowestCommonAncestor(root.left,p,q);
            else  return root;
        }
    
        //++++++++++++++++++++++++++++++++++++++++ lca of binaryTree
        Node lca(Node root, int n1,int n2)
        {
            if(root==null) return null;
    
            Node leftchild=lca(root.left,n1,n2);
            Node rightchild=lca(root.right,n1,n2);
            if(root.data==n1||root.data==n2) {
                return root;
            }
            else if(leftchild!=null&& rightchild==null) return leftchild;
            else if(leftchild==null&& rightchild!=null) return rightchild;
            else if(leftchild!=null&& rightchild!=null) return root;
            else return null;
        }
        +++++++++++++++++++++++++++++++++++++++++++++++
        sqrt root decompostion
        public static void main (String[] args) throws java.lang.Exception
        {
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            int q=s.nextInt();
            int newsize=(int) Math.ceil(Math.sqrt(n));
            int b[]=new int[newsize];
            Arrays.fill(b,Integer.MAX_VALUE);
            for(int i=0;i<n;i++) b[i/newsize]=Math.min(b[i/newsize], a[i]);
            while(q-->0) {
                int l=s.nextInt();
                int r=s.nextInt();
                int Min=Integer.MAX_VALUE;
                for(int i=l;i<=r;i++) {
                    if(i%newsize==0) {
                        if(i+newsize-1<=r) {
                            Min=Math.min(Min,b[i/newsize]);
                                i+=newsize-1;
                        }else Min=Math.min(Min,a[i]);
                    }
                    else Min=Math.min(Min,a[i]);
                }
                System.out.println(Min);
            }
        }
        ++++++++++++++++++++++++++++++++++++++++++++++
        class Solution {
            int ans;
            public int distributeCoins(TreeNode root) {
                int ans2= helper(root);
                return ans;
            }
            public int helper(TreeNode root) {
                if(root==null) return 0;
                int left=helper(root.left);
                int right=helper(root.right);
                int temp=left+right+root.val-1;
                ans+=Math.abs(temp);
                return temp;
            }
        }
        ++++++++++++++++++++++++++++++++++++++++++++++
        delete node in bst
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root==null)  return null;
            if(root.val==key)  root=delete(root);
            else if(root.val>key) root.left=deleteNode(root.left,key);
            else root.right=deleteNode(root.right,key);
           return root;
       }
       public TreeNode delete(TreeNode root) {
           if(root.left==null&&root.right==null) return null;
           else if(root.left==null&&root.right!=null) return root.right;
           else if(root.left!=null&&root.right==null) return root.left;
           else {
               TreeNode temp=root.right;
               while(temp.left!=null) {
                   temp=temp.left;
               }
               temp.left=root.left;
               return root.right;
           }
       }
       ++++++++++++++++++++++++++++++++++++++++++++++++++++
       build tree from pre and inorder
       class Solution {
            HashMap<Integer,Integer> map;
            public TreeNode buildTree(int[] preorder, int[] inorder) {
                map=new HashMap<>();
                int len=inorder.length-1;
                for(int i=0;i<len+1;i++) {
                    map.put(inorder[i],i);
                }
                return helper(preorder,0,len,inorder,0,len);
            }
            public TreeNode helper(int[] pre,int psi,int pen ,int[] in,int isi,int ien) {
                if(psi>pen||isi>ien) return null;
                TreeNode root=new TreeNode(pre[psi]);
                int index=map.get(pre[psi]);
                int count=index-isi;
                root.left=helper(pre,psi+1,psi+count,in,isi,index-1);
                root.right=helper(pre,psi+count+1,pen,in,index+1,ien);
                return root;
            }
        }
        ++++++++++++++++++++++++++++++++++++++++++++++++++++
        build tree from inorder and postorder
       class Solution {
            HashMap<Integer,Integer> map;
            public TreeNode buildTree(int[] inorder,int[] postorder) {
                map=new HashMap<>();
                int len=inorder.length-1;
                for(int i=0;i<len+1;i++) {
                    map.put(inorder[i],i);
                }
                return helper(postorder,0,len,inorder,0,len);
            }
            public TreeNode helper(int[] pos,int psi,int pen ,int[] in,int isi,int ien) {
                if(psi>pen||isi>ien) return null;
                TreeNode root=new TreeNode(pos[pen]);
                int index=map.get(pos[pen]);
                int count=ien-index;
                root.left=helper(pos,psi,pen-count-1,in,isi,index-1);
                root.right=helper(pos,pen-count,pen-1,in,index+1,ien);
                return root;
            }
        }
       +++++++++++++++++++++++++++++++++++++++++++++++++++++++
       build tree from inorder and level order
       static Node buildTree(int in[], int lev[]) {
            map = new HashMap<>();
            int n = in.length;
            for(int i=0; i<n; i++) {
                map.put(in[i], i);
            }
            Node root = f(in, 0, n-1, lev, 0, n-1);
           return root;
       }
    
        static HashMap<Integer, Integer> map;
    
        static Node f(int in[], int is, int ie, int lev[], int ls, int le) {
            if(is>ie || ls>le) return null;
            Node node = new Node(lev[0]);
            int k = map.get(lev[0]);
            int temp1[] = new int[k-is];
            int temp2[] = new int[ie-k];
            int x = 0, y = 0;
            for(int j=ls+1; j<=le; j++) {
                if(map.get(lev[j])<k) {
                    temp1[x++] = lev[j];
                } else {
                    temp2[y++] = lev[j];
                }
            }
            node.left =  f(in, is, k-1, temp1, 0, k-is-1);
            node.right = f(in, k+1, ie, temp2, 0, ie-k-1);
            return node;
        }
    
       +++++++++++++++++++++++++++++++++++++++++++++++++++++++
       serialize and deserialize funtion
       public class Codec {
    
            // Encodes a tree to a single string.
            public String serialize(TreeNode root) {
                if(root==null) return "#";
                String s1=serialize(root.left);
                String s2=serialize(root.right);
                return root.val+" "+s1+" "+s2;
            }
    
            // Decodes your encoded data to tree.
            public TreeNode deserialize(String data) {
                String s[] = data.split(" ");
                i = 0; n = s.length;
                TreeNode root = f(s);
                return root;
            }
            static int i, n;
    
            static TreeNode f(String s[]) {
                if(i==n) return null;
                TreeNode root = null;
                if(s[i].equals("#")) {
                    return root;
                } else {
                    int num = Integer.parseInt(s[i]);
                    root = new TreeNode(num);
                }
                i++;
                root.left = f(s);
                i++;
                root.right = f(s);
                return root;
            }
        }
       +++++++++++++++++++++++++++++++++++++++++++++++
       Construct BST from Postorder
       public Node constructTree(int p[],int l) {
            Node root = null;
            post = p; i = l-1;
            int inf = Integer.MAX_VALUE;
            root = f(-inf, inf);
            return root;
        }
    
        int post[], i;
       public Node f(int min, int max) {
            if(i<0) return null;
            int val = post[i];
            if(val<min || val>max) return null;
            i--;
            Node root = new Node(val);
            root.right = f(val+1, max);
            root.left = f(min, val-1);
            return root;
        }
        +++++++++++++++++++++++++++++++++++++++++++++++++++++
        Clone a Binary Tree
        public static Tree cloneTree(Tree tree){
           insert(tree);
           setRandom(tree);
           return extract(tree);
         }
         public static Tree extract(Tree root) {
             if(root==null) return null;
             Tree left=extract(root.left.left);
             Tree right=extract(root.right);
             if(left==null&&right==null) {
                 Tree cloned=root.left;
                 root.left=null;
                 return cloned;
             }
             else if(left==null) {
                 Tree myclone=root.left;
                 myclone.right=right;
                 root.left=null;
                 return myclone;
             }
             else if(right==null) {
                 Tree myclone=root.left;
                 root.left=root.left.left;
                 myclone.left=left;
                 return myclone;
             }
             else  {
                 Tree myclone=root.left;
                 root.left=root.left.left;
                 myclone.left=left;
                 myclone.right=right;
                 return myclone;
             }
         }
         public static void setRandom(Tree root) {
             if(root==null) return;
             if(root.random!=null) {
                 root.left.random=root.random.left;
             }
             setRandom(root.left.left);
             setRandom(root.right);
         }
         public static void insert(Tree root) {
             if(root==null) return;
             insert(root.left);
             Tree temp=root.left;
             Tree newNode=new Tree(root.data);
             root.left=newNode;
             newNode.left=temp;
             insert(root.right);
         }
         +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
         Binary Tree to Circular doubly linked list
         Node bTreeToClist(Node root)
        {
            Node tail= helper(root);
            return tail.right;
        }
        void merge(Node tail1,Node tail2) {  //left=prev  //right =next
            Node head1=tail1.right;
            Node head2=tail2.right;
            tail1.right=head2;
            head2.left=tail1;
            head1.left=tail2;
            tail2.right=head1;
        }
         Node helper(Node root) {
             if(root==null) return null;
             Node lefttail=helper(root.left);
             Node righttail=helper(root.right);
    
               root.left=root;
               root.right=root;
             if(lefttail==null&&righttail==null){
                root.left=root;
                root.right=root;
                return root;
             }
             else if(lefttail==null) {
               merge(root,righttail);
               return righttail;
             }
             else if(righttail==null) {
                 merge(lefttail,root);
                 return root;
             }
             else {
                 merge(lefttail,root);
                 merge(root,righttail);
                 return righttail;
             }
         }
         ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       */
    }
    