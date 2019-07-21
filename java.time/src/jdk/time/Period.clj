(ns jdk.time.Period
  "A date-based amount of time in the ISO-8601 calendar system,
  such as '2 years, 3 months and 4 days'.

  This class models a quantity or amount of time in terms of years, months and days.
  See Duration for the time-based equivalent to this class.

  Durations and periods differ in their treatment of daylight savings time
  when added to ZonedDateTime. A Duration will add an exact
  number of seconds, thus a duration of one day is always exactly 24 hours.
  By contrast, a Period will add a conceptual day, trying to maintain
  the local time.

  For example, consider adding a period of one day and a duration of one day to
  18:00 on the evening before a daylight savings gap. The Period will add
  the conceptual day and result in a ZonedDateTime at 18:00 the following day.
  By contrast, the Duration will add exactly 24 hours, resulting in a
  ZonedDateTime at 19:00 the following day (assuming a one hour DST gap).

  The supported units of a period are YEARS,
  MONTHS and DAYS.
  All three fields are always present, but may be set to zero.

  The ISO-8601 calendar system is the modern civil calendar system used today
  in most of the world. It is equivalent to the proleptic Gregorian calendar
  system, in which today's rules for leap years are applied for all time.

  The period is modeled as a directed amount of time, meaning that individual parts of the
  period may be negative.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  Period may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time Period]))

(def *-zero
  "Static Constant.

  A constant for a period of zero.

  type: java.time.Period"
  Period/ZERO)

(defn *of-years
  "Obtains a Period representing a number of years.

   The resulting period will have the specified years.
   The months and days units will be zero.

  years - the number of years, positive or negative - `int`

  returns: the period of years, not null - `java.time.Period`"
  (^java.time.Period [^Integer years]
    (Period/ofYears years)))

(defn *of-months
  "Obtains a Period representing a number of months.

   The resulting period will have the specified months.
   The years and days units will be zero.

  months - the number of months, positive or negative - `int`

  returns: the period of months, not null - `java.time.Period`"
  (^java.time.Period [^Integer months]
    (Period/ofMonths months)))

(defn *of-weeks
  "Obtains a Period representing a number of weeks.

   The resulting period will be day-based, with the amount of days
   equal to the number of weeks multiplied by 7.
   The years and months units will be zero.

  weeks - the number of weeks, positive or negative - `int`

  returns: the period, with the input weeks converted to days, not null - `java.time.Period`"
  (^java.time.Period [^Integer weeks]
    (Period/ofWeeks weeks)))

(defn *of-days
  "Obtains a Period representing a number of days.

   The resulting period will have the specified days.
   The years and months units will be zero.

  days - the number of days, positive or negative - `int`

  returns: the period of days, not null - `java.time.Period`"
  (^java.time.Period [^Integer days]
    (Period/ofDays days)))

(defn *of
  "Obtains a Period representing a number of years, months and days.

   This creates an instance based on years, months and days.

  years - the amount of years, may be negative - `int`
  months - the amount of months, may be negative - `int`
  days - the amount of days, may be negative - `int`

  returns: the period of years, months and days, not null - `java.time.Period`"
  (^java.time.Period [^Integer years ^Integer months ^Integer days]
    (Period/of years months days)))

(defn *from
  "Obtains an instance of Period from a temporal amount.

   This obtains a period based on the specified amount.
   A TemporalAmount represents an  amount of time, which may be
   date-based or time-based, which this factory extracts to a Period.

   The conversion loops around the set of units from the amount and uses
   the YEARS, MONTHS
   and DAYS units to create a period.
   If any other units are found then an exception is thrown.

   If the amount is a ChronoPeriod then it must use the ISO chronology.

  amount - the temporal amount to convert, not null - `java.time.temporal.TemporalAmount`

  returns: the equivalent period, not null - `java.time.Period`

  throws: java.time.DateTimeException - if unable to convert to a Period"
  (^java.time.Period [^java.time.temporal.TemporalAmount amount]
    (Period/from amount)))

(defn *parse
  "Obtains a Period from a text string such as PnYnMnD.

   This will parse the string produced by toString() which is
   based on the ISO-8601 period formats PnYnMnD and PnW.

   The string starts with an optional sign, denoted by the ASCII negative
   or positive symbol. If negative, the whole period is negated.
   The ASCII letter \"P\" is next in upper or lower case.
   There are then four sections, each consisting of a number and a suffix.
   At least one of the four sections must be present.
   The sections have suffixes in ASCII of \"Y\", \"M\", \"W\" and \"D\" for
   years, months, weeks and days, accepted in upper or lower case.
   The suffixes must occur in order.
   The number part of each section must consist of ASCII digits.
   The number may be prefixed by the ASCII negative or positive symbol.
   The number must parse to an int.

   The leading plus/minus sign, and negative values for other units are
   not part of the ISO-8601 standard. In addition, ISO-8601 does not
   permit mixing between the PnYnMnD and PnW formats.
   Any week-based input is multiplied by 7 and treated as a number of days.

   For example, the following are valid inputs:


     \"P2Y\"             -- Period.ofYears(2)
     \"P3M\"             -- Period.ofMonths(3)
     \"P4W\"             -- Period.ofWeeks(4)
     \"P5D\"             -- Period.ofDays(5)
     \"P1Y2M3D\"         -- Period.of(1, 2, 3)
     \"P1Y2M3W4D\"       -- Period.of(1, 2, 25)
     \"P-1Y2M\"          -- Period.of(-1, 2, 0)
     \"-P1Y2M\"          -- Period.of(-1, -2, 0)

  text - the text to parse, not null - `java.lang.CharSequence`

  returns: the parsed period, not null - `java.time.Period`

  throws: java.time.format.DateTimeParseException - if the text cannot be parsed to a period"
  (^java.time.Period [^java.lang.CharSequence text]
    (Period/parse text)))

(defn *between
  "Obtains a Period consisting of the number of years, months,
   and days between two dates.

   The start date is included, but the end date is not.
   The period is calculated by removing complete months, then calculating
   the remaining number of days, adjusting to ensure that both have the same sign.
   The number of months is then split into years and months based on a 12 month year.
   A month is considered if the end day-of-month is greater than or equal to the start day-of-month.
   For example, from 2010-01-15 to 2011-03-18 is one year, two months and three days.

   The result of this method can be a negative period if the end is before the start.
   The negative sign will be the same in each of year, month and day.

  start-date-inclusive - the start date, inclusive, not null - `java.time.LocalDate`
  end-date-exclusive - the end date, exclusive, not null - `java.time.LocalDate`

  returns: the period between this date and the end date, not null - `java.time.Period`"
  (^java.time.Period [^java.time.LocalDate start-date-inclusive ^java.time.LocalDate end-date-exclusive]
    (Period/between start-date-inclusive end-date-exclusive)))

(defn get-months
  "Gets the amount of months of this period.

   This returns the months unit.

   The months unit is not automatically normalized with the years unit.
   This means that a period of \"15 months\" is different to a period
   of \"1 year and 3 months\".

  returns: the amount of months of this period, may be negative - `int`"
  (^Integer [^Period this]
    (-> this (.getMonths))))

(defn negative?
  "Checks if any of the three units of this period are negative.

   This checks whether the years, months or days units are less than zero.

  returns: true if any unit of this period is negative - `boolean`"
  (^Boolean [^Period this]
    (-> this (.isNegative))))

(defn zero?
  "Checks if all three units of this period are zero.

   A zero period has the value zero for the years, months and days units.

  returns: true if this period is zero-length - `boolean`"
  (^Boolean [^Period this]
    (-> this (.isZero))))

(defn multiplied-by
  "Returns a new instance with each element in this period multiplied
   by the specified scalar.

   This returns a period with each of the years, months and days units
   individually multiplied.
   For example, a period of \"2 years, -3 months and 4 days\" multiplied by
   3 will return \"6 years, -9 months and 12 days\".
   No normalization is performed.

  scalar - the scalar to multiply by, not null - `int`

  returns: a Period based on this period with the amounts multiplied by the scalar, not null - `java.time.Period`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Period [^Period this ^Integer scalar]
    (-> this (.multipliedBy scalar))))

(defn get-units
  "Gets the set of units supported by this period.

   The supported units are YEARS,
   MONTHS and DAYS.
   They are returned in the order years, months, days.

   This set can be used in conjunction with get(TemporalUnit)
   to access the entire state of the period.

  returns: a list containing the years, months and days units, not null - `java.util.List<java.time.temporal.TemporalUnit>`"
  (^java.util.List [^Period this]
    (-> this (.getUnits))))

(defn with-days
  "Returns a copy of this period with the specified amount of days.

   This sets the amount of the days unit in a copy of this period.
   The years and months units are unaffected.

   This instance is immutable and unaffected by this method call.

  days - the days to represent, may be negative - `int`

  returns: a Period based on this period with the requested days, not null - `java.time.Period`"
  (^java.time.Period [^Period this ^Integer days]
    (-> this (.withDays days))))

(defn plus
  "Returns a copy of this period with the specified period added.

   This operates separately on the years, months and days.
   No normalization is performed.

   For example, \"1 year, 6 months and 3 days\" plus \"2 years, 2 months and 2 days\"
   returns \"3 years, 8 months and 5 days\".

   The specified amount is typically an instance of Period.
   Other types are interpreted using from(TemporalAmount).

   This instance is immutable and unaffected by this method call.

  amount-to-add - the amount to add, not null - `java.time.temporal.TemporalAmount`

  returns: a Period based on this period with the requested period added, not null - `java.time.Period`

  throws: java.time.DateTimeException - if the specified amount has a non-ISO chronology or contains an invalid unit"
  (^java.time.Period [^Period this ^java.time.temporal.TemporalAmount amount-to-add]
    (-> this (.plus amount-to-add))))

(defn to-string
  "Outputs this period as a String, such as P6Y3M1D.

   The output will be in the ISO-8601 period format.
   A zero period will be represented as zero days, 'P0D'.

  returns: a string representation of this period, not null - `java.lang.String`"
  (^java.lang.String [^Period this]
    (-> this (.toString))))

(defn plus-months
  "Returns a copy of this period with the specified months added.

   This adds the amount to the months unit in a copy of this period.
   The years and days units are unaffected.
   For example, \"1 year, 6 months and 3 days\" plus 2 months returns \"1 year, 8 months and 3 days\".

   This instance is immutable and unaffected by this method call.

  months-to-add - the months to add, positive or negative - `long`

  returns: a Period based on this period with the specified months added, not null - `java.time.Period`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Period [^Period this ^Long months-to-add]
    (-> this (.plusMonths months-to-add))))

(defn minus-months
  "Returns a copy of this period with the specified months subtracted.

   This subtracts the amount from the months unit in a copy of this period.
   The years and days units are unaffected.
   For example, \"1 year, 6 months and 3 days\" minus 2 months returns \"1 year, 4 months and 3 days\".

   This instance is immutable and unaffected by this method call.

  months-to-subtract - the years to subtract, positive or negative - `long`

  returns: a Period based on this period with the specified months subtracted, not null - `java.time.Period`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Period [^Period this ^Long months-to-subtract]
    (-> this (.minusMonths months-to-subtract))))

(defn minus
  "Returns a copy of this period with the specified period subtracted.

   This operates separately on the years, months and days.
   No normalization is performed.

   For example, \"1 year, 6 months and 3 days\" minus \"2 years, 2 months and 2 days\"
   returns \"-1 years, 4 months and 1 day\".

   The specified amount is typically an instance of Period.
   Other types are interpreted using from(TemporalAmount).

   This instance is immutable and unaffected by this method call.

  amount-to-subtract - the amount to subtract, not null - `java.time.temporal.TemporalAmount`

  returns: a Period based on this period with the requested period subtracted, not null - `java.time.Period`

  throws: java.time.DateTimeException - if the specified amount has a non-ISO chronology or contains an invalid unit"
  (^java.time.Period [^Period this ^java.time.temporal.TemporalAmount amount-to-subtract]
    (-> this (.minus amount-to-subtract))))

(defn add-to
  "Adds this period to the specified temporal object.

   This returns a temporal object of the same observable type as the input
   with this period added.
   If the temporal has a chronology, it must be the ISO chronology.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.plus(TemporalAmount).


     // these two lines are equivalent, but the second approach is recommended
     dateTime = thisPeriod.addTo(dateTime);
     dateTime = dateTime.plus(thisPeriod);

   The calculation operates as follows.
   First, the chronology of the temporal is checked to ensure it is ISO chronology or null.
   Second, if the months are zero, the years are added if non-zero, otherwise
   the combination of years and months is added if non-zero.
   Finally, any days are added.

   This approach ensures that a partial period can be added to a partial date.
   For example, a period of years and/or months can be added to a YearMonth,
   but a period including days cannot.
   The approach also adds years and months together when necessary, which ensures
   correct behaviour at the end of the month.

   This instance is immutable and unaffected by this method call.

  temporal - the temporal object to adjust, not null - `java.time.temporal.Temporal`

  returns: an object of the same type with the adjustment made, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to add"
  (^java.time.temporal.Temporal [^Period this ^java.time.temporal.Temporal temporal]
    (-> this (.addTo temporal))))

(defn to-total-months
  "Gets the total number of months in this period.

   This returns the total number of months in the period by multiplying the
   number of years by 12 and adding the number of months.

   This instance is immutable and unaffected by this method call.

  returns: the total number of months in the period, may be negative - `long`"
  (^Long [^Period this]
    (-> this (.toTotalMonths))))

(defn plus-days
  "Returns a copy of this period with the specified days added.

   This adds the amount to the days unit in a copy of this period.
   The years and months units are unaffected.
   For example, \"1 year, 6 months and 3 days\" plus 2 days returns \"1 year, 6 months and 5 days\".

   This instance is immutable and unaffected by this method call.

  days-to-add - the days to add, positive or negative - `long`

  returns: a Period based on this period with the specified days added, not null - `java.time.Period`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Period [^Period this ^Long days-to-add]
    (-> this (.plusDays days-to-add))))

(defn get-days
  "Gets the amount of days of this period.

   This returns the days unit.

  returns: the amount of days of this period, may be negative - `int`"
  (^Integer [^Period this]
    (-> this (.getDays))))

(defn negated
  "Returns a new instance with each amount in this period negated.

   This returns a period with each of the years, months and days units
   individually negated.
   For example, a period of \"2 years, -3 months and 4 days\" will be
   negated to \"-2 years, 3 months and -4 days\".
   No normalization is performed.

  returns: a Period based on this period with the amounts negated, not null - `java.time.Period`

  throws: java.lang.ArithmeticException - if numeric overflow occurs, which only happens if one of the units has the value Long.MIN_VALUE"
  (^java.time.Period [^Period this]
    (-> this (.negated))))

(defn get-years
  "Gets the amount of years of this period.

   This returns the years unit.

   The months unit is not automatically normalized with the years unit.
   This means that a period of \"15 months\" is different to a period
   of \"1 year and 3 months\".

  returns: the amount of years of this period, may be negative - `int`"
  (^Integer [^Period this]
    (-> this (.getYears))))

(defn with-years
  "Returns a copy of this period with the specified amount of years.

   This sets the amount of the years unit in a copy of this period.
   The months and days units are unaffected.

   The months unit is not automatically normalized with the years unit.
   This means that a period of \"15 months\" is different to a period
   of \"1 year and 3 months\".

   This instance is immutable and unaffected by this method call.

  years - the years to represent, may be negative - `int`

  returns: a Period based on this period with the requested years, not null - `java.time.Period`"
  (^java.time.Period [^Period this ^Integer years]
    (-> this (.withYears years))))

(defn normalized
  "Returns a copy of this period with the years and months normalized.

   This normalizes the years and months units, leaving the days unit unchanged.
   The months unit is adjusted to have an absolute value less than 11,
   with the years unit being adjusted to compensate. For example, a period of
   \"1 Year and 15 months\" will be normalized to \"2 years and 3 months\".

   The sign of the years and months units will be the same after normalization.
   For example, a period of \"1 year and -25 months\" will be normalized to
   \"-1 year and -1 month\".

   This instance is immutable and unaffected by this method call.

  returns: a Period based on this period with excess months normalized to years, not null - `java.time.Period`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Period [^Period this]
    (-> this (.normalized))))

(defn with-months
  "Returns a copy of this period with the specified amount of months.

   This sets the amount of the months unit in a copy of this period.
   The years and days units are unaffected.

   The months unit is not automatically normalized with the years unit.
   This means that a period of \"15 months\" is different to a period
   of \"1 year and 3 months\".

   This instance is immutable and unaffected by this method call.

  months - the months to represent, may be negative - `int`

  returns: a Period based on this period with the requested months, not null - `java.time.Period`"
  (^java.time.Period [^Period this ^Integer months]
    (-> this (.withMonths months))))

(defn minus-years
  "Returns a copy of this period with the specified years subtracted.

   This subtracts the amount from the years unit in a copy of this period.
   The months and days units are unaffected.
   For example, \"1 year, 6 months and 3 days\" minus 2 years returns \"-1 years, 6 months and 3 days\".

   This instance is immutable and unaffected by this method call.

  years-to-subtract - the years to subtract, positive or negative - `long`

  returns: a Period based on this period with the specified years subtracted, not null - `java.time.Period`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Period [^Period this ^Long years-to-subtract]
    (-> this (.minusYears years-to-subtract))))

(defn get-chronology
  "Gets the chronology of this period, which is the ISO calendar system.

   The Chronology represents the calendar system in use.
   The ISO-8601 calendar system is the modern civil calendar system used today
   in most of the world. It is equivalent to the proleptic Gregorian calendar
   system, in which today's rules for leap years are applied for all time.

  returns: the ISO chronology, not null - `java.time.chrono.IsoChronology`"
  (^java.time.chrono.IsoChronology [^Period this]
    (-> this (.getChronology))))

(defn hash-code
  "A hash code for this period.

  returns: a suitable hash code - `int`"
  (^Integer [^Period this]
    (-> this (.hashCode))))

(defn subtract-from
  "Subtracts this period from the specified temporal object.

   This returns a temporal object of the same observable type as the input
   with this period subtracted.
   If the temporal has a chronology, it must be the ISO chronology.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.minus(TemporalAmount).


     // these two lines are equivalent, but the second approach is recommended
     dateTime = thisPeriod.subtractFrom(dateTime);
     dateTime = dateTime.minus(thisPeriod);

   The calculation operates as follows.
   First, the chronology of the temporal is checked to ensure it is ISO chronology or null.
   Second, if the months are zero, the years are subtracted if non-zero, otherwise
   the combination of years and months is subtracted if non-zero.
   Finally, any days are subtracted.

   This approach ensures that a partial period can be subtracted from a partial date.
   For example, a period of years and/or months can be subtracted from a YearMonth,
   but a period including days cannot.
   The approach also subtracts years and months together when necessary, which ensures
   correct behaviour at the end of the month.

   This instance is immutable and unaffected by this method call.

  temporal - the temporal object to adjust, not null - `java.time.temporal.Temporal`

  returns: an object of the same type with the adjustment made, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to subtract"
  (^java.time.temporal.Temporal [^Period this ^java.time.temporal.Temporal temporal]
    (-> this (.subtractFrom temporal))))

(defn get
  "Gets the value of the requested unit.

   This returns a value for each of the three supported units,
   YEARS, MONTHS and
   DAYS.
   All other units throw an exception.

  unit - the TemporalUnit for which to return the value - `java.time.temporal.TemporalUnit`

  returns: the long value of the unit - `long`

  throws: java.time.DateTimeException - if the unit is not supported"
  (^Long [^Period this ^java.time.temporal.TemporalUnit unit]
    (-> this (.get unit))))

(defn equals
  "Checks if this period is equal to another period.

   The comparison is based on the type Period and each of the three amounts.
   To be equal, the years, months and days units must be individually equal.
   Note that this means that a period of \"15 Months\" is not equal to a period
   of \"1 Year and 3 Months\".

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other period - `boolean`"
  (^Boolean [^Period this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn plus-years
  "Returns a copy of this period with the specified years added.

   This adds the amount to the years unit in a copy of this period.
   The months and days units are unaffected.
   For example, \"1 year, 6 months and 3 days\" plus 2 years returns \"3 years, 6 months and 3 days\".

   This instance is immutable and unaffected by this method call.

  years-to-add - the years to add, positive or negative - `long`

  returns: a Period based on this period with the specified years added, not null - `java.time.Period`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Period [^Period this ^Long years-to-add]
    (-> this (.plusYears years-to-add))))

(defn minus-days
  "Returns a copy of this period with the specified days subtracted.

   This subtracts the amount from the days unit in a copy of this period.
   The years and months units are unaffected.
   For example, \"1 year, 6 months and 3 days\" minus 2 days returns \"1 year, 6 months and 1 day\".

   This instance is immutable and unaffected by this method call.

  days-to-subtract - the months to subtract, positive or negative - `long`

  returns: a Period based on this period with the specified days subtracted, not null - `java.time.Period`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Period [^Period this ^Long days-to-subtract]
    (-> this (.minusDays days-to-subtract))))

