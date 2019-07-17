(ns javax.sound.midi.Soundbank
  "A Soundbank contains a set of Instruments
  that can be loaded into a Synthesizer.
  Note that a Java Sound Soundbank is different from a MIDI bank.
  MIDI permits up to 16383 banks, each containing up to 128 instruments
  (also sometimes called programs, patches, or timbres).
  However, a Soundbank can contain 16383 times 128 instruments,
  because the instruments within a Soundbank are indexed by both
  a MIDI program number and a MIDI bank number (via a Patch
  object). Thus, a Soundbank can be thought of as a collection
  of MIDI banks.

  Soundbank includes methods that return String
  objects containing the sound bank's name, manufacturer, version number, and
  description.  The precise content and format of these strings is left
  to the implementor.

  Different synthesizers use a variety of synthesis techniques.  A common
  one is wavetable synthesis, in which a segment of recorded sound is
  played back, often with looping and pitch change.  The Downloadable Sound
  (DLS) format uses segments of recorded sound, as does the Headspace Engine.
  Soundbanks and Instruments that are based on
  wavetable synthesis (or other uses of stored sound recordings) should
  typically implement the getResources()
  method to provide access to these recorded segments.  This is optional,
  however; the method can return an zero-length array if the synthesis technique
  doesn't use sampled sound (FM synthesis and physical modeling are examples
  of such techniques), or if it does but the implementor chooses not to make the
  samples accessible."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi Soundbank]))

(defn get-name
  "Obtains the name of the sound bank.

  returns: a String naming the sound bank - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn get-version
  "Obtains the version string for the sound bank.

  returns: a String that indicates the sound bank's version - `java.lang.String`"
  ([this]
    (-> this (.getVersion))))

(defn get-vendor
  "Obtains a string naming the company that provides the
   sound bank

  returns: the vendor string - `java.lang.String`"
  ([this]
    (-> this (.getVendor))))

(defn get-description
  "Obtains a textual description of the sound bank, suitable for display.

  returns: a String that describes the sound bank - `java.lang.String`"
  ([this]
    (-> this (.getDescription))))

(defn get-resources
  "Extracts a list of non-Instrument resources contained in the sound bank.

  returns: an array of resources, excluding instruments.  If the sound bank contains
   no resources (other than instruments), returns an array of length 0. - `javax.sound.midi.SoundbankResource[]`"
  ([this]
    (-> this (.getResources))))

(defn get-instruments
  "Obtains a list of instruments contained in this sound bank.

  returns: an array of the Instruments in this
   SoundBank
   If the sound bank contains no instruments, returns an array of length 0. - `javax.sound.midi.Instrument[]`"
  ([this]
    (-> this (.getInstruments))))

(defn get-instrument
  "Obtains an Instrument from the given Patch.

  patch - a Patch object specifying the bank index and program change number - `javax.sound.midi.Patch`

  returns: the requested instrument, or null if the
   sound bank doesn't contain that instrument - `javax.sound.midi.Instrument`"
  ([this patch]
    (-> this (.getInstrument patch))))

