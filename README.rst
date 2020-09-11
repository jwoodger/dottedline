dottedline - Contract Programming for Java
==========================================
dottedline is a Java library meant to make it easy to use Design by
Contract. This kind of design lets programmers create components with different
requirements, both on the clients of the components, and the internals of the
component itself. It is built into languages such as Ada, D, and Eiffel.

While Java can support Design by Contract through constructs like exceptions and
the ``assert`` keyword, it is sometimes difficult to tell from looking at code
what contracts a class or method wants callers to fulfill. dottedline lets
programmers define contracts easily and in a way that communicates their intent.
