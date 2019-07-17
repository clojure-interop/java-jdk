(ns jdk.util.regex.MatchResult
  "The result of a match operation.

  This interface contains query methods used to determine the
  results of a match against a regular expression. The match boundaries,
  groups and group boundaries can be seen but not modified through
  a MatchResult."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.regex MatchResult]))

(defn start
  "Returns the start index of the subsequence captured by the given group
   during this match.

    Capturing groups are indexed from left
   to right, starting at one.  Group zero denotes the entire pattern, so
   the expression m.start(0) is equivalent to
   m.start().

  group - The index of a capturing group in this matcher's pattern - `int`

  returns: The index of the first character captured by the group,
            or -1 if the match was successful but the group
            itself did not match anything - `int`

  throws: java.lang.IllegalStateException - If no match has yet been attempted, or if the previous match operation failed"
  ([^java.util.regex.MatchResult this ^Integer group]
    (-> this (.start group)))
  ([^java.util.regex.MatchResult this]
    (-> this (.start))))

(defn end
  "Returns the offset after the last character of the subsequence
   captured by the given group during this match.

    Capturing groups are indexed from left
   to right, starting at one.  Group zero denotes the entire pattern, so
   the expression m.end(0) is equivalent to
   m.end().

  group - The index of a capturing group in this matcher's pattern - `int`

  returns: The offset after the last character captured by the group,
            or -1 if the match was successful
            but the group itself did not match anything - `int`

  throws: java.lang.IllegalStateException - If no match has yet been attempted, or if the previous match operation failed"
  ([^java.util.regex.MatchResult this ^Integer group]
    (-> this (.end group)))
  ([^java.util.regex.MatchResult this]
    (-> this (.end))))

(defn group
  "Returns the input subsequence captured by the given group during the
   previous match operation.

    For a matcher m, input sequence s, and group index
   g, the expressions m.group(g) and
   s.substring(m.start(g), m.end(g))
   are equivalent.

    Capturing groups are indexed from left
   to right, starting at one.  Group zero denotes the entire pattern, so
   the expression m.group(0) is equivalent to m.group().


    If the match was successful but the group specified failed to match
   any part of the input sequence, then null is returned. Note
   that some groups, for example (a*), match the empty string.
   This method will return the empty string when such a group successfully
   matches the empty string in the input.

  group - The index of a capturing group in this matcher's pattern - `int`

  returns: The (possibly empty) subsequence captured by the group
            during the previous match, or null if the group
            failed to match part of the input - `java.lang.String`

  throws: java.lang.IllegalStateException - If no match has yet been attempted, or if the previous match operation failed"
  ([^java.util.regex.MatchResult this ^Integer group]
    (-> this (.group group)))
  ([^java.util.regex.MatchResult this]
    (-> this (.group))))

(defn group-count
  "Returns the number of capturing groups in this match result's pattern.

    Group zero denotes the entire pattern by convention. It is not
   included in this count.

    Any non-negative integer smaller than or equal to the value
   returned by this method is guaranteed to be a valid group index for
   this matcher.

  returns: The number of capturing groups in this matcher's pattern - `int`"
  ([^java.util.regex.MatchResult this]
    (-> this (.groupCount))))

