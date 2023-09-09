package application;

public class SinglyLinkedlist<e extends Comparable<e>> {
	
	public Node<e> head;
	private int counter = 0;

    public void insertAtHead(e data) {
    	
    	Node<e> newNode = new Node(data);
       
        //Node<e> curr = head;

        if (head == null)
        	head = newNode;
        else {
        	newNode.setNext(head);
            head = newNode;
        }

    }

  
    public String search(e target){
    	Node<e> curr = head;
        
        while(curr.getNext()!=null){
            if(curr.getData() == target) {
            	return "record found --> "+ curr.getData();
                
            }
            curr=curr.getNext();
        }

        return "record not found!";
    }
    
    public void delete (e data) {
		Node<e> curr = head;
		Node<e> pre = null;
		while (curr!=null ){
			if(((TawjeheRecords)head.getData()).getSeatnum() == ((TawjeheRecords)data).getSeatnum()) {
				head=head.getNext();
				break;
			}
			
			if(((TawjeheRecords)curr.getData()).getSeatnum() == ((TawjeheRecords)data).getSeatnum()) {
				pre.setNext(curr.getNext());
				break;
			}
			else {
				pre=curr;
				curr=curr.getNext();
			}
			
		}
		
	}
    

   

//    public void delete(e target) {
//        Node<e> curr = head;
//        Node<e> prev = null;
//        if(head.getData() == target) {
//            curr=head.getNext();
//            head.setNext(null);
//            head=curr;
//        }
//        else {
//            while (curr != null ) {
//                prev = curr;
//                curr = curr.getNext();
//                if( ((TawjeheRecords)curr.getData()).getSeatnum() == ((TawjeheRecords)target)) {
//                    prev.setNext(curr.getNext());
//                    break;
//                }
//            }
//        }
//
//    }

   
    @Override
    public String toString() {
        String s = "Head -->" ;
        Node<e> curr = head;
        while (curr != null) {
            s += "[" + ((TawjeheRecords)curr.getData()).getSeatnum() +"," + ((TawjeheRecords)curr.getData()).getBranch()+ "," +
            		((TawjeheRecords)curr.getData()).getAverage()+ "]" +"-->";
            curr = curr.getNext();
        }
        return s + " Null" ;
    }
	
	

}
