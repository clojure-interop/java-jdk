(ns javax.swing.text.Highlighter
  "An interface for an object that allows one to mark up the background
  with colored areas."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Highlighter]))

(defn install
  "Called when the UI is being installed into the
   interface of a JTextComponent.  This can be used
   to gain access to the model that is being navigated
   by the implementation of this interface.

  c - the JTextComponent editor - `javax.swing.text.JTextComponent`"
  ([^javax.swing.text.Highlighter this ^javax.swing.text.JTextComponent c]
    (-> this (.install c))))

(defn deinstall
  "Called when the UI is being removed from the
   interface of a JTextComponent.  This is used to
   unregister any listeners that were attached.

  c - the JTextComponent editor - `javax.swing.text.JTextComponent`"
  ([^javax.swing.text.Highlighter this ^javax.swing.text.JTextComponent c]
    (-> this (.deinstall c))))

(defn paint
  "Renders the highlights.

  g - the graphics context. - `java.awt.Graphics`"
  ([^javax.swing.text.Highlighter this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn add-highlight
  "Adds a highlight to the view.  Returns a tag that can be used
   to refer to the highlight.

  p-0 - the beginning of the range >= 0 - `int`
  p-1 - the end of the range >= p0 - `int`
  p - the painter to use for the actual highlighting - `javax.swing.text.Highlighter.HighlightPainter`

  returns: an object that refers to the highlight - `java.lang.Object`

  throws: javax.swing.text.BadLocationException - for an invalid range specification"
  (^java.lang.Object [^javax.swing.text.Highlighter this ^Integer p-0 ^Integer p-1 ^javax.swing.text.Highlighter.HighlightPainter p]
    (-> this (.addHighlight p-0 p-1 p))))

(defn remove-highlight
  "Removes a highlight from the view.

  tag - which highlight to remove - `java.lang.Object`"
  ([^javax.swing.text.Highlighter this ^java.lang.Object tag]
    (-> this (.removeHighlight tag))))

(defn remove-all-highlights
  "Removes all highlights this highlighter is responsible for."
  ([^javax.swing.text.Highlighter this]
    (-> this (.removeAllHighlights))))

(defn change-highlight
  "Changes the given highlight to span a different portion of
   the document.  This may be more efficient than a remove/add
   when a selection is expanding/shrinking (such as a sweep
   with a mouse) by damaging only what changed.

  tag - which highlight to change - `java.lang.Object`
  p-0 - the beginning of the range >= 0 - `int`
  p-1 - the end of the range >= p0 - `int`

  throws: javax.swing.text.BadLocationException - for an invalid range specification"
  ([^javax.swing.text.Highlighter this ^java.lang.Object tag ^Integer p-0 ^Integer p-1]
    (-> this (.changeHighlight tag p-0 p-1))))

(defn get-highlights
  "Fetches the current list of highlights.

  returns: the highlight list - `javax.swing.text.Highlighter.Highlight[]`"
  ([^javax.swing.text.Highlighter this]
    (-> this (.getHighlights))))

