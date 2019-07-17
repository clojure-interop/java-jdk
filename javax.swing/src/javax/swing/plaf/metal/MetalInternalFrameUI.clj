(ns javax.swing.plaf.metal.MetalInternalFrameUI
  "Metal implementation of JInternalFrame."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalInternalFrameUI]))

(defn ->metal-internal-frame-ui
  "Constructor.

  b - `javax.swing.JInternalFrame`"
  ([b]
    (new MetalInternalFrameUI b)))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([c]
    (MetalInternalFrameUI/createUI c)))

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

(defn set-palette
  "is-palette - `boolean`"
  ([this is-palette]
    (-> this (.setPalette is-palette))))

