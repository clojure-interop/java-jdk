(ns jdk.awt.image.renderable.ContextualRenderedImageFactory
  "ContextualRenderedImageFactory provides an interface for the
  functionality that may differ between instances of
  RenderableImageOp.  Thus different operations on RenderableImages
  may be performed by a single class such as RenderedImageOp through
  the use of multiple instances of ContextualRenderedImageFactory.
  The name ContextualRenderedImageFactory is commonly shortened to
  `CRIF.`

   All operations that are to be used in a rendering-independent
  chain must implement ContextualRenderedImageFactory.

   Classes that implement this interface must provide a
  constructor with no arguments."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image.renderable ContextualRenderedImageFactory]))

(defn map-render-context
  "Maps the operation's output RenderContext into a RenderContext
   for each of the operation's sources.  This is useful for
   operations that can be expressed in whole or in part simply as
   alterations in the RenderContext, such as an affine mapping, or
   operations that wish to obtain lower quality renderings of
   their sources in order to save processing effort or
   transmission bandwith.  Some operations, such as blur, can also
   use this mechanism to avoid obtaining sources of higher quality
   than necessary.

  i - the index of the source image. - `int`
  render-context - the RenderContext being applied to the operation. - `java.awt.image.renderable.RenderContext`
  param-block - a ParameterBlock containing the operation's sources and parameters. - `java.awt.image.renderable.ParameterBlock`
  image - the RenderableImage being rendered. - `java.awt.image.renderable.RenderableImage`

  returns: a RenderContext for
           the source at the specified index of the parameters
           Vector contained in the specified ParameterBlock. - `java.awt.image.renderable.RenderContext`"
  (^java.awt.image.renderable.RenderContext [^ContextualRenderedImageFactory this ^Integer i ^java.awt.image.renderable.RenderContext render-context ^java.awt.image.renderable.ParameterBlock param-block ^java.awt.image.renderable.RenderableImage image]
    (-> this (.mapRenderContext i render-context param-block image))))

(defn create
  "Creates a rendering, given a RenderContext and a ParameterBlock
   containing the operation's sources and parameters.  The output
   is a RenderedImage that takes the RenderContext into account to
   determine its dimensions and placement on the image plane.
   This method houses the `intelligence` that allows a
   rendering-independent operation to adapt to a specific
   RenderContext.

  render-context - The RenderContext specifying the rendering - `java.awt.image.renderable.RenderContext`
  param-block - a ParameterBlock containing the operation's sources and parameters - `java.awt.image.renderable.ParameterBlock`

  returns: a RenderedImage from the sources and parameters
           in the specified ParameterBlock and according to the
           rendering instructions in the specified RenderContext. - `java.awt.image.RenderedImage`"
  (^java.awt.image.RenderedImage [^ContextualRenderedImageFactory this ^java.awt.image.renderable.RenderContext render-context ^java.awt.image.renderable.ParameterBlock param-block]
    (-> this (.create render-context param-block))))

(defn get-bounds-2-d
  "Returns the bounding box for the output of the operation,
   performed on a given set of sources, in rendering-independent
   space.  The bounds are returned as a Rectangle2D, that is, an
   axis-aligned rectangle with floating-point corner coordinates.

  param-block - a ParameterBlock containing the operation's sources and parameters. - `java.awt.image.renderable.ParameterBlock`

  returns: a Rectangle2D specifying the rendering-independent
           bounding box of the output. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^ContextualRenderedImageFactory this ^java.awt.image.renderable.ParameterBlock param-block]
    (-> this (.getBounds2D param-block))))

(defn get-property
  "Gets the appropriate instance of the property specified by the name
   parameter.  This method must determine which instance of a property to
   return when there are multiple sources that each specify the property.

  param-block - a ParameterBlock containing the operation's sources and parameters. - `java.awt.image.renderable.ParameterBlock`
  name - a String naming the desired property. - `java.lang.String`

  returns: an object reference to the value of the property requested. - `java.lang.Object`"
  (^java.lang.Object [^ContextualRenderedImageFactory this ^java.awt.image.renderable.ParameterBlock param-block ^java.lang.String name]
    (-> this (.getProperty param-block name))))

(defn get-property-names
  "Returns a list of names recognized by getProperty.

  returns: the list of property names. - `java.lang.String[]`"
  ([^ContextualRenderedImageFactory this]
    (-> this (.getPropertyNames))))

(defn dynamic?
  "Returns true if successive renderings (that is, calls to
   create(RenderContext, ParameterBlock)) with the same arguments
   may produce different results.  This method may be used to
   determine whether an existing rendering may be cached and
   reused.  It is always safe to return true.

  returns: true if successive renderings with the
           same arguments might produce different results;
           false otherwise. - `boolean`"
  (^Boolean [^ContextualRenderedImageFactory this]
    (-> this (.isDynamic))))

