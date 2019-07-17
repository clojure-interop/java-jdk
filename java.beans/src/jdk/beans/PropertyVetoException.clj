(ns jdk.beans.PropertyVetoException
  "A PropertyVetoException is thrown when a proposed change to a
  property represents an unacceptable value."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans PropertyVetoException]))

(defn ->property-veto-exception
  "Constructor.

  Constructs a PropertyVetoException with a
   detailed message.

  mess - Descriptive message - `java.lang.String`
  evt - A PropertyChangeEvent describing the vetoed change. - `java.beans.PropertyChangeEvent`"
  ([mess evt]
    (new PropertyVetoException mess evt)))

(defn get-property-change-event
  "Gets the vetoed PropertyChangeEvent.

  returns: A PropertyChangeEvent describing the vetoed change. - `java.beans.PropertyChangeEvent`"
  ([this]
    (-> this (.getPropertyChangeEvent))))

