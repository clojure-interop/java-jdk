(ns jdk.time.zone.ZoneOffsetTransitionRule$TimeDefinition
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.zone ZoneOffsetTransitionRule$TimeDefinition]))

(def UTC
  "Enum Constant.

  The local date-time is expressed in terms of the UTC offset.

  type: java.time.zone.ZoneOffsetTransitionRule.TimeDefinition"
  ZoneOffsetTransitionRule$TimeDefinition/UTC)

(def WALL
  "Enum Constant.

  The local date-time is expressed in terms of the wall offset.

  type: java.time.zone.ZoneOffsetTransitionRule.TimeDefinition"
  ZoneOffsetTransitionRule$TimeDefinition/WALL)

(def STANDARD
  "Enum Constant.

  The local date-time is expressed in terms of the standard offset.

  type: java.time.zone.ZoneOffsetTransitionRule.TimeDefinition"
  ZoneOffsetTransitionRule$TimeDefinition/STANDARD)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (ZoneOffsetTransitionRule.TimeDefinition c : ZoneOffsetTransitionRule.TimeDefinition.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.zone.ZoneOffsetTransitionRule.TimeDefinition[]`"
  ([]
    (ZoneOffsetTransitionRule$TimeDefinition/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.zone.ZoneOffsetTransitionRule.TimeDefinition`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (ZoneOffsetTransitionRule$TimeDefinition/valueOf name)))

(defn create-date-time
  "Converts the specified local date-time to the local date-time actually
   seen on a wall clock.

   This method converts using the type of this enum.
   The output is defined relative to the 'before' offset of the transition.

   The UTC type uses the UTC offset.
   The STANDARD type uses the standard offset.
   The WALL type returns the input date-time.
   The result is intended for use with the wall-offset.

  date-time - the local date-time, not null - `java.time.LocalDateTime`
  standard-offset - the standard offset, not null - `java.time.ZoneOffset`
  wall-offset - the wall offset, not null - `java.time.ZoneOffset`

  returns: the date-time relative to the wall/before offset, not null - `java.time.LocalDateTime`"
  ([^java.time.zone.ZoneOffsetTransitionRule$TimeDefinition this ^java.time.LocalDateTime date-time ^java.time.ZoneOffset standard-offset ^java.time.ZoneOffset wall-offset]
    (-> this (.createDateTime date-time standard-offset wall-offset))))

