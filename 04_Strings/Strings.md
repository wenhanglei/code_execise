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

