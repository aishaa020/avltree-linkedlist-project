package application;



public class AvlNode<e extends Comparable<e>> {
	e data;
    int height;
     AvlNode<e> left;
     AvlNode<e> right;
    
    private DNode<e> pointer;
   
    public AvlNode(e data) {
        this.data = data;
    }

    public e getData() {
        return data;
    }

    public void setData(e data) {
        this.data = data;
    }

    public AvlNode<e> getLeft() {
        return left;
    }

    public void setLeft(AvlNode<e> left) {
        this.left = left;
    }

    public AvlNode<e> getRight() {
        return right;
    }

    public void setRight(AvlNode<e> right) {
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
