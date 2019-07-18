(ns javax.swing.ViewportLayout
  "The default layout manager for JViewport.
  ViewportLayout defines
  a policy for layout that should be useful for most applications.
  The viewport makes its view the same size as the viewport,
  however it will not make the view smaller than its minimum size.
  As the viewport grows the view is kept bottom justified until
  the entire view is visible, subsequently the view is kept top
  justified.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ViewportLayout]))

(defn ->viewport-layout
  "Constructor."
  (^ViewportLayout []
    (new ViewportLayout )))

(defn add-layout-component
  "Adds the specified component to the layout. Not used by this class.

  name - the name of the component - `java.lang.String`
  c - the the component to be added - `java.awt.Component`"
  ([^ViewportLayout this ^java.lang.String name ^java.awt.Component c]
    (-> this (.addLayoutComponent name c))))

(defn remove-layout-component
  "Removes the specified component from the layout. Not used by
   this class.

  c - the component to remove - `java.awt.Component`"
  ([^ViewportLayout this ^java.awt.Component c]
    (-> this (.removeLayoutComponent c))))

(defn preferred-layout-size
  "Returns the preferred dimensions for this layout given the components
   in the specified target container.

  parent - the component which needs to be laid out - `java.awt.Container`

  returns: a Dimension object containing the
            preferred dimensions - `java.awt.Dimension`"
  (^java.awt.Dimension [^ViewportLayout this ^java.awt.Container parent]
    (-> this (.preferredLayoutSize parent))))

(defn minimum-layout-size
  "Returns the minimum dimensions needed to layout the components
   contained in the specified target container.

  parent - the component which needs to be laid out - `java.awt.Container`

  returns: a Dimension object containing the minimum
            dimensions - `java.awt.Dimension`"
  (^java.awt.Dimension [^ViewportLayout this ^java.awt.Container parent]
    (-> this (.minimumLayoutSize parent))))

(defn layout-container
  "Called by the AWT when the specified container needs to be laid out.

  parent - the container to lay out - `java.awt.Container`

  throws: java.awt.AWTError - if the target isn't the container specified to the BoxLayout constructor"
  ([^ViewportLayout this ^java.awt.Container parent]
    (-> this (.layoutContainer parent))))

