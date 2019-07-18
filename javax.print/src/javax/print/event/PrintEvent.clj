(ns javax.print.event.PrintEvent
  "Class PrintEvent is the super class of all Print Service API events."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.event PrintEvent]))

(defn ->print-event
  "Constructor.

  Constructs a PrintEvent object.

  source - is the source of the event - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if source is null."
  (^PrintEvent [^java.lang.Object source]
    (new PrintEvent source)))

(defn to-string
  "Description copied from class: EventObject

  returns: a message describing the event - `java.lang.String`"
  (^java.lang.String [^PrintEvent this]
    (-> this (.toString))))

