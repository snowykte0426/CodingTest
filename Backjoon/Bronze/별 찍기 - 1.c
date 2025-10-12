#include <stdio.h>

int star_omg(void) {
    int reo = 0;
    scanf("%d", &reo);
    
    for (int i = 0; i < reo; i++) {
        for (int j = 0; j <= i; j++) {
            printf("*");
        }
        printf("\n");
    }
    
    return 0;
}

int main(void) {
    star_omg();
    return 0;
}
