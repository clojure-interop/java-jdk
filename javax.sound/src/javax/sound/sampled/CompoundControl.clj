(ns javax.sound.sampled.CompoundControl
  "A CompoundControl, such as a graphic equalizer, provides control
  over two or more related properties, each of which is itself represented as
  a Control."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled CompoundControl]))

(defn get-member-controls
  "Returns the set of member controls that comprise the compound control.

  returns: the set of member controls. - `javax.sound.sampled.Control[]`"
  ([^javax.sound.sampled.CompoundControl this]
    (-> this (.getMemberControls))))

(defn to-string
  "Provides a string representation of the control

  returns: a string description - `java.lang.String`"
  (^java.lang.String [^javax.sound.sampled.CompoundControl this]
    (-> this (.toString))))

