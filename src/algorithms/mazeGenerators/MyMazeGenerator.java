package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {
    public MyMazeGenerator()
    {
    }

    private boolean isOnePassNeighbor(int [][] array,int row,int col)
    {
        int counter=0;
        if(row>0 && PassCell(array,row-1,col))
            counter++;
        if(col>0 && PassCell(array,row,col-1))
            counter++;
        if(row<array.length-1&& PassCell(array,row+1,col))
            counter++;
        if(col<array[0].length-1&& PassCell(array,row,col+1))
            counter++;
        return counter==1;
    }
    private boolean PassCell (int [][] array, int row, int col)
    {
        return (array[row][col]==0||array[row][col]==2);
    }
    private void treatNeighbors(List<Position>nodes, int [][]array, List<Position>lst)
    {
        Random random=new Random();
        int size = nodes.size();
        int index = random.nextInt(size);
        Position curr = nodes.get(index);
        lst.add(curr);
        nodes.remove(index);
        array[curr.getRowIndex()][curr.getColumnIndex()] = 0;

        if (curr.getRowIndex() != 0)
            addAndUpdate (nodes, array,curr, curr.getRowIndex()-1, curr.getColumnIndex());

        if (curr.getColumnIndex() != 0)
            addAndUpdate (nodes, array,curr, curr.getRowIndex(), curr.getColumnIndex() - 1);

        if (curr.getRowIndex() != array.length - 1)
            addAndUpdate (nodes, array,curr, curr.getRowIndex()+1, curr.getColumnIndex());

        if (curr.getColumnIndex() != array[0].length - 1)
            addAndUpdate (nodes, array,curr, curr.getRowIndex(), curr.getColumnIndex() + 1);
    }
private void addAndUpdate (List<Position>nodes, int [][]array, Position curr, int row, int col)
    {
        if (array[row][col] == 1 && isOnePassNeighbor(array, row, col))
        {
            nodes.add(new Position(row, col));
            array[row][col] = 2;
        }
    }

    private Position prim(int[][] array, Position start)
    {
        List<Position> nodes = new ArrayList<>();
        nodes.add(start);
        initArray (array, array.length, array[0].length);

        List<Position> lst = new ArrayList<>();
        while (nodes.size() > 0)
        {
            treatNeighbors(nodes,array,lst);
        }
        int size = lst.size();
        Random random=new Random();
        int index = random.nextInt(size);
        Position curr = lst.get(index);
        while(curr.equalsPos(start))
        {
            lst.remove(curr);
            size--;
            index = random.nextInt(size);
            curr= lst.get(index);
        }
        return curr;
    }
    public Maze generate(int row, int col)
    {
        int [][]array=new int[row][col];
        Position start=getRandomPosition(col,row);
        Position goal =prim(array,start);
        Maze maze =new Maze(array,start,goal);
        return maze;
    }
}