(ns jdk.awt.TextComponent
  "The TextComponent class is the superclass of
  any component that allows the editing of some text.

  A text component embodies a string of text.  The
  TextComponent class defines a set of methods
  that determine whether or not this text is editable. If the
  component is editable, it defines another set of methods
  that supports a text insertion caret.

  In addition, the class defines methods that are used
  to maintain a current selection from the text.
  The text selection, a substring of the component's text,
  is the target of editing operations. It is also referred
  to as the selected text."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt TextComponent]))

(defn get-selected-text
  "Returns the selected text from the text that is
   presented by this text component.

  returns: the selected text of this text component - `java.lang.String`"
  (^java.lang.String [^TextComponent this]
    (-> this (.getSelectedText))))

(defn set-text
  "Sets the text that is presented by this
   text component to be the specified text.

  t - the new text; if this parameter is null then the text is set to the empty string \"\" - `java.lang.String`"
  ([^TextComponent this ^java.lang.String t]
    (-> this (.setText t))))

(defn add-text-listener
  "Adds the specified text event listener to receive text events
   from this text component.
   If l is null, no exception is
   thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the text event listener - `java.awt.event.TextListener`"
  ([^TextComponent this ^java.awt.event.TextListener l]
    (-> this (.addTextListener l))))

(defn get-text
  "Returns the text that is presented by this text component.
   By default, this is an empty string.

  returns: the value of this TextComponent - `java.lang.String`"
  (^java.lang.String [^TextComponent this]
    (-> this (.getText))))

(defn select-all
  "Selects all the text in this text component."
  ([^TextComponent this]
    (-> this (.selectAll))))

(defn get-selection-start
  "Gets the start position of the selected text in
   this text component.

  returns: the start position of the selected text - `int`"
  (^Integer [^TextComponent this]
    (-> this (.getSelectionStart))))

(defn enable-input-methods
  "Enables or disables input method support for this text component. If input
   method support is enabled and the text component also processes key events,
   incoming events are offered to the current input method and will only be
   processed by the component or dispatched to its listeners if the input method
   does not consume them. Whether and how input method support for this text
   component is enabled or disabled by default is implementation dependent.

  enable - true to enable, false to disable - `boolean`"
  ([^TextComponent this ^Boolean enable]
    (-> this (.enableInputMethods enable))))

(defn set-caret-position
  "Sets the position of the text insertion caret.
   The caret position is constrained to be between 0
   and the last character of the text, inclusive.
   If the passed-in value is greater than this range,
   the value is set to the last character (or 0 if
   the TextComponent contains no text)
   and no error is returned.  If the passed-in value is
   less than 0, an IllegalArgumentException
   is thrown.

  position - the position of the text insertion caret - `int`

  throws: java.lang.IllegalArgumentException - if position is less than zero"
  ([^TextComponent this ^Integer position]
    (-> this (.setCaretPosition position))))

(defn set-background
  "Sets the background color of this text component.

  c - The color to become this text component's color. If this parameter is null then this text component will inherit the background color of its parent. - `java.awt.Color`"
  ([^TextComponent this ^java.awt.Color c]
    (-> this (.setBackground c))))

(defn add-notify
  "Makes this Component displayable by connecting it to a
   native screen resource.
   This method is called internally by the toolkit and should
   not be called directly by programs."
  ([^TextComponent this]
    (-> this (.addNotify))))

(defn editable?
  "Indicates whether or not this text component is editable.

  returns: true if this text component is
                    editable; false otherwise. - `boolean`"
  (^Boolean [^TextComponent this]
    (-> this (.isEditable))))

(defn get-caret-position
  "Returns the position of the text insertion caret.
   The caret position is constrained to be between 0
   and the last character of the text, inclusive.
   If the text or caret have not been set, the default
   caret position is 0.

  returns: the position of the text insertion caret - `int`"
  (^Integer [^TextComponent this]
    (-> this (.getCaretPosition))))

(defn remove-notify
  "Removes the TextComponent's peer.
   The peer allows us to modify the appearance of the
   TextComponent without changing its
   functionality."
  ([^TextComponent this]
    (-> this (.removeNotify))))

(defn select
  "Selects the text between the specified start and end positions.

   This method sets the start and end positions of the
   selected text, enforcing the restriction that the start position
   must be greater than or equal to zero.  The end position must be
   greater than or equal to the start position, and less than or
   equal to the length of the text component's text.  The
   character positions are indexed starting with zero.
   The length of the selection is
   endPosition - startPosition, so the
   character at endPosition is not selected.
   If the start and end positions of the selected text are equal,
   all text is deselected.

   If the caller supplies values that are inconsistent or out of
   bounds, the method enforces these constraints silently, and
   without failure. Specifically, if the start position or end
   position is greater than the length of the text, it is reset to
   equal the text length. If the start position is less than zero,
   it is reset to zero, and if the end position is less than the
   start position, it is reset to the start position.

  selection-start - the zero-based index of the first character (char value) to be selected - `int`
  selection-end - the zero-based end position of the text to be selected; the character (char value) at selectionEnd is not selected - `int`"
  ([^TextComponent this ^Integer selection-start ^Integer selection-end]
    (-> this (.select selection-start selection-end))))

(defn get-selection-end
  "Gets the end position of the selected text in
   this text component.

  returns: the end position of the selected text - `int`"
  (^Integer [^TextComponent this]
    (-> this (.getSelectionEnd))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this TextComponent.
   For text components, the AccessibleContext takes the form of an
   AccessibleAWTTextComponent.
   A new AccessibleAWTTextComponent instance is created if necessary.

  returns: an AccessibleAWTTextComponent that serves as the
           AccessibleContext of this TextComponent - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^TextComponent this]
    (-> this (.getAccessibleContext))))

(defn set-selection-start
  "Sets the selection start for this text component to
   the specified position. The new start point is constrained
   to be at or before the current selection end. It also
   cannot be set to less than zero, the beginning of the
   component's text.
   If the caller supplies a value for selectionStart
   that is out of bounds, the method enforces these constraints
   silently, and without failure.

  selection-start - the start position of the selected text - `int`"
  ([^TextComponent this ^Integer selection-start]
    (-> this (.setSelectionStart selection-start))))

(defn set-editable
  "Sets the flag that determines whether or not this
   text component is editable.

   If the flag is set to true, this text component
   becomes user editable. If the flag is set to false,
   the user cannot change the text of this text component.
   By default, non-editable text components have a background color
   of SystemColor.control.  This default can be overridden by
   calling setBackground.

  b - a flag indicating whether this text component is user editable. - `boolean`"
  ([^TextComponent this ^Boolean b]
    (-> this (.setEditable b))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this TextComponent.
   FooListeners are registered using the
   addFooListener method.


   You can specify the listenerType argument
   with a class literal, such as
   FooListener.class.
   For example, you can query a
   TextComponent t
   for its text listeners with the following code:



  TextListener[] tls = (TextListener[])(t.getListeners(TextListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class`

  returns: an array of all objects registered as
            FooListeners on this text component,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^TextComponent this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn get-background
  "Gets the background color of this text component.

   By default, non-editable text components have a background color
   of SystemColor.control.  This default can be overridden by
   calling setBackground.

  returns: This text component's background color.
           If this text component does not have a background color,
           the background color of its parent is returned. - `java.awt.Color`"
  (^java.awt.Color [^TextComponent this]
    (-> this (.getBackground))))

(defn get-input-method-requests
  "Description copied from class: Component

  returns: the input method request handler for this component,
            null by default - `java.awt.im.InputMethodRequests`"
  (^java.awt.im.InputMethodRequests [^TextComponent this]
    (-> this (.getInputMethodRequests))))

(defn get-text-listeners
  "Returns an array of all the text listeners
   registered on this text component.

  returns: all of this text component's TextListeners
           or an empty array if no text
           listeners are currently registered - `java.awt.event.TextListener[]`"
  ([^TextComponent this]
    (-> this (.getTextListeners))))

(defn set-selection-end
  "Sets the selection end for this text component to
   the specified position. The new end point is constrained
   to be at or after the current selection start. It also
   cannot be set beyond the end of the component's text.
   If the caller supplies a value for selectionEnd
   that is out of bounds, the method enforces these constraints
   silently, and without failure.

  selection-end - the end position of the selected text - `int`"
  ([^TextComponent this ^Integer selection-end]
    (-> this (.setSelectionEnd selection-end))))

(defn remove-text-listener
  "Removes the specified text event listener so that it no longer
   receives text events from this text component
   If l is null, no exception is
   thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the text listener - `java.awt.event.TextListener`"
  ([^TextComponent this ^java.awt.event.TextListener l]
    (-> this (.removeTextListener l))))

