(ns jdk.text.MessageFormat$Field
  "Defines constants that are used as attribute keys in the
  AttributedCharacterIterator returned
  from MessageFormat.formatToCharacterIterator."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text MessageFormat$Field]))

(def *-argument
  "Static Constant.

  Constant identifying a portion of a message that was generated
   from an argument passed into formatToCharacterIterator.
   The value associated with the key will be an Integer
   indicating the index in the arguments array of the
   argument from which the text was generated.

  type: java.text.MessageFormat$Field"
  MessageFormat$Field/ARGUMENT)

