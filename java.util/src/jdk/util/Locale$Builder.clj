(ns jdk.util.Locale$Builder
  "Builder is used to build instances of Locale
  from values configured by the setters.  Unlike the Locale
  constructors, the Builder checks if a value configured by a
  setter satisfies the syntax requirements defined by the Locale
  class.  A Locale object created by a Builder is
  well-formed and can be transformed to a well-formed IETF BCP 47 language tag
  without losing information.

  Note: The Locale class does not provide any
  syntactic restrictions on variant, while BCP 47 requires each variant
  subtag to be 5 to 8 alphanumerics or a single numeric followed by 3
  alphanumerics.  The method setVariant throws
  IllformedLocaleException for a variant that does not satisfy
  this restriction. If it is necessary to support such a variant, use a
  Locale constructor.  However, keep in mind that a Locale
  object created this way might lose the variant information when
  transformed to a BCP 47 language tag.

  The following example shows how to create a Locale object
  with the Builder.



      Locale aLocale = new Builder().setLanguage(`sr`).setScript(`Latn`).setRegion(`RS`).build();


  Builders can be reused; clear() resets all
  fields to their default values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Locale$Builder]))

(defn ->builder
  "Constructor.

  Constructs an empty Builder. The default value of all
   fields, extensions, and private use information is the
   empty string."
  ([]
    (new Locale$Builder )))

(defn add-unicode-locale-attribute
  "Adds a unicode locale attribute, if not already present, otherwise
   has no effect.  The attribute must not be null and must be well-formed or an exception
   is thrown.

  attribute - the attribute - `java.lang.String`

  returns: This builder. - `java.util.Locale.Builder`

  throws: java.lang.NullPointerException - if attribute is null"
  ([^java.util.Locale$Builder this ^java.lang.String attribute]
    (-> this (.addUnicodeLocaleAttribute attribute))))

(defn set-region
  "Sets the region.  If region is null or the empty string, the region
   in this Builder is removed.  Otherwise,
   the region must be well-formed or an
   exception is thrown.

   The typical region value is a two-letter ISO 3166 code or a
   three-digit UN M.49 area code.

   The country value in the Locale created by the
   Builder is always normalized to upper case.

  region - the region - `java.lang.String`

  returns: This builder. - `java.util.Locale.Builder`

  throws: java.util.IllformedLocaleException - if region is ill-formed"
  ([^java.util.Locale$Builder this ^java.lang.String region]
    (-> this (.setRegion region))))

(defn set-variant
  "Sets the variant.  If variant is null or the empty string, the
   variant in this Builder is removed.  Otherwise, it
   must consist of one or more well-formed
   subtags, or an exception is thrown.

   Note: This method checks if variant
   satisfies the IETF BCP 47 variant subtag's syntax requirements,
   and normalizes the value to lowercase letters.  However,
   the Locale class does not impose any syntactic
   restriction on variant, and the variant value in
   Locale is case sensitive.  To set such a variant,
   use a Locale constructor.

  variant - the variant - `java.lang.String`

  returns: This builder. - `java.util.Locale.Builder`

  throws: java.util.IllformedLocaleException - if variant is ill-formed"
  ([^java.util.Locale$Builder this ^java.lang.String variant]
    (-> this (.setVariant variant))))

(defn set-language-tag
  "Resets the Builder to match the provided IETF BCP 47
   language tag.  Discards the existing state.  Null and the
   empty string cause the builder to be reset, like clear().  Grandfathered tags (see Locale.forLanguageTag(java.lang.String)) are converted to their canonical
   form before being processed.  Otherwise, the language tag
   must be well-formed (see Locale) or an exception is
   thrown (unlike Locale.forLanguageTag, which
   just discards ill-formed and following portions of the
   tag).

  language-tag - the language tag - `java.lang.String`

  returns: This builder. - `java.util.Locale.Builder`

  throws: java.util.IllformedLocaleException - if languageTag is ill-formed"
  ([^java.util.Locale$Builder this ^java.lang.String language-tag]
    (-> this (.setLanguageTag language-tag))))

(defn remove-unicode-locale-attribute
  "Removes a unicode locale attribute, if present, otherwise has no
   effect.  The attribute must not be null and must be well-formed or an exception
   is thrown.

   Attribute comparision for removal is case-insensitive.

  attribute - the attribute - `java.lang.String`

  returns: This builder. - `java.util.Locale.Builder`

  throws: java.lang.NullPointerException - if attribute is null"
  ([^java.util.Locale$Builder this ^java.lang.String attribute]
    (-> this (.removeUnicodeLocaleAttribute attribute))))

(defn set-extension
  "Sets the extension for the given key. If the value is null or the
   empty string, the extension is removed.  Otherwise, the extension
   must be well-formed or an exception
   is thrown.

   Note: The key UNICODE_LOCALE_EXTENSION ('u') is used for the Unicode locale extension.
   Setting a value for this key replaces any existing Unicode locale key/type
   pairs with those defined in the extension.

   Note: The key PRIVATE_USE_EXTENSION ('x') is used for the private use code. To be
   well-formed, the value for this key needs only to have subtags of one to
   eight alphanumeric characters, not two to eight as in the general case.

  key - the extension key - `char`
  value - the extension value - `java.lang.String`

  returns: This builder. - `java.util.Locale.Builder`

  throws: java.util.IllformedLocaleException - if key is illegal or value is ill-formed"
  ([^java.util.Locale$Builder this ^Character key ^java.lang.String value]
    (-> this (.setExtension key value))))

(defn set-script
  "Sets the script. If script is null or the empty string,
   the script in this Builder is removed.
   Otherwise, the script must be well-formed or an
   exception is thrown.

   The typical script value is a four-letter script code as defined by ISO 15924.

  script - the script - `java.lang.String`

  returns: This builder. - `java.util.Locale.Builder`

  throws: java.util.IllformedLocaleException - if script is ill-formed"
  ([^java.util.Locale$Builder this ^java.lang.String script]
    (-> this (.setScript script))))

(defn build
  "Returns an instance of Locale created from the fields set
   on this builder.

   This applies the conversions listed in Locale.forLanguageTag(java.lang.String)
   when constructing a Locale. (Grandfathered tags are handled in
   setLanguageTag(java.lang.String).)

  returns: A Locale. - `java.util.Locale`"
  ([^java.util.Locale$Builder this]
    (-> this (.build))))

(defn set-unicode-locale-keyword
  "Sets the Unicode locale keyword type for the given key.  If the type
   is null, the Unicode keyword is removed.  Otherwise, the key must be
   non-null and both key and type must be well-formed or an exception
   is thrown.

   Keys and types are converted to lower case.

   Note:Setting the 'u' extension via setExtension(char, java.lang.String)
   replaces all Unicode locale keywords with those defined in the
   extension.

  key - the Unicode locale key - `java.lang.String`
  type - the Unicode locale type - `java.lang.String`

  returns: This builder. - `java.util.Locale.Builder`

  throws: java.util.IllformedLocaleException - if key or type is ill-formed"
  ([^java.util.Locale$Builder this ^java.lang.String key ^java.lang.String type]
    (-> this (.setUnicodeLocaleKeyword key type))))

(defn set-language
  "Sets the language.  If language is the empty string or
   null, the language in this Builder is removed.  Otherwise,
   the language must be well-formed
   or an exception is thrown.

   The typical language value is a two or three-letter language
   code as defined in ISO639.

  language - the language - `java.lang.String`

  returns: This builder. - `java.util.Locale.Builder`

  throws: java.util.IllformedLocaleException - if language is ill-formed"
  ([^java.util.Locale$Builder this ^java.lang.String language]
    (-> this (.setLanguage language))))

(defn set-locale
  "Resets the Builder to match the provided
   locale.  Existing state is discarded.

   All fields of the locale must be well-formed, see Locale.

   Locales with any ill-formed fields cause
   IllformedLocaleException to be thrown, except for the
   following three cases which are accepted for compatibility
   reasons:
   Locale(`ja`, `JP`, `JP`) is treated as `ja-JP-u-ca-japanese`
   Locale(`th`, `TH`, `TH`) is treated as `th-TH-u-nu-thai`
   Locale(`no`, `NO`, `NY`) is treated as `nn-NO`

  locale - the locale - `java.util.Locale`

  returns: This builder. - `java.util.Locale.Builder`

  throws: java.util.IllformedLocaleException - if locale has any ill-formed fields."
  ([^java.util.Locale$Builder this ^java.util.Locale locale]
    (-> this (.setLocale locale))))

(defn clear
  "Resets the builder to its initial, empty state.

  returns: This builder. - `java.util.Locale.Builder`"
  ([^java.util.Locale$Builder this]
    (-> this (.clear))))

(defn clear-extensions
  "Resets the extensions to their initial, empty state.
   Language, script, region and variant are unchanged.

  returns: This builder. - `java.util.Locale.Builder`"
  ([^java.util.Locale$Builder this]
    (-> this (.clearExtensions))))

