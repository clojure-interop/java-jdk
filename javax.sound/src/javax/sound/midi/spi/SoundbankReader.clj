(ns javax.sound.midi.spi.SoundbankReader
  "A SoundbankReader supplies soundbank file-reading services. Concrete
  subclasses of SoundbankReader parse a given soundbank file, producing
  a Soundbank object that can be loaded into a
  Synthesizer."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi.spi SoundbankReader]))

(defn ->soundbank-reader
  "Constructor."
  ([]
    (new SoundbankReader )))

(defn get-soundbank
  "Obtains a soundbank object from the URL provided.

  url - URL representing the soundbank. - `java.net.URL`

  returns: soundbank object - `javax.sound.midi.Soundbank`

  throws: javax.sound.midi.InvalidMidiDataException - if the URL does not point to valid MIDI soundbank data recognized by this soundbank reader"
  ([this url]
    (-> this (.getSoundbank url))))

