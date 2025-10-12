#include <stdio.h>

int main(void) {
    int N, M, i, j, temp = 0;
    int arr[101] = {0};
    
    scanf("%d %d", &N, &M);
    
    for (int k = 0; k <= N; k++) {
        arr[k] = k;
    }
    
    for (int a = 0; a < M; a++) {
        scanf("%d %d", &i, &j);
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    for (int b = 1; b <= N; b++) {
        printf("%d ", arr[b]);
    }
    
    return 0;
}
