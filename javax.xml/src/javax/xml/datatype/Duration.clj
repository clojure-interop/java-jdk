(ns javax.xml.datatype.Duration
  "Immutable representation of a time span as defined in
  the W3C XML Schema 1.0 specification.

  A Duration object represents a period of Gregorian time,
  which consists of six fields (years, months, days, hours,
  minutes, and seconds) plus a sign (+/-) field.

  The first five fields have non-negative (>=0) integers or null
  (which represents that the field is not set),
  and the seconds field has a non-negative decimal or null.
  A negative sign indicates a negative duration.

  This class provides a number of methods that make it easy
  to use for the duration datatype of XML Schema 1.0 with
  the errata.

  Order relationship
  Duration objects only have partial order, where two values A and B
  maybe either:

   A<B (A is shorter than B)
   A>B (A is longer than B)
   A==B   (A and B are of the same duration)
   A<>B (Comparison between A and B is indeterminate)


  For example, 30 days cannot be meaningfully compared to one month.
  The compare(Duration duration) method implements this
  relationship.

  See the isLongerThan(Duration) method for details about
  the order relationship among Duration objects.

  Operations over Duration
  This class provides a set of basic arithmetic operations, such
  as addition, subtraction and multiplication.
  Because durations don't have total order, an operation could
  fail for some combinations of operations. For example, you cannot
  subtract 15 days from 1 month. See the javadoc of those methods
  for detailed conditions where this could happen.

  Also, division of a duration by a number is not provided because
  the Duration class can only deal with finite precision
  decimal numbers. For example, one cannot represent 1 sec divided by 3.

  However, you could substitute a division by 3 with multiplying
  by numbers such as 0.3 or 0.333.

  Range of allowed values

  Because some operations of Duration rely on Calendar
  even though Duration can hold very large or very small values,
  some of the methods may not work correctly on such Durations.
  The impacted methods document their dependency on Calendar."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.datatype Duration]))

(defn ->duration
  "Constructor.

  Default no-arg constructor.

   Note: Always use the DatatypeFactory to
   construct an instance of Duration.
   The constructor on this class cannot be guaranteed to
   produce an object with a consistent state and may be
   removed in the future."
  (^Duration []
    (new Duration )))

(defn compare
  "Partial order relation comparison with this Duration instance.

   Comparison result must be in accordance with
   W3C XML Schema 1.0 Part 2, Section 3.2.7.6.2,
   Order relation on duration.

   Return:

     DatatypeConstants.LESSER if this Duration is shorter than duration parameter
     DatatypeConstants.EQUAL if this Duration is equal to duration parameter
     DatatypeConstants.GREATER if this Duration is longer than duration parameter
     DatatypeConstants.INDETERMINATE if a conclusive partial order relation cannot be determined

  duration - to compare - `javax.xml.datatype.Duration`

  returns: the relationship between this Durationand duration parameter as
     DatatypeConstants.LESSER, DatatypeConstants.EQUAL, DatatypeConstants.GREATER
     or DatatypeConstants.INDETERMINATE. - `int`

  throws: java.lang.UnsupportedOperationException - If the underlying implementation cannot reasonably process the request, e.g. W3C XML Schema allows for arbitrarily large/small/precise values, the request may be beyond the implementations capability."
  (^Integer [^Duration this ^javax.xml.datatype.Duration duration]
    (-> this (.compare duration))))

(defn get-months
  "Obtains the value of the MONTHS field as an integer value,
   or 0 if not present.

   This method works just like getYears() except
   that this method works on the MONTHS field.

  returns: Months of this Duration. - `int`"
  (^Integer [^Duration this]
    (-> this (.getMonths))))

(defn multiply
  "Computes a new duration whose value is factor times
   longer than the value of this duration.

   This method is provided for the convenience.
   It is functionally equivalent to the following code:


   multiply(new BigDecimal(String.valueOf(factor)))

  factor - Factor times longer of new Duration to create. - `int`

  returns: New Duration that is factortimes longer than this Duration. - `javax.xml.datatype.Duration`"
  (^javax.xml.datatype.Duration [^Duration this ^Integer factor]
    (-> this (.multiply factor))))

(defn negate
  "Returns a new Duration object whose
   value is -this.


   Since the Duration class is immutable, this method
   doesn't change the value of this object. It simply computes
   a new Duration object and returns it.

  returns: always return a non-null valid Duration object. - `javax.xml.datatype.Duration`"
  (^javax.xml.datatype.Duration [^Duration this]
    (-> this (.negate))))

(defn get-hours
  "Obtains the value of the HOURS field as an integer value,
   or 0 if not present.

   This method works just like getYears() except
   that this method works on the HOURS field.

  returns: Hours of this Duration. - `int`"
  (^Integer [^Duration this]
    (-> this (.getHours))))

(defn to-string
  "Returns a String representation of this Duration Object.

   The result is formatted according to the XML Schema 1.0 spec and can be always parsed back later into the
   equivalent Duration Object by DatatypeFactory.newDuration(String  lexicalRepresentation).

   Formally, the following holds for any Duration
   Object x:


   new Duration(x.toString()).equals(x)

  returns: A non-null valid String representation of this Duration. - `java.lang.String`"
  (^java.lang.String [^Duration this]
    (-> this (.toString))))

(defn normalize-with
  "Converts the years and months fields into the days field
   by using a specific time instant as the reference point.

   For example, duration of one month normalizes to 31 days
   given the start time instance \"July 8th 2003, 17:40:32\".

   Formally, the computation is done as follows:

    the given Calendar object is cloned
    the years, months and days fields will be added to the Calendar object
        by using the Calendar.add(int,int) method
    the difference between the two Calendars in computed in milliseconds and converted to days,
       if a remainder occurs due to Daylight Savings Time, it is discarded
    the computed days, along with the hours, minutes and seconds
        fields of this duration object is used to construct a new
        Duration object.


   Note that since the Calendar class uses int to
   hold the value of year and month, this method may produce
   an unexpected result if this duration object holds
   a very large value in the years or months fields.

  start-time-instant - Calendar reference point. - `java.util.Calendar`

  returns: Duration of years and months of this Duration as days. - `javax.xml.datatype.Duration`

  throws: java.lang.NullPointerException - If the startTimeInstant parameter is null."
  (^javax.xml.datatype.Duration [^Duration this ^java.util.Calendar start-time-instant]
    (-> this (.normalizeWith start-time-instant))))

(defn add-to
  "Adds this duration to a Calendar object.


   Calls Calendar.add(int,int) in the
   order of YEARS, MONTHS, DAYS, HOURS, MINUTES, SECONDS, and MILLISECONDS
   if those fields are present. Because the Calendar class
   uses int to hold values, there are cases where this method
   won't work correctly (for example if values of fields
   exceed the range of int.)



   Also, since this duration class is a Gregorian duration, this
   method will not work correctly if the given Calendar
   object is based on some other calendar systems.



   Any fractional parts of this Duration object
   beyond milliseconds will be simply ignored. For example, if
   this duration is \"P1.23456S\", then 1 is added to SECONDS,
   234 is added to MILLISECONDS, and the rest will be unused.



   Note that because Calendar.add(int, int) is using
   int, Duration with values beyond the
   range of int in its fields
   will cause overflow/underflow to the given Calendar.
   XMLGregorianCalendar.add(Duration) provides the same
   basic operation as this method while avoiding
   the overflow/underflow issues.

  calendar - A calendar object whose value will be modified. - `java.util.Calendar`

  throws: java.lang.NullPointerException - if the calendar parameter is null."
  ([^Duration this ^java.util.Calendar calendar]
    (-> this (.addTo calendar))))

(defn longer-than?
  "Checks if this duration object is strictly longer than
   another Duration object.

   Duration X is \"longer\" than Y if and only if X>Y
   as defined in the section 3.2.6.2 of the XML Schema 1.0
   specification.

   For example, \"P1D\" (one day) > \"PT12H\" (12 hours) and
   \"P2Y\" (two years) > \"P23M\" (23 months).

  duration - Duration to test this Duration against. - `javax.xml.datatype.Duration`

  returns: true if the duration represented by this object
        is longer than the given duration. false otherwise. - `boolean`

  throws: java.lang.UnsupportedOperationException - If the underlying implementation cannot reasonably process the request, e.g. W3C XML Schema allows for arbitrarily large/small/precise values, the request may be beyond the implementations capability."
  (^Boolean [^Duration this ^javax.xml.datatype.Duration duration]
    (-> this (.isLongerThan duration))))

(defn set?
  "Checks if a field is set.

   A field of a duration object may or may not be present.
   This method can be used to test if a field is present.

  field - one of the six Field constants (YEARS,MONTHS,DAYS,HOURS, MINUTES, or SECONDS.) - `javax.xml.datatype.DatatypeConstants$Field`

  returns: true if the field is present. false if not. - `boolean`

  throws: java.lang.NullPointerException - If the field parameter is null."
  (^Boolean [^Duration this ^javax.xml.datatype.DatatypeConstants$Field field]
    (-> this (.isSet field))))

(defn subtract
  "Computes a new duration whose value is this-rhs.

   For example:


   \"1 day\" - \"-3 days\" = \"4 days\"
   \"1 year\" - \"1 day\" = IllegalStateException
   \"-(1 hour,50 minutes)\" - \"-20 minutes\" = \"-(1hours,30 minutes)\"
   \"15 hours\" - \"-3 days\" = \"3 days and 15 hours\"
   \"1 year\" - \"-1 day\" = \"1 year and 1 day\"

   Since there's no way to meaningfully subtract 1 day from 1 month,
   there are cases where the operation fails in IllegalStateException.

   Formally the computation is defined as follows.
   First, we can assume that two Durations are both positive
   without losing generality.  (i.e.,
   (-X)-Y=-(X+Y), X-(-Y)=X+Y,
   (-X)-(-Y)=-(X-Y))

   Then two durations are subtracted field by field.
   If the sign of any non-zero field F is different from
   the sign of the most significant field,
   1 (if F is negative) or -1 (otherwise)
   will be borrowed from the next bigger unit of F.

   This process is repeated until all the non-zero fields have
   the same sign.

   If a borrow occurs in the days field (in other words, if
   the computation needs to borrow 1 or -1 month to compensate
   days), then the computation fails by throwing an
   IllegalStateException.

  rhs - Duration to subtract from this Duration. - `javax.xml.datatype.Duration`

  returns: New Duration created from subtracting rhs from this Duration. - `javax.xml.datatype.Duration`

  throws: java.lang.IllegalStateException - If two durations cannot be meaningfully subtracted. For example, subtracting one day from one month causes this exception."
  (^javax.xml.datatype.Duration [^Duration this ^javax.xml.datatype.Duration rhs]
    (-> this (.subtract rhs))))

(defn get-field
  "Gets the value of a field.

   Fields of a duration object may contain arbitrary large value.
   Therefore this method is designed to return a Number object.

   In case of YEARS, MONTHS, DAYS, HOURS, and MINUTES, the returned
   number will be a non-negative integer. In case of seconds,
   the returned number may be a non-negative decimal value.

  field - one of the six Field constants (YEARS,MONTHS,DAYS,HOURS, MINUTES, or SECONDS.) - `javax.xml.datatype.DatatypeConstants$Field`

  returns: If the specified field is present, this method returns
        a non-null non-negative Number object that
        represents its value. If it is not present, return null.
        For YEARS, MONTHS, DAYS, HOURS, and MINUTES, this method
        returns a BigInteger object. For SECONDS, this
        method returns a BigDecimal. - `java.lang.Number`

  throws: java.lang.NullPointerException - If the field is null."
  (^java.lang.Number [^Duration this ^javax.xml.datatype.DatatypeConstants$Field field]
    (-> this (.getField field))))

(defn get-days
  "Obtains the value of the DAYS field as an integer value,
   or 0 if not present.

   This method works just like getYears() except
   that this method works on the DAYS field.

  returns: Days of this Duration. - `int`"
  (^Integer [^Duration this]
    (-> this (.getDays))))

(defn get-years
  "Get the years value of this Duration as an int or 0 if not present.

   getYears() is a convenience method for
   getField(DatatypeConstants.YEARS).

   As the return value is an int, an incorrect value will be returned for Durations
   with years that go beyond the range of an int.
   Use getField(DatatypeConstants.YEARS) to avoid possible loss of precision.

  returns: If the years field is present, return its value as an int, else return 0. - `int`"
  (^Integer [^Duration this]
    (-> this (.getYears))))

(defn get-time-in-millis
  "Returns the length of the duration in milli-seconds.

   If the seconds field carries more digits than milli-second order,
   those will be simply discarded (or in other words, rounded to zero.)
   For example, for any Calendar value x,


   new Duration(\"PT10.00099S\").getTimeInMills(x) == 10000.
   new Duration(\"-PT10.00099S\").getTimeInMills(x) == -10000.


   Note that this method uses the addTo(Calendar) method,
   which may work incorrectly with Duration objects with
   very large values in its fields. See the addTo(Calendar)
   method for details.

  start-instant - The length of a month/year varies. The startInstant is used to disambiguate this variance. Specifically, this method returns the difference between startInstant and startInstant+duration - `java.util.Calendar`

  returns: milliseconds between startInstant and
     startInstant plus this Duration - `long`

  throws: java.lang.NullPointerException - if startInstant parameter is null."
  (^Long [^Duration this ^java.util.Calendar start-instant]
    (-> this (.getTimeInMillis start-instant))))

(defn get-seconds
  "Obtains the value of the SECONDS field as an integer value,
   or 0 if not present.

   This method works just like getYears() except
   that this method works on the SECONDS field.

  returns: seconds in the integer value. The fraction of seconds
     will be discarded (for example, if the actual value is 2.5,
     this method returns 2) - `int`"
  (^Integer [^Duration this]
    (-> this (.getSeconds))))

(defn shorter-than?
  "Checks if this duration object is strictly shorter than
   another Duration object.

  duration - Duration to test this Duration against. - `javax.xml.datatype.Duration`

  returns: true if duration parameter is shorter than this Duration,
     else false. - `boolean`

  throws: java.lang.UnsupportedOperationException - If the underlying implementation cannot reasonably process the request, e.g. W3C XML Schema allows for arbitrarily large/small/precise values, the request may be beyond the implementations capability."
  (^Boolean [^Duration this ^javax.xml.datatype.Duration duration]
    (-> this (.isShorterThan duration))))

(defn hash-code
  "Returns a hash code consistent with the definition of the equals method.

  returns: a hash code value for this object. - `int`"
  (^Integer [^Duration this]
    (-> this (.hashCode))))

(defn add
  "Computes a new duration whose value is this+rhs.

   For example,


   \"1 day\"  \"-3 days\" = \"-2 days\"
   \"1 year\"  \"1 day\" = \"1 year and 1 day\"
   \"-(1 hour,50 minutes)\"  \"-20 minutes\" = \"-(1 hours,70 minutes)\"
   \"15 hours\"  \"-3 days\" = \"-(2 days,9 hours)\"
   \"1 year\"  \"-1 day\" = IllegalStateException

   Since there's no way to meaningfully subtract 1 day from 1 month,
   there are cases where the operation fails in
   IllegalStateException.


   Formally, the computation is defined as follows.

   Firstly, we can assume that two Durations to be added
   are both positive without losing generality (i.e.,
   (-X)+Y=Y-X, X+(-Y)=X-Y,
   (-X)+(-Y)=-(X+Y))


   Addition of two positive Durations are simply defined as
   field by field addition where missing fields are treated as 0.

   A field of the resulting Duration will be unset if and
   only if respective fields of two input Durations are unset.

   Note that lhs.add(rhs) will be always successful if
   lhs.signum()*rhs.signum()!=-1 or both of them are
   normalized.

  rhs - Duration to add to this Duration - `javax.xml.datatype.Duration`

  returns: non-null valid Duration object. - `javax.xml.datatype.Duration`

  throws: java.lang.NullPointerException - If the rhs parameter is null."
  (^javax.xml.datatype.Duration [^Duration this ^javax.xml.datatype.Duration rhs]
    (-> this (.add rhs))))

(defn get-sign
  "Returns the sign of this duration in -1,0, or 1.

  returns: -1 if this duration is negative, 0 if the duration is zero,
        and 1 if the duration is positive. - `int`"
  (^Integer [^Duration this]
    (-> this (.getSign))))

(defn get-xml-schema-type
  "Return the name of the XML Schema date/time type that this instance
   maps to. Type is computed based on fields that are set,
   i.e. isSet(DatatypeConstants.Field field) == true.





           Required fields for XML Schema 1.0 Date/Time Datatypes.
           (timezone is optional for all date/time datatypes)





         Datatype
         year
         month
         day
         hour
         minute
         second


         DatatypeConstants.DURATION
         X
         X
         X
         X
         X
         X


         DatatypeConstants.DURATION_DAYTIME


         X
         X
         X
         X


         DatatypeConstants.DURATION_YEARMONTH
         X
         X

  returns: one of the following constants:
     DatatypeConstants.DURATION,
     DatatypeConstants.DURATION_DAYTIME or
     DatatypeConstants.DURATION_YEARMONTH. - `javax.xml.namespace.QName`

  throws: java.lang.IllegalStateException - If the combination of set fields does not match one of the XML Schema date/time datatypes."
  (^javax.xml.namespace.QName [^Duration this]
    (-> this (.getXMLSchemaType))))

(defn get-minutes
  "Obtains the value of the MINUTES field as an integer value,
   or 0 if not present.

   This method works just like getYears() except
   that this method works on the MINUTES field.

  returns: Minutes of this Duration. - `int`"
  (^Integer [^Duration this]
    (-> this (.getMinutes))))

(defn equals
  "Checks if this duration object has the same duration
   as another Duration object.

   For example, \"P1D\" (1 day) is equal to \"PT24H\" (24 hours).

   Duration X is equal to Y if and only if time instant
   t+X and t+Y are the same for all the test time instants
   specified in the section 3.2.6.2 of the XML Schema 1.0
   specification.

   Note that there are cases where two Durations are
   \"incomparable\" to each other, like one month and 30 days.
   For example,


   !new Duration(\"P1M\").isShorterThan(new Duration(\"P30D\"))
   !new Duration(\"P1M\").isLongerThan(new Duration(\"P30D\"))
   !new Duration(\"P1M\").equals(new Duration(\"P30D\"))

  duration - The object to compare this Duration against. - `java.lang.Object`

  returns: true if this duration is the same length as
           duration.
        false if duration is null,
           is not a
           Duration object,
           or its length is different from this duration. - `boolean`

  throws: java.lang.UnsupportedOperationException - If the underlying implementation cannot reasonably process the request, e.g. W3C XML Schema allows for arbitrarily large/small/precise values, the request may be beyond the implementations capability."
  (^Boolean [^Duration this ^java.lang.Object duration]
    (-> this (.equals duration))))

