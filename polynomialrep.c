#include <stdio.h>
void main()
{
  int limit,i;
      struct poly {
       int coef,expo;};
    printf("Enter the number of terms in polynomial:\n");
    scanf("%d",&limit);
    struct poly a[limit];
    for(i=0;i<limit;i++)
    {
        printf("Enter the coefficient of %d term\n",i+1);
        scanf("%d",&a[i].coef);
        printf("Enter the exponent of %d term\n",i+1);
        scanf("%d",&a[i].expo);
    }
      printf("The polynomial is :\n");
      for(i=0;i<limit;i++)
      {
          printf("%dx^%d",a[i].coef,a[i].expo);
          if(i<limit-1)
          {
              printf("+");
          }
      }
   printf("\n");
}
