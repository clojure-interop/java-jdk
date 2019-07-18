(ns jdk.awt.Frame
  "A Frame is a top-level window with a title and a border.

  The size of the frame includes any area designated for the
  border.  The dimensions of the border area may be obtained
  using the getInsets method, however, since
  these dimensions are platform-dependent, a valid insets
  value cannot be obtained until the frame is made displayable
  by either calling pack or show.
  Since the border area is included in the overall size of the
  frame, the border effectively obscures a portion of the frame,
  constraining the area available for rendering and/or displaying
  subcomponents to the rectangle which has an upper-left corner
  location of (insets.left, insets.top), and has a size of
  width - (insets.left  insets.right) by
  height - (insets.top  insets.bottom).

  The default layout for a frame is BorderLayout.

  A frame may have its native decorations (i.e. Frame
  and Titlebar) turned off
  with setUndecorated. This can only be done while the frame
  is not displayable.

  In a multi-screen environment, you can create a Frame
  on a different screen device by constructing the Frame
  with Frame(GraphicsConfiguration) or
  Frame(String title, GraphicsConfiguration).  The
  GraphicsConfiguration object is one of the
  GraphicsConfiguration objects of the target screen
  device.

  In a virtual device multi-screen environment in which the desktop
  area could span multiple physical screen devices, the bounds of all
  configurations are relative to the virtual-coordinate system.  The
  origin of the virtual-coordinate system is at the upper left-hand
  corner of the primary physical screen.  Depending on the location
  of the primary screen in the virtual device, negative coordinates
  are possible, as shown in the following figure.



  In such an environment, when calling setLocation,
  you must pass a virtual coordinate to this method.  Similarly,
  calling getLocationOnScreen on a Frame
  returns virtual device coordinates.  Call the getBounds
  method of a GraphicsConfiguration to find its origin in
  the virtual coordinate system.

  The following code sets the
  location of the Frame at (10, 10) relative
  to the origin of the physical screen of the corresponding
  GraphicsConfiguration.  If the bounds of the
  GraphicsConfiguration is not taken into account, the
  Frame location would be set at (10, 10) relative to the
  virtual-coordinate system and would appear on the primary physical
  screen, which might be different from the physical screen of the
  specified GraphicsConfiguration.



       Frame f = new Frame(GraphicsConfiguration gc);
       Rectangle bounds = gc.getBounds();
       f.setLocation(10  bounds.x, 10  bounds.y);


  Frames are capable of generating the following types of
  WindowEvents:

  WINDOW_OPENED
  WINDOW_CLOSING:
      If the program doesn't
      explicitly hide or dispose the window while processing
      this event, the window close operation is canceled.
  WINDOW_CLOSED
  WINDOW_ICONIFIED
  WINDOW_DEICONIFIED
  WINDOW_ACTIVATED
  WINDOW_DEACTIVATED
  WINDOW_GAINED_FOCUS
  WINDOW_LOST_FOCUS
  WINDOW_STATE_CHANGED"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Frame]))

(defn ->frame
  "Constructor.

  Constructs a new, initially invisible Frame object
   with the specified title and a
   GraphicsConfiguration.

  title - the title to be displayed in the frame's border. A null value is treated as an empty string, ``. - `java.lang.String`
  gc - the GraphicsConfiguration of the target screen device. If gc is null, the system default GraphicsConfiguration is assumed. - `java.awt.GraphicsConfiguration`

  throws: java.lang.IllegalArgumentException - if gc is not from a screen device."
  (^Frame [^java.lang.String title ^java.awt.GraphicsConfiguration gc]
    (new Frame title gc))
  (^Frame [^java.awt.GraphicsConfiguration gc]
    (new Frame gc))
  (^Frame []
    (new Frame )))

(def *-default-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.DEFAULT_CURSOR.

  type: int"
  Frame/DEFAULT_CURSOR)

(def *-crosshair-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.CROSSHAIR_CURSOR.

  type: int"
  Frame/CROSSHAIR_CURSOR)

(def *-text-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.TEXT_CURSOR.

  type: int"
  Frame/TEXT_CURSOR)

(def *-wait-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.WAIT_CURSOR.

  type: int"
  Frame/WAIT_CURSOR)

(def *-sw-resize-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.SW_RESIZE_CURSOR.

  type: int"
  Frame/SW_RESIZE_CURSOR)

(def *-se-resize-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.SE_RESIZE_CURSOR.

  type: int"
  Frame/SE_RESIZE_CURSOR)

(def *-nw-resize-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.NW_RESIZE_CURSOR.

  type: int"
  Frame/NW_RESIZE_CURSOR)

(def *-ne-resize-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.NE_RESIZE_CURSOR.

  type: int"
  Frame/NE_RESIZE_CURSOR)

(def *-n-resize-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.N_RESIZE_CURSOR.

  type: int"
  Frame/N_RESIZE_CURSOR)

(def *-s-resize-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.S_RESIZE_CURSOR.

  type: int"
  Frame/S_RESIZE_CURSOR)

(def *-w-resize-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.W_RESIZE_CURSOR.

  type: int"
  Frame/W_RESIZE_CURSOR)

(def *-e-resize-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.E_RESIZE_CURSOR.

  type: int"
  Frame/E_RESIZE_CURSOR)

(def *-hand-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.HAND_CURSOR.

  type: int"
  Frame/HAND_CURSOR)

(def *-move-cursor
  "Static Constant.

  Deprecated. replaced by Cursor.MOVE_CURSOR.

  type: int"
  Frame/MOVE_CURSOR)

(def *-normal
  "Static Constant.

  Frame is in the `normal` state.  This symbolic constant names a
   frame state with all state bits cleared.

  type: int"
  Frame/NORMAL)

(def *-iconified
  "Static Constant.

  This state bit indicates that frame is iconified.

  type: int"
  Frame/ICONIFIED)

(def *-maximized-horiz
  "Static Constant.

  This state bit indicates that frame is maximized in the
   horizontal direction.

  type: int"
  Frame/MAXIMIZED_HORIZ)

(def *-maximized-vert
  "Static Constant.

  This state bit indicates that frame is maximized in the
   vertical direction.

  type: int"
  Frame/MAXIMIZED_VERT)

(def *-maximized-both
  "Static Constant.

  This state bit mask indicates that frame is fully maximized
   (that is both horizontally and vertically).  It is just a
   convenience alias for
   MAXIMIZED_VERT | MAXIMIZED_HORIZ.

   Note that the correct test for frame being fully maximized is


       (state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH

   To test is frame is maximized in some direction use


       (state & Frame.MAXIMIZED_BOTH) != 0

  type: int"
  Frame/MAXIMIZED_BOTH)

(defn *get-frames
  "Returns an array of all Frames created by this application.
   If called from an applet, the array includes only the Frames
   accessible by that applet.

   Warning: this method may return system created frames, such
   as a shared, hidden frame which is used by Swing. Applications
   should not assume the existence of these frames, nor should an
   application assume anything about these frames such as component
   positions, LayoutManagers or serialization.

   Note: To obtain a list of all ownerless windows, including
   ownerless Dialogs (introduced in release 1.6), use Window.getOwnerlessWindows.

  returns: `java.awt.Frame[]`"
  ([]
    (Frame/getFrames )))

(defn set-maximized-bounds
  "Sets the maximized bounds for this frame.

   When a frame is in maximized state the system supplies some
   defaults bounds.  This method allows some or all of those
   system supplied values to be overridden.

   If bounds is null, accept bounds
   supplied by the system.  If non-null you can
   override some of the system supplied values while accepting
   others by setting those fields you want to accept from system
   to Integer.MAX_VALUE.

   Note, the given maximized bounds are used as a hint for the native
   system, because the underlying platform may not support setting the
   location and/or size of the maximized windows.  If that is the case, the
   provided values do not affect the appearance of the frame in the
   maximized state.

  bounds - bounds for the maximized state - `java.awt.Rectangle`"
  ([^Frame this ^java.awt.Rectangle bounds]
    (-> this (.setMaximizedBounds bounds))))

(defn get-maximized-bounds
  "Gets maximized bounds for this frame.
   Some fields may contain Integer.MAX_VALUE to indicate
   that system supplied values for this field must be used.

  returns: maximized bounds for this frame;  may be null - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^Frame this]
    (-> this (.getMaximizedBounds))))

(defn set-shape
  "Sets the shape of the window.

   Setting a shape cuts off some parts of the window. Only the parts that
   belong to the given Shape remain visible and clickable. If
   the shape argument is null, this method restores the default
   shape, making the window rectangular on most platforms.

   The following conditions must be met to set a non-null shape:

   The PERPIXEL_TRANSPARENT translucency must be supported by the
   underlying system
   The window must be undecorated (see setUndecorated(boolean)
   and Dialog.setUndecorated(boolean))
   The window must not be in full-screen mode (see GraphicsDevice.setFullScreenWindow(Window))


   If the requested shape is not null, and any of the above
   conditions are not met, the shape of this window will not change,
   and either the UnsupportedOperationException or IllegalComponentStateException will be thrown.

   The translucency levels of individual pixels may also be effected by the
   alpha component of their color (see Window.setBackground(Color)) and the
   opacity value (see Window.setOpacity(float)). See GraphicsDevice.WindowTranslucency for more details.

  shape - the shape to set to the window - `java.awt.Shape`"
  ([^Frame this ^java.awt.Shape shape]
    (-> this (.setShape shape))))

(defn set-opacity
  "Sets the opacity of the window.

   The opacity value is in the range [0..1]. Note that setting the opacity
   level of 0 may or may not disable the mouse event handling on this
   window. This is a platform-dependent behavior.

   The following conditions must be met in order to set the opacity value
   less than 1.0f:

   The TRANSLUCENT
   translucency must be supported by the underlying system
   The window must be undecorated (see setUndecorated(boolean)
   and Dialog.setUndecorated(boolean))
   The window must not be in full-screen mode (see GraphicsDevice.setFullScreenWindow(Window))


   If the requested opacity value is less than 1.0f, and any of the
   above conditions are not met, the window opacity will not change,
   and the IllegalComponentStateException will be thrown.

   The translucency levels of individual pixels may also be effected by the
   alpha component of their color (see Window.setBackground(Color)) and the
   current shape of this window (see Window.setShape(Shape)).

  opacity - the opacity level to set to the window - `float`"
  ([^Frame this ^Float opacity]
    (-> this (.setOpacity opacity))))

(defn get-cursor-type
  "Deprecated. As of JDK version 1.1,
   replaced by Component.getCursor().

  returns: `int`"
  (^Integer [^Frame this]
    (-> this (.getCursorType))))

(defn set-state
  "Sets the state of this frame (obsolete).

   In older versions of JDK a frame state could only be NORMAL or
   ICONIFIED.  Since JDK 1.4 set of supported frame states is
   expanded and frame state is represented as a bitwise mask.

   For compatibility with applications developed
   earlier this method still accepts
   Frame.NORMAL and
   Frame.ICONIFIED only.  The iconic
   state of the frame is only changed, other aspects
   of frame state are not affected by this method. If
   the state passed to this method is neither Frame.NORMAL nor Frame.ICONIFIED the
   method performs no actions at all.
   Note that if the state is not supported on a
   given platform, neither the state nor the return
   value of the getState() method will be
   changed. The application may determine whether a
   specific state is supported via the Toolkit.isFrameStateSupported(int) method.
   If the frame is currently visible on the
   screen (the Window.isShowing() method returns
   true), the developer should examine the
   return value of the  WindowEvent.getNewState() method of
   the WindowEvent received through the
   WindowStateListener to
   determine that the state has actually been
   changed.
   If the frame is not visible on the
   screen, the events may or may not be
   generated.  In this case the developer may assume
   that the state changes immediately after this
   method returns.  Later, when the setVisible(true) method is invoked, the frame
   will attempt to apply this state. Receiving any
   WindowEvent.WINDOW_STATE_CHANGED
   events is not guaranteed in this case also.

  state - either Frame.NORMAL or Frame.ICONIFIED. - `int`"
  ([^Frame this ^Integer state]
    (-> this (.setState state))))

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
   The window must be undecorated (see setUndecorated(boolean)
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
   opacity (see Window.setOpacity(float)), as well as the current shape of
   this window (see Window.setShape(Shape)).

   Note that painting a pixel with the alpha value of 0 may or may
   not disable the mouse event handling on this pixel. This is a
   platform-dependent behavior. To make sure the mouse events do not get
   dispatched to a particular pixel, the pixel must be excluded from the
   shape of the window.

   Enabling the per-pixel translucency mode may change the graphics
   configuration of this window due to the native platform requirements.

  bg-color - the color to become this window's background color. - `java.awt.Color`"
  ([^Frame this ^java.awt.Color bg-color]
    (-> this (.setBackground bg-color))))

(defn undecorated?
  "Indicates whether this frame is undecorated.
   By default, all frames are initially decorated.

  returns: true if frame is undecorated;
                          false otherwise. - `boolean`"
  (^Boolean [^Frame this]
    (-> this (.isUndecorated))))

(defn get-state
  "Gets the state of this frame (obsolete).

   In older versions of JDK a frame state could only be NORMAL or
   ICONIFIED.  Since JDK 1.4 set of supported frame states is
   expanded and frame state is represented as a bitwise mask.

   For compatibility with old programs this method still returns
   Frame.NORMAL and Frame.ICONIFIED but
   it only reports the iconic state of the frame, other aspects of
   frame state are not reported by this method.

  returns: Frame.NORMAL or Frame.ICONIFIED. - `int`"
  (^Integer [^Frame this]
    (-> this (.getState))))

(defn get-icon-image
  "Returns the image to be displayed as the icon for this frame.

   This method is obsolete and kept for backward compatibility
   only. Use Window.getIconImages() instead.

   If a list of several images was specified as a Window's icon,
   this method will return the first item of the list.

  returns: the icon image for this frame, or null
                      if this frame doesn't have an icon image. - `java.awt.Image`"
  (^java.awt.Image [^Frame this]
    (-> this (.getIconImage))))

(defn add-notify
  "Makes this Frame displayable by connecting it to
   a native screen resource.  Making a frame displayable will
   cause any of its children to be made displayable.
   This method is called internally by the toolkit and should
   not be called directly by programs."
  ([^Frame this]
    (-> this (.addNotify))))

(defn set-menu-bar
  "Sets the menu bar for this frame to the specified menu bar.

  mb - the menu bar being set. If this parameter is null then any existing menu bar on this frame is removed. - `java.awt.MenuBar`"
  ([^Frame this ^java.awt.MenuBar mb]
    (-> this (.setMenuBar mb))))

(defn get-extended-state
  "Gets the state of this frame. The state is
   represented as a bitwise mask.

   NORMAL
   Indicates that no state bits are set.
   ICONIFIED
   MAXIMIZED_HORIZ
   MAXIMIZED_VERT
   MAXIMIZED_BOTH
   Concatenates MAXIMIZED_HORIZ
   and MAXIMIZED_VERT.

  returns: a bitwise mask of frame state constants - `int`"
  (^Integer [^Frame this]
    (-> this (.getExtendedState))))

(defn remove-notify
  "Makes this Frame undisplayable by removing its connection
   to its native screen resource. Making a Frame undisplayable
   will cause any of its children to be made undisplayable.
   This method is called by the toolkit internally and should
   not be called directly by programs."
  ([^Frame this]
    (-> this (.removeNotify))))

(defn resizable?
  "Indicates whether this frame is resizable by the user.
   By default, all frames are initially resizable.

  returns: true if the user can resize this frame;
                          false otherwise. - `boolean`"
  (^Boolean [^Frame this]
    (-> this (.isResizable))))

(defn remove
  "Removes the specified menu bar from this frame.

  m - the menu component to remove. If m is null, then no action is taken - `java.awt.MenuComponent`"
  ([^Frame this ^java.awt.MenuComponent m]
    (-> this (.remove m))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this Frame.
   For frames, the AccessibleContext takes the form of an
   AccessibleAWTFrame.
   A new AccessibleAWTFrame instance is created if necessary.

  returns: an AccessibleAWTFrame that serves as the
           AccessibleContext of this Frame - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^Frame this]
    (-> this (.getAccessibleContext))))

(defn set-undecorated
  "Disables or enables decorations for this frame.

   This method can only be called while the frame is not displayable. To
   make this frame decorated, it must be opaque and have the default shape,
   otherwise the IllegalComponentStateException will be thrown.
   Refer to Window.setShape(java.awt.Shape), Window.setOpacity(float) and Window.setBackground(java.awt.Color) for details

  undecorated - true if no frame decorations are to be enabled; false if frame decorations are to be enabled - `boolean`

  throws: java.awt.IllegalComponentStateException - if undecorated is false, and the alpha value of this frame background color is less than 1.0f"
  ([^Frame this ^Boolean undecorated]
    (-> this (.setUndecorated undecorated))))

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
  ([^Frame this ^java.awt.Image image]
    (-> this (.setIconImage image))))

(defn get-menu-bar
  "Gets the menu bar for this frame.

  returns: the menu bar for this frame, or null
                     if this frame doesn't have a menu bar. - `java.awt.MenuBar`"
  (^java.awt.MenuBar [^Frame this]
    (-> this (.getMenuBar))))

(defn set-cursor
  "Deprecated. As of JDK version 1.1,
   replaced by Component.setCursor(Cursor).

  cursor-type - `int`"
  ([^Frame this ^Integer cursor-type]
    (-> this (.setCursor cursor-type))))

(defn set-extended-state
  "Sets the state of this frame. The state is
   represented as a bitwise mask.

   NORMAL
   Indicates that no state bits are set.
   ICONIFIED
   MAXIMIZED_HORIZ
   MAXIMIZED_VERT
   MAXIMIZED_BOTH
   Concatenates MAXIMIZED_HORIZ
   and MAXIMIZED_VERT.

   Note that if the state is not supported on a
   given platform, neither the state nor the return
   value of the getExtendedState() method will
   be changed. The application may determine whether
   a specific state is supported via the Toolkit.isFrameStateSupported(int) method.
   If the frame is currently visible on the
   screen (the Window.isShowing() method returns
   true), the developer should examine the
   return value of the WindowEvent.getNewState() method of
   the WindowEvent received through the
   WindowStateListener to
   determine that the state has actually been
   changed.
   If the frame is not visible on the
   screen, the events may or may not be
   generated.  In this case the developer may assume
   that the state changes immediately after this
   method returns.  Later, when the setVisible(true) method is invoked, the frame
   will attempt to apply this state. Receiving any
   WindowEvent.WINDOW_STATE_CHANGED
   events is not guaranteed in this case also.

  state - a bitwise mask of frame state constants - `int`"
  ([^Frame this ^Integer state]
    (-> this (.setExtendedState state))))

(defn set-resizable
  "Sets whether this frame is resizable by the user.

  resizable - true if this frame is resizable; false otherwise. - `boolean`"
  ([^Frame this ^Boolean resizable]
    (-> this (.setResizable resizable))))

(defn get-title
  "Gets the title of the frame.  The title is displayed in the
   frame's border.

  returns: the title of this frame, or an empty string (``)
                  if this frame doesn't have a title. - `java.lang.String`"
  (^java.lang.String [^Frame this]
    (-> this (.getTitle))))

(defn set-title
  "Sets the title for this frame to the specified string.

  title - the title to be displayed in the frame's border. A null value is treated as an empty string, ``. - `java.lang.String`"
  ([^Frame this ^java.lang.String title]
    (-> this (.setTitle title))))

