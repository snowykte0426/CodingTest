#include <stdio.h>

int main(void) {
    int arr[100][100] = {0};
    int x, y, result = 0;
    int t;
    
    scanf("%d", &t);
    
    for (int i = 0; i < t; i++) {
        scanf("%d %d", &x, &y);
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                arr[x + j][y + k] = 1;
            }
        }
    }
    
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            if (arr[i][j] == 1) {
                result++;
            }
        }
    }
    
    printf("%d", result);
    return 0;
}
