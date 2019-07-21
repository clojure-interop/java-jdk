(ns jdk.awt.Desktop$Action
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Desktop$Action]))

(def OPEN
  "Enum Constant.

  Represents an \"open\" action.

  type: java.awt.Desktop$Action"
  Desktop$Action/OPEN)

(def EDIT
  "Enum Constant.

  Represents an \"edit\" action.

  type: java.awt.Desktop$Action"
  Desktop$Action/EDIT)

(def PRINT
  "Enum Constant.

  Represents a \"print\" action.

  type: java.awt.Desktop$Action"
  Desktop$Action/PRINT)

(def MAIL
  "Enum Constant.

  Represents a \"mail\" action.

  type: java.awt.Desktop$Action"
  Desktop$Action/MAIL)

(def BROWSE
  "Enum Constant.

  Represents a \"browse\" action.

  type: java.awt.Desktop$Action"
  Desktop$Action/BROWSE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Desktop.Action c : Desktop.Action.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.awt.Desktop$Action[]`"
  ([]
    (Desktop$Action/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.awt.Desktop$Action`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.awt.Desktop$Action [^java.lang.String name]
    (Desktop$Action/valueOf name)))

