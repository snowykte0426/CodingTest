#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n1, n2;
    
    while (1) {
        scanf("%d %d", &n1, &n2);
        if (n1 == 0 && n2 == 0)
            exit(0);
        else
            printf("%d\n", n1 + n2);
    }
    
    return 0;
}
