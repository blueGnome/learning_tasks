#include <math.h>
#include <iostream>

double sqroot_Newton(double x) {
	double eps = 0.00000000001;
	double cur = 1;
	double next = x;

	while (true) {
		next = (cur * cur + x) / (2 * cur);

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

	std::cout << std::endl << sqroot_Newton(n) << std::endl;
}