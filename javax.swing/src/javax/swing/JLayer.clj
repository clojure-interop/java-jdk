(ns javax.swing.JLayer
  "JLayer is a universal decorator for Swing components
  which enables you to implement various advanced painting effects as well as
  receive notifications of all AWTEvents generated within its borders.

  JLayer delegates the handling of painting and input events to a
  LayerUI object, which performs the actual decoration.

  The custom painting implemented in the LayerUI and events notification
  work for the JLayer itself and all its subcomponents.
  This combination enables you to enrich existing components
  by adding new advanced functionality such as temporary locking of a hierarchy,
  data tips for compound components, enhanced mouse scrolling etc and so on.

  JLayer is a good solution if you only need to do custom painting
  over compound component or catch input events from its subcomponents.


  import javax.swing.*;
  import javax.swing.plaf.LayerUI;
  import java.awt.*;

  public class JLayerSample {

      private static JLayer<JComponent> createLayer() {
          // This custom layerUI will fill the layer with translucent green
          // and print out all mouseMotion events generated within its borders
          LayerUI<JComponent> layerUI = new LayerUI<JComponent>() {

              public void paint(Graphics g, JComponent c) {
                  // paint the layer as is
                  super.paint(g, c);
                  // fill it with the translucent green
                  g.setColor(new Color(0, 128, 0, 128));
                  g.fillRect(0, 0, c.getWidth(), c.getHeight());
              }

              public void installUI(JComponent c) {
                  super.installUI(c);
                  // enable mouse motion events for the layer's subcomponents
                  ((JLayer) c).setLayerEventMask(AWTEvent.MOUSE_MOTION_EVENT_MASK);
              }

              public void uninstallUI(JComponent c) {
                  super.uninstallUI(c);
                  // reset the layer event mask
                  ((JLayer) c).setLayerEventMask(0);
              }

              // overridden method which catches MouseMotion events
              public void eventDispatched(AWTEvent e, JLayer<? extends JComponent> l) {
                  System.out.println(\"AWTEvent detected: \"  e);
              }
          };
          // create a component to be decorated with the layer
          JPanel panel = new JPanel();
          panel.add(new JButton(\"JButton\"));

          // create the layer for the panel using our custom layerUI
          return new JLayer<JComponent>(panel, layerUI);
      }

      private static void createAndShowGUI() {
          final JFrame frame = new JFrame();
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          // work with the layer as with any other Swing component
          frame.add(createLayer());

          frame.setSize(200, 200);
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
      }

      public static void main(String[] args) throws Exception {
          SwingUtilities.invokeAndWait(new Runnable() {
              public void run() {
                  createAndShowGUI();
              }
          });
      }
  }

  Note: JLayer doesn't support the following methods:

  Container.add(java.awt.Component)
  Container.add(String, java.awt.Component)
  Container.add(java.awt.Component, int)
  Container.add(java.awt.Component, Object)
  Container.add(java.awt.Component, Object, int)

  using any of of them will cause UnsupportedOperationException to be thrown,
  to add a component to JLayer
  use setView(Component) or setGlassPane(JPanel)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JLayer]))

(defn ->j-layer
  "Constructor.

  Creates a new JLayer object with the specified view component
   and LayerUI object.

  view - the component to be decorated - `V`
  ui - the LayerUI delegate to be used by this JLayer - `javax.swing.plaf.LayerUI`"
  (^JLayer [view ^javax.swing.plaf.LayerUI ui]
    (new JLayer view ui))
  (^JLayer [view]
    (new JLayer view))
  (^JLayer []
    (new JLayer )))

(defn create-glass-pane
  "Called by the constructor methods to create a default glassPane.
   By default this method creates a new JPanel with visibility set to true
   and opacity set to false.

  returns: the default glassPane - `javax.swing.JPanel`"
  (^javax.swing.JPanel [^JLayer this]
    (-> this (.createGlassPane))))

(defn set-layout
  "Sets the layout manager for this container.  This method is
   overridden to prevent the layout manager from being set.
   Note:  If mgr is non-null, this
   method will throw an exception as layout managers are not supported on
   a JLayer.

  mgr - the specified layout manager - `java.awt.LayoutManager`

  throws: java.lang.IllegalArgumentException - this method is not supported"
  ([^JLayer this ^java.awt.LayoutManager mgr]
    (-> this (.setLayout mgr))))

(defn get-view
  "Returns the JLayer's view component or null.
   This is a bound property.

  returns: the JLayer's view component
           or null if none exists - `V`"
  ([^JLayer this]
    (-> this (.getView))))

(defn get-scrollable-block-increment
  "Returns a scroll increment, which is required for components
   that display logical rows or columns in order to completely expose
   one block of rows or columns, depending on the value of orientation.

   If the view component of this layer implements Scrollable, this method delegates its
   implementation to the view component.

  visible-rect - The view area visible within the viewport - `java.awt.Rectangle`
  orientation - Either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL. - `int`
  direction - Less than zero to scroll up/left, greater than zero for down/right. - `int`

  returns: the \"block\" increment for scrolling in the specified direction - `int`"
  (^Integer [^JLayer this ^java.awt.Rectangle visible-rect ^Integer orientation ^Integer direction]
    (-> this (.getScrollableBlockIncrement visible-rect orientation direction))))

(defn get-scrollable-unit-increment
  "Returns a scroll increment, which is required for components
   that display logical rows or columns in order to completely expose
   one new row or column, depending on the value of orientation.
   Ideally, components should handle a partially exposed row or column
   by returning the distance required to completely expose the item.

   Scrolling containers, like JScrollPane, will use this method
   each time the user requests a unit scroll.

   If the view component of this layer implements Scrollable, this method delegates its
   implementation to the view component.

  visible-rect - The view area visible within the viewport - `java.awt.Rectangle`
  orientation - Either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL. - `int`
  direction - Less than zero to scroll up/left, greater than zero for down/right. - `int`

  returns: The \"unit\" increment for scrolling in the specified direction.
           This value should always be positive. - `int`"
  (^Integer [^JLayer this ^java.awt.Rectangle visible-rect ^Integer orientation ^Integer direction]
    (-> this (.getScrollableUnitIncrement visible-rect orientation direction))))

(defn property-change
  "This method gets called when a bound property is changed.

  evt - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([^JLayer this ^java.beans.PropertyChangeEvent evt]
    (-> this (.propertyChange evt))))

(defn add-notify
  "Notifies this component that it now has a parent component.
   When this method is invoked, the chain of parent components is
   set up with KeyboardAction event listeners.
   This method is called by the toolkit internally and should
   not be called directly by programs."
  ([^JLayer this]
    (-> this (.addNotify))))

(defn get-preferred-scrollable-viewport-size
  "Returns the preferred size of the viewport for a view component.

   If the view component of this layer implements Scrollable, this method delegates its
   implementation to the view component.

  returns: the preferred size of the viewport for a view component - `java.awt.Dimension`"
  (^java.awt.Dimension [^JLayer this]
    (-> this (.getPreferredScrollableViewportSize))))

(defn set-ui
  "Sets the LayerUI which will perform painting
   and receive input events for this JLayer.

  ui - the LayerUI for this JLayer - `javax.swing.plaf.LayerUI`"
  ([^JLayer this ^javax.swing.plaf.LayerUI ui]
    (-> this (.setUI ui))))

(defn remove-notify
  "Notifies this component that it no longer has a parent component.
   When this method is invoked, any KeyboardActions
   set up in the the chain of parent components are removed.
   This method is called by the toolkit internally and should
   not be called directly by programs."
  ([^JLayer this]
    (-> this (.removeNotify))))

(defn get-layer-event-mask
  "Returns the bitmap of event mask to receive by this JLayer
   and its LayerUI.

   It means that LayerUI.eventDispatched(AWTEvent, JLayer) method
   will only receive events that match the event mask.

   By default JLayer receives no events.

  returns: the bitmask of event types to receive for this JLayer - `long`"
  (^Long [^JLayer this]
    (-> this (.getLayerEventMask))))

(defn remove
  "Removes the specified component from this container.
   This method also notifies the layout manager to remove the
   component from this container's layout via the
   removeLayoutComponent method.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy. If the container has already been
   displayed, the hierarchy must be validated thereafter in order to
   reflect the changes.

  comp - the component to be removed - `java.awt.Component`"
  ([^JLayer this ^java.awt.Component comp]
    (-> this (.remove comp))))

(defn paint-immediately
  "Delegates its functionality to the
   LayerUI.paintImmediately(int, int, int, int, JLayer) method,
   if LayerUI is set.

  x - the x value of the region to be painted - `int`
  y - the y value of the region to be painted - `int`
  w - the width of the region to be painted - `int`
  h - the height of the region to be painted - `int`"
  ([^JLayer this ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintImmediately x y w h))))

(defn get-ui
  "Returns the LayerUI for this JLayer.

  returns: the LayerUI for this JLayer - `javax.swing.plaf.LayerUI<? super V>`"
  ([^JLayer this]
    (-> this (.getUI))))

(defn set-layer-event-mask
  "Enables the events from JLayer and all its descendants
   defined by the specified event mask parameter
   to be delivered to the
   LayerUI.eventDispatched(AWTEvent, JLayer) method.

   Events are delivered provided that LayerUI is set
   for this JLayer and the JLayer
   is displayable.

   The following example shows how to correctly use this method
   in the LayerUI implementations:


      public void installUI(JComponent c) {
         super.installUI(c);
         JLayer l = (JLayer) c;
         // this LayerUI will receive only key and focus events
         l.setLayerEventMask(AWTEvent.KEY_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK);
      }

      public void uninstallUI(JComponent c) {
         super.uninstallUI(c);
         JLayer l = (JLayer) c;
         // JLayer must be returned to its initial state
         l.setLayerEventMask(0);
      }

   By default JLayer receives no events and its event mask is 0.

  layer-event-mask - the bitmask of event types to receive - `long`"
  ([^JLayer this ^Long layer-event-mask]
    (-> this (.setLayerEventMask layer-event-mask))))

(defn get-scrollable-tracks-viewport-width?
  "Returns false to indicate that the width of the viewport does not
   determine the width of the layer, unless the preferred width
   of the layer is smaller than the width of the viewport.

   If the view component of this layer implements Scrollable, this method delegates its
   implementation to the view component.

  returns: whether the layer should track the width of the viewport - `boolean`"
  (^Boolean [^JLayer this]
    (-> this (.getScrollableTracksViewportWidth))))

(defn get-glass-pane
  "Returns the JLayer's glassPane component or null.
   This is a bound property.

  returns: the JLayer's glassPane component
           or null if none exists - `javax.swing.JPanel`"
  (^javax.swing.JPanel [^JLayer this]
    (-> this (.getGlassPane))))

(defn paint
  "Delegates all painting to the LayerUI object.

  g - the Graphics to render to - `java.awt.Graphics`"
  ([^JLayer this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JLayer.

  returns: the AccessibleContext associated with this JLayer. - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JLayer this]
    (-> this (.getAccessibleContext))))

(defn set-glass-pane
  "Sets the JLayer's glassPane component, which can be null.
   This is a bound property.

  glass-pane - the glassPane component of this JLayer - `javax.swing.JPanel`"
  ([^JLayer this ^javax.swing.JPanel glass-pane]
    (-> this (.setGlassPane glass-pane))))

(defn do-layout
  "Delegates its functionality to the LayerUI.doLayout(JLayer) method,
   if LayerUI is set."
  ([^JLayer this]
    (-> this (.doLayout))))

(defn get-scrollable-tracks-viewport-height?
  "Returns false to indicate that the height of the viewport does not
   determine the height of the layer, unless the preferred height
   of the layer is smaller than the height of the viewport.

   If the view component of this layer implements Scrollable, this method delegates its
   implementation to the view component.

  returns: whether the layer should track the height of the viewport - `boolean`"
  (^Boolean [^JLayer this]
    (-> this (.getScrollableTracksViewportHeight))))

(defn set-border
  "A non-null border, or non-zero insets, isn't supported, to prevent the geometry
   of this component from becoming complex enough to inhibit
   subclassing of LayerUI class.  To create a JLayer with a border,
   add it to a JPanel that has a border.
   Note:  If border is non-null, this
   method will throw an exception as borders are not supported on
   a JLayer.

  border - the Border to set - `javax.swing.border.Border`

  throws: java.lang.IllegalArgumentException - this method is not supported"
  ([^JLayer this ^javax.swing.border.Border border]
    (-> this (.setBorder border))))

(defn remove-all
  "Removes all the components from this container.
   This method also notifies the layout manager to remove the
   components from this container's layout via the
   removeLayoutComponent method.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy. If the container has already been
   displayed, the hierarchy must be validated thereafter in order to
   reflect the changes."
  ([^JLayer this]
    (-> this (.removeAll))))

(defn update-ui
  "Delegates its functionality to the LayerUI.updateUI(JLayer) method,
   if LayerUI is set."
  ([^JLayer this]
    (-> this (.updateUI))))

(defn set-view
  "Sets the JLayer's view component, which can be null.
   This is a bound property.

  view - the view component for this JLayer - `V`"
  ([^JLayer this view]
    (-> this (.setView view))))

(defn optimized-drawing-enabled?
  "The JLayer overrides the default implementation of
   this method (in JComponent) to return false.
   This ensures
   that the drawing machinery will call the JLayer's
   paint
   implementation rather than messaging the JLayer's
   children directly.

  returns: false - `boolean`"
  (^Boolean [^JLayer this]
    (-> this (.isOptimizedDrawingEnabled))))

