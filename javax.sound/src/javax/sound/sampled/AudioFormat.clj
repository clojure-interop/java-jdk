(ns javax.sound.sampled.AudioFormat
  "AudioFormat is the class that specifies a particular arrangement of data in a sound stream.
  By examining the information stored in the audio format, you can discover how to interpret the bits in the
  binary sound data.

  Every data line has an audio format associated with its data stream. The audio format of a source (playback) data line indicates
  what kind of data the data line expects to receive for output.  For a target (capture) data line, the audio format specifies the kind
  of the data that can be read from the line.
  Sound files also have audio formats, of course.  The AudioFileFormat
  class encapsulates an AudioFormat in addition to other,
  file-specific information.  Similarly, an AudioInputStream has an
  AudioFormat.

  The AudioFormat class accommodates a number of common sound-file encoding techniques, including
  pulse-code modulation (PCM), mu-law encoding, and a-law encoding.  These encoding techniques are predefined,
  but service providers can create new encoding types.
  The encoding that a specific format uses is named by its encoding field.

  In addition to the encoding, the audio format includes other properties that further specify the exact
  arrangement of the data.
  These include the number of channels, sample rate, sample size, byte order, frame rate, and frame size.
  Sounds may have different numbers of audio channels: one for mono, two for stereo.
  The sample rate measures how many `snapshots` (samples) of the sound pressure are taken per second, per channel.
  (If the sound is stereo rather than mono, two samples are actually measured at each instant of time: one for the left channel,
  and another for the right channel; however, the sample rate still measures the number per channel, so the rate is the same
  regardless of the number of channels.   This is the standard use of the term.)
  The sample size indicates how many bits are used to store each snapshot; 8 and 16 are typical values.
  For 16-bit samples (or any other sample size larger than a byte),
  byte order is important; the bytes in each sample are arranged in
  either the `little-endian` or `big-endian` style.
  For encodings like PCM, a frame consists of the set of samples for all channels at a given
  point in time, and so the size of a frame (in bytes) is always equal to the size of a sample (in bytes) times
  the number of channels.  However, with some other sorts of encodings a frame can contain
  a bundle of compressed data for a whole series of samples, as well as additional, non-sample
  data.  For such encodings, the sample rate and sample size refer to the data after it is decoded into PCM,
  and so they are completely different from the frame rate and frame size.

  An AudioFormat object can include a set of
  properties. A property is a pair of key and value: the key
  is of type String, the associated property
  value is an arbitrary object. Properties specify
  additional format specifications, like the bit rate for
  compressed formats. Properties are mainly used as a means
  to transport additional information of the audio format
  to and from the service providers. Therefore, properties
  are ignored in the matches(AudioFormat) method.
  However, methods which rely on the installed service
  providers, like (AudioFormat, AudioFormat) isConversionSupported may consider
  properties, depending on the respective service provider
  implementation.

  The following table lists some common properties which
  service providers should use, if applicable:


   Audio Format Properties

    Property key
    Value type
    Description


    `bitrate`
    Integer
    average bit rate in bits per second


    `vbr`
    Boolean
    true, if the file is encoded in variable bit
        rate (VBR)


    `quality`
    Integer
    encoding/conversion quality, 1..100



  Vendors of service providers (plugins) are encouraged
  to seek information about other already established
  properties in third party plugins, and follow the same
  conventions."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled AudioFormat]))

(defn ->audio-format
  "Constructor.

  Constructs an AudioFormat with the given parameters.
   The encoding specifies the convention used to represent the data.
   The other parameters are further explained in the class description.

  encoding - the audio encoding technique - `javax.sound.sampled.AudioFormat$Encoding`
  sample-rate - the number of samples per second - `float`
  sample-size-in-bits - the number of bits in each sample - `int`
  channels - the number of channels (1 for mono, 2 for stereo, and so on) - `int`
  frame-size - the number of bytes in each frame - `int`
  frame-rate - the number of frames per second - `float`
  big-endian - indicates whether the data for a single sample is stored in big-endian byte order (false means little-endian) - `boolean`
  properties - a Map<String,Object> object containing format properties - `java.util.Map`"
  (^AudioFormat [^javax.sound.sampled.AudioFormat$Encoding encoding ^Float sample-rate ^Integer sample-size-in-bits ^Integer channels ^Integer frame-size ^Float frame-rate ^Boolean big-endian ^java.util.Map properties]
    (new AudioFormat encoding sample-rate sample-size-in-bits channels frame-size frame-rate big-endian properties))
  (^AudioFormat [^javax.sound.sampled.AudioFormat$Encoding encoding ^Float sample-rate ^Integer sample-size-in-bits ^Integer channels ^Integer frame-size ^Float frame-rate ^Boolean big-endian]
    (new AudioFormat encoding sample-rate sample-size-in-bits channels frame-size frame-rate big-endian))
  (^AudioFormat [^Float sample-rate ^Integer sample-size-in-bits ^Integer channels ^Boolean signed ^Boolean big-endian]
    (new AudioFormat sample-rate sample-size-in-bits channels signed big-endian)))

(defn properties
  "Obtain an unmodifiable map of properties.
   The concept of properties is further explained in
   the class description.

  returns: a Map<String,Object> object containing
           all properties. If no properties are recognized, an empty map is
           returned. - `java.util.Map<java.lang.String,java.lang.Object>`"
  (^java.util.Map [^AudioFormat this]
    (-> this (.properties))))

(defn get-sample-rate
  "Obtains the sample rate.
   For compressed formats, the return value is the sample rate of the uncompressed
   audio data.
   When this AudioFormat is used for queries (e.g. AudioSystem.isConversionSupported) or capabilities (e.g. DataLine.Info.getFormats), a sample rate of
   AudioSystem.NOT_SPECIFIED means that any sample rate is
   acceptable. AudioSystem.NOT_SPECIFIED is also returned when
   the sample rate is not defined for this audio format.

  returns: the number of samples per second,
   or AudioSystem.NOT_SPECIFIED - `float`"
  (^Float [^AudioFormat this]
    (-> this (.getSampleRate))))

(defn get-encoding
  "Obtains the type of encoding for sounds in this format.

  returns: the encoding type - `javax.sound.sampled.AudioFormat$Encoding`"
  (^javax.sound.sampled.AudioFormat$Encoding [^AudioFormat this]
    (-> this (.getEncoding))))

(defn to-string
  "Returns a string that describes the format, such as:
   `PCM SIGNED 22050 Hz 16 bit mono big-endian`.  The contents of the string
   may vary between implementations of Java Sound.

  returns: a string that describes the format parameters - `java.lang.String`"
  (^java.lang.String [^AudioFormat this]
    (-> this (.toString))))

(defn get-sample-size-in-bits
  "Obtains the size of a sample.
   For compressed formats, the return value is the sample size of the
   uncompressed audio data.
   When this AudioFormat is used for queries (e.g. AudioSystem.isConversionSupported) or capabilities (e.g. DataLine.Info.getFormats), a sample size of
   AudioSystem.NOT_SPECIFIED means that any sample size is
   acceptable. AudioSystem.NOT_SPECIFIED is also returned when
   the sample size is not defined for this audio format.

  returns: the number of bits in each sample,
   or AudioSystem.NOT_SPECIFIED - `int`"
  (^Integer [^AudioFormat this]
    (-> this (.getSampleSizeInBits))))

(defn get-channels
  "Obtains the number of channels.
   When this AudioFormat is used for queries (e.g. AudioSystem.isConversionSupported) or capabilities (e.g. DataLine.Info.getFormats), a return value of
   AudioSystem.NOT_SPECIFIED means that any (positive) number of channels is
   acceptable.

  returns: The number of channels (1 for mono, 2 for stereo, etc.),
   or AudioSystem.NOT_SPECIFIED - `int`"
  (^Integer [^AudioFormat this]
    (-> this (.getChannels))))

(defn get-frame-size
  "Obtains the frame size in bytes.
   When this AudioFormat is used for queries (e.g. AudioSystem.isConversionSupported) or capabilities (e.g. DataLine.Info.getFormats), a frame size of
   AudioSystem.NOT_SPECIFIED means that any frame size is
   acceptable. AudioSystem.NOT_SPECIFIED is also returned when
   the frame size is not defined for this audio format.

  returns: the number of bytes per frame,
   or AudioSystem.NOT_SPECIFIED - `int`"
  (^Integer [^AudioFormat this]
    (-> this (.getFrameSize))))

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
  (^java.lang.Object [^AudioFormat this ^java.lang.String key]
    (-> this (.getProperty key))))

(defn get-frame-rate
  "Obtains the frame rate in frames per second.
   When this AudioFormat is used for queries (e.g. AudioSystem.isConversionSupported) or capabilities (e.g. DataLine.Info.getFormats), a frame rate of
   AudioSystem.NOT_SPECIFIED means that any frame rate is
   acceptable. AudioSystem.NOT_SPECIFIED is also returned when
   the frame rate is not defined for this audio format.

  returns: the number of frames per second,
   or AudioSystem.NOT_SPECIFIED - `float`"
  (^Float [^AudioFormat this]
    (-> this (.getFrameRate))))

(defn matches
  "Indicates whether this format matches the one specified.
   To match, two formats must have the same encoding,
   and consistent values of the number of channels, sample rate, sample size,
   frame rate, and frame size.
   The values of the property are consistent if they are equal
   or the specified format has the property value
   AudioSystem.NOT_SPECIFIED.
   The byte order (big-endian or little-endian) must be the same
   if the sample size is greater than one byte.

  format - format to test for match - `javax.sound.sampled.AudioFormat`

  returns: true if this format matches the one specified,
           false otherwise. - `boolean`"
  (^Boolean [^AudioFormat this ^javax.sound.sampled.AudioFormat format]
    (-> this (.matches format))))

(defn big-endian?
  "Indicates whether the audio data is stored in big-endian or little-endian
   byte order.  If the sample size is not more than one byte, the return value is
   irrelevant.

  returns: true if the data is stored in big-endian byte order,
   false if little-endian - `boolean`"
  (^Boolean [^AudioFormat this]
    (-> this (.isBigEndian))))

