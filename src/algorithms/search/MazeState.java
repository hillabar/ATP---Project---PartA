package algorithms.search;
import algorithms.mazeGenerators.*;

public class MazeState extends AState {
    private Position current;
    public MazeState(Position curr)
    {
        super();
        current=curr;
        this.stateToString="{"+curr.getRowIndex()+","+curr.getColumnIndex()+"}";

    }
    public MazeState(Position curr, int priority)
    {
        super(priority);
        current=curr;
        this.stateToString="{"+curr.getRowIndex()+","+curr.getColumnIndex()+"}";
    }

    public Position getCurrentPosition()
    {
        return new Position(current);
    }
}