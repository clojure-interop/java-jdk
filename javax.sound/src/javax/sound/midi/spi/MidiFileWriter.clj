(ns javax.sound.midi.spi.MidiFileWriter
  "A MidiFileWriter supplies MIDI file-writing services. Classes that
  implement this interface can write one or more types of MIDI file from a
  Sequence object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi.spi MidiFileWriter]))

(defn ->midi-file-writer
  "Constructor."
  ([]
    (new MidiFileWriter )))

(defn get-midi-file-types
  "Obtains the file types that this file writer can write from the sequence
   specified.

  sequence - the sequence for which MIDI file type support is queried - `javax.sound.midi.Sequence`

  returns: array of file types. If no file types are supported, returns an
           array of length 0. - `int[]`"
  ([^javax.sound.midi.spi.MidiFileWriter this ^javax.sound.midi.Sequence sequence]
    (-> this (.getMidiFileTypes sequence)))
  ([^javax.sound.midi.spi.MidiFileWriter this]
    (-> this (.getMidiFileTypes))))

(defn file-type-supported?
  "Indicates whether a MIDI file of the file type specified can be written
   from the sequence indicated.

  file-type - the file type for which write capabilities are queried - `int`
  sequence - the sequence for which file writing support is queried - `javax.sound.midi.Sequence`

  returns: true if the file type is supported for this sequence,
           otherwise false - `boolean`"
  ([^javax.sound.midi.spi.MidiFileWriter this ^Integer file-type ^javax.sound.midi.Sequence sequence]
    (-> this (.isFileTypeSupported file-type sequence)))
  ([^javax.sound.midi.spi.MidiFileWriter this ^Integer file-type]
    (-> this (.isFileTypeSupported file-type))))

(defn write
  "Writes a stream of bytes representing a MIDI file of the file type
   indicated to the output stream provided.

  in - sequence containing MIDI data to be written to the file - `javax.sound.midi.Sequence`
  file-type - type of the file to be written to the output stream - `int`
  out - stream to which the file data should be written - `java.io.OutputStream`

  returns: the number of bytes written to the output stream - `int`

  throws: java.io.IOException - if an I/O exception occurs"
  ([^javax.sound.midi.spi.MidiFileWriter this ^javax.sound.midi.Sequence in ^Integer file-type ^java.io.OutputStream out]
    (-> this (.write in file-type out))))

