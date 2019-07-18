(ns javax.swing.text.Caret
  "A place within a document view that represents where
  things can be inserted into the document model.  A caret
  has a position in the document referred to as a dot.
  The dot is where the caret is currently located in the
  model.  There is
  a second position maintained by the caret that represents
  the other end of a selection called mark.  If there is
  no selection the dot and mark will be equal.  If a selection
  exists, the two values will be different.

  The dot can be placed by either calling
  setDot or moveDot.  Setting
  the dot has the effect of removing any selection that may
  have previously existed.  The dot and mark will be equal.
  Moving the dot has the effect of creating a selection as
  the mark is left at whatever position it previously had."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Caret]))

(defn get-dot
  "Fetches the current position of the caret.

  returns: the position >=0 - `int`"
  (^Integer [^Caret this]
    (-> this (.getDot))))

(defn move-dot
  "Moves the caret position (dot) to some other position,
   leaving behind the mark.  This is useful for
   making selections.

  dot - the new position to move the caret to >=0 - `int`"
  ([^Caret this ^Integer dot]
    (-> this (.moveDot dot))))

(defn add-change-listener
  "Adds a listener to track whenever the caret position
   has been changed.

  l - the change listener - `javax.swing.event.ChangeListener`"
  ([^Caret this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn get-magic-caret-position
  "Gets the current caret visual location.

  returns: the visual position. - `java.awt.Point`"
  (^java.awt.Point [^Caret this]
    (-> this (.getMagicCaretPosition))))

(defn set-blink-rate
  "Sets the blink rate of the caret.  This determines if
   and how fast the caret blinks, commonly used as one
   way to attract attention to the caret.

  rate - the delay in milliseconds >=0. If this is zero the caret will not blink. - `int`"
  ([^Caret this ^Integer rate]
    (-> this (.setBlinkRate rate))))

(defn set-magic-caret-position
  "Set the current caret visual location.  This can be used when
   moving between lines that have uneven end positions (such as
   when caret up or down actions occur).  If text flows
   left-to-right or right-to-left the x-coordinate will indicate
   the desired navigation location for vertical movement.  If
   the text flow is top-to-bottom, the y-coordinate will indicate
   the desired navigation location for horizontal movement.

  p - the Point to use for the saved position. This can be null to indicate there is no visual location. - `java.awt.Point`"
  ([^Caret this ^java.awt.Point p]
    (-> this (.setMagicCaretPosition p))))

(defn remove-change-listener
  "Removes a listener that was tracking caret position changes.

  l - the change listener - `javax.swing.event.ChangeListener`"
  ([^Caret this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn install
  "Called when the UI is being installed into the
   interface of a JTextComponent.  This can be used
   to gain access to the model that is being navigated
   by the implementation of this interface.

  c - the JTextComponent - `javax.swing.text.JTextComponent`"
  ([^Caret this ^javax.swing.text.JTextComponent c]
    (-> this (.install c))))

(defn get-blink-rate
  "Gets the blink rate of the caret.  This determines if
   and how fast the caret blinks, commonly used as one
   way to attract attention to the caret.

  returns: the delay in milliseconds >=0.  If this is
    zero the caret will not blink. - `int`"
  (^Integer [^Caret this]
    (-> this (.getBlinkRate))))

(defn get-mark
  "Fetches the current position of the mark.  If there
   is a selection, the mark will not be the same as
   the dot.

  returns: the position >=0 - `int`"
  (^Integer [^Caret this]
    (-> this (.getMark))))

(defn paint
  "Renders the caret. This method is called by UI classes.

  g - the graphics context - `java.awt.Graphics`"
  ([^Caret this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn selection-visible?
  "Determines if the selection is currently visible.

  returns: true if the caret is visible else false - `boolean`"
  (^Boolean [^Caret this]
    (-> this (.isSelectionVisible))))

(defn set-visible
  "Sets the visibility of the caret.

  v - true if the caret should be shown, and false if the caret should be hidden - `boolean`"
  ([^Caret this ^Boolean v]
    (-> this (.setVisible v))))

(defn deinstall
  "Called when the UI is being removed from the
   interface of a JTextComponent.  This is used to
   unregister any listeners that were attached.

  c - the JTextComponent - `javax.swing.text.JTextComponent`"
  ([^Caret this ^javax.swing.text.JTextComponent c]
    (-> this (.deinstall c))))

(defn visible?
  "Determines if the caret is currently visible.

  returns: true if the caret is visible else false - `boolean`"
  (^Boolean [^Caret this]
    (-> this (.isVisible))))

(defn set-selection-visible
  "Sets the visibility of the selection

  v - true if the caret should be shown, and false if the caret should be hidden - `boolean`"
  ([^Caret this ^Boolean v]
    (-> this (.setSelectionVisible v))))

(defn set-dot
  "Sets the caret position to some position.  This
   causes the mark to become the same as the dot,
   effectively setting the selection range to zero.

   If the parameter is negative or beyond the length of the document,
   the caret is placed at the beginning or at the end, respectively.

  dot - the new position to set the caret to - `int`"
  ([^Caret this ^Integer dot]
    (-> this (.setDot dot))))

