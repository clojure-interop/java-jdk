(ns javax.swing.JLabel
  "A display area for a short text string or an image,
  or both.
  A label does not react to input events.
  As a result, it cannot get the keyboard focus.
  A label can, however, display a keyboard alternative
  as a convenience for a nearby component
  that has a keyboard alternative but can't display it.

  A JLabel object can display
  either text, an image, or both.
  You can specify where in the label's display area
  the label's contents are aligned
  by setting the vertical and horizontal alignment.
  By default, labels are vertically centered
  in their display area.
  Text-only labels are leading edge aligned, by default;
  image-only labels are horizontally centered, by default.

  You can also specify the position of the text
  relative to the image.
  By default, text is on the trailing edge of the image,
  with the text and image vertically aligned.

  A label's leading and trailing edge are determined from the value of its
  ComponentOrientation property.  At present, the default
  ComponentOrientation setting maps the leading edge to left and the trailing
  edge to right.


  Finally, you can use the setIconTextGap method
  to specify how many pixels
  should appear between the text and the image.
  The default is 4 pixels.

  See How to Use Labels
  in The Java Tutorial
  for further documentation.

  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JLabel]))

(defn ->j-label
  "Constructor.

  Creates a JLabel instance with the specified
   text, image, and horizontal alignment.
   The label is centered vertically in its display area.
   The text is on the trailing edge of the image.

  text - The text to be displayed by the label. - `java.lang.String`
  icon - The image to be displayed by the label. - `javax.swing.Icon`
  horizontal-alignment - One of the following constants defined in SwingConstants: LEFT, CENTER, RIGHT, LEADING or TRAILING. - `int`"
  ([^java.lang.String text ^javax.swing.Icon icon ^Integer horizontal-alignment]
    (new JLabel text icon horizontal-alignment))
  ([^java.lang.String text ^Integer horizontal-alignment]
    (new JLabel text horizontal-alignment))
  ([^java.lang.String text]
    (new JLabel text))
  ([]
    (new JLabel )))

(defn set-vertical-alignment
  "Sets the alignment of the label's contents along the Y axis.

   The default value of this property is CENTER.

  alignment - One of the following constants defined in SwingConstants: TOP, CENTER (the default), or BOTTOM. - `int`"
  ([^javax.swing.JLabel this ^Integer alignment]
    (-> this (.setVerticalAlignment alignment))))

(defn get-vertical-text-position
  "Returns the vertical position of the label's text,
   relative to its image.

  returns: One of the following constants
             defined in SwingConstants:
             TOP,
             CENTER, or
             BOTTOM. - `int`"
  ([^javax.swing.JLabel this]
    (-> this (.getVerticalTextPosition))))

(defn get-displayed-mnemonic
  "Return the keycode that indicates a mnemonic key.
   This property is used when the label is part of a larger component.
   If the labelFor property of the label is not null, the label will
   call the requestFocus method of the component specified by the
   labelFor property when the mnemonic is activated.

  returns: int value for the mnemonic key - `int`"
  ([^javax.swing.JLabel this]
    (-> this (.getDisplayedMnemonic))))

(defn set-icon
  "Defines the icon this component will display.  If
   the value of icon is null, nothing is displayed.

   The default value of this property is null.

   This is a JavaBeans bound property.

  icon - `javax.swing.Icon`"
  ([^javax.swing.JLabel this ^javax.swing.Icon icon]
    (-> this (.setIcon icon))))

(defn set-text
  "Defines the single line of text this component will display.  If
   the value of text is null or empty string, nothing is displayed.

   The default value of this property is null.

   This is a JavaBeans bound property.

  text - `java.lang.String`"
  ([^javax.swing.JLabel this ^java.lang.String text]
    (-> this (.setText text))))

(defn set-icon-text-gap
  "If both the icon and text properties are set, this property
   defines the space between them.

   The default value of this property is 4 pixels.

   This is a JavaBeans bound property.

  icon-text-gap - `int`"
  ([^javax.swing.JLabel this ^Integer icon-text-gap]
    (-> this (.setIconTextGap icon-text-gap))))

(defn set-horizontal-text-position
  "Sets the horizontal position of the label's text,
   relative to its image.

  text-position - One of the following constants defined in SwingConstants: LEFT, CENTER, RIGHT, LEADING, or TRAILING (the default). - `int`

  throws: java.lang.IllegalArgumentException"
  ([^javax.swing.JLabel this ^Integer text-position]
    (-> this (.setHorizontalTextPosition text-position))))

(defn get-text
  "Returns the text string that the label displays.

  returns: a String - `java.lang.String`"
  ([^javax.swing.JLabel this]
    (-> this (.getText))))

(defn get-icon
  "Returns the graphic image (glyph, icon) that the label displays.

  returns: an Icon - `javax.swing.Icon`"
  ([^javax.swing.JLabel this]
    (-> this (.getIcon))))

(defn set-vertical-text-position
  "Sets the vertical position of the label's text,
   relative to its image.

   The default value of this property is CENTER.

   This is a JavaBeans bound property.

  text-position - One of the following constants defined in SwingConstants: TOP, CENTER (the default), or BOTTOM. - `int`"
  ([^javax.swing.JLabel this ^Integer text-position]
    (-> this (.setVerticalTextPosition text-position))))

(defn get-horizontal-text-position
  "Returns the horizontal position of the label's text,
   relative to its image.

  returns: One of the following constants
             defined in SwingConstants:
             LEFT,
             CENTER,
             RIGHT,
             LEADING or
             TRAILING. - `int`"
  ([^javax.swing.JLabel this]
    (-> this (.getHorizontalTextPosition))))

(defn get-ui-class-id
  "Returns a string that specifies the name of the l&f class
   that renders this component.

  returns: String `LabelUI` - `java.lang.String`"
  ([^javax.swing.JLabel this]
    (-> this (.getUIClassID))))

(defn get-label-for
  "Get the component this is labelling.

  returns: the Component this is labelling.  Can be null if this
   does not label a Component.  If the displayedMnemonic
   property is set and the labelFor property is also set, the label
   will call the requestFocus method of the component specified by the
   labelFor property when the mnemonic is activated. - `java.awt.Component`"
  ([^javax.swing.JLabel this]
    (-> this (.getLabelFor))))

(defn set-label-for
  "Set the component this is labelling.  Can be null if this does not
   label a Component.  If the displayedMnemonic property is set
   and the labelFor property is also set, the label will
   call the requestFocus method of the component specified by the
   labelFor property when the mnemonic is activated.

  c - the Component this label is for, or null if the label is not the label for a component - `java.awt.Component`"
  ([^javax.swing.JLabel this ^java.awt.Component c]
    (-> this (.setLabelFor c))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the LabelUI L&F object - `javax.swing.plaf.LabelUI`"
  ([^javax.swing.JLabel this ^javax.swing.plaf.LabelUI ui]
    (-> this (.setUI ui))))

(defn get-ui
  "Returns the L&F object that renders this component.

  returns: LabelUI object - `javax.swing.plaf.LabelUI`"
  ([^javax.swing.JLabel this]
    (-> this (.getUI))))

(defn set-displayed-mnemonic-index
  "Provides a hint to the look and feel as to which character in the
   text should be decorated to represent the mnemonic. Not all look and
   feels may support this. A value of -1 indicates either there is no
   mnemonic, the mnemonic character is not contained in the string, or
   the developer does not wish the mnemonic to be displayed.

   The value of this is updated as the properties relating to the
   mnemonic change (such as the mnemonic itself, the text...).
   You should only ever have to call this if
   you do not wish the default character to be underlined. For example, if
   the text was 'Save As', with a mnemonic of 'a', and you wanted the 'A'
   to be decorated, as 'Save As', you would have to invoke
   setDisplayedMnemonicIndex(5) after invoking
   setDisplayedMnemonic(KeyEvent.VK_A).

  index - Index into the String to underline - `int`

  throws: java.lang.IllegalArgumentException - will be thrown if index is >= length of the text, or < -1"
  ([^javax.swing.JLabel this ^Integer index]
    (-> this (.setDisplayedMnemonicIndex index))))

(defn get-accessible-context
  "Get the AccessibleContext of this object

  returns: the AccessibleContext of this object - `javax.accessibility.AccessibleContext`"
  ([^javax.swing.JLabel this]
    (-> this (.getAccessibleContext))))

(defn get-vertical-alignment
  "Returns the alignment of the label's contents along the Y axis.

  returns: The value of the verticalAlignment property, one of the
             following constants defined in SwingConstants:
             TOP,
             CENTER, or
             BOTTOM. - `int`"
  ([^javax.swing.JLabel this]
    (-> this (.getVerticalAlignment))))

(defn image-update
  "This is overridden to return false if the current Icon's Image is
   not equal to the passed in Image img.

  img - the image being observed - `java.awt.Image`
  infoflags - see imageUpdate for more information - `int`
  x - the x coordinate - `int`
  y - the y coordinate - `int`
  w - the width - `int`
  h - the height - `int`

  returns: false if the infoflags indicate that the
              image is completely loaded; true otherwise. - `boolean`"
  ([^javax.swing.JLabel this ^java.awt.Image img ^Integer infoflags ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.imageUpdate img infoflags x y w h))))

(defn get-horizontal-alignment
  "Returns the alignment of the label's contents along the X axis.

  returns: The value of the horizontalAlignment property, one of the
             following constants defined in SwingConstants:
             LEFT,
             CENTER,
             RIGHT,
             LEADING or
             TRAILING. - `int`"
  ([^javax.swing.JLabel this]
    (-> this (.getHorizontalAlignment))))

(defn get-icon-text-gap
  "Returns the amount of space between the text and the icon
   displayed in this label.

  returns: an int equal to the number of pixels between the text
           and the icon. - `int`"
  ([^javax.swing.JLabel this]
    (-> this (.getIconTextGap))))

(defn set-displayed-mnemonic
  "Specify a keycode that indicates a mnemonic key.
   This property is used when the label is part of a larger component.
   If the labelFor property of the label is not null, the label will
   call the requestFocus method of the component specified by the
   labelFor property when the mnemonic is activated.

  key - `int`"
  ([^javax.swing.JLabel this ^Integer key]
    (-> this (.setDisplayedMnemonic key))))

(defn set-horizontal-alignment
  "Sets the alignment of the label's contents along the X axis.

   This is a JavaBeans bound property.

  alignment - One of the following constants defined in SwingConstants: LEFT, CENTER (the default for image-only labels), RIGHT, LEADING (the default for text-only labels) or TRAILING. - `int`"
  ([^javax.swing.JLabel this ^Integer alignment]
    (-> this (.setHorizontalAlignment alignment))))

(defn get-displayed-mnemonic-index
  "Returns the character, as an index, that the look and feel should
   provide decoration for as representing the mnemonic character.

  returns: index representing mnemonic character - `int`"
  ([^javax.swing.JLabel this]
    (-> this (.getDisplayedMnemonicIndex))))

(defn set-disabled-icon
  "Set the icon to be displayed if this JLabel is `disabled`
   (JLabel.setEnabled(false)).

   The default value of this property is null.

  disabled-icon - the Icon to display when the component is disabled - `javax.swing.Icon`"
  ([^javax.swing.JLabel this ^javax.swing.Icon disabled-icon]
    (-> this (.setDisabledIcon disabled-icon))))

(defn get-disabled-icon
  "Returns the icon used by the label when it's disabled.
   If no disabled icon has been set this will forward the call to
   the look and feel to construct an appropriate disabled Icon.

   Some look and feels might not render the disabled Icon, in which
   case they will ignore this.

  returns: the disabledIcon property - `javax.swing.Icon`"
  ([^javax.swing.JLabel this]
    (-> this (.getDisabledIcon))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([^javax.swing.JLabel this]
    (-> this (.updateUI))))

