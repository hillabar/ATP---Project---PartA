package JUnit;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.ASearchingAlgorithm;
import algorithms.search.BestFirstSearch;
import algorithms.search.ISearchable;
import algorithms.search.SearchableMaze;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JUnitTestingBestFirstSearch {
    @org.junit.jupiter.api.Test
    void TestName()
    {
        assertEquals("Best First Search", new BestFirstSearch().getName());
    }

    @org.junit.jupiter.api.Test
    void testNull() {
        IMazeGenerator gen = new MyMazeGenerator();
        Maze maze = gen.generate(10, 10);
        ISearchable searchableMaze = null;
        ASearchingAlgorithm Best = new BestFirstSearch();
        assertEquals(null, Best.solve(searchableMaze));
    }
    @org.junit.jupiter.api.Test
    void PositiveEvaluatedNumber()
    {
        BestFirstSearch BFS = new BestFirstSearch();
        MyMazeGenerator myMaze = new MyMazeGenerator();
        Maze maze = myMaze.generate(100, 100);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        BFS.solve(searchableMaze);
        Assertions.assertTrue(BFS.getNumberOfNodesEvaluated() > 0);
    }
    @org.junit.jupiter.api.Test
    void solveInMinute()
    {
        BestFirstSearch BFS = new BestFirstSearch();
        MyMazeGenerator myMaze = new MyMazeGenerator();
        Maze maze = myMaze.generate(1000, 1000);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        long before = System.currentTimeMillis();
        BFS.solve(searchableMaze);
        long time = System.currentTimeMillis() - before ;
        Assertions.assertTrue(time<=60000);
    }

}