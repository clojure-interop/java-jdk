(ns jdk.util.StringJoiner
  "StringJoiner is used to construct a sequence of characters separated
  by a delimiter and optionally starting with a supplied prefix
  and ending with a supplied suffix.

  Prior to adding something to the StringJoiner, its
  sj.toString() method will, by default, return prefix  suffix.
  However, if the setEmptyValue method is called, the emptyValue
  supplied will be returned instead. This can be used, for example, when
  creating a string using set notation to indicate an empty set, i.e.
  `{}`, where the prefix is `{`, the
  suffix is `}` and nothing has been added to the
  StringJoiner."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util StringJoiner]))

(defn ->string-joiner
  "Constructor.

  Constructs a StringJoiner with no characters in it using copies
   of the supplied prefix, delimiter and suffix.
   If no characters are added to the StringJoiner and methods
   accessing the string value of it are invoked, it will return the
   prefix  suffix (or properties thereof) in the result, unless
   setEmptyValue has first been called.

  delimiter - the sequence of characters to be used between each element added to the StringJoiner - `java.lang.CharSequence`
  prefix - the sequence of characters to be used at the beginning - `java.lang.CharSequence`
  suffix - the sequence of characters to be used at the end - `java.lang.CharSequence`

  throws: java.lang.NullPointerException - if prefix, delimiter, or suffix is null"
  ([^java.lang.CharSequence delimiter ^java.lang.CharSequence prefix ^java.lang.CharSequence suffix]
    (new StringJoiner delimiter prefix suffix))
  ([^java.lang.CharSequence delimiter]
    (new StringJoiner delimiter)))

(defn set-empty-value
  "Sets the sequence of characters to be used when determining the string
   representation of this StringJoiner and no elements have been
   added yet, that is, when it is empty.  A copy of the emptyValue
   parameter is made for this purpose. Note that once an add method has been
   called, the StringJoiner is no longer considered empty, even if
   the element(s) added correspond to the empty String.

  empty-value - the characters to return as the value of an empty StringJoiner - `java.lang.CharSequence`

  returns: this StringJoiner itself so the calls may be chained - `java.util.StringJoiner`

  throws: java.lang.NullPointerException - when the emptyValue parameter is null"
  (^java.util.StringJoiner [^java.util.StringJoiner this ^java.lang.CharSequence empty-value]
    (-> this (.setEmptyValue empty-value))))

(defn to-string
  "Returns the current value, consisting of the prefix, the values
   added so far separated by the delimiter, and the suffix,
   unless no elements have been added in which case, the
   prefix  suffix or the emptyValue characters are returned

  returns: the string representation of this StringJoiner - `java.lang.String`"
  (^java.lang.String [^java.util.StringJoiner this]
    (-> this (.toString))))

(defn add
  "Adds a copy of the given CharSequence value as the next
   element of the StringJoiner value. If newElement is
   null, then `null` is added.

  new-element - The element to add - `java.lang.CharSequence`

  returns: a reference to this StringJoiner - `java.util.StringJoiner`"
  (^java.util.StringJoiner [^java.util.StringJoiner this ^java.lang.CharSequence new-element]
    (-> this (.add new-element))))

(defn merge
  "Adds the contents of the given StringJoiner without prefix and
   suffix as the next element if it is non-empty. If the given StringJoiner is empty, the call has no effect.

   A StringJoiner is empty if add()
   has never been called, and if merge() has never been called
   with a non-empty StringJoiner argument.

   If the other StringJoiner is using a different delimiter,
   then elements from the other StringJoiner are concatenated with
   that delimiter and the result is appended to this StringJoiner
   as a single element.

  other - The StringJoiner whose contents should be merged into this one - `java.util.StringJoiner`

  returns: This StringJoiner - `java.util.StringJoiner`

  throws: java.lang.NullPointerException - if the other StringJoiner is null"
  (^java.util.StringJoiner [^java.util.StringJoiner this ^java.util.StringJoiner other]
    (-> this (.merge other))))

(defn length
  "Returns the length of the String representation
   of this StringJoiner. Note that if
   no add methods have been called, then the length of the String
   representation (either prefix  suffix or emptyValue)
   will be returned. The value should be equivalent to
   toString().length().

  returns: the length of the current value of StringJoiner - `int`"
  (^Integer [^java.util.StringJoiner this]
    (-> this (.length))))

