(ns jdk.time.format.FormatStyle
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.format FormatStyle]))

(def FULL
  "Enum Constant.

  Full text style, with the most detail.
   For example, the format might be 'Tuesday, April 12, 1952 AD' or '3:30:42pm PST'.

  type: java.time.format.FormatStyle"
  FormatStyle/FULL)

(def LONG
  "Enum Constant.

  Long text style, with lots of detail.
   For example, the format might be 'January 12, 1952'.

  type: java.time.format.FormatStyle"
  FormatStyle/LONG)

(def MEDIUM
  "Enum Constant.

  Medium text style, with some detail.
   For example, the format might be 'Jan 12, 1952'.

  type: java.time.format.FormatStyle"
  FormatStyle/MEDIUM)

(def SHORT
  "Enum Constant.

  Short text style, typically numeric.
   For example, the format might be '12.13.52' or '3:30pm'.

  type: java.time.format.FormatStyle"
  FormatStyle/SHORT)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (FormatStyle c : FormatStyle.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.format.FormatStyle[]`"
  ([]
    (FormatStyle/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.format.FormatStyle`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.time.format.FormatStyle [^java.lang.String name]
    (FormatStyle/valueOf name)))

