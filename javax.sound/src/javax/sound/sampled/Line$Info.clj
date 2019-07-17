(ns javax.sound.sampled.Line$Info
  "A Line.Info object contains information about a line.
  The only information provided by Line.Info itself
  is the Java class of the line.
  A subclass of Line.Info adds other kinds of information
  about the line.  This additional information depends on which Line
  subinterface is implemented by the kind of line that the Line.Info
  subclass describes.

  A Line.Info can be retrieved using various methods of
  the Line, Mixer, and AudioSystem
  interfaces.  Other such methods let you pass a Line.Info as
  an argument, to learn whether lines matching the specified configuration
  are available and to obtain them."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled Line$Info]))

(defn ->info
  "Constructor.

  Constructs an info object that describes a line of the specified class.
   This constructor is typically used by an application to
   describe a desired line.

  line-class - the class of the line that the new Line.Info object describes - `java.lang.Class<?>`"
  ([^java.lang.Class line-class]
    (new Line$Info line-class)))

(defn get-line-class
  "Obtains the class of the line that this Line.Info object describes.

  returns: the described line's class - `java.lang.Class<?>`"
  ([^javax.sound.sampled.Line$Info this]
    (-> this (.getLineClass))))

(defn matches
  "Indicates whether the specified info object matches this one.
   To match, the specified object must be identical to or
   a special case of this one.  The specified info object
   must be either an instance of the same class as this one,
   or an instance of a sub-type of this one.  In addition, the
   attributes of the specified object must be compatible with the
   capabilities of this one.  Specifically, the routing configuration
   for the specified info object must be compatible with that of this
   one.
   Subclasses may add other criteria to determine whether the two objects
   match.

  info - the info object which is being compared to this one - `javax.sound.sampled.Line.Info`

  returns: true if the specified object matches this one,
   false otherwise - `boolean`"
  ([^javax.sound.sampled.Line$Info this ^javax.sound.sampled.Line.Info info]
    (-> this (.matches info))))

(defn to-string
  "Obtains a textual description of the line info.

  returns: a string description - `java.lang.String`"
  ([^javax.sound.sampled.Line$Info this]
    (-> this (.toString))))

