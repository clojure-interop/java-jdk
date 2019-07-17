(ns jdk.time.temporal.TemporalAdjuster
  "Strategy for adjusting a temporal object.

  Adjusters are a key tool for modifying temporal objects.
  They exist to externalize the process of adjustment, permitting different
  approaches, as per the strategy design pattern.
  Examples might be an adjuster that sets the date avoiding weekends, or one that
  sets the date to the last day of the month.

  There are two equivalent ways of using a TemporalAdjuster.
  The first is to invoke the method on this interface directly.
  The second is to use Temporal.with(TemporalAdjuster):


    // these two lines are equivalent, but the second approach is recommended
    temporal = thisAdjuster.adjustInto(temporal);
    temporal = temporal.with(thisAdjuster);
  It is recommended to use the second approach, with(TemporalAdjuster),
  as it is a lot clearer to read in code.

  The TemporalAdjusters class contains a standard set of adjusters,
  available as static methods.
  These include:

  finding the first or last day of the month
  finding the first day of next month
  finding the first or last day of the year
  finding the first day of next year
  finding the first or last day-of-week within a month, such as `first Wednesday in June`
  finding the next or previous day-of-week, such as `next Thursday`"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.temporal TemporalAdjuster]))

(defn adjust-into
  "Adjusts the specified temporal object.

   This adjusts the specified temporal object using the logic
   encapsulated in the implementing class.
   Examples might be an adjuster that sets the date avoiding weekends, or one that
   sets the date to the last day of the month.

   There are two equivalent ways of using this method.
   The first is to invoke this method directly.
   The second is to use Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisAdjuster.adjustInto(temporal);
     temporal = temporal.with(thisAdjuster);
   It is recommended to use the second approach, with(TemporalAdjuster),
   as it is a lot clearer to read in code.

  temporal - the temporal object to adjust, not null - `java.time.temporal.Temporal`

  returns: an object of the same observable type with the adjustment made, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  ([^java.time.temporal.TemporalAdjuster this ^java.time.temporal.Temporal temporal]
    (-> this (.adjustInto temporal))))

