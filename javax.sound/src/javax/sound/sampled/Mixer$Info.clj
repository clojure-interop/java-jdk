(ns javax.sound.sampled.Mixer$Info
  "The Mixer.Info class represents information about an audio mixer,
  including the product's name, version, and vendor, along with a textual
  description.  This information may be retrieved through the
  getMixerInfo
  method of the Mixer interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled Mixer$Info]))

(defn equals
  "Indicates whether two info objects are equal, returning true if
   they are identical.

  obj - the reference object with which to compare this info object - `java.lang.Object`

  returns: true if this info object is the same as the
   obj argument; false otherwise - `boolean`"
  (^Boolean [^Mixer$Info this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Finalizes the hashcode method.

  returns: the hashcode for this object - `int`"
  (^Integer [^Mixer$Info this]
    (-> this (.hashCode))))

(defn get-name
  "Obtains the name of the mixer.

  returns: a string that names the mixer - `java.lang.String`"
  (^java.lang.String [^Mixer$Info this]
    (-> this (.getName))))

(defn get-vendor
  "Obtains the vendor of the mixer.

  returns: a string that names the mixer's vendor - `java.lang.String`"
  (^java.lang.String [^Mixer$Info this]
    (-> this (.getVendor))))

(defn get-description
  "Obtains the description of the mixer.

  returns: a textual description of the mixer - `java.lang.String`"
  (^java.lang.String [^Mixer$Info this]
    (-> this (.getDescription))))

(defn get-version
  "Obtains the version of the mixer.

  returns: textual version information for the mixer - `java.lang.String`"
  (^java.lang.String [^Mixer$Info this]
    (-> this (.getVersion))))

(defn to-string
  "Provides a string representation of the mixer info.

  returns: a string describing the info object - `java.lang.String`"
  (^java.lang.String [^Mixer$Info this]
    (-> this (.toString))))

