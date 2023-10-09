#include<stdio.h>
void main()
{
int i,j,row,col,k=1,count=0;
printf("enter the row amd coloumn\n");
scanf("%d%d",&row,&col);
printf("enter the matrix\n");
int a[row][col];
for(i=0;i<row;i++)
{
for(j=0;j<col;j++)
{
scanf("%d",&a[i][j]);
}
}
struct sparse
{
int col1,row1,val;
}s[20];
for(i=0;i<row;i++)
{
for(j=0;j<col;j++)
{
if(a[i][j]!=0)
{
s[k].row1=i;
s[k].col1=j;
s[k].val=a[i][j];
k++;
count++;
}
}
}
s[0].row1=row;
s[0].col1=col;
s[0].val=count;
printf("the triplet matrix:\n");
printf("row\tcolumn\tvalue\n");
for(i=0;i<k;i++)
{
printf("%d\t%d\t%d\t",s[i].row1,s[i].col1,s[i].val);
printf("\n");
}
}
