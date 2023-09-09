package application;

public class Queue<T> {
	
	 private QNode<T> last;

	    public void enqueue(T data){
	        QNode<T> newNode = new QNode<>(data);
	        if(isEmpty())
	            newNode.setNext(newNode);
	        else{
	            newNode.setNext(last.getNext());
	            last.setNext(newNode);
	        }
	        last=newNode;
	    }

	    public T getFront(){
	        if(!isEmpty())
	            return last.getNext().getData();
	        return null;
	    }

	    public T dequeue(){
	        T data;
	        if(!isEmpty()){
	            if(last.getNext()==last){
	                data=last.getData();
	                last=null;
	            }
	            else{
	                data=last.getNext().getData();
	                last.setNext(last.getNext().getNext());
	            }
	            return data;
	        }
	        return null;
	    }


	    public boolean isEmpty() {
	        return (last==null);
	    }


	    public void clear () {
	        last = null;
	    }

	    @Override
	    public String toString() {
	        QNode c = null;
	        String s="First-->";
	        if(last!=null)
	            c = last.getNext();
	        while(true){
	            s+=c.getData()+"-->";

	            if(c==last)
	                break;

	            c=c.getNext();

	        }
	        return s;
	    }


}
