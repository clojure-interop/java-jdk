(ns jdk.awt.FontMetrics
  "The FontMetrics class defines a font metrics object, which
  encapsulates information about the rendering of a particular font on a
  particular screen.

  Note to subclassers: Since many of these methods form closed,
  mutually recursive loops, you must take care that you implement
  at least one of the methods in each such loop to prevent
  infinite recursion when your subclass is used.
  In particular, the following is the minimal suggested set of methods
  to override in order to ensure correctness and prevent infinite
  recursion (though other subsets are equally feasible):

  getAscent()
  getLeading()
  getMaxAdvance()
  charWidth(char)
  charsWidth(char[], int, int)



  Note that the implementations of these methods are
  inefficient, so they are usually overridden with more efficient
  toolkit-specific implementations.

  When an application asks to place a character at the position
  (x, y), the character is placed so that its
  reference point (shown as the dot in the accompanying image) is
  put at that position. The reference point specifies a horizontal
  line called the baseline of the character. In normal
  printing, the baselines of characters should align.

  In addition, every character in a font has an ascent, a
  descent, and an advance width. The ascent is the
  amount by which the character ascends above the baseline. The
  descent is the amount by which the character descends below the
  baseline. The advance width indicates the position at which AWT
  should place the next character.

  An array of characters or a string can also have an ascent, a
  descent, and an advance width. The ascent of the array is the
  maximum ascent of any character in the array. The descent is the
  maximum descent of any character in the array. The advance width
  is the sum of the advance widths of each of the characters in the
  character array.  The advance of a String is the
  distance along the baseline of the String.  This
  distance is the width that should be used for centering or
  right-aligning the String.
  Note that the advance of a String is not necessarily
  the sum of the advances of its characters measured in isolation
  because the width of a character can vary depending on its context.
  For example, in Arabic text, the shape of a character can change
  in order to connect to other characters.  Also, in some scripts,
  certain character sequences can be represented by a single shape,
  called a ligature.  Measuring characters individually does
  not account for these transformations.
  Font metrics are baseline-relative, meaning that they are
  generally independent of the rotation applied to the font (modulo
  possible grid hinting effects).  See Font."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt FontMetrics]))

(defn get-widths
  "Gets the advance widths of the first 256 characters in the
   Font.  The advance is the
   distance from the leftmost point to the rightmost point on the
   character's baseline.  Note that the advance of a
   String is not necessarily the sum of the advances
   of its characters.

  returns: an array storing the advance widths of the
                   characters in the Font
                   described by this FontMetrics object. - `int[]`"
  ([^java.awt.FontMetrics this]
    (-> this (.getWidths))))

(defn char-width
  "Returns the advance width of the specified character in this
   Font.  The advance is the
   distance from the leftmost point to the rightmost point on the
   character's baseline.  Note that the advance of a
   String is not necessarily the sum of the advances
   of its characters.

   This method doesn't validate the specified character to be a
   valid Unicode code point. The caller must validate the
   character value using Character.isValidCodePoint if necessary.

  code-point - the character (Unicode code point) to be measured - `int`

  returns: the advance width of the specified character
              in the Font described by this
              FontMetrics object. - `int`"
  (^Integer [^java.awt.FontMetrics this ^Integer code-point]
    (-> this (.charWidth code-point))))

(defn get-ascent
  "Determines the font ascent of the Font
   described by this FontMetrics object. The font ascent
   is the distance from the font's baseline to the top of most
   alphanumeric characters. Some characters in the Font
   might extend above the font ascent line.

  returns: the font ascent of the Font. - `int`"
  (^Integer [^java.awt.FontMetrics this]
    (-> this (.getAscent))))

(defn get-line-metrics
  "Returns the LineMetrics object for the specified
   String in the specified Graphics context.

  str - the specified String - `java.lang.String`
  begin-index - the initial offset of str - `int`
  limit - the end offset of str - `int`
  context - the specified Graphics context - `java.awt.Graphics`

  returns: a LineMetrics object created with the
   specified String and Graphics context. - `java.awt.font.LineMetrics`"
  (^java.awt.font.LineMetrics [^java.awt.FontMetrics this ^java.lang.String str ^Integer begin-index ^Integer limit ^java.awt.Graphics context]
    (-> this (.getLineMetrics str begin-index limit context)))
  (^java.awt.font.LineMetrics [^java.awt.FontMetrics this ^java.lang.String str ^java.awt.Graphics context]
    (-> this (.getLineMetrics str context))))

(defn to-string
  "Returns a representation of this FontMetrics
   object's values as a String.

  returns: a String representation of this
   FontMetrics object. - `java.lang.String`"
  (^java.lang.String [^java.awt.FontMetrics this]
    (-> this (.toString))))

(defn get-string-bounds
  "Returns the bounds of the specified String in the
   specified Graphics context.  The bounds is used
   to layout the String.
   Note: The returned bounds is in baseline-relative coordinates
   (see class notes).

  str - the specified String - `java.lang.String`
  begin-index - the offset of the beginning of str - `int`
  limit - the end offset of str - `int`
  context - the specified Graphics context - `java.awt.Graphics`

  returns: a Rectangle2D that is the bounding box of the
   specified String in the specified
   Graphics context. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^java.awt.FontMetrics this ^java.lang.String str ^Integer begin-index ^Integer limit ^java.awt.Graphics context]
    (-> this (.getStringBounds str begin-index limit context)))
  (^java.awt.geom.Rectangle2D [^java.awt.FontMetrics this ^java.lang.String str ^java.awt.Graphics context]
    (-> this (.getStringBounds str context))))

(defn get-max-descent
  "Determines the maximum descent of the Font
   described by this FontMetrics object.  No character
   extends further below the font's baseline than this height.

  returns: the maximum descent of any character in the
   Font. - `int`"
  (^Integer [^java.awt.FontMetrics this]
    (-> this (.getMaxDescent))))

(defn get-descent
  "Determines the font descent of the Font
   described by this
   FontMetrics object. The font descent is the distance
   from the font's baseline to the bottom of most alphanumeric
   characters with descenders. Some characters in the
   Font might extend
   below the font descent line.

  returns: the font descent of the Font. - `int`"
  (^Integer [^java.awt.FontMetrics this]
    (-> this (.getDescent))))

(defn bytes-width
  "Returns the total advance width for showing the specified array
   of bytes in this Font.  The advance is the
   distance from the leftmost point to the rightmost point on the
   string's baseline.  The advance of a String
   is not necessarily the sum of the advances of its characters.
   This is equivalent to measuring a String of the
   characters in the specified range.

  data - the array of bytes to be measured - `byte[]`
  off - the start offset of the bytes in the array - `int`
  len - the number of bytes to be measured from the array - `int`

  returns: the advance width of the subarray of the specified
                 byte array in the Font
                    described by
                 this FontMetrics object. - `int`

  throws: java.lang.NullPointerException - if data is null."
  (^Integer [^java.awt.FontMetrics this data ^Integer off ^Integer len]
    (-> this (.bytesWidth data off len))))

(defn get-max-char-bounds
  "Returns the bounds for the character with the maximum bounds
   in the specified Graphics context.

  context - the specified Graphics context - `java.awt.Graphics`

  returns: a Rectangle2D that is the
   bounding box for the character with the maximum bounds. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^java.awt.FontMetrics this ^java.awt.Graphics context]
    (-> this (.getMaxCharBounds context))))

(defn get-height
  "Gets the standard height of a line of text in this font.  This
   is the distance between the baseline of adjacent lines of text.
   It is the sum of the leading  ascent  descent. Due to rounding
   this may not be the same as getAscent()  getDescent()  getLeading().
   There is no guarantee that lines of text spaced at this distance are
   disjoint; such lines may overlap if some characters overshoot
   either the standard ascent or the standard descent metric.

  returns: the standard height of the font. - `int`"
  (^Integer [^java.awt.FontMetrics this]
    (-> this (.getHeight))))

(defn get-leading
  "Determines the standard leading of the
   Font described by this FontMetrics
   object.  The standard leading, or
   interline spacing, is the logical amount of space to be reserved
   between the descent of one line of text and the ascent of the next
   line. The height metric is calculated to include this extra space.

  returns: the standard leading of the Font. - `int`"
  (^Integer [^java.awt.FontMetrics this]
    (-> this (.getLeading))))

(defn get-max-advance
  "Gets the maximum advance width of any character in this
   Font.  The advance is the
   distance from the leftmost point to the rightmost point on the
   string's baseline.  The advance of a String is
   not necessarily the sum of the advances of its characters.

  returns: the maximum advance width of any character
              in the Font, or -1 if the
              maximum advance width is not known. - `int`"
  (^Integer [^java.awt.FontMetrics this]
    (-> this (.getMaxAdvance))))

(defn get-font-render-context
  "Gets the FontRenderContext used by this
   FontMetrics object to measure text.

   Note that methods in this class which take a Graphics
   parameter measure text using the FontRenderContext
   of that Graphics object, and not this
   FontRenderContext

  returns: the FontRenderContext used by this
   FontMetrics object. - `java.awt.font.FontRenderContext`"
  (^java.awt.font.FontRenderContext [^java.awt.FontMetrics this]
    (-> this (.getFontRenderContext))))

(defn get-font
  "Gets the Font described by this
   FontMetrics object.

  returns: the Font described by this
   FontMetrics object. - `java.awt.Font`"
  (^java.awt.Font [^java.awt.FontMetrics this]
    (-> this (.getFont))))

(defn chars-width
  "Returns the total advance width for showing the specified array
   of characters in this Font.  The advance is the
   distance from the leftmost point to the rightmost point on the
   string's baseline.  The advance of a String
   is not necessarily the sum of the advances of its characters.
   This is equivalent to measuring a String of the
   characters in the specified range.

  data - the array of characters to be measured - `char[]`
  off - the start offset of the characters in the array - `int`
  len - the number of characters to be measured from the array - `int`

  returns: the advance width of the subarray of the specified
                 char array in the font described by
                 this FontMetrics object. - `int`

  throws: java.lang.NullPointerException - if data is null."
  (^Integer [^java.awt.FontMetrics this data ^Integer off ^Integer len]
    (-> this (.charsWidth data off len))))

(defn get-max-ascent
  "Determines the maximum ascent of the Font
   described by this FontMetrics object.  No character
   extends further above the font's baseline than this height.

  returns: the maximum ascent of any character in the
   Font. - `int`"
  (^Integer [^java.awt.FontMetrics this]
    (-> this (.getMaxAscent))))

(defn string-width
  "Returns the total advance width for showing the specified
   String in this Font.  The advance
   is the distance from the leftmost point to the rightmost point
   on the string's baseline.

   Note that the advance of a String is
   not necessarily the sum of the advances of its characters.

  str - the String to be measured - `java.lang.String`

  returns: the advance width of the specified String
                    in the Font described by this
                    FontMetrics. - `int`

  throws: java.lang.NullPointerException - if str is null."
  (^Integer [^java.awt.FontMetrics this ^java.lang.String str]
    (-> this (.stringWidth str))))

(defn get-max-decent
  "Deprecated. As of JDK version 1.1.1,
   replaced by getMaxDescent().

  returns: the maximum descent of any character in the
   Font. - `java.lang.  int`"
  ([^java.awt.FontMetrics this]
    (-> this (.getMaxDecent))))

(defn has-uniform-line-metrics?
  "Checks to see if the Font has uniform line metrics.  A
   composite font may consist of several different fonts to cover
   various character sets.  In such cases, the
   FontLineMetrics objects are not uniform.
   Different fonts may have a different ascent, descent, metrics and
   so on.  This information is sometimes necessary for line
   measuring and line breaking.

  returns: true if the font has uniform line metrics;
   false otherwise. - `boolean`"
  (^Boolean [^java.awt.FontMetrics this]
    (-> this (.hasUniformLineMetrics))))

