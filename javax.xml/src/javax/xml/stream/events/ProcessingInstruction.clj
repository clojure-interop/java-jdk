(ns javax.xml.stream.events.ProcessingInstruction
  "An interface that describes the data found in processing instructions"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events ProcessingInstruction]))

(defn get-target
  "The target section of the processing instruction

  returns: the String value of the PI or null - `java.lang.String`"
  ([^. this]
    (-> this (.getTarget))))

(defn get-data
  "The data section of the processing instruction

  returns: the String value of the PI's data or null - `java.lang.String`"
  ([^. this]
    (-> this (.getData))))

