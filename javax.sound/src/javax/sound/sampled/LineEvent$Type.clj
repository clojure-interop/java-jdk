(ns javax.sound.sampled.LineEvent$Type
  "The LineEvent.Type inner class identifies what kind of event occurred on a line.
  Static instances are provided for the common types (OPEN, CLOSE, START, and STOP)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled LineEvent$Type]))

(def *-open
  "Static Constant.

  A type of event that is sent when a line opens, reserving system
   resources for itself.

  type: javax.sound.sampled.LineEvent.Type"
  LineEvent$Type/OPEN)

(def *-close
  "Static Constant.

  A type of event that is sent when a line closes, freeing the system
   resources it had obtained when it was opened.

  type: javax.sound.sampled.LineEvent.Type"
  LineEvent$Type/CLOSE)

(def *-start
  "Static Constant.

  A type of event that is sent when a line begins to engage in active
   input or output of audio data in response to a
   start request.

  type: javax.sound.sampled.LineEvent.Type"
  LineEvent$Type/START)

(def *-stop
  "Static Constant.

  A type of event that is sent when a line ceases active input or output
   of audio data in response to a stop request,
   or because the end of media has been reached.

  type: javax.sound.sampled.LineEvent.Type"
  LineEvent$Type/STOP)

(defn equals
  "Indicates whether the specified object is equal to this event type,
   returning true if the objects are identical.

  obj - the reference object with which to compare - `java.lang.Object`

  returns: true if this event type is the same as
   obj; false otherwise - `boolean`"
  ([^javax.sound.sampled.LineEvent$Type this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Finalizes the hashcode method.

  returns: a hash code value for this object. - `int`"
  ([^javax.sound.sampled.LineEvent$Type this]
    (-> this (.hashCode))))

(defn to-string
  "Returns the type name as the string representation.

  returns: a string representation of the object. - `java.lang.String`"
  ([^javax.sound.sampled.LineEvent$Type this]
    (-> this (.toString))))

