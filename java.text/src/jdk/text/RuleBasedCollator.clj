(ns jdk.text.RuleBasedCollator
  "The RuleBasedCollator class is a concrete subclass of
  Collator that provides a simple, data-driven, table
  collator.  With this class you can create a customized table-based
  Collator.  RuleBasedCollator maps
  characters to sort keys.


  RuleBasedCollator has the following restrictions
  for efficiency (other subclasses may be used for more complex languages) :

  If a special collation rule controlled by a <modifier> is
       specified it applies to the whole collator object.
  All non-mentioned characters are at the end of the
      collation order.



  The collation table is composed of a list of collation rules, where each
  rule is of one of three forms:


     <modifier>
     <relation> <text-argument>
     <reset> <text-argument>
  The definitions of the rule elements is as follows:

     Text-Argument: A text-argument is any sequence of
         characters, excluding special characters (that is, common
         whitespace characters [0009-000D, 0020] and rule syntax characters
         [0021-002F, 003A-0040, 005B-0060, 007B-007E]). If those
         characters are desired, you can put them in single quotes
         (e.g. ampersand => '&'). Note that unquoted white space characters
         are ignored; e.g. b c is treated as bc.
     Modifier: There are currently two modifiers that
         turn on special collation rules.

             '@' : Turns on backwards sorting of accents (secondary
                       differences), as in French.
             '!' : Turns on Thai/Lao vowel-consonant swapping.  If this
                       rule is in force when a Thai vowel of the range
                       \U0E40-\U0E44 precedes a Thai consonant of the range
                       \U0E01-\U0E2E OR a Lao vowel of the range \U0EC0-\U0EC4
                       precedes a Lao consonant of the range \U0E81-\U0EAE then
                       the vowel is placed after the consonant for collation
                       purposes.

         '@' : Indicates that accents are sorted backwards, as in French.
     Relation: The relations are the following:

             '<' : Greater, as a letter difference (primary)
             ';' : Greater, as an accent difference (secondary)
             ',' : Greater, as a case difference (tertiary)
             '=' : Equal

     Reset: There is a single reset
         which is used primarily for contractions and expansions, but which
         can also be used to add a modification at the end of a set of rules.
         '&' : Indicates that the next rule follows the position to where
             the reset text-argument would be sorted.



  This sounds more complicated than it is in practice. For example, the
  following are equivalent ways of expressing the same thing:



  a < b < c
  a < b & b < c
  a < c & a < b

  Notice that the order is important, as the subsequent item goes immediately
  after the text-argument. The following are not equivalent:



  a < b & a < c
  a < c & a < b

  Either the text-argument must already be present in the sequence, or some
  initial substring of the text-argument must be present. (e.g. `a < b & ae <
  e` is valid since `a` is present in the sequence before `ae` is reset). In
  this latter case, `ae` is not entered and treated as a single character;
  instead, `e` is sorted as if it were expanded to two characters: `a`
  followed by an `e`. This difference appears in natural languages: in
  traditional Spanish `ch` is treated as though it contracts to a single
  character (expressed as `c < ch < d`), while in traditional German
  a-umlaut is treated as though it expanded to two characters
  (expressed as `a,A < b,B ... &ae;\u00e3&AE;\u00c3`).
  [\u00e3 and \u00c3 are, of course, the escape sequences for a-umlaut.]

  Ignorable Characters

  For ignorable characters, the first rule must start with a relation (the
  examples we have used above are really fragments; `a < b` really should be
  `< a < b`). If, however, the first relation is not `<`, then all the all
  text-arguments up to the first `<` are ignorable. For example, `, - < a < b`
  makes `-` an ignorable character, as we saw earlier in the word
  `black-birds`. In the samples for different languages, you see that most
  accents are ignorable.

  Normalization and Accents

  RuleBasedCollator automatically processes its rule table to
  include both pre-composed and combining-character versions of
  accented characters.  Even if the provided rule string contains only
  base characters and separate combining accent characters, the pre-composed
  accented characters matching all canonical combinations of characters from
  the rule string will be entered in the table.

  This allows you to use a RuleBasedCollator to compare accented strings
  even when the collator is set to NO_DECOMPOSITION.  There are two caveats,
  however.  First, if the strings to be collated contain combining
  sequences that may not be in canonical order, you should set the collator to
  CANONICAL_DECOMPOSITION or FULL_DECOMPOSITION to enable sorting of
  combining sequences.  Second, if the strings contain characters with
  compatibility decompositions (such as full-width and half-width forms),
  you must use FULL_DECOMPOSITION, since the rule tables only include
  canonical mappings.

  Errors

  The following are errors:

      A text-argument contains unquoted punctuation symbols
         (e.g. `a < b-c < d`).
      A relation or reset character not followed by a text-argument
         (e.g. `a < ,b`).
      A reset where the text-argument (or an initial substring of the
          text-argument) is not already in the sequence.
          (e.g. `a < b & e < f`)

  If you produce one of these errors, a RuleBasedCollator throws
  a ParseException.

  Examples
  Simple:     `< a < b < c < d`
  Norwegian:  `< a, A < b, B < c, C < d, D < e, E < f, F
                  < g, G < h, H < i, I < j, J < k, K < l, L
                  < m, M < n, N < o, O < p, P < q, Q < r, R
                  < s, S < t, T < u, U < v, V < w, W < x, X
                  < y, Y < z, Z
                  < \u00E6, \u00C6
                  < \u00F8, \u00D8
                  < \u00E5 = a\u030A, \u00C5 = A\u030A;
                       aa, AA`


  To create a RuleBasedCollator object with specialized
  rules tailored to your needs, you construct the RuleBasedCollator
  with the rules contained in a String object. For example:



  String simple = `< a< b< c< d`;
  RuleBasedCollator mySimple = new RuleBasedCollator(simple);

  Or:



  String Norwegian = `< a, A < b, B < c, C < d, D < e, E < f, F < g, G < h, H < i, I`
                     `< j, J < k, K < l, L < m, M < n, N < o, O < p, P < q, Q < r, R`
                     `< s, S < t, T < u, U < v, V < w, W < x, X < y, Y < z, Z`
                     `< \u00E6, \u00C6`      // Latin letter ae & AE
                     `< \u00F8, \u00D8`      // Latin letter o & O with stroke
                     `< \u00E5 = a\u030A,`   // Latin letter a with ring above
                     `  \u00C5 = A\u030A;`   // Latin letter A with ring above
                     `  aa, AA`;
  RuleBasedCollator myNorwegian = new RuleBasedCollator(Norwegian);



  A new collation rules string can be created by concatenating rules
  strings. For example, the rules returned by getRules() could
  be concatenated to combine multiple RuleBasedCollators.


  The following example demonstrates how to change the order of
  non-spacing accents,



  // old rule
  String oldRules = `=\u0301;\u0300;\u0302;\u0308`    // main accents
                   `;\u0327;\u0303;\u0304;\u0305`    // main accents
                   `;\u0306;\u0307;\u0309;\u030A`    // main accents
                   `;\u030B;\u030C;\u030D;\u030E`    // main accents
                   `;\u030F;\u0310;\u0311;\u0312`    // main accents
                   `< a , A ; ae, AE ; \u00e6 , \u00c6`
                   `< b , B < c, C < e, E & C < d, D`;
  // change the order of accent characters
  String addOn = `& \u0300 ; \u0308 ; \u0302`;
  RuleBasedCollator myCollator = new RuleBasedCollator(oldRules  addOn);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text RuleBasedCollator]))

(defn ->rule-based-collator
  "Constructor.

  RuleBasedCollator constructor.  This takes the table rules and builds
   a collation table out of them.  Please see RuleBasedCollator class
   description for more details on the collation rule syntax.

  rules - the collation rules to build the collation table from. - `java.lang.String`

  throws: java.text.ParseException - A format exception will be thrown if the build process of the rules fails. For example, build rule `a < ? < d` will cause the constructor to throw the ParseException because the '?' is not quoted."
  ([^java.lang.String rules]
    (new RuleBasedCollator rules)))

(defn get-rules
  "Gets the table-based rules for the collation object.

  returns: returns the collation rules that the table collation object
   was created from. - `java.lang.String`"
  (^java.lang.String [^java.text.RuleBasedCollator this]
    (-> this (.getRules))))

(defn get-collation-element-iterator
  "Returns a CollationElementIterator for the given String.

  source - the string to be collated - `java.lang.String`

  returns: a CollationElementIterator object - `java.text.CollationElementIterator`"
  (^java.text.CollationElementIterator [^java.text.RuleBasedCollator this ^java.lang.String source]
    (-> this (.getCollationElementIterator source))))

(defn compare
  "Compares the character data stored in two different strings based on the
   collation rules.  Returns information about whether a string is less
   than, greater than or equal to another string in a language.
   This can be overriden in a subclass.

  source - the source string. - `java.lang.String`
  target - the target string. - `java.lang.String`

  returns: Returns an integer value. Value is less than zero if source is less than
   target, value is zero if source and target are equal, value is greater than zero
   if source is greater than target. - `int`

  throws: java.lang.NullPointerException - if source or target is null."
  (^Integer [^java.text.RuleBasedCollator this ^java.lang.String source ^java.lang.String target]
    (-> this (.compare source target))))

(defn get-collation-key
  "Transforms the string into a series of characters that can be compared
   with CollationKey.compareTo. This overrides java.text.Collator.getCollationKey.
   It can be overriden in a subclass.

  source - the string to be transformed into a collation key. - `java.lang.String`

  returns: the CollationKey for the given String based on this Collator's collation
   rules. If the source String is null, a null CollationKey is returned. - `java.text.CollationKey`"
  (^java.text.CollationKey [^java.text.RuleBasedCollator this ^java.lang.String source]
    (-> this (.getCollationKey source))))

(defn clone
  "Standard override; no change in semantics.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^java.text.RuleBasedCollator this]
    (-> this (.clone))))

(defn equals
  "Compares the equality of two collation objects.

  obj - the table-based collation object to be compared with this. - `java.lang.Object`

  returns: true if the current table-based collation object is the same
   as the table-based collation object obj; false otherwise. - `boolean`"
  (^Boolean [^java.text.RuleBasedCollator this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Generates the hash code for the table-based collation object

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.text.RuleBasedCollator this]
    (-> this (.hashCode))))

