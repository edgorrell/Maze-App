
public class MazeTest {
    public static void main(String[] args){
    Maze maze = new Maze();
    System.out.println(maze.loadMaze("src\\maze-81a"));
    System.out.println(maze.getNeighbors(0,0));
    System.out.println(maze.getStart());
    System.out.println(maze.getEnd());
    System.out.println(maze.toString());
    }
}


