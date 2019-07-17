(ns javax.xml.stream.events.Comment
  "An interface for comment events"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events Comment]))

(defn get-text
  "Return the string data of the comment, returns empty string if it
   does not exist

  returns: `java.lang.String`"
  (^java.lang.String [^javax.xml.stream.events.Comment this]
    (-> this (.getText))))

