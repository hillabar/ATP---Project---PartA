package algorithms.mazeGenerators;

public class Position {
    private int row;
    private int col;

    public Position(int row,int col){
        this.row=row;
        this.col=col;
    }
    public Position(Position pos)
    {
        this(pos.row,pos.col);
    }

    /**
     * This function will return the index of the row
     * @return - The index of the row
     */
    public int getRowIndex(){
        return row;
    }
    public int getColumnIndex(){
        return col;
    }
    public boolean equalsPos(Position p)
    {
        return this.getColumnIndex()==p.getColumnIndex()&&this.getRowIndex()==p.getRowIndex();
    }

    @Override
    public String toString(){
        return "{"+row+","+col+"}";
    }
}