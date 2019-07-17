(ns jdk.awt.im.InputContext
  "Provides methods to control text input facilities such as input
  methods and keyboard layouts.
  Two methods handle both input methods and keyboard layouts: selectInputMethod
  lets a client component select an input method or keyboard layout by locale,
  getLocale lets a client component obtain the locale of the current input method
  or keyboard layout.
  The other methods more specifically support interaction with input methods:
  They let client components control the behavior of input methods, and
  dispatch events from the client component to the input method.


  By default, one InputContext instance is created per Window instance,
  and this input context is shared by all components within the window's
  container hierarchy. However, this means that only one text input
  operation is possible at any one time within a window, and that the
  text needs to be committed when moving the focus from one text component
  to another. If this is not desired, text components can create their
  own input context instances.


  The Java Platform supports input methods that have been developed in the Java
  programming language, using the interfaces in the java.awt.im.spi package,
  and installed into a Java SE Runtime Environment as extensions. Implementations
  may also support using the native input methods of the platforms they run on;
  however, not all platforms and locales provide input methods. Keyboard layouts
  are provided by the host platform.


  Input methods are unavailable if (a) no input method written
  in the Java programming language has been installed and (b) the Java Platform implementation
  or the underlying platform does not support native input methods. In this case,
  input contexts can still be created and used; their behavior is specified with
  the individual methods below."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.im InputContext]))

(defn *get-instance
  "Returns a new InputContext instance.

  returns: `java.awt.im.InputContext`"
  ([]
    (InputContext/getInstance )))

(defn end-composition
  "Ends any input composition that may currently be going on in this
   context. Depending on the platform and possibly user preferences,
   this may commit or delete uncommitted text. Any changes to the text
   are communicated to the active component using an input method event.
   If no input methods are available, then this method has no effect.


   A text editing component may call this in a variety of situations,
   for example, when the user moves the insertion point within the text
   (but outside the composed text), or when the component's text is
   saved to a file or copied to the clipboard."
  ([^java.awt.im.InputContext this]
    (-> this (.endComposition))))

(defn reconvert
  "Asks the current input method to reconvert text from the
   current client component. The input method obtains the text to
   be reconverted from the client component using the
   InputMethodRequests.getSelectedText
   method. The other InputMethodRequests methods
   must be prepared to deal with further information requests by
   the input method. The composed and/or committed text will be
   sent to the client component as a sequence of
   InputMethodEvents. If the input method cannot
   reconvert the given text, the text is returned as committed
   text in an InputMethodEvent.

  throws: java.lang.UnsupportedOperationException - if there is no current input method available or the current input method does not support the reconversion operation."
  ([^java.awt.im.InputContext this]
    (-> this (.reconvert))))

(defn dispose
  "Releases the resources used by this input context.
   Called by AWT for the default input context of each Window.
   If no input methods are available, then this method
   has no effect."
  ([^java.awt.im.InputContext this]
    (-> this (.dispose))))

(defn get-locale
  "Returns the current locale of the current input method or keyboard
   layout.
   Returns null if the input context does not have a current input method
   or keyboard layout or if the current input method's
   InputMethod.getLocale() method returns null.


   Not all host operating systems provide API to determine the locale of
   the currently selected native input method or keyboard layout.
   For host operating systems that don't provide such API,
   getLocale assumes that the current locale of all native
   input methods or keyboard layouts provided by the host operating system
   is the system's default locale.

  returns: the current locale of the current input method or keyboard layout - `java.util.Locale`"
  ([^java.awt.im.InputContext this]
    (-> this (.getLocale))))

(defn select-input-method
  "Attempts to select an input method or keyboard layout that
   supports the given locale, and returns a value indicating whether such
   an input method or keyboard layout has been successfully selected. The
   following steps are taken until an input method has been selected:



   If the currently selected input method or keyboard layout supports the
   requested locale, it remains selected.


   If there is no input method or keyboard layout available that supports
   the requested locale, the current input method or keyboard layout remains
   selected.


   If the user has previously selected an input method or keyboard layout
   for the requested locale from the user interface, then the most recently
   selected such input method or keyboard layout is reselected.


   Otherwise, an input method or keyboard layout that supports the requested
   locale is selected in an implementation dependent way.


   Before switching away from an input method, any currently uncommitted text
   is committed. If no input method or keyboard layout supporting the requested
   locale is available, then false is returned.


   Not all host operating systems provide API to determine the locale of
   the currently selected native input method or keyboard layout, and to
   select a native input method or keyboard layout by locale.
   For host operating systems that don't provide such API,
   selectInputMethod assumes that native input methods or
   keyboard layouts provided by the host operating system support only the
   system's default locale.


   A text editing component may call this method, for example, when
   the user changes the insertion point, so that the user can
   immediately continue typing in the language of the surrounding text.

  locale - The desired new locale. - `java.util.Locale`

  returns: true if the input method or keyboard layout that's active after
           this call supports the desired locale. - `boolean`

  throws: java.lang.NullPointerException - if locale is null"
  ([^java.awt.im.InputContext this ^java.util.Locale locale]
    (-> this (.selectInputMethod locale))))

(defn get-input-method-control-object
  "Returns a control object from the current input method, or null. A
   control object provides methods that control the behavior of the
   input method or obtain information from the input method. The type
   of the object is an input method specific class. Clients have to
   compare the result against known input method control object
   classes and cast to the appropriate class to invoke the methods
   provided.

   If no input methods are available or the current input method does
   not provide an input method control object, then null is returned.

  returns: A control object from the current input method, or null. - `java.lang.Object`"
  ([^java.awt.im.InputContext this]
    (-> this (.getInputMethodControlObject))))

(defn remove-notify
  "Notifies the input context that a client component has been
   removed from its containment hierarchy, or that input method
   support has been disabled for the component. This method is
   usually called from the client component's
   Component.removeNotify
   method. Potentially pending input from input methods
   for this component is discarded.
   If no input methods are available, then this method has no effect.

  client - Client component - `java.awt.Component`

  throws: java.lang.NullPointerException - if client is null"
  ([^java.awt.im.InputContext this ^java.awt.Component client]
    (-> this (.removeNotify client))))

(defn composition-enabled?
  "Determines whether the current input method is enabled for composition.
   An input method that is enabled for composition interprets incoming
   events for both composition and control purposes, while a
   disabled input method does not interpret events for composition.

  returns: true if the current input method is enabled for
   composition; false otherwise - `boolean`

  throws: java.lang.UnsupportedOperationException - if there is no current input method available or the current input method does not support checking whether it is enabled for composition"
  ([^java.awt.im.InputContext this]
    (-> this (.isCompositionEnabled))))

(defn dispatch-event
  "Dispatches an event to the active input method. Called by AWT.
   If no input method is available, then the event will never be consumed.

  event - The event - `java.awt.AWTEvent`

  throws: java.lang.NullPointerException - if event is null"
  ([^java.awt.im.InputContext this ^java.awt.AWTEvent event]
    (-> this (.dispatchEvent event))))

(defn set-character-subsets
  "Sets the subsets of the Unicode character set that input methods of this input
   context should be allowed to input. Null may be passed in to
   indicate that all characters are allowed. The initial value
   is null. The setting applies to the current input method as well
   as input methods selected after this call is made. However,
   applications cannot rely on this call having the desired effect,
   since this setting cannot be passed on to all host input methods -
   applications still need to apply their own character validation.
   If no input methods are available, then this method has no effect.

  subsets - The subsets of the Unicode character set from which characters may be input - `java.lang.Character.Subset[]`"
  ([^java.awt.im.InputContext this ^java.lang.Character.Subset[] subsets]
    (-> this (.setCharacterSubsets subsets))))

(defn set-composition-enabled
  "Enables or disables the current input method for composition,
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

  enable - whether to enable the current input method for composition - `boolean`

  throws: java.lang.UnsupportedOperationException - if there is no current input method available or the current input method does not support the enabling/disabling operation"
  ([^java.awt.im.InputContext this ^Boolean enable]
    (-> this (.setCompositionEnabled enable))))

