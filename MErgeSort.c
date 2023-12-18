#include <stdio.h>

void merge(int a[], int start, int middle, int end);

void mergeSort(int a[], int start, int end) {
    if (start != end) {
        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle + 1, end);
        merge(a, start, middle, end);
    }
}

void merge(int a[], int start, int middle, int end) {
    int i, j, k, temp[50];
    i = start;
    j = middle + 1;
    k = start;
    while (i <= middle && j <= end) {
        if (a[i] <= a[j]) {
            temp[k] = a[i];
            i++;
            k++;
        } else {
            temp[k] = a[j];
            j++;
            k++;
        }
    }
    while (i <= middle) {
        temp[k] = a[i];
        i++;
        k++;
    }
    while (j <= end) {
        temp[k] = a[j];
        j++;
        k++;
    }
    for (i = start; i <= end; i++) {
        a[i] = temp[i];
    }
}

void main() {
    printf("Enter the limit\n");
    int limit;
    scanf("%d", &limit);
    int a[limit];
    printf("Enter elements of the array\n");
    int i;
    for (i = 0; i < limit; i++) {
        scanf("%d", &a[i]);
    }
    printf("Given array is\n");
    for (i = 0; i < limit; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    mergeSort(a, 0, limit - 1);
    printf("Array after merge sort\n");
    for (i = 0; i < limit; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

}
