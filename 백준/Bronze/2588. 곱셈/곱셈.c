#include <stdio.h>
int main(void) {
	int A = 0, B = 0;
	scanf("%d", &A);
	scanf("%d", &B);

	for (int i = B; i > 0; i= i / 10) {
		printf("%d \n", A * (i % 10));
	}
	printf("%d \n", A * B);
	return 0;
}