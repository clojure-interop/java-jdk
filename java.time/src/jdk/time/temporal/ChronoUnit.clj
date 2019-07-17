(ns jdk.time.temporal.ChronoUnit
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.temporal ChronoUnit]))

(def NANOS
  "Enum Constant.

  Unit that represents the concept of a nanosecond, the smallest supported unit of time.
   For the ISO calendar system, it is equal to the 1,000,000,000th part of the second unit.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/NANOS)

(def MICROS
  "Enum Constant.

  Unit that represents the concept of a microsecond.
   For the ISO calendar system, it is equal to the 1,000,000th part of the second unit.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/MICROS)

(def MILLIS
  "Enum Constant.

  Unit that represents the concept of a millisecond.
   For the ISO calendar system, it is equal to the 1000th part of the second unit.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/MILLIS)

(def SECONDS
  "Enum Constant.

  Unit that represents the concept of a second.
   For the ISO calendar system, it is equal to the second in the SI system
   of units, except around a leap-second.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/SECONDS)

(def MINUTES
  "Enum Constant.

  Unit that represents the concept of a minute.
   For the ISO calendar system, it is equal to 60 seconds.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/MINUTES)

(def HOURS
  "Enum Constant.

  Unit that represents the concept of an hour.
   For the ISO calendar system, it is equal to 60 minutes.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/HOURS)

(def HALF_DAYS
  "Enum Constant.

  Unit that represents the concept of half a day, as used in AM/PM.
   For the ISO calendar system, it is equal to 12 hours.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/HALF_DAYS)

(def DAYS
  "Enum Constant.

  Unit that represents the concept of a day.
   For the ISO calendar system, it is the standard day from midnight to midnight.
   The estimated duration of a day is 24 Hours.

   When used with other calendar systems it must correspond to the day defined by
   the rising and setting of the Sun on Earth. It is not required that days begin
   at midnight - when converting between calendar systems, the date should be
   equivalent at midday.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/DAYS)

(def WEEKS
  "Enum Constant.

  Unit that represents the concept of a week.
   For the ISO calendar system, it is equal to 7 days.

   When used with other calendar systems it must correspond to an integral number of days.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/WEEKS)

(def MONTHS
  "Enum Constant.

  Unit that represents the concept of a month.
   For the ISO calendar system, the length of the month varies by month-of-year.
   The estimated duration of a month is one twelfth of 365.2425 Days.

   When used with other calendar systems it must correspond to an integral number of days.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/MONTHS)

(def YEARS
  "Enum Constant.

  Unit that represents the concept of a year.
   For the ISO calendar system, it is equal to 12 months.
   The estimated duration of a year is 365.2425 Days.

   When used with other calendar systems it must correspond to an integral number of days
   or months roughly equal to a year defined by the passage of the Earth around the Sun.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/YEARS)

(def DECADES
  "Enum Constant.

  Unit that represents the concept of a decade.
   For the ISO calendar system, it is equal to 10 years.

   When used with other calendar systems it must correspond to an integral number of days
   and is normally an integral number of years.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/DECADES)

(def CENTURIES
  "Enum Constant.

  Unit that represents the concept of a century.
   For the ISO calendar system, it is equal to 100 years.

   When used with other calendar systems it must correspond to an integral number of days
   and is normally an integral number of years.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/CENTURIES)

(def MILLENNIA
  "Enum Constant.

  Unit that represents the concept of a millennium.
   For the ISO calendar system, it is equal to 1000 years.

   When used with other calendar systems it must correspond to an integral number of days
   and is normally an integral number of years.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/MILLENNIA)

(def ERAS
  "Enum Constant.

  Unit that represents the concept of an era.
   The ISO calendar system doesn't have eras thus it is impossible to add
   an era to a date or date-time.
   The estimated duration of the era is artificially defined as 1,000,000,000 Years.

   When used with other calendar systems there are no restrictions on the unit.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/ERAS)

(def FOREVER
  "Enum Constant.

  Artificial unit that represents the concept of forever.
   This is primarily used with TemporalField to represent unbounded fields
   such as the year or era.
   The estimated duration of the era is artificially defined as the largest duration
   supported by Duration.

  type: java.time.temporal.ChronoUnit"
  ChronoUnit/FOREVER)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (ChronoUnit c : ChronoUnit.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.temporal.ChronoUnit[]`"
  ([]
    (ChronoUnit/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.temporal.ChronoUnit`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (ChronoUnit/valueOf name)))

(defn get-duration
  "Gets the estimated duration of this unit in the ISO calendar system.

   All of the units in this class have an estimated duration.
   Days vary due to daylight saving time, while months have different lengths.

  returns: the estimated duration of this unit, not null - `java.time.Duration`"
  ([^java.time.temporal.ChronoUnit this]
    (-> this (.getDuration))))

(defn duration-estimated?
  "Checks if the duration of the unit is an estimate.

   All time units in this class are considered to be accurate, while all date
   units in this class are considered to be estimated.

   This definition ignores leap seconds, but considers that Days vary due to
   daylight saving time and months have different lengths.

  returns: true if the duration is estimated, false if accurate - `boolean`"
  ([^java.time.temporal.ChronoUnit this]
    (-> this (.isDurationEstimated))))

(defn date-based?
  "Checks if this unit is a date unit.

   All units from days to eras inclusive are date-based.
   Time-based units and FOREVER return false.

  returns: true if a date unit, false if a time unit - `boolean`"
  ([^java.time.temporal.ChronoUnit this]
    (-> this (.isDateBased))))

(defn time-based?
  "Checks if this unit is a time unit.

   All units from nanos to half-days inclusive are time-based.
   Date-based units and FOREVER return false.

  returns: true if a time unit, false if a date unit - `boolean`"
  ([^java.time.temporal.ChronoUnit this]
    (-> this (.isTimeBased))))

(defn supported-by?
  "Description copied from interface: TemporalUnit

  temporal - the temporal object to check, not null - `java.time.temporal.Temporal`

  returns: true if the unit is supported - `boolean`"
  ([^java.time.temporal.ChronoUnit this ^java.time.temporal.Temporal temporal]
    (-> this (.isSupportedBy temporal))))

(defn add-to
  "Description copied from interface: TemporalUnit

  temporal - the temporal object to adjust, not null - `R`
  amount - the amount of this unit to add, positive or negative - `long`

  returns: the adjusted temporal object, not null - `<R extends java.time.temporal.Temporal> R`"
  ([^java.time.temporal.ChronoUnit this temporal ^Long amount]
    (-> this (.addTo temporal amount))))

(defn between
  "Description copied from interface: TemporalUnit

  temporal-1-inclusive - the base temporal object, not null - `java.time.temporal.Temporal`
  temporal-2-exclusive - the other temporal object, exclusive, not null - `java.time.temporal.Temporal`

  returns: the amount of time between temporal1Inclusive and temporal2Exclusive
    in terms of this unit; positive if temporal2Exclusive is later than
    temporal1Inclusive, negative if earlier - `long`"
  ([^java.time.temporal.ChronoUnit this ^java.time.temporal.Temporal temporal-1-inclusive ^java.time.temporal.Temporal temporal-2-exclusive]
    (-> this (.between temporal-1-inclusive temporal-2-exclusive))))

(defn to-string
  "Description copied from class: Enum

  returns: the name of this enum constant - `java.lang.String`"
  ([^java.time.temporal.ChronoUnit this]
    (-> this (.toString))))

