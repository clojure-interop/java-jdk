(ns javax.swing.text.NavigationFilter
  "NavigationFilter can be used to restrict where the cursor can
  be positioned. When the default cursor positioning actions attempt to
  reposition the cursor they will call into the
  NavigationFilter, assuming
  the JTextComponent has a non-null
  NavigationFilter set. In this manner
  the NavigationFilter can effectively restrict where the
  cursor can be positioned. Similarly DefaultCaret will call
  into the NavigationFilter when the user is changing the
  selection to further restrict where the cursor can be positioned.

  Subclasses can conditionally call into supers implementation to restrict
  where the cursor can be placed, or call directly into the
  FilterBypass."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text NavigationFilter]))

(defn ->navigation-filter
  "Constructor."
  ([]
    (new NavigationFilter )))

(defn set-dot
  "Invoked prior to the Caret setting the dot. The default implementation
   calls directly into the FilterBypass with the passed
   in arguments. Subclasses may wish to conditionally
   call super with a different location, or invoke the necessary method
   on the FilterBypass

  fb - FilterBypass that can be used to mutate caret position - `javax.swing.text.NavigationFilter.FilterBypass`
  dot - the position >= 0 - `int`
  bias - Bias to place the dot at - `javax.swing.text.Position.Bias`"
  ([^javax.swing.text.NavigationFilter this ^javax.swing.text.NavigationFilter.FilterBypass fb ^Integer dot ^javax.swing.text.Position.Bias bias]
    (-> this (.setDot fb dot bias))))

(defn move-dot
  "Invoked prior to the Caret moving the dot. The default implementation
   calls directly into the FilterBypass with the passed
   in arguments. Subclasses may wish to conditionally
   call super with a different location, or invoke the necessary
   methods on the FilterBypass.

  fb - FilterBypass that can be used to mutate caret position - `javax.swing.text.NavigationFilter.FilterBypass`
  dot - the position >= 0 - `int`
  bias - Bias for new location - `javax.swing.text.Position.Bias`"
  ([^javax.swing.text.NavigationFilter this ^javax.swing.text.NavigationFilter.FilterBypass fb ^Integer dot ^javax.swing.text.Position.Bias bias]
    (-> this (.moveDot fb dot bias))))

(defn get-next-visual-position-from
  "Returns the next visual position to place the caret at from an
   existing position. The default implementation simply forwards the
   method to the root View. Subclasses may wish to further restrict the
   location based on additional criteria.

  text - JTextComponent containing text - `javax.swing.text.JTextComponent`
  pos - Position used in determining next position - `int`
  bias - Bias used in determining next position - `javax.swing.text.Position.Bias`
  direction - the direction from the current position that can be thought of as the arrow keys typically found on a keyboard. This will be one of the following values: SwingConstants.WEST SwingConstants.EAST SwingConstants.NORTH SwingConstants.SOUTH - `int`
  bias-ret - Used to return resulting Bias of next position - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the next
    location visual position - `int`

  throws: javax.swing.text.BadLocationException"
  (^Integer [^javax.swing.text.NavigationFilter this ^javax.swing.text.JTextComponent text ^Integer pos ^javax.swing.text.Position.Bias bias ^Integer direction bias-ret]
    (-> this (.getNextVisualPositionFrom text pos bias direction bias-ret))))

