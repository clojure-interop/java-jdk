(ns jdk.awt.Dialog
  "A Dialog is a top-level window with a title and a border
  that is typically used to take some form of input from the user.

  The size of the dialog includes any area designated for the
  border.  The dimensions of the border area can be obtained
  using the getInsets method, however, since
  these dimensions are platform-dependent, a valid insets
  value cannot be obtained until the dialog is made displayable
  by either calling pack or show.
  Since the border area is included in the overall size of the
  dialog, the border effectively obscures a portion of the dialog,
  constraining the area available for rendering and/or displaying
  subcomponents to the rectangle which has an upper-left corner
  location of (insets.left, insets.top), and has a size of
  width - (insets.left  insets.right) by
  height - (insets.top  insets.bottom).

  The default layout for a dialog is BorderLayout.

  A dialog may have its native decorations (i.e. Frame & Titlebar) turned off
  with setUndecorated.  This can only be done while the dialog
  is not displayable.

  A dialog may have another window as its owner when it's constructed.  When
  the owner window of a visible dialog is minimized, the dialog will
  automatically be hidden from the user. When the owner window is subsequently
  restored, the dialog is made visible to the user again.

  In a multi-screen environment, you can create a Dialog
  on a different screen device than its owner.  See Frame for
  more information.

  A dialog can be either modeless (the default) or modal.  A modal
  dialog is one which blocks input to some other top-level windows
  in the application, except for any windows created with the dialog
  as their owner. See AWT Modality
  specification for details.

  Dialogs are capable of generating the following
  WindowEvents:
  WindowOpened, WindowClosing,
  WindowClosed, WindowActivated,
  WindowDeactivated, WindowGainedFocus,
  WindowLostFocus."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Dialog]))

(defn ->dialog
  "Constructor.

  Constructs an initially invisible Dialog with the specified owner
   Frame, title, modality, and GraphicsConfiguration.

  owner - the owner of the dialog or null if this dialog has no owner - `java.awt.Frame`
  title - the title of the dialog or null if this dialog has no title - `java.lang.String`
  modal - specifies whether dialog blocks user input to other top-level windows when shown. If false, the dialog is MODELESS; if true, the modality type property is set to DEFAULT_MODALITY_TYPE - `boolean`
  gc - the GraphicsConfiguration of the target screen device; if null, the default system GraphicsConfiguration is assumed - `java.awt.GraphicsConfiguration`

  throws: java.lang.IllegalArgumentException - if gc is not from a screen device"
  ([^java.awt.Frame owner ^java.lang.String title ^Boolean modal ^java.awt.GraphicsConfiguration gc]
    (new Dialog owner title modal gc))
  ([^java.awt.Frame owner ^java.lang.String title ^Boolean modal]
    (new Dialog owner title modal))
  ([^java.awt.Frame owner ^Boolean modal]
    (new Dialog owner modal))
  ([^java.awt.Frame owner]
    (new Dialog owner)))

(def *-default-modality-type
  "Static Constant.

  Default modality type for modal dialogs. The default modality type is
   APPLICATION_MODAL. Calling the oldstyle setModal(true)
   is equal to setModalityType(DEFAULT_MODALITY_TYPE).

  type: java.awt.Dialog.ModalityType"
  Dialog/DEFAULT_MODALITY_TYPE)

(defn hide
  "Deprecated. As of JDK version 1.5, replaced by
   setVisible(boolean).

  returns: `java.lang.  void`"
  ([^java.awt.Dialog this]
    (-> this (.hide))))

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
   and setUndecorated(boolean))
   The window must not be in full-screen mode (see GraphicsDevice.setFullScreenWindow(Window))


   If the requested shape is not null, and any of the above
   conditions are not met, the shape of this window will not change,
   and either the UnsupportedOperationException or IllegalComponentStateException will be thrown.

   The translucency levels of individual pixels may also be effected by the
   alpha component of their color (see Window.setBackground(Color)) and the
   opacity value (see Window.setOpacity(float)). See GraphicsDevice.WindowTranslucency for more details.

  shape - the shape to set to the window - `java.awt.Shape`"
  ([^java.awt.Dialog this ^java.awt.Shape shape]
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
   The window must be undecorated (see Frame.setUndecorated(boolean)
   and setUndecorated(boolean))
   The window must not be in full-screen mode (see GraphicsDevice.setFullScreenWindow(Window))


   If the requested opacity value is less than 1.0f, and any of the
   above conditions are not met, the window opacity will not change,
   and the IllegalComponentStateException will be thrown.

   The translucency levels of individual pixels may also be effected by the
   alpha component of their color (see Window.setBackground(Color)) and the
   current shape of this window (see Window.setShape(Shape)).

  opacity - the opacity level to set to the window - `float`"
  ([^java.awt.Dialog this ^Float opacity]
    (-> this (.setOpacity opacity))))

(defn modal?
  "Indicates whether the dialog is modal.

   This method is obsolete and is kept for backwards compatibility only.
   Use getModalityType() instead.

  returns: true if this dialog window is modal;
              false otherwise - `boolean`"
  (^Boolean [^java.awt.Dialog this]
    (-> this (.isModal))))

(defn get-modality-type
  "Returns the modality type of this dialog.

  returns: modality type of this dialog - `java.awt.Dialog.ModalityType`"
  (^java.awt.Dialog.ModalityType [^java.awt.Dialog this]
    (-> this (.getModalityType))))

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
   and setUndecorated(boolean))
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
  ([^java.awt.Dialog this ^java.awt.Color bg-color]
    (-> this (.setBackground bg-color))))

(defn undecorated?
  "Indicates whether this dialog is undecorated.
   By default, all dialogs are initially decorated.

  returns: true if dialog is undecorated;
                          false otherwise. - `boolean`"
  (^Boolean [^java.awt.Dialog this]
    (-> this (.isUndecorated))))

(defn add-notify
  "Makes this Dialog displayable by connecting it to
   a native screen resource.  Making a dialog displayable will
   cause any of its children to be made displayable.
   This method is called internally by the toolkit and should
   not be called directly by programs."
  ([^java.awt.Dialog this]
    (-> this (.addNotify))))

(defn show
  "Deprecated. As of JDK version 1.5, replaced by
   setVisible(boolean).

  returns: `java.lang.  void`"
  ([^java.awt.Dialog this]
    (-> this (.show))))

(defn resizable?
  "Indicates whether this dialog is resizable by the user.
   By default, all dialogs are initially resizable.

  returns: true if the user can resize the dialog;
              false otherwise. - `boolean`"
  (^Boolean [^java.awt.Dialog this]
    (-> this (.isResizable))))

(defn set-modality-type
  "Sets the modality type for this dialog. See ModalityType for possible modality types.

   If the given modality type is not supported, MODELESS
   is used. You may want to call getModalityType() after calling
   this method to ensure that the modality type has been set.

   Note: changing modality of the visible dialog may have no effect
   until it is hidden and then shown again.

  type - specifies whether dialog blocks input to other windows when shown. null value and unsupported modality types are equivalent to MODELESS - `java.awt.Dialog.ModalityType`

  throws: java.lang.SecurityException - if the calling thread does not have permission to create modal dialogs with the given modalityType"
  ([^java.awt.Dialog this ^java.awt.Dialog.ModalityType type]
    (-> this (.setModalityType type))))

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
   and active Windows unchanged.

   If this dialog is modal and blocks some windows, then all of them are
   also sent to the back to keep them below the blocking dialog."
  ([^java.awt.Dialog this]
    (-> this (.toBack))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this Dialog.
   For dialogs, the AccessibleContext takes the form of an
   AccessibleAWTDialog.
   A new AccessibleAWTDialog instance is created if necessary.

  returns: an AccessibleAWTDialog that serves as the
           AccessibleContext of this Dialog - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^java.awt.Dialog this]
    (-> this (.getAccessibleContext))))

(defn set-visible
  "Shows or hides this Dialog depending on the value of parameter
   b.

  b - if true, makes the Dialog visible, otherwise hides the Dialog. If the dialog and/or its owner are not yet displayable, both are made displayable. The dialog will be validated prior to being made visible. If false, hides the Dialog and then causes setVisible(true) to return if it is currently blocked. Notes for modal dialogs. setVisible(true): If the dialog is not already visible, this call will not return until the dialog is hidden by calling setVisible(false) or dispose. setVisible(false): Hides the dialog and then returns on setVisible(true) if it is currently blocked. It is OK to call this method from the event dispatching thread because the toolkit ensures that other events are not blocked while this method is blocked. - `boolean`"
  ([^java.awt.Dialog this ^Boolean b]
    (-> this (.setVisible b))))

(defn set-undecorated
  "Disables or enables decorations for this dialog.

   This method can only be called while the dialog is not displayable. To
   make this dialog decorated, it must be opaque and have the default shape,
   otherwise the IllegalComponentStateException will be thrown.
   Refer to Window.setShape(java.awt.Shape), Window.setOpacity(float) and Window.setBackground(java.awt.Color) for details

  undecorated - true if no dialog decorations are to be enabled; false if dialog decorations are to be enabled - `boolean`

  throws: java.awt.IllegalComponentStateException - if undecorated is false, and the alpha value of this dialog background color is less than 1.0f"
  ([^java.awt.Dialog this ^Boolean undecorated]
    (-> this (.setUndecorated undecorated))))

(defn set-modal
  "Specifies whether this dialog should be modal.

   This method is obsolete and is kept for backwards compatibility only.
   Use setModalityType() instead.

   Note: changing modality of the visible dialog may have no effect
   until it is hidden and then shown again.

  modal - specifies whether dialog blocks input to other windows when shown; calling to setModal(true) is equivalent to setModalityType(Dialog.DEFAULT_MODALITY_TYPE), and calling to setModal(false) is equvivalent to setModalityType(Dialog.ModalityType.MODELESS) - `boolean`"
  ([^java.awt.Dialog this ^Boolean modal]
    (-> this (.setModal modal))))

(defn set-resizable
  "Sets whether this dialog is resizable by the user.

  resizable - true if the user can resize this dialog; false otherwise. - `boolean`"
  ([^java.awt.Dialog this ^Boolean resizable]
    (-> this (.setResizable resizable))))

(defn get-title
  "Gets the title of the dialog. The title is displayed in the
   dialog's border.

  returns: the title of this dialog window. The title may be
              null. - `java.lang.String`"
  (^java.lang.String [^java.awt.Dialog this]
    (-> this (.getTitle))))

(defn set-title
  "Sets the title of the Dialog.

  title - the title displayed in the dialog's border; a null value results in an empty title - `java.lang.String`"
  ([^java.awt.Dialog this ^java.lang.String title]
    (-> this (.setTitle title))))

