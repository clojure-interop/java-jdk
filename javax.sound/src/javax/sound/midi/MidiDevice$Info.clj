(ns javax.sound.midi.MidiDevice$Info
  "A MidiDevice.Info object contains assorted
  data about a MidiDevice, including its
  name, the company who created it, and descriptive text."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MidiDevice$Info]))

(defn equals
  "Reports whether two objects are equal.
   Returns true if the objects are identical.

  obj - the reference object with which to compare this object - `java.lang.Object`

  returns: true if this object is the same as the
   obj argument; false otherwise - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Finalizes the hashcode method.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn get-name
  "Obtains the name of the device.

  returns: a string containing the device's name - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn get-vendor
  "Obtains the name of the company who supplies the device.

  returns: device the vendor's name - `java.lang.String`"
  ([this]
    (-> this (.getVendor))))

(defn get-description
  "Obtains the description of the device.

  returns: a description of the device - `java.lang.String`"
  ([this]
    (-> this (.getDescription))))

(defn get-version
  "Obtains the version of the device.

  returns: textual version information for the device. - `java.lang.String`"
  ([this]
    (-> this (.getVersion))))

(defn to-string
  "Provides a string representation of the device information.

  returns: a description of the info object - `java.lang.String`"
  ([this]
    (-> this (.toString))))

