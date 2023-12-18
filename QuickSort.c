#include <stdio.h>
#include <stdlib.h>

void swap(int a[], int i, int j);
int partition(int a[], int left, int right);
void quickSort(int a[], int left, int right);

int main() {
    int i, limit;
    printf("Enter the limit\n");
    scanf("%d", &limit);
    int a[limit];
    printf("Enter elements of array\n");
    for (i = 0; i < limit; i++) {
        scanf("%d", &a[i]);
    }
    quickSort(a, 0, limit - 1);
    printf("Elements of array after quick sort\n");
    for (i = 0; i < limit; i++) {
        printf("%d ", a[i]);
    }

    return 0;
}

void swap(int a[], int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}

int partition(int a[], int left, int right) {
    int pivot = a[right];
    int i = left - 1;
    for (int j = left; j <= right - 1; j++) {
        if (a[j] <= pivot) {
            i++;
            swap(a, i, j);
        }
    }
    swap(a, i + 1, right);
    return i + 1;
}

void quickSort(int a[], int left, int right) {
    if (left < right) {
        int pi = partition(a, left, right);
        quickSort(a, left, pi - 1);
        quickSort(a, pi + 1, right);
    }
}
