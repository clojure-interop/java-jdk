(ns jdk.awt.Font
  "The Font class represents fonts, which are used to
  render text in a visible way.
  A font provides the information needed to map sequences of
  characters to sequences of glyphs
  and to render sequences of glyphs on Graphics and
  Component objects.

  Characters and Glyphs

  A character is a symbol that represents an item such as a letter,
  a digit, or punctuation in an abstract way. For example, 'g',
  LATIN SMALL LETTER G, is a character.

  A glyph is a shape used to render a character or a sequence of
  characters. In simple writing systems, such as Latin, typically one glyph
  represents one character. In general, however, characters and glyphs do not
  have one-to-one correspondence. For example, the character 'á'
  LATIN SMALL LETTER A WITH ACUTE, can be represented by
  two glyphs: one for 'a' and one for '´'. On the other hand, the
  two-character string `fi` can be represented by a single glyph, an
  `fi` ligature. In complex writing systems, such as Arabic or the South
  and South-East Asian writing systems, the relationship between characters
  and glyphs can be more complicated and involve context-dependent selection
  of glyphs as well as glyph reordering.

  A font encapsulates the collection of glyphs needed to render a selected set
  of characters as well as the tables needed to map sequences of characters to
  corresponding sequences of glyphs.

  Physical and Logical Fonts

  The Java Platform distinguishes between two kinds of fonts:
  physical fonts and logical fonts.

  Physical fonts are the actual font libraries containing glyph data
  and tables to map from character sequences to glyph sequences, using a font
  technology such as TrueType or PostScript Type 1.
  All implementations of the Java Platform must support TrueType fonts;
  support for other font technologies is implementation dependent.
  Physical fonts may use names such as Helvetica, Palatino, HonMincho, or
  any number of other font names.
  Typically, each physical font supports only a limited set of writing
  systems, for example, only Latin characters or only Japanese and Basic
  Latin.
  The set of available physical fonts varies between configurations.
  Applications that require specific fonts can bundle them and instantiate
  them using the createFont method.

  Logical fonts are the five font families defined by the Java
  platform which must be supported by any Java runtime environment:
  Serif, SansSerif, Monospaced, Dialog, and DialogInput.
  These logical fonts are not actual font libraries. Instead, the logical
  font names are mapped to physical fonts by the Java runtime environment.
  The mapping is implementation and usually locale dependent, so the look
  and the metrics provided by them vary.
  Typically, each logical font name maps to several physical fonts in order to
  cover a large range of characters.

  Peered AWT components, such as Label and
  TextField, can only use logical fonts.

  For a discussion of the relative advantages and disadvantages of using
  physical or logical fonts, see the
  Internationalization FAQ
  document.

  Font Faces and Names

  A Font
  can have many faces, such as heavy, medium, oblique, gothic and
  regular. All of these faces have similar typographic design.

  There are three different names that you can get from a
  Font object.  The logical font name is simply the
  name that was used to construct the font.
  The font face name, or just font name for
  short, is the name of a particular font face, like Helvetica Bold. The
  family name is the name of the font family that determines the
  typographic design across several faces, like Helvetica.

  The Font class represents an instance of a font face from
  a collection of  font faces that are present in the system resources
  of the host system.  As examples, Arial Bold and Courier Bold Italic
  are font faces.  There can be several Font objects
  associated with a font face, each differing in size, style, transform
  and font features.

  The getAllFonts method
  of the GraphicsEnvironment class returns an
  array of all font faces available in the system. These font faces are
  returned as Font objects with a size of 1, identity
  transform and default font features. These
  base fonts can then be used to derive new Font objects
  with varying sizes, styles, transforms and font features via the
  deriveFont methods in this class.

  Font and TextAttribute

  Font supports most
  TextAttributes.  This makes some operations, such as
  rendering underlined text, convenient since it is not
  necessary to explicitly construct a TextLayout object.
  Attributes can be set on a Font by constructing or deriving it
  using a Map of TextAttribute values.

  The values of some TextAttributes are not
  serializable, and therefore attempting to serialize an instance of
  Font that has such values will not serialize them.
  This means a Font deserialized from such a stream will not compare
  equal to the original Font that contained the non-serializable
  attributes.  This should very rarely pose a problem
  since these attributes are typically used only in special
  circumstances and are unlikely to be serialized.


  FOREGROUND and BACKGROUND use
  Paint values. The subclass Color is
  serializable, while GradientPaint and
  TexturePaint are not.
  CHAR_REPLACEMENT uses
  GraphicAttribute values.  The subclasses
  ShapeGraphicAttribute and
  ImageGraphicAttribute are not serializable.
  INPUT_METHOD_HIGHLIGHT uses
  InputMethodHighlight values, which are
  not serializable.  See InputMethodHighlight.


  Clients who create custom subclasses of Paint and
  GraphicAttribute can make them serializable and
  avoid this problem.  Clients who use input method highlights can
  convert these to the platform-specific attributes for that
  highlight on the current platform and set them on the Font as
  a workaround.

  The Map-based constructor and
  deriveFont APIs ignore the FONT attribute, and it is
  not retained by the Font; the static getFont(java.util.Map<? extends java.text.AttributedCharacterIterator.Attribute, ?>) method should
  be used if the FONT attribute might be present.  See TextAttribute.FONT for more information.

  Several attributes will cause additional rendering overhead
  and potentially invoke layout.  If a Font has such
  attributes, the hasLayoutAttributes() method
  will return true.

  Note: Font rotations can cause text baselines to be rotated.  In
  order to account for this (rare) possibility, font APIs are
  specified to return metrics and take parameters 'in
  baseline-relative coordinates'.  This maps the 'x' coordinate to
  the advance along the baseline, (positive x is forward along the
  baseline), and the 'y' coordinate to a distance along the
  perpendicular to the baseline at 'x' (positive y is 90 degrees
  clockwise from the baseline vector).  APIs for which this is
  especially important are called out as having 'baseline-relative
  coordinates.'"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Font]))

(defn ->font
  "Constructor.

  Creates a new Font from the specified name, style and
   point size.

   The font name can be a font face name or a font family name.
   It is used together with the style to find an appropriate font face.
   When a font family name is specified, the style argument is used to
   select the most appropriate face from the family. When a font face
   name is specified, the face's style and the style argument are
   merged to locate the best matching font from the same family.
   For example if face name `Arial Bold` is specified with style
   Font.ITALIC, the font system looks for a face in the
   `Arial` family that is bold and italic, and may associate the font
   instance with the physical font face `Arial Bold Italic`.
   The style argument is merged with the specified face's style, not
   added or subtracted.
   This means, specifying a bold face and a bold style does not
   double-embolden the font, and specifying a bold face and a plain
   style does not lighten the font.

   If no face for the requested style can be found, the font system
   may apply algorithmic styling to achieve the desired style.
   For example, if ITALIC is requested, but no italic
   face is available, glyphs from the plain face may be algorithmically
   obliqued (slanted).

   Font name lookup is case insensitive, using the case folding
   rules of the US locale.

   If the name parameter represents something other than a
   logical font, i.e. is interpreted as a physical font face or family, and
   this cannot be mapped by the implementation to a physical font or a
   compatible alternative, then the font system will map the Font
   instance to `Dialog`, such that for example, the family as reported
   by getFamily will be `Dialog`.

  name - the font name. This can be a font face name or a font family name, and may represent either a logical font or a physical font found in this GraphicsEnvironment. The family names for logical fonts are: Dialog, DialogInput, Monospaced, Serif, or SansSerif. Pre-defined String constants exist for all of these names, for example, DIALOG. If name is null, the logical font name of the new Font as returned by getName() is set to the name `Default`. - `java.lang.String`
  style - the style constant for the Font The style argument is an integer bitmask that may be PLAIN, or a bitwise union of BOLD and/or ITALIC (for example, ITALIC or BOLD|ITALIC). If the style argument does not conform to one of the expected integer bitmasks then the style is set to PLAIN. - `int`
  size - the point size of the Font - `int`"
  ([name style size]
    (new Font name style size))
  ([attributes]
    (new Font attributes)))

(def *-dialog
  "Static Constant.

  A String constant for the canonical family name of the
   logical font `Dialog`. It is useful in Font construction
   to provide compile-time verification of the name.

  type: java.lang.String"
  Font/DIALOG)

(def *-dialog-input
  "Static Constant.

  A String constant for the canonical family name of the
   logical font `DialogInput`. It is useful in Font construction
   to provide compile-time verification of the name.

  type: java.lang.String"
  Font/DIALOG_INPUT)

(def *-sans-serif
  "Static Constant.

  A String constant for the canonical family name of the
   logical font `SansSerif`. It is useful in Font construction
   to provide compile-time verification of the name.

  type: java.lang.String"
  Font/SANS_SERIF)

(def *-serif
  "Static Constant.

  A String constant for the canonical family name of the
   logical font `Serif`. It is useful in Font construction
   to provide compile-time verification of the name.

  type: java.lang.String"
  Font/SERIF)

(def *-monospaced
  "Static Constant.

  A String constant for the canonical family name of the
   logical font `Monospaced`. It is useful in Font construction
   to provide compile-time verification of the name.

  type: java.lang.String"
  Font/MONOSPACED)

(def *-plain
  "Static Constant.

  The plain style constant.

  type: int"
  Font/PLAIN)

(def *-bold
  "Static Constant.

  The bold style constant.  This can be combined with the other style
   constants (except PLAIN) for mixed styles.

  type: int"
  Font/BOLD)

(def *-italic
  "Static Constant.

  The italicized style constant.  This can be combined with the other
   style constants (except PLAIN) for mixed styles.

  type: int"
  Font/ITALIC)

(def *-roman-baseline
  "Static Constant.

  The baseline used in most Roman scripts when laying out text.

  type: int"
  Font/ROMAN_BASELINE)

(def *-center-baseline
  "Static Constant.

  The baseline used in ideographic scripts like Chinese, Japanese,
   and Korean when laying out text.

  type: int"
  Font/CENTER_BASELINE)

(def *-hanging-baseline
  "Static Constant.

  The baseline used in Devanigiri and similar scripts when laying
   out text.

  type: int"
  Font/HANGING_BASELINE)

(def *-truetype-font
  "Static Constant.

  Identify a font resource of type TRUETYPE.
   Used to specify a TrueType font resource to the
   createFont(int, java.io.InputStream) method.
   The TrueType format was extended to become the OpenType
   format, which adds support for fonts with Postscript outlines,
   this tag therefore references these fonts, as well as those
   with TrueType outlines.

  type: int"
  Font/TRUETYPE_FONT)

(def *-type-1-font
  "Static Constant.

  Identify a font resource of type TYPE1.
   Used to specify a Type1 font resource to the
   createFont(int, java.io.InputStream) method.

  type: int"
  Font/TYPE1_FONT)

(def *-layout-left-to-right
  "Static Constant.

  A flag to layoutGlyphVector indicating that text is left-to-right as
   determined by Bidi analysis.

  type: int"
  Font/LAYOUT_LEFT_TO_RIGHT)

(def *-layout-right-to-left
  "Static Constant.

  A flag to layoutGlyphVector indicating that text is right-to-left as
   determined by Bidi analysis.

  type: int"
  Font/LAYOUT_RIGHT_TO_LEFT)

(def *-layout-no-start-context
  "Static Constant.

  A flag to layoutGlyphVector indicating that text in the char array
   before the indicated start should not be examined.

  type: int"
  Font/LAYOUT_NO_START_CONTEXT)

(def *-layout-no-limit-context
  "Static Constant.

  A flag to layoutGlyphVector indicating that text in the char array
   after the indicated limit should not be examined.

  type: int"
  Font/LAYOUT_NO_LIMIT_CONTEXT)

(defn *get-font
  "Gets the specified Font from the system properties
   list.  As in the getProperty method of
   System, the first
   argument is treated as the name of a system property to be
   obtained.  The String value of this property is then
   interpreted as a Font object.

   The property value should be one of the forms accepted by
   Font.decode(String)
   If the specified property is not found, or the executing code does not
   have permission to read the property, the font
   argument is returned instead.

  nm - the case-insensitive property name - `java.lang.String`
  font - a default Font to return if property nm is not defined - `java.awt.Font`

  returns: the Font value of the property. - `java.awt.Font`

  throws: java.lang.NullPointerException - if nm is null."
  ([nm font]
    (Font/getFont nm font))
  ([attributes]
    (Font/getFont attributes)))

(defn *create-font
  "Returns a new Font using the specified font type
   and input data.  The new Font is
   created with a point size of 1 and style PLAIN.
   This base font can then be used with the deriveFont
   methods in this class to derive new Font objects with
   varying sizes, styles, transforms and font features.  This
   method does not close the InputStream.

   To make the Font available to Font constructors the
   returned Font must be registered in the
   GraphicsEnviroment by calling
   registerFont(Font).

  font-format - the type of the Font, which is TRUETYPE_FONT if a TrueType resource is specified. or TYPE1_FONT if a Type 1 resource is specified. - `int`
  font-stream - an InputStream object representing the input data for the font. - `java.io.InputStream`

  returns: a new Font created with the specified font type. - `java.awt.Font`

  throws: java.lang.IllegalArgumentException - if fontFormat is not TRUETYPE_FONTorTYPE1_FONT."
  ([font-format font-stream]
    (Font/createFont font-format font-stream)))

(defn *decode
  "Returns the Font that the str
   argument describes.
   To ensure that this method returns the desired Font,
   format the str parameter in
   one of these ways


   fontname-style-pointsize
   fontname-pointsize
   fontname-style
   fontname
   fontname style pointsize
   fontname pointsize
   fontname style
   fontname

   in which style is one of the four
   case-insensitive strings:
   `PLAIN`, `BOLD`, `BOLDITALIC`, or
   `ITALIC`, and pointsize is a positive decimal integer
   representation of the point size.
   For example, if you want a font that is Arial, bold, with
   a point size of 18, you would call this method with:
   `Arial-BOLD-18`.
   This is equivalent to calling the Font constructor :
   new Font(`Arial`, Font.BOLD, 18);
   and the values are interpreted as specified by that constructor.

   A valid trailing decimal field is always interpreted as the pointsize.
   Therefore a fontname containing a trailing decimal value should not
   be used in the fontname only form.

   If a style name field is not one of the valid style strings, it is
   interpreted as part of the font name, and the default style is used.

   Only one of ' ' or '-' may be used to separate fields in the input.
   The identified separator is the one closest to the end of the string
   which separates a valid pointsize, or a valid style name from
   the rest of the string.
   Null (empty) pointsize and style fields are treated
   as valid fields with the default value for that field.

   Some font names may include the separator characters ' ' or '-'.
   If str is not formed with 3 components, e.g. such that
   style or pointsize fields are not present in
   str, and fontname also contains a
   character determined to be the separator character
   then these characters where they appear as intended to be part of
   fontname may instead be interpreted as separators
   so the font name may not be properly recognised.


   The default size is 12 and the default style is PLAIN.
   If str does not specify a valid size, the returned
   Font has a size of 12.  If str does not
   specify a valid style, the returned Font has a style of PLAIN.
   If you do not specify a valid font name in
   the str argument, this method will return
   a font with the family name `Dialog`.
   To determine what font family names are available on
   your system, use the
   GraphicsEnvironment.getAvailableFontFamilyNames() method.
   If str is null, a new Font
   is returned with the family name `Dialog`, a size of 12 and a
   PLAIN style.

  str - the name of the font, or null - `java.lang.String`

  returns: the Font object that str
            describes, or a new default Font if
            str is null. - `java.awt.Font`"
  ([str]
    (Font/decode str)))

(defn get-available-attributes
  "Returns the keys of all the attributes supported by this
   Font.  These attributes can be used to derive other
   fonts.

  returns: an array containing the keys of all the attributes
            supported by this Font. - `java.text.AttributedCharacterIterator.Attribute[]`"
  ([this]
    (-> this (.getAvailableAttributes))))

(defn transformed?
  "Indicates whether or not this Font object has a
   transform that affects its size in addition to the Size
   attribute.

  returns: true if this Font object
            has a non-identity AffineTransform attribute.
            false otherwise. - `boolean`"
  ([this]
    (-> this (.isTransformed))))

(defn create-glyph-vector
  "Creates a GlyphVector by
   mapping characters to glyphs one-to-one based on the
   Unicode cmap in this Font.  This method does no other
   processing besides the mapping of glyphs to characters.  This
   means that this method is not useful for some scripts, such
   as Arabic, Hebrew, Thai, and Indic, that require reordering,
   shaping, or ligature substitution.

  frc - the specified FontRenderContext - `java.awt.font.FontRenderContext`
  str - the specified String - `java.lang.String`

  returns: a new GlyphVector created with the
   specified String and the specified
   FontRenderContext. - `java.awt.font.GlyphVector`"
  ([this frc str]
    (-> this (.createGlyphVector frc str))))

(defn layout-glyph-vector
  "Returns a new GlyphVector object, performing full
   layout of the text if possible.  Full layout is required for
   complex text, such as Arabic or Hindi.  Support for different
   scripts depends on the font and implementation.

   Layout requires bidi analysis, as performed by
   Bidi, and should only be performed on text that
   has a uniform direction.  The direction is indicated in the
   flags parameter,by using LAYOUT_RIGHT_TO_LEFT to indicate a
   right-to-left (Arabic and Hebrew) run direction, or
   LAYOUT_LEFT_TO_RIGHT to indicate a left-to-right (English)
   run direction.

   In addition, some operations, such as Arabic shaping, require
   context, so that the characters at the start and limit can have
   the proper shapes.  Sometimes the data in the buffer outside
   the provided range does not have valid data.  The values
   LAYOUT_NO_START_CONTEXT and LAYOUT_NO_LIMIT_CONTEXT can be
   added to the flags parameter to indicate that the text before
   start, or after limit, respectively, should not be examined
   for context.

   All other values for the flags parameter are reserved.

  frc - the specified FontRenderContext - `java.awt.font.FontRenderContext`
  text - the text to layout - `char[]`
  start - the start of the text to use for the GlyphVector - `int`
  limit - the limit of the text to use for the GlyphVector - `int`
  flags - control flags as described above - `int`

  returns: a new GlyphVector representing the text between
   start and limit, with glyphs chosen and positioned so as to best represent
   the text - `java.awt.font.GlyphVector`

  throws: java.lang.ArrayIndexOutOfBoundsException - if start or limit is out of bounds"
  ([this frc text start limit flags]
    (-> this (.layoutGlyphVector frc text start limit flags))))

(defn can-display?
  "Checks if this Font has a glyph for the specified
   character.

    Note: This method cannot handle  supplementary
   characters. To support all Unicode characters, including
   supplementary characters, use the canDisplay(int)
   method or canDisplayUpTo methods.

  c - the character for which a glyph is needed - `char`

  returns: true if this Font has a glyph for this
            character; false otherwise. - `boolean`"
  ([this c]
    (-> this (.canDisplay c))))

(defn plain?
  "Indicates whether or not this Font object's style is
   PLAIN.

  returns: true if this Font has a
              PLAIN style;
              false otherwise. - `boolean`"
  ([this]
    (-> this (.isPlain))))

(defn bold?
  "Indicates whether or not this Font object's style is
   BOLD.

  returns: true if this Font object's
              style is BOLD;
              false otherwise. - `boolean`"
  ([this]
    (-> this (.isBold))))

(defn get-line-metrics
  "Returns a LineMetrics object created with the
   specified arguments.

  str - the specified String - `java.lang.String`
  begin-index - the initial offset of str - `int`
  limit - the end offset of str - `int`
  frc - the specified FontRenderContext - `java.awt.font.FontRenderContext`

  returns: a LineMetrics object created with the
   specified arguments. - `java.awt.font.LineMetrics`"
  ([this str begin-index limit frc]
    (-> this (.getLineMetrics str begin-index limit frc)))
  ([this str frc]
    (-> this (.getLineMetrics str frc))))

(defn to-string
  "Converts this Font object to a String
   representation.

  returns: a String representation of this
            Font object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn derive-font
  "Creates a new Font object by replicating this
   Font object and applying a new style and size.

  style - the style for the new Font - `int`
  size - the size for the new Font - `float`

  returns: a new Font object. - `java.awt.Font`"
  ([this style size]
    (-> this (.deriveFont style size)))
  ([this size]
    (-> this (.deriveFont size))))

(defn can-display-up-to
  "Indicates whether or not this Font can display
   the characters in the specified text
   starting at start and ending at
   limit.  This method is a convenience overload.

  text - the specified array of char values - `char[]`
  start - the specified starting offset (in chars) into the specified array of char values - `int`
  limit - the specified ending offset (in chars) into the specified array of char values - `int`

  returns: an offset into text that points
            to the first character in text that this
            Font cannot display; or -1 if
            this Font can display all characters in
            text. - `int`"
  ([this text start limit]
    (-> this (.canDisplayUpTo text start limit)))
  ([this str]
    (-> this (.canDisplayUpTo str))))

(defn get-string-bounds
  "Returns the logical bounds of the specified String in
   the specified FontRenderContext.  The logical bounds
   contains the origin, ascent, advance, and height, which includes
   the leading.  The logical bounds does not always enclose all the
   text.  For example, in some languages and in some fonts, accent
   marks can be positioned above the ascent or below the descent.
   To obtain a visual bounding box, which encloses all the text,
   use the getBounds method of
   TextLayout.
   Note: The returned bounds is in baseline-relative coordinates
   (see class notes).

  str - the specified String - `java.lang.String`
  begin-index - the initial offset of str - `int`
  limit - the end offset of str - `int`
  frc - the specified FontRenderContext - `java.awt.font.FontRenderContext`

  returns: a Rectangle2D that is the bounding box of the
   specified String in the specified
   FontRenderContext. - `java.awt.geom.Rectangle2D`

  throws: java.lang.IndexOutOfBoundsException - if beginIndex is less than zero, or limit is greater than the length of str, or beginIndex is greater than limit."
  ([this str begin-index limit frc]
    (-> this (.getStringBounds str begin-index limit frc)))
  ([this str frc]
    (-> this (.getStringBounds str frc))))

(defn get-name
  "Returns the logical name of this Font.
   Use getFamily to get the family name of the font.
   Use getFontName to get the font face name of the font.

  returns: a String representing the logical name of
            this Font. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn get-num-glyphs
  "Returns the number of glyphs in this Font. Glyph codes
   for this Font range from 0 to
   getNumGlyphs() - 1.

  returns: the number of glyphs in this Font. - `int`"
  ([this]
    (-> this (.getNumGlyphs))))

(defn get-size-2-d
  "Returns the point size of this Font in
   float value.

  returns: the point size of this Font as a
   float value. - `float`"
  ([this]
    (-> this (.getSize2D))))

(defn has-layout-attributes?
  "Return true if this Font contains attributes that require extra
   layout processing.

  returns: true if the font has layout attributes - `boolean`"
  ([this]
    (-> this (.hasLayoutAttributes))))

(defn get-font-name
  "Returns the font face name of the Font, localized
   for the specified locale. For example, Helvetica Fett could be
   returned as the font face name.
   Use getFamily to get the family name of the font.

  l - a locale for which to get the font face name - `java.util.Locale`

  returns: a String representing the font face name,
            localized for the specified locale. - `java.lang.String`"
  ([this l]
    (-> this (.getFontName l)))
  ([this]
    (-> this (.getFontName))))

(defn get-family
  "Returns the family name of this Font, localized for
   the specified locale.

   The family name of a font is font specific. Two fonts such as
   Helvetica Italic and Helvetica Bold have the same family name,
   Helvetica, whereas their font face names are
   Helvetica Bold and Helvetica Italic. The list of
   available family names may be obtained by using the
   GraphicsEnvironment.getAvailableFontFamilyNames() method.

   Use getFontName to get the font face name of the font.

  l - locale for which to get the family name - `java.util.Locale`

  returns: a String representing the family name of the
            font, localized for the specified locale. - `java.lang.String`"
  ([this l]
    (-> this (.getFamily l)))
  ([this]
    (-> this (.getFamily))))

(defn get-max-char-bounds
  "Returns the bounds for the character with the maximum
   bounds as defined in the specified FontRenderContext.
   Note: The returned bounds is in baseline-relative coordinates
   (see class notes).

  frc - the specified FontRenderContext - `java.awt.font.FontRenderContext`

  returns: a Rectangle2D that is the bounding box
   for the character with the maximum bounds. - `java.awt.geom.Rectangle2D`"
  ([this frc]
    (-> this (.getMaxCharBounds frc))))

(defn get-italic-angle
  "Returns the italic angle of this Font.  The italic angle
   is the inverse slope of the caret which best matches the posture of this
   Font.

  returns: the angle of the ITALIC style of this Font. - `float`"
  ([this]
    (-> this (.getItalicAngle))))

(defn get-ps-name
  "Returns the postscript name of this Font.
   Use getFamily to get the family name of the font.
   Use getFontName to get the font face name of the font.

  returns: a String representing the postscript name of
            this Font. - `java.lang.String`"
  ([this]
    (-> this (.getPSName))))

(defn hash-code
  "Returns a hashcode for this Font.

  returns: a hashcode value for this Font. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn get-missing-glyph-code
  "Returns the glyphCode which is used when this Font
   does not have a glyph for a specified unicode code point.

  returns: the glyphCode of this Font. - `int`"
  ([this]
    (-> this (.getMissingGlyphCode))))

(defn get-transform
  "Returns a copy of the transform associated with this
   Font.  This transform is not necessarily the one
   used to construct the font.  If the font has algorithmic
   superscripting or width adjustment, this will be incorporated
   into the returned AffineTransform.

   Typically, fonts will not be transformed.  Clients generally
   should call isTransformed() first, and only call this
   method if isTransformed returns true.

  returns: an AffineTransform object representing the
            transform attribute of this Font object. - `java.awt.geom.AffineTransform`"
  ([this]
    (-> this (.getTransform))))

(defn italic?
  "Indicates whether or not this Font object's style is
   ITALIC.

  returns: true if this Font object's
              style is ITALIC;
              false otherwise. - `boolean`"
  ([this]
    (-> this (.isItalic))))

(defn get-size
  "Returns the point size of this Font, rounded to
   an integer.
   Most users are familiar with the idea of using point size to
   specify the size of glyphs in a font. This point size defines a
   measurement between the baseline of one line to the baseline of the
   following line in a single spaced text document. The point size is
   based on typographic points, approximately 1/72 of an inch.

   The Java(tm)2D API adopts the convention that one point is
   equivalent to one unit in user coordinates.  When using a
   normalized transform for converting user space coordinates to
   device space coordinates 72 user
   space units equal 1 inch in device space.  In this case one point
   is 1/72 of an inch.

  returns: the point size of this Font in 1/72 of an
            inch units. - `int`"
  ([this]
    (-> this (.getSize))))

(defn has-uniform-line-metrics?
  "Checks whether or not this Font has uniform
   line metrics.  A logical Font might be a
   composite font, which means that it is composed of different
   physical fonts to cover different code ranges.  Each of these
   fonts might have different LineMetrics.  If the
   logical Font is a single
   font then the metrics would be uniform.

  returns: true if this Font has
   uniform line metrics; false otherwise. - `boolean`"
  ([this]
    (-> this (.hasUniformLineMetrics))))

(defn equals
  "Compares this Font object to the specified
   Object.

  obj - the Object to compare - `java.lang.Object`

  returns: true if the objects are the same
            or if the argument is a Font object
            describing the same font as this object;
            false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn get-baseline-for
  "Returns the baseline appropriate for displaying this character.

   Large fonts can support different writing systems, and each system can
   use a different baseline.
   The character argument determines the writing system to use. Clients
   should not assume all characters use the same baseline.

  c - a character used to identify the writing system - `char`

  returns: the baseline appropriate for the specified character. - `byte`"
  ([this c]
    (-> this (.getBaselineFor c))))

(defn get-attributes
  "Returns a map of font attributes available in this
   Font.  Attributes include things like ligatures and
   glyph substitution.

  returns: the attributes map of this Font. - `java.util.Map<java.awt.font.TextAttribute,?>`"
  ([this]
    (-> this (.getAttributes))))

(defn get-peer
  "Deprecated. Font rendering is now platform independent.

  returns: the peer of the Font. - `java.lang.  java.awt.peer.FontPeer`"
  ([this]
    (-> this (.getPeer))))

(defn get-style
  "Returns the style of this Font.  The style can be
   PLAIN, BOLD, ITALIC, or BOLD+ITALIC.

  returns: the style of this Font - `int`"
  ([this]
    (-> this (.getStyle))))

