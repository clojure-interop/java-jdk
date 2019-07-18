(ns javax.swing.text.JTextComponent
  "JTextComponent is the base class for swing text
  components.  It tries to be compatible with the
  java.awt.TextComponent class
  where it can reasonably do so.  Also provided are other services
  for additional flexibility (beyond the pluggable UI and bean
  support).
  You can find information on how to use the functionality
  this class provides in
  General Rules for Using Text Components,
  a section in The Java Tutorial.


  Caret Changes

  The caret is a pluggable object in swing text components.
  Notification of changes to the caret position and the selection
  are sent to implementations of the CaretListener
  interface that have been registered with the text component.
  The UI will install a default caret unless a customized caret
  has been set.
  By default the caret tracks all the document changes
  performed on the Event Dispatching Thread and updates it's position
  accordingly if an insertion occurs before or at the caret position
  or a removal occurs before the caret position. DefaultCaret
  tries to make itself visible which may lead to scrolling
  of a text component within JScrollPane. The default caret
  behavior can be changed by the DefaultCaret.setUpdatePolicy(int) method.

  Note: Non-editable text components also have a caret though
  it may not be painted.

  Commands

  Text components provide a number of commands that can be used
  to manipulate the component.  This is essentially the way that
  the component expresses its capabilities.  These are expressed
  in terms of the swing Action interface,
  using the TextAction implementation.
  The set of commands supported by the text component can be
  found with the getActions() method.  These actions
  can be bound to key events, fired from buttons, etc.

  Text Input

  The text components support flexible and internationalized text input, using
  keymaps and the input method framework, while maintaining compatibility with
  the AWT listener model.

  A Keymap lets an application bind key
  strokes to actions.
  In order to allow keymaps to be shared across multiple text components, they
  can use actions that extend TextAction.
  TextAction can determine which JTextComponent
  most recently has or had focus and therefore is the subject of
  the action (In the case that the ActionEvent
  sent to the action doesn't contain the target text component as its source).

  The input method framework
  lets text components interact with input methods, separate software
  components that preprocess events to let users enter thousands of
  different characters using keyboards with far fewer keys.
  JTextComponent is an active client of
  the framework, so it implements the preferred user interface for interacting
  with input methods. As a consequence, some key events do not reach the text
  component because they are handled by an input method, and some text input
  reaches the text component as committed text within an InputMethodEvent instead of as a key event.
  The complete text input is the combination of the characters in
  keyTyped key events and committed text in input method events.

  The AWT listener model lets applications attach event listeners to
  components in order to bind events to actions. Swing encourages the
  use of keymaps instead of listeners, but maintains compatibility
  with listeners by giving the listeners a chance to steal an event
  by consuming it.

  Keyboard event and input method events are handled in the following stages,
  with each stage capable of consuming the event:



  Stage
  KeyEvent
  InputMethodEvent
  1.
      input methods
      (generated here)
  2.
      focus manager



      3.
      registered key listeners
      registered input method listeners

      4.

      input method handling in JTextComponent

      5.   keymap handling using the current keymap
  6.   keyboard handling in JComponent (e.g. accelerators, component navigation, etc.)




  To maintain compatibility with applications that listen to key
  events but are not aware of input method events, the input
  method handling in stage 4 provides a compatibility mode for
  components that do not process input method events. For these
  components, the committed text is converted to keyTyped key events
  and processed in the key event pipeline starting at stage 3
  instead of in the input method event pipeline.

  By default the component will create a keymap (named DEFAULT_KEYMAP)
  that is shared by all JTextComponent instances as the default keymap.
  Typically a look-and-feel implementation will install a different keymap
  that resolves to the default keymap for those bindings not found in the
  different keymap. The minimal bindings include:

  inserting content into the editor for the
   printable keys.
  removing content with the backspace and del
   keys.
  caret movement forward and backward


  Model/View Split

  The text components have a model-view split.  A text component pulls
  together the objects used to represent the model, view, and controller.
  The text document model may be shared by other views which act as observers
  of the model (e.g. a document may be shared by multiple components).




  The model is defined by the Document interface.
  This is intended to provide a flexible text storage mechanism
  that tracks change during edits and can be extended to more sophisticated
  models.  The model interfaces are meant to capture the capabilities of
  expression given by SGML, a system used to express a wide variety of
  content.
  Each modification to the document causes notification of the
  details of the change to be sent to all observers in the form of a
  DocumentEvent which allows the views to stay up to date with the model.
  This event is sent to observers that have implemented the
  DocumentListener
  interface and registered interest with the model being observed.

  Location Information

  The capability of determining the location of text in
  the view is provided.  There are two methods, modelToView(int)
  and viewToModel(java.awt.Point) for determining this information.

  Undo/Redo support

  Support for an edit history mechanism is provided to allow
  undo/redo operations.  The text component does not itself
  provide the history buffer by default, but does provide
  the UndoableEdit records that can be used in conjunction
  with a history buffer to provide the undo/redo support.
  The support is provided by the Document model, which allows
  one to attach UndoableEditListener implementations.

  Thread Safety

  The swing text components provide some support of thread
  safe operations.  Because of the high level of configurability
  of the text components, it is possible to circumvent the
  protection provided.  The protection primarily comes from
  the model, so the documentation of AbstractDocument
  describes the assumptions of the protection provided.
  The methods that are safe to call asynchronously are marked
  with comments.

  Newlines

  For a discussion on how newlines are handled, see
  DefaultEditorKit.


  Printing support

  Several print methods are provided for basic
  document printing.  If more advanced printing is needed, use the
  getPrintable(java.text.MessageFormat, java.text.MessageFormat) method.



  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text JTextComponent]))

(defn ->j-text-component
  "Constructor.

  Creates a new JTextComponent.
   Listeners for caret events are established, and the pluggable
   UI installed.  The component is marked as editable.  No layout manager
   is used, because layout is managed by the view subsystem of text.
   The document model is set to null."
  (^JTextComponent []
    (new JTextComponent )))

(def *-focus-accelerator-key
  "Static Constant.

  The bound property name for the focus accelerator.

  type: java.lang.String"
  JTextComponent/FOCUS_ACCELERATOR_KEY)

(def *-default-keymap
  "Static Constant.

  The default keymap that will be shared by all
   JTextComponent instances unless they
   have had a different keymap set.

  type: java.lang.String"
  JTextComponent/DEFAULT_KEYMAP)

(defn *add-keymap
  "Adds a new keymap into the keymap hierarchy.  Keymap bindings
   resolve from bottom up so an attribute specified in a child
   will override an attribute specified in the parent.

  nm - the name of the keymap (must be unique within the collection of named keymaps in the document); the name may be null if the keymap is unnamed, but the caller is responsible for managing the reference returned as an unnamed keymap can't be fetched by name - `java.lang.String`
  parent - the parent keymap; this may be null if unspecified bindings need not be resolved in some other keymap - `javax.swing.text.Keymap`

  returns: the keymap - `javax.swing.text.Keymap`"
  (^javax.swing.text.Keymap [^java.lang.String nm ^javax.swing.text.Keymap parent]
    (JTextComponent/addKeymap nm parent)))

(defn *remove-keymap
  "Removes a named keymap previously added to the document.  Keymaps
   with null names may not be removed in this way.

  nm - the name of the keymap to remove - `java.lang.String`

  returns: the keymap that was removed - `javax.swing.text.Keymap`"
  (^javax.swing.text.Keymap [^java.lang.String nm]
    (JTextComponent/removeKeymap nm)))

(defn *get-keymap
  "Fetches a named keymap previously added to the document.
   This does not work with null-named keymaps.

  nm - the name of the keymap - `java.lang.String`

  returns: the keymap - `javax.swing.text.Keymap`"
  (^javax.swing.text.Keymap [^java.lang.String nm]
    (JTextComponent/getKeymap nm)))

(defn *load-keymap
  "Loads a keymap with a bunch of
   bindings.  This can be used to take a static table of
   definitions and load them into some keymap.  The following
   example illustrates an example of binding some keys to
   the cut, copy, and paste actions associated with a
   JTextComponent.  A code fragment to accomplish
   this might look as follows:


     static final JTextComponent.KeyBinding[] defaultBindings = {
       new JTextComponent.KeyBinding(
         KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK),
         DefaultEditorKit.copyAction),
       new JTextComponent.KeyBinding(
         KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK),
         DefaultEditorKit.pasteAction),
       new JTextComponent.KeyBinding(
         KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK),
         DefaultEditorKit.cutAction),
     };

     JTextComponent c = new JTextPane();
     Keymap k = c.getKeymap();
     JTextComponent.loadKeymap(k, defaultBindings, c.getActions());
   The sets of bindings and actions may be empty but must be
   non-null.

  map - the keymap - `javax.swing.text.Keymap`
  bindings - the bindings - `javax.swing.text.JTextComponent$KeyBinding[]`
  actions - the set of actions - `javax.swing.Action[]`"
  ([^javax.swing.text.Keymap map bindings actions]
    (JTextComponent/loadKeymap map bindings actions)))

(defn get-selected-text-color
  "Fetches the current color used to render the
   selected text.

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^JTextComponent this]
    (-> this (.getSelectedTextColor))))

(defn get-selected-text
  "Returns the selected text contained in this
   TextComponent.  If the selection is
   null or the document empty, returns null.

  returns: the text - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the selection doesn't have a valid mapping into the document for some reason"
  (^java.lang.String [^JTextComponent this]
    (-> this (.getSelectedText))))

(defn set-disabled-text-color
  "Sets the current color used to render the
   disabled text.  Setting the color fires off a
   PropertyChange event (`disabledTextColor`).

  c - the color - `java.awt.Color`"
  ([^JTextComponent this ^java.awt.Color c]
    (-> this (.setDisabledTextColor c))))

(defn get-document
  "Fetches the model associated with the editor.  This is
   primarily for the UI to get at the minimal amount of
   state required to be a text editor.  Subclasses will
   return the actual type of the model which will typically
   be something that extends Document.

  returns: the model - `javax.swing.text.Document`"
  (^javax.swing.text.Document [^JTextComponent this]
    (-> this (.getDocument))))

(defn copy
  "Transfers the currently selected range in the associated
   text model to the system clipboard, leaving the contents
   in the text model.  The current selection remains intact.
   Does nothing for null selections."
  ([^JTextComponent this]
    (-> this (.copy))))

(defn set-document
  "Associates the editor with a text document.
   The currently registered factory is used to build a view for
   the document, which gets displayed by the editor after revalidation.
   A PropertyChange event (`document`) is propagated to each listener.

  doc - the document to display/edit - `javax.swing.text.Document`"
  ([^JTextComponent this ^javax.swing.text.Document doc]
    (-> this (.setDocument doc))))

(defn get-navigation-filter
  "Returns the NavigationFilter. NavigationFilter
   is used by DefaultCaret and the default cursor movement
   actions as a way to restrict the cursor movement. A null return value
   implies the cursor movement and selection should not be restricted.

  returns: the NavigationFilter - `javax.swing.text.NavigationFilter`"
  (^javax.swing.text.NavigationFilter [^JTextComponent this]
    (-> this (.getNavigationFilter))))

(defn set-text
  "Sets the text of this TextComponent
   to the specified text.  If the text is null
   or empty, has the effect of simply deleting the old text.
   When text has been inserted, the resulting caret location
   is determined by the implementation of the caret class.


   Note that text is not a bound property, so no PropertyChangeEvent
    is fired when it changes. To listen for changes to the text,
   use DocumentListener.

  t - the new text to be set - `java.lang.String`"
  ([^JTextComponent this ^java.lang.String t]
    (-> this (.setText t))))

(defn paste
  "Transfers the contents of the system clipboard into the
   associated text model.  If there is a selection in the
   associated view, it is replaced with the contents of the
   clipboard.  If there is no selection, the clipboard contents
   are inserted in front of the current insert position in
   the associated view.  If the clipboard is empty, does nothing."
  ([^JTextComponent this]
    (-> this (.paste))))

(defn set-margin
  "Sets margin space between the text component's border
   and its text.  The text component's default Border
   object will use this value to create the proper margin.
   However, if a non-default border is set on the text component,
   it is that Border object's responsibility to create the
   appropriate margin space (else this property will effectively
   be ignored).  This causes a redraw of the component.
   A PropertyChange event (`margin`) is sent to all listeners.

  m - the space between the border and the text - `java.awt.Insets`"
  ([^JTextComponent this ^java.awt.Insets m]
    (-> this (.setMargin m))))

(defn get-drop-mode
  "Returns the drop mode for this component.

  returns: the drop mode for this component - `javax.swing.DropMode`"
  (^javax.swing.DropMode [^JTextComponent this]
    (-> this (.getDropMode))))

(defn get-scrollable-block-increment
  "Components that display logical rows or columns should compute
   the scroll increment that will completely expose one block
   of rows or columns, depending on the value of orientation.

   The default implementation of this is to simply return the visible
   area.  Subclasses will likely be able to provide a much more
   reasonable value.

  visible-rect - the view area visible within the viewport - `java.awt.Rectangle`
  orientation - either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL - `int`
  direction - less than zero to scroll up/left, greater than zero for down/right - `int`

  returns: the `block` increment for scrolling in the specified direction - `int`

  throws: java.lang.IllegalArgumentException - for an invalid orientation"
  (^Integer [^JTextComponent this ^java.awt.Rectangle visible-rect ^Integer orientation ^Integer direction]
    (-> this (.getScrollableBlockIncrement visible-rect orientation direction))))

(defn set-drop-mode
  "Sets the drop mode for this component. For backward compatibility,
   the default for this property is DropMode.USE_SELECTION.
   Usage of DropMode.INSERT is recommended, however,
   for an improved user experience. It offers similar behavior of dropping
   between text locations, but does so without affecting the actual text
   selection and caret location.

   JTextComponents support the following drop modes:

      DropMode.USE_SELECTION
      DropMode.INSERT


   The drop mode is only meaningful if this component has a
   TransferHandler that accepts drops.

  drop-mode - the drop mode to use - `javax.swing.DropMode`

  throws: java.lang.IllegalArgumentException - if the drop mode is unsupported or null"
  ([^JTextComponent this ^javax.swing.DropMode drop-mode]
    (-> this (.setDropMode drop-mode))))

(defn set-caret
  "Sets the caret to be used.  By default this will be set
   by the UI that gets installed.  This can be changed to
   a custom caret if desired.  Setting the caret results in a
   PropertyChange event (`caret`) being fired.

  c - the caret - `javax.swing.text.Caret`"
  ([^JTextComponent this ^javax.swing.text.Caret c]
    (-> this (.setCaret c))))

(defn get-text
  "Fetches a portion of the text represented by the
   component.  Returns an empty string if length is 0.

  offs - the offset ≥ 0 - `int`
  len - the length ≥ 0 - `int`

  returns: the text - `java.lang.String`

  throws: javax.swing.text.BadLocationException - if the offset or length are invalid"
  (^java.lang.String [^JTextComponent this ^Integer offs ^Integer len]
    (-> this (.getText offs len)))
  (^java.lang.String [^JTextComponent this]
    (-> this (.getText))))

(defn get-caret-color
  "Fetches the current color used to render the
   caret.

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^JTextComponent this]
    (-> this (.getCaretColor))))

(defn get-highlighter
  "Fetches the object responsible for making highlights.

  returns: the highlighter - `javax.swing.text.Highlighter`"
  (^javax.swing.text.Highlighter [^JTextComponent this]
    (-> this (.getHighlighter))))

(defn select-all
  "Selects all the text in the TextComponent.
   Does nothing on a null or empty document."
  ([^JTextComponent this]
    (-> this (.selectAll))))

(defn get-selection-start
  "Returns the selected text's start position.  Return 0 for an
   empty document, or the value of dot if no selection.

  returns: the start position ≥ 0 - `int`"
  (^Integer [^JTextComponent this]
    (-> this (.getSelectionStart))))

(defn set-focus-accelerator
  "Sets the key accelerator that will cause the receiving text
   component to get the focus.  The accelerator will be the
   key combination of the platform-specific modifier key and
   the character given (converted to upper case).  For example,
   the ALT key is used as a modifier on Windows and the CTRL+ALT
   combination is used on Mac.  By default, there is no focus
   accelerator key.  Any previous key accelerator setting will be
   superseded.  A '\0' key setting will be registered, and has the
   effect of turning off the focus accelerator.  When the new key
   is set, a PropertyChange event (FOCUS_ACCELERATOR_KEY) will be fired.

  a-key - the key - `char`"
  ([^JTextComponent this ^Character a-key]
    (-> this (.setFocusAccelerator a-key))))

(defn read
  "Initializes from a stream.  This creates a
   model of the type appropriate for the component
   and initializes the model from the stream.
   By default this will load the model as plain
   text.  Previous contents of the model are discarded.

  in - the stream to read from - `java.io.Reader`
  desc - an object describing the stream; this might be a string, a File, a URL, etc. Some kinds of documents (such as html for example) might be able to make use of this information; if non-null, it is added as a property of the document - `java.lang.Object`

  throws: java.io.IOException - as thrown by the stream being used to initialize"
  ([^JTextComponent this ^java.io.Reader in ^java.lang.Object desc]
    (-> this (.read in desc))))

(defn get-actions
  "Fetches the command list for the editor.  This is
   the list of commands supported by the plugged-in UI
   augmented by the collection of commands that the
   editor itself supports.  These are useful for binding
   to events, such as in a keymap.

  returns: the command list - `javax.swing.Action[]`"
  ([^JTextComponent this]
    (-> this (.getActions))))

(defn set-caret-position
  "Sets the position of the text insertion caret for the
   TextComponent.  Note that the caret tracks change,
   so this may move if the underlying text of the component is changed.
   If the document is null, does nothing. The position
   must be between 0 and the length of the component's text or else
   an exception is thrown.

  position - the position - `int`

  throws: java.lang.IllegalArgumentException - if the value supplied for position is less than zero or greater than the component's text length"
  ([^JTextComponent this ^Integer position]
    (-> this (.setCaretPosition position))))

(defn move-caret-position
  "Moves the caret to a new position, leaving behind a mark
   defined by the last time setCaretPosition was
   called.  This forms a selection.
   If the document is null, does nothing. The position
   must be between 0 and the length of the component's text or else
   an exception is thrown.

  pos - the position - `int`

  throws: java.lang.IllegalArgumentException - if the value supplied for position is less than zero or greater than the component's text length"
  ([^JTextComponent this ^Integer pos]
    (-> this (.moveCaretPosition pos))))

(defn get-scrollable-unit-increment
  "Components that display logical rows or columns should compute
   the scroll increment that will completely expose one new row
   or column, depending on the value of orientation.  Ideally,
   components should handle a partially exposed row or column by
   returning the distance required to completely expose the item.

   The default implementation of this is to simply return 10% of
   the visible area.  Subclasses are likely to be able to provide
   a much more reasonable value.

  visible-rect - the view area visible within the viewport - `java.awt.Rectangle`
  orientation - either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL - `int`
  direction - less than zero to scroll up/left, greater than zero for down/right - `int`

  returns: the `unit` increment for scrolling in the specified direction - `int`

  throws: java.lang.IllegalArgumentException - for an invalid orientation"
  (^Integer [^JTextComponent this ^java.awt.Rectangle visible-rect ^Integer orientation ^Integer direction]
    (-> this (.getScrollableUnitIncrement visible-rect orientation direction))))

(defn get-keymap
  "Fetches the keymap currently active in this text
   component.

  returns: the keymap - `javax.swing.text.Keymap`"
  (^javax.swing.text.Keymap [^JTextComponent this]
    (-> this (.getKeymap))))

(defn set-navigation-filter
  "Sets the NavigationFilter. NavigationFilter
   is used by DefaultCaret and the default cursor movement
   actions as a way to restrict the cursor movement.

  filter - `javax.swing.text.NavigationFilter`"
  ([^JTextComponent this ^javax.swing.text.NavigationFilter filter]
    (-> this (.setNavigationFilter filter))))

(defn set-highlighter
  "Sets the highlighter to be used.  By default this will be set
   by the UI that gets installed.  This can be changed to
   a custom highlighter if desired.  The highlighter can be set to
   null to disable it.
   A PropertyChange event (`highlighter`) is fired
   when a new highlighter is installed.

  h - the highlighter - `javax.swing.text.Highlighter`"
  ([^JTextComponent this ^javax.swing.text.Highlighter h]
    (-> this (.setHighlighter h))))

(defn get-drop-location
  "Returns the location that this component should visually indicate
   as the drop location during a DnD operation over the component,
   or null if no location is to currently be shown.

   This method is not meant for querying the drop location
   from a TransferHandler, as the drop location is only
   set after the TransferHandler's canImport
   has returned and has allowed for the location to be shown.

   When this property changes, a property change event with
   name `dropLocation` is fired by the component.

  returns: the drop location - `javax.swing.text.JTextComponent$DropLocation`"
  (^javax.swing.text.JTextComponent$DropLocation [^JTextComponent this]
    (-> this (.getDropLocation))))

(defn get-preferred-scrollable-viewport-size
  "Returns the preferred size of the viewport for a view component.
   This is implemented to do the default behavior of returning
   the preferred size of the component.

  returns: the preferredSize of a JViewport
   whose view is this Scrollable - `java.awt.Dimension`"
  (^java.awt.Dimension [^JTextComponent this]
    (-> this (.getPreferredScrollableViewportSize))))

(defn set-keymap
  "Sets the keymap to use for binding events to
   actions.  Setting to null effectively disables
   keyboard input.
   A PropertyChange event (`keymap`) is fired when a new keymap
   is installed.

  map - the keymap - `javax.swing.text.Keymap`"
  ([^JTextComponent this ^javax.swing.text.Keymap map]
    (-> this (.setKeymap map))))

(defn set-ui
  "Sets the user-interface factory for this text-oriented editor.

  ui - the factory - `javax.swing.plaf.TextUI`"
  ([^JTextComponent this ^javax.swing.plaf.TextUI ui]
    (-> this (.setUI ui))))

(defn editable?
  "Returns the boolean indicating whether this
   TextComponent is editable or not.

  returns: the boolean value - `boolean`"
  (^Boolean [^JTextComponent this]
    (-> this (.isEditable))))

(defn get-tool-tip-text
  "Returns the string to be used as the tooltip for event.
   This will return one of:

    If setToolTipText has been invoked with a
        non-null
        value, it will be returned, otherwise
    The value from invoking getToolTipText on
        the UI will be returned.

   By default JTextComponent does not register
   itself with the ToolTipManager.
   This means that tooltips will NOT be shown from the
   TextUI unless registerComponent has
   been invoked on the ToolTipManager.

  event - the event in question - `java.awt.event.MouseEvent`

  returns: the string to be used as the tooltip for event - `java.lang.String`"
  (^java.lang.String [^JTextComponent this event]
    (-> this (.getToolTipText event))))

(defn get-caret-position
  "Returns the position of the text insertion caret for the
   text component.

  returns: the position of the text insertion caret for the
    text component ≥ 0 - `int`"
  (^Integer [^JTextComponent this]
    (-> this (.getCaretPosition))))

(defn remove-notify
  "Description copied from class: JComponent"
  ([^JTextComponent this]
    (-> this (.removeNotify))))

(defn get-caret-listeners
  "Returns an array of all the caret listeners
   registered on this text component.

  returns: all of this component's CaretListeners
           or an empty
           array if no caret listeners are currently registered - `javax.swing.event.CaretListener[]`"
  ([^JTextComponent this]
    (-> this (.getCaretListeners))))

(defn select
  "Selects the text between the specified start and end positions.

   This method sets the start and end positions of the
   selected text, enforcing the restriction that the start position
   must be greater than or equal to zero.  The end position must be
   greater than or equal to the start position, and less than or
   equal to the length of the text component's text.

   If the caller supplies values that are inconsistent or out of
   bounds, the method enforces these constraints silently, and
   without failure. Specifically, if the start position or end
   position is greater than the length of the text, it is reset to
   equal the text length. If the start position is less than zero,
   it is reset to zero, and if the end position is less than the
   start position, it is reset to the start position.

   This call is provided for backward compatibility.
   It is routed to a call to setCaretPosition
   followed by a call to moveCaretPosition.
   The preferred way to manage selection is by calling
   those methods directly.

  selection-start - the start position of the text - `int`
  selection-end - the end position of the text - `int`"
  ([^JTextComponent this ^Integer selection-start ^Integer selection-end]
    (-> this (.select selection-start selection-end))))

(defn get-disabled-text-color
  "Fetches the current color used to render the
   disabled text.

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^JTextComponent this]
    (-> this (.getDisabledTextColor))))

(defn set-drag-enabled
  "Turns on or off automatic drag handling. In order to enable automatic
   drag handling, this property should be set to true, and the
   component's TransferHandler needs to be non-null.
   The default value of the dragEnabled property is false.

   The job of honoring this property, and recognizing a user drag gesture,
   lies with the look and feel implementation, and in particular, the component's
   TextUI. When automatic drag handling is enabled, most look and
   feels (including those that subclass BasicLookAndFeel) begin a
   drag and drop operation whenever the user presses the mouse button over
   a selection and then moves the mouse a few pixels. Setting this property to
   true can therefore have a subtle effect on how selections behave.

   If a look and feel is used that ignores this property, you can still
   begin a drag and drop operation by calling exportAsDrag on the
   component's TransferHandler.

  b - whether or not to enable automatic drag handling - `boolean`

  throws: java.awt.HeadlessException - if b is true and GraphicsEnvironment.isHeadless() returns true"
  ([^JTextComponent this ^Boolean b]
    (-> this (.setDragEnabled b))))

(defn get-selection-end
  "Returns the selected text's end position.  Return 0 if the document
   is empty, or the value of dot if there is no selection.

  returns: the end position ≥ 0 - `int`"
  (^Integer [^JTextComponent this]
    (-> this (.getSelectionEnd))))

(defn get-ui
  "Fetches the user-interface factory for this text-oriented editor.

  returns: the factory - `javax.swing.plaf.TextUI`"
  (^javax.swing.plaf.TextUI [^JTextComponent this]
    (-> this (.getUI))))

(defn get-selection-color
  "Fetches the current color used to render the
   selection.

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^JTextComponent this]
    (-> this (.getSelectionColor))))

(defn get-caret
  "Fetches the caret that allows text-oriented navigation over
   the view.

  returns: the caret - `javax.swing.text.Caret`"
  (^javax.swing.text.Caret [^JTextComponent this]
    (-> this (.getCaret))))

(defn get-scrollable-tracks-viewport-width?
  "Returns true if a viewport should always force the width of this
   Scrollable to match the width of the viewport.
   For example a normal text view that supported line wrapping
   would return true here, since it would be undesirable for
   wrapped lines to disappear beyond the right
   edge of the viewport.  Note that returning true for a
   Scrollable whose ancestor is a JScrollPane
   effectively disables horizontal scrolling.

   Scrolling containers, like JViewport,
   will use this method each time they are validated.

  returns: true if a viewport should force the Scrollables
     width to match its own - `boolean`"
  (^Boolean [^JTextComponent this]
    (-> this (.getScrollableTracksViewportWidth))))

(defn set-selected-text-color
  "Sets the current color used to render the selected text.
   Setting the color to null is the same as
   Color.black. Setting the color results in a
   PropertyChange event (`selectedTextColor`) being fired.

  c - the color - `java.awt.Color`"
  ([^JTextComponent this ^java.awt.Color c]
    (-> this (.setSelectedTextColor c))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this
   JTextComponent. For text components,
   the AccessibleContext takes the form of an
   AccessibleJTextComponent.
   A new AccessibleJTextComponent instance
   is created if necessary.

  returns: an AccessibleJTextComponent that serves as the
           AccessibleContext of this
           JTextComponent - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JTextComponent this]
    (-> this (.getAccessibleContext))))

(defn add-input-method-listener
  "Description copied from class: Component

  l - the input method listener - `java.awt.event.InputMethodListener`"
  ([^JTextComponent this ^java.awt.event.InputMethodListener l]
    (-> this (.addInputMethodListener l))))

(defn set-selection-start
  "Sets the selection start to the specified position.  The new
   starting point is constrained to be before or at the current
   selection end.

   This is available for backward compatibility to code
   that called this method on java.awt.TextComponent.
   This is implemented to forward to the Caret
   implementation which is where the actual selection is maintained.

  selection-start - the start position of the text ≥ 0 - `int`"
  ([^JTextComponent this ^Integer selection-start]
    (-> this (.setSelectionStart selection-start))))

(defn replace-selection
  "Replaces the currently selected content with new content
   represented by the given string.  If there is no selection
   this amounts to an insert of the given text.  If there
   is no replacement text this amounts to a removal of the
   current selection.

   This is the method that is used by the default implementation
   of the action for inserting content that gets bound to the
   keymap actions.

  content - the content to replace the selection with - `java.lang.String`"
  ([^JTextComponent this ^java.lang.String content]
    (-> this (.replaceSelection content))))

(defn get-focus-accelerator
  "Returns the key accelerator that will cause the receiving
   text component to get the focus.  Return '\0' if no focus
   accelerator has been set.

  returns: the key - `char`"
  (^Character [^JTextComponent this]
    (-> this (.getFocusAccelerator))))

(defn set-editable
  "Sets the specified boolean to indicate whether or not this
   TextComponent should be editable.
   A PropertyChange event (`editable`) is fired when the
   state is changed.

  b - the boolean to be set - `boolean`"
  ([^JTextComponent this ^Boolean b]
    (-> this (.setEditable b))))

(defn get-scrollable-tracks-viewport-height?
  "Returns true if a viewport should always force the height of this
   Scrollable to match the height of the viewport.
   For example a columnar text view that flowed text in left to
   right columns could effectively disable vertical scrolling by
   returning true here.

   Scrolling containers, like JViewport,
   will use this method each time they are validated.

  returns: true if a viewport should force the Scrollables height
     to match its own - `boolean`"
  (^Boolean [^JTextComponent this]
    (-> this (.getScrollableTracksViewportHeight))))

(defn view-to-model
  "Converts the given place in the view coordinate system
   to the nearest representative location in the model.
   The component must have a positive size for
   this translation to be computed (i.e. layout cannot
   be computed until the component has been sized).  The
   component does not have to be visible or painted.

  pt - the location in the view to translate - `java.awt.Point`

  returns: the offset ≥ 0 from the start of the document,
     or -1 if the component does not yet have a positive
     size. - `int`"
  (^Integer [^JTextComponent this ^java.awt.Point pt]
    (-> this (.viewToModel pt))))

(defn print
  "Prints the content of this JTextComponent. Note: this method
   blocks until printing is done.


   Page header and footer text can be added to the output by providing
   MessageFormat arguments. The printing code requests
   Strings from the formats, providing a single item which may be
   included in the formatted string: an Integer representing the
   current page number.


   showPrintDialog boolean parameter allows you to specify whether
   a print dialog is displayed to the user. When it is, the user
   may use the dialog to change printing attributes or even cancel the
   print.


   service allows you to provide the initial
   PrintService for the print dialog, or to specify
   PrintService to print to when the dialog is not shown.


   attributes can be used to provide the
   initial values for the print dialog, or to supply any needed
   attributes when the dialog is not shown. attributes can
   be used to control how the job will print, for example
   duplex or single-sided.


   interactive boolean parameter allows you to specify
   whether to perform printing in interactive
   mode. If true, a progress dialog, with an abort option,
   is displayed for the duration of printing.  This dialog is
   modal when print is invoked on the Event Dispatch
   Thread and non-modal otherwise. Warning:
   calling this method on the Event Dispatch Thread with interactive false blocks all events, including repaints, from
   being processed until printing is complete. It is only
   recommended when printing from an application with no
   visible GUI.


   Note: In headless mode, showPrintDialog and
   interactive parameters are ignored and no dialogs are
   shown.


   This method ensures the document is not mutated during printing.
   To indicate it visually, setEnabled(false) is set for the
   duration of printing.


   This method uses getPrintable(java.text.MessageFormat, java.text.MessageFormat) to render document content.


   This method is thread-safe, although most Swing methods are not. Please
   see
   Concurrency in Swing for more information.


   Sample Usage. This code snippet shows a cross-platform print
   dialog and then prints the JTextComponent in interactive mode
   unless the user cancels the dialog:



   textComponent.print(new MessageFormat(`My text component header`),
       new MessageFormat(`Footer. Page - {0}`), true, null, null, true);

   Executing this code off the Event Dispatch Thread
   performs printing on the background.
   The following pattern might be used for background
   printing:


       FutureTask<Boolean> future =
           new FutureTask<Boolean>(
               new Callable<Boolean>() {
                   public Boolean call() {
                       return textComponent.print(.....);
                   }
               });
       executor.execute(future);

  header-format - the text, in MessageFormat, to be used as the header, or null for no header - `java.text.MessageFormat`
  footer-format - the text, in MessageFormat, to be used as the footer, or null for no footer - `java.text.MessageFormat`
  show-print-dialog - true to display a print dialog, false otherwise - `boolean`
  service - initial PrintService, or null for the default - `javax.print.PrintService`
  attributes - the job attributes to be applied to the print job, or null for none - `javax.print.attribute.PrintRequestAttributeSet`
  interactive - whether to print in an interactive mode - `boolean`

  returns: true, unless printing is canceled by the user - `boolean`

  throws: java.awt.print.PrinterException - if an error in the print system causes the job to be aborted"
  (^Boolean [^JTextComponent this ^java.text.MessageFormat header-format ^java.text.MessageFormat footer-format ^Boolean show-print-dialog ^javax.print.PrintService service ^javax.print.attribute.PrintRequestAttributeSet attributes ^Boolean interactive]
    (-> this (.print header-format footer-format show-print-dialog service attributes interactive)))
  (^Boolean [^JTextComponent this ^java.text.MessageFormat header-format ^java.text.MessageFormat footer-format]
    (-> this (.print header-format footer-format)))
  (^Boolean [^JTextComponent this]
    (-> this (.print))))

(defn get-drag-enabled?
  "Returns whether or not automatic drag handling is enabled.

  returns: the value of the dragEnabled property - `boolean`"
  (^Boolean [^JTextComponent this]
    (-> this (.getDragEnabled))))

(defn set-caret-color
  "Sets the current color used to render the caret.
   Setting to null effectively restores the default color.
   Setting the color results in a PropertyChange event (`caretColor`)
   being fired.

  c - the color - `java.awt.Color`"
  ([^JTextComponent this ^java.awt.Color c]
    (-> this (.setCaretColor c))))

(defn remove-caret-listener
  "Removes a caret listener.

  listener - the listener to be removed - `javax.swing.event.CaretListener`"
  ([^JTextComponent this ^javax.swing.event.CaretListener listener]
    (-> this (.removeCaretListener listener))))

(defn get-printable
  "Returns a Printable to use for printing the content of this
   JTextComponent. The returned Printable prints
   the document as it looks on the screen except being reformatted
   to fit the paper.
   The returned Printable can be wrapped inside another
   Printable in order to create complex reports and
   documents.



   The returned Printable shares the document with this
   JTextComponent. It is the responsibility of the developer to
   ensure that the document is not mutated while this Printable
   is used. Printing behavior is undefined when the document is
   mutated during printing.


   Page header and footer text can be added to the output by providing
   MessageFormat arguments. The printing code requests
   Strings from the formats, providing a single item which may be
   included in the formatted string: an Integer representing the
   current page number.


   The returned Printable when printed, formats the
   document content appropriately for the page size. For correct
   line wrapping the imageable width of all pages must be the
   same. See PageFormat.getImageableWidth().


   This method is thread-safe, although most Swing methods are not. Please
   see
   Concurrency in Swing for more information.


   The returned Printable can be printed on any thread.


   This implementation returned Printable performs all painting on
   the Event Dispatch Thread, regardless of what thread it is
   used on.

  header-format - the text, in MessageFormat, to be used as the header, or null for no header - `java.text.MessageFormat`
  footer-format - the text, in MessageFormat, to be used as the footer, or null for no footer - `java.text.MessageFormat`

  returns: a Printable for use in printing content of this
           JTextComponent - `java.awt.print.Printable`"
  (^java.awt.print.Printable [^JTextComponent this ^java.text.MessageFormat header-format ^java.text.MessageFormat footer-format]
    (-> this (.getPrintable header-format footer-format))))

(defn get-input-method-requests
  "Description copied from class: Component

  returns: the input method request handler for this component,
            null by default - `java.awt.im.InputMethodRequests`"
  (^java.awt.im.InputMethodRequests [^JTextComponent this]
    (-> this (.getInputMethodRequests))))

(defn set-component-orientation
  "Description copied from class: Component

  o - `java.awt.ComponentOrientation`"
  ([^JTextComponent this ^java.awt.ComponentOrientation o]
    (-> this (.setComponentOrientation o))))

(defn set-selection-color
  "Sets the current color used to render the selection.
   Setting the color to null is the same as setting
   Color.white.  Setting the color results in a
   PropertyChange event (`selectionColor`).

  c - the color - `java.awt.Color`"
  ([^JTextComponent this ^java.awt.Color c]
    (-> this (.setSelectionColor c))))

(defn write
  "Stores the contents of the model into the given
   stream.  By default this will store the model as plain
   text.

  out - the output stream - `java.io.Writer`

  throws: java.io.IOException - on any I/O error"
  ([^JTextComponent this ^java.io.Writer out]
    (-> this (.write out))))

(defn cut
  "Transfers the currently selected range in the associated
   text model to the system clipboard, removing the contents
   from the model.  The current selection is reset.  Does nothing
   for null selections."
  ([^JTextComponent this]
    (-> this (.cut))))

(defn add-caret-listener
  "Adds a caret listener for notification of any changes
   to the caret.

  listener - the listener to be added - `javax.swing.event.CaretListener`"
  ([^JTextComponent this ^javax.swing.event.CaretListener listener]
    (-> this (.addCaretListener listener))))

(defn set-selection-end
  "Sets the selection end to the specified position.  The new
   end point is constrained to be at or after the current
   selection start.

   This is available for backward compatibility to code
   that called this method on java.awt.TextComponent.
   This is implemented to forward to the Caret
   implementation which is where the actual selection is maintained.

  selection-end - the end position of the text ≥ 0 - `int`"
  ([^JTextComponent this ^Integer selection-end]
    (-> this (.setSelectionEnd selection-end))))

(defn update-ui
  "Reloads the pluggable UI.  The key used to fetch the
   new interface is getUIClassID().  The type of
   the UI is TextUI.  invalidate
   is called after setting the UI."
  ([^JTextComponent this]
    (-> this (.updateUI))))

(defn model-to-view
  "Converts the given location in the model to a place in
   the view coordinate system.
   The component must have a positive size for
   this translation to be computed (i.e. layout cannot
   be computed until the component has been sized).  The
   component does not have to be visible or painted.

  pos - the position ≥ 0 - `int`

  returns: the coordinates as a rectangle, with (r.x, r.y) as the location
     in the coordinate system, or null if the component does
     not yet have a positive size. - `java.awt.Rectangle`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  (^java.awt.Rectangle [^JTextComponent this ^Integer pos]
    (-> this (.modelToView pos))))

(defn get-margin
  "Returns the margin between the text component's border and
   its text.

  returns: the margin - `java.awt.Insets`"
  (^java.awt.Insets [^JTextComponent this]
    (-> this (.getMargin))))

