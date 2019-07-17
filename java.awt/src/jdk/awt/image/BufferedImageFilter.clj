(ns jdk.awt.image.BufferedImageFilter
  "The BufferedImageFilter class subclasses an
  ImageFilter to provide a simple means of
  using a single-source/single-destination image operator
  (BufferedImageOp) to filter a BufferedImage
  in the Image Producer/Consumer/Observer
  paradigm. Examples of these image operators are: ConvolveOp,
  AffineTransformOp and LookupOp."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image BufferedImageFilter]))

(defn ->buffered-image-filter
  "Constructor.

  Constructs a BufferedImageFilter with the
   specified single-source/single-destination operator.

  op - the specified BufferedImageOp to use to filter a BufferedImage - `java.awt.image.BufferedImageOp`

  throws: java.lang.NullPointerException - if op is null"
  ([^java.awt.image.BufferedImageOp op]
    (new BufferedImageFilter op)))

(defn get-buffered-image-op
  "Returns the BufferedImageOp.

  returns: the operator of this BufferedImageFilter. - `java.awt.image.BufferedImageOp`"
  (^java.awt.image.BufferedImageOp [^java.awt.image.BufferedImageFilter this]
    (-> this (.getBufferedImageOp))))

(defn set-dimensions
  "Filters the information provided in the
   setDimensions  method
   of the ImageConsumer interface.

   Note: This method is intended to be called by the
   ImageProducer of the Image whose pixels are
   being filtered. Developers using this class to retrieve pixels from
   an image should avoid calling this method directly since that
   operation could result in problems with retrieving the requested
   pixels.

  width - the width to which to set the width of this BufferedImageFilter - `int`
  height - the height to which to set the height of this BufferedImageFilter - `int`"
  ([^java.awt.image.BufferedImageFilter this ^Integer width ^Integer height]
    (-> this (.setDimensions width height))))

(defn set-color-model
  "Filters the information provided in the
   setColorModel method
   of the ImageConsumer interface.

   If model is null, this
   method clears the current ColorModel of this
   BufferedImageFilter.

   Note: This method is intended to be called by the
   ImageProducer of the Image
   whose pixels are being filtered.  Developers using this
   class to retrieve pixels from an image
   should avoid calling this method directly since that
   operation could result in problems with retrieving the
   requested pixels.

  model - the ColorModel to which to set the ColorModel of this BufferedImageFilter - `java.awt.image.ColorModel`"
  ([^java.awt.image.BufferedImageFilter this ^java.awt.image.ColorModel model]
    (-> this (.setColorModel model))))

(defn set-pixels
  "Filters the information provided in the setPixels
   method of the ImageConsumer interface which takes
   an array of bytes.

   Note: This method is intended to be called by the
   ImageProducer of the Image whose pixels
   are being filtered.  Developers using
   this class to retrieve pixels from an image should avoid calling
   this method directly since that operation could result in problems
   with retrieving the requested pixels.

  x - the X coordinate of the upper-left corner of the area of pixels to be set - `int`
  y - the Y coordinate of the upper-left corner of the area of pixels to be set - `int`
  w - the width of the area of pixels - `int`
  h - the height of the area of pixels - `int`
  model - the specified ColorModel - `java.awt.image.ColorModel`
  pixels - the array of pixels - `byte[]`
  off - the offset into the pixels array - `int`
  scansize - the distance from one row of pixels to the next in the pixels array - `int`

  throws: java.lang.IllegalArgumentException - if width or height are less than zero."
  ([^java.awt.image.BufferedImageFilter this ^Integer x ^Integer y ^Integer w ^Integer h ^java.awt.image.ColorModel model pixels ^Integer off ^Integer scansize]
    (-> this (.setPixels x y w h model pixels off scansize))))

(defn image-complete
  "Filters the information provided in the imageComplete
   method of the ImageConsumer interface.

   Note: This method is intended to be called by the
   ImageProducer of the Image whose pixels
   are being filtered.  Developers using
   this class to retrieve pixels from an image should avoid calling
   this method directly since that operation could result in problems
   with retrieving the requested pixels.

  status - the status of image loading - `int`

  throws: java.awt.image.ImagingOpException - if there was a problem calling the filter method of the BufferedImageOp associated with this instance."
  ([^java.awt.image.BufferedImageFilter this ^Integer status]
    (-> this (.imageComplete status))))

