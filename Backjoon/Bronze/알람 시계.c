#include <stdio.h>

int main(void) {
    int h, m, temp;
    scanf("%d %d", &h, &m);
    
    temp = 45 - m;
    m -= 45;
    
    if (m < 0) {
        h--;
        m = 60 - temp;
        if (h < 0)
            h = 23;
    }
    
    printf("%d %d", h, m);
    return 0;
}
