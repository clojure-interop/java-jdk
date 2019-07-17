(ns jdk.util.Locale$LanguageRange
  "This class expresses a Language Range defined in
  RFC 4647 Matching of
  Language Tags. A language range is an identifier which is used to
  select language tag(s) meeting specific requirements by using the
  mechanisms described in Locale
  Matching. A list which represents a user's preferences and consists
  of language ranges is called a Language Priority List.

  There are two types of language ranges: basic and extended. In RFC
  4647, the syntax of language ranges is expressed in
  ABNF as follows:



      basic-language-range    = (1*8ALPHA *(`-` 1*8alphanum)) / `*`
      extended-language-range = (1*8ALPHA / `*`)
                                *(`-` (1*8alphanum / `*`))
      alphanum                = ALPHA / DIGIT

  For example, `en` (English), `ja-JP` (Japanese, Japan),
  `*` (special language range which matches any language tag) are
  basic language ranges, whereas `*-CH` (any languages,
  Switzerland), `es-*` (Spanish, any regions), and
  `zh-Hant-*` (Traditional Chinese, any regions) are extended
  language ranges."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Locale$LanguageRange]))

(defn ->language-range
  "Constructor.

  Constructs a LanguageRange using the given range and
   weight. Note that no validation is done against the IANA
   Language Subtag Registry at time of construction.

  range - a language range - `java.lang.String`
  weight - a weight value between MIN_WEIGHT and MAX_WEIGHT - `double`

  throws: java.lang.NullPointerException - if the given range is null"
  ([range weight]
    (new Locale$LanguageRange range weight))
  ([range]
    (new Locale$LanguageRange range)))

(def *-max-weight
  "Static Constant.

  A constant holding the maximum value of weight, 1.0, which indicates
   that the language range is a good fit for the user.

  type: double"
  Locale$LanguageRange/MAX_WEIGHT)

(def *-min-weight
  "Static Constant.

  A constant holding the minimum value of weight, 0.0, which indicates
   that the language range is not a good fit for the user.

  type: double"
  Locale$LanguageRange/MIN_WEIGHT)

(defn *parse
  "Parses the given ranges to generate a Language Priority
   List, and then customizes the list using the given map.
   This method is equivalent to
   mapEquivalents(parse(ranges), map).

  ranges - a list of comma-separated language ranges or a list of language ranges in the form of the `Accept-Language` header defined in RFC 2616 - `java.lang.String`
  map - a map containing information to customize language ranges - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`

  returns: a Language Priority List with customization. The list is
       modifiable. - `java.util.List<java.util.Locale.LanguageRange>`

  throws: java.lang.NullPointerException - if ranges is null"
  ([ranges map]
    (Locale$LanguageRange/parse ranges map))
  ([ranges]
    (Locale$LanguageRange/parse ranges)))

(defn *map-equivalents
  "Generates a new customized Language Priority List using the given
   priorityList and map. If the given map is
   empty, this method returns a copy of the given priorityList.

   In the map, a key represents a language range whereas a value is
   a list of equivalents of it. '*' cannot be used in the map.
   Each equivalent language range has the same weight value as its
   original language range.



    An example of map:
      Key                            Value
        `zh` (Chinese)                 `zh`,
                                       `zh-Hans`(Simplified Chinese)
        `zh-HK` (Chinese, Hong Kong)   `zh-HK`
        `zh-TW` (Chinese, Taiwan)      `zh-TW`

   The customization is performed after modification using the IANA
   Language Subtag Registry.

   For example, if a user's Language Priority List consists of five
   language ranges (`zh`, `zh-CN`, `en`,
   `zh-TW`, and `zh-HK`), the newly generated Language
   Priority List which is customized using the above map example will
   consists of `zh`, `zh-Hans`, `zh-CN`,
   `zh-Hans-CN`, `en`, `zh-TW`, and
   `zh-HK`.

   `zh-HK` and `zh-TW` aren't converted to
   `zh-Hans-HK` nor `zh-Hans-TW` even if they are
   included in the Language Priority List. In this example, mapping
   is used to clearly distinguish Simplified Chinese and Traditional
   Chinese.

   If the `zh`-to-`zh` mapping isn't included in the
   map, a simple replacement will be performed and the customized list
   won't include `zh` and `zh-CN`.

  priority-list - user's Language Priority List - `java.util.List<java.util.Locale.LanguageRange>`
  map - a map containing information to customize language ranges - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`

  returns: a new Language Priority List with customization. The list is
       modifiable. - `java.util.List<java.util.Locale.LanguageRange>`

  throws: java.lang.NullPointerException - if priorityList is null"
  ([priority-list map]
    (Locale$LanguageRange/mapEquivalents priority-list map)))

(defn get-range
  "Returns the language range of this LanguageRange.

  returns: the language range. - `java.lang.String`"
  ([this]
    (-> this (.getRange))))

(defn get-weight
  "Returns the weight of this LanguageRange.

  returns: the weight value. - `double`"
  ([this]
    (-> this (.getWeight))))

(defn hash-code
  "Returns a hash code value for the object.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn equals
  "Compares this object to the specified object. The result is true if
   and only if the argument is not null and is a
   LanguageRange object that contains the same range
   and weight values as this object.

  obj - the object to compare with - `java.lang.Object`

  returns: true if this object's range and
       weight are the same as the obj's; false
       otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

