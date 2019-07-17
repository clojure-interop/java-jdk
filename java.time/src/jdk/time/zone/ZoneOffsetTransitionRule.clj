(ns jdk.time.zone.ZoneOffsetTransitionRule
  "A rule expressing how to create a transition.

  This class allows rules for identifying future transitions to be expressed.
  A rule might be written in many forms:

  the 16th March
  the Sunday on or after the 16th March
  the Sunday on or before the 16th March
  the last Sunday in February

  These different rule types can be expressed and queried."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.zone ZoneOffsetTransitionRule]))

(defn *of
  "Obtains an instance defining the yearly rule to create transitions between two offsets.

   Applications should normally obtain an instance from ZoneRules.
   This factory is only intended for use when creating ZoneRules.

  month - the month of the month-day of the first day of the cutover week, not null - `java.time.Month`
  day-of-month-indicator - the day of the month-day of the cutover week, positive if the week is that day or later, negative if the week is that day or earlier, counting from the last day of the month, from -28 to 31 excluding 0 - `int`
  day-of-week - the required day-of-week, null if the month-day should not be changed - `java.time.DayOfWeek`
  time - the cutover time in the 'before' offset, not null - `java.time.LocalTime`
  time-end-of-day - whether the time is midnight at the end of day - `boolean`
  time-defnition - how to interpret the cutover - `java.time.zone.ZoneOffsetTransitionRule.TimeDefinition`
  standard-offset - the standard offset in force at the cutover, not null - `java.time.ZoneOffset`
  offset-before - the offset before the cutover, not null - `java.time.ZoneOffset`
  offset-after - the offset after the cutover, not null - `java.time.ZoneOffset`

  returns: the rule, not null - `java.time.zone.ZoneOffsetTransitionRule`

  throws: java.lang.IllegalArgumentException - if the end of day flag is true when the time is not midnight"
  ([month day-of-month-indicator day-of-week time time-end-of-day time-defnition standard-offset offset-before offset-after]
    (ZoneOffsetTransitionRule/of month day-of-month-indicator day-of-week time time-end-of-day time-defnition standard-offset offset-before offset-after)))

(defn get-offset-before
  "Gets the offset before the transition.

  returns: the offset before, not null - `java.time.ZoneOffset`"
  ([this]
    (-> this (.getOffsetBefore))))

(defn get-standard-offset
  "Gets the standard offset in force at the transition.

  returns: the standard offset, not null - `java.time.ZoneOffset`"
  ([this]
    (-> this (.getStandardOffset))))

(defn get-time-definition
  "Gets the time definition, specifying how to convert the time to an instant.

   The local time can be converted to an instant using the standard offset,
   the wall offset or UTC.

  returns: the time definition, not null - `java.time.zone.ZoneOffsetTransitionRule.TimeDefinition`"
  ([this]
    (-> this (.getTimeDefinition))))

(defn midnight-end-of-day?
  "Is the transition local time midnight at the end of day.

   The transition may be represented as occurring at 24:00.

  returns: whether a local time of midnight is at the start or end of the day - `boolean`"
  ([this]
    (-> this (.isMidnightEndOfDay))))

(defn get-day-of-week
  "Gets the day-of-week of the transition.

   If the rule defines an exact date then this returns null.

   If the rule defines a week where the cutover might occur, then this method
   returns the day-of-week that the month-day will be adjusted to.
   If the day is positive then the adjustment is later.
   If the day is negative then the adjustment is earlier.

  returns: the day-of-week that the transition occurs, null if the rule defines an exact date - `java.time.DayOfWeek`"
  ([this]
    (-> this (.getDayOfWeek))))

(defn create-transition
  "Creates a transition instance for the specified year.

   Calculations are performed using the ISO-8601 chronology.

  year - the year to create a transition for, not null - `int`

  returns: the transition instance, not null - `java.time.zone.ZoneOffsetTransition`"
  ([this year]
    (-> this (.createTransition year))))

(defn to-string
  "Returns a string describing this object.

  returns: a string for debugging, not null - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-local-time
  "Gets the local time of day of the transition which must be checked with
   isMidnightEndOfDay().

   The time is converted into an instant using the time definition.

  returns: the local time of day of the transition, not null - `java.time.LocalTime`"
  ([this]
    (-> this (.getLocalTime))))

(defn get-day-of-month-indicator
  "Gets the indicator of the day-of-month of the transition.

   If the rule defines an exact date then the day is the month of that date.

   If the rule defines a week where the transition might occur, then the day
   defines either the start of the end of the transition week.

   If the value is positive, then it represents a normal day-of-month, and is the
   earliest possible date that the transition can be.
   The date may refer to 29th February which should be treated as 1st March in non-leap years.

   If the value is negative, then it represents the number of days back from the
   end of the month where -1 is the last day of the month.
   In this case, the day identified is the latest possible date that the transition can be.

  returns: the day-of-month indicator, from -28 to 31 excluding 0 - `int`"
  ([this]
    (-> this (.getDayOfMonthIndicator))))

(defn get-offset-after
  "Gets the offset after the transition.

  returns: the offset after, not null - `java.time.ZoneOffset`"
  ([this]
    (-> this (.getOffsetAfter))))

(defn hash-code
  "Returns a suitable hash code.

  returns: the hash code - `int`"
  ([this]
    (-> this (.hashCode))))

(defn get-month
  "Gets the month of the transition.

   If the rule defines an exact date then the month is the month of that date.

   If the rule defines a week where the transition might occur, then the month
   if the month of either the earliest or latest possible date of the cutover.

  returns: the month of the transition, not null - `java.time.Month`"
  ([this]
    (-> this (.getMonth))))

(defn equals
  "Checks if this object equals another.

   The entire state of the object is compared.

  other-rule - the other object to compare to, null returns false - `java.lang.Object`

  returns: true if equal - `boolean`"
  ([this other-rule]
    (-> this (.equals other-rule))))

