(ns javax.sound.sampled.BooleanControl$Type
  "An instance of the BooleanControl.Type class identifies one kind of
  boolean control.  Static instances are provided for the
  common types."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled BooleanControl$Type]))

(def *-mute
  "Static Constant.

  Represents a control for the mute status of a line.
   Note that mute status does not affect gain.

  type: javax.sound.sampled.BooleanControl.Type"
  BooleanControl$Type/MUTE)

(def *-apply-reverb
  "Static Constant.

  Represents a control for whether reverberation is applied
   to a line.  Note that the status of this control not affect
   the reverberation settings for a line, but does affect whether
   these settings are used.

  type: javax.sound.sampled.BooleanControl.Type"
  BooleanControl$Type/APPLY_REVERB)

