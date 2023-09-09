package application;



public class AvlTree<e extends Comparable<e>> {
	
	AvlNode<e> root;
	

    public AvlTree() {
    }

    public void insert(e key) {
        root = insert(root, key);
    }

    private AvlNode<e> insert(AvlNode<e> root, e key) {
        if (root == null) {
            return new AvlNode<e>(key);
        }
        if (((TawjeheRecords) key).getSeatnum() < ((TawjeheRecords)root.getData()).getSeatnum()) {
            root.setLeft(insert(root.getLeft(), key));
        } else {
            root.setRight(insert(root.getRight(), key));
        }
        return rebalance(root);
    }

    private AvlNode rebalance(AvlNode root){
        if (root == null) {
            return root;
        }
        int balance = getBalance(root);
        if (balance > 1) {
            if (getBalance(root.getLeft()) > 0) {
                root = rotateRight(root);
            } else {
                root = rotateLeftRight(root);
            }
        } else if (balance < -1) {
            if (getBalance(root.getRight()) < 0) {
                root = rotateLeft(root);
            } else {
                root = rotateRightLeft(root);
            }
        }
        return root;
    }

    private int getBalance(AvlNode<e> root) {
        if (root == null) {
            return 0;
        }
        return getHeight(root.getLeft()) - getHeight(root.getRight());
    }

    private int getHeight(AvlNode<e> curr) {
        if (curr == null)
            return 0;
        if (curr.isLeaf())
            return 1;
        else
            return Math.max(1 + getHeight(curr.getLeft()), 1 + getHeight(curr.getRight()));
    }

    public AvlNode<e> rotateRight(AvlNode<e> node) {
        AvlNode<e> nodeC = node.getLeft();
        node.setLeft(nodeC.getRight());
        nodeC.setRight(node);
        return nodeC;
    }

    public AvlNode<e> rotateLeft(AvlNode<e> node) {
        AvlNode<e> nodeC = node.getRight();
        node.setRight(nodeC.getLeft());
        nodeC.setLeft(node);
        return nodeC;
    }

    public AvlNode<e> rotateRightLeft(AvlNode<e> node) {
        AvlNode<e> nodeC = node.getRight();
        node.setRight(rotateRight(nodeC));
        return rotateLeft(node);
    }

    public AvlNode<e> rotateLeftRight(AvlNode<e> node) {
        AvlNode<e> nodeC = node.getLeft();
        node.setLeft(rotateLeft(nodeC));
        return rotateRight(node);
    }

    public boolean isEmpty() {
        return root==null;
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(AvlNode<e> node) {
        if (node != null) {
            if (node.getLeft() != null) {
                traverseInOrder(node.getLeft());
               
            } if (node.getRight() != null) {
                traverseInOrder(node.getRight());
                
            }
            System.out.print(node + " " + "(" + getHeightDifference(node) + ")" +"\n");
        }
    }

//    public AvlNode delete(e data) {
//        AvlNode temp = deleteSuper(data);
//        if(temp!= null){
//            AvlNode rootNode = root;
//            root = rebalance(rootNode);
//        }
//        return temp;
//    }
//
//    private AvlNode<e> deleteSuper(e data) {
//        AvlNode current = root;
//        AvlNode parent = root;
//        boolean isLeftChild = false;
//
//        if(isEmpty())
//            return root;
//
//
//        while (current != null && !current.getData().equals(data)) {
//            parent = current;
//            if (data.compareTo((e) current.getData()) < 0) {
//                current = current.getLeft();
//                isLeftChild = true;
//            } else {
//                current = current.getRight();
//                isLeftChild = false;
//            }
//        }
//        if (current == null)
//            return null;
//
//
//        // case 1: node is a leaf
//        if (!current.hasLeft() && !current.hasRight()) {
//            if (current == root) // tree has one node
//                root = null;
//
//            else {
//                if (isLeftChild)
//                    parent.setLeft(null);
//
//                else
//                    parent.setRight(null);
//            }
//        } else if (current.hasLeft() && !current.hasRight()) { // current has left child only
//            if (current == root) {
//                root = current.getLeft();
//            } else if (isLeftChild) {
//                parent.setLeft(current.getLeft());
//            } else {
//                parent.setRight(current.getLeft());
//            }
//        } else if (current.hasRight() && !current.hasRight()) { // current has right child only
//            if (current == root) {
//                root = current.getRight();
//            } else if (isLeftChild) {
//                parent.setLeft(current.getRight());
//            } else {
//                parent.setRight(current.getRight());
//            }
//        } else {
//            AvlNode<e> successor = getSuccessor(current);
//            if (current == root)
//                root = successor;
//            else if (isLeftChild) {
//                parent.setLeft(successor);
//            } else {
//                parent.setRight(successor);
//            }
//            successor.setLeft(current.getLeft());
//
//
//        }
//
//        rebalance(root);
//        return current;
//    }
    
    
    public AvlNode<e> deletee(e data) {
        AvlNode current = root;
        AvlNode parent = root;
        boolean isLeftChild = false;
        if (isEmpty())
            return null; // tree is empty
        while (current != null && ((TawjeheRecords) current.data).getSeatnum() != ((TawjeheRecords)data).getSeatnum()) {
            parent = current;
            if (((TawjeheRecords)data).getSeatnum() < ((TawjeheRecords) current.data).getSeatnum() ) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
        }
        if (current == null)
            return null; // node to be deleted not found
        // case 1: node is a leaf
        if (!current.hasLeft() && !current.hasRight()) {
            if (current == root) // tree has one node
                root = null;
            else {
                if (isLeftChild)
                    parent.left = null;
                else
                    parent.right = null;
            }
        } else if (current.hasLeft() && !current.hasRight()) { // current has
            // left child
            // only
            if (current == root)
                root = current.left;
            else if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;

        } else if (current.hasRight() && !current.hasLeft()) { // current has
            // right child
            // only
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            AvlNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        
        return rebalance(root);

    }
    
    

    private AvlNode<e> getSuccessor(AvlNode node) {
        AvlNode parentOfSuccessor = node;
        AvlNode successor = node;
        AvlNode current = node.getRight();
        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.getLeft();
        }
        if (successor.getData().compareTo(node.getRight().getData())!=0) { // fix successor connections
            parentOfSuccessor.setLeft(successor.getRight());
            successor.setRight(node.getRight());
        }
        return successor;
    }

    public AvlNode find(e data) {
        return find(data, root);
    }

    private AvlNode find(e data, AvlNode node) {
        if (node != null) {
            if (((TawjeheRecords)node.getData()).getSeatnum() == ((TawjeheRecords) data).getSeatnum() )
                return node;
            else if ((((TawjeheRecords)node.getData()).getSeatnum() > ((TawjeheRecords) data).getSeatnum()) && node.hasLeft())
                return find(data, node.getLeft());
            else if ((((TawjeheRecords)node.getData()).getSeatnum() < ((TawjeheRecords) data).getSeatnum()) && node.hasRight())
                return find(data, node.getRight());
        }
        return null;
    }
    
    public int getHeightDifference(AvlNode node) {
		if (node != null)
			return getHeight(node.getLeft()) - getHeight(node.getRight());
		return 0;

	}


    String levelOrder(AvlNode node) {
        Queue<AvlNode> queue = new Queue<>();
        String s = "[ ";
        queue.enqueue(node);
        while(!queue.isEmpty()){
            node=queue.dequeue();
            if(node.getLeft()!=null){
                queue.enqueue(node.getLeft());
            }
            if(node.getRight()!=null){
                queue.enqueue(node.getRight());
            }
            s +=  ((Integer) (((TawjeheRecords)node.getData())).getSeatnum()) + " ";
        }
        return s + " ]";
    }

    public String printHeight(){
        int h=getHeight(root);
       return h + "";
    }



}
