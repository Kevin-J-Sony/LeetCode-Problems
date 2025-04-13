#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int val;
    struct ListNode *next;
};
 
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode* head = (struct ListNode*) malloc(sizeof(struct ListNode));
    struct ListNode* current_node = head;
    struct ListNode* auxillary_node = NULL;
    int carry = 0;
    while (l1 != NULL && l2 != NULL) {
        current_node->val = l1->val + l2->val + carry;
        if (current_node->val > 9) {
            current_node->val -= 10;
            carry = 1;
        } else {
            carry = 0;
        }
        current_node->next = (struct ListNode*) malloc(sizeof(struct ListNode));
        auxillary_node = current_node;
        current_node = current_node->next;
        current_node->next = NULL;
        current_node->val = 0;

        l1 = l1->next;
        l2 = l2->next;
    }

    if (l1 != NULL) {
        while (l1 != NULL) {
            current_node->val = l1->val + carry;
            if (current_node->val > 9) {
                current_node->val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            current_node->next = (struct ListNode*) malloc(sizeof(struct ListNode));
            auxillary_node = current_node;
            current_node = current_node->next;
            current_node->next = NULL;
            current_node->val = 0;
            
            l1 = l1->next;
        }
    } else if (l2 != NULL) {
        while (l2 != NULL) {
            current_node->val = l2->val + carry;
            if (current_node->val > 9) {
                current_node->val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            current_node->next = (struct ListNode*) malloc(sizeof(struct ListNode));
            auxillary_node = current_node;
            current_node = current_node->next;
            current_node->next = NULL;
            current_node->val = 0;
            
            l2 = l2->next;
        }
    }

    if (carry != 0) {
        current_node->val = carry;

        current_node->next = (struct ListNode*) malloc(sizeof(struct ListNode));
        auxillary_node = current_node;
        current_node = current_node->next;
        current_node->next = NULL;
        current_node->val = 0;
    }

    free(current_node);
    auxillary_node->next = NULL;

    return head;
}

struct ListNode* init(int number) {
    if (number > 0) {    
        struct ListNode* head = (struct ListNode*) malloc(sizeof(struct ListNode));
        struct ListNode* current_node = head;
        struct ListNode* auxillary_node = NULL;
        while(number != 0){
            current_node->val = number % 10;
            number /= 10;
            current_node->next = (struct ListNode*) malloc(sizeof(struct ListNode));
            auxillary_node = current_node;
            current_node = current_node->next;

            current_node->next = NULL;
            current_node->val = 0;
        }
        free(current_node);
        auxillary_node->next = NULL;
        /*
        current_node->next = NULL;
        current_node->val = 0;
        */
        return head;        
    }
}

void delete(struct ListNode* node) {
    struct ListNode* temp;
    while (node != NULL) {
        temp = node;
        node = node->next;
        free(temp);
    }
}

void print(struct ListNode* node) {
    while(node != NULL) {
        printf("%d ", node->val);
        node = node->next;
    }
    printf("\n");
}

int main() {
    struct ListNode* numb1 = init(9999999);
    struct ListNode* numb2 = init(9999);
    print(numb1);
    print(numb2);
    struct ListNode* sum = addTwoNumbers(numb1, numb2);
    print(sum);
    delete(numb1);
    delete(numb2);
}