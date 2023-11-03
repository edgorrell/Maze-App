public class MazeSolverQueue extends MazeSolver{

    public MazeSolverQueue(Maze maze){
        super(maze);
        this.workList = new MyQueue<Square>();
    }
    public void add(Square sq) {
        workList.add(sq);
    }

    public Square remove(){
        return workList.remove();
    }
    
    public void makeEmpty(){
        this.workList = new MyQueue<Square>();
    }

    public boolean isEmpty(){
        return workList.isEmpty();
    }

    public Square next(){
        return workList.getFirst();
    }
}
