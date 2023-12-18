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
