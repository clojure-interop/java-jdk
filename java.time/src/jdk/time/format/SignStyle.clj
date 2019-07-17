(ns jdk.time.format.SignStyle
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.format SignStyle]))

(def NORMAL
  "Enum Constant.

  Style to output the sign only if the value is negative.

   In strict parsing, the negative sign will be accepted and the positive sign rejected.
   In lenient parsing, any sign will be accepted.

  type: java.time.format.SignStyle"
  SignStyle/NORMAL)

(def ALWAYS
  "Enum Constant.

  Style to always output the sign, where zero will output '+'.

   In strict parsing, the absence of a sign will be rejected.
   In lenient parsing, any sign will be accepted, with the absence
   of a sign treated as a positive number.

  type: java.time.format.SignStyle"
  SignStyle/ALWAYS)

(def NEVER
  "Enum Constant.

  Style to never output sign, only outputting the absolute value.

   In strict parsing, any sign will be rejected.
   In lenient parsing, any sign will be accepted unless the width is fixed.

  type: java.time.format.SignStyle"
  SignStyle/NEVER)

(def NOT_NEGATIVE
  "Enum Constant.

  Style to block negative values, throwing an exception on printing.

   In strict parsing, any sign will be rejected.
   In lenient parsing, any sign will be accepted unless the width is fixed.

  type: java.time.format.SignStyle"
  SignStyle/NOT_NEGATIVE)

(def EXCEEDS_PAD
  "Enum Constant.

  Style to always output the sign if the value exceeds the pad width.
   A negative value will always output the '-' sign.

   In strict parsing, the sign will be rejected unless the pad width is exceeded.
   In lenient parsing, any sign will be accepted, with the absence
   of a sign treated as a positive number.

  type: java.time.format.SignStyle"
  SignStyle/EXCEEDS_PAD)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (SignStyle c : SignStyle.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.format.SignStyle[]`"
  ([]
    (SignStyle/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.format.SignStyle`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.time.format.SignStyle [^java.lang.String name]
    (SignStyle/valueOf name)))

