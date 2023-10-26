import java.util.*;

public class SquareTests {
    public static void main(String[] args){
        Square s1 = new Square(4,3,0);
        Square s2 = new Square(5,7,1);
        Square s3 = new Square(1,8,2);
        Square s4 = new Square(2,6,3);
        Square[] squares = new Square[] {s1,s2,s3,s4};

        for(Square sq : squares){
            System.out.println(sq.getRow() + "," + sq.getCol() + "," + sq.getType());
        }
    }
}
