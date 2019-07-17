(ns javax.swing.plaf.synth.SynthTextPaneUI
  "Provides the look and feel for a styled text editor in the
  Synth look and feel.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthTextPaneUI]))

(defn ->synth-text-pane-ui
  "Constructor."
  ([]
    (new SynthTextPaneUI )))

(defn *create-ui
  "Creates a UI for the JTextPane.

  c - the JTextPane object - `javax.swing.JComponent`

  returns: the UI object - `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent c]
    (SynthTextPaneUI/createUI c)))

(defn install-ui
  "Installs the UI for a component.  This does the following
   things.


   Sets opaqueness of the associated component according to its style,
   if the opaque property has not already been set by the client program.

   Installs the default caret and highlighter into the
   associated component. These properties are only set if their
   current value is either null or an instance of
   UIResource.

   Attaches to the editor and model.  If there is no
   model, a default one is created.

   Creates the view factory and the view hierarchy used
   to represent the model.

  c - the editor component - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthTextPaneUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn paint-border
  "Paints the border.

  context - a component context - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint on - `java.awt.Graphics`
  x - the X coordinate - `int`
  y - the Y coordinate - `int`
  w - width of the border - `int`
  h - height of the border - `int`"
  ([^javax.swing.plaf.synth.SynthTextPaneUI this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintBorder context g x y w h))))

