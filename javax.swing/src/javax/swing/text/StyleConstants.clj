(ns javax.swing.text.StyleConstants
  " A collection of well known or common attribute keys
  and methods to apply to an AttributeSet or MutableAttributeSet
  to get/set the properties in a typesafe manner.

  The paragraph attributes form the definition of a paragraph to be rendered.
  All sizes are specified in points (such as found in postscript), a
  device independent measure."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyleConstants]))

(def *-component-element-name
  "Static Constant.

  Name of elements used to represent components.

  type: java.lang.String"
  StyleConstants/ComponentElementName)

(def *-icon-element-name
  "Static Constant.

  Name of elements used to represent icons.

  type: java.lang.String"
  StyleConstants/IconElementName)

(def *-name-attribute
  "Static Constant.

  Attribute name used to name the collection of
   attributes.

  type: java.lang.Object"
  StyleConstants/NameAttribute)

(def *-resolve-attribute
  "Static Constant.

  Attribute name used to identify the resolving parent
   set of attributes, if one is defined.

  type: java.lang.Object"
  StyleConstants/ResolveAttribute)

(def *-model-attribute
  "Static Constant.

  Attribute used to identify the model for embedded
   objects that have a model view separation.

  type: java.lang.Object"
  StyleConstants/ModelAttribute)

(def *-bidi-level
  "Static Constant.

  Bidirectional level of a character as assigned by the Unicode bidi
   algorithm.

  type: java.lang.Object"
  StyleConstants/BidiLevel)

(def *-font-family
  "Static Constant.

  Name of the font family.

  type: java.lang.Object"
  StyleConstants/FontFamily)

(def *-family
  "Static Constant.

  Name of the font family.

  type: java.lang.Object"
  StyleConstants/Family)

(def *-font-size
  "Static Constant.

  Name of the font size.

  type: java.lang.Object"
  StyleConstants/FontSize)

(def *-size
  "Static Constant.

  Name of the font size.

  type: java.lang.Object"
  StyleConstants/Size)

(def *-bold
  "Static Constant.

  Name of the bold attribute.

  type: java.lang.Object"
  StyleConstants/Bold)

(def *-italic
  "Static Constant.

  Name of the italic attribute.

  type: java.lang.Object"
  StyleConstants/Italic)

(def *-underline
  "Static Constant.

  Name of the underline attribute.

  type: java.lang.Object"
  StyleConstants/Underline)

(def *-strike-through
  "Static Constant.

  Name of the Strikethrough attribute.

  type: java.lang.Object"
  StyleConstants/StrikeThrough)

(def *-superscript
  "Static Constant.

  Name of the Superscript attribute.

  type: java.lang.Object"
  StyleConstants/Superscript)

(def *-subscript
  "Static Constant.

  Name of the Subscript attribute.

  type: java.lang.Object"
  StyleConstants/Subscript)

(def *-foreground
  "Static Constant.

  Name of the foreground color attribute.

  type: java.lang.Object"
  StyleConstants/Foreground)

(def *-background
  "Static Constant.

  Name of the background color attribute.

  type: java.lang.Object"
  StyleConstants/Background)

(def *-component-attribute
  "Static Constant.

  Name of the component attribute.

  type: java.lang.Object"
  StyleConstants/ComponentAttribute)

(def *-icon-attribute
  "Static Constant.

  Name of the icon attribute.

  type: java.lang.Object"
  StyleConstants/IconAttribute)

(def *-composed-text-attribute
  "Static Constant.

  Name of the input method composed text attribute. The value of
   this attribute is an instance of AttributedString which represents
   the composed text.

  type: java.lang.Object"
  StyleConstants/ComposedTextAttribute)

(def *-first-line-indent
  "Static Constant.

  The amount of space to indent the first
   line of the paragraph.  This value may be negative
   to offset in the reverse direction.  The type
   is Float and specifies the size of the space
   in points.

  type: java.lang.Object"
  StyleConstants/FirstLineIndent)

(def *-left-indent
  "Static Constant.

  The amount to indent the left side
   of the paragraph.
   Type is float and specifies the size in points.

  type: java.lang.Object"
  StyleConstants/LeftIndent)

(def *-right-indent
  "Static Constant.

  The amount to indent the right side
   of the paragraph.
   Type is float and specifies the size in points.

  type: java.lang.Object"
  StyleConstants/RightIndent)

(def *-line-spacing
  "Static Constant.

  The amount of space between lines
   of the paragraph.
   Type is float and specifies the size as a factor of the line height

  type: java.lang.Object"
  StyleConstants/LineSpacing)

(def *-space-above
  "Static Constant.

  The amount of space above the paragraph.
   Type is float and specifies the size in points.

  type: java.lang.Object"
  StyleConstants/SpaceAbove)

(def *-space-below
  "Static Constant.

  The amount of space below the paragraph.
   Type is float and specifies the size in points.

  type: java.lang.Object"
  StyleConstants/SpaceBelow)

(def *-alignment
  "Static Constant.

  Alignment for the paragraph.  The type is
   Integer.  Valid values are:

   ALIGN_LEFT
   ALIGN_RIGHT
   ALIGN_CENTER
   ALIGN_JUSTIFED

  type: java.lang.Object"
  StyleConstants/Alignment)

(def *-tab-set
  "Static Constant.

  TabSet for the paragraph, type is a TabSet containing
   TabStops.

  type: java.lang.Object"
  StyleConstants/TabSet)

(def *-orientation
  "Static Constant.

  Orientation for a paragraph.

  type: java.lang.Object"
  StyleConstants/Orientation)

(def *-align-left
  "Static Constant.

  A possible value for paragraph alignment.  This
   specifies that the text is aligned to the left
   indent and extra whitespace should be placed on
   the right.

  type: int"
  StyleConstants/ALIGN_LEFT)

(def *-align-center
  "Static Constant.

  A possible value for paragraph alignment.  This
   specifies that the text is aligned to the center
   and extra whitespace should be placed equally on
   the left and right.

  type: int"
  StyleConstants/ALIGN_CENTER)

(def *-align-right
  "Static Constant.

  A possible value for paragraph alignment.  This
   specifies that the text is aligned to the right
   indent and extra whitespace should be placed on
   the left.

  type: int"
  StyleConstants/ALIGN_RIGHT)

(def *-align-justified
  "Static Constant.

  A possible value for paragraph alignment.  This
   specifies that extra whitespace should be spread
   out through the rows of the paragraph with the
   text lined up with the left and right indent
   except on the last line which should be aligned
   to the left.

  type: int"
  StyleConstants/ALIGN_JUSTIFIED)

(defn *set-first-line-indent
  "Sets the first line indent.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  i - the value - `float`"
  ([^javax.swing.text.MutableAttributeSet a ^Float i]
    (StyleConstants/setFirstLineIndent a i)))

(defn *get-first-line-indent
  "Gets the first line indent setting.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the value, 0 if not set - `float`"
  (^Float [^javax.swing.text.AttributeSet a]
    (StyleConstants/getFirstLineIndent a)))

(defn *set-alignment
  "Sets alignment.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  align - the alignment value - `int`"
  ([^javax.swing.text.MutableAttributeSet a ^Integer align]
    (StyleConstants/setAlignment a align)))

(defn *get-component
  "Gets the component setting from the attribute list.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the component, null if none - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.text.AttributeSet a]
    (StyleConstants/getComponent a)))

(defn *get-font-family
  "Gets the font family setting from the attribute list.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the font family, \"Monospaced\" as the default - `java.lang.String`"
  (^java.lang.String [^javax.swing.text.AttributeSet a]
    (StyleConstants/getFontFamily a)))

(defn *set-tab-set
  "Sets the TabSet.

  a - the attribute set. - `javax.swing.text.MutableAttributeSet`
  tabs - the TabSet - `javax.swing.text.TabSet`"
  ([^javax.swing.text.MutableAttributeSet a ^javax.swing.text.TabSet tabs]
    (StyleConstants/setTabSet a tabs)))

(defn *set-foreground
  "Sets the foreground color.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  fg - the color - `java.awt.Color`"
  ([^javax.swing.text.MutableAttributeSet a ^java.awt.Color fg]
    (StyleConstants/setForeground a fg)))

(defn *strike-through?
  "Checks whether the strikethrough attribute is set.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: true if set else false - `boolean`"
  (^Boolean [^javax.swing.text.AttributeSet a]
    (StyleConstants/isStrikeThrough a)))

(defn *set-right-indent
  "Sets right indent.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  i - the value - `float`"
  ([^javax.swing.text.MutableAttributeSet a ^Float i]
    (StyleConstants/setRightIndent a i)))

(defn *set-icon
  "Sets the icon attribute.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  c - the icon - `javax.swing.Icon`"
  ([^javax.swing.text.MutableAttributeSet a ^javax.swing.Icon c]
    (StyleConstants/setIcon a c)))

(defn *get-foreground
  "Gets the foreground color setting from the attribute list.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the color, Color.black as the default - `java.awt.Color`"
  (^java.awt.Color [^javax.swing.text.AttributeSet a]
    (StyleConstants/getForeground a)))

(defn *set-bidi-level
  "Sets the BidiLevel.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  o - the bidi level value - `int`"
  ([^javax.swing.text.MutableAttributeSet a ^Integer o]
    (StyleConstants/setBidiLevel a o)))

(defn *set-italic
  "Sets the italic attribute.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  b - specifies true/false for setting the attribute - `boolean`"
  ([^javax.swing.text.MutableAttributeSet a ^Boolean b]
    (StyleConstants/setItalic a b)))

(defn *set-left-indent
  "Sets left indent.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  i - the value - `float`"
  ([^javax.swing.text.MutableAttributeSet a ^Float i]
    (StyleConstants/setLeftIndent a i)))

(defn *get-bidi-level
  "Gets the BidiLevel setting.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the value - `int`"
  (^Integer [^javax.swing.text.AttributeSet a]
    (StyleConstants/getBidiLevel a)))

(defn *get-icon
  "Gets the icon setting from the attribute list.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the icon, null if none - `javax.swing.Icon`"
  (^javax.swing.Icon [^javax.swing.text.AttributeSet a]
    (StyleConstants/getIcon a)))

(defn *subscript?
  "Checks whether the subscript attribute is set.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: true if set else false - `boolean`"
  (^Boolean [^javax.swing.text.AttributeSet a]
    (StyleConstants/isSubscript a)))

(defn *bold?
  "Checks whether the bold attribute is set.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: true if set else false - `boolean`"
  (^Boolean [^javax.swing.text.AttributeSet a]
    (StyleConstants/isBold a)))

(defn *get-font-size
  "Gets the font size setting from the attribute list.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the font size, 12 as the default - `int`"
  (^Integer [^javax.swing.text.AttributeSet a]
    (StyleConstants/getFontSize a)))

(defn *set-subscript
  "Sets the subscript attribute.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  b - specifies true/false for setting the attribute - `boolean`"
  ([^javax.swing.text.MutableAttributeSet a ^Boolean b]
    (StyleConstants/setSubscript a b)))

(defn *set-font-size
  "Sets the font size attribute.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  s - the font size - `int`"
  ([^javax.swing.text.MutableAttributeSet a ^Integer s]
    (StyleConstants/setFontSize a s)))

(defn *set-background
  "Sets the background color.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  fg - the color - `java.awt.Color`"
  ([^javax.swing.text.MutableAttributeSet a ^java.awt.Color fg]
    (StyleConstants/setBackground a fg)))

(defn *get-left-indent
  "Gets the left indent setting.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the value, 0 if not set - `float`"
  (^Float [^javax.swing.text.AttributeSet a]
    (StyleConstants/getLeftIndent a)))

(defn *set-bold
  "Sets the bold attribute.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  b - specifies true/false for setting the attribute - `boolean`"
  ([^javax.swing.text.MutableAttributeSet a ^Boolean b]
    (StyleConstants/setBold a b)))

(defn *set-font-family
  "Sets the font attribute.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  fam - the font - `java.lang.String`"
  ([^javax.swing.text.MutableAttributeSet a ^java.lang.String fam]
    (StyleConstants/setFontFamily a fam)))

(defn *set-space-below
  "Sets space below.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  i - the value - `float`"
  ([^javax.swing.text.MutableAttributeSet a ^Float i]
    (StyleConstants/setSpaceBelow a i)))

(defn *superscript?
  "Checks whether the superscript attribute is set.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: true if set else false - `boolean`"
  (^Boolean [^javax.swing.text.AttributeSet a]
    (StyleConstants/isSuperscript a)))

(defn *get-line-spacing
  "Gets the line spacing setting.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the value, 0 if not set - `float`"
  (^Float [^javax.swing.text.AttributeSet a]
    (StyleConstants/getLineSpacing a)))

(defn *set-component
  "Sets the component attribute.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  c - the component - `java.awt.Component`"
  ([^javax.swing.text.MutableAttributeSet a ^java.awt.Component c]
    (StyleConstants/setComponent a c)))

(defn *get-alignment
  "Gets the alignment setting.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the value StyleConstants.ALIGN_LEFT if not set - `int`"
  (^Integer [^javax.swing.text.AttributeSet a]
    (StyleConstants/getAlignment a)))

(defn *get-space-below
  "Gets the space below setting.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the value, 0 if not set - `float`"
  (^Float [^javax.swing.text.AttributeSet a]
    (StyleConstants/getSpaceBelow a)))

(defn *set-strike-through
  "Sets the strikethrough attribute.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  b - specifies true/false for setting the attribute - `boolean`"
  ([^javax.swing.text.MutableAttributeSet a ^Boolean b]
    (StyleConstants/setStrikeThrough a b)))

(defn *get-tab-set
  "Gets the TabSet.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the TabSet - `javax.swing.text.TabSet`"
  (^javax.swing.text.TabSet [^javax.swing.text.AttributeSet a]
    (StyleConstants/getTabSet a)))

(defn *get-background
  "Gets the background color setting from the attribute list.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the color, Color.black as the default - `java.awt.Color`"
  (^java.awt.Color [^javax.swing.text.AttributeSet a]
    (StyleConstants/getBackground a)))

(defn *underline?
  "Checks whether the underline attribute is set.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: true if set else false - `boolean`"
  (^Boolean [^javax.swing.text.AttributeSet a]
    (StyleConstants/isUnderline a)))

(defn *set-space-above
  "Sets space above.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  i - the value - `float`"
  ([^javax.swing.text.MutableAttributeSet a ^Float i]
    (StyleConstants/setSpaceAbove a i)))

(defn *get-right-indent
  "Gets the right indent setting.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the value, 0 if not set - `float`"
  (^Float [^javax.swing.text.AttributeSet a]
    (StyleConstants/getRightIndent a)))

(defn *italic?
  "Checks whether the italic attribute is set.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: true if set else false - `boolean`"
  (^Boolean [^javax.swing.text.AttributeSet a]
    (StyleConstants/isItalic a)))

(defn *set-underline
  "Sets the underline attribute.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  b - specifies true/false for setting the attribute - `boolean`"
  ([^javax.swing.text.MutableAttributeSet a ^Boolean b]
    (StyleConstants/setUnderline a b)))

(defn *get-space-above
  "Gets the space above setting.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the value, 0 if not set - `float`"
  (^Float [^javax.swing.text.AttributeSet a]
    (StyleConstants/getSpaceAbove a)))

(defn *set-superscript
  "Sets the superscript attribute.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  b - specifies true/false for setting the attribute - `boolean`"
  ([^javax.swing.text.MutableAttributeSet a ^Boolean b]
    (StyleConstants/setSuperscript a b)))

(defn *set-line-spacing
  "Sets line spacing.

  a - the attribute set - `javax.swing.text.MutableAttributeSet`
  i - the value - `float`"
  ([^javax.swing.text.MutableAttributeSet a ^Float i]
    (StyleConstants/setLineSpacing a i)))

(defn to-string
  "Returns the string representation.

  returns: the string - `java.lang.String`"
  (^java.lang.String [^StyleConstants this]
    (-> this (.toString))))

