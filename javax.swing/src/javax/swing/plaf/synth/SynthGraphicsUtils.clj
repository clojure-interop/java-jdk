(ns javax.swing.plaf.synth.SynthGraphicsUtils
  "Wrapper for primitive graphics calls."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthGraphicsUtils]))

(defn ->synth-graphics-utils
  "Constructor.

  Creates a SynthGraphicsUtils."
  (^SynthGraphicsUtils []
    (new SynthGraphicsUtils )))

(defn draw-line
  "Draws a line between the two end points.
   This implementation supports only one line style key,
   \"dashed\". The \"dashed\" line style is applied
   only to vertical and horizontal lines.
   Specifying null or any key different from
   \"dashed\" will draw solid lines.

  context - identifies hosting region - `javax.swing.plaf.synth.SynthContext`
  paint-key - identifies the portion of the component being asked to paint, may be null - `java.lang.Object`
  g - Graphics object to paint to - `java.awt.Graphics`
  x-1 - x origin - `int`
  y-1 - y origin - `int`
  x-2 - x destination - `int`
  y-2 - y destination - `int`
  style-key - identifies the requested style of the line (e.g. \"dashed\") - `java.lang.Object`"
  ([^SynthGraphicsUtils this ^javax.swing.plaf.synth.SynthContext context ^java.lang.Object paint-key ^java.awt.Graphics g ^Integer x-1 ^Integer y-1 ^Integer x-2 ^Integer y-2 ^java.lang.Object style-key]
    (-> this (.drawLine context paint-key g x-1 y-1 x-2 y-2 style-key)))
  ([^SynthGraphicsUtils this ^javax.swing.plaf.synth.SynthContext context ^java.lang.Object paint-key ^java.awt.Graphics g ^Integer x-1 ^Integer y-1 ^Integer x-2 ^Integer y-2]
    (-> this (.drawLine context paint-key g x-1 y-1 x-2 y-2))))

(defn layout-text
  "Lays out text and an icon returning, by reference, the location to
   place the icon and text.

  ss - SynthContext - `javax.swing.plaf.synth.SynthContext`
  fm - FontMetrics for the Font to use, this may be ignored - `java.awt.FontMetrics`
  text - Text to layout - `java.lang.String`
  icon - Icon to layout - `javax.swing.Icon`
  h-align - horizontal alignment - `int`
  v-align - vertical alignment - `int`
  h-text-position - horizontal text position - `int`
  v-text-position - vertical text position - `int`
  view-r - Rectangle to layout text and icon in. - `java.awt.Rectangle`
  icon-r - Rectangle to place icon bounds in - `java.awt.Rectangle`
  text-r - Rectangle to place text in - `java.awt.Rectangle`
  icon-text-gap - gap between icon and text - `int`

  returns: `java.lang.String`"
  (^java.lang.String [^SynthGraphicsUtils this ^javax.swing.plaf.synth.SynthContext ss ^java.awt.FontMetrics fm ^java.lang.String text ^javax.swing.Icon icon ^Integer h-align ^Integer v-align ^Integer h-text-position ^Integer v-text-position ^java.awt.Rectangle view-r ^java.awt.Rectangle icon-r ^java.awt.Rectangle text-r ^Integer icon-text-gap]
    (-> this (.layoutText ss fm text icon h-align v-align h-text-position v-text-position view-r icon-r text-r icon-text-gap))))

(defn compute-string-width
  "Returns the size of the passed in string.

  ss - SynthContext - `javax.swing.plaf.synth.SynthContext`
  font - Font to use - `java.awt.Font`
  metrics - FontMetrics, may be ignored - `java.awt.FontMetrics`
  text - Text to get size of. - `java.lang.String`

  returns: `int`"
  (^Integer [^SynthGraphicsUtils this ^javax.swing.plaf.synth.SynthContext ss ^java.awt.Font font ^java.awt.FontMetrics metrics ^java.lang.String text]
    (-> this (.computeStringWidth ss font metrics text))))

(defn get-minimum-size
  "Returns the minimum size needed to properly render an icon and text.

  ss - SynthContext - `javax.swing.plaf.synth.SynthContext`
  font - Font to use - `java.awt.Font`
  text - Text to layout - `java.lang.String`
  icon - Icon to layout - `javax.swing.Icon`
  h-align - horizontal alignment - `int`
  v-align - vertical alignment - `int`
  h-text-position - horizontal text position - `int`
  v-text-position - vertical text position - `int`
  icon-text-gap - gap between icon and text - `int`
  mnemonic-index - Index into text to render the mnemonic at, -1 indicates no mnemonic. - `int`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^SynthGraphicsUtils this ^javax.swing.plaf.synth.SynthContext ss ^java.awt.Font font ^java.lang.String text ^javax.swing.Icon icon ^Integer h-align ^Integer v-align ^Integer h-text-position ^Integer v-text-position ^Integer icon-text-gap ^Integer mnemonic-index]
    (-> this (.getMinimumSize ss font text icon h-align v-align h-text-position v-text-position icon-text-gap mnemonic-index))))

(defn get-maximum-size
  "Returns the maximum size needed to properly render an icon and text.

  ss - SynthContext - `javax.swing.plaf.synth.SynthContext`
  font - Font to use - `java.awt.Font`
  text - Text to layout - `java.lang.String`
  icon - Icon to layout - `javax.swing.Icon`
  h-align - horizontal alignment - `int`
  v-align - vertical alignment - `int`
  h-text-position - horizontal text position - `int`
  v-text-position - vertical text position - `int`
  icon-text-gap - gap between icon and text - `int`
  mnemonic-index - Index into text to render the mnemonic at, -1 indicates no mnemonic. - `int`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^SynthGraphicsUtils this ^javax.swing.plaf.synth.SynthContext ss ^java.awt.Font font ^java.lang.String text ^javax.swing.Icon icon ^Integer h-align ^Integer v-align ^Integer h-text-position ^Integer v-text-position ^Integer icon-text-gap ^Integer mnemonic-index]
    (-> this (.getMaximumSize ss font text icon h-align v-align h-text-position v-text-position icon-text-gap mnemonic-index))))

(defn get-maximum-char-height
  "Returns the maximum height of the the Font from the passed in
   SynthContext.

  context - SynthContext used to determine font. - `javax.swing.plaf.synth.SynthContext`

  returns: maximum height of the characters for the font from the passed
           in context. - `int`"
  (^Integer [^SynthGraphicsUtils this ^javax.swing.plaf.synth.SynthContext context]
    (-> this (.getMaximumCharHeight context))))

(defn get-preferred-size
  "Returns the preferred size needed to properly render an icon and text.

  ss - SynthContext - `javax.swing.plaf.synth.SynthContext`
  font - Font to use - `java.awt.Font`
  text - Text to layout - `java.lang.String`
  icon - Icon to layout - `javax.swing.Icon`
  h-align - horizontal alignment - `int`
  v-align - vertical alignment - `int`
  h-text-position - horizontal text position - `int`
  v-text-position - vertical text position - `int`
  icon-text-gap - gap between icon and text - `int`
  mnemonic-index - Index into text to render the mnemonic at, -1 indicates no mnemonic. - `int`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^SynthGraphicsUtils this ^javax.swing.plaf.synth.SynthContext ss ^java.awt.Font font ^java.lang.String text ^javax.swing.Icon icon ^Integer h-align ^Integer v-align ^Integer h-text-position ^Integer v-text-position ^Integer icon-text-gap ^Integer mnemonic-index]
    (-> this (.getPreferredSize ss font text icon h-align v-align h-text-position v-text-position icon-text-gap mnemonic-index))))

(defn paint-text
  "Paints an icon and text. This will render the text as html, if
   necessary, and offset the location by the insets of the component.

  ss - SynthContext - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to render string and icon into - `java.awt.Graphics`
  text - Text to layout - `java.lang.String`
  icon - Icon to layout - `javax.swing.Icon`
  h-align - horizontal alignment - `int`
  v-align - vertical alignment - `int`
  h-text-position - horizontal text position - `int`
  v-text-position - vertical text position - `int`
  icon-text-gap - gap between icon and text - `int`
  mnemonic-index - Index into text to render the mnemonic at, -1 indicates no mnemonic. - `int`
  text-offset - Amount to offset the text when painting - `int`"
  ([^SynthGraphicsUtils this ^javax.swing.plaf.synth.SynthContext ss ^java.awt.Graphics g ^java.lang.String text ^javax.swing.Icon icon ^Integer h-align ^Integer v-align ^Integer h-text-position ^Integer v-text-position ^Integer icon-text-gap ^Integer mnemonic-index ^Integer text-offset]
    (-> this (.paintText ss g text icon h-align v-align h-text-position v-text-position icon-text-gap mnemonic-index text-offset)))
  ([^SynthGraphicsUtils this ^javax.swing.plaf.synth.SynthContext ss ^java.awt.Graphics g ^java.lang.String text ^Integer x ^Integer y ^Integer mnemonic-index]
    (-> this (.paintText ss g text x y mnemonic-index)))
  ([^SynthGraphicsUtils this ^javax.swing.plaf.synth.SynthContext ss ^java.awt.Graphics g ^java.lang.String text ^java.awt.Rectangle bounds ^Integer mnemonic-index]
    (-> this (.paintText ss g text bounds mnemonic-index))))

