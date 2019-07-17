(ns jdk.lang.ProcessBuilder$Redirect$Type
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ProcessBuilder$Redirect$Type]))

(def PIPE
  "Enum Constant.

  The type of Redirect.PIPE.

  type: java.lang.ProcessBuilder.Redirect.Type"
  ProcessBuilder$Redirect$Type/PIPE)

(def INHERIT
  "Enum Constant.

  The type of Redirect.INHERIT.

  type: java.lang.ProcessBuilder.Redirect.Type"
  ProcessBuilder$Redirect$Type/INHERIT)

(def READ
  "Enum Constant.

  The type of redirects returned from
   Redirect.from(File).

  type: java.lang.ProcessBuilder.Redirect.Type"
  ProcessBuilder$Redirect$Type/READ)

(def WRITE
  "Enum Constant.

  The type of redirects returned from
   Redirect.to(File).

  type: java.lang.ProcessBuilder.Redirect.Type"
  ProcessBuilder$Redirect$Type/WRITE)

(def APPEND
  "Enum Constant.

  The type of redirects returned from
   Redirect.appendTo(File).

  type: java.lang.ProcessBuilder.Redirect.Type"
  ProcessBuilder$Redirect$Type/APPEND)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (ProcessBuilder.Redirect.Type c : ProcessBuilder.Redirect.Type.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.lang.ProcessBuilder.Redirect.Type[]`"
  ([]
    (ProcessBuilder$Redirect$Type/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.lang.ProcessBuilder.Redirect.Type`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (ProcessBuilder$Redirect$Type/valueOf name)))

