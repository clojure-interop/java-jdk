(ns jdk.beans.Expression
  "An Expression object represents a primitive expression
  in which a single method is applied to a target and a set of
  arguments to return a result - as in `a.getFoo()`.

  In addition to the properties of the super class, the
  Expression object provides a value which
  is the object returned when this expression is evaluated.
  The return value is typically not provided by the caller and
  is instead computed by dynamically finding the method and invoking
  it when the first call to getValue is made."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans Expression]))

(defn ->expression
  "Constructor.

  Creates a new Expression object with the specified value
   for the specified target object to invoke the  method
   specified by the name and by the array of arguments.
   The value value is used as the value of the value property,
   so the getValue() method will return it
   without executing this Expression.

   The target and the methodName values should not be null.
   Otherwise an attempt to execute this Expression
   will result in a NullPointerException.
   If the arguments value is null,
   an empty array is used as the value of the arguments property.

  value - the value of this expression - `java.lang.Object`
  target - the target object of this expression - `java.lang.Object`
  method-name - the name of the method to invoke on the specified target - `java.lang.String`
  arguments - the array of arguments to invoke the specified method - `java.lang.Object[]`"
  (^Expression [^java.lang.Object value ^java.lang.Object target ^java.lang.String method-name arguments]
    (new Expression value target method-name arguments))
  (^Expression [^java.lang.Object target ^java.lang.String method-name arguments]
    (new Expression target method-name arguments)))

(defn execute
  "The execute method finds a method whose name is the same
   as the methodName property, and invokes the method on
   the target.

   When the target's class defines many methods with the given name
   the implementation should choose the most specific method using
   the algorithm specified in the Java Language Specification
   (15.11). The dynamic class of the target and arguments are used
   in place of the compile-time type information and, like the
   Method class itself, conversion between
   primitive values and their associated wrapper classes is handled
   internally.

   The following method types are handled as special cases:


   Static methods may be called by using a class object as the target.

   The reserved method name `new` may be used to call a class's constructor
   as if all classes defined static `new` methods. Constructor invocations
   are typically considered Expressions rather than Statements
   as they return a value.

   The method names `get` and `set` defined in the List
   interface may also be applied to array instances, mapping to
   the static methods of the same name in the Array class.


   If the invoked method completes normally,
   the value it returns is copied in the value property.
   Note that the value property is set to null,
   if the return type of the underlying method is void.

  throws: java.lang.NullPointerException - if the value of the target or methodName property is null"
  ([^Expression this]
    (-> this (.execute))))

(defn get-value
  "If the value property of this instance is not already set,
   this method dynamically finds the method with the specified
   methodName on this target with these arguments and calls it.
   The result of the method invocation is first copied
   into the value property of this expression and then returned
   as the result of getValue. If the value property
   was already set, either by a call to setValue
   or a previous call to getValue then the value
   property is returned without either looking up or calling the method.

   The value property of an Expression is set to
   a unique private (non-null) value by default and
   this value is used as an internal indication that the method
   has not yet been called. A return value of null
   replaces this default value in the same way that any other value
   would, ensuring that expressions are never evaluated more than once.

   See the execute method for details on how
   methods are chosen using the dynamic types of the target
   and arguments.

  returns: The result of applying this method to these arguments. - `java.lang.Object`

  throws: java.lang.Exception - if the method with the specified methodName throws an exception"
  (^java.lang.Object [^Expression this]
    (-> this (.getValue))))

(defn set-value
  "Sets the value of this expression to value.
   This value will be returned by the getValue method
   without calling the method associated with this
   expression.

  value - The value of this expression. - `java.lang.Object`"
  ([^Expression this ^java.lang.Object value]
    (-> this (.setValue value))))

(defn to-string
  "Prints the value of this expression using a Java-style syntax.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^Expression this]
    (-> this (.toString))))

