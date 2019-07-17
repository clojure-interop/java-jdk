(ns javax.sound.sampled.AudioSystem
  "The AudioSystem class acts as the entry point to the
  sampled-audio system resources. This class lets you query and
  access the mixers that are installed on the system.
  AudioSystem includes a number of
  methods for converting audio data between different formats, and for
  translating between audio files and streams. It also provides a method
  for obtaining a Line directly from the
  AudioSystem without dealing explicitly
  with mixers.

  Properties can be used to specify the default mixer
  for specific line types.
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


   Audio System Property Keys

    Property Key
    Interface
    Affected Method(s)


    javax.sound.sampled.Clip
    Clip
    getLine(javax.sound.sampled.Line.Info), getClip()


    javax.sound.sampled.Port
    Port
    getLine(javax.sound.sampled.Line.Info)


    javax.sound.sampled.SourceDataLine
    SourceDataLine
    getLine(javax.sound.sampled.Line.Info), getSourceDataLine(javax.sound.sampled.AudioFormat)


    javax.sound.sampled.TargetDataLine
    TargetDataLine
    getLine(javax.sound.sampled.Line.Info), getTargetDataLine(javax.sound.sampled.AudioFormat)



  The property value consists of the provider class name
  and the mixer name, separated by the hash mark (`#`).
  The provider class name is the fully-qualified
  name of a concrete mixer provider class. The mixer name is matched against
  the String returned by the getName
  method of Mixer.Info.
  Either the class name, or the mixer name may be omitted.
  If only the class name is specified, the trailing hash mark
  is optional.

  If the provider class is specified, and it can be
  successfully retrieved from the installed providers, the list of
  Mixer.Info objects is retrieved
  from the provider. Otherwise, or when these mixers
  do not provide a subsequent match, the list is retrieved
  from getMixerInfo() to contain
  all available Mixer.Info objects.

  If a mixer name is specified, the resulting list of
  Mixer.Info objects is searched:
  the first one with a matching name, and whose
  Mixer provides the
  respective line interface, will be returned.
  If no matching Mixer.Info object
  is found, or the mixer name is not specified,
  the first mixer from the resulting
  list, which provides the respective line
  interface, will be returned.

  For example, the property javax.sound.sampled.Clip
  with a value
  `com.sun.media.sound.MixerProvider#SunClip`
  will have the following consequences when
  getLine is called requesting a Clip
  instance:
  if the class com.sun.media.sound.MixerProvider exists
  in the list of installed mixer providers,
  the first Clip from the first mixer with name
  `SunClip` will be returned. If it cannot
  be found, the first Clip from the first mixer
  of the specified provider will be returned, regardless of name.
  If there is none, the first Clip from the first
  Mixer with name
  `SunClip` in the list of all mixers
  (as returned by getMixerInfo) will be returned,
  or, if not found, the first Clip of the first
  Mixerthat can be found in the list of all
  mixers is returned.
  If that fails, too, an IllegalArgumentException
  is thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled AudioSystem]))

(def *-not-specified
  "Static Constant.

  An integer that stands for an unknown numeric value.
   This value is appropriate only for signed quantities that do not
   normally take negative values.  Examples include file sizes, frame
   sizes, buffer sizes, and sample rates.
   A number of Java Sound constructors accept
   a value of NOT_SPECIFIED for such parameters.  Other
   methods may also accept or return this value, as documented.

  type: int"
  AudioSystem/NOT_SPECIFIED)

(defn *file-type-supported?
  "Indicates whether an audio file of the specified file type can be written
   from the indicated audio input stream.

  file-type - the file type for which write capabilities are queried - `javax.sound.sampled.AudioFileFormat.Type`
  stream - the stream for which file-writing support is queried - `javax.sound.sampled.AudioInputStream`

  returns: true if the file type is supported for this audio input stream,
   otherwise false - `boolean`"
  (^Boolean [^javax.sound.sampled.AudioFileFormat.Type file-type ^javax.sound.sampled.AudioInputStream stream]
    (AudioSystem/isFileTypeSupported file-type stream))
  (^Boolean [^javax.sound.sampled.AudioFileFormat.Type file-type]
    (AudioSystem/isFileTypeSupported file-type)))

(defn *get-clip
  "Obtains a clip from the specified mixer that can be
   used for playing back an audio file or an audio stream.

   The returned clip must be opened with the
   open(AudioFormat) or
   open(AudioInputStream) method.

   This is a high-level method that uses getMixer
   and getLine internally.

  mixer-info - a Mixer.Info object representing the desired mixer, or null for the system default mixer - `javax.sound.sampled.Mixer.Info`

  returns: a clip object from the specified mixer - `javax.sound.sampled.Clip`

  throws: javax.sound.sampled.LineUnavailableException - if a clip is not available from this mixer due to resource restrictions"
  (^javax.sound.sampled.Clip [^javax.sound.sampled.Mixer.Info mixer-info]
    (AudioSystem/getClip mixer-info))
  (^javax.sound.sampled.Clip []
    (AudioSystem/getClip )))

(defn *get-source-line-info
  "Obtains information about all source lines of a particular type that are supported
   by the installed mixers.

  info - a Line.Info object that specifies the kind of lines about which information is requested - `javax.sound.sampled.Line.Info`

  returns: an array of Line.Info objects describing source lines matching
   the type requested.  If no matching source lines are supported, an array of length 0
   is returned. - `javax.sound.sampled.Line.Info[]`"
  ([^javax.sound.sampled.Line.Info info]
    (AudioSystem/getSourceLineInfo info)))

(defn *get-target-line-info
  "Obtains information about all target lines of a particular type that are supported
   by the installed mixers.

  info - a Line.Info object that specifies the kind of lines about which information is requested - `javax.sound.sampled.Line.Info`

  returns: an array of Line.Info objects describing target lines matching
   the type requested.  If no matching target lines are supported, an array of length 0
   is returned. - `javax.sound.sampled.Line.Info[]`"
  ([^javax.sound.sampled.Line.Info info]
    (AudioSystem/getTargetLineInfo info)))

(defn *get-audio-file-types
  "Obtains the file types that the system can write from the
   audio input stream specified.

  stream - the audio input stream for which audio file type support is queried - `javax.sound.sampled.AudioInputStream`

  returns: array of file types.  If no file types are supported,
   an array of length 0 is returned. - `javax.sound.sampled.AudioFileFormat.Type[]`"
  ([^javax.sound.sampled.AudioInputStream stream]
    (AudioSystem/getAudioFileTypes stream))
  ([]
    (AudioSystem/getAudioFileTypes )))

(defn *get-target-data-line
  "Obtains a target data line that can be used for recording
   audio data in the format specified by the
   AudioFormat object, provided by the mixer
   specified by the Mixer.Info object.

   The returned line should be opened with the
   open(AudioFormat) or
   open(AudioFormat, int) method.

   This is a high-level method that uses getMixer
   and getLine internally.

   The returned TargetDataLine's default
   audio format will be initialized with format.

  format - an AudioFormat object specifying the supported audio format of the returned line, or null for any audio format - `javax.sound.sampled.AudioFormat`
  mixerinfo - a Mixer.Info object representing the desired mixer, or null for the system default mixer - `javax.sound.sampled.Mixer.Info`

  returns: the desired TargetDataLine object - `javax.sound.sampled.TargetDataLine`

  throws: javax.sound.sampled.LineUnavailableException - if a matching target data line is not available from the specified mixer due to resource restrictions"
  (^javax.sound.sampled.TargetDataLine [^javax.sound.sampled.AudioFormat format ^javax.sound.sampled.Mixer.Info mixerinfo]
    (AudioSystem/getTargetDataLine format mixerinfo))
  (^javax.sound.sampled.TargetDataLine [^javax.sound.sampled.AudioFormat format]
    (AudioSystem/getTargetDataLine format)))

(defn *get-audio-file-format
  "Obtains the audio file format of the provided input stream.  The stream must
   point to valid audio file data.  The implementation of this method may require
   multiple parsers to examine the stream to determine whether they support it.
   These parsers must be able to mark the stream, read enough data to determine whether they
   support the stream, and, if not, reset the stream's read pointer to its original
   position.  If the input stream does not support these operations, this method may fail
   with an IOException.

  stream - the input stream from which file format information should be extracted - `java.io.InputStream`

  returns: an AudioFileFormat object describing the stream's audio file format - `javax.sound.sampled.AudioFileFormat`

  throws: javax.sound.sampled.UnsupportedAudioFileException - if the stream does not point to valid audio file data recognized by the system"
  (^javax.sound.sampled.AudioFileFormat [^java.io.InputStream stream]
    (AudioSystem/getAudioFileFormat stream)))

(defn *line-supported?
  "Indicates whether the system supports any lines that match
   the specified Line.Info object.  A line is supported if
   any installed mixer supports it.

  info - a Line.Info object describing the line for which support is queried - `javax.sound.sampled.Line.Info`

  returns: true if at least one matching line is
   supported, otherwise false - `boolean`"
  (^Boolean [^javax.sound.sampled.Line.Info info]
    (AudioSystem/isLineSupported info)))

(defn *get-mixer
  "Obtains the requested audio mixer.

  info - a Mixer.Info object representing the desired mixer, or null for the system default mixer - `javax.sound.sampled.Mixer.Info`

  returns: the requested mixer - `javax.sound.sampled.Mixer`

  throws: java.lang.SecurityException - if the requested mixer is unavailable because of security restrictions"
  (^javax.sound.sampled.Mixer [^javax.sound.sampled.Mixer.Info info]
    (AudioSystem/getMixer info)))

(defn *get-mixer-info
  "Obtains an array of mixer info objects that represents
   the set of audio mixers that are currently installed on the system.

  returns: an array of info objects for the currently installed mixers.  If no mixers
   are available on the system, an array of length 0 is returned. - `javax.sound.sampled.Mixer.Info[]`"
  ([]
    (AudioSystem/getMixerInfo )))

(defn *get-target-formats
  "Obtains the formats that have a particular encoding and that the system can
   obtain from a stream of the specified format using the set of
   installed format converters.

  target-encoding - the desired encoding after conversion - `javax.sound.sampled.AudioFormat.Encoding`
  source-format - the audio format before conversion - `javax.sound.sampled.AudioFormat`

  returns: array of formats.  If no formats of the specified
   encoding are supported, an array of length 0 is returned. - `javax.sound.sampled.AudioFormat[]`"
  ([^javax.sound.sampled.AudioFormat.Encoding target-encoding ^javax.sound.sampled.AudioFormat source-format]
    (AudioSystem/getTargetFormats target-encoding source-format)))

(defn *conversion-supported?
  "Indicates whether an audio input stream of the specified encoding
   can be obtained from an audio input stream that has the specified
   format.

  target-encoding - the desired encoding after conversion - `javax.sound.sampled.AudioFormat.Encoding`
  source-format - the audio format before conversion - `javax.sound.sampled.AudioFormat`

  returns: true if the conversion is supported,
   otherwise false - `boolean`"
  (^Boolean [^javax.sound.sampled.AudioFormat.Encoding target-encoding ^javax.sound.sampled.AudioFormat source-format]
    (AudioSystem/isConversionSupported target-encoding source-format)))

(defn *get-line
  "Obtains a line that matches the description in the specified
   Line.Info object.

   If a DataLine is requested, and info
   is an instance of DataLine.Info specifying at least
   one fully qualified audio format, the last one
   will be used as the default format of the returned
   DataLine.

   If system properties
   javax.sound.sampled.Clip,
   javax.sound.sampled.Port,
   javax.sound.sampled.SourceDataLine and
   javax.sound.sampled.TargetDataLine are defined
   or they are defined in the file `sound.properties`,
   they are used to retrieve default lines.
   For details, refer to the class description.

   If the respective property is not set, or the mixer
   requested in the property is not installed or does not provide the
   requested line, all installed mixers are queried for the
   requested line type. A Line will be returned from the first mixer
   providing the requested line type.

  info - a Line.Info object describing the desired kind of line - `javax.sound.sampled.Line.Info`

  returns: a line of the requested kind - `javax.sound.sampled.Line`

  throws: javax.sound.sampled.LineUnavailableException - if a matching line is not available due to resource restrictions"
  (^javax.sound.sampled.Line [^javax.sound.sampled.Line.Info info]
    (AudioSystem/getLine info)))

(defn *get-source-data-line
  "Obtains a source data line that can be used for playing back
   audio data in the format specified by the
   AudioFormat object, provided by the mixer
   specified by the Mixer.Info object.

   The returned line should be opened with the
   open(AudioFormat) or
   open(AudioFormat, int) method.

   This is a high-level method that uses getMixer
   and getLine internally.

   The returned SourceDataLine's default
   audio format will be initialized with format.

  format - an AudioFormat object specifying the supported audio format of the returned line, or null for any audio format - `javax.sound.sampled.AudioFormat`
  mixerinfo - a Mixer.Info object representing the desired mixer, or null for the system default mixer - `javax.sound.sampled.Mixer.Info`

  returns: the desired SourceDataLine object - `javax.sound.sampled.SourceDataLine`

  throws: javax.sound.sampled.LineUnavailableException - if a matching source data line is not available from the specified mixer due to resource restrictions"
  (^javax.sound.sampled.SourceDataLine [^javax.sound.sampled.AudioFormat format ^javax.sound.sampled.Mixer.Info mixerinfo]
    (AudioSystem/getSourceDataLine format mixerinfo))
  (^javax.sound.sampled.SourceDataLine [^javax.sound.sampled.AudioFormat format]
    (AudioSystem/getSourceDataLine format)))

(defn *write
  "Writes a stream of bytes representing an audio file of the specified file type
   to the output stream provided.  Some file types require that
   the length be written into the file header; such files cannot be written from
   start to finish unless the length is known in advance.  An attempt
   to write a file of such a type will fail with an IOException if the length in
   the audio file type is AudioSystem.NOT_SPECIFIED.

  stream - the audio input stream containing audio data to be written to the file - `javax.sound.sampled.AudioInputStream`
  file-type - the kind of audio file to write - `javax.sound.sampled.AudioFileFormat.Type`
  out - the stream to which the file data should be written - `java.io.OutputStream`

  returns: the number of bytes written to the output stream - `int`

  throws: java.io.IOException - if an input/output exception occurs"
  (^Integer [^javax.sound.sampled.AudioInputStream stream ^javax.sound.sampled.AudioFileFormat.Type file-type ^java.io.OutputStream out]
    (AudioSystem/write stream file-type out)))

(defn *get-audio-input-stream
  "Obtains an audio input stream of the indicated encoding, by converting the
   provided audio input stream.

  target-encoding - the desired encoding after conversion - `javax.sound.sampled.AudioFormat.Encoding`
  source-stream - the stream to be converted - `javax.sound.sampled.AudioInputStream`

  returns: an audio input stream of the indicated encoding - `javax.sound.sampled.AudioInputStream`

  throws: java.lang.IllegalArgumentException - if the conversion is not supported"
  (^javax.sound.sampled.AudioInputStream [^javax.sound.sampled.AudioFormat.Encoding target-encoding ^javax.sound.sampled.AudioInputStream source-stream]
    (AudioSystem/getAudioInputStream target-encoding source-stream))
  (^javax.sound.sampled.AudioInputStream [^java.io.InputStream stream]
    (AudioSystem/getAudioInputStream stream)))

(defn *get-target-encodings
  "Obtains the encodings that the system can obtain from an
   audio input stream with the specified encoding using the set
   of installed format converters.

  source-encoding - the encoding for which conversion support is queried - `javax.sound.sampled.AudioFormat.Encoding`

  returns: array of encodings.  If sourceEncodingis not supported,
   an array of length 0 is returned. Otherwise, the array will have a length
   of at least 1, representing sourceEncoding (no conversion). - `javax.sound.sampled.AudioFormat.Encoding[]`"
  ([^javax.sound.sampled.AudioFormat.Encoding source-encoding]
    (AudioSystem/getTargetEncodings source-encoding)))

