(ns jdk.util.concurrent.TimeUnit
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent TimeUnit]))

(def NANOSECONDS
  "Enum Constant.

  Time unit representing one thousandth of a microsecond

  type: java.util.concurrent.TimeUnit"
  TimeUnit/NANOSECONDS)

(def MICROSECONDS
  "Enum Constant.

  Time unit representing one thousandth of a millisecond

  type: java.util.concurrent.TimeUnit"
  TimeUnit/MICROSECONDS)

(def MILLISECONDS
  "Enum Constant.

  Time unit representing one thousandth of a second

  type: java.util.concurrent.TimeUnit"
  TimeUnit/MILLISECONDS)

(def SECONDS
  "Enum Constant.

  Time unit representing one second

  type: java.util.concurrent.TimeUnit"
  TimeUnit/SECONDS)

(def MINUTES
  "Enum Constant.

  Time unit representing sixty seconds

  type: java.util.concurrent.TimeUnit"
  TimeUnit/MINUTES)

(def HOURS
  "Enum Constant.

  Time unit representing sixty minutes

  type: java.util.concurrent.TimeUnit"
  TimeUnit/HOURS)

(def DAYS
  "Enum Constant.

  Time unit representing twenty four hours

  type: java.util.concurrent.TimeUnit"
  TimeUnit/DAYS)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (TimeUnit c : TimeUnit.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.util.concurrent.TimeUnit[]`"
  ([]
    (TimeUnit/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.util.concurrent.TimeUnit`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.util.concurrent.TimeUnit [^java.lang.String name]
    (TimeUnit/valueOf name)))

(defn to-micros
  "Equivalent to
   MICROSECONDS.convert(duration, this).

  duration - the duration - `long`

  returns: the converted duration,
   or Long.MIN_VALUE if conversion would negatively
   overflow, or Long.MAX_VALUE if it would positively overflow. - `long`"
  (^Long [^java.util.concurrent.TimeUnit this ^Long duration]
    (-> this (.toMicros duration))))

(defn to-nanos
  "Equivalent to
   NANOSECONDS.convert(duration, this).

  duration - the duration - `long`

  returns: the converted duration,
   or Long.MIN_VALUE if conversion would negatively
   overflow, or Long.MAX_VALUE if it would positively overflow. - `long`"
  (^Long [^java.util.concurrent.TimeUnit this ^Long duration]
    (-> this (.toNanos duration))))

(defn to-minutes
  "Equivalent to
   MINUTES.convert(duration, this).

  duration - the duration - `long`

  returns: the converted duration,
   or Long.MIN_VALUE if conversion would negatively
   overflow, or Long.MAX_VALUE if it would positively overflow. - `long`"
  (^Long [^java.util.concurrent.TimeUnit this ^Long duration]
    (-> this (.toMinutes duration))))

(defn convert
  "Converts the given time duration in the given unit to this unit.
   Conversions from finer to coarser granularities truncate, so
   lose precision. For example, converting 999 milliseconds
   to seconds results in 0. Conversions from coarser to
   finer granularities with arguments that would numerically
   overflow saturate to Long.MIN_VALUE if negative or
   Long.MAX_VALUE if positive.

   For example, to convert 10 minutes to milliseconds, use:
   TimeUnit.MILLISECONDS.convert(10L, TimeUnit.MINUTES)

  source-duration - the time duration in the given sourceUnit - `long`
  source-unit - the unit of the sourceDuration argument - `java.util.concurrent.TimeUnit`

  returns: the converted duration in this unit,
   or Long.MIN_VALUE if conversion would negatively
   overflow, or Long.MAX_VALUE if it would positively overflow. - `long`"
  (^Long [^java.util.concurrent.TimeUnit this ^Long source-duration ^java.util.concurrent.TimeUnit source-unit]
    (-> this (.convert source-duration source-unit))))

(defn timed-join
  "Performs a timed Thread.join
   using this time unit.
   This is a convenience method that converts time arguments into the
   form required by the Thread.join method.

  thread - the thread to wait for - `java.lang.Thread`
  timeout - the maximum time to wait. If less than or equal to zero, do not wait at all. - `long`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.TimeUnit this ^java.lang.Thread thread ^Long timeout]
    (-> this (.timedJoin thread timeout))))

(defn sleep
  "Performs a Thread.sleep using
   this time unit.
   This is a convenience method that converts time arguments into the
   form required by the Thread.sleep method.

  timeout - the minimum time to sleep. If less than or equal to zero, do not sleep at all. - `long`

  throws: java.lang.InterruptedException - if interrupted while sleeping"
  ([^java.util.concurrent.TimeUnit this ^Long timeout]
    (-> this (.sleep timeout))))

(defn to-millis
  "Equivalent to
   MILLISECONDS.convert(duration, this).

  duration - the duration - `long`

  returns: the converted duration,
   or Long.MIN_VALUE if conversion would negatively
   overflow, or Long.MAX_VALUE if it would positively overflow. - `long`"
  (^Long [^java.util.concurrent.TimeUnit this ^Long duration]
    (-> this (.toMillis duration))))

(defn to-hours
  "Equivalent to
   HOURS.convert(duration, this).

  duration - the duration - `long`

  returns: the converted duration,
   or Long.MIN_VALUE if conversion would negatively
   overflow, or Long.MAX_VALUE if it would positively overflow. - `long`"
  (^Long [^java.util.concurrent.TimeUnit this ^Long duration]
    (-> this (.toHours duration))))

(defn timed-wait
  "Performs a timed Object.wait
   using this time unit.
   This is a convenience method that converts timeout arguments
   into the form required by the Object.wait method.

   For example, you could implement a blocking poll
   method (see BlockingQueue.poll)
   using:



   public synchronized Object poll(long timeout, TimeUnit unit)
       throws InterruptedException {
     while (empty) {
       unit.timedWait(this, timeout);
       ...
     }
   }

  obj - the object to wait on - `java.lang.Object`
  timeout - the maximum time to wait. If less than or equal to zero, do not wait at all. - `long`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.TimeUnit this ^java.lang.Object obj ^Long timeout]
    (-> this (.timedWait obj timeout))))

(defn to-seconds
  "Equivalent to
   SECONDS.convert(duration, this).

  duration - the duration - `long`

  returns: the converted duration,
   or Long.MIN_VALUE if conversion would negatively
   overflow, or Long.MAX_VALUE if it would positively overflow. - `long`"
  (^Long [^java.util.concurrent.TimeUnit this ^Long duration]
    (-> this (.toSeconds duration))))

(defn to-days
  "Equivalent to
   DAYS.convert(duration, this).

  duration - the duration - `long`

  returns: the converted duration - `long`"
  (^Long [^java.util.concurrent.TimeUnit this ^Long duration]
    (-> this (.toDays duration))))

