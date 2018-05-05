package algorithms.search;
import algorithms.mazeGenerators.*;
//
public class SearchableMaze implements ISearchable {

    private AState start,goal;
    private void addPossibleNextStates(MazeState[][] maze){
        for (int i = 0; i < maze.length;i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if(maze[i][j]!=null){
                    if(i>0&&maze[i-1][j]!=null){
                        maze[i][j].possibleNextStates.add(maze[i-1][j]);
                    }
                    if(i<maze.length-1&&maze[i+1][j]!=null){
                        maze[i][j].possibleNextStates.add(maze[i+1][j]);
                    }
                    if(j>0&&maze[i][j-1]!=null){
                        maze[i][j].possibleNextStates.add(maze[i][j-1]);
                    }
                    if(j<maze[0].length-1&&maze[i][j+1]!=null){
                    }
                    if(i>0&&j>0&&maze[i-1][j-1]!=null){
                        maze[i][j].possibleNextStates.add(maze[i-1][j-1]);
                    }
                    if(i<maze.length-1&&j>0&&maze[i+1][j-1]!=null){
                        maze[i][j].possibleNextStates.add(maze[i+1][j-1]);
                    }
                    if(j<maze[0].length-1&&i<maze.length-1&&maze[i+1][j+1]!=null){
                        maze[i][j].possibleNextStates.add(maze[i+1][j+1]);
                    }
                    if(j<maze[0].length-1&&i>0&&maze[i-1][j+1]!=null){
                        maze[i][j].possibleNextStates.add(maze[i-1][j+1]);
                    }
                }
            }
        }
    }

    public SearchableMaze(Maze maze)
    {
        MazeState[][] mazeOfStates= new MazeState[maze.getNumOfRows()][maze.getNumOfColumns()];
        for (int i = 0; i < maze.getNumOfRows();i++) {
            for (int j = 0; j < maze.getNumOfColumns();j++) {
                mazeOfStates[i][j]=null;
                if (maze.isPathCell(i, j)) {
                    mazeOfStates[i][j]=new MazeState(new Position(i, j));
                }
            }
        }
        addPossibleNextStates(mazeOfStates);
        this.start= mazeOfStates[maze.getStartPosition().getRowIndex()][maze.getStartPosition().getColumnIndex()];
        this.goal= mazeOfStates[maze.getGoalPosition().getRowIndex()][maze.getGoalPosition().getColumnIndex()];
    }
    public SearchableMaze(AState start,AState end)
    {
        this.start=start;
        this.goal=end;
    }
    public AState getStartState()
    {
        return this.start;
    }
    public AState getGoalState()
    {
        return this.goal;
    }
}