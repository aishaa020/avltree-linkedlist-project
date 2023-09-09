package application;

public class Node<e extends Comparable<e>> {
	
	 Node<e> next;
	 e data;
	
	
	
	
	


	public Node( e data2) {
		this.data = data2;
		
	}
	


	public e getData() {
		return data;
	}



	public void setData(e data) {
		this.data = data;
	}



	public Node<e> getNext() {
		return next;
	}


	public void setNext(Node<e> next) {
		this.next = next;
	}



	@Override
	public String toString() {
		return "[" + data + "]";
	}


	

	
	

	

}
