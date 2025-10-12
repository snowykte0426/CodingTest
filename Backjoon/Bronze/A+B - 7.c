#include <stdio.h>

int main(void) {
    int t = 0, num1, num2, count = 1;
    scanf("%d", &t);
    
    for (int i = 0; i < t; i++) {
        scanf("%d %d", &num1, &num2);
        printf("Case #%d: %d\n", count, num1 + num2);
        count++;
    }
    
    return 0;
}
