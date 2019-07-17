(ns javax.sound.sampled.AudioFileFormat$Type
  "An instance of the Type class represents one of the
  standard types of audio file.  Static instances are provided for the
  common types."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled AudioFileFormat$Type]))

(defn ->type
  "Constructor.

  Constructs a file type.

  name - the string that names the file type - `java.lang.String`
  extension - the string that commonly marks the file type without leading dot. - `java.lang.String`"
  ([^java.lang.String name ^java.lang.String extension]
    (new AudioFileFormat$Type name extension)))

(def *-wave
  "Static Constant.

  Specifies a WAVE file.

  type: javax.sound.sampled.AudioFileFormat.Type"
  AudioFileFormat$Type/WAVE)

(def *-au
  "Static Constant.

  Specifies an AU file.

  type: javax.sound.sampled.AudioFileFormat.Type"
  AudioFileFormat$Type/AU)

(def *-aiff
  "Static Constant.

  Specifies an AIFF file.

  type: javax.sound.sampled.AudioFileFormat.Type"
  AudioFileFormat$Type/AIFF)

(def *-aifc
  "Static Constant.

  Specifies an AIFF-C file.

  type: javax.sound.sampled.AudioFileFormat.Type"
  AudioFileFormat$Type/AIFC)

(def *-snd
  "Static Constant.

  Specifies a SND file.

  type: javax.sound.sampled.AudioFileFormat.Type"
  AudioFileFormat$Type/SND)

(defn equals
  "Finalizes the equals method

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^javax.sound.sampled.AudioFileFormat$Type this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Finalizes the hashCode method

  returns: a hash code value for this object. - `int`"
  (^Integer [^javax.sound.sampled.AudioFileFormat$Type this]
    (-> this (.hashCode))))

(defn to-string
  "Provides the file type's name as the String representation
   of the file type.

  returns: the file type's name - `java.lang.String`"
  (^java.lang.String [^javax.sound.sampled.AudioFileFormat$Type this]
    (-> this (.toString))))

(defn get-extension
  "Obtains the common file name extension for this file type.

  returns: file type extension - `java.lang.String`"
  (^java.lang.String [^javax.sound.sampled.AudioFileFormat$Type this]
    (-> this (.getExtension))))

