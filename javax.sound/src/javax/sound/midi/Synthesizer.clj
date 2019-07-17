(ns javax.sound.midi.Synthesizer
  "A Synthesizer generates sound.  This usually happens when one of
  the Synthesizer's MidiChannel objects receives a
  noteOn message, either
  directly or via the Synthesizer object.
  Many Synthesizers support Receivers, through which
  MIDI events can be delivered to the Synthesizer.
  In such cases, the Synthesizer typically responds by sending
  a corresponding message to the appropriate MidiChannel, or by
  processing the event itself if the event isn't one of the MIDI channel
  messages.

  The Synthesizer interface includes methods for loading and
  unloading instruments from soundbanks.  An instrument is a specification for synthesizing a
  certain type of sound, whether that sound emulates a traditional instrument or is
  some kind of sound effect or other imaginary sound. A soundbank is a collection of instruments, organized
  by bank and program number (via the instrument's Patch object).
  Different Synthesizer classes might implement different sound-synthesis
  techniques, meaning that some instruments and not others might be compatible with a
  given synthesizer.
  Also, synthesizers may have a limited amount of memory for instruments, meaning
  that not every soundbank and instrument can be used by every synthesizer, even if
  the synthesis technique is compatible.
  To see whether the instruments from
  a certain soundbank can be played by a given synthesizer, invoke the
  isSoundbankSupported method of
  Synthesizer.

  `Loading` an instrument means that that instrument becomes available for
  synthesizing notes.  The instrument is loaded into the bank and
  program location specified by its Patch object.  Loading does
  not necessarily mean that subsequently played notes will immediately have
  the sound of this newly loaded instrument.  For the instrument to play notes,
  one of the synthesizer's MidiChannel objects must receive (or have received)
  a program-change message that causes that particular instrument's
  bank and program number to be selected."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi Synthesizer]))

(defn unload-all-instruments
  "Unloads all instruments contained in the specified Soundbank.

  soundbank - soundbank containing instruments to unload - `javax.sound.midi.Soundbank`

  throws: java.lang.IllegalArgumentException - thrown if the soundbank is not supported."
  ([^javax.sound.midi.Synthesizer this ^javax.sound.midi.Soundbank soundbank]
    (-> this (.unloadAllInstruments soundbank))))

(defn get-default-soundbank
  "Obtains the default soundbank for the synthesizer, if one exists.
   (Some synthesizers provide a default or built-in soundbank.)
   If a synthesizer doesn't have a default soundbank, instruments must
   be loaded explicitly from an external soundbank.

  returns: default soundbank, or null if one does not exist. - `javax.sound.midi.Soundbank`"
  (^javax.sound.midi.Soundbank [^javax.sound.midi.Synthesizer this]
    (-> this (.getDefaultSoundbank))))

(defn load-all-instruments
  "Loads onto the Synthesizer all instruments contained
   in the specified Soundbank.

  soundbank - the Soundbank whose are instruments are to be loaded - `javax.sound.midi.Soundbank`

  returns: true if the instruments are all successfully loaded (or
   already had been), false if any instrument could not be
   loaded (for example, if the Synthesizer had insufficient memory) - `boolean`

  throws: java.lang.IllegalArgumentException - if the requested soundbank is incompatible with this synthesizer."
  (^Boolean [^javax.sound.midi.Synthesizer this ^javax.sound.midi.Soundbank soundbank]
    (-> this (.loadAllInstruments soundbank))))

(defn load-instruments
  "Loads the instruments referenced by the specified patches, from the
   specified Soundbank.  Each of the Patch objects
   indicates a bank and program number; the Instrument that
   has the matching Patch is loaded into that bank and program
   location.

  soundbank - the Soundbank containing the instruments to load - `javax.sound.midi.Soundbank`
  patch-list - list of patches for which instruments should be loaded - `javax.sound.midi.Patch[]`

  returns: true if the instruments are all successfully loaded (or
   already had been), false if any instrument could not be
   loaded (for example, if the Synthesizer had insufficient memory) - `boolean`

  throws: java.lang.IllegalArgumentException - thrown if the soundbank is not supported."
  (^Boolean [^javax.sound.midi.Synthesizer this ^javax.sound.midi.Soundbank soundbank patch-list]
    (-> this (.loadInstruments soundbank patch-list))))

(defn get-max-polyphony
  "Obtains the maximum number of notes that this synthesizer can sound simultaneously.

  returns: the maximum number of simultaneous notes - `int`"
  (^Integer [^javax.sound.midi.Synthesizer this]
    (-> this (.getMaxPolyphony))))

(defn get-available-instruments
  "Obtains a list of instruments that come with the synthesizer.  These
   instruments might be built into the synthesizer, or they might be
   part of a default soundbank provided with the synthesizer, etc.

   Note that you don't use this method  to find out which instruments are
   currently loaded onto the synthesizer; for that purpose, you use
   getLoadedInstruments().
   Nor does the method indicate all the instruments that can be loaded onto
   the synthesizer; it only indicates the subset that come with the synthesizer.
   To learn whether another instrument can be loaded, you can invoke
   isSoundbankSupported(), and if the instrument's
   Soundbank is supported, you can try loading the instrument.

  returns: list of available instruments. If the synthesizer
   has no instruments coming with it, an array of length 0 is returned. - `javax.sound.midi.Instrument[]`"
  ([^javax.sound.midi.Synthesizer this]
    (-> this (.getAvailableInstruments))))

(defn get-voice-status
  "Obtains the current status of the voices produced by this synthesizer.
   If this class of Synthesizer does not provide voice
   information, the returned array will always be of length 0.  Otherwise,
   its length is always equal to the total number of voices, as returned by
   getMaxPolyphony().  (See the VoiceStatus class
   description for an explanation of synthesizer voices.)

  returns: an array of VoiceStatus objects that supply
   information about the corresponding synthesizer voices - `javax.sound.midi.VoiceStatus[]`"
  ([^javax.sound.midi.Synthesizer this]
    (-> this (.getVoiceStatus))))

(defn soundbank-supported?
  "Informs the caller whether this synthesizer is capable of loading
   instruments from the specified soundbank.
   If the soundbank is unsupported, any attempts to load instruments from
   it will result in an IllegalArgumentException.

  soundbank - soundbank for which support is queried - `javax.sound.midi.Soundbank`

  returns: true if the soundbank is supported, otherwise false - `boolean`"
  (^Boolean [^javax.sound.midi.Synthesizer this ^javax.sound.midi.Soundbank soundbank]
    (-> this (.isSoundbankSupported soundbank))))

(defn unload-instrument
  "Unloads a particular instrument.

  instrument - instrument to unload - `javax.sound.midi.Instrument`

  throws: java.lang.IllegalArgumentException - if this Synthesizer doesn't support the specified instrument's soundbank"
  ([^javax.sound.midi.Synthesizer this ^javax.sound.midi.Instrument instrument]
    (-> this (.unloadInstrument instrument))))

(defn get-channels
  "Obtains the set of MIDI channels controlled by this synthesizer.  Each
   non-null element in the returned array is a MidiChannel that
   receives the MIDI messages sent on that channel number.

   The MIDI 1.0 specification provides for 16 channels, so this
   method returns an array of at least 16 elements.  However, if this synthesizer
   doesn't make use of all 16 channels, some of the elements of the array
   might be null, so you should check each element
   before using it.

  returns: an array of the MidiChannel objects managed by this
   Synthesizer.  Some of the array elements may be null. - `javax.sound.midi.MidiChannel[]`"
  ([^javax.sound.midi.Synthesizer this]
    (-> this (.getChannels))))

(defn load-instrument
  "Makes a particular instrument available for synthesis.  This instrument
   is loaded into the patch location specified by its Patch
   object, so that if a program-change message is
   received (or has been received) that causes that patch to be selected,
   subsequent notes will be played using the sound of
   instrument.  If the specified instrument is already loaded,
   this method does nothing and returns true.

   The instrument must be part of a soundbank
   that this Synthesizer supports.  (To make sure, you can use
   the getSoundbank method of Instrument and the
   isSoundbankSupported method of Synthesizer.)

  instrument - instrument to load - `javax.sound.midi.Instrument`

  returns: true if the instrument is successfully loaded (or
   already had been), false if the instrument could not be
   loaded (for example, if the synthesizer has insufficient
   memory to load it) - `boolean`

  throws: java.lang.IllegalArgumentException - if this Synthesizer doesn't support the specified instrument's soundbank"
  (^Boolean [^javax.sound.midi.Synthesizer this ^javax.sound.midi.Instrument instrument]
    (-> this (.loadInstrument instrument))))

(defn remap-instrument
  "Remaps an instrument. Instrument to takes the
   place of instrument from.
   For example, if from was located at bank number 2,
   program number 11, remapping causes that bank and program location
   to be occupied instead by to.
   If the function succeeds,  instrument from is unloaded.
   To cancel the remapping reload instrument from by
   invoking one of loadInstrument(javax.sound.midi.Instrument), loadInstruments(javax.sound.midi.Soundbank, javax.sound.midi.Patch[])
   or loadAllInstruments(javax.sound.midi.Soundbank).

  from - the Instrument object to be replaced - `javax.sound.midi.Instrument`
  to - the Instrument object to be used in place of the old instrument, it should be loaded into the synthesizer - `javax.sound.midi.Instrument`

  returns: true if the instrument successfully remapped,
   false if feature is not implemented by synthesizer - `boolean`

  throws: java.lang.IllegalArgumentException - if instrument from or instrument to aren't supported by synthesizer or if instrument to is not loaded"
  (^Boolean [^javax.sound.midi.Synthesizer this ^javax.sound.midi.Instrument from ^javax.sound.midi.Instrument to]
    (-> this (.remapInstrument from to))))

(defn get-latency
  "Obtains the processing latency incurred by this synthesizer, expressed in
   microseconds.  This latency measures the worst-case delay between the
   time a MIDI message is delivered to the synthesizer and the time that the
   synthesizer actually produces the corresponding result.

   Although the latency is expressed in microseconds, a synthesizer's actual measured
   delay may vary over a wider range than this resolution suggests.  For example,
   a synthesizer might have a worst-case delay of a few milliseconds or more.

  returns: the worst-case delay, in microseconds - `long`"
  (^Long [^javax.sound.midi.Synthesizer this]
    (-> this (.getLatency))))

(defn get-loaded-instruments
  "Obtains a list of the instruments that are currently loaded onto this
   Synthesizer.

  returns: a list of currently loaded instruments - `javax.sound.midi.Instrument[]`"
  ([^javax.sound.midi.Synthesizer this]
    (-> this (.getLoadedInstruments))))

(defn unload-instruments
  "Unloads the instruments referenced by the specified patches, from the MIDI sound bank specified.

  soundbank - soundbank containing instruments to unload - `javax.sound.midi.Soundbank`
  patch-list - list of patches for which instruments should be unloaded - `javax.sound.midi.Patch[]`

  throws: java.lang.IllegalArgumentException - thrown if the soundbank is not supported."
  ([^javax.sound.midi.Synthesizer this ^javax.sound.midi.Soundbank soundbank patch-list]
    (-> this (.unloadInstruments soundbank patch-list))))

