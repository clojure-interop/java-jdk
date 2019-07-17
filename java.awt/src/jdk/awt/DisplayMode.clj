(ns jdk.awt.DisplayMode
  "The DisplayMode class encapsulates the bit depth, height,
  width, and refresh rate of a GraphicsDevice. The ability to
  change graphics device's display mode is platform- and
  configuration-dependent and may not always be available
  (see GraphicsDevice.isDisplayChangeSupported()).

  For more information on full-screen exclusive mode API, see the

  Full-Screen Exclusive Mode API Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt DisplayMode]))

(defn ->display-mode
  "Constructor.

  Create a new display mode object with the supplied parameters.

  width - the width of the display, in pixels - `int`
  height - the height of the display, in pixels - `int`
  bit-depth - the bit depth of the display, in bits per pixel. This can be BIT_DEPTH_MULTI if multiple bit depths are available. - `int`
  refresh-rate - the refresh rate of the display, in hertz. This can be REFRESH_RATE_UNKNOWN if the information is not available. - `int`"
  ([width height bit-depth refresh-rate]
    (new DisplayMode width height bit-depth refresh-rate)))

(def *-bit-depth-multi
  "Static Constant.

  Value of the bit depth if multiple bit depths are supported in this
   display mode.

  type: java.lang.annotation.    int"
  DisplayMode/BIT_DEPTH_MULTI)

(def *-refresh-rate-unknown
  "Static Constant.

  Value of the refresh rate if not known.

  type: java.lang.annotation.    int"
  DisplayMode/REFRESH_RATE_UNKNOWN)

(defn get-height
  "Returns the height of the display, in pixels.

  returns: the height of the display, in pixels - `int`"
  ([this]
    (-> this (.getHeight))))

(defn get-width
  "Returns the width of the display, in pixels.

  returns: the width of the display, in pixels - `int`"
  ([this]
    (-> this (.getWidth))))

(defn get-bit-depth
  "Returns the bit depth of the display, in bits per pixel.  This may be
   BIT_DEPTH_MULTI if multiple bit depths are supported in
   this display mode.

  returns: the bit depth of the display, in bits per pixel. - `int`"
  ([this]
    (-> this (.getBitDepth))))

(defn get-refresh-rate
  "Returns the refresh rate of the display, in hertz.  This may be
   REFRESH_RATE_UNKNOWN if the information is not available.

  returns: the refresh rate of the display, in hertz. - `int`"
  ([this]
    (-> this (.getRefreshRate))))

(defn equals
  "Returns whether the two display modes are equal.

  dm - `java.awt.DisplayMode`

  returns: whether the two display modes are equal - `boolean`"
  ([this dm]
    (-> this (.equals dm))))

(defn hash-code
  "Returns a hash code value for the object. This method is
   supported for the benefit of hash tables such as those provided by
   HashMap.

   The general contract of hashCode is:

   Whenever it is invoked on the same object more than once during
       an execution of a Java application, the hashCode method
       must consistently return the same integer, provided no information
       used in equals comparisons on the object is modified.
       This integer need not remain consistent from one execution of an
       application to another execution of the same application.
   If two objects are equal according to the equals(Object)
       method, then calling the hashCode method on each of
       the two objects must produce the same integer result.
   It is not required that if two objects are unequal
       according to the Object.equals(java.lang.Object)
       method, then calling the hashCode method on each of the
       two objects must produce distinct integer results.  However, the
       programmer should be aware that producing distinct integer results
       for unequal objects may improve the performance of hash tables.


   As much as is reasonably practical, the hashCode method defined by
   class Object does return distinct integers for distinct
   objects. (This is typically implemented by converting the internal
   address of the object into an integer, but this implementation
   technique is not required by the
   Java™ programming language.)

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

