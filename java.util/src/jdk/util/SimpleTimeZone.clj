(ns jdk.util.SimpleTimeZone
  "SimpleTimeZone is a concrete subclass of TimeZone
  that represents a time zone for use with a Gregorian calendar.
  The class holds an offset from GMT, called raw offset, and start
  and end rules for a daylight saving time schedule.  Since it only holds
  single values for each, it cannot handle historical changes in the offset
  from GMT and the daylight saving schedule, except that the setStartYear method can specify the year when the daylight
  saving time schedule starts in effect.

  To construct a SimpleTimeZone with a daylight saving time
  schedule, the schedule can be described with a set of rules,
  start-rule and end-rule. A day when daylight saving time
  starts or ends is specified by a combination of month,
  day-of-month, and day-of-week values. The month
  value is represented by a Calendar MONTH field
  value, such as Calendar.MARCH. The day-of-week value is
  represented by a Calendar DAY_OF_WEEK value,
  such as SUNDAY. The meanings of value combinations
  are as follows.


  Exact day of month
  To specify an exact day of month, set the month and
  day-of-month to an exact value, and day-of-week to zero. For
  example, to specify March 1, set the month to MARCH, day-of-month to 1, and day-of-week to 0.

  Day of week on or after day of month
  To specify a day of week on or after an exact day of month, set the
  month to an exact month value, day-of-month to the day on
  or after which the rule is applied, and day-of-week to a negative DAY_OF_WEEK field value. For example, to specify the
  second Sunday of April, set month to APRIL,
  day-of-month to 8, and day-of-week to -SUNDAY.

  Day of week on or before day of month
  To specify a day of the week on or before an exact day of the month, set
  day-of-month and day-of-week to a negative value. For
  example, to specify the last Wednesday on or before the 21st of March, set
  month to MARCH, day-of-month is -21
  and day-of-week is -WEDNESDAY.

  Last day-of-week of month
  To specify, the last day-of-week of the month, set day-of-week to a
  DAY_OF_WEEK value and day-of-month to
  -1. For example, to specify the last Sunday of October, set month
  to OCTOBER, day-of-week to SUNDAY and day-of-month to -1.


  The time of the day at which daylight saving time starts or ends is
  specified by a millisecond value within the day. There are three kinds of
  modes to specify the time: WALL_TIME, STANDARD_TIME and UTC_TIME. For example, if daylight
  saving time ends
  at 2:00 am in the wall clock time, it can be specified by 7200000
  milliseconds in the WALL_TIME mode. In this case, the wall clock time
  for an end-rule means the same thing as the daylight time.

  The following are examples of parameters for constructing time zone objects.


       // Base GMT offset: -8:00
       // DST starts:      at 2:00am in standard time
       //                  on the first Sunday in April
       // DST ends:        at 2:00am in daylight time
       //                  on the last Sunday in October
       // Save:            1 hour
       SimpleTimeZone(-28800000,
                      `America/Los_Angeles`,
                      Calendar.APRIL, 1, -Calendar.SUNDAY,
                      7200000,
                      Calendar.OCTOBER, -1, Calendar.SUNDAY,
                      7200000,
                      3600000)

       // Base GMT offset: 1:00
       // DST starts:      at 1:00am in UTC time
       //                  on the last Sunday in March
       // DST ends:        at 1:00am in UTC time
       //                  on the last Sunday in October
       // Save:            1 hour
       SimpleTimeZone(3600000,
                      `Europe/Paris`,
                      Calendar.MARCH, -1, Calendar.SUNDAY,
                      3600000, SimpleTimeZone.UTC_TIME,
                      Calendar.OCTOBER, -1, Calendar.SUNDAY,
                      3600000, SimpleTimeZone.UTC_TIME,
                      3600000)
  These parameter rules are also applicable to the set rule methods, such as
  setStartRule."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util SimpleTimeZone]))

(defn ->simple-time-zone
  "Constructor.

  Constructs a SimpleTimeZone with the given base time zone offset from
   GMT, time zone ID, and rules for starting and ending the daylight
   time.
   This constructor takes the full set of the start and end rules
   parameters, including modes of startTime and
   endTime. The mode specifies either wall
   time or standard time or UTC
   time.

  raw-offset - The given base time zone offset from GMT. - `int`
  id - The time zone ID which is given to this object. - `java.lang.String`
  start-month - The daylight saving time starting month. Month is a MONTH field value (0-based. e.g., 0 for January). - `int`
  start-day - The day of the month on which the daylight saving time starts. See the class description for the special cases of this parameter. - `int`
  start-day-of-week - The daylight saving time starting day-of-week. See the class description for the special cases of this parameter. - `int`
  start-time - The daylight saving time starting time in the time mode specified by startTimeMode. - `int`
  start-time-mode - The mode of the start time specified by startTime. - `int`
  end-month - The daylight saving time ending month. Month is a MONTH field value (0-based. e.g., 9 for October). - `int`
  end-day - The day of the month on which the daylight saving time ends. See the class description for the special cases of this parameter. - `int`
  end-day-of-week - The daylight saving time ending day-of-week. See the class description for the special cases of this parameter. - `int`
  end-time - The daylight saving ending time in time time mode specified by endTimeMode. - `int`
  end-time-mode - The mode of the end time specified by endTime - `int`
  dst-savings - The amount of time in milliseconds saved during daylight saving time. - `int`

  throws: java.lang.IllegalArgumentException - if the month, day, dayOfWeek, time more, or time parameters are out of range for the start or end rule, or if a time mode value is invalid."
  ([raw-offset id start-month start-day start-day-of-week start-time start-time-mode end-month end-day end-day-of-week end-time end-time-mode dst-savings]
    (new SimpleTimeZone raw-offset id start-month start-day start-day-of-week start-time start-time-mode end-month end-day end-day-of-week end-time end-time-mode dst-savings))
  ([raw-offset id start-month start-day start-day-of-week start-time end-month end-day end-day-of-week end-time dst-savings]
    (new SimpleTimeZone raw-offset id start-month start-day start-day-of-week start-time end-month end-day end-day-of-week end-time dst-savings))
  ([raw-offset id start-month start-day start-day-of-week start-time end-month end-day end-day-of-week end-time]
    (new SimpleTimeZone raw-offset id start-month start-day start-day-of-week start-time end-month end-day end-day-of-week end-time))
  ([raw-offset id]
    (new SimpleTimeZone raw-offset id)))

(def *-wall-time
  "Static Constant.

  Constant for a mode of start or end time specified as wall clock
   time.  Wall clock time is standard time for the onset rule, and
   daylight time for the end rule.

  type: int"
  SimpleTimeZone/WALL_TIME)

(def *-standard-time
  "Static Constant.

  Constant for a mode of start or end time specified as standard time.

  type: int"
  SimpleTimeZone/STANDARD_TIME)

(def *-utc-time
  "Static Constant.

  Constant for a mode of start or end time specified as UTC. European
   Union rules are specified as UTC time, for example.

  type: int"
  SimpleTimeZone/UTC_TIME)

(defn set-start-year
  "Sets the daylight saving time starting year.

  year - The daylight saving starting year. - `int`"
  ([this year]
    (-> this (.setStartYear year))))

(defn in-daylight-time
  "Queries if the given date is in daylight saving time.

  date - the given Date. - `java.util.Date`

  returns: true if daylight saving time is in effective at the
   given date; false otherwise. - `boolean`"
  ([this date]
    (-> this (.inDaylightTime date))))

(defn set-dst-savings
  "Sets the amount of time in milliseconds that the clock is advanced
   during daylight saving time.

  millis-saved-during-dst - the number of milliseconds the time is advanced with respect to standard time when the daylight saving time rules are in effect. A positive number, typically one hour (3600000). - `int`"
  ([this millis-saved-during-dst]
    (-> this (.setDSTSavings millis-saved-during-dst))))

(defn get-raw-offset
  "Gets the GMT offset for this time zone.

  returns: the GMT offset value in milliseconds - `int`"
  ([this]
    (-> this (.getRawOffset))))

(defn to-string
  "Returns a string representation of this time zone.

  returns: a string representation of this time zone. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-dst-savings
  "Returns the amount of time in milliseconds that the clock is
   advanced during daylight saving time.

  returns: the number of milliseconds the time is advanced with
   respect to standard time when the daylight saving rules are in
   effect, or 0 (zero) if this time zone doesn't observe daylight
   saving time. - `int`"
  ([this]
    (-> this (.getDSTSavings))))

(defn get-offset
  "Returns the difference in milliseconds between local time and
   UTC, taking into account both the raw offset and the effect of
   daylight saving, for the specified date and time.  This method
   assumes that the start and end month are distinct.  It also
   uses a default GregorianCalendar object as its
   underlying calendar, such as for determining leap years.  Do
   not use the result of this method with a calendar other than a
   default GregorianCalendar.

   Note:  In general, clients should use
   Calendar.get(ZONE_OFFSET)  Calendar.get(DST_OFFSET)
   instead of calling this method.

  era - The era of the given date. - `int`
  year - The year in the given date. - `int`
  month - The month in the given date. Month is 0-based. e.g., 0 for January. - `int`
  day - The day-in-month of the given date. - `int`
  day-of-week - The day-of-week of the given date. - `int`
  millis - The milliseconds in day in standard local time. - `int`

  returns: The milliseconds to add to UTC to get local time. - `int`

  throws: java.lang.IllegalArgumentException - the era, month, day, dayOfWeek, or millis parameters are out of range"
  ([this era year month day day-of-week millis]
    (-> this (.getOffset era year month day day-of-week millis)))
  ([this date]
    (-> this (.getOffset date))))

(defn set-end-rule
  "Sets the daylight saving time end rule to a weekday before or after the given date within
   a month, e.g., the first Monday on or after the 8th.

  end-month - The daylight saving time ending month. Month is a MONTH field value (0-based. e.g., 9 for October). - `int`
  end-day - The day of the month on which the daylight saving time ends. - `int`
  end-day-of-week - The daylight saving time ending day-of-week. - `int`
  end-time - The daylight saving ending time in local wall clock time, (in milliseconds within the day) which is local daylight time in this case. - `int`
  after - If true, this rule selects the first endDayOfWeek on or after endDay. If false, this rule selects the last endDayOfWeek on or before endDay of the month. - `boolean`

  throws: java.lang.IllegalArgumentException - the endMonth, endDay, endDayOfWeek, or endTime parameters are out of range"
  ([this end-month end-day end-day-of-week end-time after]
    (-> this (.setEndRule end-month end-day end-day-of-week end-time after)))
  ([this end-month end-day end-day-of-week end-time]
    (-> this (.setEndRule end-month end-day end-day-of-week end-time)))
  ([this end-month end-day end-time]
    (-> this (.setEndRule end-month end-day end-time))))

(defn set-raw-offset
  "Sets the base time zone offset to GMT.
   This is the offset to add to UTC to get local time.

  offset-millis - the given base time zone offset to GMT. - `int`"
  ([this offset-millis]
    (-> this (.setRawOffset offset-millis))))

(defn has-same-rules?
  "Returns true if this zone has the same rules and offset as another zone.

  other - the TimeZone object to be compared with - `java.util.TimeZone`

  returns: true if the given zone is a SimpleTimeZone and has the
   same rules and offset as this one - `boolean`"
  ([this other]
    (-> this (.hasSameRules other))))

(defn clone
  "Returns a clone of this SimpleTimeZone instance.

  returns: a clone of this instance. - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn hash-code
  "Generates the hash code for the SimpleDateFormat object.

  returns: the hash code for this object - `int`"
  ([this]
    (-> this (.hashCode))))

(defn observes-daylight-time
  "Returns true if this SimpleTimeZone observes
   Daylight Saving Time. This method is equivalent to useDaylightTime().

  returns: true if this SimpleTimeZone observes
   Daylight Saving Time; false otherwise. - `boolean`"
  ([this]
    (-> this (.observesDaylightTime))))

(defn equals
  "Compares the equality of two SimpleTimeZone objects.

  obj - The SimpleTimeZone object to be compared with. - `java.lang.Object`

  returns: True if the given obj is the same as this
               SimpleTimeZone object; false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn set-start-rule
  "Sets the daylight saving time start rule to a weekday before or after the given date within
   a month, e.g., the first Monday on or after the 8th.

  start-month - The daylight saving time starting month. Month is a MONTH field value (0-based. e.g., 0 for January). - `int`
  start-day - The day of the month on which the daylight saving time starts. - `int`
  start-day-of-week - The daylight saving time starting day-of-week. - `int`
  start-time - The daylight saving time starting time in local wall clock time, which is local standard time in this case. - `int`
  after - If true, this rule selects the first dayOfWeek on or after dayOfMonth. If false, this rule selects the last dayOfWeek on or before dayOfMonth. - `boolean`

  throws: java.lang.IllegalArgumentException - if the startMonth, startDay, startDayOfWeek, or startTime parameters are out of range"
  ([this start-month start-day start-day-of-week start-time after]
    (-> this (.setStartRule start-month start-day start-day-of-week start-time after)))
  ([this start-month start-day start-day-of-week start-time]
    (-> this (.setStartRule start-month start-day start-day-of-week start-time)))
  ([this start-month start-day start-time]
    (-> this (.setStartRule start-month start-day start-time))))

(defn use-daylight-time
  "Queries if this time zone uses daylight saving time.

  returns: true if this time zone uses daylight saving time;
   false otherwise. - `boolean`"
  ([this]
    (-> this (.useDaylightTime))))

