package algorithms.search;
import java.util.LinkedList;
public class BreadthFirstSearch extends ASearchingAlgorithm {

    @Override
    public String getName() {
        return "Breadth First Search";
    }
    protected void solve(AState start,AState goal) {
        LinkedList<AState> nextToBeEvaluated=new LinkedList<>();
        nextToBeEvaluated.add(start);
        AState scanned;
        this.numberOfNodesEvaluated++;
        start.isVisited=true;
        while(nextToBeEvaluated.size()!=0)
        {
            scanned=nextToBeEvaluated.removeFirst();
            for (int i=0; i<scanned.possibleNextStates.size();i++)
            {
                if(scanned.possibleNextStates.get(i)==goal)
                {
                    goal.setParent(scanned);
                    this.numberOfNodesEvaluated++;
                    return;
                }
                if (!scanned.possibleNextStates.get(i).isVisited)
                {
                    scanned.possibleNextStates.get(i).setParent(scanned);
                    scanned.possibleNextStates.get(i).isVisited=true;
                    this.numberOfNodesEvaluated++;
                    addToList(nextToBeEvaluated,scanned.possibleNextStates.get(i));
                }
            }
        }
    }
    protected void addToList(LinkedList<AState> listOfStates, AState aState) {
        listOfStates.addLast(aState);
    }
}