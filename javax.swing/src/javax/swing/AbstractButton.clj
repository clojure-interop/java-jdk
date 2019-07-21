(ns javax.swing.AbstractButton
  "Defines common behaviors for buttons and menu items.

  Buttons can be configured, and to some degree controlled, by
  Actions.  Using an
  Action with a button has many benefits beyond directly
  configuring a button.  Refer to
  Swing Components Supporting Action for more
  details, and you can find more information in How
  to Use Actions, a section in The Java Tutorial.

  For further information see
  How to Use Buttons, Check Boxes, and Radio Buttons,
  a section in The Java Tutorial.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing AbstractButton]))

(defn ->abstract-button
  "Constructor."
  (^AbstractButton []
    (new AbstractButton )))

(def *-model-changed-property
  "Static Constant.

  Identifies a change in the button model.

  type: java.lang.String"
  AbstractButton/MODEL_CHANGED_PROPERTY)

(def *-text-changed-property
  "Static Constant.

  Identifies a change in the button's text.

  type: java.lang.String"
  AbstractButton/TEXT_CHANGED_PROPERTY)

(def *-mnemonic-changed-property
  "Static Constant.

  Identifies a change to the button's mnemonic.

  type: java.lang.String"
  AbstractButton/MNEMONIC_CHANGED_PROPERTY)

(def *-margin-changed-property
  "Static Constant.

  Identifies a change in the button's margins.

  type: java.lang.String"
  AbstractButton/MARGIN_CHANGED_PROPERTY)

(def *-vertical-alignment-changed-property
  "Static Constant.

  Identifies a change in the button's vertical alignment.

  type: java.lang.String"
  AbstractButton/VERTICAL_ALIGNMENT_CHANGED_PROPERTY)

(def *-horizontal-alignment-changed-property
  "Static Constant.

  Identifies a change in the button's horizontal alignment.

  type: java.lang.String"
  AbstractButton/HORIZONTAL_ALIGNMENT_CHANGED_PROPERTY)

(def *-vertical-text-position-changed-property
  "Static Constant.

  Identifies a change in the button's vertical text position.

  type: java.lang.String"
  AbstractButton/VERTICAL_TEXT_POSITION_CHANGED_PROPERTY)

(def *-horizontal-text-position-changed-property
  "Static Constant.

  Identifies a change in the button's horizontal text position.

  type: java.lang.String"
  AbstractButton/HORIZONTAL_TEXT_POSITION_CHANGED_PROPERTY)

(def *-border-painted-changed-property
  "Static Constant.

  Identifies a change to having the border drawn,
   or having it not drawn.

  type: java.lang.String"
  AbstractButton/BORDER_PAINTED_CHANGED_PROPERTY)

(def *-focus-painted-changed-property
  "Static Constant.

  Identifies a change to having the border highlighted when focused,
   or not.

  type: java.lang.String"
  AbstractButton/FOCUS_PAINTED_CHANGED_PROPERTY)

(def *-rollover-enabled-changed-property
  "Static Constant.

  Identifies a change from rollover enabled to disabled or back
   to enabled.

  type: java.lang.String"
  AbstractButton/ROLLOVER_ENABLED_CHANGED_PROPERTY)

(def *-content-area-filled-changed-property
  "Static Constant.

  Identifies a change to having the button paint the content area.

  type: java.lang.String"
  AbstractButton/CONTENT_AREA_FILLED_CHANGED_PROPERTY)

(def *-icon-changed-property
  "Static Constant.

  Identifies a change to the icon that represents the button.

  type: java.lang.String"
  AbstractButton/ICON_CHANGED_PROPERTY)

(def *-pressed-icon-changed-property
  "Static Constant.

  Identifies a change to the icon used when the button has been
   pressed.

  type: java.lang.String"
  AbstractButton/PRESSED_ICON_CHANGED_PROPERTY)

(def *-selected-icon-changed-property
  "Static Constant.

  Identifies a change to the icon used when the button has
   been selected.

  type: java.lang.String"
  AbstractButton/SELECTED_ICON_CHANGED_PROPERTY)

(def *-rollover-icon-changed-property
  "Static Constant.

  Identifies a change to the icon used when the cursor is over
   the button.

  type: java.lang.String"
  AbstractButton/ROLLOVER_ICON_CHANGED_PROPERTY)

(def *-rollover-selected-icon-changed-property
  "Static Constant.

  Identifies a change to the icon used when the cursor is
   over the button and it has been selected.

  type: java.lang.String"
  AbstractButton/ROLLOVER_SELECTED_ICON_CHANGED_PROPERTY)

(def *-disabled-icon-changed-property
  "Static Constant.

  Identifies a change to the icon used when the button has
   been disabled.

  type: java.lang.String"
  AbstractButton/DISABLED_ICON_CHANGED_PROPERTY)

(def *-disabled-selected-icon-changed-property
  "Static Constant.

  Identifies a change to the icon used when the button has been
   disabled and selected.

  type: java.lang.String"
  AbstractButton/DISABLED_SELECTED_ICON_CHANGED_PROPERTY)

(defn add-item-listener
  "Adds an ItemListener to the checkbox.

  l - the ItemListener to be added - `java.awt.event.ItemListener`"
  ([^AbstractButton this ^java.awt.event.ItemListener l]
    (-> this (.addItemListener l))))

(defn get-mnemonic
  "Returns the keyboard mnemonic from the the current model.

  returns: the keyboard mnemonic from the model - `int`"
  (^Integer [^AbstractButton this]
    (-> this (.getMnemonic))))

(defn add-change-listener
  "Adds a ChangeListener to the button.

  l - the listener to be added - `javax.swing.event.ChangeListener`"
  ([^AbstractButton this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn set-vertical-alignment
  "Sets the vertical alignment of the icon and text.

  alignment - one of the following values: SwingConstants.CENTER (the default) SwingConstants.TOP SwingConstants.BOTTOM - `int`

  throws: java.lang.IllegalArgumentException - if the alignment is not one of the legal values listed above"
  ([^AbstractButton this ^Integer alignment]
    (-> this (.setVerticalAlignment alignment))))

(defn get-selected-icon
  "Returns the selected icon for the button.

  returns: the selectedIcon property - `javax.swing.Icon`"
  (^javax.swing.Icon [^AbstractButton this]
    (-> this (.getSelectedIcon))))

(defn set-layout
  "Sets the layout manager for this container, refer to
   Container.setLayout(LayoutManager)
   for a complete description of this method.

  mgr - the specified layout manager - `java.awt.LayoutManager`"
  ([^AbstractButton this ^java.awt.LayoutManager mgr]
    (-> this (.setLayout mgr))))

(defn get-rollover-selected-icon
  "Returns the rollover selection icon for the button.

  returns: the rolloverSelectedIcon property - `javax.swing.Icon`"
  (^javax.swing.Icon [^AbstractButton this]
    (-> this (.getRolloverSelectedIcon))))

(defn get-vertical-text-position
  "Returns the vertical position of the text relative to the icon.

  returns: the verticalTextPosition property,
            one of the following values:

   SwingConstants.CENTER (the default)
   SwingConstants.TOP
   SwingConstants.BOTTOM - `int`"
  (^Integer [^AbstractButton this]
    (-> this (.getVerticalTextPosition))))

(defn get-multi-click-threshhold
  "Gets the amount of time (in milliseconds) required between
   mouse press events for the button to generate the corresponding
   action events.

  returns: the amount of time required between mouse press events
           to generate corresponding action events - `long`"
  (^Long [^AbstractButton this]
    (-> this (.getMultiClickThreshhold))))

(defn get-disabled-selected-icon
  "Returns the icon used by the button when it's disabled and selected.
   If no disabled selection icon has been set, this will forward
   the call to the LookAndFeel to construct an appropriate disabled
   Icon from the selection icon if it has been set and to
   getDisabledIcon() otherwise.

   Some look and feels might not render the disabled selected Icon, in
   which case they will ignore this.

  returns: the disabledSelectedIcon property - `javax.swing.Icon`"
  (^javax.swing.Icon [^AbstractButton this]
    (-> this (.getDisabledSelectedIcon))))

(defn set-focus-painted
  "Sets the paintFocus property, which must
   be true for the focus state to be painted.
   The default value for the paintFocus property
   is true.
   Some look and feels might not paint focus state;
   they will ignore this property.

  b - if true, the focus state should be painted - `boolean`"
  ([^AbstractButton this ^Boolean b]
    (-> this (.setFocusPainted b))))

(defn set-icon
  "Sets the button's default icon. This icon is
   also used as the \"pressed\" and \"disabled\" icon if
   there is no explicitly set pressed icon.

  default-icon - the icon used as the default image - `javax.swing.Icon`"
  ([^AbstractButton this ^javax.swing.Icon default-icon]
    (-> this (.setIcon default-icon))))

(defn set-text
  "Sets the button's text.

  text - the string used to set the text - `java.lang.String`"
  ([^AbstractButton this ^java.lang.String text]
    (-> this (.setText text))))

(defn remove-item-listener
  "Removes an ItemListener from the button.

  l - the ItemListener to be removed - `java.awt.event.ItemListener`"
  ([^AbstractButton this ^java.awt.event.ItemListener l]
    (-> this (.removeItemListener l))))

(defn set-icon-text-gap
  "If both the icon and text properties are set, this property
   defines the space between them.

   The default value of this property is 4 pixels.

   This is a JavaBeans bound property.

  icon-text-gap - `int`"
  ([^AbstractButton this ^Integer icon-text-gap]
    (-> this (.setIconTextGap icon-text-gap))))

(defn content-area-filled?
  "Gets the contentAreaFilled property.

  returns: the contentAreaFilled property - `boolean`"
  (^Boolean [^AbstractButton this]
    (-> this (.isContentAreaFilled))))

(defn set-horizontal-text-position
  "Sets the horizontal position of the text relative to the icon.

  text-position - one of the following values: SwingConstants.RIGHT SwingConstants.LEFT SwingConstants.CENTER SwingConstants.LEADING SwingConstants.TRAILING (the default) - `int`

  throws: java.lang.IllegalArgumentException - if textPosition is not one of the legal values listed above"
  ([^AbstractButton this ^Integer text-position]
    (-> this (.setHorizontalTextPosition text-position))))

(defn set-margin
  "Sets space for margin between the button's border and
   the label. Setting to null will cause the button to
   use the default margin.  The button's default Border
   object will use this value to create the proper margin.
   However, if a non-default border is set on the button,
   it is that Border object's responsibility to create the
   appropriate margin space (else this property will
   effectively be ignored).

  m - the space between the border and the label - `java.awt.Insets`"
  ([^AbstractButton this ^java.awt.Insets m]
    (-> this (.setMargin m))))

(defn get-text
  "Returns the button's text.

  returns: the buttons text - `java.lang.String`"
  (^java.lang.String [^AbstractButton this]
    (-> this (.getText))))

(defn set-selected
  "Sets the state of the button. Note that this method does not
   trigger an actionEvent.
   Call doClick to perform a programmatic action change.

  b - true if the button is selected, otherwise false - `boolean`"
  ([^AbstractButton this ^Boolean b]
    (-> this (.setSelected b))))

(defn get-icon
  "Returns the default icon.

  returns: the default Icon - `javax.swing.Icon`"
  (^javax.swing.Icon [^AbstractButton this]
    (-> this (.getIcon))))

(defn set-vertical-text-position
  "Sets the vertical position of the text relative to the icon.

  text-position - one of the following values: SwingConstants.CENTER (the default) SwingConstants.TOP SwingConstants.BOTTOM - `int`"
  ([^AbstractButton this ^Integer text-position]
    (-> this (.setVerticalTextPosition text-position))))

(defn do-click
  "Programmatically perform a \"click\". This does the same
   thing as if the user had pressed and released the button.
   The button stays visually \"pressed\" for pressTime
    milliseconds.

  press-time - the time to \"hold down\" the button, in milliseconds - `int`"
  ([^AbstractButton this ^Integer press-time]
    (-> this (.doClick press-time)))
  ([^AbstractButton this]
    (-> this (.doClick))))

(defn get-action
  "Returns the currently set Action for this
   ActionEvent source, or null
   if no Action is set.

  returns: the Action for this ActionEvent
            source, or null - `javax.swing.Action`"
  (^javax.swing.Action [^AbstractButton this]
    (-> this (.getAction))))

(defn get-horizontal-text-position
  "Returns the horizontal position of the text relative to the icon.

  returns: the horizontalTextPosition property,
            one of the following values:

   SwingConstants.RIGHT
   SwingConstants.LEFT
   SwingConstants.CENTER
   SwingConstants.LEADING
   SwingConstants.TRAILING (the default) - `int`"
  (^Integer [^AbstractButton this]
    (-> this (.getHorizontalTextPosition))))

(defn add-action-listener
  "Adds an ActionListener to the button.

  l - the ActionListener to be added - `java.awt.event.ActionListener`"
  ([^AbstractButton this ^java.awt.event.ActionListener l]
    (-> this (.addActionListener l))))

(defn set-rollover-selected-icon
  "Sets the rollover selected icon for the button.

  rollover-selected-icon - the icon used as the \"selected rollover\" image - `javax.swing.Icon`"
  ([^AbstractButton this ^javax.swing.Icon rollover-selected-icon]
    (-> this (.setRolloverSelectedIcon rollover-selected-icon))))

(defn set-rollover-icon
  "Sets the rollover icon for the button.

  rollover-icon - the icon used as the \"rollover\" image - `javax.swing.Icon`"
  ([^AbstractButton this ^javax.swing.Icon rollover-icon]
    (-> this (.setRolloverIcon rollover-icon))))

(defn set-border-painted
  "Sets the borderPainted property.
   If true and the button has a border,
   the border is painted. The default value for the
   borderPainted property is true.

   Some look and feels might not support
   the borderPainted property,
   in which case they ignore this.

  b - if true and border property is not null, the border is painted - `boolean`"
  ([^AbstractButton this ^Boolean b]
    (-> this (.setBorderPainted b))))

(defn set-rollover-enabled
  "Sets the rolloverEnabled property, which
   must be true for rollover effects to occur.
   The default value for the rolloverEnabled
   property is false.
   Some look and feels might not implement rollover effects;
   they will ignore this property.

  b - if true, rollover effects should be painted - `boolean`"
  ([^AbstractButton this ^Boolean b]
    (-> this (.setRolloverEnabled b))))

(defn remove-change-listener
  "Removes a ChangeListener from the button.

  l - the listener to be removed - `javax.swing.event.ChangeListener`"
  ([^AbstractButton this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn get-change-listeners
  "Returns an array of all the ChangeListeners added
   to this AbstractButton with addChangeListener().

  returns: all of the ChangeListeners added or an empty
           array if no listeners have been added - `javax.swing.event.ChangeListener[]`"
  ([^AbstractButton this]
    (-> this (.getChangeListeners))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the ButtonUI L&F object - `javax.swing.plaf.ButtonUI`"
  ([^AbstractButton this ^javax.swing.plaf.ButtonUI ui]
    (-> this (.setUI ui))))

(defn remove-notify
  "Notifies this component that it no longer has a parent component.
   When this method is invoked, any KeyboardActions
   set up in the the chain of parent components are removed.
   This method is called by the toolkit internally and should
   not be called directly by programs."
  ([^AbstractButton this]
    (-> this (.removeNotify))))

(defn get-hide-action-text?
  "Returns the value of the hideActionText property, which
   determines whether the button displays text from the
   Action.  This is useful only if an Action
   has been installed on the button.

  returns: true if the button's text
           property should not reflect that of the
           Action; the default is false - `boolean`"
  (^Boolean [^AbstractButton this]
    (-> this (.getHideActionText))))

(defn get-ui
  "Returns the L&F object that renders this component.

  returns: the ButtonUI object - `javax.swing.plaf.ButtonUI`"
  (^javax.swing.plaf.ButtonUI [^AbstractButton this]
    (-> this (.getUI))))

(defn get-action-listeners
  "Returns an array of all the ActionListeners added
   to this AbstractButton with addActionListener().

  returns: all of the ActionListeners added or an empty
           array if no listeners have been added - `java.awt.event.ActionListener[]`"
  ([^AbstractButton this]
    (-> this (.getActionListeners))))

(defn set-hide-action-text
  "Sets the hideActionText property, which determines
   whether the button displays text from the Action.
   This is useful only if an Action has been
   installed on the button.

  hide-action-text - true if the button's text property should not reflect that of the Action; the default is false - `boolean`"
  ([^AbstractButton this ^Boolean hide-action-text]
    (-> this (.setHideActionText hide-action-text))))

(defn get-label
  "Deprecated. - Replaced by getText

  returns: a String containing the label - `java.lang.String`"
  (^java.lang.String [^AbstractButton this]
    (-> this (.getLabel))))

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
   setMnemonic(KeyEvent.VK_A).

  index - Index into the String to underline - `int`

  throws: java.lang.IllegalArgumentException - will be thrown if index is >= length of the text, or < -1"
  ([^AbstractButton this ^Integer index]
    (-> this (.setDisplayedMnemonicIndex index))))

(defn get-vertical-alignment
  "Returns the vertical alignment of the text and icon.

  returns: the verticalAlignment property, one of the
            following values:

   SwingConstants.CENTER (the default)
   SwingConstants.TOP
   SwingConstants.BOTTOM - `int`"
  (^Integer [^AbstractButton this]
    (-> this (.getVerticalAlignment))))

(defn get-pressed-icon
  "Returns the pressed icon for the button.

  returns: the pressedIcon property - `javax.swing.Icon`"
  (^javax.swing.Icon [^AbstractButton this]
    (-> this (.getPressedIcon))))

(defn get-rollover-icon
  "Returns the rollover icon for the button.

  returns: the rolloverIcon property - `javax.swing.Icon`"
  (^javax.swing.Icon [^AbstractButton this]
    (-> this (.getRolloverIcon))))

(defn image-update
  "This is overridden to return false if the current Icon's
   Image is not equal to the
   passed in Image img.

  img - the Image to be compared - `java.awt.Image`
  infoflags - flags used to repaint the button when the image is updated and which determine how much is to be painted - `int`
  x - the x coordinate - `int`
  y - the y coordinate - `int`
  w - the width - `int`
  h - the height - `int`

  returns: false if the infoflags indicate that the
              image is completely loaded; true otherwise. - `boolean`"
  (^Boolean [^AbstractButton this ^java.awt.Image img ^Integer infoflags ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.imageUpdate img infoflags x y w h))))

(defn set-enabled
  "Enables (or disables) the button.

  b - true to enable the button, otherwise false - `boolean`"
  ([^AbstractButton this ^Boolean b]
    (-> this (.setEnabled b))))

(defn set-disabled-selected-icon
  "Sets the disabled selection icon for the button.

  disabled-selected-icon - the icon used as the disabled selection image - `javax.swing.Icon`"
  ([^AbstractButton this ^javax.swing.Icon disabled-selected-icon]
    (-> this (.setDisabledSelectedIcon disabled-selected-icon))))

(defn set-pressed-icon
  "Sets the pressed icon for the button.

  pressed-icon - the icon used as the \"pressed\" image - `javax.swing.Icon`"
  ([^AbstractButton this ^javax.swing.Icon pressed-icon]
    (-> this (.setPressedIcon pressed-icon))))

(defn set-multi-click-threshhold
  "Sets the amount of time (in milliseconds) required between
   mouse press events for the button to generate the corresponding
   action events.  After the initial mouse press occurs (and action
   event generated) any subsequent mouse press events which occur
   on intervals less than the threshhold will be ignored and no
   corresponding action event generated.  By default the threshhold is 0,
   which means that for each mouse press, an action event will be
   fired, no matter how quickly the mouse clicks occur.  In buttons
   where this behavior is not desirable (for example, the \"OK\" button
   in a dialog), this threshhold should be set to an appropriate
   positive value.

  threshhold - the amount of time required between mouse press events to generate corresponding action events - `long`

  throws: java.lang.IllegalArgumentException - if threshhold < 0"
  ([^AbstractButton this ^Long threshhold]
    (-> this (.setMultiClickThreshhold threshhold))))

(defn get-horizontal-alignment
  "Returns the horizontal alignment of the icon and text.
   AbstractButton's default is SwingConstants.CENTER,
   but subclasses such as JCheckBox may use a different default.

  returns: the horizontalAlignment property,
               one of the following values:

     SwingConstants.RIGHT
     SwingConstants.LEFT
     SwingConstants.CENTER
     SwingConstants.LEADING
     SwingConstants.TRAILING - `int`"
  (^Integer [^AbstractButton this]
    (-> this (.getHorizontalAlignment))))

(defn rollover-enabled?
  "Gets the rolloverEnabled property.

  returns: the value of the rolloverEnabled property - `boolean`"
  (^Boolean [^AbstractButton this]
    (-> this (.isRolloverEnabled))))

(defn selected?
  "Returns the state of the button. True if the
   toggle button is selected, false if it's not.

  returns: true if the toggle button is selected, otherwise false - `boolean`"
  (^Boolean [^AbstractButton this]
    (-> this (.isSelected))))

(defn get-selected-objects
  "Returns an array (length 1) containing the label or
   null if the button is not selected.

  returns: an array containing 1 Object: the text of the button,
           if the item is selected; otherwise null - `java.lang.Object[]`"
  ([^AbstractButton this]
    (-> this (.getSelectedObjects))))

(defn get-icon-text-gap
  "Returns the amount of space between the text and the icon
   displayed in this button.

  returns: an int equal to the number of pixels between the text
           and the icon. - `int`"
  (^Integer [^AbstractButton this]
    (-> this (.getIconTextGap))))

(defn set-selected-icon
  "Sets the selected icon for the button.

  selected-icon - the icon used as the \"selected\" image - `javax.swing.Icon`"
  ([^AbstractButton this ^javax.swing.Icon selected-icon]
    (-> this (.setSelectedIcon selected-icon))))

(defn remove-action-listener
  "Removes an ActionListener from the button.
   If the listener is the currently set Action
   for the button, then the Action
   is set to null.

  l - the listener to be removed - `java.awt.event.ActionListener`"
  ([^AbstractButton this ^java.awt.event.ActionListener l]
    (-> this (.removeActionListener l))))

(defn border-painted?
  "Gets the borderPainted property.

  returns: the value of the borderPainted property - `boolean`"
  (^Boolean [^AbstractButton this]
    (-> this (.isBorderPainted))))

(defn get-action-command
  "Returns the action command for this button.

  returns: the action command for this button - `java.lang.String`"
  (^java.lang.String [^AbstractButton this]
    (-> this (.getActionCommand))))

(defn set-action
  "Sets the Action.
   The new Action replaces any previously set
   Action but does not affect ActionListeners
   independently added with addActionListener.
   If the Action is already a registered
   ActionListener for the button, it is not re-registered.

   Setting the Action results in immediately changing
   all the properties described in
   Swing Components Supporting Action.
   Subsequently, the button's properties are automatically updated
   as the Action's properties change.

   This method uses three other methods to set
   and help track the Action's property values.
   It uses the configurePropertiesFromAction method
   to immediately change the button's properties.
   To track changes in the Action's property values,
   this method registers the PropertyChangeListener
   returned by createActionPropertyChangeListener. The
   default PropertyChangeListener invokes the
   actionPropertyChanged method when a property in the
   Action changes.

  a - the Action for the AbstractButton, or null - `javax.swing.Action`"
  ([^AbstractButton this ^javax.swing.Action a]
    (-> this (.setAction a))))

(defn set-horizontal-alignment
  "Sets the horizontal alignment of the icon and text.
   AbstractButton's default is SwingConstants.CENTER,
   but subclasses such as JCheckBox may use a different default.

  alignment - the alignment value, one of the following values: SwingConstants.RIGHT SwingConstants.LEFT SwingConstants.CENTER SwingConstants.LEADING SwingConstants.TRAILING - `int`

  throws: java.lang.IllegalArgumentException - if the alignment is not one of the valid values"
  ([^AbstractButton this ^Integer alignment]
    (-> this (.setHorizontalAlignment alignment))))

(defn get-model
  "Returns the model that this button represents.

  returns: the model property - `javax.swing.ButtonModel`"
  (^javax.swing.ButtonModel [^AbstractButton this]
    (-> this (.getModel))))

(defn get-displayed-mnemonic-index
  "Returns the character, as an index, that the look and feel should
   provide decoration for as representing the mnemonic character.

  returns: index representing mnemonic character - `int`"
  (^Integer [^AbstractButton this]
    (-> this (.getDisplayedMnemonicIndex))))

(defn set-disabled-icon
  "Sets the disabled icon for the button.

  disabled-icon - the icon used as the disabled image - `javax.swing.Icon`"
  ([^AbstractButton this ^javax.swing.Icon disabled-icon]
    (-> this (.setDisabledIcon disabled-icon))))

(defn set-model
  "Sets the model that this button represents.

  new-model - the new ButtonModel - `javax.swing.ButtonModel`"
  ([^AbstractButton this ^javax.swing.ButtonModel new-model]
    (-> this (.setModel new-model))))

(defn get-disabled-icon
  "Returns the icon used by the button when it's disabled.
   If no disabled icon has been set this will forward the call to
   the look and feel to construct an appropriate disabled Icon.

   Some look and feels might not render the disabled Icon, in which
   case they will ignore this.

  returns: the disabledIcon property - `javax.swing.Icon`"
  (^javax.swing.Icon [^AbstractButton this]
    (-> this (.getDisabledIcon))))

(defn set-content-area-filled
  "Sets the contentAreaFilled property.
   If true the button will paint the content
   area.  If you wish to have a transparent button, such as
   an icon only button, for example, then you should set
   this to false. Do not call setOpaque(false).
   The default value for the the contentAreaFilled
   property is true.

   This function may cause the component's opaque property to change.

   The exact behavior of calling this function varies on a
   component-by-component and L&F-by-L&F basis.

  b - if true, the content should be filled; if false the content area is not filled - `boolean`"
  ([^AbstractButton this ^Boolean b]
    (-> this (.setContentAreaFilled b))))

(defn set-action-command
  "Sets the action command for this button.

  action-command - the action command for this button - `java.lang.String`"
  ([^AbstractButton this ^java.lang.String action-command]
    (-> this (.setActionCommand action-command))))

(defn update-ui
  "Resets the UI property to a value from the current look
   and feel.  Subtypes of AbstractButton
   should override this to update the UI. For
   example, JButton might do the following:


        setUI((ButtonUI)UIManager.getUI(
            \"ButtonUI\", \"javax.swing.plaf.basic.BasicButtonUI\", this));"
  ([^AbstractButton this]
    (-> this (.updateUI))))

(defn set-mnemonic
  "Sets the keyboard mnemonic on the current model.
   The mnemonic is the key which when combined with the look and feel's
   mouseless modifier (usually Alt) will activate this button
   if focus is contained somewhere within this button's ancestor
   window.

   A mnemonic must correspond to a single key on the keyboard
   and should be specified using one of the VK_XXX
   keycodes defined in java.awt.event.KeyEvent.
   These codes and the wider array of codes for international
   keyboards may be obtained through
   java.awt.event.KeyEvent.getExtendedKeyCodeForChar.
   Mnemonics are case-insensitive, therefore a key event
   with the corresponding keycode would cause the button to be
   activated whether or not the Shift modifier was pressed.

   If the character defined by the mnemonic is found within
   the button's label string, the first occurrence of it
   will be underlined to indicate the mnemonic to the user.

  mnemonic - the key code which represents the mnemonic - `int`"
  ([^AbstractButton this ^Integer mnemonic]
    (-> this (.setMnemonic mnemonic))))

(defn set-label
  "Deprecated. - Replaced by setText(text)

  label - a String containing the text - `java.lang.String`"
  ([^AbstractButton this ^java.lang.String label]
    (-> this (.setLabel label))))

(defn get-item-listeners
  "Returns an array of all the ItemListeners added
   to this AbstractButton with addItemListener().

  returns: all of the ItemListeners added or an empty
           array if no listeners have been added - `java.awt.event.ItemListener[]`"
  ([^AbstractButton this]
    (-> this (.getItemListeners))))

(defn get-margin
  "Returns the margin between the button's border and
   the label.

  returns: an Insets object specifying the margin
            between the botton's border and the label - `java.awt.Insets`"
  (^java.awt.Insets [^AbstractButton this]
    (-> this (.getMargin))))

(defn focus-painted?
  "Gets the paintFocus property.

  returns: the paintFocus property - `boolean`"
  (^Boolean [^AbstractButton this]
    (-> this (.isFocusPainted))))

