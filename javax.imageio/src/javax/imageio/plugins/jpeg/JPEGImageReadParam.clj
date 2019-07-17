(ns javax.imageio.plugins.jpeg.JPEGImageReadParam
  "This class adds the ability to set JPEG quantization and Huffman
  tables when using the built-in JPEG reader plug-in.  An instance of
  this class will be returned from the
  getDefaultImageReadParam methods of the built-in JPEG
  ImageReader.

   The sole purpose of these additions is to allow the
  specification of tables for use in decoding abbreviated streams.
  The built-in JPEG reader will also accept an ordinary
  ImageReadParam, which is sufficient for decoding
  non-abbreviated streams.

   While tables for abbreviated streams are often obtained by
  first reading another abbreviated stream containing only the
  tables, in some applications the tables are fixed ahead of time.
  This class allows the tables to be specified directly from client
  code.  If no tables are specified either in the stream or in a
  JPEGImageReadParam, then the stream is presumed to use
  the `standard` visually lossless tables.  See JPEGQTable
  and JPEGHuffmanTable for more information
   on the default tables.

   The default JPEGImageReadParam returned by the
  getDefaultReadParam method of the builtin JPEG reader
  contains no tables.  Default tables may be obtained from the table
  classes JPEGQTable and
  JPEGHuffmanTable.

   If a stream does contain tables, the tables given in a
  JPEGImageReadParam are ignored.  Furthermore, if the
  first image in a stream does contain tables and subsequent ones do
  not, then the tables given in the first image are used for all the
  abbreviated images.  Once tables have been read from a stream, they
  can be overridden only by tables subsequently read from the same
  stream.  In order to specify new tables, the setInput method of
  the reader must be called to change the stream.

   Note that this class does not provide a means for obtaining the
  tables found in a stream.  These may be extracted from a stream by
  consulting the IIOMetadata object returned by the reader.


  For more information about the operation of the built-in JPEG plug-ins,
  see the JPEG
  metadata format specification and usage notes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.plugins.jpeg JPEGImageReadParam]))

(defn ->jpeg-image-read-param
  "Constructor.

  Constructs a JPEGImageReadParam."
  ([]
    (new JPEGImageReadParam )))

(defn are-tables-set
  "Returns true if tables are currently set.

  returns: true if tables are present. - `boolean`"
  ([this]
    (-> this (.areTablesSet))))

(defn set-decode-tables
  "Sets the quantization and Huffman tables to use in decoding
   abbreviated streams.  There may be a maximum of 4 tables of
   each type.  These tables are ignored once tables are
   encountered in the stream.  All arguments must be
   non-null.  The two arrays of Huffman tables must
   have the same number of elements.  The table specifiers in the
   frame and scan headers in the stream are assumed to be
   equivalent to indices into these arrays.  The argument arrays
   are copied by this method.

  q-tables - an array of quantization table objects. - `javax.imageio.plugins.jpeg.JPEGQTable[]`
  dc-huffman-tables - an array of Huffman table objects. - `javax.imageio.plugins.jpeg.JPEGHuffmanTable[]`
  ac-huffman-tables - an array of Huffman table objects. - `javax.imageio.plugins.jpeg.JPEGHuffmanTable[]`

  throws: java.lang.IllegalArgumentException - if any of the arguments is null, has more than 4 elements, or if the numbers of DC and AC tables differ."
  ([this q-tables dc-huffman-tables ac-huffman-tables]
    (-> this (.setDecodeTables q-tables dc-huffman-tables ac-huffman-tables))))

(defn unset-decode-tables
  "Removes any quantization and Huffman tables that are currently
   set."
  ([this]
    (-> this (.unsetDecodeTables))))

(defn get-q-tables
  "Returns a copy of the array of quantization tables set on the
   most recent call to setDecodeTables, or
   null if tables are not currently set.

  returns: an array of JPEGQTable objects, or
   null. - `javax.imageio.plugins.jpeg.JPEGQTable[]`"
  ([this]
    (-> this (.getQTables))))

(defn get-dc-huffman-tables
  "Returns a copy of the array of DC Huffman tables set on the
   most recent call to setDecodeTables, or
   null if tables are not currently set.

  returns: an array of JPEGHuffmanTable objects, or
   null. - `javax.imageio.plugins.jpeg.JPEGHuffmanTable[]`"
  ([this]
    (-> this (.getDCHuffmanTables))))

(defn get-ac-huffman-tables
  "Returns a copy of the array of AC Huffman tables set on the
   most recent call to setDecodeTables, or
   null if tables are not currently set.

  returns: an array of JPEGHuffmanTable objects, or
   null. - `javax.imageio.plugins.jpeg.JPEGHuffmanTable[]`"
  ([this]
    (-> this (.getACHuffmanTables))))

