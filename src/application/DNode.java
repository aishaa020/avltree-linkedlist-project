package application;



public class DNode<e extends Comparable<e>> {
	
	 e data;
	 DNode<e> prev;
	 DNode<e> next;
	
	
	
	
	public DNode(e data) {
	
		this.data = data;
	}

	public e getData() {
		return data;
	}
	
	public void setData(e data) {
		this.data = data;
	}
	
	public DNode<e> getPrev() {
		return prev;
	}
	
	public void setPrev(DNode<e> prev) {
		this.prev = prev;
	}
	
	public DNode<e> getNext() {
		return next;
	}
	
	public void setNext(DNode<e> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return  data + " -->" ;
	}
	
	

}
