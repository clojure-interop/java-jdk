(ns javax.swing.plaf.multi.MultiPopupMenuUI
  "A multiplexing UI used to combine PopupMenuUIs.

  This file was automatically generated by AutoMulti."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.multi MultiPopupMenuUI]))

(defn ->multi-popup-menu-ui
  "Constructor."
  (^MultiPopupMenuUI []
    (new MultiPopupMenuUI )))

(defn *create-ui
  "Returns a multiplexing UI instance if any of the auxiliary
   LookAndFeels supports this UI.  Otherwise, just returns the
   UI object obtained from the default LookAndFeel.

  a - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent a]
    (MultiPopupMenuUI/createUI a)))

(defn install-ui
  "Invokes the installUI method on each UI handled by this object.

  a - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^MultiPopupMenuUI this ^javax.swing.JComponent a]
    (-> this (.installUI a))))

(defn get-minimum-size
  "Invokes the getMinimumSize method on each UI handled by this object.

  a - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: the value obtained from the first UI, which is
   the UI obtained from the default LookAndFeel - `java.awt.Dimension`"
  (^java.awt.Dimension [^MultiPopupMenuUI this ^javax.swing.JComponent a]
    (-> this (.getMinimumSize a))))

(defn get-maximum-size
  "Invokes the getMaximumSize method on each UI handled by this object.

  a - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: the value obtained from the first UI, which is
   the UI obtained from the default LookAndFeel - `java.awt.Dimension`"
  (^java.awt.Dimension [^MultiPopupMenuUI this ^javax.swing.JComponent a]
    (-> this (.getMaximumSize a))))

(defn get-accessible-child
  "Invokes the getAccessibleChild method on each UI handled by this object.

  a - `javax.swing.JComponent`
  b - `int`

  returns: the value obtained from the first UI, which is
   the UI obtained from the default LookAndFeel - `javax.accessibility.Accessible`"
  (^javax.accessibility.Accessible [^MultiPopupMenuUI this ^javax.swing.JComponent a ^Integer b]
    (-> this (.getAccessibleChild a b))))

(defn get-u-is
  "Returns the list of UIs associated with this multiplexing UI.  This
   allows processing of the UIs by an application aware of multiplexing
   UIs on components.

  returns: `javax.swing.plaf.ComponentUI[]`"
  ([^MultiPopupMenuUI this]
    (-> this (.getUIs))))

(defn uninstall-ui
  "Invokes the uninstallUI method on each UI handled by this object.

  a - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^MultiPopupMenuUI this ^javax.swing.JComponent a]
    (-> this (.uninstallUI a))))

(defn contains
  "Invokes the contains method on each UI handled by this object.

  a - the component where the x,y location is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`
  b - the x coordinate of the point - `int`
  c - the y coordinate of the point - `int`

  returns: the value obtained from the first UI, which is
   the UI obtained from the default LookAndFeel - `boolean`"
  (^Boolean [^MultiPopupMenuUI this ^javax.swing.JComponent a ^Integer b ^Integer c]
    (-> this (.contains a b c))))

(defn popup-trigger?
  "Invokes the isPopupTrigger method on each UI handled by this object.

  a - `java.awt.event.MouseEvent`

  returns: the value obtained from the first UI, which is
   the UI obtained from the default LookAndFeel - `boolean`"
  (^Boolean [^MultiPopupMenuUI this a]
    (-> this (.isPopupTrigger a))))

(defn update
  "Invokes the update method on each UI handled by this object.

  a - the Graphics context in which to paint - `java.awt.Graphics`
  b - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^MultiPopupMenuUI this ^java.awt.Graphics a ^javax.swing.JComponent b]
    (-> this (.update a b))))

(defn get-accessible-children-count
  "Invokes the getAccessibleChildrenCount method on each UI handled by this object.

  a - `javax.swing.JComponent`

  returns: the value obtained from the first UI, which is
   the UI obtained from the default LookAndFeel - `int`"
  (^Integer [^MultiPopupMenuUI this ^javax.swing.JComponent a]
    (-> this (.getAccessibleChildrenCount a))))

(defn paint
  "Invokes the paint method on each UI handled by this object.

  a - the Graphics context in which to paint - `java.awt.Graphics`
  b - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^MultiPopupMenuUI this ^java.awt.Graphics a ^javax.swing.JComponent b]
    (-> this (.paint a b))))

(defn get-popup
  "Invokes the getPopup method on each UI handled by this object.

  a - JPopupMenu requesting Popup - `javax.swing.JPopupMenu`
  b - Screen x location Popup is to be shown at - `int`
  c - Screen y location Popup is to be shown at. - `int`

  returns: the value obtained from the first UI, which is
   the UI obtained from the default LookAndFeel - `javax.swing.Popup`"
  (^javax.swing.Popup [^MultiPopupMenuUI this ^javax.swing.JPopupMenu a ^Integer b ^Integer c]
    (-> this (.getPopup a b c))))

(defn get-preferred-size
  "Invokes the getPreferredSize method on each UI handled by this object.

  a - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: the value obtained from the first UI, which is
   the UI obtained from the default LookAndFeel - `java.awt.Dimension`"
  (^java.awt.Dimension [^MultiPopupMenuUI this ^javax.swing.JComponent a]
    (-> this (.getPreferredSize a))))

