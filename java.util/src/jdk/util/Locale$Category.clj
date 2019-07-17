(ns jdk.util.Locale$Category
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Locale$Category]))

(def DISPLAY
  "Enum Constant.

  Category used to represent the default locale for
   displaying user interfaces.

  type: java.util.Locale.Category"
  Locale$Category/DISPLAY)

(def FORMAT
  "Enum Constant.

  Category used to represent the default locale for
   formatting dates, numbers, and/or currencies.

  type: java.util.Locale.Category"
  Locale$Category/FORMAT)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Locale.Category c : Locale.Category.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.util.Locale.Category[]`"
  ([]
    (Locale$Category/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.util.Locale.Category`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (Locale$Category/valueOf name)))

