(ns javax.sound.sampled.FloatControl$Type
  "An instance of the FloatControl.Type inner class identifies one kind of
  float control.  Static instances are provided for the
  common types."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled FloatControl$Type]))

(def *-master-gain
  "Static Constant.

  Represents a control for the overall gain on a line.

   Gain is a quantity in decibels (dB) that is added to the intrinsic
   decibel level of the audio signal--that is, the level of
   the signal before it is altered by the gain control.  A positive
   gain amplifies (boosts) the signal's volume, and a negative gain
   attenuates (cuts) it.
   The gain setting defaults to a value of 0.0 dB, meaning the signal's
   loudness is unaffected.   Note that gain measures dB, not amplitude.
   The relationship between a gain in decibels and the corresponding
   linear amplitude multiplier is:

   linearScalar = pow(10.0, gainDB/20.0)

   The FloatControl class has methods to impose a maximum and
   minimum allowable value for gain.  However, because an audio signal might
   already be at a high amplitude, the maximum setting does not guarantee
   that the signal will be undistorted when the gain is applied to it (unless
   the maximum is zero or negative). To avoid numeric overflow from excessively
   large gain settings, a gain control can implement
   clipping, meaning that the signal's amplitude will be limited to the maximum
   value representable by its audio format, instead of wrapping around.

   These comments apply to gain controls in general, not just master gain controls.
   A line can have more than one gain control.  For example, a mixer (which is
   itself a line) might have a master gain control, an auxiliary return control,
   a reverb return control, and, on each of its source lines, an individual aux
   send and reverb send.

  type: javax.sound.sampled.FloatControl$Type"
  FloatControl$Type/MASTER_GAIN)

(def *-aux-send
  "Static Constant.

  Represents a control for the auxiliary send gain on a line.

  type: javax.sound.sampled.FloatControl$Type"
  FloatControl$Type/AUX_SEND)

(def *-aux-return
  "Static Constant.

  Represents a control for the auxiliary return gain on a line.

  type: javax.sound.sampled.FloatControl$Type"
  FloatControl$Type/AUX_RETURN)

(def *-reverb-send
  "Static Constant.

  Represents a control for the pre-reverb gain on a line.
   This control may be used to affect how much
   of a line's signal is directed to a mixer's internal reverberation unit.

  type: javax.sound.sampled.FloatControl$Type"
  FloatControl$Type/REVERB_SEND)

(def *-reverb-return
  "Static Constant.

  Represents a control for the post-reverb gain on a line.
   This control may be used to control the relative amplitude
   of the signal returned from an internal reverberation unit.

  type: javax.sound.sampled.FloatControl$Type"
  FloatControl$Type/REVERB_RETURN)

(def *-volume
  "Static Constant.

  Represents a control for the volume on a line.

  type: javax.sound.sampled.FloatControl$Type"
  FloatControl$Type/VOLUME)

(def *-pan
  "Static Constant.

  Represents a control for the relative pan (left-right positioning)
   of the signal.  The signal may be mono; the pan setting affects how
   it is distributed by the mixer in a stereo mix.  The valid range of values is -1.0
   (left channel only) to 1.0 (right channel
   only).  The default is 0.0 (centered).

  type: javax.sound.sampled.FloatControl$Type"
  FloatControl$Type/PAN)

(def *-balance
  "Static Constant.

  Represents a control for the relative balance of a stereo signal
   between two stereo speakers.  The valid range of values is -1.0 (left channel only) to 1.0 (right channel
   only).  The default is 0.0 (centered).

  type: javax.sound.sampled.FloatControl$Type"
  FloatControl$Type/BALANCE)

(def *-sample-rate
  "Static Constant.

  Represents a control that changes the sample rate of audio playback.  The net effect
   of changing the sample rate depends on the relationship between
   the media's natural rate and the rate that is set via this control.
   The natural rate is the sample rate that is specified in the data line's
   AudioFormat object.  For example, if the natural rate
   of the media is 11025 samples per second and the sample rate is set
   to 22050 samples per second, the media will play back at twice the
   normal speed.

   Changing the sample rate with this control does not affect the data line's
   audio format.  Also note that whenever you change a sound's sample rate, a
   change in the sound's pitch results.  For example, doubling the sample
   rate has the effect of doubling the frequencies in the sound's spectrum,
   which raises the pitch by an octave.

  type: javax.sound.sampled.FloatControl$Type"
  FloatControl$Type/SAMPLE_RATE)

