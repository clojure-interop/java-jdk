(ns jdk.awt.GraphicsDevice
  "The GraphicsDevice class describes the graphics devices
  that might be available in a particular graphics environment.  These
  include screen and printer devices. Note that there can be many screens
  and many printers in an instance of GraphicsEnvironment. Each
  graphics device has one or more GraphicsConfiguration objects
  associated with it.  These objects specify the different configurations
  in which the GraphicsDevice can be used.

  In a multi-screen environment, the GraphicsConfiguration
  objects can be used to render components on multiple screens.  The
  following code sample demonstrates how to create a JFrame
  object for each GraphicsConfiguration on each screen
  device in the GraphicsEnvironment:


    GraphicsEnvironment ge = GraphicsEnvironment.
    getLocalGraphicsEnvironment();
    GraphicsDevice[] gs = ge.getScreenDevices();
    for (int j = 0; j < gs.length; j++) {
       GraphicsDevice gd = gs[j];
       GraphicsConfiguration[] gc =
       gd.getConfigurations();
       for (int i=0; i < gc.length; i++) {
          JFrame f = new
          JFrame(gs[j].getDefaultConfiguration());
          Canvas c = new Canvas(gc[i]);
          Rectangle gcBounds = gc[i].getBounds();
          int xoffs = gcBounds.x;
          int yoffs = gcBounds.y;
          f.getContentPane().add(c);
          f.setLocation((i*50)+xoffs, (i*60)+yoffs);
          f.show();
       }
    }

  For more information on full-screen exclusive mode API, see the

  Full-Screen Exclusive Mode API Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt GraphicsDevice]))

(def *-type-raster-screen
  "Static Constant.

  Device is a raster screen.

  type: int"
  GraphicsDevice/TYPE_RASTER_SCREEN)

(def *-type-printer
  "Static Constant.

  Device is a printer.

  type: int"
  GraphicsDevice/TYPE_PRINTER)

(def *-type-image-buffer
  "Static Constant.

  Device is an image buffer.  This buffer can reside in device
   or system memory but it is not physically viewable by the user.

  type: int"
  GraphicsDevice/TYPE_IMAGE_BUFFER)

(defn get-display-mode
  "Returns the current display mode of this
   GraphicsDevice.
   The returned display mode is allowed to have a refresh rate
   DisplayMode.REFRESH_RATE_UNKNOWN if it is indeterminate.
   Likewise, the returned display mode is allowed to have a bit depth
   DisplayMode.BIT_DEPTH_MULTI if it is indeterminate or if multiple
   bit depths are supported.

  returns: the current display mode of this graphics device. - `java.awt.DisplayMode`"
  (^java.awt.DisplayMode [^java.awt.GraphicsDevice this]
    (-> this (.getDisplayMode))))

(defn get-full-screen-window
  "Returns the Window object representing the
   full-screen window if the device is in full-screen mode.

  returns: the full-screen window, or null if the device is
   not in full-screen mode. - `java.awt.Window`"
  (^java.awt.Window [^java.awt.GraphicsDevice this]
    (-> this (.getFullScreenWindow))))

(defn get-type
  "Returns the type of this GraphicsDevice.

  returns: the type of this GraphicsDevice, which can
   either be TYPE_RASTER_SCREEN, TYPE_PRINTER or TYPE_IMAGE_BUFFER. - `int`"
  (^Integer [^java.awt.GraphicsDevice this]
    (-> this (.getType))))

(defn get-display-modes
  "Returns all display modes available for this
   GraphicsDevice.
   The returned display modes are allowed to have a refresh rate
   DisplayMode.REFRESH_RATE_UNKNOWN if it is indeterminate.
   Likewise, the returned display modes are allowed to have a bit depth
   DisplayMode.BIT_DEPTH_MULTI if it is indeterminate or if multiple
   bit depths are supported.

  returns: all of the display modes available for this graphics device. - `java.awt.DisplayMode[]`"
  ([^java.awt.GraphicsDevice this]
    (-> this (.getDisplayModes))))

(defn display-change-supported?
  "Returns true if this GraphicsDevice
   supports low-level display changes.
   On some platforms low-level display changes may only be allowed in
   full-screen exclusive mode (i.e., if isFullScreenSupported()
   returns true and the application has already entered
   full-screen mode using setFullScreenWindow(java.awt.Window)).

  returns: whether low-level display changes are supported for this
   graphics device. - `boolean`"
  (^Boolean [^java.awt.GraphicsDevice this]
    (-> this (.isDisplayChangeSupported))))

(defn get-i-dstring
  "Returns the identification string associated with this
   GraphicsDevice.

   A particular program might use more than one
   GraphicsDevice in a GraphicsEnvironment.
   This method returns a String identifying a
   particular GraphicsDevice in the local
   GraphicsEnvironment.  Although there is
   no public method to set this String, a programmer can
   use the String for debugging purposes.  Vendors of
   the Java™ Runtime Environment can
   format the return value of the String.  To determine
   how to interpret the value of the String, contact the
   vendor of your Java Runtime.  To find out who the vendor is, from
   your program, call the
   getProperty method of the
   System class with `java.vendor`.

  returns: a String that is the identification
   of this GraphicsDevice. - `java.lang.String`"
  (^java.lang.String [^java.awt.GraphicsDevice this]
    (-> this (.getIDstring))))

(defn window-translucency-supported?
  "Returns whether the given level of translucency is supported by
   this graphics device.

  translucency-kind - a kind of translucency support - `java.awt.GraphicsDevice.WindowTranslucency`

  returns: whether the given translucency kind is supported - `boolean`"
  (^Boolean [^java.awt.GraphicsDevice this ^java.awt.GraphicsDevice.WindowTranslucency translucency-kind]
    (-> this (.isWindowTranslucencySupported translucency-kind))))

(defn set-display-mode
  "Sets the display mode of this graphics device. This is only allowed
   if isDisplayChangeSupported() returns true and may
   require first entering full-screen exclusive mode using
   setFullScreenWindow(java.awt.Window) providing that full-screen exclusive mode is
   supported (i.e., isFullScreenSupported() returns
   true).


   The display mode must be one of the display modes returned by
   getDisplayModes(), with one exception: passing a display mode
   with DisplayMode.REFRESH_RATE_UNKNOWN refresh rate will result in
   selecting a display mode from the list of available display modes with
   matching width, height and bit depth.
   However, passing a display mode with DisplayMode.BIT_DEPTH_MULTI
   for bit depth is only allowed if such mode exists in the list returned by
   getDisplayModes().

   Example code:


   Frame frame;
   DisplayMode newDisplayMode;
   GraphicsDevice gd;
   // create a Frame, select desired DisplayMode from the list of modes
   // returned by gd.getDisplayModes() ...

   if (gd.isFullScreenSupported()) {
       gd.setFullScreenWindow(frame);
   } else {
      // proceed in non-full-screen mode
      frame.setSize(...);
      frame.setLocation(...);
      frame.setVisible(true);
   }

   if (gd.isDisplayChangeSupported()) {
       gd.setDisplayMode(newDisplayMode);
   }

  dm - The new display mode of this graphics device. - `java.awt.DisplayMode`

  throws: java.lang.IllegalArgumentException - if the DisplayMode supplied is null, or is not available in the array returned by getDisplayModes"
  ([^java.awt.GraphicsDevice this ^java.awt.DisplayMode dm]
    (-> this (.setDisplayMode dm))))

(defn get-configurations
  "Returns all of the GraphicsConfiguration
   objects associated with this GraphicsDevice.

  returns: an array of GraphicsConfiguration
   objects that are associated with this
   GraphicsDevice. - `java.awt.GraphicsConfiguration[]`"
  ([^java.awt.GraphicsDevice this]
    (-> this (.getConfigurations))))

(defn full-screen-supported?
  "Returns true if this GraphicsDevice
   supports full-screen exclusive mode.
   If a SecurityManager is installed, its
   checkPermission method will be called
   with AWTPermission(`fullScreenExclusive`).
   isFullScreenSupported returns true only if
   that permission is granted.

  returns: whether full-screen exclusive mode is available for
   this graphics device - `boolean`"
  (^Boolean [^java.awt.GraphicsDevice this]
    (-> this (.isFullScreenSupported))))

(defn get-available-accelerated-memory
  "This method returns the number of bytes available in
   accelerated memory on this device.
   Some images are created or cached
   in accelerated memory on a first-come,
   first-served basis.  On some operating systems,
   this memory is a finite resource.  Calling this method
   and scheduling the creation and flushing of images carefully may
   enable applications to make the most efficient use of
   that finite resource.

   Note that the number returned is a snapshot of how much
   memory is available; some images may still have problems
   being allocated into that memory.  For example, depending
   on operating system, driver, memory configuration, and
   thread situations, the full extent of the size reported
   may not be available for a given image.  There are further
   inquiry methods on the ImageCapabilities object
   associated with a VolatileImage that can be used to determine
   whether a particular VolatileImage has been created in accelerated
   memory.

  returns: number of bytes available in accelerated memory.
   A negative return value indicates that the amount of accelerated memory
   on this GraphicsDevice is indeterminate. - `int`"
  (^Integer [^java.awt.GraphicsDevice this]
    (-> this (.getAvailableAcceleratedMemory))))

(defn set-full-screen-window
  "Enter full-screen mode, or return to windowed mode.  The entered
   full-screen mode may be either exclusive or simulated.  Exclusive
   mode is only available if isFullScreenSupported
   returns true.

   Exclusive mode implies:

   Windows cannot overlap the full-screen window.  All other application
   windows will always appear beneath the full-screen window in the Z-order.
   There can be only one full-screen window on a device at any time,
   so calling this method while there is an existing full-screen Window
   will cause the existing full-screen window to
   return to windowed mode.
   Input method windows are disabled.  It is advisable to call
   Component.enableInputMethods(false) to make a component
   a non-client of the input method framework.


   The simulated full-screen mode places and resizes the window to the maximum
   possible visible area of the screen. However, the native windowing system
   may modify the requested geometry-related data, so that the Window object
   is placed and sized in a way that corresponds closely to the desktop settings.

   When entering full-screen mode, if the window to be used as a
   full-screen window is not visible, this method will make it visible.
   It will remain visible when returning to windowed mode.

   When entering full-screen mode, all the translucency effects are reset for
   the window. Its shape is set to null, the opacity value is set to
   1.0f, and the background color alpha is set to 255 (completely opaque).
   These values are not restored when returning to windowed mode.

   It is unspecified and platform-dependent how decorated windows operate
   in full-screen mode. For this reason, it is recommended to turn off
   the decorations in a Frame or Dialog object by using the
   setUndecorated method.

   When returning to windowed mode from an exclusive full-screen window,
   any display changes made by calling setDisplayMode are
   automatically restored to their original state.

  w - a window to use as the full-screen window; null if returning to windowed mode. Some platforms expect the fullscreen window to be a top-level component (i.e., a Frame); therefore it is preferable to use a Frame here rather than a Window. - `java.awt.Window`"
  ([^java.awt.GraphicsDevice this ^java.awt.Window w]
    (-> this (.setFullScreenWindow w))))

(defn get-default-configuration
  "Returns the default GraphicsConfiguration
   associated with this GraphicsDevice.

  returns: the default GraphicsConfiguration
   of this GraphicsDevice. - `java.awt.GraphicsConfiguration`"
  (^java.awt.GraphicsConfiguration [^java.awt.GraphicsDevice this]
    (-> this (.getDefaultConfiguration))))

(defn get-best-configuration
  "Returns the `best` configuration possible that passes the
   criteria defined in the GraphicsConfigTemplate.

  gct - the GraphicsConfigTemplate object used to obtain a valid GraphicsConfiguration - `java.awt.GraphicsConfigTemplate`

  returns: a GraphicsConfiguration that passes
   the criteria defined in the specified
   GraphicsConfigTemplate. - `java.awt.GraphicsConfiguration`"
  (^java.awt.GraphicsConfiguration [^java.awt.GraphicsDevice this ^java.awt.GraphicsConfigTemplate gct]
    (-> this (.getBestConfiguration gct))))

