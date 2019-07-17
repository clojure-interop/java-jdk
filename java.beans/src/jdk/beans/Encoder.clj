(ns jdk.beans.Encoder
  "An Encoder is a class which can be used to create
  files or streams that encode the state of a collection of
  JavaBeans in terms of their public APIs. The Encoder,
  in conjunction with its persistence delegates, is responsible for
  breaking the object graph down into a series of Statementss
  and Expressions which can be used to create it.
  A subclass typically provides a syntax for these expressions
  using some human readable form - like Java source code or XML."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans Encoder]))

(defn ->encoder
  "Constructor."
  ([]
    (new Encoder )))

(defn set-exception-listener
  "Sets the exception handler for this stream to exceptionListener.
   The exception handler is notified when this stream catches recoverable
   exceptions.

  exception-listener - The exception handler for this stream; if null the default exception listener will be used. - `java.beans.ExceptionListener`"
  ([this exception-listener]
    (-> this (.setExceptionListener exception-listener))))

(defn get-exception-listener
  "Gets the exception handler for this stream.

  returns: The exception handler for this stream;
      Will return the default exception listener if this has not explicitly been set. - `java.beans.ExceptionListener`"
  ([this]
    (-> this (.getExceptionListener))))

(defn get-persistence-delegate
  "Returns the persistence delegate for the given type.
   The persistence delegate is calculated by applying
   the following rules in order:


   If a persistence delegate is associated with the given type
   by using the setPersistenceDelegate(java.lang.Class<?>, java.beans.PersistenceDelegate) method
   it is returned.

   A persistence delegate is then looked up by the name
   composed of the the fully qualified name of the given type
   and the `PersistenceDelegate` postfix.
   For example, a persistence delegate for the Bean class
   should be named BeanPersistenceDelegate
   and located in the same package.


   public class Bean { ... }
   public class BeanPersistenceDelegate { ... }
   The instance of the BeanPersistenceDelegate class
   is returned for the Bean class.

   If the type is null,
   a shared internal persistence delegate is returned
   that encodes null value.

   If the type is a enum declaration,
   a shared internal persistence delegate is returned
   that encodes constants of this enumeration
   by their names.

   If the type is a primitive type or the corresponding wrapper,
   a shared internal persistence delegate is returned
   that encodes values of the given type.

   If the type is an array,
   a shared internal persistence delegate is returned
   that encodes an array of the appropriate type and length,
   and each of its elements as if they are properties.

   If the type is a proxy,
   a shared internal persistence delegate is returned
   that encodes a proxy instance by using
   the Proxy.newProxyInstance(java.lang.ClassLoader, java.lang.Class<?>[], java.lang.reflect.InvocationHandler) method.

   If the BeanInfo for this type has a BeanDescriptor
   which defined a `persistenceDelegate` attribute,
   the value of this named attribute is returned.

   In all other cases the default persistence delegate is returned.
   The default persistence delegate assumes the type is a JavaBean,
   implying that it has a default constructor and that its state
   may be characterized by the matching pairs of `setter` and `getter`
   methods returned by the Introspector class.
   The default constructor is the constructor with the greatest number
   of parameters that has the ConstructorProperties annotation.
   If none of the constructors has the ConstructorProperties annotation,
   then the nullary constructor (constructor with no parameters) will be used.
   For example, in the following code fragment, the nullary constructor
   for the Foo class will be used,
   while the two-parameter constructor
   for the Bar class will be used.


   public class Foo {
       public Foo() { ... }
       public Foo(int x) { ... }
   }
   public class Bar {
       public Bar() { ... }
       @ConstructorProperties({`x`})
       public Bar(int x) { ... }
       @ConstructorProperties({`x`, `y`})
       public Bar(int x, int y) { ... }
   }

  type - the class of the objects - `java.lang.Class<?>`

  returns: the persistence delegate for the given type - `java.beans.PersistenceDelegate`"
  ([this type]
    (-> this (.getPersistenceDelegate type))))

(defn set-persistence-delegate
  "Associates the specified persistence delegate with the given type.

  type - the class of objects that the specified persistence delegate applies to - `java.lang.Class<?>`
  delegate - the persistence delegate for instances of the given type - `java.beans.PersistenceDelegate`"
  ([this type delegate]
    (-> this (.setPersistenceDelegate type delegate))))

(defn remove
  "Removes the entry for this instance, returning the old entry.

  old-instance - The entry that should be removed. - `java.lang.Object`

  returns: The entry that was removed. - `java.lang.Object`"
  ([this old-instance]
    (-> this (.remove old-instance))))

(defn get
  "Returns a tentative value for oldInstance in
   the environment created by this stream. A persistence
   delegate can use its mutatesTo method to
   determine whether this value may be initialized to
   form the equivalent object at the output or whether
   a new object must be instantiated afresh. If the
   stream has not yet seen this value, null is returned.

  old-instance - The instance to be looked up. - `java.lang.Object`

  returns: The object, null if the object has not been seen before. - `java.lang.Object`"
  ([this old-instance]
    (-> this (.get old-instance))))

(defn write-statement
  "Writes statement oldStm to the stream.
   The oldStm should be written entirely
   in terms of the callers environment, i.e. the
   target and all arguments should be part of the
   object graph being written. These expressions
   represent a series of `what happened` expressions
   which tell the output stream how to produce an
   object graph like the original.

   The implementation of this method will produce
   a second expression to represent the same expression in
   an environment that will exist when the stream is read.
   This is achieved simply by calling writeObject
   on the target and all the arguments and building a new
   expression with the results.

  old-stm - The expression to be written to the stream. - `java.beans.Statement`"
  ([this old-stm]
    (-> this (.writeStatement old-stm))))

(defn write-expression
  "The implementation first checks to see if an
   expression with this value has already been written.
   If not, the expression is cloned, using
   the same procedure as writeStatement,
   and the value of this expression is reconciled
   with the value of the cloned expression
   by calling writeObject.

  old-exp - The expression to be written to the stream. - `java.beans.Expression`"
  ([this old-exp]
    (-> this (.writeExpression old-exp))))

