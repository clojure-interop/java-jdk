(ns jdk.net.IDN
  "Provides methods to convert internationalized domain names (IDNs) between
  a normal Unicode representation and an ASCII Compatible Encoding (ACE) representation.
  Internationalized domain names can use characters from the entire range of
  Unicode, while traditional domain names are restricted to ASCII characters.
  ACE is an encoding of Unicode strings that uses only ASCII characters and
  can be used with software (such as the Domain Name System) that only
  understands traditional domain names.

  Internationalized domain names are defined in RFC 3490.
  RFC 3490 defines two operations: ToASCII and ToUnicode. These 2 operations employ
  Nameprep algorithm, which is a
  profile of Stringprep, and
  Punycode algorithm to convert
  domain name string back and forth.

  The behavior of aforementioned conversion process can be adjusted by various flags:

      If the ALLOW_UNASSIGNED flag is used, the domain name string to be converted
          can contain code points that are unassigned in Unicode 3.2, which is the
          Unicode version on which IDN conversion is based. If the flag is not used,
          the presence of such unassigned code points is treated as an error.
      If the USE_STD3_ASCII_RULES flag is used, ASCII strings are checked against RFC 1122 and RFC 1123.
          It is an error if they don't meet the requirements.

  These flags can be logically OR'ed together.

  The security consideration is important with respect to internationalization
  domain name support. For example, English domain names may be homographed
  - maliciously misspelled by substitution of non-Latin letters.
  Unicode Technical Report #36
  discusses security issues of IDN support as well as possible solutions.
  Applications are responsible for taking adequate security measures when using
  international domain names."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net IDN]))

(def *-allow-unassigned
  "Static Constant.

  Flag to allow processing of unassigned code points

  type: int"
  IDN/ALLOW_UNASSIGNED)

(def *-use-std-3-ascii-rules
  "Static Constant.

  Flag to turn on the check against STD-3 ASCII rules

  type: int"
  IDN/USE_STD3_ASCII_RULES)

(defn *to-ascii
  "Translates a string from Unicode to ASCII Compatible Encoding (ACE),
   as defined by the ToASCII operation of RFC 3490.

   ToASCII operation can fail. ToASCII fails if any step of it fails.
   If ToASCII operation fails, an IllegalArgumentException will be thrown.
   In this case, the input string should not be used in an internationalized domain name.

    A label is an individual part of a domain name. The original ToASCII operation,
   as defined in RFC 3490, only operates on a single label. This method can handle
   both label and entire domain name, by assuming that labels in a domain name are
   always separated by dots. The following characters are recognized as dots:
   \u002E (full stop), \u3002 (ideographic full stop), \uFF0E (fullwidth full stop),
   and \uFF61 (halfwidth ideographic full stop). if dots are
   used as label separators, this method also changes all of them to \u002E (full stop)
   in output translated string.

  input - the string to be processed - `java.lang.String`
  flag - process flag; can be 0 or any logical OR of possible flags - `int`

  returns: the translated String - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the input string doesn't conform to RFC 3490 specification"
  ([^java.lang.String input ^Integer flag]
    (IDN/toASCII input flag))
  ([^java.lang.String input]
    (IDN/toASCII input)))

(defn *to-unicode
  "Translates a string from ASCII Compatible Encoding (ACE) to Unicode,
   as defined by the ToUnicode operation of RFC 3490.

   ToUnicode never fails. In case of any error, the input string is returned unmodified.

    A label is an individual part of a domain name. The original ToUnicode operation,
   as defined in RFC 3490, only operates on a single label. This method can handle
   both label and entire domain name, by assuming that labels in a domain name are
   always separated by dots. The following characters are recognized as dots:
   \u002E (full stop), \u3002 (ideographic full stop), \uFF0E (fullwidth full stop),
   and \uFF61 (halfwidth ideographic full stop).

  input - the string to be processed - `java.lang.String`
  flag - process flag; can be 0 or any logical OR of possible flags - `int`

  returns: the translated String - `java.lang.String`"
  ([^java.lang.String input ^Integer flag]
    (IDN/toUnicode input flag))
  ([^java.lang.String input]
    (IDN/toUnicode input)))

