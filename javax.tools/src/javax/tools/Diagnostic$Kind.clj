(ns javax.tools.Diagnostic$Kind
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools Diagnostic$Kind]))

(def ERROR
  "Enum Constant.

  Problem which prevents the tool's normal completion.

  type: javax.tools.Diagnostic.Kind"
  Diagnostic$Kind/ERROR)

(def WARNING
  "Enum Constant.

  Problem which does not usually prevent the tool from
   completing normally.

  type: javax.tools.Diagnostic.Kind"
  Diagnostic$Kind/WARNING)

(def MANDATORY_WARNING
  "Enum Constant.

  Problem similar to a warning, but is mandated by the tool's
   specification.  For example, the Java™ Language
   Specification mandates warnings on certain
   unchecked operations and the use of deprecated methods.

  type: javax.tools.Diagnostic.Kind"
  Diagnostic$Kind/MANDATORY_WARNING)

(def NOTE
  "Enum Constant.

  Informative message from the tool.

  type: javax.tools.Diagnostic.Kind"
  Diagnostic$Kind/NOTE)

(def OTHER
  "Enum Constant.

  Diagnostic which does not fit within the other kinds.

  type: javax.tools.Diagnostic.Kind"
  Diagnostic$Kind/OTHER)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Diagnostic.Kind c : Diagnostic.Kind.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.tools.Diagnostic.Kind[]`"
  ([]
    (Diagnostic$Kind/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.tools.Diagnostic.Kind`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (Diagnostic$Kind/valueOf name)))

