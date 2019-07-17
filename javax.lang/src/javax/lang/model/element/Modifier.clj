(ns javax.lang.model.element.Modifier
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element Modifier]))

(def PUBLIC
  "Enum Constant.

  The modifier public

  type: javax.lang.model.element.Modifier"
  Modifier/PUBLIC)

(def PROTECTED
  "Enum Constant.

  The modifier protected

  type: javax.lang.model.element.Modifier"
  Modifier/PROTECTED)

(def PRIVATE
  "Enum Constant.

  The modifier private

  type: javax.lang.model.element.Modifier"
  Modifier/PRIVATE)

(def ABSTRACT
  "Enum Constant.

  The modifier abstract

  type: javax.lang.model.element.Modifier"
  Modifier/ABSTRACT)

(def DEFAULT
  "Enum Constant.

  The modifier default

  type: javax.lang.model.element.Modifier"
  Modifier/DEFAULT)

(def STATIC
  "Enum Constant.

  The modifier static

  type: javax.lang.model.element.Modifier"
  Modifier/STATIC)

(def FINAL
  "Enum Constant.

  The modifier final

  type: javax.lang.model.element.Modifier"
  Modifier/FINAL)

(def TRANSIENT
  "Enum Constant.

  The modifier transient

  type: javax.lang.model.element.Modifier"
  Modifier/TRANSIENT)

(def VOLATILE
  "Enum Constant.

  The modifier volatile

  type: javax.lang.model.element.Modifier"
  Modifier/VOLATILE)

(def SYNCHRONIZED
  "Enum Constant.

  The modifier synchronized

  type: javax.lang.model.element.Modifier"
  Modifier/SYNCHRONIZED)

(def NATIVE
  "Enum Constant.

  The modifier native

  type: javax.lang.model.element.Modifier"
  Modifier/NATIVE)

(def STRICTFP
  "Enum Constant.

  The modifier strictfp

  type: javax.lang.model.element.Modifier"
  Modifier/STRICTFP)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Modifier c : Modifier.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.lang.model.element.Modifier[]`"
  ([]
    (Modifier/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.lang.model.element.Modifier`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.lang.model.element.Modifier [^java.lang.String name]
    (Modifier/valueOf name)))

(defn to-string
  "Returns this modifier's name in lowercase.

  returns: the name of this enum constant - `java.lang.String`"
  (^java.lang.String [^javax.lang.model.element.Modifier this]
    (-> this (.toString))))

