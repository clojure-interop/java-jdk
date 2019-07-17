(ns javax.swing.plaf.basic.ComboPopup
  "The interface which defines the methods required for the implementation of the popup
  portion of a combo box.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic ComboPopup]))

(defn show
  "Shows the popup"
  ([this]
    (-> this (.show))))

(defn hide
  "Hides the popup"
  ([this]
    (-> this (.hide))))

(defn visible?
  "Returns true if the popup is visible (currently being displayed).

  returns: true if the component is visible; false otherwise. - `boolean`"
  ([this]
    (-> this (.isVisible))))

(defn get-list
  "Returns the list that is being used to draw the items in the combo box.
   This method is highly implementation specific and should not be used
   for general list manipulation.

  returns: `javax.swing.JList`"
  ([this]
    (-> this (.getList))))

(defn get-mouse-listener
  "Returns a mouse listener that will be added to the combo box or null.
   If this method returns null then it will not be added to the combo box.

  returns: a MouseListener or null - `java.awt.event.MouseListener`"
  ([this]
    (-> this (.getMouseListener))))

(defn get-mouse-motion-listener
  "Returns a mouse motion listener that will be added to the combo box or null.
   If this method returns null then it will not be added to the combo box.

  returns: a MouseMotionListener or null - `java.awt.event.MouseMotionListener`"
  ([this]
    (-> this (.getMouseMotionListener))))

(defn get-key-listener
  "Returns a key listener that will be added to the combo box or null.
   If this method returns null then it will not be added to the combo box.

  returns: `java.awt.event.KeyListener`"
  ([this]
    (-> this (.getKeyListener))))

(defn uninstalling-ui
  "Called to inform the ComboPopup that the UI is uninstalling.
   If the ComboPopup added any listeners in the component, it should remove them here."
  ([this]
    (-> this (.uninstallingUI))))

