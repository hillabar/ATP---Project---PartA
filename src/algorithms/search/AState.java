package algorithms.search;

import java.util.ArrayList;

public abstract class AState implements Comparable{

    public boolean isVisited;
    private int priority;
    protected ArrayList<AState> possibleNextStates;
    private AState parent;
    protected String stateToString;

    @Override
    public int compareTo(Object o) {
        if(o instanceof AState)
        {
            AState aState=(AState)o;
            return aState.priority-this.priority;
        }
        throw new IllegalArgumentException("not a state object");
    }

    protected AState(int priority) {
        isVisited = false;
        this.priority = priority;
        possibleNextStates = new ArrayList<>();
        parent=null;
        this.stateToString="";
    }
    protected AState() {
        this(-1);
    }
    public void setParent(AState parent)
    {
        this.parent=parent;
    }
    public String toString()
    {
        return this.stateToString;
    }

    public AState getParent()
    {
        return  this.parent;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority)
    {
        this.priority=priority;
    }
}