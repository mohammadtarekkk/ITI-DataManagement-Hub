class ImaginaryNumber:
    def __init__(self, real, imag):
        self.real = real
        self.imag = imag

    def __str__(self):
        sign = '+' if self.imag >= 0 else '-'
        return f"{self.real} {sign} {abs(self.imag)}i"

    def __add__(self, other):
        return ImaginaryNumber(self.real + other.real, self.imag + other.imag)

    def __sub__(self, other):
        return ImaginaryNumber(self.real - other.real, self.imag - other.imag)

    def __mul__(self, other):
        real_part = self.real * other.real - self.imag * other.imag
        imag_part = self.real * other.imag + self.imag * other.real
        return ImaginaryNumber(real_part, imag_part)

    def __eq__(self, other):
        return self.real == other.real and self.imag == other.imag
    
n1 = ImaginaryNumber(3, 4)
n2 = ImaginaryNumber(3, -4)
print(n1) 
print(n2)

n3 = n1 + n2
print(n3)

n4 = n1 - n2
print(n4)

n5 = n1 * n2
print(n5)

print(n1 == n2)
print(n1 == ImaginaryNumber(3, 4))