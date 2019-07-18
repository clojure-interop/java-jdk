(ns javax.sound.sampled.AudioFileFormat
  "An instance of the AudioFileFormat class describes
  an audio file, including the file type, the file's length in bytes,
  the length in sample frames of the audio data contained in the file,
  and the format of the audio data.

  The AudioSystem class includes methods for determining the format
  of an audio file, obtaining an audio input stream from an audio file, and
  writing an audio file from an audio input stream.

  An AudioFileFormat object can
  include a set of properties. A property is a pair of key and value:
  the key is of type String, the associated property
  value is an arbitrary object.
  Properties specify additional informational
  meta data (like a author, copyright, or file duration).
  Properties are optional information, and file reader and file
  writer implementations are not required to provide or
  recognize properties.

  The following table lists some common properties that should
  be used in implementations:


   Audio File Format Properties

    Property key
    Value type
    Description


    `duration`
    Long
    playback duration of the file in microseconds


    `author`
    String
    name of the author of this file


    `title`
    String
    title of this file


    `copyright`
    String
    copyright message


    `date`
    Date
    date of the recording or release


    `comment`
    String
    an arbitrary text"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled AudioFileFormat]))

(defn ->audio-file-format
  "Constructor.

  Construct an audio file format object with a set of
   defined properties.
   This public constructor may be used by applications to describe the
   properties of a requested audio file. The properties map
   will be copied to prevent any changes to it.

  type - the type of the audio file - `javax.sound.sampled.AudioFileFormat$Type`
  format - the format of the audio data contained in the file - `javax.sound.sampled.AudioFormat`
  frame-length - the audio data length in sample frames, or AudioSystem.NOT_SPECIFIED - `int`
  properties - a Map<String,Object> object with properties - `java.util.Map`"
  (^AudioFileFormat [^javax.sound.sampled.AudioFileFormat$Type type ^javax.sound.sampled.AudioFormat format ^Integer frame-length ^java.util.Map properties]
    (new AudioFileFormat type format frame-length properties))
  (^AudioFileFormat [^javax.sound.sampled.AudioFileFormat$Type type ^javax.sound.sampled.AudioFormat format ^Integer frame-length]
    (new AudioFileFormat type format frame-length)))

(defn get-type
  "Obtains the audio file type, such as WAVE or AU.

  returns: the audio file type - `javax.sound.sampled.AudioFileFormat$Type`"
  (^javax.sound.sampled.AudioFileFormat$Type [^AudioFileFormat this]
    (-> this (.getType))))

(defn get-byte-length
  "Obtains the size in bytes of the entire audio file (not just its audio data).

  returns: the audio file length in bytes - `int`"
  (^Integer [^AudioFileFormat this]
    (-> this (.getByteLength))))

(defn get-format
  "Obtains the format of the audio data contained in the audio file.

  returns: the audio data format - `javax.sound.sampled.AudioFormat`"
  (^javax.sound.sampled.AudioFormat [^AudioFileFormat this]
    (-> this (.getFormat))))

(defn get-frame-length
  "Obtains the length of the audio data contained in the file, expressed in sample frames.

  returns: the number of sample frames of audio data in the file - `int`"
  (^Integer [^AudioFileFormat this]
    (-> this (.getFrameLength))))

(defn properties
  "Obtain an unmodifiable map of properties.
   The concept of properties is further explained in
   the class description.

  returns: a Map<String,Object> object containing
           all properties. If no properties are recognized, an empty map is
           returned. - `java.util.Map<java.lang.String,java.lang.Object>`"
  (^java.util.Map [^AudioFileFormat this]
    (-> this (.properties))))

(defn get-property
  "Obtain the property value specified by the key.
   The concept of properties is further explained in
   the class description.

   If the specified property is not defined for a
   particular file format, this method returns
   null.

  key - the key of the desired property - `java.lang.String`

  returns: the value of the property with the specified key,
           or null if the property does not exist. - `java.lang.Object`"
  (^java.lang.Object [^AudioFileFormat this ^java.lang.String key]
    (-> this (.getProperty key))))

(defn to-string
  "Provides a string representation of the file format.

  returns: the file format as a string - `java.lang.String`"
  (^java.lang.String [^AudioFileFormat this]
    (-> this (.toString))))

