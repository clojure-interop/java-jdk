(ns javax.annotation.processing.Completions
  "Utility class for assembling Completion objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.annotation.processing Completions]))

(defn *of
  "Returns a completion of the value and message.

  value - the text of the completion - `java.lang.String`
  message - a message about the completion - `java.lang.String`

  returns: a completion of the provided value and message - `javax.annotation.processing.Completion`"
  ([value message]
    (Completions/of value message))
  ([value]
    (Completions/of value)))

