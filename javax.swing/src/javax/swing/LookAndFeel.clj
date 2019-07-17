(ns javax.swing.LookAndFeel
  "LookAndFeel, as the name implies, encapsulates a look and
  feel. Beyond installing a look and feel most developers never need to
  interact directly with LookAndFeel. In general only developers
  creating a custom look and feel need to concern themselves with this class.

  Swing is built upon the foundation that each JComponent
  subclass has an implementation of a specific ComponentUI
  subclass. The ComponentUI is often referred to as `the ui`,
  `component ui`, or `look and feel delegate`. The ComponentUI
  subclass is responsible for providing the look and feel specific
  functionality of the component. For example, JTree requires
  an implementation of the ComponentUI subclass TreeUI. The implementation of the specific ComponentUI subclass is provided by the LookAndFeel. Each
  JComponent subclass identifies the ComponentUI
  subclass it requires by way of the JComponent method getUIClassID.

  Each LookAndFeel implementation must provide
  an implementation of the appropriate ComponentUI subclass by
  specifying a value for each of Swing's ui class ids in the UIDefaults object returned from getDefaults. For example,
  BasicLookAndFeel uses BasicTreeUI as the concrete
  implementation for TreeUI. This is accomplished by BasicLookAndFeel providing the key-value pair `TreeUI`-`javax.swing.plaf.basic.BasicTreeUI`, in the
  UIDefaults returned from getDefaults. Refer to
  UIDefaults.getUI(JComponent) for details on how the implementation
  of the ComponentUI subclass is obtained.

  When a LookAndFeel is installed the UIManager does
  not check that an entry exists for all ui class ids. As such,
  random exceptions will occur if the current look and feel has not
  provided a value for a particular ui class id and an instance of
  the JComponent subclass is created.

  Recommendations for Look and Feels

  As noted in UIManager each LookAndFeel has the opportunity
  to provide a set of defaults that are layered in with developer and
  system defaults. Some of Swing's components require the look and feel
  to provide a specific set of defaults. These are documented in the
  classes that require the specific default.

  ComponentUIs and defaults

  All ComponentUIs typically need to set various properties
  on the JComponent the ComponentUI is providing the
  look and feel for. This is typically done when the ComponentUI is installed on the JComponent. Setting a
  property should only be done if the developer has not set the
  property. For non-primitive values it is recommended that the
  ComponentUI only change the property on the JComponent if the current value is null or implements
  UIResource. If the current value is null or
  implements UIResource it indicates the property has not
  been set by the developer, and the ui is free to change it.  For
  example, BasicButtonUI.installDefaults only changes the
  font on the JButton if the return value from button.getFont() is null or implements UIResource. On the other hand if button.getFont() returned
  a non-null value that did not implement UIResource
  then BasicButtonUI.installDefaults would not change the
  JButton's font.

  For primitive values, such as opaque, the method installProperty should be invoked.  installProperty only changes
  the corresponding property if the value has not been changed by the
  developer.

  ComponentUI implementations should use the various install methods
  provided by this class as they handle the necessary checking and install
  the property using the recommended guidelines.

  Exceptions

  All of the install methods provided by LookAndFeel need to
  access the defaults if the value of the property being changed is
  null or a UIResource. For example, installing the
  font does the following:


    JComponent c;
    Font font = c.getFont();
    if (font == null || (font instanceof UIResource)) {
        c.setFont(UIManager.getFont(`fontKey`));
    }
  If the font is null or a UIResource, the
  defaults table is queried with the key fontKey. All of
  UIDefault's get methods throw a NullPointerException if passed in null. As such, unless
  otherwise noted each of the various install methods of LookAndFeel throw a NullPointerException if the current
  value is null or a UIResource and the supplied
  defaults key is null. In addition, unless otherwise specified
  all of the install methods throw a NullPointerException if
  a null component is passed in."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing LookAndFeel]))

(defn ->look-and-feel
  "Constructor."
  ([]
    (new LookAndFeel )))

(defn *make-key-bindings
  "Convenience method for building an array of KeyBindings. While this method is not deprecated, developers
   should instead use ActionMap and InputMap for
   supplying key bindings.

   This method returns an array of KeyBindings, one for each
   alternating key-action pair in keyBindingList.
   A key can either be a String in the format
   specified by the KeyStroke.getKeyStroke method, or
   a KeyStroke. The action part of the pair is a
   String that corresponds to the name of the Action.

   The following example illustrates creating a KeyBinding array
   from six alternating key-action pairs:


    JTextComponent.KeyBinding[] multilineBindings = makeKeyBindings( new Object[] {
            `UP`, DefaultEditorKit.upAction,
          `DOWN`, DefaultEditorKit.downAction,
       `PAGE_UP`, DefaultEditorKit.pageUpAction,
     `PAGE_DOWN`, DefaultEditorKit.pageDownAction,
         `ENTER`, DefaultEditorKit.insertBreakAction,
           `TAB`, DefaultEditorKit.insertTabAction
    });
   If keyBindingList's length is odd, the last element is
   ignored.

   Supplying a null value for either the key or
   action part of the key-action pair results in
   creating a KeyBinding with the corresponding value
   null. As other parts of Swing's expect non-null values
   in a KeyBinding, you should avoid supplying null as
   either the key or action part of the key-action
   pair.

  key-binding-list - an array of key-action pairs - `java.lang.Object[]`

  returns: an array of KeyBindings - `javax.swing.text.JTextComponent.KeyBinding[]`

  throws: java.lang.NullPointerException - if keyBindingList is null"
  ([key-binding-list]
    (LookAndFeel/makeKeyBindings key-binding-list)))

(defn *make-input-map
  "Creates a InputMapUIResource from keys. This is
   a convenience method for creating a new InputMapUIResource,
   invoking loadKeyBindings(map, keys), and returning the
   InputMapUIResource.

  keys - alternating pairs of keystroke-action key pairs as described in loadKeyBindings(javax.swing.InputMap, java.lang.Object[]) - `java.lang.Object[]`

  returns: newly created and populated InputMapUIResource - `javax.swing.InputMap`"
  (^javax.swing.InputMap [keys]
    (LookAndFeel/makeInputMap keys)))

(defn *make-component-input-map
  "Creates a ComponentInputMapUIResource from
   keys. This is a convenience method for creating a
   new ComponentInputMapUIResource, invoking loadKeyBindings(map, keys), and returning the ComponentInputMapUIResource.

  c - component to create the ComponentInputMapUIResource with - `javax.swing.JComponent`
  keys - alternating pairs of keystroke-action key pairs as described in loadKeyBindings(javax.swing.InputMap, java.lang.Object[]) - `java.lang.Object[]`

  returns: newly created and populated InputMapUIResource - `javax.swing.ComponentInputMap`

  throws: java.lang.IllegalArgumentException - if c is null"
  (^javax.swing.ComponentInputMap [^javax.swing.JComponent c keys]
    (LookAndFeel/makeComponentInputMap c keys)))

(defn *install-colors
  "Convenience method for setting a component's foreground
   and background color properties with values from the
   defaults.  The properties are only set if the current
   value is either null or a UIResource.

  c - component to set the colors on - `javax.swing.JComponent`
  default-bg-name - key for the background - `java.lang.String`
  default-fg-name - key for the foreground - `java.lang.String`

  throws: java.lang.NullPointerException - as described in exceptions"
  ([^javax.swing.JComponent c ^java.lang.String default-bg-name ^java.lang.String default-fg-name]
    (LookAndFeel/installColors c default-bg-name default-fg-name)))

(defn *get-desktop-property-value
  "Returns the value of the specified system desktop property by
   invoking Toolkit.getDefaultToolkit().getDesktopProperty().
   If the value of the specified property is null,
   fallbackValue is returned.

  system-property-name - the name of the system desktop property being queried - `java.lang.String`
  fallback-value - the object to be returned as the value if the system value is null - `java.lang.Object`

  returns: the current value of the desktop property - `java.lang.Object`"
  (^java.lang.Object [^java.lang.String system-property-name ^java.lang.Object fallback-value]
    (LookAndFeel/getDesktopPropertyValue system-property-name fallback-value)))

(defn *uninstall-border
  "Convenience method for uninstalling a border. If the border of
   the component is a UIResource, it is set to null.

  c - component to uninstall the border on - `javax.swing.JComponent`

  throws: java.lang.NullPointerException - if c is null"
  ([^javax.swing.JComponent c]
    (LookAndFeel/uninstallBorder c)))

(defn *load-key-bindings
  "Populates an InputMap with the specified bindings.
   The bindings are supplied as a list of alternating
   keystroke-action key pairs. The keystroke is either
   an instance of KeyStroke, or a String
   that identifies the KeyStroke for the binding. Refer
   to KeyStroke.getKeyStroke(String) for the specific
   format. The action key part of the pair is the key
   registered in the InputMap for the KeyStroke.

   The following illustrates loading an InputMap with two
   key-action pairs:


     LookAndFeel.loadKeyBindings(inputMap, new Object[] {
       `control X`, `cut`,
       `control V`, `paste`
     });

   Supplying a null list of bindings (keys) does not
   change retMap in any way.

   Specifying a null action key results in
   removing the keystroke's entry from the InputMap.
   A null keystroke is ignored.

  ret-map - InputMap to add the key-action pairs to - `javax.swing.InputMap`
  keys - bindings to add to retMap - `java.lang.Object[]`

  throws: java.lang.NullPointerException - if keys is non-null, not empty, and retMap is null"
  ([^javax.swing.InputMap ret-map keys]
    (LookAndFeel/loadKeyBindings ret-map keys)))

(defn *install-border
  "Convenience method for setting a component's border property with
   a value from the defaults. The border is only set if the border is
   null or an instance of UIResource.

  c - component to set the border on - `javax.swing.JComponent`
  default-border-name - key specifying the border - `java.lang.String`

  throws: java.lang.NullPointerException - as described in exceptions"
  ([^javax.swing.JComponent c ^java.lang.String default-border-name]
    (LookAndFeel/installBorder c default-border-name)))

(defn *install-property
  "Convenience method for installing a property with the specified name
   and value on a component if that property has not already been set
   by the developer.  This method is intended to be used by
   ui delegate instances that need to specify a default value for a
   property of primitive type (boolean, int, ..), but do not wish
   to override a value set by the client.  Since primitive property
   values cannot be wrapped with the UIResource marker, this method
   uses private state to determine whether the property has been set
   by the client.

  c - target component to set the property on - `javax.swing.JComponent`
  property-name - name of the property to set - `java.lang.String`
  property-value - value of the property - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the specified property is not one which can be set using this method"
  ([^javax.swing.JComponent c ^java.lang.String property-name ^java.lang.Object property-value]
    (LookAndFeel/installProperty c property-name property-value)))

(defn *install-colors-and-font
  "Convenience method for setting a component's foreground,
   background and font properties with values from the
   defaults.  The properties are only set if the current
   value is either null or a UIResource.

  c - component set to the colors and font on - `javax.swing.JComponent`
  default-bg-name - key for the background - `java.lang.String`
  default-fg-name - key for the foreground - `java.lang.String`
  default-font-name - key for the font - `java.lang.String`

  throws: java.lang.NullPointerException - as described in exceptions"
  ([^javax.swing.JComponent c ^java.lang.String default-bg-name ^java.lang.String default-fg-name ^java.lang.String default-font-name]
    (LookAndFeel/installColorsAndFont c default-bg-name default-fg-name default-font-name)))

(defn *make-icon
  "Creates and returns a UIDefault.LazyValue that loads an
   image. The returned value is an implementation of UIDefaults.LazyValue. When createValue is invoked on
   the returned object, the image is loaded. If the image is non-null, it is then wrapped in an Icon that implements UIResource. The image is loaded using Class.getResourceAsStream(gifFile).

   This method does not check the arguments in any way. It is
   strongly recommended that non-null values are supplied else
   exceptions may occur when createValue is invoked on the
   returned object.

  base-class - Class used to load the resource - `java.lang.Class<?>`
  gif-file - path to the image to load - `java.lang.String`

  returns: a UIDefaults.LazyValue; when resolved the
           LazyValue loads the specified image - `java.lang.Object`"
  (^java.lang.Object [^java.lang.Class base-class ^java.lang.String gif-file]
    (LookAndFeel/makeIcon base-class gif-file)))

(defn get-disabled-selected-icon
  "Returns an Icon for use by disabled
   components that are also selected. This method is used to generate an
   Icon for components that are in both the disabled and
   selected states but do not have a specific Icon for this
   state.  For example, if you create a JButton and only
   specify an Icon via setIcon this method
   will be called to generate the disabled and selected
   Icon. If null is passed as icon this
   methods returns null.

   Some look and feels might not render the disabled and selected
   Icon, in which case they will ignore this.

  component - JComponent that will display the Icon, may be null - `javax.swing.JComponent`
  icon - Icon to generate disabled and selected icon from - `javax.swing.Icon`

  returns: disabled and selected icon, or null if a suitable
           Icon can not be generated. - `javax.swing.Icon`"
  (^javax.swing.Icon [^javax.swing.LookAndFeel this ^javax.swing.JComponent component ^javax.swing.Icon icon]
    (-> this (.getDisabledSelectedIcon component icon))))

(defn uninitialize
  "Uninitializes the look and feel. While this method is public,
   it should only be invoked by the UIManager when
   the look and feel is uninstalled. For example,
   UIManager.setLookAndFeel invokes this when the look and
   feel is changed.

   Subclasses may choose to free up some resources here."
  ([^javax.swing.LookAndFeel this]
    (-> this (.uninitialize))))

(defn get-supports-window-decorations?
  "Returns true if the LookAndFeel returned
   RootPaneUI instances support providing Window
   decorations in a JRootPane.

   The default implementation returns false, subclasses that
   support Window decorations should override this and return
   true.

  returns: true if the RootPaneUI instances created by
           this look and feel support client side decorations - `boolean`"
  (^Boolean [^javax.swing.LookAndFeel this]
    (-> this (.getSupportsWindowDecorations))))

(defn get-defaults
  "Returns the look and feel defaults. While this method is public,
   it should only be invoked by the UIManager when the
   look and feel is set as the current look and feel and after
   initialize has been invoked.

  returns: the look and feel defaults - `javax.swing.UIDefaults`"
  (^javax.swing.UIDefaults [^javax.swing.LookAndFeel this]
    (-> this (.getDefaults))))

(defn to-string
  "Returns a string that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  (^java.lang.String [^javax.swing.LookAndFeel this]
    (-> this (.toString))))

(defn get-name
  "Return a short string that identifies this look and feel, e.g.
   `CDE/Motif`.  This string should be appropriate for a menu item.
   Distinct look and feels should have different names, e.g.
   a subclass of MotifLookAndFeel that changes the way a few components
   are rendered should be called `CDE/Motif My Way`; something
   that would be useful to a user trying to select a L&F from a list
   of names.

  returns: short identifier for the look and feel - `java.lang.String`"
  (^java.lang.String [^javax.swing.LookAndFeel this]
    (-> this (.getName))))

(defn get-layout-style
  "Returns the LayoutStyle for this look
   and feel.  This never returns null.

   You generally don't use the LayoutStyle from
   the look and feel, instead use the LayoutStyle
   method getInstance.

  returns: the LayoutStyle for this look and feel - `javax.swing.LayoutStyle`"
  (^javax.swing.LayoutStyle [^javax.swing.LookAndFeel this]
    (-> this (.getLayoutStyle))))

(defn get-description
  "Return a one line description of this look and feel implementation,
   e.g. `The CDE/Motif Look and Feel`.   This string is intended for
   the user, e.g. in the title of a window or in a ToolTip message.

  returns: short description for the look and feel - `java.lang.String`"
  (^java.lang.String [^javax.swing.LookAndFeel this]
    (-> this (.getDescription))))

(defn supported-look-and-feel?
  "Return true if the underlying platform supports and or permits
   this look and feel.  This method returns false if the look
   and feel depends on special resources or legal agreements that
   aren't defined for the current platform.

  returns: true if this is a supported look and feel - `boolean`"
  (^Boolean [^javax.swing.LookAndFeel this]
    (-> this (.isSupportedLookAndFeel))))

(defn provide-error-feedback
  "Invoked when the user attempts an invalid operation,
   such as pasting into an uneditable JTextField
   that has focus. The default implementation beeps. Subclasses
   that wish different behavior should override this and provide
   the additional feedback.

  component - the Component the error occurred in, may be null indicating the error condition is not directly associated with a Component - `java.awt.Component`"
  ([^javax.swing.LookAndFeel this ^java.awt.Component component]
    (-> this (.provideErrorFeedback component))))

(defn initialize
  "Initializes the look and feel. While this method is public,
   it should only be invoked by the UIManager when a
   look and feel is installed as the current look and feel. This
   method is invoked before the UIManager invokes
   getDefaults. This method is intended to perform any
   initialization for the look and feel. Subclasses
   should do any one-time setup they need here, rather than
   in a static initializer, because look and feel class objects
   may be loaded just to discover that isSupportedLookAndFeel()
   returns false."
  ([^javax.swing.LookAndFeel this]
    (-> this (.initialize))))

(defn native-look-and-feel?
  "If the underlying platform has a `native` look and feel, and
   this is an implementation of it, return true.  For
   example, when the underlying platform is Solaris running CDE
   a CDE/Motif look and feel implementation would return true.

  returns: true if this look and feel represents the underlying
           platform look and feel - `boolean`"
  (^Boolean [^javax.swing.LookAndFeel this]
    (-> this (.isNativeLookAndFeel))))

(defn get-id
  "Return a string that identifies this look and feel.  This string
   will be used by applications/services that want to recognize
   well known look and feel implementations.  Presently
   the well known names are `Motif`, `Windows`, `Mac`, `Metal`.  Note
   that a LookAndFeel derived from a well known superclass
   that doesn't make any fundamental changes to the look or feel
   shouldn't override this method.

  returns: identifier for the look and feel - `java.lang.String`"
  (^java.lang.String [^javax.swing.LookAndFeel this]
    (-> this (.getID))))

(defn get-disabled-icon
  "Returns an Icon with a disabled appearance.
   This method is used to generate a disabled Icon when
   one has not been specified.  For example, if you create a
   JButton and only specify an Icon via
   setIcon this method will be called to generate the
   disabled Icon. If null is passed as
   icon this method returns null.

   Some look and feels might not render the disabled Icon, in which
   case they will ignore this.

  component - JComponent that will display the Icon, may be null - `javax.swing.JComponent`
  icon - Icon to generate the disabled icon from - `javax.swing.Icon`

  returns: disabled Icon, or null if a suitable
           Icon can not be generated - `javax.swing.Icon`"
  (^javax.swing.Icon [^javax.swing.LookAndFeel this ^javax.swing.JComponent component ^javax.swing.Icon icon]
    (-> this (.getDisabledIcon component icon))))

