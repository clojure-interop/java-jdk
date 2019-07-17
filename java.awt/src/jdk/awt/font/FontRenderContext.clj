(ns jdk.awt.font.FontRenderContext
  "The FontRenderContext class is a container for the
    information needed to correctly measure text.  The measurement of text
    can vary because of rules that map outlines to pixels, and rendering
    hints provided by an application.

    One such piece of information is a transform that scales
    typographical points to pixels. (A point is defined to be exactly 1/72
    of an inch, which is slightly different than
    the traditional mechanical measurement of a point.)  A character that
    is rendered at 12pt on a 600dpi device might have a different size
    than the same character rendered at 12pt on a 72dpi device because of
    such factors as rounding to pixel boundaries and hints that the font
    designer may have specified.

    Anti-aliasing and Fractional-metrics specified by an application can also
    affect the size of a character because of rounding to pixel
    boundaries.

    Typically, instances of FontRenderContext are
    obtained from a Graphics2D object.  A
    FontRenderContext which is directly constructed will
    most likely not represent any actual graphics device, and may lead
    to unexpected or incorrect results."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font FontRenderContext]))

(defn ->font-render-context
  "Constructor.

  Constructs a FontRenderContext object from an
   optional AffineTransform and two boolean
   values that determine if the newly constructed object has
   anti-aliasing or fractional metrics.
   In each case the boolean values true and false
   correspond to the rendering hint values ON and
   OFF respectively.

   To specify other hint values, use the constructor which
   specifies the rendering hint values as parameters :
   FontRenderContext(AffineTransform, Object, Object).

  tx - the transform which is used to scale typographical points to pixels in this FontRenderContext. If null, an identity transform is used. - `java.awt.geom.AffineTransform`
  is-anti-aliased - determines if the newly constructed object has anti-aliasing. - `boolean`
  uses-fractional-metrics - determines if the newly constructed object has fractional metrics. - `boolean`"
  ([^java.awt.geom.AffineTransform tx ^Boolean is-anti-aliased ^Boolean uses-fractional-metrics]
    (new FontRenderContext tx is-anti-aliased uses-fractional-metrics)))

(defn transformed?
  "Indicates whether or not this FontRenderContext object
   measures text in a transformed render context.

  returns: true if this FontRenderContext
            object has a non-identity AffineTransform attribute.
            false otherwise. - `boolean`"
  (^Boolean [^java.awt.font.FontRenderContext this]
    (-> this (.isTransformed))))

(defn get-anti-aliasing-hint
  "Return the text anti-aliasing rendering mode hint used in this
   FontRenderContext.
   This will be one of the text antialiasing rendering hint values
   defined in java.awt.RenderingHints.

  returns: text anti-aliasing rendering mode hint used in this
   FontRenderContext. - `java.lang.Object`"
  (^java.lang.Object [^java.awt.font.FontRenderContext this]
    (-> this (.getAntiAliasingHint))))

(defn get-transform-type
  "Returns the integer type of the affine transform for this
   FontRenderContext as specified by
   AffineTransform.getType()

  returns: the type of the transform. - `int`"
  (^Integer [^java.awt.font.FontRenderContext this]
    (-> this (.getTransformType))))

(defn uses-fractional-metrics
  "Returns a boolean which whether text fractional metrics mode
   is used in this FontRenderContext.
   Call getFractionalMetricsHint()
   to obtain the corresponding rendering hint value.

  returns: true, if layout should be performed with
     fractional metrics; false otherwise.
                 in this FontRenderContext. - `boolean`"
  (^Boolean [^java.awt.font.FontRenderContext this]
    (-> this (.usesFractionalMetrics))))

(defn hash-code
  "Return a hashcode for this FontRenderContext.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.awt.font.FontRenderContext this]
    (-> this (.hashCode))))

(defn get-transform
  "Gets the transform that is used to scale typographical points
     to pixels in this FontRenderContext.

  returns: the AffineTransform of this
      FontRenderContext. - `java.awt.geom.AffineTransform`"
  (^java.awt.geom.AffineTransform [^java.awt.font.FontRenderContext this]
    (-> this (.getTransform))))

(defn get-fractional-metrics-hint
  "Return the text fractional metrics rendering mode hint used in this
   FontRenderContext.
   This will be one of the text fractional metrics rendering hint values
   defined in java.awt.RenderingHints.

  returns: the text fractional metrics rendering mode hint used in this
   FontRenderContext. - `java.lang.Object`"
  (^java.lang.Object [^java.awt.font.FontRenderContext this]
    (-> this (.getFractionalMetricsHint))))

(defn equals
  "Return true if obj is an instance of FontRenderContext and has the same
   transform, antialiasing, and fractional metrics values as this.

  obj - the object to test for equality - `java.lang.Object`

  returns: true if the specified object is equal to
           this FontRenderContext; false
           otherwise. - `boolean`"
  (^Boolean [^java.awt.font.FontRenderContext this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn anti-aliased?
  "Returns a boolean which indicates whether or not some form of
   antialiasing is specified by this FontRenderContext.
   Call getAntiAliasingHint()
   for the specific rendering hint value.

  returns: true, if text is anti-aliased in this
     FontRenderContext; false otherwise. - `boolean`"
  (^Boolean [^java.awt.font.FontRenderContext this]
    (-> this (.isAntiAliased))))

