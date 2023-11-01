import java.util.ArrayList;

public abstract class MazeSolver{
    protected Maze maze;
    protected WorkList<Square> workList;

    public MazeSolver(Maze maze){
        this.maze = maze;
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
            path += s.coords();
            s = s.previous;
        }
        return path;        
    }

    public Square step(){
        if(workList == null){
            workList = new WorkList<Square>();
            workList.add(maze.getStart());
            return null;
        } else {
            Square s = workList.getFirst();
            if(maze.getStart().equals(s)){
                workList.clear();
                return s;
            }
            ArrayList<Square> neighbors = maze.getNeighbors(s.getRow(), s.getCol());
            for(Square near : neighbors){
                workList.add(near);
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