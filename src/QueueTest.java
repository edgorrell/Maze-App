public class QueueTest{
    public static void main(String[] args){
        MyQueue<String> queue = new MyQueue<String>();
        System.out.println(queue.isEmpty());
        queue.enqueue("item1");
        queue.enqueue("item2");
        queue.enqueue("item3");
        System.out.println(queue.dequeue());
        System.out.println(queue.front());
        System.out.println(queue.size());
        queue.clear();
        System.out.println(queue.isEmpty());
    }
}
