(ns javax.swing.text.ViewFactory
  "A factory to create a view of some portion of document subject.
  This is intended to enable customization of how views get
  mapped over a document model."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text ViewFactory]))

(defn create
  "Creates a view from the given structural element of a
   document.

  elem - the piece of the document to build a view of - `javax.swing.text.Element`

  returns: the view - `javax.swing.text.View`"
  ([^javax.swing.text.ViewFactory this ^javax.swing.text.Element elem]
    (-> this (.create elem))))

