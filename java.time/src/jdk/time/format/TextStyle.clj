(ns jdk.time.format.TextStyle
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.format TextStyle]))

(def FULL
  "Enum Constant.

  Full text, typically the full description.
   For example, day-of-week Monday might output `Monday`.

  type: java.time.format.TextStyle"
  TextStyle/FULL)

(def FULL_STANDALONE
  "Enum Constant.

  Full text for stand-alone use, typically the full description.
   For example, day-of-week Monday might output `Monday`.

  type: java.time.format.TextStyle"
  TextStyle/FULL_STANDALONE)

(def SHORT
  "Enum Constant.

  Short text, typically an abbreviation.
   For example, day-of-week Monday might output `Mon`.

  type: java.time.format.TextStyle"
  TextStyle/SHORT)

(def SHORT_STANDALONE
  "Enum Constant.

  Short text for stand-alone use, typically an abbreviation.
   For example, day-of-week Monday might output `Mon`.

  type: java.time.format.TextStyle"
  TextStyle/SHORT_STANDALONE)

(def NARROW
  "Enum Constant.

  Narrow text, typically a single letter.
   For example, day-of-week Monday might output `M`.

  type: java.time.format.TextStyle"
  TextStyle/NARROW)

(def NARROW_STANDALONE
  "Enum Constant.

  Narrow text for stand-alone use, typically a single letter.
   For example, day-of-week Monday might output `M`.

  type: java.time.format.TextStyle"
  TextStyle/NARROW_STANDALONE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (TextStyle c : TextStyle.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.format.TextStyle[]`"
  ([]
    (TextStyle/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.format.TextStyle`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.time.format.TextStyle [^java.lang.String name]
    (TextStyle/valueOf name)))

(defn standalone?
  "Returns true if the Style is a stand-alone style.

  returns: true if the style is a stand-alone style. - `boolean`"
  (^Boolean [^TextStyle this]
    (-> this (.isStandalone))))

(defn as-standalone
  "Returns the stand-alone style with the same size.

  returns: the stand-alone style with the same size - `java.time.format.TextStyle`"
  (^java.time.format.TextStyle [^TextStyle this]
    (-> this (.asStandalone))))

(defn as-normal
  "Returns the normal style with the same size.

  returns: the normal style with the same size - `java.time.format.TextStyle`"
  (^java.time.format.TextStyle [^TextStyle this]
    (-> this (.asNormal))))

