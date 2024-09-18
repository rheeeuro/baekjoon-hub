#define _CRT_SECURE_NO_WARNINGS
#include <stdlib.h> 
#include <stdio.h>
#include <math.h>

int money1(int);
int money2(int);

int main() {
	int t = 0;
	scanf("%d", &t);
	if (t >= 1 && t <= 1000) {
		int* a = (int*)malloc(t * sizeof(int));
		int* b = (int*)malloc(t * sizeof(int));

		for (int i = 0; i < t; i++) {
			scanf("%d %d", &a[i], &b[i]);

			if (a[i] > 100) a[i] = 0;
			if (b[i] > 64) b[i] = 0;
		}

		for (int i = 0; i < t; i++) {
			printf("%d \n", 10000 * (money1(a[i]) + money2(b[i])));
		}

	}
	
	return 0;
}

int money1(int a) {
	if (a == 0) {
		return 0;
	}
	else if (a == 1) {
		return 500;
	}
	else if (a <= 3) {
		return 300;
	}
	else if (a <= 6) {
		return 200;
	}
	else if (a <= 10) {
		return 50;
	}
	else if (a <= 15) {
		return 30;
	}
	else if (a <= 21) {
		return 10;
	}
	else {
		return 0;
	}
}

int money2(int b) {
	if (b == 0) {
		return 0;
	}
	else if (b == 1) {
		return 512;
	}
	else if (b <= 3) {
		return 256;
	}
	else if (b <= 7) {
		return 128;
	}
	else if (b <= 15) {
		return 64;
	}
	else if (b <= 31) {
		return 32;
	}
	else {
		return 0;
	}
}