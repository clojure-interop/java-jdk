(ns jdk.awt.image.AreaAveragingScaleFilter
  "An ImageFilter class for scaling images using a simple area averaging
  algorithm that produces smoother results than the nearest neighbor
  algorithm.
  This class extends the basic ImageFilter Class to scale an existing
  image and provide a source for a new image containing the resampled
  image.  The pixels in the source image are blended to produce pixels
  for an image of the specified size.  The blending process is analogous
  to scaling up the source image to a multiple of the destination size
  using pixel replication and then scaling it back down to the destination
  size by simply averaging all the pixels in the supersized image that
  fall within a given pixel of the destination image.  If the data from
  the source is not delivered in TopDownLeftRight order then the filter
  will back off to a simple pixel replication behavior and utilize the
  requestTopDownLeftRightResend() method to refilter the pixels in a
  better way at the end.
  It is meant to be used in conjunction with a FilteredImageSource
  object to produce scaled versions of existing images.  Due to
  implementation dependencies, there may be differences in pixel values
  of an image filtered on different platforms."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image AreaAveragingScaleFilter]))

(defn ->area-averaging-scale-filter
  "Constructor.

  Constructs an AreaAveragingScaleFilter that scales the pixels from
   its source Image as specified by the width and height parameters.

  width - the target width to scale the image - `int`
  height - the target height to scale the image - `int`"
  (^AreaAveragingScaleFilter [^Integer width ^Integer height]
    (new AreaAveragingScaleFilter width height)))

(defn set-hints
  "Detect if the data is being delivered with the necessary hints
   to allow the averaging algorithm to do its work.

   Note: This method is intended to be called by the
   ImageProducer of the Image whose
   pixels are being filtered.  Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  hints - a set of hints that the ImageConsumer uses to process the pixels - `int`"
  ([^AreaAveragingScaleFilter this ^Integer hints]
    (-> this (.setHints hints))))

(defn set-pixels
  "Combine the components for the delivered byte pixels into the
   accumulation arrays and send on any averaged data for rows of
   pixels that are complete.  If the correct hints were not
   specified in the setHints call then relay the work to our
   superclass which is capable of scaling pixels regardless of
   the delivery hints.

   Note: This method is intended to be called by the
   ImageProducer of the Image
   whose pixels are being filtered.  Developers using
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
  ([^AreaAveragingScaleFilter this ^Integer x ^Integer y ^Integer w ^Integer h ^java.awt.image.ColorModel model pixels ^Integer off ^Integer scansize]
    (-> this (.setPixels x y w h model pixels off scansize))))

