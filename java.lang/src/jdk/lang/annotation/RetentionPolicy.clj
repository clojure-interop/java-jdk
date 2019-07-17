(ns jdk.lang.annotation.RetentionPolicy
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.annotation RetentionPolicy]))

(def SOURCE
  "Enum Constant.

  Annotations are to be discarded by the compiler.

  type: java.lang.annotation.RetentionPolicy"
  RetentionPolicy/SOURCE)

(def CLASS
  "Enum Constant.

  Annotations are to be recorded in the class file by the compiler
   but need not be retained by the VM at run time.  This is the default
   behavior.

  type: java.lang.annotation.RetentionPolicy"
  RetentionPolicy/CLASS)

(def RUNTIME
  "Enum Constant.

  Annotations are to be recorded in the class file by the compiler and
   retained by the VM at run time, so they may be read reflectively.

  type: java.lang.annotation.RetentionPolicy"
  RetentionPolicy/RUNTIME)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (RetentionPolicy c : RetentionPolicy.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.lang.annotation.RetentionPolicy[]`"
  ([]
    (RetentionPolicy/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.lang.annotation.RetentionPolicy`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.lang.annotation.RetentionPolicy [^java.lang.String name]
    (RetentionPolicy/valueOf name)))

