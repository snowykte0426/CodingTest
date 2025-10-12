#include <stdio.h>

int main(void) {
    int i, a, b[30] = {0};
    
    for (i = 1; i <= 28; i++) {
        scanf("%d", &a);
        b[a] = a;
    }
    
    for (a = 1; a <= 30; a++) {
        if (b[a] != a)
            printf("%d\n", a);
    }
    
    return 0;
}
