(ns javax.lang.model.element.VariableElement
  "Represents a field, enum constant, method or constructor
  parameter, local variable, resource variable, or exception
  parameter."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element VariableElement]))

(defn get-constant-value
  "Returns the value of this variable if this is a final
   field initialized to a compile-time constant.  Returns null otherwise.  The value will be of a primitive type or a
   String.  If the value is of a primitive type, it is
   wrapped in the appropriate wrapper class (such as Integer).

   Note that not all final fields will have
   constant values.  In particular, enum constants are
   not considered to be compile-time constants.  To have a
   constant value, a field's type must be either a primitive type
   or String.

  returns: the value of this variable if this is a final
   field initialized to a compile-time constant, or null
   otherwise - `java.lang.Object`"
  ([^javax.lang.model.element.VariableElement this]
    (-> this (.getConstantValue))))

(defn get-simple-name
  "Returns the simple name of this variable element.

   For method and constructor parameters, the name of each
   parameter must be distinct from the names of all other
   parameters of the same executable.  If the original source
   names are not available, an implementation may synthesize names
   subject to the distinctness requirement above.

  returns: the simple name of this variable element - `javax.lang.model.element.Name`"
  ([^javax.lang.model.element.VariableElement this]
    (-> this (.getSimpleName))))

(defn get-enclosing-element
  "Returns the enclosing element of this variable.

   The enclosing element of a method or constructor parameter is
   the executable declaring the parameter.

  returns: the enclosing element of this variable - `javax.lang.model.element.Element`"
  ([^javax.lang.model.element.VariableElement this]
    (-> this (.getEnclosingElement))))

