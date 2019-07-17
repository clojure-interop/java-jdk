(ns javax.swing.CellRendererPane
  "This class is inserted in between cell renderers and the components that
  use them.  It just exists to thwart the repaint() and invalidate() methods
  which would otherwise propagate up the tree when the renderer was configured.
  It's used by the implementations of JTable, JTree, and JList.  For example,
  here's how CellRendererPane is used in the code the paints each row
  in a JList:


    cellRendererPane = new CellRendererPane();
    ...
    Component rendererComponent = renderer.getListCellRendererComponent();
    renderer.configureListCellRenderer(dataModel.getElementAt(row), row);
    cellRendererPane.paintComponent(g, rendererComponent, this, x, y, w, h);

  A renderer component must override isShowing() and unconditionally return
  true to work correctly because the Swing paint does nothing for components
  with isShowing false.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing CellRendererPane]))

(defn ->cell-renderer-pane
  "Constructor.

  Construct a CellRendererPane object."
  ([]
    (new CellRendererPane )))

(defn invalidate
  "Overridden to avoid propagating a invalidate up the tree when the
   cell renderer child is configured."
  ([^javax.swing.CellRendererPane this]
    (-> this (.invalidate))))

(defn paint
  "Shouldn't be called.

  g - the specified Graphics window - `java.awt.Graphics`"
  ([^javax.swing.CellRendererPane this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn update
  "Shouldn't be called.

  g - the specified Graphics window - `java.awt.Graphics`"
  ([^javax.swing.CellRendererPane this ^java.awt.Graphics g]
    (-> this (.update g))))

(defn paint-component
  "Paint a cell renderer component c on graphics object g.  Before the component
   is drawn it's reparented to this (if that's necessary), it's bounds
   are set to w,h and the graphics object is (effectively) translated to x,y.
   If it's a JComponent, double buffering is temporarily turned off. After
   the component is painted it's bounds are reset to -w, -h, 0, 0 so that, if
   it's the last renderer component painted, it will not start consuming input.
   The Container p is the component we're actually drawing on, typically it's
   equal to this.getParent(). If shouldValidate is true the component c will be
   validated before painted.

  g - `java.awt.Graphics`
  c - `java.awt.Component`
  p - `java.awt.Container`
  x - `int`
  y - `int`
  w - `int`
  h - `int`
  should-validate - `boolean`"
  ([^javax.swing.CellRendererPane this ^java.awt.Graphics g ^java.awt.Component c ^java.awt.Container p ^Integer x ^Integer y ^Integer w ^Integer h ^Boolean should-validate]
    (-> this (.paintComponent g c p x y w h should-validate)))
  ([^javax.swing.CellRendererPane this ^java.awt.Graphics g ^java.awt.Component c ^java.awt.Container p ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintComponent g c p x y w h)))
  ([^javax.swing.CellRendererPane this ^java.awt.Graphics g ^java.awt.Component c ^java.awt.Container p ^java.awt.Rectangle r]
    (-> this (.paintComponent g c p r))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this CellRendererPane.
   For CellRendererPanes, the AccessibleContext takes the form of an
   AccessibleCellRendererPane.
   A new AccessibleCellRendererPane instance is created if necessary.

  returns: an AccessibleCellRendererPane that serves as the
           AccessibleContext of this CellRendererPane - `javax.accessibility.AccessibleContext`"
  ([^javax.swing.CellRendererPane this]
    (-> this (.getAccessibleContext))))

