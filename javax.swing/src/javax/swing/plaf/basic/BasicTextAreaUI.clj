(ns javax.swing.plaf.basic.BasicTextAreaUI
  "Provides the look and feel for a plain text editor.  In this
  implementation the default UI is extended to act as a simple
  view factory.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicTextAreaUI]))

(defn ->basic-text-area-ui
  "Constructor.

  Constructs a new BasicTextAreaUI object."
  ([]
    (new BasicTextAreaUI )))

(defn *create-ui
  "Creates a UI for a JTextArea.

  ta - a text area - `javax.swing.JComponent`

  returns: the UI - `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent ta]
    (BasicTextAreaUI/createUI ta)))

(defn get-preferred-size
  "The method is overridden to take into account caret width.

  c - the editor component - `javax.swing.JComponent`

  returns: the preferred size - `java.awt.Dimension`

  throws: java.lang.IllegalArgumentException - if invalid value is passed"
  ([^javax.swing.plaf.basic.BasicTextAreaUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

(defn get-minimum-size
  "The method is overridden to take into account caret width.

  c - the editor component - `javax.swing.JComponent`

  returns: the minimum size - `java.awt.Dimension`

  throws: java.lang.IllegalArgumentException - if invalid value is passed"
  ([^javax.swing.plaf.basic.BasicTextAreaUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn create
  "Creates the view for an element.  Returns a WrappedPlainView or
   PlainView.

  elem - the element - `javax.swing.text.Element`

  returns: the view - `javax.swing.text.View`"
  ([^javax.swing.plaf.basic.BasicTextAreaUI this ^javax.swing.text.Element elem]
    (-> this (.create elem))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  ([^javax.swing.plaf.basic.BasicTextAreaUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  ([^javax.swing.plaf.basic.BasicTextAreaUI this ^javax.swing.JComponent c]
    (-> this (.getBaselineResizeBehavior c))))

