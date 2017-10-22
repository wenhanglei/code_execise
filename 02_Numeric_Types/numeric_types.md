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

