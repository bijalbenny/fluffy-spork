#include<stdio.h>
#include<string.h>
#include<ctype.h>
int top = -1;
char stack[20];
void push(char);
char pop(),x;
int priority(char);
int main(){
       push('(');
       char infix[20], *p;
       printf("Enter the infix expression : ");
       scanf("%s",infix);
       p = infix;
       printf("\nIt's postfix expression is :\n");
        while(*p != '\0') {
         if(isalnum(*p))
            printf("%c ", *p);
         else if(*p == '(')
            push(*p);
         else if(*p == ')'){
            while((x=pop() )!= '(')
            printf("%c ", x);}
             else {
               while(priority(stack[top]) >= priority(*p)) { 
                x=pop();
                printf("%c",x);
              }
            push(*p);
        }
      p++;
    }
    while(top >= -1){
        x=pop();
         printf("%c",x);
    }
}
void push(char pushElement) {
    top++;
    stack[top] = pushElement;
    
}
char pop() {
    char x;
    x = stack[top];
    top--;
    return x;
}
int priority(char element){
    if(element == '^')
        return 3;
    else if(element=='*' || element=='/')
        return 2;
    else if(element=='+' || element=='-')
        return 1;
    else
        return 0;
}
