(ns jdk.awt.image.renderable.RenderContext
  "A RenderContext encapsulates the information needed to produce a
  specific rendering from a RenderableImage.  It contains the area to
  be rendered specified in rendering-independent terms, the
  resolution at which the rendering is to be performed, and hints
  used to control the rendering process.

   Users create RenderContexts and pass them to the
  RenderableImage via the createRendering method.  Most of the methods of
  RenderContexts are not meant to be used directly by applications,
  but by the RenderableImage and operator classes to which it is
  passed.

   The AffineTransform parameter passed into and out of this class
  are cloned.  The RenderingHints and Shape parameters are not
  necessarily cloneable and are therefore only reference copied.
  Altering RenderingHints or Shape instances that are in use by
  instances of RenderContext may have undesired side effects."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image.renderable RenderContext]))

(defn ->render-context
  "Constructor.

  Constructs a RenderContext with a given transform.
   The area of interest is supplied as a Shape,
   and the rendering hints are supplied as a RenderingHints object.

  usr-2dev - an AffineTransform. - `java.awt.geom.AffineTransform`
  aoi - a Shape representing the area of interest. - `java.awt.Shape`
  hints - a RenderingHints object containing rendering hints. - `java.awt.RenderingHints`"
  (^RenderContext [^java.awt.geom.AffineTransform usr-2dev ^java.awt.Shape aoi ^java.awt.RenderingHints hints]
    (new RenderContext usr-2dev aoi hints))
  (^RenderContext [^java.awt.geom.AffineTransform usr-2dev ^java.awt.RenderingHints hints]
    (new RenderContext usr-2dev hints))
  (^RenderContext [^java.awt.geom.AffineTransform usr-2dev]
    (new RenderContext usr-2dev)))

(defn concetenate-transform
  "Deprecated. replaced by
                   concatenateTransform(AffineTransform).

  mod-transform - the AffineTransform to append to the current usr2dev transform. - `java.awt.geom.AffineTransform`"
  ([^RenderContext this ^java.awt.geom.AffineTransform mod-transform]
    (-> this (.concetenateTransform mod-transform))))

(defn get-rendering-hints
  "Gets the rendering hints of this RenderContext.

  returns: a RenderingHints object that represents
   the rendering hints of this RenderContext. - `java.awt.RenderingHints`"
  (^java.awt.RenderingHints [^RenderContext this]
    (-> this (.getRenderingHints))))

(defn pre-concetenate-transform
  "Deprecated. replaced by
                   preConcatenateTransform(AffineTransform).

  mod-transform - the AffineTransform to prepend to the current usr2dev transform. - `java.awt.geom.AffineTransform`"
  ([^RenderContext this ^java.awt.geom.AffineTransform mod-transform]
    (-> this (.preConcetenateTransform mod-transform))))

(defn concatenate-transform
  "Modifies the current user-to-device transform by appending another
   transform.  In matrix notation the operation is:


   [this] = [this] x [modTransform]

  mod-transform - the AffineTransform to append to the current usr2dev transform. - `java.awt.geom.AffineTransform`"
  ([^RenderContext this ^java.awt.geom.AffineTransform mod-transform]
    (-> this (.concatenateTransform mod-transform))))

(defn set-area-of-interest
  "Sets the current area of interest.  The old area is discarded.

  new-aoi - The new area of interest. - `java.awt.Shape`"
  ([^RenderContext this ^java.awt.Shape new-aoi]
    (-> this (.setAreaOfInterest new-aoi))))

(defn pre-concatenate-transform
  "Modifies the current user-to-device transform by prepending another
   transform.  In matrix notation the operation is:


   [this] = [modTransform] x [this]

  mod-transform - the AffineTransform to prepend to the current usr2dev transform. - `java.awt.geom.AffineTransform`"
  ([^RenderContext this ^java.awt.geom.AffineTransform mod-transform]
    (-> this (.preConcatenateTransform mod-transform))))

(defn get-area-of-interest
  "Gets the ares of interest currently contained in the
   RenderContext.

  returns: a reference to the area of interest of the RenderContext,
           or null if none is specified. - `java.awt.Shape`"
  (^java.awt.Shape [^RenderContext this]
    (-> this (.getAreaOfInterest))))

(defn clone
  "Makes a copy of a RenderContext. The area of interest is copied
   by reference.  The usr2dev AffineTransform and hints are cloned,
   while the area of interest is copied by reference.

  returns: the new cloned RenderContext. - `java.lang.Object`"
  (^java.lang.Object [^RenderContext this]
    (-> this (.clone))))

(defn set-transform
  "Sets the current user-to-device AffineTransform contained
   in the RenderContext to a given transform.

  new-transform - the new AffineTransform. - `java.awt.geom.AffineTransform`"
  ([^RenderContext this ^java.awt.geom.AffineTransform new-transform]
    (-> this (.setTransform new-transform))))

(defn get-transform
  "Gets the current user-to-device AffineTransform.

  returns: a reference to the current AffineTransform. - `java.awt.geom.AffineTransform`"
  (^java.awt.geom.AffineTransform [^RenderContext this]
    (-> this (.getTransform))))

(defn set-rendering-hints
  "Sets the rendering hints of this RenderContext.

  hints - a RenderingHints object that represents the rendering hints to assign to this RenderContext. - `java.awt.RenderingHints`"
  ([^RenderContext this ^java.awt.RenderingHints hints]
    (-> this (.setRenderingHints hints))))

