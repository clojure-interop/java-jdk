(ns javax.swing.plaf.synth.SynthStyleFactory
  "Factory used for obtaining SynthStyles.  Each of the
  Synth ComponentUIs will call into the current
  SynthStyleFactory to obtain a SynthStyle
  for each of the distinct regions they have.

  The following example creates a custom SynthStyleFactory
  that returns a different style based on the Region:


  class MyStyleFactory extends SynthStyleFactory {
      public SynthStyle getStyle(JComponent c, Region id) {
          if (id == Region.BUTTON) {
              return buttonStyle;
          }
          else if (id == Region.TREE) {
              return treeStyle;
          }
          return defaultStyle;
      }
  }
  SynthLookAndFeel laf = new SynthLookAndFeel();
  UIManager.setLookAndFeel(laf);
  SynthLookAndFeel.setStyleFactory(new MyStyleFactory());"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthStyleFactory]))

(defn ->synth-style-factory
  "Constructor.

  Creates a SynthStyleFactory."
  ([]
    (new SynthStyleFactory )))

(defn get-style
  "Returns the style for the specified Component.

  c - Component asking for - `javax.swing.JComponent`
  id - Region identifier - `javax.swing.plaf.synth.Region`

  returns: SynthStyle for region. - `javax.swing.plaf.synth.SynthStyle`"
  (^javax.swing.plaf.synth.SynthStyle [^javax.swing.plaf.synth.SynthStyleFactory this ^javax.swing.JComponent c ^javax.swing.plaf.synth.Region id]
    (-> this (.getStyle c id))))

