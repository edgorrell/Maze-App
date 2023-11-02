public class MazeSolverQueue extends MazeSolver{
    private MyQueue<Square> queue;
    public MazeSolverQueue(Maze maze){
        super(maze);
    }
    public void add(Square sq) {
        queue.add(sq);
    }
    public void makeEmpty(){
        WorkList<Square> queue = new MyQueue<Square>();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public Square next(){
        return queue.dequeue();
    }
}
