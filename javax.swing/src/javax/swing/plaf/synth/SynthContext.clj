(ns javax.swing.plaf.synth.SynthContext
  "An immutable transient object containing contextual information about
  a Region. A SynthContext should only be
  considered valid for the duration
  of the method it is passed to. In other words you should not cache
  a SynthContext that is passed to you and expect it to
  remain valid."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthContext]))

(defn ->synth-context
  "Constructor.

  Creates a SynthContext with the specified values. This is meant
   for subclasses and custom UI implementors. You very rarely need to
   construct a SynthContext, though some methods will take one.

  component - JComponent - `javax.swing.JComponent`
  region - Identifies the portion of the JComponent - `javax.swing.plaf.synth.Region`
  style - Style associated with the component - `javax.swing.plaf.synth.SynthStyle`
  state - State of the component as defined in SynthConstants. - `int`

  throws: java.lang.NullPointerException - if component, region of style is null."
  ([^javax.swing.JComponent component ^javax.swing.plaf.synth.Region region ^javax.swing.plaf.synth.SynthStyle style ^Integer state]
    (new SynthContext component region style state)))

(defn get-component
  "Returns the hosting component containing the region.

  returns: Hosting Component - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthContext this]
    (-> this (.getComponent))))

(defn get-region
  "Returns the Region identifying this state.

  returns: Region of the hosting component - `javax.swing.plaf.synth.Region`"
  ([^javax.swing.plaf.synth.SynthContext this]
    (-> this (.getRegion))))

(defn get-style
  "Returns the style associated with this Region.

  returns: SynthStyle associated with the region. - `javax.swing.plaf.synth.SynthStyle`"
  ([^javax.swing.plaf.synth.SynthContext this]
    (-> this (.getStyle))))

(defn get-component-state
  "Returns the state of the widget, which is a bitmask of the
   values defined in SynthConstants. A region will at least
   be in one of
   ENABLED, MOUSE_OVER, PRESSED
   or DISABLED.

  returns: State of Component - `int`"
  ([^javax.swing.plaf.synth.SynthContext this]
    (-> this (.getComponentState))))

