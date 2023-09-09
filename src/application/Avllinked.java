package application;



public class Avllinked<e extends Comparable<e>> {
	
   AvllNode<e> root;
	

    public Avllinked() {
    }

    public void insert2(e key) {
        root = insert2(root, key);
    }

    private AvllNode<e> insert2(AvllNode<e> root, e key){
        if (root == null) {
            return new AvllNode<e>(key);
        }
        if (((TawjeheRecords) key).getAverage()< ( ((TawjeheRecords) root.getData()).getAverage()) ) {
            root.setLeft(insert2(root.getLeft(), key));
        } else if(((TawjeheRecords) key).getAverage() > ( ((TawjeheRecords) root.getData()).getAverage())) {
            root.setRight(insert2(root.getRight(), key));
        }else if(((TawjeheRecords) key).getAverage() == ( ((TawjeheRecords) root.getData()).getAverage())) { 
        	
        	root.l.insertAtHead(key);
        }        return rebalance(root);
    }

    private AvllNode<e> rebalance(AvllNode<e> root){
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

    private int getBalance(AvllNode<e> root) {
        if (root == null) {
            return 0;
        }
        return getHeight(root.getLeft()) - getHeight(root.getRight());
    }

    private int getHeight(AvllNode<e> curr) {
        if (curr == null)
            return 0;
        if (curr.isLeaf())
            return 1;
        else
            return Math.max(1 + getHeight(curr.getLeft()), 1 + getHeight(curr.getRight()));
    }

    public AvllNode<e> rotateRight(AvllNode<e> node) {
        AvllNode<e> nodeC = node.getLeft();
        node.setLeft(nodeC.getRight());
        nodeC.setRight(node);
        return nodeC;
    }

    public AvllNode<e> rotateLeft(AvllNode<e> node) {
        AvllNode<e> nodeC = node.getRight();
        node.setRight(nodeC.getLeft());
        nodeC.setLeft(node);
        return nodeC;
    }

    public AvllNode<e> rotateRightLeft(AvllNode<e> node) {
        AvllNode<e> nodeC = node.getRight();
        node.setRight(rotateRight(nodeC));
        return rotateLeft(node);
    }

    public AvllNode<e> rotateLeftRight(AvllNode<e> node) {
        AvllNode<e> nodeC = node.getLeft();
        node.setLeft(rotateLeft(nodeC));
        return rotateRight(node);
    }

    public boolean isEmpty() {
        return root==null;
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(AvllNode<e> node) {
        if (node != null) {
            if (node.getLeft() != null) {
                traverseInOrder(node.getLeft());
               
            } if (node.getRight() != null) {
                traverseInOrder(node.getRight());
               
            }
            System.out.println(  node.l.toString() + " " + "(" + getHeightDifference(node) + ")"  );
        }
    }


    
    public AvllNode<e> deletee(e data) {
        AvllNode current = root;
        AvllNode parent = root;
        boolean isLeftChild = false;
        if (isEmpty())
            return null; // tree is empty
        while (current != null && ((TawjeheRecords) current.getData()).getAverage() != ((TawjeheRecords)data).getAverage() ) {
            parent = current;
            if (((TawjeheRecords)data).getAverage()  < ((TawjeheRecords) current.getData()).getAverage() ) {
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
            AvllNode successor = getSuccessor(current);
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
    
    
   
    
    
    

    public void deleteee(e data) {
		if (findavg(data) != null) {// the data is found
			Node<e> key = findavg(data).l.head;
			if (key.getNext() != null) {
				findavg(data).l.delete(data);
			}else 
				deletee(data);

		} else
			System.out.println("NOT FOUND");
	}

    private AvllNode<e> getSuccessor(AvllNode node) {
        AvllNode parentOfSuccessor = node;
        AvllNode successor = node;
        AvllNode current = node.getRight();
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

    public AvllNode find(e data) {
        return find(data, root);
    }

    public AvllNode<e> find(e data, AvllNode<e> node) {
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
    
    public AvllNode findavg(e data) {
        return findavg(data, root);
    }

    public AvllNode<e> findavg(e data, AvllNode<e> node) {
    	 if (node != null) {
             if (((TawjeheRecords)node.getData()).getAverage() == ((TawjeheRecords) data).getAverage() )
                 return node;
             else if ((((TawjeheRecords)node.getData()).getAverage() > ((TawjeheRecords) data).getAverage()) && node.hasLeft())
                 return findavg(data, node.getLeft());
             else if ((((TawjeheRecords)node.getData()).getAverage() < ((TawjeheRecords) data).getAverage()) && node.hasRight())
                 return findavg(data, node.getRight());
         }
         return null;
    }
    
    public int getHeightDifference(AvllNode<e> node) {
		if (node != null)
			return getHeight(node.getLeft()) - getHeight(node.getRight());
		return 0;

	}


    String levelOrder(AvllNode node) {
        Queue<AvllNode> queue = new Queue<>();
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
           s +=  ((Double) (((TawjeheRecords)node.getData())).getAverage()) + " ";
        }
        return s + " ]";
    }

    public String printHeight(){
        int h=getHeight(root);
        return h +"";
    }



}
