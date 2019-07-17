(ns jdk.text.DateFormat$Field
  "Defines constants that are used as attribute keys in the
  AttributedCharacterIterator returned
  from DateFormat.formatToCharacterIterator and as
  field identifiers in FieldPosition.

  The class also provides two methods to map
  between its constants and the corresponding Calendar constants."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text DateFormat$Field]))

(def *-era
  "Static Constant.

  Constant identifying the era field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/ERA)

(def *-year
  "Static Constant.

  Constant identifying the year field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/YEAR)

(def *-month
  "Static Constant.

  Constant identifying the month field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/MONTH)

(def *-day-of-month
  "Static Constant.

  Constant identifying the day of month field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/DAY_OF_MONTH)

(def *-hour-of-day-1
  "Static Constant.

  Constant identifying the hour of day field, where the legal values
   are 1 to 24.

  type: java.text.DateFormat.Field"
  DateFormat$Field/HOUR_OF_DAY1)

(def *-hour-of-day-0
  "Static Constant.

  Constant identifying the hour of day field, where the legal values
   are 0 to 23.

  type: java.text.DateFormat.Field"
  DateFormat$Field/HOUR_OF_DAY0)

(def *-minute
  "Static Constant.

  Constant identifying the minute field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/MINUTE)

(def *-second
  "Static Constant.

  Constant identifying the second field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/SECOND)

(def *-millisecond
  "Static Constant.

  Constant identifying the millisecond field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/MILLISECOND)

(def *-day-of-week
  "Static Constant.

  Constant identifying the day of week field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/DAY_OF_WEEK)

(def *-day-of-year
  "Static Constant.

  Constant identifying the day of year field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/DAY_OF_YEAR)

(def *-day-of-week-in-month
  "Static Constant.

  Constant identifying the day of week field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/DAY_OF_WEEK_IN_MONTH)

(def *-week-of-year
  "Static Constant.

  Constant identifying the week of year field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/WEEK_OF_YEAR)

(def *-week-of-month
  "Static Constant.

  Constant identifying the week of month field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/WEEK_OF_MONTH)

(def *-am-pm
  "Static Constant.

  Constant identifying the time of day indicator
   (e.g. `a.m.` or `p.m.`) field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/AM_PM)

(def *-hour-1
  "Static Constant.

  Constant identifying the hour field, where the legal values are
   1 to 12.

  type: java.text.DateFormat.Field"
  DateFormat$Field/HOUR1)

(def *-hour-0
  "Static Constant.

  Constant identifying the hour field, where the legal values are
   0 to 11.

  type: java.text.DateFormat.Field"
  DateFormat$Field/HOUR0)

(def *-time-zone
  "Static Constant.

  Constant identifying the time zone field.

  type: java.text.DateFormat.Field"
  DateFormat$Field/TIME_ZONE)

(defn *of-calendar-field
  "Returns the Field constant that corresponds to
   the Calendar constant calendarField.
   If there is no direct mapping between the Calendar
   constant and a Field, null is returned.

  calendar-field - Calendar field constant - `int`

  returns: Field instance representing calendarField. - `java.text.DateFormat.Field`

  throws: java.lang.IllegalArgumentException - if calendarField is not the value of a Calendar field constant."
  ([calendar-field]
    (DateFormat$Field/ofCalendarField calendar-field)))

(defn get-calendar-field
  "Returns the Calendar field associated with this
   attribute. For example, if this represents the hours field of
   a Calendar, this would return
   Calendar.HOUR. If there is no corresponding
   Calendar constant, this will return -1.

  returns: Calendar constant for this field - `int`"
  ([this]
    (-> this (.getCalendarField))))

