(ns javax.imageio.plugins.jpeg.JPEGImageWriteParam
  "This class adds the ability to set JPEG quantization and Huffman
  tables when using the built-in JPEG writer plug-in, and to request that
  optimized Huffman tables be computed for an image.  An instance of
  this class will be returned from the
  getDefaultImageWriteParam methods of the built-in JPEG
  ImageWriter.

   The principal purpose of these additions is to allow the
  specification of tables to use in encoding abbreviated streams.
  The built-in JPEG writer will also accept an ordinary
  ImageWriteParam, in which case the writer will
  construct the necessary tables internally.

   In either case, the quality setting in an ImageWriteParam
  has the same meaning as for the underlying library: 1.00 means a
  quantization table of all 1's, 0.75 means the `standard`, visually
  lossless quantization table, and 0.00 means aquantization table of
  all 255's.

   While tables for abbreviated streams are often specified by
  first writing an abbreviated stream containing only the tables, in
  some applications the tables are fixed ahead of time.  This class
  allows the tables to be specified directly from client code.

   Normally, the tables are specified in the
  IIOMetadata objects passed in to the writer, and any
  tables included in these objects are written to the stream.
  If no tables are specified in the metadata, then an abbreviated
  stream is written.  If no tables are included in the metadata and
  no tables are specified in a JPEGImageWriteParam, then
  an abbreviated stream is encoded using the `standard` visually
  lossless tables.  This class is necessary for specifying tables
  when an abbreviated stream must be written without writing any tables
  to a stream first.  In order to use this class, the metadata object
  passed into the writer must contain no tables, and no stream metadata
  must be provided.  See JPEGQTable and
  JPEGHuffmanTable for more
  information on the default tables.

   The default JPEGImageWriteParam returned by the
  getDefaultWriteParam method of the writer contains no
  tables.  Default tables are included in the default
  IIOMetadata objects returned by the writer.

   If the metadata does contain tables, the tables given in a
  JPEGImageWriteParam are ignored.  Furthermore, once a
  set of tables has been written, only tables in the metadata can
  override them for subsequent writes, whether to the same stream or
  a different one.  In order to specify new tables using this class,
  the reset
  method of the writer must be called.


  For more information about the operation of the built-in JPEG plug-ins,
  see the JPEG
  metadata format specification and usage notes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.plugins.jpeg JPEGImageWriteParam]))

(defn ->jpeg-image-write-param
  "Constructor.

  Constructs a JPEGImageWriteParam.  Tiling is not
   supported.  Progressive encoding is supported. The default
   progressive mode is MODE_DISABLED.  A single form of compression,
   named `JPEG`, is supported.  The default compression quality is
   0.75.

  locale - a Locale to be used by the superclass to localize compression type names and quality descriptions, or null. - `java.util.Locale`"
  (^JPEGImageWriteParam [^java.util.Locale locale]
    (new JPEGImageWriteParam locale)))

(defn compression-lossless?
  "Returns false since the JPEG plug-in only supports
   lossy compression.

  returns: false. - `boolean`

  throws: java.lang.IllegalStateException - if the compression mode is not MODE_EXPLICIT."
  (^Boolean [^JPEGImageWriteParam this]
    (-> this (.isCompressionLossless))))

(defn are-tables-set
  "Returns true if tables are currently set.

  returns: true if tables are present. - `boolean`"
  (^Boolean [^JPEGImageWriteParam this]
    (-> this (.areTablesSet))))

(defn set-optimize-huffman-tables
  "Tells the writer to generate optimized Huffman tables
   for the image as part of the writing process.  The
   default is false.  If this flag is set
   to true, it overrides any tables specified
   in the metadata.  Note that this means that any image
   written with this flag set to true will
   always contain Huffman tables.

  optimize - A boolean indicating whether to generate optimized Huffman tables when writing. - `boolean`"
  ([^JPEGImageWriteParam this ^Boolean optimize]
    (-> this (.setOptimizeHuffmanTables optimize))))

(defn unset-encode-tables
  "Removes any quantization and Huffman tables that are currently
   set."
  ([^JPEGImageWriteParam this]
    (-> this (.unsetEncodeTables))))

(defn unset-compression
  "Removes any previous compression quality setting.

    The default implementation resets the compression quality
   to 0.75F.

  throws: java.lang.IllegalStateException - if the compression mode is not MODE_EXPLICIT."
  ([^JPEGImageWriteParam this]
    (-> this (.unsetCompression))))

(defn get-optimize-huffman-tables?
  "Returns the value passed into the most recent call
   to setOptimizeHuffmanTables, or
   false if setOptimizeHuffmanTables
   has never been called.

  returns: true if the writer will generate optimized
   Huffman tables. - `boolean`"
  (^Boolean [^JPEGImageWriteParam this]
    (-> this (.getOptimizeHuffmanTables))))

(defn get-compression-quality-descriptions
  "Description copied from class: ImageWriteParam

  returns: an array of Strings containing localized
   descriptions of the compression quality levels. - `java.lang.String[]`"
  ([^JPEGImageWriteParam this]
    (-> this (.getCompressionQualityDescriptions))))

(defn get-dc-huffman-tables
  "Returns a copy of the array of DC Huffman tables set on the
   most recent call to setEncodeTables, or
   null if tables are not currently set.

  returns: an array of JPEGHuffmanTable objects, or
   null. - `javax.imageio.plugins.jpeg.JPEGHuffmanTable[]`"
  ([^JPEGImageWriteParam this]
    (-> this (.getDCHuffmanTables))))

(defn get-ac-huffman-tables
  "Returns a copy of the array of AC Huffman tables set on the
   most recent call to setEncodeTables, or
   null if tables are not currently set.

  returns: an array of JPEGHuffmanTable objects, or
   null. - `javax.imageio.plugins.jpeg.JPEGHuffmanTable[]`"
  ([^JPEGImageWriteParam this]
    (-> this (.getACHuffmanTables))))

(defn set-encode-tables
  "Sets the quantization and Huffman tables to use in encoding
   abbreviated streams.  There may be a maximum of 4 tables of
   each type.  These tables are ignored if tables are specified in
   the metadata.  All arguments must be non-null.
   The two arrays of Huffman tables must have the same number of
   elements.  The table specifiers in the frame and scan headers
   in the metadata are assumed to be equivalent to indices into
   these arrays.  The argument arrays are copied by this method.

  q-tables - An array of quantization table objects. - `javax.imageio.plugins.jpeg.JPEGQTable[]`
  dc-huffman-tables - An array of Huffman table objects. - `javax.imageio.plugins.jpeg.JPEGHuffmanTable[]`
  ac-huffman-tables - An array of Huffman table objects. - `javax.imageio.plugins.jpeg.JPEGHuffmanTable[]`

  throws: java.lang.IllegalArgumentException - if any of the arguments is null or has more than 4 elements, or if the numbers of DC and AC tables differ."
  ([^JPEGImageWriteParam this q-tables dc-huffman-tables ac-huffman-tables]
    (-> this (.setEncodeTables q-tables dc-huffman-tables ac-huffman-tables))))

(defn get-compression-quality-values
  "Description copied from class: ImageWriteParam

  returns: an array of floats indicating the
   boundaries between the compression quality levels as described
   by the Strings from
   getCompressionQualityDescriptions. - `float[]`"
  ([^JPEGImageWriteParam this]
    (-> this (.getCompressionQualityValues))))

(defn get-q-tables
  "Returns a copy of the array of quantization tables set on the
   most recent call to setEncodeTables, or
   null if tables are not currently set.

  returns: an array of JPEGQTable objects, or
   null. - `javax.imageio.plugins.jpeg.JPEGQTable[]`"
  ([^JPEGImageWriteParam this]
    (-> this (.getQTables))))

