(ns javax.sound.sampled.EnumControl
  "A EnumControl provides control over a set of
  discrete possible values, each represented by an object.  In a
  graphical user interface, such a control might be represented
  by a set of buttons, each of which chooses one value or setting.  For
  example, a reverb control might provide several preset reverberation
  settings, instead of providing continuously adjustable parameters
  of the sort that would be represented by FloatControl
  objects.

  Controls that provide a choice between only two settings can often be implemented
  instead as a BooleanControl, and controls that provide
  a set of values along some quantifiable dimension might be implemented
  instead as a FloatControl with a coarse resolution.
  However, a key feature of EnumControl is that the returned values
  are arbitrary objects, rather than numerical or boolean values.  This means that each
  returned object can provide further information.  As an example, the settings
  of a REVERB control are instances of
  ReverbType that can be queried for the parameter values
  used for each setting."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled EnumControl]))

(defn set-value
  "Sets the current value for the control.  The default implementation
   simply sets the value as indicated.  If the value indicated is not
   supported, an IllegalArgumentException is thrown.
   Some controls require that their line be open before they can be affected
   by setting a value.

  value - the desired new value - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the value indicated does not fall within the allowable range"
  ([^javax.sound.sampled.EnumControl this ^java.lang.Object value]
    (-> this (.setValue value))))

(defn get-value
  "Obtains this control's current value.

  returns: the current value - `java.lang.Object`"
  ([^javax.sound.sampled.EnumControl this]
    (-> this (.getValue))))

(defn get-values
  "Returns the set of possible values for this control.

  returns: the set of possible values - `java.lang.Object[]`"
  ([^javax.sound.sampled.EnumControl this]
    (-> this (.getValues))))

(defn to-string
  "Provides a string representation of the control.

  returns: a string description - `java.lang.String`"
  ([^javax.sound.sampled.EnumControl this]
    (-> this (.toString))))

