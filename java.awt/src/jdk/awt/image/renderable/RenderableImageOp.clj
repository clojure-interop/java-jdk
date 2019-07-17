(ns jdk.awt.image.renderable.RenderableImageOp
  "This class handles the renderable aspects of an operation with help
  from its associated instance of a ContextualRenderedImageFactory."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image.renderable RenderableImageOp]))

(defn ->renderable-image-op
  "Constructor.

  Constructs a RenderedImageOp given a
   ContextualRenderedImageFactory object, and
   a ParameterBlock containing RenderableImage sources and other
   parameters.  Any RenderedImage sources referenced by the
   ParameterBlock will be ignored.

  crif - a ContextualRenderedImageFactory object - `java.awt.image.renderable.ContextualRenderedImageFactory`
  param-block - a ParameterBlock containing this operation's source images and other parameters necessary for the operation to run. - `java.awt.image.renderable.ParameterBlock`"
  ([crif param-block]
    (new RenderableImageOp crif param-block)))

(defn get-width
  "Gets the width in user coordinate space.  By convention, the
   usual width of a RenderableImage is equal to the image's aspect
   ratio (width divided by height).

  returns: the width of the image in user coordinates. - `float`"
  ([this]
    (-> this (.getWidth))))

(defn create-default-rendering
  "Gets a RenderedImage instance of this image with a default
   width and height in pixels.  The RenderContext is built
   automatically with an appropriate usr2dev transform and an area
   of interest of the full image.  All the rendering hints come
   from hints passed in.  Implementors of this interface must be
   sure that there is a defined default width and height.

  returns: a RenderedImage containing the rendered data. - `java.awt.image.RenderedImage`"
  ([this]
    (-> this (.createDefaultRendering))))

(defn set-parameter-block
  "Change the current ParameterBlock of the operation, allowing
   editing of image rendering chains.  The effects of such a
   change will be visible when a new rendering is created from
   this RenderableImageOp or any dependent RenderableImageOp.

  param-block - the new ParameterBlock. - `java.awt.image.renderable.ParameterBlock`

  returns: the old ParameterBlock. - `java.awt.image.renderable.ParameterBlock`"
  ([this param-block]
    (-> this (.setParameterBlock param-block))))

(defn get-parameter-block
  "Returns a reference to the current parameter block.

  returns: the ParameterBlock of this
           RenderableImageOp. - `java.awt.image.renderable.ParameterBlock`"
  ([this]
    (-> this (.getParameterBlock))))

(defn dynamic?
  "Returns true if successive renderings (that is, calls to
   createRendering() or createScaledRendering()) with the same arguments
   may produce different results.  This method may be used to
   determine whether an existing rendering may be cached and
   reused.  The CRIF's isDynamic method will be called.

  returns: true if successive renderings with the
           same arguments might produce different results;
           false otherwise. - `boolean`"
  ([this]
    (-> this (.isDynamic))))

(defn get-min-y
  "Gets the minimum Y coordinate of the rendering-independent image data.

  returns: the minimum Y coordinate of the rendering-independent image
   data. - `float`"
  ([this]
    (-> this (.getMinY))))

(defn get-property-names
  "Return a list of names recognized by getProperty.

  returns: a list of property names. - `java.lang.String[]`"
  ([this]
    (-> this (.getPropertyNames))))

(defn get-height
  "Gets the height in user coordinate space.  By convention, the
   usual height of a RenderedImage is equal to 1.0F.

  returns: the height of the image in user coordinates. - `float`"
  ([this]
    (-> this (.getHeight))))

(defn get-property
  "Gets a property from the property set of this image.
   If the property name is not recognized, java.awt.Image.UndefinedProperty
   will be returned.

  name - the name of the property to get, as a String. - `java.lang.String`

  returns: a reference to the property Object, or the value
           java.awt.Image.UndefinedProperty. - `java.lang.Object`"
  ([this name]
    (-> this (.getProperty name))))

(defn create-rendering
  "Creates a RenderedImage which represents this
   RenderableImageOp (including its Renderable sources) rendered
   according to the given RenderContext.

    This method supports chaining of either Renderable or
   RenderedImage operations.  If sources in
   the ParameterBlock used to construct the RenderableImageOp are
   RenderableImages, then a three step process is followed:


    mapRenderContext() is called on the associated CRIF for
   each RenderableImage source;
    createRendering() is called on each of the RenderableImage sources
   using the backwards-mapped RenderContexts obtained in step 1,
   resulting in a rendering of each source;
    ContextualRenderedImageFactory.create() is called
   with a new ParameterBlock containing the parameters of
   the RenderableImageOp and the RenderedImages that were created by the
   createRendering() calls.


    If the elements of the source Vector of
   the ParameterBlock used to construct the RenderableImageOp are
   instances of RenderedImage, then the CRIF.create() method is
   called immediately using the original ParameterBlock.
   This provides a basis case for the recursion.

    The created RenderedImage may have a property identified
   by the String HINTS_OBSERVED to indicate which RenderingHints
   (from the RenderContext) were used to create the image.
   In addition any RenderedImages
   that are obtained via the getSources() method on the created
   RenderedImage may have such a property.

  render-context - The RenderContext to use to perform the rendering. - `java.awt.image.renderable.RenderContext`

  returns: a RenderedImage containing the desired output image. - `java.awt.image.RenderedImage`"
  ([this render-context]
    (-> this (.createRendering render-context))))

(defn get-min-x
  "Gets the minimum X coordinate of the rendering-independent image data.

  returns: the minimum X coordinate of the rendering-independent image
   data. - `float`"
  ([this]
    (-> this (.getMinX))))

(defn create-scaled-rendering
  "Creates a RenderedImage instance of this image with width w, and
   height h in pixels.  The RenderContext is built automatically
   with an appropriate usr2dev transform and an area of interest
   of the full image.  All the rendering hints come from hints
   passed in.

    If w == 0, it will be taken to equal
   Math.round(h*(getWidth()/getHeight())).
   Similarly, if h == 0, it will be taken to equal
   Math.round(w*(getHeight()/getWidth())).  One of
   w or h must be non-zero or else an IllegalArgumentException
   will be thrown.

    The created RenderedImage may have a property identified
   by the String HINTS_OBSERVED to indicate which RenderingHints
   were used to create the image.  In addition any RenderedImages
   that are obtained via the getSources() method on the created
   RenderedImage may have such a property.

  w - the width of rendered image in pixels, or 0. - `int`
  h - the height of rendered image in pixels, or 0. - `int`
  hints - a RenderingHints object containing hints. - `java.awt.RenderingHints`

  returns: a RenderedImage containing the rendered data. - `java.awt.image.RenderedImage`"
  ([this w h hints]
    (-> this (.createScaledRendering w h hints))))

(defn get-sources
  "Returns a vector of RenderableImages that are the sources of
   image data for this RenderableImage. Note that this method may
   return an empty vector, to indicate that the image has no sources,
   or null, to indicate that no information is available.

  returns: a (possibly empty) Vector of RenderableImages, or null. - `java.util.Vector<java.awt.image.renderable.RenderableImage>`"
  ([this]
    (-> this (.getSources))))

