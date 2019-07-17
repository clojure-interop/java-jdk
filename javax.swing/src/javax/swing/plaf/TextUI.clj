(ns javax.swing.plaf.TextUI
  "Text editor user interface"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf TextUI]))

(defn ->text-ui
  "Constructor."
  ([]
    (new TextUI )))

(defn model-to-view
  "Converts the given location in the model to a place in
   the view coordinate system.

  t - `javax.swing.text.JTextComponent`
  pos - the local location in the model to translate >= 0 - `int`
  bias - `javax.swing.text.Position.Bias`

  returns: the coordinates as a rectangle - `java.awt.Rectangle`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  ([^javax.swing.plaf.TextUI this ^javax.swing.text.JTextComponent t ^Integer pos ^javax.swing.text.Position.Bias bias]
    (-> this (.modelToView t pos bias)))
  ([^javax.swing.plaf.TextUI this ^javax.swing.text.JTextComponent t ^Integer pos]
    (-> this (.modelToView t pos))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.

  t - `javax.swing.text.JTextComponent`
  pt - the location in the view to translate. This should be in the same coordinate system as the mouse events. - `java.awt.Point`
  bias-return - filled in by this method to indicate whether the point given is closer to the previous or the next character in the model - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the
           given point in the view >= 0 - `int`"
  ([^javax.swing.plaf.TextUI this ^javax.swing.text.JTextComponent t ^java.awt.Point pt ^javax.swing.text.Position.Bias[] bias-return]
    (-> this (.viewToModel t pt bias-return)))
  ([^javax.swing.plaf.TextUI this ^javax.swing.text.JTextComponent t ^java.awt.Point pt]
    (-> this (.viewToModel t pt))))

(defn get-next-visual-position-from
  "Provides a way to determine the next visually represented model
   location that one might place a caret.  Some views may not be visible,
   they might not be in the same order found in the model, or they just
   might not allow access to some of the locations in the model.

  t - the text component for which this UI is installed - `javax.swing.text.JTextComponent`
  pos - the position to convert >= 0 - `int`
  b - the bias for the position - `javax.swing.text.Position.Bias`
  direction - the direction from the current position that can be thought of as the arrow keys typically found on a keyboard. This may be SwingConstants.WEST, SwingConstants.EAST, SwingConstants.NORTH, or SwingConstants.SOUTH - `int`
  bias-ret - an array to contain the bias for the returned position - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the next
    location visual position - `int`

  throws: javax.swing.text.BadLocationException"
  ([^javax.swing.plaf.TextUI this ^javax.swing.text.JTextComponent t ^Integer pos ^javax.swing.text.Position.Bias b ^Integer direction ^javax.swing.text.Position.Bias[] bias-ret]
    (-> this (.getNextVisualPositionFrom t pos b direction bias-ret))))

(defn damage-range
  "Causes the portion of the view responsible for the
   given part of the model to be repainted.

  t - `javax.swing.text.JTextComponent`
  p-0 - the beginning of the range >= 0 - `int`
  p-1 - the end of the range >= p0 - `int`
  first-bias - `javax.swing.text.Position.Bias`
  second-bias - `javax.swing.text.Position.Bias`"
  ([^javax.swing.plaf.TextUI this ^javax.swing.text.JTextComponent t ^Integer p-0 ^Integer p-1 ^javax.swing.text.Position.Bias first-bias ^javax.swing.text.Position.Bias second-bias]
    (-> this (.damageRange t p-0 p-1 first-bias second-bias)))
  ([^javax.swing.plaf.TextUI this ^javax.swing.text.JTextComponent t ^Integer p-0 ^Integer p-1]
    (-> this (.damageRange t p-0 p-1))))

(defn get-editor-kit
  "Fetches the binding of services that set a policy
   for the type of document being edited.  This contains
   things like the commands available, stream readers and
   writers, etc.

  t - `javax.swing.text.JTextComponent`

  returns: the editor kit binding - `javax.swing.text.EditorKit`"
  ([^javax.swing.plaf.TextUI this ^javax.swing.text.JTextComponent t]
    (-> this (.getEditorKit t))))

(defn get-root-view
  "Fetches a View with the allocation of the associated
   text component (i.e. the root of the hierarchy) that
   can be traversed to determine how the model is being
   represented spatially.

  t - `javax.swing.text.JTextComponent`

  returns: the view - `javax.swing.text.View`"
  ([^javax.swing.plaf.TextUI this ^javax.swing.text.JTextComponent t]
    (-> this (.getRootView t))))

(defn get-tool-tip-text
  "Returns the string to be used as the tooltip at the passed in location.

  t - `javax.swing.text.JTextComponent`
  pt - `java.awt.Point`

  returns: `java.lang.String`"
  ([^javax.swing.plaf.TextUI this ^javax.swing.text.JTextComponent t ^java.awt.Point pt]
    (-> this (.getToolTipText t pt))))

