(ns javax.swing.plaf.metal.MetalTreeUI
  "The metal look and feel implementation of TreeUI.

  MetalTreeUI allows for configuring how to
  visually render the spacing and delineation between nodes. The following
  hints are supported:



     Angled
     A line is drawn connecting the child to the parent. For handling
           of the root node refer to
           JTree.setRootVisible(boolean) and
           JTree.setShowsRootHandles(boolean).



      Horizontal
      A horizontal line is drawn dividing the children of the root node.


       None
       Do not draw any visual indication between nodes.




  As it is typically impractical to obtain the TreeUI from
  the JTree and cast to an instance of MetalTreeUI
  you enable this property via the client property
  JTree.lineStyle. For example, to switch to
  Horizontal style you would do:
  tree.putClientProperty(`JTree.lineStyle`, `Horizontal`);

  The default is Angled."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalTreeUI]))

(defn ->metal-tree-ui
  "Constructor."
  ([]
    (new MetalTreeUI )))

(defn *create-ui
  "x - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent x]
    (MetalTreeUI/createUI x)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalTreeUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalTreeUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalTreeUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

