(ns javax.swing.event.HyperlinkListener
  "HyperlinkListener"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event HyperlinkListener]))

(defn hyperlink-update
  "Called when a hypertext link is updated.

  e - the event responsible for the update - `javax.swing.event.HyperlinkEvent`"
  ([this e]
    (-> this (.hyperlinkUpdate e))))

