#include <stdio.h>

int main(void) {
    int reo;
    scanf("%d", &reo);
    
    for (int i = 1; i <= reo; i++) {
        for (int j = 0; j < reo - i; j++) {
            printf(" ");
        }
        for (int k = 0; k < i; k++) {
            printf("*");
        }
        printf("\n");
    }

    return 0;
}
