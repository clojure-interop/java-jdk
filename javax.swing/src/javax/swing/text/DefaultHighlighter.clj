(ns javax.swing.text.DefaultHighlighter
  "Implements the Highlighter interfaces.  Implements a simple highlight
  painter that renders in a solid color."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DefaultHighlighter]))

(defn ->default-highlighter
  "Constructor.

  Creates a new DefaultHighlighther object."
  ([]
    (new DefaultHighlighter )))

(def *-default-painter
  "Static Constant.

  Default implementation of LayeredHighlighter.LayerPainter that can
   be used for painting highlights.

   As of 1.4 this field is final.

  type: javax.swing.text.LayeredHighlighter.LayerPainter"
  DefaultHighlighter/DefaultPainter)

(defn change-highlight
  "Changes a highlight.

  tag - the highlight tag - `java.lang.Object`
  p-0 - the beginning of the range >= 0 - `int`
  p-1 - the end of the range >= p0 - `int`

  throws: javax.swing.text.BadLocationException - if the specified location is invalid"
  ([this tag p-0 p-1]
    (-> this (.changeHighlight tag p-0 p-1))))

(defn get-draws-layered-highlights?
  "returns: `boolean`"
  ([this]
    (-> this (.getDrawsLayeredHighlights))))

(defn add-highlight
  "Adds a highlight to the view.  Returns a tag that can be used
   to refer to the highlight.

  p-0 - the start offset of the range to highlight >= 0 - `int`
  p-1 - the end offset of the range to highlight >= p0 - `int`
  p - the painter to use to actually render the highlight - `javax.swing.text.Highlighter.HighlightPainter`

  returns: an object that can be used as a tag
     to refer to the highlight - `java.lang.Object`

  throws: javax.swing.text.BadLocationException - if the specified location is invalid"
  ([this p-0 p-1 p]
    (-> this (.addHighlight p-0 p-1 p))))

(defn remove-highlight
  "Removes a highlight from the view.

  tag - the reference to the highlight - `java.lang.Object`"
  ([this tag]
    (-> this (.removeHighlight tag))))

(defn get-highlights
  "Makes a copy of the highlights.  Does not actually clone each highlight,
   but only makes references to them.

  returns: the copy - `javax.swing.text.Highlighter.Highlight[]`"
  ([this]
    (-> this (.getHighlights))))

(defn paint-layered-highlights
  "When leaf Views (such as LabelView) are rendering they should
   call into this method. If a highlight is in the given region it will
   be drawn immediately.

  g - Graphics used to draw - `java.awt.Graphics`
  p-0 - starting offset of view - `int`
  p-1 - ending offset of view - `int`
  view-bounds - Bounds of View - `java.awt.Shape`
  editor - JTextComponent - `javax.swing.text.JTextComponent`
  view - View instance being rendered - `javax.swing.text.View`"
  ([this g p-0 p-1 view-bounds editor view]
    (-> this (.paintLayeredHighlights g p-0 p-1 view-bounds editor view))))

(defn install
  "Called when the UI is being installed into the
   interface of a JTextComponent.  Installs the editor, and
   removes any existing highlights.

  c - the editor component - `javax.swing.text.JTextComponent`"
  ([this c]
    (-> this (.install c))))

(defn paint
  "Renders the highlights.

  g - the graphics context - `java.awt.Graphics`"
  ([this g]
    (-> this (.paint g))))

(defn remove-all-highlights
  "Removes all highlights."
  ([this]
    (-> this (.removeAllHighlights))))

(defn deinstall
  "Called when the UI is being removed from the interface of
   a JTextComponent.

  c - the component - `javax.swing.text.JTextComponent`"
  ([this c]
    (-> this (.deinstall c))))

(defn set-draws-layered-highlights
  "If true, highlights are drawn as the Views draw the text. That is
   the Views will call into paintLayeredHighlight which
   will result in a rectangle being drawn before the text is drawn
   (if the offsets are in a highlighted region that is). For this to
   work the painter supplied must be an instance of
   LayeredHighlightPainter.

  new-value - `boolean`"
  ([this new-value]
    (-> this (.setDrawsLayeredHighlights new-value))))

