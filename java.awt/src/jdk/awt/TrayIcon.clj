(ns jdk.awt.TrayIcon
  "A TrayIcon object represents a tray icon that can be
  added to the system tray. A
  TrayIcon can have a tooltip (text), an image, a popup
  menu, and a set of listeners associated with it.

  A TrayIcon can generate various MouseEvents and supports adding corresponding listeners to receive
  notification of these events.  TrayIcon processes some
  of the events by itself.  For example, by default, when the
  right-mouse click is performed on the TrayIcon it
  displays the specified popup menu.  When the mouse hovers
  over the TrayIcon the tooltip is displayed.

  Note: When the MouseEvent is
  dispatched to its registered listeners its component
  property will be set to null.  (See ComponentEvent.getComponent()) The
  source property will be set to this
  TrayIcon. (See EventObject.getSource())

  Note: A well-behaved TrayIcon implementation
  will assign different gestures to showing a popup menu and
  selecting a tray icon.

  A TrayIcon can generate an ActionEvent.  On some platforms, this occurs when the user selects
  the tray icon using either the mouse or keyboard.

  If a SecurityManager is installed, the AWTPermission
  accessSystemTray must be granted in order to create
  a TrayIcon. Otherwise the constructor will throw a
  SecurityException.

   See the SystemTray class overview for an example on how
  to use the TrayIcon API."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt TrayIcon]))

(defn ->tray-icon
  "Constructor.

  Creates a TrayIcon with the specified image,
   tooltip and popup menu.

  image - the Image to be used - `java.awt.Image`
  tooltip - the string to be used as tooltip text; if the value is null no tooltip is shown - `java.lang.String`
  popup - the menu to be used for the tray icon's popup menu; if the value is null no popup menu is shown - `java.awt.PopupMenu`

  throws: java.lang.IllegalArgumentException - if image is null"
  ([^java.awt.Image image ^java.lang.String tooltip ^java.awt.PopupMenu popup]
    (new TrayIcon image tooltip popup))
  ([^java.awt.Image image ^java.lang.String tooltip]
    (new TrayIcon image tooltip))
  ([^java.awt.Image image]
    (new TrayIcon image)))

(defn get-image
  "Returns the current image used for this TrayIcon.

  returns: the image - `java.awt.Image`"
  ([^java.awt.TrayIcon this]
    (-> this (.getImage))))

(defn add-mouse-listener
  "Adds the specified mouse listener to receive mouse events from
   this TrayIcon.  Calling this method with a
   null value has no effect.

   Note: The MouseEvent's coordinates (received
   from the TrayIcon) are relative to the screen, not the
   TrayIcon.

    Note: The MOUSE_ENTERED and
   MOUSE_EXITED mouse events are not supported.
   Refer to AWT Threading Issues for details on AWT's threading model.

  listener - the mouse listener - `java.awt.event.MouseListener`"
  ([^java.awt.TrayIcon this ^java.awt.event.MouseListener listener]
    (-> this (.addMouseListener listener))))

(defn get-popup-menu
  "Returns the popup menu associated with this TrayIcon.

  returns: the popup menu or null if none exists - `java.awt.PopupMenu`"
  ([^java.awt.TrayIcon this]
    (-> this (.getPopupMenu))))

(defn add-mouse-motion-listener
  "Adds the specified mouse listener to receive mouse-motion
   events from this TrayIcon.  Calling this method
   with a null value has no effect.

   Note: The MouseEvent's coordinates (received
   from the TrayIcon) are relative to the screen, not the
   TrayIcon.

    Note: The MOUSE_DRAGGED mouse event is not supported.
   Refer to AWT Threading Issues for details on AWT's threading model.

  listener - the mouse listener - `java.awt.event.MouseMotionListener`"
  ([^java.awt.TrayIcon this ^java.awt.event.MouseMotionListener listener]
    (-> this (.addMouseMotionListener listener))))

(defn set-image
  "Sets the image for this TrayIcon.  The previous
   tray icon image is discarded without calling the Image.flush() method  you will need to call it
   manually.

    If the image represents an animated image, it will be
   animated automatically.

    See the setImageAutoSize(boolean) property for
   details on the size of the displayed image.

    Calling this method with the same image that is currently
   being used has no effect.

  image - the non-null Image to be used - `java.awt.Image`

  throws: java.lang.NullPointerException - if image is null"
  ([^java.awt.TrayIcon this ^java.awt.Image image]
    (-> this (.setImage image))))

(defn image-auto-size?
  "Returns the value of the auto-size property.

  returns: true if the image will be auto-sized,
   false otherwise - `boolean`"
  ([^java.awt.TrayIcon this]
    (-> this (.isImageAutoSize))))

(defn add-action-listener
  "Adds the specified action listener to receive
   ActionEvents from this TrayIcon.
   Action events usually occur when a user selects the tray icon,
   using either the mouse or keyboard.  The conditions in which
   action events are generated are platform-dependent.

   Calling this method with a null value has no
   effect.
   Refer to AWT Threading Issues for details on AWT's threading model.

  listener - the action listener - `java.awt.event.ActionListener`"
  ([^java.awt.TrayIcon this ^java.awt.event.ActionListener listener]
    (-> this (.addActionListener listener))))

(defn display-message
  "Displays a popup message near the tray icon.  The message will
   disappear after a time or if the user clicks on it.  Clicking
   on the message may trigger an ActionEvent.

   Either the caption or the text may be null, but an
   NullPointerException is thrown if both are
   null.

   When displayed, the caption or text strings may be truncated on
   some platforms; the number of characters that may be displayed is
   platform-dependent.

   Note: Some platforms may not support
   showing a message.

  caption - the caption displayed above the text, usually in bold; may be null - `java.lang.String`
  text - the text displayed for the particular message; may be null - `java.lang.String`
  message-type - an enum indicating the message type - `java.awt.TrayIcon.MessageType`

  throws: java.lang.NullPointerException - if both caption and text are null"
  ([^java.awt.TrayIcon this ^java.lang.String caption ^java.lang.String text ^java.awt.TrayIcon.MessageType message-type]
    (-> this (.displayMessage caption text message-type))))

(defn remove-mouse-motion-listener
  "Removes the specified mouse-motion listener.  Calling this method with
   null or an invalid value has no effect.
   Refer to AWT Threading Issues for details on AWT's threading model.

  listener - the mouse listener - `java.awt.event.MouseMotionListener`"
  ([^java.awt.TrayIcon this ^java.awt.event.MouseMotionListener listener]
    (-> this (.removeMouseMotionListener listener))))

(defn set-tool-tip
  "Sets the tooltip string for this TrayIcon. The
   tooltip is displayed automatically when the mouse hovers over
   the icon.  Setting the tooltip to null removes any
   tooltip text.

   When displayed, the tooltip string may be truncated on some platforms;
   the number of characters that may be displayed is platform-dependent.

  tooltip - the string for the tooltip; if the value is null no tooltip is shown - `java.lang.String`"
  ([^java.awt.TrayIcon this ^java.lang.String tooltip]
    (-> this (.setToolTip tooltip))))

(defn get-action-listeners
  "Returns an array of all the action listeners
   registered on this TrayIcon.

  returns: all of the ActionListeners registered on
   this TrayIcon or an empty array if no action
   listeners are currently registered - `java.awt.event.ActionListener[]`"
  ([^java.awt.TrayIcon this]
    (-> this (.getActionListeners))))

(defn remove-mouse-listener
  "Removes the specified mouse listener.  Calling this method with
   null or an invalid value has no effect.
   Refer to AWT Threading Issues for details on AWT's threading model.

  listener - the mouse listener - `java.awt.event.MouseListener`"
  ([^java.awt.TrayIcon this ^java.awt.event.MouseListener listener]
    (-> this (.removeMouseListener listener))))

(defn set-image-auto-size
  "Sets the auto-size property.  Auto-size determines whether the
   tray image is automatically sized to fit the space allocated
   for the image on the tray.  By default, the auto-size property
   is set to false.

    If auto-size is false, and the image size
   doesn't match the tray icon space, the image is painted as-is
   inside that space  if larger than the allocated space, it will
   be cropped.

    If auto-size is true, the image is stretched or shrunk to
   fit the tray icon space.

  autosize - true to auto-size the image, false otherwise - `boolean`"
  ([^java.awt.TrayIcon this ^Boolean autosize]
    (-> this (.setImageAutoSize autosize))))

(defn remove-action-listener
  "Removes the specified action listener.  Calling this method with
   null or an invalid value has no effect.
   Refer to AWT Threading Issues for details on AWT's threading model.

  listener - the action listener - `java.awt.event.ActionListener`"
  ([^java.awt.TrayIcon this ^java.awt.event.ActionListener listener]
    (-> this (.removeActionListener listener))))

(defn get-tool-tip
  "Returns the tooltip string associated with this
   TrayIcon.

  returns: the tooltip string or null if none exists - `java.lang.String`"
  ([^java.awt.TrayIcon this]
    (-> this (.getToolTip))))

(defn get-mouse-listeners
  "Returns an array of all the mouse listeners
   registered on this TrayIcon.

  returns: all of the MouseListeners registered on
   this TrayIcon or an empty array if no mouse
   listeners are currently registered - `java.awt.event.MouseListener[]`"
  ([^java.awt.TrayIcon this]
    (-> this (.getMouseListeners))))

(defn get-action-command
  "Returns the command name of the action event fired by this tray icon.

  returns: the action command name, or null if none exists - `java.lang.String`"
  ([^java.awt.TrayIcon this]
    (-> this (.getActionCommand))))

(defn set-popup-menu
  "Sets the popup menu for this TrayIcon.  If
   popup is null, no popup menu will be
   associated with this TrayIcon.

   Note that this popup must not be added to any
   parent before or after it is set on the tray icon.  If you add
   it to some parent, the popup may be removed from
   that parent.

   The popup can be set on one TrayIcon only.
   Setting the same popup on multiple TrayIcons will cause
   an IllegalArgumentException.

   Note: Some platforms may not support
   showing the user-specified popup menu component when the user
   right-clicks the tray icon.  In this situation, either no menu
   will be displayed or, on some systems, a native version of the
   menu may be displayed.

  popup - a PopupMenu or null to remove any popup menu - `java.awt.PopupMenu`

  throws: java.lang.IllegalArgumentException - if the popup is already set for another TrayIcon"
  ([^java.awt.TrayIcon this ^java.awt.PopupMenu popup]
    (-> this (.setPopupMenu popup))))

(defn get-size
  "Returns the size, in pixels, of the space that the tray icon
   occupies in the system tray.  For the tray icon that is not yet
   added to the system tray, the returned size is equal to the
   result of the SystemTray.getTrayIconSize().

  returns: the size of the tray icon, in pixels - `java.awt.Dimension`"
  ([^java.awt.TrayIcon this]
    (-> this (.getSize))))

(defn set-action-command
  "Sets the command name for the action event fired by this tray
   icon.  By default, this action command is set to
   null.

  command - a string used to set the tray icon's action command. - `java.lang.String`"
  ([^java.awt.TrayIcon this ^java.lang.String command]
    (-> this (.setActionCommand command))))

(defn get-mouse-motion-listeners
  "Returns an array of all the mouse-motion listeners
   registered on this TrayIcon.

  returns: all of the MouseInputListeners registered on
   this TrayIcon or an empty array if no mouse
   listeners are currently registered - `java.awt.event.MouseMotionListener[]`"
  ([^java.awt.TrayIcon this]
    (-> this (.getMouseMotionListeners))))

