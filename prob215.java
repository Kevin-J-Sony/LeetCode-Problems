import java.util.Arrays;
//import java.util.Random;

public class prob215 {
    public static void main(String[] args) {
        Solution215 sol = new Solution215();
        /*
        int[] heap = new int[10];
        Random rand = new Random();
        for (int i = 0; i < heap.length; i++) {
            heap[i] = rand.nextInt(100);
        }
        sol.sort(heap);
        System.out.println(Arrays.toString(heap));

        System.out.println("\n\n");
        */
        
        //int[] heap = {3,2,3,1,2,4,5,5,6};
        int[] heap = {3,2,1,5,4,6};
        System.out.println(sol.findKthLargest(heap, 2));
        //System.out.println(Arrays.toString(heap));
    }
}

class Solution215 {

    private void heapify(int[] nums) {
        int n = nums.length;
        for (int k = n / 2; k >= 0; k--) {
            // build the heap with node at k as root
            // and shift downwards to largest operation
            int largest = k;
            int currentNode = largest;
            boolean flag = false;

            while (largest < n && !flag) {
                int leftChildNode = 2*currentNode + 1;
                int rightChildNode = 2*currentNode + 2;
    

                if (leftChildNode < n && nums[leftChildNode] > nums[largest])
                    largest = leftChildNode;
                
                if (rightChildNode < n && nums[rightChildNode] > nums[largest])
                    largest = rightChildNode;
                
                if (largest != currentNode) {
                    int temp = nums[largest];
                    nums[largest] = nums[currentNode];
                    nums[currentNode] = temp;
                } else {
                    flag = true;
                }
                currentNode = largest;
            }
        }
        // heap created
    }

    private void mergeHeaps(int[] nums, int n) {
        // here, we assume array has already been heapified
        // then this is part of the sorting algorithm
        // where after sending largest element packing to the end
        // we then merge the two heaps together
        // through percolating the "new" root to the end

        int nodeIdx = 0;
        int currentNode = nodeIdx;
        boolean flag = false;
        while (nodeIdx < n && !flag) {
            // check if the left and right child nodes are greater than it
            int leftChildNode = 2*nodeIdx + 1;
            int rightChildNode = 2*nodeIdx + 2;

            // get the largest element
            if (leftChildNode < n && nums[leftChildNode] > nums[nodeIdx])
                nodeIdx = leftChildNode;
            
            if (rightChildNode < n && nums[rightChildNode] > nums[nodeIdx])
                nodeIdx = rightChildNode;
            
            if (nodeIdx != currentNode) {
                int temp = nums[nodeIdx];
                nums[nodeIdx] = nums[currentNode];
                nums[currentNode] = temp;
            } else {
                flag = true;                
            }
            currentNode = nodeIdx;
        }
    }

    public void sort(int[] nums) {
        // first heapify
        // then swap largest element to end
        // then merge the heaps
        heapify(nums);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int max = nums[0];
            nums[0] = nums[i];
            nums[i] = max;

            mergeHeaps(nums, i);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        heapify(nums);
        System.out.println(Arrays.toString(nums) + "\n\n");
        int len = nums.length;
        for (int i = len - 1; i >= len - k + 1; i--) {
            int max = nums[0];
            nums[0] = nums[i];
            nums[i] = max;
            mergeHeaps(nums, i);
            System.out.println(Arrays.toString(nums));
        }

        return nums[0];
    }
}