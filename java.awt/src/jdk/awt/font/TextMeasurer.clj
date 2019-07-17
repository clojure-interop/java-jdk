(ns jdk.awt.font.TextMeasurer
  "The TextMeasurer class provides the primitive operations
  needed for line break: measuring up to a given advance, determining the
  advance of a range of characters, and generating a
  TextLayout for a range of characters. It also provides
  methods for incremental editing of paragraphs.

  A TextMeasurer object is constructed with an
  AttributedCharacterIterator
  representing a single paragraph of text.  The value returned by the
  getBeginIndex
  method of AttributedCharacterIterator
  defines the absolute index of the first character.  The value
  returned by the
  getEndIndex
  method of AttributedCharacterIterator defines the index
  past the last character.  These values define the range of indexes to
  use in calls to the TextMeasurer.  For example, calls to
  get the advance of a range of text or the line break of a range of text
  must use indexes between the beginning and end index values.  Calls to
  insertChar
  and
  deleteChar
  reset the TextMeasurer to use the beginning index and end
  index of the AttributedCharacterIterator passed in those calls.

  Most clients will use the more convenient LineBreakMeasurer,
  which implements the standard line break policy (placing as many words
  as will fit on each line)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font TextMeasurer]))

(defn ->text-measurer
  "Constructor.

  Constructs a TextMeasurer from the source text.
   The source text should be a single entire paragraph.

  text - the source paragraph. Cannot be null. - `java.text.AttributedCharacterIterator`
  frc - the information about a graphics device which is needed to measure the text correctly. Cannot be null. - `java.awt.font.FontRenderContext`"
  ([^java.text.AttributedCharacterIterator text ^java.awt.font.FontRenderContext frc]
    (new TextMeasurer text frc)))

(defn get-line-break-index
  "Returns the index of the first character which will not fit on
   on a line beginning at start and possible
   measuring up to maxAdvance in graphical width.

  start - the character index at which to start measuring. start is an absolute index, not relative to the start of the paragraph - `int`
  max-advance - the graphical width in which the line must fit - `float`

  returns: the index after the last character that will fit
    on a line beginning at start, which is not longer
    than maxAdvance in graphical width - `int`

  throws: java.lang.IllegalArgumentException - if start is less than the beginning of the paragraph."
  (^Integer [^java.awt.font.TextMeasurer this ^Integer start ^Float max-advance]
    (-> this (.getLineBreakIndex start max-advance))))

(defn get-advance-between
  "Returns the graphical width of a line beginning at start
   and including characters up to limit.
   start and limit are absolute indices,
   not relative to the start of the paragraph.

  start - the character index at which to start measuring - `int`
  limit - the character index at which to stop measuring - `int`

  returns: the graphical width of a line beginning at start
     and including characters up to limit - `float`

  throws: java.lang.IndexOutOfBoundsException - if limit is less than start"
  (^Float [^java.awt.font.TextMeasurer this ^Integer start ^Integer limit]
    (-> this (.getAdvanceBetween start limit))))

(defn get-layout
  "Returns a TextLayout on the given character range.

  start - the index of the first character - `int`
  limit - the index after the last character. Must be greater than start - `int`

  returns: a TextLayout for the characters beginning at
    start up to (but not including) limit - `java.awt.font.TextLayout`

  throws: java.lang.IndexOutOfBoundsException - if limit is less than start"
  (^java.awt.font.TextLayout [^java.awt.font.TextMeasurer this ^Integer start ^Integer limit]
    (-> this (.getLayout start limit))))

(defn insert-char
  "Updates the TextMeasurer after a single character has
   been inserted
   into the paragraph currently represented by this
   TextMeasurer.  After this call, this
   TextMeasurer is equivalent to a new
   TextMeasurer created from the text;  however, it will
   usually be more efficient to update an existing
   TextMeasurer than to create a new one from scratch.

  new-paragraph - the text of the paragraph after performing the insertion. Cannot be null. - `java.text.AttributedCharacterIterator`
  insert-pos - the position in the text where the character was inserted. Must not be less than the start of newParagraph, and must be less than the end of newParagraph. - `int`

  throws: java.lang.IndexOutOfBoundsException - if insertPos is less than the start of newParagraph or greater than or equal to the end of newParagraph"
  ([^java.awt.font.TextMeasurer this ^java.text.AttributedCharacterIterator new-paragraph ^Integer insert-pos]
    (-> this (.insertChar new-paragraph insert-pos))))

(defn delete-char
  "Updates the TextMeasurer after a single character has
   been deleted
   from the paragraph currently represented by this
   TextMeasurer.  After this call, this
   TextMeasurer is equivalent to a new TextMeasurer
   created from the text;  however, it will usually be more efficient
   to update an existing TextMeasurer than to create a new one
   from scratch.

  new-paragraph - the text of the paragraph after performing the deletion. Cannot be null. - `java.text.AttributedCharacterIterator`
  delete-pos - the position in the text where the character was removed. Must not be less than the start of newParagraph, and must not be greater than the end of newParagraph. - `int`

  throws: java.lang.IndexOutOfBoundsException - if deletePos is less than the start of newParagraph or greater than the end of newParagraph"
  ([^java.awt.font.TextMeasurer this ^java.text.AttributedCharacterIterator new-paragraph ^Integer delete-pos]
    (-> this (.deleteChar new-paragraph delete-pos))))

