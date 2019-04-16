
/*

********** Queue interface methods **********

* boolean add(E e)
Inserts the specified element into this queue if it is possible to do so
immediately without violating capacity restrictions, returning true upon success
and throwing an IllegalStateException if no space is currently available.

* E element()
Retrieves, but does not remove, the head of this queue.

* boolean offer(E e)
Inserts the specified element into this queue if it is possible to do so
immediately without violating capacity restrictions.

* E peek()
Retrieves, but does not remove, the head of this queue, or returns null if this
queue is empty.

* E poll()
Retrieves and removes the head of this queue, or returns null if this queue is
empty.

* E remove()
Retrieves and removes the head of this queue.

*/


import java.util.LinkedList;
import java.util.Queue;

public class Section_6_6_Queues {
    
    public static void main(String[] arguments){
        
        Queue<Integer> numsQueue = new LinkedList<Integer>();
        
        numsQueue.offer(10);
        numsQueue.offer(20);
        numsQueue.offer(30);
        numsQueue.offer(40);
        numsQueue.offer(50);
        
        System.out.println("The first number in the queue is: " + numsQueue.peek());
        System.out.println("The first number in the queue is: " + numsQueue.element());
        
        System.out.println("-------------------------------------------------");
        
        System.out.println(numsQueue);
        
        System.out.println("'" + numsQueue.poll() + "' has been removed of the Queue...!");
        
        System.out.println(numsQueue);
        
        System.out.println("'" + numsQueue.remove() + "' has been removed of the Queue...!");
        
        System.out.println(numsQueue);
    }
}
