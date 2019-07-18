(ns jdk.time.format.DecimalStyle
  "Localized decimal style used in date and time formatting.

  A significant part of dealing with dates and times is the localization.
  This class acts as a central point for accessing the information."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.format DecimalStyle]))

(def *-standard
  "Static Constant.

  The standard set of non-localized decimal style symbols.

   This uses standard ASCII characters for zero, positive, negative and a dot for the decimal point.

  type: java.time.format.DecimalStyle"
  DecimalStyle/STANDARD)

(defn *get-available-locales
  "Lists all the locales that are supported.

   The locale 'en_US' will always be present.

  returns: a Set of Locales for which localization is supported - `java.util.Set<java.util.Locale>`"
  (^java.util.Set []
    (DecimalStyle/getAvailableLocales )))

(defn *of-default-locale
  "Obtains the DecimalStyle for the default
   FORMAT locale.

   This method provides access to locale sensitive decimal style symbols.

   This is equivalent to calling
   of(Locale.getDefault(Locale.Category.FORMAT)).

  returns: the decimal style, not null - `java.time.format.DecimalStyle`"
  (^java.time.format.DecimalStyle []
    (DecimalStyle/ofDefaultLocale )))

(defn *of
  "Obtains the DecimalStyle for the specified locale.

   This method provides access to locale sensitive decimal style symbols.

  locale - the locale, not null - `java.util.Locale`

  returns: the decimal style, not null - `java.time.format.DecimalStyle`"
  (^java.time.format.DecimalStyle [^java.util.Locale locale]
    (DecimalStyle/of locale)))

(defn with-decimal-separator
  "Returns a copy of the info with a new character that represents the decimal point.

   The character used to represent a decimal point may vary by culture.
   This method specifies the character to use.

  decimal-separator - the character for the decimal point - `char`

  returns: a copy with a new character that represents the decimal point, not null - `java.time.format.DecimalStyle`"
  (^java.time.format.DecimalStyle [^DecimalStyle this ^Character decimal-separator]
    (-> this (.withDecimalSeparator decimal-separator))))

(defn with-positive-sign
  "Returns a copy of the info with a new character that represents the positive sign.

   The character used to represent a positive number may vary by culture.
   This method specifies the character to use.

  positive-sign - the character for the positive sign - `char`

  returns: a copy with a new character that represents the positive sign, not null - `java.time.format.DecimalStyle`"
  (^java.time.format.DecimalStyle [^DecimalStyle this ^Character positive-sign]
    (-> this (.withPositiveSign positive-sign))))

(defn get-decimal-separator
  "Gets the character that represents the decimal point.

   The character used to represent a decimal point may vary by culture.
   This method specifies the character to use.

  returns: the character for the decimal point - `char`"
  (^Character [^DecimalStyle this]
    (-> this (.getDecimalSeparator))))

(defn with-zero-digit
  "Returns a copy of the info with a new character that represents zero.

   The character used to represent digits may vary by culture.
   This method specifies the zero character to use, which implies the characters for one to nine.

  zero-digit - the character for zero - `char`

  returns: a copy with a new character that represents zero, not null - `java.time.format.DecimalStyle`"
  (^java.time.format.DecimalStyle [^DecimalStyle this ^Character zero-digit]
    (-> this (.withZeroDigit zero-digit))))

(defn to-string
  "Returns a string describing this DecimalStyle.

  returns: a string description, not null - `java.lang.String`"
  (^java.lang.String [^DecimalStyle this]
    (-> this (.toString))))

(defn get-zero-digit
  "Gets the character that represents zero.

   The character used to represent digits may vary by culture.
   This method specifies the zero character to use, which implies the characters for one to nine.

  returns: the character for zero - `char`"
  (^Character [^DecimalStyle this]
    (-> this (.getZeroDigit))))

(defn with-negative-sign
  "Returns a copy of the info with a new character that represents the negative sign.

   The character used to represent a negative number may vary by culture.
   This method specifies the character to use.

  negative-sign - the character for the negative sign - `char`

  returns: a copy with a new character that represents the negative sign, not null - `java.time.format.DecimalStyle`"
  (^java.time.format.DecimalStyle [^DecimalStyle this ^Character negative-sign]
    (-> this (.withNegativeSign negative-sign))))

(defn get-positive-sign
  "Gets the character that represents the positive sign.

   The character used to represent a positive number may vary by culture.
   This method specifies the character to use.

  returns: the character for the positive sign - `char`"
  (^Character [^DecimalStyle this]
    (-> this (.getPositiveSign))))

(defn hash-code
  "A hash code for this DecimalStyle.

  returns: a suitable hash code - `int`"
  (^Integer [^DecimalStyle this]
    (-> this (.hashCode))))

(defn get-negative-sign
  "Gets the character that represents the negative sign.

   The character used to represent a negative number may vary by culture.
   This method specifies the character to use.

  returns: the character for the negative sign - `char`"
  (^Character [^DecimalStyle this]
    (-> this (.getNegativeSign))))

(defn equals
  "Checks if this DecimalStyle is equal to another DecimalStyle.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other date - `boolean`"
  (^Boolean [^DecimalStyle this ^java.lang.Object obj]
    (-> this (.equals obj))))

