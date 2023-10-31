import java.util.NoSuchElementException;

public class MyQueue<T> implements QueueADT<T>{    
    private Node<T> first, last;
    public MyQueue(){
        this.first = null;
    }
    
    
    
    public void enqueue(T element){
        if(size() == 0){
            first = new Node<T>(element, null);
            last = first;
            return;
        }
        Node<T> node = new Node<T>(element, null);
        last.next = node;
        this.last = node;
    }

    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() throws NoSuchElementException{
        if (this.first == null){
            throw new NoSuchElementException();
        }
        T element = this.first.data;
        if(this.first.equals(this.last)){
            this.first = null;
            this.last = null;
            return element;
        } else {
            this.first = this.first.next;
            return element;
        }
    }

    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T front() throws NoSuchElementException{
        if (this.first == null){
            throw new NoSuchElementException();
        }
        return this.first.data;
    }

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    public int size(){
        if(first == null && last == null){
            return 0;
        }
        Node<T> temp = first;
        int size = 1;
        while(temp.next != null){
            temp = temp.next;
            System.out.println(temp.data);
            size++;  
        }
        return size;
    }

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty(){
        return this.first==null;
    }

    /**
     * Clear out the data structure
     */
    public void clear(){
        this.first = null;
        this.last = null;
    }

    static class Node<T>{
        public T data;
        public Node<T> next;

        public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
        }
    }
    
}

