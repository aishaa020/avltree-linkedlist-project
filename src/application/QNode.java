package application;

public class QNode<T> {
	
	private QNode<T> next;
    private T data;

    public QNode(T data) {
        this.data=data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public QNode<T> getNext() {
        return next;
    }

    public void setNext(QNode<T> next) {
        this.next = next;
    }

}
