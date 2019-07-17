(ns javax.swing.JPanel
  "JPanel is a generic lightweight container.
  For examples and task-oriented documentation for JPanel, see
  How to Use Panels,
  a section in The Java Tutorial.

  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JPanel]))

(defn ->j-panel
  "Constructor.

  Creates a new JPanel with the specified layout manager and buffering
   strategy.

  layout - the LayoutManager to use - `java.awt.LayoutManager`
  is-double-buffered - a boolean, true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates - `boolean`"
  ([layout is-double-buffered]
    (new JPanel layout is-double-buffered))
  ([layout]
    (new JPanel layout))
  ([]
    (new JPanel )))

(defn update-ui
  "Resets the UI property with a value from the current look and feel."
  ([this]
    (-> this (.updateUI))))

(defn get-ui
  "Returns the look and feel (L&amp;F) object that renders this component.

  returns: the PanelUI object that renders this component - `javax.swing.plaf.PanelUI`"
  ([this]
    (-> this (.getUI))))

(defn set-ui
  "Sets the look and feel (L&F) object that renders this component.

  ui - the PanelUI L&F object - `javax.swing.plaf.PanelUI`"
  ([this ui]
    (-> this (.setUI ui))))

(defn get-ui-class-id
  "Returns a string that specifies the name of the L&F class
   that renders this component.

  returns: `PanelUI` - `java.lang.String`"
  ([this]
    (-> this (.getUIClassID))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JPanel.
   For JPanels, the AccessibleContext takes the form of an
   AccessibleJPanel.
   A new AccessibleJPanel instance is created if necessary.

  returns: an AccessibleJPanel that serves as the
           AccessibleContext of this JPanel - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

