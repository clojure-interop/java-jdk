(ns javax.lang.model.type.TypeKind
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type TypeKind]))

(def BOOLEAN
  "Enum Constant.

  The primitive type boolean.

  type: javax.lang.model.type.TypeKind"
  TypeKind/BOOLEAN)

(def BYTE
  "Enum Constant.

  The primitive type byte.

  type: javax.lang.model.type.TypeKind"
  TypeKind/BYTE)

(def SHORT
  "Enum Constant.

  The primitive type short.

  type: javax.lang.model.type.TypeKind"
  TypeKind/SHORT)

(def INT
  "Enum Constant.

  The primitive type int.

  type: javax.lang.model.type.TypeKind"
  TypeKind/INT)

(def LONG
  "Enum Constant.

  The primitive type long.

  type: javax.lang.model.type.TypeKind"
  TypeKind/LONG)

(def CHAR
  "Enum Constant.

  The primitive type char.

  type: javax.lang.model.type.TypeKind"
  TypeKind/CHAR)

(def FLOAT
  "Enum Constant.

  The primitive type float.

  type: javax.lang.model.type.TypeKind"
  TypeKind/FLOAT)

(def DOUBLE
  "Enum Constant.

  The primitive type double.

  type: javax.lang.model.type.TypeKind"
  TypeKind/DOUBLE)

(def VOID
  "Enum Constant.

  The pseudo-type corresponding to the keyword void.

  type: javax.lang.model.type.TypeKind"
  TypeKind/VOID)

(def NONE
  "Enum Constant.

  A pseudo-type used where no actual type is appropriate.

  type: javax.lang.model.type.TypeKind"
  TypeKind/NONE)

(def NULL
  "Enum Constant.

  The null type.

  type: javax.lang.model.type.TypeKind"
  TypeKind/NULL)

(def ARRAY
  "Enum Constant.

  An array type.

  type: javax.lang.model.type.TypeKind"
  TypeKind/ARRAY)

(def DECLARED
  "Enum Constant.

  A class or interface type.

  type: javax.lang.model.type.TypeKind"
  TypeKind/DECLARED)

(def ERROR
  "Enum Constant.

  A class or interface type that could not be resolved.

  type: javax.lang.model.type.TypeKind"
  TypeKind/ERROR)

(def TYPEVAR
  "Enum Constant.

  A type variable.

  type: javax.lang.model.type.TypeKind"
  TypeKind/TYPEVAR)

(def WILDCARD
  "Enum Constant.

  A wildcard type argument.

  type: javax.lang.model.type.TypeKind"
  TypeKind/WILDCARD)

(def PACKAGE
  "Enum Constant.

  A pseudo-type corresponding to a package element.

  type: javax.lang.model.type.TypeKind"
  TypeKind/PACKAGE)

(def EXECUTABLE
  "Enum Constant.

  A method, constructor, or initializer.

  type: javax.lang.model.type.TypeKind"
  TypeKind/EXECUTABLE)

(def OTHER
  "Enum Constant.

  An implementation-reserved type.
   This is not the type you are looking for.

  type: javax.lang.model.type.TypeKind"
  TypeKind/OTHER)

(def UNION
  "Enum Constant.

  A union type.

  type: javax.lang.model.type.TypeKind"
  TypeKind/UNION)

(def INTERSECTION
  "Enum Constant.

  An intersection type.

  type: javax.lang.model.type.TypeKind"
  TypeKind/INTERSECTION)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (TypeKind c : TypeKind.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.lang.model.type.TypeKind[]`"
  ([]
    (TypeKind/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.lang.model.type.TypeKind`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (TypeKind/valueOf name)))

(defn primitive?
  "Returns true if this kind corresponds to a primitive
   type and false otherwise.

  returns: true if this kind corresponds to a primitive type - `boolean`"
  ([this]
    (-> this (.isPrimitive))))

