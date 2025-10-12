#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
    int num, sum = 0, i = 0;
    scanf("%d", &num);
    
    while (1) {
        i++;
        sum += i;
        if (i == num)
            break;
    }
    
    printf("%d", sum);
    return 0;
}
