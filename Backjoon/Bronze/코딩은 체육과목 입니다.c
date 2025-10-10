#include <stdio.h>

int main(void) {
	int byte = 0, i = 0;
	scanf("%d", &byte);
	while (i < byte) {
		printf("long ");
		i += 4;
	}
	printf("int");
	return 0;
}
