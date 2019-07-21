(ns javax.xml.datatype.DatatypeConstants
  "Utility class to contain basic Datatype values as constants."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.datatype DatatypeConstants]))

(def *-january
  "Static Constant.

  Value for first month of year.

  type: int"
  DatatypeConstants/JANUARY)

(def *-february
  "Static Constant.

  Value for second month of year.

  type: int"
  DatatypeConstants/FEBRUARY)

(def *-march
  "Static Constant.

  Value for third month of year.

  type: int"
  DatatypeConstants/MARCH)

(def *-april
  "Static Constant.

  Value for fourth month of year.

  type: int"
  DatatypeConstants/APRIL)

(def *-may
  "Static Constant.

  Value for fifth month of year.

  type: int"
  DatatypeConstants/MAY)

(def *-june
  "Static Constant.

  Value for sixth month of year.

  type: int"
  DatatypeConstants/JUNE)

(def *-july
  "Static Constant.

  Value for seventh month of year.

  type: int"
  DatatypeConstants/JULY)

(def *-august
  "Static Constant.

  Value for eighth month of year.

  type: int"
  DatatypeConstants/AUGUST)

(def *-september
  "Static Constant.

  Value for ninth month of year.

  type: int"
  DatatypeConstants/SEPTEMBER)

(def *-october
  "Static Constant.

  Value for tenth month of year.

  type: int"
  DatatypeConstants/OCTOBER)

(def *-november
  "Static Constant.

  Value for eleven month of year.

  type: int"
  DatatypeConstants/NOVEMBER)

(def *-december
  "Static Constant.

  Value for twelve month of year.

  type: int"
  DatatypeConstants/DECEMBER)

(def *-lesser
  "Static Constant.

  Comparison result.

  type: int"
  DatatypeConstants/LESSER)

(def *-equal
  "Static Constant.

  Comparison result.

  type: int"
  DatatypeConstants/EQUAL)

(def *-greater
  "Static Constant.

  Comparison result.

  type: int"
  DatatypeConstants/GREATER)

(def *-indeterminate
  "Static Constant.

  Comparison result.

  type: int"
  DatatypeConstants/INDETERMINATE)

(def *-field-undefined
  "Static Constant.

  Designation that an \"int\" field is not set.

  type: int"
  DatatypeConstants/FIELD_UNDEFINED)

(def *-years
  "Static Constant.

  A constant that represents the years field.

  type: javax.xml.datatype.DatatypeConstants$Field"
  DatatypeConstants/YEARS)

(def *-months
  "Static Constant.

  A constant that represents the months field.

  type: javax.xml.datatype.DatatypeConstants$Field"
  DatatypeConstants/MONTHS)

(def *-days
  "Static Constant.

  A constant that represents the days field.

  type: javax.xml.datatype.DatatypeConstants$Field"
  DatatypeConstants/DAYS)

(def *-hours
  "Static Constant.

  A constant that represents the hours field.

  type: javax.xml.datatype.DatatypeConstants$Field"
  DatatypeConstants/HOURS)

(def *-minutes
  "Static Constant.

  A constant that represents the minutes field.

  type: javax.xml.datatype.DatatypeConstants$Field"
  DatatypeConstants/MINUTES)

(def *-seconds
  "Static Constant.

  A constant that represents the seconds field.

  type: javax.xml.datatype.DatatypeConstants$Field"
  DatatypeConstants/SECONDS)

(def *-datetime
  "Static Constant.

  Fully qualified name for W3C XML Schema 1.0 datatype dateTime.

  type: javax.xml.namespace.QName"
  DatatypeConstants/DATETIME)

(def *-time
  "Static Constant.

  Fully qualified name for W3C XML Schema 1.0 datatype time.

  type: javax.xml.namespace.QName"
  DatatypeConstants/TIME)

(def *-date
  "Static Constant.

  Fully qualified name for W3C XML Schema 1.0 datatype date.

  type: javax.xml.namespace.QName"
  DatatypeConstants/DATE)

(def *-gyearmonth
  "Static Constant.

  Fully qualified name for W3C XML Schema 1.0 datatype gYearMonth.

  type: javax.xml.namespace.QName"
  DatatypeConstants/GYEARMONTH)

(def *-gmonthday
  "Static Constant.

  Fully qualified name for W3C XML Schema 1.0 datatype gMonthDay.

  type: javax.xml.namespace.QName"
  DatatypeConstants/GMONTHDAY)

(def *-gyear
  "Static Constant.

  Fully qualified name for W3C XML Schema 1.0 datatype gYear.

  type: javax.xml.namespace.QName"
  DatatypeConstants/GYEAR)

(def *-gmonth
  "Static Constant.

  Fully qualified name for W3C XML Schema 1.0 datatype gMonth.

  type: javax.xml.namespace.QName"
  DatatypeConstants/GMONTH)

(def *-gday
  "Static Constant.

  Fully qualified name for W3C XML Schema 1.0 datatype gDay.

  type: javax.xml.namespace.QName"
  DatatypeConstants/GDAY)

(def *-duration
  "Static Constant.

  Fully qualified name for W3C XML Schema datatype duration.

  type: javax.xml.namespace.QName"
  DatatypeConstants/DURATION)

(def *-duration-daytime
  "Static Constant.

  Fully qualified name for XQuery 1.0 and XPath 2.0 datatype dayTimeDuration.

  type: javax.xml.namespace.QName"
  DatatypeConstants/DURATION_DAYTIME)

(def *-duration-yearmonth
  "Static Constant.

  Fully qualified name for XQuery 1.0 and XPath 2.0 datatype yearMonthDuration.

  type: javax.xml.namespace.QName"
  DatatypeConstants/DURATION_YEARMONTH)

(def *-max-timezone-offset
  "Static Constant.

  W3C XML Schema max timezone offset is -14:00. Zone offset is in minutes.

  type: int"
  DatatypeConstants/MAX_TIMEZONE_OFFSET)

(def *-min-timezone-offset
  "Static Constant.

  W3C XML Schema min timezone offset is 14:00. Zone offset is in minutes.

  type: int"
  DatatypeConstants/MIN_TIMEZONE_OFFSET)

