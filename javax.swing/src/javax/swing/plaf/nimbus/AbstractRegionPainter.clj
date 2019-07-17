(ns javax.swing.plaf.nimbus.AbstractRegionPainter
  "Convenient base class for defining Painter instances for rendering a
  region or component in Nimbus."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.nimbus AbstractRegionPainter]))

(defn paint
  "Renders to the given Graphics2D object. Implementations
   of this method may modify state on the Graphics2D, and are not
   required to restore that state upon completion. In most cases, it is recommended
   that the caller pass in a scratch graphics object. The Graphics2D
   must never be null.

   State on the graphics object may be honored by the paint method,
   but may not be. For instance, setting the antialiasing rendering hint on the
   graphics may or may not be respected by the Painter implementation.

   The supplied object parameter acts as an optional configuration argument.
   For example, it could be of type Component. A Painter
   that expected it could then read state from that Component and
   use the state for painting. For example, an implementation may read the
   backgroundColor and use that.

   Generally, to enhance reusability, most standard Painters ignore
   this parameter. They can thus be reused in any context. The object
   may be null. Implementations must not throw a NullPointerException if the object
   parameter is null.

   Finally, the width and height arguments specify the
   width and height that the Painter should paint into. More
   specifically, the specified width and height instruct the painter that it should
   paint fully within this width and height. Any specified clip on the
   g param will further constrain the region.

   For example, suppose I have a Painter implementation that draws
   a gradient. The gradient goes from white to black. It `stretches` to fill the
   painted region. Thus, if I use this Painter to paint a 500 x 500
   region, the far left would be black, the far right would be white, and a smooth
   gradient would be painted between. I could then, without modification, reuse the
   Painter to paint a region that is 20x20 in size. This region would
   also be black on the left, white on the right, and a smooth gradient painted
   between.

  g - The Graphics2D to render to. This must not be null. - `java.awt.Graphics2D`
  c - an optional configuration parameter. This may be null. - `javax.swing.JComponent`
  w - width of the area to paint. - `int`
  h - height of the area to paint. - `int`"
  ([^javax.swing.plaf.nimbus.AbstractRegionPainter this ^java.awt.Graphics2D g ^javax.swing.JComponent c ^Integer w ^Integer h]
    (-> this (.paint g c w h))))

