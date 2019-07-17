(ns javax.swing.text.DefaultCaret
  "A default implementation of Caret.  The caret is rendered as
  a vertical line in the color specified by the CaretColor property
  of the associated JTextComponent.  It can blink at the rate specified
  by the BlinkRate property.

  This implementation expects two sources of asynchronous notification.
  The timer thread fires asynchronously, and causes the caret to simply
  repaint the most recent bounding box.  The caret also tracks change
  as the document is modified.  Typically this will happen on the
  event dispatch thread as a result of some mouse or keyboard event.
  The caret behavior on both synchronous and asynchronous documents updates
  is controlled by UpdatePolicy property. The repaint of the
  new caret location will occur on the event thread in any case, as calls to
  modelToView are only safe on the event thread.

  The caret acts as a mouse and focus listener on the text component
  it has been installed in, and defines the caret semantics based upon
  those events.  The listener methods can be reimplemented to change the
  semantics.
  By default, the first mouse button will be used to set focus and caret
  position.  Dragging the mouse pointer with the first mouse button will
  sweep out a selection that is contiguous in the model.  If the associated
  text component is editable, the caret will become visible when focus
  is gained, and invisible when focus is lost.

  The Highlighter bound to the associated text component is used to
  render the selection by default.
  Selection appearance can be customized by supplying a
  painter to use for the highlights.  By default a painter is used that
  will render a solid color as specified in the associated text component
  in the SelectionColor property.  This can easily be changed
  by reimplementing the
  getSelectionPainter
  method.

  A customized caret appearance can be achieved by reimplementing
  the paint method.  If the paint method is changed, the damage method
  should also be reimplemented to cause a repaint for the area needed
  to render the caret.  The caret extends the Rectangle class which
  is used to hold the bounding box for where the caret was last rendered.
  This enables the caret to repaint in a thread-safe manner when the
  caret moves without making a call to modelToView which is unstable
  between model updates and view repair (i.e. the order of delivery
  to DocumentListeners is not guaranteed).

  The magic caret position is set to null when the caret position changes.
  A timer is used to determine the new location (after the caret change).
  When the timer fires, if the magic caret position is still null it is
  reset to the current caret position. Any actions that change
  the caret position and want the magic caret position to remain the
  same, must remember the magic caret position, change the cursor, and
  then set the magic caret position to its original value. This has the
  benefit that only actions that want the magic caret position to persist
  (such as open/down) need to know about it.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DefaultCaret]))

(defn ->default-caret
  "Constructor.

  Constructs a default caret."
  ([]
    (new DefaultCaret )))

(def *-update-when-on-edt
  "Static Constant.

  Indicates that the caret position is to be updated only when
   document changes are performed on the Event Dispatching Thread.

  type: int"
  DefaultCaret/UPDATE_WHEN_ON_EDT)

(def *-never-update
  "Static Constant.

  Indicates that the caret should remain at the same
   absolute position in the document regardless of any document
   updates, except when the document length becomes less than
   the current caret position due to removal. In that case the caret
   position is adjusted to the end of the document.

  type: int"
  DefaultCaret/NEVER_UPDATE)

(def *-always-update
  "Static Constant.

  Indicates that the caret position is to be always
   updated accordingly to the document changes regardless whether
   the document updates are performed on the Event Dispatching Thread
   or not.

  type: int"
  DefaultCaret/ALWAYS_UPDATE)

(defn get-dot
  "Fetches the current position of the caret.

  returns: the position >= 0 - `int`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.getDot))))

(defn move-dot
  "Moves the caret position to the specified position, with the
   specified bias.

  dot - the position >= 0 - `int`
  dot-bias - the bias for this position, not null - `javax.swing.text.Position.Bias`

  throws: java.lang.IllegalArgumentException - if the bias is null"
  ([^javax.swing.text.DefaultCaret this ^Integer dot ^javax.swing.text.Position.Bias dot-bias]
    (-> this (.moveDot dot dot-bias)))
  ([^javax.swing.text.DefaultCaret this ^Integer dot]
    (-> this (.moveDot dot))))

(defn add-change-listener
  "Adds a listener to track whenever the caret position has
   been changed.

  l - the listener - `javax.swing.event.ChangeListener`"
  ([^javax.swing.text.DefaultCaret this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn active?
  "Determines if the caret is currently active.

   This method returns whether or not the Caret
   is currently in a blinking state. It does not provide
   information as to whether it is currently blinked on or off.
   To determine if the caret is currently painted use the
   isVisible method.

  returns: true if active else false - `boolean`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.isActive))))

(defn mouse-moved
  "Called when the mouse is moved.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^javax.swing.text.DefaultCaret this ^java.awt.event.MouseEvent e]
    (-> this (.mouseMoved e))))

(defn get-magic-caret-position
  "Gets the saved caret position.

  returns: the position
   see #setMagicCaretPosition - `java.awt.Point`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.getMagicCaretPosition))))

(defn focus-gained
  "Called when the component containing the caret gains
   focus.  This is implemented to set the caret to visible
   if the component is editable.

  e - the focus event - `java.awt.event.FocusEvent`"
  ([^javax.swing.text.DefaultCaret this ^java.awt.event.FocusEvent e]
    (-> this (.focusGained e))))

(defn set-blink-rate
  "Sets the caret blink rate.

  rate - the rate in milliseconds, 0 to stop blinking - `int`"
  ([^javax.swing.text.DefaultCaret this ^Integer rate]
    (-> this (.setBlinkRate rate))))

(defn set-update-policy
  "Sets the caret movement policy on the document updates. Normally
   the caret updates its absolute position within the document on
   insertions occurred before or at the caret position and
   on removals before the caret position. 'Absolute position'
   means here the position relative to the start of the document.
   For example if
   a character is typed within editable text component it is inserted
   at the caret position and the caret moves to the next absolute
   position within the document due to insertion and if
   BACKSPACE is typed then caret decreases its absolute
   position due to removal of a character before it. Sometimes
   it may be useful to turn off the caret position updates so that
   the caret stays at the same absolute position within the
   document position regardless of any document updates.

   The following update policies are allowed:

     NEVER_UPDATE: the caret stays at the same
         absolute position in the document regardless of any document
         updates, except when document length becomes less than
         the current caret position due to removal. In that case caret
         position is adjusted to the end of the document.
         The caret doesn't try to keep itself visible by scrolling
         the associated view when using this policy.
     ALWAYS_UPDATE: the caret always tracks document
         changes. For regular changes it increases its position
         if an insertion occurs before or at its current position,
         and decreases position if a removal occurs before
         its current position. For undo/redo updates it is always
         moved to the position where update occurred. The caret
         also tries to keep itself visible by calling
         adjustVisibility method.
     UPDATE_WHEN_ON_EDT: acts like ALWAYS_UPDATE
         if the document updates are performed on the Event Dispatching Thread
         and like NEVER_UPDATE if updates are performed on
         other thread.

   The default property value is UPDATE_WHEN_ON_EDT.

  policy - one of the following values : UPDATE_WHEN_ON_EDT, NEVER_UPDATE, ALWAYS_UPDATE - `int`

  throws: java.lang.IllegalArgumentException - if invalid value is passed"
  ([^javax.swing.text.DefaultCaret this ^Integer policy]
    (-> this (.setUpdatePolicy policy))))

(defn to-string
  "Description copied from class: Rectangle

  returns: a String representing this
                 Rectangle object's coordinate and size values. - `java.lang.String`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.toString))))

(defn get-mark-bias
  "Returns the bias of the mark.

  returns: the bias of the mark - `javax.swing.text.Position.Bias`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.getMarkBias))))

(defn mouse-pressed
  "If button 1 is pressed, this is implemented to
   request focus on the associated text component,
   and to set the caret position. If the shift key is held down,
   the caret will be moved, potentially resulting in a selection,
   otherwise the
   caret position will be set to the new location.  If the component
   is not enabled, there will be no request for focus.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^javax.swing.text.DefaultCaret this ^java.awt.event.MouseEvent e]
    (-> this (.mousePressed e))))

(defn mouse-released
  "Called when the mouse is released.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^javax.swing.text.DefaultCaret this ^java.awt.event.MouseEvent e]
    (-> this (.mouseReleased e))))

(defn set-magic-caret-position
  "Saves the current caret position.  This is used when
   caret up/down actions occur, moving between lines
   that have uneven end positions.

  p - the position - `java.awt.Point`"
  ([^javax.swing.text.DefaultCaret this ^java.awt.Point p]
    (-> this (.setMagicCaretPosition p))))

(defn remove-change-listener
  "Removes a listener that was tracking caret position changes.

  l - the listener - `javax.swing.event.ChangeListener`"
  ([^javax.swing.text.DefaultCaret this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn get-change-listeners
  "Returns an array of all the change listeners
   registered on this caret.

  returns: all of this caret's ChangeListeners
           or an empty
           array if no change listeners are currently registered - `javax.swing.event.ChangeListener[]`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.getChangeListeners))))

(defn focus-lost
  "Called when the component containing the caret loses
   focus.  This is implemented to set the caret to visibility
   to false.

  e - the focus event - `java.awt.event.FocusEvent`"
  ([^javax.swing.text.DefaultCaret this ^java.awt.event.FocusEvent e]
    (-> this (.focusLost e))))

(defn install
  "Called when the UI is being installed into the
   interface of a JTextComponent.  This can be used
   to gain access to the model that is being navigated
   by the implementation of this interface.  Sets the dot
   and mark to 0, and establishes document, property change,
   focus, mouse, and mouse motion listeners.

  c - the component - `javax.swing.text.JTextComponent`"
  ([^javax.swing.text.DefaultCaret this ^javax.swing.text.JTextComponent c]
    (-> this (.install c))))

(defn get-blink-rate
  "Gets the caret blink rate.

  returns: the delay in milliseconds.  If this is
    zero the caret will not blink. - `int`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.getBlinkRate))))

(defn mouse-exited
  "Called when the mouse exits a region.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^javax.swing.text.DefaultCaret this ^java.awt.event.MouseEvent e]
    (-> this (.mouseExited e))))

(defn get-mark
  "Fetches the current position of the mark.  If there is a selection,
   the dot and mark will not be the same.

  returns: the position >= 0 - `int`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.getMark))))

(defn paint
  "Renders the caret as a vertical line.  If this is reimplemented
   the damage method should also be reimplemented as it assumes the
   shape of the caret is a vertical line.  Sets the caret color to
   the value returned by getCaretColor().

   If there are multiple text directions present in the associated
   document, a flag indicating the caret bias will be rendered.
   This will occur only if the associated document is a subclass
   of AbstractDocument and there are multiple bidi levels present
   in the bidi element structure (i.e. the text has multiple
   directions associated with it).

  g - the graphics context - `java.awt.Graphics`"
  ([^javax.swing.text.DefaultCaret this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn selection-visible?
  "Checks whether the current selection is visible.

  returns: true if the selection is visible - `boolean`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.isSelectionVisible))))

(defn set-visible
  "Sets the caret visibility, and repaints the caret.
   It is important to understand the relationship between this method,
   isVisible and isActive.
   Calling this method with a value of true activates the
   caret blinking. Setting it to false turns it completely off.
   To determine whether the blinking is active, you should call
   isActive. In effect, isActive is an
   appropriate corresponding `getter` method for this one.
   isVisible can be used to fetch the current
   visibility status of the caret, meaning whether or not it is currently
   painted. This status will change as the caret blinks on and off.

   Here's a list showing the potential return values of both
   isActive and isVisible
   after calling this method:

   setVisible(true):

       isActive(): true
       isVisible(): true or false depending on whether
           or not the caret is blinked on or off


   setVisible(false):

       isActive(): false
       isVisible(): false

  e - the visibility specifier - `boolean`"
  ([^javax.swing.text.DefaultCaret this ^Boolean e]
    (-> this (.setVisible e))))

(defn deinstall
  "Called when the UI is being removed from the
   interface of a JTextComponent.  This is used to
   unregister any listeners that were attached.

  c - the component - `javax.swing.text.JTextComponent`"
  ([^javax.swing.text.DefaultCaret this ^javax.swing.text.JTextComponent c]
    (-> this (.deinstall c))))

(defn mouse-entered
  "Called when the mouse enters a region.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^javax.swing.text.DefaultCaret this ^java.awt.event.MouseEvent e]
    (-> this (.mouseEntered e))))

(defn visible?
  "Indicates whether or not the caret is currently visible. As the
   caret flashes on and off the return value of this will change
   between true, when the caret is painted, and false, when the
   caret is not painted. isActive indicates whether
   or not the caret is in a blinking state, such that it can
   be visible, and isVisible indicates whether or not
   the caret is actually visible.

   Subclasses that wish to render a different flashing caret
   should override paint and only paint the caret if this method
   returns true.

  returns: true if visible else false - `boolean`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.isVisible))))

(defn set-selection-visible
  "Changes the selection visibility.

  vis - the new visibility - `boolean`"
  ([^javax.swing.text.DefaultCaret this ^Boolean vis]
    (-> this (.setSelectionVisible vis))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this caret.
   FooListeners are registered using the
   addFooListener method.



   You can specify the listenerType argument
   with a class literal,
   such as
   FooListener.class.
   For example, you can query a
   DefaultCaret c
   for its change listeners with the following code:



  ChangeListener[] cls = (ChangeListener[])(c.getListeners(ChangeListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners on this component,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^javax.swing.text.DefaultCaret this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn get-update-policy
  "Gets the caret movement policy on document updates.

  returns: one of the following values : UPDATE_WHEN_ON_EDT,
   NEVER_UPDATE, ALWAYS_UPDATE - `int`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.getUpdatePolicy))))

(defn mouse-dragged
  "Moves the caret position
   according to the mouse pointer's current
   location.  This effectively extends the
   selection.  By default, this is only done
   for mouse button 1.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^javax.swing.text.DefaultCaret this ^java.awt.event.MouseEvent e]
    (-> this (.mouseDragged e))))

(defn get-dot-bias
  "Returns the bias of the caret position.

  returns: the bias of the caret position - `javax.swing.text.Position.Bias`"
  ([^javax.swing.text.DefaultCaret this]
    (-> this (.getDotBias))))

(defn equals
  "Compares this object to the specified object.
   The superclass behavior of comparing rectangles
   is not desired, so this is changed to the Object
   behavior.

  obj - the object to compare this font with - `java.lang.Object`

  returns: true if the objects are equal;
              false otherwise - `boolean`"
  ([^javax.swing.text.DefaultCaret this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn mouse-clicked
  "Called when the mouse is clicked.  If the click was generated
   from button1, a double click selects a word,
   and a triple click the current line.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^javax.swing.text.DefaultCaret this ^java.awt.event.MouseEvent e]
    (-> this (.mouseClicked e))))

(defn set-dot
  "Sets the caret position and mark to the specified position, with the
   specified bias. This implicitly sets the selection range
   to zero.

  dot - the position >= 0 - `int`
  dot-bias - the bias for this position, not null - `javax.swing.text.Position.Bias`

  throws: java.lang.IllegalArgumentException - if the bias is null"
  ([^javax.swing.text.DefaultCaret this ^Integer dot ^javax.swing.text.Position.Bias dot-bias]
    (-> this (.setDot dot dot-bias)))
  ([^javax.swing.text.DefaultCaret this ^Integer dot]
    (-> this (.setDot dot))))

