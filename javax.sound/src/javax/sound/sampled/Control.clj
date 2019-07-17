(ns javax.sound.sampled.Control
  "Lines often have a set of controls, such as gain and pan, that affect
  the audio signal passing through the line.  Java Sound's Line objects
  let you obtain a particular control object by passing its class as the
  argument to a getControl method.

  Because the various types of controls have different purposes and features,
  all of their functionality is accessed from the subclasses that define
  each kind of control."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled Control]))

(defn get-type
  "Obtains the control's type.

  returns: the control's type. - `javax.sound.sampled.Control.Type`"
  ([this]
    (-> this (.getType))))

(defn to-string
  "Obtains a String describing the control type and its current state.

  returns: a String representation of the Control. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

