package algorithms.mazeGenerators;

public class SimpleMazeGenerator extends AMazeGenerator {
    public SimpleMazeGenerator(){

    }

    private void generatePath(Position start,Position goal, int[][] myMaze)
    {
        Position upper;
        Position lower;
        if(start.getRowIndex()>goal.getRowIndex())
        {
            upper=goal;
            lower=start;
        }
        else
            {
                upper=start;
                lower=goal;
        }
        int currRow=upper.getRowIndex();
        int currCol=upper.getColumnIndex();
        int currColSteps=0;
        int rowSteps=lower.getRowIndex()-upper.getRowIndex();
        int colSteps=Math.abs(upper.getColumnIndex()-lower.getColumnIndex());
        boolean isUpperLefter=upper.getColumnIndex()-lower.getColumnIndex()<0;
        for(int i=1;i<=rowSteps+colSteps;i++)
        {
            if ((Math.random()>0.5&&currRow<lower.getRowIndex())||colSteps==currColSteps)
            {
                currRow++;
            }
            else
            {
                currColSteps++;
                if (isUpperLefter&&currCol<myMaze.length-1)
                    currCol++;
                else if (currCol>0)
                    currCol--;
            }
            myMaze[currRow][currCol] = 2;
        }
    }
    public Maze generate(int row,int col)
    {
        Position start= getRandomPosition(col,row);
        Position goal= getRandomPosition(col,row);
        //if start and goal are in same cell, choose another goal randomaly
        while(start.equalsPos(goal))
        {
            goal=getRandomPosition(col,row);
        }
        int[][] myMaze = new int[row][col];
        initArray(myMaze,col,row);
        generatePath(start,goal,myMaze);
//the borders has to remain black, so we won't scan them
        for (int i = 1; i < row-1; i++)
        {
            for (int j = 1; j < col-1; j++)
            {
                if(myMaze[i][j]==1)
                {
                    if(Math.random()>0.5)
                    {
                        myMaze[i][j] = 0;
                    }
                }
            }
        }
        generate2to0(myMaze, col,row);
        return new Maze(myMaze,start,goal);
    }

    /**
     * move every 2 cell back to be a pass (0) cell
     * @param myMaze
     * @param col
     * @param row
     */
    private void generate2to0 (int [][]myMaze, int col, int row)
    {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
            {
                if (myMaze[i][j] == 2) {
                    myMaze[i][j] = 0;
                }
            }
        }

    }
}