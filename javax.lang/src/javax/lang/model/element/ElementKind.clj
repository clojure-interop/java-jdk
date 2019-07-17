(ns javax.lang.model.element.ElementKind
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element ElementKind]))

(def PACKAGE
  "Enum Constant.

  A package.

  type: javax.lang.model.element.ElementKind"
  ElementKind/PACKAGE)

(def ENUM
  "Enum Constant.

  An enum type.

  type: javax.lang.model.element.ElementKind"
  ElementKind/ENUM)

(def CLASS
  "Enum Constant.

  A class not described by a more specific kind (like ENUM).

  type: javax.lang.model.element.ElementKind"
  ElementKind/CLASS)

(def ANNOTATION_TYPE
  "Enum Constant.

  An annotation type.

  type: javax.lang.model.element.ElementKind"
  ElementKind/ANNOTATION_TYPE)

(def INTERFACE
  "Enum Constant.

  An interface not described by a more specific kind (like
   ANNOTATION_TYPE).

  type: javax.lang.model.element.ElementKind"
  ElementKind/INTERFACE)

(def ENUM_CONSTANT
  "Enum Constant.

  An enum constant.

  type: javax.lang.model.element.ElementKind"
  ElementKind/ENUM_CONSTANT)

(def FIELD
  "Enum Constant.

  A field not described by a more specific kind (like
   ENUM_CONSTANT).

  type: javax.lang.model.element.ElementKind"
  ElementKind/FIELD)

(def PARAMETER
  "Enum Constant.

  A parameter of a method or constructor.

  type: javax.lang.model.element.ElementKind"
  ElementKind/PARAMETER)

(def LOCAL_VARIABLE
  "Enum Constant.

  A local variable.

  type: javax.lang.model.element.ElementKind"
  ElementKind/LOCAL_VARIABLE)

(def EXCEPTION_PARAMETER
  "Enum Constant.

  A parameter of an exception handler.

  type: javax.lang.model.element.ElementKind"
  ElementKind/EXCEPTION_PARAMETER)

(def METHOD
  "Enum Constant.

  A method.

  type: javax.lang.model.element.ElementKind"
  ElementKind/METHOD)

(def CONSTRUCTOR
  "Enum Constant.

  A constructor.

  type: javax.lang.model.element.ElementKind"
  ElementKind/CONSTRUCTOR)

(def STATIC_INIT
  "Enum Constant.

  A static initializer.

  type: javax.lang.model.element.ElementKind"
  ElementKind/STATIC_INIT)

(def INSTANCE_INIT
  "Enum Constant.

  An instance initializer.

  type: javax.lang.model.element.ElementKind"
  ElementKind/INSTANCE_INIT)

(def TYPE_PARAMETER
  "Enum Constant.

  A type parameter.

  type: javax.lang.model.element.ElementKind"
  ElementKind/TYPE_PARAMETER)

(def OTHER
  "Enum Constant.

  An implementation-reserved element.  This is not the element
   you are looking for.

  type: javax.lang.model.element.ElementKind"
  ElementKind/OTHER)

(def RESOURCE_VARIABLE
  "Enum Constant.

  A resource variable.

  type: javax.lang.model.element.ElementKind"
  ElementKind/RESOURCE_VARIABLE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (ElementKind c : ElementKind.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.lang.model.element.ElementKind[]`"
  ([]
    (ElementKind/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.lang.model.element.ElementKind`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.lang.model.element.ElementKind [^java.lang.String name]
    (ElementKind/valueOf name)))

(defn class?
  "Returns true if this is a kind of class:
   either CLASS or ENUM.

  returns: true if this is a kind of class - `boolean`"
  (^Boolean [^javax.lang.model.element.ElementKind this]
    (-> this (.isClass))))

(defn interface?
  "Returns true if this is a kind of interface:
   either INTERFACE or ANNOTATION_TYPE.

  returns: true if this is a kind of interface - `boolean`"
  (^Boolean [^javax.lang.model.element.ElementKind this]
    (-> this (.isInterface))))

(defn field?
  "Returns true if this is a kind of field:
   either FIELD or ENUM_CONSTANT.

  returns: true if this is a kind of field - `boolean`"
  (^Boolean [^javax.lang.model.element.ElementKind this]
    (-> this (.isField))))

