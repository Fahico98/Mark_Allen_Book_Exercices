
import java.util.LinkedList;

public class Section_18_1_firstChild_nextSibling_Method {
    
}

class ListTree<T>{
    
    private LinkedList<ListTree> siblings;
    private T value;
    
    public ListTree(T value){
        this.value = value;
    }
    
    public T getValue(){
        return(this.value);
    }
    
    public void addChild(T toAdd){
        ListTree<T> nodeToAdd = new ListTree(toAdd);
        this.siblings.add(nodeToAdd);
    }
}