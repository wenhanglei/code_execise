Python programs can be decomposed into modules, statements, expressions, and objects.

1. Programs are composed of modules.
2. Modules contain statements.
3. Statements contains expressions.
4. Expressions create and process objects.

## Why Use Built-in Types?

+ Python provides powerful object types as an intrinsic part of the language, so there's usually no need to code object before you start solving problems.
+ **why you'd better use built-in object:**
	- they make program easy to write.
	- they are components of your extensions.
	- they are often more efficient than custom data structures.
	- they are a standard part of the language.

## Python's Core Data Types

| Object type | Example literal/creation |
| :--- | :--- |
| Numbers | 1234, 3.1415, 3+4j, Decimal, Fraction |
| Strings | 'spam', "apple's", b'a\x01c' |
| Lists | [1, [2, 'three'], 4] |
| Dictionaries | {'food': 'spam', 'taste': 'yum'} |
| Tuples | (1, 'spam', 4, 'U') |
| Files | myfile = open('filename.ext', 'r') |
| Other core types | Booleans, types, None |
| Program unit types | Functions, modules, classes |
| Implementation-related types | Compiled code, stack tracebacks |

Python is ***dynamically typed***

+ it keeps track of types for you automatically instead of requiring declaration code

but it is also ***strongly typed***

+ you can perform on an object only operation that are valid for its type

## Numbers

Numbers support normal mathematical operations: + , * , **
Python integer type automatically provides extra precision for large numbers.

	>>> 2 ** 98
	316912650057057350374175801344
	>>> len(str(2 ** 1000000))
	301030

when dealing with floating-point numbers. something odd:

## Strings

## Sequence Operations

- indexing
- slicing

## Immutability

- stings are *immutable* in Python
- numbers, strings, and tuples are immutable

## Type-Specific Methods

although sequence operations are generic, methods are not

## Getting Help

**dir**: returns a list of all the attributes available for a given object.

The **dir** simply gives the methods' names. To ask what they do, you can pass them to **help** function.

**help** : a tool for extracting documentation from objects.

## Other Ways to Code Strings

Python allow strings to be enclosed in single or double quote 
characters. It also allows multiline string literals enclosed in triple quotes.


## Pattern Matching

## Lists

	>>> M = [[1, 2, 3],
		     [4, 5, 6],
		     [7, 8, 9]]
	>>> M
	[[1, 2, 3], [4, 5, 6], [7, 8, 9]]

- **Bounds Checking**
- **Nesting**
- **Comprehensions**

	List comprehensions derive from set notation; they are a way to 
	build a new list by running an expression on each item in a sequence, one at a time, from left to right.

		>>> [row[1] + 1 for row in M]
		[3, 6, 9]
		>>> [row[1] for row in M if row[1] % 2 == 0]
		[2, 8]


