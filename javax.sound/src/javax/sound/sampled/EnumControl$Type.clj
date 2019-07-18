(ns javax.sound.sampled.EnumControl$Type
  "An instance of the EnumControl.Type inner class identifies one kind of
  enumerated control.  Static instances are provided for the
  common types."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled EnumControl$Type]))

(def *-reverb
  "Static Constant.

  Represents a control over a set of possible reverberation settings.
   Each reverberation setting is described by an instance of the
   ReverbType class.  (To access these settings,
   invoke EnumControl.getValues() on an
   enumerated control of type REVERB.)

  type: javax.sound.sampled.EnumControl$Type"
  EnumControl$Type/REVERB)

