(ns javax.crypto.spec.PSource$PSpecified
  "This class is used to explicitly specify the value for
  encoding input P in OAEP Padding."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec PSource$PSpecified]))

(defn ->p-specified
  "Constructor.

  Constructs the source explicitly with the specified
   value p as the encoding input P.
   Note:

  p - the value of the encoding input. The contents of the array are copied to protect against subsequent modification. - `byte[]`

  throws: java.lang.NullPointerException - if p is null."
  ([p]
    (new PSource$PSpecified p)))

(def *-default
  "Static Constant.

  The encoding input P whose value equals byte[0].

  type: javax.crypto.spec.PSource.PSpecified"
  PSource$PSpecified/DEFAULT)

(defn get-value
  "Returns the value of encoding input P.

  returns: the value of encoding input P. A new array is
   returned each time this method is called. - `byte[]`"
  ([^javax.crypto.spec.PSource$PSpecified this]
    (-> this (.getValue))))

