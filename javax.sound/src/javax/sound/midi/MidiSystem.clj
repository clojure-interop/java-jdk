(ns javax.sound.midi.MidiSystem
  "The MidiSystem class provides access to the installed MIDI
  system resources, including devices such as synthesizers, sequencers, and
  MIDI input and output ports.  A typical simple MIDI application might
  begin by invoking one or more MidiSystem methods to learn
  what devices are installed and to obtain the ones needed in that
  application.

  The class also has methods for reading files, streams, and  URLs that
  contain standard MIDI file data or soundbanks.  You can query the
  MidiSystem for the format of a specified MIDI file.

  You cannot instantiate a MidiSystem; all the methods are
  static.

  Properties can be used to specify default MIDI devices.
  Both system properties and a properties file are considered.
  The sound.properties properties file is read from
  an implementation-specific location (typically it is the lib
  directory in the Java installation directory).
  If a property exists both as a system property and in the
  properties file, the system property takes precedence. If none is
  specified, a suitable default is chosen among the available devices.
  The syntax of the properties file is specified in
  Properties.load. The
  following table lists the available property keys and which methods
  consider them:


   MIDI System Property Keys

    Property Key
    Interface
    Affected Method


    javax.sound.midi.Receiver
    Receiver
    getReceiver()


    javax.sound.midi.Sequencer
    Sequencer
    getSequencer()


    javax.sound.midi.Synthesizer
    Synthesizer
    getSynthesizer()


    javax.sound.midi.Transmitter
    Transmitter
    getTransmitter()



  The property value consists of the provider class name
  and the device name, separated by the hash mark (`#`).
  The provider class name is the fully-qualified
  name of a concrete MIDI device provider class. The device name is matched against
  the String returned by the getName
  method of MidiDevice.Info.
  Either the class name, or the device name may be omitted.
  If only the class name is specified, the trailing hash mark
  is optional.

  If the provider class is specified, and it can be
  successfully retrieved from the installed providers,
  the list of
  MidiDevice.Info objects is retrieved
  from the provider. Otherwise, or when these devices
  do not provide a subsequent match, the list is retrieved
  from getMidiDeviceInfo() to contain
  all available MidiDevice.Info objects.

  If a device name is specified, the resulting list of
  MidiDevice.Info objects is searched:
  the first one with a matching name, and whose
  MidiDevice implements the
  respective interface, will be returned.
  If no matching MidiDevice.Info object
  is found, or the device name is not specified,
  the first suitable device from the resulting
  list will be returned. For Sequencer and Synthesizer,
  a device is suitable if it implements the respective
  interface; whereas for Receiver and Transmitter, a device is
  suitable if it
  implements neither Sequencer nor Synthesizer and provides
  at least one Receiver or Transmitter, respectively.

  For example, the property javax.sound.midi.Receiver
  with a value
  `com.sun.media.sound.MidiProvider#SunMIDI1`
  will have the following consequences when
  getReceiver is called:
  if the class com.sun.media.sound.MidiProvider exists
  in the list of installed MIDI device providers,
  the first Receiver device with name
  `SunMIDI1` will be returned. If it cannot
  be found, the first Receiver from that provider
  will be returned, regardless of name.
  If there is none, the first Receiver with name
  `SunMIDI1` in the list of all devices
  (as returned by getMidiDeviceInfo) will be returned,
  or, if not found, the first Receiver that can
  be found in the list of all devices is returned.
  If that fails, too, a MidiUnavailableException
  is thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MidiSystem]))

(defn *get-sequencer
  "Obtains the default Sequencer, optionally
   connected to a default device.

   If connected is true, the returned
   Sequencer instance is
   connected to the default Synthesizer,
   as returned by getSynthesizer().
   If there is no Synthesizer
   available, or the default Synthesizer
   cannot be opened, the sequencer is connected
   to the default Receiver, as returned
   by getReceiver().
   The connection is made by retrieving a Transmitter
   instance from the Sequencer and setting its
   Receiver.
   Closing and re-opening the sequencer will restore the
   connection to the default device.

   If connected is false, the returned
   Sequencer instance is not connected, it
   has no open Transmitters. In order to
   play the sequencer on a MIDI device, or a Synthesizer,
   it is necessary to get a Transmitter and set its
   Receiver.

   If the system property
   javax.sound.midi.Sequencer
   is defined or it is defined in the file `sound.properties`,
   it is used to identify the default sequencer.
   For details, refer to the class description.

  connected - whether or not the returned Sequencer is connected to the default Synthesizer - `boolean`

  returns: the default sequencer - `javax.sound.midi.Sequencer`

  throws: javax.sound.midi.MidiUnavailableException - if the sequencer is not available due to resource restrictions, or no sequencer is installed in the system, or if connected is true, and there is no Receiver available by any installed MidiDevice"
  (^javax.sound.midi.Sequencer [^Boolean connected]
    (MidiSystem/getSequencer connected))
  (^javax.sound.midi.Sequencer []
    (MidiSystem/getSequencer )))

(defn *file-type-supported?
  "Indicates whether a MIDI file of the file type specified can be written
   from the sequence indicated.

  file-type - the file type for which write capabilities are queried - `int`
  sequence - the sequence for which file writing support is queried - `javax.sound.midi.Sequence`

  returns: true if the file type is supported for this
   sequence, otherwise false - `boolean`"
  (^Boolean [^Integer file-type ^javax.sound.midi.Sequence sequence]
    (MidiSystem/isFileTypeSupported file-type sequence))
  (^Boolean [^Integer file-type]
    (MidiSystem/isFileTypeSupported file-type)))

(defn *get-transmitter
  "Obtains a MIDI transmitter from an external MIDI port
   or other default source.
   The returned transmitter always implements
   the MidiDeviceTransmitter interface.

   If the system property
   javax.sound.midi.Transmitter
   is defined or it is defined in the file `sound.properties`,
   it is used to identify the device that provides the default transmitter.
   For details, refer to the class description.

   If a native transmitter provided by the default device does not implement
   the MidiDeviceTransmitter interface, it will be wrapped in a
   wrapper class that implements the MidiDeviceTransmitter interface.
   The corresponding Transmitter method calls will be forwarded
   to the native transmitter.

   If this method returns successfully, the MidiDevice the
   Transmitter belongs to is opened implicitly, if it
   is not already open. It is possible to close an implicitly
   opened device by calling close on the returned
   Transmitter. All open Transmitter
   instances have to be closed in order to release system resources
   hold by the MidiDevice. For a detailed description
   of open/close behaviour see the class description of MidiDevice.

  returns: the default MIDI transmitter - `javax.sound.midi.Transmitter`

  throws: javax.sound.midi.MidiUnavailableException - if the default transmitter is not available due to resource restrictions, or no device providing transmitters is installed in the system"
  (^javax.sound.midi.Transmitter []
    (MidiSystem/getTransmitter )))

(defn *get-synthesizer
  "Obtains the default synthesizer.

   If the system property
   javax.sound.midi.Synthesizer
   is defined or it is defined in the file `sound.properties`,
   it is used to identify the default synthesizer.
   For details, refer to the class description.

  returns: the default synthesizer - `javax.sound.midi.Synthesizer`

  throws: javax.sound.midi.MidiUnavailableException - if the synthesizer is not available due to resource restrictions, or no synthesizer is installed in the system"
  (^javax.sound.midi.Synthesizer []
    (MidiSystem/getSynthesizer )))

(defn *get-receiver
  "Obtains a MIDI receiver from an external MIDI port
   or other default device.
   The returned receiver always implements
   the MidiDeviceReceiver interface.

   If the system property
   javax.sound.midi.Receiver
   is defined or it is defined in the file `sound.properties`,
   it is used to identify the device that provides the default receiver.
   For details, refer to the class description.

   If a suitable MIDI port is not available, the Receiver is
   retrieved from an installed synthesizer.

   If a native receiver provided by the default device does not implement
   the MidiDeviceReceiver interface, it will be wrapped in a
   wrapper class that implements the MidiDeviceReceiver interface.
   The corresponding Receiver method calls will be forwarded
   to the native receiver.

   If this method returns successfully, the MidiDevice the
   Receiver belongs to is opened implicitly, if it is
   not already open. It is possible to close an implicitly opened
   device by calling close
   on the returned Receiver. All open Receiver
   instances have to be closed in order to release system resources
   hold by the MidiDevice. For a
   detailed description of open/close behaviour see the class
   description of MidiDevice.

  returns: the default MIDI receiver - `javax.sound.midi.Receiver`

  throws: javax.sound.midi.MidiUnavailableException - if the default receiver is not available due to resource restrictions, or no device providing receivers is installed in the system"
  (^javax.sound.midi.Receiver []
    (MidiSystem/getReceiver )))

(defn *get-midi-file-format
  "Obtains the MIDI file format of the data in the specified input stream.
   The stream must point to valid MIDI file data for a file type recognized
   by the system.

   This method and/or the code it invokes may need to read some data from
   the stream to determine whether its data format is supported.  The
   implementation may therefore
   need to mark the stream, read enough data to determine whether it is in
   a supported format, and reset the stream's read pointer to its original
   position.  If the input stream does not permit this set of operations,
   this method may fail with an IOException.

   This operation can only succeed for files of a type which can be parsed
   by an installed file reader.  It may fail with an InvalidMidiDataException
   even for valid files if no compatible file reader is installed.  It
   will also fail with an InvalidMidiDataException if a compatible file reader
   is installed, but encounters errors while determining the file format.

  stream - the input stream from which file format information should be extracted - `java.io.InputStream`

  returns: an MidiFileFormat object describing the MIDI file
   format - `javax.sound.midi.MidiFileFormat`

  throws: javax.sound.midi.InvalidMidiDataException - if the stream does not point to valid MIDI file data recognized by the system"
  (^javax.sound.midi.MidiFileFormat [^java.io.InputStream stream]
    (MidiSystem/getMidiFileFormat stream)))

(defn *get-sequence
  "Obtains a MIDI sequence from the specified input stream.  The stream must
   point to valid MIDI file data for a file type recognized
   by the system.

   This method and/or the code it invokes may need to read some data
   from the stream to determine whether
   its data format is supported.  The implementation may therefore
   need to mark the stream, read enough data to determine whether it is in
   a supported format, and reset the stream's read pointer to its original
   position.  If the input stream does not permit this set of operations,
   this method may fail with an IOException.

   This operation can only succeed for files of a type which can be parsed
   by an installed file reader.  It may fail with an InvalidMidiDataException
   even for valid files if no compatible file reader is installed.  It
   will also fail with an InvalidMidiDataException if a compatible file reader
   is installed, but encounters errors while constructing the Sequence
   object from the file data.

  stream - the input stream from which the Sequence should be constructed - `java.io.InputStream`

  returns: a Sequence object based on the MIDI file data
   contained in the input stream - `javax.sound.midi.Sequence`

  throws: javax.sound.midi.InvalidMidiDataException - if the stream does not point to valid MIDI file data recognized by the system"
  (^javax.sound.midi.Sequence [^java.io.InputStream stream]
    (MidiSystem/getSequence stream)))

(defn *get-midi-device
  "Obtains the requested MIDI device.

  info - a device information object representing the desired device. - `javax.sound.midi.MidiDevice.Info`

  returns: the requested device - `javax.sound.midi.MidiDevice`

  throws: javax.sound.midi.MidiUnavailableException - if the requested device is not available due to resource restrictions"
  (^javax.sound.midi.MidiDevice [^javax.sound.midi.MidiDevice.Info info]
    (MidiSystem/getMidiDevice info)))

(defn *get-soundbank
  "Constructs a MIDI sound bank by reading it from the specified stream.
   The stream must point to
   a valid MIDI soundbank file.  In general, MIDI soundbank providers may
   need to read some data from the stream before determining whether they
   support it.  These parsers must
   be able to mark the stream, read enough data to determine whether they
   support the stream, and, if not, reset the stream's read pointer to
   its original position.  If the input stream does not support this,
   this method may fail with an IOException.

  stream - the source of the sound bank data. - `java.io.InputStream`

  returns: the sound bank - `javax.sound.midi.Soundbank`

  throws: javax.sound.midi.InvalidMidiDataException - if the stream does not point to valid MIDI soundbank data recognized by the system"
  (^javax.sound.midi.Soundbank [^java.io.InputStream stream]
    (MidiSystem/getSoundbank stream)))

(defn *get-midi-device-info
  "Obtains an array of information objects representing
   the set of all MIDI devices available on the system.
   A returned information object can then be used to obtain the
   corresponding device object, by invoking
   getMidiDevice.

  returns: an array of MidiDevice.Info objects, one
   for each installed MIDI device.  If no such devices are installed,
   an array of length 0 is returned. - `javax.sound.midi.MidiDevice.Info[]`"
  ([]
    (MidiSystem/getMidiDeviceInfo )))

(defn *write
  "Writes a stream of bytes representing a file of the MIDI file type
   indicated to the output stream provided.

  in - sequence containing MIDI data to be written to the file - `javax.sound.midi.Sequence`
  file-type - the file type of the file to be written to the output stream - `int`
  out - stream to which the file data should be written - `java.io.OutputStream`

  returns: the number of bytes written to the output stream - `int`

  throws: java.io.IOException - if an I/O exception occurs"
  (^Integer [^javax.sound.midi.Sequence in ^Integer file-type ^java.io.OutputStream out]
    (MidiSystem/write in file-type out)))

(defn *get-midi-file-types
  "Obtains the set of MIDI file types that the system can write from the
   sequence specified.

  sequence - the sequence for which MIDI file type support is queried - `javax.sound.midi.Sequence`

  returns: the set of unique supported file types.  If no file types are supported,
   returns an array of length 0. - `int[]`"
  ([^javax.sound.midi.Sequence sequence]
    (MidiSystem/getMidiFileTypes sequence))
  ([]
    (MidiSystem/getMidiFileTypes )))

