public class StackTest {
    public static void main(String[] args){
        MyStack<String> stack = new MyStack<String>();
        System.out.println(stack.isEmpty());
        stack.push("item1");
        stack.push("item2");
        stack.push("item3");
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        stack.clear();
        System.out.println(stack.isEmpty());
    }
}
