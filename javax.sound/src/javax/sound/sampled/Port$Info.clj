(ns javax.sound.sampled.Port$Info
  "The Port.Info class extends Line.Info
  with additional information specific to ports, including the port's name
  and whether it is a source or a target for its mixer.
  By definition, a port acts as either a source or a target to its mixer,
  but not both.  (Audio input ports are sources; audio output ports are targets.)

  To learn what ports are available, you can retrieve port info objects through the
  getSourceLineInfo and
  getTargetLineInfo
  methods of the Mixer interface.  Instances of the
  Port.Info class may also be constructed and used to obtain
  lines matching the parameters specified in the Port.Info object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled Port$Info]))

(defn ->info
  "Constructor.

  Constructs a port's info object from the information given.
   This constructor is typically used by an implementation
   of Java Sound to describe a supported line.

  line-class - the class of the port described by the info object. - `java.lang.Class<?>`
  name - the string that names the port - `java.lang.String`
  is-source - true if the port is a source port (such as a microphone), false if the port is a target port (such as a speaker). - `boolean`"
  ([^java.lang.Class line-class ^java.lang.String name ^Boolean is-source]
    (new Port$Info line-class name is-source)))

(def *-microphone
  "Static Constant.

  A type of port that gets audio from a built-in microphone or a microphone jack.

  type: javax.sound.sampled.Port.Info"
  Port$Info/MICROPHONE)

(def *-line-in
  "Static Constant.

  A type of port that gets audio from a line-level audio input jack.

  type: javax.sound.sampled.Port.Info"
  Port$Info/LINE_IN)

(def *-compact-disc
  "Static Constant.

  A type of port that gets audio from a CD-ROM drive.

  type: javax.sound.sampled.Port.Info"
  Port$Info/COMPACT_DISC)

(def *-speaker
  "Static Constant.

  A type of port that sends audio to a built-in speaker or a speaker jack.

  type: javax.sound.sampled.Port.Info"
  Port$Info/SPEAKER)

(def *-headphone
  "Static Constant.

  A type of port that sends audio to a headphone jack.

  type: javax.sound.sampled.Port.Info"
  Port$Info/HEADPHONE)

(def *-line-out
  "Static Constant.

  A type of port that sends audio to a line-level audio output jack.

  type: javax.sound.sampled.Port.Info"
  Port$Info/LINE_OUT)

(defn get-name
  "Obtains the name of the port.

  returns: the string that names the port - `java.lang.String`"
  ([^javax.sound.sampled.Port$Info this]
    (-> this (.getName))))

(defn source?
  "Indicates whether the port is a source or a target for its mixer.

  returns: true if the port is a source port (such
   as a microphone), false if the port is a target port
   (such as a speaker). - `boolean`"
  ([^javax.sound.sampled.Port$Info this]
    (-> this (.isSource))))

(defn matches
  "Indicates whether this info object specified matches this one.
   To match, the match requirements of the superclass must be
   met and the types must be equal.

  info - the info object for which the match is queried - `javax.sound.sampled.Line.Info`

  returns: true if the specified object matches this one,
   false otherwise - `boolean`"
  ([^javax.sound.sampled.Port$Info this ^javax.sound.sampled.Line.Info info]
    (-> this (.matches info))))

(defn equals
  "Finalizes the equals method

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([^javax.sound.sampled.Port$Info this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Finalizes the hashCode method

  returns: a hash code value for this object. - `int`"
  ([^javax.sound.sampled.Port$Info this]
    (-> this (.hashCode))))

(defn to-string
  "Provides a String representation
   of the port.

  returns: a string that describes the port - `java.lang.String`"
  ([^javax.sound.sampled.Port$Info this]
    (-> this (.toString))))

