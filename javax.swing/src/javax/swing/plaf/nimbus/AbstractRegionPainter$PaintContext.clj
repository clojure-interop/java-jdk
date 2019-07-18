(ns javax.swing.plaf.nimbus.AbstractRegionPainter$PaintContext
  "A class encapsulating state useful when painting. Generally, instances of this
  class are created once, and reused for each paint request without modification.
  This class contains values useful when hinting the cache engine, and when decoding
  control points and bezier curve anchors."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.nimbus AbstractRegionPainter$PaintContext]))

(defn ->paint-context
  "Constructor.

  Creates a new PaintContext.

  insets - The stretching insets. May be null. If null, then assumed to be 0, 0, 0, 0. - `java.awt.Insets`
  canvas-size - The size of the canvas used when encoding the various x/y values. May be null. If null, then it is assumed that there are no encoded values, and any calls to one of the `decode` methods will return the passed in value. - `java.awt.Dimension`
  inverted - Whether to `invert` the meaning of the 9-square grid and stretching insets - `boolean`
  cache-mode - A hint as to which caching mode to use. If null, then set to no caching. - `javax.swing.plaf.nimbus.AbstractRegionPainter$PaintContext$CacheMode`
  max-h - The maximum scale in the horizontal direction to use before punting and redrawing from scratch. For example, if maxH is 2, then we will attempt to scale any cached images up to 2x the canvas width before redrawing from scratch. Reasonable maxH values may improve painting performance. If set too high, then you may get poor looking graphics at higher zoom levels. Must be >= 1. - `double`
  max-v - The maximum scale in the vertical direction to use before punting and redrawing from scratch. For example, if maxV is 2, then we will attempt to scale any cached images up to 2x the canvas height before redrawing from scratch. Reasonable maxV values may improve painting performance. If set too high, then you may get poor looking graphics at higher zoom levels. Must be >= 1. - `double`"
  (^AbstractRegionPainter$PaintContext [^java.awt.Insets insets ^java.awt.Dimension canvas-size ^Boolean inverted ^javax.swing.plaf.nimbus.AbstractRegionPainter$PaintContext$CacheMode cache-mode ^Double max-h ^Double max-v]
    (new AbstractRegionPainter$PaintContext insets canvas-size inverted cache-mode max-h max-v))
  (^AbstractRegionPainter$PaintContext [^java.awt.Insets insets ^java.awt.Dimension canvas-size ^Boolean inverted]
    (new AbstractRegionPainter$PaintContext insets canvas-size inverted)))

