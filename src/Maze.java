import java.util.*;

public class Maze implements MazeSkeleton{
    private Square[][]  maze;
    public Maze(){}
    

    boolean loadMaze(String fname){
        
        Scanner scan = new Scanner(new File(fname));
        String str = scan.nextLine();

        int numRows = Integer.parseInt(str.substring(0, str.indexOf(" ")));
        int numCols = Integer.parseInt(str.substring(str.indexOf(" ")+1));

        this.maze = new Square[numRows][numCols];

        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++){
                maze[row][col] = null;
            }
        }
    }

    ArrayList<Square> getNeighbors(Square sq){
        ArrayList<Square> neighbors = new ArrayList<>();

        int[] xOffset = {0,1,0,-1};
        int[] yOffset = {1,0,-1,0};
        for(int i = 0; i < 4; i++){
            try{
                neighbors.add(maze[sq.getRow()+yOffset[i]][sq.getCol()+xOffset[i]]);
            } catch(Exception e){}
        }

        return neighbors;
    }

        //return an ArrayList of the Square neighbors of the parameter Square sq. There will be at most four of these (to the North, East, South, and West) and you should list them in that order.
        //If the square is on a border, skip over directions that are out of bounds of the maze. Don't be adding in null values.
    

    public Square getStart(){

    }
    public Square getFinish(){

    }
    public void reset(){

    }
    public String toString(){
        
    }
}
