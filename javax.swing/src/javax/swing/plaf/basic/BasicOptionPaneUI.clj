(ns javax.swing.plaf.basic.BasicOptionPaneUI
  "Provides the basic look and feel for a JOptionPane.
  BasicMessagePaneUI provides a means to place an icon,
  message and buttons into a Container.
  Generally, the layout will look like:


         ------------------
         | i | message    |
         | c | message    |
         | o | message    |
         | n | message    |
         ------------------
         |     buttons    |
         |________________|
  icon is an instance of Icon that is wrapped inside a
  JLabel.  The message is an opaque object and is tested
  for the following: if the message is a Component it is
  added to the Container, if it is an Icon
  it is wrapped inside a JLabel and added to the
  Container otherwise it is wrapped inside a JLabel.

  The above layout is used when the option pane's
  ComponentOrientation property is horizontal, left-to-right.
  The layout will be adjusted appropriately for other orientations.

  The Container, message, icon, and buttons are all
  determined from abstract methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicOptionPaneUI]))

(defn ->basic-option-pane-ui
  "Constructor."
  ([]
    (new BasicOptionPaneUI )))

(def *-minimum-width
  "Static Constant.

  type: int"
  BasicOptionPaneUI/MinimumWidth)

(def *-minimum-height
  "Static Constant.

  type: int"
  BasicOptionPaneUI/MinimumHeight)

(defn *create-ui
  "Creates a new BasicOptionPaneUI instance.

  x - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent x]
    (BasicOptionPaneUI/createUI x)))

(defn install-ui
  "Installs the receiver as the L&F for the passed in
   JOptionPane.

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicOptionPaneUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Removes the receiver from the L&F controller of the passed in split
   pane.

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicOptionPaneUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-minimum-option-pane-size
  "Returns the minimum size the option pane should be. Primarily
   provided for subclassers wishing to offer a different minimum size.

  returns: `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicOptionPaneUI this]
    (-> this (.getMinimumOptionPaneSize))))

(defn get-preferred-size
  "If c is the JOptionPane the receiver
   is contained in, the preferred
   size that is returned is the maximum of the preferred size of
   the LayoutManager for the JOptionPane, and
   getMinimumOptionPaneSize.

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicOptionPaneUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

(defn select-initial-value
  "If inputComponent is non-null, the focus is requested on that,
   otherwise request focus on the default value

  op - `javax.swing.JOptionPane`"
  ([^javax.swing.plaf.basic.BasicOptionPaneUI this ^javax.swing.JOptionPane op]
    (-> this (.selectInitialValue op))))

(defn contains-custom-components
  "Returns true if in the last call to validateComponent the message
   or buttons contained a subclass of Component.

  op - `javax.swing.JOptionPane`

  returns: `boolean`"
  ([^javax.swing.plaf.basic.BasicOptionPaneUI this ^javax.swing.JOptionPane op]
    (-> this (.containsCustomComponents op))))

