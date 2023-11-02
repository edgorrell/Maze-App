public class MazeSolverStack extends MazeSolver{
    
    public MazeSolverStack(Maze maze){
        super(maze);
        solverType = new MyStack<Square>();
    }

    public void makeEmpty(){
        workList.clear();
    }

    public boolean isEmpty(){
        return workList.isEmpty();
    }

    public void add(Square sq){
        workList.add(sq);
    }

    public Square next(){
        return workList.getFirst();
    }
}