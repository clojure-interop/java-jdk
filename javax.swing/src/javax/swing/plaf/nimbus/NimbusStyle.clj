(ns javax.swing.plaf.nimbus.NimbusStyle
  "A SynthStyle implementation used by Nimbus. Each Region that has been
  registered with the NimbusLookAndFeel will have an associated NimbusStyle.
  Third party components that are registered with the NimbusLookAndFeel will
  therefore be handed a NimbusStyle from the look and feel from the
  #getStyle(JComponent, Region) method.

  This class properly reads and retrieves values placed in the UIDefaults
  according to the standard Nimbus naming conventions. It will create and
  retrieve painters, fonts, colors, and other data stored there.

  NimbusStyle also supports the ability to override settings on a per
  component basis. NimbusStyle checks the component's client property map for
  `Nimbus.Overrides`. If the value associated with this key is an instance of
  UIDefaults, then the values in that defaults table will override the standard
  Nimbus defaults in UIManager, but for that component instance only.

  Optionally, you may specify the client property
  `Nimbus.Overrides.InheritDefaults`. If true, this client property indicates
  that the defaults located in UIManager should first be read, and then
  replaced with defaults located in the component client properties. If false,
  then only the defaults located in the component client property map will
  be used. If not specified, it is assumed to be true.

  You must specify `Nimbus.Overrides` for `Nimbus.Overrides.InheritDefaults`
  to have any effect. `Nimbus.Overrides` indicates whether there are any
  overrides, while `Nimbus.Overrides.InheritDefaults` indicates whether those
  overrides should first be initialized with the defaults from UIManager.

  The NimbusStyle is reloaded whenever a property change event is fired
  for a component for `Nimbus.Overrides` or `Nimbus.Overrides.InheritDefaults`.
  So for example, setting a new UIDefaults on a component would cause the
  style to be reloaded.

  The values are only read out of UIManager once, and then cached. If
  you need to read the values again (for example, if the UI is being reloaded),
  then discard this NimbusStyle and read a new one from NimbusLookAndFeel
  using NimbusLookAndFeel.getStyle.

  The primary API of interest in this class for 3rd party component authors
  are the three methods which retrieve painters: #getBackgroundPainter,
  #getForegroundPainter, and #getBorderPainter.

  NimbusStyle allows you to specify custom states, or modify the order of
  states. Synth (and thus Nimbus) has the concept of a `state`. For example,
  a JButton might be in the `MOUSE_OVER` state, or the `ENABLED` state, or the
  `DISABLED` state. These are all `standard` states which are defined in synth,
  and which apply to all synth Regions.

  Sometimes, however, you need to have a custom state. For example, you
  want JButton to render differently if it's parent is a JToolbar. In Nimbus,
  you specify these custom states by including a special key in UIDefaults.
  The following UIDefaults entries define three states for this button:



      JButton.States = Enabled, Disabled, Toolbar
      JButton[Enabled].backgroundPainter = somePainter
      JButton[Disabled].background = BLUE
      JButton[Toolbar].backgroundPainter = someOtherPaint

  As you can see, the JButton.States entry lists the states
  that the JButton style will support. You then specify the settings for
  each state. If you do not specify the JButton.States entry,
  then the standard Synth states will be assumed. If you specify the entry
  but the list of states is empty or null, then the standard synth states
  will be assumed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.nimbus NimbusStyle]))

(def *-large-key
  "Static Constant.

  type: java.lang.String"
  NimbusStyle/LARGE_KEY)

(def *-small-key
  "Static Constant.

  type: java.lang.String"
  NimbusStyle/SMALL_KEY)

(def *-mini-key
  "Static Constant.

  type: java.lang.String"
  NimbusStyle/MINI_KEY)

(def *-large-scale
  "Static Constant.

  type: double"
  NimbusStyle/LARGE_SCALE)

(def *-small-scale
  "Static Constant.

  type: double"
  NimbusStyle/SMALL_SCALE)

(def *-mini-scale
  "Static Constant.

  type: double"
  NimbusStyle/MINI_SCALE)

(defn install-defaults
  "Installs the necessary state from this Style on the
   JComponent from context.

   Overridden to cause this style to populate itself with data from
   UIDefaults, if necessary.

  ctx - SynthContext identifying component to install properties to. - `javax.swing.plaf.synth.SynthContext`"
  ([^javax.swing.plaf.nimbus.NimbusStyle this ^javax.swing.plaf.synth.SynthContext ctx]
    (-> this (.installDefaults ctx))))

(defn get-insets
  "Returns the Insets that are used to calculate sizing information.

   Overridden to cause this style to populate itself with data from
   UIDefaults, if necessary.

  ctx - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`
  in - Insets to place return value in. - `java.awt.Insets`

  returns: Sizing Insets. - `java.awt.Insets`"
  ([^javax.swing.plaf.nimbus.NimbusStyle this ^javax.swing.plaf.synth.SynthContext ctx ^java.awt.Insets in]
    (-> this (.getInsets ctx in))))

(defn get-painter
  "Returns the SynthPainter that will be used for painting.
   This may return null.

   Returns the SynthPainter for this style, which ends up delegating to
   the Painters installed in this style.

  ctx - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`

  returns: SynthPainter to use - `javax.swing.plaf.synth.SynthPainter`"
  ([^javax.swing.plaf.nimbus.NimbusStyle this ^javax.swing.plaf.synth.SynthContext ctx]
    (-> this (.getPainter ctx))))

(defn opaque?
  "Returns true if the region is opaque.

   Overridden to cause this style to populate itself with data from
   UIDefaults, if necessary. If opacity is not specified in UI defaults,
   then it defaults to being non-opaque.

  ctx - SynthContext identifying requester - `javax.swing.plaf.synth.SynthContext`

  returns: true if region is opaque. - `boolean`"
  ([^javax.swing.plaf.nimbus.NimbusStyle this ^javax.swing.plaf.synth.SynthContext ctx]
    (-> this (.isOpaque ctx))))

(defn get
  "Getter for a region specific style property.

   Overridden to cause this style to populate itself with data from
   UIDefaults, if necessary.

   Properties in UIDefaults may be specified in a chained manner. For
   example:


   background
   Button.opacity
   Button.Enabled.foreground
   Button.Enabled+Selected.background

   In this example, suppose you were in the Enabled+Selected state and
   searched for `foreground`. In this case, we first check for
   Button.Enabled+Selected.foreground, but no such color exists. We then
   fall back to the next valid state, in this case,
   Button.Enabled.foreground, and have a match. So we return it.

   Again, if we were in the state Enabled and looked for `background`, we
   wouldn't find it in Button.Enabled, or in Button, but would at the top
   level in UIManager. So we return that value.

   One special note: the `key` passed to this method could be of the form
   `background` or `Button.background` where `Button` equals the prefix
   passed to the NimbusStyle constructor. In either case, it looks for
   `background`.

  ctx - `javax.swing.plaf.synth.SynthContext`
  key - must not be null - `java.lang.Object`

  returns: Value of the named property - `java.lang.Object`"
  ([^javax.swing.plaf.nimbus.NimbusStyle this ^javax.swing.plaf.synth.SynthContext ctx ^java.lang.Object key]
    (-> this (.get ctx key))))

(defn get-background-painter
  "Gets the appropriate background Painter, if there is one, for the state
   specified in the given SynthContext. This method does appropriate
   fallback searching, as described in #get.

  ctx - The SynthContext. Must not be null. - `javax.swing.plaf.synth.SynthContext`

  returns: The background painter associated for the given state, or null if
   none could be found. - `javax.swing.Painter`"
  ([^javax.swing.plaf.nimbus.NimbusStyle this ^javax.swing.plaf.synth.SynthContext ctx]
    (-> this (.getBackgroundPainter ctx))))

(defn get-foreground-painter
  "Gets the appropriate foreground Painter, if there is one, for the state
   specified in the given SynthContext. This method does appropriate
   fallback searching, as described in #get.

  ctx - The SynthContext. Must not be null. - `javax.swing.plaf.synth.SynthContext`

  returns: The foreground painter associated for the given state, or null if
   none could be found. - `javax.swing.Painter`"
  ([^javax.swing.plaf.nimbus.NimbusStyle this ^javax.swing.plaf.synth.SynthContext ctx]
    (-> this (.getForegroundPainter ctx))))

(defn get-border-painter
  "Gets the appropriate border Painter, if there is one, for the state
   specified in the given SynthContext. This method does appropriate
   fallback searching, as described in #get.

  ctx - The SynthContext. Must not be null. - `javax.swing.plaf.synth.SynthContext`

  returns: The border painter associated for the given state, or null if
   none could be found. - `javax.swing.Painter`"
  ([^javax.swing.plaf.nimbus.NimbusStyle this ^javax.swing.plaf.synth.SynthContext ctx]
    (-> this (.getBorderPainter ctx))))

