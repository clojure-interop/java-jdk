(ns jdk.awt.Window
  "A Window object is a top-level window with no borders and no
  menubar.
  The default layout for a window is BorderLayout.

  A window must have either a frame, dialog, or another window defined as its
  owner when it's constructed.

  In a multi-screen environment, you can create a Window
  on a different screen device by constructing the Window
  with Window(Window, GraphicsConfiguration).  The
  GraphicsConfiguration object is one of the
  GraphicsConfiguration objects of the target screen device.

  In a virtual device multi-screen environment in which the desktop
  area could span multiple physical screen devices, the bounds of all
  configurations are relative to the virtual device coordinate system.
  The origin of the virtual-coordinate system is at the upper left-hand
  corner of the primary physical screen.  Depending on the location of
  the primary screen in the virtual device, negative coordinates are
  possible, as shown in the following figure.



  In such an environment, when calling setLocation,
  you must pass a virtual coordinate to this method.  Similarly,
  calling getLocationOnScreen on a Window returns
  virtual device coordinates.  Call the getBounds method
  of a GraphicsConfiguration to find its origin in the virtual
  coordinate system.

  The following code sets the location of a Window
  at (10, 10) relative to the origin of the physical screen
  of the corresponding GraphicsConfiguration.  If the
  bounds of the GraphicsConfiguration is not taken
  into account, the Window location would be set
  at (10, 10) relative to the virtual-coordinate system and would appear
  on the primary physical screen, which might be different from the
  physical screen of the specified GraphicsConfiguration.



       Window w = new Window(Window owner, GraphicsConfiguration gc);
       Rectangle bounds = gc.getBounds();
       w.setLocation(10  bounds.x, 10  bounds.y);


  Note: the location and size of top-level windows (including
  Windows, Frames, and Dialogs)
  are under the control of the desktop's window management system.
  Calls to setLocation, setSize, and
  setBounds are requests (not directives) which are
  forwarded to the window management system.  Every effort will be
  made to honor such requests.  However, in some cases the window
  management system may ignore such requests, or modify the requested
  geometry in order to place and size the Window in a way
  that more closely matches the desktop settings.

  Due to the asynchronous nature of native event handling, the results
  returned by getBounds, getLocation,
  getLocationOnScreen, and getSize might not
  reflect the actual geometry of the Window on screen until the last
  request has been processed.  During the processing of subsequent
  requests these values might change accordingly while the window
  management system fulfills the requests.

  An application may set the size and location of an invisible
  Window arbitrarily, but the window management system may
  subsequently change its size and/or location when the
  Window is made visible. One or more ComponentEvents
  will be generated to indicate the new geometry.

  Windows are capable of generating the following WindowEvents:
  WindowOpened, WindowClosed, WindowGainedFocus, WindowLostFocus."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Window]))

(defn ->window
  "Constructor.

  Constructs a new, initially invisible window with the specified owner
   Window and a GraphicsConfiguration
   of a screen device. The Window will not be focusable unless
   its nearest owning Frame or Dialog
   is showing on the screen.

   If there is a security manager set, it is invoked to check
   AWTPermission(`showWindowWithoutWarningBanner`). If that
   check fails with a SecurityException then a warning banner
   is created.

  owner - the window to act as owner or null if this window has no owner - `java.awt.Window`
  gc - the GraphicsConfiguration of the target screen device; if gc is null, the system default GraphicsConfiguration is assumed - `java.awt.GraphicsConfiguration`

  throws: java.lang.IllegalArgumentException - if gc is not from a screen device"
  ([^java.awt.Window owner ^java.awt.GraphicsConfiguration gc]
    (new Window owner gc))
  ([^java.awt.Frame owner]
    (new Window owner)))

(defn *get-windows
  "Returns an array of all Windows, both owned and ownerless,
   created by this application.
   If called from an applet, the array includes only the Windows
   accessible by that applet.

   Warning: this method may return system created windows, such
   as a print dialog. Applications should not assume the existence of
   these dialogs, nor should an application assume anything about these
   dialogs such as component positions, LayoutManagers
   or serialization.

  returns: `java.awt.Window[]`"
  ([]
    (Window/getWindows )))

(defn *get-ownerless-windows
  "Returns an array of all Windows created by this application
   that have no owner. They include Frames and ownerless
   Dialogs and Windows.
   If called from an applet, the array includes only the Windows
   accessible by that applet.

   Warning: this method may return system created windows, such
   as a print dialog. Applications should not assume the existence of
   these dialogs, nor should an application assume anything about these
   dialogs such as component positions, LayoutManagers
   or serialization.

  returns: `java.awt.Window[]`"
  ([]
    (Window/getOwnerlessWindows )))

(defn opaque?
  "Indicates if the window is currently opaque.

   The method returns false if the background color of the window
   is not null and the alpha component of the color is less than
   1.0f. The method returns true otherwise.

  returns: true if the window is opaque, false otherwise - `boolean`"
  ([^java.awt.Window this]
    (-> this (.isOpaque))))

(defn active?
  "Returns whether this Window is active. Only a Frame or a Dialog may be
   active. The native windowing system may denote the active Window or its
   children with special decorations, such as a highlighted title bar. The
   active Window is always either the focused Window, or the first Frame or
   Dialog that is an owner of the focused Window.

  returns: whether this is the active Window. - `boolean`"
  ([^java.awt.Window this]
    (-> this (.isActive))))

(defn get-buffer-strategy
  "Returns the BufferStrategy used by this component.  This
   method will return null if a BufferStrategy has not yet
   been created or has been disposed.

  returns: the buffer strategy used by this component - `java.awt.image.BufferStrategy`"
  ([^java.awt.Window this]
    (-> this (.getBufferStrategy))))

(defn remove-window-listener
  "Removes the specified window listener so that it no longer
   receives window events from this window.
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the window listener - `java.awt.event.WindowListener`"
  ([^java.awt.Window this ^java.awt.event.WindowListener l]
    (-> this (.removeWindowListener l))))

(defn set-auto-request-focus
  "Sets whether this window should receive focus on
   subsequently being shown (with a call to setVisible(true)),
   or being moved to the front (with a call to toFront()).

   Note that setVisible(true) may be called indirectly
   (e.g. when showing an owner of the window makes the window to be shown).
   toFront() may also be called indirectly (e.g. when
   setVisible(true) is called on already visible window).
   In all such cases this property takes effect as well.

   The value of the property is not inherited by owned windows.

  auto-request-focus - whether this window should be focused on subsequently being shown or being moved to the front - `boolean`"
  ([^java.awt.Window this ^Boolean auto-request-focus]
    (-> this (.setAutoRequestFocus auto-request-focus))))

(defn set-location
  "Moves this component to a new location. The top-left corner of
   the new location is specified by the x and y
   parameters in the coordinate space of this component's parent.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

   The method changes the geometry-related data. Therefore,
   the native windowing system may ignore such requests, or it may modify
   the requested data, so that the Window object is placed and sized
   in a way that corresponds closely to the desktop settings.

  x - the x-coordinate of the new location's top-left corner in the parent's coordinate space - `int`
  y - the y-coordinate of the new location's top-left corner in the parent's coordinate space - `int`"
  ([^java.awt.Window this ^Integer x ^Integer y]
    (-> this (.setLocation x y)))
  ([^java.awt.Window this ^java.awt.Point p]
    (-> this (.setLocation p))))

(defn hide
  "Deprecated. As of JDK version 1.5, replaced by
   setVisible(boolean).

  returns: `java.lang.  void`"
  ([^java.awt.Window this]
    (-> this (.hide))))

(defn set-icon-images
  "Sets the sequence of images to be displayed as the icon
   for this window. Subsequent calls to getIconImages will
   always return a copy of the icons list.

   Depending on the platform capabilities one or several images
   of different dimensions will be used as the window's icon.

   The icons list is scanned for the images of most
   appropriate dimensions from the beginning. If the list contains
   several images of the same size, the first will be used.

   Ownerless windows with no icon specified use platfrom-default icon.
   The icon of an owned window may be inherited from the owner
   unless explicitly overridden.
   Setting the icon to null or empty list restores
   the default behavior.

   Note : Native windowing systems may use different images of differing
   dimensions to represent a window, depending on the context (e.g.
   window decoration, window list, taskbar, etc.). They could also use
   just a single image for all contexts or no image at all.

  icons - the list of icon images to be displayed. - `java.awt.Image>`"
  ([^java.awt.Window this ^java.awt.Image> icons]
    (-> this (.setIconImages icons))))

(defn auto-request-focus?
  "Returns whether this window should receive focus on subsequently being shown
   (with a call to setVisible(true)), or being moved to the front
   (with a call to toFront()).

   By default, the window has autoRequestFocus value of true.

  returns: autoRequestFocus value - `boolean`"
  ([^java.awt.Window this]
    (-> this (.isAutoRequestFocus))))

(defn get-type
  "Returns the type of the window.

  returns: `java.awt.Window.Type`"
  ([^java.awt.Window this]
    (-> this (.getType))))

(defn set-location-relative-to
  "Sets the location of the window relative to the specified
   component according to the following scenarios.

   The target screen mentioned below is a screen to which
   the window should be placed after the setLocationRelativeTo
   method is called.

   If the component is null, or the GraphicsConfiguration associated with this component is
   null, the window is placed in the center of the
   screen. The center point can be obtained with the GraphicsEnvironment.getCenterPoint method.
   If the component is not null, but it is not
   currently showing, the window is placed in the center of
   the target screen defined by the GraphicsConfiguration associated with this component.
   If the component is not null and is shown on
   the screen, then the window is located in such a way that
   the center of the window coincides with the center of the
   component.


   If the screens configuration does not allow the window to
   be moved from one screen to another, then the window is
   only placed at the location determined according to the
   above conditions and its GraphicsConfiguration is
   not changed.

   Note: If the lower edge of the window is out of the screen,
   then the window is placed to the side of the Component
   that is closest to the center of the screen. So if the
   component is on the right part of the screen, the window
   is placed to its left, and vice versa.

   If after the window location has been calculated, the upper,
   left, or right edge of the window is out of the screen,
   then the window is located in such a way that the upper,
   left, or right edge of the window coincides with the
   corresponding edge of the screen. If both left and right
   edges of the window are out of the screen, the window is
   placed at the left side of the screen. The similar placement
   will occur if both top and bottom edges are out of the screen.
   In that case, the window is placed at the top side of the screen.

   The method changes the geometry-related data. Therefore,
   the native windowing system may ignore such requests, or it may modify
   the requested data, so that the Window object is placed and sized
   in a way that corresponds closely to the desktop settings.

  c - the component in relation to which the window's location is determined - `java.awt.Component`"
  ([^java.awt.Window this ^java.awt.Component c]
    (-> this (.setLocationRelativeTo c))))

(defn remove-window-state-listener
  "Removes the specified window state listener so that it no
   longer receives window events from this window.  If
   l is null, no exception is thrown and
   no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the window state listener - `java.awt.event.WindowStateListener`"
  ([^java.awt.Window this ^java.awt.event.WindowStateListener l]
    (-> this (.removeWindowStateListener l))))

(defn pack
  "Causes this Window to be sized to fit the preferred size
   and layouts of its subcomponents. The resulting width and
   height of the window are automatically enlarged if either
   of dimensions is less than the minimum size as specified
   by the previous call to the setMinimumSize method.

   If the window and/or its owner are not displayable yet,
   both of them are made displayable before calculating
   the preferred size. The Window is validated after its
   size is being calculated."
  ([^java.awt.Window this]
    (-> this (.pack))))

(defn get-focus-traversal-keys
  "Gets a focus traversal key for this Window. (See setFocusTraversalKeys for a full description of each key.)

   If the traversal key has not been explicitly set for this Window,
   then this Window's parent's traversal key is returned. If the
   traversal key has not been explicitly set for any of this Window's
   ancestors, then the current KeyboardFocusManager's default traversal key
   is returned.

  id - one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS - `int`

  returns: the AWTKeyStroke for the specified key - `java.util.Set<java.awt.AWTKeyStroke>`

  throws: java.lang.IllegalArgumentException - if id is not one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS"
  ([^java.awt.Window this ^Integer id]
    (-> this (.getFocusTraversalKeys id))))

(defn get-most-recent-focus-owner
  "Returns the child Component of this Window that will receive the focus
   when this Window is focused. If this Window is currently focused, this
   method returns the same Component as getFocusOwner(). If
   this Window is not focused, then the child Component that most recently
   requested focus will be returned. If no child Component has ever
   requested focus, and this is a focusable Window, then this Window's
   initial focusable Component is returned. If no child Component has ever
   requested focus, and this is a non-focusable Window, null is returned.

  returns: the child Component that will receive focus when this Window is
           focused - `java.awt.Component`"
  ([^java.awt.Window this]
    (-> this (.getMostRecentFocusOwner))))

(defn set-type
  "Sets the type of the window.

   This method can only be called while the window is not displayable.

  type - `java.awt.Window.Type`

  throws: java.awt.IllegalComponentStateException - if the window is displayable."
  ([^java.awt.Window this ^java.awt.Window.Type type]
    (-> this (.setType type))))

(defn set-focus-cycle-root
  "Does nothing because Windows must always be roots of a focus traversal
   cycle. The passed-in value is ignored.

  focus-cycle-root - this value is ignored - `boolean`"
  ([^java.awt.Window this ^Boolean focus-cycle-root]
    (-> this (.setFocusCycleRoot focus-cycle-root))))

(defn set-shape
  "Sets the shape of the window.

   Setting a shape cuts off some parts of the window. Only the parts that
   belong to the given Shape remain visible and clickable. If
   the shape argument is null, this method restores the default
   shape, making the window rectangular on most platforms.

   The following conditions must be met to set a non-null shape:

   The PERPIXEL_TRANSPARENT translucency must be supported by the
   underlying system
   The window must be undecorated (see Frame.setUndecorated(boolean)
   and Dialog.setUndecorated(boolean))
   The window must not be in full-screen mode (see GraphicsDevice.setFullScreenWindow(Window))


   If the requested shape is not null, and any of the above
   conditions are not met, the shape of this window will not change,
   and either the UnsupportedOperationException or IllegalComponentStateException will be thrown.

   The translucency levels of individual pixels may also be effected by the
   alpha component of their color (see setBackground(Color)) and the
   opacity value (see setOpacity(float)). See GraphicsDevice.WindowTranslucency for more details.

  shape - the shape to set to the window - `java.awt.Shape`

  throws: java.awt.IllegalComponentStateException - if the shape is not null and the window is in full-screen mode"
  ([^java.awt.Window this ^java.awt.Shape shape]
    (-> this (.setShape shape))))

(defn post-event
  "Deprecated. As of JDK version 1.1
   replaced by dispatchEvent(AWTEvent).

  e - `java.awt.Event`

  returns: `java.lang.  boolean`"
  ([^java.awt.Window this ^java.awt.Event e]
    (-> this (.postEvent e))))

(defn set-opacity
  "Sets the opacity of the window.

   The opacity value is in the range [0..1]. Note that setting the opacity
   level of 0 may or may not disable the mouse event handling on this
   window. This is a platform-dependent behavior.

   The following conditions must be met in order to set the opacity value
   less than 1.0f:

   The TRANSLUCENT
   translucency must be supported by the underlying system
   The window must be undecorated (see Frame.setUndecorated(boolean)
   and Dialog.setUndecorated(boolean))
   The window must not be in full-screen mode (see GraphicsDevice.setFullScreenWindow(Window))


   If the requested opacity value is less than 1.0f, and any of the
   above conditions are not met, the window opacity will not change,
   and the IllegalComponentStateException will be thrown.

   The translucency levels of individual pixels may also be effected by the
   alpha component of their color (see setBackground(Color)) and the
   current shape of this window (see setShape(Shape)).

  opacity - the opacity level to set to the window - `float`

  throws: java.lang.IllegalArgumentException - if the opacity is out of the range [0..1]"
  ([^java.awt.Window this ^Float opacity]
    (-> this (.setOpacity opacity))))

(defn dispose
  "Releases all of the native screen resources used by this
   Window, its subcomponents, and all of its owned
   children. That is, the resources for these Components
   will be destroyed, any memory they consume will be returned to the
   OS, and they will be marked as undisplayable.

   The Window and its subcomponents can be made displayable
   again by rebuilding the native resources with a subsequent call to
   pack or show. The states of the recreated
   Window and its subcomponents will be identical to the
   states of these objects at the point where the Window
   was disposed (not accounting for additional modifications between
   those actions).

   Note: When the last displayable window
   within the Java virtual machine (VM) is disposed of, the VM may
   terminate.  See
   AWT Threading Issues for more information."
  ([^java.awt.Window this]
    (-> this (.dispose))))

(defn get-opacity
  "Returns the opacity of the window.

  returns: the opacity of the window - `float`"
  ([^java.awt.Window this]
    (-> this (.getOpacity))))

(defn set-focusable-window-state
  "Sets whether this Window can become the focused Window if it meets
   the other requirements outlined in isFocusableWindow. If
   this Window's focusable Window state is set to false, then
   isFocusableWindow will return false. If this
   Window's focusable Window state is set to true, then
   isFocusableWindow may return true or
   false depending upon the other requirements which must be
   met in order for a Window to be focusable.

   Setting a Window's focusability state to false is the
   standard mechanism for an application to identify to the AWT a Window
   which will be used as a floating palette or toolbar, and thus should be
   a non-focusable Window.

   Setting the focusability state on a visible Window
   can have a delayed effect on some platforms  the actual
   change may happen only when the Window becomes
   hidden and then visible again.  To ensure consistent behavior
   across platforms, set the Window's focusable state
   when the Window is invisible and then show it.

  focusable-window-state - whether this Window can be the focused Window - `boolean`"
  ([^java.awt.Window this ^Boolean focusable-window-state]
    (-> this (.setFocusableWindowState focusable-window-state))))

(defn get-locale
  "Gets the Locale object that is associated
   with this window, if the locale has been set.
   If no locale has been set, then the default locale
   is returned.

  returns: the locale that is set for this window. - `java.util.Locale`"
  ([^java.awt.Window this]
    (-> this (.getLocale))))

(defn get-focus-owner
  "Returns the child Component of this Window that has focus if this Window
   is focused; returns null otherwise.

  returns: the child Component with focus, or null if this Window is not
           focused - `java.awt.Component`"
  ([^java.awt.Window this]
    (-> this (.getFocusOwner))))

(defn set-always-on-top
  "Sets whether this window should always be above other windows.  If
   there are multiple always-on-top windows, their relative order is
   unspecified and platform dependent.

   If some other window is already always-on-top then the
   relative order between these windows is unspecified (depends on
   platform).  No window can be brought to be over the always-on-top
   window except maybe another always-on-top window.

   All windows owned by an always-on-top window inherit this state and
   automatically become always-on-top.  If a window ceases to be
   always-on-top, the windows that it owns will no longer be
   always-on-top.  When an always-on-top window is sent toBack, its always-on-top state is set to false.

    When this method is called on a window with a value of
   true, and the window is visible and the platform
   supports always-on-top for this window, the window is immediately
   brought forward, `sticking` it in the top-most position. If the
   window isn`t currently visible, this method sets the always-on-top
   state to true but does not bring the window forward.
   When the window is later shown, it will be always-on-top.

    When this method is called on a window with a value of
   false the always-on-top state is set to normal. It may also
   cause an unspecified, platform-dependent change in the z-order of
   top-level windows, but other always-on-top windows will remain in
   top-most position. Calling this method with a value of false
   on a window that has a normal state has no effect.

   Note: some platforms might not support always-on-top
   windows.  To detect if always-on-top windows are supported by the
   current platform, use Toolkit.isAlwaysOnTopSupported() and
   isAlwaysOnTopSupported().  If always-on-top mode
   isn't supported for this window or this window's toolkit does not
   support always-on-top windows, calling this method has no effect.

   If a SecurityManager is installed, the calling thread must be
   granted the AWTPermission `setWindowAlwaysOnTop` in
   order to set the value of this property. If this
   permission is not granted, this method will throw a
   SecurityException, and the current value of the property will
   be left unchanged.

  always-on-top - true if the window should always be above other windows - `boolean`

  throws: java.lang.SecurityException - if the calling thread does not have permission to set the value of always-on-top property"
  ([^java.awt.Window this ^Boolean always-on-top]
    (-> this (.setAlwaysOnTop always-on-top))))

(defn validate-root?
  "Indicates if this container is a validate root.

   Window objects are the validate roots, and, therefore, they
   override this method to return true.

  returns: true - `boolean`"
  ([^java.awt.Window this]
    (-> this (.isValidateRoot))))

(defn add-window-listener
  "Adds the specified window listener to receive window events from
   this window.
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the window listener - `java.awt.event.WindowListener`"
  ([^java.awt.Window this ^java.awt.event.WindowListener l]
    (-> this (.addWindowListener l))))

(defn set-background
  "Sets the background color of this window.

   If the windowing system supports the PERPIXEL_TRANSLUCENT
   translucency, the alpha component of the given background color
   may effect the mode of operation for this window: it indicates whether
   this window must be opaque (alpha equals 1.0f) or per-pixel translucent
   (alpha is less than 1.0f). If the given background color is
   null, the window is considered completely opaque.

   All the following conditions must be met to enable the per-pixel
   transparency mode for this window:

   The PERPIXEL_TRANSLUCENT translucency must be supported by the graphics
   device where this window is located
   The window must be undecorated (see Frame.setUndecorated(boolean)
   and Dialog.setUndecorated(boolean))
   The window must not be in full-screen mode (see GraphicsDevice.setFullScreenWindow(Window))


   If the alpha component of the requested background color is less than
   1.0f, and any of the above conditions are not met, the background
   color of this window will not change, the alpha component of the given
   background color will not affect the mode of operation for this window,
   and either the UnsupportedOperationException or IllegalComponentStateException will be thrown.

   When the window is per-pixel translucent, the drawing sub-system
   respects the alpha value of each individual pixel. If a pixel gets
   painted with the alpha color component equal to zero, it becomes
   visually transparent. If the alpha of the pixel is equal to 1.0f, the
   pixel is fully opaque. Interim values of the alpha color component make
   the pixel semi-transparent. In this mode, the background of the window
   gets painted with the alpha value of the given background color. If the
   alpha value of the argument of this method is equal to 0, the
   background is not painted at all.

   The actual level of translucency of a given pixel also depends on window
   opacity (see setOpacity(float)), as well as the current shape of
   this window (see setShape(Shape)).

   Note that painting a pixel with the alpha value of 0 may or may
   not disable the mouse event handling on this pixel. This is a
   platform-dependent behavior. To make sure the mouse events do not get
   dispatched to a particular pixel, the pixel must be excluded from the
   shape of the window.

   Enabling the per-pixel translucency mode may change the graphics
   configuration of this window due to the native platform requirements.

  bg-color - the color to become this window's background color. - `java.awt.Color`

  throws: java.awt.IllegalComponentStateException - if the alpha value of the given background color is less than 1.0f and the window is in full-screen mode"
  ([^java.awt.Window this ^java.awt.Color bg-color]
    (-> this (.setBackground bg-color))))

(defn get-window-listeners
  "Returns an array of all the window listeners
   registered on this window.

  returns: all of this window's WindowListeners
           or an empty array if no window
           listeners are currently registered - `java.awt.event.WindowListener[]`"
  ([^java.awt.Window this]
    (-> this (.getWindowListeners))))

(defn reshape
  "Deprecated. As of JDK version 1.1,
   replaced by setBounds(int, int, int, int).

  x - `int`
  y - `int`
  width - `int`
  height - `int`

  returns: `java.lang.  void`"
  ([^java.awt.Window this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.reshape x y width height))))

(defn get-owned-windows
  "Return an array containing all the windows this
   window currently owns.

  returns: `java.awt.Window[]`"
  ([^java.awt.Window this]
    (-> this (.getOwnedWindows))))

(defn get-focusable-window-state?
  "Returns whether this Window can become the focused Window if it meets
   the other requirements outlined in isFocusableWindow. If
   this method returns false, then
   isFocusableWindow will return false as well.
   If this method returns true, then
   isFocusableWindow may return true or
   false depending upon the other requirements which must be
   met in order for a Window to be focusable.

   By default, all Windows have a focusable Window state of
   true.

  returns: whether this Window can be the focused Window - `boolean`"
  ([^java.awt.Window this]
    (-> this (.getFocusableWindowState))))

(defn add-notify
  "Makes this Window displayable by creating the connection to its
   native screen resource.
   This method is called internally by the toolkit and should
   not be called directly by programs."
  ([^java.awt.Window this]
    (-> this (.addNotify))))

(defn get-window-focus-listeners
  "Returns an array of all the window focus listeners
   registered on this window.

  returns: all of this window's WindowFocusListeners
           or an empty array if no window focus
           listeners are currently registered - `java.awt.event.WindowFocusListener[]`"
  ([^java.awt.Window this]
    (-> this (.getWindowFocusListeners))))

(defn show
  "Deprecated. As of JDK version 1.5, replaced by
   setVisible(boolean).

  returns: `java.lang.  void`"
  ([^java.awt.Window this]
    (-> this (.show))))

(defn apply-resource-bundle
  "Deprecated. As of J2SE 1.4, replaced by
   Component.applyComponentOrientation.

  rb - `java.util.ResourceBundle`

  returns: `java.lang.  void`"
  ([^java.awt.Window this ^java.util.ResourceBundle rb]
    (-> this (.applyResourceBundle rb))))

(defn add-window-focus-listener
  "Adds the specified window focus listener to receive window events
   from this window.
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the window focus listener - `java.awt.event.WindowFocusListener`"
  ([^java.awt.Window this ^java.awt.event.WindowFocusListener l]
    (-> this (.addWindowFocusListener l))))

(defn remove-notify
  "Makes this Container undisplayable by removing its connection
   to its native screen resource.  Making a container undisplayable
   will cause all of its children to be made undisplayable.
   This method is called by the toolkit internally and should
   not be called directly by programs."
  ([^java.awt.Window this]
    (-> this (.removeNotify))))

(defn get-owner
  "Returns the owner of this window.

  returns: `java.awt.Window`"
  ([^java.awt.Window this]
    (-> this (.getOwner))))

(defn focusable-window?
  "Returns whether this Window can become the focused Window, that is,
   whether this Window or any of its subcomponents can become the focus
   owner. For a Frame or Dialog to be focusable, its focusable Window state
   must be set to true. For a Window which is not a Frame or
   Dialog to be focusable, its focusable Window state must be set to
   true, its nearest owning Frame or Dialog must be
   showing on the screen, and it must contain at least one Component in
   its focus traversal cycle. If any of these conditions is not met, then
   neither this Window nor any of its subcomponents can become the focus
   owner.

  returns: true if this Window can be the focused Window;
           false otherwise - `boolean`"
  ([^java.awt.Window this]
    (-> this (.isFocusableWindow))))

(defn always-on-top?
  "Returns whether this window is an always-on-top window.

  returns: true, if the window is in always-on-top state,
           false otherwise - `boolean`"
  ([^java.awt.Window this]
    (-> this (.isAlwaysOnTop))))

(defn get-icon-images
  "Returns the sequence of images to be displayed as the icon for this window.

   This method returns a copy of the internally stored list, so all operations
   on the returned object will not affect the window's behavior.

  returns: the copy of icon images' list for this window, or
              empty list if this window doesn't have icon images. - `java.util.List<java.awt.Image>`"
  ([^java.awt.Window this]
    (-> this (.getIconImages))))

(defn set-location-by-platform
  "Sets whether this Window should appear at the default location for the
   native windowing system or at the current location (returned by
   getLocation) the next time the Window is made visible.
   This behavior resembles a native window shown without programmatically
   setting its location.  Most windowing systems cascade windows if their
   locations are not explicitly set. The actual location is determined once the
   window is shown on the screen.

   This behavior can also be enabled by setting the System Property
   `java.awt.Window.locationByPlatform` to `true`, though calls to this method
   take precedence.

   Calls to setVisible, setLocation and
   setBounds after calling setLocationByPlatform clear
   this property of the Window.

   For example, after the following code is executed:


   setLocationByPlatform(true);
   setVisible(true);
   boolean flag = isLocationByPlatform();
   The window will be shown at platform's default location and
   flag will be false.

   In the following sample:


   setLocationByPlatform(true);
   setLocation(10, 10);
   boolean flag = isLocationByPlatform();
   setVisible(true);
   The window will be shown at (10, 10) and flag will be
   false.

  location-by-platform - true if this Window should appear at the default location, false if at the current location - `boolean`

  throws: java.awt.IllegalComponentStateException - if the window is showing on screen and locationByPlatform is true."
  ([^java.awt.Window this ^Boolean location-by-platform]
    (-> this (.setLocationByPlatform location-by-platform))))

(defn to-back
  "If this Window is visible, sends this Window to the back and may cause
   it to lose focus or activation if it is the focused or active Window.

   Places this Window at the bottom of the stacking order and shows it
   behind any other Windows in this VM. No action will take place is this
   Window is not visible. Some platforms do not allow Windows which are
   owned by other Windows to appear below their owners. Every attempt will
   be made to move this Window as low as possible in the stacking order;
   however, developers should not assume that this method will move this
   Window below all other windows in every situation.

   Because of variations in native windowing systems, no guarantees about
   changes to the focused and active Windows can be made. Developers must
   never assume that this Window is no longer the focused or active Window
   until this Window receives a WINDOW_LOST_FOCUS or WINDOW_DEACTIVATED
   event. On platforms where the top-most window is the focused window,
   this method will probably cause this Window to lose focus. In
   that case, the next highest, focusable Window in this VM will receive
   focus. On platforms where the stacking order does not typically affect
   the focused window, this method will probably leave the focused
   and active Windows unchanged."
  ([^java.awt.Window this]
    (-> this (.toBack))))

(defn paint
  "Paints the container. This forwards the paint to any lightweight
   components that are children of this container. If this method is
   reimplemented, super.paint(g) should be called so that lightweight
   components are properly rendered. If a child component is entirely
   clipped by the current clipping setting in g, paint() will not be
   forwarded to that child.

  g - the specified Graphics window - `java.awt.Graphics`"
  ([^java.awt.Window this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this Window.
   For windows, the AccessibleContext takes the form of an
   AccessibleAWTWindow.
   A new AccessibleAWTWindow instance is created if necessary.

  returns: an AccessibleAWTWindow that serves as the
           AccessibleContext of this Window - `javax.accessibility.AccessibleContext`"
  ([^java.awt.Window this]
    (-> this (.getAccessibleContext))))

(defn get-window-state-listeners
  "Returns an array of all the window state listeners
   registered on this window.

  returns: all of this window's WindowStateListeners
           or an empty array if no window state
           listeners are currently registered - `java.awt.event.WindowStateListener[]`"
  ([^java.awt.Window this]
    (-> this (.getWindowStateListeners))))

(defn set-minimum-size
  "Sets the minimum size of this window to a constant
   value.  Subsequent calls to getMinimumSize
   will always return this value. If current window's
   size is less than minimumSize the size of the
   window is automatically enlarged to honor the minimum size.

   If the setSize or setBounds methods
   are called afterwards with a width or height less than
   that was specified by the setMinimumSize method
   the window is automatically enlarged to meet
   the minimumSize value. The minimumSize
   value also affects the behaviour of the pack method.

   The default behavior is restored by setting the minimum size
   parameter to the null value.

   Resizing operation may be restricted if the user tries
   to resize window below the minimumSize value.
   This behaviour is platform-dependent.

  minimum-size - the new minimum size of this window - `java.awt.Dimension`"
  ([^java.awt.Window this ^java.awt.Dimension minimum-size]
    (-> this (.setMinimumSize minimum-size))))

(defn set-visible
  "Shows or hides this Window depending on the value of parameter
   b.

   If the method shows the window then the window is also made
   focused under the following conditions:

    The Window meets the requirements outlined in the
        isFocusableWindow() method.
    The Window's autoRequestFocus property is of the true value.
    Native windowing system allows the Window to get focused.

   There is an exception for the second condition (the value of the
   autoRequestFocus property). The property is not taken into account if the
   window is a modal dialog, which blocks the currently focused window.

   Developers must never assume that the window is the focused or active window
   until it receives a WINDOW_GAINED_FOCUS or WINDOW_ACTIVATED event.

  b - if true, makes the Window visible, otherwise hides the Window. If the Window and/or its owner are not yet displayable, both are made displayable. The Window will be validated prior to being made visible. If the Window is already visible, this will bring the Window to the front. If false, hides this Window, its subcomponents, and all of its owned children. The Window and its subcomponents can be made visible again with a call to #setVisible(true). - `boolean`"
  ([^java.awt.Window this ^Boolean b]
    (-> this (.setVisible b))))

(defn get-shape
  "Returns the shape of the window.

   The value returned by this method may not be the same as
   previously set with setShape(shape), but it is guaranteed
   to represent the same shape.

  returns: the shape of the window or null if no
       shape is specified for the window - `java.awt.Shape`"
  ([^java.awt.Window this]
    (-> this (.getShape))))

(defn get-modal-exclusion-type
  "Returns the modal exclusion type of this window.

  returns: the modal exclusion type of this window - `java.awt.Dialog.ModalExclusionType`"
  ([^java.awt.Window this]
    (-> this (.getModalExclusionType))))

(defn get-input-context
  "Gets the input context for this window. A window always has an input context,
   which is shared by subcomponents unless they create and set their own.

  returns: the input context used by this component;
            null if no context can be determined - `java.awt.im.InputContext`"
  ([^java.awt.Window this]
    (-> this (.getInputContext))))

(defn set-size
  "Resizes this component so that it has width width
   and height height.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

   The width and height values
   are automatically enlarged if either is less than
   the minimum size as specified by previous call to
   setMinimumSize.

   The method changes the geometry-related data. Therefore,
   the native windowing system may ignore such requests, or it may modify
   the requested data, so that the Window object is placed and sized
   in a way that corresponds closely to the desktop settings.

  width - the new width of this component in pixels - `int`
  height - the new height of this component in pixels - `int`"
  ([^java.awt.Window this ^Integer width ^Integer height]
    (-> this (.setSize width height)))
  ([^java.awt.Window this ^java.awt.Dimension d]
    (-> this (.setSize d))))

(defn get-focus-cycle-root-ancestor
  "Always returns null because Windows have no ancestors; they
   represent the top of the Component hierarchy.

  returns: null - `java.awt.Container`"
  ([^java.awt.Window this]
    (-> this (.getFocusCycleRootAncestor))))

(defn set-icon-image
  "Sets the image to be displayed as the icon for this window.

   This method can be used instead of setIconImages()
   to specify a single image as a window's icon.

   The following statement:


       setIconImage(image);
   is equivalent to:


       ArrayList<Image> imageList = new ArrayList<Image>();
       imageList.add(image);
       setIconImages(imageList);

   Note : Native windowing systems may use different images of differing
   dimensions to represent a window, depending on the context (e.g.
   window decoration, window list, taskbar, etc.). They could also use
   just a single image for all contexts or no image at all.

  image - the icon image to be displayed. - `java.awt.Image`"
  ([^java.awt.Window this ^java.awt.Image image]
    (-> this (.setIconImage image))))

(defn set-modal-exclusion-type
  "Specifies the modal exclusion type for this window. If a window is modal
   excluded, it is not blocked by some modal dialogs. See Dialog.ModalExclusionType for
   possible modal exclusion types.

   If the given type is not supported, NO_EXCLUDE is used.

   Note: changing the modal exclusion type for a visible window may have no
   effect until it is hidden and then shown again.

  exclusion-type - the modal exclusion type for this window; a null value is equivalent to NO_EXCLUDE - `java.awt.Dialog.ModalExclusionType`

  throws: java.lang.SecurityException - if the calling thread does not have permission to set the modal exclusion property to the window with the given exclusionType"
  ([^java.awt.Window this ^java.awt.Dialog.ModalExclusionType exclusion-type]
    (-> this (.setModalExclusionType exclusion-type))))

(defn set-bounds
  "Moves and resizes this component. The new location of the top-left
   corner is specified by x and y, and the
   new size is specified by width and height.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

   The width or height values
   are automatically enlarged if either is less than
   the minimum size as specified by previous call to
   setMinimumSize.

   The method changes the geometry-related data. Therefore,
   the native windowing system may ignore such requests, or it may modify
   the requested data, so that the Window object is placed and sized
   in a way that corresponds closely to the desktop settings.

  x - the new x-coordinate of this component - `int`
  y - the new y-coordinate of this component - `int`
  width - the new width of this component - `int`
  height - the new height of this component - `int`"
  ([^java.awt.Window this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.setBounds x y width height)))
  ([^java.awt.Window this ^java.awt.Rectangle r]
    (-> this (.setBounds r))))

(defn get-toolkit
  "Returns the toolkit of this frame.

  returns: the toolkit of this window. - `java.awt.Toolkit`"
  ([^java.awt.Window this]
    (-> this (.getToolkit))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this Window.
   FooListeners are registered using the
   addFooListener method.



   You can specify the listenerType argument
   with a class literal, such as
   FooListener.class.
   For example, you can query a
   Window w
   for its window listeners with the following code:



  WindowListener[] wls = (WindowListener[])(w.getListeners(WindowListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners on this window,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^java.awt.Window this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn always-on-top-supported?
  "Returns whether the always-on-top mode is supported for this
   window. Some platforms may not support always-on-top windows, some
   may support only some kinds of top-level windows; for example,
   a platform may not support always-on-top modal dialogs.

  returns: true, if the always-on-top mode is supported for
           this window and this window's toolkit supports always-on-top windows,
           false otherwise - `boolean`"
  ([^java.awt.Window this]
    (-> this (.isAlwaysOnTopSupported))))

(defn location-by-platform?
  "Returns true if this Window will appear at the default location
   for the native windowing system the next time this Window is made visible.
   This method always returns false if the Window is showing on the
   screen.

  returns: whether this Window will appear at the default location - `boolean`"
  ([^java.awt.Window this]
    (-> this (.isLocationByPlatform))))

(defn set-cursor
  "Set the cursor image to a specified cursor.

   The method may have no visual effect if the Java platform
   implementation and/or the native system do not support
   changing the mouse cursor shape.

  cursor - One of the constants defined by the Cursor class. If this parameter is null then the cursor for this window will be set to the type Cursor.DEFAULT_CURSOR. - `java.awt.Cursor`"
  ([^java.awt.Window this ^java.awt.Cursor cursor]
    (-> this (.setCursor cursor))))

(defn get-background
  "Gets the background color of this window.

   Note that the alpha component of the returned color indicates whether
   the window is in the non-opaque (per-pixel translucent) mode.

  returns: this component's background color - `java.awt.Color`"
  ([^java.awt.Window this]
    (-> this (.getBackground))))

(defn to-front
  "If this Window is visible, brings this Window to the front and may make
   it the focused Window.

   Places this Window at the top of the stacking order and shows it in
   front of any other Windows in this VM. No action will take place if this
   Window is not visible. Some platforms do not allow Windows which own
   other Windows to appear on top of those owned Windows. Some platforms
   may not permit this VM to place its Windows above windows of native
   applications, or Windows of other VMs. This permission may depend on
   whether a Window in this VM is already focused. Every attempt will be
   made to move this Window as high as possible in the stacking order;
   however, developers should not assume that this method will move this
   Window above all other windows in every situation.

   Developers must never assume that this Window is the focused or active
   Window until this Window receives a WINDOW_GAINED_FOCUS or WINDOW_ACTIVATED
   event. On platforms where the top-most window is the focused window, this
   method will probably focus this Window (if it is not already focused)
   under the following conditions:

    The window meets the requirements outlined in the
        isFocusableWindow() method.
    The window's property autoRequestFocus is of the
        true value.
    Native windowing system allows the window to get focused.

   On platforms where the stacking order does not typically affect the focused
   window, this method will probably leave the focused and active
   Windows unchanged.

   If this method causes this Window to be focused, and this Window is a
   Frame or a Dialog, it will also become activated. If this Window is
   focused, but it is not a Frame or a Dialog, then the first Frame or
   Dialog that is an owner of this Window will be activated.

   If this window is blocked by modal dialog, then the blocking dialog
   is brought to the front and remains above the blocked window."
  ([^java.awt.Window this]
    (-> this (.toFront))))

(defn remove-window-focus-listener
  "Removes the specified window focus listener so that it no longer
   receives window events from this window.
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the window focus listener - `java.awt.event.WindowFocusListener`"
  ([^java.awt.Window this ^java.awt.event.WindowFocusListener l]
    (-> this (.removeWindowFocusListener l))))

(defn create-buffer-strategy
  "Creates a new strategy for multi-buffering on this component with the
   required buffer capabilities.  This is useful, for example, if only
   accelerated memory or page flipping is desired (as specified by the
   buffer capabilities).

   Each time this method
   is called, the existing buffer strategy for this component is discarded.

  num-buffers - number of buffers to create, including the front buffer - `int`
  caps - the required capabilities for creating the buffer strategy; cannot be null - `java.awt.BufferCapabilities`

  throws: java.awt.AWTException - if the capabilities supplied could not be supported or met; this may happen, for example, if there is not enough accelerated memory currently available, or if page flipping is specified but not possible."
  ([^java.awt.Window this ^Integer num-buffers ^java.awt.BufferCapabilities caps]
    (-> this (.createBufferStrategy num-buffers caps)))
  ([^java.awt.Window this ^Integer num-buffers]
    (-> this (.createBufferStrategy num-buffers))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list for a specific
   property. The specified property may be user-defined, or one of the
   following:

      this Window's font (`font`)
      this Window's background color (`background`)
      this Window's foreground color (`foreground`)
      this Window's focusability (`focusable`)
      this Window's focus traversal keys enabled state
          (`focusTraversalKeysEnabled`)
      this Window's Set of FORWARD_TRAVERSAL_KEYS
          (`forwardFocusTraversalKeys`)
      this Window's Set of BACKWARD_TRAVERSAL_KEYS
          (`backwardFocusTraversalKeys`)
      this Window's Set of UP_CYCLE_TRAVERSAL_KEYS
          (`upCycleFocusTraversalKeys`)
      this Window's Set of DOWN_CYCLE_TRAVERSAL_KEYS
          (`downCycleFocusTraversalKeys`)
      this Window's focus traversal policy (`focusTraversalPolicy`)

      this Window's focusable Window state (`focusableWindowState`)

      this Window's always-on-top state(`alwaysOnTop`)

   Note that if this Window is inheriting a bound property, then no
   event will be fired in response to a change in the inherited property.

   If listener is null, no exception is thrown and no action is performed.

  property-name - one of the property names listed above - `java.lang.String`
  listener - the PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([^java.awt.Window this ^java.lang.String property-name ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener property-name listener)))
  ([^java.awt.Window this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn showing?
  "Checks if this Window is showing on screen.

  returns: true if the component is showing,
            false otherwise - `boolean`"
  ([^java.awt.Window this]
    (-> this (.isShowing))))

(defn get-warning-string
  "Gets the warning string that is displayed with this window.
   If this window is insecure, the warning string is displayed
   somewhere in the visible area of the window. A window is
   insecure if there is a security manager and the security
   manager denies
   AWTPermission(`showWindowWithoutWarningBanner`).

   If the window is secure, then getWarningString
   returns null. If the window is insecure, this
   method checks for the system property
   awt.appletWarning
   and returns the string value of that property.

  returns: the warning string for this window. - `java.lang.String`"
  ([^java.awt.Window this]
    (-> this (.getWarningString))))

(defn focus-cycle-root?
  "Always returns true because all Windows must be roots of a
   focus traversal cycle.

  returns: true - `boolean`"
  ([^java.awt.Window this]
    (-> this (.isFocusCycleRoot))))

(defn add-window-state-listener
  "Adds the specified window state listener to receive window
   events from this window.  If l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the window state listener - `java.awt.event.WindowStateListener`"
  ([^java.awt.Window this ^java.awt.event.WindowStateListener l]
    (-> this (.addWindowStateListener l))))

(defn focused?
  "Returns whether this Window is focused. If there exists a focus owner,
   the focused Window is the Window that is, or contains, that focus owner.
   If there is no focus owner, then no Window is focused.

   If the focused Window is a Frame or a Dialog it is also the active
   Window. Otherwise, the active Window is the first Frame or Dialog that
   is an owner of the focused Window.

  returns: whether this is the focused Window. - `boolean`"
  ([^java.awt.Window this]
    (-> this (.isFocused))))

