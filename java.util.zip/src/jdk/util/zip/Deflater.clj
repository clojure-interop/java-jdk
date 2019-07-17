(ns jdk.util.zip.Deflater
  "This class provides support for general purpose compression using the
  popular ZLIB compression library. The ZLIB compression library was
  initially developed as part of the PNG graphics standard and is not
  protected by patents. It is fully described in the specifications at
  the java.util.zip
  package description.

  The following code fragment demonstrates a trivial compression
  and decompression of a string using Deflater and
  Inflater.



  try {
      // Encode a String into bytes
      String inputString = `blahblahblah`;
      byte[] input = inputString.getBytes(`UTF-8`);

      // Compress the bytes
      byte[] output = new byte[100];
      Deflater compresser = new Deflater();
      compresser.setInput(input);
      compresser.finish();
      int compressedDataLength = compresser.deflate(output);
      compresser.end();

      // Decompress the bytes
      Inflater decompresser = new Inflater();
      decompresser.setInput(output, 0, compressedDataLength);
      byte[] result = new byte[100];
      int resultLength = decompresser.inflate(result);
      decompresser.end();

      // Decode the bytes into a String
      String outputString = new String(result, 0, resultLength, `UTF-8`);
  } catch(java.io.UnsupportedEncodingException ex) {
      // handle
  } catch (java.util.zip.DataFormatException ex) {
      // handle
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip Deflater]))

(defn ->deflater
  "Constructor.

  Creates a new compressor using the specified compression level.
   If 'nowrap' is true then the ZLIB header and checksum fields will
   not be used in order to support the compression format used in
   both GZIP and PKZIP.

  level - the compression level (0-9) - `int`
  nowrap - if true then use GZIP compatible compression - `boolean`"
  ([^Integer level ^Boolean nowrap]
    (new Deflater level nowrap))
  ([^Integer level]
    (new Deflater level))
  ([]
    (new Deflater )))

(def *-deflated
  "Static Constant.

  Compression method for the deflate algorithm (the only one currently
   supported).

  type: int"
  Deflater/DEFLATED)

(def *-no-compression
  "Static Constant.

  Compression level for no compression.

  type: int"
  Deflater/NO_COMPRESSION)

(def *-best-speed
  "Static Constant.

  Compression level for fastest compression.

  type: int"
  Deflater/BEST_SPEED)

(def *-best-compression
  "Static Constant.

  Compression level for best compression.

  type: int"
  Deflater/BEST_COMPRESSION)

(def *-default-compression
  "Static Constant.

  Default compression level.

  type: int"
  Deflater/DEFAULT_COMPRESSION)

(def *-filtered
  "Static Constant.

  Compression strategy best used for data consisting mostly of small
   values with a somewhat random distribution. Forces more Huffman coding
   and less string matching.

  type: int"
  Deflater/FILTERED)

(def *-huffman-only
  "Static Constant.

  Compression strategy for Huffman coding only.

  type: int"
  Deflater/HUFFMAN_ONLY)

(def *-default-strategy
  "Static Constant.

  Default compression strategy.

  type: int"
  Deflater/DEFAULT_STRATEGY)

(def *-no-flush
  "Static Constant.

  Compression flush mode used to achieve best compression result.

  type: int"
  Deflater/NO_FLUSH)

(def *-sync-flush
  "Static Constant.

  Compression flush mode used to flush out all pending output; may
   degrade compression for some compression algorithms.

  type: int"
  Deflater/SYNC_FLUSH)

(def *-full-flush
  "Static Constant.

  Compression flush mode used to flush out all pending output and
   reset the deflater. Using this mode too often can seriously degrade
   compression.

  type: int"
  Deflater/FULL_FLUSH)

(defn set-input
  "Sets input data for compression. This should be called whenever
   needsInput() returns true indicating that more input data is required.

  b - the input data bytes - `byte[]`
  off - the start offset of the data - `int`
  len - the length of the data - `int`"
  ([^java.util.zip.Deflater this b ^Integer off ^Integer len]
    (-> this (.setInput b off len)))
  ([^java.util.zip.Deflater this b]
    (-> this (.setInput b))))

(defn get-total-out
  "Returns the total number of compressed bytes output so far.

   Since the number of bytes may be greater than
   Integer.MAX_VALUE, the getBytesWritten() method is now
   the preferred means of obtaining this information.

  returns: the total number of compressed bytes output so far - `int`"
  (^Integer [^java.util.zip.Deflater this]
    (-> this (.getTotalOut))))

(defn get-bytes-written
  "Returns the total number of compressed bytes output so far.

  returns: the total (non-negative) number of compressed bytes output so far - `long`"
  (^Long [^java.util.zip.Deflater this]
    (-> this (.getBytesWritten))))

(defn needs-input
  "Returns true if the input data buffer is empty and setInput()
   should be called in order to provide more input.

  returns: true if the input data buffer is empty and setInput()
   should be called in order to provide more input - `boolean`"
  (^Boolean [^java.util.zip.Deflater this]
    (-> this (.needsInput))))

(defn reset
  "Resets deflater so that a new set of input data can be processed.
   Keeps current compression level and strategy settings."
  ([^java.util.zip.Deflater this]
    (-> this (.reset))))

(defn set-strategy
  "Sets the compression strategy to the specified value.

    If the compression strategy is changed, the next invocation
   of deflate will compress the input available so far with
   the old strategy (and may be flushed); the new strategy will take
   effect only after that invocation.

  strategy - the new compression strategy - `int`

  throws: java.lang.IllegalArgumentException - if the compression strategy is invalid"
  ([^java.util.zip.Deflater this ^Integer strategy]
    (-> this (.setStrategy strategy))))

(defn finish
  "When called, indicates that compression should end with the current
   contents of the input buffer."
  ([^java.util.zip.Deflater this]
    (-> this (.finish))))

(defn get-bytes-read
  "Returns the total number of uncompressed bytes input so far.

  returns: the total (non-negative) number of uncompressed bytes input so far - `long`"
  (^Long [^java.util.zip.Deflater this]
    (-> this (.getBytesRead))))

(defn get-adler
  "Returns the ADLER-32 value of the uncompressed data.

  returns: the ADLER-32 value of the uncompressed data - `int`"
  (^Integer [^java.util.zip.Deflater this]
    (-> this (.getAdler))))

(defn set-level
  "Sets the compression level to the specified value.

    If the compression level is changed, the next invocation
   of deflate will compress the input available so far
   with the old level (and may be flushed); the new level will
   take effect only after that invocation.

  level - the new compression level (0-9) - `int`

  throws: java.lang.IllegalArgumentException - if the compression level is invalid"
  ([^java.util.zip.Deflater this ^Integer level]
    (-> this (.setLevel level))))

(defn deflate
  "Compresses the input data and fills the specified buffer with compressed
   data. Returns actual number of bytes of data compressed.

   Compression flush mode is one of the following three modes:


   NO_FLUSH: allows the deflater to decide how much data
   to accumulate, before producing output, in order to achieve the best
   compression (should be used in normal use scenario). A return value
   of 0 in this flush mode indicates that needsInput() should
   be called in order to determine if more input data is required.

   SYNC_FLUSH: all pending output in the deflater is flushed,
   to the specified output buffer, so that an inflater that works on
   compressed data can get all input data available so far (In particular
   the needsInput() returns true after this invocation
   if enough output space is provided). Flushing with SYNC_FLUSH
   may degrade compression for some compression algorithms and so it
   should be used only when necessary.

   FULL_FLUSH: all pending output is flushed out as with
   SYNC_FLUSH. The compression state is reset so that the inflater
   that works on the compressed output data can restart from this point
   if previous compressed data has been damaged or if random access is
   desired. Using FULL_FLUSH too often can seriously degrade
   compression.


   In the case of FULL_FLUSH or SYNC_FLUSH, if
   the return value is len, the space available in output
   buffer b, this method should be invoked again with the same
   flush parameter and more output space.

  b - the buffer for the compressed data - `byte[]`
  off - the start offset of the data - `int`
  len - the maximum number of bytes of compressed data - `int`
  flush - the compression flush mode - `int`

  returns: the actual number of bytes of compressed data written to
           the output buffer - `int`

  throws: java.lang.IllegalArgumentException - if the flush mode is invalid"
  (^Integer [^java.util.zip.Deflater this b ^Integer off ^Integer len ^Integer flush]
    (-> this (.deflate b off len flush)))
  (^Integer [^java.util.zip.Deflater this b ^Integer off ^Integer len]
    (-> this (.deflate b off len)))
  (^Integer [^java.util.zip.Deflater this b]
    (-> this (.deflate b))))

(defn get-total-in
  "Returns the total number of uncompressed bytes input so far.

   Since the number of bytes may be greater than
   Integer.MAX_VALUE, the getBytesRead() method is now
   the preferred means of obtaining this information.

  returns: the total number of uncompressed bytes input so far - `int`"
  (^Integer [^java.util.zip.Deflater this]
    (-> this (.getTotalIn))))

(defn set-dictionary
  "Sets preset dictionary for compression. A preset dictionary is used
   when the history buffer can be predetermined. When the data is later
   uncompressed with Inflater.inflate(), Inflater.getAdler() can be called
   in order to get the Adler-32 value of the dictionary required for
   decompression.

  b - the dictionary data bytes - `byte[]`
  off - the start offset of the data - `int`
  len - the length of the data - `int`"
  ([^java.util.zip.Deflater this b ^Integer off ^Integer len]
    (-> this (.setDictionary b off len)))
  ([^java.util.zip.Deflater this b]
    (-> this (.setDictionary b))))

(defn end
  "Closes the compressor and discards any unprocessed input.
   This method should be called when the compressor is no longer
   being used, but will also be called automatically by the
   finalize() method. Once this method is called, the behavior
   of the Deflater object is undefined."
  ([^java.util.zip.Deflater this]
    (-> this (.end))))

(defn finished
  "Returns true if the end of the compressed data output stream has
   been reached.

  returns: true if the end of the compressed data output stream has
   been reached - `boolean`"
  (^Boolean [^java.util.zip.Deflater this]
    (-> this (.finished))))

