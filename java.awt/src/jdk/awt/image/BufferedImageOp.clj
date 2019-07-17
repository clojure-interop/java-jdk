(ns jdk.awt.image.BufferedImageOp
  "This interface describes single-input/single-output
  operations performed on BufferedImage objects.
  It is implemented by AffineTransformOp,
  ConvolveOp, ColorConvertOp, RescaleOp,
  and LookupOp.  These objects can be passed into
  a BufferedImageFilter to operate on a
  BufferedImage in the
  ImageProducer-ImageFilter-ImageConsumer paradigm.

  Classes that implement this
  interface must specify whether or not they allow in-place filtering--
  filter operations where the source object is equal to the destination
  object.

  This interface cannot be used to describe more sophisticated operations
  such as those that take multiple sources. Note that this restriction also
  means that the values of the destination pixels prior to the operation are
  not used as input to the filter operation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image BufferedImageOp]))

(defn filter
  "Performs a single-input/single-output operation on a
   BufferedImage.
   If the color models for the two images do not match, a color
   conversion into the destination color model is performed.
   If the destination image is null,
   a BufferedImage with an appropriate ColorModel
   is created.

   An IllegalArgumentException may be thrown if the source
   and/or destination image is incompatible with the types of images       $
   allowed by the class implementing this filter.

  src - The BufferedImage to be filtered - `java.awt.image.BufferedImage`
  dest - The BufferedImage in which to store the results$ - `java.awt.image.BufferedImage`

  returns: The filtered BufferedImage. - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalArgumentException - If the source and/or destination image is not compatible with the types of images allowed by the class implementing this filter."
  ([^. this ^java.awt.image.BufferedImage src ^java.awt.image.BufferedImage dest]
    (-> this (.filter src dest))))

(defn get-bounds-2-d
  "Returns the bounding box of the filtered destination image.
   An IllegalArgumentException may be thrown if the source
   image is incompatible with the types of images allowed
   by the class implementing this filter.

  src - The BufferedImage to be filtered - `java.awt.image.BufferedImage`

  returns: The Rectangle2D representing the destination
   image's bounding box. - `java.awt.geom.Rectangle2D`"
  ([^. this ^java.awt.image.BufferedImage src]
    (-> this (.getBounds2D src))))

(defn create-compatible-dest-image
  "Creates a zeroed destination image with the correct size and number of
   bands.
   An IllegalArgumentException may be thrown if the source
   image is incompatible with the types of images allowed
   by the class implementing this filter.

  src - The BufferedImage to be filtered - `java.awt.image.BufferedImage`
  dest-cm - ColorModel of the destination. If null, the ColorModel of the source is used. - `java.awt.image.ColorModel`

  returns: The zeroed destination image. - `java.awt.image.BufferedImage`"
  ([^. this ^java.awt.image.BufferedImage src ^java.awt.image.ColorModel dest-cm]
    (-> this (.createCompatibleDestImage src dest-cm))))

(defn get-point-2-d
  "Returns the location of the corresponding destination point given a
   point in the source image.  If dstPt is specified, it
   is used to hold the return value.

  src-pt - the Point2D that represents the point in the source image - `java.awt.geom.Point2D`
  dst-pt - The Point2D in which to store the result - `java.awt.geom.Point2D`

  returns: The Point2D in the destination image that
   corresponds to the specified point in the source image. - `java.awt.geom.Point2D`"
  ([^. this ^java.awt.geom.Point2D src-pt ^java.awt.geom.Point2D dst-pt]
    (-> this (.getPoint2D src-pt dst-pt))))

(defn get-rendering-hints
  "Returns the rendering hints for this operation.

  returns: The RenderingHints object for this
   BufferedImageOp.  Returns
   null if no hints have been set. - `java.awt.RenderingHints`"
  ([^. this]
    (-> this (.getRenderingHints))))

