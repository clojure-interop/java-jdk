(ns jdk.text.DateFormat
  "DateFormat is an abstract class for date/time formatting subclasses which
  formats and parses dates or time in a language-independent manner.
  The date/time formatting subclass, such as SimpleDateFormat, allows for
  formatting (i.e., date → text), parsing (text → date), and
  normalization.  The date is represented as a Date object or
  as the milliseconds since January 1, 1970, 00:00:00 GMT.

  DateFormat provides many class methods for obtaining default date/time
  formatters based on the default or a given locale and a number of formatting
  styles. The formatting styles include FULL, LONG, MEDIUM, and SHORT. More
  detail and examples of using these styles are provided in the method
  descriptions.

  DateFormat helps you to format and parse dates for any locale.
  Your code can be completely independent of the locale conventions for
  months, days of the week, or even the calendar format: lunar vs. solar.

  To format a date for the current Locale, use one of the
  static factory methods:



  myString = DateFormat.getDateInstance().format(myDate);

  If you are formatting multiple dates, it is
  more efficient to get the format and use it multiple times so that
  the system doesn't have to fetch the information about the local
  language and country conventions multiple times.



  DateFormat df = DateFormat.getDateInstance();
  for (int i = 0; i < myDate.length; +i) {
      output.println(df.format(myDate[i])  \"; \");
  }

  To format a date for a different Locale, specify it in the
  call to getDateInstance().



  DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);

  You can use a DateFormat to parse also.



  myDate = df.parse(myString);

  Use getDateInstance to get the normal date format for that country.
  There are other static factory methods available.
  Use getTimeInstance to get the time format for that country.
  Use getDateTimeInstance to get a date and time format. You can pass in
  different options to these factory methods to control the length of the
  result; from SHORT to MEDIUM to LONG to FULL. The exact result depends
  on the locale, but generally:
  SHORT is completely numeric, such as 12.13.52 or 3:30pm
  MEDIUM is longer, such as Jan 12, 1952
  LONG is longer, such as January 12, 1952 or 3:30:32pm
  FULL is pretty completely specified, such as
  Tuesday, April 12, 1952 AD or 3:30:42pm PST.


  You can also set the time zone on the format if you wish.
  If you want even more control over the format or parsing,
  (or want to give your users more control),
  you can try casting the DateFormat you get from the factory methods
  to a SimpleDateFormat. This will work for the majority
  of countries; just remember to put it in a try block in case you
  encounter an unusual one.

  You can also use forms of the parse and format methods with
  ParsePosition and FieldPosition to
  allow you to
  progressively parse through pieces of a string.
  align any particular field, or find out where it is for selection
  on the screen.


  Synchronization


  Date formats are not synchronized.
  It is recommended to create separate format instances for each thread.
  If multiple threads access a format concurrently, it must be synchronized
  externally."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text DateFormat]))

(def *-era-field
  "Static Constant.

  Useful constant for ERA field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/ERA_FIELD)

(def *-year-field
  "Static Constant.

  Useful constant for YEAR field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/YEAR_FIELD)

(def *-month-field
  "Static Constant.

  Useful constant for MONTH field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/MONTH_FIELD)

(def *-date-field
  "Static Constant.

  Useful constant for DATE field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/DATE_FIELD)

(def *-hour-of-day-1-field
  "Static Constant.

  Useful constant for one-based HOUR_OF_DAY field alignment.
   Used in FieldPosition of date/time formatting.
   HOUR_OF_DAY1_FIELD is used for the one-based 24-hour clock.
   For example, 23:59  01:00 results in 24:59.

  type: int"
  DateFormat/HOUR_OF_DAY1_FIELD)

(def *-hour-of-day-0-field
  "Static Constant.

  Useful constant for zero-based HOUR_OF_DAY field alignment.
   Used in FieldPosition of date/time formatting.
   HOUR_OF_DAY0_FIELD is used for the zero-based 24-hour clock.
   For example, 23:59  01:00 results in 00:59.

  type: int"
  DateFormat/HOUR_OF_DAY0_FIELD)

(def *-minute-field
  "Static Constant.

  Useful constant for MINUTE field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/MINUTE_FIELD)

(def *-second-field
  "Static Constant.

  Useful constant for SECOND field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/SECOND_FIELD)

(def *-millisecond-field
  "Static Constant.

  Useful constant for MILLISECOND field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/MILLISECOND_FIELD)

(def *-day-of-week-field
  "Static Constant.

  Useful constant for DAY_OF_WEEK field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/DAY_OF_WEEK_FIELD)

(def *-day-of-year-field
  "Static Constant.

  Useful constant for DAY_OF_YEAR field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/DAY_OF_YEAR_FIELD)

(def *-day-of-week-in-month-field
  "Static Constant.

  Useful constant for DAY_OF_WEEK_IN_MONTH field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/DAY_OF_WEEK_IN_MONTH_FIELD)

(def *-week-of-year-field
  "Static Constant.

  Useful constant for WEEK_OF_YEAR field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/WEEK_OF_YEAR_FIELD)

(def *-week-of-month-field
  "Static Constant.

  Useful constant for WEEK_OF_MONTH field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/WEEK_OF_MONTH_FIELD)

(def *-am-pm-field
  "Static Constant.

  Useful constant for AM_PM field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/AM_PM_FIELD)

(def *-hour-1-field
  "Static Constant.

  Useful constant for one-based HOUR field alignment.
   Used in FieldPosition of date/time formatting.
   HOUR1_FIELD is used for the one-based 12-hour clock.
   For example, 11:30 PM  1 hour results in 12:30 AM.

  type: int"
  DateFormat/HOUR1_FIELD)

(def *-hour-0-field
  "Static Constant.

  Useful constant for zero-based HOUR field alignment.
   Used in FieldPosition of date/time formatting.
   HOUR0_FIELD is used for the zero-based 12-hour clock.
   For example, 11:30 PM  1 hour results in 00:30 AM.

  type: int"
  DateFormat/HOUR0_FIELD)

(def *-timezone-field
  "Static Constant.

  Useful constant for TIMEZONE field alignment.
   Used in FieldPosition of date/time formatting.

  type: int"
  DateFormat/TIMEZONE_FIELD)

(def *-full
  "Static Constant.

  Constant for full style pattern.

  type: int"
  DateFormat/FULL)

(def *-long
  "Static Constant.

  Constant for long style pattern.

  type: int"
  DateFormat/LONG)

(def *-medium
  "Static Constant.

  Constant for medium style pattern.

  type: int"
  DateFormat/MEDIUM)

(def *-short
  "Static Constant.

  Constant for short style pattern.

  type: int"
  DateFormat/SHORT)

(def *-default
  "Static Constant.

  Constant for default style pattern.  Its value is MEDIUM.

  type: int"
  DateFormat/DEFAULT)

(defn *get-time-instance
  "Gets the time formatter with the given formatting style
   for the given locale.

  style - the given formatting style. For example, SHORT for \"h:mm a\" in the US locale. - `int`
  a-locale - the given locale. - `java.util.Locale`

  returns: a time formatter. - `java.text.DateFormat`"
  (^java.text.DateFormat [^Integer style ^java.util.Locale a-locale]
    (DateFormat/getTimeInstance style a-locale))
  (^java.text.DateFormat [^Integer style]
    (DateFormat/getTimeInstance style))
  (^java.text.DateFormat []
    (DateFormat/getTimeInstance )))

(defn *get-date-instance
  "Gets the date formatter with the given formatting style
   for the given locale.

  style - the given formatting style. For example, SHORT for \"M/d/yy\" in the US locale. - `int`
  a-locale - the given locale. - `java.util.Locale`

  returns: a date formatter. - `java.text.DateFormat`"
  (^java.text.DateFormat [^Integer style ^java.util.Locale a-locale]
    (DateFormat/getDateInstance style a-locale))
  (^java.text.DateFormat [^Integer style]
    (DateFormat/getDateInstance style))
  (^java.text.DateFormat []
    (DateFormat/getDateInstance )))

(defn *get-date-time-instance
  "Gets the date/time formatter with the given formatting styles
   for the given locale.

  date-style - the given date formatting style. - `int`
  time-style - the given time formatting style. - `int`
  a-locale - the given locale. - `java.util.Locale`

  returns: a date/time formatter. - `java.text.DateFormat`"
  (^java.text.DateFormat [^Integer date-style ^Integer time-style ^java.util.Locale a-locale]
    (DateFormat/getDateTimeInstance date-style time-style a-locale))
  (^java.text.DateFormat [^Integer date-style ^Integer time-style]
    (DateFormat/getDateTimeInstance date-style time-style))
  (^java.text.DateFormat []
    (DateFormat/getDateTimeInstance )))

(defn *get-instance
  "Get a default date/time formatter that uses the SHORT style for both the
   date and the time.

  returns: a date/time formatter - `java.text.DateFormat`"
  (^java.text.DateFormat []
    (DateFormat/getInstance )))

(defn *get-available-locales
  "Returns an array of all locales for which the
   get*Instance methods of this class can return
   localized instances.
   The returned array represents the union of locales supported by the Java
   runtime and by installed
   DateFormatProvider implementations.
   It must contain at least a Locale instance equal to
   Locale.US.

  returns: An array of locales for which localized
           DateFormat instances are available. - `java.util.Locale[]`"
  ([]
    (DateFormat/getAvailableLocales )))

(defn set-time-zone
  "Sets the time zone for the calendar of this DateFormat object.
   This method is equivalent to the following call.


   getCalendar().setTimeZone(zone)

   The TimeZone set by this method is overwritten by a
   setCalendar call.

   The TimeZone set by this method may be overwritten as
   a result of a call to the parse method.

  zone - the given new time zone. - `java.util.TimeZone`"
  ([^DateFormat this ^java.util.TimeZone zone]
    (-> this (.setTimeZone zone))))

(defn set-number-format
  "Allows you to set the number formatter.

  new-number-format - the given new NumberFormat. - `java.text.NumberFormat`"
  ([^DateFormat this ^java.text.NumberFormat new-number-format]
    (-> this (.setNumberFormat new-number-format))))

(defn parse-object
  "Parses text from a string to produce a Date.

   The method attempts to parse text starting at the index given by
   pos.
   If parsing succeeds, then the index of pos is updated
   to the index after the last character used (parsing does not necessarily
   use all characters up to the end of the string), and the parsed
   date is returned. The updated pos can be used to
   indicate the starting point for the next call to this method.
   If an error occurs, then the index of pos is not
   changed, the error index of pos is set to the index of
   the character where the error occurred, and null is returned.

   See the parse(String, ParsePosition) method for more information
   on date parsing.

  source - A String, part of which should be parsed. - `java.lang.String`
  pos - A ParsePosition object with index and error index information as described above. - `java.text.ParsePosition`

  returns: A Date parsed from the string. In case of
           error, returns null. - `java.lang.Object`

  throws: java.lang.NullPointerException - if pos is null."
  (^java.lang.Object [^DateFormat this ^java.lang.String source ^java.text.ParsePosition pos]
    (-> this (.parseObject source pos))))

(defn set-lenient
  "Specify whether or not date/time parsing is to be lenient.  With
   lenient parsing, the parser may use heuristics to interpret inputs that
   do not precisely match this object's format.  With strict parsing,
   inputs must match this object's format.

   This method is equivalent to the following call.


   getCalendar().setLenient(lenient)

   This leniency value is overwritten by a call to setCalendar().

  lenient - when true, parsing is lenient - `boolean`"
  ([^DateFormat this ^Boolean lenient]
    (-> this (.setLenient lenient))))

(defn get-calendar
  "Gets the calendar associated with this date/time formatter.

  returns: the calendar associated with this date/time formatter. - `java.util.Calendar`"
  (^java.util.Calendar [^DateFormat this]
    (-> this (.getCalendar))))

(defn lenient?
  "Tell whether date/time parsing is to be lenient.
   This method is equivalent to the following call.


   getCalendar().isLenient()

  returns: true if the calendar is lenient;
           false otherwise. - `boolean`"
  (^Boolean [^DateFormat this]
    (-> this (.isLenient))))

(defn get-time-zone
  "Gets the time zone.
   This method is equivalent to the following call.


   getCalendar().getTimeZone()

  returns: the time zone associated with the calendar of DateFormat. - `java.util.TimeZone`"
  (^java.util.TimeZone [^DateFormat this]
    (-> this (.getTimeZone))))

(defn get-number-format
  "Gets the number formatter which this date/time formatter uses to
   format and parse a time.

  returns: the number formatter which this date/time formatter uses. - `java.text.NumberFormat`"
  (^java.text.NumberFormat [^DateFormat this]
    (-> this (.getNumberFormat))))

(defn set-calendar
  "Set the calendar to be used by this date format.  Initially, the default
   calendar for the specified or default locale is used.

   Any TimeZone and leniency values that have previously been set are
   overwritten by newCalendar's values.

  new-calendar - the new Calendar to be used by the date format - `java.util.Calendar`"
  ([^DateFormat this ^java.util.Calendar new-calendar]
    (-> this (.setCalendar new-calendar))))

(defn clone
  "Overrides Cloneable

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^DateFormat this]
    (-> this (.clone))))

(defn parse
  "Parse a date/time string according to the given parse position.  For
   example, a time text \"07/10/96 4:5 PM, PDT\" will be parsed into a Date
   that is equivalent to Date(837039900000L).

    By default, parsing is lenient: If the input is not in the form used
   by this object's format method but can still be parsed as a date, then
   the parse succeeds.  Clients may insist on strict adherence to the
   format by calling setLenient(false).

   This parsing operation uses the calendar to produce
   a Date. As a result, the calendar's date-time
   fields and the TimeZone value may have been
   overwritten, depending on subclass implementations. Any TimeZone value that has previously been set by a call to
   setTimeZone may need
   to be restored for further operations.

  source - The date/time string to be parsed - `java.lang.String`
  pos - On input, the position at which to start parsing; on output, the position at which parsing terminated, or the start position if the parse failed. - `java.text.ParsePosition`

  returns: A Date, or null if the input could not be parsed - `java.util.Date`"
  (^java.util.Date [^DateFormat this ^java.lang.String source ^java.text.ParsePosition pos]
    (-> this (.parse source pos)))
  (^java.util.Date [^DateFormat this ^java.lang.String source]
    (-> this (.parse source))))

(defn hash-code
  "Overrides hashCode

  returns: a hash code value for this object. - `int`"
  (^Integer [^DateFormat this]
    (-> this (.hashCode))))

(defn equals
  "Overrides equals

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^DateFormat this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn format
  "Overrides Format.
   Formats a time object into a time string. Examples of time objects
   are a time value expressed in milliseconds and a Date object.

  obj - must be a Number or a Date. - `java.lang.Object`
  to-append-to - the string buffer for the returning time string. - `java.lang.StringBuffer`
  field-position - keeps track of the position of the field within the returned string. On input: an alignment field, if desired. On output: the offsets of the alignment field. For example, given a time text \"1996.07.10 AD at 15:08:56 PDT\", if the given fieldPosition is DateFormat.YEAR_FIELD, the begin index and end index of fieldPosition will be set to 0 and 4, respectively. Notice that if the same time field appears more than once in a pattern, the fieldPosition will be set for the first occurrence of that time field. For instance, formatting a Date to the time string \"1 PM PDT (Pacific Daylight Time)\" using the pattern \"h a z (zzzz)\" and the alignment field DateFormat.TIMEZONE_FIELD, the begin index and end index of fieldPosition will be set to 5 and 8, respectively, for the first occurrence of the timezone pattern character 'z'. - `java.text.FieldPosition`

  returns: the string buffer passed in as toAppendTo, with formatted text appended. - `java.lang.StringBuffer`"
  (^java.lang.StringBuffer [^DateFormat this ^java.lang.Object obj ^java.lang.StringBuffer to-append-to ^java.text.FieldPosition field-position]
    (-> this (.format obj to-append-to field-position)))
  (^java.lang.String [^DateFormat this ^java.util.Date date]
    (-> this (.format date))))

