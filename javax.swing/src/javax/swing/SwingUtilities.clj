(ns javax.swing.SwingUtilities
  "A collection of utility methods for Swing."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SwingUtilities]))

(defn *rectangle-containing-rectangle?
  "Return true if a contains b

  a - `java.awt.Rectangle`
  b - `java.awt.Rectangle`

  returns: `boolean`"
  ([a b]
    (SwingUtilities/isRectangleContainingRectangle a b)))

(defn *window-for-component
  "Returns the first Window  ancestor of c, or
   null if c is not contained inside a Window.

   Note: This method provides the same functionality as
   getWindowAncestor.

  c - Component to get Window ancestor of. - `java.awt.Component`

  returns: the first Window  ancestor of c, or
           null if c is not contained inside a
           Window. - `java.awt.Window`"
  ([c]
    (SwingUtilities/windowForComponent c)))

(defn *convert-rectangle
  "Convert the rectangle aRectangle in source coordinate system to
   destination coordinate system.
   If source is null, aRectangle is assumed to be in destination's
   root component coordinate system.
   If destination is null, aRectangle will be converted to source's
   root component coordinate system.
   If both source and destination are null, return aRectangle
   without any conversion.

  source - `java.awt.Component`
  a-rectangle - `java.awt.Rectangle`
  destination - `java.awt.Component`

  returns: `java.awt.Rectangle`"
  ([source a-rectangle destination]
    (SwingUtilities/convertRectangle source a-rectangle destination)))

(defn *invoke-later
  "Causes doRun.run() to be executed asynchronously on the
   AWT event dispatching thread.  This will happen after all
   pending AWT events have been processed.  This method should
   be used when an application thread needs to update the GUI.
   In the following example the invokeLater call queues
   the Runnable object doHelloWorld
   on the event dispatching thread and
   then prints a message.


   Runnable doHelloWorld = new Runnable() {
       public void run() {
           System.out.println(`Hello World on `  Thread.currentThread());
       }
   };

   SwingUtilities.invokeLater(doHelloWorld);
   System.out.println(`This might well be displayed before the other message.`);
   If invokeLater is called from the event dispatching thread --
   for example, from a JButton's ActionListener -- the doRun.run() will
   still be deferred until all pending events have been processed.
   Note that if the doRun.run() throws an uncaught exception
   the event dispatching thread will unwind (not the current thread).

   Additional documentation and examples for this method can be
   found in
   Concurrency in Swing.

   As of 1.3 this method is just a cover for java.awt.EventQueue.invokeLater().

   Unlike the rest of Swing, this method can be invoked from any thread.

  do-run - `java.lang.Runnable`"
  ([do-run]
    (SwingUtilities/invokeLater do-run)))

(defn *compute-difference
  "Convenience returning an array of rect representing the regions within
   rectA that do not overlap with rectB. If the
   two Rects do not overlap, returns an empty array

  rect-a - `java.awt.Rectangle`
  rect-b - `java.awt.Rectangle`

  returns: `java.awt.Rectangle[]`"
  ([rect-a rect-b]
    (SwingUtilities/computeDifference rect-a rect-b)))

(defn *invoke-and-wait
  "Causes doRun.run() to be executed synchronously on the
   AWT event dispatching thread.  This call blocks until
   all pending AWT events have been processed and (then)
   doRun.run() returns. This method should
   be used when an application thread needs to update the GUI.
   It shouldn't be called from the event dispatching thread.
   Here's an example that creates a new application thread
   that uses invokeAndWait to print a string from the event
   dispatching thread and then, when that's finished, print
   a string from the application thread.


   final Runnable doHelloWorld = new Runnable() {
       public void run() {
           System.out.println(`Hello World on `  Thread.currentThread());
       }
   };

   Thread appThread = new Thread() {
       public void run() {
           try {
               SwingUtilities.invokeAndWait(doHelloWorld);
           }
           catch (Exception e) {
               e.printStackTrace();
           }
           System.out.println(`Finished on `  Thread.currentThread());
       }
   };
   appThread.start();
   Note that if the Runnable.run method throws an
   uncaught exception
   (on the event dispatching thread) it's caught and rethrown, as
   an InvocationTargetException, on the caller's thread.

   Additional documentation and examples for this method can be
   found in
   Concurrency in Swing.

   As of 1.3 this method is just a cover for
   java.awt.EventQueue.invokeAndWait().

  do-run - `java.lang.Runnable`

  throws: java.lang.InterruptedException - if we're interrupted while waiting for the event dispatching thread to finish executing doRun.run()"
  ([do-run]
    (SwingUtilities/invokeAndWait do-run)))

(defn *get-unwrapped-view
  "Returns the first JViewport's descendant
   which is not an instance of JLayer.
   If such a descendant can not be found, null is returned.

   If the viewport's view component is not a JLayer,
   this method is equivalent to JViewport.getView()
   otherwise JLayer.getView() will be recursively
   called on all descending JLayers.

  viewport - JViewport to get the first descendant of, which in not a JLayer instance. - `javax.swing.JViewport`

  returns: the first JViewport's descendant
   which is not an instance of JLayer.
   If such a descendant can not be found, null is returned. - `java.awt.Component`

  throws: java.lang.NullPointerException - if viewport is null"
  ([viewport]
    (SwingUtilities/getUnwrappedView viewport)))

(defn *get-accessible-child
  "Return the nth Accessible child of the object.

   Note: as of the Java 2 platform v1.3, it is recommended that developers call
   Component.AccessibleAWTComponent.getAccessibleIndexInParent() instead
   of using this method.

  c - `java.awt.Component`
  i - zero-based index of child - `int`

  returns: the nth Accessible child of the object - `javax.accessibility.Accessible`"
  ([c i]
    (SwingUtilities/getAccessibleChild c i)))

(defn *left-mouse-button?
  "Returns true if the mouse event specifies the left mouse button.

  an-event - a MouseEvent object - `java.awt.event.MouseEvent`

  returns: true if the left mouse button was active - `boolean`"
  ([an-event]
    (SwingUtilities/isLeftMouseButton an-event)))

(defn *find-focus-owner
  "Deprecated. As of 1.4, replaced by
     KeyboardFocusManager.getFocusOwner().

  c - the root of the Component hierarchy to search for the focus owner - `java.awt.Component`

  returns: the focus owner, or null if there is no focus
           owner, or if the focus owner is not comp, or a
           descendant of comp - `java.lang.   java.awt.Component`"
  ([c]
    (SwingUtilities/findFocusOwner c)))

(defn *middle-mouse-button?
  "Returns true if the mouse event specifies the middle mouse button.

  an-event - a MouseEvent object - `java.awt.event.MouseEvent`

  returns: true if the middle mouse button was active - `boolean`"
  ([an-event]
    (SwingUtilities/isMiddleMouseButton an-event)))

(defn *get-ui-input-map
  "Returns the InputMap provided by the UI for condition
   condition in component component.
   This will return null if the UI has not installed a InputMap
   of the specified type.

  component - `javax.swing.JComponent`
  condition - `int`

  returns: `javax.swing.InputMap`"
  ([component condition]
    (SwingUtilities/getUIInputMap component condition)))

(defn *calculate-inner-area
  "Stores the position and size of
   the inner painting area of the specified component
   in r and returns r.
   The position and size specify the bounds of the component,
   adjusted so as not to include the border area (the insets).
   This method is useful for classes
   that implement painting code.

  c - the JComponent in question; if null, this method returns null - `javax.swing.JComponent`
  r - the Rectangle instance to be modified; may be null - `java.awt.Rectangle`

  returns: null if the Component is null;
           otherwise, returns the passed-in rectangle (if non-null)
           or a new rectangle specifying position and size information - `java.awt.Rectangle`"
  ([c r]
    (SwingUtilities/calculateInnerArea c r)))

(defn *get-accessible-state-set
  "Get the state of this object.

   Note: as of the Java 2 platform v1.3, it is recommended that developers call
   Component.AccessibleAWTComponent.getAccessibleIndexInParent() instead
   of using this method.

  c - `java.awt.Component`

  returns: an instance of AccessibleStateSet containing the current state
   set of the object - `javax.accessibility.AccessibleStateSet`"
  ([c]
    (SwingUtilities/getAccessibleStateSet c)))

(defn *get-ui-action-map
  "Returns the ActionMap provided by the UI
   in component component.
   This will return null if the UI has not installed an ActionMap.

  component - `javax.swing.JComponent`

  returns: `javax.swing.ActionMap`"
  ([component]
    (SwingUtilities/getUIActionMap component)))

(defn *layout-compound-label
  "Compute and return the location of the icons origin, the
   location of origin of the text baseline, and a possibly clipped
   version of the compound labels string.  Locations are computed
   relative to the viewR rectangle.
   The JComponents orientation (LEADING/TRAILING) will also be taken
   into account and translated into LEFT/RIGHT values accordingly.

  c - `javax.swing.JComponent`
  fm - `java.awt.FontMetrics`
  text - `java.lang.String`
  icon - `javax.swing.Icon`
  vertical-alignment - `int`
  horizontal-alignment - `int`
  vertical-text-position - `int`
  horizontal-text-position - `int`
  view-r - `java.awt.Rectangle`
  icon-r - `java.awt.Rectangle`
  text-r - `java.awt.Rectangle`
  text-icon-gap - `int`

  returns: `java.lang.String`"
  ([c fm text icon vertical-alignment horizontal-alignment vertical-text-position horizontal-text-position view-r icon-r text-r text-icon-gap]
    (SwingUtilities/layoutCompoundLabel c fm text icon vertical-alignment horizontal-alignment vertical-text-position horizontal-text-position view-r icon-r text-r text-icon-gap))
  ([fm text icon vertical-alignment horizontal-alignment vertical-text-position horizontal-text-position view-r icon-r text-r text-icon-gap]
    (SwingUtilities/layoutCompoundLabel fm text icon vertical-alignment horizontal-alignment vertical-text-position horizontal-text-position view-r icon-r text-r text-icon-gap)))

(defn *get-unwrapped-parent
  "Returns the first ancestor of the component
   which is not an instance of JLayer.

  component - Component to get the first ancestor of, which is not a JLayer instance. - `java.awt.Component`

  returns: the first ancestor of the component
   which is not an instance of JLayer.
   If such an ancestor can not be found, null is returned. - `java.awt.Container`

  throws: java.lang.NullPointerException - if component is null"
  ([component]
    (SwingUtilities/getUnwrappedParent component)))

(defn *get-ancestor-of-class
  "Convenience method for searching above comp in the
   component hierarchy and returns the first object of class c it
   finds. Can return null, if a class c cannot be found.

  c - `java.lang.Class<?>`
  comp - `java.awt.Component`

  returns: `java.awt.Container`"
  ([c comp]
    (SwingUtilities/getAncestorOfClass c comp)))

(defn *paint-component
  "Paints a component to the specified Graphics.
   This method is primarily useful to render
   Components that don't exist as part of the visible
   containment hierarchy, but are used for rendering.  For
   example, if you are doing your own rendering and want to render
   some text (or even HTML), you could make use of
   JLabel's text rendering support and have it paint
   directly by way of this method, without adding the label to the
   visible containment hierarchy.

   This method makes use of CellRendererPane to handle
   the actual painting, and is only recommended if you use one
   component for rendering.  If you make use of multiple components
   to handle the rendering, as JTable does, use
   CellRendererPane directly.  Otherwise, as described
   below, you could end up with a CellRendererPane
   per Component.

   If c's parent is not a CellRendererPane,
   a new CellRendererPane is created, c is
   added to it, and the CellRendererPane is added to
   p.  If c's parent is a
   CellRendererPane and the CellRendererPanes
   parent is not p, it is added to p.

   The component should either descend from JComponent
   or be another kind of lightweight component.
   A lightweight component is one whose `lightweight` property
   (returned by the Component
   isLightweight method)
   is true. If the Component is not lightweight, bad things map happen:
   crashes, exceptions, painting problems...

  g - the Graphics object to draw on - `java.awt.Graphics`
  c - the Component to draw - `java.awt.Component`
  p - the intermediate Container - `java.awt.Container`
  x - an int specifying the left side of the area draw in, in pixels, measured from the left edge of the graphics context - `int`
  y - an int specifying the top of the area to draw in, in pixels measured down from the top edge of the graphics context - `int`
  w - an int specifying the width of the area draw in, in pixels - `int`
  h - an int specifying the height of the area draw in, in pixels - `int`"
  ([g c p x y w h]
    (SwingUtilities/paintComponent g c p x y w h))
  ([g c p r]
    (SwingUtilities/paintComponent g c p r)))

(defn *update-component-tree-ui
  "A simple minded look and feel change: ask each node in the tree
   to updateUI() -- that is, to initialize its UI property
   with the current look and feel.

  c - `java.awt.Component`"
  ([c]
    (SwingUtilities/updateComponentTreeUI c)))

(defn *get-local-bounds
  "Return the rectangle (0,0,bounds.width,bounds.height) for the component aComponent

  a-component - `java.awt.Component`

  returns: `java.awt.Rectangle`"
  ([a-component]
    (SwingUtilities/getLocalBounds a-component)))

(defn *compute-union
  "Convenience method that calculates the union of two rectangles
   without allocating a new rectangle.

  x - the x-coordinate of the first rectangle - `int`
  y - the y-coordinate of the first rectangle - `int`
  width - the width of the first rectangle - `int`
  height - the height of the first rectangle - `int`
  dest - the coordinates of the second rectangle; the union of the two rectangles is returned in this rectangle - `java.awt.Rectangle`

  returns: the dest Rectangle - `java.awt.Rectangle`"
  ([x y width height dest]
    (SwingUtilities/computeUnion x y width height dest)))

(defn *compute-intersection
  "Convenience to calculate the intersection of two rectangles
   without allocating a new rectangle.
   If the two rectangles don't intersect,
   then the returned rectangle begins at (0,0)
   and has zero width and height.

  x - the X coordinate of the first rectangle's top-left point - `int`
  y - the Y coordinate of the first rectangle's top-left point - `int`
  width - the width of the first rectangle - `int`
  height - the height of the first rectangle - `int`
  dest - the second rectangle - `java.awt.Rectangle`

  returns: dest, modified to specify the intersection - `java.awt.Rectangle`"
  ([x y width height dest]
    (SwingUtilities/computeIntersection x y width height dest)))

(defn *replace-ui-input-map
  "Convenience method to change the UI InputMap for component
   to uiInputMap. If uiInputMap is null,
   this removes any previously installed UI InputMap.

  component - `javax.swing.JComponent`
  type - `int`
  ui-input-map - `javax.swing.InputMap`"
  ([component type ui-input-map]
    (SwingUtilities/replaceUIInputMap component type ui-input-map)))

(defn *event-dispatch-thread?
  "Returns true if the current thread is an AWT event dispatching thread.

   As of 1.3 this method is just a cover for
   java.awt.EventQueue.isDispatchThread().

  returns: true if the current thread is an AWT event dispatching thread - `boolean`"
  ([]
    (SwingUtilities/isEventDispatchThread )))

(defn *get-accessible-children-count
  "Returns the number of accessible children in the object.  If all
   of the children of this object implement Accessible, than this
   method should return the number of children of this object.

   Note: as of the Java 2 platform v1.3, it is recommended that developers call
   Component.AccessibleAWTComponent.getAccessibleIndexInParent() instead
   of using this method.

  c - `java.awt.Component`

  returns: the number of accessible children in the object. - `int`"
  ([c]
    (SwingUtilities/getAccessibleChildrenCount c)))

(defn *convert-mouse-event
  "Returns a MouseEvent similar to sourceEvent except that its x
   and y members have been converted to destination's coordinate
   system.  If source is null, sourceEvent x and y members
   are assumed to be into destination's root component coordinate system.
   If destination is null, the
   returned MouseEvent will be in source's coordinate system.
   sourceEvent will not be changed. A new event is returned.
   the source field of the returned event will be set
   to destination if destination is non-null
   use the translateMouseEvent() method to translate a mouse event from
   one component to another without changing the source.

  source - `java.awt.Component`
  source-event - `java.awt.event.MouseEvent`
  destination - `java.awt.Component`

  returns: `java.awt.event.MouseEvent`"
  ([source source-event destination]
    (SwingUtilities/convertMouseEvent source source-event destination)))

(defn *get-root
  "Returns the root component for the current component tree.

  c - `java.awt.Component`

  returns: the first ancestor of c that's a Window or the last Applet ancestor - `java.awt.Component`"
  ([c]
    (SwingUtilities/getRoot c)))

(defn *process-key-bindings
  "Process the key bindings for the Component associated with
   event. This method is only useful if
   event.getComponent() does not descend from
   JComponent, or your are not invoking
   super.processKeyEvent from within your
   JComponent subclass. JComponent
   automatically processes bindings from within its
   processKeyEvent method, hence you rarely need
   to directly invoke this method.

  event - KeyEvent used to identify which bindings to process, as well as which Component has focus. - `java.awt.event.KeyEvent`

  returns: true if a binding has found and processed - `boolean`"
  ([event]
    (SwingUtilities/processKeyBindings event)))

(defn *get-deepest-component-at
  "Returns the deepest visible descendent Component of parent
   that contains the location x, y.
   If parent does not contain the specified location,
   then null is returned.  If parent is not a
   container, or none of parent's visible descendents
   contain the specified location, parent is returned.

  parent - the root component to begin the search - `java.awt.Component`
  x - the x target location - `int`
  y - the y target location - `int`

  returns: `java.awt.Component`"
  ([parent x y]
    (SwingUtilities/getDeepestComponentAt parent x y)))

(defn *right-mouse-button?
  "Returns true if the mouse event specifies the right mouse button.

  an-event - a MouseEvent object - `java.awt.event.MouseEvent`

  returns: true if the right mouse button was active - `boolean`"
  ([an-event]
    (SwingUtilities/isRightMouseButton an-event)))

(defn *notify-action
  "Invokes actionPerformed on action if
   action is enabled (and non-null). The command for the
   ActionEvent is determined by:

     If the action was registered via
         registerKeyboardAction, then the command string
         passed in (null will be used if null was passed in).
     Action value with name Action.ACTION_COMMAND_KEY, unless null.
     String value of the KeyEvent, unless getKeyChar
         returns KeyEvent.CHAR_UNDEFINED..

   This will return true if action is non-null and
   actionPerformed is invoked on it.

  action - `javax.swing.Action`
  ks - `javax.swing.KeyStroke`
  event - `java.awt.event.KeyEvent`
  sender - `java.lang.Object`
  modifiers - `int`

  returns: `boolean`"
  ([action ks event sender modifiers]
    (SwingUtilities/notifyAction action ks event sender modifiers)))

(defn *convert-point
  "Convert the point (x,y) in source coordinate system to
   destination coordinate system.
   If source is null, (x,y) is assumed to be in destination's
   root component coordinate system.
   If destination is null, (x,y) will be converted to source's
   root component coordinate system.
   If both source and destination are null, return (x,y)
   without any conversion.

  source - `java.awt.Component`
  x - `int`
  y - `int`
  destination - `java.awt.Component`

  returns: `java.awt.Point`"
  ([source x y destination]
    (SwingUtilities/convertPoint source x y destination))
  ([source a-point destination]
    (SwingUtilities/convertPoint source a-point destination)))

(defn *convert-point-to-screen
  "Convert a point from a component's coordinate system to
   screen coordinates.

  p - a Point object (converted to the new coordinate system) - `java.awt.Point`
  c - a Component object - `java.awt.Component`"
  ([p c]
    (SwingUtilities/convertPointToScreen p c)))

(defn *replace-ui-action-map
  "Convenience method to change the UI ActionMap for component
   to uiActionMap. If uiActionMap is null,
   this removes any previously installed UI ActionMap.

  component - `javax.swing.JComponent`
  ui-action-map - `javax.swing.ActionMap`"
  ([component ui-action-map]
    (SwingUtilities/replaceUIActionMap component ui-action-map)))

(defn *compute-string-width
  "Compute the width of the string using a font with the specified
   `metrics` (sizes).

  fm - a FontMetrics object to compute with - `java.awt.FontMetrics`
  str - the String to compute - `java.lang.String`

  returns: an int containing the string width - `int`"
  ([fm str]
    (SwingUtilities/computeStringWidth fm str)))

(defn *get-accessible-at
  "Returns the Accessible child contained at the
   local coordinate Point, if one exists.
   Otherwise returns null.

  c - `java.awt.Component`
  p - `java.awt.Point`

  returns: the Accessible at the specified location,
      if it exists; otherwise null - `javax.accessibility.Accessible`"
  ([c p]
    (SwingUtilities/getAccessibleAt c p)))

(defn *get-root-pane
  "If c is a JRootPane descendant return its JRootPane ancestor.
   If c is a RootPaneContainer then return its JRootPane.

  c - `java.awt.Component`

  returns: the JRootPane for Component c or null. - `javax.swing.JRootPane`"
  ([c]
    (SwingUtilities/getRootPane c)))

(defn *descending-from?
  "Return true if a component a descends from a component b

  a - `java.awt.Component`
  b - `java.awt.Component`

  returns: `boolean`"
  ([a b]
    (SwingUtilities/isDescendingFrom a b)))

(defn *get-ancestor-named
  "Convenience method for searching above comp in the
   component hierarchy and returns the first object of name it
   finds. Can return null, if name cannot be found.

  name - `java.lang.String`
  comp - `java.awt.Component`

  returns: `java.awt.Container`"
  ([name comp]
    (SwingUtilities/getAncestorNamed name comp)))

(defn *convert-point-from-screen
  "Convert a point from a screen coordinates to a component's
   coordinate system

  p - a Point object (converted to the new coordinate system) - `java.awt.Point`
  c - a Component object - `java.awt.Component`"
  ([p c]
    (SwingUtilities/convertPointFromScreen p c)))

(defn *get-accessible-index-in-parent
  "Get the index of this object in its accessible parent.

   Note: as of the Java 2 platform v1.3, it is recommended that developers call
   Component.AccessibleAWTComponent.getAccessibleIndexInParent() instead
   of using this method.

  c - `java.awt.Component`

  returns: -1 of this object does not have an accessible parent.
   Otherwise, the index of the child in its accessible parent. - `int`"
  ([c]
    (SwingUtilities/getAccessibleIndexInParent c)))

(defn *get-window-ancestor
  "Returns the first Window  ancestor of c, or
   null if c is not contained inside a Window.

  c - Component to get Window ancestor of. - `java.awt.Component`

  returns: the first Window  ancestor of c, or
           null if c is not contained inside a
           Window. - `java.awt.Window`"
  ([c]
    (SwingUtilities/getWindowAncestor c)))

