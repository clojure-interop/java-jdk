(ns jdk.awt.MultipleGradientPaint
  "This is the superclass for Paints which use a multiple color
  gradient to fill in their raster.  It provides storage for variables and
  enumerated values common to
  LinearGradientPaint and RadialGradientPaint."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt MultipleGradientPaint]))

(defn get-fractions
  "Returns a copy of the array of floats used by this gradient
   to calculate color distribution.
   The returned array always has 0 as its first value and 1 as its
   last value, with increasing values in between.

  returns: a copy of the array of floats used by this gradient to
   calculate color distribution - `float[]`"
  ([^java.awt.MultipleGradientPaint this]
    (-> this (.getFractions))))

(defn get-colors
  "Returns a copy of the array of colors used by this gradient.
   The first color maps to the first value in the fractions array,
   and the last color maps to the last value in the fractions array.

  returns: a copy of the array of colors used by this gradient - `java.awt.Color[]`"
  ([^java.awt.MultipleGradientPaint this]
    (-> this (.getColors))))

(defn get-cycle-method
  "Returns the enumerated type which specifies cycling behavior.

  returns: the enumerated type which specifies cycling behavior - `java.awt.MultipleGradientPaint.CycleMethod`"
  ([^java.awt.MultipleGradientPaint this]
    (-> this (.getCycleMethod))))

(defn get-color-space
  "Returns the enumerated type which specifies color space for
   interpolation.

  returns: the enumerated type which specifies color space for
   interpolation - `java.awt.MultipleGradientPaint.ColorSpaceType`"
  ([^java.awt.MultipleGradientPaint this]
    (-> this (.getColorSpace))))

(defn get-transform
  "Returns a copy of the transform applied to the gradient.


   Note that if no transform is applied to the gradient
   when it is created, the identity transform is used.

  returns: a copy of the transform applied to the gradient - `java.awt.geom.AffineTransform`"
  ([^java.awt.MultipleGradientPaint this]
    (-> this (.getTransform))))

(defn get-transparency
  "Returns the transparency mode for this Paint object.

  returns: OPAQUE if all colors used by this
           Paint object are opaque,
           TRANSLUCENT if at least one of the
           colors used by this Paint object is not opaque. - `int`"
  ([^java.awt.MultipleGradientPaint this]
    (-> this (.getTransparency))))

