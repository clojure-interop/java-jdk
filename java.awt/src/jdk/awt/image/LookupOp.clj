(ns jdk.awt.image.LookupOp
  "This class implements a lookup operation from the source
  to the destination.  The LookupTable object may contain a single array
  or multiple arrays, subject to the restrictions below.

  For Rasters, the lookup operates on bands.  The number of
  lookup arrays may be one, in which case the same array is
  applied to all bands, or it must equal the number of Source
  Raster bands.

  For BufferedImages, the lookup operates on color and alpha components.
  The number of lookup arrays may be one, in which case the
  same array is applied to all color (but not alpha) components.
  Otherwise, the number of lookup arrays may
  equal the number of Source color components, in which case no
  lookup of the alpha component (if present) is performed.
  If neither of these cases apply, the number of lookup arrays
  must equal the number of Source color components plus alpha components,
  in which case lookup is performed for all color and alpha components.
  This allows non-uniform rescaling of multi-band BufferedImages.

  BufferedImage sources with premultiplied alpha data are treated in the same
  manner as non-premultiplied images for purposes of the lookup.  That is,
  the lookup is done per band on the raw data of the BufferedImage source
  without regard to whether the data is premultiplied.  If a color conversion
  is required to the destination ColorModel, the premultiplied state of
  both source and destination will be taken into account for this step.

  Images with an IndexColorModel cannot be used.

  If a RenderingHints object is specified in the constructor, the
  color rendering hint and the dithering hint may be used when color
  conversion is required.

  This class allows the Source to be the same as the Destination."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image LookupOp]))

(defn ->lookup-op
  "Constructor.

  Constructs a LookupOp object given the lookup
   table and a RenderingHints object, which might
   be null.

  lookup - the specified LookupTable - `java.awt.image.LookupTable`
  hints - the specified RenderingHints, or null - `java.awt.RenderingHints`"
  ([^java.awt.image.LookupTable lookup ^java.awt.RenderingHints hints]
    (new LookupOp lookup hints)))

(defn get-table
  "Returns the LookupTable.

  returns: the LookupTable of this
           LookupOp. - `java.awt.image.LookupTable`"
  (^java.awt.image.LookupTable [^java.awt.image.LookupOp this]
    (-> this (.getTable))))

(defn filter
  "Performs a lookup operation on a BufferedImage.
   If the color model in the source image is not the same as that
   in the destination image, the pixels will be converted
   in the destination.  If the destination image is null,
   a BufferedImage will be created with an appropriate
   ColorModel.  An IllegalArgumentException
   might be thrown if the number of arrays in the
   LookupTable does not meet the restrictions
   stated in the class comment above, or if the source image
   has an IndexColorModel.

  src - the BufferedImage to be filtered - `java.awt.image.BufferedImage`
  dst - the BufferedImage in which to store the results of the filter operation - `java.awt.image.BufferedImage`

  returns: the filtered BufferedImage. - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalArgumentException - if the number of arrays in the LookupTable does not meet the restrictions described in the class comments, or if the source image has an IndexColorModel."
  (^java.awt.image.BufferedImage [^java.awt.image.LookupOp this ^java.awt.image.BufferedImage src ^java.awt.image.BufferedImage dst]
    (-> this (.filter src dst))))

(defn get-bounds-2-d
  "Returns the bounding box of the filtered destination image.  Since
   this is not a geometric operation, the bounding box does not
   change.

  src - the BufferedImage to be filtered - `java.awt.image.BufferedImage`

  returns: the bounds of the filtered definition image. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^java.awt.image.LookupOp this ^java.awt.image.BufferedImage src]
    (-> this (.getBounds2D src))))

(defn create-compatible-dest-image
  "Creates a zeroed destination image with the correct size and number of
   bands.  If destCM is null, an appropriate
   ColorModel will be used.

  src - Source image for the filter operation. - `java.awt.image.BufferedImage`
  dest-cm - the destination's ColorModel, which can be null. - `java.awt.image.ColorModel`

  returns: a filtered destination BufferedImage. - `java.awt.image.BufferedImage`"
  (^java.awt.image.BufferedImage [^java.awt.image.LookupOp this ^java.awt.image.BufferedImage src ^java.awt.image.ColorModel dest-cm]
    (-> this (.createCompatibleDestImage src dest-cm))))

(defn create-compatible-dest-raster
  "Creates a zeroed-destination Raster with the
   correct size and number of bands, given this source.

  src - the Raster to be transformed - `java.awt.image.Raster`

  returns: the zeroed-destination Raster. - `java.awt.image.WritableRaster`"
  (^java.awt.image.WritableRaster [^java.awt.image.LookupOp this ^java.awt.image.Raster src]
    (-> this (.createCompatibleDestRaster src))))

(defn get-point-2-d
  "Returns the location of the destination point given a
   point in the source.  If dstPt is not
   null, it will be used to hold the return value.
   Since this is not a geometric operation, the srcPt
   will equal the dstPt.

  src-pt - a Point2D that represents a point in the source image - `java.awt.geom.Point2D`
  dst-pt - a Point2Dthat represents the location in the destination - `java.awt.geom.Point2D`

  returns: the Point2D in the destination that
           corresponds to the specified point in the source. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.image.LookupOp this ^java.awt.geom.Point2D src-pt ^java.awt.geom.Point2D dst-pt]
    (-> this (.getPoint2D src-pt dst-pt))))

(defn get-rendering-hints
  "Returns the rendering hints for this op.

  returns: the RenderingHints object associated
           with this op. - `java.awt.RenderingHints`"
  (^java.awt.RenderingHints [^java.awt.image.LookupOp this]
    (-> this (.getRenderingHints))))

