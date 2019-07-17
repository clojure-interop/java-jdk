(ns javax.tools.JavaFileObject$Kind
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools JavaFileObject$Kind]))

(def SOURCE
  "Enum Constant.

  Source files written in the Java programming language.  For
   example, regular files ending with .java.

  type: javax.tools.JavaFileObject.Kind"
  JavaFileObject$Kind/SOURCE)

(def CLASS
  "Enum Constant.

  Class files for the Java Virtual Machine.  For example,
   regular files ending with .class.

  type: javax.tools.JavaFileObject.Kind"
  JavaFileObject$Kind/CLASS)

(def HTML
  "Enum Constant.

  HTML files.  For example, regular files ending with .html.

  type: javax.tools.JavaFileObject.Kind"
  JavaFileObject$Kind/HTML)

(def OTHER
  "Enum Constant.

  Any other kind.

  type: javax.tools.JavaFileObject.Kind"
  JavaFileObject$Kind/OTHER)

(def -extension
  "Instance Constant.

  The extension which (by convention) is normally used for
   this kind of file object.  If no convention exists, the
   empty string (``) is used.

  type: java.lang.String"
  (-> this .-extension))

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (JavaFileObject.Kind c : JavaFileObject.Kind.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.tools.JavaFileObject.Kind[]`"
  ([]
    (JavaFileObject$Kind/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.tools.JavaFileObject.Kind`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (JavaFileObject$Kind/valueOf name)))

