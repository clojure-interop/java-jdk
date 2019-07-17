(ns jdk.awt.image.ImageConsumer
  "The interface for objects expressing interest in image data through
  the ImageProducer interfaces.  When a consumer is added to an image
  producer, the producer delivers all of the data about the image
  using the method calls defined in this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ImageConsumer]))

(defn set-dimensions
  "The dimensions of the source image are reported using the
   setDimensions method call.

  width - the width of the source image - `int`
  height - the height of the source image - `int`"
  ([this width height]
    (-> this (.setDimensions width height))))

(defn set-properties
  "Sets the extensible list of properties associated with this image.

  props - the list of properties to be associated with this image - `java.util.Hashtable<?,?>`"
  ([this props]
    (-> this (.setProperties props))))

(defn set-color-model
  "Sets the ColorModel object used for the majority of
   the pixels reported using the setPixels method
   calls.  Note that each set of pixels delivered using setPixels
   contains its own ColorModel object, so no assumption should
   be made that this model will be the only one used in delivering
   pixel values.  A notable case where multiple ColorModel objects
   may be seen is a filtered image when for each set of pixels
   that it filters, the filter
   determines  whether the
   pixels can be sent on untouched, using the original ColorModel,
   or whether the pixels should be modified (filtered) and passed
   on using a ColorModel more convenient for the filtering process.

  model - the specified ColorModel - `java.awt.image.ColorModel`"
  ([this model]
    (-> this (.setColorModel model))))

(defn set-hints
  "Sets the hints that the ImageConsumer uses to process the
   pixels delivered by the ImageProducer.
   The ImageProducer can deliver the pixels in any order, but
   the ImageConsumer may be able to scale or convert the pixels
   to the destination ColorModel more efficiently or with higher
   quality if it knows some information about how the pixels will
   be delivered up front.  The setHints method should be called
   before any calls to any of the setPixels methods with a bit mask
   of hints about the manner in which the pixels will be delivered.
   If the ImageProducer does not follow the guidelines for the
   indicated hint, the results are undefined.

  hintflags - a set of hints that the ImageConsumer uses to process the pixels - `int`"
  ([this hintflags]
    (-> this (.setHints hintflags))))

(defn set-pixels
  "Delivers the pixels of the image with one or more calls
   to this method.  Each call specifies the location and
   size of the rectangle of source pixels that are contained in
   the array of pixels.  The specified ColorModel object should
   be used to convert the pixels into their corresponding color
   and alpha components.  Pixel (m,n) is stored in the pixels array
   at index (n * scansize  m  off).  The pixels delivered using
   this method are all stored as bytes.

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

(defn image-complete
  "The imageComplete method is called when the ImageProducer is
   finished delivering all of the pixels that the source image
   contains, or when a single frame of a multi-frame animation has
   been completed, or when an error in loading or producing the
   image has occurred.  The ImageConsumer should remove itself from the
   list of consumers registered with the ImageProducer at this time,
   unless it is interested in successive frames.

  status - the status of image loading - `int`"
  ([this status]
    (-> this (.imageComplete status))))

