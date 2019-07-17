(ns jdk.time.zone.ZoneOffsetTransition
  "A transition between two offsets caused by a discontinuity in the local time-line.

  A transition between two offsets is normally the result of a daylight savings cutover.
  The discontinuity is normally a gap in spring and an overlap in autumn.
  ZoneOffsetTransition models the transition between the two offsets.

  Gaps occur where there are local date-times that simply do not exist.
  An example would be when the offset changes from +03:00 to +04:00.
  This might be described as 'the clocks will move forward one hour tonight at 1am'.

  Overlaps occur where there are local date-times that exist twice.
  An example would be when the offset changes from +04:00 to +03:00.
  This might be described as 'the clocks will move back one hour tonight at 2am'."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.zone ZoneOffsetTransition]))

(defn *of
  "Obtains an instance defining a transition between two offsets.

   Applications should normally obtain an instance from ZoneRules.
   This factory is only intended for use when creating ZoneRules.

  transition - the transition date-time at the transition, which never actually occurs, expressed local to the before offset, not null - `java.time.LocalDateTime`
  offset-before - the offset before the transition, not null - `java.time.ZoneOffset`
  offset-after - the offset at and after the transition, not null - `java.time.ZoneOffset`

  returns: the transition, not null - `java.time.zone.ZoneOffsetTransition`

  throws: java.lang.IllegalArgumentException - if offsetBefore and offsetAfter are equal, or transition.getNano() returns non-zero value"
  ([transition offset-before offset-after]
    (ZoneOffsetTransition/of transition offset-before offset-after)))

(defn get-offset-before
  "Gets the offset before the transition.

   This is the offset in use before the instant of the transition.

  returns: the offset before the transition, not null - `java.time.ZoneOffset`"
  ([this]
    (-> this (.getOffsetBefore))))

(defn gap?
  "Does this transition represent a gap in the local time-line.

   Gaps occur where there are local date-times that simply do not exist.
   An example would be when the offset changes from +01:00 to +02:00.
   This might be described as 'the clocks will move forward one hour tonight at 1am'.

  returns: true if this transition is a gap, false if it is an overlap - `boolean`"
  ([this]
    (-> this (.isGap))))

(defn to-string
  "Returns a string describing this object.

  returns: a string for debugging, not null - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-date-time-after
  "Gets the local transition date-time, as would be expressed with the 'after' offset.

   This is the first date-time after the discontinuity, when the new offset applies.

   The combination of the 'before' date-time and offset represents the same instant
   as the 'after' date-time and offset.

  returns: the transition date-time expressed with the after offset, not null - `java.time.LocalDateTime`"
  ([this]
    (-> this (.getDateTimeAfter))))

(defn get-instant
  "Gets the transition instant.

   This is the instant of the discontinuity, which is defined as the first
   instant that the 'after' offset applies.

   The methods getInstant(), getDateTimeBefore() and getDateTimeAfter()
   all represent the same instant.

  returns: the transition instant, not null - `java.time.Instant`"
  ([this]
    (-> this (.getInstant))))

(defn to-epoch-second
  "Gets the transition instant as an epoch second.

  returns: the transition epoch second - `long`"
  ([this]
    (-> this (.toEpochSecond))))

(defn overlap?
  "Does this transition represent an overlap in the local time-line.

   Overlaps occur where there are local date-times that exist twice.
   An example would be when the offset changes from +02:00 to +01:00.
   This might be described as 'the clocks will move back one hour tonight at 2am'.

  returns: true if this transition is an overlap, false if it is a gap - `boolean`"
  ([this]
    (-> this (.isOverlap))))

(defn get-offset-after
  "Gets the offset after the transition.

   This is the offset in use on and after the instant of the transition.

  returns: the offset after the transition, not null - `java.time.ZoneOffset`"
  ([this]
    (-> this (.getOffsetAfter))))

(defn get-date-time-before
  "Gets the local transition date-time, as would be expressed with the 'before' offset.

   This is the date-time where the discontinuity begins expressed with the 'before' offset.
   At this instant, the 'after' offset is actually used, therefore the combination of this
   date-time and the 'before' offset will never occur.

   The combination of the 'before' date-time and offset represents the same instant
   as the 'after' date-time and offset.

  returns: the transition date-time expressed with the before offset, not null - `java.time.LocalDateTime`"
  ([this]
    (-> this (.getDateTimeBefore))))

(defn hash-code
  "Returns a suitable hash code.

  returns: the hash code - `int`"
  ([this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares this transition to another based on the transition instant.

   This compares the instants of each transition.
   The offsets are ignored, making this order inconsistent with equals.

  transition - the transition to compare to, not null - `java.time.zone.ZoneOffsetTransition`

  returns: the comparator value, negative if less, positive if greater - `int`"
  ([this transition]
    (-> this (.compareTo transition))))

(defn valid-offset?
  "Checks if the specified offset is valid during this transition.

   This checks to see if the given offset will be valid at some point in the transition.
   A gap will always return false.
   An overlap will return true if the offset is either the before or after offset.

  offset - the offset to check, null returns false - `java.time.ZoneOffset`

  returns: true if the offset is valid during the transition - `boolean`"
  ([this offset]
    (-> this (.isValidOffset offset))))

(defn get-duration
  "Gets the duration of the transition.

   In most cases, the transition duration is one hour, however this is not always the case.
   The duration will be positive for a gap and negative for an overlap.
   Time-zones are second-based, so the nanosecond part of the duration will be zero.

  returns: the duration of the transition, positive for gaps, negative for overlaps - `java.time.Duration`"
  ([this]
    (-> this (.getDuration))))

(defn equals
  "Checks if this object equals another.

   The entire state of the object is compared.

  other - the other object to compare to, null returns false - `java.lang.Object`

  returns: true if equal - `boolean`"
  ([this other]
    (-> this (.equals other))))

