package algorithms.search;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class BestFirstSearch extends BreadthFirstSearch {
    @Override
    public String getName() {
        return "Best First Search";
    }

    protected void addToList(LinkedList<AState> listOfStates, AState aState) {
        if (listOfStates.size() == 0) {
            listOfStates.add(aState);
            return;
        }
        for (int i=0; i<listOfStates.size();i++)
        {
            if(listOfStates.get(i).getPriority()<aState.getPriority())
            {
                listOfStates.add(i,aState);
                break;
            }
        }
        listOfStates.add(listOfStates.size(),aState);
    }
}