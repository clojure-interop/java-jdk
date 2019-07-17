(ns jdk.text.Format
  "Format is an abstract base class for formatting locale-sensitive
  information such as dates, messages, and numbers.


  Format defines the programming interface for formatting
  locale-sensitive objects into Strings (the
  format method) and for parsing Strings back
  into objects (the parseObject method).


  Generally, a format's parseObject method must be able to parse
  any string formatted by its format method. However, there may
  be exceptional cases where this is not possible. For example, a
  format method might create two adjacent integer numbers with
  no separator in between, and in this case the parseObject could
  not tell which digits belong to which number.

  Subclassing


  The Java Platform provides three specialized subclasses of Format--
  DateFormat, MessageFormat, and
  NumberFormat--for formatting dates, messages, and numbers,
  respectively.

  Concrete subclasses must implement three methods:

   format(Object obj, StringBuffer toAppendTo, FieldPosition pos)
   formatToCharacterIterator(Object obj)
   parseObject(String source, ParsePosition pos)

  These general methods allow polymorphic parsing and formatting of objects
  and are used, for example, by MessageFormat.
  Subclasses often also provide additional format methods for
  specific input types as well as parse methods for specific
  result types. Any parse method that does not take a
  ParsePosition argument should throw ParseException
  when no text in the required format is at the beginning of the input text.


  Most subclasses will also implement the following factory methods:


  getInstance for getting a useful format object appropriate
  for the current locale

  getInstance(Locale) for getting a useful format
  object appropriate for the specified locale

  In addition, some subclasses may also implement other
  getXxxxInstance methods for more specialized control. For
  example, the NumberFormat class provides
  getPercentInstance and getCurrencyInstance
  methods for getting specialized number formatters.


  Subclasses of Format that allow programmers to create objects
  for locales (with getInstance(Locale) for example)
  must also implement the following class method:



  public static Locale[] getAvailableLocales()



  And finally subclasses may define a set of constants to identify the various
  fields in the formatted output. These constants are used to create a FieldPosition
  object which identifies what information is contained in the field and its
  position in the formatted result. These constants should be named
  item_FIELD where item identifies
  the field. For examples of these constants, see ERA_FIELD and its
  friends in DateFormat.

  Synchronization


  Formats are generally not synchronized.
  It is recommended to create separate format instances for each thread.
  If multiple threads access a format concurrently, it must be synchronized
  externally."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text Format]))

(defn format
  "Formats an object and appends the resulting text to a given string
   buffer.
   If the pos argument identifies a field used by the format,
   then its indices are set to the beginning and end of the first such
   field encountered.

  obj - The object to format - `java.lang.Object`
  to-append-to - where the text is to be appended - `java.lang.StringBuffer`
  pos - A FieldPosition identifying a field in the formatted text - `java.text.FieldPosition`

  returns: the string buffer passed in as toAppendTo,
                 with formatted text appended - `java.lang.StringBuffer`

  throws: java.lang.NullPointerException - if toAppendTo or pos is null"
  ([this obj to-append-to pos]
    (-> this (.format obj to-append-to pos)))
  ([this obj]
    (-> this (.format obj))))

(defn format-to-character-iterator
  "Formats an Object producing an AttributedCharacterIterator.
   You can use the returned AttributedCharacterIterator
   to build the resulting String, as well as to determine information
   about the resulting String.

   Each attribute key of the AttributedCharacterIterator will be of type
   Field. It is up to each Format implementation
   to define what the legal values are for each attribute in the
   AttributedCharacterIterator, but typically the attribute
   key is also used as the attribute value.
   The default implementation creates an
   AttributedCharacterIterator with no attributes. Subclasses
   that support fields should override this and create an
   AttributedCharacterIterator with meaningful attributes.

  obj - The object to format - `java.lang.Object`

  returns: AttributedCharacterIterator describing the formatted value. - `java.text.AttributedCharacterIterator`

  throws: java.lang.NullPointerException - if obj is null."
  ([this obj]
    (-> this (.formatToCharacterIterator obj))))

(defn parse-object
  "Parses text from a string to produce an object.

   The method attempts to parse text starting at the index given by
   pos.
   If parsing succeeds, then the index of pos is updated
   to the index after the last character used (parsing does not necessarily
   use all characters up to the end of the string), and the parsed
   object is returned. The updated pos can be used to
   indicate the starting point for the next call to this method.
   If an error occurs, then the index of pos is not
   changed, the error index of pos is set to the index of
   the character where the error occurred, and null is returned.

  source - A String, part of which should be parsed. - `java.lang.String`
  pos - A ParsePosition object with index and error index information as described above. - `java.text.ParsePosition`

  returns: An Object parsed from the string. In case of
           error, returns null. - `java.lang.Object`

  throws: java.lang.NullPointerException - if pos is null."
  ([this source pos]
    (-> this (.parseObject source pos)))
  ([this source]
    (-> this (.parseObject source))))

(defn clone
  "Creates and returns a copy of this object.

  returns: a clone of this instance. - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

