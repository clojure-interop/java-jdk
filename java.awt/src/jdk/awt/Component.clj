(ns jdk.awt.Component
  "A component is an object having a graphical representation
  that can be displayed on the screen and that can interact with the
  user. Examples of components are the buttons, checkboxes, and scrollbars
  of a typical graphical user interface.
  The Component class is the abstract superclass of
  the nonmenu-related Abstract Window Toolkit components. Class
  Component can also be extended directly to create a
  lightweight component. A lightweight component is a component that is
  not associated with a native window. On the contrary, a heavyweight
  component is associated with a native window. The isLightweight()
  method may be used to distinguish between the two kinds of the components.

  Lightweight and heavyweight components may be mixed in a single component
  hierarchy. However, for correct operating of such a mixed hierarchy of
  components, the whole hierarchy must be valid. When the hierarchy gets
  invalidated, like after changing the bounds of components, or
  adding/removing components to/from containers, the whole hierarchy must be
  validated afterwards by means of the Container.validate() method
  invoked on the top-most invalid container of the hierarchy.

  Serialization
  It is important to note that only AWT listeners which conform
  to the Serializable protocol will be saved when
  the object is stored.  If an AWT object has listeners that
  aren't marked serializable, they will be dropped at
  writeObject time.  Developers will need, as always,
  to consider the implications of making an object serializable.
  One situation to watch out for is this:


     import java.awt.*;
     import java.awt.event.*;
     import java.io.Serializable;

     class MyApp implements ActionListener, Serializable
     {
         BigObjectThatShouldNotBeSerializedWithAButton bigOne;
         Button aButton = new Button();

         MyApp()
         {
             // Oops, now aButton has a listener with a reference
             // to bigOne!
             aButton.addActionListener(this);
         }

         public void actionPerformed(ActionEvent e)
         {
             System.out.println(\"Hello There\");
         }
     }
  In this example, serializing aButton by itself
  will cause MyApp and everything it refers to
  to be serialized as well.  The problem is that the listener
  is serializable by coincidence, not by design.  To separate
  the decisions about MyApp and the
  ActionListener being serializable one can use a
  nested class, as in the following example:


     import java.awt.*;
     import java.awt.event.*;
     import java.io.Serializable;

     class MyApp implements java.io.Serializable
     {
          BigObjectThatShouldNotBeSerializedWithAButton bigOne;
          Button aButton = new Button();

          static class MyActionListener implements ActionListener
          {
              public void actionPerformed(ActionEvent e)
              {
                  System.out.println(\"Hello There\");
              }
          }

          MyApp()
          {
              aButton.addActionListener(new MyActionListener());
          }
     }

  Note: For more information on the paint mechanisms utilitized
  by AWT and Swing, including information on how to write the most
  efficient painting code, see
  Painting in AWT and Swing.

  For details on the focus subsystem, see

  How to Use the Focus Subsystem,
  a section in The Java Tutorial, and the
  Focus Specification
  for more information."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Component]))

(def *-top-alignment
  "Static Constant.

  Ease-of-use constant for getAlignmentY().
   Specifies an alignment to the top of the component.

  type: float"
  Component/TOP_ALIGNMENT)

(def *-center-alignment
  "Static Constant.

  Ease-of-use constant for getAlignmentY and
   getAlignmentX. Specifies an alignment to
   the center of the component

  type: float"
  Component/CENTER_ALIGNMENT)

(def *-bottom-alignment
  "Static Constant.

  Ease-of-use constant for getAlignmentY.
   Specifies an alignment to the bottom of the component.

  type: float"
  Component/BOTTOM_ALIGNMENT)

(def *-left-alignment
  "Static Constant.

  Ease-of-use constant for getAlignmentX.
   Specifies an alignment to the left side of the component.

  type: float"
  Component/LEFT_ALIGNMENT)

(def *-right-alignment
  "Static Constant.

  Ease-of-use constant for getAlignmentX.
   Specifies an alignment to the right side of the component.

  type: float"
  Component/RIGHT_ALIGNMENT)

(defn opaque?
  "Returns true if this component is completely opaque, returns
   false by default.

   An opaque component paints every pixel within its
   rectangular region. A non-opaque component paints only some of
   its pixels, allowing the pixels underneath it to \"show through\".
   A component that does not fully paint its pixels therefore
   provides a degree of transparency.

   Subclasses that guarantee to always completely paint their
   contents should override this method and return true.

  returns: true if this component is completely opaque - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isOpaque))))

(defn get-graphics-configuration
  "Gets the GraphicsConfiguration associated with this
   Component.
   If the Component has not been assigned a specific
   GraphicsConfiguration,
   the GraphicsConfiguration of the
   Component object's top-level container is
   returned.
   If the Component has been created, but not yet added
   to a Container, this method returns null.

  returns: the GraphicsConfiguration used by this
            Component or null - `java.awt.GraphicsConfiguration`"
  (^java.awt.GraphicsConfiguration [^Component this]
    (-> this (.getGraphicsConfiguration))))

(defn remove-input-method-listener
  "Removes the specified input method listener so that it no longer
   receives input method events from this component. This method performs
   no function, nor does it throw an exception, if the listener
   specified by the argument was not previously added to this component.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the input method listener - `java.awt.event.InputMethodListener`"
  ([^Component this ^java.awt.event.InputMethodListener l]
    (-> this (.removeInputMethodListener l))))

(defn double-buffered?
  "Returns true if this component is painted to an offscreen image
   (\"buffer\") that's copied to the screen later.  Component
   subclasses that support double buffering should override this
   method to return true if double buffering is enabled.

  returns: false by default - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isDoubleBuffered))))

(defn lightweight?
  "A lightweight component doesn't have a native toolkit peer.
   Subclasses of Component and Container,
   other than the ones defined in this package like Button
   or Scrollbar, are lightweight.
   All of the Swing components are lightweights.

   This method will always return false if this component
   is not displayable because it is impossible to determine the
   weight of an undisplayable component.

  returns: true if this component has a lightweight peer; false if
           it has a native peer or no peer - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isLightweight))))

(defn get-minimum-size
  "Gets the minimum size of this component.

  returns: a dimension object indicating this component's minimum size - `java.awt.Dimension`"
  (^java.awt.Dimension [^Component this]
    (-> this (.getMinimumSize))))

(defn set-focus-traversal-keys-enabled
  "Sets whether focus traversal keys are enabled for this Component.
   Components for which focus traversal keys are disabled receive key
   events for focus traversal keys. Components for which focus traversal
   keys are enabled do not see these events; instead, the events are
   automatically converted to traversal operations.

  focus-traversal-keys-enabled - whether focus traversal keys are enabled for this Component - `boolean`"
  ([^Component this ^Boolean focus-traversal-keys-enabled]
    (-> this (.setFocusTraversalKeysEnabled focus-traversal-keys-enabled))))

(defn handle-event
  "Deprecated. As of JDK version 1.1
   replaced by processEvent(AWTEvent).

  evt - `java.awt.Event`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt]
    (-> this (.handleEvent evt))))

(defn get-location
  "Stores the x,y origin of this component into \"return value\" rv
   and return rv.   If rv is null a new
   Point is allocated.
   This version of getLocation is useful if the
   caller wants to avoid allocating a new Point
   object on the heap.

  rv - the return value, modified to the components location - `java.awt.Point`

  returns: rv - `java.awt.Point`"
  (^java.awt.Point [^Component this ^java.awt.Point rv]
    (-> this (.getLocation rv)))
  (^java.awt.Point [^Component this]
    (-> this (.getLocation))))

(defn print-all
  "Prints this component and all of its subcomponents.

   The origin of the graphics context, its
   (0, 0) coordinate point, is the
   top-left corner of this component. The clipping region of the
   graphics context is the bounding rectangle of this component.

  g - the graphics context to use for printing - `java.awt.Graphics`"
  ([^Component this ^java.awt.Graphics g]
    (-> this (.printAll g))))

(defn get-maximum-size
  "Gets the maximum size of this component.

  returns: a dimension object indicating this component's maximum size - `java.awt.Dimension`"
  (^java.awt.Dimension [^Component this]
    (-> this (.getMaximumSize))))

(defn add-mouse-listener
  "Adds the specified mouse listener to receive mouse events from
   this component.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the mouse listener - `java.awt.event.MouseListener`"
  ([^Component this ^java.awt.event.MouseListener l]
    (-> this (.addMouseListener l))))

(defn list
  "Prints out a list, starting at the specified indentation, to the
   specified print stream.

  out - a print stream - `java.io.PrintStream`
  indent - number of spaces to indent - `int`

  throws: java.lang.NullPointerException - if out is null"
  ([^Component this ^java.io.PrintStream out ^Integer indent]
    (-> this (.list out indent)))
  ([^Component this ^java.io.PrintStream out]
    (-> this (.list out)))
  ([^Component this]
    (-> this (.list))))

(defn get-width
  "Returns the current width of this component.
   This method is preferable to writing
   component.getBounds().width,
   or component.getSize().width because it
   doesn't cause any heap allocations.

  returns: the current width of this component - `int`"
  (^Integer [^Component this]
    (-> this (.getWidth))))

(defn set-location
  "Moves this component to a new location. The top-left corner of
   the new location is specified by the x and y
   parameters in the coordinate space of this component's parent.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

  x - the x-coordinate of the new location's top-left corner in the parent's coordinate space - `int`
  y - the y-coordinate of the new location's top-left corner in the parent's coordinate space - `int`"
  ([^Component this ^Integer x ^Integer y]
    (-> this (.setLocation x y)))
  ([^Component this ^java.awt.Point p]
    (-> this (.setLocation p))))

(defn hide
  "Deprecated. As of JDK version 1.1,
   replaced by setVisible(boolean)."
  ([^Component this]
    (-> this (.hide))))

(defn get-input-method-listeners
  "Returns an array of all the input method listeners
   registered on this component.

  returns: all of this component's InputMethodListeners
           or an empty array if no input method
           listeners are currently registered - `java.awt.event.InputMethodListener[]`"
  ([^Component this]
    (-> this (.getInputMethodListeners))))

(defn set-foreground
  "Sets the foreground color of this component.

  c - the color to become this component's foreground color; if this parameter is null then this component will inherit the foreground color of its parent - `java.awt.Color`"
  ([^Component this ^java.awt.Color c]
    (-> this (.setForeground c))))

(defn remove-hierarchy-bounds-listener
  "Removes the specified hierarchy bounds listener so that it no longer
   receives hierarchy bounds events from this component. This method
   performs no function, nor does it throw an exception, if the listener
   specified by the argument was not previously added to this component.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the hierarchy bounds listener - `java.awt.event.HierarchyBoundsListener`"
  ([^Component this ^java.awt.event.HierarchyBoundsListener l]
    (-> this (.removeHierarchyBoundsListener l))))

(defn fire-property-change
  "Reports a bound property change.

  property-name - the programmatic name of the property that was changed - `java.lang.String`
  old-value - the old value of the property (as a byte) - `byte`
  new-value - the new value of the property (as a byte) - `byte`"
  ([^Component this ^java.lang.String property-name ^Byte old-value ^Byte new-value]
    (-> this (.firePropertyChange property-name old-value new-value))))

(defn next-focus
  "Deprecated. As of JDK version 1.1,
   replaced by transferFocus()."
  ([^Component this]
    (-> this (.nextFocus))))

(defn key-down
  "Deprecated. As of JDK version 1.1,
   replaced by processKeyEvent(KeyEvent).

  evt - `java.awt.Event`
  key - `int`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt ^Integer key]
    (-> this (.keyDown evt key))))

(defn foreground-set?
  "Returns whether the foreground color has been explicitly set for this
   Component. If this method returns false, this Component is
   inheriting its foreground color from an ancestor.

  returns: true if the foreground color has been explicitly
           set for this Component; false otherwise. - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isForegroundSet))))

(defn cursor-set?
  "Returns whether the cursor has been explicitly set for this Component.
   If this method returns false, this Component is inheriting
   its cursor from an ancestor.

  returns: true if the cursor has been explicitly set for this
           Component; false otherwise. - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isCursorSet))))

(defn get-focus-traversal-keys
  "Returns the Set of focus traversal keys for a given traversal operation
   for this Component. (See
   setFocusTraversalKeys for a full description of each key.)

   If a Set of traversal keys has not been explicitly defined for this
   Component, then this Component's parent's Set is returned. If no Set
   has been explicitly defined for any of this Component's ancestors, then
   the current KeyboardFocusManager's default Set is returned.

  id - one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, or KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS - `int`

  returns: the Set of AWTKeyStrokes for the specified operation. The Set
           will be unmodifiable, and may be empty. null will never be
           returned. - `java.util.Set<java.awt.AWTKeyStroke>`

  throws: java.lang.IllegalArgumentException - if id is not one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, or KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS"
  (^java.util.Set [^Component this ^Integer id]
    (-> this (.getFocusTraversalKeys id))))

(defn add-mouse-motion-listener
  "Adds the specified mouse motion listener to receive mouse motion
   events from this component.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the mouse motion listener - `java.awt.event.MouseMotionListener`"
  ([^Component this ^java.awt.event.MouseMotionListener l]
    (-> this (.addMouseMotionListener l))))

(defn get-foreground
  "Gets the foreground color of this component.

  returns: this component's foreground color; if this component does
   not have a foreground color, the foreground color of its parent
   is returned - `java.awt.Color`"
  (^java.awt.Color [^Component this]
    (-> this (.getForeground))))

(defn get-mouse-position
  "Returns the position of the mouse pointer in this Component's
   coordinate space if the Component is directly under the mouse
   pointer, otherwise returns null.
   If the Component is not showing on the screen, this method
   returns null even if the mouse pointer is above the area
   where the Component would be displayed.
   If the Component is partially or fully obscured by other
   Components or native windows, this method returns a non-null
   value only if the mouse pointer is located above the unobscured part of the
   Component.

   For Containers it returns a non-null value if the mouse is
   above the Container itself or above any of its descendants.
   Use Container.getMousePosition(boolean) if you need to exclude children.

   Sometimes the exact mouse coordinates are not important, and the only thing
   that matters is whether a specific Component is under the mouse
   pointer. If the return value of this method is null, mouse
   pointer is not directly above the Component.

  returns: mouse coordinates relative to this Component, or null - `java.awt.Point`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  (^java.awt.Point [^Component this]
    (-> this (.getMousePosition))))

(defn get-cursor
  "Gets the cursor set in the component. If the component does
   not have a cursor set, the cursor of its parent is returned.
   If no cursor is set in the entire hierarchy,
   Cursor.DEFAULT_CURSOR is returned.

  returns: `java.awt.Cursor`"
  (^java.awt.Cursor [^Component this]
    (-> this (.getCursor))))

(defn validate
  "Validates this component.

   The meaning of the term validating is defined by the ancestors of
   this class. See Container.validate() for more details."
  ([^Component this]
    (-> this (.validate))))

(defn contains
  "Checks whether this component \"contains\" the specified point,
   where x and y are defined to be
   relative to the coordinate system of this component.

  x - the x coordinate of the point - `int`
  y - the y coordinate of the point - `int`

  returns: `boolean`"
  (^Boolean [^Component this ^Integer x ^Integer y]
    (-> this (.contains x y)))
  (^Boolean [^Component this ^java.awt.Point p]
    (-> this (.contains p))))

(defn has-focus?
  "Returns true if this Component is the
   focus owner.  This method is obsolete, and has been replaced by
   isFocusOwner().

  returns: true if this Component is the
           focus owner; false otherwise - `boolean`"
  (^Boolean [^Component this]
    (-> this (.hasFocus))))

(defn add-hierarchy-bounds-listener
  "Adds the specified hierarchy bounds listener to receive hierarchy
   bounds events from this component when the hierarchy to which this
   container belongs changes.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the hierarchy bounds listener - `java.awt.event.HierarchyBoundsListener`"
  ([^Component this ^java.awt.event.HierarchyBoundsListener l]
    (-> this (.addHierarchyBoundsListener l))))

(defn post-event
  "Deprecated. As of JDK version 1.1,
   replaced by dispatchEvent(AWTEvent).

  e - `java.awt.Event`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event e]
    (-> this (.postEvent e))))

(defn font-set?
  "Returns whether the font has been explicitly set for this Component. If
   this method returns false, this Component is inheriting its
   font from an ancestor.

  returns: true if the font has been explicitly set for this
           Component; false otherwise. - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isFontSet))))

(defn set-drop-target
  "Associate a DropTarget with this component.
   The Component will receive drops only if it
   is enabled.

  dt - The DropTarget - `java.awt.dnd.DropTarget`"
  ([^Component this ^java.awt.dnd.DropTarget dt]
    (-> this (.setDropTarget dt))))

(defn transfer-focus-up-cycle
  "Transfers the focus up one focus traversal cycle. Typically, the focus
   owner is set to this Component's focus cycle root, and the current focus
   cycle root is set to the new focus owner's focus cycle root. If,
   however, this Component's focus cycle root is a Window, then the focus
   owner is set to the focus cycle root's default Component to focus, and
   the current focus cycle root is unchanged."
  ([^Component this]
    (-> this (.transferFocusUpCycle))))

(defn set-name
  "Sets the name of the component to the specified string.

  name - the string that is to be this component's name - `java.lang.String`"
  ([^Component this ^java.lang.String name]
    (-> this (.setName name))))

(defn enable
  "Deprecated. As of JDK version 1.1,
   replaced by setEnabled(boolean).

  b - `boolean`"
  ([^Component this ^Boolean b]
    (-> this (.enable b)))
  ([^Component this]
    (-> this (.enable))))

(defn get-graphics
  "Creates a graphics context for this component. This method will
   return null if this component is currently not
   displayable.

  returns: a graphics context for this component, or null
               if it has none - `java.awt.Graphics`"
  (^java.awt.Graphics [^Component this]
    (-> this (.getGraphics))))

(defn get-locale
  "Gets the locale of this component.

  returns: this component's locale; if this component does not
            have a locale, the locale of its parent is returned - `java.util.Locale`

  throws: java.awt.IllegalComponentStateException - if the Component does not have its own locale and has not yet been added to a containment hierarchy such that the locale can be determined from the containing parent"
  (^java.util.Locale [^Component this]
    (-> this (.getLocale))))

(defn get-component-orientation
  "Retrieves the language-sensitive orientation that is to be used to order
   the elements or text within this component.  LayoutManager
   and Component
   subclasses that wish to respect orientation should call this method to
   get the component's orientation before performing layout or drawing.

  returns: `java.awt.ComponentOrientation`"
  (^java.awt.ComponentOrientation [^Component this]
    (-> this (.getComponentOrientation))))

(defn to-string
  "Returns a string representation of this component and its values.

  returns: a string representation of this component - `java.lang.String`"
  (^java.lang.String [^Component this]
    (-> this (.toString))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.  This method is primarily meant for
   layout managers and GUI builders.

   The default implementation returns
   BaselineResizeBehavior.OTHER.  Subclasses that have a
   baseline should override appropriately.  Subclasses should
   never return null; if the baseline can not be
   calculated return BaselineResizeBehavior.OTHER.  Callers
   should first ask for the baseline using
   getBaseline and if a value >= 0 is returned use
   this method.  It is acceptable for this method to return a
   value other than BaselineResizeBehavior.OTHER even if
   getBaseline returns a value less than 0.

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component$BaselineResizeBehavior`"
  (^java.awt.Component$BaselineResizeBehavior [^Component this]
    (-> this (.getBaselineResizeBehavior))))

(defn get-location-on-screen
  "Gets the location of this component in the form of a point
   specifying the component's top-left corner in the screen's
   coordinate space.

  returns: an instance of Point representing
            the top-left corner of the component's bounds in the
            coordinate space of the screen - `java.awt.Point`

  throws: java.awt.IllegalComponentStateException - if the component is not showing on the screen"
  (^java.awt.Point [^Component this]
    (-> this (.getLocationOnScreen))))

(defn lost-focus
  "Deprecated. As of JDK version 1.1,
   replaced by processFocusEvent(FocusEvent).

  evt - `java.awt.Event`
  what - `java.lang.Object`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt ^java.lang.Object what]
    (-> this (.lostFocus evt what))))

(defn are-focus-traversal-keys-set
  "Returns whether the Set of focus traversal keys for the given focus
   traversal operation has been explicitly defined for this Component. If
   this method returns false, this Component is inheriting the
   Set from an ancestor, or from the current KeyboardFocusManager.

  id - one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, or KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS - `int`

  returns: true if the the Set of focus traversal keys for the
           given focus traversal operation has been explicitly defined for
           this Component; false otherwise. - `boolean`

  throws: java.lang.IllegalArgumentException - if id is not one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, or KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS"
  (^Boolean [^Component this ^Integer id]
    (-> this (.areFocusTraversalKeysSet id))))

(defn enable-input-methods
  "Enables or disables input method support for this component. If input
   method support is enabled and the component also processes key events,
   incoming events are offered to
   the current input method and will only be processed by the component or
   dispatched to its listeners if the input method does not consume them.
   By default, input method support is enabled.

  enable - true to enable, false to disable - `boolean`"
  ([^Component this ^Boolean enable]
    (-> this (.enableInputMethods enable))))

(defn set-ignore-repaint
  "Sets whether or not paint messages received from the operating system
   should be ignored.  This does not affect paint events generated in
   software by the AWT, unless they are an immediate response to an
   OS-level paint message.

   This is useful, for example, if running under full-screen mode and
   better performance is desired, or if page-flipping is used as the
   buffer strategy.

  ignore-repaint - `boolean`"
  ([^Component this ^Boolean ignore-repaint]
    (-> this (.setIgnoreRepaint ignore-repaint))))

(defn remove-hierarchy-listener
  "Removes the specified hierarchy listener so that it no longer
   receives hierarchy changed events from this component. This method
   performs no function, nor does it throw an exception, if the listener
   specified by the argument was not previously added to this component.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the hierarchy listener - `java.awt.event.HierarchyListener`"
  ([^Component this ^java.awt.event.HierarchyListener l]
    (-> this (.removeHierarchyListener l))))

(defn update
  "Updates this component.

   If this component is not a lightweight component, the
   AWT calls the update method in response to
   a call to repaint.  You can assume that
   the background is not cleared.

   The update method of Component
   calls this component's paint method to redraw
   this component.  This method is commonly overridden by subclasses
   which need to do additional work in response to a call to
   repaint.
   Subclasses of Component that override this method should either
   call super.update(g), or call paint(g)
   directly from their update method.

   The origin of the graphics context, its
   (0, 0) coordinate point, is the
   top-left corner of this component. The clipping region of the
   graphics context is the bounding rectangle of this component.


   Note: For more information on the paint mechanisms utilitized
   by AWT and Swing, including information on how to write the most
   efficient painting code, see
   Painting in AWT and Swing.

  g - the specified context to use for updating - `java.awt.Graphics`"
  ([^Component this ^java.awt.Graphics g]
    (-> this (.update g))))

(defn check-image
  "Returns the status of the construction of a screen representation
   of the specified image.

   This method does not cause the image to begin loading. An
   application must use the prepareImage method
   to force the loading of an image.

   The checkImage method of Component
   calls its peer's checkImage method to calculate
   the flags. If this component does not yet have a peer, the
   component's toolkit's checkImage method is called
   instead.

   Information on the flags returned by this method can be found
   with the discussion of the ImageObserver interface.

  image - the Image object whose status is being checked - `java.awt.Image`
  width - the width of the scaled version whose status is to be checked - `int`
  height - the height of the scaled version whose status is to be checked - `int`
  observer - the ImageObserver object to be notified as the image is being prepared - `java.awt.image.ImageObserver`

  returns: the bitwise inclusive OR of
              ImageObserver flags indicating what
              information about the image is currently available - `int`"
  (^Integer [^Component this ^java.awt.Image image ^Integer width ^Integer height ^java.awt.image.ImageObserver observer]
    (-> this (.checkImage image width height observer)))
  (^Integer [^Component this ^java.awt.Image image ^java.awt.image.ImageObserver observer]
    (-> this (.checkImage image observer))))

(defn mouse-move
  "Deprecated. As of JDK version 1.1,
   replaced by processMouseMotionEvent(MouseEvent).

  evt - `java.awt.Event`
  x - `int`
  y - `int`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt ^Integer x ^Integer y]
    (-> this (.mouseMove evt x y))))

(defn paint-all
  "Paints this component and all of its subcomponents.

   The origin of the graphics context, its
   (0, 0) coordinate point, is the
   top-left corner of this component. The clipping region of the
   graphics context is the bounding rectangle of this component.

  g - the graphics context to use for painting - `java.awt.Graphics`"
  ([^Component this ^java.awt.Graphics g]
    (-> this (.paintAll g))))

(defn set-background
  "Sets the background color of this component.

   The background color affects each component differently and the
   parts of the component that are affected by the background color
   may differ between operating systems.

  c - the color to become this component's color; if this parameter is null, then this component will inherit the background color of its parent - `java.awt.Color`"
  ([^Component this ^java.awt.Color c]
    (-> this (.setBackground c))))

(defn get-name
  "Gets the name of the component.

  returns: this component's name - `java.lang.String`"
  (^java.lang.String [^Component this]
    (-> this (.getName))))

(defn reshape
  "Deprecated. As of JDK version 1.1,
   replaced by setBounds(int, int, int, int).

  x - `int`
  y - `int`
  width - `int`
  height - `int`"
  ([^Component this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.reshape x y width height))))

(defn get-focus-listeners
  "Returns an array of all the focus listeners
   registered on this component.

  returns: all of this component's FocusListeners
           or an empty array if no component
           listeners are currently registered - `java.awt.event.FocusListener[]`"
  ([^Component this]
    (-> this (.getFocusListeners))))

(defn set-focusable
  "Sets the focusable state of this Component to the specified value. This
   value overrides the Component's default focusability.

  focusable - indicates whether this Component is focusable - `boolean`"
  ([^Component this ^Boolean focusable]
    (-> this (.setFocusable focusable))))

(defn focus-traversable?
  "Deprecated. As of 1.4, replaced by isFocusable().

  returns: true if this Component is
   focusable; false otherwise - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isFocusTraversable))))

(defn remove-mouse-motion-listener
  "Removes the specified mouse motion listener so that it no longer
   receives mouse motion events from this component. This method performs
   no function, nor does it throw an exception, if the listener
   specified by the argument was not previously added to this component.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the mouse motion listener - `java.awt.event.MouseMotionListener`"
  ([^Component this ^java.awt.event.MouseMotionListener l]
    (-> this (.removeMouseMotionListener l))))

(defn get-component-listeners
  "Returns an array of all the component listeners
   registered on this component.

  returns: all ComponentListeners of this component
           or an empty array if no component
           listeners are currently registered - `java.awt.event.ComponentListener[]`"
  ([^Component this]
    (-> this (.getComponentListeners))))

(defn get-alignment-x
  "Returns the alignment along the x axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  returns: `float`"
  (^Float [^Component this]
    (-> this (.getAlignmentX))))

(defn add-notify
  "Makes this Component displayable by connecting it to a
   native screen resource.
   This method is called internally by the toolkit and should
   not be called directly by programs.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy."
  ([^Component this]
    (-> this (.addNotify))))

(defn transfer-focus-backward
  "Transfers the focus to the previous component, as though this Component
   were the focus owner."
  ([^Component this]
    (-> this (.transferFocusBackward))))

(defn get-font-metrics
  "Gets the font metrics for the specified font.
   Warning: Since Font metrics are affected by the
   FontRenderContext and
   this method does not provide one, it can return only metrics for
   the default render context which may not match that used when
   rendering on the Component if Graphics2D functionality is being
   used. Instead metrics can be obtained at rendering time by calling
   Graphics.getFontMetrics() or text measurement APIs on the
   Font class.

  font - the font for which font metrics is to be obtained - `java.awt.Font`

  returns: the font metrics for font - `java.awt.FontMetrics`"
  (^java.awt.FontMetrics [^Component this ^java.awt.Font font]
    (-> this (.getFontMetrics font))))

(defn set-preferred-size
  "Sets the preferred size of this component to a constant
   value.  Subsequent calls to getPreferredSize will always
   return this value.  Setting the preferred size to null
   restores the default behavior.

  preferred-size - The new preferred size, or null - `java.awt.Dimension`"
  ([^Component this ^java.awt.Dimension preferred-size]
    (-> this (.setPreferredSize preferred-size))))

(defn get-y
  "Returns the current y coordinate of the components origin.
   This method is preferable to writing
   component.getBounds().y,
   or component.getLocation().y because it
   doesn't cause any heap allocations.

  returns: the current y coordinate of the components origin - `int`"
  (^Integer [^Component this]
    (-> this (.getY))))

(defn show
  "Deprecated. As of JDK version 1.1,
   replaced by setVisible(boolean).

  b - `boolean`"
  ([^Component this ^Boolean b]
    (-> this (.show b)))
  ([^Component this]
    (-> this (.show))))

(defn remove-property-change-listener
  "Removes a PropertyChangeListener from the listener
   list for a specific property. This method should be used to remove
   PropertyChangeListeners
   that were registered for a specific bound property.

   If propertyName or listener is null,
   no exception is thrown and no action is taken.

  property-name - a valid property name - `java.lang.String`
  listener - the PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([^Component this ^java.lang.String property-name ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener property-name listener)))
  ([^Component this ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener listener))))

(defn mouse-drag
  "Deprecated. As of JDK version 1.1,
   replaced by processMouseMotionEvent(MouseEvent).

  evt - `java.awt.Event`
  x - `int`
  y - `int`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt ^Integer x ^Integer y]
    (-> this (.mouseDrag evt x y))))

(defn get-hierarchy-bounds-listeners
  "Returns an array of all the hierarchy bounds listeners
   registered on this component.

  returns: all of this component's HierarchyBoundsListeners
           or an empty array if no hierarchy bounds
           listeners are currently registered - `java.awt.event.HierarchyBoundsListener[]`"
  ([^Component this]
    (-> this (.getHierarchyBoundsListeners))))

(defn location
  "Deprecated. As of JDK version 1.1,
   replaced by getLocation().

  returns: `java.awt.Point`"
  (^java.awt.Point [^Component this]
    (-> this (.location))))

(defn remove-notify
  "Makes this Component undisplayable by destroying it native
   screen resource.

   This method is called by the toolkit internally and should
   not be called directly by programs. Code overriding
   this method should call super.removeNotify as
   the first line of the overriding method."
  ([^Component this]
    (-> this (.removeNotify))))

(defn preferred-size-set?
  "Returns true if the preferred size has been set to a
   non-null value otherwise returns false.

  returns: true if setPreferredSize has been invoked
           with a non-null value. - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isPreferredSizeSet))))

(defn get-parent
  "Gets the parent of this component.

  returns: the parent container of this component - `java.awt.Container`"
  (^java.awt.Container [^Component this]
    (-> this (.getParent))))

(defn disable
  "Deprecated. As of JDK version 1.1,
   replaced by setEnabled(boolean)."
  ([^Component this]
    (-> this (.disable))))

(defn mouse-exit
  "Deprecated. As of JDK version 1.1,
   replaced by processMouseEvent(MouseEvent).

  evt - `java.awt.Event`
  x - `int`
  y - `int`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt ^Integer x ^Integer y]
    (-> this (.mouseExit evt x y))))

(defn remove
  "Removes the specified popup menu from the component.

  popup - the popup menu to be removed - `java.awt.MenuComponent`"
  ([^Component this ^java.awt.MenuComponent popup]
    (-> this (.remove popup))))

(defn layout
  "Deprecated. As of JDK version 1.1,
   replaced by doLayout()."
  ([^Component this]
    (-> this (.layout))))

(defn action
  "Deprecated. As of JDK version 1.1,
   should register this component as ActionListener on component
   which fires action events.

  evt - `java.awt.Event`
  what - `java.lang.Object`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt ^java.lang.Object what]
    (-> this (.action evt what))))

(defn add-focus-listener
  "Adds the specified focus listener to receive focus events from
   this component when this component gains input focus.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the focus listener - `java.awt.event.FocusListener`"
  ([^Component this ^java.awt.event.FocusListener l]
    (-> this (.addFocusListener l))))

(defn get-key-listeners
  "Returns an array of all the key listeners
   registered on this component.

  returns: all of this component's KeyListeners
           or an empty array if no key
           listeners are currently registered - `java.awt.event.KeyListener[]`"
  ([^Component this]
    (-> this (.getKeyListeners))))

(defn repaint
  "Repaints the specified rectangle of this component within
   tm milliseconds.

   If this component is a lightweight component, this method causes
   a call to this component's paint method.
   Otherwise, this method causes a call to this component's
   update method.

   Note: For more information on the paint mechanisms utilitized
   by AWT and Swing, including information on how to write the most
   efficient painting code, see
   Painting in AWT and Swing.

  tm - maximum time in milliseconds before update - `long`
  x - the x coordinate - `int`
  y - the y coordinate - `int`
  width - the width - `int`
  height - the height - `int`"
  ([^Component this ^Long tm ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.repaint tm x y width height)))
  ([^Component this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.repaint x y width height)))
  ([^Component this ^Long tm]
    (-> this (.repaint tm)))
  ([^Component this]
    (-> this (.repaint))))

(defn preferred-size
  "Deprecated. As of JDK version 1.1,
   replaced by getPreferredSize().

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^Component this]
    (-> this (.preferredSize))))

(defn remove-mouse-listener
  "Removes the specified mouse listener so that it no longer
   receives mouse events from this component. This method performs
   no function, nor does it throw an exception, if the listener
   specified by the argument was not previously added to this component.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the mouse listener - `java.awt.event.MouseListener`"
  ([^Component this ^java.awt.event.MouseListener l]
    (-> this (.removeMouseListener l))))

(defn get-x
  "Returns the current x coordinate of the components origin.
   This method is preferable to writing
   component.getBounds().x,
   or component.getLocation().x because it doesn't
   cause any heap allocations.

  returns: the current x coordinate of the components origin - `int`"
  (^Integer [^Component this]
    (-> this (.getX))))

(defn set-font
  "Sets the font of this component.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

  f - the font to become this component's font; if this parameter is null then this component will inherit the font of its parent - `java.awt.Font`"
  ([^Component this ^java.awt.Font f]
    (-> this (.setFont f))))

(defn minimum-size-set?
  "Returns whether or not setMinimumSize has been
   invoked with a non-null value.

  returns: true if setMinimumSize has been invoked with a
                non-null value. - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isMinimumSizeSet))))

(defn invalidate
  "Invalidates this component and its ancestors.

   By default, all the ancestors of the component up to the top-most
   container of the hierarchy are marked invalid. If the java.awt.smartInvalidate system property is set to true,
   invalidation stops on the nearest validate root of this component.
   Marking a container invalid indicates that the container needs to
   be laid out.

   This method is called automatically when any layout-related information
   changes (e.g. setting the bounds of the component, or adding the
   component to a container).

   This method might be called often, so it should work fast."
  ([^Component this]
    (-> this (.invalidate))))

(defn focusable?
  "Returns whether this Component can be focused.

  returns: true if this Component is focusable;
           false otherwise. - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isFocusable))))

(defn maximum-size-set?
  "Returns true if the maximum size has been set to a non-null
   value otherwise returns false.

  returns: true if maximumSize is non-null,
            false otherwise - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isMaximumSizeSet))))

(defn get-height
  "Returns the current height of this component.
   This method is preferable to writing
   component.getBounds().height,
   or component.getSize().height because it
   doesn't cause any heap allocations.

  returns: the current height of this component - `int`"
  (^Integer [^Component this]
    (-> this (.getHeight))))

(defn get-hierarchy-listeners
  "Returns an array of all the hierarchy listeners
   registered on this component.

  returns: all of this component's HierarchyListeners
           or an empty array if no hierarchy
           listeners are currently registered - `java.awt.event.HierarchyListener[]`"
  ([^Component this]
    (-> this (.getHierarchyListeners))))

(defn get-component-at
  "Determines if this component or one of its immediate
   subcomponents contains the (x, y) location,
   and if so, returns the containing component. This method only
   looks one level deep. If the point (x, y) is
   inside a subcomponent that itself has subcomponents, it does not
   go looking down the subcomponent tree.

   The locate method of Component simply
   returns the component itself if the (x, y)
   coordinate location is inside its bounding box, and null
   otherwise.

  x - the x coordinate - `int`
  y - the y coordinate - `int`

  returns: the component or subcomponent that contains the
                  (x, y) location;
                  null if the location
                  is outside this component - `java.awt.Component`"
  (^java.awt.Component [^Component this ^Integer x ^Integer y]
    (-> this (.getComponentAt x y)))
  (^java.awt.Component [^Component this ^java.awt.Point p]
    (-> this (.getComponentAt p))))

(defn get-drop-target
  "Gets the DropTarget associated with this
   Component.

  returns: `java.awt.dnd.DropTarget`"
  (^java.awt.dnd.DropTarget [^Component this]
    (-> this (.getDropTarget))))

(defn get-alignment-y
  "Returns the alignment along the y axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  returns: `float`"
  (^Float [^Component this]
    (-> this (.getAlignmentY))))

(defn set-locale
  "Sets the locale of this component.  This is a bound property.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

  l - the locale to become this component's locale - `java.util.Locale`"
  ([^Component this ^java.util.Locale l]
    (-> this (.setLocale l))))

(defn paint
  "Paints this component.

   This method is called when the contents of the component should
   be painted; such as when the component is first being shown or
   is damaged and in need of repair.  The clip rectangle in the
   Graphics parameter is set to the area
   which needs to be painted.
   Subclasses of Component that override this
   method need not call super.paint(g).

   For performance reasons, Components with zero width
   or height aren't considered to need painting when they are first shown,
   and also aren't considered to need repair.

   Note: For more information on the paint mechanisms utilitized
   by AWT and Swing, including information on how to write the most
   efficient painting code, see
   Painting in AWT and Swing.

  g - the graphics context to use for painting - `java.awt.Graphics`"
  ([^Component this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn get-accessible-context
  "Gets the AccessibleContext associated
   with this Component.
   The method implemented by this base
   class returns null.  Classes that extend Component
   should implement this method to return the
   AccessibleContext associated with the subclass.

  returns: the AccessibleContext of this
      Component - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^Component this]
    (-> this (.getAccessibleContext))))

(defn valid?
  "Determines whether this component is valid. A component is valid
   when it is correctly sized and positioned within its parent
   container and all its children are also valid.
   In order to account for peers' size requirements, components are invalidated
   before they are first shown on the screen. By the time the parent container
   is fully realized, all its components will be valid.

  returns: true if the component is valid, false
   otherwise - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isValid))))

(defn get-tree-lock
  "Gets this component's locking object (the object that owns the thread
   synchronization monitor) for AWT component-tree and layout
   operations.

  returns: this component's locking object - `java.lang.Object`"
  (^java.lang.Object [^Component this]
    (-> this (.getTreeLock))))

(defn get-property-change-listeners
  "Returns an array of all the listeners which have been associated
   with the named property.

  property-name - `java.lang.String`

  returns: all of the PropertyChangeListeners associated with
           the named property; if no such listeners have been added or
           if propertyName is null, an empty
           array is returned - `java.beans.PropertyChangeListener[]`"
  ([^Component this ^java.lang.String property-name]
    (-> this (.getPropertyChangeListeners property-name)))
  ([^Component this]
    (-> this (.getPropertyChangeListeners))))

(defn focus-owner?
  "Returns true if this Component is the
      focus owner.

  returns: true if this Component is the
       focus owner; false otherwise - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isFocusOwner))))

(defn remove-mouse-wheel-listener
  "Removes the specified mouse wheel listener so that it no longer
   receives mouse wheel events from this component. This method performs
   no function, nor does it throw an exception, if the listener
   specified by the argument was not previously added to this component.
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the mouse wheel listener. - `java.awt.event.MouseWheelListener`"
  ([^Component this ^java.awt.event.MouseWheelListener l]
    (-> this (.removeMouseWheelListener l))))

(defn move
  "Deprecated. As of JDK version 1.1,
   replaced by setLocation(int, int).

  x - `int`
  y - `int`"
  ([^Component this ^Integer x ^Integer y]
    (-> this (.move x y))))

(defn set-minimum-size
  "Sets the minimum size of this component to a constant
   value.  Subsequent calls to getMinimumSize will always
   return this value.  Setting the minimum size to null
   restores the default behavior.

  minimum-size - the new minimum size of this component - `java.awt.Dimension`"
  ([^Component this ^java.awt.Dimension minimum-size]
    (-> this (.setMinimumSize minimum-size))))

(defn add-input-method-listener
  "Adds the specified input method listener to receive
   input method events from this component. A component will
   only receive input method events from input methods
   if it also overrides getInputMethodRequests to return an
   InputMethodRequests instance.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the input method listener - `java.awt.event.InputMethodListener`"
  ([^Component this ^java.awt.event.InputMethodListener l]
    (-> this (.addInputMethodListener l))))

(defn set-visible
  "Shows or hides this component depending on the value of parameter
   b.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

  b - if true, shows this component; otherwise, hides this component - `boolean`"
  ([^Component this ^Boolean b]
    (-> this (.setVisible b))))

(defn create-volatile-image
  "Creates a volatile off-screen drawable image, with the given capabilities.
   The contents of this image may be lost at any time due
   to operating system issues, so the image must be managed
   via the VolatileImage interface.

  width - the specified width. - `int`
  height - the specified height. - `int`
  caps - the image capabilities - `java.awt.ImageCapabilities`

  returns: a VolatileImage object, which can be used
   to manage surface contents loss and capabilities. - `java.awt.image.VolatileImage`

  throws: java.awt.AWTException - if an image with the specified capabilities cannot be created"
  (^java.awt.image.VolatileImage [^Component this ^Integer width ^Integer height ^java.awt.ImageCapabilities caps]
    (-> this (.createVolatileImage width height caps)))
  (^java.awt.image.VolatileImage [^Component this ^Integer width ^Integer height]
    (-> this (.createVolatileImage width height))))

(defn image-update
  "Repaints the component when the image has changed.
   This imageUpdate method of an ImageObserver
   is called when more information about an
   image which had been previously requested using an asynchronous
   routine such as the drawImage method of
   Graphics becomes available.
   See the definition of imageUpdate for
   more information on this method and its arguments.

   The imageUpdate method of Component
   incrementally draws an image on the component as more of the bits
   of the image are available.

   If the system property awt.image.incrementaldraw
   is missing or has the value true, the image is
   incrementally drawn. If the system property has any other value,
   then the image is not drawn until it has been completely loaded.

   Also, if incremental drawing is in effect, the value of the
   system property awt.image.redrawrate is interpreted
   as an integer to give the maximum redraw rate, in milliseconds. If
   the system property is missing or cannot be interpreted as an
   integer, the redraw rate is once every 100ms.

   The interpretation of the x, y,
   width, and height arguments depends on
   the value of the infoflags argument.

  img - the image being observed - `java.awt.Image`
  infoflags - see imageUpdate for more information - `int`
  x - the x coordinate - `int`
  y - the y coordinate - `int`
  w - the width - `int`
  h - the height - `int`

  returns: false if the infoflags indicate that the
              image is completely loaded; true otherwise. - `boolean`"
  (^Boolean [^Component this ^java.awt.Image img ^Integer infoflags ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.imageUpdate img infoflags x y w h))))

(defn background-set?
  "Returns whether the background color has been explicitly set for this
   Component. If this method returns false, this Component is
   inheriting its background color from an ancestor.

  returns: true if the background color has been explicitly
           set for this Component; false otherwise. - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isBackgroundSet))))

(defn apply-component-orientation
  "Sets the ComponentOrientation property of this component
   and all components contained within it.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

  orientation - the new component orientation of this component and the components contained within it. - `java.awt.ComponentOrientation`

  throws: java.lang.NullPointerException - if orientation is null."
  ([^Component this ^java.awt.ComponentOrientation orientation]
    (-> this (.applyComponentOrientation orientation))))

(defn set-enabled
  "Enables or disables this component, depending on the value of the
   parameter b. An enabled component can respond to user
   input and generate events. Components are enabled initially by default.

   Note: Disabling a lightweight component does not prevent it from
   receiving MouseEvents.
   Note: Disabling a heavyweight container prevents all components
   in this container from receiving any input events.  But disabling a
   lightweight container affects only this container.

  b - If true, this component is enabled; otherwise this component is disabled - `boolean`"
  ([^Component this ^Boolean b]
    (-> this (.setEnabled b))))

(defn do-layout
  "Prompts the layout manager to lay out this component. This is
   usually called when the component (more specifically, container)
   is validated."
  ([^Component this]
    (-> this (.doLayout))))

(defn get-focus-traversal-keys-enabled?
  "Returns whether focus traversal keys are enabled for this Component.
   Components for which focus traversal keys are disabled receive key
   events for focus traversal keys. Components for which focus traversal
   keys are enabled do not see these events; instead, the events are
   automatically converted to traversal operations.

  returns: whether focus traversal keys are enabled for this Component - `boolean`"
  (^Boolean [^Component this]
    (-> this (.getFocusTraversalKeysEnabled))))

(defn get-input-context
  "Gets the input context used by this component for handling
   the communication with input methods when text is entered
   in this component. By default, the input context used for
   the parent component is returned. Components may
   override this to return a private input context.

  returns: the input context used by this component;
            null if no context can be determined - `java.awt.im.InputContext`"
  (^java.awt.im.InputContext [^Component this]
    (-> this (.getInputContext))))

(defn visible?
  "Determines whether this component should be visible when its
   parent is visible. Components are
   initially visible, with the exception of top level components such
   as Frame objects.

  returns: true if the component is visible,
   false otherwise - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isVisible))))

(defn set-size
  "Resizes this component so that it has width width
   and height height.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

  width - the new width of this component in pixels - `int`
  height - the new height of this component in pixels - `int`"
  ([^Component this ^Integer width ^Integer height]
    (-> this (.setSize width height)))
  ([^Component this ^java.awt.Dimension d]
    (-> this (.setSize d))))

(defn get-focus-cycle-root-ancestor
  "Returns the Container which is the focus cycle root of this Component's
   focus traversal cycle. Each focus traversal cycle has only a single
   focus cycle root and each Component which is not a Container belongs to
   only a single focus traversal cycle. Containers which are focus cycle
   roots belong to two cycles: one rooted at the Container itself, and one
   rooted at the Container's nearest focus-cycle-root ancestor. For such
   Containers, this method will return the Container's nearest focus-cycle-
   root ancestor.

  returns: this Component's nearest focus-cycle-root ancestor - `java.awt.Container`"
  (^java.awt.Container [^Component this]
    (-> this (.getFocusCycleRootAncestor))))

(defn inside
  "Deprecated. As of JDK version 1.1,
   replaced by contains(int, int).

  x - `int`
  y - `int`

  returns: `boolean`"
  (^Boolean [^Component this ^Integer x ^Integer y]
    (-> this (.inside x y))))

(defn key-up
  "Deprecated. As of JDK version 1.1,
   replaced by processKeyEvent(KeyEvent).

  evt - `java.awt.Event`
  key - `int`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt ^Integer key]
    (-> this (.keyUp evt key))))

(defn create-image
  "Creates an off-screen drawable image
       to be used for double buffering.

  width - the specified width - `int`
  height - the specified height - `int`

  returns: an off-screen drawable image, which can be used for double
      buffering.  The return value may be null if the
      component is not displayable.  This will always happen if
      GraphicsEnvironment.isHeadless() returns
      true. - `java.awt.Image`"
  (^java.awt.Image [^Component this ^Integer width ^Integer height]
    (-> this (.createImage width height)))
  (^java.awt.Image [^Component this ^java.awt.image.ImageProducer producer]
    (-> this (.createImage producer))))

(defn dispatch-event
  "Dispatches an event to this component or one of its sub components.
   Calls processEvent before returning for 1.1-style
   events which have been enabled for the Component.

  e - the event - `java.awt.AWTEvent`"
  ([^Component this ^java.awt.AWTEvent e]
    (-> this (.dispatchEvent e))))

(defn print
  "Prints this component. Applications should override this method
   for components that must do special processing before being
   printed or should be printed differently than they are painted.

   The default implementation of this method calls the
   paint method.

   The origin of the graphics context, its
   (0, 0) coordinate point, is the
   top-left corner of this component. The clipping region of the
   graphics context is the bounding rectangle of this component.

  g - the graphics context to use for printing - `java.awt.Graphics`"
  ([^Component this ^java.awt.Graphics g]
    (-> this (.print g))))

(defn request-focus
  "Requests that this Component get the input focus, and that this
   Component's top-level ancestor become the focused Window. This
   component must be displayable, focusable, visible and all of
   its ancestors (with the exception of the top-level Window) must
   be visible for the request to be granted. Every effort will be
   made to honor the request; however, in some cases it may be
   impossible to do so. Developers must never assume that this
   Component is the focus owner until this Component receives a
   FOCUS_GAINED event. If this request is denied because this
   Component's top-level Window cannot become the focused Window,
   the request will be remembered and will be granted when the
   Window is later focused by the user.

   This method cannot be used to set the focus owner to no Component at
   all. Use KeyboardFocusManager.clearGlobalFocusOwner()
   instead.

   Because the focus behavior of this method is platform-dependent,
   developers are strongly encouraged to use
   requestFocusInWindow when possible.

   Note: Not all focus transfers result from invoking this method. As
   such, a component may receive focus without this or any of the other
   requestFocus methods of Component being invoked."
  ([^Component this]
    (-> this (.requestFocus))))

(defn get-bounds
  "Stores the bounds of this component into \"return value\" rv and
   return rv.  If rv is null a new
   Rectangle is allocated.
   This version of getBounds is useful if the caller
   wants to avoid allocating a new Rectangle object
   on the heap.

  rv - the return value, modified to the components bounds - `java.awt.Rectangle`

  returns: rv - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^Component this ^java.awt.Rectangle rv]
    (-> this (.getBounds rv)))
  (^java.awt.Rectangle [^Component this]
    (-> this (.getBounds))))

(defn set-bounds
  "Moves and resizes this component. The new location of the top-left
   corner is specified by x and y, and the
   new size is specified by width and height.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

  x - the new x-coordinate of this component - `int`
  y - the new y-coordinate of this component - `int`
  width - the new width of this component - `int`
  height - the new height of this component - `int`"
  ([^Component this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.setBounds x y width height)))
  ([^Component this ^java.awt.Rectangle r]
    (-> this (.setBounds r))))

(defn get-toolkit
  "Gets the toolkit of this component. Note that
   the frame that contains a component controls which
   toolkit is used by that component. Therefore if the component
   is moved from one frame to another, the toolkit it uses may change.

  returns: the toolkit of this component - `java.awt.Toolkit`"
  (^java.awt.Toolkit [^Component this]
    (-> this (.getToolkit))))

(defn add
  "Adds the specified popup menu to the component.

  popup - the popup menu to be added to the component. - `java.awt.PopupMenu`

  throws: java.lang.NullPointerException - if popup is null"
  ([^Component this ^java.awt.PopupMenu popup]
    (-> this (.add popup))))

(defn bounds
  "Deprecated. As of JDK version 1.1,
   replaced by getBounds().

  returns: `java.awt.Rectangle`"
  (^java.awt.Rectangle [^Component this]
    (-> this (.bounds))))

(defn set-focus-traversal-keys
  "Sets the focus traversal keys for a given traversal operation for this
   Component.

   The default values for a Component's focus traversal keys are
   implementation-dependent. Sun recommends that all implementations for a
   particular native platform use the same default values. The
   recommendations for Windows and Unix are listed below. These
   recommendations are used in the Sun AWT implementations.



      Identifier
      Meaning
      Default


      KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS
      Normal forward keyboard traversal
      TAB on KEY_PRESSED, CTRL-TAB on KEY_PRESSED


      KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS
      Normal reverse keyboard traversal
      SHIFT-TAB on KEY_PRESSED, CTRL-SHIFT-TAB on KEY_PRESSED


      KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS
      Go up one focus traversal cycle
      none



   To disable a traversal key, use an empty Set; Collections.EMPTY_SET is
   recommended.

   Using the AWTKeyStroke API, client code can specify on which of two
   specific KeyEvents, KEY_PRESSED or KEY_RELEASED, the focus traversal
   operation will occur. Regardless of which KeyEvent is specified,
   however, all KeyEvents related to the focus traversal key, including the
   associated KEY_TYPED event, will be consumed, and will not be dispatched
   to any Component. It is a runtime error to specify a KEY_TYPED event as
   mapping to a focus traversal operation, or to map the same event to
   multiple default focus traversal operations.

   If a value of null is specified for the Set, this Component inherits the
   Set from its parent. If all ancestors of this Component have null
   specified for the Set, then the current KeyboardFocusManager's default
   Set is used.

   This method may throw a ClassCastException if any Object
   in keystrokes is not an AWTKeyStroke.

  id - one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, or KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS - `int`
  keystrokes - the Set of AWTKeyStroke for the specified operation - `java.util.Set`

  throws: java.lang.IllegalArgumentException - if id is not one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, or KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or if keystrokes contains null, or if any keystroke represents a KEY_TYPED event, or if any keystroke already maps to another focus traversal operation for this Component"
  ([^Component this ^Integer id ^java.util.Set keystrokes]
    (-> this (.setFocusTraversalKeys id keystrokes))))

(defn get-font
  "Gets the font of this component.

  returns: this component's font; if a font has not been set
   for this component, the font of its parent is returned - `java.awt.Font`"
  (^java.awt.Font [^Component this]
    (-> this (.getFont))))

(defn mouse-down
  "Deprecated. As of JDK version 1.1,
   replaced by processMouseEvent(MouseEvent).

  evt - `java.awt.Event`
  x - `int`
  y - `int`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt ^Integer x ^Integer y]
    (-> this (.mouseDown evt x y))))

(defn get-ignore-repaint?
  "returns: whether or not paint messages received from the operating system
   should be ignored. - `boolean`"
  (^Boolean [^Component this]
    (-> this (.getIgnoreRepaint))))

(defn deliver-event
  "Deprecated. As of JDK version 1.1,
   replaced by dispatchEvent(AWTEvent e).

  e - `java.awt.Event`"
  ([^Component this ^java.awt.Event e]
    (-> this (.deliverEvent e))))

(defn displayable?
  "Determines whether this component is displayable. A component is
   displayable when it is connected to a native screen resource.

   A component is made displayable either when it is added to
   a displayable containment hierarchy or when its containment
   hierarchy is made displayable.
   A containment hierarchy is made displayable when its ancestor
   window is either packed or made visible.

   A component is made undisplayable either when it is removed from
   a displayable containment hierarchy or when its containment hierarchy
   is made undisplayable.  A containment hierarchy is made
   undisplayable when its ancestor window is disposed.

  returns: true if the component is displayable,
   false otherwise - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isDisplayable))))

(defn prepare-image
  "Prepares an image for rendering on this component at the
   specified width and height.

   The image data is downloaded asynchronously in another thread,
   and an appropriately scaled screen representation of the image is
   generated.

  image - the instance of Image for which to prepare a screen representation - `java.awt.Image`
  width - the width of the desired screen representation - `int`
  height - the height of the desired screen representation - `int`
  observer - the ImageObserver object to be notified as the image is being prepared - `java.awt.image.ImageObserver`

  returns: true if the image has already been fully
            prepared; false otherwise - `boolean`"
  (^Boolean [^Component this ^java.awt.Image image ^Integer width ^Integer height ^java.awt.image.ImageObserver observer]
    (-> this (.prepareImage image width height observer)))
  (^Boolean [^Component this ^java.awt.Image image ^java.awt.image.ImageObserver observer]
    (-> this (.prepareImage image observer))))

(defn get-mouse-listeners
  "Returns an array of all the mouse listeners
   registered on this component.

  returns: all of this component's MouseListeners
           or an empty array if no mouse
           listeners are currently registered - `java.awt.event.MouseListener[]`"
  ([^Component this]
    (-> this (.getMouseListeners))))

(defn resize
  "Deprecated. As of JDK version 1.1,
   replaced by setSize(int, int).

  width - `int`
  height - `int`"
  ([^Component this ^Integer width ^Integer height]
    (-> this (.resize width height)))
  ([^Component this ^java.awt.Dimension d]
    (-> this (.resize d))))

(defn size
  "Deprecated. As of JDK version 1.1,
   replaced by getSize().

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^Component this]
    (-> this (.size))))

(defn transfer-focus
  "Transfers the focus to the next component, as though this Component were
   the focus owner."
  ([^Component this]
    (-> this (.transferFocus))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this Component.
   FooListeners are registered using the
   addFooListener method.


   You can specify the listenerType argument
   with a class literal, such as
   FooListener.class.
   For example, you can query a
   Component c
   for its mouse listeners with the following code:



  MouseListener[] mls = (MouseListener[])(c.getListeners(MouseListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class`

  returns: an array of all objects registered as
            FooListeners on this component,
            or an empty array if no such listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^Component this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn set-cursor
  "Sets the cursor image to the specified cursor.  This cursor
   image is displayed when the contains method for
   this component returns true for the current cursor location, and
   this Component is visible, displayable, and enabled. Setting the
   cursor of a Container causes that cursor to be displayed
   within all of the container's subcomponents, except for those
   that have a non-null cursor.

   The method may have no visual effect if the Java platform
   implementation and/or the native system do not support
   changing the mouse cursor shape.

  cursor - One of the constants defined by the Cursor class; if this parameter is null then this component will inherit the cursor of its parent - `java.awt.Cursor`"
  ([^Component this ^java.awt.Cursor cursor]
    (-> this (.setCursor cursor))))

(defn get-background
  "Gets the background color of this component.

  returns: this component's background color; if this component does
            not have a background color,
            the background color of its parent is returned - `java.awt.Color`"
  (^java.awt.Color [^Component this]
    (-> this (.getBackground))))

(defn get-input-method-requests
  "Gets the input method request handler which supports
   requests from input methods for this component. A component
   that supports on-the-spot text input must override this
   method to return an InputMethodRequests instance.
   At the same time, it also has to handle input method events.

  returns: the input method request handler for this component,
            null by default - `java.awt.im.InputMethodRequests`"
  (^java.awt.im.InputMethodRequests [^Component this]
    (-> this (.getInputMethodRequests))))

(defn set-component-orientation
  "Sets the language-sensitive orientation that is to be used to order
   the elements or text within this component.  Language-sensitive
   LayoutManager and Component
   subclasses will use this property to
   determine how to lay out and draw components.

   At construction time, a component's orientation is set to
   ComponentOrientation.UNKNOWN,
   indicating that it has not been specified
   explicitly.  The UNKNOWN orientation behaves the same as
   ComponentOrientation.LEFT_TO_RIGHT.

   To set the orientation of a single component, use this method.
   To set the orientation of an entire component
   hierarchy, use
   applyComponentOrientation.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

  o - `java.awt.ComponentOrientation`"
  ([^Component this ^java.awt.ComponentOrientation o]
    (-> this (.setComponentOrientation o))))

(defn get-baseline
  "Returns the baseline.  The baseline is measured from the top of
   the component.  This method is primarily meant for
   LayoutManagers to align components along their
   baseline.  A return value less than 0 indicates this component
   does not have a reasonable baseline and that
   LayoutManagers should not align this component on
   its baseline.

   The default implementation returns -1.  Subclasses that support
   baseline should override appropriately.  If a value >= 0 is
   returned, then the component has a valid baseline for any
   size >= the minimum size and getBaselineResizeBehavior
   can be used to determine how the baseline changes with size.

  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: the baseline or < 0 indicating there is no reasonable
           baseline - `int`

  throws: java.lang.IllegalArgumentException - if width or height is < 0"
  (^Integer [^Component this ^Integer width ^Integer height]
    (-> this (.getBaseline width height))))

(defn set-maximum-size
  "Sets the maximum size of this component to a constant
   value.  Subsequent calls to getMaximumSize will always
   return this value.  Setting the maximum size to null
   restores the default behavior.

  maximum-size - a Dimension containing the desired maximum allowable size - `java.awt.Dimension`"
  ([^Component this ^java.awt.Dimension maximum-size]
    (-> this (.setMaximumSize maximum-size))))

(defn mouse-enter
  "Deprecated. As of JDK version 1.1,
   replaced by processMouseEvent(MouseEvent).

  evt - `java.awt.Event`
  x - `int`
  y - `int`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt ^Integer x ^Integer y]
    (-> this (.mouseEnter evt x y))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list for a specific
   property. The specified property may be user-defined, or one of the
   following:

      this Component's font (\"font\")
      this Component's background color (\"background\")
      this Component's foreground color (\"foreground\")
      this Component's focusability (\"focusable\")
      this Component's focus traversal keys enabled state
          (\"focusTraversalKeysEnabled\")
      this Component's Set of FORWARD_TRAVERSAL_KEYS
          (\"forwardFocusTraversalKeys\")
      this Component's Set of BACKWARD_TRAVERSAL_KEYS
          (\"backwardFocusTraversalKeys\")
      this Component's Set of UP_CYCLE_TRAVERSAL_KEYS
          (\"upCycleFocusTraversalKeys\")

   Note that if this Component is inheriting a bound property, then no
   event will be fired in response to a change in the inherited property.

   If propertyName or listener is null,
   no exception is thrown and no action is taken.

  property-name - one of the property names listed above - `java.lang.String`
  listener - the property change listener to be added - `java.beans.PropertyChangeListener`"
  ([^Component this ^java.lang.String property-name ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener property-name listener)))
  ([^Component this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn add-hierarchy-listener
  "Adds the specified hierarchy listener to receive hierarchy changed
   events from this component when the hierarchy to which this container
   belongs changes.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the hierarchy listener - `java.awt.event.HierarchyListener`"
  ([^Component this ^java.awt.event.HierarchyListener l]
    (-> this (.addHierarchyListener l))))

(defn add-key-listener
  "Adds the specified key listener to receive key events from
   this component.
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the key listener. - `java.awt.event.KeyListener`"
  ([^Component this ^java.awt.event.KeyListener l]
    (-> this (.addKeyListener l))))

(defn mouse-up
  "Deprecated. As of JDK version 1.1,
   replaced by processMouseEvent(MouseEvent).

  evt - `java.awt.Event`
  x - `int`
  y - `int`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt ^Integer x ^Integer y]
    (-> this (.mouseUp evt x y))))

(defn revalidate
  "Revalidates the component hierarchy up to the nearest validate root.

   This method first invalidates the component hierarchy starting from this
   component up to the nearest validate root. Afterwards, the component
   hierarchy is validated starting from the nearest validate root.

   This is a convenience method supposed to help application developers
   avoid looking for validate roots manually. Basically, it's equivalent to
   first calling the invalidate() method on this component, and
   then calling the validate() method on the nearest validate
   root."
  ([^Component this]
    (-> this (.revalidate))))

(defn showing?
  "Determines whether this component is showing on screen. This means
   that the component must be visible, and it must be in a container
   that is visible and showing.

   Note: sometimes there is no way to detect whether the
   Component is actually visible to the user.  This can happen when:

   the component has been added to a visible ScrollPane but
   the Component is not currently in the scroll pane's view port.
   the Component is obscured by another Component or
   Container.

  returns: true if the component is showing,
            false otherwise - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isShowing))))

(defn get-size
  "Stores the width/height of this component into \"return value\" rv
   and return rv.   If rv is null a new
   Dimension object is allocated.  This version of
   getSize is useful if the caller wants to avoid
   allocating a new Dimension object on the heap.

  rv - the return value, modified to the components size - `java.awt.Dimension`

  returns: rv - `java.awt.Dimension`"
  (^java.awt.Dimension [^Component this ^java.awt.Dimension rv]
    (-> this (.getSize rv)))
  (^java.awt.Dimension [^Component this]
    (-> this (.getSize))))

(defn minimum-size
  "Deprecated. As of JDK version 1.1,
   replaced by getMinimumSize().

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^Component this]
    (-> this (.minimumSize))))

(defn get-mouse-wheel-listeners
  "Returns an array of all the mouse wheel listeners
   registered on this component.

  returns: all of this component's MouseWheelListeners
           or an empty array if no mouse wheel
           listeners are currently registered - `java.awt.event.MouseWheelListener[]`"
  ([^Component this]
    (-> this (.getMouseWheelListeners))))

(defn get-color-model
  "Gets the instance of ColorModel used to display
   the component on the output device.

  returns: the color model used by this component - `java.awt.image.ColorModel`"
  (^java.awt.image.ColorModel [^Component this]
    (-> this (.getColorModel))))

(defn got-focus
  "Deprecated. As of JDK version 1.1,
   replaced by processFocusEvent(FocusEvent).

  evt - `java.awt.Event`
  what - `java.lang.Object`

  returns: `boolean`"
  (^Boolean [^Component this ^java.awt.Event evt ^java.lang.Object what]
    (-> this (.gotFocus evt what))))

(defn remove-focus-listener
  "Removes the specified focus listener so that it no longer
   receives focus events from this component. This method performs
   no function, nor does it throw an exception, if the listener
   specified by the argument was not previously added to this component.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the focus listener - `java.awt.event.FocusListener`"
  ([^Component this ^java.awt.event.FocusListener l]
    (-> this (.removeFocusListener l))))

(defn focus-cycle-root?
  "Returns whether the specified Container is the focus cycle root of this
   Component's focus traversal cycle. Each focus traversal cycle has only
   a single focus cycle root and each Component which is not a Container
   belongs to only a single focus traversal cycle.

  container - the Container to be tested - `java.awt.Container`

  returns: true if the specified Container is a focus-cycle-
           root of this Component; false otherwise - `boolean`"
  (^Boolean [^Component this ^java.awt.Container container]
    (-> this (.isFocusCycleRoot container))))

(defn remove-key-listener
  "Removes the specified key listener so that it no longer
   receives key events from this component. This method performs
   no function, nor does it throw an exception, if the listener
   specified by the argument was not previously added to this component.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the key listener - `java.awt.event.KeyListener`"
  ([^Component this ^java.awt.event.KeyListener l]
    (-> this (.removeKeyListener l))))

(defn remove-component-listener
  "Removes the specified component listener so that it no longer
   receives component events from this component. This method performs
   no function, nor does it throw an exception, if the listener
   specified by the argument was not previously added to this component.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the component listener - `java.awt.event.ComponentListener`"
  ([^Component this ^java.awt.event.ComponentListener l]
    (-> this (.removeComponentListener l))))

(defn get-mouse-motion-listeners
  "Returns an array of all the mouse motion listeners
   registered on this component.

  returns: all of this component's MouseMotionListeners
           or an empty array if no mouse motion
           listeners are currently registered - `java.awt.event.MouseMotionListener[]`"
  ([^Component this]
    (-> this (.getMouseMotionListeners))))

(defn add-mouse-wheel-listener
  "Adds the specified mouse wheel listener to receive mouse wheel events
   from this component.  Containers also receive mouse wheel events from
   sub-components.

   For information on how mouse wheel events are dispatched, see
   the class description for MouseWheelEvent.

   If l is null, no exception is thrown and no
   action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the mouse wheel listener - `java.awt.event.MouseWheelListener`"
  ([^Component this ^java.awt.event.MouseWheelListener l]
    (-> this (.addMouseWheelListener l))))

(defn get-preferred-size
  "Gets the preferred size of this component.

  returns: a dimension object indicating this component's preferred size - `java.awt.Dimension`"
  (^java.awt.Dimension [^Component this]
    (-> this (.getPreferredSize))))

(defn enabled?
  "Determines whether this component is enabled. An enabled component
   can respond to user input and generate events. Components are
   enabled initially by default. A component may be enabled or disabled by
   calling its setEnabled method.

  returns: true if the component is enabled,
            false otherwise - `boolean`"
  (^Boolean [^Component this]
    (-> this (.isEnabled))))

(defn get-peer
  "Deprecated. As of JDK version 1.1,
   programs should not directly manipulate peers;
   replaced by boolean isDisplayable().

  returns: `java.awt.peer.ComponentPeer`"
  (^java.awt.peer.ComponentPeer [^Component this]
    (-> this (.getPeer))))

(defn locate
  "Deprecated. As of JDK version 1.1,
   replaced by getComponentAt(int, int).

  x - `int`
  y - `int`

  returns: `java.awt.Component`"
  (^java.awt.Component [^Component this ^Integer x ^Integer y]
    (-> this (.locate x y))))

(defn request-focus-in-window
  "Requests that this Component get the input focus, if this
   Component's top-level ancestor is already the focused
   Window. This component must be displayable, focusable, visible
   and all of its ancestors (with the exception of the top-level
   Window) must be visible for the request to be granted. Every
   effort will be made to honor the request; however, in some
   cases it may be impossible to do so. Developers must never
   assume that this Component is the focus owner until this
   Component receives a FOCUS_GAINED event.

   This method returns a boolean value. If false is returned,
   the request is guaranteed to fail. If true is
   returned, the request will succeed unless it is vetoed, or an
   extraordinary event, such as disposal of the Component's peer, occurs
   before the request can be granted by the native windowing system. Again,
   while a return value of true indicates that the request is
   likely to succeed, developers must never assume that this Component is
   the focus owner until this Component receives a FOCUS_GAINED event.

   This method cannot be used to set the focus owner to no Component at
   all. Use KeyboardFocusManager.clearGlobalFocusOwner()
   instead.

   The focus behavior of this method can be implemented uniformly across
   platforms, and thus developers are strongly encouraged to use this
   method over requestFocus when possible. Code which relies
   on requestFocus may exhibit different focus behavior on
   different platforms.

   Note: Not all focus transfers result from invoking this method. As
   such, a component may receive focus without this or any of the other
   requestFocus methods of Component being invoked.

  returns: false if the focus change request is guaranteed to
           fail; true if it is likely to succeed - `boolean`"
  (^Boolean [^Component this]
    (-> this (.requestFocusInWindow))))

(defn add-component-listener
  "Adds the specified component listener to receive component events from
   this component.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the component listener - `java.awt.event.ComponentListener`"
  ([^Component this ^java.awt.event.ComponentListener l]
    (-> this (.addComponentListener l))))

