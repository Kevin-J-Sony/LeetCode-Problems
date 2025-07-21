#include <stdlib.h>
#include <stdio.h>

int removeDuplicates(int* nums, int numsSize) {
    int idx1 = 0;
    int idx2 = 0;
    while (idx2 < numsSize) {
        if (nums[idx2] != nums[idx2 + 1] || idx2 + 1 == numsSize) {
            nums[idx1] = nums[idx2];
            idx1++;
            idx2++;
        } else {
            nums[idx1] = nums[idx2];
            nums[idx1 + 1] = nums[idx2 + 1];
            idx2 += 2;
            idx1 += 2;
            while (idx2 < numsSize && nums[idx2] == nums[idx2 - 2]) {
                idx2++;
            }
        }
    }

    return idx1;
}

int main() {
    int n = 6;
    int* array = (int *)malloc(sizeof(int) * n);
    int ray[] = {1,1,1,2,2,3};
    for (int i = 0; i < n; i++) {
        array[i] = ray[i];
    }

    int k = removeDuplicates(array, 6);

    for (int i = 0; i < n; i++) {
        printf("array[%d] = %d\n", i, array[i]);
    }
    printf("k: %d\n", k);

    return 0;
}