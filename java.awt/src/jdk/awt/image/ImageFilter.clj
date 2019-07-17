(ns jdk.awt.image.ImageFilter
  "This class implements a filter for the set of interface methods that
  are used to deliver data from an ImageProducer to an ImageConsumer.
  It is meant to be used in conjunction with a FilteredImageSource
  object to produce filtered versions of existing images.  It is a
  base class that provides the calls needed to implement a `Null filter`
  which has no effect on the data being passed through.  Filters should
  subclass this class and override the methods which deal with the
  data that needs to be filtered and modify it as necessary."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ImageFilter]))

(defn ->image-filter
  "Constructor."
  ([]
    (new ImageFilter )))

(defn get-filter-instance
  "Returns a unique instance of an ImageFilter object which will
   actually perform the filtering for the specified ImageConsumer.
   The default implementation just clones this object.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being filtered.  Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`

  returns: an ImageFilter used to perform the
           filtering for the specified ImageConsumer. - `java.awt.image.ImageFilter`"
  (^java.awt.image.ImageFilter [^java.awt.image.ImageFilter this ^java.awt.image.ImageConsumer ic]
    (-> this (.getFilterInstance ic))))

(defn set-dimensions
  "Filters the information provided in the setDimensions method
   of the ImageConsumer interface.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being filtered.  Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  width - the width of the source image - `int`
  height - the height of the source image - `int`"
  ([^java.awt.image.ImageFilter this ^Integer width ^Integer height]
    (-> this (.setDimensions width height))))

(defn set-pixels
  "Filters the information provided in the setPixels method of the
   ImageConsumer interface which takes an array of bytes.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being filtered.  Developers using
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
  ([^java.awt.image.ImageFilter this ^Integer x ^Integer y ^Integer w ^Integer h ^java.awt.image.ColorModel model pixels ^Integer off ^Integer scansize]
    (-> this (.setPixels x y w h model pixels off scansize))))

(defn set-hints
  "Filters the information provided in the setHints method
   of the ImageConsumer interface.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being filtered.  Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  hints - a set of hints that the ImageConsumer uses to process the pixels - `int`"
  ([^java.awt.image.ImageFilter this ^Integer hints]
    (-> this (.setHints hints))))

(defn set-color-model
  "Filter the information provided in the setColorModel method
   of the ImageConsumer interface.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being filtered.  Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  model - the specified ColorModel - `java.awt.image.ColorModel`"
  ([^java.awt.image.ImageFilter this ^java.awt.image.ColorModel model]
    (-> this (.setColorModel model))))

(defn resend-top-down-left-right
  "Responds to a request for a TopDownLeftRight (TDLR) ordered resend
   of the pixel data from an ImageConsumer.
   When an ImageConsumer being fed
   by an instance of this ImageFilter
   requests a resend of the data in TDLR order,
   the FilteredImageSource
   invokes this method of the ImageFilter.



   An ImageFilter subclass might override this method or not,
   depending on if and how it can send data in TDLR order.
   Three possibilities exist:



   Do not override this method.
   This makes the subclass use the default implementation,
   which is to
   forward the request
   to the indicated ImageProducer
   using this filter as the requesting ImageConsumer.
   This behavior
   is appropriate if the filter can determine
   that it will forward the pixels
   in TDLR order if its upstream producer object
   sends them in TDLR order.


   Override the method to simply send the data.
   This is appropriate if the filter can handle the request itself 
   for example,
   if the generated pixels have been saved in some sort of buffer.


   Override the method to do nothing.
   This is appropriate
   if the filter cannot produce filtered data in TDLR order.

  ip - the ImageProducer that is feeding this instance of the filter - also the ImageProducer that the request should be forwarded to if necessary - `java.awt.image.ImageProducer`

  throws: java.lang.NullPointerException - if ip is null"
  ([^java.awt.image.ImageFilter this ^java.awt.image.ImageProducer ip]
    (-> this (.resendTopDownLeftRight ip))))

(defn set-properties
  "Passes the properties from the source object along after adding a
   property indicating the stream of filters it has been run through.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being filtered.  Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  props - the properties from the source object - `java.util.Hashtable<?,?>`

  throws: java.lang.NullPointerException - if props is null"
  ([^java.awt.image.ImageFilter this ^java.util.Hashtable props]
    (-> this (.setProperties props))))

(defn clone
  "Clones this object.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^java.awt.image.ImageFilter this]
    (-> this (.clone))))

(defn image-complete
  "Filters the information provided in the imageComplete method of
   the ImageConsumer interface.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being filtered.  Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  status - the status of image loading - `int`"
  ([^java.awt.image.ImageFilter this ^Integer status]
    (-> this (.imageComplete status))))

