(ns javax.swing.plaf.synth.SynthStyle
  "SynthStyle is a set of style properties.
  Each SynthUI references at least one
  SynthStyle that is obtained using a
  SynthStyleFactory. You typically don't need to interact with
  this class directly, rather you will load a
  Synth File Format file into
  SynthLookAndFeel that will create a set of SynthStyles."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthStyle]))

(defn ->synth-style
  "Constructor.

  Constructs a SynthStyle."
  ([]
    (new SynthStyle )))

(defn opaque?
  "Returns true if the region is opaque.

  context - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`

  returns: true if region is opaque. - `boolean`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context]
    (-> this (.isOpaque context))))

(defn get-insets
  "Returns the Insets that are used to calculate sizing information.

  context - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`
  insets - Insets to place return value in. - `java.awt.Insets`

  returns: Sizing Insets. - `java.awt.Insets`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Insets insets]
    (-> this (.getInsets context insets))))

(defn get-painter
  "Returns the SynthPainter that will be used for painting.
   This may return null.

  context - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`

  returns: SynthPainter to use - `javax.swing.plaf.synth.SynthPainter`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context]
    (-> this (.getPainter context))))

(defn get-string
  "Convenience method to get a specific style property whose value is
   a String.

  context - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`
  key - Property being requested. - `java.lang.Object`
  default-value - Value to return if the property has not been specified, or is not a String - `java.lang.String`

  returns: Value of the named property - `java.lang.String`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context ^java.lang.Object key ^java.lang.String default-value]
    (-> this (.getString context key default-value))))

(defn get-icon
  "Convenience method to get a specific style property whose value is
   an Icon.

  context - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`
  key - Property being requested. - `java.lang.Object`

  returns: Value of the named property, or null if not specified - `javax.swing.Icon`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context ^java.lang.Object key]
    (-> this (.getIcon context key))))

(defn get-int
  "Convenience method to get a specific style property whose value is
   a Number. If the value is a Number,
   intValue is returned, otherwise defaultValue
   is returned.

  context - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`
  key - Property being requested. - `java.lang.Object`
  default-value - Value to return if the property has not been specified, or is not a Number - `int`

  returns: Value of the named property - `int`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context ^java.lang.Object key ^Integer default-value]
    (-> this (.getInt context key default-value))))

(defn uninstall-defaults
  "Uninstalls any state that this style installed on
   the JComponent from context.

   Styles should NOT depend upon this being called, in certain cases
   it may never be called.

  context - SynthContext identifying component to install properties to. - `javax.swing.plaf.synth.SynthContext`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context]
    (-> this (.uninstallDefaults context))))

(defn get-graphics-utils
  "Returns the SynthGraphicUtils for the specified context.

  context - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`

  returns: SynthGraphicsUtils - `javax.swing.plaf.synth.SynthGraphicsUtils`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context]
    (-> this (.getGraphicsUtils context))))

(defn get-font
  "Returns the Font for the specified state. This redirects to the
   JComponent from the context as necessary.
   If this does not redirect
   to the JComponent getFontForState(javax.swing.plaf.synth.SynthContext) is invoked.

  context - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`

  returns: Font to render with - `java.awt.Font`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context]
    (-> this (.getFont context))))

(defn get-boolean?
  "Convenience method to get a specific style property whose value is
   an Boolean.

  context - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`
  key - Property being requested. - `java.lang.Object`
  default-value - Value to return if the property has not been specified, or is not a Boolean - `boolean`

  returns: Value of the named property - `boolean`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context ^java.lang.Object key ^Boolean default-value]
    (-> this (.getBoolean context key default-value))))

(defn get-color
  "Returns the color for the specified state. This gives precedence to
   foreground and background of the JComponent. If the
   Color from the JComponent is not appropriate,
   or not used, this will invoke getColorForState. Subclasses
   should generally not have to override this, instead override
   getColorForState(javax.swing.plaf.synth.SynthContext, javax.swing.plaf.synth.ColorType).

  context - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`
  type - Type of color being requested. - `javax.swing.plaf.synth.ColorType`

  returns: Color - `java.awt.Color`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context ^javax.swing.plaf.synth.ColorType type]
    (-> this (.getColor context type))))

(defn get
  "Getter for a region specific style property.

  context - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`
  key - Property being requested. - `java.lang.Object`

  returns: Value of the named property - `java.lang.Object`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context ^java.lang.Object key]
    (-> this (.get context key))))

(defn install-defaults
  "Installs the necessary state from this Style on the
   JComponent from context.

  context - SynthContext identifying component to install properties to. - `javax.swing.plaf.synth.SynthContext`"
  ([^javax.swing.plaf.synth.SynthStyle this ^javax.swing.plaf.synth.SynthContext context]
    (-> this (.installDefaults context))))

