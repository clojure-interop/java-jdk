(ns jdk.awt.font.TextAttribute
  "The TextAttribute class defines attribute keys and
  attribute values used for text rendering.

  TextAttribute instances are used as attribute keys to
  identify attributes in
  Font,
  TextLayout,
  AttributedCharacterIterator,
  and other classes handling text attributes. Other constants defined
  in this class can be used as attribute values.

  For each text attribute, the documentation provides:

    the type of its value,
    the relevant predefined constants, if any
    the default effect if the attribute is absent
    the valid values if there are limitations
    a description of the effect.


  Values

    The values of attributes must always be immutable.
    Where value limitations are given, any value outside of that
    set is reserved for future use; the value will be treated as
    the default.
    The value null is treated the same as the
    default value and results in the default behavior.
    If the value is not of the proper type, the attribute
    will be ignored.
    The identity of the value does not matter, only the actual
    value.  For example, TextAttribute.WEIGHT_BOLD and
    new Float(2.0)
    indicate the same WEIGHT.
    Attribute values of type Number (used for
    WEIGHT, WIDTH, POSTURE,
    SIZE, JUSTIFICATION, and
    TRACKING) can vary along their natural range and are
    not restricted to the predefined constants.
    Number.floatValue() is used to get the actual value
    from the Number.
    The values for WEIGHT, WIDTH, and
    POSTURE are interpolated by the system, which
    can select the 'nearest available' font or use other techniques to
    approximate the user's request.



  Summary of attributes



  Key
  Value Type
  Principal Constants
  Default Value


  FAMILY
  String
  See Font DIALOG,
  DIALOG_INPUT, SERIF,
  SANS_SERIF, and MONOSPACED.

  \"Default\" (use platform default)


  WEIGHT
  Number
  WEIGHT_REGULAR, WEIGHT_BOLD
  WEIGHT_REGULAR


  WIDTH
  Number
  WIDTH_CONDENSED, WIDTH_REGULAR,WIDTH_EXTENDED
  WIDTH_REGULAR


  POSTURE
  Number
  POSTURE_REGULAR, POSTURE_OBLIQUE
  POSTURE_REGULAR


  SIZE
  Number
  none
  12.0


  TRANSFORM
  TransformAttribute
  See TransformAttribute IDENTITY
  TransformAttribute.IDENTITY


  SUPERSCRIPT
  Integer
  SUPERSCRIPT_SUPER, SUPERSCRIPT_SUB
  0 (use the standard glyphs and metrics)


  FONT
  Font
  none
  null (do not override font resolution)


  CHAR_REPLACEMENT
  GraphicAttribute
  none
  null (draw text using font glyphs)


  FOREGROUND
  Paint
  none
  null (use current graphics paint)


  BACKGROUND
  Paint
  none
  null (do not render background)


  UNDERLINE
  Integer
  UNDERLINE_ON
  -1 (do not render underline)


  STRIKETHROUGH
  Boolean
  STRIKETHROUGH_ON
  false (do not render strikethrough)


  RUN_DIRECTION
  Boolean
  RUN_DIRECTION_LTRRUN_DIRECTION_RTL
  null (use Bidi standard default)


  BIDI_EMBEDDING
  Integer
  none
  0 (use base line direction)


  JUSTIFICATION
  Number
  JUSTIFICATION_FULL
  JUSTIFICATION_FULL


  INPUT_METHOD_HIGHLIGHT
  InputMethodHighlight,Annotation
  (see class)
  null (do not apply input highlighting)


  INPUT_METHOD_UNDERLINE
  Integer
  UNDERLINE_LOW_ONE_PIXEL,UNDERLINE_LOW_TWO_PIXEL
  -1 (do not render underline)


  SWAP_COLORS
  Boolean
  SWAP_COLORS_ON
  false (do not swap colors)


  NUMERIC_SHAPING
  NumericShaper
  none
  null (do not shape digits)


  KERNING
  Integer
  KERNING_ON
  0 (do not request kerning)


  LIGATURES
  Integer
  LIGATURES_ON
  0 (do not form optional ligatures)


  TRACKING
  Number
  TRACKING_LOOSE, TRACKING_TIGHT
  0 (do not add tracking)"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font TextAttribute]))

(def *-family
  "Static Constant.

  Attribute key for the font name.  Values are instances of
   String.  The default value is
   \"Default\", which causes the platform default font
   family to be used.

    The Font class defines constants for the logical
   font names
   DIALOG,
   DIALOG_INPUT,
   SANS_SERIF,
   SERIF, and
   MONOSPACED.

   This defines the value passed as name to the
   Font constructor.  Both logical and physical
   font names are allowed. If a font with the requested name
   is not found, the default font is used.

   Note: This attribute is unfortunately misnamed, as
   it specifies the face name and not just the family.  Thus
   values such as \"Lucida Sans Bold\" will select that face if it
   exists.  Note, though, that if the requested face does not
   exist, the default will be used with regular weight.
   The \"Bold\" in the name is part of the face name, not a separate
   request that the font's weight be bold.

  type: java.awt.font.TextAttribute"
  TextAttribute/FAMILY)

(def *-weight
  "Static Constant.

  Attribute key for the weight of a font.  Values are instances
   of Number.  The default value is
   WEIGHT_REGULAR.

   Several constant values are provided, see WEIGHT_EXTRA_LIGHT, WEIGHT_LIGHT, WEIGHT_DEMILIGHT, WEIGHT_REGULAR, WEIGHT_SEMIBOLD, WEIGHT_MEDIUM, WEIGHT_DEMIBOLD, WEIGHT_BOLD, WEIGHT_HEAVY,
   WEIGHT_EXTRABOLD, and WEIGHT_ULTRABOLD.  The
   value WEIGHT_BOLD corresponds to the
   style value Font.BOLD as passed to the
   Font constructor.

   The value is roughly the ratio of the stem width to that of
   the regular weight.

   The system can interpolate the provided value.

  type: java.awt.font.TextAttribute"
  TextAttribute/WEIGHT)

(def *-weight-extra-light
  "Static Constant.

  The lightest predefined weight.

  type: java.lang.Float"
  TextAttribute/WEIGHT_EXTRA_LIGHT)

(def *-weight-light
  "Static Constant.

  The standard light weight.

  type: java.lang.Float"
  TextAttribute/WEIGHT_LIGHT)

(def *-weight-demilight
  "Static Constant.

  An intermediate weight between WEIGHT_LIGHT and
   WEIGHT_STANDARD.

  type: java.lang.Float"
  TextAttribute/WEIGHT_DEMILIGHT)

(def *-weight-regular
  "Static Constant.

  The standard weight. This is the default value for WEIGHT.

  type: java.lang.Float"
  TextAttribute/WEIGHT_REGULAR)

(def *-weight-semibold
  "Static Constant.

  A moderately heavier weight than WEIGHT_REGULAR.

  type: java.lang.Float"
  TextAttribute/WEIGHT_SEMIBOLD)

(def *-weight-medium
  "Static Constant.

  An intermediate weight between WEIGHT_REGULAR and
   WEIGHT_BOLD.

  type: java.lang.Float"
  TextAttribute/WEIGHT_MEDIUM)

(def *-weight-demibold
  "Static Constant.

  A moderately lighter weight than WEIGHT_BOLD.

  type: java.lang.Float"
  TextAttribute/WEIGHT_DEMIBOLD)

(def *-weight-bold
  "Static Constant.

  The standard bold weight.

  type: java.lang.Float"
  TextAttribute/WEIGHT_BOLD)

(def *-weight-heavy
  "Static Constant.

  A moderately heavier weight than WEIGHT_BOLD.

  type: java.lang.Float"
  TextAttribute/WEIGHT_HEAVY)

(def *-weight-extrabold
  "Static Constant.

  An extra heavy weight.

  type: java.lang.Float"
  TextAttribute/WEIGHT_EXTRABOLD)

(def *-weight-ultrabold
  "Static Constant.

  The heaviest predefined weight.

  type: java.lang.Float"
  TextAttribute/WEIGHT_ULTRABOLD)

(def *-width
  "Static Constant.

  Attribute key for the width of a font.  Values are instances of
   Number.  The default value is
   WIDTH_REGULAR.

   Several constant values are provided, see WIDTH_CONDENSED, WIDTH_SEMI_CONDENSED, WIDTH_REGULAR, WIDTH_SEMI_EXTENDED, WIDTH_EXTENDED.

   The value is roughly the ratio of the advance width to that
   of the regular width.

   The system can interpolate the provided value.

  type: java.awt.font.TextAttribute"
  TextAttribute/WIDTH)

(def *-width-condensed
  "Static Constant.

  The most condensed predefined width.

  type: java.lang.Float"
  TextAttribute/WIDTH_CONDENSED)

(def *-width-semi-condensed
  "Static Constant.

  A moderately condensed width.

  type: java.lang.Float"
  TextAttribute/WIDTH_SEMI_CONDENSED)

(def *-width-regular
  "Static Constant.

  The standard width. This is the default value for
   WIDTH.

  type: java.lang.Float"
  TextAttribute/WIDTH_REGULAR)

(def *-width-semi-extended
  "Static Constant.

  A moderately extended width.

  type: java.lang.Float"
  TextAttribute/WIDTH_SEMI_EXTENDED)

(def *-width-extended
  "Static Constant.

  The most extended predefined width.

  type: java.lang.Float"
  TextAttribute/WIDTH_EXTENDED)

(def *-posture
  "Static Constant.

  Attribute key for the posture of a font.  Values are instances
   of Number. The default value is
   POSTURE_REGULAR.

   Two constant values are provided, POSTURE_REGULAR
   and POSTURE_OBLIQUE. The value
   POSTURE_OBLIQUE corresponds to the style value
   Font.ITALIC as passed to the Font
   constructor.

   The value is roughly the slope of the stems of the font,
   expressed as the run over the rise.  Positive values lean right.

   The system can interpolate the provided value.

   This will affect the font's italic angle as returned by
   Font.getItalicAngle.

  type: java.awt.font.TextAttribute"
  TextAttribute/POSTURE)

(def *-posture-regular
  "Static Constant.

  The standard posture, upright.  This is the default value for
   POSTURE.

  type: java.lang.Float"
  TextAttribute/POSTURE_REGULAR)

(def *-posture-oblique
  "Static Constant.

  The standard italic posture.

  type: java.lang.Float"
  TextAttribute/POSTURE_OBLIQUE)

(def *-size
  "Static Constant.

  Attribute key for the font size.  Values are instances of
   Number.  The default value is 12pt.

   This corresponds to the size parameter to the
   Font constructor.

   Very large or small sizes will impact rendering performance,
   and the rendering system might not render text at these sizes.
   Negative sizes are illegal and result in the default size.

   Note that the appearance and metrics of a 12pt font with a
   2x transform might be different than that of a 24 point font
   with no transform.

  type: java.awt.font.TextAttribute"
  TextAttribute/SIZE)

(def *-transform
  "Static Constant.

  Attribute key for the transform of a font.  Values are
   instances of TransformAttribute.  The
   default value is TransformAttribute.IDENTITY.

   The TransformAttribute class defines the
   constant IDENTITY.

   This corresponds to the transform passed to
   Font.deriveFont(AffineTransform).  Since that
   transform is mutable and TextAttribute values must
   not be, the TransformAttribute wrapper class is
   used.

   The primary intent is to support scaling and skewing, though
   other effects are possible.

   Some transforms will cause the baseline to be rotated and/or
   shifted.  The text and the baseline are transformed together so
   that the text follows the new baseline.  For example, with text
   on a horizontal baseline, the new baseline follows the
   direction of the unit x vector passed through the
   transform. Text metrics are measured against this new baseline.
   So, for example, with other things being equal, text rendered
   with a rotated TRANSFORM and an unrotated TRANSFORM will measure as
   having the same ascent, descent, and advance.

   In styled text, the baselines for each such run are aligned
   one after the other to potentially create a non-linear baseline
   for the entire run of text. For more information, see TextLayout.getLayoutPath().

  type: java.awt.font.TextAttribute"
  TextAttribute/TRANSFORM)

(def *-superscript
  "Static Constant.

  Attribute key for superscripting and subscripting.  Values are
   instances of Integer.  The default value is
   0, which means that no superscript or subscript is used.

   Two constant values are provided, see SUPERSCRIPT_SUPER and SUPERSCRIPT_SUB.  These have
   the values 1 and -1 respectively.  Values of
   greater magnitude define greater levels of superscript or
   subscripting, for example, 2 corresponds to super-superscript,
   3 to super-super-superscript, and similarly for negative values
   and subscript, up to a level of 7 (or -7).  Values beyond this
   range are reserved; behavior is platform-dependent.

   SUPERSCRIPT can
   impact the ascent and descent of a font.  The ascent
   and descent can never become negative, however.

  type: java.awt.font.TextAttribute"
  TextAttribute/SUPERSCRIPT)

(def *-superscript-super
  "Static Constant.

  Standard superscript.

  type: java.lang.Integer"
  TextAttribute/SUPERSCRIPT_SUPER)

(def *-superscript-sub
  "Static Constant.

  Standard subscript.

  type: java.lang.Integer"
  TextAttribute/SUPERSCRIPT_SUB)

(def *-font
  "Static Constant.

  Attribute key used to provide the font to use to render text.
   Values are instances of Font.  The default
   value is null, indicating that normal resolution of a
   Font from attributes should be performed.

   TextLayout and
   AttributedCharacterIterator work in terms of
   Maps of TextAttributes.  Normally,
   all the attributes are examined and used to select and
   configure a Font instance.  If a FONT
   attribute is present, though, its associated Font
   will be used.  This provides a way for users to override the
   resolution of font attributes into a Font, or
   force use of a particular Font instance.  This
   also allows users to specify subclasses of Font in
   cases where a Font can be subclassed.

   FONT is used for special situations where
   clients already have a Font instance but still
   need to use Map-based APIs.  Typically, there will
   be no other attributes in the Map except the
   FONT attribute.  With Map-based APIs
   the common case is to specify all attributes individually, so
   FONT is not needed or desireable.

   However, if both FONT and other attributes are
   present in the Map, the rendering system will
   merge the attributes defined in the Font with the
   additional attributes.  This merging process classifies
   TextAttributes into two groups.  One group, the
   'primary' group, is considered fundamental to the selection and
   metric behavior of a font.  These attributes are
   FAMILY, WEIGHT, WIDTH,
   POSTURE, SIZE,
   TRANSFORM, SUPERSCRIPT, and
   TRACKING. The other group, the 'secondary' group,
   consists of all other defined attributes, with the exception of
   FONT itself.

   To generate the new Map, first the
   Font is obtained from the FONT
   attribute, and all of its attributes extracted into a
   new Map.  Then only the secondary
   attributes from the original Map are added to
   those in the new Map.  Thus the values of primary
   attributes come solely from the Font, and the
   values of secondary attributes originate with the
   Font but can be overridden by other values in the
   Map.

   Note:Font's Map-based
   constructor and deriveFont methods do not process
   the FONT attribute, as these are used to create
   new Font objects.  Instead, Font.getFont(Map) should be used to
   handle the FONT attribute.

  type: java.awt.font.TextAttribute"
  TextAttribute/FONT)

(def *-char-replacement
  "Static Constant.

  Attribute key for a user-defined glyph to display in lieu
   of the font's standard glyph for a character.  Values are
   intances of GraphicAttribute.  The default value is null,
   indicating that the standard glyphs provided by the font
   should be used.

   This attribute is used to reserve space for a graphic or
   other component embedded in a line of text.  It is required for
   correct positioning of 'inline' components within a line when
   bidirectional reordering (see Bidi) is
   performed.  Each character (Unicode code point) will be
   rendered using the provided GraphicAttribute. Typically, the
   characters to which this attribute is applied should be
   \\uFFFC.

   The GraphicAttribute determines the logical and visual
   bounds of the text; the actual Font values are ignored.

  type: java.awt.font.TextAttribute"
  TextAttribute/CHAR_REPLACEMENT)

(def *-foreground
  "Static Constant.

  Attribute key for the paint used to render the text.  Values are
   instances of Paint.  The default value is
   null, indicating that the Paint set on the
   Graphics2D at the time of rendering is used.

   Glyphs will be rendered using this
   Paint regardless of the Paint value
   set on the Graphics (but see SWAP_COLORS).

  type: java.awt.font.TextAttribute"
  TextAttribute/FOREGROUND)

(def *-background
  "Static Constant.

  Attribute key for the paint used to render the background of
   the text.  Values are instances of Paint.
   The default value is null, indicating that the background
   should not be rendered.

   The logical bounds of the text will be filled using this
   Paint, and then the text will be rendered on top
   of it (but see SWAP_COLORS).

   The visual bounds of the text is extended to include the
   logical bounds, if necessary.  The outline is not affected.

  type: java.awt.font.TextAttribute"
  TextAttribute/BACKGROUND)

(def *-underline
  "Static Constant.

  Attribute key for underline.  Values are instances of
   Integer.  The default value is -1, which
   means no underline.

   The constant value UNDERLINE_ON is provided.

   The underline affects both the visual bounds and the outline
   of the text.

  type: java.awt.font.TextAttribute"
  TextAttribute/UNDERLINE)

(def *-underline-on
  "Static Constant.

  Standard underline.

  type: java.lang.Integer"
  TextAttribute/UNDERLINE_ON)

(def *-strikethrough
  "Static Constant.

  Attribute key for strikethrough.  Values are instances of
   Boolean.  The default value is
   false, which means no strikethrough.

   The constant value STRIKETHROUGH_ON is provided.

   The strikethrough affects both the visual bounds and the
   outline of the text.

  type: java.awt.font.TextAttribute"
  TextAttribute/STRIKETHROUGH)

(def *-strikethrough-on
  "Static Constant.

  A single strikethrough.

  type: java.lang.Boolean"
  TextAttribute/STRIKETHROUGH_ON)

(def *-run-direction
  "Static Constant.

  Attribute key for the run direction of the line.  Values are
   instances of Boolean.  The default value is
   null, which indicates that the standard Bidi algorithm for
   determining run direction should be used with the value Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT.

   The constants RUN_DIRECTION_RTL and RUN_DIRECTION_LTR are provided.

   This determines the value passed to the Bidi constructor to select the primary direction of
   the text in the paragraph.

   Note: This attribute should have the same value for
   all the text in a paragraph, otherwise the behavior is
   undetermined.

  type: java.awt.font.TextAttribute"
  TextAttribute/RUN_DIRECTION)

(def *-run-direction-ltr
  "Static Constant.

  Left-to-right run direction.

  type: java.lang.Boolean"
  TextAttribute/RUN_DIRECTION_LTR)

(def *-run-direction-rtl
  "Static Constant.

  Right-to-left run direction.

  type: java.lang.Boolean"
  TextAttribute/RUN_DIRECTION_RTL)

(def *-bidi-embedding
  "Static Constant.

  Attribute key for the embedding level of the text.  Values are
   instances of Integer.  The default value is
   null, indicating that the the Bidirectional
   algorithm should run without explicit embeddings.

   Positive values 1 through 61 are embedding levels,
   negative values -1 through -61 are override levels.
   The value 0 means that the base line direction is used.  These
   levels are passed in the embedding levels array to the Bidi constructor.

   Note: When this attribute is present anywhere in
   a paragraph, then any Unicode bidi control characters (RLO,
   LRO, RLE, LRE, and PDF) in the paragraph are
   disregarded, and runs of text where this attribute is not
   present are treated as though it were present and had the value
   0.

  type: java.awt.font.TextAttribute"
  TextAttribute/BIDI_EMBEDDING)

(def *-justification
  "Static Constant.

  Attribute key for the justification of a paragraph.  Values are
   instances of Number.  The default value is
   1, indicating that justification should use the full width
   provided.  Values are pinned to the range [0..1].

   The constants JUSTIFICATION_FULL and JUSTIFICATION_NONE are provided.

   Specifies the fraction of the extra space to use when
   justification is requested on a TextLayout. For
   example, if the line is 50 points wide and it is requested to
   justify to 70 points, a value of 0.75 will pad to use
   three-quarters of the remaining space, or 15 points, so that
   the resulting line will be 65 points in length.

   Note: This should have the same value for all the
   text in a paragraph, otherwise the behavior is undetermined.

  type: java.awt.font.TextAttribute"
  TextAttribute/JUSTIFICATION)

(def *-justification-full
  "Static Constant.

  Justify the line to the full requested width.  This is the
   default value for JUSTIFICATION.

  type: java.lang.Float"
  TextAttribute/JUSTIFICATION_FULL)

(def *-justification-none
  "Static Constant.

  Do not allow the line to be justified.

  type: java.lang.Float"
  TextAttribute/JUSTIFICATION_NONE)

(def *-input-method-highlight
  "Static Constant.

  Attribute key for input method highlight styles.

   Values are instances of InputMethodHighlight or Annotation.  The default value is null,
   which means that input method styles should not be applied
   before rendering.

   If adjacent runs of text with the same
   InputMethodHighlight need to be rendered
   separately, the InputMethodHighlights should be
   wrapped in Annotation instances.

   Input method highlights are used while text is being
   composed by an input method. Text editing components should
   retain them even if they generally only deal with unstyled
   text, and make them available to the drawing routines.

  type: java.awt.font.TextAttribute"
  TextAttribute/INPUT_METHOD_HIGHLIGHT)

(def *-input-method-underline
  "Static Constant.

  Attribute key for input method underlines.  Values
   are instances of Integer.  The default
   value is -1, which means no underline.

   Several constant values are provided, see UNDERLINE_LOW_ONE_PIXEL, UNDERLINE_LOW_TWO_PIXEL,
   UNDERLINE_LOW_DOTTED, UNDERLINE_LOW_GRAY, and
   UNDERLINE_LOW_DASHED.

   This may be used in conjunction with UNDERLINE if
   desired.  The primary purpose is for use by input methods.
   Other use of these underlines for simple ornamentation might
   confuse users.

   The input method underline affects both the visual bounds and
   the outline of the text.

  type: java.awt.font.TextAttribute"
  TextAttribute/INPUT_METHOD_UNDERLINE)

(def *-underline-low-one-pixel
  "Static Constant.

  Single pixel solid low underline.

  type: java.lang.Integer"
  TextAttribute/UNDERLINE_LOW_ONE_PIXEL)

(def *-underline-low-two-pixel
  "Static Constant.

  Double pixel solid low underline.

  type: java.lang.Integer"
  TextAttribute/UNDERLINE_LOW_TWO_PIXEL)

(def *-underline-low-dotted
  "Static Constant.

  Single pixel dotted low underline.

  type: java.lang.Integer"
  TextAttribute/UNDERLINE_LOW_DOTTED)

(def *-underline-low-gray
  "Static Constant.

  Double pixel gray low underline.

  type: java.lang.Integer"
  TextAttribute/UNDERLINE_LOW_GRAY)

(def *-underline-low-dashed
  "Static Constant.

  Single pixel dashed low underline.

  type: java.lang.Integer"
  TextAttribute/UNDERLINE_LOW_DASHED)

(def *-swap-colors
  "Static Constant.

  Attribute key for swapping foreground and background
   Paints.  Values are instances of
   Boolean.  The default value is
   false, which means do not swap colors.

   The constant value SWAP_COLORS_ON is defined.

   If the FOREGROUND attribute is set, its
   Paint will be used as the background, otherwise
   the Paint currently on the Graphics
   will be used.  If the BACKGROUND attribute is set, its
   Paint will be used as the foreground, otherwise
   the system will find a contrasting color to the
   (resolved) background so that the text will be visible.

  type: java.awt.font.TextAttribute"
  TextAttribute/SWAP_COLORS)

(def *-swap-colors-on
  "Static Constant.

  Swap foreground and background.

  type: java.lang.Boolean"
  TextAttribute/SWAP_COLORS_ON)

(def *-numeric-shaping
  "Static Constant.

  Attribute key for converting ASCII decimal digits to other
   decimal ranges.  Values are instances of NumericShaper.
   The default is null, which means do not perform
   numeric shaping.

   When a numeric shaper is defined, the text is first
   processed by the shaper before any other analysis of the text
   is performed.

   Note: This should have the same value for all the
   text in the paragraph, otherwise the behavior is undetermined.

  type: java.awt.font.TextAttribute"
  TextAttribute/NUMERIC_SHAPING)

(def *-kerning
  "Static Constant.

  Attribute key to request kerning. Values are instances of
   Integer.  The default value is
   0, which does not request kerning.

   The constant value KERNING_ON is provided.

   The default advances of single characters are not
   appropriate for some character sequences, for example \"To\" or
   \"AWAY\".  Without kerning the adjacent characters appear to be
   separated by too much space.  Kerning causes selected sequences
   of characters to be spaced differently for a more pleasing
   visual appearance.

  type: java.awt.font.TextAttribute"
  TextAttribute/KERNING)

(def *-kerning-on
  "Static Constant.

  Request standard kerning.

  type: java.lang.Integer"
  TextAttribute/KERNING_ON)

(def *-ligatures
  "Static Constant.

  Attribute key for enabling optional ligatures. Values are
   instances of Integer.  The default value is
   0, which means do not use optional ligatures.

   The constant value LIGATURES_ON is defined.

   Ligatures required by the writing system are always enabled.

  type: java.awt.font.TextAttribute"
  TextAttribute/LIGATURES)

(def *-ligatures-on
  "Static Constant.

  Request standard optional ligatures.

  type: java.lang.Integer"
  TextAttribute/LIGATURES_ON)

(def *-tracking
  "Static Constant.

  Attribute key to control tracking.  Values are instances of
   Number.  The default value is
   0, which means no additional tracking.

   The constant values TRACKING_TIGHT and TRACKING_LOOSE are provided.

   The tracking value is multiplied by the font point size and
   passed through the font transform to determine an additional
   amount to add to the advance of each glyph cluster.  Positive
   tracking values will inhibit formation of optional ligatures.
   Tracking values are typically between -0.1 and
   0.3; values outside this range are generally not
   desireable.

  type: java.awt.font.TextAttribute"
  TextAttribute/TRACKING)

(def *-tracking-tight
  "Static Constant.

  Perform tight tracking.

  type: java.lang.Float"
  TextAttribute/TRACKING_TIGHT)

(def *-tracking-loose
  "Static Constant.

  Perform loose tracking.

  type: java.lang.Float"
  TextAttribute/TRACKING_LOOSE)

