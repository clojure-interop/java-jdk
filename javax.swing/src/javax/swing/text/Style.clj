(ns javax.swing.text.Style
  "A collection of attributes to associate with an element in a document.
  Since these are typically used to associate character and paragraph
  styles with the element, operations for this are provided.  Other
  customized attributes that get associated with the element will
  effectively be name-value pairs that live in a hierarchy and if a name
  (key) is not found locally, the request is forwarded to the parent.
  Commonly used attributes are separated out to facilitate alternative
  implementations that are more efficient."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Style]))

(defn get-name
  "Fetches the name of the style.   A style is not required to be named,
   so null is returned if there is no name
   associated with the style.

  returns: the name - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn add-change-listener
  "Adds a listener to track whenever an attribute
   has been changed.

  l - the change listener - `javax.swing.event.ChangeListener`"
  ([this l]
    (-> this (.addChangeListener l))))

(defn remove-change-listener
  "Removes a listener that was tracking attribute changes.

  l - the change listener - `javax.swing.event.ChangeListener`"
  ([this l]
    (-> this (.removeChangeListener l))))

