package algorithms.mazeGenerators;

import java.util.Random;

public abstract class AMazeGenerator implements IMazeGenerator {
    /**
     * find the time between the start measuring to the time after maze generetion.
     * @param row
     * @param col
     * @return
     */
    public long  measureAlgorithmTimeMillis(int row,int col)
    {
        long before = System.currentTimeMillis();
        generate(col,row);
        long afrer=System.currentTimeMillis();
        return afrer-before;
    }

    /**
     * filling all the maze array just with blocks.
     * @param array
     * @param row
     * @param col
     */
    protected void initArray (int[][]array, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = 1;
            }
        }
    }

    /**
     * init random position in the array maze, not include the borders
     * @param row
     * @param col
     * @return
     */
    protected Position getRandomPosition(int row, int col)
    {
        Random random=new Random();
        int c= random.nextInt(col-1)+1;
        int r= random.nextInt(row-1)+1;
        return new Position(r, c);
    }
}