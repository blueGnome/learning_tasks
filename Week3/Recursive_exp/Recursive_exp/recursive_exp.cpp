#include <iostream>

double exponention(double a, int x) {
	if (x % 2 == 0)		 // even
		return (x == 1) ? a : exponention(a * a, x / 2);
	else				// odd
		return (x == 1) ? a : a * exponention(a * a, (x-1)/2);
}

int main()
{
	double a;
	int x;
	double result = 0;

	std::cout << "Enter base" << std::endl;
	std::cin >> a;

	std::cout << "Enter exponent" << std::endl;
	std::cin >> x;

	std::cout << exponention(a, x) << std::endl;
}