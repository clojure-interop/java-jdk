(ns javax.swing.text.TabableView
  "Interface for Views that have size dependent upon tabs."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text TabableView]))

(defn get-tabbed-span
  "Determines the desired span when using the given
   tab expansion implementation.  If a container
   calls this method, it will do so prior to the
   normal layout which would call getPreferredSpan.
   A view implementing this should give the same
   result in any subsequent calls to getPreferredSpan
   along the axis of tab expansion.

  x - the position the view would be located at for the purpose of tab expansion >= 0. - `float`
  e - how to expand the tabs when encountered. - `javax.swing.text.TabExpander`

  returns: the desired span >= 0 - `float`"
  (^Float [^javax.swing.text.TabableView this ^Float x ^javax.swing.text.TabExpander e]
    (-> this (.getTabbedSpan x e))))

(defn get-partial-span
  "Determines the span along the same axis as tab
   expansion for a portion of the view.  This is
   intended for use by the TabExpander for cases
   where the tab expansion involves aligning the
   portion of text that doesn't have whitespace
   relative to the tab stop.  There is therefore
   an assumption that the range given does not
   contain tabs.

  p-0 - the starting location in the text document >= 0 - `int`
  p-1 - the ending location in the text document >= p0 - `int`

  returns: the span >= 0 - `float`"
  (^Float [^javax.swing.text.TabableView this ^Integer p-0 ^Integer p-1]
    (-> this (.getPartialSpan p-0 p-1))))

