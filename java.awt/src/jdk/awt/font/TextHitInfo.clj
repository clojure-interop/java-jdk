(ns jdk.awt.font.TextHitInfo
  "The TextHitInfo class represents a character position in a
  text model, and a bias, or `side,` of the character.  Biases are
  either leading (the left edge, for a left-to-right character)
  or trailing (the right edge, for a left-to-right character).
  Instances of TextHitInfo are used to specify caret and
  insertion positions within text.

  For example, consider the text `abc`.  TextHitInfo.trailing(1)
  corresponds to the right side of the 'b' in the text.

  TextHitInfo is used primarily by TextLayout and
  clients of TextLayout.  Clients of TextLayout
  query TextHitInfo instances for an insertion offset, where
  new text is inserted into the text model.  The insertion offset is equal
  to the character position in the TextHitInfo if the bias
  is leading, and one character after if the bias is trailing.  The
  insertion offset for TextHitInfo.trailing(1) is 2.

  Sometimes it is convenient to construct a TextHitInfo with
  the same insertion offset as an existing one, but on the opposite
  character.  The getOtherHit method constructs a new
  TextHitInfo with the same insertion offset as an existing
  one, with a hit on the character on the other side of the insertion offset.
  Calling getOtherHit on trailing(1) would return leading(2).
  In general, getOtherHit for trailing(n) returns
  leading(n+1) and getOtherHit for leading(n)
  returns trailing(n-1).

  Example:
  Converting a graphical point to an insertion point within a text
  model


  TextLayout layout = ...;
  Point2D.Float hitPoint = ...;
  TextHitInfo hitInfo = layout.hitTestChar(hitPoint.x, hitPoint.y);
  int insPoint = hitInfo.getInsertionIndex();
  // insPoint is relative to layout;  may need to adjust for use
  // in a text model"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font TextHitInfo]))

(defn *leading
  "Creates a TextHitInfo on the leading edge of the
   character at the specified charIndex.

  char-index - the index of the character hit - `int`

  returns: a TextHitInfo on the leading edge of the
   character at the specified charIndex. - `java.awt.font.TextHitInfo`"
  (^java.awt.font.TextHitInfo [^Integer char-index]
    (TextHitInfo/leading char-index)))

(defn *trailing
  "Creates a hit on the trailing edge of the character at
   the specified charIndex.

  char-index - the index of the character hit - `int`

  returns: a TextHitInfo on the trailing edge of the
   character at the specified charIndex. - `java.awt.font.TextHitInfo`"
  (^java.awt.font.TextHitInfo [^Integer char-index]
    (TextHitInfo/trailing char-index)))

(defn *before-offset
  "Creates a TextHitInfo at the specified offset,
   associated with the character before the offset.

  offset - an offset associated with the character before the offset - `int`

  returns: a TextHitInfo at the specified offset. - `java.awt.font.TextHitInfo`"
  (^java.awt.font.TextHitInfo [^Integer offset]
    (TextHitInfo/beforeOffset offset)))

(defn *after-offset
  "Creates a TextHitInfo at the specified offset,
   associated with the character after the offset.

  offset - an offset associated with the character after the offset - `int`

  returns: a TextHitInfo at the specified offset. - `java.awt.font.TextHitInfo`"
  (^java.awt.font.TextHitInfo [^Integer offset]
    (TextHitInfo/afterOffset offset)))

(defn get-char-index
  "Returns the index of the character hit.

  returns: the index of the character hit. - `int`"
  (^Integer [^java.awt.font.TextHitInfo this]
    (-> this (.getCharIndex))))

(defn leading-edge?
  "Returns true if the leading edge of the character was
   hit.

  returns: true if the leading edge of the character was
   hit; false otherwise. - `boolean`"
  (^Boolean [^java.awt.font.TextHitInfo this]
    (-> this (.isLeadingEdge))))

(defn get-insertion-index
  "Returns the insertion index.  This is the character index if
   the leading edge of the character was hit, and one greater
   than the character index if the trailing edge was hit.

  returns: the insertion index. - `int`"
  (^Integer [^java.awt.font.TextHitInfo this]
    (-> this (.getInsertionIndex))))

(defn hash-code
  "Returns the hash code.

  returns: the hash code of this TextHitInfo, which is
   also the charIndex of this TextHitInfo. - `int`"
  (^Integer [^java.awt.font.TextHitInfo this]
    (-> this (.hashCode))))

(defn equals
  "Returns true if the specified Object is a
   TextHitInfo and equals this TextHitInfo.

  obj - the Object to test for equality - `java.lang.Object`

  returns: true if the specified Object
   equals this TextHitInfo; false otherwise. - `boolean`"
  (^Boolean [^java.awt.font.TextHitInfo this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn to-string
  "Returns a String representing the hit for debugging
   use only.

  returns: a String representing this
   TextHitInfo. - `java.lang.String`"
  (^java.lang.String [^java.awt.font.TextHitInfo this]
    (-> this (.toString))))

(defn get-other-hit
  "Creates a TextHitInfo on the other side of the
   insertion point.  This TextHitInfo remains unchanged.

  returns: a TextHitInfo on the other side of the
   insertion point. - `java.awt.font.TextHitInfo`"
  (^java.awt.font.TextHitInfo [^java.awt.font.TextHitInfo this]
    (-> this (.getOtherHit))))

(defn get-offset-hit
  "Creates a TextHitInfo whose character index is offset
   by delta from the charIndex of this
   TextHitInfo. This TextHitInfo remains
   unchanged.

  delta - the value to offset this charIndex - `int`

  returns: a TextHitInfo whose charIndex is
   offset by delta from the charIndex of
   this TextHitInfo. - `java.awt.font.TextHitInfo`"
  (^java.awt.font.TextHitInfo [^java.awt.font.TextHitInfo this ^Integer delta]
    (-> this (.getOffsetHit delta))))

