(ns javax.sound.sampled.ReverbType
  "The ReverbType class provides methods for
  accessing various reverberation settings to be applied to
  an audio signal.

  Reverberation simulates the reflection of sound off of
  the walls, ceiling, and floor of a room.  Depending on
  the size of the room, and how absorbent or reflective the materials in the
  room's surfaces are, the sound might bounce around for a
  long time before dying away.

  The reverberation parameters provided by ReverbType consist
  of the delay time and intensity of early reflections, the delay time and
  intensity of late reflections, and an overall decay time.
  Early reflections are the initial individual low-order reflections of the
  direct signal off the surfaces in the room.
  The late Reflections are the dense, high-order reflections that characterize
  the room's reverberation.
  The delay times for the start of these two reflection types give the listener
  a sense of the overall size and complexity of the room's shape and contents.
  The larger the room, the longer the reflection delay times.
  The early and late reflections' intensities define the gain (in decibels) of the reflected
  signals as compared to the direct signal.  These intensities give the
  listener an impression of the absorptive nature of the surfaces and objects
  in the room.
  The decay time defines how long the reverberation takes to exponentially
  decay until it is no longer perceptible (\"effective zero\").
  The larger and less absorbent the surfaces, the longer the decay time.

  The set of parameters defined here may not include all aspects of reverberation
  as specified by some systems.  For example, the Midi Manufacturer's Association
  (MMA) has an Interactive Audio Special Interest Group (IASIG), which has a
  3-D Working Group that has defined a Level 2 Spec (I3DL2).  I3DL2
  supports filtering of reverberation and
  control of reverb density.  These properties are not included in the JavaSound 1.0
  definition of a reverb control.  In such a case, the implementing system
  should either extend the defined reverb control to include additional
  parameters, or else interpret the system's additional capabilities in a way that fits
  the model described here.

  If implementing JavaSound on a I3DL2-compliant device:

  Filtering is disabled (high-frequency attenuations are set to 0.0 dB)
  Density parameters are set to midway between minimum and maximum


  The following table shows what parameter values an implementation might use for a
  representative set of reverberation settings.


  Reverberation Types and Parameters




   Type
   Decay Time (ms)
   Late Intensity (dB)
   Late Delay (ms)
   Early Intensity (dB)
   Early Delay(ms)



   Cavern
   2250
   -2.0
   41.3
   -1.4
   10.3



   Dungeon
   1600
   -1.0
   10.3
   -0.7
   2.6



   Garage
   900
   -6.0
   14.7
   -4.0
   3.9



   Acoustic Lab
   280
   -3.0
   8.0
   -2.0
   2.0



   Closet
   150
   -10.0
   2.5
   -7.0
   0.6"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled ReverbType]))

(defn get-late-reflection-delay
  "Returns the late reflection delay time in microseconds.
   This is the amount of time between when the first early reflections
   are heard and when the first late reflections are heard.

  returns: late reflection delay time for this reverb type, in microseconds - `int`"
  (^Integer [^ReverbType this]
    (-> this (.getLateReflectionDelay))))

(defn to-string
  "Provides a String representation of the reverb type,
   including its name and its parameter settings.
   The exact contents of the string may vary between implementations of
   Java Sound.

  returns: reverberation type name and description - `java.lang.String`"
  (^java.lang.String [^ReverbType this]
    (-> this (.toString))))

(defn get-name
  "Obtains the name of this reverb type.

  returns: the name of this reverb type - `java.lang.String`"
  (^java.lang.String [^ReverbType this]
    (-> this (.getName))))

(defn get-early-reflection-intensity
  "Returns the early reflection intensity in decibels.
   This is the amplitude attenuation of the first early reflections
   relative to the direct signal.

  returns: early reflection intensity for this reverb type, in dB - `float`"
  (^Float [^ReverbType this]
    (-> this (.getEarlyReflectionIntensity))))

(defn get-late-reflection-intensity
  "Returns the late reflection intensity in decibels.
   This is the amplitude attenuation of the first late reflections
   relative to the direct signal.

  returns: late reflection intensity for this reverb type, in dB - `float`"
  (^Float [^ReverbType this]
    (-> this (.getLateReflectionIntensity))))

(defn get-early-reflection-delay
  "Returns the early reflection delay time in microseconds.
   This is the amount of time between when the direct signal is
   heard and when the first early reflections are heard.

  returns: early reflection delay time for this reverb type, in microseconds - `int`"
  (^Integer [^ReverbType this]
    (-> this (.getEarlyReflectionDelay))))

(defn hash-code
  "Finalizes the hashcode method.

  returns: a hash code value for this object. - `int`"
  (^Integer [^ReverbType this]
    (-> this (.hashCode))))

(defn equals
  "Indicates whether the specified object is equal to this reverb type,
   returning true if the objects are identical.

  obj - the reference object with which to compare - `java.lang.Object`

  returns: true if this reverb type is the same as
   obj; false otherwise - `boolean`"
  (^Boolean [^ReverbType this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn get-decay-time
  "Obtains the decay time, which is the amount of time over which the
   late reflections attenuate to effective zero.  The effective zero
   value is implementation-dependent.

  returns: the decay time of the late reflections, in microseconds - `int`"
  (^Integer [^ReverbType this]
    (-> this (.getDecayTime))))

