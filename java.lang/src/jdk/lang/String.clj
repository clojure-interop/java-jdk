(ns jdk.lang.String
  "The String class represents character strings. All
  string literals in Java programs, such as `abc`, are
  implemented as instances of this class.

  Strings are constant; their values cannot be changed after they
  are created. String buffers support mutable strings.
  Because String objects are immutable they can be shared. For example:


      String str = `abc`;
  is equivalent to:


      char data[] = {'a', 'b', 'c'};
      String str = new String(data);
  Here are some more examples of how strings can be used:


      System.out.println(`abc`);
      String cde = `cde`;
      System.out.println(`abc`  cde);
      String c = `abc`.substring(2,3);
      String d = cde.substring(1, 2);

  The class String includes methods for examining
  individual characters of the sequence, for comparing strings, for
  searching strings, for extracting substrings, and for creating a
  copy of a string with all characters translated to uppercase or to
  lowercase. Case mapping is based on the Unicode Standard version
  specified by the Character class.

  The Java language provides special support for the string
  concatenation operator (  ), and for conversion of
  other objects to strings. String concatenation is implemented
  through the StringBuilder(or StringBuffer)
  class and its append method.
  String conversions are implemented through the method
  toString, defined by Object and
  inherited by all classes in Java. For additional information on
  string concatenation and conversion, see Gosling, Joy, and Steele,
  The Java Language Specification.

   Unless otherwise noted, passing a null argument to a constructor
  or method in this class will cause a NullPointerException to be
  thrown.

  A String represents a string in the UTF-16 format
  in which supplementary characters are represented by surrogate
  pairs (see the section Unicode
  Character Representations in the Character class for
  more information).
  Index values refer to char code units, so a supplementary
  character uses two positions in a String.
  The String class provides methods for dealing with
  Unicode code points (i.e., characters), in addition to those for
  dealing with Unicode code units (i.e., char values)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang String]))

(defn ->string
  "Constructor.

  Constructs a new String by decoding the specified subarray of
   bytes using the specified charset.  The length of the new String
   is a function of the charset, and hence may not be equal to the length
   of the subarray.

    The behavior of this constructor when the given bytes are not valid
   in the given charset is unspecified.  The CharsetDecoder class should be used when more control
   over the decoding process is required.

  bytes - The bytes to be decoded into characters - `byte[]`
  offset - The index of the first byte to decode - `int`
  length - The number of bytes to decode - `int`
  charset-name - The name of a supported java.nio.charset.charset - `java.lang.String`

  throws: java.io.UnsupportedEncodingException - If the named charset is not supported"
  ([bytes offset length charset-name]
    (new String bytes offset length charset-name))
  ([value offset count]
    (new String value offset count))
  ([bytes charset-name]
    (new String bytes charset-name))
  ([original]
    (new String original))
  ([]
    (new String )))

(def *-case-insensitive-order
  "Static Constant.

  A Comparator that orders String objects as by
   compareToIgnoreCase. This comparator is serializable.

   Note that this Comparator does not take locale into account,
   and will result in an unsatisfactory ordering for certain locales.
   The java.text package provides Collators to allow
   locale-sensitive ordering.

  type: java.util.Comparator<java.lang.String>"
  String/CASE_INSENSITIVE_ORDER)

(defn *join
  "Returns a new String composed of copies of the
   CharSequence elements joined together with a copy of
   the specified delimiter.

   For example,


       String message = String.join(`-`, `Java`, `is`, `cool`);
       // message returned is: `Java-is-cool`

   Note that if an element is null, then `null` is added.

  delimiter - the delimiter that separates each element - `java.lang.CharSequence`
  elements - the elements to join together. - `java.lang.CharSequence`

  returns: a new String that is composed of the elements
           separated by the delimiter - `java.lang.String`

  throws: java.lang.NullPointerException - If delimiter or elements is null"
  ([delimiter elements]
    (String/join delimiter elements)))

(defn *format
  "Returns a formatted string using the specified locale, format string,
   and arguments.

  l - The java.util.locale to apply during formatting. If l is null then no localization is applied. - `java.util.Locale`
  format - A format string - `java.lang.String`
  args - Arguments referenced by the format specifiers in the format string. If there are more arguments than format specifiers, the extra arguments are ignored. The number of arguments is variable and may be zero. The maximum number of arguments is limited by the maximum dimension of a Java array as defined by The Java™ Virtual Machine Specification. The behaviour on a null argument depends on the conversion. - `java.lang.Object`

  returns: A formatted string - `java.lang.String`

  throws: java.util.IllegalFormatException - If a format string contains an illegal syntax, a format specifier that is incompatible with the given arguments, insufficient arguments given the format string, or other illegal conditions. For specification of all possible formatting errors, see the Details section of the formatter class specification"
  ([l format args]
    (String/format l format args))
  ([format args]
    (String/format format args)))

(defn *value-of
  "Returns the string representation of a specific subarray of the
   char array argument.

   The offset argument is the index of the first
   character of the subarray. The count argument
   specifies the length of the subarray. The contents of the subarray
   are copied; subsequent modification of the character array does not
   affect the returned string.

  data - the character array. - `char[]`
  offset - initial offset of the subarray. - `int`
  count - length of the subarray. - `int`

  returns: a String that contains the characters of the
            specified subarray of the character array. - `java.lang.String`

  throws: java.lang.IndexOutOfBoundsException - if offset is negative, or count is negative, or offset+count is larger than data.length."
  ([data offset count]
    (String/valueOf data offset count))
  ([obj]
    (String/valueOf obj)))

(defn *copy-value-of
  "Equivalent to valueOf(char[], int, int).

  data - the character array. - `char[]`
  offset - initial offset of the subarray. - `int`
  count - length of the subarray. - `int`

  returns: a String that contains the characters of the
            specified subarray of the character array. - `java.lang.String`

  throws: java.lang.IndexOutOfBoundsException - if offset is negative, or count is negative, or offset+count is larger than data.length."
  ([data offset count]
    (String/copyValueOf data offset count))
  ([data]
    (String/copyValueOf data)))

(defn get-chars
  "Copies characters from this string into the destination character
   array.

   The first character to be copied is at index srcBegin;
   the last character to be copied is at index srcEnd-1
   (thus the total number of characters to be copied is
   srcEnd-srcBegin). The characters are copied into the
   subarray of dst starting at index dstBegin
   and ending at index:


       dstBegin  (srcEnd-srcBegin) - 1

  src-begin - index of the first character in the string to copy. - `int`
  src-end - index after the last character in the string to copy. - `int`
  dst - the destination array. - `char[]`
  dst-begin - the start offset in the destination array. - `int`

  throws: java.lang.IndexOutOfBoundsException - If any of the following is true: srcBegin is negative. srcBegin is greater than srcEnd srcEnd is greater than the length of this string dstBegin is negative dstBegin+(srcEnd-srcBegin) is larger than dst.length"
  ([this src-begin src-end dst dst-begin]
    (-> this (.getChars src-begin src-end dst dst-begin))))

(defn trim
  "Returns a string whose value is this string, with any leading and trailing
   whitespace removed.

   If this String object represents an empty character
   sequence, or the first and last characters of character sequence
   represented by this String object both have codes
   greater than '\u0020' (the space character), then a
   reference to this String object is returned.

   Otherwise, if there is no character with a code greater than
   '\u0020' in the string, then a
   String object representing an empty string is
   returned.

   Otherwise, let k be the index of the first character in the
   string whose code is greater than '\u0020', and let
   m be the index of the last character in the string whose code
   is greater than '\u0020'. A String
   object is returned, representing the substring of this string that
   begins with the character at index k and ends with the
   character at index m-that is, the result of
   this.substring(k, m  1).

   This method may be used to trim whitespace (as defined above) from
   the beginning and end of a string.

  returns: A string whose value is this string, with any leading and trailing white
            space removed, or this string if it has no leading or
            trailing white space. - `java.lang.String`"
  ([this]
    (-> this (.trim))))

(defn to-lower-case
  "Converts all of the characters in this String to lower
   case using the rules of the given Locale.  Case mapping is based
   on the Unicode Standard version specified by the Character
   class. Since case mappings are not always 1:1 char mappings, the resulting
   String may be a different length than the original String.

   Examples of lowercase  mappings are in the following table:


     Language Code of Locale
     Upper Case
     Lower Case
     Description


     tr (Turkish)
     \u0130
     \u0069
     capital letter I with dot above -> small letter i


     tr (Turkish)
     \u0049
     \u0131
     capital letter I -> small letter dotless i


     (all)
     French Fries
     french fries
     lowercased all chars in String


     (all)






     lowercased all chars in String

  locale - use the case transformation rules for this locale - `java.util.Locale`

  returns: the String, converted to lowercase. - `java.lang.String`"
  ([this locale]
    (-> this (.toLowerCase locale)))
  ([this]
    (-> this (.toLowerCase))))

(defn replace-all
  "Replaces each substring of this string that matches the given regular expression with the
   given replacement.

    An invocation of this method of the form
   str.replaceAll(regex, repl)
   yields exactly the same result as the expression



   Pattern.compile(regex).matcher(str).replaceAll(repl)




   Note that backslashes (\) and dollar signs ($) in the
   replacement string may cause the results to be different than if it were
   being treated as a literal replacement string; see
   Matcher.replaceAll.
   Use Matcher.quoteReplacement(java.lang.String) to suppress the special
   meaning of these characters, if desired.

  regex - the regular expression to which this string is to be matched - `java.lang.String`
  replacement - the string to be substituted for each match - `java.lang.String`

  returns: The resulting String - `java.lang.String`

  throws: java.util.regex.PatternSyntaxException - if the regular expression's syntax is invalid"
  ([this regex replacement]
    (-> this (.replaceAll regex replacement))))

(defn contains
  "Returns true if and only if this string contains the specified
   sequence of char values.

  s - the sequence to search for - `java.lang.CharSequence`

  returns: true if this string contains s, false otherwise - `boolean`"
  ([this s]
    (-> this (.contains s))))

(defn ends-with
  "Tests if this string ends with the specified suffix.

  suffix - the suffix. - `java.lang.String`

  returns: true if the character sequence represented by the
            argument is a suffix of the character sequence represented by
            this object; false otherwise. Note that the
            result will be true if the argument is the
            empty string or is equal to this String object
            as determined by the equals(Object) method. - `boolean`"
  ([this suffix]
    (-> this (.endsWith suffix))))

(defn replace-first
  "Replaces the first substring of this string that matches the given regular expression with the
   given replacement.

    An invocation of this method of the form
   str.replaceFirst(regex, repl)
   yields exactly the same result as the expression



   Pattern.compile(regex).matcher(str).replaceFirst(repl)




   Note that backslashes (\) and dollar signs ($) in the
   replacement string may cause the results to be different than if it were
   being treated as a literal replacement string; see
   Matcher.replaceFirst(java.lang.String).
   Use Matcher.quoteReplacement(java.lang.String) to suppress the special
   meaning of these characters, if desired.

  regex - the regular expression to which this string is to be matched - `java.lang.String`
  replacement - the string to be substituted for the first match - `java.lang.String`

  returns: The resulting String - `java.lang.String`

  throws: java.util.regex.PatternSyntaxException - if the regular expression's syntax is invalid"
  ([this regex replacement]
    (-> this (.replaceFirst regex replacement))))

(defn to-string
  "This object (which is already a string!) is itself returned.

  returns: the string itself. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-bytes
  "Encodes this String into a sequence of bytes using the named
   charset, storing the result into a new byte array.

    The behavior of this method when this string cannot be encoded in
   the given charset is unspecified.  The CharsetEncoder class should be used when more control
   over the encoding process is required.

  charset-name - The name of a supported java.nio.charset.charset - `java.lang.String`

  returns: The resultant byte array - `byte[]`

  throws: java.io.UnsupportedEncodingException - If the named charset is not supported"
  ([this charset-name]
    (-> this (.getBytes charset-name)))
  ([this]
    (-> this (.getBytes)))
  ([this src-begin src-end dst dst-begin]
    (-> this (.getBytes src-begin src-end dst dst-begin))))

(defn sub-sequence
  "Returns a character sequence that is a subsequence of this sequence.

    An invocation of this method of the form



   str.subSequence(begin, end)

   behaves in exactly the same way as the invocation



   str.substring(begin, end)

  begin-index - the begin index, inclusive. - `int`
  end-index - the end index, exclusive. - `int`

  returns: the specified subsequence. - `java.lang.CharSequence`

  throws: java.lang.IndexOutOfBoundsException - if beginIndex or endIndex is negative, if endIndex is greater than length(), or if beginIndex is greater than endIndex"
  ([this begin-index end-index]
    (-> this (.subSequence begin-index end-index))))

(defn substring
  "Returns a string that is a substring of this string. The
   substring begins at the specified beginIndex and
   extends to the character at index endIndex - 1.
   Thus the length of the substring is endIndex-beginIndex.

   Examples:


   `hamburger`.substring(4, 8) returns `urge`
   `smiles`.substring(1, 5) returns `mile`

  begin-index - the beginning index, inclusive. - `int`
  end-index - the ending index, exclusive. - `int`

  returns: the specified substring. - `java.lang.String`

  throws: java.lang.IndexOutOfBoundsException - if the beginIndex is negative, or endIndex is larger than the length of this String object, or beginIndex is larger than endIndex."
  ([this begin-index end-index]
    (-> this (.substring begin-index end-index)))
  ([this begin-index]
    (-> this (.substring begin-index))))

(defn equals-ignore-case
  "Compares this String to another String, ignoring case
   considerations.  Two strings are considered equal ignoring case if they
   are of the same length and corresponding characters in the two strings
   are equal ignoring case.

    Two characters c1 and c2 are considered the same
   ignoring case if at least one of the following is true:

      The two characters are the same (as compared by the
          == operator)
      Applying the method Character.toUpperCase(char) to each character
          produces the same result
      Applying the method Character.toLowerCase(char) to each character
          produces the same result

  another-string - The String to compare this String against - `java.lang.String`

  returns: true if the argument is not null and it
            represents an equivalent String ignoring case; false otherwise - `boolean`"
  ([this another-string]
    (-> this (.equalsIgnoreCase another-string))))

(defn replace
  "Returns a string resulting from replacing all occurrences of
   oldChar in this string with newChar.

   If the character oldChar does not occur in the
   character sequence represented by this String object,
   then a reference to this String object is returned.
   Otherwise, a String object is returned that
   represents a character sequence identical to the character sequence
   represented by this String object, except that every
   occurrence of oldChar is replaced by an occurrence
   of newChar.

   Examples:


   `mesquite in your cellar`.replace('e', 'o')
           returns `mosquito in your collar`
   `the war of baronets`.replace('r', 'y')
           returns `the way of bayonets`
   `sparring with a purple porpoise`.replace('p', 't')
           returns `starring with a turtle tortoise`
   `JonL`.replace('q', 'x') returns `JonL` (no change)

  old-char - the old character. - `char`
  new-char - the new character. - `char`

  returns: a string derived from this string by replacing every
            occurrence of oldChar with newChar. - `java.lang.String`"
  ([this old-char new-char]
    (-> this (.replace old-char new-char))))

(defn to-char-array
  "Converts this string to a new character array.

  returns: a newly allocated character array whose length is the length
            of this string and whose contents are initialized to contain
            the character sequence represented by this string. - `char[]`"
  ([this]
    (-> this (.toCharArray))))

(defn last-index-of
  "Returns the index within this string of the last occurrence of
   the specified character, searching backward starting at the
   specified index. For values of ch in the range
   from 0 to 0xFFFF (inclusive), the index returned is the largest
   value k such that:


   (this.charAt(k) == ch)  && (k <= fromIndex)
   is true. For other values of ch, it is the
   largest value k such that:


   (this.codePointAt(k) == ch)  && (k <= fromIndex)
   is true. In either case, if no such character occurs in this
   string at or before position fromIndex, then
   -1 is returned.

   All indices are specified in char values
   (Unicode code units).

  ch - a character (Unicode code point). - `int`
  from-index - the index to start the search from. There is no restriction on the value of fromIndex. If it is greater than or equal to the length of this string, it has the same effect as if it were equal to one less than the length of this string: this entire string may be searched. If it is negative, it has the same effect as if it were -1: -1 is returned. - `int`

  returns: the index of the last occurrence of the character in the
            character sequence represented by this object that is less
            than or equal to fromIndex, or -1
            if the character does not occur before that point. - `int`"
  ([this ch from-index]
    (-> this (.lastIndexOf ch from-index)))
  ([this ch]
    (-> this (.lastIndexOf ch))))

(defn char-at
  "Returns the char value at the
   specified index. An index ranges from 0 to
   length() - 1. The first char value of the sequence
   is at index 0, the next at index 1,
   and so on, as for array indexing.

   If the char value specified by the index is a
   surrogate, the surrogate
   value is returned.

  index - the index of the char value. - `int`

  returns: the char value at the specified index of this string.
               The first char value is at index 0. - `char`

  throws: java.lang.IndexOutOfBoundsException - if the index argument is negative or not less than the length of this string."
  ([this index]
    (-> this (.charAt index))))

(defn split
  "Splits this string around matches of the given
   regular expression.

    The array returned by this method contains each substring of this
   string that is terminated by another substring that matches the given
   expression or is terminated by the end of the string.  The substrings in
   the array are in the order in which they occur in this string.  If the
   expression does not match any part of the input then the resulting array
   has just one element, namely this string.

    When there is a positive-width match at the beginning of this
   string then an empty leading substring is included at the beginning
   of the resulting array. A zero-width match at the beginning however
   never produces such empty leading substring.

    The limit parameter controls the number of times the
   pattern is applied and therefore affects the length of the resulting
   array.  If the limit n is greater than zero then the pattern
   will be applied at most n - 1 times, the array's
   length will be no greater than n, and the array's last entry
   will contain all input beyond the last matched delimiter.  If n
   is non-positive then the pattern will be applied as many times as
   possible and the array can have any length.  If n is zero then
   the pattern will be applied as many times as possible, the array can
   have any length, and trailing empty strings will be discarded.

    The string `boo:and:foo`, for example, yields the
   following results with these parameters:



       Regex
       Limit
       Result

   :
       2
       { `boo`, `and:foo` }
   :
       5
       { `boo`, `and`, `foo` }
   :
       -2
       { `boo`, `and`, `foo` }
   o
       5
       { `b`, ``, `:and:f`, ``, `` }
   o
       -2
       { `b`, ``, `:and:f`, ``, `` }
   o
       0
       { `b`, ``, `:and:f` }


    An invocation of this method of the form
   str.split(regex, n)
   yields the same result as the expression



   Pattern.compile(regex).split(str, n)

  regex - the delimiting regular expression - `java.lang.String`
  limit - the result threshold, as described above - `int`

  returns: the array of strings computed by splitting this string
            around matches of the given regular expression - `java.lang.String[]`

  throws: java.util.regex.PatternSyntaxException - if the regular expression's syntax is invalid"
  ([this regex limit]
    (-> this (.split regex limit)))
  ([this regex]
    (-> this (.split regex))))

(defn to-upper-case
  "Converts all of the characters in this String to upper
   case using the rules of the given Locale. Case mapping is based
   on the Unicode Standard version specified by the Character
   class. Since case mappings are not always 1:1 char mappings, the resulting
   String may be a different length than the original String.

   Examples of locale-sensitive and 1:M case mappings are in the following table.



     Language Code of Locale
     Lower Case
     Upper Case
     Description


     tr (Turkish)
     \u0069
     \u0130
     small letter i -> capital letter I with dot above


     tr (Turkish)
     \u0131
     \u0049
     small letter dotless i -> capital letter I


     (all)
     \u00df
     \u0053 \u0053
     small letter sharp s -> two letters: SS


     (all)
     Fahrvergnügen
     FAHRVERGNÜGEN

  locale - use the case transformation rules for this locale - `java.util.Locale`

  returns: the String, converted to uppercase. - `java.lang.String`"
  ([this locale]
    (-> this (.toUpperCase locale)))
  ([this]
    (-> this (.toUpperCase))))

(defn concat
  "Concatenates the specified string to the end of this string.

   If the length of the argument string is 0, then this
   String object is returned. Otherwise, a
   String object is returned that represents a character
   sequence that is the concatenation of the character sequence
   represented by this String object and the character
   sequence represented by the argument string.
   Examples:


   `cares`.concat(`s`) returns `caress`
   `to`.concat(`get`).concat(`her`) returns `together`

  str - the String that is concatenated to the end of this String. - `java.lang.String`

  returns: a string that represents the concatenation of this object's
            characters followed by the string argument's characters. - `java.lang.String`"
  ([this str]
    (-> this (.concat str))))

(defn offset-by-code-points
  "Returns the index within this String that is
   offset from the given index by
   codePointOffset code points. Unpaired surrogates
   within the text range given by index and
   codePointOffset count as one code point each.

  index - the index to be offset - `int`
  code-point-offset - the offset in code points - `int`

  returns: the index within this String - `int`

  throws: java.lang.IndexOutOfBoundsException - if index is negative or larger then the length of this String, or if codePointOffset is positive and the substring starting with index has fewer than codePointOffset code points, or if codePointOffset is negative and the substring before index has fewer than the absolute value of codePointOffset code points."
  ([this index code-point-offset]
    (-> this (.offsetByCodePoints index code-point-offset))))

(defn length
  "Returns the length of this string.
   The length is equal to the number of Unicode
   code units in the string.

  returns: the length of the sequence of characters represented by this
            object. - `int`"
  ([this]
    (-> this (.length))))

(defn region-matches
  "Tests if two string regions are equal.

   A substring of this String object is compared to a substring
   of the argument other. The result is true if these
   substrings represent character sequences that are the same, ignoring
   case if and only if ignoreCase is true. The substring of
   this String object to be compared begins at index
   toffset and has length len. The substring of
   other to be compared begins at index ooffset and
   has length len. The result is false if and only if
   at least one of the following is true:
   toffset is negative.
   ooffset is negative.
   toffset+len is greater than the length of this
   String object.
   ooffset+len is greater than the length of the other
   argument.
   ignoreCase is false and there is some nonnegative
   integer k less than len such that:


   this.charAt(toffset+k) != other.charAt(ooffset+k)
   ignoreCase is true and there is some nonnegative
   integer k less than len such that:


   Character.toLowerCase(this.charAt(toffset+k)) !=
       Character.toLowerCase(other.charAt(ooffset+k))
   and:


   Character.toUpperCase(this.charAt(toffset+k)) !=
           Character.toUpperCase(other.charAt(ooffset+k))

  ignore-case - if true, ignore case when comparing characters. - `boolean`
  toffset - the starting offset of the subregion in this string. - `int`
  other - the string argument. - `java.lang.String`
  ooffset - the starting offset of the subregion in the string argument. - `int`
  len - the number of characters to compare. - `int`

  returns: true if the specified subregion of this string
            matches the specified subregion of the string argument;
            false otherwise. Whether the matching is exact
            or case insensitive depends on the ignoreCase
            argument. - `boolean`"
  ([this ignore-case toffset other ooffset len]
    (-> this (.regionMatches ignore-case toffset other ooffset len)))
  ([this toffset other ooffset len]
    (-> this (.regionMatches toffset other ooffset len))))

(defn matches
  "Tells whether or not this string matches the given regular expression.

    An invocation of this method of the form
   str.matches(regex) yields exactly the
   same result as the expression


   Pattern.matches(regex, str)

  regex - the regular expression to which this string is to be matched - `java.lang.String`

  returns: true if, and only if, this string matches the
            given regular expression - `boolean`

  throws: java.util.regex.PatternSyntaxException - if the regular expression's syntax is invalid"
  ([this regex]
    (-> this (.matches regex))))

(defn intern
  "Returns a canonical representation for the string object.

   A pool of strings, initially empty, is maintained privately by the
   class String.

   When the intern method is invoked, if the pool already contains a
   string equal to this String object as determined by
   the equals(Object) method, then the string from the pool is
   returned. Otherwise, this String object is added to the
   pool and a reference to this String object is returned.

   It follows that for any two strings s and t,
   s.intern() == t.intern() is true
   if and only if s.equals(t) is true.

   All literal strings and string-valued constant expressions are
   interned. String literals are defined in section 3.10.5 of the
   The Java™ Language Specification.

  returns: a string that has the same contents as this string, but is
            guaranteed to be from a pool of unique strings. - `java.lang.String`"
  ([this]
    (-> this (.intern))))

(defn starts-with
  "Tests if the substring of this string beginning at the
   specified index starts with the specified prefix.

  prefix - the prefix. - `java.lang.String`
  toffset - where to begin looking in this string. - `int`

  returns: true if the character sequence represented by the
            argument is a prefix of the substring of this object starting
            at index toffset; false otherwise.
            The result is false if toffset is
            negative or greater than the length of this
            String object; otherwise the result is the same
            as the result of the expression


            this.substring(toffset).startsWith(prefix) - `boolean`"
  ([this prefix toffset]
    (-> this (.startsWith prefix toffset)))
  ([this prefix]
    (-> this (.startsWith prefix))))

(defn hash-code
  "Returns a hash code for this string. The hash code for a
   String object is computed as


   s[0]*31^(n-1)  s[1]*31^(n-2)  ...  s[n-1]
   using int arithmetic, where s[i] is the
   ith character of the string, n is the length of
   the string, and ^ indicates exponentiation.
   (The hash value of the empty string is zero.)

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn empty?
  "Returns true if, and only if, length() is 0.

  returns: true if length() is 0, otherwise
   false - `boolean`"
  ([this]
    (-> this (.isEmpty))))

(defn code-point-count
  "Returns the number of Unicode code points in the specified text
   range of this String. The text range begins at the
   specified beginIndex and extends to the
   char at index endIndex - 1. Thus the
   length (in chars) of the text range is
   endIndex-beginIndex. Unpaired surrogates within
   the text range count as one code point each.

  begin-index - the index to the first char of the text range. - `int`
  end-index - the index after the last char of the text range. - `int`

  returns: the number of Unicode code points in the specified text
   range - `int`

  throws: java.lang.IndexOutOfBoundsException - if the beginIndex is negative, or endIndex is larger than the length of this String, or beginIndex is larger than endIndex."
  ([this begin-index end-index]
    (-> this (.codePointCount begin-index end-index))))

(defn compare-to
  "Compares two strings lexicographically.
   The comparison is based on the Unicode value of each character in
   the strings. The character sequence represented by this
   String object is compared lexicographically to the
   character sequence represented by the argument string. The result is
   a negative integer if this String object
   lexicographically precedes the argument string. The result is a
   positive integer if this String object lexicographically
   follows the argument string. The result is zero if the strings
   are equal; compareTo returns 0 exactly when
   the equals(Object) method would return true.

   This is the definition of lexicographic ordering. If two strings are
   different, then either they have different characters at some index
   that is a valid index for both strings, or their lengths are different,
   or both. If they have different characters at one or more index
   positions, let k be the smallest such index; then the string
   whose character at position k has the smaller value, as
   determined by using the < operator, lexicographically precedes the
   other string. In this case, compareTo returns the
   difference of the two character values at position k in
   the two string -- that is, the value:


   this.charAt(k)-anotherString.charAt(k)
   If there is no index position at which they differ, then the shorter
   string lexicographically precedes the longer string. In this case,
   compareTo returns the difference of the lengths of the
   strings -- that is, the value:


   this.length()-anotherString.length()

  another-string - the String to be compared. - `java.lang.String`

  returns: the value 0 if the argument string is equal to
            this string; a value less than 0 if this string
            is lexicographically less than the string argument; and a
            value greater than 0 if this string is
            lexicographically greater than the string argument. - `int`"
  ([this another-string]
    (-> this (.compareTo another-string))))

(defn code-point-before
  "Returns the character (Unicode code point) before the specified
   index. The index refers to char values
   (Unicode code units) and ranges from 1 to length.

    If the char value at (index - 1)
   is in the low-surrogate range, (index - 2) is not
   negative, and the char value at (index -
   2) is in the high-surrogate range, then the
   supplementary code point value of the surrogate pair is
   returned. If the char value at index -
   1 is an unpaired low-surrogate or a high-surrogate, the
   surrogate value is returned.

  index - the index following the code point that should be returned - `int`

  returns: the Unicode code point value before the given index. - `int`

  throws: java.lang.IndexOutOfBoundsException - if the index argument is less than 1 or greater than the length of this string."
  ([this index]
    (-> this (.codePointBefore index))))

(defn index-of
  "Returns the index within this string of the first occurrence of the
   specified character, starting the search at the specified index.

   If a character with value ch occurs in the
   character sequence represented by this String
   object at an index no smaller than fromIndex, then
   the index of the first such occurrence is returned. For values
   of ch in the range from 0 to 0xFFFF (inclusive),
   this is the smallest value k such that:


   (this.charAt(k) == ch)  && (k >= fromIndex)
   is true. For other values of ch, it is the
   smallest value k such that:


   (this.codePointAt(k) == ch)  && (k >= fromIndex)
   is true. In either case, if no such character occurs in this
   string at or after position fromIndex, then
   -1 is returned.


   There is no restriction on the value of fromIndex. If it
   is negative, it has the same effect as if it were zero: this entire
   string may be searched. If it is greater than the length of this
   string, it has the same effect as if it were equal to the length of
   this string: -1 is returned.

   All indices are specified in char values
   (Unicode code units).

  ch - a character (Unicode code point). - `int`
  from-index - the index to start the search from. - `int`

  returns: the index of the first occurrence of the character in the
            character sequence represented by this object that is greater
            than or equal to fromIndex, or -1
            if the character does not occur. - `int`"
  ([this ch from-index]
    (-> this (.indexOf ch from-index)))
  ([this ch]
    (-> this (.indexOf ch))))

(defn content-equals
  "Compares this string to the specified StringBuffer.  The result
   is true if and only if this String represents the same
   sequence of characters as the specified StringBuffer. This method
   synchronizes on the StringBuffer.

  sb - The StringBuffer to compare this String against - `java.lang.StringBuffer`

  returns: true if this String represents the same
            sequence of characters as the specified StringBuffer,
            false otherwise - `boolean`"
  ([this sb]
    (-> this (.contentEquals sb))))

(defn equals
  "Compares this string to the specified object.  The result is true if and only if the argument is not null and is a String object that represents the same sequence of characters as this
   object.

  an-object - The object to compare this String against - `java.lang.Object`

  returns: true if the given object represents a String
            equivalent to this string, false otherwise - `boolean`"
  ([this an-object]
    (-> this (.equals an-object))))

(defn compare-to-ignore-case
  "Compares two strings lexicographically, ignoring case
   differences. This method returns an integer whose sign is that of
   calling compareTo with normalized versions of the strings
   where case differences have been eliminated by calling
   Character.toLowerCase(Character.toUpperCase(character)) on
   each character.

   Note that this method does not take locale into account,
   and will result in an unsatisfactory ordering for certain locales.
   The java.text package provides collators to allow
   locale-sensitive ordering.

  str - the String to be compared. - `java.lang.String`

  returns: a negative integer, zero, or a positive integer as the
            specified String is greater than, equal to, or less
            than this String, ignoring case considerations. - `int`"
  ([this str]
    (-> this (.compareToIgnoreCase str))))

(defn code-point-at
  "Returns the character (Unicode code point) at the specified
   index. The index refers to char values
   (Unicode code units) and ranges from 0 to
   length()- 1.

    If the char value specified at the given index
   is in the high-surrogate range, the following index is less
   than the length of this String, and the
   char value at the following index is in the
   low-surrogate range, then the supplementary code point
   corresponding to this surrogate pair is returned. Otherwise,
   the char value at the given index is returned.

  index - the index to the char values - `int`

  returns: the code point value of the character at the
               index - `int`

  throws: java.lang.IndexOutOfBoundsException - if the index argument is negative or not less than the length of this string."
  ([this index]
    (-> this (.codePointAt index))))

