(ns jdk.awt.image.FilteredImageSource
  "This class is an implementation of the ImageProducer interface which
  takes an existing image and a filter object and uses them to produce
  image data for a new filtered version of the original image.
  Here is an example which filters an image by swapping the red and
  blue compents:


       Image src = getImage(`doc:///demo/images/duke/T1.gif`);
       ImageFilter colorfilter = new RedBlueSwapFilter();
       Image img = createImage(new FilteredImageSource(src.getSource(),
                                                       colorfilter));"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image FilteredImageSource]))

(defn ->filtered-image-source
  "Constructor.

  Constructs an ImageProducer object from an existing ImageProducer
   and a filter object.

  orig - the specified ImageProducer - `java.awt.image.ImageProducer`
  imgf - the specified ImageFilter - `java.awt.image.ImageFilter`"
  ([^java.awt.image.ImageProducer orig ^java.awt.image.ImageFilter imgf]
    (new FilteredImageSource orig imgf)))

(defn add-consumer
  "Adds the specified ImageConsumer
   to the list of consumers interested in data for the filtered image.
   An instance of the original ImageFilter
   is created
   (using the filter's getFilterInstance method)
   to manipulate the image data
   for the specified ImageConsumer.
   The newly created filter instance
   is then passed to the addConsumer method
   of the original ImageProducer.


   This method is public as a side effect
   of this class implementing
   the ImageProducer interface.
   It should not be called from user code,
   and its behavior if called from user code is unspecified.

  ic - the consumer for the filtered image - `java.awt.image.ImageConsumer`"
  ([^java.awt.image.FilteredImageSource this ^java.awt.image.ImageConsumer ic]
    (-> this (.addConsumer ic))))

(defn consumer?
  "Determines whether an ImageConsumer is on the list of consumers
   currently interested in data for this image.


   This method is public as a side effect
   of this class implementing
   the ImageProducer interface.
   It should not be called from user code,
   and its behavior if called from user code is unspecified.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`

  returns: true if the ImageConsumer is on the list; false otherwise - `boolean`"
  (^Boolean [^java.awt.image.FilteredImageSource this ^java.awt.image.ImageConsumer ic]
    (-> this (.isConsumer ic))))

(defn remove-consumer
  "Removes an ImageConsumer from the list of consumers interested in
   data for this image.


   This method is public as a side effect
   of this class implementing
   the ImageProducer interface.
   It should not be called from user code,
   and its behavior if called from user code is unspecified.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`"
  ([^java.awt.image.FilteredImageSource this ^java.awt.image.ImageConsumer ic]
    (-> this (.removeConsumer ic))))

(defn start-production
  "Starts production of the filtered image.
   If the specified ImageConsumer
   isn't already a consumer of the filtered image,
   an instance of the original ImageFilter
   is created
   (using the filter's getFilterInstance method)
   to manipulate the image data
   for the ImageConsumer.
   The filter instance for the ImageConsumer
   is then passed to the startProduction method
   of the original ImageProducer.


   This method is public as a side effect
   of this class implementing
   the ImageProducer interface.
   It should not be called from user code,
   and its behavior if called from user code is unspecified.

  ic - the consumer for the filtered image - `java.awt.image.ImageConsumer`"
  ([^java.awt.image.FilteredImageSource this ^java.awt.image.ImageConsumer ic]
    (-> this (.startProduction ic))))

(defn request-top-down-left-right-resend
  "Requests that a given ImageConsumer have the image data delivered
   one more time in top-down, left-right order.  The request is
   handed to the ImageFilter for further processing, since the
   ability to preserve the pixel ordering depends on the filter.


   This method is public as a side effect
   of this class implementing
   the ImageProducer interface.
   It should not be called from user code,
   and its behavior if called from user code is unspecified.

  ic - the specified ImageConsumer - `java.awt.image.ImageConsumer`"
  ([^java.awt.image.FilteredImageSource this ^java.awt.image.ImageConsumer ic]
    (-> this (.requestTopDownLeftRightResend ic))))

