(ns jdk.awt.font.GlyphMetrics
  "The GlyphMetrics class represents information for a
  single glyph.   A glyph is the visual representation of one or more
  characters.  Many different glyphs can be used to represent a single
  character or combination of characters.  GlyphMetrics
  instances are produced by Font and are applicable
  to a specific glyph in a particular Font.

  Glyphs are either STANDARD, LIGATURE, COMBINING, or COMPONENT.

  STANDARD glyphs are commonly used to represent single characters.
  LIGATURE glyphs are used to represent sequences of characters.
  COMPONENT glyphs in a GlyphVector do not correspond to a
  particular character in a text model. Instead, COMPONENT glyphs are
  added for typographical reasons, such as Arabic justification.
  COMBINING glyphs embellish STANDARD or LIGATURE glyphs, such
  as accent marks.  Carets do not appear before COMBINING glyphs.


  Other metrics available through GlyphMetrics are the
  components of the advance, the visual bounds, and the left and right
  side bearings.

  Glyphs for a rotated font, or obtained from a GlyphVector
  which has applied a rotation to the glyph, can have advances that
  contain both X and Y components.  Usually the advance only has one
  component.

  The advance of a glyph is the distance from the glyph's origin to the
  origin of the next glyph along the baseline, which is either vertical
  or horizontal.  Note that, in a GlyphVector,
  the distance from a glyph to its following glyph might not be the
  glyph's advance, because of kerning or other positioning adjustments.

  The bounds is the smallest rectangle that completely contains the
  outline of the glyph.  The bounds rectangle is relative to the
  glyph's origin.  The left-side bearing is the distance from the glyph
  origin to the left of its bounds rectangle. If the left-side bearing is
  negative, part of the glyph is drawn to the left of its origin.  The
  right-side bearing is the distance from the right side of the bounds
  rectangle to the next glyph origin (the origin plus the advance).  If
  negative, part of the glyph is drawn to the right of the next glyph's
  origin.  Note that the bounds does not necessarily enclose all the pixels
  affected when rendering the glyph, because of rasterization and pixel
  adjustment effects.

  Although instances of GlyphMetrics can be directly
  constructed, they are almost always obtained from a
  GlyphVector.  Once constructed, GlyphMetrics
  objects are immutable.

  Example:
  Querying a Font for glyph information


  Font font = ...;
  int glyphIndex = ...;
  GlyphMetrics metrics = GlyphVector.getGlyphMetrics(glyphIndex);
  int isStandard = metrics.isStandard();
  float glyphAdvance = metrics.getAdvance();"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font GlyphMetrics]))

(defn ->glyph-metrics
  "Constructor.

  Constructs a GlyphMetrics object.

  horizontal - if true, metrics are for a horizontal baseline, otherwise they are for a vertical baseline - `boolean`
  advance-x - the X-component of the glyph's advance - `float`
  advance-y - the Y-component of the glyph's advance - `float`
  bounds - the visual bounds of the glyph - `java.awt.geom.Rectangle2D`
  glyph-type - the type of the glyph - `byte`"
  ([^Boolean horizontal ^Float advance-x ^Float advance-y ^java.awt.geom.Rectangle2D bounds ^Byte glyph-type]
    (new GlyphMetrics horizontal advance-x advance-y bounds glyph-type))
  ([^Float advance ^java.awt.geom.Rectangle2D bounds ^Byte glyph-type]
    (new GlyphMetrics advance bounds glyph-type)))

(def *-standard
  "Static Constant.

  Indicates a glyph that represents a single standard
   character.

  type: byte"
  GlyphMetrics/STANDARD)

(def *-ligature
  "Static Constant.

  Indicates a glyph that represents multiple characters
   as a ligature, for example 'fi' or 'ffi'.  It is followed by
   filler glyphs for the remaining characters. Filler and combining
   glyphs can be intermixed to control positioning of accent marks
   on the logically preceding ligature.

  type: byte"
  GlyphMetrics/LIGATURE)

(def *-combining
  "Static Constant.

  Indicates a glyph that represents a combining character,
   such as an umlaut.  There is no caret position between this glyph
   and the preceding glyph.

  type: byte"
  GlyphMetrics/COMBINING)

(def *-component
  "Static Constant.

  Indicates a glyph with no corresponding character in the
   backing store.  The glyph is associated with the character
   represented by the logically preceding non-component glyph.  This
   is used for kashida justification or other visual modifications to
   existing glyphs.  There is no caret position between this glyph
   and the preceding glyph.

  type: byte"
  GlyphMetrics/COMPONENT)

(def *-whitespace
  "Static Constant.

  Indicates a glyph with no visual representation. It can
   be added to the other code values to indicate an invisible glyph.

  type: byte"
  GlyphMetrics/WHITESPACE)

(defn get-advance-y
  "Returns the y-component of the advance of the glyph.

  returns: the y-component of the advance of the glyph - `float`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.getAdvanceY))))

(defn get-type
  "Returns the raw glyph type code.

  returns: the raw glyph type code. - `int`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.getType))))

(defn get-advance
  "Returns the advance of the glyph along the baseline (either
   horizontal or vertical).

  returns: the advance of the glyph - `float`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.getAdvance))))

(defn component?
  "Returns true if this is a component glyph.

  returns: true if this is a component glyph;
            false otherwise. - `boolean`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.isComponent))))

(defn get-lsb
  "Returns the left (top) side bearing of the glyph.

   This is the distance from 0, 0 to the left (top) of the glyph
   bounds.  If the bounds of the glyph is to the left of (above) the
   origin, the LSB is negative.

  returns: the left side bearing of the glyph. - `float`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.getLSB))))

(defn combining?
  "Returns true if this is a combining glyph.

  returns: true if this is a combining glyph;
            false otherwise. - `boolean`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.isCombining))))

(defn standard?
  "Returns true if this is a standard glyph.

  returns: true if this is a standard glyph;
            false otherwise. - `boolean`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.isStandard))))

(defn get-bounds-2-d
  "Returns the bounds of the glyph. This is the bounding box of the glyph outline.
   Because of rasterization and pixel alignment effects, it does not necessarily
   enclose the pixels that are affected when rendering the glyph.

  returns: a Rectangle2D that is the bounds of the glyph. - `java.awt.geom.Rectangle2D`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.getBounds2D))))

(defn ligature?
  "Returns true if this is a ligature glyph.

  returns: true if this is a ligature glyph;
            false otherwise. - `boolean`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.isLigature))))

(defn get-rsb
  "Returns the right (bottom) side bearing of the glyph.

   This is the distance from the right (bottom) of the glyph bounds to
   the advance. If the bounds of the glyph is to the right of (below)
   the advance, the RSB is negative.

  returns: the right side bearing of the glyph. - `float`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.getRSB))))

(defn get-advance-x
  "Returns the x-component of the advance of the glyph.

  returns: the x-component of the advance of the glyph - `float`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.getAdvanceX))))

(defn whitespace?
  "Returns true if this is a whitespace glyph.

  returns: true if this is a whitespace glyph;
            false otherwise. - `boolean`"
  ([^java.awt.font.GlyphMetrics this]
    (-> this (.isWhitespace))))

