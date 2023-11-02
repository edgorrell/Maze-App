import java.util.*;
import java.io.*;

public class Maze{
    private Square[][] maze = null;
    private Square start, end;
    private int numRows, numCols;

    public Maze(){

    }

    boolean loadMaze(String fileName){
        try{
            File f = new File(fileName);
            Scanner scan = new Scanner(f);
            String str = scan.nextLine();  scan.close();

            numRows = Integer.parseInt(str.substring(0, str.indexOf(" ")));
            numCols = Integer.parseInt(str.substring(str.indexOf(" ")+1));

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
        } catch(Exception e){
            return false;
        }
    }

    ArrayList<Square> getNeighbors(int row, int col){
        ArrayList<Square> neighbors = new ArrayList<>();
        Square sq = getSquare(row, col);
        
        int[] xOffset = {0,1,0,-1};
        int[] yOffset = {1,0,-1,0};
        for(int i = 0; i < 4; i++){
            try{
                neighbors.add(maze[sq.getRow()+yOffset[i]][sq.getCol()+xOffset[i]]);
            } catch(Exception e){
                continue;
            }
        }

        return neighbors;
    }

    public Square getSquare(int row, int col){
        return maze[row][col];
    }

    public Square getStart(){
        return start;
    }

    public Square getEnd(){
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
        for(int i = 0; i < numCols + 2; i++){
            result += "#";
        }
        result += "\n";
        for(Square[] row : maze){
            result += "#";
            for(Square s : row){
                result += s;
            }
            result += "#\n";
        }
        for(int i = 0; i < numCols + 2; i++){
            result += "#";
        }
        return result;
    }
}
