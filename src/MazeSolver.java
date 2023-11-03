import java.util.ArrayList;

public abstract class MazeSolver{
    protected Maze maze;
    protected WorkList<Square> workList;
    protected boolean setup = false;

    public MazeSolver(Maze maze){
        this.maze = maze;
    }

    public void setup(){
        workList.clear();
        workList.add(maze.getStart());
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
        maze.reset();
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
        path += maze.getStart().coords();
        return path;        
    }

    public Square step(){
        if(!setup){
            setup();
            setup = !setup;
        }
        Square s = next();
        s.isCurrent = true;
        s.explored = true;
        if(maze.getEnd().equals(s)){
            workList.clear();
            return s;
        }
        ArrayList<Square> neighbors = maze.getNeighbors(s.getRow(), s.getCol());
        for(Square near : neighbors){
            if(near.isCurrent){
                near.isCurrent = false;
            }
            if(near.getType() == 1){
                continue;
            }
            if(near.explored){
                continue;
            }
            near.previous = s;
            add(near);
        }
        workList.remove();
        return s;
    }

    public void solve(){
        while(!workList.isEmpty()){
            step();
        }
    }
}