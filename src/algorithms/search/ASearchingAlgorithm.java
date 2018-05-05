package algorithms.search;
import java.util.ArrayList;
public abstract class ASearchingAlgorithm implements  ISearchingAlgorithm{
    protected int numberOfNodesEvaluated;
    protected  ASearchingAlgorithm()
    {
        this.numberOfNodesEvaluated=0;
    }
    public int getNumberOfNodesEvaluated()
    {
        return numberOfNodesEvaluated;
    }
    public Solution solve(ISearchable iSearchable) {
        if (iSearchable == null)
            return null;
        AState start=iSearchable.getStartState();
        AState goal = iSearchable.getGoalState();
        ArrayList<AState> sol=new ArrayList<>();
        this.numberOfNodesEvaluated=0;
        if(goal==start) {
            sol.add(goal);
            this.numberOfNodesEvaluated=1;
            return new Solution(sol);
        }
        solve(start,goal);
        AState partOfTheSolution=goal;
        while(partOfTheSolution!=null)
        {
            sol.add(0,partOfTheSolution);
            partOfTheSolution=partOfTheSolution.getParent();
        }
        if (sol==null)
            return null;
        Solution solution=new Solution(sol);
        return solution;
    }
    protected abstract void solve(AState start,AState goal);
}