public class LinkedList {
    /*
    +++++++++++++++++++++++++++++++++++++++
    LRU Cache
      class LRUCache {

    DoubleLinkedList head,tail;
	int maxCapacity;
	int capacity;
	HashMap<Integer,DoubleLinkedList> map;
	class DoubleLinkedList {
		int key,value;
		DoubleLinkedList next;
		DoubleLinkedList prev;
		DoubleLinkedList(int key,int value) {
			this.key=key;
			this.value=value;
		}
	}
	public void insert(DoubleLinkedList temp) {
		if(capacity==maxCapacity) return;
		DoubleLinkedList tailm1=tail.prev;
		tailm1.next=temp;
		tail.prev=temp;
		temp.next=tail;
		temp.prev=tailm1;
		capacity++;
	}
	public int remove(DoubleLinkedList temp) {
		if(capacity==0) return -1;
		DoubleLinkedList tempm1=temp.prev;
		DoubleLinkedList tempp1=temp.next;
		tempm1.next=tempp1;
		tempp1.prev= tempm1;
		temp.next=null;
		temp.prev=null;
		capacity--;
		return temp.value;
	}
	public int removeLast() {
		if(capacity==0) return -1;
		DoubleLinkedList temp =head.next;
		DoubleLinkedList tempm1=temp.prev;
		DoubleLinkedList tempp1=temp.next;
		tempm1.next=tempp1;
		tempp1.prev= tempm1;
		temp.next=null;
		temp.prev=null;
		capacity--;
		map.remove(temp.key);
		return temp.value;
	}
    public LRUCache(int capacity) {
    	maxCapacity=capacity;
    	capacity=0;
    	head=new DoubleLinkedList(0,0);
    	tail=new DoubleLinkedList(0,0);
    	head.next=tail;
    	tail.prev=head;
    	map=new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
        	DoubleLinkedList temp=map.get(key);
        	remove(temp);
            insert(temp);
            return temp.value;
        }
        return -1;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)) remove(map.get(key));
        else if(capacity==maxCapacity) removeLast();
        DoubleLinkedList temp=new DoubleLinkedList(key,value);
        map.put(key, temp);
        insert(temp);
     }
}
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Clone a linked list with next and random pointer
class Clone {
    Node copyList(Node head) {
        insert(head);
        random(head);
        Node temp=extract(head);
        return temp;
    }
    void insert(Node head) {
        Node temp=head;
        while(temp!=null) {
            Node tempp1 =temp.next;
            Node newNode=new Node(temp.data);
            temp.next=newNode;
            newNode.next=tempp1;
            temp=tempp1;
        }
    }
    void random(Node head) {
        Node curr=head;
        while(curr!=null) {
            if(curr.arb!=null) { //==>this condition is important
                curr.next.arb=curr.arb.next;
            }
            curr=curr.next.next;
        }
    }
    Node extract(Node head) {
       Node newHead=head.next;
       Node temp=head;
       Node newNode=head.next;
       while(temp!=null) {
          Node temp1=newNode.next;
          Node newtemp1=null;
          if(temp1!=null) {
              newtemp1=temp1.next;
          }
          temp.next=temp1;
          newNode.next=newtemp1;
          temp=temp1;
          newNode=newtemp1;
       }
       return newHead;
    }
    
}

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
public static ListNode reverseList(ListNode head) {
	       if(head==null) return null;
	       ListNode prev=null;
	       ListNode curr=head;
	       while(curr!=null) {
	           ListNode  next=curr.next;
	           curr.next=prev;
	           prev=curr;
	           curr=next;
	       }
	        return prev;
	    }
	public static int getMiddle(ListNode head)
	   {
		ListNode slow=head;
		ListNode fast =head;
	       while(fast!=null&&fast.next!=null) {
	           slow=slow.next;
	           fast=fast.next.next;
	       }
	       return slow.data;
	   }
	public int detectLoop(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
        while(fast!=null&&slow!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return 1;
        }
        return 0;
    }
	class Intersect
	{   int length(Node head) {
	       if(head==null) return 0;
	       Node temp=head;
	       int count=0;
	       while(temp!=null) {
	           count++;
	           temp=temp.next;
	       }
	       return count;
	    }
		int intersectPoint(Node headA, Node headB)
		{
	         int len1=length(headA);
	         int len2=length(headB);
	         int count=Math.abs(len1-len2);
	         Node temp1=null;
	         Node temp2=null;
	         if(len1>len2) {
	            temp1=headA;
	            temp2=headB;
	         }
	         else {
	            temp1=headB;
	            temp2=headA;
	         }

	         while(count-->0) {
	           temp1=temp1.next;
	         }
	         while(temp1!=null&&temp2!=null&&temp1!=temp2) {
	             temp1=temp1.next;
	             temp2=temp2.next;
	         }
	         if(temp1==null||temp2==null||temp1!=temp2) return -1;
	         return temp1.data;
		}
	}
     */
}
