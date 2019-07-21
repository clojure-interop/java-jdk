(ns jdk.awt.AWTEventMulticaster
  "AWTEventMulticaster implements efficient and thread-safe multi-cast
  event dispatching for the AWT events defined in the java.awt.event
  package.

  The following example illustrates how to use this class:



  public myComponent extends Component {
      ActionListener actionListener = null;

      public synchronized void addActionListener(ActionListener l) {
          actionListener = AWTEventMulticaster.add(actionListener, l);
      }
      public synchronized void removeActionListener(ActionListener l) {
          actionListener = AWTEventMulticaster.remove(actionListener, l);
      }
      public void processEvent(AWTEvent e) {
          // when event occurs which causes \"action\" semantic
          ActionListener listener = actionListener;
          if (listener != null) {
              listener.actionPerformed(new ActionEvent());
          }
      }
  }
  The important point to note is the first argument to the add and remove methods is the field maintaining the
  listeners. In addition you must assign the result of the add
  and remove methods to the field maintaining the listeners.

  AWTEventMulticaster is implemented as a pair of EventListeners that are set at construction time. AWTEventMulticaster is immutable. The add and remove methods do not alter AWTEventMulticaster in
  anyway. If necessary, a new AWTEventMulticaster is
  created. In this way it is safe to add and remove listeners during
  the process of an event dispatching.  However, event listeners
  added during the process of an event dispatch operation are not
  notified of the event currently being dispatched.

  All of the add methods allow null arguments. If the
  first argument is null, the second argument is returned. If
  the first argument is not null and the second argument is
  null, the first argument is returned. If both arguments are
  non-null, a new AWTEventMulticaster is created using
  the two arguments and returned.

  For the remove methods that take two arguments, the following is
  returned:

    null, if the first argument is null, or
        the arguments are equal, by way of ==.
    the first argument, if the first argument is not an instance of
        AWTEventMulticaster.
    result of invoking remove(EventListener) on the
        first argument, supplying the second argument to the
        remove(EventListener) method.

  Swing makes use of
  EventListenerList for
  similar logic. Refer to it for details."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt AWTEventMulticaster]))

(defn *add
  "Adds component-listener-a with component-listener-b and
   returns the resulting multicast listener.

  a - component-listener-a - `java.awt.event.ComponentListener`
  b - component-listener-b - `java.awt.event.ComponentListener`

  returns: `java.awt.event.ComponentListener`"
  (^java.awt.event.ComponentListener [^java.awt.event.ComponentListener a ^java.awt.event.ComponentListener b]
    (AWTEventMulticaster/add a b)))

(defn *remove
  "Removes the old component-listener from component-listener-l and
   returns the resulting multicast listener.

  l - component-listener-l - `java.awt.event.ComponentListener`
  oldl - the component-listener being removed - `java.awt.event.ComponentListener`

  returns: `java.awt.event.ComponentListener`"
  (^java.awt.event.ComponentListener [^java.awt.event.ComponentListener l ^java.awt.event.ComponentListener oldl]
    (AWTEventMulticaster/remove l oldl)))

(defn *get-listeners
  "Returns an array of all the objects chained as
   FooListeners by the specified
   java.util.EventListener.
   FooListeners are chained by the
   AWTEventMulticaster using the
   addFooListener method.
   If a null listener is specified, this method returns an
   empty array. If the specified listener is not an instance of
   AWTEventMulticaster, this method returns an array which
   contains only the specified listener. If no such listeners are chained,
   this method returns an empty array.

  l - the specified java.util.EventListener - `java.util.EventListener`
  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class`

  returns: an array of all objects chained as
            FooListeners by the specified multicast
            listener, or an empty array if no such listeners have been
            chained by the specified multicast listener - `<T extends java.util.EventListener> T[]`

  throws: java.lang.NullPointerException - if the specified listenertype parameter is null"
  ([^java.util.EventListener l ^java.lang.Class listener-type]
    (AWTEventMulticaster/getListeners l listener-type)))

(defn component-removed
  "Handles the componentRemoved container event by invoking the
   componentRemoved methods on listener-a and listener-b.

  e - the component event - `java.awt.event.ContainerEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.ContainerEvent e]
    (-> this (.componentRemoved e))))

(defn window-opened
  "Handles the windowOpened event by invoking the
   windowOpened methods on listener-a and listener-b.

  e - the window event - `java.awt.event.WindowEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.WindowEvent e]
    (-> this (.windowOpened e))))

(defn window-state-changed
  "Handles the windowStateChanged event by invoking the
   windowStateChanged methods on listener-a and listener-b.

  e - the window event - `java.awt.event.WindowEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.WindowEvent e]
    (-> this (.windowStateChanged e))))

(defn mouse-moved
  "Handles the mouseMoved event by invoking the
   mouseMoved methods on listener-a and listener-b.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^AWTEventMulticaster this e]
    (-> this (.mouseMoved e))))

(defn adjustment-value-changed
  "Handles the adjustmentValueChanged event by invoking the
   adjustmentValueChanged methods on listener-a and listener-b.

  e - the adjustment event - `java.awt.event.AdjustmentEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.AdjustmentEvent e]
    (-> this (.adjustmentValueChanged e))))

(defn key-typed
  "Handles the keyTyped event by invoking the
   keyTyped methods on listener-a and listener-b.

  e - the key event - `java.awt.event.KeyEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.KeyEvent e]
    (-> this (.keyTyped e))))

(defn component-resized
  "Handles the componentResized event by invoking the
   componentResized methods on listener-a and listener-b.

  e - the component event - `java.awt.event.ComponentEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.ComponentEvent e]
    (-> this (.componentResized e))))

(defn caret-position-changed
  "Handles the caretPositionChanged event by invoking the
   caretPositionChanged methods on listener-a and listener-b.

  e - the item event - `java.awt.event.InputMethodEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.InputMethodEvent e]
    (-> this (.caretPositionChanged e))))

(defn focus-gained
  "Handles the focusGained event by invoking the
   focusGained methods on listener-a and listener-b.

  e - the focus event - `java.awt.event.FocusEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.FocusEvent e]
    (-> this (.focusGained e))))

(defn mouse-wheel-moved
  "Handles the mouseWheelMoved event by invoking the
   mouseWheelMoved methods on listener-a and listener-b.

  e - the mouse event - `java.awt.event.MouseWheelEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.MouseWheelEvent e]
    (-> this (.mouseWheelMoved e))))

(defn ancestor-resized
  "Handles the ancestorResized event by invoking the
   ancestorResized methods on listener-a and listener-b.

  e - the item event - `java.awt.event.HierarchyEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.HierarchyEvent e]
    (-> this (.ancestorResized e))))

(defn window-gained-focus
  "Handles the windowGainedFocus event by invoking the windowGainedFocus
   methods on listener-a and listener-b.

  e - the window event - `java.awt.event.WindowEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.WindowEvent e]
    (-> this (.windowGainedFocus e))))

(defn input-method-text-changed
  "Handles the inputMethodTextChanged event by invoking the
   inputMethodTextChanged methods on listener-a and listener-b.

  e - the item event - `java.awt.event.InputMethodEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.InputMethodEvent e]
    (-> this (.inputMethodTextChanged e))))

(defn window-closing
  "Handles the windowClosing event by invoking the
   windowClosing methods on listener-a and listener-b.

  e - the window event - `java.awt.event.WindowEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.WindowEvent e]
    (-> this (.windowClosing e))))

(defn mouse-pressed
  "Handles the mousePressed event by invoking the
   mousePressed methods on listener-a and listener-b.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^AWTEventMulticaster this e]
    (-> this (.mousePressed e))))

(defn mouse-released
  "Handles the mouseReleased event by invoking the
   mouseReleased methods on listener-a and listener-b.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^AWTEventMulticaster this e]
    (-> this (.mouseReleased e))))

(defn key-pressed
  "Handles the keyPressed event by invoking the
   keyPressed methods on listener-a and listener-b.

  e - the key event - `java.awt.event.KeyEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.KeyEvent e]
    (-> this (.keyPressed e))))

(defn focus-lost
  "Handles the focusLost event by invoking the
   focusLost methods on listener-a and listener-b.

  e - the focus event - `java.awt.event.FocusEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.FocusEvent e]
    (-> this (.focusLost e))))

(defn component-hidden
  "Handles the componentHidden event by invoking the
   componentHidden methods on listener-a and listener-b.

  e - the component event - `java.awt.event.ComponentEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.ComponentEvent e]
    (-> this (.componentHidden e))))

(defn ancestor-moved
  "Handles the ancestorMoved event by invoking the
   ancestorMoved methods on listener-a and listener-b.

  e - the item event - `java.awt.event.HierarchyEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.HierarchyEvent e]
    (-> this (.ancestorMoved e))))

(defn window-closed
  "Handles the windowClosed event by invoking the
   windowClosed methods on listener-a and listener-b.

  e - the window event - `java.awt.event.WindowEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.WindowEvent e]
    (-> this (.windowClosed e))))

(defn key-released
  "Handles the keyReleased event by invoking the
   keyReleased methods on listener-a and listener-b.

  e - the key event - `java.awt.event.KeyEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.KeyEvent e]
    (-> this (.keyReleased e))))

(defn component-moved
  "Handles the componentMoved event by invoking the
   componentMoved methods on listener-a and listener-b.

  e - the component event - `java.awt.event.ComponentEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.ComponentEvent e]
    (-> this (.componentMoved e))))

(defn mouse-exited
  "Handles the mouseExited event by invoking the
   mouseExited methods on listener-a and listener-b.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^AWTEventMulticaster this e]
    (-> this (.mouseExited e))))

(defn component-shown
  "Handles the componentShown event by invoking the
   componentShown methods on listener-a and listener-b.

  e - the component event - `java.awt.event.ComponentEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.ComponentEvent e]
    (-> this (.componentShown e))))

(defn window-activated
  "Handles the windowActivated event by invoking the
   windowActivated methods on listener-a and listener-b.

  e - the window event - `java.awt.event.WindowEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.WindowEvent e]
    (-> this (.windowActivated e))))

(defn action-performed
  "Handles the actionPerformed event by invoking the
   actionPerformed methods on listener-a and listener-b.

  e - the action event - `java.awt.event.ActionEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.ActionEvent e]
    (-> this (.actionPerformed e))))

(defn window-iconified
  "Handles the windowIconified event by invoking the
   windowIconified methods on listener-a and listener-b.

  e - the window event - `java.awt.event.WindowEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.WindowEvent e]
    (-> this (.windowIconified e))))

(defn mouse-entered
  "Handles the mouseEntered event by invoking the
   mouseEntered methods on listener-a and listener-b.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^AWTEventMulticaster this e]
    (-> this (.mouseEntered e))))

(defn component-added
  "Handles the componentAdded container event by invoking the
   componentAdded methods on listener-a and listener-b.

  e - the component event - `java.awt.event.ContainerEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.ContainerEvent e]
    (-> this (.componentAdded e))))

(defn window-deactivated
  "Handles the windowDeactivated event by invoking the
   windowDeactivated methods on listener-a and listener-b.

  e - the window event - `java.awt.event.WindowEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.WindowEvent e]
    (-> this (.windowDeactivated e))))

(defn window-lost-focus
  "Handles the windowLostFocus event by invoking the windowLostFocus
   methods on listener-a and listener-b.

  e - the window event - `java.awt.event.WindowEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.WindowEvent e]
    (-> this (.windowLostFocus e))))

(defn text-value-changed
  "Description copied from interface: TextListener

  e - `java.awt.event.TextEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.TextEvent e]
    (-> this (.textValueChanged e))))

(defn window-deiconified
  "Handles the windowDeiconfied event by invoking the
   windowDeiconified methods on listener-a and listener-b.

  e - the window event - `java.awt.event.WindowEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.WindowEvent e]
    (-> this (.windowDeiconified e))))

(defn mouse-dragged
  "Handles the mouseDragged event by invoking the
   mouseDragged methods on listener-a and listener-b.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^AWTEventMulticaster this e]
    (-> this (.mouseDragged e))))

(defn item-state-changed
  "Handles the itemStateChanged event by invoking the
   itemStateChanged methods on listener-a and listener-b.

  e - the item event - `java.awt.event.ItemEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.ItemEvent e]
    (-> this (.itemStateChanged e))))

(defn mouse-clicked
  "Handles the mouseClicked event by invoking the
   mouseClicked methods on listener-a and listener-b.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^AWTEventMulticaster this e]
    (-> this (.mouseClicked e))))

(defn hierarchy-changed
  "Handles the hierarchyChanged event by invoking the
   hierarchyChanged methods on listener-a and listener-b.

  e - the item event - `java.awt.event.HierarchyEvent`"
  ([^AWTEventMulticaster this ^java.awt.event.HierarchyEvent e]
    (-> this (.hierarchyChanged e))))

