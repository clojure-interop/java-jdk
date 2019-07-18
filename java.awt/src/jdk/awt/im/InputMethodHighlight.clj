(ns jdk.awt.im.InputMethodHighlight
  "An InputMethodHighlight is used to describe the highlight
  attributes of text being composed.
  The description can be at two levels:
  at the abstract level it specifies the conversion state and whether the
  text is selected; at the concrete level it specifies style attributes used
  to render the highlight.
  An InputMethodHighlight must provide the description at the
  abstract level; it may or may not provide the description at the concrete
  level.
  If no concrete style is provided, a renderer should use
  Toolkit.mapInputMethodHighlight(java.awt.im.InputMethodHighlight) to map to a concrete style.

  The abstract description consists of three fields: selected,
  state, and variation.
  selected indicates whether the text range is the one that the
  input method is currently working on, for example, the segment for which
  conversion candidates are currently shown in a menu.
  state represents the conversion state. State values are defined
  by the input method framework and should be distinguished in all
  mappings from abstract to concrete styles. Currently defined state values
  are raw (unconverted) and converted.
  These state values are recommended for use before and after the
  main conversion step of text composition, say, before and after kana->kanji
  or pinyin->hanzi conversion.
  The variation field allows input methods to express additional
  information about the conversion results.


  InputMethodHighlight instances are typically used as attribute values
  returned from AttributedCharacterIterator for the INPUT_METHOD_HIGHLIGHT
  attribute. They may be wrapped into Annotation
  instances to indicate separate text segments."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.im InputMethodHighlight]))

(defn ->input-method-highlight
  "Constructor.

  Constructs an input method highlight record.
   The style attributes map provided must be unmodifiable.

  selected - whether the text range is selected - `boolean`
  state - the conversion state for the text range - RAW_TEXT or CONVERTED_TEXT - `int`
  variation - the variation for the text range - `int`
  style - the rendering style attributes for the text range, or null - `java.util.Map`

  throws: java.lang.IllegalArgumentException - if a state other than RAW_TEXT or CONVERTED_TEXT is given"
  (^InputMethodHighlight [^Boolean selected ^Integer state ^Integer variation ^java.util.Map style]
    (new InputMethodHighlight selected state variation style))
  (^InputMethodHighlight [^Boolean selected ^Integer state ^Integer variation]
    (new InputMethodHighlight selected state variation))
  (^InputMethodHighlight [^Boolean selected ^Integer state]
    (new InputMethodHighlight selected state)))

(def *-raw-text
  "Static Constant.

  Constant for the raw text state.

  type: int"
  InputMethodHighlight/RAW_TEXT)

(def *-converted-text
  "Static Constant.

  Constant for the converted text state.

  type: int"
  InputMethodHighlight/CONVERTED_TEXT)

(def *-unselected-raw-text-highlight
  "Static Constant.

  Constant for the default highlight for unselected raw text.

  type: java.awt.im.InputMethodHighlight"
  InputMethodHighlight/UNSELECTED_RAW_TEXT_HIGHLIGHT)

(def *-selected-raw-text-highlight
  "Static Constant.

  Constant for the default highlight for selected raw text.

  type: java.awt.im.InputMethodHighlight"
  InputMethodHighlight/SELECTED_RAW_TEXT_HIGHLIGHT)

(def *-unselected-converted-text-highlight
  "Static Constant.

  Constant for the default highlight for unselected converted text.

  type: java.awt.im.InputMethodHighlight"
  InputMethodHighlight/UNSELECTED_CONVERTED_TEXT_HIGHLIGHT)

(def *-selected-converted-text-highlight
  "Static Constant.

  Constant for the default highlight for selected converted text.

  type: java.awt.im.InputMethodHighlight"
  InputMethodHighlight/SELECTED_CONVERTED_TEXT_HIGHLIGHT)

(defn selected?
  "Returns whether the text range is selected.

  returns: `boolean`"
  (^Boolean [^InputMethodHighlight this]
    (-> this (.isSelected))))

(defn get-state
  "Returns the conversion state of the text range.

  returns: The conversion state for the text range - RAW_TEXT or CONVERTED_TEXT. - `int`"
  (^Integer [^InputMethodHighlight this]
    (-> this (.getState))))

(defn get-variation
  "Returns the variation of the text range.

  returns: `int`"
  (^Integer [^InputMethodHighlight this]
    (-> this (.getVariation))))

(defn get-style
  "Returns the rendering style attributes for the text range, or null.

  returns: `java.util.Map<java.awt.font.TextAttribute,?>`"
  (^java.util.Map [^InputMethodHighlight this]
    (-> this (.getStyle))))

