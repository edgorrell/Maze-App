public class Square{
    private Square previous;
    private int row, col, type;
    public boolean explored, onPath, isCurrent;

    public Square(int row, int col, int type){
        this.row = row;
        this.col = col;
        this.type = type;
        this.previous = previous;
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

    // 0 = empty
    // 1 = wall
    // 2 = start
    // 3 = end
    // booleans determine stuff when solving
    public String toString(){
        if(isCurrent){
            return "o";
        }
        if(onPath){
            return "x";
        }
        if(explored){
            return ".";
        }
        switch(type){
            case 0:
                return " ";
            case 1:
                return "#";
            case 2:
                return "S";
            case 3:
                return "E";
        }
        return null;
    }
}