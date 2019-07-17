(ns jdk.awt.image.ReplicateScaleFilter
  "An ImageFilter class for scaling images using the simplest algorithm.
  This class extends the basic ImageFilter Class to scale an existing
  image and provide a source for a new image containing the resampled
  image.  The pixels in the source image are sampled to produce pixels
  for an image of the specified size by replicating rows and columns of
  pixels to scale up or omitting rows and columns of pixels to scale
  down.
  It is meant to be used in conjunction with a FilteredImageSource
  object to produce scaled versions of existing images.  Due to
  implementation dependencies, there may be differences in pixel values
  of an image filtered on different platforms."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ReplicateScaleFilter]))

(defn ->replicate-scale-filter
  "Constructor.

  Constructs a ReplicateScaleFilter that scales the pixels from
   its source Image as specified by the width and height parameters.

  width - the target width to scale the image - `int`
  height - the target height to scale the image - `int`

  throws: java.lang.IllegalArgumentException - if width equals zero or height equals zero"
  ([width height]
    (new ReplicateScaleFilter width height)))

(defn set-properties
  "Passes along the properties from the source object after adding a
   property indicating the scale applied.
   This method invokes super.setProperties,
   which might result in additional properties being added.

   Note: This method is intended to be called by the
   ImageProducer of the Image whose pixels
   are being filtered. Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  props - the properties from the source object - `java.util.Hashtable<?,?>`"
  ([this props]
    (-> this (.setProperties props))))

(defn set-dimensions
  "Override the dimensions of the source image and pass the dimensions
   of the new scaled size to the ImageConsumer.

   Note: This method is intended to be called by the
   ImageProducer of the Image whose pixels
   are being filtered. Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  w - the width of the source image - `int`
  h - the height of the source image - `int`"
  ([this w h]
    (-> this (.setDimensions w h))))

(defn set-pixels
  "Choose which rows and columns of the delivered byte pixels are
   needed for the destination scaled image and pass through just
   those rows and columns that are needed, replicated as necessary.

   Note: This method is intended to be called by the
   ImageProducer of the Image whose pixels
   are being filtered. Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  x - the X coordinate of the upper-left corner of the area of pixels to be set - `int`
  y - the Y coordinate of the upper-left corner of the area of pixels to be set - `int`
  w - the width of the area of pixels - `int`
  h - the height of the area of pixels - `int`
  model - the specified ColorModel - `java.awt.image.ColorModel`
  pixels - the array of pixels - `byte[]`
  off - the offset into the pixels array - `int`
  scansize - the distance from one row of pixels to the next in the pixels array - `int`"
  ([this x y w h model pixels off scansize]
    (-> this (.setPixels x y w h model pixels off scansize))))

