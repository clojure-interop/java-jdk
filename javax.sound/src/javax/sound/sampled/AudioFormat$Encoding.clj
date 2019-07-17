(ns javax.sound.sampled.AudioFormat$Encoding
  "The Encoding class  names the  specific type of data representation
  used for an audio stream.   The encoding includes aspects of the
  sound format other than the number of channels, sample rate, sample size,
  frame rate, frame size, and byte order.

  One ubiquitous type of audio encoding is pulse-code modulation (PCM),
  which is simply a linear (proportional) representation of the sound
  waveform.  With PCM, the number stored in each sample is proportional
  to the instantaneous amplitude of the sound pressure at that point in
  time.  The numbers may be signed or unsigned integers or floats.
  Besides PCM, other encodings include mu-law and a-law, which are nonlinear
  mappings of the sound amplitude that are often used for recording speech.

  You can use a predefined encoding by referring to one of the static
  objects created by this class, such as PCM_SIGNED or
  PCM_UNSIGNED.  Service providers can create new encodings, such as
  compressed audio formats, and make
  these available through the AudioSystem class.

  The Encoding class is static, so that all
  AudioFormat objects that have the same encoding will refer
  to the same object (rather than different instances of the same class).
  This allows matches to be made by checking that two format's encodings
  are equal."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled AudioFormat$Encoding]))

(defn ->encoding
  "Constructor.

  Constructs a new encoding.

  name - the name of the new type of encoding - `java.lang.String`"
  ([^java.lang.String name]
    (new AudioFormat$Encoding name)))

(def *-pcm-signed
  "Static Constant.

  Specifies signed, linear PCM data.

  type: javax.sound.sampled.AudioFormat.Encoding"
  AudioFormat$Encoding/PCM_SIGNED)

(def *-pcm-unsigned
  "Static Constant.

  Specifies unsigned, linear PCM data.

  type: javax.sound.sampled.AudioFormat.Encoding"
  AudioFormat$Encoding/PCM_UNSIGNED)

(def *-pcm-float
  "Static Constant.

  Specifies floating-point PCM data.

  type: javax.sound.sampled.AudioFormat.Encoding"
  AudioFormat$Encoding/PCM_FLOAT)

(def *-ulaw
  "Static Constant.

  Specifies u-law encoded data.

  type: javax.sound.sampled.AudioFormat.Encoding"
  AudioFormat$Encoding/ULAW)

(def *-alaw
  "Static Constant.

  Specifies a-law encoded data.

  type: javax.sound.sampled.AudioFormat.Encoding"
  AudioFormat$Encoding/ALAW)

(defn equals
  "Finalizes the equals method

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([^javax.sound.sampled.AudioFormat$Encoding this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Finalizes the hashCode method

  returns: a hash code value for this object. - `int`"
  ([^javax.sound.sampled.AudioFormat$Encoding this]
    (-> this (.hashCode))))

(defn to-string
  "Provides the String representation of the encoding.  This String is
   the same name that was passed to the constructor.  For the predefined encodings, the name
   is similar to the encoding's variable (field) name.  For example, PCM_SIGNED.toString() returns
   the name `pcm_signed`.

  returns: the encoding name - `java.lang.String`"
  ([^javax.sound.sampled.AudioFormat$Encoding this]
    (-> this (.toString))))

