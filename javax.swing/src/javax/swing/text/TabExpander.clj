(ns javax.swing.text.TabExpander
  "Simple interface to allow for different types of
  implementations of tab expansion."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text TabExpander]))

(defn next-tab-stop
  "Returns the next tab stop position given a reference
   position.  Values are expressed in points.

  x - the position in points >= 0 - `float`
  tab-offset - the position within the text stream that the tab occurred at >= 0. - `int`

  returns: the next tab stop >= 0 - `float`"
  ([^javax.swing.text.TabExpander this ^Float x ^Integer tab-offset]
    (-> this (.nextTabStop x tab-offset))))

