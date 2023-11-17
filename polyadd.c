#include <stdio.h>
#include <stdlib.h>
#include <math.h>
struct poly {
    int coeff, exp;
    struct poly* next;
  };

struct poly* createPoly(int terms) {
    struct poly *head = NULL, *temp = NULL, *current = NULL;

    for (int i = 0; i < terms; i++) {
        temp = (struct poly*)malloc(sizeof(struct poly));

        printf("\nEnter the coefficient and exponent: ");
        scanf("%d%d", &temp->coeff, &temp->exp);

        temp->next = NULL;

        if (head == NULL) {
            head = temp;
            current = temp;
        } else {
            current->next = temp;
            current = temp;
        }
    }

    return head;
}

void display(struct poly* poly) {
    while (poly != NULL) {
        printf("%dx^%d ", poly->coeff, poly->exp);
        if (poly->next != NULL) {
            printf("+ ");
        }
        poly = poly->next;
    }
    printf("\n");
}

struct poly* addPolynomials(struct poly* poly1, struct poly* poly2) {
    struct poly* result = NULL;
    struct poly* temp = NULL;

    while (poly1 != NULL || poly2 != NULL) {
        struct poly* newNode = (struct poly*)malloc(sizeof(struct poly));
        newNode->next = NULL;

        if (result == NULL) {
            result = newNode;
            temp = newNode;
        } else {
            temp->next = newNode;
            temp = newNode;
        }

        if (poly1 == NULL) {
            newNode->coeff = poly2->coeff;
            newNode->exp = poly2->exp;
            poly2 = poly2->next;
        } else if (poly2 == NULL) {
            newNode->coeff = poly1->coeff;
            newNode->exp = poly1->exp;
            poly1 = poly1->next;
        } else {
            if (poly1->exp > poly2->exp) {
                newNode->coeff = poly1->coeff;
                newNode->exp = poly1->exp;
                poly1 = poly1->next;
            } else if (poly1->exp < poly2->exp) {
                newNode->coeff = poly2->coeff;
                newNode->exp = poly2->exp;
                poly2 = poly2->next;
            } else {
                newNode->coeff = poly1->coeff + poly2->coeff;
                newNode->exp = poly1->exp;
                poly1 = poly1->next;
                poly2 = poly2->next;
            }
        }
    }

    return result;
}

int main() {
    int n1, n2;
    printf("Enter the number of terms of the 1st polynomial: ");
    scanf("%d", &n1);

    struct poly* p = createPoly(n1);
    printf("Enter the number of terms of the 2nd polynomial: ");
    scanf("%d", &n2);

    struct poly* q = createPoly(n2);

    printf("\n1st polynomial: ");
    display(p);

    printf("\n2nd polynomial: ");
    display(q);

    struct poly* result = addPolynomials(p, q);

    printf("\nResultant polynomial after addition: ");
    display(result);

    return 0;
}
