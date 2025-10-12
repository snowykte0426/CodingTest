#include <stdio.h>

int main(void) {
    char arr[5][15] = {0};
    
    for (int i = 0; i < 5; i++) {
        scanf("%s", arr[i]);
    }
    
    int a = 0;
    for (; a < 15; a++) {
        for (int i = 0; i < 5; i++) {
            if (arr[i][a] != '\0')
                printf("%c", arr[i][a]);
        }
    }
    
    return 0;
}
