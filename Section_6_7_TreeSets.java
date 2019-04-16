
/*

The 'TreeSet' class allows create sorted trees as it implements the 'SortedSet'
interface which in turn iplements the 'Set' inteface.

********** TreeSet class methods **********

* boolean add(E e)
Adds the specified element to this set if it is not already present.

* boolean addAll(Collection<? extends E> c)
Adds all of the elements in the specified collection to this set.

* E ceiling(E e)
Returns the least element in this set greater than or equal to the given
element, or null if there is no such element.

* void clear()
Removes all of the elements from this set.

* Object clone()
Returns a shallow copy of this TreeSet instance.

* Comparator<? super E> comparator()
Returns the comparator used to order the elements in this set, or null if this
set uses the natural ordering of its elements.

* boolean contains(Object o)
Returns true if this set contains the specified element.

* Iterator<E> descendingIterator()
Returns an iterator over the elements in this set in descending order.

* NavigableSet<E> descendingSet()
Returns a reverse order view of the elements contained in this set.

* E first()
Returns the first (lowest) element currently in this set.

* E floor(E e)
Returns the greatest element in this set less than or equal to the given
element, or null if there is no such element.

* SortedSet<E> headSet(E toElement)
Returns a view of the portion of this set whose elements are strictly less than
toElement.

* NavigableSet<E> headSet(E toElement, boolean inclusive)
Returns a view of the portion of this set whose elements are less than (or equal
to, if inclusive is true) toElement.

* E higher(E e)
Returns the least element in this set strictly greater than the given element,
or null if there is no such element.

* boolean isEmpty()
Returns true if this set contains no elements.

* Iterator<E> iterator()
Returns an iterator over the elements in this set in ascending order.

* E last()
Returns the last (highest) element currently in this set.

* E lower(E e)
Returns the greatest element in this set strictly less than the given element,
or null if there is no such element.

* E pollFirst()
Retrieves and removes the first (lowest) element, or returns null if this set is
empty.

* E pollLast()
Retrieves and removes the last (highest) element, or returns null if this set is
empty.

* boolean remove(Object o)
Removes the specified element from this set if it is present.

* int size()
Returns the number of elements in this set (its cardinality).

* NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
Returns a view of the portion of this set whose elements range from fromElement to toElement.

* SortedSet<E> subSet(E fromElement, E toElement)
Returns a view of the portion of this set whose elements range from fromElement,
inclusive, to toElement, exclusive.

* SortedSet<E> tailSet(E fromElement)
Returns a view of the portion of this set whose elements are greater than or
equal to fromElement.

* NavigableSet<E> tailSet(E fromElement, boolean inclusive)
Returns a view of the portion of this set whose elements are greater than (or
equal to, if inclusive is true) fromElement.

*/

import java.util.Iterator;
import java.util.TreeSet;

public class Section_6_7_TreeSets {
    
    public static void main(String[] arguments){
        
        TreeSet<Integer> yearsTree = new TreeSet();
        
        yearsTree.add(1992);
        yearsTree.add(1918);
        yearsTree.add(2015);
        yearsTree.add(1184);
        yearsTree.add(2001);
        yearsTree.add(1945);
        yearsTree.add(1550);
        
        Iterator<Integer> yearsIterator = yearsTree.descendingIterator();
        
        while(yearsIterator.hasNext()){
            System.out.println(yearsIterator.next());
        }
    }
}
