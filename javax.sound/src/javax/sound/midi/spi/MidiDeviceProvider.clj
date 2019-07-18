(ns javax.sound.midi.spi.MidiDeviceProvider
  "A MidiDeviceProvider is a factory or provider for a particular type
  of MIDI device. This mechanism allows the implementation to determine how
  resources are managed in the creation and management of a device."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi.spi MidiDeviceProvider]))

(defn ->midi-device-provider
  "Constructor."
  (^MidiDeviceProvider []
    (new MidiDeviceProvider )))

(defn device-supported?
  "Indicates whether the device provider supports the device represented by
   the specified device info object.

  info - an info object that describes the device for which support is queried - `javax.sound.midi.MidiDevice$Info`

  returns: true if the specified device is supported, otherwise
           false - `boolean`"
  (^Boolean [^MidiDeviceProvider this ^javax.sound.midi.MidiDevice$Info info]
    (-> this (.isDeviceSupported info))))

(defn get-device-info
  "Obtains the set of info objects representing the device or devices
   provided by this MidiDeviceProvider.

  returns: set of device info objects - `javax.sound.midi.MidiDevice$Info[]`"
  ([^MidiDeviceProvider this]
    (-> this (.getDeviceInfo))))

(defn get-device
  "Obtains an instance of the device represented by the info object.

  info - an info object that describes the desired device - `javax.sound.midi.MidiDevice$Info`

  returns: device instance - `javax.sound.midi.MidiDevice`

  throws: java.lang.IllegalArgumentException - if the info object specified does not match the info object for a device supported by this MidiDeviceProvider"
  (^javax.sound.midi.MidiDevice [^MidiDeviceProvider this ^javax.sound.midi.MidiDevice$Info info]
    (-> this (.getDevice info))))

