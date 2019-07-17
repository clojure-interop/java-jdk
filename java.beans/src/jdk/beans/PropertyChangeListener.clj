(ns jdk.beans.PropertyChangeListener
  "A `PropertyChange` event gets fired whenever a bean changes a `bound`
  property.  You can register a PropertyChangeListener with a source
  bean so as to be notified of any bound property updates."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans PropertyChangeListener]))

(defn property-change
  "This method gets called when a bound property is changed.

  evt - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([^java.beans.PropertyChangeListener this ^java.beans.PropertyChangeEvent evt]
    (-> this (.propertyChange evt))))

