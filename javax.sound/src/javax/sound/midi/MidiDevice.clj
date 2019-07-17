(ns javax.sound.midi.MidiDevice
  "MidiDevice is the base interface for all MIDI devices.
  Common devices include synthesizers, sequencers, MIDI input ports, and MIDI
  output ports.

  A MidiDevice can be a transmitter or a receiver of
  MIDI events, or both. Therefore, it can provide Transmitter
  or Receiver instances (or both). Typically, MIDI IN ports
  provide transmitters, MIDI OUT ports and synthesizers provide
  receivers. A Sequencer typically provides transmitters for playback
  and receivers for recording.

  A MidiDevice can be opened and closed explicitly as
  well as implicitly. Explicit opening is accomplished by calling
  open(), explicit closing is done by calling close() on the MidiDevice instance.
  If an application opens a MidiDevice
  explicitly, it has to close it explicitly to free system resources
  and enable the application to exit cleanly. Implicit opening is
  done by calling MidiSystem.getReceiver and MidiSystem.getTransmitter. The MidiDevice used by
  MidiSystem.getReceiver and
  MidiSystem.getTransmitter is implementation-dependant
  unless the properties javax.sound.midi.Receiver
  and javax.sound.midi.Transmitter are used (see the
  description of properties to select default providers in
  MidiSystem). A MidiDevice
  that was opened implicitly, is closed implicitly by closing the
  Receiver or Transmitter that resulted in
  opening it. If more than one implicitly opening
  Receiver or Transmitter were obtained by
  the application, the device is closed after the last
  Receiver or Transmitter has been
  closed. On the other hand, calling getReceiver or
  getTransmitter on the device instance directly does
  not open the device implicitly. Closing these
  Transmitters and Receivers does not close
  the device implicitly. To use a device with Receivers
  or Transmitters obtained this way, the device has to
  be opened and closed explicitly.

  If implicit and explicit opening and closing are mixed on the
  same MidiDevice instance, the following rules apply:


  After an explicit open (either before or after implicit
  opens), the device will not be closed by implicit closing. The only
  way to close an explicitly opened device is an explicit close.

  An explicit close always closes the device, even if it also has
  been opened implicitly. A subsequent implicit close has no further
  effect.


  To detect if a MidiDevice represents a hardware MIDI port, the
  following programming technique can be used:



  MidiDevice device = ...;
  if ( ! (device instanceof Sequencer) && ! (device instanceof Synthesizer)) {
    // we're now sure that device represents a MIDI port
    // ...
  }


  A MidiDevice includes a MidiDevice.Info object
  to provide manufacturer information and so on."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MidiDevice]))

(defn get-max-transmitters
  "Obtains the maximum number of MIDI OUT connections available on this
   MIDI device for transmitting MIDI data.

  returns: maximum number of MIDI OUT connections,
   or -1 if an unlimited number of connections is available. - `int`"
  ([this]
    (-> this (.getMaxTransmitters))))

(defn get-microsecond-position
  "Obtains the current time-stamp of the device, in microseconds.
   If a device supports time-stamps, it should start counting at
   0 when the device is opened and continue incrementing its
   time-stamp in microseconds until the device is closed.
   If it does not support time-stamps, it should always return
   -1.

  returns: the current time-stamp of the device in microseconds,
   or -1 if time-stamping is not supported by the device. - `long`"
  ([this]
    (-> this (.getMicrosecondPosition))))

(defn get-transmitter
  "Obtains a MIDI OUT connection from which the MIDI device will transmit
   MIDI data  The returned transmitter must be closed when the application
   has finished using it.

   Usually the returned transmitter implements
   the MidiDeviceTransmitter interface.

   Obtaining a Transmitter with this method does not
   open the device. To be able to use the device, it has to be
   opened explicitly by calling open(). Also, closing the
   Transmitter does not close the device. It has to be
   closed explicitly by calling close().

  returns: a MIDI OUT transmitter for the device. - `javax.sound.midi.Transmitter`

  throws: javax.sound.midi.MidiUnavailableException - thrown if a transmitter is not available due to resource restrictions"
  ([this]
    (-> this (.getTransmitter))))

(defn get-receiver
  "Obtains a MIDI IN receiver through which the MIDI device may receive
   MIDI data.  The returned receiver must be closed when the application
   has finished using it.

   Usually the returned receiver implements
   the MidiDeviceReceiver interface.

   Obtaining a Receiver with this method does not
   open the device. To be able to use the device, it has to be
   opened explicitly by calling open(). Also, closing the
   Receiver does not close the device. It has to be
   closed explicitly by calling close().

  returns: a receiver for the device. - `javax.sound.midi.Receiver`

  throws: javax.sound.midi.MidiUnavailableException - thrown if a receiver is not available due to resource restrictions"
  ([this]
    (-> this (.getReceiver))))

(defn get-max-receivers
  "Obtains the maximum number of MIDI IN connections available on this
   MIDI device for receiving MIDI data.

  returns: maximum number of MIDI IN connections,
   or -1 if an unlimited number of connections is available. - `int`"
  ([this]
    (-> this (.getMaxReceivers))))

(defn close
  "Closes the device, indicating that the device should now release
   any system resources it is using.

   All Receiver and Transmitter instances
   open from this device are closed. This includes instances retrieved
   via MidiSystem."
  ([this]
    (-> this (.close))))

(defn get-device-info
  "Obtains information about the device, including its Java class and
   Strings containing its name, vendor, and description.

  returns: device info - `javax.sound.midi.MidiDevice.Info`"
  ([this]
    (-> this (.getDeviceInfo))))

(defn open?
  "Reports whether the device is open.

  returns: true if the device is open, otherwise
   false - `boolean`"
  ([this]
    (-> this (.isOpen))))

(defn open
  "Opens the device, indicating that it should now acquire any
   system resources it requires and become operational.

   An application opening a device explicitly with this call
   has to close the device by calling close(). This is
   necessary to release system resources and allow applications to
   exit cleanly.


   Note that some devices, once closed, cannot be reopened.  Attempts
   to reopen such a device will always result in a MidiUnavailableException.

  throws: javax.sound.midi.MidiUnavailableException - thrown if the device cannot be opened due to resource restrictions."
  ([this]
    (-> this (.open))))

(defn get-transmitters
  "Returns all currently active, non-closed transmitters
   connected with this MidiDevice.
   A transmitter can be removed
   from the device by closing it.

   Usually the returned transmitters implement
   the MidiDeviceTransmitter interface.

  returns: an unmodifiable list of the open transmitters - `java.util.List<javax.sound.midi.Transmitter>`"
  ([this]
    (-> this (.getTransmitters))))

(defn get-receivers
  "Returns all currently active, non-closed receivers
   connected with this MidiDevice.
   A receiver can be removed
   from the device by closing it.

   Usually the returned receivers implement
   the MidiDeviceReceiver interface.

  returns: an unmodifiable list of the open receivers - `java.util.List<javax.sound.midi.Receiver>`"
  ([this]
    (-> this (.getReceivers))))

