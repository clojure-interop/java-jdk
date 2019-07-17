(ns javax.swing.plaf.synth.SynthConstants
  "Constants used by Synth. Not all Components support all states. A
  Component will at least be in one of the primary states. That is, the
  return value from SynthContext.getComponentState() will at
  least be one of ENABLED, MOUSE_OVER,
  PRESSED or DISABLED, and may also contain
  FOCUSED, SELECTED or DEFAULT."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthConstants]))

