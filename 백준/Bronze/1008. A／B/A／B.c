#include <stdio.h>
int main(void) {
	int a = 0, b = 0;
	scanf("%d", &a);
	scanf("%d", &b);
	printf("%.15g", (double)a / (double)b);
	return 0;
}