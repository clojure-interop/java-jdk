(ns javax.swing.plaf.synth.SynthLookAndFeel
  "SynthLookAndFeel provides the basis for creating a customized look and
  feel. SynthLookAndFeel does not directly provide a look, all painting is
  delegated.
  You need to either provide a configuration file, by way of the
  load(java.io.InputStream, java.lang.Class<?>) method, or provide your own SynthStyleFactory
  to setStyleFactory(javax.swing.plaf.synth.SynthStyleFactory). Refer to the
  package summary for an example of
  loading a file, and SynthStyleFactory for
  an example of providing your own SynthStyleFactory to
  setStyleFactory.

  Warning:
  This class implements Serializable as a side effect of it
  extending BasicLookAndFeel. It is not intended to be serialized.
  An attempt to serialize it will
  result in NotSerializableException."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthLookAndFeel]))

(defn ->synth-look-and-feel
  "Constructor.

  Creates a SynthLookAndFeel.

   For the returned SynthLookAndFeel to be useful you need to
   invoke load to specify the set of
   SynthStyles, or invoke setStyleFactory."
  ([]
    (new SynthLookAndFeel )))

(defn *set-style-factory
  "Sets the SynthStyleFactory that the UI classes provided by
   synth will use to obtain a SynthStyle.

  cache - SynthStyleFactory the UIs should use. - `javax.swing.plaf.synth.SynthStyleFactory`"
  ([^javax.swing.plaf.synth.SynthStyleFactory cache]
    (SynthLookAndFeel/setStyleFactory cache)))

(defn *get-style-factory
  "Returns the current SynthStyleFactory.

  returns: SynthStyleFactory - `javax.swing.plaf.synth.SynthStyleFactory`"
  (^javax.swing.plaf.synth.SynthStyleFactory []
    (SynthLookAndFeel/getStyleFactory )))

(defn *get-style
  "Gets a SynthStyle for the specified region of the specified component.
   This is not for general consumption, only custom UIs should call this
   method.

  c - JComponent to get the SynthStyle for - `javax.swing.JComponent`
  region - Identifies the region of the specified component - `javax.swing.plaf.synth.Region`

  returns: SynthStyle to use. - `javax.swing.plaf.synth.SynthStyle`"
  (^javax.swing.plaf.synth.SynthStyle [^javax.swing.JComponent c ^javax.swing.plaf.synth.Region region]
    (SynthLookAndFeel/getStyle c region)))

(defn *update-styles
  "Updates the style associated with c, and all its children.
   This is a lighter version of
   SwingUtilities.updateComponentTreeUI.

  c - Component to update style for. - `java.awt.Component`"
  ([^java.awt.Component c]
    (SynthLookAndFeel/updateStyles c)))

(defn *get-region
  "Returns the Region for the JComponent c.

  c - JComponent to fetch the Region for - `javax.swing.JComponent`

  returns: Region corresponding to c - `javax.swing.plaf.synth.Region`"
  (^javax.swing.plaf.synth.Region [^javax.swing.JComponent c]
    (SynthLookAndFeel/getRegion c)))

(defn *create-ui
  "Creates the Synth look and feel ComponentUI for
   the passed in JComponent.

  c - JComponent to create the ComponentUI for - `javax.swing.JComponent`

  returns: ComponentUI to use for c - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (SynthLookAndFeel/createUI c)))

(defn uninitialize
  "Called by UIManager when this look and feel is uninstalled."
  ([^javax.swing.plaf.synth.SynthLookAndFeel this]
    (-> this (.uninitialize))))

(defn load
  "Loads the set of SynthStyles that will be used by
   this SynthLookAndFeel. resourceBase is
   used to resolve any path based resources, for example an
   Image would be resolved by
   resourceBase.getResource(path). Refer to
   Synth File Format
   for more information.

  input - InputStream to load from - `java.io.InputStream`
  resource-base - used to resolve any images or other resources - `java.lang.Class<?>`

  throws: java.text.ParseException - if there is an error in parsing"
  ([^javax.swing.plaf.synth.SynthLookAndFeel this ^java.io.InputStream input ^java.lang.Class resource-base]
    (-> this (.load input resource-base)))
  ([^javax.swing.plaf.synth.SynthLookAndFeel this ^java.net.URL url]
    (-> this (.load url))))

(defn get-defaults
  "Returns the defaults for this SynthLookAndFeel.

  returns: Defaults table. - `javax.swing.UIDefaults`"
  (^javax.swing.UIDefaults [^javax.swing.plaf.synth.SynthLookAndFeel this]
    (-> this (.getDefaults))))

(defn get-name
  "Return a short string that identifies this look and feel.

  returns: a short string identifying this look and feel. - `java.lang.String`"
  (^java.lang.String [^javax.swing.plaf.synth.SynthLookAndFeel this]
    (-> this (.getName))))

(defn get-description
  "Returns a textual description of SynthLookAndFeel.

  returns: textual description of synth. - `java.lang.String`"
  (^java.lang.String [^javax.swing.plaf.synth.SynthLookAndFeel this]
    (-> this (.getDescription))))

(defn supported-look-and-feel?
  "Returns true, SynthLookAndFeel is always supported.

  returns: true. - `boolean`"
  (^Boolean [^javax.swing.plaf.synth.SynthLookAndFeel this]
    (-> this (.isSupportedLookAndFeel))))

(defn should-update-style-on-ancestor-changed?
  "Returns whether or not the UIs should update their
   SynthStyles from the SynthStyleFactory
   when the ancestor of the JComponent changes. A subclass
   that provided a SynthStyleFactory that based the
   return value from getStyle off the containment hierarchy
   would override this method to return true.

  returns: whether or not the UIs should update their
   SynthStyles from the SynthStyleFactory
   when the ancestor changed. - `boolean`"
  (^Boolean [^javax.swing.plaf.synth.SynthLookAndFeel this]
    (-> this (.shouldUpdateStyleOnAncestorChanged))))

(defn initialize
  "Called by UIManager when this look and feel is installed."
  ([^javax.swing.plaf.synth.SynthLookAndFeel this]
    (-> this (.initialize))))

(defn native-look-and-feel?
  "Returns false, SynthLookAndFeel is not a native look and feel.

  returns: false - `boolean`"
  (^Boolean [^javax.swing.plaf.synth.SynthLookAndFeel this]
    (-> this (.isNativeLookAndFeel))))

(defn get-id
  "Return a string that identifies this look and feel.

  returns: a short string identifying this look and feel. - `java.lang.String`"
  (^java.lang.String [^javax.swing.plaf.synth.SynthLookAndFeel this]
    (-> this (.getID))))

