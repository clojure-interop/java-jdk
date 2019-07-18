(ns javax.annotation.processing.Completion
  "A suggested completion for an
  annotation.  A completion is text meant to be inserted into a
  program as part of an annotation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.annotation.processing Completion]))

(defn get-value
  "Returns the text of the suggested completion.

  returns: the text of the suggested completion. - `java.lang.String`"
  (^java.lang.String [^Completion this]
    (-> this (.getValue))))

(defn get-message
  "Returns an informative message about the completion.

  returns: an informative message about the completion. - `java.lang.String`"
  (^java.lang.String [^Completion this]
    (-> this (.getMessage))))

