(ns javax.sound.sampled.BooleanControl
  "A BooleanControl provides the ability to switch between
  two possible settings that affect a line's audio.  The settings are boolean
  values (true and false).  A graphical user interface
  might represent the control by a two-state button, an on/off switch, two
  mutually exclusive buttons, or a checkbox (among other possibilities).
  For example, depressing a button might activate a
  MUTE control to silence
  the line's audio.

  As with other Control subclasses, a method is
  provided that returns string labels for the values, suitable for
  display in the user interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled BooleanControl]))

(defn set-value
  "Sets the current value for the control.  The default
   implementation simply sets the value as indicated.
   Some controls require that their line be open before they can be affected
   by setting a value.

  value - desired new value. - `boolean`"
  ([^javax.sound.sampled.BooleanControl this ^Boolean value]
    (-> this (.setValue value))))

(defn get-value?
  "Obtains this control's current value.

  returns: current value. - `boolean`"
  ([^javax.sound.sampled.BooleanControl this]
    (-> this (.getValue))))

(defn get-state-label
  "Obtains the label for the specified state.

  state - the state whose label will be returned - `boolean`

  returns: the label for the specified state, such as `true` or `on`
   for true, or `false` or `off` for false. - `java.lang.String`"
  ([^javax.sound.sampled.BooleanControl this ^Boolean state]
    (-> this (.getStateLabel state))))

(defn to-string
  "Provides a string representation of the control

  returns: a string description - `java.lang.String`"
  ([^javax.sound.sampled.BooleanControl this]
    (-> this (.toString))))

