(ns javax.swing.plaf.nimbus.NimbusLookAndFeel
  "The NimbusLookAndFeel class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.nimbus NimbusLookAndFeel]))

(defn ->nimbus-look-and-feel
  "Constructor.

  Create a new NimbusLookAndFeel."
  (^NimbusLookAndFeel []
    (new NimbusLookAndFeel )))

(defn *get-style
  "Gets the style associated with the given component and region. This
   will never return null. If an appropriate component and region cannot
   be determined, then a default style is returned.

  c - a non-null reference to a JComponent - `javax.swing.JComponent`
  r - a non-null reference to the region of the component c - `javax.swing.plaf.synth.Region`

  returns: a non-null reference to a NimbusStyle. - `javax.swing.plaf.nimbus.NimbusStyle`"
  (^javax.swing.plaf.nimbus.NimbusStyle [^javax.swing.JComponent c ^javax.swing.plaf.synth.Region r]
    (NimbusLookAndFeel/getStyle c r)))

(defn uninitialize
  "Called by UIManager when this look and feel is uninstalled."
  ([^NimbusLookAndFeel this]
    (-> this (.uninitialize))))

(defn get-defaults
  "Returns the defaults for this SynthLookAndFeel.

  returns: Defaults table. - `javax.swing.UIDefaults`"
  (^javax.swing.UIDefaults [^NimbusLookAndFeel this]
    (-> this (.getDefaults))))

(defn get-derived-color
  "Get a derived color, derived colors are shared instances and is color
   value will change when its parent UIDefault color changes.

  ui-default-parent-name - The parent UIDefault key - `java.lang.String`
  h-offset - The hue offset - `float`
  s-offset - The saturation offset - `float`
  b-offset - The brightness offset - `float`
  a-offset - The alpha offset - `int`
  ui-resource - True if the derived color should be a UIResource, false if it should not be - `boolean`

  returns: The stored derived color - `java.awt.Color`"
  (^java.awt.Color [^NimbusLookAndFeel this ^java.lang.String ui-default-parent-name ^Float h-offset ^Float s-offset ^Float b-offset ^Integer a-offset ^Boolean ui-resource]
    (-> this (.getDerivedColor ui-default-parent-name h-offset s-offset b-offset a-offset ui-resource))))

(defn get-name
  "Return a short string that identifies this look and feel. This
   String will be the unquoted String `Nimbus`.

  returns: a short string identifying this look and feel. - `java.lang.String`"
  (^java.lang.String [^NimbusLookAndFeel this]
    (-> this (.getName))))

(defn get-description
  "Returns a textual description of this look and feel.

  returns: textual description of this look and feel. - `java.lang.String`"
  (^java.lang.String [^NimbusLookAndFeel this]
    (-> this (.getDescription))))

(defn register
  "Registers a third party component with the NimbusLookAndFeel.

   Regions represent Components and areas within Components that act as
   independent painting areas. Once registered with the NimbusLookAndFeel,
   NimbusStyles for these Regions can be retrieved via the
   getStyle method.

   The NimbusLookAndFeel uses a standard naming scheme for entries in the
   UIDefaults table. The key for each property, state, painter, and other
   default registered in UIDefaults for a specific Region will begin with
   the specified prefix

   For example, suppose I had a component named JFoo. Suppose I then registered
   this component with the NimbusLookAndFeel in this manner:



       laf.register(NimbusFooUI.FOO_REGION, `Foo`);

   In this case, I could then register properties for this component with
   UIDefaults in the following manner:



       UIManager.put(`Foo.background`, new ColorUIResource(Color.BLACK));
       UIManager.put(`Foo.Enabled.backgroundPainter`, new FooBackgroundPainter());

   It is also possible to register a named component with Nimbus.
   For example, suppose you wanted to style the background of a JPanel
   named `MyPanel` differently from other JPanels. You could accomplish this
   by doing the following:



       laf.register(Region.PANEL, ``MyPanel``);
       UIManager.put(``MyPanel`.background`, new ColorUIResource(Color.RED));

  region - The Synth Region that is being registered. Such as Button, or ScrollBarThumb, or NimbusFooUI.FOO_REGION. - `javax.swing.plaf.synth.Region`
  prefix - The UIDefault prefix. For example, could be ComboBox, or if a named components, `MyComboBox`, or even something like ToolBar.`MyComboBox`.`ComboBox.arrowButton` - `java.lang.String`"
  ([^NimbusLookAndFeel this ^javax.swing.plaf.synth.Region region ^java.lang.String prefix]
    (-> this (.register region prefix))))

(defn should-update-style-on-ancestor-changed?
  "Returns whether or not the UIs should update their
   SynthStyles from the SynthStyleFactory
   when the ancestor of the JComponent changes. A subclass
   that provided a SynthStyleFactory that based the
   return value from getStyle off the containment hierarchy
   would override this method to return true.

  returns: true - `boolean`"
  (^Boolean [^NimbusLookAndFeel this]
    (-> this (.shouldUpdateStyleOnAncestorChanged))))

(defn initialize
  "Called by UIManager when this look and feel is installed."
  ([^NimbusLookAndFeel this]
    (-> this (.initialize))))

(defn get-id
  "Return a string that identifies this look and feel. This String will
   be the unquoted String `Nimbus`.

  returns: a short string identifying this look and feel. - `java.lang.String`"
  (^java.lang.String [^NimbusLookAndFeel this]
    (-> this (.getID))))

(defn get-disabled-icon
  "Description copied from class: LookAndFeel

  component - JComponent that will display the Icon, may be null - `javax.swing.JComponent`
  icon - Icon to generate the disabled icon from - `javax.swing.Icon`

  returns: disabled Icon, or null if a suitable
           Icon can not be generated - `javax.swing.Icon`"
  (^javax.swing.Icon [^NimbusLookAndFeel this ^javax.swing.JComponent component ^javax.swing.Icon icon]
    (-> this (.getDisabledIcon component icon))))

