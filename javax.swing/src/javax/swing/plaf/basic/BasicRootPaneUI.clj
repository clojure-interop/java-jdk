(ns javax.swing.plaf.basic.BasicRootPaneUI
  "Basic implementation of RootPaneUI, there is one shared between all
  JRootPane instances."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicRootPaneUI]))

(defn ->basic-root-pane-ui
  "Constructor."
  ([]
    (new BasicRootPaneUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([c]
    (BasicRootPaneUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([this c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([this c]
    (-> this (.uninstallUI c))))

(defn property-change
  "Invoked when a property changes on the root pane. If the event
   indicates the defaultButton has changed, this will
   reinstall the keyboard actions.

  e - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([this e]
    (-> this (.propertyChange e))))

