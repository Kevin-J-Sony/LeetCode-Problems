# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: Optional[ListNode]
        :type k: int
        :rtype: Optional[ListNode]
        """
        if k == 1:
            return head
        
        # keep an array of heads of reversed nodes
        # for each "group"
        arr_heads = []
        
        n = 0
        curr_node = head
        prev_node = None
        while curr_node is not None:
            if n % k == 0:
                arr_heads.append(curr_node)
                if n != 0:
                    prev_node.next = None
            prev_node = curr_node
            curr_node = curr_node.next

            n += 1

        # create a function to reverse lists
        def reverse_list(ll):
            c_node = ll
            p_node = None
            
            while c_node is not None:
                n_node = c_node.next
                c_node.next = p_node
                
                p_node = c_node
                c_node = n_node
                ...
            return p_node
        
        if n % k != 0:
            # leave the end alone
            for i in range(len(arr_heads) - 1):
                arr_heads[i] = reverse_list(arr_heads[i])
        else:
            # include the end
            for i in range(len(arr_heads)):
                arr_heads[i] = reverse_list(arr_heads[i])
                
        # merge the ends
        for i in range(len(arr_heads) - 1):
            # get the end node of ith element and point it to beginning
            # of next element
            curr_node = arr_heads[i]
            while curr_node.next is not None:
                curr_node = curr_node.next
            curr_node.next = arr_heads[i + 1]
            
        return arr_heads[0]
        ...

def load_list(head, arr):
    curr_node = head
    for i in range(len(arr)):
        curr_node.val = arr[i]
        if i != len(arr) - 1:
            curr_node.next = ListNode()
            curr_node = curr_node.next


ll = ListNode()
load_list(ll, [1,2,3,4,5])
sol = Solution()
mmm = sol.reverseKGroup(ll, 3)

