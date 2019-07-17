(ns jdk.nio.charset.CharacterCodingException
  "Checked exception thrown when a character encoding
  or decoding error occurs."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset CharacterCodingException]))

(defn ->character-coding-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new CharacterCodingException )))

