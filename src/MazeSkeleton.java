public interface MazeSkeleton {
    public abstract boolean loadMaze(String fname);
    public abstract ArrayList<Square> getNeighbors(Square sq);
    public abstract Square getStart();
    public abstract Square getFinish();
    public abstract void reset();
    public abstract String toString();
}
