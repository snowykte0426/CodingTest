#include <stdio.h>

int main(void) {
    int total = 0, get = 0, price = 0, set_get = 0, sum = 0;
    
    scanf("%d", &total);
    scanf("%d", &get);
    
    for (int i = 0; i < get; i++) {
        scanf("%d %d", &price, &set_get);
        sum += price * set_get;
    }
    
    if (sum == total)
        printf("Yes");
    else
        printf("No");
    
    return 0;
}
