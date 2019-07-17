(ns javax.sound.midi.spi.MidiFileReader
  "A MidiFileReader supplies MIDI file-reading services. Classes
  implementing this interface can parse the format information from one or more
  types of MIDI file, and can produce a Sequence object from files of
  these types."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi.spi MidiFileReader]))

(defn ->midi-file-reader
  "Constructor."
  ([]
    (new MidiFileReader )))

(defn get-midi-file-format
  "Obtains the MIDI file format of the input stream provided. The stream
   must point to valid MIDI file data. In general, MIDI file readers may
   need to read some data from the stream before determining whether they
   support it. These parsers must be able to mark the stream, read enough
   data to determine whether they support the stream, and, if not, reset the
   stream's read pointer to its original position. If the input stream does
   not support this, this method may fail with an IOException.

  stream - the input stream from which file format information should be extracted - `java.io.InputStream`

  returns: a MidiFileFormat object describing the MIDI file format - `javax.sound.midi.MidiFileFormat`

  throws: javax.sound.midi.InvalidMidiDataException - if the stream does not point to valid MIDI file data recognized by the system"
  ([^javax.sound.midi.spi.MidiFileReader this ^java.io.InputStream stream]
    (-> this (.getMidiFileFormat stream))))

(defn get-sequence
  "Obtains a MIDI sequence from the input stream provided. The stream must
   point to valid MIDI file data. In general, MIDI file readers may need to
   read some data from the stream before determining whether they support
   it. These parsers must be able to mark the stream, read enough data to
   determine whether they support the stream, and, if not, reset the
   stream's read pointer to its original position. If the input stream does
   not support this, this method may fail with an IOException.

  stream - the input stream from which the Sequence should be constructed - `java.io.InputStream`

  returns: a Sequence object based on the MIDI file data contained
           in the input stream. - `javax.sound.midi.Sequence`

  throws: javax.sound.midi.InvalidMidiDataException - if the stream does not point to valid MIDI file data recognized by the system"
  ([^javax.sound.midi.spi.MidiFileReader this ^java.io.InputStream stream]
    (-> this (.getSequence stream))))

