(ns jdk.time.format.ResolverStyle
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.format ResolverStyle]))

(def STRICT
  "Enum Constant.

  Style to resolve dates and times strictly.

   Using strict resolution will ensure that all parsed values are within
   the outer range of valid values for the field. Individual fields may
   be further processed for strictness.

   For example, resolving year-month and day-of-month in the ISO calendar
   system using strict mode will ensure that the day-of-month is valid
   for the year-month, rejecting invalid values.

  type: java.time.format.ResolverStyle"
  ResolverStyle/STRICT)

(def SMART
  "Enum Constant.

  Style to resolve dates and times in a smart, or intelligent, manner.

   Using smart resolution will perform the sensible default for each
   field, which may be the same as strict, the same as lenient, or a third
   behavior. Individual fields will interpret this differently.

   For example, resolving year-month and day-of-month in the ISO calendar
   system using smart mode will ensure that the day-of-month is from
   1 to 31, converting any value beyond the last valid day-of-month to be
   the last valid day-of-month.

  type: java.time.format.ResolverStyle"
  ResolverStyle/SMART)

(def LENIENT
  "Enum Constant.

  Style to resolve dates and times leniently.

   Using lenient resolution will resolve the values in an appropriate
   lenient manner. Individual fields will interpret this differently.

   For example, lenient mode allows the month in the ISO calendar system
   to be outside the range 1 to 12.
   For example, month 15 is treated as being 3 months after month 12.

  type: java.time.format.ResolverStyle"
  ResolverStyle/LENIENT)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (ResolverStyle c : ResolverStyle.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.format.ResolverStyle[]`"
  ([]
    (ResolverStyle/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.format.ResolverStyle`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.time.format.ResolverStyle [^java.lang.String name]
    (ResolverStyle/valueOf name)))

