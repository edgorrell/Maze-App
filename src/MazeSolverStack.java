public class MazeSolverStack extends MazeSolver{
    
    public MazeSolverStack(Maze maze){
        super(maze);
        this.workList = new MyStack<Square>();
    }

    public void add(Square sq){
        workList.add(sq);
    }

    public Square remove(){
        return workList.remove();
    }

    public Square next(){
        return workList.getFirst();
    }

    public void makeEmpty(){
        workList = new MyStack<Square>();
    }

    public boolean isEmpty(){
        return workList.isEmpty();
    }
}