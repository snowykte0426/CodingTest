#include <stdio.h>

int main(void) {
    long long t = 0, num1 = 0, num2 = 0;
    scanf("%lld", &t);
    
    for (int i = 0; i < t; i++) {
        scanf("%lld %lld", &num1, &num2);
        printf("%lld\n", num1 + num2);
    }
    
    return 0;
}
