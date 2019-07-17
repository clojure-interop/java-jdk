(ns javax.swing.BorderFactory
  "Factory class for vending standard Border objects.  Wherever
  possible, this factory will hand out references to shared
  Border instances.
  For further information and examples see
  How
  to Use Borders,
  a section in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing BorderFactory]))

(defn *create-lowered-soft-bevel-border
  "Creates a beveled border with a lowered edge and softened corners,
   using brighter shades of the component's current background color
   for highlighting, and darker shading for shadows.
   In a lowered border, shadows are on top and highlights are underneath.

  returns: the Border object - `javax.swing.border.Border`"
  ([]
    (BorderFactory/createLoweredSoftBevelBorder )))

(defn *create-empty-border
  "Creates an empty border that takes up space but which does
   no drawing, specifying the width of the top, left, bottom, and
   right sides.

  top - an integer specifying the width of the top, in pixels - `int`
  left - an integer specifying the width of the left side, in pixels - `int`
  bottom - an integer specifying the width of the bottom, in pixels - `int`
  right - an integer specifying the width of the right side, in pixels - `int`

  returns: the Border object - `javax.swing.border.Border`"
  ([top left bottom right]
    (BorderFactory/createEmptyBorder top left bottom right))
  ([]
    (BorderFactory/createEmptyBorder )))

(defn *create-raised-bevel-border
  "Creates a border with a raised beveled edge, using
   brighter shades of the component's current background color
   for highlighting, and darker shading for shadows.
   (In a raised border, highlights are on top and shadows
    are underneath.)

  returns: the Border object - `javax.swing.border.Border`"
  ([]
    (BorderFactory/createRaisedBevelBorder )))

(defn *create-matte-border
  "Creates a matte-look border using a solid color. (The difference between
   this border and a line border is that you can specify the individual
   border dimensions.)

  top - an integer specifying the width of the top, in pixels - `int`
  left - an integer specifying the width of the left side, in pixels - `int`
  bottom - an integer specifying the width of the right side, in pixels - `int`
  right - an integer specifying the width of the bottom, in pixels - `int`
  color - a Color to use for the border - `java.awt.Color`

  returns: the MatteBorder object - `javax.swing.border.MatteBorder`"
  ([top left bottom right color]
    (BorderFactory/createMatteBorder top left bottom right color)))

(defn *create-lowered-bevel-border
  "Creates a border with a lowered beveled edge, using
   brighter shades of the component's current background color
   for highlighting, and darker shading for shadows.
   (In a lowered border, shadows are on top and highlights
    are underneath.)

  returns: the Border object - `javax.swing.border.Border`"
  ([]
    (BorderFactory/createLoweredBevelBorder )))

(defn *create-titled-border
  "Adds a title to an existing border, with the specified
   positioning, font and color.

  border - the Border object to add the title to - `javax.swing.border.Border`
  title - a String containing the text of the title - `java.lang.String`
  title-justification - an integer specifying the justification of the title -- one of the following:TitledBorder.LEFTTitledBorder.CENTERTitledBorder.RIGHTTitledBorder.LEADINGTitledBorder.TRAILINGTitledBorder.DEFAULT_JUSTIFICATION (leading) - `int`
  title-position - an integer specifying the vertical position of the text in relation to the border -- one of the following: TitledBorder.ABOVE_TOPTitledBorder.TOP (sitting on the top line)TitledBorder.BELOW_TOPTitledBorder.ABOVE_BOTTOMTitledBorder.BOTTOM (sitting on the bottom line)TitledBorder.BELOW_BOTTOMTitledBorder.DEFAULT_POSITION (the title position is determined by the current look and feel) - `int`
  title-font - a Font object specifying the title font - `java.awt.Font`
  title-color - a Color object specifying the title color - `java.awt.Color`

  returns: the TitledBorder object - `javax.swing.border.TitledBorder`"
  ([border title title-justification title-position title-font title-color]
    (BorderFactory/createTitledBorder border title title-justification title-position title-font title-color))
  ([border title title-justification title-position title-font]
    (BorderFactory/createTitledBorder border title title-justification title-position title-font))
  ([border title title-justification title-position]
    (BorderFactory/createTitledBorder border title title-justification title-position))
  ([border title]
    (BorderFactory/createTitledBorder border title))
  ([title]
    (BorderFactory/createTitledBorder title)))

(defn *create-dashed-border
  "Creates a dashed border of the specified paint, thickness,
   line shape, relative length, and relative spacing.
   If the specified paint is null,
   the component's foreground color will be used to render the border.

  paint - the Paint object used to generate a color - `java.awt.Paint`
  thickness - the width of a dash line - `float`
  length - the relative length of a dash line - `float`
  spacing - the relative spacing between dash lines - `float`
  rounded - whether or not line ends should be round - `boolean`

  returns: the Border object - `javax.swing.border.Border`

  throws: java.lang.IllegalArgumentException - if the specified thickness is less than 1, or if the specified length is less than 1, or if the specified spacing is less than 0"
  ([paint thickness length spacing rounded]
    (BorderFactory/createDashedBorder paint thickness length spacing rounded))
  ([paint length spacing]
    (BorderFactory/createDashedBorder paint length spacing))
  ([paint]
    (BorderFactory/createDashedBorder paint)))

(defn *create-compound-border
  "Creates a compound border specifying the border objects to use
   for the outside and inside edges.

  outside-border - a Border object for the outer edge of the compound border - `javax.swing.border.Border`
  inside-border - a Border object for the inner edge of the compound border - `javax.swing.border.Border`

  returns: the CompoundBorder object - `javax.swing.border.CompoundBorder`"
  ([outside-border inside-border]
    (BorderFactory/createCompoundBorder outside-border inside-border))
  ([]
    (BorderFactory/createCompoundBorder )))

(defn *create-etched-border
  "Creates a border with an `etched` look using
   the specified highlighting and shading colors.

  type - one of EtchedBorder.RAISED, or EtchedBorder.LOWERED - `int`
  highlight - a Color object for the border highlights - `java.awt.Color`
  shadow - a Color object for the border shadows - `java.awt.Color`

  returns: the Border object - `javax.swing.border.Border`"
  ([type highlight shadow]
    (BorderFactory/createEtchedBorder type highlight shadow))
  ([highlight shadow]
    (BorderFactory/createEtchedBorder highlight shadow))
  ([type]
    (BorderFactory/createEtchedBorder type))
  ([]
    (BorderFactory/createEtchedBorder )))

(defn *create-raised-soft-bevel-border
  "Creates a beveled border with a raised edge and softened corners,
   using brighter shades of the component's current background color
   for highlighting, and darker shading for shadows.
   In a raised border, highlights are on top and shadows are underneath.

  returns: the Border object - `javax.swing.border.Border`"
  ([]
    (BorderFactory/createRaisedSoftBevelBorder )))

(defn *create-soft-bevel-border
  "Creates a beveled border of the specified type with softened corners,
   using the specified colors for the inner and outer edges
   of the highlight and the shadow areas.
   The type is either BevelBorder.RAISED or BevelBorder.LOWERED.
   Note: The shadow inner and outer colors are switched
   for a lowered bevel border.

  type - a type of a bevel - `int`
  highlight-outer - a color of the outer edge of the highlight area - `java.awt.Color`
  highlight-inner - a color of the inner edge of the highlight area - `java.awt.Color`
  shadow-outer - a color of the outer edge of the shadow area - `java.awt.Color`
  shadow-inner - a color of the inner edge of the shadow area - `java.awt.Color`

  returns: the Border object - `javax.swing.border.Border`"
  ([type highlight-outer highlight-inner shadow-outer shadow-inner]
    (BorderFactory/createSoftBevelBorder type highlight-outer highlight-inner shadow-outer shadow-inner))
  ([type highlight shadow]
    (BorderFactory/createSoftBevelBorder type highlight shadow))
  ([type]
    (BorderFactory/createSoftBevelBorder type)))

(defn *create-bevel-border
  "Creates a beveled border of the specified type, using
   the specified colors for the inner and outer highlight
   and shadow areas.

  type - an integer specifying either BevelBorder.LOWERED or BevelBorder.RAISED - `int`
  highlight-outer - a Color object for the outer edge of the highlight area - `java.awt.Color`
  highlight-inner - a Color object for the inner edge of the highlight area - `java.awt.Color`
  shadow-outer - a Color object for the outer edge of the shadow area - `java.awt.Color`
  shadow-inner - a Color object for the inner edge of the shadow area - `java.awt.Color`

  returns: the Border object - `javax.swing.border.Border`"
  ([type highlight-outer highlight-inner shadow-outer shadow-inner]
    (BorderFactory/createBevelBorder type highlight-outer highlight-inner shadow-outer shadow-inner))
  ([type highlight shadow]
    (BorderFactory/createBevelBorder type highlight shadow))
  ([type]
    (BorderFactory/createBevelBorder type)))

(defn *create-stroke-border
  "Creates a border of the specified stroke and paint.
   If the specified paint is null,
   the component's foreground color will be used to render the border.

  stroke - the BasicStroke object used to stroke a shape - `java.awt.BasicStroke`
  paint - the Paint object used to generate a color - `java.awt.Paint`

  returns: the Border object - `javax.swing.border.Border`

  throws: java.lang.NullPointerException - if the specified stroke is null"
  ([stroke paint]
    (BorderFactory/createStrokeBorder stroke paint))
  ([stroke]
    (BorderFactory/createStrokeBorder stroke)))

(defn *create-line-border
  "Creates a line border with the specified color, thickness, and corner shape.

  color - the color of the border - `java.awt.Color`
  thickness - the thickness of the border - `int`
  rounded - whether or not border corners should be round - `boolean`

  returns: the Border object - `javax.swing.border.Border`"
  ([color thickness rounded]
    (BorderFactory/createLineBorder color thickness rounded))
  ([color thickness]
    (BorderFactory/createLineBorder color thickness))
  ([color]
    (BorderFactory/createLineBorder color)))

