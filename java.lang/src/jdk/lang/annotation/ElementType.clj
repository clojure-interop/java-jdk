(ns jdk.lang.annotation.ElementType
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.annotation ElementType]))

(def TYPE
  "Enum Constant.

  Class, interface (including annotation type), or enum declaration

  type: java.lang.annotation.ElementType"
  ElementType/TYPE)

(def FIELD
  "Enum Constant.

  Field declaration (includes enum constants)

  type: java.lang.annotation.ElementType"
  ElementType/FIELD)

(def METHOD
  "Enum Constant.

  Method declaration

  type: java.lang.annotation.ElementType"
  ElementType/METHOD)

(def PARAMETER
  "Enum Constant.

  Formal parameter declaration

  type: java.lang.annotation.ElementType"
  ElementType/PARAMETER)

(def CONSTRUCTOR
  "Enum Constant.

  Constructor declaration

  type: java.lang.annotation.ElementType"
  ElementType/CONSTRUCTOR)

(def LOCAL_VARIABLE
  "Enum Constant.

  Local variable declaration

  type: java.lang.annotation.ElementType"
  ElementType/LOCAL_VARIABLE)

(def ANNOTATION_TYPE
  "Enum Constant.

  Annotation type declaration

  type: java.lang.annotation.ElementType"
  ElementType/ANNOTATION_TYPE)

(def PACKAGE
  "Enum Constant.

  Package declaration

  type: java.lang.annotation.ElementType"
  ElementType/PACKAGE)

(def TYPE_PARAMETER
  "Enum Constant.

  Type parameter declaration

  type: java.lang.annotation.ElementType"
  ElementType/TYPE_PARAMETER)

(def TYPE_USE
  "Enum Constant.

  Use of a type

  type: java.lang.annotation.ElementType"
  ElementType/TYPE_USE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (ElementType c : ElementType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.lang.annotation.ElementType[]`"
  ([]
    (ElementType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.lang.annotation.ElementType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (ElementType/valueOf name)))

