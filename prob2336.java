import java.util.PriorityQueue;
import java.util.HashSet;

public class prob2336 {
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);                    // 2 is already in the set, so no change is made.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1, since 1 is the smallest number, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 2, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 3, and remove it from the set.
        smallestInfiniteSet.addBack(1);                    // 1 is added back to the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1, since 1 was added back to the set and
                                                               // is the smallest number, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 4, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 5, and remove it from the set.
    }
}

class SmallestInfiniteSet {

    private HashSet<Integer> hsExcludeInt;
    private PriorityQueue<Integer> pqExcludeInt;

    public SmallestInfiniteSet() {
        // rather than work with an infinite set
        // deal with a finite set to be excluded
        
        // use a hashset to quickly determine if element is in list
        // and priority queue to get the smallest element

        // when an element is removed from the infinite set
        // add it onto the heap. when an element is added to the infinite
        // set, remove it from the heap
        hsExcludeInt = new HashSet<>();
        pqExcludeInt = new PriorityQueue<>();
    }

    public int popSmallest() {
        // smallest element not in heap_excluded
        int smallest = 1;

        // peak at top. if does not contain

        // search for the smallest through bfs
        while (hsExcludeInt.contains(smallest)) {
            smallest++;
        }

        hsExcludeInt.add(smallest);
        return smallest;
    }
    
    public void addBack(int num) {
        // eliminate element from heap_excluded
        // if the element is not contained in it
        // then do nothing
        hsExcludeInt.remove(num);        
    }
}
