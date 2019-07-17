(ns jdk.awt.im.spi.InputMethod
  "Defines the interface for an input method that supports complex text input.
  Input methods traditionally support text input for languages that have
  more characters than can be represented on a standard-size keyboard,
  such as Chinese, Japanese, and Korean. However, they may also be used to
  support phonetic text input for English or character reordering for Thai.

  Subclasses of InputMethod can be loaded by the input method framework; they
  can then be selected either through the API
  (InputContext.selectInputMethod)
  or the user interface (the input method selection menu)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.im.spi InputMethod]))

(defn end-composition
  "Ends any input composition that may currently be going on in this
   context. Depending on the platform and possibly user preferences,
   this may commit or delete uncommitted text. Any changes to the text
   are communicated to the active component using an input method event.


   A text editing component may call this in a variety of situations,
   for example, when the user moves the insertion point within the text
   (but outside the composed text), or when the component's text is
   saved to a file or copied to the clipboard.

   This method is called

   by InputContext.endComposition,
   by InputContext.dispatchEvent
       when switching to a different client component
   when switching from this input method to a different one using the
       user interface or
       InputContext.selectInputMethod."
  ([^java.awt.im.spi.InputMethod this]
    (-> this (.endComposition))))

(defn reconvert
  "Starts the reconversion operation. The input method obtains the
   text to be reconverted from the current client component using the
   InputMethodRequests.getSelectedText
   method. It can use other InputMethodRequests
   methods to request additional information required for the
   reconversion operation. The composed and committed text
   produced by the operation is sent to the client component as a
   sequence of InputMethodEvents. If the given text
   cannot be reconverted, the same text should be sent to the
   client component as committed text.

   This method is called by
   InputContext.reconvert.

  throws: java.lang.UnsupportedOperationException - if the input method does not support the reconversion operation."
  ([^java.awt.im.spi.InputMethod this]
    (-> this (.reconvert))))

(defn activate
  "Activates the input method for immediate input processing.

   If an input method provides its own windows, it should make sure
   at this point that all necessary windows are open and visible.

   This method is called

   by InputContext.dispatchEvent
       when a client component receives a FOCUS_GAINED event,
   when switching to this input method from a different one using the
       user interface or
       InputContext.selectInputMethod.

   The method is only called when the input method is inactive.
   A newly instantiated input method is assumed to be inactive."
  ([^java.awt.im.spi.InputMethod this]
    (-> this (.activate))))

(defn set-input-method-context
  "Sets the input method context, which is used to dispatch input method
   events to the client component and to request information from
   the client component.

   This method is called once immediately after instantiating this input
   method.

  context - the input method context for this input method - `java.awt.im.spi.InputMethodContext`

  throws: java.lang.NullPointerException - if context is null"
  ([^java.awt.im.spi.InputMethod this ^java.awt.im.spi.InputMethodContext context]
    (-> this (.setInputMethodContext context))))

(defn dispose
  "Releases the resources used by this input method.
   In particular, the input method should dispose windows and close files that are no
   longer needed.

   This method is called by InputContext.dispose.

   The method is only called when the input method is inactive.
   No method of this interface is called on this instance after dispose."
  ([^java.awt.im.spi.InputMethod this]
    (-> this (.dispose))))

(defn get-locale
  "Returns the current input locale. Might return null in exceptional cases.

   This method is called

   by InputContext.getLocale and
   when switching from this input method to a different one through the
       user interface.

  returns: the current input locale, or null - `java.util.Locale`"
  (^java.util.Locale [^java.awt.im.spi.InputMethod this]
    (-> this (.getLocale))))

(defn hide-windows
  "Closes or hides all windows opened by this input method instance or
   its class.

   This method is called

   before calling activate on an instance of a different input
       method class,
   before calling dispose on this input method.

   The method is only called when the input method is inactive."
  ([^java.awt.im.spi.InputMethod this]
    (-> this (.hideWindows))))

(defn deactivate
  "Deactivates the input method.
   The isTemporary argument has the same meaning as in
   FocusEvent.isTemporary.

   If an input method provides its own windows, only windows that relate
   to the current composition (such as a lookup choice window) should be
   closed at this point.
   It is possible that the input method will be immediately activated again
   for a different client component, and closing and reopening more
   persistent windows (such as a control panel) would create unnecessary
   screen flicker.
   Before an instance of a different input method class is activated,
   hideWindows() is called on the current input method.

   This method is called

   by InputContext.dispatchEvent
       when a client component receives a FOCUS_LOST event,
   when switching from this input method to a different one using the
       user interface or
       InputContext.selectInputMethod,
   before removeNotify if the current client component is
       removed.

   The method is only called when the input method is active.

  is-temporary - whether the focus change is temporary - `boolean`"
  ([^java.awt.im.spi.InputMethod this ^Boolean is-temporary]
    (-> this (.deactivate is-temporary))))

(defn remove-notify
  "Notifies the input method that a client component has been
   removed from its containment hierarchy, or that input method
   support has been disabled for the component.

   This method is called by InputContext.removeNotify.

   The method is only called when the input method is inactive."
  ([^java.awt.im.spi.InputMethod this]
    (-> this (.removeNotify))))

(defn composition-enabled?
  "Determines whether this input method is enabled.
   An input method that is enabled for composition interprets incoming
   events for both composition and control purposes, while a
   disabled input method does not interpret events for composition.

   This method is called

   by InputContext.isCompositionEnabled and
   when switching from this input method to a different one using the
       user interface or
       InputContext.selectInputMethod.

  returns: true if this input method is enabled for
   composition; false otherwise. - `boolean`

  throws: java.lang.UnsupportedOperationException - if this input method does not support checking whether it is enabled for composition"
  (^Boolean [^java.awt.im.spi.InputMethod this]
    (-> this (.isCompositionEnabled))))

(defn set-locale
  "Attempts to set the input locale. If the input method supports the
   desired locale, it changes its behavior to support input for the locale
   and returns true.
   Otherwise, it returns false and does not change its behavior.

   This method is called

   by InputContext.selectInputMethod,
   when switching to this input method through the user interface if the user
       specified a locale or if the previously selected input method's
       getLocale method
       returns a non-null value.

  locale - locale to input - `java.util.Locale`

  returns: whether the specified locale is supported - `boolean`

  throws: java.lang.NullPointerException - if locale is null"
  (^Boolean [^java.awt.im.spi.InputMethod this ^java.util.Locale locale]
    (-> this (.setLocale locale))))

(defn get-control-object
  "Returns a control object from this input method, or null. A
   control object provides methods that control the behavior of the
   input method or obtain information from the input method. The type
   of the object is an input method specific class. Clients have to
   compare the result against known input method control object
   classes and cast to the appropriate class to invoke the methods
   provided.

   This method is called by
   InputContext.getInputMethodControlObject.

  returns: a control object from this input method, or null - `java.lang.Object`"
  (^java.lang.Object [^java.awt.im.spi.InputMethod this]
    (-> this (.getControlObject))))

(defn dispatch-event
  "Dispatches the event to the input method. If input method support is
   enabled for the focussed component, incoming events of certain types
   are dispatched to the current input method for this component before
   they are dispatched to the component's methods or event listeners.
   The input method decides whether it needs to handle the event. If it
   does, it also calls the event's consume method; this
   causes the event to not get dispatched to the component's event
   processing methods or event listeners.

   Events are dispatched if they are instances of InputEvent or its
   subclasses.
   This includes instances of the AWT classes KeyEvent and MouseEvent.

   This method is called by InputContext.dispatchEvent.

  event - the event being dispatched to the input method - `java.awt.AWTEvent`

  throws: java.lang.NullPointerException - if event is null"
  ([^java.awt.im.spi.InputMethod this ^java.awt.AWTEvent event]
    (-> this (.dispatchEvent event))))

(defn set-character-subsets
  "Sets the subsets of the Unicode character set that this input method
   is allowed to input. Null may be passed in to indicate that all
   characters are allowed.

   This method is called

   immediately after instantiating this input method,
   when switching to this input method from a different one, and
   by InputContext.setCharacterSubsets.

  subsets - the subsets of the Unicode character set from which characters may be input - `java.lang.Character.Subset[]`"
  ([^java.awt.im.spi.InputMethod this subsets]
    (-> this (.setCharacterSubsets subsets))))

(defn set-composition-enabled
  "Enables or disables this input method for composition,
   depending on the value of the parameter enable.

   An input method that is enabled for composition interprets incoming
   events for both composition and control purposes, while a
   disabled input method does not interpret events for composition.
   Note however that events are passed on to the input method regardless
   whether it is enabled or not, and that an input method that is disabled
   for composition may still interpret events for control purposes,
   including to enable or disable itself for composition.

   For input methods provided by host operating systems, it is not always possible to
   determine whether this operation is supported. For example, an input method may enable
   composition only for some locales, and do nothing for other locales. For such input
   methods, it is possible that this method does not throw
   UnsupportedOperationException,
   but also does not affect whether composition is enabled.

   This method is called

   by InputContext.setCompositionEnabled,
   when switching to this input method from a different one using the
       user interface or
       InputContext.selectInputMethod,
       if the previously selected input method's
       isCompositionEnabled
       method returns without throwing an exception.

  enable - whether to enable the input method for composition - `boolean`

  throws: java.lang.UnsupportedOperationException - if this input method does not support the enabling/disabling operation"
  ([^java.awt.im.spi.InputMethod this ^Boolean enable]
    (-> this (.setCompositionEnabled enable))))

(defn notify-client-window-change
  "Notifies this input method of changes in the client window
   location or state. This method is called while this input
   method is the current input method of its input context and
   notifications for it are enabled (see InputMethodContext.enableClientWindowNotification). Calls
   to this method are temporarily suspended if the input context's
   removeNotify
   method is called, and resume when the input method is activated
   for a new client component. It is called in the following
   situations:


   when the window containing the current client component changes
   in location, size, visibility, iconification state, or when the
   window is closed.

   from  enableClientWindowNotification(inputMethod,
   true) if the current client component exists,

   when activating the input method for the first time after it
   called
   enableClientWindowNotification(inputMethod,
   true) if during the call no current client component was
   available,

   when activating the input method for a new client component
   after the input context's removeNotify method has been
   called.

  bounds - client window's bounds on the screen; or null if the client window is iconified or invisible - `java.awt.Rectangle`"
  ([^java.awt.im.spi.InputMethod this ^java.awt.Rectangle bounds]
    (-> this (.notifyClientWindowChange bounds))))

