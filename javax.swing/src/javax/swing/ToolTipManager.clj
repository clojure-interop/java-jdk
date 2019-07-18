(ns javax.swing.ToolTipManager
  "Manages all the ToolTips in the system.

  ToolTipManager contains numerous properties for configuring how long it
  will take for the tooltips to become visible, and how long till they
  hide. Consider a component that has a different tooltip based on where
  the mouse is, such as JTree. When the mouse moves into the JTree and
  over a region that has a valid tooltip, the tooltip will become
  visible after initialDelay milliseconds. After
  dismissDelay milliseconds the tooltip will be hidden. If
  the mouse is over a region that has a valid tooltip, and the tooltip
  is currently visible, when the mouse moves to a region that doesn't have
  a valid tooltip the tooltip will be hidden. If the mouse then moves back
  into a region that has a valid tooltip within reshowDelay
  milliseconds, the tooltip will immediately be shown, otherwise the
  tooltip will be shown again after initialDelay milliseconds."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ToolTipManager]))

(defn *shared-instance
  "Returns a shared ToolTipManager instance.

  returns: a shared ToolTipManager object - `javax.swing.ToolTipManager`"
  (^javax.swing.ToolTipManager []
    (ToolTipManager/sharedInstance )))

(defn set-reshow-delay
  "Used to specify the amount of time before the user has to wait
   initialDelay milliseconds before a tooltip will be
   shown. That is, if the tooltip is hidden, and the user moves into
   a region of the same Component that has a valid tooltip within
   milliseconds milliseconds the tooltip will immediately
   be shown. Otherwise, if the user moves into a region with a valid
   tooltip after milliseconds milliseconds, the user
   will have to wait an additional initialDelay
   milliseconds before the tooltip is shown again.

  milliseconds - time in milliseconds - `int`"
  ([^ToolTipManager this ^Integer milliseconds]
    (-> this (.setReshowDelay milliseconds))))

(defn light-weight-popup-enabled?
  "Returns true if lightweight (all-Java) Tooltips
   are in use, or false if heavyweight (native peer)
   Tooltips are being used.

  returns: true if lightweight ToolTips are in use - `boolean`"
  (^Boolean [^ToolTipManager this]
    (-> this (.isLightWeightPopupEnabled))))

(defn set-dismiss-delay
  "Specifies the dismissal delay value.

  milliseconds - the number of milliseconds to delay before taking away the tooltip - `int`"
  ([^ToolTipManager this ^Integer milliseconds]
    (-> this (.setDismissDelay milliseconds))))

(defn unregister-component
  "Removes a component from tooltip control.

  component - a JComponent object to remove - `javax.swing.JComponent`"
  ([^ToolTipManager this ^javax.swing.JComponent component]
    (-> this (.unregisterComponent component))))

(defn mouse-moved
  "Called when the mouse is moved.
    Determines whether the tool tip should be displayed.

  event - the event in question - `java.awt.event.MouseEvent`"
  ([^ToolTipManager this event]
    (-> this (.mouseMoved event))))

(defn set-initial-delay
  "Specifies the initial delay value.

  milliseconds - the number of milliseconds to delay (after the cursor has paused) before displaying the tooltip - `int`"
  ([^ToolTipManager this ^Integer milliseconds]
    (-> this (.setInitialDelay milliseconds))))

(defn register-component
  "Registers a component for tooltip management.

   This will register key bindings to show and hide the tooltip text
   only if component has focus bindings. This is done
   so that components that are not normally focus traversable, such
   as JLabel, are not made focus traversable as a result
   of invoking this method.

  component - a JComponent object to add - `javax.swing.JComponent`"
  ([^ToolTipManager this ^javax.swing.JComponent component]
    (-> this (.registerComponent component))))

(defn get-dismiss-delay
  "Returns the dismissal delay value.

  returns: an integer representing the dismissal delay value,
            in milliseconds - `int`"
  (^Integer [^ToolTipManager this]
    (-> this (.getDismissDelay))))

(defn get-reshow-delay
  "Returns the reshow delay property.

  returns: reshown delay property - `int`"
  (^Integer [^ToolTipManager this]
    (-> this (.getReshowDelay))))

(defn mouse-pressed
  "Called when the mouse is pressed.
    Any tool tip showing should be hidden.

  event - the event in question - `java.awt.event.MouseEvent`"
  ([^ToolTipManager this event]
    (-> this (.mousePressed event))))

(defn get-initial-delay
  "Returns the initial delay value.

  returns: an integer representing the initial delay value,
            in milliseconds - `int`"
  (^Integer [^ToolTipManager this]
    (-> this (.getInitialDelay))))

(defn mouse-exited
  "Called when the mouse exits the region of a component.
    Any tool tip showing should be hidden.

  event - the event in question - `java.awt.event.MouseEvent`"
  ([^ToolTipManager this event]
    (-> this (.mouseExited event))))

(defn set-enabled
  "Enables or disables the tooltip.

  flag - true to enable the tip, false otherwise - `boolean`"
  ([^ToolTipManager this ^Boolean flag]
    (-> this (.setEnabled flag))))

(defn mouse-entered
  "Called when the mouse enters the region of a component.
    This determines whether the tool tip should be shown.

  event - the event in question - `java.awt.event.MouseEvent`"
  ([^ToolTipManager this event]
    (-> this (.mouseEntered event))))

(defn set-light-weight-popup-enabled
  "When displaying the JToolTip, the
   ToolTipManager chooses to use a lightweight
   JPanel if it fits. This method allows you to
   disable this feature. You have to do disable it if your
   application mixes light weight and heavy weights components.

  a-flag - true if a lightweight panel is desired, false otherwise - `boolean`"
  ([^ToolTipManager this ^Boolean a-flag]
    (-> this (.setLightWeightPopupEnabled a-flag))))

(defn mouse-dragged
  "Called when the mouse is pressed and dragged.
    Does nothing.

  event - the event in question - `java.awt.event.MouseEvent`"
  ([^ToolTipManager this event]
    (-> this (.mouseDragged event))))

(defn enabled?
  "Returns true if this object is enabled.

  returns: true if this object is enabled, false otherwise - `boolean`"
  (^Boolean [^ToolTipManager this]
    (-> this (.isEnabled))))

