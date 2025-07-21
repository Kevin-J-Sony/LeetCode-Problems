# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        if len(lists) == 0:
            return None
        elif len(lists) == 1:
            return lists[0]
        
        # This looks to be the bottle neck
        # Eliminate calls to this
        def add_to_list(ml, v):
            curr_node = ml
            while curr_node.next is not None:
                curr_node = curr_node.next
            curr_node.next = ListNode()
            curr_node.next.val = v
                
        ''' RESULT USING RECURSION
        if len(lists) > 0:
            midpoint = len(lists) // 2
            bottom_half = lists[:midpoint]
            top_half = lists[midpoint:]

            bottom_merged = self.mergeKLists(bottom_half)
            top_merged = self.mergeKLists(top_half)
            
            # create an array of current nodes
            bot_curr_node = bottom_merged
            top_curr_node = top_merged
                
            merged_list = ListNode()
            merged_list.val = 2**31
            
            flag = False
            while bot_curr_node is not None and top_curr_node is not None:
                if bot_curr_node.val < top_curr_node.val:
                    add_to_list(merged_list, bot_curr_node.val)
                    bot_curr_node = bot_curr_node.next
                else:
                    add_to_list(merged_list, top_curr_node.val)
                    top_curr_node = top_curr_node.next
                
            
            while bot_curr_node is not None:
                add_to_list(merged_list, bot_curr_node.val)
                bot_curr_node = bot_curr_node.next
            
            while top_curr_node is not None:
                add_to_list(merged_list, top_curr_node.val)
                top_curr_node = top_curr_node.next
                        
            return merged_list.next
            
        # create an array of current nodes
        arr_of_curr_nodes = []
        end_of_lists = []
        k = len(lists)
        for i in range(k):
            arr_of_curr_nodes.append(lists[i])
            end_of_lists.append(lists[i] is None)
            
        merged_list = ListNode()
        merged_list.val = 2**31
        
        flag = False
        while not flag:
            # let idx be smallest
            idx = 0
            for i in range(k):
                if not end_of_lists[i]:
                    idx = i
                    break
            
            for i in range(k):
                if not end_of_lists[i]:
                    if arr_of_curr_nodes[i].val < arr_of_curr_nodes[idx].val:
                        idx = i
            
            # add current value at idx of arr_of_curr_nodes to merged_list
            if not end_of_lists[idx]:
                add_to_list(merged_list, arr_of_curr_nodes[idx].val)
            
            # updated arr_of_curr_nodes
            if not end_of_lists[idx]:
                arr_of_curr_nodes[idx] = arr_of_curr_nodes[idx].next
            
            if arr_of_curr_nodes[idx] is None:
                end_of_lists[idx] = True
                
                # if all lists reached the end, stop the code
                # if one hasn't reached the end, continue
                tflag = False
                for i in range(k):
                    if not end_of_lists[i]:
                        tflag = True
                        
                flag = False if tflag else True
        
        return merged_list.next
        '''
        
        def mergeTwoLists(first_list, second_list):
            # create an array of current nodes
            first_curr_node = first_list
            second_curr_node = second_list
                
            merged_list = ListNode()
            merged_list.val = 2**31
            curr_merged_list_node = merged_list
            
            flag = False
            while first_curr_node is not None and second_curr_node is not None:
                if first_curr_node.val < second_curr_node.val:
                    curr_merged_list_node.next = ListNode()
                    curr_merged_list_node.next.val = first_curr_node.val
                    curr_merged_list_node = curr_merged_list_node.next
                    # add_to_list(merged_list, first_curr_node.val)
                    first_curr_node = first_curr_node.next
                else:
                    curr_merged_list_node.next = ListNode()
                    curr_merged_list_node.next.val = second_curr_node.val
                    curr_merged_list_node = curr_merged_list_node.next
                    # add_to_list(merged_list, second_curr_node.val)
                    second_curr_node = second_curr_node.next

            while first_curr_node is not None:
                curr_merged_list_node.next = ListNode()
                curr_merged_list_node.next.val = first_curr_node.val
                curr_merged_list_node = curr_merged_list_node.next
                # add_to_list(merged_list, first_curr_node.val)
                first_curr_node = first_curr_node.next
            
            while second_curr_node is not None:
                curr_merged_list_node.next = ListNode()
                curr_merged_list_node.next.val = second_curr_node.val
                curr_merged_list_node = curr_merged_list_node.next
                # add_to_list(merged_list, second_curr_node.val)
                second_curr_node = second_curr_node.next
                        
            return merged_list.next

        
        while len(lists) > 1:
            merged_list = []
            for i in range(0, len(lists), 2):
                f_list = lists[i]
                s_list = lists[i + 1] if i + 1 < len(lists) else None
                merged_list.append(mergeTwoLists(f_list, s_list))
            lists = merged_list
        
        return merged_list[0]
        

def load_list(head, arr):
    curr_node = head
    for i in range(len(arr)):
        curr_node.val = arr[i]
        if i != len(arr) - 1:
            curr_node.next = ListNode()
            curr_node = curr_node.next
    

#'''
arr_of_list = [ListNode(), ListNode(), ListNode()]
load_list(arr_of_list[0], [1,4,5])
load_list(arr_of_list[1], [1,3,4])
load_list(arr_of_list[2], [2,6])
'''
arr_of_list = [ListNode(), ListNode()]
load_list(arr_of_list[0], [1])
load_list(arr_of_list[1], [0])
'''

sol = Solution()
mmm = sol.mergeKLists(arr_of_list)
breakpoint()
