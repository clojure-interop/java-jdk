(ns jdk.awt.image.ConvolveOp
  "This class implements a convolution from the source
  to the destination.
  Convolution using a convolution kernel is a spatial operation that
  computes the output pixel from an input pixel by multiplying the kernel
  with the surround of the input pixel.
  This allows the output pixel to be affected by the immediate neighborhood
  in a way that can be mathematically specified with a kernel.

  This class operates with BufferedImage data in which color components are
  premultiplied with the alpha component.  If the Source BufferedImage has
  an alpha component, and the color components are not premultiplied with
  the alpha component, then the data are premultiplied before being
  convolved.  If the Destination has color components which are not
  premultiplied, then alpha is divided out before storing into the
  Destination (if alpha is 0, the color components are set to 0).  If the
  Destination has no alpha component, then the resulting alpha is discarded
  after first dividing it out of the color components.

  Rasters are treated as having no alpha channel.  If the above treatment
  of the alpha channel in BufferedImages is not desired, it may be avoided
  by getting the Raster of a source BufferedImage and using the filter method
  of this class which works with Rasters.

  If a RenderingHints object is specified in the constructor, the
  color rendering hint and the dithering hint may be used when color
  conversion is required.

  Note that the Source and the Destination may not be the same object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ConvolveOp]))

(defn ->convolve-op
  "Constructor.

  Constructs a ConvolveOp given a Kernel, an edge condition, and a
   RenderingHints object (which may be null).

  kernel - the specified Kernel - `java.awt.image.Kernel`
  edge-condition - the specified edge condition - `int`
  hints - the specified RenderingHints object - `java.awt.RenderingHints`"
  ([^java.awt.image.Kernel kernel ^Integer edge-condition ^java.awt.RenderingHints hints]
    (new ConvolveOp kernel edge-condition hints))
  ([^java.awt.image.Kernel kernel]
    (new ConvolveOp kernel)))

(def *-edge-zero-fill
  "Static Constant.

  Pixels at the edge of the destination image are set to zero.  This
   is the default.

  type: java.lang.annotation.    int"
  ConvolveOp/EDGE_ZERO_FILL)

(def *-edge-no-op
  "Static Constant.

  Pixels at the edge of the source image are copied to
   the corresponding pixels in the destination without modification.

  type: java.lang.annotation.    int"
  ConvolveOp/EDGE_NO_OP)

(defn get-edge-condition
  "Returns the edge condition.

  returns: the edge condition of this ConvolveOp. - `int`"
  ([^java.awt.image.ConvolveOp this]
    (-> this (.getEdgeCondition))))

(defn get-kernel
  "Returns the Kernel.

  returns: the Kernel of this ConvolveOp. - `java.awt.image.Kernel`"
  ([^java.awt.image.ConvolveOp this]
    (-> this (.getKernel))))

(defn filter
  "Performs a convolution on BufferedImages.  Each component of the
   source image will be convolved (including the alpha component, if
   present).
   If the color model in the source image is not the same as that
   in the destination image, the pixels will be converted
   in the destination.  If the destination image is null,
   a BufferedImage will be created with the source ColorModel.
   The IllegalArgumentException may be thrown if the source is the
   same as the destination.

  src - the source BufferedImage to filter - `java.awt.image.BufferedImage`
  dst - the destination BufferedImage for the filtered src - `java.awt.image.BufferedImage`

  returns: the filtered BufferedImage - `java.awt.image.BufferedImage`

  throws: java.lang.NullPointerException - if src is null"
  ([^java.awt.image.ConvolveOp this ^java.awt.image.BufferedImage src ^java.awt.image.BufferedImage dst]
    (-> this (.filter src dst))))

(defn create-compatible-dest-image
  "Creates a zeroed destination image with the correct size and number
   of bands.  If destCM is null, an appropriate ColorModel will be used.

  src - Source image for the filter operation. - `java.awt.image.BufferedImage`
  dest-cm - ColorModel of the destination. Can be null. - `java.awt.image.ColorModel`

  returns: a destination BufferedImage with the correct
           size and number of bands. - `java.awt.image.BufferedImage`"
  ([^java.awt.image.ConvolveOp this ^java.awt.image.BufferedImage src ^java.awt.image.ColorModel dest-cm]
    (-> this (.createCompatibleDestImage src dest-cm))))

(defn create-compatible-dest-raster
  "Creates a zeroed destination Raster with the correct size and number
   of bands, given this source.

  src - the source Raster - `java.awt.image.Raster`

  returns: a WritableRaster that is compatible with
           src - `java.awt.image.WritableRaster`"
  ([^java.awt.image.ConvolveOp this ^java.awt.image.Raster src]
    (-> this (.createCompatibleDestRaster src))))

(defn get-bounds-2-d
  "Returns the bounding box of the filtered destination image.  Since
   this is not a geometric operation, the bounding box does not
   change.

  src - The BufferedImage to be filtered - `java.awt.image.BufferedImage`

  returns: The Rectangle2D representing the destination
   image's bounding box. - `java.awt.geom.Rectangle2D`"
  ([^java.awt.image.ConvolveOp this ^java.awt.image.BufferedImage src]
    (-> this (.getBounds2D src))))

(defn get-point-2-d
  "Returns the location of the destination point given a
   point in the source.  If dstPt is non-null, it will
   be used to hold the return value.  Since this is not a geometric
   operation, the srcPt will equal the dstPt.

  src-pt - the Point2D that represents the point in the source image - `java.awt.geom.Point2D`
  dst-pt - The Point2D in which to store the result - `java.awt.geom.Point2D`

  returns: The Point2D in the destination image that
   corresponds to the specified point in the source image. - `java.awt.geom.Point2D`"
  ([^java.awt.image.ConvolveOp this ^java.awt.geom.Point2D src-pt ^java.awt.geom.Point2D dst-pt]
    (-> this (.getPoint2D src-pt dst-pt))))

(defn get-rendering-hints
  "Returns the rendering hints for this op.

  returns: The RenderingHints object for this
   BufferedImageOp.  Returns
   null if no hints have been set. - `java.awt.RenderingHints`"
  ([^java.awt.image.ConvolveOp this]
    (-> this (.getRenderingHints))))

