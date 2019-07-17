(ns jdk.util.TimeZone
  "TimeZone represents a time zone offset, and also figures out daylight
  savings.


  Typically, you get a TimeZone using getDefault
  which creates a TimeZone based on the time zone where the program
  is running. For example, for a program running in Japan, getDefault
  creates a TimeZone object based on Japanese Standard Time.


  You can also get a TimeZone using getTimeZone
  along with a time zone ID. For instance, the time zone ID for the
  U.S. Pacific Time zone is `America/Los_Angeles`. So, you can get a
  U.S. Pacific Time TimeZone object with:


  TimeZone tz = TimeZone.getTimeZone(`America/Los_Angeles`);
  You can use the getAvailableIDs method to iterate through
  all the supported time zone IDs. You can then choose a
  supported ID to get a TimeZone.
  If the time zone you want is not represented by one of the
  supported IDs, then a custom time zone ID can be specified to
  produce a TimeZone. The syntax of a custom time zone ID is:



  CustomID:
          GMT Sign Hours : Minutes
          GMT Sign Hours Minutes
          GMT Sign Hours
  Sign: one of
          + -
  Hours:
          Digit
          Digit Digit
  Minutes:
          Digit Digit
  Digit: one of
          0 1 2 3 4 5 6 7 8 9

  Hours must be between 0 to 23 and Minutes must be
  between 00 to 59.  For example, `GMT+10` and `GMT+0010` mean ten
  hours and ten minutes ahead of GMT, respectively.

  The format is locale independent and digits must be taken from the
  Basic Latin block of the Unicode standard. No daylight saving time
  transition schedule can be specified with a custom time zone ID. If
  the specified string doesn't match the syntax, `GMT`
  is used.

  When creating a TimeZone, the specified custom time
  zone ID is normalized in the following syntax:


  NormalizedCustomID:
          GMT Sign TwoDigitHours : Minutes
  Sign: one of
          + -
  TwoDigitHours:
          Digit Digit
  Minutes:
          Digit Digit
  Digit: one of
          0 1 2 3 4 5 6 7 8 9
  For example, TimeZone.getTimeZone(`GMT-8`).getID() returns `GMT-08:00`.

  Three-letter time zone IDs

  For compatibility with JDK 1.1.x, some other three-letter time zone IDs
  (such as `PST`, `CTT`, `AST`) are also supported. However, their
  use is deprecated because the same abbreviation is often used
  for multiple time zones (for example, `CST` could be U.S. `Central Standard
  Time` and `China Standard Time`), and the Java platform can then only
  recognize one of them."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util TimeZone]))

(defn ->time-zone
  "Constructor.

  Sole constructor.  (For invocation by subclass constructors, typically
   implicit.)"
  ([]
    (new TimeZone )))

(def *-short
  "Static Constant.

  A style specifier for getDisplayName() indicating
   a short name, such as `PST.`

  type: int"
  TimeZone/SHORT)

(def *-long
  "Static Constant.

  A style specifier for getDisplayName() indicating
   a long name, such as `Pacific Standard Time.`

  type: int"
  TimeZone/LONG)

(defn *get-time-zone
  "Gets the TimeZone for the given ID.

  id - the ID for a TimeZone, either an abbreviation such as `PST`, a full name such as `America/Los_Angeles`, or a custom ID such as `GMT-8:00`. Note that the support of abbreviations is for JDK 1.1.x compatibility only and full names should be used. - `java.lang.String`

  returns: the specified TimeZone, or the GMT zone if the given ID
   cannot be understood. - `java.util.TimeZone`"
  (^java.util.TimeZone [^java.lang.String id]
    (TimeZone/getTimeZone id)))

(defn *get-available-i-ds
  "Gets the available IDs according to the given time zone offset in milliseconds.

  raw-offset - the given time zone GMT offset in milliseconds. - `int`

  returns: an array of IDs, where the time zone for that ID has
   the specified GMT offset. For example, `America/Phoenix` and `America/Denver`
   both have GMT-07:00, but differ in daylight saving behavior. - `java.lang.String[]`"
  ([^Integer raw-offset]
    (TimeZone/getAvailableIDs raw-offset))
  ([]
    (TimeZone/getAvailableIDs )))

(defn *get-default
  "Gets the default TimeZone of the Java virtual machine. If the
   cached default TimeZone is available, its clone is returned.
   Otherwise, the method takes the following steps to determine the default
   time zone.


   Use the user.timezone property value as the default
   time zone ID if it's available.
   Detect the platform time zone ID. The source of the
   platform time zone and ID mapping may vary with implementation.
   Use GMT as the last resort if the given or detected
   time zone ID is unknown.


   The default TimeZone created from the ID is cached,
   and its clone is returned. The user.timezone property
   value is set to the ID upon return.

  returns: the default TimeZone - `java.util.TimeZone`"
  (^java.util.TimeZone []
    (TimeZone/getDefault )))

(defn *set-default
  "Sets the TimeZone that is returned by the getDefault
   method. zone is cached. If zone is null, the cached
   default TimeZone is cleared. This method doesn't change the value
   of the user.timezone property.

  zone - the new default TimeZone, or null - `java.util.TimeZone`

  throws: java.lang.SecurityException - if the security manager's checkPermission denies PropertyPermission(`user.timezone`, `write`)"
  ([^java.util.TimeZone zone]
    (TimeZone/setDefault zone)))

(defn in-daylight-time
  "Queries if the given date is in Daylight Saving Time in
   this time zone.

  date - the given Date. - `java.util.Date`

  returns: true if the given date is in Daylight Saving Time,
           false, otherwise. - `boolean`"
  (^Boolean [^java.util.TimeZone this ^java.util.Date date]
    (-> this (.inDaylightTime date))))

(defn get-raw-offset
  "Returns the amount of time in milliseconds to add to UTC to get
   standard time in this time zone. Because this value is not
   affected by daylight saving time, it is called raw
   offset.

   If an underlying TimeZone implementation subclass
   supports historical GMT offset changes, the method returns the
   raw offset value of the current date. In Honolulu, for example,
   its raw offset changed from GMT-10:30 to GMT-10:00 in 1947, and
   this method always returns -36000000 milliseconds (i.e., -10
   hours).

  returns: the amount of raw offset time in milliseconds to add to UTC. - `int`"
  (^Integer [^java.util.TimeZone this]
    (-> this (.getRawOffset))))

(defn get-display-name
  "Returns a name in the specified style of this TimeZone
   suitable for presentation to the user in the specified locale. If the specified daylight is true, a Daylight
   Saving Time name is returned (even if this TimeZone doesn't
   observe Daylight Saving Time). Otherwise, a Standard Time name is
   returned.

   When looking up a time zone name, the default
   Locale search path of ResourceBundle derived
   from the specified locale is used. (No fallback
   Locale search is performed.) If a time zone name in any
   Locale of the search path, including Locale.ROOT, is
   found, the name is returned. Otherwise, a string in the
   normalized custom ID format is returned.

  daylight - true specifying a Daylight Saving Time name, or false specifying a Standard Time name - `boolean`
  style - either LONG or SHORT - `int`
  locale - the locale in which to supply the display name. - `java.util.Locale`

  returns: the human-readable name of this time zone in the given locale. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if style is invalid."
  (^java.lang.String [^java.util.TimeZone this ^Boolean daylight ^Integer style ^java.util.Locale locale]
    (-> this (.getDisplayName daylight style locale)))
  (^java.lang.String [^java.util.TimeZone this ^Boolean daylight ^Integer style]
    (-> this (.getDisplayName daylight style)))
  (^java.lang.String [^java.util.TimeZone this ^java.util.Locale locale]
    (-> this (.getDisplayName locale)))
  (^java.lang.String [^java.util.TimeZone this]
    (-> this (.getDisplayName))))

(defn get-dst-savings
  "Returns the amount of time to be added to local standard time
   to get local wall clock time.

   The default implementation returns 3600000 milliseconds
   (i.e., one hour) if a call to useDaylightTime()
   returns true. Otherwise, 0 (zero) is returned.

   If an underlying TimeZone implementation subclass
   supports historical and future Daylight Saving Time schedule
   changes, this method returns the amount of saving time of the
   last known Daylight Saving Time rule that can be a future
   prediction.

   If the amount of saving time at any given time stamp is
   required, construct a Calendar with this TimeZone and the time stamp, and call Calendar.get(Calendar.DST_OFFSET).

  returns: the amount of saving time in milliseconds - `int`"
  (^Integer [^java.util.TimeZone this]
    (-> this (.getDSTSavings))))

(defn get-offset
  "Gets the time zone offset, for current date, modified in case of
   daylight savings. This is the offset to add to UTC to get local time.

   This method returns a historically correct offset if an
   underlying TimeZone implementation subclass
   supports historical Daylight Saving Time schedule and GMT
   offset changes.

  era - the era of the given date. - `int`
  year - the year in the given date. - `int`
  month - the month in the given date. Month is 0-based. e.g., 0 for January. - `int`
  day - the day-in-month of the given date. - `int`
  day-of-week - the day-of-week of the given date. - `int`
  milliseconds - the milliseconds in day in standard local time. - `int`

  returns: the offset in milliseconds to add to GMT to get local time. - `int`"
  (^Integer [^java.util.TimeZone this ^Integer era ^Integer year ^Integer month ^Integer day ^Integer day-of-week ^Integer milliseconds]
    (-> this (.getOffset era year month day day-of-week milliseconds)))
  (^Integer [^java.util.TimeZone this ^Long date]
    (-> this (.getOffset date))))

(defn set-raw-offset
  "Sets the base time zone offset to GMT.
   This is the offset to add to UTC to get local time.

   If an underlying TimeZone implementation subclass
   supports historical GMT offset changes, the specified GMT
   offset is set as the latest GMT offset and the difference from
   the known latest GMT offset value is used to adjust all
   historical GMT offset values.

  offset-millis - the given base time zone offset to GMT. - `int`"
  ([^java.util.TimeZone this ^Integer offset-millis]
    (-> this (.setRawOffset offset-millis))))

(defn has-same-rules?
  "Returns true if this zone has the same rule and offset as another zone.
   That is, if this zone differs only in ID, if at all.  Returns false
   if the other zone is null.

  other - the TimeZone object to be compared with - `java.util.TimeZone`

  returns: true if the other zone is not null and is the same as this one,
   with the possible exception of the ID - `boolean`"
  (^Boolean [^java.util.TimeZone this ^java.util.TimeZone other]
    (-> this (.hasSameRules other))))

(defn clone
  "Creates a copy of this TimeZone.

  returns: a clone of this TimeZone - `java.lang.Object`"
  (^java.lang.Object [^java.util.TimeZone this]
    (-> this (.clone))))

(defn get-id
  "Gets the ID of this time zone.

  returns: the ID of this time zone. - `java.lang.String`"
  (^java.lang.String [^java.util.TimeZone this]
    (-> this (.getID))))

(defn to-zone-id
  "Converts this TimeZone object to a ZoneId.

  returns: a ZoneId representing the same time zone as this
           TimeZone - `java.time.ZoneId`"
  (^java.time.ZoneId [^java.util.TimeZone this]
    (-> this (.toZoneId))))

(defn observes-daylight-time
  "Returns true if this TimeZone is currently in
   Daylight Saving Time, or if a transition from Standard Time to
   Daylight Saving Time occurs at any future time.

   The default implementation returns true if
   useDaylightTime() or inDaylightTime(new Date())
   returns true.

  returns: true if this TimeZone is currently in
   Daylight Saving Time, or if a transition from Standard Time to
   Daylight Saving Time occurs at any future time; false
   otherwise. - `boolean`"
  (^Boolean [^java.util.TimeZone this]
    (-> this (.observesDaylightTime))))

(defn set-id
  "Sets the time zone ID. This does not change any other data in
   the time zone object.

  id - the new time zone ID. - `java.lang.String`"
  ([^java.util.TimeZone this ^java.lang.String id]
    (-> this (.setID id))))

(defn use-daylight-time
  "Queries if this TimeZone uses Daylight Saving Time.

   If an underlying TimeZone implementation subclass
   supports historical and future Daylight Saving Time schedule
   changes, this method refers to the last known Daylight Saving Time
   rule that can be a future prediction and may not be the same as
   the current rule. Consider calling observesDaylightTime()
   if the current rule should also be taken into account.

  returns: true if this TimeZone uses Daylight Saving Time,
           false, otherwise. - `boolean`"
  (^Boolean [^java.util.TimeZone this]
    (-> this (.useDaylightTime))))

