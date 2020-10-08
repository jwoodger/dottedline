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

Usage
-----

Preconditions with ``requires``
...............................
Preconditions on a method express contracts that must be satistfied by the
*client* of the method (that is, the method/object that calls it). Usually this
is a requirement of the method parameters.

For example, in a rectangle class, you might write a constructor that takes a
width and height:

.. code-block:: java

   public class Rectangle {

       public Rectangle(int width, int height) {
           // ...
       }
   }

When making a rectangle, it would only make sense if the width and height were
positive, that is, greater than 0. This would be a *precondition* on clients
calling the rectangle constructor. You can express this precondition both
through the documentation as well as dottedline's ``requires`` method, like so:

.. code-block:: java

   import static jwoodger.dottedline.Contracts.*;

   public class Rectangle {

       /**
        * @param width The width of the rectangle - must be positive.
	* @param height The height of the rectangle - must be positive.
	*/
       public Rectangle(int width, int height) {
           requires(width > 0 && height > 0);
	   // ...
       }
   }

In this case, if the precondition fails, ``requires`` will throw an unchecked
exception - ``PreconditionViolationException``.

You can also pass a message to ``requires``:

.. code-block:: java

   requires(width > 0 && height > 0, "Width and height must be positive.");

Postconditions with ``ensures``
-------------------------------
A postcondition expresses a contract that must be fulfilled by the callee of a
method. Usually a postcondition signals a programming error, and thus the
program should crash if it is not met.

For example, a custom container class might contain a sorting algorithm. A good
postcondition would, at the end of the sorting algorithm, check that the
container was properly sorted. Like above, you can express this postcondition
through documentation and the ``ensures`` method:

.. code-block:: java

   import static jwoodger.dottedline.Contracts.*;

   public class Container {

       // Checks that the container is properly sorted.
       private boolean isSorted() {
       }

       /**
        * Sorts this container.
        */
       public void sort() {
           // sorting logic...

           ensures(isSorted());
       }
   }

If the container was not correctly sorted, ``ensures`` will throw a
``PostconditionViolationException``.

Just like with ``requires``, ``ensures`` can take a message parameter.

.. code-block:: java

   ensures(isSorted(), "The container is properly sorted.");
