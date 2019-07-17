(ns javax.swing.plaf.basic.BasicEditorPaneUI
  "Provides the look and feel for a JEditorPane.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicEditorPaneUI]))

(defn ->basic-editor-pane-ui
  "Constructor.

  Creates a new BasicEditorPaneUI."
  ([]
    (new BasicEditorPaneUI )))

(defn *create-ui
  "Creates a UI for the JTextPane.

  c - the JTextPane component - `javax.swing.JComponent`

  returns: the UI - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicEditorPaneUI/createUI c)))

(defn install-ui
  "Installs the UI for a component.  This does the following
   things.


   Sets the associated component to opaque if the opaque property
   has not already been set by the client program. This will cause the
   component's background color to be painted.

   Installs the default caret and highlighter into the
   associated component. These properties are only set if their
   current value is either null or an instance of
   UIResource.

   Attaches to the editor and model.  If there is no
   model, a default one is created.

   Creates the view factory and the view hierarchy used
   to represent the model.

  c - the editor component - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicEditorPaneUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Deinstalls the UI for a component.  This removes the listeners,
   uninstalls the highlighter, removes views, and nulls out the keymap.

  c - the editor component - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicEditorPaneUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-editor-kit
  "Fetches the EditorKit for the UI.  This is whatever is
   currently set in the associated JEditorPane.

  tc - the text component for which this UI is installed - `javax.swing.text.JTextComponent`

  returns: the editor capabilities - `javax.swing.text.EditorKit`"
  (^javax.swing.text.EditorKit [^javax.swing.plaf.basic.BasicEditorPaneUI this ^javax.swing.text.JTextComponent tc]
    (-> this (.getEditorKit tc))))

