import java.util.*;
import java.io.*;

public class Maze {
    private Square[][]  maze;
    private Square start, end;

    public Maze(){

    }

    // there is a better way to do this but it works
    boolean loadMaze(String fileName) throws FileNotFoundException{
        File f = new File(fileName);
        Scanner scan = new Scanner(f);
        String str = scan.nextLine();  scan.close();

        int numRows = Integer.parseInt(str.substring(0, str.indexOf(" ")));
        int numCols = Integer.parseInt(str.substring(str.indexOf(" ")+1));

        this.maze = new Square[numRows][numCols];
        scan = new Scanner(f); scan.nextLine();
        int row = 0, col = 0;
        while(scan.hasNext()){
            str = scan.nextLine();
            for(col = 0; col < numCols; col++){
                int type = Integer.parseInt(str.substring(2*col,2*col+1));
                maze[row][col] = new Square(row,col,type);
                if(type == 2){
                    this.start = maze[row][col];
                }
                if(type == 3){
                    this.end = maze[row][col];
                }
            }
            row++;
        }
        return true;
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

    public Square getStart(){
        if(this.start == null){
            throw new NullPointerException();
        }
        return start;
    }

    public Square getFinish(){
        if(this.end == null){
            throw new NullPointerException();
        }
        return end;
    }
    
    public void reset(){
        for(Square[] row : maze){
            for(Square s : row){
                s.reset();
            }
        }
    }

    public String toString(){
        String result = "";
        for(Square[] row : maze){
            for(Square s : row){
                result += s;
            }
            result += "\n";
        }
        return result;
    }
}
