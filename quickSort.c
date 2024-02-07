#include <stdio.h>
#include <stdbool.h>
void swap(int arr[],int i,int j){
 int temp = arr[i];
 arr[i]=arr[j];
 arr[j]=temp;
}
int partition(int arr[],int left,int right){
    int pivot = arr[left];
    int i=left;
    for(int j= left +1;j<=right;j++){
        if (arr[j]<pivot){
            i++;
            swap(arr,i,j);
        }
    }
    swap(arr,left,i);
    return i;
}
void quickSort(int arr[],int left,int right){
 if(left<right){
    int pi = partition(arr,left,right);
    quickSort(arr,left,pi-1);
    quickSort(arr,pi+1,right);
 }
 }
void main(){
  int limit,i;
  printf("Enter limit\n");
  scanf("%d",&limit);
  int a[limit];
  printf("Enter number to be sorted\n");
  for(i=0;i<limit;i++){
    scanf("%d",&a[i]);
  }
  quickSort(a,0,limit-1);
  printf("Sorted array is \n");
  for(i=0;i<limit;i++)
    printf("%d ",a[i]);
}
