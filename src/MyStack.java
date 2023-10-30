import java.util.NoSuchElementException;

public class MyStack<T> implements StackADT<T>{
    private Node<T> top = null;

    public void push(T item){
        Node<T> n = new Node<T>(item, top);
        top = n;
    }


    public T pop() throws NoSuchElementException{
        if(top == null){
            throw new NoSuchElementException();
        }
        T item = top.item;
        top = top.next;
        return item;
    }


    public T top() throws NoSuchElementException{
        if(top == null){
            throw new NoSuchElementException();
        }
        return top.item;
    }


    public int size(){
        int i = 0;
        Node<T> n = top;
        while(n.next != null){
            n = n.next;
            i++;
        }
        return i;
    }


    public boolean isEmpty(){
        return top == null;
    }


    public void clear(){
        top = null;
    }

    static class Node<T>{
        T item;
        Node<T> next;

        public Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }
}
