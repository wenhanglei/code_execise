Python strings are categgorized as immutable sequences, meaning that 
the characters they contain have a left-to-right positional order and
thet they cannot be changed in-place.

## String Literals

## Single and Double Quoted Strings Are the Same

## Escape Sequences Represent Special Bytes

	>>> s = 'a\0b\0c'
	>>> s
	'a\x00b\x00c'
	>>> len(s)
	5

In Python, the zero(null)byte does not terminate a string the way in 
C.Instead, Python keeps both strings's length and text in memory.In
fact, no character terminates a string in Python.

if Python does not recognize the character after a \ as being a valid
escape code, it simply keeps the backslash in the resulting string:

	>>> x = 'c:\py\code'
	>>> x
	'c:\\py\\code'

## Raw Strings Suppress Escapes

## Triple Quotes Code Multiline Block Strings

	>>> s = '''I am your father's dady'''
	>>> s
	"I am your father's dady"
	>>> b = '''I am your mather\'s mam'''
	>>> b
	"I am your mather's mam"

you can see the escape still work in three quotes.

Triple-quoted strings are useful any time you need multiline text in 
your program; for example, to embed mutiline error message or HTML 
or XML code in your source code files.

##Indexing and Slicing

**Extended slicing: the third limit and slice ojects**

	>>> S = 'abcdefghijklmnop'
	>>> S[1:10:2]
	'bdfhj'
	>>> S[::2]
	'acegikmo'

use a negative stride to *reverse* the sequence:

	>>> S = 'World'
	>>> S[::-1]
	'dlroW'

## String Conversion Tools

	>>> int("42"), str(42)
	(42, '42')
	>>> str(3.1415), float("1.5")
	('3.1415', 1.5)

- Character code conventions

	>>> ord('a')
	97
	>>> chr(97)
	'a'

- Changing Strings
- String Methods

## String Method Example
- Changing Strings
- Parsing Text

## String Formatting Expressions

- *String formatting expressions*
- *String formatting method calls*

## Advanced String Formatting Expressions

	%[(name)][flags][width][.precision]typecode

- name: a dictionary key;
- flags: list flags that specify things like left justification (-),
numeric sign (+), and zero fills (0);
- width: give a total minimum field width and the number of digits 
after a decimal point;

Dictionary-Based String Formatting Expressions


