(ns jdk.awt.image.Kernel
  "The Kernel class defines a matrix that describes how a
  specified pixel and its surrounding pixels affect the value
  computed for the pixel's position in the output image of a filtering
  operation.  The X origin and Y origin indicate the kernel matrix element
  that corresponds to the pixel position for which an output value is
  being computed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image Kernel]))

(defn ->kernel
  "Constructor.

  Constructs a Kernel object from an array of floats.
   The first width*height elements of
   the data array are copied.
   If the length of the data array is less
   than width*height, an IllegalArgumentException is thrown.
   The X origin is (width-1)/2 and the Y origin is (height-1)/2.

  width - width of the kernel - `int`
  height - height of the kernel - `int`
  data - kernel data in row major order - `float[]`

  throws: java.lang.IllegalArgumentException - if the length of data is less than the product of width and height"
  ([width height data]
    (new Kernel width height data)))

(defn get-x-origin
  "Returns the X origin of this Kernel.

  returns: the X origin. - `int`"
  ([this]
    (-> this (.getXOrigin))))

(defn get-y-origin
  "Returns the Y origin of this Kernel.

  returns: the Y origin. - `int`"
  ([this]
    (-> this (.getYOrigin))))

(defn get-width
  "Returns the width of this Kernel.

  returns: the width of this Kernel. - `int`"
  ([this]
    (-> this (.getWidth))))

(defn get-height
  "Returns the height of this Kernel.

  returns: the height of this Kernel. - `int`"
  ([this]
    (-> this (.getHeight))))

(defn get-kernel-data
  "Returns the kernel data in row major order.
   The data array is returned.  If data
   is null, a new array is allocated.

  data - if non-null, contains the returned kernel data - `float[]`

  returns: the data array containing the kernel data
           in row major order or, if data is
           null, a newly allocated array containing
           the kernel data in row major order - `float[]`

  throws: java.lang.IllegalArgumentException - if data is less than the size of this Kernel"
  ([this data]
    (-> this (.getKernelData data))))

(defn clone
  "Clones this object.

  returns: a clone of this object. - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

