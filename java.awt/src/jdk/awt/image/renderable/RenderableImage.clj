(ns jdk.awt.image.renderable.RenderableImage
  "A RenderableImage is a common interface for rendering-independent
  images (a notion which subsumes resolution independence).  That is,
  images which are described and have operations applied to them
  independent of any specific rendering of the image.  For example, a
  RenderableImage can be rotated and cropped in
  resolution-independent terms.  Then, it can be rendered for various
  specific contexts, such as a draft preview, a high-quality screen
  display, or a printer, each in an optimal fashion.

   A RenderedImage is returned from a RenderableImage via the
  createRendering() method, which takes a RenderContext.  The
  RenderContext specifies how the RenderedImage should be
  constructed.  Note that it is not possible to extract pixels
  directly from a RenderableImage.

   The createDefaultRendering() and createScaledRendering() methods are
  convenience methods that construct an appropriate RenderContext
  internally.  All of the rendering methods may return a reference to a
  previously produced rendering."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image.renderable RenderableImage]))

(defn get-width
  "Gets the width in user coordinate space.  By convention, the
   usual width of a RenderableImage is equal to the image's aspect
   ratio (width divided by height).

  returns: the width of the image in user coordinates. - `float`"
  (^Float [^java.awt.image.renderable.RenderableImage this]
    (-> this (.getWidth))))

(defn create-default-rendering
  "Returnd a RenderedImage instance of this image with a default
   width and height in pixels.  The RenderContext is built
   automatically with an appropriate usr2dev transform and an area
   of interest of the full image.  The rendering hints are
   empty.  createDefaultRendering may make use of a stored
   rendering for speed.

  returns: a RenderedImage containing the rendered data. - `java.awt.image.RenderedImage`"
  (^java.awt.image.RenderedImage [^java.awt.image.renderable.RenderableImage this]
    (-> this (.createDefaultRendering))))

(defn dynamic?
  "Returns true if successive renderings (that is, calls to
   createRendering() or createScaledRendering()) with the same arguments
   may produce different results.  This method may be used to
   determine whether an existing rendering may be cached and
   reused.  It is always safe to return true.

  returns: true if successive renderings with the
           same arguments might produce different results;
           false otherwise. - `boolean`"
  (^Boolean [^java.awt.image.renderable.RenderableImage this]
    (-> this (.isDynamic))))

(defn get-min-y
  "Gets the minimum Y coordinate of the rendering-independent image data.

  returns: the minimum Y coordinate of the rendering-independent image
   data. - `float`"
  (^Float [^java.awt.image.renderable.RenderableImage this]
    (-> this (.getMinY))))

(defn get-property-names
  "Returns a list of names recognized by getProperty.

  returns: a list of property names. - `java.lang.String[]`"
  ([^java.awt.image.renderable.RenderableImage this]
    (-> this (.getPropertyNames))))

(defn get-height
  "Gets the height in user coordinate space.  By convention, the
   usual height of a RenderedImage is equal to 1.0F.

  returns: the height of the image in user coordinates. - `float`"
  (^Float [^java.awt.image.renderable.RenderableImage this]
    (-> this (.getHeight))))

(defn get-property
  "Gets a property from the property set of this image.
   If the property name is not recognized, java.awt.Image.UndefinedProperty
   will be returned.

  name - the name of the property to get, as a String. - `java.lang.String`

  returns: a reference to the property Object, or the value
           java.awt.Image.UndefinedProperty. - `java.lang.Object`"
  (^java.lang.Object [^java.awt.image.renderable.RenderableImage this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn create-rendering
  "Creates a RenderedImage that represented a rendering of this image
   using a given RenderContext.  This is the most general way to obtain a
   rendering of a RenderableImage.

    The created RenderedImage may have a property identified
   by the String HINTS_OBSERVED to indicate which RenderingHints
   (from the RenderContext) were used to create the image.
   In addition any RenderedImages
   that are obtained via the getSources() method on the created
   RenderedImage may have such a property.

  render-context - the RenderContext to use to produce the rendering. - `java.awt.image.renderable.RenderContext`

  returns: a RenderedImage containing the rendered data. - `java.awt.image.RenderedImage`"
  (^java.awt.image.RenderedImage [^java.awt.image.renderable.RenderableImage this ^java.awt.image.renderable.RenderContext render-context]
    (-> this (.createRendering render-context))))

(defn get-min-x
  "Gets the minimum X coordinate of the rendering-independent image data.

  returns: the minimum X coordinate of the rendering-independent image
   data. - `float`"
  (^Float [^java.awt.image.renderable.RenderableImage this]
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
  (^java.awt.image.RenderedImage [^java.awt.image.renderable.RenderableImage this ^Integer w ^Integer h ^java.awt.RenderingHints hints]
    (-> this (.createScaledRendering w h hints))))

(defn get-sources
  "Returns a vector of RenderableImages that are the sources of
   image data for this RenderableImage. Note that this method may
   return an empty vector, to indicate that the image has no sources,
   or null, to indicate that no information is available.

  returns: a (possibly empty) Vector of RenderableImages, or null. - `java.util.Vector<java.awt.image.renderable.RenderableImage>`"
  (^java.util.Vector [^java.awt.image.renderable.RenderableImage this]
    (-> this (.getSources))))

