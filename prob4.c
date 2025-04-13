#include <stdio.h>
#include <stdlib.h>

double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    // given the overll run time complexity should be O(log n + log m), it should employ some sort of
    // halving operation, likely binary search

    int med2_idx = nums2Size / 2;
    int med2 = nums1[med2_idx];

    // search until the index of med1 is found
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