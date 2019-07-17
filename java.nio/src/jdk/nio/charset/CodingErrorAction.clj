(ns jdk.nio.charset.CodingErrorAction
  "A typesafe enumeration for coding-error actions.

   Instances of this class are used to specify how malformed-input and
  unmappable-character errors are to be handled by charset decoders and encoders."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset CodingErrorAction]))

(def *-ignore
  "Static Constant.

  Action indicating that a coding error is to be handled by dropping the
   erroneous input and resuming the coding operation.

  type: java.nio.charset.CodingErrorAction"
  CodingErrorAction/IGNORE)

(def *-replace
  "Static Constant.

  Action indicating that a coding error is to be handled by dropping the
   erroneous input, appending the coder's replacement value to the output
   buffer, and resuming the coding operation.

  type: java.nio.charset.CodingErrorAction"
  CodingErrorAction/REPLACE)

(def *-report
  "Static Constant.

  Action indicating that a coding error is to be reported, either by
   returning a CoderResult object or by throwing a CharacterCodingException, whichever is appropriate for the method
   implementing the coding process.

  type: java.nio.charset.CodingErrorAction"
  CodingErrorAction/REPORT)

(defn to-string
  "Returns a string describing this action.

  returns: A descriptive string - `java.lang.String`"
  (^java.lang.String [^java.nio.charset.CodingErrorAction this]
    (-> this (.toString))))

