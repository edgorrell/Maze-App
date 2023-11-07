public class Square{
    private int row, col, type;
    public Square previous;
    public boolean explored, onPath, isCurrent;

    public Square(int row, int col, int type){
        this.row = row;
        this.col = col;
        this.type = type;
        this.reset();
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public int getType(){
        return this.type;
    }

    public void reset(){
        this.explored = false;
        this.isCurrent = false;
    }

    public void resetAll(){
        this.explored = false;
        this.isCurrent = false;
        this.onPath = false;
        this.previous = null;
    }

    public String coords(){
        return "(" + row + "," + col + ")";
    }

    // 0 = empty
    // 1 = wall
    // 2 = start
    // 3 = end
    // booleans determine stuff when solving
    public String toString(Maze m){
        switch(type){
            case 0:
                if(isCurrent){
                    return "o";
                }
                if(onPath){
                    return "x";
                }
                if(explored){
                    return ".";
                }
                return " ";
            case 1:
                return "#";
            case 2:
                return "S";
            case 3:
                return "E";
        }
        return " ";
    }

    public boolean equals(Square s){
        return this.row == s.row && this.col == s.col && this.type == s.type;
    }
}