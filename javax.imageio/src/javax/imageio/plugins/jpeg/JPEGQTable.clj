(ns javax.imageio.plugins.jpeg.JPEGQTable
  "A class encapsulating a single JPEG quantization table.
  The elements appear in natural order (as opposed to zig-zag order).
  Static variables are provided for the `standard` tables taken from
   Annex K of the JPEG specification, as well as the default tables
  conventionally used for visually lossless encoding.

  For more information about the operation of the standard JPEG plug-in,
  see the JPEG
  metadata format specification and usage notes"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.plugins.jpeg JPEGQTable]))

(defn ->jpegq-table
  "Constructor.

  Constructs a quantization table from the argument, which must
   contain 64 elements in natural order (not zig-zag order).
   A copy is made of the the input array.

  table - the quantization table, as an int array. - `int[]`

  throws: java.lang.IllegalArgumentException - if table is null or table.length is not equal to 64."
  ([table]
    (new JPEGQTable table)))

(def *-k-1-luminance
  "Static Constant.

  The sample luminance quantization table given in the JPEG
   specification, table K.1. According to the specification,
   these values produce `good` quality output.

  type: javax.imageio.plugins.jpeg.JPEGQTable"
  JPEGQTable/K1Luminance)

(def *-k-1-div-2-luminance
  "Static Constant.

  The sample luminance quantization table given in the JPEG
   specification, table K.1, with all elements divided by 2.
   According to the specification, these values produce `very good`
   quality output. This is the table usually used for `visually lossless`
   encoding, and is the default luminance table used if the default
   tables and quality settings are used.

  type: javax.imageio.plugins.jpeg.JPEGQTable"
  JPEGQTable/K1Div2Luminance)

(def *-k-2-chrominance
  "Static Constant.

  The sample chrominance quantization table given in the JPEG
   specification, table K.2. According to the specification,
   these values produce `good` quality output.

  type: javax.imageio.plugins.jpeg.JPEGQTable"
  JPEGQTable/K2Chrominance)

(def *-k-2-div-2-chrominance
  "Static Constant.

  The sample chrominance quantization table given in the JPEG
   specification, table K.1, with all elements divided by 2.
   According to the specification, these values produce `very good`
   quality output. This is the table usually used for `visually lossless`
   encoding, and is the default chrominance table used if the default
   tables and quality settings are used.

  type: javax.imageio.plugins.jpeg.JPEGQTable"
  JPEGQTable/K2Div2Chrominance)

(defn get-table
  "Returns a copy of the current quantization table as an array
   of ints in natural (not zig-zag) order.

  returns: A copy of the current quantization table. - `int[]`"
  ([^javax.imageio.plugins.jpeg.JPEGQTable this]
    (-> this (.getTable))))

(defn get-scaled-instance
  "Returns a new quantization table where the values are multiplied
   by scaleFactor and then clamped to the range 1..32767
   (or to 1..255 if forceBaseline is true).

   Values of scaleFactor less than 1 tend to improve
   the quality level of the table, and values greater than 1.0
   degrade the quality level of the table.

  scale-factor - multiplication factor for the table. - `float`
  force-baseline - if true, the values will be clamped to the range 1..255 - `boolean`

  returns: a new quantization table that is a linear multiple
   of the current table. - `javax.imageio.plugins.jpeg.JPEGQTable`"
  (^javax.imageio.plugins.jpeg.JPEGQTable [^javax.imageio.plugins.jpeg.JPEGQTable this ^Float scale-factor ^Boolean force-baseline]
    (-> this (.getScaledInstance scale-factor force-baseline))))

(defn to-string
  "Returns a String representing this quantization table.

  returns: a String representing this quantization table. - `java.lang.String`"
  (^java.lang.String [^javax.imageio.plugins.jpeg.JPEGQTable this]
    (-> this (.toString))))

