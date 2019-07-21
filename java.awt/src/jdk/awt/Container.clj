(ns jdk.awt.Container
  "A generic Abstract Window Toolkit(AWT) container object is a component
  that can contain other AWT components.

  Components added to a container are tracked in a list.  The order
  of the list will define the components' front-to-back stacking order
  within the container.  If no index is specified when adding a
  component to a container, it will be added to the end of the list
  (and hence to the bottom of the stacking order).

  Note: For details on the focus subsystem, see

  How to Use the Focus Subsystem,
  a section in The Java Tutorial, and the
  Focus Specification
  for more information."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Container]))

(defn ->container
  "Constructor.

  Constructs a new Container. Containers can be extended directly,
   but are lightweight in this case and must be contained by a parent
   somewhere higher up in the component tree that is native.
   (such as Frame for example)."
  (^Container []
    (new Container )))

(defn get-minimum-size
  "Returns the minimum size of this container.  If the minimum size has
   not been set explicitly by Component.setMinimumSize(Dimension)
   and this Container has a non-null LayoutManager,
   then LayoutManager.minimumLayoutSize(Container)
   is used to calculate the minimum size.

   Note: some implementations may cache the value returned from the
   LayoutManager.  Implementations that cache need not invoke
   minimumLayoutSize on the LayoutManager every time
   this method is invoked, rather the LayoutManager will only
   be queried after the Container becomes invalid.

  returns: an instance of Dimension that represents
                  the minimum size of this container. - `java.awt.Dimension`"
  (^java.awt.Dimension [^Container this]
    (-> this (.getMinimumSize))))

(defn set-component-z-order
  "Moves the specified component to the specified z-order index in
   the container. The z-order determines the order that components
   are painted; the component with the highest z-order paints first
   and the component with the lowest z-order paints last.
   Where components overlap, the component with the lower
   z-order paints over the component with the higher z-order.

   If the component is a child of some other container, it is
   removed from that container before being added to this container.
   The important difference between this method and
   java.awt.Container.add(Component, int) is that this method
   doesn't call removeNotify on the component while
   removing it from its previous container unless necessary and when
   allowed by the underlying native windowing system. This way, if the
   component has the keyboard focus, it maintains the focus when
   moved to the new position.

   This property is guaranteed to apply only to lightweight
   non-Container components.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

   Note: Not all platforms support changing the z-order of
   heavyweight components from one container into another without
   the call to removeNotify. There is no way to detect
   whether a platform supports this, so developers shouldn't make
   any assumptions.

  comp - the component to be moved - `java.awt.Component`
  index - the position in the container's list to insert the component, where getComponentCount() appends to the end - `int`

  throws: java.lang.NullPointerException - if comp is null"
  ([^Container this ^java.awt.Component comp ^Integer index]
    (-> this (.setComponentZOrder comp index))))

(defn get-component
  "Gets the nth component in this container.

   Note: This method should be called under AWT tree lock.

  n - the index of the component to get. - `int`

  returns: the nth component in this container. - `java.awt.Component`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the nth value does not exist."
  (^java.awt.Component [^Container this ^Integer n]
    (-> this (.getComponent n))))

(defn set-layout
  "Sets the layout manager for this container.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

  mgr - the specified layout manager - `java.awt.LayoutManager`"
  ([^Container this ^java.awt.LayoutManager mgr]
    (-> this (.setLayout mgr))))

(defn get-focus-traversal-policy
  "Returns the focus traversal policy that will manage keyboard traversal
   of this Container's children, or null if this Container is not a focus
   cycle root. If no traversal policy has been explicitly set for this
   Container, then this Container's focus-cycle-root ancestor's policy is
   returned.

  returns: this Container's focus traversal policy, or null if this
           Container is not a focus cycle root. - `java.awt.FocusTraversalPolicy`"
  (^java.awt.FocusTraversalPolicy [^Container this]
    (-> this (.getFocusTraversalPolicy))))

(defn set-focus-traversal-policy
  "Sets the focus traversal policy that will manage keyboard traversal of
   this Container's children, if this Container is a focus cycle root. If
   the argument is null, this Container inherits its policy from its focus-
   cycle-root ancestor. If the argument is non-null, this policy will be
   inherited by all focus-cycle-root children that have no keyboard-
   traversal policy of their own (as will, recursively, their focus-cycle-
   root children).

   If this Container is not a focus cycle root, the policy will be
   remembered, but will not be used or inherited by this or any other
   Containers until this Container is made a focus cycle root.

  policy - the new focus traversal policy for this Container - `java.awt.FocusTraversalPolicy`"
  ([^Container this ^java.awt.FocusTraversalPolicy policy]
    (-> this (.setFocusTraversalPolicy policy))))

(defn get-maximum-size
  "Returns the maximum size of this container.  If the maximum size has
   not been set explicitly by Component.setMaximumSize(Dimension)
   and the LayoutManager installed on this Container
   is an instance of LayoutManager2, then
   LayoutManager2.maximumLayoutSize(Container)
   is used to calculate the maximum size.

   Note: some implementations may cache the value returned from the
   LayoutManager2.  Implementations that cache need not invoke
   maximumLayoutSize on the LayoutManager2 every time
   this method is invoked, rather the LayoutManager2 will only
   be queried after the Container becomes invalid.

  returns: an instance of Dimension that represents
                  the maximum size of this container. - `java.awt.Dimension`"
  (^java.awt.Dimension [^Container this]
    (-> this (.getMaximumSize))))

(defn list
  "Prints a listing of this container to the specified output
   stream. The listing starts at the specified indentation.

   The immediate children of the container are printed with
   an indentation of indent+1.  The children
   of those children are printed at indent+2
   and so on.

  out - a print stream - `java.io.PrintStream`
  indent - the number of spaces to indent - `int`

  throws: java.lang.NullPointerException - if out is null"
  ([^Container this ^java.io.PrintStream out ^Integer indent]
    (-> this (.list out indent))))

(defn paint-components
  "Paints each of the components in this container.

  g - the graphics context. - `java.awt.Graphics`"
  ([^Container this ^java.awt.Graphics g]
    (-> this (.paintComponents g))))

(defn get-insets
  "Determines the insets of this container, which indicate the size
   of the container's border.

   A Frame object, for example, has a top inset that
   corresponds to the height of the frame's title bar.

  returns: the insets of this container. - `java.awt.Insets`"
  (^java.awt.Insets [^Container this]
    (-> this (.getInsets))))

(defn add-container-listener
  "Adds the specified container listener to receive container events
   from this container.
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the container listener - `java.awt.event.ContainerListener`"
  ([^Container this ^java.awt.event.ContainerListener l]
    (-> this (.addContainerListener l))))

(defn get-focus-traversal-keys
  "Returns the Set of focus traversal keys for a given traversal operation
   for this Container. (See
   setFocusTraversalKeys for a full description of each key.)

   If a Set of traversal keys has not been explicitly defined for this
   Container, then this Container's parent's Set is returned. If no Set
   has been explicitly defined for any of this Container's ancestors, then
   the current KeyboardFocusManager's default Set is returned.

  id - one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS - `int`

  returns: the Set of AWTKeyStrokes for the specified operation. The Set
           will be unmodifiable, and may be empty. null will never be
           returned. - `java.util.Set<java.awt.AWTKeyStroke>`

  throws: java.lang.IllegalArgumentException - if id is not one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS"
  (^java.util.Set [^Container this ^Integer id]
    (-> this (.getFocusTraversalKeys id))))

(defn get-container-listeners
  "Returns an array of all the container listeners
   registered on this container.

  returns: all of this container's ContainerListeners
           or an empty array if no container
           listeners are currently registered - `java.awt.event.ContainerListener[]`"
  ([^Container this]
    (-> this (.getContainerListeners))))

(defn set-focus-cycle-root
  "Sets whether this Container is the root of a focus traversal cycle. Once
   focus enters a traversal cycle, typically it cannot leave it via focus
   traversal unless one of the up- or down-cycle keys is pressed. Normal
   traversal is limited to this Container, and all of this Container's
   descendants that are not descendants of inferior focus cycle roots. Note
   that a FocusTraversalPolicy may bend these restrictions, however. For
   example, ContainerOrderFocusTraversalPolicy supports implicit down-cycle
   traversal.

   The alternative way to specify the traversal order of this Container's
   children is to make this Container a
   focus traversal policy provider.

  focus-cycle-root - indicates whether this Container is the root of a focus traversal cycle - `boolean`"
  ([^Container this ^Boolean focus-cycle-root]
    (-> this (.setFocusCycleRoot focus-cycle-root))))

(defn get-mouse-position
  "Returns the position of the mouse pointer in this Container's
   coordinate space if the Container is under the mouse pointer,
   otherwise returns null.
   This method is similar to Component.getMousePosition() with the exception
   that it can take the Container's children into account.
   If allowChildren is false, this method will return
   a non-null value only if the mouse pointer is above the Container
   directly, not above the part obscured by children.
   If allowChildren is true, this method returns
   a non-null value if the mouse pointer is above Container or any
   of its descendants.

  allow-children - true if children should be taken into account - `boolean`

  returns: mouse coordinates relative to this Component, or null - `java.awt.Point`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  (^java.awt.Point [^Container this ^Boolean allow-children]
    (-> this (.getMousePosition allow-children))))

(defn validate
  "Validates this container and all of its subcomponents.

   Validating a container means laying out its subcomponents.
   Layout-related changes, such as setting the bounds of a component, or
   adding a component to the container, invalidate the container
   automatically.  Note that the ancestors of the container may be
   invalidated also (see Component.invalidate() for details.)
   Therefore, to restore the validity of the hierarchy, the validate() method should be invoked on the top-most invalid
   container of the hierarchy.

   Validating the container may be a quite time-consuming operation. For
   performance reasons a developer may postpone the validation of the
   hierarchy till a set of layout-related operations completes, e.g. after
   adding all the children to the container.

   If this Container is not valid, this method invokes
   the validateTree method and marks this Container
   as valid. Otherwise, no action is performed."
  ([^Container this]
    (-> this (.validate))))

(defn focus-traversal-policy-set?
  "Returns whether the focus traversal policy has been explicitly set for
   this Container. If this method returns false, this
   Container will inherit its focus traversal policy from an ancestor.

  returns: true if the focus traversal policy has been
           explicitly set for this Container; false otherwise. - `boolean`"
  (^Boolean [^Container this]
    (-> this (.isFocusTraversalPolicySet))))

(defn transfer-focus-down-cycle
  "Transfers the focus down one focus traversal cycle. If this Container is
   a focus cycle root, then the focus owner is set to this Container's
   default Component to focus, and the current focus cycle root is set to
   this Container. If this Container is not a focus cycle root, then no
   focus traversal operation occurs."
  ([^Container this]
    (-> this (.transferFocusDownCycle))))

(defn are-focus-traversal-keys-set
  "Returns whether the Set of focus traversal keys for the given focus
   traversal operation has been explicitly defined for this Container. If
   this method returns false, this Container is inheriting the
   Set from an ancestor, or from the current KeyboardFocusManager.

  id - one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS - `int`

  returns: true if the the Set of focus traversal keys for the
           given focus traversal operation has been explicitly defined for
           this Component; false otherwise. - `boolean`

  throws: java.lang.IllegalArgumentException - if id is not one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS"
  (^Boolean [^Container this ^Integer id]
    (-> this (.areFocusTraversalKeysSet id))))

(defn update
  "Updates the container.  This forwards the update to any lightweight
   components that are children of this container.  If this method is
   reimplemented, super.update(g) should be called so that lightweight
   components are properly rendered.  If a child component is entirely
   clipped by the current clipping setting in g, update() will not be
   forwarded to that child.

  g - the specified Graphics window - `java.awt.Graphics`"
  ([^Container this ^java.awt.Graphics g]
    (-> this (.update g))))

(defn validate-root?
  "Indicates if this container is a validate root.

   Layout-related changes, such as bounds of the validate root descendants,
   do not affect the layout of the validate root parent. This peculiarity
   enables the invalidate() method to stop invalidating the
   component hierarchy when the method encounters a validate root. However,
   to preserve backward compatibility this new optimized behavior is
   enabled only when the java.awt.smartInvalidate system property
   value is set to true.

   If a component hierarchy contains validate roots and the new optimized
   invalidate() behavior is enabled, the validate() method
   must be invoked on the validate root of a previously invalidated
   component to restore the validity of the hierarchy later. Otherwise,
   calling the validate() method on the top-level container (such
   as a Frame object) should be used to restore the validity of the
   component hierarchy.

   The Window class and the Applet class are the validate
   roots in AWT.  Swing introduces more validate roots.

  returns: whether this container is a validate root - `boolean`"
  (^Boolean [^Container this]
    (-> this (.isValidateRoot))))

(defn remove-container-listener
  "Removes the specified container listener so it no longer receives
   container events from this container.
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the container listener - `java.awt.event.ContainerListener`"
  ([^Container this ^java.awt.event.ContainerListener l]
    (-> this (.removeContainerListener l))))

(defn get-layout
  "Gets the layout manager for this container.

  returns: `java.awt.LayoutManager`"
  (^java.awt.LayoutManager [^Container this]
    (-> this (.getLayout))))

(defn get-alignment-x
  "Returns the alignment along the x axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  returns: `float`"
  (^Float [^Container this]
    (-> this (.getAlignmentX))))

(defn add-notify
  "Makes this Container displayable by connecting it to
   a native screen resource.  Making a container displayable will
   cause all of its children to be made displayable.
   This method is called internally by the toolkit and should
   not be called directly by programs."
  ([^Container this]
    (-> this (.addNotify))))

(defn remove-notify
  "Makes this Container undisplayable by removing its connection
   to its native screen resource.  Making a container undisplayable
   will cause all of its children to be made undisplayable.
   This method is called by the toolkit internally and should
   not be called directly by programs."
  ([^Container this]
    (-> this (.removeNotify))))

(defn get-components
  "Gets all the components in this container.

   Note: This method should be called under AWT tree lock.

  returns: an array of all the components in this container. - `java.awt.Component[]`"
  ([^Container this]
    (-> this (.getComponents))))

(defn remove
  "Removes the component, specified by index,
   from this container.
   This method also notifies the layout manager to remove the
   component from this container's layout via the
   removeLayoutComponent method.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy. If the container has already been
   displayed, the hierarchy must be validated thereafter in order to
   reflect the changes.

  index - the index of the component to be removed - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if index is not in range [0, getComponentCount()-1]"
  ([^Container this ^Integer index]
    (-> this (.remove index))))

(defn layout
  "Deprecated. As of JDK version 1.1,
   replaced by doLayout()."
  ([^Container this]
    (-> this (.layout))))

(defn get-component-z-order
  "Returns the z-order index of the component inside the container.
   The higher a component is in the z-order hierarchy, the lower
   its index.  The component with the lowest z-order index is
   painted last, above all other child components.

  comp - the component being queried - `java.awt.Component`

  returns: the z-order index of the component; otherwise
            returns -1 if the component is null
            or doesn't belong to the container - `int`"
  (^Integer [^Container this ^java.awt.Component comp]
    (-> this (.getComponentZOrder comp))))

(defn preferred-size
  "Deprecated. As of JDK version 1.1,
   replaced by getPreferredSize().

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^Container this]
    (-> this (.preferredSize))))

(defn set-font
  "Sets the font of this container.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

  f - The font to become this container's font. - `java.awt.Font`"
  ([^Container this ^java.awt.Font f]
    (-> this (.setFont f))))

(defn invalidate
  "Invalidates the container.

   If the LayoutManager installed on this container is an instance
   of the LayoutManager2 interface, then
   the LayoutManager2.invalidateLayout(Container) method is invoked
   on it supplying this Container as the argument.

   Afterwards this method marks this container invalid, and invalidates its
   ancestors. See the Component.invalidate() method for more details."
  ([^Container this]
    (-> this (.invalidate))))

(defn print-components
  "Prints each of the components in this container.

  g - the graphics context. - `java.awt.Graphics`"
  ([^Container this ^java.awt.Graphics g]
    (-> this (.printComponents g))))

(defn get-component-at
  "Locates the component that contains the x,y position.  The
   top-most child component is returned in the case where there
   is overlap in the components.  This is determined by finding
   the component closest to the index 0 that claims to contain
   the given point via Component.contains(), except that Components
   which have native peers take precedence over those which do not
   (i.e., lightweight Components).

  x - the x coordinate - `int`
  y - the y coordinate - `int`

  returns: null if the component does not contain the position.
   If there is no child component at the requested point and the
   point is within the bounds of the container the container itself
   is returned; otherwise the top-most child is returned. - `java.awt.Component`"
  (^java.awt.Component [^Container this ^Integer x ^Integer y]
    (-> this (.getComponentAt x y)))
  (^java.awt.Component [^Container this ^java.awt.Point p]
    (-> this (.getComponentAt p))))

(defn get-alignment-y
  "Returns the alignment along the y axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  returns: `float`"
  (^Float [^Container this]
    (-> this (.getAlignmentY))))

(defn ancestor-of?
  "Checks if the component is contained in the component hierarchy of
   this container.

  c - the component - `java.awt.Component`

  returns: true if it is an ancestor;
               false otherwise. - `boolean`"
  (^Boolean [^Container this ^java.awt.Component c]
    (-> this (.isAncestorOf c))))

(defn paint
  "Paints the container. This forwards the paint to any lightweight
   components that are children of this container. If this method is
   reimplemented, super.paint(g) should be called so that lightweight
   components are properly rendered. If a child component is entirely
   clipped by the current clipping setting in g, paint() will not be
   forwarded to that child.

  g - the specified Graphics window - `java.awt.Graphics`"
  ([^Container this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn insets
  "Deprecated. As of JDK version 1.1,
   replaced by getInsets().

  returns: `java.awt.Insets`"
  (^java.awt.Insets [^Container this]
    (-> this (.insets))))

(defn apply-component-orientation
  "Sets the ComponentOrientation property of this container
   and all components contained within it.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

  o - the new component orientation of this container and the components contained within it. - `java.awt.ComponentOrientation`

  throws: java.lang.NullPointerException - if orientation is null."
  ([^Container this ^java.awt.ComponentOrientation o]
    (-> this (.applyComponentOrientation o))))

(defn do-layout
  "Causes this container to lay out its components.  Most programs
   should not call this method directly, but should invoke
   the validate method instead."
  ([^Container this]
    (-> this (.doLayout))))

(defn print
  "Prints the container. This forwards the print to any lightweight
   components that are children of this container. If this method is
   reimplemented, super.print(g) should be called so that lightweight
   components are properly rendered. If a child component is entirely
   clipped by the current clipping setting in g, print() will not be
   forwarded to that child.

  g - the specified Graphics window - `java.awt.Graphics`"
  ([^Container this ^java.awt.Graphics g]
    (-> this (.print g))))

(defn focus-traversal-policy-provider?
  "Returns whether this container provides focus traversal
   policy. If this property is set to true then when
   keyboard focus manager searches container hierarchy for focus
   traversal policy and encounters this container before any other
   container with this property as true or focus cycle roots then
   its focus traversal policy will be used instead of focus cycle
   root's policy.

  returns: true if this container provides focus traversal
           policy, false otherwise - `boolean`"
  (^Boolean [^Container this]
    (-> this (.isFocusTraversalPolicyProvider))))

(defn add
  "Adds the specified component to this container with the specified
   constraints at the specified index.  Also notifies the layout
   manager to add the component to the this container's layout using
   the specified constraints object.
   This is a convenience method for addImpl(java.awt.Component, java.lang.Object, int).

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy. If the container has already been
   displayed, the hierarchy must be validated thereafter in order to
   display the added component.

  comp - the component to be added - `java.awt.Component`
  constraints - an object expressing layout constraints for this - `java.lang.Object`
  index - the position in the container's list at which to insert the component; -1 means insert at the end component - `int`

  throws: java.lang.NullPointerException - if comp is null"
  ([^Container this ^java.awt.Component comp ^java.lang.Object constraints ^Integer index]
    (-> this (.add comp constraints index)))
  (^java.awt.Component [^Container this ^java.lang.String name ^java.awt.Component comp]
    (-> this (.add name comp)))
  (^java.awt.Component [^Container this ^java.awt.Component comp]
    (-> this (.add comp))))

(defn set-focus-traversal-keys
  "Sets the focus traversal keys for a given traversal operation for this
   Container.

   The default values for a Container's focus traversal keys are
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


      KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS
      Go down one focus traversal cycle
      none



   To disable a traversal key, use an empty Set; Collections.EMPTY_SET is
   recommended.

   Using the AWTKeyStroke API, client code can specify on which of two
   specific KeyEvents, KEY_PRESSED or KEY_RELEASED, the focus traversal
   operation will occur. Regardless of which KeyEvent is specified,
   however, all KeyEvents related to the focus traversal key, including the
   associated KEY_TYPED event, will be consumed, and will not be dispatched
   to any Container. It is a runtime error to specify a KEY_TYPED event as
   mapping to a focus traversal operation, or to map the same event to
   multiple default focus traversal operations.

   If a value of null is specified for the Set, this Container inherits the
   Set from its parent. If all ancestors of this Container have null
   specified for the Set, then the current KeyboardFocusManager's default
   Set is used.

   This method may throw a ClassCastException if any Object
   in keystrokes is not an AWTKeyStroke.

  id - one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS - `int`
  keystrokes - the Set of AWTKeyStroke for the specified operation - `java.util.Set`

  throws: java.lang.IllegalArgumentException - if id is not one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS, or if keystrokes contains null, or if any keystroke represents a KEY_TYPED event, or if any keystroke already maps to another focus traversal operation for this Container"
  ([^Container this ^Integer id ^java.util.Set keystrokes]
    (-> this (.setFocusTraversalKeys id keystrokes))))

(defn deliver-event
  "Deprecated. As of JDK version 1.1,
   replaced by dispatchEvent(AWTEvent e)

  e - `java.awt.Event`"
  ([^Container this ^java.awt.Event e]
    (-> this (.deliverEvent e))))

(defn get-component-count
  "Gets the number of components in this panel.

   Note: This method should be called under AWT tree lock.

  returns: the number of components in this panel. - `int`"
  (^Integer [^Container this]
    (-> this (.getComponentCount))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this Container.
   FooListeners are registered using the
   addFooListener method.


   You can specify the listenerType argument
   with a class literal, such as
   FooListener.class.
   For example, you can query a
   Container c
   for its container listeners with the following code:



  ContainerListener[] cls = (ContainerListener[])(c.getListeners(ContainerListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class`

  returns: an array of all objects registered as
            FooListeners on this container,
            or an empty array if no such listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^Container this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list for a specific
   property. The specified property may be user-defined, or one of the
   following defaults:

      this Container's font (\"font\")
      this Container's background color (\"background\")
      this Container's foreground color (\"foreground\")
      this Container's focusability (\"focusable\")
      this Container's focus traversal keys enabled state
          (\"focusTraversalKeysEnabled\")
      this Container's Set of FORWARD_TRAVERSAL_KEYS
          (\"forwardFocusTraversalKeys\")
      this Container's Set of BACKWARD_TRAVERSAL_KEYS
          (\"backwardFocusTraversalKeys\")
      this Container's Set of UP_CYCLE_TRAVERSAL_KEYS
          (\"upCycleFocusTraversalKeys\")
      this Container's Set of DOWN_CYCLE_TRAVERSAL_KEYS
          (\"downCycleFocusTraversalKeys\")
      this Container's focus traversal policy (\"focusTraversalPolicy\")

      this Container's focus-cycle-root state (\"focusCycleRoot\")
      this Container's focus-traversal-policy-provider state(\"focusTraversalPolicyProvider\")
      this Container's focus-traversal-policy-provider state(\"focusTraversalPolicyProvider\")

   Note that if this Container is inheriting a bound property, then no
   event will be fired in response to a change in the inherited property.

   If listener is null, no exception is thrown and no action is performed.

  property-name - one of the property names listed above - `java.lang.String`
  listener - the PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([^Container this ^java.lang.String property-name ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener property-name listener)))
  ([^Container this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn minimum-size
  "Deprecated. As of JDK version 1.1,
   replaced by getMinimumSize().

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^Container this]
    (-> this (.minimumSize))))

(defn remove-all
  "Removes all the components from this container.
   This method also notifies the layout manager to remove the
   components from this container's layout via the
   removeLayoutComponent method.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy. If the container has already been
   displayed, the hierarchy must be validated thereafter in order to
   reflect the changes."
  ([^Container this]
    (-> this (.removeAll))))

(defn focus-cycle-root?
  "Returns whether the specified Container is the focus cycle root of this
   Container's focus traversal cycle. Each focus traversal cycle has only
   a single focus cycle root and each Container which is not a focus cycle
   root belongs to only a single focus traversal cycle. Containers which
   are focus cycle roots belong to two cycles: one rooted at the Container
   itself, and one rooted at the Container's nearest focus-cycle-root
   ancestor. This method will return true for both such
   Containers in this case.

  container - the Container to be tested - `java.awt.Container`

  returns: true if the specified Container is a focus-cycle-
           root of this Container; false otherwise - `boolean`"
  (^Boolean [^Container this ^java.awt.Container container]
    (-> this (.isFocusCycleRoot container)))
  (^Boolean [^Container this]
    (-> this (.isFocusCycleRoot))))

(defn set-focus-traversal-policy-provider
  "Sets whether this container will be used to provide focus
   traversal policy. Container with this property as
   true will be used to acquire focus traversal policy
   instead of closest focus cycle root ancestor.

  provider - indicates whether this container will be used to provide focus traversal policy - `boolean`"
  ([^Container this ^Boolean provider]
    (-> this (.setFocusTraversalPolicyProvider provider))))

(defn get-preferred-size
  "Returns the preferred size of this container.  If the preferred size has
   not been set explicitly by Component.setPreferredSize(Dimension)
   and this Container has a non-null LayoutManager,
   then LayoutManager.preferredLayoutSize(Container)
   is used to calculate the preferred size.

   Note: some implementations may cache the value returned from the
   LayoutManager.  Implementations that cache need not invoke
   preferredLayoutSize on the LayoutManager every time
   this method is invoked, rather the LayoutManager will only
   be queried after the Container becomes invalid.

  returns: an instance of Dimension that represents
                  the preferred size of this container. - `java.awt.Dimension`"
  (^java.awt.Dimension [^Container this]
    (-> this (.getPreferredSize))))

(defn find-component-at
  "Locates the visible child component that contains the specified
   position.  The top-most child component is returned in the case
   where there is overlap in the components.  If the containing child
   component is a Container, this method will continue searching for
   the deepest nested child component.  Components which are not
   visible are ignored during the search.

   The findComponentAt method is different from getComponentAt in
   that getComponentAt only searches the Container's immediate
   children; if the containing component is a Container,
   findComponentAt will search that child to find a nested component.

  x - the x coordinate - `int`
  y - the y coordinate - `int`

  returns: null if the component does not contain the position.
   If there is no child component at the requested point and the
   point is within the bounds of the container the container itself
   is returned. - `java.awt.Component`"
  (^java.awt.Component [^Container this ^Integer x ^Integer y]
    (-> this (.findComponentAt x y)))
  (^java.awt.Component [^Container this ^java.awt.Point p]
    (-> this (.findComponentAt p))))

(defn locate
  "Deprecated. As of JDK version 1.1,
   replaced by getComponentAt(int, int).

  x - `int`
  y - `int`

  returns: `java.awt.Component`"
  (^java.awt.Component [^Container this ^Integer x ^Integer y]
    (-> this (.locate x y))))

(defn count-components
  "Deprecated. As of JDK version 1.1,
   replaced by getComponentCount().

  returns: `int`"
  (^Integer [^Container this]
    (-> this (.countComponents))))

