
/**

NOTES:

The 'LinkedList' class implements the 'List' interface, therefore it got all 
'List' interface methods

To iterate a 'LinkedList' instance we have call 'ListIterator' method instead
'Iterator'


* ArrayList vs LinkedList

The ArrayList may be appropriate if insertions are performed only at the high
end of the array, The ArrayList doubles the internal array capacity if an
insertion at the high end would exceed the internal capacity, Although this
gives good Big-Oh performance, especially if we add a constructor that allows
the caller to suggest initial capacity for the internal array, the ArrayList is
a poor choice if insertions are not made at the end, because then we must move
items out of the way.

*/

import java.util.LinkedList;
import java.util.ListIterator;

public class Section_6_5_LinkedList {
    
    public static void main(String[] arguments){
        
        LinkedList<String> people = new LinkedList();
        
        people.add("James");
        people.add("Brendan");
        people.add("George");
        people.add("Terence");
        people.add("Nikcy");
        people.add("Thomas");
        
        // Print LinkedList elements using ListIterator.
        
        ListIterator<String> peopleIterator = people.listIterator();
        
        while(peopleIterator.hasNext()){
            System.out.println(peopleIterator.next());
        }
        
        System.out.println(" -------------------------------------------- ");
        
        LinkedList<String> countries = new LinkedList();
        
        countries.add("España");
        countries.add("Colombia");
        countries.add("Inglaterra");
        countries.add("Mexico");
        countries.add("Argentina");
        
        LinkedList<String> capitals = new LinkedList();
        
        capitals.add("Madrid");
        capitals.add("Bogota D.C.");
        capitals.add("Londres");
        capitals.add("Ciudad de Mexico");
        capitals.add("Buenon Aires");
        
        System.out.println(countries);
        System.out.println(capitals);
        
        System.out.println(" -------------------------------------------- ");
        
        ListIterator<String> countriesIterator = countries.listIterator();
        ListIterator<String> capitalsIterator = capitals.listIterator();
        
        while(capitalsIterator.hasNext()){
            if(countriesIterator.hasNext()){
                countriesIterator.next();
            }
            countriesIterator.add(capitalsIterator.next());
        }
        
        System.out.println(countries);
    }
}
