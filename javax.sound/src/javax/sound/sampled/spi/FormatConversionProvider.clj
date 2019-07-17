(ns javax.sound.sampled.spi.FormatConversionProvider
  "A format conversion provider provides format conversion services
  from one or more input formats to one or more output formats.
  Converters include codecs, which encode and/or decode audio data,
  as well as transcoders, etc.  Format converters provide methods for
  determining what conversions are supported and for obtaining an audio
  stream from which converted data can be read.

  The source format represents the format of the incoming
  audio data, which will be converted.

  The target format represents the format of the processed, converted
  audio data.  This is the format of the data that can be read from
  the stream returned by one of the getAudioInputStream methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled.spi FormatConversionProvider]))

(defn ->format-conversion-provider
  "Constructor."
  ([]
    (new FormatConversionProvider )))

(defn get-source-encodings
  "Obtains the set of source format encodings from which format
   conversion services are provided by this provider.

  returns: array of source format encodings. If for some reason provider
   does not provide any conversion services, an array of length 0 is
   returned. - `javax.sound.sampled.AudioFormat.Encoding[]`"
  ([^javax.sound.sampled.spi.FormatConversionProvider this]
    (-> this (.getSourceEncodings))))

(defn get-target-encodings
  "Obtains the set of target format encodings supported by the format converter
   given a particular source format.
   If no target format encodings are supported for this source format,
   an array of length 0 is returned.

  source-format - format of the incoming data - `javax.sound.sampled.AudioFormat`

  returns: array of supported target format encodings. - `javax.sound.sampled.AudioFormat.Encoding[]`"
  ([^javax.sound.sampled.spi.FormatConversionProvider this ^javax.sound.sampled.AudioFormat source-format]
    (-> this (.getTargetEncodings source-format)))
  ([^javax.sound.sampled.spi.FormatConversionProvider this]
    (-> this (.getTargetEncodings))))

(defn source-encoding-supported?
  "Indicates whether the format converter supports conversion from the
   specified source format encoding.

  source-encoding - the source format encoding for which support is queried - `javax.sound.sampled.AudioFormat.Encoding`

  returns: true if the encoding is supported, otherwise false - `boolean`"
  (^Boolean [^javax.sound.sampled.spi.FormatConversionProvider this ^javax.sound.sampled.AudioFormat.Encoding source-encoding]
    (-> this (.isSourceEncodingSupported source-encoding))))

(defn target-encoding-supported?
  "Indicates whether the format converter supports conversion to the
   specified target format encoding.

  target-encoding - the target format encoding for which support is queried - `javax.sound.sampled.AudioFormat.Encoding`

  returns: true if the encoding is supported, otherwise false - `boolean`"
  (^Boolean [^javax.sound.sampled.spi.FormatConversionProvider this ^javax.sound.sampled.AudioFormat.Encoding target-encoding]
    (-> this (.isTargetEncodingSupported target-encoding))))

(defn conversion-supported?
  "Indicates whether the format converter supports conversion to a particular encoding
   from a particular format.

  target-encoding - desired encoding of the outgoing data - `javax.sound.sampled.AudioFormat.Encoding`
  source-format - format of the incoming data - `javax.sound.sampled.AudioFormat`

  returns: true if the conversion is supported, otherwise false - `boolean`"
  (^Boolean [^javax.sound.sampled.spi.FormatConversionProvider this ^javax.sound.sampled.AudioFormat.Encoding target-encoding ^javax.sound.sampled.AudioFormat source-format]
    (-> this (.isConversionSupported target-encoding source-format))))

(defn get-target-formats
  "Obtains the set of target formats with the encoding specified
   supported by the format converter
   If no target formats with the specified encoding are supported
   for this source format, an array of length 0 is returned.

  target-encoding - desired encoding of the stream after processing - `javax.sound.sampled.AudioFormat.Encoding`
  source-format - format of the incoming data - `javax.sound.sampled.AudioFormat`

  returns: array of supported target formats. - `javax.sound.sampled.AudioFormat[]`"
  ([^javax.sound.sampled.spi.FormatConversionProvider this ^javax.sound.sampled.AudioFormat.Encoding target-encoding ^javax.sound.sampled.AudioFormat source-format]
    (-> this (.getTargetFormats target-encoding source-format))))

(defn get-audio-input-stream
  "Obtains an audio input stream with the specified encoding from the given audio
   input stream.

  target-encoding - desired encoding of the stream after processing - `javax.sound.sampled.AudioFormat.Encoding`
  source-stream - stream from which data to be processed should be read - `javax.sound.sampled.AudioInputStream`

  returns: stream from which processed data with the specified target encoding may be read - `javax.sound.sampled.AudioInputStream`

  throws: java.lang.IllegalArgumentException - if the format combination supplied is not supported."
  (^javax.sound.sampled.AudioInputStream [^javax.sound.sampled.spi.FormatConversionProvider this ^javax.sound.sampled.AudioFormat.Encoding target-encoding ^javax.sound.sampled.AudioInputStream source-stream]
    (-> this (.getAudioInputStream target-encoding source-stream))))

