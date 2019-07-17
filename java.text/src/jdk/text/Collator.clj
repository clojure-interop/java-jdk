(ns jdk.text.Collator
  "The Collator class performs locale-sensitive
  String comparison. You use this class to build
  searching and sorting routines for natural language text.


  Collator is an abstract base class. Subclasses
  implement specific collation strategies. One subclass,
  RuleBasedCollator, is currently provided with
  the Java Platform and is applicable to a wide set of languages. Other
  subclasses may be created to handle more specialized needs.


  Like other locale-sensitive classes, you can use the static
  factory method, getInstance, to obtain the appropriate
  Collator object for a given locale. You will only need
  to look at the subclasses of Collator if you need
  to understand the details of a particular collation strategy or
  if you need to modify that strategy.


  The following example shows how to compare two strings using
  the Collator for the default locale.



  // Compare two strings in the default locale
  Collator myCollator = Collator.getInstance();
  if( myCollator.compare(`abc`, `ABC`) < 0 )
      System.out.println(`abc is less than ABC`);
  else
      System.out.println(`abc is greater than or equal to ABC`);



  You can set a Collator's strength property
  to determine the level of difference considered significant in
  comparisons. Four strengths are provided: PRIMARY,
  SECONDARY, TERTIARY, and IDENTICAL.
  The exact assignment of strengths to language features is
  locale dependant.  For example, in Czech, `e` and `f` are considered
  primary differences, while `e` and `ě` are secondary differences,
  `e` and `E` are tertiary differences and `e` and `e` are identical.
  The following shows how both case and accents could be ignored for
  US English.



  //Get the Collator for US English and set its strength to PRIMARY
  Collator usCollator = Collator.getInstance(Locale.US);
  usCollator.setStrength(Collator.PRIMARY);
  if( usCollator.compare(`abc`, `ABC`) == 0 ) {
      System.out.println(`Strings are equivalent`);
  }


  For comparing Strings exactly once, the compare
  method provides the best performance. When sorting a list of
  Strings however, it is generally necessary to compare each
  String multiple times. In this case, CollationKeys
  provide better performance. The CollationKey class converts
  a String to a series of bits that can be compared bitwise
  against other CollationKeys. A CollationKey is
  created by a Collator object for a given String.

  Note: CollationKeys from different
  Collators can not be compared. See the class description
  for CollationKey
  for an example using CollationKeys."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text Collator]))

(def *-primary
  "Static Constant.

  Collator strength value.  When set, only PRIMARY differences are
   considered significant during comparison. The assignment of strengths
   to language features is locale dependant. A common example is for
   different base letters (`a` vs `b`) to be considered a PRIMARY difference.

  type: int"
  Collator/PRIMARY)

(def *-secondary
  "Static Constant.

  Collator strength value.  When set, only SECONDARY and above differences are
   considered significant during comparison. The assignment of strengths
   to language features is locale dependant. A common example is for
   different accented forms of the same base letter (`a` vs `�`) to be
   considered a SECONDARY difference.

  type: int"
  Collator/SECONDARY)

(def *-tertiary
  "Static Constant.

  Collator strength value.  When set, only TERTIARY and above differences are
   considered significant during comparison. The assignment of strengths
   to language features is locale dependant. A common example is for
   case differences (`a` vs `A`) to be considered a TERTIARY difference.

  type: int"
  Collator/TERTIARY)

(def *-identical
  "Static Constant.

  Collator strength value.  When set, all differences are
   considered significant during comparison. The assignment of strengths
   to language features is locale dependant. A common example is for control
   characters (`\u0001` vs `\u0002`) to be considered equal at the
   PRIMARY, SECONDARY, and TERTIARY levels but different at the IDENTICAL
   level.  Additionally, differences between pre-composed accents such as
   `\u00C0` (A-grave) and combining accents such as `A\u0300`
   (A, combining-grave) will be considered significant at the IDENTICAL
   level if decomposition is set to NO_DECOMPOSITION.

  type: int"
  Collator/IDENTICAL)

(def *-no-decomposition
  "Static Constant.

  Decomposition mode value. With NO_DECOMPOSITION
   set, accented characters will not be decomposed for collation. This
   is the default setting and provides the fastest collation but
   will only produce correct results for languages that do not use accents.

  type: int"
  Collator/NO_DECOMPOSITION)

(def *-canonical-decomposition
  "Static Constant.

  Decomposition mode value. With CANONICAL_DECOMPOSITION
   set, characters that are canonical variants according to Unicode
   standard will be decomposed for collation. This should be used to get
   correct collation of accented characters.

   CANONICAL_DECOMPOSITION corresponds to Normalization Form D as
   described in
   Unicode
   Technical Report #15.

  type: int"
  Collator/CANONICAL_DECOMPOSITION)

(def *-full-decomposition
  "Static Constant.

  Decomposition mode value. With FULL_DECOMPOSITION
   set, both Unicode canonical variants and Unicode compatibility variants
   will be decomposed for collation.  This causes not only accented
   characters to be collated, but also characters that have special formats
   to be collated with their norminal form. For example, the half-width and
   full-width ASCII and Katakana characters are then collated together.
   FULL_DECOMPOSITION is the most complete and therefore the slowest
   decomposition mode.

   FULL_DECOMPOSITION corresponds to Normalization Form KD as
   described in
   Unicode
   Technical Report #15.

  type: int"
  Collator/FULL_DECOMPOSITION)

(defn *get-instance
  "Gets the Collator for the desired locale.

  desired-locale - the desired locale. - `java.util.Locale`

  returns: the Collator for the desired locale. - `java.text.Collator`"
  (^java.text.Collator [^java.util.Locale desired-locale]
    (Collator/getInstance desired-locale))
  (^java.text.Collator []
    (Collator/getInstance )))

(defn *get-available-locales
  "Returns an array of all locales for which the
   getInstance methods of this class can return
   localized instances.
   The returned array represents the union of locales supported
   by the Java runtime and by installed
   CollatorProvider implementations.
   It must contain at least a Locale instance equal to
   Locale.US.

  returns: An array of locales for which localized
           Collator instances are available. - `java.util.Locale[]`"
  ([]
    (Collator/getAvailableLocales )))

(defn compare
  "Compares the source string to the target string according to the
   collation rules for this Collator.  Returns an integer less than,
   equal to or greater than zero depending on whether the source String is
   less than, equal to or greater than the target string.  See the Collator
   class description for an example of use.

   For a one time comparison, this method has the best performance. If a
   given String will be involved in multiple comparisons, CollationKey.compareTo
   has the best performance. See the Collator class description for an example
   using CollationKeys.

  source - the source string. - `java.lang.String`
  target - the target string. - `java.lang.String`

  returns: Returns an integer value. Value is less than zero if source is less than
   target, value is zero if source and target are equal, value is greater than zero
   if source is greater than target. - `int`"
  (^Integer [^java.text.Collator this ^java.lang.String source ^java.lang.String target]
    (-> this (.compare source target))))

(defn get-decomposition
  "Get the decomposition mode of this Collator. Decomposition mode
   determines how Unicode composed characters are handled. Adjusting
   decomposition mode allows the user to select between faster and more
   complete collation behavior.
   The three values for decomposition mode are:

   NO_DECOMPOSITION,
   CANONICAL_DECOMPOSITION
   FULL_DECOMPOSITION.

   See the documentation for these three constants for a description
   of their meaning.

  returns: the decomposition mode - `int`"
  (^Integer [^java.text.Collator this]
    (-> this (.getDecomposition))))

(defn set-decomposition
  "Set the decomposition mode of this Collator. See getDecomposition
   for a description of decomposition mode.

  decomposition-mode - the new decomposition mode. - `int`

  throws: java.lang.IllegalArgumentException - If the given value is not a valid decomposition mode."
  ([^java.text.Collator this ^Integer decomposition-mode]
    (-> this (.setDecomposition decomposition-mode))))

(defn get-collation-key
  "Transforms the String into a series of bits that can be compared bitwise
   to other CollationKeys. CollationKeys provide better performance than
   Collator.compare when Strings are involved in multiple comparisons.
   See the Collator class description for an example using CollationKeys.

  source - the string to be transformed into a collation key. - `java.lang.String`

  returns: the CollationKey for the given String based on this Collator's collation
   rules. If the source String is null, a null CollationKey is returned. - `java.text.CollationKey`"
  (^java.text.CollationKey [^java.text.Collator this ^java.lang.String source]
    (-> this (.getCollationKey source))))

(defn set-strength
  "Sets this Collator's strength property.  The strength property determines
   the minimum level of difference considered significant during comparison.
   See the Collator class description for an example of use.

  new-strength - the new strength value. - `int`

  throws: java.lang.IllegalArgumentException - If the new strength value is not one of PRIMARY, SECONDARY, TERTIARY or IDENTICAL."
  ([^java.text.Collator this ^Integer new-strength]
    (-> this (.setStrength new-strength))))

(defn clone
  "Overrides Cloneable

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^java.text.Collator this]
    (-> this (.clone))))

(defn hash-code
  "Generates the hash code for this Collator.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.text.Collator this]
    (-> this (.hashCode))))

(defn get-strength
  "Returns this Collator's strength property.  The strength property determines
   the minimum level of difference considered significant during comparison.
   See the Collator class description for an example of use.

  returns: this Collator's current strength property. - `int`"
  (^Integer [^java.text.Collator this]
    (-> this (.getStrength))))

(defn equals
  "Convenience method for comparing the equality of two strings based on
   this Collator's collation rules.

  source - the source string to be compared with. - `java.lang.String`
  target - the target string to be compared with. - `java.lang.String`

  returns: true if the strings are equal according to the collation
   rules.  false, otherwise. - `boolean`"
  (^Boolean [^java.text.Collator this ^java.lang.String source ^java.lang.String target]
    (-> this (.equals source target)))
  (^Boolean [^java.text.Collator this ^java.lang.Object that]
    (-> this (.equals that))))

