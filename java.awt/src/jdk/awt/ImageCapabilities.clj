(ns jdk.awt.ImageCapabilities
  "Capabilities and properties of images."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt ImageCapabilities]))

(defn ->image-capabilities
  "Constructor.

  Creates a new object for specifying image capabilities.

  accelerated - whether or not an accelerated image is desired - `boolean`"
  ([^Boolean accelerated]
    (new ImageCapabilities accelerated)))

(defn accelerated?
  "Returns true if the object whose capabilities are
   encapsulated in this ImageCapabilities can be or is
   accelerated.

  returns: whether or not an image can be, or is, accelerated.  There are
   various platform-specific ways to accelerate an image, including
   pixmaps, VRAM, AGP.  This is the general acceleration method (as
   opposed to residing in system memory). - `boolean`"
  ([^java.awt.ImageCapabilities this]
    (-> this (.isAccelerated))))

(defn true-volatile?
  "Returns true if the VolatileImage
   described by this ImageCapabilities can lose
   its surfaces.

  returns: whether or not a volatile image is subject to losing its surfaces
   at the whim of the operating system. - `boolean`"
  ([^java.awt.ImageCapabilities this]
    (-> this (.isTrueVolatile))))

(defn clone
  "Description copied from class: Object

  returns: a copy of this ImageCapabilities object. - `java.lang.Object`"
  ([^java.awt.ImageCapabilities this]
    (-> this (.clone))))

