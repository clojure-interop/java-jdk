(ns javax.swing.text.Utilities
  "A collection of methods to deal with various text
  related activities."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Utilities]))

(defn ->utilities
  "Constructor."
  ([]
    (new Utilities )))

(defn *get-previous-word
  "Determine the start of the prev word for the given location.
   Uses BreakIterator.getWordInstance() to actually get the words.

  c - the editor - `javax.swing.text.JTextComponent`
  offs - the offset in the document >= 0 - `int`

  returns: the location in the model of the word start >= 0 - `int`

  throws: javax.swing.text.BadLocationException - if the offset is out of range"
  ([c offs]
    (Utilities/getPreviousWord c offs)))

(defn *get-tabbed-text-offset
  "Determines the relative offset into the given text that
   best represents the given span in the view coordinate
   system.  This is implemented in a 1.1 style coordinate
   system where ints are used and 72dpi is assumed.

  s - the source of the text - `javax.swing.text.Segment`
  metrics - the font metrics to use for the calculation - `java.awt.FontMetrics`
  x-0 - the starting view location representing the start of the given text >= 0. - `int`
  x - the target view location to translate to an offset into the text >= 0. - `int`
  e - how to expand the tabs. If this value is null, tabs will be expanded as a space character. - `javax.swing.text.TabExpander`
  start-offset - starting offset of the text in the document >= 0 - `int`

  returns: the offset into the text >= 0 - `int`"
  ([s metrics x-0 x e start-offset]
    (Utilities/getTabbedTextOffset s metrics x-0 x e start-offset))
  ([s metrics x-0 x e start-offset round]
    (Utilities/getTabbedTextOffset s metrics x-0 x e start-offset round)))

(defn *get-word-end
  "Determines the end of a word for the given location.
   Uses BreakIterator.getWordInstance() to actually get the words.

  c - the editor - `javax.swing.text.JTextComponent`
  offs - the offset in the document >= 0 - `int`

  returns: the location in the model of the word end >= 0 - `int`

  throws: javax.swing.text.BadLocationException - if the offset is out of range"
  ([c offs]
    (Utilities/getWordEnd c offs)))

(defn *get-tabbed-text-width
  "Determines the width of the given segment of text taking tabs
   into consideration.  This is implemented in a 1.1 style coordinate
   system where ints are used and 72dpi is assumed.

  s - the source of the text - `javax.swing.text.Segment`
  metrics - the font metrics to use for the calculation - `java.awt.FontMetrics`
  x - the X origin >= 0 - `int`
  e - how to expand the tabs. If this value is null, tabs will be expanded as a space character. - `javax.swing.text.TabExpander`
  start-offset - starting offset of the text in the document >= 0 - `int`

  returns: the width of the text - `int`"
  ([s metrics x e start-offset]
    (Utilities/getTabbedTextWidth s metrics x e start-offset)))

(defn *get-position-below
  "Determines the position in the model that is closest to the given
   view location in the row below.  The component given must have a
   size to compute the result.  If the component doesn't have a size
   a value of -1 will be returned.

  c - the editor - `javax.swing.text.JTextComponent`
  offs - the offset in the document >= 0 - `int`
  x - the X coordinate >= 0 - `int`

  returns: the position >= 0 if the request can be computed, otherwise
    a value of -1 will be returned. - `int`

  throws: javax.swing.text.BadLocationException - if the offset is out of range"
  ([c offs x]
    (Utilities/getPositionBelow c offs x)))

(defn *get-word-start
  "Determines the start of a word for the given model location.
   Uses BreakIterator.getWordInstance() to actually get the words.

  c - the editor - `javax.swing.text.JTextComponent`
  offs - the offset in the document >= 0 - `int`

  returns: the location in the model of the word start >= 0 - `int`

  throws: javax.swing.text.BadLocationException - if the offset is out of range"
  ([c offs]
    (Utilities/getWordStart c offs)))

(defn *get-row-start
  "Determines the starting row model position of the row that contains
   the specified model position.  The component given must have a
   size to compute the result.  If the component doesn't have a size
   a value of -1 will be returned.

  c - the editor - `javax.swing.text.JTextComponent`
  offs - the offset in the document >= 0 - `int`

  returns: the position >= 0 if the request can be computed, otherwise
    a value of -1 will be returned. - `int`

  throws: javax.swing.text.BadLocationException - if the offset is out of range"
  ([c offs]
    (Utilities/getRowStart c offs)))

(defn *get-position-above
  "Determines the position in the model that is closest to the given
   view location in the row above.  The component given must have a
   size to compute the result.  If the component doesn't have a size
   a value of -1 will be returned.

  c - the editor - `javax.swing.text.JTextComponent`
  offs - the offset in the document >= 0 - `int`
  x - the X coordinate >= 0 - `int`

  returns: the position >= 0 if the request can be computed, otherwise
    a value of -1 will be returned. - `int`

  throws: javax.swing.text.BadLocationException - if the offset is out of range"
  ([c offs x]
    (Utilities/getPositionAbove c offs x)))

(defn *draw-tabbed-text
  "Draws the given text, expanding any tabs that are contained
   using the given tab expansion technique.  This particular
   implementation renders in a 1.1 style coordinate system
   where ints are used and 72dpi is assumed.

  s - the source of the text - `javax.swing.text.Segment`
  x - the X origin >= 0 - `int`
  y - the Y origin >= 0 - `int`
  g - the graphics context - `java.awt.Graphics`
  e - how to expand the tabs. If this value is null, tabs will be expanded as a space character. - `javax.swing.text.TabExpander`
  start-offset - starting offset of the text in the document >= 0 - `int`

  returns: the X location at the end of the rendered text - `int`"
  ([s x y g e start-offset]
    (Utilities/drawTabbedText s x y g e start-offset)))

(defn *get-row-end
  "Determines the ending row model position of the row that contains
   the specified model position.  The component given must have a
   size to compute the result.  If the component doesn't have a size
   a value of -1 will be returned.

  c - the editor - `javax.swing.text.JTextComponent`
  offs - the offset in the document >= 0 - `int`

  returns: the position >= 0 if the request can be computed, otherwise
    a value of -1 will be returned. - `int`

  throws: javax.swing.text.BadLocationException - if the offset is out of range"
  ([c offs]
    (Utilities/getRowEnd c offs)))

(defn *get-break-location
  "Determine where to break the given text to fit
   within the given span. This tries to find a word boundary.

  s - the source of the text - `javax.swing.text.Segment`
  metrics - the font metrics to use for the calculation - `java.awt.FontMetrics`
  x-0 - the starting view location representing the start of the given text. - `int`
  x - the target view location to translate to an offset into the text. - `int`
  e - how to expand the tabs. If this value is null, tabs will be expanded as a space character. - `javax.swing.text.TabExpander`
  start-offset - starting offset in the document of the text - `int`

  returns: the offset into the given text - `int`"
  ([s metrics x-0 x e start-offset]
    (Utilities/getBreakLocation s metrics x-0 x e start-offset)))

(defn *get-paragraph-element
  "Determines the element to use for a paragraph/line.

  c - the editor - `javax.swing.text.JTextComponent`
  offs - the starting offset in the document >= 0 - `int`

  returns: the element - `javax.swing.text.Element`"
  ([c offs]
    (Utilities/getParagraphElement c offs)))

(defn *get-next-word
  "Determines the start of the next word for the given location.
   Uses BreakIterator.getWordInstance() to actually get the words.

  c - the editor - `javax.swing.text.JTextComponent`
  offs - the offset in the document >= 0 - `int`

  returns: the location in the model of the word start >= 0 - `int`

  throws: javax.swing.text.BadLocationException - if the offset is out of range"
  ([c offs]
    (Utilities/getNextWord c offs)))

