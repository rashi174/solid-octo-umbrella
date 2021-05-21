
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
         Node temp1=head1;
         Node temp2=head2;
         int m=0,n=0;
         while(temp1!=null){
             m++;
             temp1=temp1.next;
         }
         while(temp2!=null){
             n++;
             temp2=temp2.next;
         }
         temp1=head1;
         temp2=head2;
         if (m>n)
         {
             //list1 is bigger
             int diff=m-n;
             for(int i=0;i<diff;i++)
             {
                 temp1=temp1.next;
             }
         }
        if (n>m){
             //list2 is bigger
             int diff=n-m;
             for(int i=0;i<diff;i++){
                 temp2=temp2.next;
             }
         }
         while(temp1!=null || temp2!=null){
             if (temp1==temp2){
                 return temp1.data;
             }
             temp1=temp1.next;
             temp2=temp2.next;
         }
         return -1;
         
	}
}
