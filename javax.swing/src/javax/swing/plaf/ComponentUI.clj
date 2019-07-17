(ns javax.swing.plaf.ComponentUI
  "The base class for all UI delegate objects in the Swing pluggable
  look and feel architecture.  The UI delegate object for a Swing
  component is responsible for implementing the aspects of the
  component that depend on the look and feel.
  The JComponent class
  invokes methods from this class in order to delegate operations
  (painting, layout calculations, etc.) that may vary depending on the
  look and feel installed.  Client programs should not invoke methods
  on this class directly."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf ComponentUI]))

(defn ->component-ui
  "Constructor.

  Sole constructor. (For invocation by subclass constructors,
   typically implicit.)"
  ([]
    (new ComponentUI )))

(defn *create-ui
  "Returns an instance of the UI delegate for the specified component.
   Each subclass must provide its own static createUI
   method that returns an instance of that UI delegate subclass.
   If the UI delegate subclass is stateless, it may return an instance
   that is shared by multiple components.  If the UI delegate is
   stateful, then it should return a new instance per component.
   The default implementation of this method throws an error, as it
   should never be invoked.

  c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (ComponentUI/createUI c)))

(defn install-ui
  "Configures the specified component appropriately for the look and feel.
   This method is invoked when the ComponentUI instance is being installed
   as the UI delegate on the specified component.  This method should
   completely configure the component for the look and feel,
   including the following:

   Install default property values for color, fonts, borders,
       icons, opacity, etc. on the component.  Whenever possible,
       property values initialized by the client program should not
       be overridden.
   Install a LayoutManager on the component if necessary.
   Create/add any required sub-components to the component.
   Create/install event listeners on the component.
   Create/install a PropertyChangeListener on the component in order
       to detect and respond to component property changes appropriately.
   Install keyboard UI (mnemonics, traversal, etc.) on the component.
   Initialize any appropriate instance data.

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.ComponentUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn get-minimum-size
  "Returns the specified component's minimum size appropriate for
   the look and feel.  If null is returned, the minimum
   size will be calculated by the component's layout manager instead
   (this is the preferred approach for any component with a specific
   layout manager installed).  The default implementation of this
   method invokes getPreferredSize and returns that value.

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.ComponentUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn get-maximum-size
  "Returns the specified component's maximum size appropriate for
   the look and feel.  If null is returned, the maximum
   size will be calculated by the component's layout manager instead
   (this is the preferred approach for any component with a specific
   layout manager installed).  The default implementation of this
   method invokes getPreferredSize and returns that value.

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.ComponentUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

(defn get-accessible-child
  "Returns the ith Accessible child of the object.
   UIs might need to override this if they present areas on the
   screen that can be viewed as components, but actual components
   are not used for presenting those areas.



   Note: As of v1.3, it is recommended that developers call
   Component.AccessibleAWTComponent.getAccessibleChild() instead of
   this method.

  c - `javax.swing.JComponent`
  i - zero-based index of child - `int`

  returns: the ith Accessible child of the object - `javax.accessibility.Accessible`"
  (^javax.accessibility.Accessible [^javax.swing.plaf.ComponentUI this ^javax.swing.JComponent c ^Integer i]
    (-> this (.getAccessibleChild c i))))

(defn uninstall-ui
  "Reverses configuration which was done on the specified component during
   installUI.  This method is invoked when this
   UIComponent instance is being removed as the UI delegate
   for the specified component.  This method should undo the
   configuration performed in installUI, being careful to
   leave the JComponent instance in a clean state (no
   extraneous listeners, look-and-feel-specific property objects, etc.).
   This should include the following:

   Remove any UI-set borders from the component.
   Remove any UI-set layout managers on the component.
   Remove any UI-added sub-components from the component.
   Remove any UI-added event/property listeners from the component.
   Remove any UI-installed keyboard UI from the component.
   Nullify any allocated instance data objects to allow for GC.

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.ComponentUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn contains
  "Returns true if the specified x,y location is
   contained within the look and feel's defined shape of the specified
   component. x and y are defined to be relative
   to the coordinate system of the specified component.  Although
   a component's bounds is constrained to a rectangle,
   this method provides the means for defining a non-rectangular
   shape within those bounds for the purpose of hit detection.

  c - the component where the x,y location is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`
  x - the x coordinate of the point - `int`
  y - the y coordinate of the point - `int`

  returns: `boolean`"
  (^Boolean [^javax.swing.plaf.ComponentUI this ^javax.swing.JComponent c ^Integer x ^Integer y]
    (-> this (.contains c x y))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of he component
   changes as the size changes.  This method is primarily meant for
   layout managers and GUI builders.

   This method returns BaselineResizeBehavior.OTHER.
   Subclasses that support a baseline should override appropriately.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  (^java.awt.Component.BaselineResizeBehavior [^javax.swing.plaf.ComponentUI this ^javax.swing.JComponent c]
    (-> this (.getBaselineResizeBehavior c))))

(defn update
  "Notifies this UI delegate that it is time to paint the specified
   component.  This method is invoked by JComponent
   when the specified component is being painted.

   By default this method fills the specified component with
   its background color if its opaque property is true,
   and then immediately calls paint. In general this method need
   not be overridden by subclasses; all look-and-feel rendering code should
   reside in the paint method.

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.ComponentUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.update g c))))

(defn get-accessible-children-count
  "Returns the number of accessible children in the object.  If all
   of the children of this object implement Accessible,
   this
   method should return the number of children of this object.
   UIs might wish to override this if they present areas on the
   screen that can be viewed as components, but actual components
   are not used for presenting those areas.

   Note: As of v1.3, it is recommended that developers call
   Component.AccessibleAWTComponent.getAccessibleChildrenCount() instead
   of this method.

  c - `javax.swing.JComponent`

  returns: the number of accessible children in the object - `int`"
  (^Integer [^javax.swing.plaf.ComponentUI this ^javax.swing.JComponent c]
    (-> this (.getAccessibleChildrenCount c))))

(defn paint
  "Paints the specified component appropriately for the look and feel.
   This method is invoked from the ComponentUI.update method when
   the specified component is being painted.  Subclasses should override
   this method and use the specified Graphics object to
   render the content of the component.

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.ComponentUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-baseline
  "Returns the baseline.  The baseline is measured from the top of
   the component.  This method is primarily meant for
   LayoutManagers to align components along their
   baseline.  A return value less than 0 indicates this component
   does not have a reasonable baseline and that
   LayoutManagers should not align this component on
   its baseline.

   This method returns -1.  Subclasses that have a meaningful baseline
   should override appropriately.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  (^Integer [^javax.swing.plaf.ComponentUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn get-preferred-size
  "Returns the specified component's preferred size appropriate for
   the look and feel.  If null is returned, the preferred
   size will be calculated by the component's layout manager instead
   (this is the preferred approach for any component with a specific
   layout manager installed).  The default implementation of this
   method returns null.

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.ComponentUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

