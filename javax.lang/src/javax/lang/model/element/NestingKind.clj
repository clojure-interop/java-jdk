(ns javax.lang.model.element.NestingKind
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element NestingKind]))

(def TOP_LEVEL
  "Enum Constant.

  A top-level type, not contained within another type.

  type: javax.lang.model.element.NestingKind"
  NestingKind/TOP_LEVEL)

(def MEMBER
  "Enum Constant.

  A type that is a named member of another type.

  type: javax.lang.model.element.NestingKind"
  NestingKind/MEMBER)

(def LOCAL
  "Enum Constant.

  A named type declared within a construct other than a type.

  type: javax.lang.model.element.NestingKind"
  NestingKind/LOCAL)

(def ANONYMOUS
  "Enum Constant.

  A type without a name.

  type: javax.lang.model.element.NestingKind"
  NestingKind/ANONYMOUS)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (NestingKind c : NestingKind.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.lang.model.element.NestingKind[]`"
  ([]
    (NestingKind/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.lang.model.element.NestingKind`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.lang.model.element.NestingKind [^java.lang.String name]
    (NestingKind/valueOf name)))

(defn nested?
  "Does this constant correspond to a nested type element?
   A nested type element is any that is not top-level.
   An inner type element is any nested type element that
   is not static.

  returns: whether or not the constant is nested - `boolean`"
  (^Boolean [^NestingKind this]
    (-> this (.isNested))))

