(ns javax.imageio.plugins.jpeg.JPEGHuffmanTable
  "A class encapsulating a single JPEG Huffman table.
  Fields are provided for the `standard` tables taken
  from Annex K of the JPEG specification.
  These are the tables used as defaults.

  For more information about the operation of the standard JPEG plug-in,
  see the JPEG
  metadata format specification and usage notes"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.plugins.jpeg JPEGHuffmanTable]))

(defn ->jpeg-huffman-table
  "Constructor.

  Creates a Huffman table and initializes it. The input arrays are copied.
   The arrays must describe a possible Huffman table.
   For example, 3 codes cannot be expressed with a single bit.

  lengths - an array of shorts where lengths[k] is equal to the number of values with corresponding codes of length k 1 bits. - `short[]`
  values - an array of shorts containing the values in order of increasing code length. - `short[]`

  throws: java.lang.IllegalArgumentException - if lengths or values are null, the length of lengths is greater than 16, the length of values is greater than 256, if any value in lengths or values is less than zero, or if the arrays do not describe a valid Huffman table."
  ([lengths values]
    (new JPEGHuffmanTable lengths values)))

(def *-std-dc-luminance
  "Static Constant.

  The standard DC luminance Huffman table.

  type: javax.imageio.plugins.jpeg.JPEGHuffmanTable"
  JPEGHuffmanTable/StdDCLuminance)

(def *-std-dc-chrominance
  "Static Constant.

  The standard DC chrominance Huffman table.

  type: javax.imageio.plugins.jpeg.JPEGHuffmanTable"
  JPEGHuffmanTable/StdDCChrominance)

(def *-std-ac-luminance
  "Static Constant.

  The standard AC luminance Huffman table.

  type: javax.imageio.plugins.jpeg.JPEGHuffmanTable"
  JPEGHuffmanTable/StdACLuminance)

(def *-std-ac-chrominance
  "Static Constant.

  The standard AC chrominance Huffman table.

  type: javax.imageio.plugins.jpeg.JPEGHuffmanTable"
  JPEGHuffmanTable/StdACChrominance)

(defn get-lengths
  "Returns an array of shorts containing the number of values
   for each length in the Huffman table. The returned array is a copy.

  returns: a short array where array[k-1]
   is equal to the number of values in the table of length k. - `short[]`"
  ([this]
    (-> this (.getLengths))))

(defn get-values
  "Returns an array of shorts containing the values arranged
   by increasing length of their corresponding codes.
   The interpretation of the array is dependent on the values returned
   from getLengths. The returned array is a copy.

  returns: a short array of values. - `short[]`"
  ([this]
    (-> this (.getValues))))

(defn to-string
  "Returns a String representing this Huffman table.

  returns: a String representing this Huffman table. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

