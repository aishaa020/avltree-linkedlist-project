package application;

public class AvllNode<e extends Comparable<e>> {
	
	 e data;
     int height;
     AvllNode<e> left;
     AvllNode<e> right;
    
    SinglyLinkedlist<e> l = new SinglyLinkedlist<e>();;
   
    public AvllNode(e data) {
     
    	l.insertAtHead(data);
    }
    
    
     
    public SinglyLinkedlist<e> getL() {
		return l;
	}



	public void setL(SinglyLinkedlist<e> l) {
		this.l = l;
	}



	public e getData() {
        return (e)l.head.getData();
    }
    

    public void setData(e data) {
        this.data = data;
    }

   
	public AvllNode<e> getLeft() {
        return left;
    }

    public void setLeft(AvllNode<e> left) {
        this.left = left;
    }

    public AvllNode<e> getRight() {
        return right;
    }

    public void setRight(AvllNode<e> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return (left == null && right == null);
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return "[" + data + "]";
    }


}
