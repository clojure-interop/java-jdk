(ns jdk.util.regex.Matcher
  "An engine that performs match operations on a java.lang.character sequence by interpreting a Pattern.

   A matcher is created from a pattern by invoking the pattern's matcher method.  Once created, a matcher can be used to
  perform three different kinds of match operations:



     The matches method attempts to match the entire
    input sequence against the pattern.

     The lookingAt method attempts to match the
    input sequence, starting at the beginning, against the pattern.

     The find method scans the input sequence looking for
    the next subsequence that matches the pattern.



   Each of these methods returns a boolean indicating success or failure.
  More information about a successful match can be obtained by querying the
  state of the matcher.

   A matcher finds matches in a subset of its input called the
  region. By default, the region contains all of the matcher's input.
  The region can be modified via theregion method and queried
  via the regionStart and regionEnd
  methods. The way that the region boundaries interact with some pattern
  constructs can be changed. See useAnchoringBounds and useTransparentBounds
  for more details.

   This class also defines methods for replacing matched subsequences with
  new strings whose contents can, if desired, be computed from the match
  result.  The appendReplacement and appendTail methods can be used in tandem in order to collect
  the result into an existing string buffer, or the more convenient replaceAll method can be used to create a string in which every
  matching subsequence in the input sequence is replaced.

   The explicit state of a matcher includes the start and end indices of
  the most recent successful match.  It also includes the start and end
  indices of the input subsequence captured by each capturing group in the pattern as well as a total
  count of such subsequences.  As a convenience, methods are also provided for
  returning these captured subsequences in string form.

   The explicit state of a matcher is initially undefined; attempting to
  query any part of it before a successful match will cause an IllegalStateException to be thrown.  The explicit state of a matcher is
  recomputed by every match operation.

   The implicit state of a matcher includes the input character sequence as
  well as the append position, which is initially zero and is updated
  by the appendReplacement method.

   A matcher may be reset explicitly by invoking its reset()
  method or, if a new input sequence is desired, its reset(CharSequence) method.  Resetting a
  matcher discards its explicit state information and sets the append position
  to zero.

   Instances of this class are not safe for use by multiple concurrent
  threads."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.regex Matcher]))

(defn *quote-replacement
  "Returns a literal replacement String for the specified
   String.

   This method produces a String that will work
   as a literal replacement s in the
   appendReplacement method of the Matcher class.
   The String produced will match the sequence of characters
   in s treated as a literal sequence. Slashes ('\\') and
   dollar signs ('$') will be given no special meaning.

  s - The string to be literalized - `java.lang.String`

  returns: A literal string replacement - `java.lang.String`"
  (^java.lang.String [^java.lang.String s]
    (Matcher/quoteReplacement s)))

(defn replace-all
  "Replaces every subsequence of the input sequence that matches the
   pattern with the given replacement string.

    This method first resets this matcher.  It then scans the input
   sequence looking for matches of the pattern.  Characters that are not
   part of any match are appended directly to the result string; each match
   is replaced in the result by the replacement string.  The replacement
   string may contain references to captured subsequences as in the appendReplacement method.

    Note that backslashes (\\) and dollar signs ($) in
   the replacement string may cause the results to be different than if it
   were being treated as a literal replacement string. Dollar signs may be
   treated as references to captured subsequences as described above, and
   backslashes are used to escape literal characters in the replacement
   string.

    Given the regular expression a*b, the input
   \"aabfooaabfooabfoob\", and the replacement string
   \"-\", an invocation of this method on a matcher for that
   expression would yield the string \"-foo-foo-foo-\".

    Invoking this method changes this matcher's state.  If the matcher
   is to be used in further matching operations then it should first be
   reset.

  replacement - The replacement string - `java.lang.String`

  returns: The string constructed by replacing each matching subsequence
            by the replacement string, substituting captured subsequences
            as needed - `java.lang.String`"
  (^java.lang.String [^Matcher this ^java.lang.String replacement]
    (-> this (.replaceAll replacement))))

(defn use-anchoring-bounds
  "Sets the anchoring of region bounds for this matcher.

    Invoking this method with an argument of true will set this
   matcher to use anchoring bounds. If the boolean
   argument is false, then non-anchoring bounds will be
   used.

    Using anchoring bounds, the boundaries of this
   matcher's region match anchors such as ^ and $.

    Without anchoring bounds, the boundaries of this
   matcher's region will not match anchors such as ^ and $.

    By default, a matcher uses anchoring region boundaries.

  b - a boolean indicating whether or not to use anchoring bounds. - `boolean`

  returns: this matcher - `java.util.regex.Matcher`"
  (^java.util.regex.Matcher [^Matcher this ^Boolean b]
    (-> this (.useAnchoringBounds b))))

(defn find
  "Resets this matcher and then attempts to find the next subsequence of
   the input sequence that matches the pattern, starting at the specified
   index.

    If the match succeeds then more information can be obtained via the
   start, end, and group methods, and subsequent
   invocations of the find() method will start at the first
   character not matched by this match.

  start - the index to start searching for a match - `int`

  returns: true if, and only if, a subsequence of the input
            sequence starting at the given index matches this matcher's
            pattern - `boolean`

  throws: java.lang.IndexOutOfBoundsException - If start is less than zero or if start is greater than the length of the input sequence."
  (^Boolean [^Matcher this ^Integer start]
    (-> this (.find start)))
  (^Boolean [^Matcher this]
    (-> this (.find))))

(defn has-transparent-bounds?
  "Queries the transparency of region bounds for this matcher.

    This method returns true if this matcher uses
   transparent bounds, false if it uses opaque
   bounds.

    See useTransparentBounds for a
   description of transparent and opaque bounds.

    By default, a matcher uses opaque region boundaries.

  returns: true iff this matcher is using transparent bounds,
           false otherwise. - `boolean`"
  (^Boolean [^Matcher this]
    (-> this (.hasTransparentBounds))))

(defn use-transparent-bounds
  "Sets the transparency of region bounds for this matcher.

    Invoking this method with an argument of true will set this
   matcher to use transparent bounds. If the boolean
   argument is false, then opaque bounds will be used.

    Using transparent bounds, the boundaries of this
   matcher's region are transparent to lookahead, lookbehind,
   and boundary matching constructs. Those constructs can see beyond the
   boundaries of the region to see if a match is appropriate.

    Using opaque bounds, the boundaries of this matcher's
   region are opaque to lookahead, lookbehind, and boundary matching
   constructs that may try to see beyond them. Those constructs cannot
   look past the boundaries so they will fail to match anything outside
   of the region.

    By default, a matcher uses opaque bounds.

  b - a boolean indicating whether to use opaque or transparent regions - `boolean`

  returns: this matcher - `java.util.regex.Matcher`"
  (^java.util.regex.Matcher [^Matcher this ^Boolean b]
    (-> this (.useTransparentBounds b))))

(defn use-pattern
  "Changes the Pattern that this Matcher uses to
   find matches with.

    This method causes this matcher to lose information
   about the groups of the last match that occurred. The
   matcher's position in the input is maintained and its
   last append position is unaffected.

  new-pattern - The new pattern used by this matcher - `java.util.regex.Pattern`

  returns: This matcher - `java.util.regex.Matcher`

  throws: java.lang.IllegalArgumentException - If newPattern is null"
  (^java.util.regex.Matcher [^Matcher this ^java.util.regex.Pattern new-pattern]
    (-> this (.usePattern new-pattern))))

(defn append-tail
  "Implements a terminal append-and-replace step.

    This method reads characters from the input sequence, starting at
   the append position, and appends them to the given string buffer.  It is
   intended to be invoked after one or more invocations of the appendReplacement method in order to copy the
   remainder of the input sequence.

  sb - The target string buffer - `java.lang.StringBuffer`

  returns: The target string buffer - `java.lang.StringBuffer`"
  (^java.lang.StringBuffer [^Matcher this ^java.lang.StringBuffer sb]
    (-> this (.appendTail sb))))

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
  (^java.lang.String [^Matcher this ^Integer group]
    (-> this (.group group)))
  (^java.lang.String [^Matcher this]
    (-> this (.group))))

(defn require-end
  "Returns true if more input could change a positive match into a
   negative one.

   If this method returns true, and a match was found, then more
   input could cause the match to be lost. If this method returns false
   and a match was found, then more input might change the match but the
   match won't be lost. If a match was not found, then requireEnd has no
   meaning.

  returns: true iff more input could change a positive match into a
            negative one. - `boolean`"
  (^Boolean [^Matcher this]
    (-> this (.requireEnd))))

(defn replace-first
  "Replaces the first subsequence of the input sequence that matches the
   pattern with the given replacement string.

    This method first resets this matcher.  It then scans the input
   sequence looking for a match of the pattern.  Characters that are not
   part of the match are appended directly to the result string; the match
   is replaced in the result by the replacement string.  The replacement
   string may contain references to captured subsequences as in the appendReplacement method.

   Note that backslashes (\\) and dollar signs ($) in
   the replacement string may cause the results to be different than if it
   were being treated as a literal replacement string. Dollar signs may be
   treated as references to captured subsequences as described above, and
   backslashes are used to escape literal characters in the replacement
   string.

    Given the regular expression dog, the input
   \"zzzdogzzzdogzzz\", and the replacement string
   \"cat\", an invocation of this method on a matcher for that
   expression would yield the string \"zzzcatzzzdogzzz\".

    Invoking this method changes this matcher's state.  If the matcher
   is to be used in further matching operations then it should first be
   reset.

  replacement - The replacement string - `java.lang.String`

  returns: The string constructed by replacing the first matching
            subsequence by the replacement string, substituting captured
            subsequences as needed - `java.lang.String`"
  (^java.lang.String [^Matcher this ^java.lang.String replacement]
    (-> this (.replaceFirst replacement))))

(defn to-string
  "Returns the string representation of this matcher. The
   string representation of a Matcher contains information
   that may be useful for debugging. The exact format is unspecified.

  returns: The string representation of this matcher - `java.lang.String`"
  (^java.lang.String [^Matcher this]
    (-> this (.toString))))

(defn reset
  "Resets this matcher with a new input sequence.

    Resetting a matcher discards all of its explicit state information
   and sets its append position to zero.  The matcher's region is set to
   the default region, which is its entire character sequence.  The
   anchoring and transparency of this matcher's region boundaries are
   unaffected.

  input - The new input character sequence - `java.lang.CharSequence`

  returns: This matcher - `java.util.regex.Matcher`"
  (^java.util.regex.Matcher [^Matcher this ^java.lang.CharSequence input]
    (-> this (.reset input)))
  (^java.util.regex.Matcher [^Matcher this]
    (-> this (.reset))))

(defn hit-end
  "Returns true if the end of input was hit by the search engine in
   the last match operation performed by this matcher.

   When this method returns true, then it is possible that more input
   would have changed the result of the last search.

  returns: true iff the end of input was hit in the last match; false
            otherwise - `boolean`"
  (^Boolean [^Matcher this]
    (-> this (.hitEnd))))

(defn region-start
  "Reports the start index of this matcher's region. The
   searches this matcher conducts are limited to finding matches
   within regionStart (inclusive) and
   regionEnd (exclusive).

  returns: The starting point of this matcher's region - `int`"
  (^Integer [^Matcher this]
    (-> this (.regionStart))))

(defn to-match-result
  "Returns the match state of this matcher as a MatchResult.
   The result is unaffected by subsequent operations performed upon this
   matcher.

  returns: a MatchResult with the state of this matcher - `java.util.regex.MatchResult`"
  (^java.util.regex.MatchResult [^Matcher this]
    (-> this (.toMatchResult))))

(defn start
  "Returns the start index of the subsequence captured by the given group
   during the previous match operation.

    Capturing groups are indexed from left
   to right, starting at one.  Group zero denotes the entire pattern, so
   the expression m.start(0) is equivalent to
   m.start().

  group - The index of a capturing group in this matcher's pattern - `int`

  returns: The index of the first character captured by the group,
            or -1 if the match was successful but the group
            itself did not match anything - `int`

  throws: java.lang.IllegalStateException - If no match has yet been attempted, or if the previous match operation failed"
  (^Integer [^Matcher this ^Integer group]
    (-> this (.start group)))
  (^Integer [^Matcher this]
    (-> this (.start))))

(defn looking-at
  "Attempts to match the input sequence, starting at the beginning of the
   region, against the pattern.

    Like the matches method, this method always starts
   at the beginning of the region; unlike that method, it does not
   require that the entire region be matched.

    If the match succeeds then more information can be obtained via the
   start, end, and group methods.

  returns: true if, and only if, a prefix of the input
            sequence matches this matcher's pattern - `boolean`"
  (^Boolean [^Matcher this]
    (-> this (.lookingAt))))

(defn region
  "Sets the limits of this matcher's region. The region is the part of the
   input sequence that will be searched to find a match. Invoking this
   method resets the matcher, and then sets the region to start at the
   index specified by the start parameter and end at the
   index specified by the end parameter.

   Depending on the transparency and anchoring being used (see
   useTransparentBounds and
   useAnchoringBounds), certain constructs such
   as anchors may behave differently at or around the boundaries of the
   region.

  start - The index to start searching at (inclusive) - `int`
  end - The index to end searching at (exclusive) - `int`

  returns: this matcher - `java.util.regex.Matcher`

  throws: java.lang.IndexOutOfBoundsException - If start or end is less than zero, if start is greater than the length of the input sequence, if end is greater than the length of the input sequence, or if start is greater than end."
  (^java.util.regex.Matcher [^Matcher this ^Integer start ^Integer end]
    (-> this (.region start end))))

(defn matches
  "Attempts to match the entire region against the pattern.

    If the match succeeds then more information can be obtained via the
   start, end, and group methods.

  returns: true if, and only if, the entire region sequence
            matches this matcher's pattern - `boolean`"
  (^Boolean [^Matcher this]
    (-> this (.matches))))

(defn pattern
  "Returns the pattern that is interpreted by this matcher.

  returns: The pattern for which this matcher was created - `java.util.regex.Pattern`"
  (^java.util.regex.Pattern [^Matcher this]
    (-> this (.pattern))))

(defn region-end
  "Reports the end index (exclusive) of this matcher's region.
   The searches this matcher conducts are limited to finding matches
   within regionStart (inclusive) and
   regionEnd (exclusive).

  returns: the ending point of this matcher's region - `int`"
  (^Integer [^Matcher this]
    (-> this (.regionEnd))))

(defn has-anchoring-bounds?
  "Queries the anchoring of region bounds for this matcher.

    This method returns true if this matcher uses
   anchoring bounds, false otherwise.

    See useAnchoringBounds for a
   description of anchoring bounds.

    By default, a matcher uses anchoring region boundaries.

  returns: true iff this matcher is using anchoring bounds,
           false otherwise. - `boolean`"
  (^Boolean [^Matcher this]
    (-> this (.hasAnchoringBounds))))

(defn group-count
  "Returns the number of capturing groups in this matcher's pattern.

    Group zero denotes the entire pattern by convention. It is not
   included in this count.

    Any non-negative integer smaller than or equal to the value
   returned by this method is guaranteed to be a valid group index for
   this matcher.

  returns: The number of capturing groups in this matcher's pattern - `int`"
  (^Integer [^Matcher this]
    (-> this (.groupCount))))

(defn end
  "Returns the offset after the last character of the subsequence
   captured by the given group during the previous match operation.

    Capturing groups are indexed from left
   to right, starting at one.  Group zero denotes the entire pattern, so
   the expression m.end(0) is equivalent to
   m.end().

  group - The index of a capturing group in this matcher's pattern - `int`

  returns: The offset after the last character captured by the group,
            or -1 if the match was successful
            but the group itself did not match anything - `int`

  throws: java.lang.IllegalStateException - If no match has yet been attempted, or if the previous match operation failed"
  (^Integer [^Matcher this ^Integer group]
    (-> this (.end group)))
  (^Integer [^Matcher this]
    (-> this (.end))))

(defn append-replacement
  "Implements a non-terminal append-and-replace step.

    This method performs the following actions:



      It reads characters from the input sequence, starting at the
     append position, and appends them to the given string buffer.  It
     stops after reading the last character preceding the previous match,
     that is, the character at index start() - 1.

      It appends the given replacement string to the string buffer.


      It sets the append position of this matcher to the index of
     the last character matched, plus one, that is, to end().




    The replacement string may contain references to subsequences
   captured during the previous match: Each occurrence of
   ${name} or $g
   will be replaced by the result of evaluating the corresponding
   group(name) or group(g)
   respectively. For  $g,
   the first number after the $ is always treated as part of
   the group reference. Subsequent numbers are incorporated into g if
   they would form a legal group reference. Only the numerals '0'
   through '9' are considered as potential components of the group
   reference. If the second group matched the string \"foo\", for
   example, then passing the replacement string \"$2bar\" would
   cause \"foobar\" to be appended to the string buffer. A dollar
   sign ($) may be included as a literal in the replacement
   string by preceding it with a backslash (\\$).

    Note that backslashes (\\) and dollar signs ($) in
   the replacement string may cause the results to be different than if it
   were being treated as a literal replacement string. Dollar signs may be
   treated as references to captured subsequences as described above, and
   backslashes are used to escape literal characters in the replacement
   string.

    This method is intended to be used in a loop together with the
   appendTail and find methods.  The
   following code, for example, writes one dog two dogs in the
   yard to the standard-output stream:



   Pattern p = Pattern.compile(\"cat\");
   Matcher m = p.matcher(\"one cat two cats in the yard\");
   StringBuffer sb = new StringBuffer();
   while (m.find()) {
       m.appendReplacement(sb, \"dog\");
   }
   m.appendTail(sb);
   System.out.println(sb.toString());

  sb - The target string buffer - `java.lang.StringBuffer`
  replacement - The replacement string - `java.lang.String`

  returns: This matcher - `java.util.regex.Matcher`

  throws: java.lang.IllegalStateException - If no match has yet been attempted, or if the previous match operation failed"
  (^java.util.regex.Matcher [^Matcher this ^java.lang.StringBuffer sb ^java.lang.String replacement]
    (-> this (.appendReplacement sb replacement))))

