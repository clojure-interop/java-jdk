(ns javax.xml.datatype.XMLGregorianCalendar
  "Representation for W3C XML Schema 1.0 date/time datatypes.
  Specifically, these date/time datatypes are
  DatatypeConstants.DATETIME,
  DatatypeConstants.TIME,
  DatatypeConstants.DATE,
  DatatypeConstants.GYEARMONTH,
  DatatypeConstants.GMONTHDAY,
  DatatypeConstants.GYEAR,
  DatatypeConstants.GMONTH, and
  DatatypeConstants.GDAY
  defined in the XML Namespace
  `http://www.w3.org/2001/XMLSchema`.
  These datatypes are normatively defined in
  W3C XML Schema 1.0 Part 2, Section 3.2.7-14.

  The table below defines the mapping between XML Schema 1.0
  date/time datatype fields and this class' fields. It also summarizes
  the value constraints for the date and time fields defined in
  W3C XML Schema 1.0 Part 2, Appendix D,
  ISO 8601 Date and Time Formats.






          Date/Time Datatype Field Mapping Between XML Schema 1.0 and Java Representation





        XML Schema 1.0
            datatype
             field
        RelatedXMLGregorianCalendarAccessor(s)
        Value Range


        year
         getYear()  getEon() or
             getEonAndYear()

         getYear() is a value between -(10^9-1) to (10^9)-1
             or DatatypeConstants.FIELD_UNDEFINED.
             getEon() is high order year value in billion of years.
             getEon() has values greater than or equal to (10^9) or less than or equal to -(10^9).
             A value of null indicates field is undefined.
             Given that XML Schema 1.0 errata states that the year zero
             will be a valid lexical value in a future version of XML Schema,
             this class allows the year field to be set to zero. Otherwise,
             the year field value is handled exactly as described
             in the errata and [ISO-8601-1988]. Note that W3C XML Schema 1.0
             validation does not allow for the year field to have a value of zero.



        month
         getMonth()
         1 to 12 or DatatypeConstants.FIELD_UNDEFINED


        day
         getDay()
         Independent of month, max range is 1 to 31 or DatatypeConstants.FIELD_UNDEFINED.
             The normative value constraint stated relative to month
             field's value is in W3C XML Schema 1.0 Part 2, Appendix D.



        hour
        getHour()

          0 to 23 or DatatypeConstants.FIELD_UNDEFINED.
          An hour value of 24 is allowed to be set in the lexical space provided the minute and second
          field values are zero. However, an hour value of 24 is not allowed in value space and will be
          transformed to represent the value of the first instance of the following day as per

          XML Schema Part 2: Datatypes Second Edition, 3.2 Primitive datatypes.



        minute
         getMinute()
         0 to 59 or DatatypeConstants.FIELD_UNDEFINED


        second

          getSecond()  getMillisecond()/1000 or
          getSecond()  getFractionalSecond()


          getSecond() from 0 to 60 or DatatypeConstants.FIELD_UNDEFINED.
          (Note: 60 only allowable for leap second.)
          getFractionalSecond() allows for infinite precision over the range from 0.0 to 1.0 when
          the getSecond() is defined.
          FractionalSecond is optional and has a value of null when it is undefined.
             getMillisecond() is the convenience
             millisecond precision of value of getFractionalSecond().



        timezone
         getTimezone()
         Number of minutes or DatatypeConstants.FIELD_UNDEFINED.
          Value range from -14 hours (-14 * 60 minutes) to 14 hours (14 * 60 minutes).





  All maximum value space constraints listed for the fields in the table
  above are checked by factory methods, @{link DatatypeFactory},
  setter methods and parse methods of
  this class. IllegalArgumentException is thrown when a
  parameter's value is outside the value constraint for the field or
  if the composite
  values constitute an invalid XMLGregorianCalendar instance (for example, if
  the 31st of June is specified).


  The following operations are defined for this class:

    accessors/mutators for independent date/time fields
    conversion between this class and W3C XML Schema 1.0 lexical representation,
      toString(), DatatypeFactory.newXMLGregorianCalendar(String lexicalRepresentation)
    conversion between this class and GregorianCalendar,
      toGregorianCalendar(java.util.TimeZone timezone, java.util.Locale aLocale, XMLGregorianCalendar defaults),
      DatatypeFactory
    partial order relation comparator method, compare(XMLGregorianCalendar xmlGregorianCalendar)
    equals(Object) defined relative to compare(XMLGregorianCalendar xmlGregorianCalendar).
    addition operation with Duration
       instance as defined in
       W3C XML Schema 1.0 Part 2, Appendix E, Adding durations to dateTimes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.datatype XMLGregorianCalendar]))

(defn ->xml-gregorian-calendar
  "Constructor.

  Default no-arg constructor.

   Note: Always use the DatatypeFactory to
   construct an instance of XMLGregorianCalendar.
   The constructor on this class cannot be guaranteed to
   produce an object with a consistent state and may be
   removed in the future."
  (^XMLGregorianCalendar []
    (new XMLGregorianCalendar )))

(defn compare
  "Compare two instances of W3C XML Schema 1.0 date/time datatypes
   according to partial order relation defined in
   W3C XML Schema 1.0 Part 2, Section 3.2.7.3,
   Order relation on dateTime.

   xsd:dateTime datatype field mapping to accessors of
   this class are defined in
   date/time field mapping table.

  xml-gregorian-calendar - Instance of XMLGregorianCalendar to compare - `javax.xml.datatype.XMLGregorianCalendar`

  returns: The relationship between this XMLGregorianCalendar and
     the specified xmlGregorianCalendar as
     DatatypeConstants.LESSER,
     DatatypeConstants.EQUAL,
     DatatypeConstants.GREATER or
     DatatypeConstants.INDETERMINATE. - `int`

  throws: java.lang.NullPointerException - if xmlGregorianCalendar is null."
  (^Integer [^XMLGregorianCalendar this ^javax.xml.datatype.XMLGregorianCalendar xml-gregorian-calendar]
    (-> this (.compare xml-gregorian-calendar))))

(defn set-month
  "Set month.

   Unset this field by invoking the setter with a parameter value of DatatypeConstants.FIELD_UNDEFINED.

  month - value constraints summarized in month field of date/time field mapping table. - `int`

  throws: java.lang.IllegalArgumentException - if month parameter is outside value constraints for the field as specified in date/time field mapping table."
  ([^XMLGregorianCalendar this ^Integer month]
    (-> this (.setMonth month))))

(defn set-millisecond
  "Set milliseconds.

   Unset this field by invoking the setter with a parameter value of DatatypeConstants.FIELD_UNDEFINED.

  millisecond - value constraints summarized in second field of date/time field mapping table. - `int`

  throws: java.lang.IllegalArgumentException - if millisecond parameter is outside value constraints for the field as specified in date/time field mapping table."
  ([^XMLGregorianCalendar this ^Integer millisecond]
    (-> this (.setMillisecond millisecond))))

(defn get-hour
  "Return hours or DatatypeConstants.FIELD_UNDEFINED.
   Returns DatatypeConstants.FIELD_UNDEFINED if this field is not defined.

   Value constraints for this value are summarized in
   hour field of date/time field mapping table.

  returns: `int`"
  (^Integer [^XMLGregorianCalendar this]
    (-> this (.getHour))))

(defn get-fractional-second
  "Return fractional seconds.

   null is returned when this optional field is not defined.

   Value constraints are detailed in
   second field of date/time field mapping table.

   This optional field can only have a defined value when the
   xs:dateTime second field, represented by getSecond(),
   does not return DatatypeConstants.FIELD_UNDEFINED.

  returns: fractional seconds  of this XMLGregorianCalendar. - `java.math.BigDecimal`"
  (^java.math.BigDecimal [^XMLGregorianCalendar this]
    (-> this (.getFractionalSecond))))

(defn normalize
  "Normalize this instance to UTC.

   2000-03-04T23:00:00+03:00 normalizes to 2000-03-04T20:00:00Z
   Implements W3C XML Schema Part 2, Section 3.2.7.3 (A).

  returns: this XMLGregorianCalendar normalized to UTC. - `javax.xml.datatype.XMLGregorianCalendar`"
  (^javax.xml.datatype.XMLGregorianCalendar [^XMLGregorianCalendar this]
    (-> this (.normalize))))

(defn set-time
  "Set time as one unit, including the optional infinite precision
   fractional seconds.

  hour - value constraints are summarized in hour field of date/time field mapping table. - `int`
  minute - value constraints are summarized in minute field of date/time field mapping table. - `int`
  second - value constraints are summarized in second field of date/time field mapping table. - `int`
  fractional - value of null indicates this optional field is not set. - `java.math.BigDecimal`

  throws: java.lang.IllegalArgumentException - if any parameter is outside value constraints for the field as specified in date/time field mapping table."
  ([^XMLGregorianCalendar this ^Integer hour ^Integer minute ^Integer second ^java.math.BigDecimal fractional]
    (-> this (.setTime hour minute second fractional)))
  ([^XMLGregorianCalendar this ^Integer hour ^Integer minute ^Integer second]
    (-> this (.setTime hour minute second))))

(defn set-minute
  "Set minutes.

   Unset this field by invoking the setter with a parameter value of DatatypeConstants.FIELD_UNDEFINED.

  minute - value constraints summarized in minute field of date/time field mapping table. - `int`

  throws: java.lang.IllegalArgumentException - if minute parameter is outside value constraints for the field as specified in date/time field mapping table."
  ([^XMLGregorianCalendar this ^Integer minute]
    (-> this (.setMinute minute))))

(defn set-fractional-second
  "Set fractional seconds.

   Unset this field by invoking the setter with a parameter value of null.

  fractional - value constraints summarized in second field of date/time field mapping table. - `java.math.BigDecimal`

  throws: java.lang.IllegalArgumentException - if fractional parameter is outside value constraints for the field as specified in date/time field mapping table."
  ([^XMLGregorianCalendar this ^java.math.BigDecimal fractional]
    (-> this (.setFractionalSecond fractional))))

(defn set-second
  "Set seconds.

   Unset this field by invoking the setter with a parameter value of DatatypeConstants.FIELD_UNDEFINED.

  second - value constraints summarized in second field of date/time field mapping table. - `int`

  throws: java.lang.IllegalArgumentException - if second parameter is outside value constraints for the field as specified in date/time field mapping table."
  ([^XMLGregorianCalendar this ^Integer second]
    (-> this (.setSecond second))))

(defn get-year
  "Return low order component for XML Schema 1.0 dateTime datatype field for
   year or DatatypeConstants.FIELD_UNDEFINED.

   Value constraints for this value are summarized in
   year field of date/time field mapping table.

  returns: year  of this XMLGregorianCalendar. - `int`"
  (^Integer [^XMLGregorianCalendar this]
    (-> this (.getYear))))

(defn get-second
  "Return seconds or DatatypeConstants.FIELD_UNDEFINED.

   Returns DatatypeConstants.FIELD_UNDEFINED if this field is not defined.
   When this field is not defined, the optional xs:dateTime
   fractional seconds field, represented by
   getFractionalSecond() and getMillisecond(),
   must not be defined.

   Value constraints for this value are summarized in
   second field of date/time field mapping table.

  returns: Second  of this XMLGregorianCalendar. - `int`"
  (^Integer [^XMLGregorianCalendar this]
    (-> this (.getSecond))))

(defn to-gregorian-calendar
  "Convert this XMLGregorianCalendar along with provided parameters
   to a GregorianCalendar instance.

    Since XML Schema 1.0 date/time datetypes has no concept of
   timezone ids or daylight savings timezone ids, this conversion operation
   allows the user to explicitly specify one with
   timezone parameter.

   To compute the return value's TimeZone field,

   when parameter timeZone is non-null,
   it is the timezone field.
   else when this.getTimezone() != FIELD_UNDEFINED,
   create a java.util.TimeZone with a custom timezone id
   using the this.getTimezone().
   else when defaults.getTimezone() != FIELD_UNDEFINED,
   create a java.util.TimeZone with a custom timezone id
   using defaults.getTimezone().
   else use the GregorianCalendar default timezone value
   for the host is defined as specified by
   java.util.TimeZone.getDefault().

   To ensure consistency in conversion implementations, the new
   GregorianCalendar should be instantiated in following
   manner.

     Create a new java.util.GregorianCalendar(TimeZone,
         Locale) with TimeZone set as specified above and the
         Locale parameter.

     Initialize all GregorianCalendar fields by calling Calendar.clear()
     Obtain a pure Gregorian Calendar by invoking
     GregorianCalendar.setGregorianChange(
     new Date(Long.MIN_VALUE)).
     Its fields ERA, YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY,
         MINUTE, SECOND and MILLISECOND are set using the method
         Calendar.set(int,int)

  timezone - provide Timezone. null is a legal value. - `java.util.TimeZone`
  a-locale - provide explicit Locale. Use default GregorianCalendar locale if value is null. - `java.util.Locale`
  defaults - provide default field values to use when corresponding field for this instance is FIELD_UNDEFINED or null. If defaultsis null or a field within the specified defaults is undefined, just use java.util.GregorianCalendar defaults. - `javax.xml.datatype.XMLGregorianCalendar`

  returns: a java.util.GregorianCalendar conversion of this instance. - `java.util.GregorianCalendar`"
  (^java.util.GregorianCalendar [^XMLGregorianCalendar this ^java.util.TimeZone timezone ^java.util.Locale a-locale ^javax.xml.datatype.XMLGregorianCalendar defaults]
    (-> this (.toGregorianCalendar timezone a-locale defaults)))
  (^java.util.GregorianCalendar [^XMLGregorianCalendar this]
    (-> this (.toGregorianCalendar))))

(defn set-timezone
  "Set the number of minutes in the timezone offset.

   Unset this field by invoking the setter with a parameter value of DatatypeConstants.FIELD_UNDEFINED.

  offset - value constraints summarized in timezone field of date/time field mapping table. - `int`

  throws: java.lang.IllegalArgumentException - if offset parameter is outside value constraints for the field as specified in date/time field mapping table."
  ([^XMLGregorianCalendar this ^Integer offset]
    (-> this (.setTimezone offset))))

(defn to-string
  "Returns a String representation of this XMLGregorianCalendar Object.

   The result is a lexical representation generated by toXMLFormat().

  returns: A non-null valid String representation of this XMLGregorianCalendar. - `java.lang.String`

  throws: java.lang.IllegalStateException - if the combination of set fields does not match one of the eight defined XML Schema builtin date/time datatypes."
  (^java.lang.String [^XMLGregorianCalendar this]
    (-> this (.toString))))

(defn reset
  "Reset this XMLGregorianCalendar to its original values.

   XMLGregorianCalendar is reset to the same values as when it was created with
   DatatypeFactory.newXMLGregorianCalendar(),
   DatatypeFactory.newXMLGregorianCalendar(String lexicalRepresentation),
   DatatypeFactory.newXMLGregorianCalendar(
     BigInteger year,
     int month,
     int day,
     int hour,
     int minute,
     int second,
     BigDecimal fractionalSecond,
     int timezone),
   DatatypeFactory.newXMLGregorianCalendar(
     int year,
     int month,
     int day,
     int hour,
     int minute,
     int second,
     int millisecond,
     int timezone),
   DatatypeFactory.newXMLGregorianCalendar(GregorianCalendar cal),
   DatatypeFactory.newXMLGregorianCalendarDate(
     int year,
     int month,
     int day,
     int timezone),
   DatatypeFactory.newXMLGregorianCalendarTime(
     int hours,
     int minutes,
     int seconds,
     int timezone),
   DatatypeFactory.newXMLGregorianCalendarTime(
     int hours,
     int minutes,
     int seconds,
     BigDecimal fractionalSecond,
     int timezone) or
   DatatypeFactory.newXMLGregorianCalendarTime(
     int hours,
     int minutes,
     int seconds,
     int milliseconds,
     int timezone).


   reset() is designed to allow the reuse of existing XMLGregorianCalendars
   thus saving resources associated with the creation of new XMLGregorianCalendars."
  ([^XMLGregorianCalendar this]
    (-> this (.reset))))

(defn to-xml-format
  "Return the lexical representation of this instance.
   The format is specified in
   XML Schema 1.0 Part 2, Section 3.2.[7-14].1,
   Lexical Representation`.

   Specific target lexical representation format is determined by
   getXMLSchemaType().

  returns: XML, as String, representation of this XMLGregorianCalendar - `java.lang.String`

  throws: java.lang.IllegalStateException - if the combination of set fields does not match one of the eight defined XML Schema builtin date/time datatypes."
  (^java.lang.String [^XMLGregorianCalendar this]
    (-> this (.toXMLFormat))))

(defn get-time-zone
  "Returns a java.util.TimeZone for this class.

   If timezone field is defined for this instance,
   returns TimeZone initialized with custom timezone id
   of zoneoffset. If timezone field is undefined,
   try the defaultZoneoffset that was passed in.
   If defaultZoneoffset is FIELD_UNDEFINED, return
   default timezone for this host.
   (Same default as java.util.GregorianCalendar).

  default-zoneoffset - default zoneoffset if this zoneoffset is DatatypeConstants.FIELD_UNDEFINED. - `int`

  returns: TimeZone for this. - `java.util.TimeZone`"
  (^java.util.TimeZone [^XMLGregorianCalendar this ^Integer default-zoneoffset]
    (-> this (.getTimeZone default-zoneoffset))))

(defn get-eon-and-year
  "Return XML Schema 1.0 dateTime datatype field for
   year.

   Value constraints for this value are summarized in
   year field of date/time field mapping table.

  returns: sum of eon and BigInteger.valueOf(year)
   when both fields are defined. When only year is defined,
   return it. When both eon and year are not
   defined, return null. - `java.math.BigInteger`"
  (^java.math.BigInteger [^XMLGregorianCalendar this]
    (-> this (.getEonAndYear))))

(defn get-timezone
  "Return timezone offset in minutes or
   DatatypeConstants.FIELD_UNDEFINED if this optional field is not defined.

   Value constraints for this value are summarized in
   timezone field of date/time field mapping table.

  returns: `int`"
  (^Integer [^XMLGregorianCalendar this]
    (-> this (.getTimezone))))

(defn valid?
  "Validate instance by getXMLSchemaType() constraints.

  returns: true if data values are valid. - `boolean`"
  (^Boolean [^XMLGregorianCalendar this]
    (-> this (.isValid))))

(defn get-day
  "Return day in month or DatatypeConstants.FIELD_UNDEFINED.

   Value constraints for this value are summarized in
   day field of date/time field mapping table.

  returns: `int`"
  (^Integer [^XMLGregorianCalendar this]
    (-> this (.getDay))))

(defn get-millisecond
  "Return millisecond precision of getFractionalSecond().

   This method represents a convenience accessor to infinite
   precision fractional second value returned by
   getFractionalSecond(). The returned value is the rounded
   down to milliseconds value of
   getFractionalSecond(). When getFractionalSecond()
   returns null, this method must return
   DatatypeConstants.FIELD_UNDEFINED.

   Value constraints for this value are summarized in
   second field of date/time field mapping table.

  returns: Millisecond  of this XMLGregorianCalendar. - `int`"
  (^Integer [^XMLGregorianCalendar this]
    (-> this (.getMillisecond))))

(defn set-hour
  "Set hours.

   Unset this field by invoking the setter with a parameter value of DatatypeConstants.FIELD_UNDEFINED.

  hour - value constraints summarized in hour field of date/time field mapping table. - `int`

  throws: java.lang.IllegalArgumentException - if hour parameter is outside value constraints for the field as specified in date/time field mapping table."
  ([^XMLGregorianCalendar this ^Integer hour]
    (-> this (.setHour hour))))

(defn get-eon
  "Return high order component for XML Schema 1.0 dateTime datatype field for
   year.
   null if this optional part of the year field is not defined.

   Value constraints for this value are summarized in
   year field of date/time field mapping table.

  returns: eon of this XMLGregorianCalendar. The value
   returned is an integer multiple of 10^9. - `java.math.BigInteger`"
  (^java.math.BigInteger [^XMLGregorianCalendar this]
    (-> this (.getEon))))

(defn clone
  "Creates and returns a copy of this object.

  returns: copy of this Object - `java.lang.Object`"
  (^java.lang.Object [^XMLGregorianCalendar this]
    (-> this (.clone))))

(defn get-minute
  "Return minutes or DatatypeConstants.FIELD_UNDEFINED.
   Returns DatatypeConstants.FIELD_UNDEFINED if this field is not defined.

   Value constraints for this value are summarized in
   minute field of date/time field mapping table.

  returns: `int`"
  (^Integer [^XMLGregorianCalendar this]
    (-> this (.getMinute))))

(defn hash-code
  "Returns a hash code consistent with the definition of the equals method.

  returns: hash code of this object. - `int`"
  (^Integer [^XMLGregorianCalendar this]
    (-> this (.hashCode))))

(defn add
  "Add duration to this instance.

   The computation is specified in
   XML Schema 1.0 Part 2, Appendix E,
   Adding durations to dateTimes>.
   date/time field mapping table
   defines the mapping from XML Schema 1.0 dateTime fields
   to this class' representation of those fields.

  duration - Duration to add to this XMLGregorianCalendar. - `javax.xml.datatype.Duration`

  throws: java.lang.NullPointerException - when duration parameter is null."
  ([^XMLGregorianCalendar this ^javax.xml.datatype.Duration duration]
    (-> this (.add duration))))

(defn clear
  "Unset all fields to undefined.

   Set all int fields to DatatypeConstants.FIELD_UNDEFINED and reference fields
   to null."
  ([^XMLGregorianCalendar this]
    (-> this (.clear))))

(defn get-month
  "Return number of month or DatatypeConstants.FIELD_UNDEFINED.

   Value constraints for this value are summarized in
   month field of date/time field mapping table.

  returns: year  of this XMLGregorianCalendar. - `int`"
  (^Integer [^XMLGregorianCalendar this]
    (-> this (.getMonth))))

(defn set-year
  "Set low and high order component of XSD dateTime year field.

   Unset this field by invoking the setter with a parameter value of null.

  year - value constraints summarized in year field of date/time field mapping table. - `java.math.BigInteger`

  throws: java.lang.IllegalArgumentException - if year parameter is outside value constraints for the field as specified in date/time field mapping table."
  ([^XMLGregorianCalendar this ^java.math.BigInteger year]
    (-> this (.setYear year))))

(defn get-xml-schema-type
  "Return the name of the XML Schema date/time type that this instance
   maps to. Type is computed based on fields that are set.





           Required fields for XML Schema 1.0 Date/Time Datatypes.
           (timezone is optional for all date/time datatypes)





         Datatype
         year
         month
         day
         hour
         minute
         second


         DatatypeConstants.DATETIME
         X
         X
         X
         X
         X
         X


         DatatypeConstants.DATE
         X
         X
         X





         DatatypeConstants.TIME



         X
         X
         X


         DatatypeConstants.GYEARMONTH
         X
         X






         DatatypeConstants.GMONTHDAY

         X
         X





         DatatypeConstants.GYEAR
         X







         DatatypeConstants.GMONTH

         X






         DatatypeConstants.GDAY


         X

  returns: One of the following class constants:
     DatatypeConstants.DATETIME,
     DatatypeConstants.TIME,
     DatatypeConstants.DATE,
     DatatypeConstants.GYEARMONTH,
     DatatypeConstants.GMONTHDAY,
     DatatypeConstants.GYEAR,
     DatatypeConstants.GMONTH or
     DatatypeConstants.GDAY. - `javax.xml.namespace.QName`

  throws: java.lang.IllegalStateException - if the combination of set fields does not match one of the eight defined XML Schema builtin date/time datatypes."
  (^javax.xml.namespace.QName [^XMLGregorianCalendar this]
    (-> this (.getXMLSchemaType))))

(defn equals
  "Compares this calendar to the specified object. The result is
   true if and only if the argument is not null and is an
   XMLGregorianCalendar object that represents the same
   instant in time as this object.

  obj - to compare. - `java.lang.Object`

  returns: true when obj is an instance of
   XMLGregorianCalendar and
   compare(XMLGregorianCalendar obj)
   returns DatatypeConstants.EQUAL,
   otherwise false. - `boolean`"
  (^Boolean [^XMLGregorianCalendar this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn set-day
  "Set days in month.

   Unset this field by invoking the setter with a parameter value of DatatypeConstants.FIELD_UNDEFINED.

  day - value constraints summarized in day field of date/time field mapping table. - `int`

  throws: java.lang.IllegalArgumentException - if day parameter is outside value constraints for the field as specified in date/time field mapping table."
  ([^XMLGregorianCalendar this ^Integer day]
    (-> this (.setDay day))))

