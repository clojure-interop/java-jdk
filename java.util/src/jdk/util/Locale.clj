(ns jdk.util.Locale
  "A Locale object represents a specific geographical, political,
  or cultural region. An operation that requires a Locale to perform
  its task is called locale-sensitive and uses the Locale
  to tailor information for the user. For example, displaying a number
  is a locale-sensitive operation— the number should be formatted
  according to the customs and conventions of the user's native country,
  region, or culture.

   The Locale class implements IETF BCP 47 which is composed of
  RFC 4647 `Matching of Language
  Tags` and RFC 5646 `Tags
  for Identifying Languages` with support for the LDML (UTS#35, `Unicode
  Locale Data Markup Language`) BCP 47-compatible extensions for locale data
  exchange.

   A Locale object logically consists of the fields
  described below.


    language

    ISO 639 alpha-2 or alpha-3 language code, or registered
    language subtags up to 8 alpha letters (for future enhancements).
    When a language has both an alpha-2 code and an alpha-3 code, the
    alpha-2 code must be used.  You can find a full list of valid
    language codes in the IANA Language Subtag Registry (search for
    `Type: language`).  The language field is case insensitive, but
    Locale always canonicalizes to lower case.

    Well-formed language values have the form
    [a-zA-Z]{2,8}.  Note that this is not the the full
    BCP47 language production, since it excludes extlang.  They are
    not needed since modern three-letter language codes replace
    them.

    Example: `en` (English), `ja` (Japanese), `kok` (Konkani)

    script

    ISO 15924 alpha-4 script code.  You can find a full list of
    valid script codes in the IANA Language Subtag Registry (search
    for `Type: script`).  The script field is case insensitive, but
    Locale always canonicalizes to title case (the first
    letter is upper case and the rest of the letters are lower
    case).

    Well-formed script values have the form
    [a-zA-Z]{4}

    Example: `Latn` (Latin), `Cyrl` (Cyrillic)

    country (region)

    ISO 3166 alpha-2 country code or UN M.49 numeric-3 area code.
    You can find a full list of valid country and region codes in the
    IANA Language Subtag Registry (search for `Type: region`).  The
    country (region) field is case insensitive, but
    Locale always canonicalizes to upper case.

    Well-formed country/region values have
    the form [a-zA-Z]{2} | [0-9]{3}

    Example: `US` (United States), `FR` (France), `029`
    (Caribbean)

    variant

    Any arbitrary value used to indicate a variation of a
    Locale.  Where there are two or more variant values
    each indicating its own semantics, these values should be ordered
    by importance, with most important first, separated by
    underscore('_').  The variant field is case sensitive.

    Note: IETF BCP 47 places syntactic restrictions on variant
    subtags.  Also BCP 47 subtags are strictly used to indicate
    additional variations that define a language or its dialects that
    are not covered by any combinations of language, script and
    region subtags.  You can find a full list of valid variant codes
    in the IANA Language Subtag Registry (search for `Type: variant`).

    However, the variant field in Locale has
    historically been used for any kind of variation, not just
    language variations.  For example, some supported variants
    available in Java SE Runtime Environments indicate alternative
    cultural behaviors such as calendar type or number script.  In
    BCP 47 this kind of information, which does not identify the
    language, is supported by extension subtags or private use
    subtags.

    Well-formed variant values have the form SUBTAG
    (('_'|'-') SUBTAG)* where SUBTAG =
    [0-9][0-9a-zA-Z]{3} | [0-9a-zA-Z]{5,8}. (Note: BCP 47 only
    uses hyphen ('-') as a delimiter, this is more lenient).

    Example: `polyton` (Polytonic Greek), `POSIX`

    extensions

    A map from single character keys to string values, indicating
    extensions apart from language identification.  The extensions in
    Locale implement the semantics and syntax of BCP 47
    extension subtags and private use subtags. The extensions are
    case insensitive, but Locale canonicalizes all
    extension keys and values to lower case. Note that extensions
    cannot have empty values.

    Well-formed keys are single characters from the set
    [0-9a-zA-Z].  Well-formed values have the form
    SUBTAG ('-' SUBTAG)* where for the key 'x'
    SUBTAG = [0-9a-zA-Z]{1,8} and for other keys
    SUBTAG = [0-9a-zA-Z]{2,8} (that is, 'x' allows
    single-character subtags).

    Example: key=`u`/value=`ca-japanese` (Japanese Calendar),
    key=`x`/value=`java-1-7`


  Note: Although BCP 47 requires field values to be registered
  in the IANA Language Subtag Registry, the Locale class
  does not provide any validation features.  The Builder
  only checks if an individual field satisfies the syntactic
  requirement (is well-formed), but does not validate the value
  itself.  See Locale.Builder for details.

  Unicode locale/language extension

  UTS#35, `Unicode Locale Data Markup Language` defines optional
  attributes and keywords to override or refine the default behavior
  associated with a locale.  A keyword is represented by a pair of
  key and type.  For example, `nu-thai` indicates that Thai local
  digits (value:`thai`) should be used for formatting numbers
  (key:`nu`).

  The keywords are mapped to a BCP 47 extension value using the
  extension key 'u' (UNICODE_LOCALE_EXTENSION).  The above
  example, `nu-thai`, becomes the extension `u-nu-thai`.code

  Thus, when a Locale object contains Unicode locale
  attributes and keywords,
  getExtension(UNICODE_LOCALE_EXTENSION) will return a
  String representing this information, for example, `nu-thai`.  The
  Locale class also provides getUnicodeLocaleAttributes(), getUnicodeLocaleKeys(), and
  getUnicodeLocaleType(java.lang.String) which allow you to access Unicode
  locale attributes and key/type pairs directly.  When represented as
  a string, the Unicode Locale Extension lists attributes
  alphabetically, followed by key/type sequences with keys listed
  alphabetically (the order of subtags comprising a key's type is
  fixed when the type is defined)

  A well-formed locale key has the form
  [0-9a-zA-Z]{2}.  A well-formed locale type has the
  form `` | [0-9a-zA-Z]{3,8} ('-' [0-9a-zA-Z]{3,8})* (it
  can be empty, or a series of subtags 3-8 alphanums in length).  A
  well-formed locale attribute has the form
  [0-9a-zA-Z]{3,8} (it is a single subtag with the same
  form as a locale type subtag).

  The Unicode locale extension specifies optional behavior in
  locale-sensitive services.  Although the LDML specification defines
  various keys and values, actual locale-sensitive service
  implementations in a Java Runtime Environment might not support any
  particular Unicode locale attributes or key/type pairs.

  Creating a Locale

  There are several different ways to create a Locale
  object.

  Builder

  Using Locale.Builder you can construct a Locale object
  that conforms to BCP 47 syntax.

  Constructors

  The Locale class provides three constructors:



      Locale(String language)
      Locale(String language, String country)
      Locale(String language, String country, String variant)

  These constructors allow you to create a Locale object
  with language, country and variant, but you cannot specify
  script or extensions.

  Factory Methods

  The method forLanguageTag(java.lang.String) creates a Locale
  object for a well-formed BCP 47 language tag.

  Locale Constants

  The Locale class provides a number of convenient constants
  that you can use to create Locale objects for commonly used
  locales. For example, the following creates a Locale object
  for the United States:



      Locale.US


  Locale Matching

  If an application or a system is internationalized and provides localized
  resources for multiple locales, it sometimes needs to find one or more
  locales (or language tags) which meet each user's specific preferences. Note
  that a term `language tag` is used interchangeably with `locale` in this
  locale matching documentation.

  In order to do matching a user's preferred locales to a set of language
  tags, RFC 4647 Matching of
  Language Tags defines two mechanisms: filtering and lookup.
  Filtering is used to get all matching locales, whereas
  lookup is to choose the best matching locale.
  Matching is done case-insensitively. These matching mechanisms are described
  in the following sections.

  A user's preference is called a Language Priority List and is
  expressed as a list of language ranges. There are syntactically two types of
  language ranges: basic and extended. See
  Locale.LanguageRange for details.

  Filtering

  The filtering operation returns all matching language tags. It is defined
  in RFC 4647 as follows:
  `In filtering, each language range represents the least specific language
  tag (that is, the language tag with fewest number of subtags) that is an
  acceptable match. All of the language tags in the matching set of tags will
  have an equal or greater number of subtags than the language range. Every
  non-wildcard subtag in the language range will appear in every one of the
  matching language tags.`

  There are two types of filtering: filtering for basic language ranges
  (called `basic filtering`) and filtering for extended language ranges
  (called `extended filtering`). They may return different results by what
  kind of language ranges are included in the given Language Priority List.
  Locale.FilteringMode is a parameter to specify how filtering should
  be done.

  Lookup

  The lookup operation returns the best matching language tags. It is
  defined in RFC 4647 as follows:
  `By contrast with filtering, each language range represents the most
  specific tag that is an acceptable match.  The first matching tag found,
  according to the user's priority, is considered the closest match and is the
  item returned.`

  For example, if a Language Priority List consists of two language ranges,
  `zh-Hant-TW` and `en-US`, in prioritized order, lookup
  method progressively searches the language tags below in order to find the
  best matching language tag.



     1. zh-Hant-TW
     2. zh-Hant
     3. zh
     4. en-US
     5. en

  If there is a language tag which matches completely to a language range
  above, the language tag is returned.

  `*` is the special language range, and it is ignored in lookup.

  If multiple language tags match as a result of the subtag '*'
  included in a language range, the first matching language tag returned by
  an Iterator over a Collection of language tags is treated as
  the best matching one.

  Use of Locale

  Once you've created a Locale you can query it for information
  about itself. Use getCountry to get the country (or region)
  code and getLanguage to get the language code.
  You can use getDisplayCountry to get the
  name of the country suitable for displaying to the user. Similarly,
  you can use getDisplayLanguage to get the name of
  the language suitable for displaying to the user. Interestingly,
  the getDisplayXXX methods are themselves locale-sensitive
  and have two versions: one that uses the default
  DISPLAY locale and one
  that uses the locale specified as an argument.

  The Java Platform provides a number of classes that perform locale-sensitive
  operations. For example, the NumberFormat class formats
  numbers, currency, and percentages in a locale-sensitive manner. Classes
  such as NumberFormat have several convenience methods
  for creating a default object of that type. For example, the
  NumberFormat class provides these three convenience methods
  for creating a default NumberFormat object:



      NumberFormat.getInstance()
      NumberFormat.getCurrencyInstance()
      NumberFormat.getPercentInstance()

  Each of these methods has two variants; one with an explicit locale
  and one without; the latter uses the default
  FORMAT locale:



      NumberFormat.getInstance(myLocale)
      NumberFormat.getCurrencyInstance(myLocale)
      NumberFormat.getPercentInstance(myLocale)

  A Locale is the mechanism for identifying the kind of object
  (NumberFormat) that you would like to get. The locale is
  just a mechanism for identifying objects,
  not a container for the objects themselves.

  Compatibility

  In order to maintain compatibility with existing usage, Locale's
  constructors retain their behavior prior to the Java Runtime
  Environment version 1.7.  The same is largely true for the
  toString method. Thus Locale objects can continue to
  be used as they were. In particular, clients who parse the output
  of toString into language, country, and variant fields can continue
  to do so (although this is strongly discouraged), although the
  variant field will have additional information in it if script or
  extensions are present.

  In addition, BCP 47 imposes syntax restrictions that are not
  imposed by Locale's constructors. This means that conversions
  between some Locales and BCP 47 language tags cannot be made without
  losing information. Thus toLanguageTag cannot
  represent the state of locales whose language, country, or variant
  do not conform to BCP 47.

  Because of these issues, it is recommended that clients migrate
  away from constructing non-conforming locales and use the
  forLanguageTag and Locale.Builder APIs instead.
  Clients desiring a string representation of the complete locale can
  then always rely on toLanguageTag for this purpose.

  Special cases

  For compatibility reasons, two
  non-conforming locales are treated as special cases.  These are
  ja_JP_JP and th_TH_TH. These are ill-formed
  in BCP 47 since the variants are too short. To ease migration to BCP 47,
  these are treated specially during construction.  These two cases (and only
  these) cause a constructor to generate an extension, all other values behave
  exactly as they did prior to Java 7.

  Java has used ja_JP_JP to represent Japanese as used in
  Japan together with the Japanese Imperial calendar. This is now
  representable using a Unicode locale extension, by specifying the
  Unicode locale key ca (for `calendar`) and type
  japanese. When the Locale constructor is called with the
  arguments `ja`, `JP`, `JP`, the extension `u-ca-japanese` is
  automatically added.

  Java has used th_TH_TH to represent Thai as used in
  Thailand together with Thai digits. This is also now representable using
  a Unicode locale extension, by specifying the Unicode locale key
  nu (for `number`) and value thai. When the Locale
  constructor is called with the arguments `th`, `TH`, `TH`, the
  extension `u-nu-thai` is automatically added.

  Serialization

  During serialization, writeObject writes all fields to the output
  stream, including extensions.

  During deserialization, readResolve adds extensions as described
  in Special Cases, only
  for the two cases th_TH_TH and ja_JP_JP.

  Legacy language codes

  Locale's constructor has always converted three language codes to
  their earlier, obsoleted forms: he maps to iw,
  yi maps to ji, and id maps to
  in.  This continues to be the case, in order to not break
  backwards compatibility.

  The APIs added in 1.7 map between the old and new language codes,
  maintaining the old codes internal to Locale (so that
  getLanguage and toString reflect the old
  code), but using the new codes in the BCP 47 language tag APIs (so
  that toLanguageTag reflects the new one). This
  preserves the equivalence between Locales no matter which code or
  API is used to construct them. Java's default resource bundle
  lookup mechanism also implements this mapping, so that resources
  can be named using either convention, see ResourceBundle.Control.

  Three-letter language/country(region) codes

  The Locale constructors have always specified that the language
  and the country param be two characters in length, although in
  practice they have accepted any length.  The specification has now
  been relaxed to allow language codes of two to eight characters and
  country (region) codes of two to three characters, and in
  particular, three-letter language codes and three-digit region
  codes as specified in the IANA Language Subtag Registry.  For
  compatibility, the implementation still does not impose a length
  constraint."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Locale]))

(defn ->locale
  "Constructor.

  Construct a locale from language, country and variant.
   This constructor normalizes the language value to lowercase and
   the country value to uppercase.

   Note:

   ISO 639 is not a stable standard; some of the language codes it defines
   (specifically `iw`, `ji`, and `in`) have changed.  This constructor accepts both the
   old codes (`iw`, `ji`, and `in`) and the new codes (`he`, `yi`, and `id`), but all other
   API on Locale will return only the OLD codes.
   For backward compatibility reasons, this constructor does not make
   any syntactic checks on the input.
   The two cases (`ja`, `JP`, `JP`) and (`th`, `TH`, `TH`) are handled specially,
   see Special Cases for more information.

  language - An ISO 639 alpha-2 or alpha-3 language code, or a language subtag up to 8 characters in length. See the Locale class description about valid language values. - `java.lang.String`
  country - An ISO 3166 alpha-2 country code or a UN M.49 numeric-3 area code. See the Locale class description about valid country values. - `java.lang.String`
  variant - Any arbitrary value used to indicate a variation of a Locale. See the Locale class description for the details. - `java.lang.String`

  throws: java.lang.NullPointerException - thrown if any argument is null."
  (^Locale [^java.lang.String language ^java.lang.String country ^java.lang.String variant]
    (new Locale language country variant))
  (^Locale [^java.lang.String language ^java.lang.String country]
    (new Locale language country))
  (^Locale [^java.lang.String language]
    (new Locale language)))

(def *-english
  "Static Constant.

  Useful constant for language.

  type: java.util.Locale"
  Locale/ENGLISH)

(def *-french
  "Static Constant.

  Useful constant for language.

  type: java.util.Locale"
  Locale/FRENCH)

(def *-german
  "Static Constant.

  Useful constant for language.

  type: java.util.Locale"
  Locale/GERMAN)

(def *-italian
  "Static Constant.

  Useful constant for language.

  type: java.util.Locale"
  Locale/ITALIAN)

(def *-japanese
  "Static Constant.

  Useful constant for language.

  type: java.util.Locale"
  Locale/JAPANESE)

(def *-korean
  "Static Constant.

  Useful constant for language.

  type: java.util.Locale"
  Locale/KOREAN)

(def *-chinese
  "Static Constant.

  Useful constant for language.

  type: java.util.Locale"
  Locale/CHINESE)

(def *-simplified-chinese
  "Static Constant.

  Useful constant for language.

  type: java.util.Locale"
  Locale/SIMPLIFIED_CHINESE)

(def *-traditional-chinese
  "Static Constant.

  Useful constant for language.

  type: java.util.Locale"
  Locale/TRADITIONAL_CHINESE)

(def *-france
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/FRANCE)

(def *-germany
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/GERMANY)

(def *-italy
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/ITALY)

(def *-japan
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/JAPAN)

(def *-korea
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/KOREA)

(def *-china
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/CHINA)

(def *-prc
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/PRC)

(def *-taiwan
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/TAIWAN)

(def *-uk
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/UK)

(def *-us
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/US)

(def *-canada
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/CANADA)

(def *-canada-french
  "Static Constant.

  Useful constant for country.

  type: java.util.Locale"
  Locale/CANADA_FRENCH)

(def *-root
  "Static Constant.

  Useful constant for the root locale.  The root locale is the locale whose
   language, country, and variant are empty (``) strings.  This is regarded
   as the base locale of all locales, and is used as the language/country
   neutral locale for the locale sensitive operations.

  type: java.util.Locale"
  Locale/ROOT)

(def *-private-use-extension
  "Static Constant.

  The key for the private use extension ('x').

  type: char"
  Locale/PRIVATE_USE_EXTENSION)

(def *-unicode-locale-extension
  "Static Constant.

  The key for Unicode locale extension ('u').

  type: char"
  Locale/UNICODE_LOCALE_EXTENSION)

(defn *set-default
  "Sets the default locale for the specified Category for this instance
   of the Java Virtual Machine. This does not affect the host locale.

   If there is a security manager, its checkPermission method is called
   with a PropertyPermission(`user.language`, `write`) permission before
   the default locale is changed.

   The Java Virtual Machine sets the default locale during startup based
   on the host environment. It is used by many locale-sensitive methods
   if no locale is explicitly specified.

   Since changing the default locale may affect many different areas of
   functionality, this method should only be used if the caller is
   prepared to reinitialize locale-sensitive code running within the
   same Java Virtual Machine.

  category - - the specified category to set the default locale - `java.util.Locale$Category`
  new-locale - - the new default locale - `java.util.Locale`

  throws: java.lang.SecurityException - - if a security manager exists and its checkPermission method doesn't allow the operation."
  ([^java.util.Locale$Category category ^java.util.Locale new-locale]
    (Locale/setDefault category new-locale))
  ([^java.util.Locale new-locale]
    (Locale/setDefault new-locale)))

(defn *for-language-tag
  "Returns a locale for the specified IETF BCP 47 language tag string.

   If the specified language tag contains any ill-formed subtags,
   the first such subtag and all following subtags are ignored.  Compare
   to Locale.Builder.setLanguageTag(java.lang.String) which throws an exception
   in this case.

   The following conversions are performed:

   The language code `und` is mapped to language ``.

   The language codes `he`, `yi`, and `id` are mapped to `iw`,
   `ji`, and `in` respectively. (This is the same canonicalization
   that's done in Locale's constructors.)

   The portion of a private use subtag prefixed by `lvariant`,
   if any, is removed and appended to the variant field in the
   result locale (without case normalization).  If it is then
   empty, the private use subtag is discarded:



       Locale loc;
       loc = Locale.forLanguageTag(`en-US-x-lvariant-POSIX`);
       loc.getVariant(); // returns `POSIX`
       loc.getExtension('x'); // returns null

       loc = Locale.forLanguageTag(`de-POSIX-x-URP-lvariant-Abc-Def`);
       loc.getVariant(); // returns `POSIX_Abc_Def`
       loc.getExtension('x'); // returns `urp`

   When the languageTag argument contains an extlang subtag,
   the first such subtag is used as the language, and the primary
   language subtag and other extlang subtags are ignored:



       Locale.forLanguageTag(`ar-aao`).getLanguage(); // returns `aao`
       Locale.forLanguageTag(`en-abc-def-us`).toString(); // returns `abc_US`

   Case is normalized except for variant tags, which are left
   unchanged.  Language is normalized to lower case, script to
   title case, country to upper case, and extensions to lower
   case.

   If, after processing, the locale would exactly match either
   ja_JP_JP or th_TH_TH with no extensions, the appropriate
   extensions are added as though the constructor had been called:



      Locale.forLanguageTag(`ja-JP-x-lvariant-JP`).toLanguageTag();
      // returns `ja-JP-u-ca-japanese-x-lvariant-JP`
      Locale.forLanguageTag(`th-TH-x-lvariant-TH`).toLanguageTag();
      // returns `th-TH-u-nu-thai-x-lvariant-TH`

   This implements the 'Language-Tag' production of BCP47, and
   so supports grandfathered (regular and irregular) as well as
   private use language tags.  Stand alone private use tags are
   represented as empty language and extension 'x-whatever',
   and grandfathered tags are converted to their canonical replacements
   where they exist.

   Grandfathered tags with canonical replacements are as follows:



   grandfathered tag modern replacement
   art-lojban jbo
   i-ami ami
   i-bnn bnn
   i-hak hak
   i-klingon tlh
   i-lux lb
   i-navajo nv
   i-pwn pwn
   i-tao tao
   i-tay tay
   i-tsu tsu
   no-bok nb
   no-nyn nn
   sgn-BE-FR sfb
   sgn-BE-NL vgt
   sgn-CH-DE sgg
   zh-guoyu cmn
   zh-hakka hak
   zh-min-nan nan
   zh-xiang hsn



   Grandfathered tags with no modern replacement will be
   converted as follows:



   grandfathered tag converts to
   cel-gaulish xtg-x-cel-gaulish
   en-GB-oed en-GB-x-oed
   i-default en-x-i-default
   i-enochian und-x-i-enochian
   i-mingo see-x-i-mingo
   zh-min nan-x-zh-min



   For a list of all grandfathered tags, see the
   IANA Language Subtag Registry (search for `Type: grandfathered`).

   Note: there is no guarantee that toLanguageTag
   and forLanguageTag will round-trip.

  language-tag - the language tag - `java.lang.String`

  returns: The locale that best represents the language tag. - `java.util.Locale`

  throws: java.lang.NullPointerException - if languageTag is null"
  (^java.util.Locale [^java.lang.String language-tag]
    (Locale/forLanguageTag language-tag)))

(defn *lookup-tag
  "Returns the best-matching language tag using the lookup mechanism
   defined in RFC 4647.

  priority-list - user's Language Priority List in which each language tag is sorted in descending order based on priority or weight - `java.util.List`
  tags - language tangs used for matching - `java.util.Collection`

  returns: the best matching language tag chosen based on priority or
       weight, or null if nothing matches. - `java.lang.String`

  throws: java.lang.NullPointerException - if priorityList or tags is null"
  (^java.lang.String [^java.util.List priority-list ^java.util.Collection tags]
    (Locale/lookupTag priority-list tags)))

(defn *lookup
  "Returns a Locale instance for the best-matching language
   tag using the lookup mechanism defined in RFC 4647.

  priority-list - user's Language Priority List in which each language tag is sorted in descending order based on priority or weight - `java.util.List`
  locales - Locale instances used for matching - `java.util.Collection`

  returns: the best matching Locale instance chosen based on
       priority or weight, or null if nothing matches. - `java.util.Locale`

  throws: java.lang.NullPointerException - if priorityList or tags is null"
  (^java.util.Locale [^java.util.List priority-list ^java.util.Collection locales]
    (Locale/lookup priority-list locales)))

(defn *get-default
  "Gets the current value of the default locale for the specified Category
   for this instance of the Java Virtual Machine.

   The Java Virtual Machine sets the default locale during startup based
   on the host environment. It is used by many locale-sensitive methods
   if no locale is explicitly specified. It can be changed using the
   setDefault(Locale.Category, Locale) method.

  category - - the specified category to get the default locale - `java.util.Locale$Category`

  returns: the default locale for the specified Category for this instance
       of the Java Virtual Machine - `java.util.Locale`

  throws: java.lang.NullPointerException - - if category is null"
  (^java.util.Locale [^java.util.Locale$Category category]
    (Locale/getDefault category))
  (^java.util.Locale []
    (Locale/getDefault )))

(defn *filter
  "Returns a list of matching Locale instances using the filtering
   mechanism defined in RFC 4647.

  priority-list - user's Language Priority List in which each language tag is sorted in descending order based on priority or weight - `java.util.List`
  locales - Locale instances used for matching - `java.util.Collection`
  mode - filtering mode - `java.util.Locale$FilteringMode`

  returns: a list of Locale instances for matching language tags
       sorted in descending order based on priority or weight, or an empty
       list if nothing matches. The list is modifiable. - `java.util.List<java.util.Locale>`

  throws: java.lang.NullPointerException - if priorityList or locales is null"
  (^java.util.List [^java.util.List priority-list ^java.util.Collection locales ^java.util.Locale$FilteringMode mode]
    (Locale/filter priority-list locales mode))
  (^java.util.List [^java.util.List priority-list ^java.util.Collection locales]
    (Locale/filter priority-list locales)))

(defn *get-available-locales
  "Returns an array of all installed locales.
   The returned array represents the union of locales supported
   by the Java runtime environment and by installed
   LocaleServiceProvider
   implementations.  It must contain at least a Locale
   instance equal to Locale.US.

  returns: An array of installed locales. - `java.util.Locale[]`"
  ([]
    (Locale/getAvailableLocales )))

(defn *get-iso-countries
  "Returns a list of all 2-letter country codes defined in ISO 3166.
   Can be used to create Locales.

   Note: The Locale class also supports other codes for
   country (region), such as 3-letter numeric UN M.49 area codes.
   Therefore, the list returned by this method does not contain ALL valid
   codes that can be used to create Locales.

  returns: An array of ISO 3166 two-letter country codes. - `java.lang.String[]`"
  ([]
    (Locale/getISOCountries )))

(defn *get-iso-languages
  "Returns a list of all 2-letter language codes defined in ISO 639.
   Can be used to create Locales.

   Note:

   ISO 639 is not a stable standard— some languages' codes have changed.
   The list this function returns includes both the new and the old codes for the
   languages whose codes have changed.
   The Locale class also supports language codes up to
   8 characters in length.  Therefore, the list returned by this method does
   not contain ALL valid codes that can be used to create Locales.

  returns: Am array of ISO 639 two-letter language codes. - `java.lang.String[]`"
  ([]
    (Locale/getISOLanguages )))

(defn *filter-tags
  "Returns a list of matching languages tags using the basic filtering
   mechanism defined in RFC 4647.

  priority-list - user's Language Priority List in which each language tag is sorted in descending order based on priority or weight - `java.util.List`
  tags - language tags - `java.util.Collection`
  mode - filtering mode - `java.util.Locale$FilteringMode`

  returns: a list of matching language tags sorted in descending order
       based on priority or weight, or an empty list if nothing matches.
       The list is modifiable. - `java.util.List<java.lang.String>`

  throws: java.lang.NullPointerException - if priorityList or tags is null"
  (^java.util.List [^java.util.List priority-list ^java.util.Collection tags ^java.util.Locale$FilteringMode mode]
    (Locale/filterTags priority-list tags mode))
  (^java.util.List [^java.util.List priority-list ^java.util.Collection tags]
    (Locale/filterTags priority-list tags)))

(defn get-script
  "Returns the script for this locale, which should
   either be the empty string or an ISO 15924 4-letter script
   code. The first letter is uppercase and the rest are
   lowercase, for example, 'Latn', 'Cyrl'.

  returns: The script code, or the empty string if none is defined. - `java.lang.String`"
  (^java.lang.String [^Locale this]
    (-> this (.getScript))))

(defn get-unicode-locale-keys
  "Returns the set of Unicode locale keys defined by this locale, or the empty set if
   this locale has none.  The returned set is immutable.  Keys are all lower case.

  returns: The set of Unicode locale keys, or the empty set if this locale has
   no Unicode locale keywords. - `java.util.Set<java.lang.String>`"
  (^java.util.Set [^Locale this]
    (-> this (.getUnicodeLocaleKeys))))

(defn get-language
  "Returns the language code of this Locale.

   Note: ISO 639 is not a stable standard— some languages' codes have changed.
   Locale's constructor recognizes both the new and the old codes for the languages
   whose codes have changed, but this function always returns the old code.  If you
   want to check for a specific language whose code has changed, don't do


   if (locale.getLanguage().equals(`he`)) // BAD!
      ...
   Instead, do


   if (locale.getLanguage().equals(new Locale(`he`).getLanguage()))
      ...

  returns: The language code, or the empty string if none is defined. - `java.lang.String`"
  (^java.lang.String [^Locale this]
    (-> this (.getLanguage))))

(defn get-display-variant
  "Returns a name for the locale's variant code that is appropriate for display to the
   user.  If possible, the name will be localized for inLocale.  If the locale
   doesn't specify a variant code, this function returns the empty string.

  in-locale - The locale for which to retrieve the display variant code. - `java.util.Locale`

  returns: The name of the display variant code appropriate to the given locale. - `java.lang.String`

  throws: java.lang.NullPointerException - if inLocale is null"
  (^java.lang.String [^Locale this ^java.util.Locale in-locale]
    (-> this (.getDisplayVariant in-locale)))
  (^java.lang.String [^Locale this]
    (-> this (.getDisplayVariant))))

(defn get-variant
  "Returns the variant code for this locale.

  returns: The variant code, or the empty string if none is defined. - `java.lang.String`"
  (^java.lang.String [^Locale this]
    (-> this (.getVariant))))

(defn to-language-tag
  "Returns a well-formed IETF BCP 47 language tag representing
   this locale.

   If this Locale has a language, country, or
   variant that does not satisfy the IETF BCP 47 language tag
   syntax requirements, this method handles these fields as
   described below:

   Language: If language is empty, or not well-formed (for example `a` or
   `e2`), it will be emitted as `und` (Undetermined).

   Country: If country is not well-formed (for example `12` or `USA`),
   it will be omitted.

   Variant: If variant is well-formed, each sub-segment
   (delimited by '-' or '_') is emitted as a subtag.  Otherwise:


   if all sub-segments match [0-9a-zA-Z]{1,8}
   (for example `WIN` or `Oracle_JDK_Standard_Edition`), the first
   ill-formed sub-segment and all following will be appended to
   the private use subtag.  The first appended subtag will be
   `lvariant`, followed by the sub-segments in order, separated by
   hyphen. For example, `x-lvariant-WIN`,
   `Oracle-x-lvariant-JDK-Standard-Edition`.

   if any sub-segment does not match
   [0-9a-zA-Z]{1,8}, the variant will be truncated
   and the problematic sub-segment and all following sub-segments
   will be omitted.  If the remainder is non-empty, it will be
   emitted as a private use subtag as above (even if the remainder
   turns out to be well-formed).  For example,
   `Solaris_isjustthecoolestthing` is emitted as
   `x-lvariant-Solaris`, not as `solaris`.

   Special Conversions: Java supports some old locale
   representations, including deprecated ISO language codes,
   for compatibility. This method performs the following
   conversions:


   Deprecated ISO language codes `iw`, `ji`, and `in` are
   converted to `he`, `yi`, and `id`, respectively.

   A locale with language `no`, country `NO`, and variant
   `NY`, representing Norwegian Nynorsk (Norway), is converted
   to a language tag `nn-NO`.

   Note: Although the language tag created by this
   method is well-formed (satisfies the syntax requirements
   defined by the IETF BCP 47 specification), it is not
   necessarily a valid BCP 47 language tag.  For example,


     new Locale(`xx`, `YY`).toLanguageTag();

   will return `xx-YY`, but the language subtag `xx` and the
   region subtag `YY` are invalid because they are not registered
   in the IANA Language Subtag Registry.

  returns: a BCP47 language tag representing the locale - `java.lang.String`"
  (^java.lang.String [^Locale this]
    (-> this (.toLanguageTag))))

(defn strip-extensions
  "Returns a copy of this Locale with no
   extensions. If this Locale has no extensions, this Locale
   is returned.

  returns: a copy of this Locale with no extensions, or this
           if this has no extensions - `java.util.Locale`"
  (^java.util.Locale [^Locale this]
    (-> this (.stripExtensions))))

(defn get-extension
  "Returns the extension (or private use) value associated with
   the specified key, or null if there is no extension
   associated with the key. To be well-formed, the key must be one
   of [0-9A-Za-z]. Keys are case-insensitive, so
   for example 'z' and 'Z' represent the same extension.

  key - the extension key - `char`

  returns: The extension, or null if this locale defines no
   extension for the specified key. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if key is not well-formed"
  (^java.lang.String [^Locale this ^Character key]
    (-> this (.getExtension key))))

(defn to-string
  "Returns a string representation of this Locale
   object, consisting of language, country, variant, script,
   and extensions as below:

   language  `_`  country  `_`  (variant  `_#` | `#`)  script  `-`  extensions


   Language is always lower case, country is always upper case, script is always title
   case, and extensions are always lower case.  Extensions and private use subtags
   will be in canonical order as explained in toLanguageTag().

   When the locale has neither script nor extensions, the result is the same as in
   Java 6 and prior.

   If both the language and country fields are missing, this function will return
   the empty string, even if the variant, script, or extensions field is present (you
   can't have a locale with just a variant, the variant must accompany a well-formed
   language or country code).

   If script or extensions are present and variant is missing, no underscore is
   added before the `#`.

   This behavior is designed to support debugging and to be compatible with
   previous uses of toString that expected language, country, and variant
   fields only.  To represent a Locale as a String for interchange purposes, use
   toLanguageTag().

   Examples:
   en
   de_DE
   _GB
   en_US_WIN
   de__POSIX
   zh_CN_#Hans
   zh_TW_#Hant-x-java
   th_TH_TH_#u-nu-thai

  returns: A string representation of the Locale, for debugging. - `java.lang.String`"
  (^java.lang.String [^Locale this]
    (-> this (.toString))))

(defn get-display-name
  "Returns a name for the locale that is appropriate for display
   to the user.  This will be the values returned by
   getDisplayLanguage(), getDisplayScript(),getDisplayCountry(),
   and getDisplayVariant() assembled into a single string.
   The non-empty values are used in order,
   with the second and subsequent names in parentheses.  For example:

   language (script, country, variant)
   language (country)
   language (variant)
   script (country)
   country

   depending on which fields are specified in the locale.  If the
   language, script, country, and variant fields are all empty,
   this function returns the empty string.

  in-locale - The locale for which to retrieve the display name. - `java.util.Locale`

  returns: The name of the locale appropriate to display. - `java.lang.String`

  throws: java.lang.NullPointerException - if inLocale is null"
  (^java.lang.String [^Locale this ^java.util.Locale in-locale]
    (-> this (.getDisplayName in-locale)))
  (^java.lang.String [^Locale this]
    (-> this (.getDisplayName))))

(defn get-unicode-locale-type
  "Returns the Unicode locale type associated with the specified Unicode locale key
   for this locale. Returns the empty string for keys that are defined with no type.
   Returns null if the key is not defined. Keys are case-insensitive. The key must
   be two alphanumeric characters ([0-9a-zA-Z]), or an IllegalArgumentException is
   thrown.

  key - the Unicode locale key - `java.lang.String`

  returns: The Unicode locale type associated with the key, or null if the
   locale does not define the key. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the key is not well-formed"
  (^java.lang.String [^Locale this ^java.lang.String key]
    (-> this (.getUnicodeLocaleType key))))

(defn get-country
  "Returns the country/region code for this locale, which should
   either be the empty string, an uppercase ISO 3166 2-letter code,
   or a UN M.49 3-digit code.

  returns: The country/region code, or the empty string if none is defined. - `java.lang.String`"
  (^java.lang.String [^Locale this]
    (-> this (.getCountry))))

(defn get-display-script
  "Returns a name for the locale's script that is appropriate
   for display to the user. If possible, the name will be
   localized for the given locale. Returns the empty string if
   this locale doesn't specify a script code.

  in-locale - The locale for which to retrieve the display script. - `java.util.Locale`

  returns: the display name of the script code for the current default
   DISPLAY locale - `java.lang.String`

  throws: java.lang.NullPointerException - if inLocale is null"
  (^java.lang.String [^Locale this ^java.util.Locale in-locale]
    (-> this (.getDisplayScript in-locale)))
  (^java.lang.String [^Locale this]
    (-> this (.getDisplayScript))))

(defn has-extensions?
  "Returns true if this Locale has any
   extensions.

  returns: true if this Locale has any extensions - `boolean`"
  (^Boolean [^Locale this]
    (-> this (.hasExtensions))))

(defn get-iso-3-language
  "Returns a three-letter abbreviation of this locale's language.
   If the language matches an ISO 639-1 two-letter code, the
   corresponding ISO 639-2/T three-letter lowercase code is
   returned.  The ISO 639-2 language codes can be found on-line,
   see `Codes for the Representation of Names of Languages Part 2:
   Alpha-3 Code`.  If the locale specifies a three-letter
   language, the language is returned as is.  If the locale does
   not specify a language the empty string is returned.

  returns: A three-letter abbreviation of this locale's language. - `java.lang.String`

  throws: java.util.MissingResourceException - Throws MissingResourceException if three-letter language abbreviation is not available for this locale."
  (^java.lang.String [^Locale this]
    (-> this (.getISO3Language))))

(defn get-extension-keys
  "Returns the set of extension keys associated with this locale, or the
   empty set if it has no extensions. The returned set is unmodifiable.
   The keys will all be lower-case.

  returns: The set of extension keys, or the empty set if this locale has
   no extensions. - `java.util.Set<java.lang.Character>`"
  (^java.util.Set [^Locale this]
    (-> this (.getExtensionKeys))))

(defn get-iso-3-country
  "Returns a three-letter abbreviation for this locale's country.
   If the country matches an ISO 3166-1 alpha-2 code, the
   corresponding ISO 3166-1 alpha-3 uppercase code is returned.
   If the locale doesn't specify a country, this will be the empty
   string.

   The ISO 3166-1 codes can be found on-line.

  returns: A three-letter abbreviation of this locale's country. - `java.lang.String`

  throws: java.util.MissingResourceException - Throws MissingResourceException if the three-letter country abbreviation is not available for this locale."
  (^java.lang.String [^Locale this]
    (-> this (.getISO3Country))))

(defn get-unicode-locale-attributes
  "Returns the set of unicode locale attributes associated with
   this locale, or the empty set if it has no attributes. The
   returned set is unmodifiable.

  returns: The set of attributes. - `java.util.Set<java.lang.String>`"
  (^java.util.Set [^Locale this]
    (-> this (.getUnicodeLocaleAttributes))))

(defn clone
  "Overrides Cloneable.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^Locale this]
    (-> this (.clone))))

(defn hash-code
  "Override hashCode.
   Since Locales are often used in hashtables, caches the value
   for speed.

  returns: a hash code value for this object. - `int`"
  (^Integer [^Locale this]
    (-> this (.hashCode))))

(defn get-display-language
  "Returns a name for the locale's language that is appropriate for display to the
   user.
   If possible, the name returned will be localized according to inLocale.
   For example, if the locale is fr_FR and inLocale
   is en_US, getDisplayLanguage() will return `French`; if the locale is en_US and
   inLocale is fr_FR, getDisplayLanguage() will return `anglais`.
   If the name returned cannot be localized according to inLocale,
   (say, we don't have a Japanese name for Croatian),
   this function falls back on the English name, and finally
   on the ISO code as a last-resort value.  If the locale doesn't specify a language,
   this function returns the empty string.

  in-locale - The locale for which to retrieve the display language. - `java.util.Locale`

  returns: The name of the display language appropriate to the given locale. - `java.lang.String`

  throws: java.lang.NullPointerException - if inLocale is null"
  (^java.lang.String [^Locale this ^java.util.Locale in-locale]
    (-> this (.getDisplayLanguage in-locale)))
  (^java.lang.String [^Locale this]
    (-> this (.getDisplayLanguage))))

(defn get-display-country
  "Returns a name for the locale's country that is appropriate for display to the
   user.
   If possible, the name returned will be localized according to inLocale.
   For example, if the locale is fr_FR and inLocale
   is en_US, getDisplayCountry() will return `France`; if the locale is en_US and
   inLocale is fr_FR, getDisplayCountry() will return `Etats-Unis`.
   If the name returned cannot be localized according to inLocale.
   (say, we don't have a Japanese name for Croatia),
   this function falls back on the English name, and finally
   on the ISO code as a last-resort value.  If the locale doesn't specify a country,
   this function returns the empty string.

  in-locale - The locale for which to retrieve the display country. - `java.util.Locale`

  returns: The name of the country appropriate to the given locale. - `java.lang.String`

  throws: java.lang.NullPointerException - if inLocale is null"
  (^java.lang.String [^Locale this ^java.util.Locale in-locale]
    (-> this (.getDisplayCountry in-locale)))
  (^java.lang.String [^Locale this]
    (-> this (.getDisplayCountry))))

(defn equals
  "Returns true if this Locale is equal to another object.  A Locale is
   deemed equal to another Locale with identical language, script, country,
   variant and extensions, and unequal to all other objects.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this Locale is equal to the specified object. - `boolean`"
  (^Boolean [^Locale this ^java.lang.Object obj]
    (-> this (.equals obj))))

