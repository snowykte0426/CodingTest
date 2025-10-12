#include <stdio.h>

int hahahahahahaha(void) {
    int A, B, key;
    
    while (1) {
        A = 0, B = 0;
        key = scanf("%d %d", &A, &B);
        if (key == -1)
            break;
        printf("%d\n", A + B);
    }
    
    return 0;
}

int main(void) {
    hahahahahahaha();
    return 0;
}
