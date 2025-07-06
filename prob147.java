public class prob147 {
    public static void main(String[] args) {

        ListNode fou = new ListNode(3);
        ListNode thi = new ListNode(1, fou);
        ListNode sec = new ListNode(2, thi);
        ListNode head = new ListNode(4, sec);

        Solution147 sol = new Solution147();
        sol.insertionSortList(head);
        
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution147 {
    public void swap(ListNode end, ListNode head) {
        int valueToInsert = end.val;
        ListNode currNode = head;
        while (currNode != end) {
            if (valueToInsert < currNode.val) {
                int temp = currNode.val;
                currNode.val = valueToInsert;
                valueToInsert = temp;
            }
            currNode = currNode.next;
        }
        currNode.val = valueToInsert;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode endSortedList = head;
        ListNode begUnsortedList = endSortedList.next;
        ListNode innerCurrNode;
        int valueToInsert, temp;
        while (begUnsortedList != null) {
            if (begUnsortedList.val < endSortedList.val) {
                valueToInsert = begUnsortedList.val;
                innerCurrNode = head;
                while (innerCurrNode != begUnsortedList) {
                    if (valueToInsert < innerCurrNode.val) {
                        temp = innerCurrNode.val;
                        innerCurrNode.val = valueToInsert;
                        valueToInsert = temp;
                    }
                    innerCurrNode = innerCurrNode.next;
                }
                innerCurrNode.val = valueToInsert;
            }
            endSortedList = begUnsortedList;
            begUnsortedList = begUnsortedList.next;
        }

        return head;
    }
}