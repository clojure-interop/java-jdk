(ns javax.swing.JComponent
  "The base class for all Swing components except top-level containers.
  To use a component that inherits from JComponent,
  you must place the component in a containment hierarchy
  whose root is a top-level Swing container.
  Top-level Swing containers --
  such as JFrame, JDialog,
  and JApplet --
  are specialized components
  that provide a place for other Swing components to paint themselves.
  For an explanation of containment hierarchies, see
  Swing Components and the Containment Hierarchy,
  a section in The Java Tutorial.


  The JComponent class provides:

  The base class for both standard and custom components
      that use the Swing architecture.
  A `pluggable look and feel` (L&F) that can be specified by the
      programmer or (optionally) selected by the user at runtime.
      The look and feel for each component is provided by a
      UI delegate -- an object that descends from
      ComponentUI.
      See How
      to Set the Look and Feel
      in The Java Tutorial
      for more information.
  Comprehensive keystroke handling.
      See the document How to Use Key Bindings,
      an article in The Java Tutorial,
      for more information.
  Support for tool tips --
      short descriptions that pop up when the cursor lingers
      over a component.
      See How
      to Use Tool Tips
      in The Java Tutorial
      for more information.
  Support for accessibility.
      JComponent contains all of the methods in the
      Accessible interface,
      but it doesn't actually implement the interface.  That is the
      responsibility of the individual classes
      that extend JComponent.
  Support for component-specific properties.
      With the putClientProperty(java.lang.Object, java.lang.Object)
      and getClientProperty(java.lang.Object) methods,
      you can associate name-object pairs
      with any object that descends from JComponent.
  An infrastructure for painting
      that includes double buffering and support for borders.
      For more information see Painting and
  How
      to Use Borders,
      both of which are sections in The Java Tutorial.

  For more information on these subjects, see the
  Swing package description
  and The Java Tutorial section
  The JComponent Class.

  JComponent and its subclasses document default values
  for certain properties.  For example, JTable documents the
  default row height as 16.  Each JComponent subclass
  that has a ComponentUI will create the
  ComponentUI as part of its constructor.  In order
  to provide a particular look and feel each
  ComponentUI may set properties back on the
  JComponent that created it.  For example, a custom
  look and feel may require JTables to have a row
  height of 24. The documented defaults are the value of a property
  BEFORE the ComponentUI has been installed.  If you
  need a specific value for a particular property you should
  explicitly set it.

  In release 1.4, the focus subsystem was rearchitected.
  For more information, see

  How to Use the Focus Subsystem,
  a section in The Java Tutorial.

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
  (:import [javax.swing JComponent]))

(defn ->j-component
  "Constructor.

  Default JComponent constructor.  This constructor does
   very little initialization beyond calling the Container
   constructor.  For example, the initial layout manager is
   null. It does, however, set the component's locale
   property to the value returned by
   JComponent.getDefaultLocale."
  (^JComponent []
    (new JComponent )))

(def *-when-focused
  "Static Constant.

  Constant used for registerKeyboardAction that
   means that the command should be invoked when
   the component has the focus.

  type: int"
  JComponent/WHEN_FOCUSED)

(def *-when-ancestor-of-focused-component
  "Static Constant.

  Constant used for registerKeyboardAction that
   means that the command should be invoked when the receiving
   component is an ancestor of the focused component or is
   itself the focused component.

  type: int"
  JComponent/WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)

(def *-when-in-focused-window
  "Static Constant.

  Constant used for registerKeyboardAction that
   means that the command should be invoked when
   the receiving component is in the window that has the focus
   or is itself the focused component.

  type: int"
  JComponent/WHEN_IN_FOCUSED_WINDOW)

(def *-undefined-condition
  "Static Constant.

  Constant used by some of the APIs to mean that no condition is defined.

  type: int"
  JComponent/UNDEFINED_CONDITION)

(def *-tool-tip-text-key
  "Static Constant.

  The comment to display when the cursor is over the component,
   also known as a `value tip`, `flyover help`, or `flyover label`.

  type: java.lang.String"
  JComponent/TOOL_TIP_TEXT_KEY)

(defn *get-default-locale
  "Returns the default locale used to initialize each JComponent's
   locale property upon creation.

   The default locale has `AppContext` scope so that applets (and
   potentially multiple lightweight applications running in a single VM)
   can have their own setting. An applet can safely alter its default
   locale because it will have no affect on other applets (or the browser).

  returns: the default Locale. - `java.util.Locale`"
  (^java.util.Locale []
    (JComponent/getDefaultLocale )))

(defn *set-default-locale
  "Sets the default locale used to initialize each JComponent's locale
   property upon creation.  The initial value is the VM's default locale.

   The default locale has `AppContext` scope so that applets (and
   potentially multiple lightweight applications running in a single VM)
   can have their own setting. An applet can safely alter its default
   locale because it will have no affect on other applets (or the browser).

  l - the desired default Locale for new components. - `java.util.Locale`"
  ([^java.util.Locale l]
    (JComponent/setDefaultLocale l)))

(defn *lightweight-component?
  "Returns true if this component is lightweight, that is, if it doesn't
   have a native window system peer.

  c - `java.awt.Component`

  returns: true if this component is lightweight - `boolean`"
  (^Boolean [^java.awt.Component c]
    (JComponent/isLightweightComponent c)))

(defn opaque?
  "Returns true if this component is completely opaque.

   An opaque component paints every pixel within its
   rectangular bounds. A non-opaque component paints only a subset of
   its pixels or none at all, allowing the pixels underneath it to
   `show through`.  Therefore, a component that does not fully paint
   its pixels provides a degree of transparency.

   Subclasses that guarantee to always completely paint their contents
   should override this method and return true.

  returns: true if this component is completely opaque - `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.isOpaque))))

(defn set-opaque
  "If true the component paints every pixel within its bounds.
   Otherwise, the component may not paint some or all of its
   pixels, allowing the underlying pixels to show through.

   The default value of this property is false for JComponent.
   However, the default value for this property on most standard
   JComponent subclasses (such as JButton and
   JTree) is look-and-feel dependent.

  is-opaque - true if this component should be opaque - `boolean`"
  ([^JComponent this ^Boolean is-opaque]
    (-> this (.setOpaque is-opaque))))

(defn double-buffered?
  "Returns whether this component should use a buffer to paint.

  returns: true if this component is double buffered, otherwise false - `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.isDoubleBuffered))))

(defn get-debug-graphics-options
  "Returns the state of graphics debugging.

  returns: a bitwise OR'd flag of zero or more of the following options:

   DebugGraphics.LOG_OPTION - causes a text message to be printed.
   DebugGraphics.FLASH_OPTION - causes the drawing to flash several
   times.
   DebugGraphics.BUFFERED_OPTION - creates an
           ExternalWindow that displays the operations
           performed on the View's offscreen buffer.
   DebugGraphics.NONE_OPTION disables debugging.
   A value of 0 causes no changes to the debugging options. - `int`"
  (^Integer [^JComponent this]
    (-> this (.getDebugGraphicsOptions))))

(defn get-minimum-size
  "If the minimum size has been set to a non-null value
   just returns it.  If the UI delegate's getMinimumSize
   method returns a non-null value then return that; otherwise
   defer to the component's layout manager.

  returns: the value of the minimumSize property - `java.awt.Dimension`"
  (^java.awt.Dimension [^JComponent this]
    (-> this (.getMinimumSize))))

(defn set-next-focusable-component
  "Deprecated. As of 1.4, replaced by FocusTraversalPolicy

  a-component - the Component that should follow this JComponent in the focus traversal cycle - `java.awt.Component`"
  ([^JComponent this ^java.awt.Component a-component]
    (-> this (.setNextFocusableComponent a-component))))

(defn get-location
  "Stores the x,y origin of this component into `return value`
   rv and returns rv.
   If rv is null a new Point
   is allocated.  This version of getLocation is useful
   if the caller wants to avoid allocating a new Point
   object on the heap.

  rv - the return value, modified to the component's location - `java.awt.Point`

  returns: rv - `java.awt.Point`"
  (^java.awt.Point [^JComponent this ^java.awt.Point rv]
    (-> this (.getLocation rv))))

(defn set-alignment-y
  "Sets the the horizontal alignment.

  alignment-y - the new horizontal alignment - `float`"
  ([^JComponent this ^Float alignment-y]
    (-> this (.setAlignmentY alignment-y))))

(defn print-all
  "Invoke this method to print the component. This method invokes
   print on the component.

  g - the Graphics context in which to paint - `java.awt.Graphics`"
  ([^JComponent this ^java.awt.Graphics g]
    (-> this (.printAll g))))

(defn get-maximum-size
  "If the maximum size has been set to a non-null value
   just returns it.  If the UI delegate's getMaximumSize
   method returns a non-null value then return that;
   otherwise defer to the component's layout manager.

  returns: the value of the maximumSize property - `java.awt.Dimension`"
  (^java.awt.Dimension [^JComponent this]
    (-> this (.getMaximumSize))))

(defn get-width
  "Returns the current width of this component.
   This method is preferable to writing
   component.getBounds().width, or
   component.getSize().width because it doesn't cause any
   heap allocations.

  returns: the current width of this component - `int`"
  (^Integer [^JComponent this]
    (-> this (.getWidth))))

(defn hide
  "Deprecated."
  ([^JComponent this]
    (-> this (.hide))))

(defn compute-visible-rect
  "Returns the Component's `visible rect rectangle` -  the
   intersection of the visible rectangles for this component
   and all of its ancestors.  The return value is stored in
   visibleRect.

  visible-rect - a Rectangle computed as the intersection of all visible rectangles for this component and all of its ancestors -- this is the return value for this method - `java.awt.Rectangle`"
  ([^JComponent this ^java.awt.Rectangle visible-rect]
    (-> this (.computeVisibleRect visible-rect))))

(defn get-action-map
  "Returns the ActionMap used to determine what
   Action to fire for particular KeyStroke
   binding. The returned ActionMap, unless otherwise
   set, will have the ActionMap from the UI set as the parent.

  returns: the ActionMap containing the key/action bindings - `javax.swing.ActionMap`"
  (^javax.swing.ActionMap [^JComponent this]
    (-> this (.getActionMap))))

(defn get-action-for-key-stroke
  "Returns the object that will perform the action registered for a
   given keystroke.

  a-key-stroke - `javax.swing.KeyStroke`

  returns: the ActionListener
            object invoked when the keystroke occurs - `java.awt.event.ActionListener`"
  (^java.awt.event.ActionListener [^JComponent this ^javax.swing.KeyStroke a-key-stroke]
    (-> this (.getActionForKeyStroke a-key-stroke))))

(defn set-foreground
  "Sets the foreground color of this component.  It is up to the
   look and feel to honor this property, some may choose to ignore
   it.

  fg - the desired foreground Color - `java.awt.Color`"
  ([^JComponent this ^java.awt.Color fg]
    (-> this (.setForeground fg))))

(defn set-inherits-popup-menu
  "Sets whether or not getComponentPopupMenu should delegate
   to the parent if this component does not have a JPopupMenu
   assigned to it.

   The default value for this is false, but some JComponent
   subclasses that are implemented as a number of JComponents
   may set this to true.

   This is a bound property.

  value - whether or not the JPopupMenu is inherited - `boolean`"
  ([^JComponent this ^Boolean value]
    (-> this (.setInheritsPopupMenu value))))

(defn get-popup-location
  "Returns the preferred location to display the popup menu in this
   component's coordinate system. It is up to the look and feel to
   honor this property, some may choose to ignore it.
   If null, the look and feel will choose a suitable location.

  event - the MouseEvent that triggered the popup to be shown, or null if the popup is not being shown as the result of a mouse event - `java.awt.event.MouseEvent`

  returns: location to display the JPopupMenu, or null - `java.awt.Point`"
  (^java.awt.Point [^JComponent this event]
    (-> this (.getPopupLocation event))))

(defn get-insets
  "Returns an Insets object containing this component's inset
   values.  The passed-in Insets object will be reused
   if possible.
   Calling methods cannot assume that the same object will be returned,
   however.  All existing values within this object are overwritten.
   If insets is null, this will allocate a new one.

  insets - the Insets object, which can be reused - `java.awt.Insets`

  returns: the Insets object - `java.awt.Insets`"
  (^java.awt.Insets [^JComponent this ^java.awt.Insets insets]
    (-> this (.getInsets insets)))
  (^java.awt.Insets [^JComponent this]
    (-> this (.getInsets))))

(defn fire-property-change
  "Support for reporting bound property changes for boolean properties.
   This method can be called when a bound property has changed and it will
   send the appropriate PropertyChangeEvent to any registered
   PropertyChangeListeners.

  property-name - the property whose value has changed - `java.lang.String`
  old-value - the property's previous value - `boolean`
  new-value - the property's new value - `boolean`"
  ([^JComponent this ^java.lang.String property-name ^Boolean old-value ^Boolean new-value]
    (-> this (.firePropertyChange property-name old-value new-value))))

(defn put-client-property
  "Adds an arbitrary key/value `client property` to this component.

   The get/putClientProperty methods provide access to
   a small per-instance hashtable. Callers can use get/putClientProperty
   to annotate components that were created by another module.
   For example, a
   layout manager might store per child constraints this way. For example:


   componentA.putClientProperty(`to the left of`, componentB);
   If value is null this method will remove the property.
   Changes to client properties are reported with
   PropertyChange events.
   The name of the property (for the sake of PropertyChange
   events) is key.toString().

   The clientProperty dictionary is not intended to
   support large
   scale extensions to JComponent nor should be it considered an
   alternative to subclassing when designing a new component.

  key - the new client property key - `java.lang.Object`
  value - the new client property value; if null this method will remove the property - `java.lang.Object`"
  ([^JComponent this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.putClientProperty key value))))

(defn painting-tile?
  "Returns true if the component is currently painting a tile.
    If this method returns true, paint will be called again for another
    tile. This method returns false if you are not painting a tile or
    if the last tile is painted.
    Use this method to keep some state you might need between tiles.

  returns: true if the component is currently painting a tile,
            false otherwise - `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.isPaintingTile))))

(defn scroll-rect-to-visible
  "Forwards the scrollRectToVisible() message to the
   JComponent's parent. Components that can service
   the request, such as JViewport,
   override this method and perform the scrolling.

  a-rect - the visible Rectangle - `java.awt.Rectangle`"
  ([^JComponent this ^java.awt.Rectangle a-rect]
    (-> this (.scrollRectToVisible a-rect))))

(defn contains
  "Gives the UI delegate an opportunity to define the precise
   shape of this component for the sake of mouse processing.

  x - the x coordinate of the point - `int`
  y - the y coordinate of the point - `int`

  returns: true if this component logically contains x,y - `boolean`"
  (^Boolean [^JComponent this ^Integer x ^Integer y]
    (-> this (.contains x y))))

(defn get-border
  "Returns the border of this component or null if no
   border is currently set.

  returns: the border object for this component - `javax.swing.border.Border`"
  (^javax.swing.border.Border [^JComponent this]
    (-> this (.getBorder))))

(defn create-tool-tip
  "Returns the instance of JToolTip that should be used
   to display the tooltip.
   Components typically would not override this method,
   but it can be used to
   cause different tooltips to be displayed differently.

  returns: the JToolTip used to display this toolTip - `javax.swing.JToolTip`"
  (^javax.swing.JToolTip [^JComponent this]
    (-> this (.createToolTip))))

(defn set-alignment-x
  "Sets the the vertical alignment.

  alignment-x - the new vertical alignment - `float`"
  ([^JComponent this ^Float alignment-x]
    (-> this (.setAlignmentX alignment-x))))

(defn enable
  "Deprecated. As of JDK version 1.1,
   replaced by java.awt.Component.setEnabled(boolean)."
  ([^JComponent this]
    (-> this (.enable))))

(defn get-graphics
  "Returns this component's graphics context, which lets you draw
   on a component. Use this method to get a Graphics object and
   then invoke operations on that object to draw on the component.

  returns: this components graphics context - `java.awt.Graphics`"
  (^java.awt.Graphics [^JComponent this]
    (-> this (.getGraphics))))

(defn get-tool-tip-location
  "Returns the tooltip location in this component's coordinate system.
   If null is returned, Swing will choose a location.
   The default implementation returns null.

  event - the MouseEvent that caused the ToolTipManager to show the tooltip - `java.awt.event.MouseEvent`

  returns: always returns null - `java.awt.Point`"
  (^java.awt.Point [^JComponent this event]
    (-> this (.getToolTipLocation event))))

(defn set-double-buffered
  "Sets whether this component should use a buffer to paint.
    If set to true, all the drawing from this component will be done
    in an offscreen painting buffer. The offscreen painting buffer will
    the be copied onto the screen.
    If a Component is buffered and one of its ancestor
    is also buffered, the ancestor buffer will be used.

  a-flag - if true, set this component to be double buffered - `boolean`"
  ([^JComponent this ^Boolean a-flag]
    (-> this (.setDoubleBuffered a-flag))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.  This method is primarily meant for
   layout managers and GUI builders.

   This method calls into the ComponentUI method of
   the same name.  If this component does not have a
   ComponentUI
   BaselineResizeBehavior.OTHER will be
   returned.  Subclasses should
   never return null; if the baseline can not be
   calculated return BaselineResizeBehavior.OTHER.  Callers
   should first ask for the baseline using
   getBaseline and if a value >= 0 is returned use
   this method.  It is acceptable for this method to return a
   value other than BaselineResizeBehavior.OTHER even if
   getBaseline returns a value less than 0.

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component$BaselineResizeBehavior`"
  (^java.awt.Component$BaselineResizeBehavior [^JComponent this]
    (-> this (.getBaselineResizeBehavior))))

(defn set-tool-tip-text
  "Registers the text to display in a tool tip.
   The text displays when the cursor lingers over the component.

   See How to Use Tool Tips
   in The Java Tutorial
   for further documentation.

  text - the string to display; if the text is null, the tool tip is turned off for this component - `java.lang.String`"
  ([^JComponent this ^java.lang.String text]
    (-> this (.setToolTipText text))))

(defn get-ui-class-id
  "Returns the UIDefaults key used to
   look up the name of the swing.plaf.ComponentUI
   class that defines the look and feel
   for this component.  Most applications will never need to
   call this method.  Subclasses of JComponent that support
   pluggable look and feel should override this method to
   return a UIDefaults key that maps to the
   ComponentUI subclass that defines their look and feel.

  returns: the UIDefaults key for a
            ComponentUI subclass - `java.lang.String`"
  (^java.lang.String [^JComponent this]
    (-> this (.getUIClassID))))

(defn update
  "Calls paint.  Doesn't clear the background but see
   ComponentUI.update, which is called by
   paintComponent.

  g - the Graphics context in which to paint - `java.awt.Graphics`"
  ([^JComponent this ^java.awt.Graphics g]
    (-> this (.update g))))

(defn get-registered-key-strokes
  "Returns the KeyStrokes that will initiate
   registered actions.

  returns: an array of KeyStroke objects - `javax.swing.KeyStroke[]`"
  ([^JComponent this]
    (-> this (.getRegisteredKeyStrokes))))

(defn validate-root?
  "If this method returns true, revalidate calls by
   descendants of this component will cause the entire tree
   beginning with this root to be validated.
   Returns false by default.  JScrollPane overrides
   this method and returns true.

  returns: always returns false - `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.isValidateRoot))))

(defn get-input-verifier
  "Returns the input verifier for this component.

  returns: the inputVerifier property - `javax.swing.InputVerifier`"
  (^javax.swing.InputVerifier [^JComponent this]
    (-> this (.getInputVerifier))))

(defn set-background
  "Sets the background color of this component.  The background
   color is used only if the component is opaque, and only
   by subclasses of JComponent or
   ComponentUI implementations.  Direct subclasses of
   JComponent must override
   paintComponent to honor this property.

   It is up to the look and feel to honor this property, some may
   choose to ignore it.

  bg - the desired background Color - `java.awt.Color`"
  ([^JComponent this ^java.awt.Color bg]
    (-> this (.setBackground bg))))

(defn reshape
  "Deprecated. As of JDK 5,
   replaced by Component.setBounds(int, int, int, int).

   Moves and resizes this component.

  x - the new horizontal location - `int`
  y - the new vertical location - `int`
  w - the new width - `int`
  h - the new height - `int`"
  ([^JComponent this ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.reshape x y w h))))

(defn get-component-popup-menu
  "Returns JPopupMenu that assigned for this component.
   If this component does not have a JPopupMenu assigned
   to it and getInheritsPopupMenu is true, this
   will return getParent().getComponentPopupMenu() (assuming
   the parent is valid.)

  returns: JPopupMenu assigned for this component
           or null if no popup assigned - `javax.swing.JPopupMenu`"
  (^javax.swing.JPopupMenu [^JComponent this]
    (-> this (.getComponentPopupMenu))))

(defn get-autoscrolls?
  "Gets the autoscrolls property.

  returns: the value of the autoscrolls property - `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.getAutoscrolls))))

(defn get-alignment-x
  "Overrides Container.getAlignmentX to return
   the vertical alignment.

  returns: the value of the alignmentX property - `float`"
  (^Float [^JComponent this]
    (-> this (.getAlignmentX))))

(defn add-notify
  "Notifies this component that it now has a parent component.
   When this method is invoked, the chain of parent components is
   set up with KeyboardAction event listeners.
   This method is called by the toolkit internally and should
   not be called directly by programs."
  ([^JComponent this]
    (-> this (.addNotify))))

(defn get-font-metrics
  "Gets the FontMetrics for the specified Font.

  font - the font for which font metrics is to be obtained - `java.awt.Font`

  returns: the font metrics for font - `java.awt.FontMetrics`

  throws: java.lang.NullPointerException - if font is null"
  (^java.awt.FontMetrics [^JComponent this ^java.awt.Font font]
    (-> this (.getFontMetrics font))))

(defn set-input-map
  "Sets the InputMap to use under the condition
   condition to
   map. A null value implies you
   do not want any bindings to be used, even from the UI. This will
   not reinstall the UI InputMap (if there was one).
   condition has one of the following values:

   WHEN_IN_FOCUSED_WINDOW
   WHEN_FOCUSED
   WHEN_ANCESTOR_OF_FOCUSED_COMPONENT

   If condition is WHEN_IN_FOCUSED_WINDOW
   and map is not a ComponentInputMap, an
   IllegalArgumentException will be thrown.
   Similarly, if condition is not one of the values
   listed, an IllegalArgumentException will be thrown.

  condition - one of the values listed above - `int`
  map - the InputMap to use for the given condition - `javax.swing.InputMap`

  throws: java.lang.IllegalArgumentException - if condition is WHEN_IN_FOCUSED_WINDOW and map is not an instance of ComponentInputMap; or if condition is not one of the legal values specified above"
  ([^JComponent this ^Integer condition ^javax.swing.InputMap map]
    (-> this (.setInputMap condition map))))

(defn set-preferred-size
  "Sets the preferred size of this component.
   If preferredSize is null, the UI will
   be asked for the preferred size.

  preferred-size - The new preferred size, or null - `java.awt.Dimension`"
  ([^JComponent this ^java.awt.Dimension preferred-size]
    (-> this (.setPreferredSize preferred-size))))

(defn get-y
  "Returns the current y coordinate of the component's origin.
   This method is preferable to writing
   component.getBounds().y, or
   component.getLocation().y because it doesn't cause any
   heap allocations.

  returns: the current y coordinate of the component's origin - `int`"
  (^Integer [^JComponent this]
    (-> this (.getY))))

(defn set-component-popup-menu
  "Sets the JPopupMenu for this JComponent.
   The UI is responsible for registering bindings and adding the necessary
   listeners such that the JPopupMenu will be shown at
   the appropriate time. When the JPopupMenu is shown
   depends upon the look and feel: some may show it on a mouse event,
   some may enable a key binding.

   If popup is null, and getInheritsPopupMenu
   returns true, then getComponentPopupMenu will be delegated
   to the parent. This provides for a way to make all child components
   inherit the popupmenu of the parent.

   This is a bound property.

  popup - - the popup that will be assigned to this component may be null - `javax.swing.JPopupMenu`"
  ([^JComponent this ^javax.swing.JPopupMenu popup]
    (-> this (.setComponentPopupMenu popup))))

(defn get-tool-tip-text
  "Returns the string to be used as the tooltip for event.
   By default this returns any string set using
   setToolTipText.  If a component provides
   more extensive API to support differing tooltips at different locations,
   this method should be overridden.

  event - `java.awt.event.MouseEvent`

  returns: `java.lang.String`"
  (^java.lang.String [^JComponent this event]
    (-> this (.getToolTipText event)))
  (^java.lang.String [^JComponent this]
    (-> this (.getToolTipText))))

(defn remove-notify
  "Notifies this component that it no longer has a parent component.
   When this method is invoked, any KeyboardActions
   set up in the the chain of parent components are removed.
   This method is called by the toolkit internally and should
   not be called directly by programs."
  ([^JComponent this]
    (-> this (.removeNotify))))

(defn get-inherits-popup-menu?
  "Returns true if the JPopupMenu should be inherited from the parent.

  returns: `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.getInheritsPopupMenu))))

(defn set-action-map
  "Sets the ActionMap to am. This does not set
   the parent of the am to be the ActionMap
   from the UI (if there was one), it is up to the caller to have done this.

  am - the new ActionMap - `javax.swing.ActionMap`"
  ([^JComponent this ^javax.swing.ActionMap am]
    (-> this (.setActionMap am))))

(defn set-transfer-handler
  "Sets the TransferHandler, which provides support for transfer
   of data into and out of this component via cut/copy/paste and drag
   and drop. This may be null if the component does not support
   data transfer operations.

   If the new TransferHandler is not null, this method
   also installs a new DropTarget on the component to
   activate drop handling through the TransferHandler and activate
   any built-in support (such as calculating and displaying potential drop
   locations). If you do not wish for this component to respond in any way
   to drops, you can disable drop support entirely either by removing the
   drop target (setDropTarget(null)) or by de-activating it
   (getDropTaget().setActive(false)).

   If the new TransferHandler is null, this method removes
   the drop target.

   Under two circumstances, this method does not modify the drop target:
   First, if the existing drop target on this component was explicitly
   set by the developer to a non-null value. Second, if the
   system property suppressSwingDropSupport is true. The
   default value for the system property is false.

   Please see

   How to Use Drag and Drop and Data Transfer,
   a section in The Java Tutorial, for more information.

  new-handler - the new TransferHandler - `javax.swing.TransferHandler`"
  ([^JComponent this ^javax.swing.TransferHandler new-handler]
    (-> this (.setTransferHandler new-handler))))

(defn register-keyboard-action
  "This method is now obsolete, please use a combination of
   getActionMap() and getInputMap() for
   similar behavior. For example, to bind the KeyStroke
   aKeyStroke to the Action anAction
   now use:


     component.getInputMap().put(aKeyStroke, aCommand);
     component.getActionMap().put(aCommmand, anAction);
   The above assumes you want the binding to be applicable for
   WHEN_FOCUSED. To register bindings for other focus
   states use the getInputMap method that takes an integer.

   Register a new keyboard action.
   anAction will be invoked if a key event matching
   aKeyStroke occurs and aCondition is verified.
   The KeyStroke object defines a
   particular combination of a keyboard key and one or more modifiers
   (alt, shift, ctrl, meta).

   The aCommand will be set in the delivered event if
   specified.

   The aCondition can be one of:


   WHEN_FOCUSED
   The action will be invoked only when the keystroke occurs
       while the component has the focus.
   WHEN_IN_FOCUSED_WINDOW
   The action will be invoked when the keystroke occurs while
       the component has the focus or if the component is in the
       window that has the focus. Note that the component need not
       be an immediate descendent of the window -- it can be
       anywhere in the window's containment hierarchy. In other
       words, whenever any component in the window has the focus,
       the action registered with this component is invoked.
   WHEN_ANCESTOR_OF_FOCUSED_COMPONENT
   The action will be invoked when the keystroke occurs while the
       component has the focus or if the component is an ancestor of
       the component that has the focus.



   The combination of keystrokes and conditions lets you define high
   level (semantic) action events for a specified keystroke+modifier
   combination (using the KeyStroke class) and direct to a parent or
   child of a component that has the focus, or to the component itself.
   In other words, in any hierarchical structure of components, an
   arbitrary key-combination can be immediately directed to the
   appropriate component in the hierarchy, and cause a specific method
   to be invoked (usually by way of adapter objects).

   If an action has already been registered for the receiving
   container, with the same charCode and the same modifiers,
   anAction will replace the action.

  an-action - the Action to be registered - `java.awt.event.ActionListener`
  a-command - the command to be set in the delivered event - `java.lang.String`
  a-key-stroke - the KeyStroke to bind to the action - `javax.swing.KeyStroke`
  a-condition - the condition that needs to be met, see above - `int`"
  ([^JComponent this ^java.awt.event.ActionListener an-action ^java.lang.String a-command ^javax.swing.KeyStroke a-key-stroke ^Integer a-condition]
    (-> this (.registerKeyboardAction an-action a-command a-key-stroke a-condition)))
  ([^JComponent this ^java.awt.event.ActionListener an-action ^javax.swing.KeyStroke a-key-stroke ^Integer a-condition]
    (-> this (.registerKeyboardAction an-action a-key-stroke a-condition))))

(defn disable
  "Deprecated. As of JDK version 1.1,
   replaced by java.awt.Component.setEnabled(boolean)."
  ([^JComponent this]
    (-> this (.disable))))

(defn add-ancestor-listener
  "Registers listener so that it will receive
   AncestorEvents when it or any of its ancestors
   move or are made visible or invisible.
   Events are also sent when the component or its ancestors are added
   or removed from the containment hierarchy.

  listener - the AncestorListener to register - `javax.swing.event.AncestorListener`"
  ([^JComponent this ^javax.swing.event.AncestorListener listener]
    (-> this (.addAncestorListener listener))))

(defn paint-immediately
  "Paints the specified region in this component and all of its
   descendants that overlap the region, immediately.

   It's rarely necessary to call this method.  In most cases it's
   more efficient to call repaint, which defers the actual painting
   and can collapse redundant requests into a single paint call.
   This method is useful if one needs to update the display while
   the current event is being dispatched.

   This method is to be overridden when the dirty region needs to be changed
   for components that are painting origins.

  x - the x value of the region to be painted - `int`
  y - the y value of the region to be painted - `int`
  w - the width of the region to be painted - `int`
  h - the height of the region to be painted - `int`"
  ([^JComponent this ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintImmediately x y w h)))
  ([^JComponent this ^java.awt.Rectangle r]
    (-> this (.paintImmediately r))))

(defn unregister-keyboard-action
  "This method is now obsolete. To unregister an existing binding
   you can either remove the binding from the
   ActionMap/InputMap, or place a dummy binding the
   InputMap. Removing the binding from the
   InputMap allows bindings in parent InputMaps
   to be active, whereas putting a dummy binding in the
   InputMap effectively disables
   the binding from ever happening.

   Unregisters a keyboard action.
   This will remove the binding from the ActionMap
   (if it exists) as well as the InputMaps.

  a-key-stroke - `javax.swing.KeyStroke`"
  ([^JComponent this ^javax.swing.KeyStroke a-key-stroke]
    (-> this (.unregisterKeyboardAction a-key-stroke))))

(defn repaint
  "Adds the specified region to the dirty region list if the component
   is showing.  The component will be repainted after all of the
   currently pending events have been dispatched.

  tm - this parameter is not used - `long`
  x - the x value of the dirty region - `int`
  y - the y value of the dirty region - `int`
  width - the width of the dirty region - `int`
  height - the height of the dirty region - `int`"
  ([^JComponent this ^Long tm ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.repaint tm x y width height)))
  ([^JComponent this ^java.awt.Rectangle r]
    (-> this (.repaint r))))

(defn request-focus-enabled?
  "Returns true if this JComponent should
   get focus; otherwise returns false.

   Please see

   How to Use the Focus Subsystem,
   a section in The Java Tutorial,
   for more information.

  returns: true if this component should get focus,
       otherwise returns false - `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.isRequestFocusEnabled))))

(defn get-x
  "Returns the current x coordinate of the component's origin.
   This method is preferable to writing
   component.getBounds().x, or
   component.getLocation().x because it doesn't cause any
   heap allocations.

  returns: the current x coordinate of the component's origin - `int`"
  (^Integer [^JComponent this]
    (-> this (.getX))))

(defn set-font
  "Sets the font for this component.

  font - the desired Font for this component - `java.awt.Font`"
  ([^JComponent this ^java.awt.Font font]
    (-> this (.setFont font))))

(defn get-height
  "Returns the current height of this component.
   This method is preferable to writing
   component.getBounds().height, or
   component.getSize().height because it doesn't cause any
   heap allocations.

  returns: the current height of this component - `int`"
  (^Integer [^JComponent this]
    (-> this (.getHeight))))

(defn get-condition-for-key-stroke
  "Returns the condition that determines whether a registered action
   occurs in response to the specified keystroke.

   For Java 2 platform v1.3, a KeyStroke can be associated
   with more than one condition.
   For example, 'a' could be bound for the two
   conditions WHEN_FOCUSED and
   WHEN_IN_FOCUSED_WINDOW condition.

  a-key-stroke - `javax.swing.KeyStroke`

  returns: the action-keystroke condition - `int`"
  (^Integer [^JComponent this ^javax.swing.KeyStroke a-key-stroke]
    (-> this (.getConditionForKeyStroke a-key-stroke))))

(defn get-alignment-y
  "Overrides Container.getAlignmentY to return
   the horizontal alignment.

  returns: the value of the alignmentY property - `float`"
  (^Float [^JComponent this]
    (-> this (.getAlignmentY))))

(defn paint
  "Invoked by Swing to draw components.
   Applications should not invoke paint directly,
   but should instead use the repaint method to
   schedule the component for redrawing.

   This method actually delegates the work of painting to three
   protected methods: paintComponent,
   paintBorder,
   and paintChildren.  They're called in the order
   listed to ensure that children appear on top of component itself.
   Generally speaking, the component and its children should not
   paint in the insets area allocated to the border. Subclasses can
   just override this method, as always.  A subclass that just
   wants to specialize the UI (look and feel) delegate's
   paint method should just override
   paintComponent.

  g - the Graphics context in which to paint - `java.awt.Graphics`"
  ([^JComponent this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn get-next-focusable-component
  "Deprecated. As of 1.4, replaced by FocusTraversalPolicy.

  returns: the Component that will follow this
          JComponent in the focus traversal cycle, or
          null if none has been explicitly specified - `java.awt.Component`"
  (^java.awt.Component [^JComponent this]
    (-> this (.getNextFocusableComponent))))

(defn grab-focus
  "Requests that this Component get the input focus, and that this
   Component's top-level ancestor become the focused Window. This component
   must be displayable, visible, and focusable for the request to be
   granted.

   This method is intended for use by focus implementations. Client code
   should not use this method; instead, it should use
   requestFocusInWindow()."
  ([^JComponent this]
    (-> this (.grabFocus))))

(defn get-vetoable-change-listeners
  "Returns an array of all the vetoable change listeners
   registered on this component.

  returns: all of the component's VetoableChangeListeners
           or an empty
           array if no vetoable change listeners are currently registered - `java.beans.VetoableChangeListener[]`"
  ([^JComponent this]
    (-> this (.getVetoableChangeListeners))))

(defn set-minimum-size
  "Sets the minimum size of this component to a constant
   value.  Subsequent calls to getMinimumSize will always
   return this value; the component's UI will not be asked
   to compute it.  Setting the minimum size to null
   restores the default behavior.

  minimum-size - the new minimum size of this component - `java.awt.Dimension`"
  ([^JComponent this ^java.awt.Dimension minimum-size]
    (-> this (.setMinimumSize minimum-size))))

(defn set-visible
  "Makes the component visible or invisible.
   Overrides Component.setVisible.

  a-flag - true to make the component visible; false to make it invisible - `boolean`"
  ([^JComponent this ^Boolean a-flag]
    (-> this (.setVisible a-flag))))

(defn set-enabled
  "Sets whether or not this component is enabled.
   A component that is enabled may respond to user input,
   while a component that is not enabled cannot respond to
   user input.  Some components may alter their visual
   representation when they are disabled in order to
   provide feedback to the user that they cannot take input.
   Note: Disabling a component does not disable its children.

   Note: Disabling a lightweight component does not prevent it from
   receiving MouseEvents.

  enabled - true if this component should be enabled, false otherwise - `boolean`"
  ([^JComponent this ^Boolean enabled]
    (-> this (.setEnabled enabled))))

(defn remove-ancestor-listener
  "Unregisters listener so that it will no longer receive
   AncestorEvents.

  listener - the AncestorListener to be removed - `javax.swing.event.AncestorListener`"
  ([^JComponent this ^javax.swing.event.AncestorListener listener]
    (-> this (.removeAncestorListener listener))))

(defn painting-for-print?
  "Returns true if the current painting operation on this
   component is part of a print operation. This method is
   useful when you want to customize what you print versus what you show
   on the screen.

   You can detect changes in the value of this property by listening for
   property change events on this component with name
   `paintingForPrint`.

   Note: This method provides complimentary functionality to that provided
   by other high level Swing printing APIs. However, it deals strictly with
   painting and should not be confused as providing information on higher
   level print processes. For example, a JTable.print()
   operation doesn't necessarily result in a continuous rendering of the
   full component, and the return value of this method can change multiple
   times during that operation. It is even possible for the component to be
   painted to the screen while the printing process is ongoing. In such a
   case, the return value of this method is true when, and only
   when, the table is being painted as part of the printing process.

  returns: true if the current painting operation on this component
           is part of a print operation - `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.isPaintingForPrint))))

(defn set-autoscrolls
  "Sets the autoscrolls property.
   If true mouse dragged events will be
   synthetically generated when the mouse is dragged
   outside of the component's bounds and mouse motion
   has paused (while the button continues to be held
   down). The synthetic events make it appear that the
   drag gesture has resumed in the direction established when
   the component's boundary was crossed.  Components that
   support autoscrolling must handle mouseDragged
   events by calling scrollRectToVisible with a
   rectangle that contains the mouse event's location.  All of
   the Swing components that support item selection and are
   typically displayed in a JScrollPane
   (JTable, JList, JTree,
   JTextArea, and JEditorPane)
   already handle mouse dragged events in this way.  To enable
   autoscrolling in any other component, add a mouse motion
   listener that calls scrollRectToVisible.
   For example, given a JPanel, myPanel:


   MouseMotionListener doScrollRectToVisible = new MouseMotionAdapter() {
       public void mouseDragged(MouseEvent e) {
          Rectangle r = new Rectangle(e.getX(), e.getY(), 1, 1);
          ((JPanel)e.getSource()).scrollRectToVisible(r);
      }
   };
   myPanel.addMouseMotionListener(doScrollRectToVisible);
   The default value of the autoScrolls
   property is false.

  autoscrolls - if true, synthetic mouse dragged events are generated when the mouse is dragged outside of a component's bounds and the mouse button continues to be held down; otherwise false - `boolean`"
  ([^JComponent this ^Boolean autoscrolls]
    (-> this (.setAutoscrolls autoscrolls))))

(defn set-input-verifier
  "Sets the input verifier for this component.

  input-verifier - the new input verifier - `javax.swing.InputVerifier`"
  ([^JComponent this ^javax.swing.InputVerifier input-verifier]
    (-> this (.setInputVerifier input-verifier))))

(defn print
  "Invoke this method to print the component to the specified
   Graphics. This method will result in invocations
   of printComponent, printBorder and
   printChildren. It is recommended that you override
   one of the previously mentioned methods rather than this one if
   your intention is to customize the way printing looks. However,
   it can be useful to override this method should you want to prepare
   state before invoking the superclass behavior. As an example,
   if you wanted to change the component's background color before
   printing, you could do the following:


       public void print(Graphics g) {
           Color orig = getBackground();
           setBackground(Color.WHITE);

           // wrap in try/finally so that we always restore the state
           try {
               super.print(g);
           } finally {
               setBackground(orig);
           }
       }

   Alternatively, or for components that delegate painting to other objects,
   you can query during painting whether or not the component is in the
   midst of a print operation. The isPaintingForPrint method provides
   this ability and its return value will be changed by this method: to
   true immediately before rendering and to false
   immediately after. With each change a property change event is fired on
   this component with the name `paintingForPrint`.

   This method sets the component's state such that the double buffer
   will not be used: painting will be done directly on the passed in
   Graphics.

  g - the Graphics context in which to paint - `java.awt.Graphics`"
  ([^JComponent this ^java.awt.Graphics g]
    (-> this (.print g))))

(defn request-default-focus
  "Deprecated. As of 1.4, replaced by
   FocusTraversalPolicy.getDefaultComponent(Container).requestFocus()

  returns: `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.requestDefaultFocus))))

(defn request-focus
  "Requests that this Component gets the input focus.
   Refer to Component.requestFocus(boolean) for a complete description of
   this method.

   Note that the use of this method is discouraged because
   its behavior is platform dependent. Instead we recommend the
   use of requestFocusInWindow(boolean).
   If you would like more information on focus, see

   How to Use the Focus Subsystem,
   a section in The Java Tutorial.

  temporary - boolean indicating if the focus change is temporary - `boolean`

  returns: false if the focus change request is guaranteed to
           fail; true if it is likely to succeed - `boolean`"
  (^Boolean [^JComponent this ^Boolean temporary]
    (-> this (.requestFocus temporary)))
  ([^JComponent this]
    (-> this (.requestFocus))))

(defn get-bounds
  "Stores the bounds of this component into `return value`
   rv and returns rv.
   If rv is null a new Rectangle
   is allocated.  This version of getBounds is useful
   if the caller wants to avoid allocating a new Rectangle
   object on the heap.

  rv - the return value, modified to the component's bounds - `java.awt.Rectangle`

  returns: rv; if rv is null
            return a newly created Rectangle with this
            component's bounds - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^JComponent this ^java.awt.Rectangle rv]
    (-> this (.getBounds rv))))

(defn remove-vetoable-change-listener
  "Removes a VetoableChangeListener from the listener list.
   This removes a VetoableChangeListener that was registered
   for all properties.

  listener - the VetoableChangeListener to be removed - `java.beans.VetoableChangeListener`"
  ([^JComponent this ^java.beans.VetoableChangeListener listener]
    (-> this (.removeVetoableChangeListener listener))))

(defn set-focus-traversal-keys
  "Sets the focus traversal keys for a given traversal operation for this
   Component.
   Refer to
   Component.setFocusTraversalKeys(int, java.util.Set<? extends java.awt.AWTKeyStroke>)
   for a complete description of this method.

   This method may throw a ClassCastException if any Object
   in keystrokes is not an AWTKeyStroke.

  id - one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, or KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS - `int`
  keystrokes - the Set of AWTKeyStroke for the specified operation - `java.util.Set`

  throws: java.lang.IllegalArgumentException - if id is not one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, or KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or if keystrokes contains null, or if any keystroke represents a KEY_TYPED event, or if any keystroke already maps to another focus traversal operation for this Component"
  ([^JComponent this ^Integer id ^java.util.Set keystrokes]
    (-> this (.setFocusTraversalKeys id keystrokes))))

(defn reset-keyboard-actions
  "Unregisters all the bindings in the first tier InputMaps
   and ActionMap. This has the effect of removing any
   local bindings, and allowing the bindings defined in parent
   InputMap/ActionMaps
   (the UI is usually defined in the second tier) to persist."
  ([^JComponent this]
    (-> this (.resetKeyboardActions))))

(defn set-verify-input-when-focus-target
  "Sets the value to indicate whether input verifier for the
   current focus owner will be called before this component requests
   focus. The default is true. Set to false on components such as a
   Cancel button or a scrollbar, which should activate even if the
   input in the current focus owner is not `passed` by the input
   verifier for that component.

  verify-input-when-focus-target - value for the verifyInputWhenFocusTarget property - `boolean`"
  ([^JComponent this ^Boolean verify-input-when-focus-target]
    (-> this (.setVerifyInputWhenFocusTarget verify-input-when-focus-target))))

(defn set-request-focus-enabled
  "Provides a hint as to whether or not this JComponent
   should get focus. This is only a hint, and it is up to consumers that
   are requesting focus to honor this property. This is typically honored
   for mouse operations, but not keyboard operations. For example, look
   and feels could verify this property is true before requesting focus
   during a mouse operation. This would often times be used if you did
   not want a mouse press on a JComponent to steal focus,
   but did want the JComponent to be traversable via the
   keyboard. If you do not want this JComponent focusable at
   all, use the setFocusable method instead.

   Please see

   How to Use the Focus Subsystem,
   a section in The Java Tutorial,
   for more information.

  request-focus-enabled - indicates whether you want this JComponent to be focusable or not - `boolean`"
  ([^JComponent this ^Boolean request-focus-enabled]
    (-> this (.setRequestFocusEnabled request-focus-enabled))))

(defn get-transfer-handler
  "Gets the transferHandler property.

  returns: the value of the transferHandler property - `javax.swing.TransferHandler`"
  (^javax.swing.TransferHandler [^JComponent this]
    (-> this (.getTransferHandler))))

(defn get-client-property
  "Returns the value of the property with the specified key.  Only
   properties added with putClientProperty will return
   a non-null value.

  key - the being queried - `java.lang.Object`

  returns: the value of this property or null - `java.lang.Object`"
  (^java.lang.Object [^JComponent this ^java.lang.Object key]
    (-> this (.getClientProperty key))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this JComponent.
   FooListeners are registered using the
   addFooListener method.



   You can specify the listenerType argument
   with a class literal,
   such as
   FooListener.class.
   For example, you can query a
   JComponent c
   for its mouse listeners with the following code:


  MouseListener[] mls = (MouseListener[])(c.getListeners(MouseListener.class));
   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class`

  returns: an array of all objects registered as
            FooListeners on this component,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^JComponent this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn get-visible-rect
  "Returns the Component's `visible rectangle` -  the
   intersection of this component's visible rectangle,
   new Rectangle(0, 0, getWidth(), getHeight()),
   and all of its ancestors' visible rectangles.

  returns: the visible rectangle - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^JComponent this]
    (-> this (.getVisibleRect))))

(defn set-border
  "Sets the border of this component.  The Border object is
   responsible for defining the insets for the component
   (overriding any insets set directly on the component) and
   for optionally rendering any border decorations within the
   bounds of those insets.  Borders should be used (rather
   than insets) for creating both decorative and non-decorative
   (such as margins and padding) regions for a swing component.
   Compound borders can be used to nest multiple borders within a
   single component.

   Although technically you can set the border on any object
   that inherits from JComponent, the look and
   feel implementation of many standard Swing components
   doesn't work well with user-set borders.  In general,
   when you want to set a border on a standard Swing
   component other than JPanel or JLabel,
   we recommend that you put the component in a JPanel
   and set the border on the JPanel.

   This is a bound property.

  border - the border to be rendered for this component - `javax.swing.border.Border`"
  ([^JComponent this ^javax.swing.border.Border border]
    (-> this (.setBorder border))))

(defn get-baseline
  "Returns the baseline.  The baseline is measured from the top of
   the component.  This method is primarily meant for
   LayoutManagers to align components along their
   baseline.  A return value less than 0 indicates this component
   does not have a reasonable baseline and that
   LayoutManagers should not align this component on
   its baseline.

   This method calls into the ComponentUI method of the
   same name.  If this component does not have a ComponentUI
   -1 will be returned.  If a value >= 0 is
   returned, then the component has a valid baseline for any
   size >= the minimum size and getBaselineResizeBehavior
   can be used to determine how the baseline changes with size.

  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: the baseline or < 0 indicating there is no reasonable
           baseline - `int`

  throws: java.lang.IllegalArgumentException - if width or height is < 0"
  (^Integer [^JComponent this ^Integer width ^Integer height]
    (-> this (.getBaseline width height))))

(defn get-root-pane
  "Returns the JRootPane ancestor for this component.

  returns: the JRootPane that contains this component,
            or null if no JRootPane is found - `javax.swing.JRootPane`"
  (^javax.swing.JRootPane [^JComponent this]
    (-> this (.getRootPane))))

(defn set-maximum-size
  "Sets the maximum size of this component to a constant
   value.  Subsequent calls to getMaximumSize will always
   return this value; the component's UI will not be asked
   to compute it.  Setting the maximum size to null
   restores the default behavior.

  maximum-size - a Dimension containing the desired maximum allowable size - `java.awt.Dimension`"
  ([^JComponent this ^java.awt.Dimension maximum-size]
    (-> this (.setMaximumSize maximum-size))))

(defn get-ancestor-listeners
  "Returns an array of all the ancestor listeners
   registered on this component.

  returns: all of the component's AncestorListeners
           or an empty
           array if no ancestor listeners are currently registered - `javax.swing.event.AncestorListener[]`"
  ([^JComponent this]
    (-> this (.getAncestorListeners))))

(defn revalidate
  "Supports deferred automatic layout.

   Calls invalidate and then adds this component's
   validateRoot to a list of components that need to be
   validated.  Validation will occur after all currently pending
   events have been dispatched.  In other words after this method
   is called,  the first validateRoot (if any) found when walking
   up the containment hierarchy of this component will be validated.
   By default, JRootPane, JScrollPane,
   and JTextField return true
   from isValidateRoot.

   This method will automatically be called on this component
   when a property value changes such that size, location, or
   internal layout of this component has been affected.  This automatic
   updating differs from the AWT because programs generally no
   longer need to invoke validate to get the contents of the
   GUI to update."
  ([^JComponent this]
    (-> this (.revalidate))))

(defn get-size
  "Stores the width/height of this component into `return value`
   rv and returns rv.
   If rv is null a new Dimension
   object is allocated.  This version of getSize
   is useful if the caller wants to avoid allocating a new
   Dimension object on the heap.

  rv - the return value, modified to the component's size - `java.awt.Dimension`

  returns: rv - `java.awt.Dimension`"
  (^java.awt.Dimension [^JComponent this ^java.awt.Dimension rv]
    (-> this (.getSize rv))))

(defn managing-focus?
  "Deprecated. As of 1.4, replaced by
     Component.setFocusTraversalKeys(int, Set) and
     Container.setFocusCycleRoot(boolean).

  returns: `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.isManagingFocus))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel.
   JComponent subclasses must override this method
   like this:


     public void updateUI() {
        setUI((SliderUI)UIManager.getUI(this);
     }"
  ([^JComponent this]
    (-> this (.updateUI))))

(defn set-debug-graphics-options
  "Enables or disables diagnostic information about every graphics
   operation performed within the component or one of its children.

  debug-options - determines how the component should display the information; one of the following options: DebugGraphics.LOG_OPTION - causes a text message to be printed. DebugGraphics.FLASH_OPTION - causes the drawing to flash several times. DebugGraphics.BUFFERED_OPTION - creates an ExternalWindow that displays the operations performed on the View's offscreen buffer. DebugGraphics.NONE_OPTION disables debugging. A value of 0 causes no changes to the debugging options. debugOptions is bitwise OR'd into the current value - `int`"
  ([^JComponent this ^Integer debug-options]
    (-> this (.setDebugGraphicsOptions debug-options))))

(defn get-verify-input-when-focus-target?
  "Returns the value that indicates whether the input verifier for the
   current focus owner will be called before this component requests
   focus.

  returns: value of the verifyInputWhenFocusTarget property - `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.getVerifyInputWhenFocusTarget))))

(defn optimized-drawing-enabled?
  "Returns true if this component tiles its children -- that is, if
   it can guarantee that the children will not overlap.  The
   repainting system is substantially more efficient in this
   common case.  JComponent subclasses that can't make this
   guarantee, such as JLayeredPane,
   should override this method to return false.

  returns: always returns true - `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.isOptimizedDrawingEnabled))))

(defn get-top-level-ancestor
  "Returns the top-level ancestor of this component (either the
   containing Window or Applet),
   or null if this component has not
   been added to any container.

  returns: the top-level Container that this component is in,
            or null if not in any container - `java.awt.Container`"
  (^java.awt.Container [^JComponent this]
    (-> this (.getTopLevelAncestor))))

(defn get-preferred-size
  "If the preferredSize has been set to a
   non-null value just returns it.
   If the UI delegate's getPreferredSize
   method returns a non null value then return that;
   otherwise defer to the component's layout manager.

  returns: the value of the preferredSize property - `java.awt.Dimension`"
  (^java.awt.Dimension [^JComponent this]
    (-> this (.getPreferredSize))))

(defn get-input-map
  "Returns the InputMap that is used during
   condition.

  condition - one of WHEN_IN_FOCUSED_WINDOW, WHEN_FOCUSED, WHEN_ANCESTOR_OF_FOCUSED_COMPONENT - `int`

  returns: the InputMap for the specified
            condition - `javax.swing.InputMap`"
  (^javax.swing.InputMap [^JComponent this ^Integer condition]
    (-> this (.getInputMap condition)))
  (^javax.swing.InputMap [^JComponent this]
    (-> this (.getInputMap))))

(defn request-focus-in-window
  "Requests that this Component gets the input focus.
   Refer to Component.requestFocusInWindow() for a complete description of
   this method.

   If you would like more information on focus, see

   How to Use the Focus Subsystem,
   a section in The Java Tutorial.

  returns: false if the focus change request is guaranteed to
           fail; true if it is likely to succeed - `boolean`"
  (^Boolean [^JComponent this]
    (-> this (.requestFocusInWindow))))

(defn add-vetoable-change-listener
  "Adds a VetoableChangeListener to the listener list.
   The listener is registered for all properties.

  listener - the VetoableChangeListener to be added - `java.beans.VetoableChangeListener`"
  ([^JComponent this ^java.beans.VetoableChangeListener listener]
    (-> this (.addVetoableChangeListener listener))))

