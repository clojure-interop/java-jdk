(ns jdk.awt.Composite
  "The Composite interface, along with
  CompositeContext, defines the methods to compose a draw
  primitive with the underlying graphics area.
  After the Composite is set in the
  Graphics2D context, it combines a shape, text, or an image
  being rendered with the colors that have already been rendered
  according to pre-defined rules. The classes
  implementing this interface provide the rules and a method to create
  the context for a particular operation.
  CompositeContext is an environment used by the
  compositing operation, which is created by the Graphics2D
  prior to the start of the operation.  CompositeContext
  contains private information and resources needed for a compositing
  operation.  When the CompositeContext is no longer needed,
  the Graphics2D object disposes of it in order to reclaim
  resources allocated for the operation.

  Instances of classes implementing Composite must be
  immutable because the Graphics2D does not clone
  these objects when they are set as an attribute with the
  setComposite method or when the Graphics2D
  object is cloned.  This is to avoid undefined rendering behavior of
  Graphics2D, resulting from the modification of
  the Composite object after it has been set in the
  Graphics2D context.

  Since this interface must expose the contents of pixels on the
  target device or image to potentially arbitrary code, the use of
  custom objects which implement this interface when rendering directly
  to a screen device is governed by the readDisplayPixels
  AWTPermission.  The permission check will occur when such
  a custom object is passed to the setComposite method
  of a Graphics2D retrieved from a Component."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Composite]))

(defn create-context
  "Creates a context containing state that is used to perform
   the compositing operation.  In a multi-threaded environment,
   several contexts can exist simultaneously for a single
   Composite object.

  src-color-model - the ColorModel of the source - `java.awt.image.ColorModel`
  dst-color-model - the ColorModel of the destination - `java.awt.image.ColorModel`
  hints - the hint that the context object uses to choose between rendering alternatives - `java.awt.RenderingHints`

  returns: the CompositeContext object used to perform the
   compositing operation. - `java.awt.CompositeContext`"
  (^java.awt.CompositeContext [^Composite this ^java.awt.image.ColorModel src-color-model ^java.awt.image.ColorModel dst-color-model ^java.awt.RenderingHints hints]
    (-> this (.createContext src-color-model dst-color-model hints))))

