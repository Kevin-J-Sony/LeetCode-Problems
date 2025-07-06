#include <stdio.h>
#include <stdlib.h>


double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
	int n = nums1Size;
	int m = nums2Size;
	double low_med = -1;
	double high_med = -1;
	
	int idx1 = 0;
	int idx2 = 0;    

	while (idx1 < n && idx2 < m) {
		if (idx1 + idx2 == -1 + (m + n) / 2) {
			low_med = (nums1[idx1] < nums2[idx2]) ? nums1[idx1] : nums2[idx2];
		}
		if (idx1 + idx2 == (m + n) / 2) {
			high_med = (nums1[idx1] < nums2[idx2]) ? nums1[idx1] : nums2[idx2];
		}
		
		if (nums1[idx1] < nums2[idx2]) {
			idx1++;
		} else {
			idx2++;
		}
	}

	while (idx1 < n) {
		if (idx1 + idx2 == -1 + (m + n) / 2) {
			low_med = nums1[idx1];
		}
		if (idx1 + idx2 == (m + n) / 2) {
			high_med = nums1[idx1];
		}
		idx1++;
	}

	while (idx2 < m) {
		if (idx1 + idx2 == -1 + (m + n) / 2) {
			low_med = nums2[idx2];
		}
		if (idx1 + idx2 == (m + n) / 2) {
			high_med = nums2[idx2];
		}
		idx2++;
	}

	if ((m + n) % 2 == 1) {
		return high_med;
	} else {
		return (low_med + high_med) / 2;
	}
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