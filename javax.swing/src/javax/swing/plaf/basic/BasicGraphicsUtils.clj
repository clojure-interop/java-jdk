(ns javax.swing.plaf.basic.BasicGraphicsUtils
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicGraphicsUtils]))

(defn ->basic-graphics-utils
  "Constructor."
  (^BasicGraphicsUtils []
    (new BasicGraphicsUtils )))

(defn *get-preferred-button-size
  "b - `javax.swing.AbstractButton`
  text-icon-gap - `int`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.AbstractButton b ^Integer text-icon-gap]
    (BasicGraphicsUtils/getPreferredButtonSize b text-icon-gap)))

(defn *draw-lowered-bezel
  "g - `java.awt.Graphics`
  x - `int`
  y - `int`
  w - `int`
  h - `int`
  shadow - `java.awt.Color`
  dark-shadow - `java.awt.Color`
  highlight - `java.awt.Color`
  light-highlight - `java.awt.Color`"
  ([^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^java.awt.Color shadow ^java.awt.Color dark-shadow ^java.awt.Color highlight ^java.awt.Color light-highlight]
    (BasicGraphicsUtils/drawLoweredBezel g x y w h shadow dark-shadow highlight light-highlight)))

(defn *draw-bezel
  "g - `java.awt.Graphics`
  x - `int`
  y - `int`
  w - `int`
  h - `int`
  is-pressed - `boolean`
  is-default - `boolean`
  shadow - `java.awt.Color`
  dark-shadow - `java.awt.Color`
  highlight - `java.awt.Color`
  light-highlight - `java.awt.Color`"
  ([^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Boolean is-pressed ^Boolean is-default ^java.awt.Color shadow ^java.awt.Color dark-shadow ^java.awt.Color highlight ^java.awt.Color light-highlight]
    (BasicGraphicsUtils/drawBezel g x y w h is-pressed is-default shadow dark-shadow highlight light-highlight)))

(defn *draw-etched-rect
  "g - `java.awt.Graphics`
  x - `int`
  y - `int`
  w - `int`
  h - `int`
  shadow - `java.awt.Color`
  dark-shadow - `java.awt.Color`
  highlight - `java.awt.Color`
  light-highlight - `java.awt.Color`"
  ([^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^java.awt.Color shadow ^java.awt.Color dark-shadow ^java.awt.Color highlight ^java.awt.Color light-highlight]
    (BasicGraphicsUtils/drawEtchedRect g x y w h shadow dark-shadow highlight light-highlight)))

(defn *draw-string-underline-char-at
  "Draw a string with the graphics g at location
   (x, y)
   just like g.drawString would.
   The character at index underlinedIndex
   in text will be underlined. If index is beyond the
   bounds of text (including < 0), nothing will be
   underlined.

  g - Graphics to draw with - `java.awt.Graphics`
  text - String to draw - `java.lang.String`
  underlined-index - Index of character in text to underline - `int`
  x - x coordinate to draw at - `int`
  y - y coordinate to draw at - `int`"
  ([^java.awt.Graphics g ^java.lang.String text ^Integer underlined-index ^Integer x ^Integer y]
    (BasicGraphicsUtils/drawStringUnderlineCharAt g text underlined-index x y)))

(defn *draw-dashed-rect
  "g - `java.awt.Graphics`
  x - `int`
  y - `int`
  width - `int`
  height - `int`"
  ([^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (BasicGraphicsUtils/drawDashedRect g x y width height)))

(defn *draw-string
  "Draw a string with the graphics g at location (x,y)
    just like g.drawString would.
    The first occurrence of underlineChar
    in text will be underlined. The matching algorithm is
    not case sensitive.

  g - `java.awt.Graphics`
  text - `java.lang.String`
  underlined-char - `int`
  x - `int`
  y - `int`"
  ([^java.awt.Graphics g ^java.lang.String text ^Integer underlined-char ^Integer x ^Integer y]
    (BasicGraphicsUtils/drawString g text underlined-char x y)))

(defn *get-etched-insets
  "Returns the amount of space taken up by a border drawn by
   drawEtchedRect()

  returns: the inset of an etched rect - `java.awt.Insets`"
  (^java.awt.Insets []
    (BasicGraphicsUtils/getEtchedInsets )))

(defn *draw-groove
  "g - `java.awt.Graphics`
  x - `int`
  y - `int`
  w - `int`
  h - `int`
  shadow - `java.awt.Color`
  highlight - `java.awt.Color`"
  ([^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^java.awt.Color shadow ^java.awt.Color highlight]
    (BasicGraphicsUtils/drawGroove g x y w h shadow highlight)))

(defn *get-groove-insets
  "Returns the amount of space taken up by a border drawn by
   drawGroove()

  returns: the inset of a groove border - `java.awt.Insets`"
  (^java.awt.Insets []
    (BasicGraphicsUtils/getGrooveInsets )))

