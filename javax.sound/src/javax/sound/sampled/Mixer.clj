(ns javax.sound.sampled.Mixer
  "A mixer is an audio device with one or more lines.  It need not be
  designed for mixing audio signals.  A mixer that actually mixes audio
  has multiple input (source) lines and at least one output (target) line.
  The former are often instances of classes that implement
  SourceDataLine,
  and the latter, TargetDataLine.  Port
  objects, too, are either source lines or target lines.
  A mixer can accept prerecorded, loopable sound as input, by having
  some of its source lines be instances of objects that implement the
  Clip interface.

  Through methods of the Line interface, which Mixer extends,
  a mixer might provide a set of controls that are global to the mixer.  For example,
  the mixer can have a master gain control.  These global controls are distinct
  from the controls belonging to each of the mixer's individual lines.

  Some mixers, especially
  those with internal digital mixing capabilities, may provide
  additional capabilities by implementing the DataLine interface.

  A mixer can support synchronization of its lines.  When one line in
  a synchronized group is started or stopped, the other lines in the group
  automatically start or stop simultaneously with the explicitly affected one."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled Mixer]))

(defn get-source-lines
  "Obtains the set of all source lines currently open to this mixer.

  returns: the source lines currently open to the mixer.
   If no source lines are currently open to this mixer,  an
   array of length 0 is returned. - `javax.sound.sampled.Line[]`

  throws: java.lang.SecurityException - if the matching lines are not available due to security restrictions"
  ([^javax.sound.sampled.Mixer this]
    (-> this (.getSourceLines))))

(defn get-source-line-info
  "Obtains information about source lines of a particular type supported
   by the mixer.
   Some source lines may only be available when this mixer is open.

  info - a Line.Info object describing lines about which information is queried - `javax.sound.sampled.Line.Info`

  returns: an array of Line.Info objects describing source lines matching
   the type requested.  If no matching source lines are supported, an array of length 0
   is returned. - `javax.sound.sampled.Line.Info[]`"
  ([^javax.sound.sampled.Mixer this ^javax.sound.sampled.Line.Info info]
    (-> this (.getSourceLineInfo info)))
  ([^javax.sound.sampled.Mixer this]
    (-> this (.getSourceLineInfo))))

(defn unsynchronize
  "Releases synchronization for the specified lines.  The array must
   be identical to one for which synchronization has already been
   established; otherwise an exception may be thrown.  However, null
   may be specified, in which case all currently synchronized lines that belong
   to this mixer are unsynchronized.

  lines - the synchronized lines for which synchronization should be released, or null for all this mixer's synchronized lines - `javax.sound.sampled.Line[]`

  throws: java.lang.IllegalArgumentException - if the lines cannot be unsynchronized. This may occur if the argument specified does not exactly match a set of lines for which synchronization has already been established."
  ([^javax.sound.sampled.Mixer this ^javax.sound.sampled.Line[] lines]
    (-> this (.unsynchronize lines))))

(defn get-target-line-info
  "Obtains information about target lines of a particular type supported
   by the mixer.
   Some target lines may only be available when this mixer is open.

  info - a Line.Info object describing lines about which information is queried - `javax.sound.sampled.Line.Info`

  returns: an array of Line.Info objects describing target lines matching
   the type requested.  If no matching target lines are supported, an array of length 0
   is returned. - `javax.sound.sampled.Line.Info[]`"
  ([^javax.sound.sampled.Mixer this ^javax.sound.sampled.Line.Info info]
    (-> this (.getTargetLineInfo info)))
  ([^javax.sound.sampled.Mixer this]
    (-> this (.getTargetLineInfo))))

(defn line-supported?
  "Indicates whether the mixer supports a line (or lines) that match
   the specified Line.Info object.
   Some lines may only be supported when this mixer is open.

  info - describes the line for which support is queried - `javax.sound.sampled.Line.Info`

  returns: true if at least one matching line is
   supported, false otherwise - `boolean`"
  ([^javax.sound.sampled.Mixer this ^javax.sound.sampled.Line.Info info]
    (-> this (.isLineSupported info))))

(defn synchronization-supported?
  "Reports whether this mixer supports synchronization of the specified set of lines.

  lines - the set of lines for which synchronization support is queried - `javax.sound.sampled.Line[]`
  maintain-sync - true if the synchronization must be precisely maintained (i.e., the synchronization must be sample-accurate) at all times during operation of the lines , or false if precise synchronization is required only during start and stop operations - `boolean`

  returns: true if the lines can be synchronized, false
   otherwise - `boolean`"
  ([^javax.sound.sampled.Mixer this ^javax.sound.sampled.Line[] lines ^Boolean maintain-sync]
    (-> this (.isSynchronizationSupported lines maintain-sync))))

(defn synchronize
  "Synchronizes two or more lines.  Any subsequent command that starts or stops
   audio playback or capture for one of these lines will exert the
   same effect on the other lines in the group, so that they start or stop playing or
   capturing data simultaneously.

  lines - the lines that should be synchronized - `javax.sound.sampled.Line[]`
  maintain-sync - true if the synchronization must be precisely maintained (i.e., the synchronization must be sample-accurate) at all times during operation of the lines , or false if precise synchronization is required only during start and stop operations - `boolean`

  throws: java.lang.IllegalArgumentException - if the lines cannot be synchronized. This may occur if the lines are of different types or have different formats for which this mixer does not support synchronization, or if all lines specified do not belong to this mixer."
  ([^javax.sound.sampled.Mixer this ^javax.sound.sampled.Line[] lines ^Boolean maintain-sync]
    (-> this (.synchronize lines maintain-sync))))

(defn get-mixer-info
  "Obtains information about this mixer, including the product's name,
   version, vendor, etc.

  returns: a mixer info object that describes this mixer - `javax.sound.sampled.Mixer.Info`"
  ([^javax.sound.sampled.Mixer this]
    (-> this (.getMixerInfo))))

(defn get-line
  "Obtains a line that is available for use and that matches the description
   in the specified Line.Info object.

   If a DataLine is requested, and info
   is an instance of DataLine.Info specifying at
   least one fully qualified audio format, the last one
   will be used as the default format of the returned
   DataLine.

  info - describes the desired line - `javax.sound.sampled.Line.Info`

  returns: a line that is available for use and that matches the description
   in the specified Line.Info object - `javax.sound.sampled.Line`

  throws: javax.sound.sampled.LineUnavailableException - if a matching line is not available due to resource restrictions"
  ([^javax.sound.sampled.Mixer this ^javax.sound.sampled.Line.Info info]
    (-> this (.getLine info))))

(defn get-max-lines
  "Obtains the approximate maximum number of lines of the requested type that can be open
   simultaneously on the mixer.

   Certain types of mixers do not have a hard bound and may allow opening more lines.
   Since certain lines are a shared resource, a mixer may not be able to open the maximum
   number of lines if another process has opened lines of this mixer.

   The requested type is any line that matches the description in
   the provided Line.Info object.  For example, if the info
   object represents a speaker
   port, and the mixer supports exactly one speaker port, this method
   should return 1.  If the info object represents a source data line
   and the mixer supports the use of 32 source data lines simultaneously,
   the return value should be 32.
   If there is no limit, this function returns AudioSystem.NOT_SPECIFIED.

  info - a Line.Info that describes the line for which the number of supported instances is queried - `javax.sound.sampled.Line.Info`

  returns: the maximum number of matching lines supported, or AudioSystem.NOT_SPECIFIED - `int`"
  ([^javax.sound.sampled.Mixer this ^javax.sound.sampled.Line.Info info]
    (-> this (.getMaxLines info))))

(defn get-target-lines
  "Obtains the set of all target lines currently open from this mixer.

  returns: target lines currently open from the mixer.
   If no target lines are currently open from this mixer, an
   array of length 0 is returned. - `javax.sound.sampled.Line[]`

  throws: java.lang.SecurityException - if the matching lines are not available due to security restrictions"
  ([^javax.sound.sampled.Mixer this]
    (-> this (.getTargetLines))))

