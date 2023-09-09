package application;



public class Doublylinkedlist<e extends Comparable<e>> {
	
	DNode<e> head;

	
	public void insertAtHead(e data) {
	//	 TawjeheRecords newR = new TawjeheRecords(seatnum, branch, average);
		  DNode<e> newNode = new DNode<>(data);
		
		
		  
		if(head!=null){
			newNode.next = head;
		    newNode.prev = head.prev;
		    head.prev.next = head.prev = newNode;
			head = newNode;
        }else {
           head = newNode;
           newNode.next = newNode;
           newNode.prev = newNode;		   
           
        }
	}
	
	public void sortedInsert(e data)
    {
		DNode newNode = new DNode(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else if (((TawjeheRecords)head.data).getSeatnum() >= ((TawjeheRecords)newNode.data).getSeatnum() ) {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        } else {
           DNode current = head.next;
            while (current != head && ((TawjeheRecords)current.data).getSeatnum() < ((TawjeheRecords)newNode.data).getSeatnum()) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
    }





	
	public DNode find(int searchValue) {
	    DNode current = head;

	    if (head == null) {
	        return null;
	    } else {
	        do {
	            if (((TawjeheRecords)current.data).getSeatnum() == searchValue) {
	                return current;
	            }
	            current = current.next;
	        } while (current != head);
	             return null;
	    }
	}
	
	public void CDdelete(e key) {
		 // If list is empty
        if (head == null)
            System.out.println("the list is empty!!!");
  
        // Find the required node
        // Declare two pointers and initialize them
        DNode<e> curr = head, prev_2 = null;
        while (((TawjeheRecords)curr.data).getSeatnum() != ((TawjeheRecords)key).getSeatnum()) {
            // If node is not present in the list
            if (curr.next == head) {
                System.out.println("record not found");
                break;
            }
  
            prev_2 = curr;
            curr = curr.next;
        }
   if(((TawjeheRecords)curr.data).getSeatnum() == ((TawjeheRecords)key).getSeatnum()) {
        // Check if node is the only node in list
        if (curr.next == head && prev_2 == null) {
            head = null;
           
        }else {
        	
			// If list has more than one node,
			// check if it is the first node
			if (curr == head) {
				// Move prev to last node
				prev_2 = head.prev;

				// Move start ahead
				head = head.next;

				// Adjust the pointers of prev_1 and start node
				prev_2.next = head;
				head.prev = prev_2;
			}

			// check if it is the last node
			else if (curr.next == head) {
				// Adjust the pointers of prev_1 and start node
				prev_2.next = head;
				head.prev = prev_2;
			} else {
				// create new pointer, points to next of curr node
				DNode temp = curr.next;

				// Adjust the pointers of prev_1 and temp node
				prev_2.next = temp;
				temp.prev = prev_2;
			}

        }
		
		
  }
		
	}
	
	
	@Override
	public String toString() {
		String s = "Head -->" + "\n";
		DNode<e> curr = head; 
		if(head != null) {
			s += curr.toString() + "\n";
			while (curr.next != head) {

				s += curr.next.toString() + "\n";
				curr = curr.next;

			}
			return  s ;
		}else
			return "list is empty!";
		
	}
	


}
