(ns javax.swing.plaf.metal.MetalProgressBarUI
  "The Metal implementation of ProgressBarUI.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalProgressBarUI]))

(defn ->metal-progress-bar-ui
  "Constructor."
  ([]
    (new MetalProgressBarUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([c]
    (MetalProgressBarUI/createUI c)))

(defn paint-determinate
  "Draws a bit of special highlighting on the progress bar.
   The core painting is deferred to the BasicProgressBar's
   paintDeterminate method.

  g - `java.awt.Graphics`
  c - `javax.swing.JComponent`"
  ([this g c]
    (-> this (.paintDeterminate g c))))

(defn paint-indeterminate
  "Draws a bit of special highlighting on the progress bar
   and bouncing box.
   The core painting is deferred to the BasicProgressBar's
   paintIndeterminate method.

  g - `java.awt.Graphics`
  c - `javax.swing.JComponent`"
  ([this g c]
    (-> this (.paintIndeterminate g c))))

