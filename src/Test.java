import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) throws FileNotFoundException{
        Maze m = new Maze();
        m.loadMaze("src\\maze-81a");
        System.out.println(m);
    }    
}
