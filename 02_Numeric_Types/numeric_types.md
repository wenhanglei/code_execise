## Numeric Type Basics

In Python, numbers are not really a single object type, but a 
category of similar types.

A complete inventory of Python's numeric toolbox includes:

- Integers and floating-point numbers
- Complex numbers
- Fixed-precision decimal numbers
- Rational fraction numbers
- Sets
- Booleans
- Unlimited integer precision
- A variety of numeric build-ins and modules

## Numeric Literals

*Basic numeric literals*

| Literal | Interpretation |
| :--- | :--- |
| 1234, -24, 0, 9999999999999999 | Integers(unlimited size) |
| 1.23, 1., 3.14e-10, 4E210, 4.0e+210 | Floating-point numbers |
| 0o177, 0x9ff, 0b101010 | Octal, hex, and binary literals in 3.0 |
| 3 + 4j, 3.0 + 4.0j, 3j | Complex number literals |

## Built-in Numeric Tools

Expression operators

	+, -, *, /, >>, **, &, etc.

Built-in mathmatical functions

	pow, abs, round, int, hex, bin, etx.

Utility modues

	random, math, etc.

## Python Expression Operators

- Mixed operators follow operator precedence
- Parentheses group subexpression
- Mixed types are converted up

## Variables and Basic Expressions

## Numeric Display Formats

## str and repr Display Formats

**repr**(and the default interactive echo) produces results that look
as though they were code; **str**(and the **print** operation) 
converts to a typically more user-friendly format if available.

## Comparisons: Normal and Chained

	>>> X = 2
	>>> Y = 4
	>>> Z = 6
	>>> 
	>>> X < Y < Z
	True
	>>> X < Y and Y < Z
	True

## Division: Classic, Floor, and True

X / Y: In Python 3.0, it performs *true* division, always keeping 
remainders regardless of types.

X // Y: Floor division, always truncate fractional remainders down
to their floor.

## Integer Precision 

## Complex Numbers

## Hexadecimal, Octal, and Binary Notation

	>>> 0o1, 0o20, 0o377
	(1, 16, 255)
	>>> 0x01, 0x10, 0xFF
	(1, 16, 255)
	>>> 0b1, 0b10000, 0b11111111
	(1, 16, 255)

buil-in functions that allow you to convert integers to other bases'
digit strings:

	>>> oct(56), hex(56), bin(56)
	('0o70', '0x38', '0b111000')

the built-in **int** function converts a string of digits to an 
integer, and an optional second argument lets you specify the 
numeric base:

	>>> int('65'), int('100', 8), int('40', 16), int('1000000', 2)
	(65, 64, 64, 64)

The **eval** function treats strings as though they were Python 
code, but usually runs more slowly--it actually compiles and runs 
the string as a piece of a program.

	>>> eval('64'), eval('0o100'), eval('0x40'), eval('0b1000000')
	(64, 64, 64, 64)

you can also convert integers to octal and hexadecimal strings with
*string formatting* method calls and expressions:

	>>> '{0:o}, {1:x}, {2:b}'.format(64, 64, 64)
	'100, 40, 1000000'
	>>> '%o, %x, %X' % (64, 255, 255)
	'100, ff, FF'

## Bitwise Operations


