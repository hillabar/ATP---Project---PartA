package algorithms.mazeGenerators;

public class Maze {
    private int[][]maze;
    private Position start;
    private Position goal;
    public Maze(int[][] maze,Position start,Position goal){
        this.start=start;
        this.goal=goal;
        int col= maze[0].length;
        int row=maze.length;
        int[][]MyMaze=new int[row][col];
        for(int i=0; i<row;i++){
            for(int j=0;j<col;j++){
                MyMaze[i][j]= maze[i][j];
            }
        }

        this.maze=MyMaze;
    }
    public Position getStartPosition(){
        return new Position(start.getRowIndex(),start.getColumnIndex());
    }
    public Position getGoalPosition(){
        return new Position(goal.getRowIndex(),goal.getColumnIndex());
    }
    public boolean isPathCell(int row,int col){
        if(maze[row][col]==0)
        {
            return true;
        }
        return false;
    }
    public int getNumOfRows()
    {
        return maze.length;
    }
    public int getNumOfColumns(){
        return maze[0].length;
    }

    /**
     * print the start& goal cells as E and S, and all the other cells in dark&light colors.
     */
    public void print(){
        int col= maze[0].length;
        int row=maze.length;
        for(int i=0; i<row;i++){
            for(int j=0;j<col;j++){
                if(j==start.getColumnIndex()&&i==start.getRowIndex()){
                    System.out.print("S");
                }
                else {
                    if(j==goal.getColumnIndex()&&i==goal.getRowIndex()){
                        System.out.print("E");
                    }
                    else
                    {
                        if (maze[i][j]==1)
                            System.out.print("█");
                        else if(maze[i][j]==0)
                            System.out.print("░");
                    }
                }
            }
            System.out.println();
        }
    }
}