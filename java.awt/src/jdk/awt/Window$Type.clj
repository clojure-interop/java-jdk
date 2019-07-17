(ns jdk.awt.Window$Type
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Window$Type]))

(def NORMAL
  "Enum Constant.

  Represents a normal window.

   This is the default type for objects of the Window class or
   its descendants. Use this type for regular top-level windows.

  type: java.awt.Window.Type"
  Window$Type/NORMAL)

(def UTILITY
  "Enum Constant.

  Represents a utility window.

   A utility window is usually a small window such as a toolbar or a
   palette. The native system may render the window with smaller
   title-bar if the window is either a Frame or a Dialog object, and if it has its decorations enabled.

  type: java.awt.Window.Type"
  Window$Type/UTILITY)

(def POPUP
  "Enum Constant.

  Represents a popup window.

   A popup window is a temporary window such as a drop-down menu or a
   tooltip. On some platforms, windows of that type may be forcibly
   made undecorated even if they are instances of the Frame or
   Dialog class, and have decorations enabled.

  type: java.awt.Window.Type"
  Window$Type/POPUP)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Window.Type c : Window.Type.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.awt.Window.Type[]`"
  ([]
    (Window$Type/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.awt.Window.Type`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (Window$Type/valueOf name)))

