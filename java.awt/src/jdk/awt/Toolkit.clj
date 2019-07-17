(ns jdk.awt.Toolkit
  "This class is the abstract superclass of all actual
  implementations of the Abstract Window Toolkit. Subclasses of
  the Toolkit class are used to bind the various components
  to particular native toolkit implementations.

  Many GUI events may be delivered to user
  asynchronously, if the opposite is not specified explicitly.
  As well as
  many GUI operations may be performed asynchronously.
  This fact means that if the state of a component is set, and then
  the state immediately queried, the returned value may not yet
  reflect the requested change.  This behavior includes, but is not
  limited to:

  Scrolling to a specified position.
  For example, calling ScrollPane.setScrollPosition
      and then getScrollPosition may return an incorrect
      value if the original request has not yet been processed.

  Moving the focus from one component to another.
  For more information, see
  Timing
  Focus Transfers, a section in
  The Swing
  Tutorial.

  Making a top-level container visible.
  Calling setVisible(true) on a Window,
      Frame or Dialog may occur
      asynchronously.

  Setting the size or location of a top-level container.
  Calls to setSize, setBounds or
      setLocation on a Window,
      Frame or Dialog are forwarded
      to the underlying window management system and may be
      ignored or modified.  See Window for
      more information.


  Most applications should not call any of the methods in this
  class directly. The methods defined by Toolkit are
  the `glue` that joins the platform-independent classes in the
  java.awt package with their counterparts in
  java.awt.peer. Some methods defined by
  Toolkit query the native operating system directly."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Toolkit]))

(defn ->toolkit
  "Constructor."
  ([]
    (new Toolkit )))

(defn *get-default-toolkit
  "Gets the default toolkit.

   If a system property named `java.awt.headless` is set
   to true then the headless implementation
   of Toolkit is used.

   If there is no `java.awt.headless` or it is set to
   false and there is a system property named
   `awt.toolkit`,
   that property is treated as the name of a class that is a subclass
   of Toolkit;
   otherwise the default platform-specific implementation of
   Toolkit is used.

   Also loads additional classes into the VM, using the property
   'assistive_technologies' specified in the Sun reference
   implementation by a line in the 'accessibility.properties'
   file.  The form is `assistive_technologies=...` where
   the `...` is a comma-separated list of assistive technology
   classes to load.  Each class is loaded in the order given
   and a single instance of each is created using
   Class.forName(class).newInstance().  This is done just after
   the AWT toolkit is created.  All errors are handled via an
   AWTError exception.

  returns: the default toolkit. - `java.awt.Toolkit`

  throws: java.awt.AWTError - if a toolkit could not be found, or if one could not be accessed or instantiated."
  ([]
    (Toolkit/getDefaultToolkit )))

(defn *get-property
  "Gets a property with the specified key and default.
   This method returns defaultValue if the property is not found.

  key - `java.lang.String`
  default-value - `java.lang.String`

  returns: `java.lang.String`"
  ([^java.lang.String key ^java.lang.String default-value]
    (Toolkit/getProperty key default-value)))

(defn get-image
  "Returns an image which gets pixel data from the specified file,
   whose format can be either GIF, JPEG or PNG.
   The underlying toolkit attempts to resolve multiple requests
   with the same filename to the same returned Image.

   Since the mechanism required to facilitate this sharing of
   Image objects may continue to hold onto images
   that are no longer in use for an indefinite period of time,
   developers are encouraged to implement their own caching of
   images by using the createImage
   variant wherever available.
   If the image data contained in the specified file changes,
   the Image object returned from this method may
   still contain stale information which was loaded from the
   file after a prior call.
   Previously loaded image data can be manually discarded by
   calling the flush method on the
   returned Image.

   This method first checks if there is a security manager installed.
   If so, the method calls the security manager's
   checkRead method with the file specified to ensure
   that the access to the image is allowed.

  filename - the name of a file containing pixel data in a recognized file format. - `java.lang.String`

  returns: an image which gets its pixel data from
                           the specified file. - `java.awt.Image`

  throws: java.lang.SecurityException - if a security manager exists and its checkRead method doesn't allow the operation."
  ([^java.awt.Toolkit this ^java.lang.String filename]
    (-> this (.getImage filename))))

(defn get-screen-resolution
  "Returns the screen resolution in dots-per-inch.

  returns: this toolkit's screen resolution, in dots-per-inch. - `int`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Toolkit this]
    (-> this (.getScreenResolution))))

(defn are-extra-mouse-buttons-enabled
  "Reports whether events from extra mouse buttons are allowed to be processed and posted into
   EventQueue.

   To change the returned value it is necessary to set the sun.awt.enableExtraMouseButtons
   property before the Toolkit class initialization. This setting could be done on the application
   startup by the following command:


   java -Dsun.awt.enableExtraMouseButtons=false Application
   Alternatively, the property could be set in the application by using the following code:


   System.setProperty(`sun.awt.enableExtraMouseButtons`, `true`);
   before the Toolkit class initialization.
   If not set by the time of the Toolkit class initialization, this property will be
   initialized with true.
   Changing this value after the Toolkit class initialization will have no effect.

  returns: true if events from extra mouse buttons are allowed to be processed and posted;
           false otherwise - `boolean`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Toolkit this]
    (-> this (.areExtraMouseButtonsEnabled))))

(defn map-input-method-highlight
  "Returns a map of visual attributes for the abstract level description
   of the given input method highlight, or null if no mapping is found.
   The style field of the input method highlight is ignored. The map
   returned is unmodifiable.

  highlight - input method highlight - `java.awt.im.InputMethodHighlight`

  returns: style attribute map, or null - `java.util.Map<java.awt.font.TextAttribute,?>`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  ([^java.awt.Toolkit this ^java.awt.im.InputMethodHighlight highlight]
    (-> this (.mapInputMethodHighlight highlight))))

(defn get-font-list
  "Deprecated. see GraphicsEnvironment.getAvailableFontFamilyNames()

  returns: the names of the available fonts in this toolkit. - `java.lang.   java.lang.String[]`"
  ([^java.awt.Toolkit this]
    (-> this (.getFontList))))

(defn get-screen-insets
  "Gets the insets of the screen.

  gc - a GraphicsConfiguration - `java.awt.GraphicsConfiguration`

  returns: the insets of this toolkit's screen, in pixels. - `java.awt.Insets`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Toolkit this ^java.awt.GraphicsConfiguration gc]
    (-> this (.getScreenInsets gc))))

(defn add-awt-event-listener
  "Adds an AWTEventListener to receive all AWTEvents dispatched
   system-wide that conform to the given eventMask.

   First, if there is a security manager, its checkPermission
   method is called with an
   AWTPermission(`listenToAllAWTEvents`) permission.
   This may result in a SecurityException.

   eventMask is a bitmask of event types to receive.
   It is constructed by bitwise OR-ing together the event masks
   defined in AWTEvent.

   Note:  event listener use is not recommended for normal
   application use, but are intended solely to support special
   purpose facilities including support for accessibility,
   event record/playback, and diagnostic tracing.

   If listener is null, no exception is thrown and no action is performed.

  listener - the event listener. - `java.awt.event.AWTEventListener`
  event-mask - the bitmask of event types to receive - `long`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow the operation."
  ([^java.awt.Toolkit this ^java.awt.event.AWTEventListener listener ^Long event-mask]
    (-> this (.addAWTEventListener listener event-mask))))

(defn get-menu-shortcut-key-mask
  "Determines which modifier key is the appropriate accelerator
   key for menu shortcuts.

   Menu shortcuts, which are embodied in the
   MenuShortcut class, are handled by the
   MenuBar class.

   By default, this method returns Event.CTRL_MASK.
   Toolkit implementations should override this method if the
   Control key isn't the correct key for accelerators.

  returns: the modifier mask on the Event class
                   that is used for menu shortcuts on this toolkit. - `int`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Toolkit this]
    (-> this (.getMenuShortcutKeyMask))))

(defn create-drag-gesture-recognizer
  "Creates a concrete, platform dependent, subclass of the abstract
   DragGestureRecognizer class requested, and associates it with the
   DragSource, Component and DragGestureListener specified.

   subclasses should override this to provide their own implementation

  abstract-recognizer-class - The abstract class of the required recognizer - `java.lang.Class<T>`
  ds - The DragSource - `java.awt.dnd.DragSource`
  c - The Component target for the DragGestureRecognizer - `java.awt.Component`
  src-actions - The actions permitted for the gesture - `int`
  dgl - The DragGestureListener - `java.awt.dnd.DragGestureListener`

  returns: the new object or null.  Always returns null if
   GraphicsEnvironment.isHeadless() returns true. - `<T extends java.awt.dnd.DragGestureRecognizer> T`"
  ([^java.awt.Toolkit this ^java.lang.Class abstract-recognizer-class ^java.awt.dnd.DragSource ds ^java.awt.Component c ^Integer src-actions ^java.awt.dnd.DragGestureListener dgl]
    (-> this (.createDragGestureRecognizer abstract-recognizer-class ds c src-actions dgl))))

(defn modal-exclusion-type-supported?
  "Returns whether the given modal exclusion type is supported by this
   toolkit. If an unsupported modal exclusion type property is set on a window,
   then Dialog.ModalExclusionType.NO_EXCLUDE is used instead.

  modal-exclusion-type - modal exclusion type to be checked for support by this toolkit - `java.awt.Dialog.ModalExclusionType`

  returns: true, if current toolkit supports given modal exclusion
       type, false otherwise - `boolean`"
  ([^java.awt.Toolkit this ^java.awt.Dialog.ModalExclusionType modal-exclusion-type]
    (-> this (.isModalExclusionTypeSupported modal-exclusion-type))))

(defn get-system-selection
  "Gets the singleton instance of the system selection as a
   Clipboard object. This allows an application to read and
   modify the current, system-wide selection.

   An application is responsible for updating the system selection whenever
   the user selects text, using either the mouse or the keyboard.
   Typically, this is implemented by installing a
   FocusListener on all Components which support
   text selection, and, between FOCUS_GAINED and
   FOCUS_LOST events delivered to that Component,
   updating the system selection Clipboard when the selection
   changes inside the Component. Properly updating the system
   selection ensures that a Java application will interact correctly with
   native applications and other Java applications running simultaneously
   on the system. Note that java.awt.TextComponent and
   javax.swing.text.JTextComponent already adhere to this
   policy. When using these classes, and their subclasses, developers need
   not write any additional code.

   Some platforms do not support a system selection Clipboard.
   On those platforms, this method will return null. In such a
   case, an application is absolved from its responsibility to update the
   system selection Clipboard as described above.

   Each actual implementation of this method should first check if there
   is a security manager installed. If there is, the method should call
   the security manager's checkPermission method to check AWTPermission(`accessClipboard`).

  returns: the system selection as a Clipboard, or
           null if the native platform does not support a
           system selection Clipboard - `java.awt.datatransfer.Clipboard`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Toolkit this]
    (-> this (.getSystemSelection))))

(defn create-custom-cursor
  "Creates a new custom cursor object.
   If the image to display is invalid, the cursor will be hidden (made
   completely transparent), and the hotspot will be set to (0, 0).

   Note that multi-frame images are invalid and may cause this
   method to hang.

  cursor - the image to display when the cursor is activated - `java.awt.Image`
  hot-spot - the X and Y of the large cursor's hot spot; the hotSpot values must be less than the Dimension returned by getBestCursorSize - `java.awt.Point`
  name - a localized description of the cursor, for Java Accessibility use - `java.lang.String`

  returns: `java.awt.Cursor`

  throws: java.lang.IndexOutOfBoundsException - if the hotSpot values are outside the bounds of the cursor"
  ([^java.awt.Toolkit this ^java.awt.Image cursor ^java.awt.Point hot-spot ^java.lang.String name]
    (-> this (.createCustomCursor cursor hot-spot name))))

(defn dynamic-layout-active?
  "Returns whether dynamic layout of Containers on resize is
   currently active (both set in program
  ( isDynamicLayoutSet() )
  , and supported
   by the underlying operating system and/or window manager).
   If dynamic layout is currently inactive then Containers
   re-layout their components when resizing is completed. As a result
   the Component.validate() method will be invoked only
   once per resize.
   If dynamic layout is currently active then Containers
   re-layout their components on every native resize event and
   the validate() method will be invoked each time.
   The OS/WM support can be queried using
   the getDesktopProperty(`awt.dynamicLayoutSupported`) method.

  returns: true if dynamic layout of Containers on resize is
              currently active, false otherwise. - `boolean`

  throws: java.awt.HeadlessException - if the GraphicsEnvironment.isHeadless() method returns true"
  ([^java.awt.Toolkit this]
    (-> this (.isDynamicLayoutActive))))

(defn get-print-job
  "Gets a PrintJob object which is the result of initiating
   a print operation on the toolkit's platform.

   Each actual implementation of this method should first check if there
   is a security manager installed. If there is, the method should call
   the security manager's checkPrintJobAccess method to
   ensure initiation of a print operation is allowed. If the default
   implementation of checkPrintJobAccess is used (that is,
   that method is not overriden), then this results in a call to the
   security manager's checkPermission method with a
   RuntimePermission(`queuePrintJob`) permission.

  frame - the parent of the print dialog. May not be null. - `java.awt.Frame`
  jobtitle - the title of the PrintJob. A null title is equivalent to ``. - `java.lang.String`
  job-attributes - a set of job attributes which will control the PrintJob. The attributes will be updated to reflect the user's choices as outlined in the JobAttributes documentation. May be null. - `java.awt.JobAttributes`
  page-attributes - a set of page attributes which will control the PrintJob. The attributes will be applied to every page in the job. The attributes will be updated to reflect the user's choices as outlined in the PageAttributes documentation. May be null. - `java.awt.PageAttributes`

  returns: a PrintJob object, or null if the
            user cancelled the print job. - `java.awt.PrintJob`

  throws: java.lang.NullPointerException - if frame is null"
  ([^java.awt.Toolkit this ^java.awt.Frame frame ^java.lang.String jobtitle ^java.awt.JobAttributes job-attributes ^java.awt.PageAttributes page-attributes]
    (-> this (.getPrintJob frame jobtitle job-attributes page-attributes)))
  ([^java.awt.Toolkit this ^java.awt.Frame frame ^java.lang.String jobtitle ^java.util.Properties props]
    (-> this (.getPrintJob frame jobtitle props))))

(defn remove-awt-event-listener
  "Removes an AWTEventListener from receiving dispatched AWTEvents.

   First, if there is a security manager, its checkPermission
   method is called with an
   AWTPermission(`listenToAllAWTEvents`) permission.
   This may result in a SecurityException.

   Note:  event listener use is not recommended for normal
   application use, but are intended solely to support special
   purpose facilities including support for accessibility,
   event record/playback, and diagnostic tracing.

   If listener is null, no exception is thrown and no action is performed.

  listener - the event listener. - `java.awt.event.AWTEventListener`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow the operation."
  ([^java.awt.Toolkit this ^java.awt.event.AWTEventListener listener]
    (-> this (.removeAWTEventListener listener))))

(defn beep
  "Emits an audio beep depending on native system settings and hardware
   capabilities."
  ([^java.awt.Toolkit this]
    (-> this (.beep))))

(defn get-system-event-queue
  "Get the application's or applet's EventQueue instance.
   Depending on the Toolkit implementation, different EventQueues
   may be returned for different applets.  Applets should
   therefore not assume that the EventQueue instance returned
   by this method will be shared by other applets or the system.

    If there is a security manager then its
   checkPermission method
   is called to check AWTPermission(`accessEventQueue`).

  returns: the EventQueue object - `java.awt.EventQueue`

  throws: java.lang.SecurityException - if a security manager is set and it denies access to the EventQueue"
  ([^java.awt.Toolkit this]
    (-> this (.getSystemEventQueue))))

(defn check-image
  "Indicates the construction status of a specified image that is
   being prepared for display.

   If the values of the width and height arguments are both
   -1, this method returns the construction status of
   a screen representation of the specified image in this toolkit.
   Otherwise, this method returns the construction status of a
   scaled representation of the image at the specified width
   and height.

   This method does not cause the image to begin loading.
   An application must call prepareImage to force
   the loading of an image.

   This method is called by the component's checkImage
   methods.

   Information on the flags returned by this method can be found
   with the definition of the ImageObserver interface.

  image - the image whose status is being checked. - `java.awt.Image`
  width - the width of the scaled version whose status is being checked, or -1. - `int`
  height - the height of the scaled version whose status is being checked, or -1. - `int`
  observer - the ImageObserver object to be notified as the image is being prepared. - `java.awt.image.ImageObserver`

  returns: the bitwise inclusive OR of the
                   ImageObserver flags for the
                   image data that is currently available. - `int`"
  ([^java.awt.Toolkit this ^java.awt.Image image ^Integer width ^Integer height ^java.awt.image.ImageObserver observer]
    (-> this (.checkImage image width height observer))))

(defn create-drag-source-context-peer
  "Creates the peer for a DragSourceContext.
   Always throws InvalidDndOperationException if
   GraphicsEnvironment.isHeadless() returns true.

  dge - `java.awt.dnd.DragGestureEvent`

  returns: `java.awt.dnd.peer.DragSourceContextPeer`

  throws: java.awt.dnd.InvalidDnDOperationException"
  ([^java.awt.Toolkit this ^java.awt.dnd.DragGestureEvent dge]
    (-> this (.createDragSourceContextPeer dge))))

(defn set-dynamic-layout
  "Controls whether the layout of Containers is validated dynamically
   during resizing, or statically, after resizing is complete.
   Use isDynamicLayoutActive() to detect if this feature enabled
   in this program and is supported by this operating system
   and/or window manager.
   Note that this feature is supported not on all platforms, and
   conversely, that this feature cannot be turned off on some platforms.
   On these platforms where dynamic layout during resizing is not supported
   (or is always supported), setting this property has no effect.
   Note that this feature can be set or unset as a property of the
   operating system or window manager on some platforms.  On such
   platforms, the dynamic resize property must be set at the operating
   system or window manager level before this method can take effect.
   This method does not change support or settings of the underlying
   operating system or
   window manager.  The OS/WM support can be
   queried using getDesktopProperty(`awt.dynamicLayoutSupported`) method.

  dynamic - If true, Containers should re-layout their components as the Container is being resized. If false, the layout will be validated after resizing is completed. - `boolean`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Toolkit this ^Boolean dynamic]
    (-> this (.setDynamicLayout dynamic))))

(defn get-font-metrics
  "Deprecated. As of JDK version 1.2, replaced by the Font
            method getLineMetrics.

  font - a font - `java.awt.Font`

  returns: the screen metrics of the specified font in this toolkit - `java.lang.   java.awt.FontMetrics`"
  ([^java.awt.Toolkit this ^java.awt.Font font]
    (-> this (.getFontMetrics font))))

(defn get-best-cursor-size
  "Returns the supported cursor dimension which is closest to the desired
   sizes.  Systems which only support a single cursor size will return that
   size regardless of the desired sizes.  Systems which don't support custom
   cursors will return a dimension of 0, 0.
   Note:  if an image is used whose dimensions don't match a supported size
   (as returned by this method), the Toolkit implementation will attempt to
   resize the image to a supported size.
   Since converting low-resolution images is difficult,
   no guarantees are made as to the quality of a cursor image which isn't a
   supported size.  It is therefore recommended that this method
   be called and an appropriate image used so no image conversion is made.

  preferred-width - the preferred cursor width the component would like to use. - `int`
  preferred-height - the preferred cursor height the component would like to use. - `int`

  returns: the closest matching supported cursor size, or a dimension of 0,0 if
   the Toolkit implementation doesn't support custom cursors. - `java.awt.Dimension`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Toolkit this ^Integer preferred-width ^Integer preferred-height]
    (-> this (.getBestCursorSize preferred-width preferred-height))))

(defn sync
  "Synchronizes this toolkit's graphics state. Some window systems
   may do buffering of graphics events.

   This method ensures that the display is up-to-date. It is useful
   for animation."
  ([^java.awt.Toolkit this]
    (-> this (.sync))))

(defn remove-property-change-listener
  "Removes the specified property change listener for the named
   desktop property. When a PropertyChangeListenerProxy object
   is removed, its property name is ignored, and
   the wrapped listener is removed.
   If name is null or pcl is null,
   no exception is thrown and no action is performed.

  name - The name of the property to remove - `java.lang.String`
  pcl - The property change listener - `java.beans.PropertyChangeListener`"
  ([^java.awt.Toolkit this ^java.lang.String name ^java.beans.PropertyChangeListener pcl]
    (-> this (.removePropertyChangeListener name pcl))))

(defn frame-state-supported?
  "Returns whether Toolkit supports this state for
   Frames.  This method tells whether the UI
   concept of, say, maximization or iconification is
   supported.  It will always return false for `compound` states
   like Frame.ICONIFIED|Frame.MAXIMIZED_VERT.
   In other words, the rule of thumb is that only queries with a
   single frame state constant as an argument are meaningful.
   Note that supporting a given concept is a platform-
   dependent feature. Due to native limitations the Toolkit
   object may report a particular state as supported, however at
   the same time the Toolkit object will be unable to apply the
   state to a given frame.  This circumstance has two following
   consequences:

   Only the return value of false for the present
   method actually indicates that the given state is not
   supported. If the method returns true the given state
   may still be unsupported and/or unavailable for a particular
   frame.
   The developer should consider examining the value of the
   WindowEvent.getNewState() method of the
   WindowEvent received through the WindowStateListener, rather than assuming
   that the state given to the setExtendedState() method
   will be definitely applied. For more information see the
   documentation for the Frame.setExtendedState(int) method.

  state - one of named frame state constants. - `int`

  returns: true is this frame state is supported by
       this Toolkit implementation, false otherwise. - `boolean`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([^java.awt.Toolkit this ^Integer state]
    (-> this (.isFrameStateSupported state))))

(defn get-desktop-property
  "Obtains a value for the specified desktop property.

   A desktop property is a uniquely named value for a resource that
   is Toolkit global in nature. Usually it also is an abstract
   representation for an underlying platform dependent desktop setting.
   For more information on desktop properties supported by the AWT see
   AWT Desktop Properties.

  property-name - `java.lang.String`

  returns: `java.lang.Object`"
  ([^java.awt.Toolkit this ^java.lang.String property-name]
    (-> this (.getDesktopProperty property-name))))

(defn get-system-clipboard
  "Gets the singleton instance of the system Clipboard which interfaces
   with clipboard facilities provided by the native platform. This
   clipboard enables data transfer between Java programs and native
   applications which use native clipboard facilities.

   In addition to any and all formats specified in the flavormap.properties
   file, or other file specified by the AWT.DnD.flavorMapFileURL
    Toolkit property, text returned by the system Clipboard's
   getTransferData() method is available in the following flavors:

   DataFlavor.stringFlavor
   DataFlavor.plainTextFlavor (deprecated)

   As with java.awt.datatransfer.StringSelection, if the
   requested flavor is DataFlavor.plainTextFlavor, or an
   equivalent flavor, a Reader is returned. Note: The behavior of
   the system Clipboard's getTransferData() method for
   DataFlavor.plainTextFlavor, and equivalent DataFlavors, is
   inconsistent with the definition of DataFlavor.plainTextFlavor
   . Because of this, support for
   DataFlavor.plainTextFlavor, and equivalent flavors, is
   deprecated.

   Each actual implementation of this method should first check if there
   is a security manager installed. If there is, the method should call
   the security manager's checkPermission method to check AWTPermission(`accessClipboard`).

  returns: the system Clipboard - `java.awt.datatransfer.Clipboard`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Toolkit this]
    (-> this (.getSystemClipboard))))

(defn get-property-change-listeners
  "Returns an array of all property change listeners
   associated with the specified name of a desktop property.

  property-name - the named property - `java.lang.String`

  returns: all of the PropertyChangeListener objects
           associated with the specified name of a desktop property
           or an empty array if no such listeners are added - `java.beans.PropertyChangeListener[]`"
  ([^java.awt.Toolkit this ^java.lang.String property-name]
    (-> this (.getPropertyChangeListeners property-name)))
  ([^java.awt.Toolkit this]
    (-> this (.getPropertyChangeListeners))))

(defn modality-type-supported?
  "Returns whether the given modality type is supported by this toolkit. If
   a dialog with unsupported modality type is created, then
   Dialog.ModalityType.MODELESS is used instead.

  modality-type - modality type to be checked for support by this toolkit - `java.awt.Dialog.ModalityType`

  returns: true, if current toolkit supports given modality
       type, false otherwise - `boolean`"
  ([^java.awt.Toolkit this ^java.awt.Dialog.ModalityType modality-type]
    (-> this (.isModalityTypeSupported modality-type))))

(defn get-maximum-cursor-colors
  "Returns the maximum number of colors the Toolkit supports in a custom cursor
   palette.
   Note: if an image is used which has more colors in its palette than
   the supported maximum, the Toolkit implementation will attempt to flatten the
   palette to the maximum.  Since converting low-resolution images is difficult,
   no guarantees are made as to the quality of a cursor image which has more
   colors than the system supports.  It is therefore recommended that this method
   be called and an appropriate image used so no image conversion is made.

  returns: the maximum number of colors, or zero if custom cursors are not
   supported by this Toolkit implementation. - `int`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Toolkit this]
    (-> this (.getMaximumCursorColors))))

(defn get-awt-event-listeners
  "Returns an array of all the AWTEventListeners
   registered on this toolkit which listen to all of the event
   types specified in the eventMask argument.
   If there is a security manager, its checkPermission
   method is called with an
   AWTPermission(`listenToAllAWTEvents`) permission.
   This may result in a SecurityException.
   Listeners can be returned
   within AWTEventListenerProxy objects, which also contain
   the event mask for the given listener.
   Note that listener objects
   added multiple times appear only once in the returned array.

  event-mask - the bitmask of event types to listen for - `long`

  returns: all of the AWTEventListeners registered
           on this toolkit for the specified
           event types, or an empty array if no such listeners
           are currently registered - `java.awt.event.AWTEventListener[]`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow the operation."
  ([^java.awt.Toolkit this ^Long event-mask]
    (-> this (.getAWTEventListeners event-mask)))
  ([^java.awt.Toolkit this]
    (-> this (.getAWTEventListeners))))

(defn create-image
  "Creates an image which decodes the image stored in the specified
   byte array, and at the specified offset and length.
   The data must be in some image format, such as GIF or JPEG,
   that is supported by this toolkit.

  imagedata - an array of bytes, representing image data in a supported image format. - `byte[]`
  imageoffset - the offset of the beginning of the data in the array. - `int`
  imagelength - the length of the data in the array. - `int`

  returns: an image. - `java.awt.Image`"
  ([^java.awt.Toolkit this imagedata ^Integer imageoffset ^Integer imagelength]
    (-> this (.createImage imagedata imageoffset imagelength)))
  ([^java.awt.Toolkit this ^java.lang.String filename]
    (-> this (.createImage filename))))

(defn prepare-image
  "Prepares an image for rendering.

   If the values of the width and height arguments are both
   -1, this method prepares the image for rendering
   on the default screen; otherwise, this method prepares an image
   for rendering on the default screen at the specified width and height.

   The image data is downloaded asynchronously in another thread,
   and an appropriately scaled screen representation of the image is
   generated.

   This method is called by components prepareImage
   methods.

   Information on the flags returned by this method can be found
   with the definition of the ImageObserver interface.

  image - the image for which to prepare a screen representation. - `java.awt.Image`
  width - the width of the desired screen representation, or -1. - `int`
  height - the height of the desired screen representation, or -1. - `int`
  observer - the ImageObserver object to be notified as the image is being prepared. - `java.awt.image.ImageObserver`

  returns: true if the image has already been
                   fully prepared; false otherwise. - `boolean`"
  ([^java.awt.Toolkit this ^java.awt.Image image ^Integer width ^Integer height ^java.awt.image.ImageObserver observer]
    (-> this (.prepareImage image width height observer))))

(defn get-locking-key-state?
  "Returns whether the given locking key on the keyboard is currently in
   its `on` state.
   Valid key codes are
   VK_CAPS_LOCK,
   VK_NUM_LOCK,
   VK_SCROLL_LOCK, and
   VK_KANA_LOCK.

  key-code - `int`

  returns: `boolean`

  throws: java.lang.IllegalArgumentException - if keyCode is not one of the valid key codes"
  ([^java.awt.Toolkit this ^Integer key-code]
    (-> this (.getLockingKeyState key-code))))

(defn set-locking-key-state
  "Sets the state of the given locking key on the keyboard.
   Valid key codes are
   VK_CAPS_LOCK,
   VK_NUM_LOCK,
   VK_SCROLL_LOCK, and
   VK_KANA_LOCK.

   Depending on the platform, setting the state of a locking key may
   involve event processing and therefore may not be immediately
   observable through getLockingKeyState.

  key-code - `int`
  on - `boolean`

  throws: java.lang.IllegalArgumentException - if keyCode is not one of the valid key codes"
  ([^java.awt.Toolkit this ^Integer key-code ^Boolean on]
    (-> this (.setLockingKeyState key-code on))))

(defn always-on-top-supported?
  "Returns whether the always-on-top mode is supported by this toolkit.
   To detect whether the always-on-top mode is supported for a
   particular Window, use Window.isAlwaysOnTopSupported().

  returns: true, if current toolkit supports the always-on-top mode,
       otherwise returns false - `boolean`"
  ([^java.awt.Toolkit this]
    (-> this (.isAlwaysOnTopSupported))))

(defn add-property-change-listener
  "Adds the specified property change listener for the named desktop
   property. When a PropertyChangeListenerProxy object is added,
   its property name is ignored, and the wrapped listener is added.
   If name is null or pcl is null,
   no exception is thrown and no action is performed.

  name - The name of the property to listen for - `java.lang.String`
  pcl - The property change listener - `java.beans.PropertyChangeListener`"
  ([^java.awt.Toolkit this ^java.lang.String name ^java.beans.PropertyChangeListener pcl]
    (-> this (.addPropertyChangeListener name pcl))))

(defn get-screen-size
  "Gets the size of the screen.  On systems with multiple displays, the
   primary display is used.  Multi-screen aware display dimensions are
   available from GraphicsConfiguration and
   GraphicsDevice.

  returns: the size of this toolkit's screen, in pixels. - `java.awt.Dimension`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Toolkit this]
    (-> this (.getScreenSize))))

(defn get-color-model
  "Determines the color model of this toolkit's screen.

   ColorModel is an abstract class that
   encapsulates the ability to translate between the
   pixel values of an image and its red, green, blue,
   and alpha components.

   This toolkit method is called by the
   getColorModel method
   of the Component class.

  returns: the color model of this toolkit's screen. - `java.awt.image.ColorModel`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Toolkit this]
    (-> this (.getColorModel))))

