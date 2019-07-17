(ns jdk.awt.image.PixelGrabber
  "The PixelGrabber class implements an ImageConsumer which can be attached
  to an Image or ImageProducer object to retrieve a subset of the pixels
  in that image.  Here is an example:


  public void handlesinglepixel(int x, int y, int pixel) {
       int alpha = (pixel >> 24) & 0xff;
       int red   = (pixel >> 16) & 0xff;
       int green = (pixel >>  8) & 0xff;
       int blue  = (pixel      ) & 0xff;
       // Deal with the pixel as necessary...
  }

  public void handlepixels(Image img, int x, int y, int w, int h) {
       int[] pixels = new int[w * h];
       PixelGrabber pg = new PixelGrabber(img, x, y, w, h, pixels, 0, w);
       try {
           pg.grabPixels();
       } catch (InterruptedException e) {
           System.err.println(`interrupted waiting for pixels!`);
           return;
       }
       if ((pg.getStatus() & ImageObserver.ABORT) != 0) {
           System.err.println(`image fetch aborted or errored`);
           return;
       }
       for (int j = 0; j < h; j++) {
           for (int i = 0; i < w; i++) {
               handlesinglepixel(x+i, y+j, pixels[j * w  i]);
           }
       }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image PixelGrabber]))

(defn ->pixel-grabber
  "Constructor.

  Create a PixelGrabber object to grab the (x, y, w, h) rectangular
   section of pixels from the specified image into the given array.
   The pixels are stored into the array in the default RGB ColorModel.
   The RGB data for pixel (i, j) where (i, j) is inside the rectangle
   (x, y, w, h) is stored in the array at
   pix[(j - y) * scansize  (i - x)  off].

  img - the image to retrieve pixels from - `java.awt.Image`
  x - the x coordinate of the upper left corner of the rectangle of pixels to retrieve from the image, relative to the default (unscaled) size of the image - `int`
  y - the y coordinate of the upper left corner of the rectangle of pixels to retrieve from the image - `int`
  w - the width of the rectangle of pixels to retrieve - `int`
  h - the height of the rectangle of pixels to retrieve - `int`
  pix - the array of integers which are to be used to hold the RGB pixels retrieved from the image - `int[]`
  off - the offset into the array of where to store the first pixel - `int`
  scansize - the distance from one row of pixels to the next in the array - `int`"
  ([^java.awt.Image img ^Integer x ^Integer y ^Integer w ^Integer h pix ^Integer off ^Integer scansize]
    (new PixelGrabber img x y w h pix off scansize))
  ([^java.awt.Image img ^Integer x ^Integer y ^Integer w ^Integer h ^Boolean force-rgb]
    (new PixelGrabber img x y w h force-rgb)))

(defn get-width
  "Get the width of the pixel buffer (after adjusting for image width).
   If no width was specified for the rectangle of pixels to grab then
   then this information will only be available after the image has
   delivered the dimensions.

  returns: the final width used for the pixel buffer or -1 if the width
   is not yet known - `int`"
  (^Integer [^java.awt.image.PixelGrabber this]
    (-> this (.getWidth))))

(defn get-status
  "Return the status of the pixels.  The ImageObserver flags
   representing the available pixel information are returned.

  returns: the bitwise OR of all relevant ImageObserver flags - `int`"
  (^Integer [^java.awt.image.PixelGrabber this]
    (-> this (.getStatus))))

(defn start-grabbing
  "Request the PixelGrabber to start fetching the pixels."
  ([^java.awt.image.PixelGrabber this]
    (-> this (.startGrabbing))))

(defn set-dimensions
  "The setDimensions method is part of the ImageConsumer API which
   this class must implement to retrieve the pixels.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being grabbed.  Developers using
   this class to retrieve pixels from an image should avoid calling
   this method directly since that operation could result in problems
   with retrieving the requested pixels.

  width - the width of the dimension - `int`
  height - the height of the dimension - `int`"
  ([^java.awt.image.PixelGrabber this ^Integer width ^Integer height]
    (-> this (.setDimensions width height))))

(defn get-pixels
  "Get the pixel buffer.  If the PixelGrabber was not constructed
   with an explicit pixel buffer to hold the pixels then this method
   will return null until the size and format of the image data is
   known.
   Since the PixelGrabber may fall back on accumulating the data
   in the default RGB ColorModel at any time if the source image
   uses more than one ColorModel to deliver the data, the array
   object returned by this method may change over time until the
   image grab is complete.

  returns: either a byte array or an int array - `java.lang.Object`"
  (^java.lang.Object [^java.awt.image.PixelGrabber this]
    (-> this (.getPixels))))

(defn set-pixels
  "The setPixels method is part of the ImageConsumer API which
   this class must implement to retrieve the pixels.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being grabbed.  Developers using
   this class to retrieve pixels from an image should avoid calling
   this method directly since that operation could result in problems
   with retrieving the requested pixels.

  src-x - the X coordinate of the upper-left corner of the area of pixels to be set - `int`
  src-y - the Y coordinate of the upper-left corner of the area of pixels to be set - `int`
  src-w - the width of the area of pixels - `int`
  src-h - the height of the area of pixels - `int`
  model - the specified ColorModel - `java.awt.image.ColorModel`
  pixels - the array of pixels - `byte[]`
  src-off - the offset into the pixels array - `int`
  src-scan - the distance from one row of pixels to the next in the pixels array - `int`"
  ([^java.awt.image.PixelGrabber this ^Integer src-x ^Integer src-y ^Integer src-w ^Integer src-h ^java.awt.image.ColorModel model pixels ^Integer src-off ^Integer src-scan]
    (-> this (.setPixels src-x src-y src-w src-h model pixels src-off src-scan))))

(defn set-hints
  "The setHints method is part of the ImageConsumer API which
   this class must implement to retrieve the pixels.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being grabbed.  Developers using
   this class to retrieve pixels from an image should avoid calling
   this method directly since that operation could result in problems
   with retrieving the requested pixels.

  hints - a set of hints used to process the pixels - `int`"
  ([^java.awt.image.PixelGrabber this ^Integer hints]
    (-> this (.setHints hints))))

(defn abort-grabbing
  "Request the PixelGrabber to abort the image fetch."
  ([^java.awt.image.PixelGrabber this]
    (-> this (.abortGrabbing))))

(defn set-color-model
  "The setColorModel method is part of the ImageConsumer API which
   this class must implement to retrieve the pixels.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being grabbed.  Developers using
   this class to retrieve pixels from an image should avoid calling
   this method directly since that operation could result in problems
   with retrieving the requested pixels.

  model - the specified ColorModel - `java.awt.image.ColorModel`"
  ([^java.awt.image.PixelGrabber this ^java.awt.image.ColorModel model]
    (-> this (.setColorModel model))))

(defn status
  "Returns the status of the pixels.  The ImageObserver flags
   representing the available pixel information are returned.
   This method and getStatus have the
   same implementation, but getStatus is the
   preferred method because it conforms to the convention of
   naming information-retrieval methods with the form
   `getXXX`.

  returns: the bitwise OR of all relevant ImageObserver flags - `int`"
  (^Integer [^java.awt.image.PixelGrabber this]
    (-> this (.status))))

(defn get-height
  "Get the height of the pixel buffer (after adjusting for image height).
   If no width was specified for the rectangle of pixels to grab then
   then this information will only be available after the image has
   delivered the dimensions.

  returns: the final height used for the pixel buffer or -1 if the height
   is not yet known - `int`"
  (^Integer [^java.awt.image.PixelGrabber this]
    (-> this (.getHeight))))

(defn set-properties
  "The setProperties method is part of the ImageConsumer API which
   this class must implement to retrieve the pixels.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being grabbed.  Developers using
   this class to retrieve pixels from an image should avoid calling
   this method directly since that operation could result in problems
   with retrieving the requested pixels.

  props - the list of properties - `java.util.Hashtable<?,?>`"
  ([^java.awt.image.PixelGrabber this ^java.util.Hashtable props]
    (-> this (.setProperties props))))

(defn grab-pixels
  "Request the Image or ImageProducer to start delivering pixels and
   wait for all of the pixels in the rectangle of interest to be
   delivered or until the specified timeout has elapsed.  This method
   behaves in the following ways, depending on the value of
   ms:

    If ms == 0, waits until all pixels are delivered
    If ms > 0, waits until all pixels are delivered
   as timeout expires.
    If ms < 0, returns true if all pixels
   are grabbed, false otherwise and does not wait.

  ms - the number of milliseconds to wait for the image pixels to arrive before timing out - `long`

  returns: true if the pixels were successfully grabbed, false on
   abort, error or timeout - `boolean`

  throws: java.lang.InterruptedException - Another thread has interrupted this thread."
  (^Boolean [^java.awt.image.PixelGrabber this ^Long ms]
    (-> this (.grabPixels ms)))
  (^Boolean [^java.awt.image.PixelGrabber this]
    (-> this (.grabPixels))))

(defn image-complete
  "The imageComplete method is part of the ImageConsumer API which
   this class must implement to retrieve the pixels.

   Note: This method is intended to be called by the ImageProducer
   of the Image whose pixels are being grabbed.  Developers using
   this class to retrieve pixels from an image should avoid calling
   this method directly since that operation could result in problems
   with retrieving the requested pixels.

  status - the status of image loading - `int`"
  ([^java.awt.image.PixelGrabber this ^Integer status]
    (-> this (.imageComplete status))))

(defn get-color-model
  "Get the ColorModel for the pixels stored in the array.  If the
   PixelGrabber was constructed with an explicit pixel buffer then
   this method will always return the default RGB ColorModel,
   otherwise it may return null until the ColorModel used by the
   ImageProducer is known.
   Since the PixelGrabber may fall back on accumulating the data
   in the default RGB ColorModel at any time if the source image
   uses more than one ColorModel to deliver the data, the ColorModel
   object returned by this method may change over time until the
   image grab is complete and may not reflect any of the ColorModel
   objects that was used by the ImageProducer to deliver the pixels.

  returns: the ColorModel object used for storing the pixels - `java.awt.image.ColorModel`"
  (^java.awt.image.ColorModel [^java.awt.image.PixelGrabber this]
    (-> this (.getColorModel))))

