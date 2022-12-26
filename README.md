# CBase

A BASIC "compiler" implemented entirely using the C macro system.

CBase is a fork and derived from [Pyrite](https://github.com/Leushenko/Pyrite).

It uses a largish number of C preprocessor macros to build a BASIC-style
syntax layer on top of C. It requires a C99-compliant preprocessor (for the
variadic macros), and for various reasons will not work with C++ due to the
nature of the output code. Heavy-duty use of macros means that a powerful
preprocessor like GCC's will probably give best results.

Features:
  - BASIC-like syntax forms
  - garbage collection
  - exceptions
  - user-defined objects
  - arrays
  - string and collection methods (not yet included)
