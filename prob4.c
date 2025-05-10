#include <stdio.h>
#include <stdlib.h>


double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    // given the overll run time complexity should be O(log n + log m), it should employ some sort of
    // halving operation, likely binary search as the arrays are sorted

    int idx1;
    int idx2;
    int nums1_bot = 0;
    int nums1_top = nums1Size - 1;

    int nums2_bot = 0;
    int nums2_top = nums2Size - 1;
    
    int flag = (0 == 1);

    do {
        idx1 = (nums1_bot + nums1_top + 1) / 2;
        idx2 = (nums1Size + nums2Size) / 2 - idx1;


        if (idx1 == 0) {

        } else {}

    } while(flag == (0 == 1));
}


int main() {
    // read the corresponding input from a file
    FILE* file = fopen("prob1.in", "r");
    int m = 2;
    int n = 1;

    printf("Input in the size of the first array: ");
    fscanf(stdin, "%d", &m);
    int* nums1 = (int*) malloc(sizeof(int) * m);

    printf("Input the elements\n-------------\n");
    for (int i = 0; i < m; i++) {
        fscanf(stdin, "%d", &nums1[i]);
    }

    printf("Input in the size of the second array: ");
    fscanf(stdin, "%d", &n);
    int* nums2 = (int*) malloc(sizeof(int) * n);

    printf("Input the elements\n-------------\n");
    for (int i = 0; i < n; i++) {
        fscanf(stdin, "%d", &nums2[i]);
    }

    printf("\nFirst array: ");
    for (int i = 0; i < m; i++) {
        printf("%d ", nums1[i]);
    }
    printf("\n");
    
    printf("Second array: ");
    for (int i = 0; i < n; i++) {
        printf("%d", nums2[i]);
    }
    printf("\n");
    

    findMedianSortedArrays(nums1, m, nums2, n);

    free(nums1);
    free(nums2);
    
}