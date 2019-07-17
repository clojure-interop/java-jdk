(ns jdk.awt.image.RGBImageFilter
  "This class provides an easy way to create an ImageFilter which modifies
  the pixels of an image in the default RGB ColorModel.  It is meant to
  be used in conjunction with a FilteredImageSource object to produce
  filtered versions of existing images.  It is an abstract class that
  provides the calls needed to channel all of the pixel data through a
  single method which converts pixels one at a time in the default RGB
  ColorModel regardless of the ColorModel being used by the ImageProducer.
  The only method which needs to be defined to create a useable image
  filter is the filterRGB method.  Here is an example of a definition
  of a filter which swaps the red and blue components of an image:


       class RedBlueSwapFilter extends RGBImageFilter {
           public RedBlueSwapFilter() {
               // The filter's operation does not depend on the
               // pixel's location, so IndexColorModels can be
               // filtered directly.
               canFilterIndexColorModel = true;
           }

           public int filterRGB(int x, int y, int rgb) {
               return ((rgb & 0xff00ff00)
                       | ((rgb & 0xff0000) >> 16)
                       | ((rgb & 0xff) << 16));
           }
       }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image RGBImageFilter]))

(defn ->rgb-image-filter
  "Constructor."
  ([]
    (new RGBImageFilter )))

(defn set-color-model
  "If the ColorModel is an IndexColorModel and the subclass has
   set the canFilterIndexColorModel flag to true, we substitute
   a filtered version of the color model here and wherever
   that original ColorModel object appears in the setPixels methods.
   If the ColorModel is not an IndexColorModel or is null, this method
   overrides the default ColorModel used by the ImageProducer and
   specifies the default RGB ColorModel instead.

   Note: This method is intended to be called by the
   ImageProducer of the Image whose pixels
   are being filtered. Developers using
   this class to filter pixels from an image should avoid calling
   this method directly since that operation could interfere
   with the filtering operation.

  model - the specified ColorModel - `java.awt.image.ColorModel`"
  ([^java.awt.image.RGBImageFilter this ^java.awt.image.ColorModel model]
    (-> this (.setColorModel model))))

(defn substitute-color-model
  "Registers two ColorModel objects for substitution.  If the oldcm
   is encountered during any of the setPixels methods, the newcm
   is substituted and the pixels passed through
   untouched (but with the new ColorModel object).

  oldcm - the ColorModel object to be replaced on the fly - `java.awt.image.ColorModel`
  newcm - the ColorModel object to replace oldcm on the fly - `java.awt.image.ColorModel`"
  ([^java.awt.image.RGBImageFilter this ^java.awt.image.ColorModel oldcm ^java.awt.image.ColorModel newcm]
    (-> this (.substituteColorModel oldcm newcm))))

(defn filter-index-color-model
  "Filters an IndexColorModel object by running each entry in its
   color tables through the filterRGB function that RGBImageFilter
   subclasses must provide.  Uses coordinates of -1 to indicate that
   a color table entry is being filtered rather than an actual
   pixel value.

  icm - the IndexColorModel object to be filtered - `java.awt.image.IndexColorModel`

  returns: a new IndexColorModel representing the filtered colors - `java.awt.image.IndexColorModel`

  throws: java.lang.NullPointerException - if icm is null"
  (^java.awt.image.IndexColorModel [^java.awt.image.RGBImageFilter this ^java.awt.image.IndexColorModel icm]
    (-> this (.filterIndexColorModel icm))))

(defn filter-rgb-pixels
  "Filters a buffer of pixels in the default RGB ColorModel by passing
   them one by one through the filterRGB method.

  x - the X coordinate of the upper-left corner of the region of pixels - `int`
  y - the Y coordinate of the upper-left corner of the region of pixels - `int`
  w - the width of the region of pixels - `int`
  h - the height of the region of pixels - `int`
  pixels - the array of pixels - `int[]`
  off - the offset into the pixels array - `int`
  scansize - the distance from one row of pixels to the next in the array - `int`"
  ([^java.awt.image.RGBImageFilter this ^Integer x ^Integer y ^Integer w ^Integer h pixels ^Integer off ^Integer scansize]
    (-> this (.filterRGBPixels x y w h pixels off scansize))))

(defn set-pixels
  "If the ColorModel object is the same one that has already
   been converted, then simply passes the pixels through with the
   converted ColorModel. Otherwise converts the buffer of byte
   pixels to the default RGB ColorModel and passes the converted
   buffer to the filterRGBPixels method to be converted one by one.

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
  ([^java.awt.image.RGBImageFilter this ^Integer x ^Integer y ^Integer w ^Integer h ^java.awt.image.ColorModel model pixels ^Integer off ^Integer scansize]
    (-> this (.setPixels x y w h model pixels off scansize))))

(defn filter-rgb
  "Subclasses must specify a method to convert a single input pixel
   in the default RGB ColorModel to a single output pixel.

  x - the X coordinate of the pixel - `int`
  y - the Y coordinate of the pixel - `int`
  rgb - the integer pixel representation in the default RGB color model - `int`

  returns: a filtered pixel in the default RGB color model. - `int`"
  (^Integer [^java.awt.image.RGBImageFilter this ^Integer x ^Integer y ^Integer rgb]
    (-> this (.filterRGB x y rgb))))

