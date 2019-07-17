(ns jdk.awt.Paint
  "This Paint interface defines how color patterns
  can be generated for Graphics2D operations.  A class
  implementing the Paint interface is added to the
  Graphics2D context in order to define the color
  pattern used by the draw and fill methods.

  Instances of classes implementing Paint must be
  read-only because the Graphics2D does not clone
  these objects when they are set as an attribute with the
  setPaint method or when the Graphics2D
  object is itself cloned."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Paint]))

(defn create-context
  "Creates and returns a PaintContext used to
   generate the color pattern.
   The arguments to this method convey additional information
   about the rendering operation that may be
   used or ignored on various implementations of the Paint interface.
   A caller must pass non-null values for all of the arguments
   except for the ColorModel argument which may be null to
   indicate that no specific ColorModel type is preferred.
   Implementations of the Paint interface are allowed to use or ignore
   any of the arguments as makes sense for their function, and are
   not constrained to use the specified ColorModel for the returned
   PaintContext, even if it is not null.
   Implementations are allowed to throw NullPointerException for
   any null argument other than the ColorModel argument,
   but are not required to do so.

  cm - the preferred ColorModel which represents the most convenient format for the caller to receive the pixel data, or null if there is no preference. - `java.awt.image.ColorModel`
  device-bounds - the device space bounding box of the graphics primitive being rendered. Implementations of the Paint interface are allowed to throw NullPointerException for a null deviceBounds. - `java.awt.Rectangle`
  user-bounds - the user space bounding box of the graphics primitive being rendered. Implementations of the Paint interface are allowed to throw NullPointerException for a null userBounds. - `java.awt.geom.Rectangle2D`
  xform - the AffineTransform from user space into device space. Implementations of the Paint interface are allowed to throw NullPointerException for a null xform. - `java.awt.geom.AffineTransform`
  hints - the set of hints that the context object can use to choose between rendering alternatives. Implementations of the Paint interface are allowed to throw NullPointerException for a null hints. - `java.awt.RenderingHints`

  returns: the PaintContext for
           generating color patterns. - `java.awt.PaintContext`"
  ([^. this ^java.awt.image.ColorModel cm ^java.awt.Rectangle device-bounds ^java.awt.geom.Rectangle2D user-bounds ^java.awt.geom.AffineTransform xform ^java.awt.RenderingHints hints]
    (-> this (.createContext cm device-bounds user-bounds xform hints))))

