#include <stdio.h>
#include <ctype.h>
#include <string.h>

int top = -1;
char stack[20];

void push(char);
int pop();
int priority(char);

int main() {
    push('(');
    char infix[20];
    printf("Enter the infix expression :\n");
    scanf("%s", infix);
    printf("\nIt's postfix expression is :\n");
    for (int i = 0; infix[i] != '\0'; i++) {
        if (isalnum(infix[i]))
            printf("%c ", infix[i]);
        else if (infix[i] == '(')
            push(infix[i]);
        else if (infix[i] == ')')
            while (pop() != '(');
        else {
            while (priority(stack[top]) >= priority(infix[i])) {
                pop();
            }
            push(infix[i]);
        }
    }
    while (top >= 0) {
        pop();
    }
}

void push(char pushElement) {
    top++;
    stack[top] = pushElement;
}

int pop() {
    char x;
    x = stack[top];
    if (x != '(')
        printf("%c ", x);
    top--;
    return x;
}

int priority(char element) {
    if (element == '^')
        return 3;
    else if (element == '*' || element == '/')
        return 2;
    else if (element == '+' || element == '-')
        return 1;
    else
        return 0;
}








/*
    
This C program converts an 
infix expression to its corresponding 
postfix expression using a stack-based 
    approach. Here's an explanation of 
    the code:

Stack Implementation:

int top = -1; char stack[20];
declares a stack with a maximum
capacity of 20 elements and 
initializes the top of the stack to -1.
The stack is used to temporarily store
operators while processing the 
infix expression.
Function Declarations:

void push(char); and int pop();
are functions to push and pop elements 
onto/from the stack.
int priority(char); 
is a function to determine the 
priority of operators.
Main Function:

push('('); initializes the stack with 
an opening parenthesis to handle edge 
cases during the conversion.
char infix[20]; scanf("%s", infix); 
reads the infix expression from the user.
Conversion Loop:

The program then iterates through each
character in the infix expression
using a for loop.
If the character is an alphanumeric
operand, it is directly printed.
If the character is an opening 
parenthesis '(', it is pushed onto the stack.
If the character is a closing parenthesis ')',
 elements are popped from the stack until an
opening parenthesis is encountered.
For operators, it compares the priority of 
the current operator with the one
on the top of the stack and pops
elements accordingly.
The current operator is then pushed
onto the stack.
Finalization:

After processing the entire infix 
expression, the program pops any 
remaining elements from the stack
and prints them.
Push and Pop Functions:

void push(char pushElement) increments 
the top index and adds the specified 
element to the stack.
int pop() retrieves the top element
from the stack, prints it 
(except for opening parenthesis), and
decrements the top index.
Priority Function:

int priority(char element) returns 
the priority of an operator based on a
predefined hierarchy (exponentiation has
the highest priority, followed by
multiplication and division, and then 
addition and subtraction).
