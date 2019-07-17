(ns jdk.awt.font.LineMetrics
  "The LineMetrics class allows access to the
  metrics needed to layout characters along a line
  and to layout of a set of lines.  A LineMetrics
  object encapsulates the measurement information associated
  with a run of text.

  Fonts can have different metrics for different ranges of
  characters.  The getLineMetrics methods of
  Font take some text as an argument
  and return a LineMetrics object describing the
  metrics of the initial number of characters in that text, as
  returned by getNumChars()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font LineMetrics]))

(defn ->line-metrics
  "Constructor."
  ([]
    (new LineMetrics )))

(defn get-underline-thickness
  "Returns the thickness of the underline.

  returns: the thickness of the underline. - `float`"
  ([^java.awt.font.LineMetrics this]
    (-> this (.getUnderlineThickness))))

(defn get-baseline-index
  "Returns the baseline index of the text.
   The index is one of
   ROMAN_BASELINE,
   CENTER_BASELINE,
   HANGING_BASELINE.

  returns: the baseline of the text. - `int`"
  ([^java.awt.font.LineMetrics this]
    (-> this (.getBaselineIndex))))

(defn get-ascent
  "Returns the ascent of the text.  The ascent
   is the distance from the baseline
   to the ascender line.  The ascent usually represents the
   the height of the capital letters of the text.  Some characters
   can extend above the ascender line.

  returns: the ascent of the text. - `float`"
  ([^java.awt.font.LineMetrics this]
    (-> this (.getAscent))))

(defn get-strikethrough-thickness
  "Returns the thickness of the strike-through line.

  returns: the thickness of the strike-through line. - `float`"
  ([^java.awt.font.LineMetrics this]
    (-> this (.getStrikethroughThickness))))

(defn get-num-chars
  "Returns the number of characters (char values) in the text whose
   metrics are encapsulated by this LineMetrics
   object.

  returns: the number of characters (char values) in the text with which
           this LineMetrics was created. - `int`"
  ([^java.awt.font.LineMetrics this]
    (-> this (.getNumChars))))

(defn get-descent
  "Returns the descent of the text.  The descent
   is the distance from the baseline
   to the descender line.  The descent usually represents
   the distance to the bottom of lower case letters like
   'p'.  Some characters can extend below the descender
   line.

  returns: the descent of the text. - `float`"
  ([^java.awt.font.LineMetrics this]
    (-> this (.getDescent))))

(defn get-baseline-offsets
  "Returns the baseline offsets of the text,
   relative to the baseline of the text.  The
   offsets are indexed by baseline index.  For
   example, if the baseline index is
   CENTER_BASELINE then
   offsets[HANGING_BASELINE] is usually
   negative, offsets[CENTER_BASELINE]
   is zero, and offsets[ROMAN_BASELINE]
   is usually positive.

  returns: the baseline offsets of the text. - `float[]`"
  ([^java.awt.font.LineMetrics this]
    (-> this (.getBaselineOffsets))))

(defn get-underline-offset
  "Returns the position of the underline relative to
   the baseline.

  returns: the position of the underline. - `float`"
  ([^java.awt.font.LineMetrics this]
    (-> this (.getUnderlineOffset))))

(defn get-strikethrough-offset
  "Returns the position of the strike-through line
   relative to the baseline.

  returns: the position of the strike-through line. - `float`"
  ([^java.awt.font.LineMetrics this]
    (-> this (.getStrikethroughOffset))))

(defn get-height
  "Returns the height of the text.  The
   height is equal to the sum of the ascent, the
   descent and the leading.

  returns: the height of the text. - `float`"
  ([^java.awt.font.LineMetrics this]
    (-> this (.getHeight))))

(defn get-leading
  "Returns the leading of the text. The
   leading is the recommended
   distance from the bottom of the descender line to the
   top of the next line.

  returns: the leading of the text. - `float`"
  ([^java.awt.font.LineMetrics this]
    (-> this (.getLeading))))

