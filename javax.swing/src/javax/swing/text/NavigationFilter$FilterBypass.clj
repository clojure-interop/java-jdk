(ns javax.swing.text.NavigationFilter$FilterBypass
  "Used as a way to circumvent calling back into the caret to
  position the cursor. Caret implementations that wish to support
  a NavigationFilter must provide an implementation that will
  not callback into the NavigationFilter."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text NavigationFilter$FilterBypass]))

(defn ->filter-bypass
  "Constructor."
  (^NavigationFilter$FilterBypass []
    (new NavigationFilter$FilterBypass )))

(defn get-caret
  "Returns the Caret that is changing.

  returns: Caret that is changing - `javax.swing.text.Caret`"
  (^javax.swing.text.Caret [^NavigationFilter$FilterBypass this]
    (-> this (.getCaret))))

(defn set-dot
  "Sets the caret location, bypassing the NavigationFilter.

  dot - the position >= 0 - `int`
  bias - Bias to place the dot at - `javax.swing.text.Position$Bias`"
  ([^NavigationFilter$FilterBypass this ^Integer dot ^javax.swing.text.Position$Bias bias]
    (-> this (.setDot dot bias))))

(defn move-dot
  "Moves the caret location, bypassing the NavigationFilter.

  dot - the position >= 0 - `int`
  bias - Bias for new location - `javax.swing.text.Position$Bias`"
  ([^NavigationFilter$FilterBypass this ^Integer dot ^javax.swing.text.Position$Bias bias]
    (-> this (.moveDot dot bias))))

