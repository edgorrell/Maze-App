import java.util.ArrayList;

public class MazeTest {
    public static void main(String[] args){
    Maze maze = new Maze();
    System.out.println(maze.loadMaze("src\\maze-81a"));
    ArrayList<Square> n = maze.getNeighbors(4,4);
    for(Square s : n){
        System.out.print(s.coords() + s + ", ");
    }
    System.out.println();
    //System.out.println(maze.getStart());
    //System.out.println(maze.getEnd());
    //System.out.println(maze.toString());
    }
}


