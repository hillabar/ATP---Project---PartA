package algorithms.search;

import java.util.ArrayList;
public class Solution {

    private ArrayList<AState> solution;
    public Solution(ArrayList<AState> solution){

        this.solution=solution;
    }
    public ArrayList<AState> getSolutionPath()
    {
        return new ArrayList<>(this.solution);
    }
}