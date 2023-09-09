package application;

public class TawjeheDS<e extends Comparable<e>> {

	Doublylinkedlist<e> d = new Doublylinkedlist<>();
	Doublylinkedlist<e> dsorted = new Doublylinkedlist<>();
	AvlTree<e> seattree = new AvlTree<>();
	Avllinked<e> gradetree = new Avllinked<e>();

	public TawjeheDS() {

	}

	
	public String findprev(int key) {
		
		if(dsorted.find(key) != null && dsorted.find(key).prev != null ) {
			
			String s = ((TawjeheRecords)dsorted.find(key).prev.getData()).toString();
			
			return s;
			
		}else
			return "there is no previous record!";
		
		
	}
	
     public String findnext(int key) {
		
		if(dsorted.find(key) != null) {
			String s = ((TawjeheRecords)dsorted.find(key).next.getData()).toString();
			
			return s;
			
		}else
			return "there is no next record!";
		
		
	}
	
	
	
	public void insertRecord(e record) {
		
		
			//dsorted.sortedInsert(record);
			d.insertAtHead(record);

			seattree.insert(d.head.getData());
			gradetree.insert2(d.head.getData());
		
		
		
	}
	
	public void updateBranch(int seat, String newbranch) {
		TawjeheRecords t = new TawjeheRecords( seat, "", 89);
		
		if (seattree.find((e) t) != null ) {
			
			TawjeheRecords updated = new TawjeheRecords(seat , newbranch, ((TawjeheRecords)(seattree.find((e) t)).getData()).getAverage());
			
			insertRecord((e) updated);
			
			deleteRec(seat);
			
			
		}else
			System.out.println("record not found");
		
		
		

	}

	public void updateAverage(int seat, double average) {
		TawjeheRecords t = new TawjeheRecords( seat, "", average);
		
        if (seattree.find((e) t) != null ) {
			
			TawjeheRecords updated = new TawjeheRecords(seat , ((TawjeheRecords)(seattree.find((e) t)).getData()).getBranch() , average);
			
			insertRecord((e) updated);
			
			deleteRec(seat);
			
			
		}else
			System.out.println("record not found");
		
	
	}

	public void deleteRec(int seat) {
		TawjeheRecords t = new TawjeheRecords( seat, "", 89);
		
		if(seattree.find((e) t) != null) {
		TawjeheRecords updated = new TawjeheRecords(seat , "", ((TawjeheRecords)(seattree.find((e) t)).getData()).getAverage());
		
			d.CDdelete((e) t);
			dsorted.CDdelete((e) t);
			
			seattree.deletee((e) t);
			gradetree.deleteee((e) updated);
			
		}else
			System.out.println("not found");
		
			
	}

	public String findRec(int seat) {
		TawjeheRecords t = new TawjeheRecords( seat, "", 89);

		if (seattree.find((e) t) != null ) {
		    return ((TawjeheRecords)(seattree.find((e) t)).getData()).toString();
		    
		}else
			return "record not found";
			
	}

	public String GetAll(double avg) {
		TawjeheRecords t = new TawjeheRecords(112, "", avg);
		
		if(gradetree.findavg((e) t) != null) {
			AvllNode<e>  a = gradetree.findavg((e) t);
			
			return a.l.toString();
		}
		else
			return "record not found";
		

		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
