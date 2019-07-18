(ns javax.sound.sampled.spi.AudioFileWriter
  "Provider for audio file writing services.  Classes providing concrete
  implementations can write one or more types of audio file from an audio
  stream."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled.spi AudioFileWriter]))

(defn ->audio-file-writer
  "Constructor."
  (^AudioFileWriter []
    (new AudioFileWriter )))

(defn get-audio-file-types
  "Obtains the file types that this audio file writer can write from the
   audio input stream specified.

  stream - the audio input stream for which audio file type support is queried - `javax.sound.sampled.AudioInputStream`

  returns: array of file types.  If no file types are supported,
   an array of length 0 is returned. - `javax.sound.sampled.AudioFileFormat$Type[]`"
  ([^AudioFileWriter this ^javax.sound.sampled.AudioInputStream stream]
    (-> this (.getAudioFileTypes stream)))
  ([^AudioFileWriter this]
    (-> this (.getAudioFileTypes))))

(defn file-type-supported?
  "Indicates whether an audio file of the type specified can be written
   from the audio input stream indicated.

  file-type - file type for which write capabilities are queried - `javax.sound.sampled.AudioFileFormat$Type`
  stream - for which file writing support is queried - `javax.sound.sampled.AudioInputStream`

  returns: true if the file type is supported for this audio input stream,
   otherwise false - `boolean`"
  (^Boolean [^AudioFileWriter this ^javax.sound.sampled.AudioFileFormat$Type file-type ^javax.sound.sampled.AudioInputStream stream]
    (-> this (.isFileTypeSupported file-type stream)))
  (^Boolean [^AudioFileWriter this ^javax.sound.sampled.AudioFileFormat$Type file-type]
    (-> this (.isFileTypeSupported file-type))))

(defn write
  "Writes a stream of bytes representing an audio file of the file type
   indicated to the output stream provided.  Some file types require that
   the length be written into the file header, and cannot be written from
   start to finish unless the length is known in advance.  An attempt
   to write such a file type will fail with an IOException if the length in
   the audio file format is
   AudioSystem.NOT_SPECIFIED.

  stream - the audio input stream containing audio data to be written to the output stream - `javax.sound.sampled.AudioInputStream`
  file-type - file type to be written to the output stream - `javax.sound.sampled.AudioFileFormat$Type`
  out - stream to which the file data should be written - `java.io.OutputStream`

  returns: the number of bytes written to the output stream - `int`

  throws: java.io.IOException - if an I/O exception occurs"
  (^Integer [^AudioFileWriter this ^javax.sound.sampled.AudioInputStream stream ^javax.sound.sampled.AudioFileFormat$Type file-type ^java.io.OutputStream out]
    (-> this (.write stream file-type out))))

