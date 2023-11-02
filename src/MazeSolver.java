import java.util.ArrayList;

public abstract class MazeSolver{
    protected Maze maze;
    protected Object solverType;
    protected WorkList<Square> workList;

    public MazeSolver(Maze maze){
        this.maze = maze;
    }

    private WorkList<Square> constructor(){
        if(solverType.getClass().equals(new MyStack<Square>().getClass())){
            return new MyStack<Square>();
        }
        if(solverType.getClass().equals(new MyQueue<Square>().getClass())){
            return new MyQueue<Square>();
        }
        return null;
    }

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    boolean isSolved(){
        Square s = maze.getEnd();
        while(s.previous != null){
            s = s.previous;
            if(maze.getStart().equals(s)){
                return true;
            }
        }
        return false;
    }

    String getPath(){
        if(!isSolved()){
            return "No Path";
        }
        String path = "";
        Square s = maze.getEnd();
        while(s.previous != null){
            s.onPath = true;
            path += s.coords();
            s = s.previous;
        }
        return path;        
    }

    public Square step(){
        if(workList == null){
            workList = constructor();
            add(maze.getStart());
            return null;
        } else {
            Square s = next();
            s.isCurrent = true;
            if(maze.getStart().equals(s)){
                workList.clear();
                return s;
            }
            ArrayList<Square> neighbors = maze.getNeighbors(s.getRow(), s.getCol());
            for(Square near : neighbors){
                if(!near.explored){
                    near.explored = true;
                    add(near);
                }
                if(near.isCurrent){
                    near.isCurrent = false;
                }
            }
            return s;
        }
    }

    public void solve(){
        while(!workList.isEmpty()){
            step();
        }
    }
}