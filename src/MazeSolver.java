import java.util.ArrayList;

public abstract class MazeSolver{
    public Maze maze;
    public WorkList<Square> workList;
    public String path;
    private boolean setup = false;


    public MazeSolver(Maze maze){
        this.maze = maze;
    }

    public void setup(){
        workList.clear();
        workList.add(maze.getStart());
        maze.getStart().explored = true;
    }

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    boolean isSolved(){
        Square s = maze.getEnd();
        this.path = "";
        while(s.previous != null){
            this.path += s.coords();
            s.onPath = true;
            s = s.previous;
            if(maze.getStart().equals(s)){
                return true;
            }
        }
        this.path = "No Path";
        return false;
    }

    String getPath(){
        isSolved();
        return this.path;        
    }

    public Square step(){
        if(!setup){
            setup();
            setup = !setup;
        }
        Square s = workList.remove();
        s.isCurrent = true;
        if(maze.getEnd().equals(s)){
            workList.clear();
            return s;
        }
        ArrayList<Square> neighbors = maze.getNeighbors(s.getRow(), s.getCol());
        for(Square near : neighbors){
            if(near.isCurrent){
                near.isCurrent = false;
            }
            if(near.getType() == 1 || near.explored){
                continue;
            }
            near.previous = s;
            near.explored = true;
            add(near);
        }
        return s;
    }

    public void solve(){
        while(!workList.isEmpty()){
            step();
        }
    }
}