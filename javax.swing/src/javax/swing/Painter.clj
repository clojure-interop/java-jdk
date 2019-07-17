(ns javax.swing.Painter
  "A painting delegate. The Painter interface defines exactly one method,
  paint. It is used in situations where the developer can change
  the painting routine of a component without having to resort to subclassing
  the component. It is also generically useful when doing any form of painting
  delegation.

  Painters are simply encapsulations of Java2D code and make
  it fairly trivial to reuse existing Painters or to combine
  them together. Implementations of this interface are also trivial to write,
  such that if you can't find a Painter that does what you need,
  you can write one with minimal effort. Writing a Painter requires
  knowledge of Java2D.

  A Painter may be created with a type parameter. This type will be
  expected in the paint method. For example, you may wish to write a
  Painter that only works with subclasses of Component.
  In that case, when the Painter is declared, you may declare that
  it requires a Component, allowing the paint method to be type safe. Ex:


  Painter<Component> p = new Painter<Component>() {
      public void paint(Graphics2D g, Component c, int width, int height) {
          g.setColor(c.getBackground());
          //and so forth
      }
  }

  This interface makes no guarantees of threadsafety."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing Painter]))

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
  object - an optional configuration parameter. This may be null. - `Painter.T`
  width - width of the area to paint. - `int`
  height - height of the area to paint. - `int`"
  ([this g object width height]
    (-> this (.paint g object width height))))

