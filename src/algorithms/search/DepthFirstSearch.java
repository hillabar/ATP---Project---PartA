package algorithms.search;
public class DepthFirstSearch extends ASearchingAlgorithm{
    AState goal;

    @Override
    public String getName() {
        return "Depth First Search";
    }
    protected void solve(AState curr, AState goal) {
        this.goal=goal;
        this.numberOfNodesEvaluated++;
        curr.isVisited=true;
        if(curr==goal){
            return;
        }
        for (int i=0;i<curr.possibleNextStates.size();i++){
            if(!curr.possibleNextStates.get(i).isVisited){
                curr.possibleNextStates.get(i).setParent(curr);
                solve(curr.possibleNextStates.get(i),goal);
            }
        }
    }
}