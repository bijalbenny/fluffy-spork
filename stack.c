#include<stdio.h>
int a[50],top=-1,max;
void push();
void pop();
void peek();
void display();
void main()
{
int choice;
printf("enter the maximum of stack\n");
scanf("%d",&max);
do
{
printf("enter the choice\t1)push\t2)pop\t3)peek\t4)display \t5)exit\n");
scanf("%d",&choice);
switch(choice)
{
case 1:
{
push();
break;
}
case 2:
{
pop();
break;
}
case 3:
{
peek();
break;
}
case 4:
{
display();
break;
}
case 5:
{
break;
}
default :
{
printf("invalid choice\n");
}
}
}
while(choice!=5);
}
void push()
{
int val;
if(top>=max-1)
{
printf("overflow\n");
}
else
{
printf("enter the value to be added into stack\n");
scanf("%d",&val);
top++;
a[top]=val;
}
}
void pop()
{
int item;
if(top==-1)
{
printf("underflow\n");
}
else
{
item=a[top];
printf("the value %d is poped out\n",item);
top--;
}
}
void peek()
{
if(top==-1)
printf("the stack is empty\n");
else
{
printf("the upper most value of stack=%d",a[top]);
printf("\n");
}
}
void display()
{
int i;
if(top==-1)
printf("the stack is empty\n");
else
{
printf("the stack:");
for(i=top;i>=0;i--)
{
printf("%d\t",a[i]);
}
printf("\n");
}
}
