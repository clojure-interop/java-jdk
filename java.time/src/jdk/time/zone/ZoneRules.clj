(ns jdk.time.zone.ZoneRules
  "The rules defining how the zone offset varies for a single time-zone.

  The rules model all the historic and future transitions for a time-zone.
  ZoneOffsetTransition is used for known transitions, typically historic.
  ZoneOffsetTransitionRule is used for future transitions that are based
  on the result of an algorithm.

  The rules are loaded via ZoneRulesProvider using a ZoneId.
  The same rules may be shared internally between multiple zone IDs.

  Serializing an instance of ZoneRules will store the entire set of rules.
  It does not store the zone ID as it is not part of the state of this object.

  A rule implementation may or may not store full information about historic
  and future transitions, and the information stored is only as accurate as
  that supplied to the implementation by the rules provider.
  Applications should treat the data provided as representing the best information
  available to the implementation of this rule."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.zone ZoneRules]))

(defn *of
  "Obtains an instance of a ZoneRules.

  base-standard-offset - the standard offset to use before legal rules were set, not null - `java.time.ZoneOffset`
  base-wall-offset - the wall offset to use before legal rules were set, not null - `java.time.ZoneOffset`
  standard-offset-transition-list - the list of changes to the standard offset, not null - `java.util.List<java.time.zone.ZoneOffsetTransition>`
  transition-list - the list of transitions, not null - `java.util.List<java.time.zone.ZoneOffsetTransition>`
  last-rules - the recurring last rules, size 16 or less, not null - `java.util.List<java.time.zone.ZoneOffsetTransitionRule>`

  returns: the zone rules, not null - `java.time.zone.ZoneRules`"
  (^java.time.zone.ZoneRules [^java.time.ZoneOffset base-standard-offset ^java.time.ZoneOffset base-wall-offset ^java.util.List standard-offset-transition-list ^java.util.List transition-list ^java.util.List last-rules]
    (ZoneRules/of base-standard-offset base-wall-offset standard-offset-transition-list transition-list last-rules))
  (^java.time.zone.ZoneRules [^java.time.ZoneOffset offset]
    (ZoneRules/of offset)))

(defn get-standard-offset
  "Gets the standard offset for the specified instant in this zone.

   This provides access to historic information on how the standard offset
   has changed over time.
   The standard offset is the offset before any daylight saving time is applied.
   This is typically the offset applicable during winter.

  instant - the instant to find the offset information for, not null, but null may be ignored if the rules have a single offset for all instants - `java.time.Instant`

  returns: the standard offset, not null - `java.time.ZoneOffset`"
  (^java.time.ZoneOffset [^java.time.zone.ZoneRules this ^java.time.Instant instant]
    (-> this (.getStandardOffset instant))))

(defn get-transition-rules
  "Gets the list of transition rules for years beyond those defined in the transition list.

   The complete set of transitions for this rules instance is defined by this method
   and getTransitions(). This method returns instances of ZoneOffsetTransitionRule
   that define an algorithm for when transitions will occur.

   For any given ZoneRules, this list contains the transition rules for years
   beyond those years that have been fully defined. These rules typically refer to future
   daylight saving time rule changes.

   If the zone defines daylight savings into the future, then the list will normally
   be of size two and hold information about entering and exiting daylight savings.
   If the zone does not have daylight savings, or information about future changes
   is uncertain, then the list will be empty.

   The list will be empty for fixed offset rules and for any time-zone where there is no
   daylight saving time. The list will also be empty if the transition rules are unknown.

  returns: an immutable list of transition rules, not null - `java.util.List<java.time.zone.ZoneOffsetTransitionRule>`"
  (^java.util.List [^java.time.zone.ZoneRules this]
    (-> this (.getTransitionRules))))

(defn get-daylight-savings
  "Gets the amount of daylight savings in use for the specified instant in this zone.

   This provides access to historic information on how the amount of daylight
   savings has changed over time.
   This is the difference between the standard offset and the actual offset.
   Typically the amount is zero during winter and one hour during summer.
   Time-zones are second-based, so the nanosecond part of the duration will be zero.

   This default implementation calculates the duration from the
   actual and
   standard offsets.

  instant - the instant to find the daylight savings for, not null, but null may be ignored if the rules have a single offset for all instants - `java.time.Instant`

  returns: the difference between the standard and actual offset, not null - `java.time.Duration`"
  (^java.time.Duration [^java.time.zone.ZoneRules this ^java.time.Instant instant]
    (-> this (.getDaylightSavings instant))))

(defn get-transitions
  "Gets the complete list of fully defined transitions.

   The complete set of transitions for this rules instance is defined by this method
   and getTransitionRules(). This method returns those transitions that have
   been fully defined. These are typically historical, but may be in the future.

   The list will be empty for fixed offset rules and for any time-zone where there has
   only ever been a single offset. The list will also be empty if the transition rules are unknown.

  returns: an immutable list of fully defined transitions, not null - `java.util.List<java.time.zone.ZoneOffsetTransition>`"
  (^java.util.List [^java.time.zone.ZoneRules this]
    (-> this (.getTransitions))))

(defn next-transition
  "Gets the next transition after the specified instant.

   This returns details of the next transition after the specified instant.
   For example, if the instant represents a point where `Summer` daylight savings time
   applies, then the method will return the transition to the next `Winter` time.

  instant - the instant to get the next transition after, not null, but null may be ignored if the rules have a single offset for all instants - `java.time.Instant`

  returns: the next transition after the specified instant, null if this is after the last transition - `java.time.zone.ZoneOffsetTransition`"
  (^java.time.zone.ZoneOffsetTransition [^java.time.zone.ZoneRules this ^java.time.Instant instant]
    (-> this (.nextTransition instant))))

(defn get-transition
  "Gets the offset transition applicable at the specified local date-time in these rules.

   The mapping from a local date-time to an offset is not straightforward.
   There are three cases:

   Normal, with one valid offset. For the vast majority of the year, the normal
    case applies, where there is a single valid offset for the local date-time.
   Gap, with zero valid offsets. This is when clocks jump forward typically
    due to the spring daylight savings change from `winter` to `summer`.
    In a gap there are local date-time values with no valid offset.
   Overlap, with two valid offsets. This is when clocks are set back typically
    due to the autumn daylight savings change from `summer` to `winter`.
    In an overlap there are local date-time values with two valid offsets.

   A transition is used to model the cases of a Gap or Overlap.
   The Normal case will return null.

   There are various ways to handle the conversion from a LocalDateTime.
   One technique, using this method, would be:


    ZoneOffsetTransition trans = rules.getTransition(localDT);
    if (trans == null) {
      // Gap or Overlap: determine what to do from transition
    } else {
      // Normal case: only one valid offset
      zoneOffset = rule.getOffset(localDT);
    }

  local-date-time - the local date-time to query for offset transition, not null, but null may be ignored if the rules have a single offset for all instants - `java.time.LocalDateTime`

  returns: the offset transition, null if the local date-time is not in transition - `java.time.zone.ZoneOffsetTransition`"
  (^java.time.zone.ZoneOffsetTransition [^java.time.zone.ZoneRules this ^java.time.LocalDateTime local-date-time]
    (-> this (.getTransition local-date-time))))

(defn to-string
  "Returns a string describing this object.

  returns: a string for debugging, not null - `java.lang.String`"
  (^java.lang.String [^java.time.zone.ZoneRules this]
    (-> this (.toString))))

(defn get-valid-offsets
  "Gets the offset applicable at the specified local date-time in these rules.

   The mapping from a local date-time to an offset is not straightforward.
   There are three cases:

   Normal, with one valid offset. For the vast majority of the year, the normal
    case applies, where there is a single valid offset for the local date-time.
   Gap, with zero valid offsets. This is when clocks jump forward typically
    due to the spring daylight savings change from `winter` to `summer`.
    In a gap there are local date-time values with no valid offset.
   Overlap, with two valid offsets. This is when clocks are set back typically
    due to the autumn daylight savings change from `summer` to `winter`.
    In an overlap there are local date-time values with two valid offsets.

   Thus, for any given local date-time there can be zero, one or two valid offsets.
   This method returns that list of valid offsets, which is a list of size 0, 1 or 2.
   In the case where there are two offsets, the earlier offset is returned at index 0
   and the later offset at index 1.

   There are various ways to handle the conversion from a LocalDateTime.
   One technique, using this method, would be:


    List<ZoneOffset> validOffsets = rules.getOffset(localDT);
    if (validOffsets.size() == 1) {
      // Normal case: only one valid offset
      zoneOffset = validOffsets.get(0);
    } else {
      // Gap or Overlap: determine what to do from transition (which will be non-null)
      ZoneOffsetTransition trans = rules.getTransition(localDT);
    }

   In theory, it is possible for there to be more than two valid offsets.
   This would happen if clocks to be put back more than once in quick succession.
   This has never happened in the history of time-zones and thus has no special handling.
   However, if it were to happen, then the list would return more than 2 entries.

  local-date-time - the local date-time to query for valid offsets, not null, but null may be ignored if the rules have a single offset for all instants - `java.time.LocalDateTime`

  returns: the list of valid offsets, may be immutable, not null - `java.util.List<java.time.ZoneOffset>`"
  (^java.util.List [^java.time.zone.ZoneRules this ^java.time.LocalDateTime local-date-time]
    (-> this (.getValidOffsets local-date-time))))

(defn get-offset
  "Gets the offset applicable at the specified instant in these rules.

   The mapping from an instant to an offset is simple, there is only
   one valid offset for each instant.
   This method returns that offset.

  instant - the instant to find the offset for, not null, but null may be ignored if the rules have a single offset for all instants - `java.time.Instant`

  returns: the offset, not null - `java.time.ZoneOffset`"
  (^java.time.ZoneOffset [^java.time.zone.ZoneRules this ^java.time.Instant instant]
    (-> this (.getOffset instant))))

(defn daylight-savings?
  "Checks if the specified instant is in daylight savings.

   This checks if the standard offset and the actual offset are the same
   for the specified instant.
   If they are not, it is assumed that daylight savings is in operation.

   This default implementation compares the actual
   and standard offsets.

  instant - the instant to find the offset information for, not null, but null may be ignored if the rules have a single offset for all instants - `java.time.Instant`

  returns: the standard offset, not null - `boolean`"
  (^Boolean [^java.time.zone.ZoneRules this ^java.time.Instant instant]
    (-> this (.isDaylightSavings instant))))

(defn previous-transition
  "Gets the previous transition before the specified instant.

   This returns details of the previous transition after the specified instant.
   For example, if the instant represents a point where `summer` daylight saving time
   applies, then the method will return the transition from the previous `winter` time.

  instant - the instant to get the previous transition after, not null, but null may be ignored if the rules have a single offset for all instants - `java.time.Instant`

  returns: the previous transition after the specified instant, null if this is before the first transition - `java.time.zone.ZoneOffsetTransition`"
  (^java.time.zone.ZoneOffsetTransition [^java.time.zone.ZoneRules this ^java.time.Instant instant]
    (-> this (.previousTransition instant))))

(defn hash-code
  "Returns a suitable hash code given the definition of #equals.

  returns: the hash code - `int`"
  (^Integer [^java.time.zone.ZoneRules this]
    (-> this (.hashCode))))

(defn valid-offset?
  "Checks if the offset date-time is valid for these rules.

   To be valid, the local date-time must not be in a gap and the offset
   must match one of the valid offsets.

   This default implementation checks if getValidOffsets(java.time.LocalDateTime)
   contains the specified offset.

  local-date-time - the date-time to check, not null, but null may be ignored if the rules have a single offset for all instants - `java.time.LocalDateTime`
  offset - the offset to check, null returns false - `java.time.ZoneOffset`

  returns: true if the offset date-time is valid for these rules - `boolean`"
  (^Boolean [^java.time.zone.ZoneRules this ^java.time.LocalDateTime local-date-time ^java.time.ZoneOffset offset]
    (-> this (.isValidOffset local-date-time offset))))

(defn fixed-offset?
  "Checks of the zone rules are fixed, such that the offset never varies.

  returns: true if the time-zone is fixed and the offset never changes - `boolean`"
  (^Boolean [^java.time.zone.ZoneRules this]
    (-> this (.isFixedOffset))))

(defn equals
  "Checks if this set of rules equals another.

   Two rule sets are equal if they will always result in the same output
   for any given input instant or local date-time.
   Rules from two different groups may return false even if they are in fact the same.

   This definition should result in implementations comparing their entire state.

  other-rules - the other rules, null returns false - `java.lang.Object`

  returns: true if this rules is the same as that specified - `boolean`"
  (^Boolean [^java.time.zone.ZoneRules this ^java.lang.Object other-rules]
    (-> this (.equals other-rules))))

