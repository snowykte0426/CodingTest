#include <stdio.h>

int main() {
    int subject;
    int max = 0;
    float result = 0;
    scanf("%d", &subject);
    int score[1000];
    for (int i = 0; i < subject; i++) {
        scanf("%d", &score[i]);
        if (max < score[i]) {
            max = score[i];
        }
    }
    for (int i = 0; i < subject; i++) 
        result += (float)score[i] / max * 100;
    printf("%f\n", result / subject);
    return 0;
}
