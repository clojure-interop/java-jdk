(ns jdk.util.Calendar$Builder
  "Calendar.Builder is used for creating a Calendar from
  various date-time parameters.

  There are two ways to set a Calendar to a date-time value. One
  is to set the instant parameter to a millisecond offset from the Epoch. The other is to set individual
  field parameters, such as YEAR, to their desired
  values. These two ways can't be mixed. Trying to set both the instant and
  individual fields will cause an IllegalStateException to be
  thrown. However, it is permitted to override previous values of the
  instant or field parameters.

  If no enough field parameters are given for determining date and/or
  time, calendar specific default values are used when building a
  Calendar. For example, if the YEAR value
  isn't given for the Gregorian calendar, 1970 will be used. If there are
  any conflicts among field parameters, the  resolution rules are applied.
  Therefore, the order of field setting matters.

  In addition to the date-time parameters,
  the locale,
  time zone,
  week definition, and
  leniency mode parameters can be set.

  Examples
  The following are sample usages. Sample code assumes that the
  Calendar constants are statically imported.

  The following code produces a Calendar with date 2012-12-31
  (Gregorian) because Monday is the first day of a week with the  ISO 8601
  compatible week parameters.


    Calendar cal = new Calendar.Builder().setCalendarType(`iso8601`)
                         .setWeekDate(2013, 1, MONDAY).build();
  The following code produces a Japanese Calendar with date
  1989-01-08 (Gregorian), assuming that the default ERA
  is Heisei that started on that day.


    Calendar cal = new Calendar.Builder().setCalendarType(`japanese`)
                         .setFields(YEAR, 1, DAY_OF_YEAR, 1).build();"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Calendar$Builder]))

(defn ->builder
  "Constructor.

  Constructs a Calendar.Builder."
  ([]
    (new Calendar$Builder )))

(defn set-time-zone
  "Sets the time zone parameter to the given zone. If no time
   zone parameter is given to this Caledar.Builder, the
   default
   TimeZone will be used in the build
   method.

  zone - the TimeZone - `java.util.TimeZone`

  returns: this Calendar.Builder - `java.util.Calendar.Builder`

  throws: java.lang.NullPointerException - if zone is null"
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^java.util.TimeZone zone]
    (-> this (.setTimeZone zone))))

(defn set-fields
  "Sets field parameters to their values given by
   fieldValuePairs that are pairs of a field and its value.
   For example,


     setFeilds(Calendar.YEAR, 2013,
               Calendar.MONTH, Calendar.DECEMBER,
               Calendar.DAY_OF_MONTH, 23);
   is equivalent to the sequence of the following
   set calls:


     set(Calendar.YEAR, 2013)
     .set(Calendar.MONTH, Calendar.DECEMBER)
     .set(Calendar.DAY_OF_MONTH, 23);

  field-value-pairs - field-value pairs - `int`

  returns: this Calendar.Builder - `java.util.Calendar.Builder`

  throws: java.lang.NullPointerException - if fieldValuePairs is null"
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^Integer field-value-pairs]
    (-> this (.setFields field-value-pairs))))

(defn set-date
  "Sets the date field parameters to the values given by year,
   month, and dayOfMonth. This method is equivalent to
   a call to:


     setFields(Calendar.YEAR, year,
               Calendar.MONTH, month,
               Calendar.DAY_OF_MONTH, dayOfMonth);

  year - the YEAR value - `int`
  month - the MONTH value (the month numbering is 0-based). - `int`
  day-of-month - the DAY_OF_MONTH value - `int`

  returns: this Calendar.Builder - `java.util.Calendar.Builder`"
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^Integer year ^Integer month ^Integer day-of-month]
    (-> this (.setDate year month day-of-month))))

(defn set-lenient
  "Sets the lenient mode parameter to the value given by lenient.
   If no lenient parameter is given to this Calendar.Builder,
   lenient mode will be used in the build method.

  lenient - true for lenient mode; false for non-lenient mode - `boolean`

  returns: this Calendar.Builder - `java.util.Calendar.Builder`"
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^Boolean lenient]
    (-> this (.setLenient lenient))))

(defn set-week-date
  "Sets the week-based date parameters to the values with the given
   date specifiers - week year, week of year, and day of week.

   If the specified calendar doesn't support week dates, the
   build method will throw an IllegalArgumentException.

  week-year - the week year - `int`
  week-of-year - the week number based on weekYear - `int`
  day-of-week - the day of week value: one of the constants for the DAY_OF_WEEK field: SUNDAY, ..., SATURDAY. - `int`

  returns: this Calendar.Builder - `java.util.Calendar.Builder`"
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^Integer week-year ^Integer week-of-year ^Integer day-of-week]
    (-> this (.setWeekDate week-year week-of-year day-of-week))))

(defn set-calendar-type
  "Sets the calendar type parameter to the given type. The
   calendar type given by this method has precedence over any explicit
   or implicit calendar type given by the
   locale.

   In addition to the available calendar types returned by the
   Calendar.getAvailableCalendarTypes
   method, `gregorian` and `iso8601` as aliases of
   `gregory` can be used with this method.

  type - the calendar type - `java.lang.String`

  returns: this Calendar.Builder - `java.util.Calendar.Builder`

  throws: java.lang.NullPointerException - if type is null"
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^java.lang.String type]
    (-> this (.setCalendarType type))))

(defn set-instant
  "Sets the instant parameter to the given instant value that is
   a millisecond offset from the
   Epoch.

  instant - a millisecond offset from the Epoch - `long`

  returns: this Calendar.Builder - `java.util.Calendar.Builder`

  throws: java.lang.IllegalStateException - if any of the field parameters have already been set"
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^Long instant]
    (-> this (.setInstant instant))))

(defn set-week-definition
  "Sets the week definition parameters to the values given by
   firstDayOfWeek and minimalDaysInFirstWeek that are
   used to determine the first
   week of a year. The parameters given by this method have
   precedence over the default values given by the
   locale.

  first-day-of-week - the first day of a week; one of Calendar.SUNDAY to Calendar.SATURDAY - `int`
  minimal-days-in-first-week - the minimal number of days in the first week (1..7) - `int`

  returns: this Calendar.Builder - `java.util.Calendar.Builder`

  throws: java.lang.IllegalArgumentException - if firstDayOfWeek or minimalDaysInFirstWeek is invalid"
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^Integer first-day-of-week ^Integer minimal-days-in-first-week]
    (-> this (.setWeekDefinition first-day-of-week minimal-days-in-first-week))))

(defn set-time-of-day
  "Sets the time of day field parameters to the values given by
   hourOfDay, minute, second, and
   millis. This method is equivalent to a call to:


     setFields(Calendar.HOUR_OF_DAY, hourOfDay,
               Calendar.MINUTE, minute,
               Calendar.SECOND, second,
               Calendar.MILLISECOND, millis);

  hour-of-day - the HOUR_OF_DAY value (24-hour clock) - `int`
  minute - the MINUTE value - `int`
  second - the SECOND value - `int`
  millis - the MILLISECOND value - `int`

  returns: this Calendar.Builder - `java.util.Calendar.Builder`"
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^Integer hour-of-day ^Integer minute ^Integer second ^Integer millis]
    (-> this (.setTimeOfDay hour-of-day minute second millis)))
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^Integer hour-of-day ^Integer minute ^Integer second]
    (-> this (.setTimeOfDay hour-of-day minute second))))

(defn build
  "Returns a Calendar built from the parameters set by the
   setter methods. The calendar type given by the setCalendarType method or the locale is
   used to determine what Calendar to be created. If no explicit
   calendar type is given, the locale's default calendar is created.

   If the calendar type is `iso8601`, the
   Gregorian change date
   of a GregorianCalendar is set to Date(Long.MIN_VALUE)
   to be the proleptic Gregorian calendar. Its week definition
   parameters are also set to be compatible
   with the ISO 8601 standard. Note that the
   getCalendarType method of
   a GregorianCalendar created with `iso8601` returns
   `gregory`.

   The default values are used for locale and time zone if these
   parameters haven't been given explicitly.

   Any out of range field values are either normalized in lenient
   mode or detected as an invalid value in non-lenient mode.

  returns: a Calendar built with parameters of this Calendar.Builder - `java.util.Calendar`

  throws: java.lang.IllegalArgumentException - if the calendar type is unknown, or if any invalid field values are given in non-lenient mode, or if a week date is given for the calendar type that doesn't support week dates."
  (^java.util.Calendar [^java.util.Calendar$Builder this]
    (-> this (.build))))

(defn set-locale
  "Sets the locale parameter to the given locale. If no locale
   is given to this Calendar.Builder, the default Locale
   for Locale.Category.FORMAT will be used.

   If no calendar type is explicitly given by a call to the
   setCalendarType method,
   the Locale value is used to determine what type of
   Calendar to be built.

   If no week definition parameters are explicitly given by a call to
   the setWeekDefinition method, the
   Locale's default values are used.

  locale - the Locale - `java.util.Locale`

  returns: this Calendar.Builder - `java.util.Calendar.Builder`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^java.util.Locale locale]
    (-> this (.setLocale locale))))

(defn set
  "Sets the field parameter to the given value.
   field is an index to the Calendar.fields, such as
   DAY_OF_MONTH. Field value validation is
   not performed in this method. Any out of range values are either
   normalized in lenient mode or detected as an invalid value in
   non-lenient mode when building a Calendar.

  field - an index to the Calendar fields - `int`
  value - the field value - `int`

  returns: this Calendar.Builder - `java.util.Calendar.Builder`

  throws: java.lang.IllegalArgumentException - if field is invalid"
  (^java.util.Calendar.Builder [^java.util.Calendar$Builder this ^Integer field ^Integer value]
    (-> this (.set field value))))

