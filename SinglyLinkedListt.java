
package singlylinkedlistt;


public class SinglyLinkedListt {
    private ListNode head;
    
    private static class ListNode{
        private int data;
        ListNode next;
        
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
    }
   
    public static void main(String[] args) {
        SinglyLinkedListt sll = new SinglyLinkedListt();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
        
       
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        
        
    }
    
    public int add(int data){
    ListNode node = new ListNode(data);
    node.data = data;
    node.next = null;

    if(head == null){
        head = node;
    }else{
        ListNode n = head;
        while(n.next !=null){
        n = n.next;
    }
        n.next = node;
    }
      
    return data;
    } 
    
    public void display(){
        ListNode current = head;
        while(current !=null){
            System.out.print(current.data + "--> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public void addFirst(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        
    }
    
    public void addAt(int position, int data){
        ListNode node = new ListNode(data);
        if(position == 1){
            node.next = head;
            head = node;
            
        }else{
            ListNode previous = head;
            int count = 1;
            while(count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    public void addLast(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    } 
    
    public ListNode removeFirst(){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
        
    }
    
    public void remove(int position){
        if(position == 1){
            head = head.next;
        }else{
            ListNode previous = head;
            int count = 1;
            while(count < position-1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }
    
    public int getFirst(){
        if(head != null){
            System.out.println(" The first element in the list is "+head.data);
        }
        return (int) head.data;
    } 
     
    public void getLast (){
    ListNode current = head;

    if( current != null){
        current = current.next;
       
    }
        System.out.println("The last element in the list is "+current.data);
    
    

    } 
    
    public int getSize(){
    if(head == null){
        
        System.out.println("The list is empty");
        return 0;
     }
    int count = 0;
    ListNode current = head;
    while(current != null){
         count ++;
         current = current.next;
     }
        System.out.println("The size of this list is "+ count);
     return count;
    } 
    
    public void clear(){
        head = null;
        System.out.println("List cleared");
        
    } 
    
    


}
