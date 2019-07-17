(ns javax.sound.sampled.spi.AudioFileReader
  "Provider for audio file reading services.  Classes providing concrete
  implementations can parse the format information from one or more types of
  audio file, and can produce audio input streams from files of these types."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled.spi AudioFileReader]))

(defn ->audio-file-reader
  "Constructor."
  ([]
    (new AudioFileReader )))

(defn get-audio-file-format
  "Obtains the audio file format of the input stream provided.  The stream must
   point to valid audio file data.  In general, audio file readers may
   need to read some data from the stream before determining whether they
   support it.  These parsers must
   be able to mark the stream, read enough data to determine whether they
   support the stream, and, if not, reset the stream's read pointer to its original
   position.  If the input stream does not support this, this method may fail
   with an IOException.

  stream - the input stream from which file format information should be extracted - `java.io.InputStream`

  returns: an AudioFileFormat object describing the audio file format - `javax.sound.sampled.AudioFileFormat`

  throws: javax.sound.sampled.UnsupportedAudioFileException - if the stream does not point to valid audio file data recognized by the system"
  ([^javax.sound.sampled.spi.AudioFileReader this ^java.io.InputStream stream]
    (-> this (.getAudioFileFormat stream))))

(defn get-audio-input-stream
  "Obtains an audio input stream from the input stream provided.  The stream must
   point to valid audio file data.  In general, audio file readers may
   need to read some data from the stream before determining whether they
   support it.  These parsers must
   be able to mark the stream, read enough data to determine whether they
   support the stream, and, if not, reset the stream's read pointer to its original
   position.  If the input stream does not support this, this method may fail
   with an IOException.

  stream - the input stream from which the AudioInputStream should be constructed - `java.io.InputStream`

  returns: an AudioInputStream object based on the audio file data contained
   in the input stream. - `javax.sound.sampled.AudioInputStream`

  throws: javax.sound.sampled.UnsupportedAudioFileException - if the stream does not point to valid audio file data recognized by the system"
  ([^javax.sound.sampled.spi.AudioFileReader this ^java.io.InputStream stream]
    (-> this (.getAudioInputStream stream))))

