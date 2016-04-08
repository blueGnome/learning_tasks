#include <math.h>
#include <iostream>

double sqroot_Newton(double x) {
	double eps = 0.00000000001;
	double cur = x;
	double next = x;

	while (true) {
		next = 0.5 * (cur + x) / cur;

		if (abs(cur - next) < eps)
			break;

		cur = next;
	}

	return next;
}

int main()
{
	double n;
	double sqroot = 0;
	std::cout << "Enter number" << std::endl;
	std::cin >> n;

	sqroot = sqroot_Newton(n);

	std::cout << std::endl << sqroot;
	std::cin;
}