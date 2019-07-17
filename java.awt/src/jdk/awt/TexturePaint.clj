(ns jdk.awt.TexturePaint
  "The TexturePaint class provides a way to fill a
  Shape with a texture that is specified as
  a BufferedImage. The size of the BufferedImage
  object should be small because the BufferedImage data
  is copied by the TexturePaint object.
  At construction time, the texture is anchored to the upper
  left corner of a Rectangle2D that is
  specified in user space.  Texture is computed for
  locations in the device space by conceptually replicating the
  specified Rectangle2D infinitely in all directions
  in user space and mapping the BufferedImage to each
  replicated Rectangle2D."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt TexturePaint]))

(defn ->texture-paint
  "Constructor.

  Constructs a TexturePaint object.

  txtr - the BufferedImage object with the texture used for painting - `java.awt.image.BufferedImage`
  anchor - the Rectangle2D in user space used to anchor and replicate the texture - `java.awt.geom.Rectangle2D`"
  ([txtr anchor]
    (new TexturePaint txtr anchor)))

(defn get-image
  "Returns the BufferedImage texture used to
   fill the shapes.

  returns: a BufferedImage. - `java.awt.image.BufferedImage`"
  ([this]
    (-> this (.getImage))))

(defn get-anchor-rect
  "Returns a copy of the anchor rectangle which positions and
   sizes the textured image.

  returns: the Rectangle2D used to anchor and
   size this TexturePaint. - `java.awt.geom.Rectangle2D`"
  ([this]
    (-> this (.getAnchorRect))))

(defn create-context
  "Creates and returns a PaintContext used to
   generate a tiled image pattern.
   See the specification of the
   method in the Paint interface for information
   on null parameter handling.

  cm - the preferred ColorModel which represents the most convenient format for the caller to receive the pixel data, or null if there is no preference. - `java.awt.image.ColorModel`
  device-bounds - the device space bounding box of the graphics primitive being rendered. - `java.awt.Rectangle`
  user-bounds - the user space bounding box of the graphics primitive being rendered. - `java.awt.geom.Rectangle2D`
  xform - the AffineTransform from user space into device space. - `java.awt.geom.AffineTransform`
  hints - the set of hints that the context object can use to choose between rendering alternatives. - `java.awt.RenderingHints`

  returns: the PaintContext for
           generating color patterns. - `java.awt.PaintContext`"
  ([this cm device-bounds user-bounds xform hints]
    (-> this (.createContext cm device-bounds user-bounds xform hints))))

(defn get-transparency
  "Returns the transparency mode for this TexturePaint.

  returns: the transparency mode for this TexturePaint
   as an integer value. - `int`"
  ([this]
    (-> this (.getTransparency))))

