(ns javax.sound.sampled.UnsupportedAudioFileException
  "An UnsupportedAudioFileException is an exception indicating that an
  operation failed because a file did not contain valid data of a recognized file
  type and format."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled UnsupportedAudioFileException]))

(defn ->unsupported-audio-file-exception
  "Constructor.

  Constructs a UnsupportedAudioFileException that has
   the specified detail message.

  message - a string containing the error detail message - `java.lang.String`"
  (^UnsupportedAudioFileException [^java.lang.String message]
    (new UnsupportedAudioFileException message))
  (^UnsupportedAudioFileException []
    (new UnsupportedAudioFileException )))

