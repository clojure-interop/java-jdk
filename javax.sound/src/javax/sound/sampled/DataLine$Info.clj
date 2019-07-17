(ns javax.sound.sampled.DataLine$Info
  "Besides the class information inherited from its superclass,
  DataLine.Info provides additional information specific to data lines.
  This information includes:

   the audio formats supported by the data line
   the minimum and maximum sizes of its internal buffer

  Because a Line.Info knows the class of the line its describes, a
  DataLine.Info object can describe DataLine
  subinterfaces such as SourceDataLine,
  TargetDataLine, and Clip.
  You can query a mixer for lines of any of these types, passing an appropriate
  instance of DataLine.Info as the argument to a method such as
  Mixer.getLine(Line.Info)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled DataLine$Info]))

(defn ->info
  "Constructor.

  Constructs a data line's info object from the specified information,
   which includes a set of supported audio formats and a range for the buffer size.
   This constructor is typically used by mixer implementations
   when returning information about a supported line.

  line-class - the class of the data line described by the info object - `java.lang.Class<?>`
  formats - set of formats supported - `javax.sound.sampled.AudioFormat[]`
  min-buffer-size - minimum buffer size supported by the data line, in bytes - `int`
  max-buffer-size - maximum buffer size supported by the data line, in bytes - `int`"
  ([^java.lang.Class line-class ^javax.sound.sampled.AudioFormat[] formats ^Integer min-buffer-size ^Integer max-buffer-size]
    (new DataLine$Info line-class formats min-buffer-size max-buffer-size))
  ([^java.lang.Class line-class ^javax.sound.sampled.AudioFormat format ^Integer buffer-size]
    (new DataLine$Info line-class format buffer-size))
  ([^java.lang.Class line-class ^javax.sound.sampled.AudioFormat format]
    (new DataLine$Info line-class format)))

(defn get-formats
  "Obtains a set of audio formats supported by the data line.
   Note that isFormatSupported(AudioFormat) might return
   true for certain additional formats that are missing from
   the set returned by getFormats().  The reverse is not
   the case: isFormatSupported(AudioFormat) is guaranteed to return
   true for all formats returned by getFormats().

   Some fields in the AudioFormat instances can be set to
   NOT_SPECIFIED
   if that field does not apply to the format,
   or if the format supports a wide range of values for that field.
   For example, a multi-channel device supporting up to
   64 channels, could set the channel field in the
   AudioFormat instances returned by this
   method to NOT_SPECIFIED.

  returns: a set of supported audio formats. - `javax.sound.sampled.AudioFormat[]`"
  ([^javax.sound.sampled.DataLine$Info this]
    (-> this (.getFormats))))

(defn format-supported?
  "Indicates whether this data line supports a particular audio format.
   The default implementation of this method simply returns true if
   the specified format matches any of the supported formats.

  format - the audio format for which support is queried. - `javax.sound.sampled.AudioFormat`

  returns: true if the format is supported, otherwise false - `boolean`"
  ([^javax.sound.sampled.DataLine$Info this ^javax.sound.sampled.AudioFormat format]
    (-> this (.isFormatSupported format))))

(defn get-min-buffer-size
  "Obtains the minimum buffer size supported by the data line.

  returns: minimum buffer size in bytes, or AudioSystem.NOT_SPECIFIED - `int`"
  ([^javax.sound.sampled.DataLine$Info this]
    (-> this (.getMinBufferSize))))

(defn get-max-buffer-size
  "Obtains the maximum buffer size supported by the data line.

  returns: maximum buffer size in bytes, or AudioSystem.NOT_SPECIFIED - `int`"
  ([^javax.sound.sampled.DataLine$Info this]
    (-> this (.getMaxBufferSize))))

(defn matches
  "Determines whether the specified info object matches this one.
   To match, the superclass match requirements must be met.  In
   addition, this object's minimum buffer size must be at least as
   large as that of the object specified, its maximum buffer size must
   be at most as large as that of the object specified, and all of its
   formats must match formats supported by the object specified.

  info - the info object which is being compared to this one - `javax.sound.sampled.Line.Info`

  returns: true if this object matches the one specified,
   otherwise false. - `boolean`"
  ([^javax.sound.sampled.DataLine$Info this ^javax.sound.sampled.Line.Info info]
    (-> this (.matches info))))

(defn to-string
  "Obtains a textual description of the data line info.

  returns: a string description - `java.lang.String`"
  ([^javax.sound.sampled.DataLine$Info this]
    (-> this (.toString))))

