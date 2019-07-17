(ns javax.sound.midi.MidiFileFormat
  "A MidiFileFormat object encapsulates a MIDI file's
  type, as well as its length and timing information.

  A MidiFileFormat object can
  include a set of properties. A property is a pair of key and value:
  the key is of type String, the associated property
  value is an arbitrary object.
  Properties specify additional informational
  meta data (like a author, or copyright).
  Properties are optional information, and file reader and file
  writer implementations are not required to provide or
  recognize properties.

  The following table lists some common properties that should
  be used in implementations:


     MIDI File Format Properties

    Property key
    Value type
    Description


    `author`
    String
    name of the author of this file


    `title`
    String
    title of this file


    `copyright`
    String
    copyright message


    `date`
    Date
    date of the recording or release


    `comment`
    String
    an arbitrary text"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MidiFileFormat]))

(defn ->midi-file-format
  "Constructor.

  Construct a MidiFileFormat with a set of properties.

  type - the MIDI file type (0, 1, or 2) - `int`
  division-type - the timing division type (PPQ or one of the SMPTE types) - `float`
  resolution - the timing resolution - `int`
  bytes - the length of the MIDI file in bytes, or UNKNOWN_LENGTH if not known - `int`
  microseconds - the duration of the file in microseconds, or UNKNOWN_LENGTH if not known - `long`
  properties - a Map<String,Object> object with properties - `java.util.Map<java.lang.String,java.lang.Object>`"
  ([^Integer type ^Float division-type ^Integer resolution ^Integer bytes ^Long microseconds ^java.util.Map properties]
    (new MidiFileFormat type division-type resolution bytes microseconds properties))
  ([^Integer type ^Float division-type ^Integer resolution ^Integer bytes ^Long microseconds]
    (new MidiFileFormat type division-type resolution bytes microseconds)))

(def *-unknown-length
  "Static Constant.

  Represents unknown length.

  type: int"
  MidiFileFormat/UNKNOWN_LENGTH)

(defn get-type
  "Obtains the MIDI file type.

  returns: the file's type (0, 1, or 2) - `int`"
  (^Integer [^javax.sound.midi.MidiFileFormat this]
    (-> this (.getType))))

(defn get-division-type
  "Obtains the timing division type for the MIDI file.

  returns: the division type (PPQ or one of the SMPTE types) - `float`"
  (^Float [^javax.sound.midi.MidiFileFormat this]
    (-> this (.getDivisionType))))

(defn get-resolution
  "Obtains the timing resolution for the MIDI file.
   If the division type is PPQ, the resolution is specified in ticks per beat.
   For SMTPE timing, the resolution is specified in ticks per frame.

  returns: the number of ticks per beat (PPQ) or per frame (SMPTE) - `int`"
  (^Integer [^javax.sound.midi.MidiFileFormat this]
    (-> this (.getResolution))))

(defn get-byte-length
  "Obtains the length of the MIDI file, expressed in 8-bit bytes.

  returns: the number of bytes in the file, or UNKNOWN_LENGTH if not known - `int`"
  (^Integer [^javax.sound.midi.MidiFileFormat this]
    (-> this (.getByteLength))))

(defn get-microsecond-length
  "Obtains the length of the MIDI file, expressed in microseconds.

  returns: the file's duration in microseconds, or UNKNOWN_LENGTH if not known - `long`"
  (^Long [^javax.sound.midi.MidiFileFormat this]
    (-> this (.getMicrosecondLength))))

(defn properties
  "Obtain an unmodifiable map of properties.
   The concept of properties is further explained in
   the class description.

  returns: a Map<String,Object> object containing
           all properties. If no properties are recognized, an empty map is
           returned. - `java.util.Map<java.lang.String,java.lang.Object>`"
  (^java.util.Map [^javax.sound.midi.MidiFileFormat this]
    (-> this (.properties))))

(defn get-property
  "Obtain the property value specified by the key.
   The concept of properties is further explained in
   the class description.

   If the specified property is not defined for a
   particular file format, this method returns
   null.

  key - the key of the desired property - `java.lang.String`

  returns: the value of the property with the specified key,
           or null if the property does not exist. - `java.lang.Object`"
  (^java.lang.Object [^javax.sound.midi.MidiFileFormat this ^java.lang.String key]
    (-> this (.getProperty key))))

