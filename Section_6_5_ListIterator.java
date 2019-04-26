
/**

 * ListIterator interface methods

* void add(E e)
Inserts the specified element into the list (optional operation)

* boolean hasNext()
Returns true if this list iterator has more elements when traversing the list in
the forward direction

* boolean hasPrevious()
Returns true if this list iterator has more elements when traversing the list in
the reverse direction

* E next()
Returns the next element in the list and advances the cursor position

* int nextIndex()
Returns the index of the element that would be returned by a subsequent call to
next()

* E previous()
Returns the previous element in the list and moves the cursor position backwards

* int previousIndex()
Returns the index of the element that would be returned by a subsequent call to
previous()

* void remove()
Removes from the list the last element that was returned by next() or previous()
(optional operation)

* void set(E e)
Replaces the last element returned by next() or previous() with the specified
element (optional operation).

*/

import java.util.ArrayList;
import java.util.ListIterator;

public class Section_6_5_ListIterator {
    
    public static void main(String[] arguments){
        
        ArrayList<String> names = new ArrayList();
        
        names.add("Menphis");
        names.add("Marck");
        names.add("David");
        names.add("Thomas");
        names.add("Billy");
        
        ListIterator namesIterator = names.listIterator();
        
        System.out.println("Printing the list elements...!");
        while(namesIterator.hasNext()){
            System.out.println(namesIterator.next());
        }
        
        System.out.println(" ---------------------------------- ");
        
        System.out.println("Printing the reverse list elements...!");
        while(namesIterator.hasPrevious()){
            System.out.println(namesIterator.previous());
        }
    }
}
