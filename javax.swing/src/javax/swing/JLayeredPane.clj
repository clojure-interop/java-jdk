(ns javax.swing.JLayeredPane
  "JLayeredPane adds depth to a JFC/Swing container,
  allowing components to overlap each other when needed.
  An Integer object specifies each component's depth in the
  container, where higher-numbered components sit \"on top\" of other
  components.
  For task-oriented documentation and examples of using layered panes see
  How to Use a Layered Pane,
  a section in The Java Tutorial.








  For convenience, JLayeredPane divides the depth-range
  into several different layers. Putting a component into one of those
  layers makes it easy to ensure that components overlap properly,
  without having to worry about specifying numbers for specific depths:

     DEFAULT_LAYER
          The standard layer, where most components go. This the bottommost
          layer.
     PALETTE_LAYER
          The palette layer sits over the default layer. Useful for floating
          toolbars and palettes, so they can be positioned above other components.
     MODAL_LAYER
          The layer used for modal dialogs. They will appear on top of any
          toolbars, palettes, or standard components in the container.
     POPUP_LAYER
          The popup layer displays above dialogs. That way, the popup windows
          associated with combo boxes, tooltips, and other help text will appear
          above the component, palette, or dialog that generated them.
     DRAG_LAYER
          When dragging a component, reassigning it to the drag layer ensures
          that it is positioned over every other component in the container. When
          finished dragging, it can be reassigned to its normal layer.

  The JLayeredPane methods moveToFront(Component),
  moveToBack(Component) and setPosition can be used
  to reposition a component within its layer. The setLayer method
  can also be used to change the component's current layer.

  Details
  JLayeredPane manages its list of children like
  Container, but allows for the definition of a several
  layers within itself. Children in the same layer are managed exactly
  like the normal Container object,
  with the added feature that when children components overlap, children
  in higher layers display above the children in lower layers.

  Each layer is a distinct integer number. The layer attribute can be set
  on a Component by passing an Integer
  object during the add call. For example:


      layeredPane.add(child, JLayeredPane.DEFAULT_LAYER);
  or
      layeredPane.add(child, new Integer(10));
  The layer attribute can also be set on a Component by calling

      layeredPaneParent.setLayer(child, 10)
  on the JLayeredPane that is the parent of component. The layer
  should be set before adding the child to the parent.

  Higher number layers display above lower number layers. So, using
  numbers for the layers and letters for individual components, a
  representative list order would look like this:

        5a, 5b, 5c, 2a, 2b, 2c, 1a
  where the leftmost components are closest to the top of the display.

  A component can be moved to the top or bottom position within its
  layer by calling moveToFront or moveToBack.

  The position of a component within a layer can also be specified directly.
  Valid positions range from 0 up to one less than the number of
  components in that layer. A value of -1 indicates the bottommost
  position. A value of 0 indicates the topmost position. Unlike layer
  numbers, higher position values are lower in the display.

  Note: This sequence (defined by java.awt.Container) is the reverse
  of the layer numbering sequence. Usually though, you will use moveToFront,
  moveToBack, and setLayer.

  Here are some examples using the method add(Component, layer, position):
  Calling add(5x, 5, -1) results in:

        5a, 5b, 5c, 5x, 2a, 2b, 2c, 1a

  Calling add(5z, 5, 2) results in:

        5a, 5b, 5z, 5c, 5x, 2a, 2b, 2c, 1a

  Calling add(3a, 3, 7) results in:

        5a, 5b, 5z, 5c, 5x, 3a, 2a, 2b, 2c, 1a

  Using normal paint/event mechanics results in 1a appearing at the bottom
  and 5a being above all other components.

  Note: that these layers are simply a logical construct and LayoutManagers
  will affect all child components of this container without regard for
  layer settings.

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
  (:import [javax.swing JLayeredPane]))

(defn ->j-layered-pane
  "Constructor.

  Create a new JLayeredPane"
  (^JLayeredPane []
    (new JLayeredPane )))

(def *-default-layer
  "Static Constant.

  Convenience object defining the Default layer. Equivalent to new Integer(0).

  type: java.lang.Integer"
  JLayeredPane/DEFAULT_LAYER)

(def *-palette-layer
  "Static Constant.

  Convenience object defining the Palette layer. Equivalent to new Integer(100).

  type: java.lang.Integer"
  JLayeredPane/PALETTE_LAYER)

(def *-modal-layer
  "Static Constant.

  Convenience object defining the Modal layer. Equivalent to new Integer(200).

  type: java.lang.Integer"
  JLayeredPane/MODAL_LAYER)

(def *-popup-layer
  "Static Constant.

  Convenience object defining the Popup layer. Equivalent to new Integer(300).

  type: java.lang.Integer"
  JLayeredPane/POPUP_LAYER)

(def *-drag-layer
  "Static Constant.

  Convenience object defining the Drag layer. Equivalent to new Integer(400).

  type: java.lang.Integer"
  JLayeredPane/DRAG_LAYER)

(def *-frame-content-layer
  "Static Constant.

  Convenience object defining the Frame Content layer.
   This layer is normally only use to position the contentPane and menuBar
   components of JFrame.
   Equivalent to new Integer(-30000).

  type: java.lang.Integer"
  JLayeredPane/FRAME_CONTENT_LAYER)

(def *-layer-property
  "Static Constant.

  Bound property

  type: java.lang.String"
  JLayeredPane/LAYER_PROPERTY)

(defn *put-layer
  "Sets the layer property on a JComponent. This method does not cause
   any side effects like setLayer() (painting, add/remove, etc).
   Normally you should use the instance method setLayer(), in order to
   get the desired side-effects (like repainting).

  c - the JComponent to move - `javax.swing.JComponent`
  layer - an int specifying the layer to move it to - `int`"
  ([^javax.swing.JComponent c ^Integer layer]
    (JLayeredPane/putLayer c layer)))

(defn *get-layer
  "Gets the layer property for a JComponent, it
   does not cause any side effects like setLayer(). (painting, add/remove, etc)
   Normally you should use the instance method getLayer().

  c - the JComponent to check - `javax.swing.JComponent`

  returns: an int specifying the component's layer - `int`"
  (^Integer [^javax.swing.JComponent c]
    (JLayeredPane/getLayer c)))

(defn *get-layered-pane-above
  "Convenience method that returns the first JLayeredPane which
   contains the specified component. Note that all JFrames have a
   JLayeredPane at their root, so any component in a JFrame will
   have a JLayeredPane parent.

  c - the Component to check - `java.awt.Component`

  returns: the JLayeredPane that contains the component, or
           null if no JLayeredPane is found in the component
           hierarchy - `javax.swing.JLayeredPane`"
  (^javax.swing.JLayeredPane [^java.awt.Component c]
    (JLayeredPane/getLayeredPaneAbove c)))

(defn get-index-of
  "Returns the index of the specified Component.
   This is the absolute index, ignoring layers.
   Index numbers, like position numbers, have the topmost component
   at index zero. Larger numbers are closer to the bottom.

  c - the Component to check - `java.awt.Component`

  returns: an int specifying the component's index - `int`"
  (^Integer [^JLayeredPane this ^java.awt.Component c]
    (-> this (.getIndexOf c))))

(defn set-position
  "Moves the component to position within its current layer,
   where 0 is the topmost position within the layer and -1 is the bottommost
   position.

   Note: Position numbering is defined by java.awt.Container, and
   is the opposite of layer numbering. Lower position numbers are closer
   to the top (0 is topmost), and higher position numbers are closer to
   the bottom.

  c - the Component to move - `java.awt.Component`
  position - an int in the range -1..N-1, where N is the number of components in the component's current layer - `int`"
  ([^JLayeredPane this ^java.awt.Component c ^Integer position]
    (-> this (.setPosition c position))))

(defn set-layer
  "Sets the layer attribute for the specified component and
   also sets its position within that layer.

  c - the Component to set the layer for - `java.awt.Component`
  layer - an int specifying the layer to set, where lower numbers are closer to the bottom - `int`
  position - an int specifying the position within the layer, where 0 is the topmost position and -1 is the bottommost position - `int`"
  ([^JLayeredPane this ^java.awt.Component c ^Integer layer ^Integer position]
    (-> this (.setLayer c layer position)))
  ([^JLayeredPane this ^java.awt.Component c ^Integer layer]
    (-> this (.setLayer c layer))))

(defn get-position
  "Get the relative position of the component within its layer.

  c - the Component to check - `java.awt.Component`

  returns: an int giving the component's position, where 0 is the
           topmost position and the highest index value = the count
           count of components at that layer, minus 1 - `int`"
  (^Integer [^JLayeredPane this ^java.awt.Component c]
    (-> this (.getPosition c))))

(defn move-to-front
  "Moves the component to the top of the components in its current layer
   (position 0).

  c - the Component to move - `java.awt.Component`"
  ([^JLayeredPane this ^java.awt.Component c]
    (-> this (.moveToFront c))))

(defn get-layer
  "Returns the layer attribute for the specified Component.

  c - the Component to check - `java.awt.Component`

  returns: an int specifying the component's current layer - `int`"
  (^Integer [^JLayeredPane this ^java.awt.Component c]
    (-> this (.getLayer c))))

(defn get-components-in-layer
  "Returns an array of the components in the specified layer.

  layer - an int specifying the layer to check - `int`

  returns: an array of Components contained in that layer - `java.awt.Component[]`"
  ([^JLayeredPane this ^Integer layer]
    (-> this (.getComponentsInLayer layer))))

(defn remove
  "Remove the indexed component from this pane.
   This is the absolute index, ignoring layers.

  index - an int specifying the component to remove - `int`"
  ([^JLayeredPane this ^Integer index]
    (-> this (.remove index))))

(defn lowest-layer
  "Returns the lowest layer value from all current children.
   Returns 0 if there are no children.

  returns: an int indicating the layer of the bottommost component in the
           pane, or zero if there are no children - `int`"
  (^Integer [^JLayeredPane this]
    (-> this (.lowestLayer))))

(defn paint
  "Paints this JLayeredPane within the specified graphics context.

  g - the Graphics context within which to paint - `java.awt.Graphics`"
  ([^JLayeredPane this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JLayeredPane.
   For layered panes, the AccessibleContext takes the form of an
   AccessibleJLayeredPane.
   A new AccessibleJLayeredPane instance is created if necessary.

  returns: an AccessibleJLayeredPane that serves as the
           AccessibleContext of this JLayeredPane - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JLayeredPane this]
    (-> this (.getAccessibleContext))))

(defn highest-layer
  "Returns the highest layer value from all current children.
   Returns 0 if there are no children.

  returns: an int indicating the layer of the topmost component in the
           pane, or zero if there are no children - `int`"
  (^Integer [^JLayeredPane this]
    (-> this (.highestLayer))))

(defn move-to-back
  "Moves the component to the bottom of the components in its current layer
   (position -1).

  c - the Component to move - `java.awt.Component`"
  ([^JLayeredPane this ^java.awt.Component c]
    (-> this (.moveToBack c))))

(defn get-component-count-in-layer
  "Returns the number of children currently in the specified layer.

  layer - an int specifying the layer to check - `int`

  returns: an int specifying the number of components in that layer - `int`"
  (^Integer [^JLayeredPane this ^Integer layer]
    (-> this (.getComponentCountInLayer layer))))

(defn remove-all
  "Removes all the components from this container."
  ([^JLayeredPane this]
    (-> this (.removeAll))))

(defn optimized-drawing-enabled?
  "Returns false if components in the pane can overlap, which makes
   optimized drawing impossible. Otherwise, returns true.

  returns: false if components can overlap, else true - `boolean`"
  (^Boolean [^JLayeredPane this]
    (-> this (.isOptimizedDrawingEnabled))))

