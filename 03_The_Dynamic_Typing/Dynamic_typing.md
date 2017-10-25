## Variables, Objects, and References

## Types Live with Objects, Not Variables

A variable in Python references a particular object at a particular 
point in time.

objects have two header fields, a type designator and a reference
counter.

## Shared References

## Shared References and In-Place Changes

## Shared References and Equality

	>>> x = 42
	>>> x = 'shrubbery'

Because Python caches and reuses small integers and small strings, 
the oject **42** here is probably not literally reclaimed.

because of Python's reference model, there are two different ways to 
check for equality in a Python program.

	>>> L = [1, 2, 3]
	>>> M = L
	>>> L == M
	True
	>>> L is M
	True

the **==** operator, tests whether the two referenced objects have 
the same values; the **is** it returns **True** only if both names 
point to the exact same object.

**is** serves as a way to detect shared references in your code.

## Dynamic Typing Is Everywhere

