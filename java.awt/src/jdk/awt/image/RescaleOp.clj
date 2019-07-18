(ns jdk.awt.image.RescaleOp
  "This class performs a pixel-by-pixel rescaling of the data in the
  source image by multiplying the sample values for each pixel by a scale
  factor and then adding an offset. The scaled sample values are clipped
  to the minimum/maximum representable in the destination image.

  The pseudo code for the rescaling operation is as follows:


 for each pixel from Source object {
     for each band/component of the pixel {
         dstElement = (srcElement*scaleFactor)  offset
     }
 }

  For Rasters, rescaling operates on bands.  The number of
  sets of scaling constants may be one, in which case the same constants
  are applied to all bands, or it must equal the number of Source
  Raster bands.

  For BufferedImages, rescaling operates on color and alpha components.
  The number of sets of scaling constants may be one, in which case the
  same constants are applied to all color (but not alpha) components.
  Otherwise, the  number of sets of scaling constants may
  equal the number of Source color components, in which case no
  rescaling of the alpha component (if present) is performed.
  If neither of these cases apply, the number of sets of scaling constants
  must equal the number of Source color components plus alpha components,
  in which case all color and alpha components are rescaled.

  BufferedImage sources with premultiplied alpha data are treated in the same
  manner as non-premultiplied images for purposes of rescaling.  That is,
  the rescaling is done per band on the raw data of the BufferedImage source
  without regard to whether the data is premultiplied.  If a color conversion
  is required to the destination ColorModel, the premultiplied state of
  both source and destination will be taken into account for this step.

  Images with an IndexColorModel cannot be rescaled.

  If a RenderingHints object is specified in the constructor, the
  color rendering hint and the dithering hint may be used when color
  conversion is required.

  Note that in-place operation is allowed (i.e. the source and destination can
  be the same object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image RescaleOp]))

(defn ->rescale-op
  "Constructor.

  Constructs a new RescaleOp with the desired scale factors
   and offsets.  The length of the scaleFactor and offset arrays
   must meet the restrictions stated in the class comments above.
   The RenderingHints argument may be null.

  scale-factors - the specified scale factors - `float[]`
  offsets - the specified offsets - `float[]`
  hints - the specified RenderingHints, or null - `java.awt.RenderingHints`"
  (^RescaleOp [scale-factors offsets ^java.awt.RenderingHints hints]
    (new RescaleOp scale-factors offsets hints)))

(defn get-point-2-d
  "Returns the location of the destination point given a
   point in the source.  If dstPt is non-null, it will
   be used to hold the return value.  Since this is not a geometric
   operation, the srcPt will equal the dstPt.

  src-pt - a point in the source image - `java.awt.geom.Point2D`
  dst-pt - the destination point or null - `java.awt.geom.Point2D`

  returns: the location of the destination point. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^RescaleOp this ^java.awt.geom.Point2D src-pt ^java.awt.geom.Point2D dst-pt]
    (-> this (.getPoint2D src-pt dst-pt))))

(defn get-rendering-hints
  "Returns the rendering hints for this op.

  returns: the rendering hints of this RescaleOp. - `java.awt.RenderingHints`"
  (^java.awt.RenderingHints [^RescaleOp this]
    (-> this (.getRenderingHints))))

(defn create-compatible-dest-image
  "Creates a zeroed destination image with the correct size and number of
   bands.

  src - Source image for the filter operation. - `java.awt.image.BufferedImage`
  dest-cm - ColorModel of the destination. If null, the ColorModel of the source will be used. - `java.awt.image.ColorModel`

  returns: the zeroed-destination image. - `java.awt.image.BufferedImage`"
  (^java.awt.image.BufferedImage [^RescaleOp this ^java.awt.image.BufferedImage src ^java.awt.image.ColorModel dest-cm]
    (-> this (.createCompatibleDestImage src dest-cm))))

(defn get-offsets
  "Returns the offsets in the given array. The array is also returned
   for convenience.  If offsets is null, a new array
   will be allocated.

  offsets - the array to contain the offsets of this RescaleOp - `float[]`

  returns: the offsets of this RescaleOp. - `float[]`"
  ([^RescaleOp this offsets]
    (-> this (.getOffsets offsets))))

(defn get-scale-factors
  "Returns the scale factors in the given array. The array is also
   returned for convenience.  If scaleFactors is null, a new array
   will be allocated.

  scale-factors - the array to contain the scale factors of this RescaleOp - `float[]`

  returns: the scale factors of this RescaleOp. - `float[]`"
  ([^RescaleOp this scale-factors]
    (-> this (.getScaleFactors scale-factors))))

(defn create-compatible-dest-raster
  "Creates a zeroed-destination Raster with the correct
   size and number of bands, given this source.

  src - the source Raster - `java.awt.image.Raster`

  returns: the zeroed-destination Raster. - `java.awt.image.WritableRaster`"
  (^java.awt.image.WritableRaster [^RescaleOp this ^java.awt.image.Raster src]
    (-> this (.createCompatibleDestRaster src))))

(defn filter
  "Rescales the source BufferedImage.
   If the color model in the source image is not the same as that
   in the destination image, the pixels will be converted
   in the destination.  If the destination image is null,
   a BufferedImage will be created with the source ColorModel.
   An IllegalArgumentException may be thrown if the number of
   scaling factors/offsets in this object does not meet the
   restrictions stated in the class comments above, or if the
   source image has an IndexColorModel.

  src - the BufferedImage to be filtered - `java.awt.image.BufferedImage`
  dst - the destination for the filtering operation or null - `java.awt.image.BufferedImage`

  returns: the filtered BufferedImage. - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalArgumentException - if the ColorModel of src is an IndexColorModel, or if the number of scaling factors and offsets in this RescaleOp do not meet the requirements stated in the class comments."
  (^java.awt.image.BufferedImage [^RescaleOp this ^java.awt.image.BufferedImage src ^java.awt.image.BufferedImage dst]
    (-> this (.filter src dst))))

(defn get-bounds-2-d
  "Returns the bounding box of the rescaled destination image.  Since
   this is not a geometric operation, the bounding box does not
   change.

  src - The BufferedImage to be filtered - `java.awt.image.BufferedImage`

  returns: The Rectangle2D representing the destination
   image's bounding box. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^RescaleOp this ^java.awt.image.BufferedImage src]
    (-> this (.getBounds2D src))))

(defn get-num-factors
  "Returns the number of scaling factors and offsets used in this
   RescaleOp.

  returns: the number of scaling factors and offsets of this
           RescaleOp. - `int`"
  (^Integer [^RescaleOp this]
    (-> this (.getNumFactors))))

