(ns jdk.text.MessageFormat
  "MessageFormat provides a means to produce concatenated
  messages in a language-neutral way. Use this to construct messages
  displayed for end users.


  MessageFormat takes a set of objects, formats them, then
  inserts the formatted strings into the pattern at the appropriate places.


  Note:
  MessageFormat differs from the other Format
  classes in that you create a MessageFormat object with one
  of its constructors (not with a getInstance style factory
  method). The factory methods aren't necessary because MessageFormat
  itself doesn't implement locale specific behavior. Any locale specific
  behavior is defined by the pattern that you provide as well as the
  subformats used for inserted arguments.

  Patterns and Their Interpretation

  MessageFormat uses patterns of the following form:


  MessageFormatPattern:
          String
          MessageFormatPattern FormatElement String

  FormatElement:
          { ArgumentIndex }
          { ArgumentIndex , FormatType }
          { ArgumentIndex , FormatType , FormatStyle }

  FormatType: one of
          number date time choice

  FormatStyle:
          short
          medium
          long
          full
          integer
          currency
          percent
          SubformatPattern

  Within a String, a pair of single quotes can be used to
  quote any arbitrary characters except single quotes. For example,
  pattern string `'{0}'` represents string
  `{0}`, not a FormatElement. A single quote itself
  must be represented by doubled single quotes '' throughout a
  String.  For example, pattern string `'{''}'` is
  interpreted as a sequence of '{ (start of quoting and a
  left curly brace), '' (a single quote), and
  }' (a right curly brace and end of quoting),
  not '{' and '}' (quoted left and
  right curly braces): representing string `{'}`,
  not `{}`.

  A SubformatPattern is interpreted by its corresponding
  subformat, and subformat-dependent pattern rules apply. For example,
  pattern string `{1,number,$'#',##}`
  (SubformatPattern with underline) will produce a number format
  with the pound-sign quoted, with a result such as: `$#31,45`. Refer to each Format subclass documentation for
  details.

  Any unmatched quote is treated as closed at the end of the given
  pattern. For example, pattern string `'{0}` is treated as
  pattern `'{0}'`.

  Any curly braces within an unquoted pattern must be balanced. For
  example, `ab {0} de` and `ab '}' de` are
  valid patterns, but `ab {0'}' de`, `ab } de`
  and `''{''` are not.

  Warning:The rules for using quotes within message
  format patterns unfortunately have shown to be somewhat confusing.
  In particular, it isn't always obvious to localizers whether single
  quotes need to be doubled or not. Make sure to inform localizers about
  the rules, and tell them (for example, by using comments in resource
  bundle source files) which strings will be processed by MessageFormat.
  Note that localizers may need to use single quotes in translated
  strings where the original version doesn't have them.


  The ArgumentIndex value is a non-negative integer written
  using the digits '0' through '9', and represents an index into the
  arguments array passed to the format methods
  or the result array returned by the parse methods.

  The FormatType and FormatStyle values are used to create
  a Format instance for the format element. The following
  table shows how the values map to Format instances. Combinations not
  shown in the table are illegal. A SubformatPattern must
  be a valid pattern string for the Format subclass used.



        FormatType
        FormatStyle
        Subformat Created

        (none)
        (none)
        null

        number
        (none)
        NumberFormat.getInstance(getLocale())

        integer
        NumberFormat.getIntegerInstance(getLocale())

        currency
        NumberFormat.getCurrencyInstance(getLocale())

        percent
        NumberFormat.getPercentInstance(getLocale())

        SubformatPattern
        new DecimalFormat(subformatPattern, DecimalFormatSymbols.getInstance(getLocale()))

        date
        (none)
        DateFormat.getDateInstance(DateFormat.DEFAULT, getLocale())

        short
        DateFormat.getDateInstance(DateFormat.SHORT, getLocale())

        medium
        DateFormat.getDateInstance(DateFormat.DEFAULT, getLocale())

        long
        DateFormat.getDateInstance(DateFormat.LONG, getLocale())

        full
        DateFormat.getDateInstance(DateFormat.FULL, getLocale())

        SubformatPattern
        new SimpleDateFormat(subformatPattern, getLocale())

        time
        (none)
        DateFormat.getTimeInstance(DateFormat.DEFAULT, getLocale())

        short
        DateFormat.getTimeInstance(DateFormat.SHORT, getLocale())

        medium
        DateFormat.getTimeInstance(DateFormat.DEFAULT, getLocale())

        long
        DateFormat.getTimeInstance(DateFormat.LONG, getLocale())

        full
        DateFormat.getTimeInstance(DateFormat.FULL, getLocale())

        SubformatPattern
        new SimpleDateFormat(subformatPattern, getLocale())

        choice
        SubformatPattern
        new ChoiceFormat(subformatPattern)


  Usage Information


  Here are some examples of usage.
  In real internationalized programs, the message format pattern and other
  static strings will, of course, be obtained from resource bundles.
  Other parameters will be dynamically determined at runtime.

  The first example uses the static method MessageFormat.format,
  which internally creates a MessageFormat for one-time use:


  int planet = 7;
  String event = `a disturbance in the Force`;

  String result = MessageFormat.format(
      `At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.`,
      planet, new Date(), event);
  The output is:


  At 12:30 PM on Jul 3, 2053, there was a disturbance in the Force on planet 7.


  The following example creates a MessageFormat instance that
  can be used repeatedly:


  int fileCount = 1273;
  String diskName = `MyDisk`;
  Object[] testArgs = {new Long(fileCount), diskName};

  MessageFormat form = new MessageFormat(
      `The disk \`{1}\` contains {0} file(s).`);

  System.out.println(form.format(testArgs));
  The output with different values for fileCount:


  The disk `MyDisk` contains 0 file(s).
  The disk `MyDisk` contains 1 file(s).
  The disk `MyDisk` contains 1,273 file(s).


  For more sophisticated patterns, you can use a ChoiceFormat
  to produce correct forms for singular and plural:


  MessageFormat form = new MessageFormat(`The disk \`{1}\` contains {0}.`);
  double[] filelimits = {0,1,2};
  String[] filepart = {`no files`,`one file`,`{0,number} files`};
  ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
  form.setFormatByArgumentIndex(0, fileform);

  int fileCount = 1273;
  String diskName = `MyDisk`;
  Object[] testArgs = {new Long(fileCount), diskName};

  System.out.println(form.format(testArgs));
  The output with different values for fileCount:


  The disk `MyDisk` contains no files.
  The disk `MyDisk` contains one file.
  The disk `MyDisk` contains 1,273 files.


  You can create the ChoiceFormat programmatically, as in the
  above example, or by using a pattern. See ChoiceFormat
  for more information.


  form.applyPattern(
     `There {0,choice,0#are no files|1#is one file|1<are {0,number,integer} files}.`);


  Note: As we see above, the string produced
  by a ChoiceFormat in MessageFormat is treated as special;
  occurrences of '{' are used to indicate subformats, and cause recursion.
  If you create both a MessageFormat and ChoiceFormat
  programmatically (instead of using the string patterns), then be careful not to
  produce a format that recurses on itself, which will cause an infinite loop.

  When a single argument is parsed more than once in the string, the last match
  will be the final result of the parsing.  For example,


  MessageFormat mf = new MessageFormat(`{0,number,#.##}, {0,number,#.#}`);
  Object[] objs = {new Double(3.1415)};
  String result = mf.format( objs );
  // result now equals `3.14, 3.1`
  objs = null;
  objs = mf.parse(result, new ParsePosition(0));
  // objs now equals {new Double(3.1)}


  Likewise, parsing with a MessageFormat object using patterns containing
  multiple occurrences of the same argument would return the last match.  For
  example,


  MessageFormat mf = new MessageFormat(`{0}, {0}, {0}`);
  String forParsing = `x, y, z`;
  Object[] objs = mf.parse(forParsing, new ParsePosition(0));
  // result now equals {new String(`z`)}

  Synchronization


  Message formats are not synchronized.
  It is recommended to create separate format instances for each thread.
  If multiple threads access a format concurrently, it must be synchronized
  externally."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text MessageFormat]))

(defn ->message-format
  "Constructor.

  Constructs a MessageFormat for the specified locale and
   pattern.
   The constructor first sets the locale, then parses the pattern and
   creates a list of subformats for the format elements contained in it.
   Patterns and their interpretation are specified in the
   class description.

  pattern - the pattern for this message format - `java.lang.String`
  locale - the locale for this message format - `java.util.Locale`

  throws: java.lang.IllegalArgumentException - if the pattern is invalid"
  ([^java.lang.String pattern ^java.util.Locale locale]
    (new MessageFormat pattern locale))
  ([^java.lang.String pattern]
    (new MessageFormat pattern)))

(defn *format
  "Creates a MessageFormat with the given pattern and uses it
   to format the given arguments. This is equivalent to

       (new MessageFormat(pattern)).format(arguments, new StringBuffer(), null).toString()

  pattern - the pattern string - `java.lang.String`
  arguments - object(s) to format - `java.lang.Object`

  returns: the formatted string - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the pattern is invalid, or if an argument in the arguments array is not of the type expected by the format element(s) that use it."
  ([^java.lang.String pattern ^java.lang.Object arguments]
    (MessageFormat/format pattern arguments)))

(defn set-format-by-argument-index
  "Sets the format to use for the format elements within the
   previously set pattern string that use the given argument
   index.
   The argument index is part of the format element definition and
   represents an index into the arguments array passed
   to the format methods or the result array returned
   by the parse methods.

   If the argument index is used for more than one format element
   in the pattern string, then the new format is used for all such
   format elements. If the argument index is not used for any format
   element in the pattern string, then the new format is ignored.

  argument-index - the argument index for which to use the new format - `int`
  new-format - the new format to use - `java.text.Format`"
  ([^java.text.MessageFormat this ^Integer argument-index ^java.text.Format new-format]
    (-> this (.setFormatByArgumentIndex argument-index new-format))))

(defn get-formats
  "Gets the formats used for the format elements in the
   previously set pattern string.
   The order of formats in the returned array corresponds to
   the order of format elements in the pattern string.

   Since the order of format elements in a pattern string often
   changes during localization, it's generally better to use the
   getFormatsByArgumentIndex
   method, which assumes an order of formats corresponding to the
   order of elements in the arguments array passed to
   the format methods or the result array returned by
   the parse methods.

  returns: the formats used for the format elements in the pattern - `java.text.Format[]`"
  ([^java.text.MessageFormat this]
    (-> this (.getFormats))))

(defn parse-object
  "Parses text from a string to produce an object array.

   The method attempts to parse text starting at the index given by
   pos.
   If parsing succeeds, then the index of pos is updated
   to the index after the last character used (parsing does not necessarily
   use all characters up to the end of the string), and the parsed
   object array is returned. The updated pos can be used to
   indicate the starting point for the next call to this method.
   If an error occurs, then the index of pos is not
   changed, the error index of pos is set to the index of
   the character where the error occurred, and null is returned.

   See the parse(String, ParsePosition) method for more information
   on message parsing.

  source - A String, part of which should be parsed. - `java.lang.String`
  pos - A ParsePosition object with index and error index information as described above. - `java.text.ParsePosition`

  returns: An Object array parsed from the string. In case of
           error, returns null. - `java.lang.Object`

  throws: java.lang.NullPointerException - if pos is null."
  ([^java.text.MessageFormat this ^java.lang.String source ^java.text.ParsePosition pos]
    (-> this (.parseObject source pos))))

(defn set-formats-by-argument-index
  "Sets the formats to use for the values passed into
   format methods or returned from parse
   methods. The indices of elements in newFormats
   correspond to the argument indices used in the previously set
   pattern string.
   The order of formats in newFormats thus corresponds to
   the order of elements in the arguments array passed
   to the format methods or the result array returned
   by the parse methods.

   If an argument index is used for more than one format element
   in the pattern string, then the corresponding new format is used
   for all such format elements. If an argument index is not used
   for any format element in the pattern string, then the
   corresponding new format is ignored. If fewer formats are provided
   than needed, then only the formats for argument indices less
   than newFormats.length are replaced.

  new-formats - the new formats to use - `java.text.Format[]`

  throws: java.lang.NullPointerException - if newFormats is null"
  ([^java.text.MessageFormat this ^java.text.Format[] new-formats]
    (-> this (.setFormatsByArgumentIndex new-formats))))

(defn set-format
  "Sets the format to use for the format element with the given
   format element index within the previously set pattern string.
   The format element index is the zero-based number of the format
   element counting from the start of the pattern string.

   Since the order of format elements in a pattern string often
   changes during localization, it is generally better to use the
   setFormatByArgumentIndex
   method, which accesses format elements based on the argument
   index they specify.

  format-element-index - the index of a format element within the pattern - `int`
  new-format - the format to use for the specified format element - `java.text.Format`

  throws: java.lang.ArrayIndexOutOfBoundsException - if formatElementIndex is equal to or larger than the number of format elements in the pattern string"
  ([^java.text.MessageFormat this ^Integer format-element-index ^java.text.Format new-format]
    (-> this (.setFormat format-element-index new-format))))

(defn get-locale
  "Gets the locale that's used when creating or comparing subformats.

  returns: the locale used when creating or comparing subformats - `java.util.Locale`"
  ([^java.text.MessageFormat this]
    (-> this (.getLocale))))

(defn to-pattern
  "Returns a pattern representing the current state of the message format.
   The string is constructed from internal information and therefore
   does not necessarily equal the previously applied pattern.

  returns: a pattern representing the current state of the message format - `java.lang.String`"
  ([^java.text.MessageFormat this]
    (-> this (.toPattern))))

(defn format-to-character-iterator
  "Formats an array of objects and inserts them into the
   MessageFormat's pattern, producing an
   AttributedCharacterIterator.
   You can use the returned AttributedCharacterIterator
   to build the resulting String, as well as to determine information
   about the resulting String.

   The text of the returned AttributedCharacterIterator is
   the same that would be returned by

       format(arguments, new StringBuffer(), null).toString()


   In addition, the AttributedCharacterIterator contains at
   least attributes indicating where text was generated from an
   argument in the arguments array. The keys of these attributes are of
   type MessageFormat.Field, their values are
   Integer objects indicating the index in the arguments
   array of the argument from which the text was generated.

   The attributes/value from the underlying Format
   instances that MessageFormat uses will also be
   placed in the resulting AttributedCharacterIterator.
   This allows you to not only find where an argument is placed in the
   resulting String, but also which fields it contains in turn.

  arguments - an array of objects to be formatted and substituted. - `java.lang.Object`

  returns: AttributedCharacterIterator describing the formatted value. - `java.text.AttributedCharacterIterator`

  throws: java.lang.NullPointerException - if arguments is null."
  ([^java.text.MessageFormat this ^java.lang.Object arguments]
    (-> this (.formatToCharacterIterator arguments))))

(defn set-locale
  "Sets the locale to be used when creating or comparing subformats.
   This affects subsequent calls

   to the applyPattern
       and toPattern methods if format elements specify
       a format type and therefore have the subformats created in the
       applyPattern method, as well as
   to the format and
       formatToCharacterIterator methods
       if format elements do not specify a format type and therefore have
       the subformats created in the formatting methods.

   Subformats that have already been created are not affected.

  locale - the locale to be used when creating or comparing subformats - `java.util.Locale`"
  ([^java.text.MessageFormat this ^java.util.Locale locale]
    (-> this (.setLocale locale))))

(defn clone
  "Creates and returns a copy of this object.

  returns: a clone of this instance. - `java.lang.Object`"
  ([^java.text.MessageFormat this]
    (-> this (.clone))))

(defn parse
  "Parses the string.

   Caveats: The parse may fail in a number of circumstances.
   For example:

   If one of the arguments does not occur in the pattern.
   If the format of an argument loses information, such as
       with a choice format where a large number formats to `many`.
   Does not yet handle recursion (where
       the substituted strings contain {n} references.)
   Will not always find a match (or the correct match)
       if some part of the parse is ambiguous.
       For example, if the pattern `{1},{2}` is used with the
       string arguments {`a,b`, `c`}, it will format as `a,b,c`.
       When the result is parsed, it will return {`a`, `b,c`}.
   If a single argument is parsed more than once in the string,
       then the later parse wins.

   When the parse fails, use ParsePosition.getErrorIndex() to find out
   where in the string the parsing failed.  The returned error
   index is the starting offset of the sub-patterns that the string
   is comparing with.  For example, if the parsing string `AAA {0} BBB`
   is comparing against the pattern `AAD {0} BBB`, the error index is
   0. When an error occurs, the call to this method will return null.
   If the source is null, return an empty array.

  source - the string to parse - `java.lang.String`
  pos - the parse position - `java.text.ParsePosition`

  returns: an array of parsed objects - `java.lang.Object[]`"
  ([^java.text.MessageFormat this ^java.lang.String source ^java.text.ParsePosition pos]
    (-> this (.parse source pos)))
  ([^java.text.MessageFormat this ^java.lang.String source]
    (-> this (.parse source))))

(defn hash-code
  "Generates a hash code for the message format object.

  returns: a hash code value for this object. - `int`"
  ([^java.text.MessageFormat this]
    (-> this (.hashCode))))

(defn set-formats
  "Sets the formats to use for the format elements in the
   previously set pattern string.
   The order of formats in newFormats corresponds to
   the order of format elements in the pattern string.

   If more formats are provided than needed by the pattern string,
   the remaining ones are ignored. If fewer formats are provided
   than needed, then only the first newFormats.length
   formats are replaced.

   Since the order of format elements in a pattern string often
   changes during localization, it is generally better to use the
   setFormatsByArgumentIndex
   method, which assumes an order of formats corresponding to the
   order of elements in the arguments array passed to
   the format methods or the result array returned by
   the parse methods.

  new-formats - the new formats to use - `java.text.Format[]`

  throws: java.lang.NullPointerException - if newFormats is null"
  ([^java.text.MessageFormat this ^java.text.Format[] new-formats]
    (-> this (.setFormats new-formats))))

(defn apply-pattern
  "Sets the pattern used by this message format.
   The method parses the pattern and creates a list of subformats
   for the format elements contained in it.
   Patterns and their interpretation are specified in the
   class description.

  pattern - the pattern for this message format - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the pattern is invalid"
  ([^java.text.MessageFormat this ^java.lang.String pattern]
    (-> this (.applyPattern pattern))))

(defn equals
  "Equality comparison between two message format objects

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([^java.text.MessageFormat this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn format
  "Formats an array of objects and appends the MessageFormat's
   pattern, with format elements replaced by the formatted objects, to the
   provided StringBuffer.

   The text substituted for the individual format elements is derived from
   the current subformat of the format element and the
   arguments element at the format element's argument index
   as indicated by the first matching line of the following table. An
   argument is unavailable if arguments is
   null or has fewer than argumentIndex+1 elements.



         Subformat
         Argument
         Formatted Text

         any
         unavailable
         `{`  argumentIndex  `}`

         any
         null
         `null`

         instanceof ChoiceFormat
         any
         subformat.format(argument).indexOf('{') >= 0 ?
             (new MessageFormat(subformat.format(argument), getLocale())).format(argument) :
             subformat.format(argument)

         != null
         any
         subformat.format(argument)

         null
         instanceof Number
         NumberFormat.getInstance(getLocale()).format(argument)

         null
         instanceof Date
         DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, getLocale()).format(argument)

         null
         instanceof String
         argument

         null
         any
         argument.toString()


   If pos is non-null, and refers to
   Field.ARGUMENT, the location of the first formatted
   string will be returned.

  arguments - an array of objects to be formatted and substituted. - `java.lang.Object[]`
  result - where text is appended. - `java.lang.StringBuffer`
  pos - On input: an alignment field, if desired. On output: the offsets of the alignment field. - `java.text.FieldPosition`

  returns: the string buffer passed in as result, with formatted
   text appended - `java.lang.StringBuffer`

  throws: java.lang.IllegalArgumentException - if an argument in the arguments array is not of the type expected by the format element(s) that use it."
  ([^java.text.MessageFormat this ^java.lang.Object[] arguments ^java.lang.StringBuffer result ^java.text.FieldPosition pos]
    (-> this (.format arguments result pos))))

(defn get-formats-by-argument-index
  "Gets the formats used for the values passed into
   format methods or returned from parse
   methods. The indices of elements in the returned array
   correspond to the argument indices used in the previously set
   pattern string.
   The order of formats in the returned array thus corresponds to
   the order of elements in the arguments array passed
   to the format methods or the result array returned
   by the parse methods.

   If an argument index is used for more than one format element
   in the pattern string, then the format used for the last such
   format element is returned in the array. If an argument index
   is not used for any format element in the pattern string, then
   null is returned in the array.

  returns: the formats used for the arguments within the pattern - `java.text.Format[]`"
  ([^java.text.MessageFormat this]
    (-> this (.getFormatsByArgumentIndex))))

