(ns jdk.util.Calendar
  "The Calendar class is an abstract class that provides methods
  for converting between a specific instant in time and a set of calendar fields such as YEAR, MONTH,
  DAY_OF_MONTH, HOUR, and so on, and for
  manipulating the calendar fields, such as getting the date of the next
  week. An instant in time can be represented by a millisecond value that is
  an offset from the Epoch, January 1, 1970
  00:00:00.000 GMT (Gregorian).

  The class also provides additional fields and methods for
  implementing a concrete calendar system outside the package. Those
  fields and methods are defined as protected.


  Like other locale-sensitive classes, Calendar provides a
  class method, getInstance, for getting a generally useful
  object of this type. Calendar's getInstance method
  returns a Calendar object whose
  calendar fields have been initialized with the current date and time:



      Calendar rightNow = Calendar.getInstance();


  A Calendar object can produce all the calendar field values
  needed to implement the date-time formatting for a particular language and
  calendar style (for example, Japanese-Gregorian, Japanese-Traditional).
  Calendar defines the range of values returned by
  certain calendar fields, as well as their meaning.  For example,
  the first month of the calendar system has value MONTH ==
  JANUARY for all calendars.  Other values are defined by the
  concrete subclass, such as ERA.  See individual field
  documentation and subclass documentation for details.

  Getting and Setting Calendar Field Values

  The calendar field values can be set by calling the set
  methods. Any field values set in a Calendar will not be
  interpreted until it needs to calculate its time value (milliseconds from
  the Epoch) or values of the calendar fields. Calling the
  get, getTimeInMillis, getTime,
  add and roll involves such calculation.

  Leniency

  Calendar has two modes for interpreting the calendar
  fields, lenient and non-lenient.  When a
  Calendar is in lenient mode, it accepts a wider range of
  calendar field values than it produces.  When a Calendar
  recomputes calendar field values for return by get(), all of
  the calendar fields are normalized. For example, a lenient
  GregorianCalendar interprets MONTH == JANUARY,
  DAY_OF_MONTH == 32 as February 1.

  When a Calendar is in non-lenient mode, it throws an
  exception if there is any inconsistency in its calendar fields. For
  example, a GregorianCalendar always produces
  DAY_OF_MONTH values between 1 and the length of the month. A
  non-lenient GregorianCalendar throws an exception upon
  calculating its time or calendar field values if any out-of-range field
  value has been set.

  First Week

  Calendar defines a locale-specific seven day week using two
  parameters: the first day of the week and the minimal days in first week
  (from 1 to 7).  These numbers are taken from the locale resource data when a
  Calendar is constructed.  They may also be specified explicitly
  through the methods for setting their values.

  When setting or getting the WEEK_OF_MONTH or
  WEEK_OF_YEAR fields, Calendar must determine the
  first week of the month or year as a reference point.  The first week of a
  month or year is defined as the earliest seven day period beginning on
  getFirstDayOfWeek() and containing at least
  getMinimalDaysInFirstWeek() days of that month or year.  Weeks
  numbered ..., -1, 0 precede the first week; weeks numbered 2, 3,... follow
  it.  Note that the normalized numbering returned by get() may be
  different.  For example, a specific Calendar subclass may
  designate the week before week 1 of a year as week n of
  the previous year.

  Calendar Fields Resolution

  When computing a date and time from the calendar fields, there
  may be insufficient information for the computation (such as only
  year and month with no day of month), or there may be inconsistent
  information (such as Tuesday, July 15, 1996 (Gregorian) -- July 15,
  1996 is actually a Monday). Calendar will resolve
  calendar field values to determine the date and time in the
  following way.

  If there is any conflict in calendar field values,
  Calendar gives priorities to calendar fields that have been set
  more recently. The following are the default combinations of the
  calendar fields. The most recent combination, as determined by the
  most recently set single field, will be used.

  For the date fields:



  YEAR  MONTH  DAY_OF_MONTH
  YEAR  MONTH  WEEK_OF_MONTH  DAY_OF_WEEK
  YEAR  MONTH  DAY_OF_WEEK_IN_MONTH  DAY_OF_WEEK
  YEAR  DAY_OF_YEAR
  YEAR  DAY_OF_WEEK  WEEK_OF_YEAR

  For the time of day fields:



  HOUR_OF_DAY
  AM_PM  HOUR

  If there are any calendar fields whose values haven't been set in the selected
  field combination, Calendar uses their default values. The default
  value of each field may vary by concrete calendar systems. For example, in
  GregorianCalendar, the default of a field is the same as that
  of the start of the Epoch: i.e., YEAR = 1970, MONTH =
  JANUARY, DAY_OF_MONTH = 1, etc.


  Note: There are certain possible ambiguities in
  interpretation of certain singular times, which are resolved in the
  following ways:

       23:59 is the last minute of the day and 00:00 is the first
           minute of the next day. Thus, 23:59 on Dec 31, 1999 < 00:00 on
           Jan 1, 2000 < 00:01 on Jan 1, 2000.

       Although historically not precise, midnight also belongs to \"am\",
           and noon belongs to \"pm\", so on the same day,
           12:00 am (midnight) < 12:01 am, and 12:00 pm (noon) < 12:01 pm



  The date or time format strings are not part of the definition of a
  calendar, as those must be modifiable or overridable by the user at
  runtime. Use DateFormat
  to format dates.

  Field Manipulation

  The calendar fields can be changed using three methods:
  set(), add(), and roll().

  set(f, value) changes calendar field
  f to value.  In addition, it sets an
  internal member variable to indicate that calendar field f has
  been changed. Although calendar field f is changed immediately,
  the calendar's time value in milliseconds is not recomputed until the next call to
  get(), getTime(), getTimeInMillis(),
  add(), or roll() is made. Thus, multiple calls to
  set() do not trigger multiple, unnecessary
  computations. As a result of changing a calendar field using
  set(), other calendar fields may also change, depending on the
  calendar field, the calendar field value, and the calendar system. In addition,
  get(f) will not necessarily return value set by
  the call to the set method
  after the calendar fields have been recomputed. The specifics are determined by
  the concrete calendar class.

  Example: Consider a GregorianCalendar
  originally set to August 31, 1999. Calling set(Calendar.MONTH,
  Calendar.SEPTEMBER) sets the date to September 31,
  1999. This is a temporary internal representation that resolves to
  October 1, 1999 if getTime()is then called. However, a
  call to set(Calendar.DAY_OF_MONTH, 30) before the call to
  getTime() sets the date to September 30, 1999, since
  no recomputation occurs after set() itself.

  add(f, delta) adds delta
  to field f.  This is equivalent to calling set(f,
  get(f)  delta) with two adjustments:


    Add rule 1. The value of field f
    after the call minus the value of field f before the
    call is delta, modulo any overflow that has occurred in
    field f. Overflow occurs when a field value exceeds its
    range and, as a result, the next larger field is incremented or
    decremented and the field value is adjusted back into its range.

    Add rule 2. If a smaller field is expected to be
    invariant, but it is impossible for it to be equal to its
    prior value because of changes in its minimum or maximum after field
    f is changed or other constraints, such as time zone
    offset changes, then its value is adjusted to be as close
    as possible to its expected value. A smaller field represents a
    smaller unit of time. HOUR is a smaller field than
    DAY_OF_MONTH. No adjustment is made to smaller fields
    that are not expected to be invariant. The calendar system
    determines what fields are expected to be invariant.


  In addition, unlike set(), add() forces
  an immediate recomputation of the calendar's milliseconds and all
  fields.

  Example: Consider a GregorianCalendar
  originally set to August 31, 1999. Calling add(Calendar.MONTH,
  13) sets the calendar to September 30, 2000. Add rule
  1 sets the MONTH field to September, since
  adding 13 months to August gives September of the next year. Since
  DAY_OF_MONTH cannot be 31 in September in a
  GregorianCalendar, add rule 2 sets the
  DAY_OF_MONTH to 30, the closest possible value. Although
  it is a smaller field, DAY_OF_WEEK is not adjusted by
  rule 2, since it is expected to change when the month changes in a
  GregorianCalendar.

  roll(f, delta) adds
  delta to field f without changing larger
  fields. This is equivalent to calling add(f, delta) with
  the following adjustment:


    Roll rule. Larger fields are unchanged after the
    call. A larger field represents a larger unit of
    time. DAY_OF_MONTH is a larger field than
    HOUR.


  Example: See GregorianCalendar.roll(int, int).

  Usage model. To motivate the behavior of
  add() and roll(), consider a user interface
  component with increment and decrement buttons for the month, day, and
  year, and an underlying GregorianCalendar. If the
  interface reads January 31, 1999 and the user presses the month
  increment button, what should it read? If the underlying
  implementation uses set(), it might read March 3, 1999. A
  better result would be February 28, 1999. Furthermore, if the user
  presses the month increment button again, it should read March 31,
  1999, not March 28, 1999. By saving the original date and using either
  add() or roll(), depending on whether larger
  fields should be affected, the user interface can behave as most users
  will intuitively expect."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Calendar]))

(def *-era
  "Static Constant.

  Field number for get and set indicating the
   era, e.g., AD or BC in the Julian calendar. This is a calendar-specific
   value; see subclass documentation.

  type: int"
  Calendar/ERA)

(def *-year
  "Static Constant.

  Field number for get and set indicating the
   year. This is a calendar-specific value; see subclass documentation.

  type: int"
  Calendar/YEAR)

(def *-month
  "Static Constant.

  Field number for get and set indicating the
   month. This is a calendar-specific value. The first month of
   the year in the Gregorian and Julian calendars is
   JANUARY which is 0; the last depends on the number
   of months in a year.

  type: int"
  Calendar/MONTH)

(def *-week-of-year
  "Static Constant.

  Field number for get and set indicating the
   week number within the current year.  The first week of the year, as
   defined by getFirstDayOfWeek() and
   getMinimalDaysInFirstWeek(), has value 1.  Subclasses define
   the value of WEEK_OF_YEAR for days before the first week of
   the year.

  type: int"
  Calendar/WEEK_OF_YEAR)

(def *-week-of-month
  "Static Constant.

  Field number for get and set indicating the
   week number within the current month.  The first week of the month, as
   defined by getFirstDayOfWeek() and
   getMinimalDaysInFirstWeek(), has value 1.  Subclasses define
   the value of WEEK_OF_MONTH for days before the first week of
   the month.

  type: int"
  Calendar/WEEK_OF_MONTH)

(def *-date
  "Static Constant.

  Field number for get and set indicating the
   day of the month. This is a synonym for DAY_OF_MONTH.
   The first day of the month has value 1.

  type: int"
  Calendar/DATE)

(def *-day-of-month
  "Static Constant.

  Field number for get and set indicating the
   day of the month. This is a synonym for DATE.
   The first day of the month has value 1.

  type: int"
  Calendar/DAY_OF_MONTH)

(def *-day-of-year
  "Static Constant.

  Field number for get and set indicating the day
   number within the current year.  The first day of the year has value 1.

  type: int"
  Calendar/DAY_OF_YEAR)

(def *-day-of-week
  "Static Constant.

  Field number for get and set indicating the day
   of the week.  This field takes values SUNDAY,
   MONDAY, TUESDAY, WEDNESDAY,
   THURSDAY, FRIDAY, and SATURDAY.

  type: int"
  Calendar/DAY_OF_WEEK)

(def *-day-of-week-in-month
  "Static Constant.

  Field number for get and set indicating the
   ordinal number of the day of the week within the current month. Together
   with the DAY_OF_WEEK field, this uniquely specifies a day
   within a month.  Unlike WEEK_OF_MONTH and
   WEEK_OF_YEAR, this field's value does not depend on
   getFirstDayOfWeek() or
   getMinimalDaysInFirstWeek().  DAY_OF_MONTH 1
   through 7 always correspond to DAY_OF_WEEK_IN_MONTH
   1; 8 through 14 correspond to
   DAY_OF_WEEK_IN_MONTH 2, and so on.
   DAY_OF_WEEK_IN_MONTH 0 indicates the week before
   DAY_OF_WEEK_IN_MONTH 1.  Negative values count back from the
   end of the month, so the last Sunday of a month is specified as
   DAY_OF_WEEK = SUNDAY, DAY_OF_WEEK_IN_MONTH = -1.  Because
   negative values count backward they will usually be aligned differently
   within the month than positive values.  For example, if a month has 31
   days, DAY_OF_WEEK_IN_MONTH -1 will overlap
   DAY_OF_WEEK_IN_MONTH 5 and the end of 4.

  type: int"
  Calendar/DAY_OF_WEEK_IN_MONTH)

(def *-am-pm
  "Static Constant.

  Field number for get and set indicating
   whether the HOUR is before or after noon.
   E.g., at 10:04:15.250 PM the AM_PM is PM.

  type: int"
  Calendar/AM_PM)

(def *-hour
  "Static Constant.

  Field number for get and set indicating the
   hour of the morning or afternoon. HOUR is used for the
   12-hour clock (0 - 11). Noon and midnight are represented by 0, not by 12.
   E.g., at 10:04:15.250 PM the HOUR is 10.

  type: int"
  Calendar/HOUR)

(def *-hour-of-day
  "Static Constant.

  Field number for get and set indicating the
   hour of the day. HOUR_OF_DAY is used for the 24-hour clock.
   E.g., at 10:04:15.250 PM the HOUR_OF_DAY is 22.

  type: int"
  Calendar/HOUR_OF_DAY)

(def *-minute
  "Static Constant.

  Field number for get and set indicating the
   minute within the hour.
   E.g., at 10:04:15.250 PM the MINUTE is 4.

  type: int"
  Calendar/MINUTE)

(def *-second
  "Static Constant.

  Field number for get and set indicating the
   second within the minute.
   E.g., at 10:04:15.250 PM the SECOND is 15.

  type: int"
  Calendar/SECOND)

(def *-millisecond
  "Static Constant.

  Field number for get and set indicating the
   millisecond within the second.
   E.g., at 10:04:15.250 PM the MILLISECOND is 250.

  type: int"
  Calendar/MILLISECOND)

(def *-zone-offset
  "Static Constant.

  Field number for get and set
   indicating the raw offset from GMT in milliseconds.

   This field reflects the correct GMT offset value of the time
   zone of this Calendar if the
   TimeZone implementation subclass supports
   historical GMT offset changes.

  type: int"
  Calendar/ZONE_OFFSET)

(def *-dst-offset
  "Static Constant.

  Field number for get and set indicating the
   daylight saving offset in milliseconds.

   This field reflects the correct daylight saving offset value of
   the time zone of this Calendar if the
   TimeZone implementation subclass supports
   historical Daylight Saving Time schedule changes.

  type: int"
  Calendar/DST_OFFSET)

(def *-field-count
  "Static Constant.

  The number of distinct fields recognized by get and set.
   Field numbers range from 0..FIELD_COUNT-1.

  type: int"
  Calendar/FIELD_COUNT)

(def *-sunday
  "Static Constant.

  Value of the DAY_OF_WEEK field indicating
   Sunday.

  type: int"
  Calendar/SUNDAY)

(def *-monday
  "Static Constant.

  Value of the DAY_OF_WEEK field indicating
   Monday.

  type: int"
  Calendar/MONDAY)

(def *-tuesday
  "Static Constant.

  Value of the DAY_OF_WEEK field indicating
   Tuesday.

  type: int"
  Calendar/TUESDAY)

(def *-wednesday
  "Static Constant.

  Value of the DAY_OF_WEEK field indicating
   Wednesday.

  type: int"
  Calendar/WEDNESDAY)

(def *-thursday
  "Static Constant.

  Value of the DAY_OF_WEEK field indicating
   Thursday.

  type: int"
  Calendar/THURSDAY)

(def *-friday
  "Static Constant.

  Value of the DAY_OF_WEEK field indicating
   Friday.

  type: int"
  Calendar/FRIDAY)

(def *-saturday
  "Static Constant.

  Value of the DAY_OF_WEEK field indicating
   Saturday.

  type: int"
  Calendar/SATURDAY)

(def *-january
  "Static Constant.

  Value of the MONTH field indicating the
   first month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/JANUARY)

(def *-february
  "Static Constant.

  Value of the MONTH field indicating the
   second month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/FEBRUARY)

(def *-march
  "Static Constant.

  Value of the MONTH field indicating the
   third month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/MARCH)

(def *-april
  "Static Constant.

  Value of the MONTH field indicating the
   fourth month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/APRIL)

(def *-may
  "Static Constant.

  Value of the MONTH field indicating the
   fifth month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/MAY)

(def *-june
  "Static Constant.

  Value of the MONTH field indicating the
   sixth month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/JUNE)

(def *-july
  "Static Constant.

  Value of the MONTH field indicating the
   seventh month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/JULY)

(def *-august
  "Static Constant.

  Value of the MONTH field indicating the
   eighth month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/AUGUST)

(def *-september
  "Static Constant.

  Value of the MONTH field indicating the
   ninth month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/SEPTEMBER)

(def *-october
  "Static Constant.

  Value of the MONTH field indicating the
   tenth month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/OCTOBER)

(def *-november
  "Static Constant.

  Value of the MONTH field indicating the
   eleventh month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/NOVEMBER)

(def *-december
  "Static Constant.

  Value of the MONTH field indicating the
   twelfth month of the year in the Gregorian and Julian calendars.

  type: int"
  Calendar/DECEMBER)

(def *-undecimber
  "Static Constant.

  Value of the MONTH field indicating the
   thirteenth month of the year. Although GregorianCalendar
   does not use this value, lunar calendars do.

  type: int"
  Calendar/UNDECIMBER)

(def *-am
  "Static Constant.

  Value of the AM_PM field indicating the
   period of the day from midnight to just before noon.

  type: int"
  Calendar/AM)

(def *-pm
  "Static Constant.

  Value of the AM_PM field indicating the
   period of the day from noon to just before midnight.

  type: int"
  Calendar/PM)

(def *-all-styles
  "Static Constant.

  A style specifier for getDisplayNames indicating names in all styles, such as
   \"January\" and \"Jan\".

  type: int"
  Calendar/ALL_STYLES)

(def *-short
  "Static Constant.

  A style specifier for getDisplayName and getDisplayNames equivalent to SHORT_FORMAT.

  type: int"
  Calendar/SHORT)

(def *-long
  "Static Constant.

  A style specifier for getDisplayName and getDisplayNames equivalent to LONG_FORMAT.

  type: int"
  Calendar/LONG)

(def *-narrow-format
  "Static Constant.

  A style specifier for getDisplayName and getDisplayNames indicating a narrow name used for format. Narrow names
   are typically single character strings, such as \"M\" for Monday.

  type: int"
  Calendar/NARROW_FORMAT)

(def *-narrow-standalone
  "Static Constant.

  A style specifier for getDisplayName and getDisplayNames indicating a narrow name independently. Narrow names
   are typically single character strings, such as \"M\" for Monday.

  type: int"
  Calendar/NARROW_STANDALONE)

(def *-short-format
  "Static Constant.

  A style specifier for getDisplayName and getDisplayNames indicating a short name used for format.

  type: int"
  Calendar/SHORT_FORMAT)

(def *-long-format
  "Static Constant.

  A style specifier for getDisplayName and getDisplayNames indicating a long name used for format.

  type: int"
  Calendar/LONG_FORMAT)

(def *-short-standalone
  "Static Constant.

  A style specifier for getDisplayName and getDisplayNames indicating a short name used independently,
   such as a month abbreviation as calendar headers.

  type: int"
  Calendar/SHORT_STANDALONE)

(def *-long-standalone
  "Static Constant.

  A style specifier for getDisplayName and getDisplayNames indicating a long name used independently,
   such as a month name as calendar headers.

  type: int"
  Calendar/LONG_STANDALONE)

(defn *get-instance
  "Gets a calendar with the specified time zone and locale.
   The Calendar returned is based on the current time
   in the given time zone with the given locale.

  zone - the time zone to use - `java.util.TimeZone`
  a-locale - the locale for the week data - `java.util.Locale`

  returns: a Calendar. - `java.util.Calendar`"
  (^java.util.Calendar [^java.util.TimeZone zone ^java.util.Locale a-locale]
    (Calendar/getInstance zone a-locale))
  (^java.util.Calendar [^java.util.TimeZone zone]
    (Calendar/getInstance zone))
  (^java.util.Calendar []
    (Calendar/getInstance )))

(defn *get-available-locales
  "Returns an array of all locales for which the getInstance
   methods of this class can return localized instances.
   The array returned must contain at least a Locale
   instance equal to Locale.US.

  returns: An array of locales for which localized
           Calendar instances are available. - `java.util.Locale[]`"
  ([]
    (Calendar/getAvailableLocales )))

(defn *get-available-calendar-types
  "Returns an unmodifiable Set containing all calendar types
   supported by Calendar in the runtime environment. The available
   calendar types can be used for the Unicode locale extensions.
   The Set returned contains at least \"gregory\". The
   calendar types don't include aliases, such as \"gregorian\" for
   \"gregory\".

  returns: an unmodifiable Set containing all available calendar types - `java.util.Set<java.lang.String>`"
  (^java.util.Set []
    (Calendar/getAvailableCalendarTypes )))

(defn set-minimal-days-in-first-week
  "Sets what the minimal days required in the first week of the year are;
   For example, if the first week is defined as one that contains the first
   day of the first month of a year, call this method with value 1. If it
   must be a full week, use value 7.

  value - the given minimal days required in the first week of the year. - `int`"
  ([^Calendar this ^Integer value]
    (-> this (.setMinimalDaysInFirstWeek value))))

(defn set-time-zone
  "Sets the time zone with the given time zone value.

  value - the given time zone. - `java.util.TimeZone`"
  ([^Calendar this ^java.util.TimeZone value]
    (-> this (.setTimeZone value))))

(defn to-instant
  "Converts this object to an Instant.

   The conversion creates an Instant that represents the
   same point on the time-line as this Calendar.

  returns: the instant representing the same point on the time-line - `java.time.Instant`"
  (^java.time.Instant [^Calendar this]
    (-> this (.toInstant))))

(defn get-minimum
  "Returns the minimum value for the given calendar field of this
   Calendar instance. The minimum value is defined as
   the smallest value returned by the get method
   for any possible time value.  The minimum value depends on
   calendar system specific parameters of the instance.

  field - the calendar field. - `int`

  returns: the minimum value for the given calendar field. - `int`"
  (^Integer [^Calendar this ^Integer field]
    (-> this (.getMinimum field))))

(defn set-time
  "Sets this Calendar's time with the given Date.

   Note: Calling setTime() with
   Date(Long.MAX_VALUE) or Date(Long.MIN_VALUE)
   may yield incorrect field values from get().

  date - the given Date. - `java.util.Date`"
  ([^Calendar this ^java.util.Date date]
    (-> this (.setTime date))))

(defn after
  "Returns whether this Calendar represents a time
   after the time represented by the specified
   Object. This method is equivalent to:


           compareTo(when) > 0
   if and only if when is a Calendar
   instance. Otherwise, the method returns false.

  when - the Object to be compared - `java.lang.Object`

  returns: true if the time of this Calendar is
   after the time represented by when; false
   otherwise. - `boolean`"
  (^Boolean [^Calendar this ^java.lang.Object when]
    (-> this (.after when))))

(defn get-first-day-of-week
  "Gets what the first day of the week is; e.g., SUNDAY in the U.S.,
   MONDAY in France.

  returns: the first day of the week. - `int`"
  (^Integer [^Calendar this]
    (-> this (.getFirstDayOfWeek))))

(defn set-time-in-millis
  "Sets this Calendar's current time from the given long value.

  millis - the new time in UTC milliseconds from the epoch. - `long`"
  ([^Calendar this ^Long millis]
    (-> this (.setTimeInMillis millis))))

(defn get-actual-minimum
  "Returns the minimum value that the specified calendar field
   could have, given the time value of this Calendar.

   The default implementation of this method uses an iterative
   algorithm to determine the actual minimum value for the
   calendar field. Subclasses should, if possible, override this
   with a more efficient implementation - in many cases, they can
   simply return getMinimum().

  field - the calendar field - `int`

  returns: the minimum of the given calendar field for the time
   value of this Calendar - `int`"
  (^Integer [^Calendar this ^Integer field]
    (-> this (.getActualMinimum field))))

(defn set-lenient
  "Specifies whether or not date/time interpretation is to be lenient.  With
   lenient interpretation, a date such as \"February 942, 1996\" will be
   treated as being equivalent to the 941st day after February 1, 1996.
   With strict (non-lenient) interpretation, such dates will cause an exception to be
   thrown. The default is lenient.

  lenient - true if the lenient mode is to be turned on; false if it is to be turned off. - `boolean`"
  ([^Calendar this ^Boolean lenient]
    (-> this (.setLenient lenient))))

(defn to-string
  "Return a string representation of this calendar. This method
   is intended to be used only for debugging purposes, and the
   format of the returned string may vary between implementations.
   The returned string may be empty but may not be null.

  returns: a string representation of this calendar. - `java.lang.String`"
  (^java.lang.String [^Calendar this]
    (-> this (.toString))))

(defn get-least-maximum
  "Returns the lowest maximum value for the given calendar field
   of this Calendar instance. The lowest maximum
   value is defined as the smallest value returned by getActualMaximum(int) for any possible time value. The least
   maximum value depends on calendar system specific parameters of
   the instance. For example, a Calendar for the
   Gregorian calendar system returns 28 for the
   DAY_OF_MONTH field, because the 28th is the last
   day of the shortest month of this calendar, February in a
   common year.

  field - the calendar field. - `int`

  returns: the lowest maximum value for the given calendar field. - `int`"
  (^Integer [^Calendar this ^Integer field]
    (-> this (.getLeastMaximum field))))

(defn set-week-date
  "Sets the date of this Calendar with the the given date
   specifiers - week year, week of year, and day of week.

   Unlike the set method, all of the calendar fields
   and time values are calculated upon return.

   If weekOfYear is out of the valid week-of-year range
   in weekYear, the weekYear and weekOfYear values are adjusted in lenient mode, or an IllegalArgumentException is thrown in non-lenient mode.

   The default implementation of this method throws an
   UnsupportedOperationException.

  week-year - the week year - `int`
  week-of-year - the week number based on weekYear - `int`
  day-of-week - the day of week value: one of the constants for the DAY_OF_WEEK field: SUNDAY, ..., SATURDAY. - `int`

  throws: java.lang.IllegalArgumentException - if any of the given date specifiers is invalid or any of the calendar fields are inconsistent with the given date specifiers in non-lenient mode"
  ([^Calendar this ^Integer week-year ^Integer week-of-year ^Integer day-of-week]
    (-> this (.setWeekDate week-year week-of-year day-of-week))))

(defn get-display-name
  "Returns the string representation of the calendar
   field value in the given style and
   locale.  If no string representation is
   applicable, null is returned. This method calls
   get(field) to get the calendar
   field value if the string representation is
   applicable to the given calendar field.

   For example, if this Calendar is a
   GregorianCalendar and its date is 2005-01-01, then
   the string representation of the MONTH field would be
   \"January\" in the long style in an English locale or \"Jan\" in
   the short style. However, no string representation would be
   available for the DAY_OF_MONTH field, and this method
   would return null.

   The default implementation supports the calendar fields for
   which a DateFormatSymbols has names in the given
   locale.

  field - the calendar field for which the string representation is returned - `int`
  style - the style applied to the string representation; one of SHORT_FORMAT (SHORT), SHORT_STANDALONE, LONG_FORMAT (LONG), LONG_STANDALONE, NARROW_FORMAT, or NARROW_STANDALONE. - `int`
  locale - the locale for the string representation (any calendar types specified by locale are ignored) - `java.util.Locale`

  returns: the string representation of the given
          field in the given style, or
          null if no string representation is
          applicable. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if field or style is invalid, or if this Calendar is non-lenient and any of the calendar fields have invalid values"
  (^java.lang.String [^Calendar this ^Integer field ^Integer style ^java.util.Locale locale]
    (-> this (.getDisplayName field style locale))))

(defn lenient?
  "Tells whether date/time interpretation is to be lenient.

  returns: true if the interpretation mode of this calendar is lenient;
   false otherwise. - `boolean`"
  (^Boolean [^Calendar this]
    (-> this (.isLenient))))

(defn get-greatest-minimum
  "Returns the highest minimum value for the given calendar field
   of this Calendar instance. The highest minimum
   value is defined as the largest value returned by getActualMinimum(int) for any possible time value. The
   greatest minimum value depends on calendar system specific
   parameters of the instance.

  field - the calendar field. - `int`

  returns: the highest minimum value for the given calendar field. - `int`"
  (^Integer [^Calendar this ^Integer field]
    (-> this (.getGreatestMinimum field))))

(defn set?
  "Determines if the given calendar field has a value set,
   including cases that the value has been set by internal fields
   calculations triggered by a get method call.

  field - the calendar field to test - `int`

  returns: true if the given calendar field has a value set;
   false otherwise. - `boolean`"
  (^Boolean [^Calendar this ^Integer field]
    (-> this (.isSet field))))

(defn get-time-zone
  "Gets the time zone.

  returns: the time zone object associated with this calendar. - `java.util.TimeZone`"
  (^java.util.TimeZone [^Calendar this]
    (-> this (.getTimeZone))))

(defn get-calendar-type
  "Returns the calendar type of this Calendar. Calendar types are
   defined by the Unicode Locale Data Markup Language (LDML)
   specification.

   The default implementation of this method returns the class name of
   this Calendar instance. Any subclasses that implement
   LDML-defined calendar systems should override this method to return
   appropriate calendar types.

  returns: the LDML-defined calendar type or the class name of this
           Calendar instance - `java.lang.String`"
  (^java.lang.String [^Calendar this]
    (-> this (.getCalendarType))))

(defn get-actual-maximum
  "Returns the maximum value that the specified calendar field
   could have, given the time value of this
   Calendar. For example, the actual maximum value of
   the MONTH field is 12 in some years, and 13 in
   other years in the Hebrew calendar system.

   The default implementation of this method uses an iterative
   algorithm to determine the actual maximum value for the
   calendar field. Subclasses should, if possible, override this
   with a more efficient implementation.

  field - the calendar field - `int`

  returns: the maximum of the given calendar field for the time
   value of this Calendar - `int`"
  (^Integer [^Calendar this ^Integer field]
    (-> this (.getActualMaximum field))))

(defn get-week-year
  "Returns the week year represented by this Calendar. The
   week year is in sync with the week cycle. The first day of the first week is the first
   day of the week year.

   The default implementation of this method throws an
   UnsupportedOperationException.

  returns: the week year of this Calendar - `int`

  throws: java.lang.UnsupportedOperationException - if any week year numbering isn't supported in this Calendar."
  (^Integer [^Calendar this]
    (-> this (.getWeekYear))))

(defn get-weeks-in-week-year
  "Returns the number of weeks in the week year represented by this
   Calendar.

   The default implementation of this method throws an
   UnsupportedOperationException.

  returns: the number of weeks in the week year. - `int`

  throws: java.lang.UnsupportedOperationException - if any week year numbering isn't supported in this Calendar."
  (^Integer [^Calendar this]
    (-> this (.getWeeksInWeekYear))))

(defn get-display-names
  "Returns a Map containing all names of the calendar
   field in the given style and
   locale and their corresponding field values. For
   example, if this Calendar is a GregorianCalendar, the returned map would contain \"Jan\" to
   JANUARY, \"Feb\" to FEBRUARY, and so on, in the
   short style in an English locale.

   Narrow names may not be unique due to use of single characters,
   such as \"S\" for Sunday and Saturday. In that case narrow names are not
   included in the returned Map.

   The values of other calendar fields may be taken into
   account to determine a set of display names. For example, if
   this Calendar is a lunisolar calendar system and
   the year value given by the YEAR field has a leap
   month, this method would return month names containing the leap
   month name, and month names are mapped to their values specific
   for the year.

   The default implementation supports display names contained in
   a DateFormatSymbols. For example, if field
   is MONTH and style is ALL_STYLES, this method returns a Map containing
   all strings returned by DateFormatSymbols.getShortMonths()
   and DateFormatSymbols.getMonths().

  field - the calendar field for which the display names are returned - `int`
  style - the style applied to the string representation; one of SHORT_FORMAT (SHORT), SHORT_STANDALONE, LONG_FORMAT (LONG), LONG_STANDALONE, NARROW_FORMAT, or NARROW_STANDALONE - `int`
  locale - the locale for the display names - `java.util.Locale`

  returns: a Map containing all display names in
          style and locale and their
          field values, or null if no display names
          are defined for field - `java.util.Map<java.lang.String,java.lang.Integer>`

  throws: java.lang.IllegalArgumentException - if field or style is invalid, or if this Calendar is non-lenient and any of the calendar fields have invalid values"
  (^java.util.Map [^Calendar this ^Integer field ^Integer style ^java.util.Locale locale]
    (-> this (.getDisplayNames field style locale))))

(defn get-time-in-millis
  "Returns this Calendar's time value in milliseconds.

  returns: the current time as UTC milliseconds from the epoch. - `long`"
  (^Long [^Calendar this]
    (-> this (.getTimeInMillis))))

(defn set-first-day-of-week
  "Sets what the first day of the week is; e.g., SUNDAY in the U.S.,
   MONDAY in France.

  value - the given first day of the week. - `int`"
  ([^Calendar this ^Integer value]
    (-> this (.setFirstDayOfWeek value))))

(defn clone
  "Creates and returns a copy of this object.

  returns: a copy of this object. - `java.lang.Object`"
  (^java.lang.Object [^Calendar this]
    (-> this (.clone))))

(defn roll
  "Adds or subtracts (up/down) a single unit of time on the given time
   field without changing larger fields. For example, to roll the current
   date up by one day, you can achieve it by calling:
   roll(Calendar.DATE, true).
   When rolling on the year or Calendar.YEAR field, it will roll the year
   value in the range between 1 and the value returned by calling
   getMaximum(Calendar.YEAR).
   When rolling on the month or Calendar.MONTH field, other fields like
   date might conflict and, need to be changed. For instance,
   rolling the month on the date 01/31/96 will result in 02/29/96.
   When rolling on the hour-in-day or Calendar.HOUR_OF_DAY field, it will
   roll the hour value in the range between 0 and 23, which is zero-based.

  field - the time field. - `int`
  up - indicates if the value of the specified time field is to be rolled up or rolled down. Use true if rolling up, false otherwise. - `boolean`"
  ([^Calendar this ^Integer field ^Boolean up]
    (-> this (.roll field up))))

(defn hash-code
  "Returns a hash code for this calendar.

  returns: a hash code value for this object. - `int`"
  (^Integer [^Calendar this]
    (-> this (.hashCode))))

(defn add
  "Adds or subtracts the specified amount of time to the given calendar field,
   based on the calendar's rules. For example, to subtract 5 days from
   the current time of the calendar, you can achieve it by calling:
   add(Calendar.DAY_OF_MONTH, -5).

  field - the calendar field. - `int`
  amount - the amount of date or time to be added to the field. - `int`"
  ([^Calendar this ^Integer field ^Integer amount]
    (-> this (.add field amount))))

(defn set
  "Sets the values for the fields YEAR, MONTH,
   DAY_OF_MONTH, HOUR_OF_DAY, MINUTE, and
   SECOND.
   Previous values of other fields are retained.  If this is not desired,
   call clear() first.

  year - the value used to set the YEAR calendar field. - `int`
  month - the value used to set the MONTH calendar field. Month value is 0-based. e.g., 0 for January. - `int`
  date - the value used to set the DAY_OF_MONTH calendar field. - `int`
  hour-of-day - the value used to set the HOUR_OF_DAY calendar field. - `int`
  minute - the value used to set the MINUTE calendar field. - `int`
  second - the value used to set the SECOND calendar field. - `int`"
  ([^Calendar this ^Integer year ^Integer month ^Integer date ^Integer hour-of-day ^Integer minute ^Integer second]
    (-> this (.set year month date hour-of-day minute second)))
  ([^Calendar this ^Integer year ^Integer month ^Integer date ^Integer hour-of-day ^Integer minute]
    (-> this (.set year month date hour-of-day minute)))
  ([^Calendar this ^Integer year ^Integer month ^Integer date]
    (-> this (.set year month date)))
  ([^Calendar this ^Integer field ^Integer value]
    (-> this (.set field value))))

(defn week-date-supported?
  "Returns whether this Calendar supports week dates.

   The default implementation of this method returns false.

  returns: true if this Calendar supports week dates;
           false otherwise. - `boolean`"
  (^Boolean [^Calendar this]
    (-> this (.isWeekDateSupported))))

(defn clear
  "Sets the given calendar field value and the time value
   (millisecond offset from the Epoch) of
   this Calendar undefined. This means that isSet(field) will return false, and
   the date and time calculations will treat the field as if it
   had never been set. A Calendar implementation
   class may use the field's specific default value for date and
   time calculations.

   The HOUR_OF_DAY, HOUR and AM_PM
   fields are handled independently and the the resolution rule for the time of
   day is applied. Clearing one of the fields doesn't reset
   the hour of day value of this Calendar. Use set(Calendar.HOUR_OF_DAY, 0) to reset the hour
   value.

  field - the calendar field to be cleared. - `int`"
  ([^Calendar this ^Integer field]
    (-> this (.clear field)))
  ([^Calendar this]
    (-> this (.clear))))

(defn compare-to
  "Compares the time values (millisecond offsets from the Epoch) represented by two
   Calendar objects.

  another-calendar - the Calendar to be compared. - `java.util.Calendar`

  returns: the value 0 if the time represented by the argument
   is equal to the time represented by this Calendar; a value
   less than 0 if the time of this Calendar is
   before the time represented by the argument; and a value greater than
   0 if the time of this Calendar is after the
   time represented by the argument. - `int`

  throws: java.lang.NullPointerException - if the specified Calendar is null."
  (^Integer [^Calendar this ^java.util.Calendar another-calendar]
    (-> this (.compareTo another-calendar))))

(defn get-minimal-days-in-first-week
  "Gets what the minimal days required in the first week of the year are;
   e.g., if the first week is defined as one that contains the first day
   of the first month of a year, this method returns 1. If
   the minimal days required must be a full week, this method
   returns 7.

  returns: the minimal days required in the first week of the year. - `int`"
  (^Integer [^Calendar this]
    (-> this (.getMinimalDaysInFirstWeek))))

(defn before
  "Returns whether this Calendar represents a time
   before the time represented by the specified
   Object. This method is equivalent to:


           compareTo(when) < 0
   if and only if when is a Calendar
   instance. Otherwise, the method returns false.

  when - the Object to be compared - `java.lang.Object`

  returns: true if the time of this
   Calendar is before the time represented by
   when; false otherwise. - `boolean`"
  (^Boolean [^Calendar this ^java.lang.Object when]
    (-> this (.before when))))

(defn get-time
  "Returns a Date object representing this
   Calendar's time value (millisecond offset from the Epoch\").

  returns: a Date representing the time value. - `java.util.Date`"
  (^java.util.Date [^Calendar this]
    (-> this (.getTime))))

(defn get-maximum
  "Returns the maximum value for the given calendar field of this
   Calendar instance. The maximum value is defined as
   the largest value returned by the get method
   for any possible time value. The maximum value depends on
   calendar system specific parameters of the instance.

  field - the calendar field. - `int`

  returns: the maximum value for the given calendar field. - `int`"
  (^Integer [^Calendar this ^Integer field]
    (-> this (.getMaximum field))))

(defn get
  "Returns the value of the given calendar field. In lenient mode,
   all calendar fields are normalized. In non-lenient mode, all
   calendar fields are validated and this method throws an
   exception if any calendar fields have out-of-range values. The
   normalization and validation are handled by the
   complete() method, which process is calendar
   system dependent.

  field - the given calendar field. - `int`

  returns: the value for the given calendar field. - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the specified field is out of range (field < 0 || field >= FIELD_COUNT)."
  (^Integer [^Calendar this ^Integer field]
    (-> this (.get field))))

(defn equals
  "Compares this Calendar to the specified
   Object.  The result is true if and only if
   the argument is a Calendar object of the same calendar
   system that represents the same time value (millisecond offset from the
   Epoch) under the same
   Calendar parameters as this object.

   The Calendar parameters are the values represented
   by the isLenient, getFirstDayOfWeek,
   getMinimalDaysInFirstWeek and getTimeZone
   methods. If there is any difference in those parameters
   between the two Calendars, this method returns
   false.

   Use the compareTo method to
   compare only the time values.

  obj - the object to compare with. - `java.lang.Object`

  returns: true if this object is equal to obj;
   false otherwise. - `boolean`"
  (^Boolean [^Calendar this ^java.lang.Object obj]
    (-> this (.equals obj))))

