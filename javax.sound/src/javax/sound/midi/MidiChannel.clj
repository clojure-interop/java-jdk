(ns javax.sound.midi.MidiChannel
  "A MidiChannel object represents a single MIDI channel.
  Generally, each MidiChannel method processes a like-named MIDI
  `channel voice` or `channel mode` message as defined by the MIDI specification. However,
  MidiChannel adds some `get` methods  that retrieve the value
  most recently set by one of the standard MIDI channel messages.  Similarly,
  methods for per-channel solo and mute have been added.

  A Synthesizer object has a collection
  of MidiChannels, usually one for each of the 16 channels
  prescribed by the MIDI 1.0 specification.  The Synthesizer
  generates sound when its MidiChannels receive
  noteOn messages.

  See the MIDI 1.0 Specification for more information about the prescribed
  behavior of the MIDI channel messages, which are not exhaustively
  documented here.  The specification is titled MIDI Reference:
  The Complete MIDI 1.0 Detailed Specification, and is published by
  the MIDI Manufacturer's Association (
  http://www.midi.org).

  MIDI was originally a protocol for reporting the gestures of a keyboard
  musician.  This genesis is visible in the MidiChannel API, which
  preserves such MIDI concepts as key number, key velocity, and key pressure.
  It should be understood that the MIDI data does not necessarily originate
  with a keyboard player (the source could be a different kind of musician, or
  software).  Some devices might generate constant values for velocity
  and pressure, regardless of how the note was performed.
  Also, the MIDI specification often leaves it up to the
  synthesizer to use the data in the way the implementor sees fit.  For
  example, velocity data need not always be mapped to volume and/or brightness."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MidiChannel]))

(defn set-omni
  "Turns omni mode on or off.  In omni mode, the channel responds
   to messages sent on all channels.  When omni is off, the channel
   responds only to messages sent on its channel number.
   The default is omni off.

   It is possible that the underlying synthesizer
   does not support omni mode. In order
   to verify that setOmni
   was successful, use getOmni.

  on - true to turn omni mode on, false to turn it off. - `boolean`"
  ([^javax.sound.midi.MidiChannel this ^Boolean on]
    (-> this (.setOmni on))))

(defn set-mono
  "Turns mono mode on or off.  In mono mode, the channel synthesizes
   only one note at a time.  In poly mode (identical to mono mode off),
   the channel can synthesize multiple notes simultaneously.
   The default is mono off (poly mode on).

   `Mono` is short for the word `monophonic,` which in this context
   is opposed to the word `polyphonic` and refers to a single synthesizer
   voice per MIDI channel.  It
   has nothing to do with how many audio channels there might be
   (as in `monophonic` versus `stereophonic` recordings).

   It is possible that the underlying synthesizer
   does not support mono mode. In order
   to verify that a call to setMono
   was successful, use getMono.

  on - true to turn mono mode on, false to turn it off (which means turning poly mode on). - `boolean`"
  ([^javax.sound.midi.MidiChannel this ^Boolean on]
    (-> this (.setMono on))))

(defn note-on
  "Starts the specified note sounding.  The key-down velocity
   usually controls the note's volume and/or brightness.
   If velocity is zero, this method instead acts like
   noteOff(int), terminating the note.

  note-number - the MIDI note number, from 0 to 127 (60 = Middle C) - `int`
  velocity - the speed with which the key was depressed - `int`"
  ([^javax.sound.midi.MidiChannel this ^Integer note-number ^Integer velocity]
    (-> this (.noteOn note-number velocity))))

(defn get-poly-pressure
  "Obtains the pressure with which the specified key is being depressed.

  note-number - the MIDI note number, from 0 to 127 (60 = Middle C) If the device does not support setting poly pressure, this method always returns 0. Calling setPolyPressure will have no effect then. - `int`

  returns: the amount of pressure for that note, from 0 to 127
   (127 = maximum pressure) - `int`"
  ([^javax.sound.midi.MidiChannel this ^Integer note-number]
    (-> this (.getPolyPressure note-number))))

(defn get-omni?
  "Obtains the current omni mode.
   Synthesizers that do not allow changing the omni mode
   will always return the same value, regardless
   of calls to setOmni.

  returns: true if omni mode is on, otherwise
   false (meaning omni mode is off). - `boolean`"
  ([^javax.sound.midi.MidiChannel this]
    (-> this (.getOmni))))

(defn set-mute
  "Sets the mute state for this channel. A value of
   true means the channel is to be muted, false
   means the channel can sound (if other channels are not soloed).

   Unlike allSoundOff(), this method
   applies to only a specific channel, not to all channels.  Further, it
   silences not only currently sounding notes, but also subsequently
   received notes.

   It is possible that the underlying synthesizer
   does not support muting channels. In order
   to verify that a call to setMute
   was successful, use getMute.

  mute - the new mute state - `boolean`"
  ([^javax.sound.midi.MidiChannel this ^Boolean mute]
    (-> this (.setMute mute))))

(defn set-channel-pressure
  "Reacts to a change in the keyboard pressure.  Channel
   pressure indicates how hard the keyboard player is depressing
   the entire keyboard.  This can be the maximum or
   average of the per-key pressure-sensor values, as set by
   setPolyPressure.  More commonly, it is a measurement of
   a single sensor on a device that doesn't implement polyphonic key
   pressure.  Pressure can be used to control various aspects of the sound,
   as described under setPolyPressure.

   It is possible that the underlying synthesizer
   does not support this MIDI message. In order
   to verify that setChannelPressure
   was successful, use getChannelPressure.

  pressure - the pressure with which the keyboard is being depressed, from 0 to 127 (127 = maximum pressure) - `int`"
  ([^javax.sound.midi.MidiChannel this ^Integer pressure]
    (-> this (.setChannelPressure pressure))))

(defn get-pitch-bend
  "Obtains the upward or downward pitch offset for this channel.
   If the device does not support setting pitch bend,
   this method always returns 8192. Calling
   setPitchBend will have no effect then.

  returns: bend amount, as a nonnegative 14-bit value (8192 = no bend) - `int`"
  ([^javax.sound.midi.MidiChannel this]
    (-> this (.getPitchBend))))

(defn all-sound-off
  "Immediately turns off all sounding notes on this channel, ignoring the
   state of the Hold Pedal and the internal decay rate of the current
   Instrument."
  ([^javax.sound.midi.MidiChannel this]
    (-> this (.allSoundOff))))

(defn set-solo
  "Sets the solo state for this channel.
   If solo is true only this channel
   and other soloed channels will sound. If solo
   is false then only other soloed channels will
   sound, unless no channels are soloed, in which case all
   unmuted channels will sound.

   It is possible that the underlying synthesizer
   does not support solo channels. In order
   to verify that a call to setSolo
   was successful, use getSolo.

  solo-state - new solo state for the channel - `boolean`"
  ([^javax.sound.midi.MidiChannel this ^Boolean solo-state]
    (-> this (.setSolo solo-state))))

(defn control-change
  "Reacts to a change in the specified controller's value.  A controller
   is some control other than a keyboard key, such as a
   switch, slider, pedal, wheel, or breath-pressure sensor.
   The MIDI 1.0 Specification provides standard numbers for typical
   controllers on MIDI devices, and describes the intended effect
   for some of the controllers.
   The way in which an
   Instrument reacts to a controller change may be
   specific to the Instrument.

   The MIDI 1.0 Specification defines both 7-bit controllers
   and 14-bit controllers.  Continuous controllers, such
   as wheels and sliders, typically have 14 bits (two MIDI bytes),
   while discrete controllers, such as switches, typically have 7 bits
   (one MIDI byte).  Refer to the specification to see the
   expected resolution for each type of control.

   Controllers 64 through 95 (0x40 - 0x5F) allow 7-bit precision.
   The value of a 7-bit controller is set completely by the
   value argument.  An additional set of controllers
   provide 14-bit precision by using two controller numbers, one
   for the most significant 7 bits and another for the least significant
   7 bits.  Controller numbers 0 through 31 (0x00 - 0x1F) control the
   most significant 7 bits of 14-bit controllers; controller numbers
   32 through 63 (0x20 - 0x3F) control the least significant 7 bits of
   these controllers.  For example, controller number 7 (0x07) controls
   the upper 7 bits of the channel volume controller, and controller
   number 39 (0x27) controls the lower 7 bits.
   The value of a 14-bit controller is determined
   by the interaction of the two halves.  When the most significant 7 bits
   of a controller are set (using controller numbers 0 through 31), the
   lower 7 bits are automatically set to 0.  The corresponding controller
   number for the lower 7 bits may then be used to further modulate the
   controller value.

   It is possible that the underlying synthesizer
   does not support a specific controller message. In order
   to verify that a call to controlChange
   was successful, use getController.

  controller - the controller number (0 to 127; see the MIDI 1.0 Specification for the interpretation) - `int`
  value - the value to which the specified controller is changed (0 to 127) - `int`"
  ([^javax.sound.midi.MidiChannel this ^Integer controller ^Integer value]
    (-> this (.controlChange controller value))))

(defn get-program
  "Obtains the current program number for this channel.

  returns: the program number of the currently selected patch - `int`"
  ([^javax.sound.midi.MidiChannel this]
    (-> this (.getProgram))))

(defn get-mute?
  "Obtains the current mute state for this channel.
   If the underlying synthesizer does not support
   muting this channel, this method always returns
   false.

  returns: true the channel is muted,
           or false if not - `boolean`"
  ([^javax.sound.midi.MidiChannel this]
    (-> this (.getMute))))

(defn get-channel-pressure
  "Obtains the channel's keyboard pressure.
   If the device does not support setting channel pressure,
   this method always returns 0. Calling
   setChannelPressure will have no effect then.

  returns: the amount of pressure for that note,
           from 0 to 127 (127 = maximum pressure) - `int`"
  ([^javax.sound.midi.MidiChannel this]
    (-> this (.getChannelPressure))))

(defn note-off
  "Turns the specified note off.  The key-up velocity, if not ignored, can
   be used to affect how quickly the note decays.
   In any case, the note might not die away instantaneously; its decay
   rate is determined by the internals of the Instrument.
   If the Hold Pedal (a controller; see
   controlChange)
   is down, the effect of this method is deferred until the pedal is
   released.

  note-number - the MIDI note number, from 0 to 127 (60 = Middle C) - `int`
  velocity - the speed with which the key was released - `int`"
  ([^javax.sound.midi.MidiChannel this ^Integer note-number ^Integer velocity]
    (-> this (.noteOff note-number velocity)))
  ([^javax.sound.midi.MidiChannel this ^Integer note-number]
    (-> this (.noteOff note-number))))

(defn get-mono?
  "Obtains the current mono/poly mode.
   Synthesizers that do not allow changing mono/poly mode
   will always return the same value, regardless
   of calls to setMono.

  returns: true if mono mode is on, otherwise
   false (meaning poly mode is on). - `boolean`"
  ([^javax.sound.midi.MidiChannel this]
    (-> this (.getMono))))

(defn reset-all-controllers
  "Resets all the implemented controllers to their default values."
  ([^javax.sound.midi.MidiChannel this]
    (-> this (.resetAllControllers))))

(defn get-solo?
  "Obtains the current solo state for this channel.
   If the underlying synthesizer does not support
   solo on this channel, this method always returns
   false.

  returns: true the channel is solo,
           or false if not - `boolean`"
  ([^javax.sound.midi.MidiChannel this]
    (-> this (.getSolo))))

(defn program-change
  "Changes the program using bank and program (patch) numbers.

   It is possible that the underlying synthesizer
   does not support a specific bank, or program. In order
   to verify that a call to programChange
   was successful, use getProgram and
   getController.
   Since banks are changed by way of control changes,
   you can verify the current bank with the following
   statement:


     int bank = (getController(0) * 128)
                 getController(32);

  bank - the bank number to switch to (0 to 16383) - `int`
  program - the program (patch) to use in the specified bank (0 to 127) - `int`"
  ([^javax.sound.midi.MidiChannel this ^Integer bank ^Integer program]
    (-> this (.programChange bank program)))
  ([^javax.sound.midi.MidiChannel this ^Integer program]
    (-> this (.programChange program))))

(defn all-notes-off
  "Turns off all notes that are currently sounding on this channel.
   The notes might not die away instantaneously; their decay
   rate is determined by the internals of the Instrument.
   If the Hold Pedal controller (see
   controlChange)
   is down, the effect of this method is deferred until the pedal is
   released."
  ([^javax.sound.midi.MidiChannel this]
    (-> this (.allNotesOff))))

(defn set-pitch-bend
  "Changes the pitch offset for all notes on this channel.
   This affects all currently sounding notes as well as subsequent ones.
   (For pitch bend to cease, the value needs to be reset to the
   center position.)
    The MIDI specification
   stipulates that pitch bend be a 14-bit value, where zero
   is maximum downward bend, 16383 is maximum upward bend, and
   8192 is the center (no pitch bend).  The actual
   amount of pitch change is not specified; it can be changed by
   a pitch-bend sensitivity setting.  However, the General MIDI
   specification says that the default range should be two semitones
   up and down from center.

   It is possible that the underlying synthesizer
   does not support this MIDI message. In order
   to verify that setPitchBend
   was successful, use getPitchBend.

  bend - the amount of pitch change, as a nonnegative 14-bit value (8192 = no bend) - `int`"
  ([^javax.sound.midi.MidiChannel this ^Integer bend]
    (-> this (.setPitchBend bend))))

(defn get-controller
  "Obtains the current value of the specified controller.  The return
   value is represented with 7 bits. For 14-bit controllers, the MSB and
   LSB controller value needs to be obtained separately. For example,
   the 14-bit value of the volume controller can be calculated by
   multiplying the value of controller 7 (0x07, channel volume MSB)
   with 128 and adding the
   value of controller 39 (0x27, channel volume LSB).

   If the device does not support setting a specific controller,
   this method returns 0 for that controller.
   Calling controlChange will have no effect then.

  controller - the number of the controller whose value is desired. The allowed range is 0-127; see the MIDI 1.0 Specification for the interpretation. - `int`

  returns: the current value of the specified controller (0 to 127) - `int`"
  ([^javax.sound.midi.MidiChannel this ^Integer controller]
    (-> this (.getController controller))))

(defn local-control
  "Turns local control on or off.  The default is for local control
   to be on.  The `on` setting means that if a device is capable
   of both synthesizing sound and transmitting MIDI messages,
   it will synthesize sound in response to the note-on and
   note-off messages that it itself transmits.  It will also respond
   to messages received from other transmitting devices.
   The `off` setting means that the synthesizer will ignore its
   own transmitted MIDI messages, but not those received from other devices.

   It is possible that the underlying synthesizer
   does not support local control. In order
   to verify that a call to localControl
   was successful, check the return value.

  on - true to turn local control on, false to turn local control off - `boolean`

  returns: the new local-control value, or false
           if local control is not supported - `boolean`"
  ([^javax.sound.midi.MidiChannel this ^Boolean on]
    (-> this (.localControl on))))

(defn set-poly-pressure
  "Reacts to a change in the specified note's key pressure.
   Polyphonic key pressure
   allows a keyboard player to press multiple keys simultaneously, each
   with a different amount of pressure.  The pressure, if not ignored,
   is typically used to vary such features as the volume, brightness,
   or vibrato of the note.

   It is possible that the underlying synthesizer
   does not support this MIDI message. In order
   to verify that setPolyPressure
   was successful, use getPolyPressure.

  note-number - the MIDI note number, from 0 to 127 (60 = Middle C) - `int`
  pressure - value for the specified key, from 0 to 127 (127 = maximum pressure) - `int`"
  ([^javax.sound.midi.MidiChannel this ^Integer note-number ^Integer pressure]
    (-> this (.setPolyPressure note-number pressure))))

