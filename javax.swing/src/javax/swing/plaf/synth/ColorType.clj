(ns javax.swing.plaf.synth.ColorType
  "A typesafe enumeration of colors that can be fetched from a style.

  Each SynthStyle has a set of ColorTypes that
  are accessed by way of the
  SynthStyle.getColor(SynthContext, ColorType) method.
  SynthStyle's installDefaults will install
  the FOREGROUND color
  as the foreground of
  the Component, and the BACKGROUND color to the background of
  the component (assuming that you have not explicitly specified a
  foreground and background color). Some components
  support more color based properties, for
  example JList has the property
  selectionForeground which will be mapped to
  FOREGROUND with a component state of
  SynthConstants.SELECTED.

  The following example shows a custom SynthStyle that returns
  a red Color for the DISABLED state, otherwise a black color.


  class MyStyle extends SynthStyle {
      private Color disabledColor = new ColorUIResource(Color.RED);
      private Color color = new ColorUIResource(Color.BLACK);
      protected Color getColorForState(SynthContext context, ColorType type){
          if (context.getComponentState() == SynthConstants.DISABLED) {
              return disabledColor;
          }
          return color;
      }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth ColorType]))

(def *-foreground
  "Static Constant.

  ColorType for the foreground of a region.

  type: javax.swing.plaf.synth.ColorType"
  ColorType/FOREGROUND)

(def *-background
  "Static Constant.

  ColorType for the background of a region.

  type: javax.swing.plaf.synth.ColorType"
  ColorType/BACKGROUND)

(def *-text-foreground
  "Static Constant.

  ColorType for the foreground of a region.

  type: javax.swing.plaf.synth.ColorType"
  ColorType/TEXT_FOREGROUND)

(def *-text-background
  "Static Constant.

  ColorType for the background of a region.

  type: javax.swing.plaf.synth.ColorType"
  ColorType/TEXT_BACKGROUND)

(def *-focus
  "Static Constant.

  ColorType for the focus.

  type: javax.swing.plaf.synth.ColorType"
  ColorType/FOCUS)

(def *-max-count
  "Static Constant.

  Maximum number of ColorTypes.

  type: int"
  ColorType/MAX_COUNT)

(defn get-id
  "Returns a unique id, as an integer, for this ColorType.

  returns: a unique id, as an integer, for this ColorType. - `int`"
  ([^javax.swing.plaf.synth.ColorType this]
    (-> this (.getID))))

(defn to-string
  "Returns the textual description of this ColorType.
   This is the same value that the ColorType was created
   with.

  returns: the description of the string - `java.lang.String`"
  ([^javax.swing.plaf.synth.ColorType this]
    (-> this (.toString))))

