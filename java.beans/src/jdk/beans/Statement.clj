(ns jdk.beans.Statement
  "A Statement object represents a primitive statement
  in which a single method is applied to a target and
  a set of arguments - as in \"a.setFoo(b)\".
  Note that where this example uses names
  to denote the target and its argument, a statement
  object does not require a name space and is constructed with
  the values themselves.
  The statement object associates the named method
  with its environment as a simple set of values:
  the target and an array of argument values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans Statement]))

(defn ->statement
  "Constructor.

  Creates a new Statement object
   for the specified target object to invoke the method
   specified by the name and by the array of arguments.

   The target and the methodName values should not be null.
   Otherwise an attempt to execute this Expression
   will result in a NullPointerException.
   If the arguments value is null,
   an empty array is used as the value of the arguments property.

  target - the target object of this statement - `java.lang.Object`
  method-name - the name of the method to invoke on the specified target - `java.lang.String`
  arguments - the array of arguments to invoke the specified method - `java.lang.Object[]`"
  (^Statement [^java.lang.Object target ^java.lang.String method-name arguments]
    (new Statement target method-name arguments)))

(defn get-target
  "Returns the target object of this statement.
   If this method returns null,
   the execute() method
   throws a NullPointerException.

  returns: the target object of this statement - `java.lang.Object`"
  (^java.lang.Object [^Statement this]
    (-> this (.getTarget))))

(defn get-method-name
  "Returns the name of the method to invoke.
   If this method returns null,
   the execute() method
   throws a NullPointerException.

  returns: the name of the method - `java.lang.String`"
  (^java.lang.String [^Statement this]
    (-> this (.getMethodName))))

(defn get-arguments
  "Returns the arguments for the method to invoke.
   The number of arguments and their types
   must match the method being  called.
   null can be used as a synonym of an empty array.

  returns: the array of arguments - `java.lang.Object[]`"
  ([^Statement this]
    (-> this (.getArguments))))

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

   The reserved method name \"new\" may be used to call a class's constructor
   as if all classes defined static \"new\" methods. Constructor invocations
   are typically considered Expressions rather than Statements
   as they return a value.

   The method names \"get\" and \"set\" defined in the List
   interface may also be applied to array instances, mapping to
   the static methods of the same name in the Array class.

  throws: java.lang.NullPointerException - if the value of the target or methodName property is null"
  ([^Statement this]
    (-> this (.execute))))

(defn to-string
  "Prints the value of this statement using a Java-style syntax.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^Statement this]
    (-> this (.toString))))

