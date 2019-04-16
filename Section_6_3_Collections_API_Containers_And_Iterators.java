/*

********** Collection interface methods **********

* boolean add(E e)
Ensures that this collection contains the specified element (optional operation).

* boolean addAll(Collection<? extends E> c)
Adds all of the elements in the specified collection to this collection
(optional operation).

* void clear()
Removes all of the elements from this collection (optional operation).

* boolean contains(Object o)
Returns true if this collection contains the specified element.

* boolean containsAll(Collection<?> c)
Returns true if this collection contains all of the elements in the specified
collection.

* boolean equals(Object o)
Compares the specified object with this collection for equality.

* int hashCode()
Returns the hash code value for this collection.

* boolean isEmpty()
Returns true if this collection contains no elements.

* Iterator<E> iterator()
Returns an iterator over the elements in this collection.

* boolean remove(Object o)
Removes a single instance of the specified element from this collection, if it is
present (optional operation).

* boolean removeAll(Collection<?> c)
Removes all of this collection's elements that are also contained in the specified
collection (optional operation).

* boolean retainAll(Collection<?> c)
Retains only the elements in this collection that are contained in the specified
collection (optional operation).

* int size()
Returns the number of elements in this collection.

* Object[] toArray()
Returns an array containing all of the elements in this collection.

* <T> T[] toArray(T[] a)
Returns an array containing all of the elements in this collection; the runtime
type of the returned array is that of the specified array.


********** Iterator interface methods **********

* boolean hasNext():
Returns true if the iteration has more elements.

* E next()
Returns the next element in the iteration.

* void remove()
Removes from the underlying collection the last element returned by this iterator
(optional operation).

*/

import java.util.ArrayList;
import java.util.Iterator;

public class Section_6_3_Collections_API_Containers_And_Iterators{
    
    public static void main(String[] arguments){
        
        /* The 'ArrayList' class implements 'List' interface wich is a subinterface
        to the 'Collection' interface, therefore, 'ArrayList' contain all its methods,
        like 'add()', 'remove()', 'iterator()', so on.*/
        
        ArrayList<String> animals = new ArrayList();
        
        animals.add("Fox");
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");
        animals.add("Tiger");
        
        // Using loops to print.
        
        for(String animal : animals){
            System.out.println(animal);
        }
        
        System.out.println("-------------------------");
        
        // Using iterator to print.
        
        Iterator animalsIterator = animals.iterator();
        
        while(animalsIterator.hasNext()){
            System.out.println(animalsIterator.next());
        }
        
        /* For a container, any external structural modification of this container
        (adds, removes, and so on) will result in a ConcurrentModificationException
        by the iterator methods when one of the methods is called. As with the
        following two code lines.*/
        
        animals.remove("Cat");
        System.out.println(animalsIterator.next());
    }
}

