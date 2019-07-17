(ns jdk.awt.font.MultipleMaster
  "The MultipleMaster interface represents Type 1
  Multiple Master fonts.
  A particular Font object can implement this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font MultipleMaster]))

(defn get-num-design-axes
  "Returns the number of multiple master design controls.
   Design axes include things like width, weight and optical scaling.

  returns: the number of multiple master design controls - `int`"
  (^Integer [^java.awt.font.MultipleMaster this]
    (-> this (.getNumDesignAxes))))

(defn get-design-axis-ranges
  "Returns an array of design limits interleaved in the form [from→to]
   for each axis.  For example,
   design limits for weight could be from 0.1 to 1.0. The values are
   returned in the same order returned by
   getDesignAxisNames.

  returns: an array of design limits for each axis. - `float[]`"
  ([^java.awt.font.MultipleMaster this]
    (-> this (.getDesignAxisRanges))))

(defn get-design-axis-defaults
  "Returns an array of default design values for each axis.  For example,
   the default value for weight could be 1.6. The values are returned
   in the same order returned by getDesignAxisNames.

  returns: an array of default design values for each axis. - `float[]`"
  ([^java.awt.font.MultipleMaster this]
    (-> this (.getDesignAxisDefaults))))

(defn get-design-axis-names
  "Returns the name for each design axis. This also determines the order in
   which the values for each axis are returned.

  returns: an array containing the names of each design axis. - `java.lang.String[]`"
  ([^java.awt.font.MultipleMaster this]
    (-> this (.getDesignAxisNames))))

(defn derive-mm-font
  "Creates a new instance of a multiple master font based on detailed metric
   information. In case of an error, null is returned.

  glyph-widths - an array of floats representing the desired width of each glyph in font space - `float[]`
  avg-stem-width - the average stem width for the overall font in font space - `float`
  typical-cap-height - the height of a typical upper case char - `float`
  typical-x-height - the height of a typical lower case char - `float`
  italic-angle - the angle at which the italics lean, in degrees counterclockwise from vertical - `float`

  returns: a Font object that is an instance of
   MultipleMaster and is based on the specified metric
   information. - `java.awt.Font`"
  (^java.awt.Font [^java.awt.font.MultipleMaster this glyph-widths ^Float avg-stem-width ^Float typical-cap-height ^Float typical-x-height ^Float italic-angle]
    (-> this (.deriveMMFont glyph-widths avg-stem-width typical-cap-height typical-x-height italic-angle)))
  (^java.awt.Font [^java.awt.font.MultipleMaster this axes]
    (-> this (.deriveMMFont axes))))

