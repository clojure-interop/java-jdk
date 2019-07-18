(ns jdk.awt.image.CropImageFilter
  "An ImageFilter class for cropping images.
  This class extends the basic ImageFilter Class to extract a given
  rectangular region of an existing Image and provide a source for a
  new image containing just the extracted region.  It is meant to
  be used in conjunction with a FilteredImageSource object to produce
  cropped versions of existing images."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image CropImageFilter]))

(defn ->crop-image-filter
  "Constructor.

  Constructs a CropImageFilter that extracts the absolute rectangular
   region of pixels from its source Image as specified by the x, y,
   w, and h parameters.

  x - the x location of the top of the rectangle to be extracted - `int`
  y - the y location of the top of the rectangle to be extracted - `int`
  w - the width of the rectangle to be extracted - `int`
  h - the height of the rectangle to be extracted - `int`"
  (^CropImageFilter [^Integer x ^Integer y ^Integer w ^Integer h]
    (new CropImageFilter x y w h)))

(defn set-properties
  "Passes along  the properties from the source object after adding a
   property indicating the cropped region.
   This method invokes super.setProperties,
   which might result in additional properties being added.

   Note: This method is intended to be called by the
   ImageProducer of the Image whose pixels
   are being filtered. Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  props - the properties from the source object - `java.util.Hashtable`"
  ([^CropImageFilter this ^java.util.Hashtable props]
    (-> this (.setProperties props))))

(defn set-dimensions
  "Override the source image's dimensions and pass the dimensions
   of the rectangular cropped region to the ImageConsumer.

   Note: This method is intended to be called by the
   ImageProducer of the Image whose
   pixels are being filtered. Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  w - the width of the source image - `int`
  h - the height of the source image - `int`"
  ([^CropImageFilter this ^Integer w ^Integer h]
    (-> this (.setDimensions w h))))

(defn set-pixels
  "Determine whether the delivered byte pixels intersect the region to
   be extracted and passes through only that subset of pixels that
   appear in the output region.

   Note: This method is intended to be called by the
   ImageProducer of the Image whose
   pixels are being filtered. Developers using
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
  ([^CropImageFilter this ^Integer x ^Integer y ^Integer w ^Integer h ^java.awt.image.ColorModel model pixels ^Integer off ^Integer scansize]
    (-> this (.setPixels x y w h model pixels off scansize))))

