(ns javax.swing.plaf.basic.BasicTextPaneUI
  "Provides the look and feel for a styled text editor.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicTextPaneUI]))

(defn ->basic-text-pane-ui
  "Constructor.

  Creates a new BasicTextPaneUI."
  (^BasicTextPaneUI []
    (new BasicTextPaneUI )))

(defn *create-ui
  "Creates a UI for the JTextPane.

  c - the JTextPane object - `javax.swing.JComponent`

  returns: the UI - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicTextPaneUI/createUI c)))

(defn install-ui
  "Description copied from class: BasicEditorPaneUI

  c - the editor component - `javax.swing.JComponent`"
  ([^BasicTextPaneUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

