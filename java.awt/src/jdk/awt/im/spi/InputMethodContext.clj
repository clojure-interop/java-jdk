(ns jdk.awt.im.spi.InputMethodContext
  "Provides methods that input methods
  can use to communicate with their client components or to request
  other services.  This interface is implemented by the input method
  framework, and input methods call its methods on the instance they
  receive through
  InputMethod.setInputMethodContext(java.awt.im.spi.InputMethodContext).
  There should be no other implementors or callers."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.im.spi InputMethodContext]))

(defn dispatch-input-method-event
  "Creates an input method event from the arguments given
   and dispatches it to the client component. For arguments,
   see InputMethodEvent.InputMethodEvent(java.awt.Component, int, java.awt.font.TextHitInfo, java.awt.font.TextHitInfo).

  id - `int`
  text - `java.text.AttributedCharacterIterator`
  committed-character-count - `int`
  caret - `java.awt.font.TextHitInfo`
  visible-position - `java.awt.font.TextHitInfo`"
  ([^InputMethodContext this ^Integer id ^java.text.AttributedCharacterIterator text ^Integer committed-character-count ^java.awt.font.TextHitInfo caret ^java.awt.font.TextHitInfo visible-position]
    (-> this (.dispatchInputMethodEvent id text committed-character-count caret visible-position))))

(defn create-input-method-window
  "Creates a top-level window for use by the input method.
   The intended behavior of this window is:

   it floats above all document windows and dialogs
   it and all components that it contains do not receive the focus
   it has lightweight decorations, such as a reduced drag region without title

   However, the actual behavior with respect to these three items is platform dependent.

   The title may or may not be displayed, depending on the actual type of window created.

   If attachToInputContext is true, the new window will share the input context that
   corresponds to this input method context, so that events for components in the window
   are automatically dispatched to the input method.
   Also, when the window is opened using setVisible(true), the input context will prevent
   deactivate and activate calls to the input method that might otherwise be caused.

   Input methods must call Window.dispose on the
   returned input method window when it is no longer needed.

  title - the title to be displayed in the window's title bar, if there is such a title bar. A null value is treated as an empty string, \"\". - `java.lang.String`
  attach-to-input-context - whether this window should share the input context that corresponds to this input method context - `boolean`

  returns: a window with special characteristics for use by input methods - `java.awt.Window`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  (^java.awt.Window [^InputMethodContext this ^java.lang.String title ^Boolean attach-to-input-context]
    (-> this (.createInputMethodWindow title attach-to-input-context))))

(defn create-input-method-j-frame
  "Creates a top-level Swing JFrame for use by the input method.
   The intended behavior of this window is:

   it floats above all document windows and dialogs
   it and all components that it contains do not receive the focus
   it has lightweight decorations, such as a reduced drag region without title

   However, the actual behavior with respect to these three items is platform dependent.

   The title may or may not be displayed, depending on the actual type of window created.

   If attachToInputContext is true, the new window will share the input context that
   corresponds to this input method context, so that events for components in the window
   are automatically dispatched to the input method.
   Also, when the window is opened using setVisible(true), the input context will prevent
   deactivate and activate calls to the input method that might otherwise be caused.

   Input methods must call Window.dispose on the
   returned input method window when it is no longer needed.

  title - the title to be displayed in the window's title bar, if there is such a title bar. A null value is treated as an empty string, \"\". - `java.lang.String`
  attach-to-input-context - whether this window should share the input context that corresponds to this input method context - `boolean`

  returns: a JFrame with special characteristics for use by input methods - `javax.swing.JFrame`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  (^javax.swing.JFrame [^InputMethodContext this ^java.lang.String title ^Boolean attach-to-input-context]
    (-> this (.createInputMethodJFrame title attach-to-input-context))))

(defn enable-client-window-notification
  "Enables or disables notification of the current client window's
   location and state for the specified input method. When
   notification is enabled, the input method's notifyClientWindowChange method is called as described in that
   method's specification. Notification is automatically disabled
   when the input method is disposed.

  input-method - the input method for which notifications are enabled or disabled - `java.awt.im.spi.InputMethod`
  enable - true to enable, false to disable - `boolean`"
  ([^InputMethodContext this ^java.awt.im.spi.InputMethod input-method ^Boolean enable]
    (-> this (.enableClientWindowNotification input-method enable))))

