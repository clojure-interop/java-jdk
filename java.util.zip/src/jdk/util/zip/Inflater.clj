(ns jdk.util.zip.Inflater
  "This class provides support for general purpose decompression using the
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
      String inputString = `blahblahblah??`;
      byte[] input = inputString.getBytes(`UTF-8`);

      // Compress the bytes
      byte[] output = new byte[100];
      Deflater compresser = new Deflater();
      compresser.setInput(input);
      compresser.finish();
      int compressedDataLength = compresser.deflate(output);

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
  (:import [java.util.zip Inflater]))

(defn ->inflater
  "Constructor.

  Creates a new decompressor. If the parameter 'nowrap' is true then
   the ZLIB header and checksum fields will not be used. This provides
   compatibility with the compression format used by both GZIP and PKZIP.

   Note: When using the 'nowrap' option it is also necessary to provide
   an extra `dummy` byte as input. This is required by the ZLIB native
   library in order to support certain optimizations.

  nowrap - if true then support GZIP compatible compression - `boolean`"
  ([^Boolean nowrap]
    (new Inflater nowrap))
  ([]
    (new Inflater )))

(defn set-input
  "Sets input data for decompression. Should be called whenever
   needsInput() returns true indicating that more input data is
   required.

  b - the input data bytes - `byte[]`
  off - the start offset of the input data - `int`
  len - the length of the input data - `int`"
  ([^java.util.zip.Inflater this b ^Integer off ^Integer len]
    (-> this (.setInput b off len)))
  ([^java.util.zip.Inflater this b]
    (-> this (.setInput b))))

(defn get-total-out
  "Returns the total number of uncompressed bytes output so far.

   Since the number of bytes may be greater than
   Integer.MAX_VALUE, the getBytesWritten() method is now
   the preferred means of obtaining this information.

  returns: the total number of uncompressed bytes output so far - `int`"
  ([^java.util.zip.Inflater this]
    (-> this (.getTotalOut))))

(defn inflate
  "Uncompresses bytes into specified buffer. Returns actual number
   of bytes uncompressed. A return value of 0 indicates that
   needsInput() or needsDictionary() should be called in order to
   determine if more input data or a preset dictionary is required.
   In the latter case, getAdler() can be used to get the Adler-32
   value of the dictionary required.

  b - the buffer for the uncompressed data - `byte[]`
  off - the start offset of the data - `int`
  len - the maximum number of uncompressed bytes - `int`

  returns: the actual number of uncompressed bytes - `int`

  throws: java.util.zip.DataFormatException - if the compressed data format is invalid"
  ([^java.util.zip.Inflater this b ^Integer off ^Integer len]
    (-> this (.inflate b off len)))
  ([^java.util.zip.Inflater this b]
    (-> this (.inflate b))))

(defn get-bytes-written
  "Returns the total number of uncompressed bytes output so far.

  returns: the total (non-negative) number of uncompressed bytes output so far - `long`"
  ([^java.util.zip.Inflater this]
    (-> this (.getBytesWritten))))

(defn needs-input
  "Returns true if no data remains in the input buffer. This can
   be used to determine if #setInput should be called in order
   to provide more input.

  returns: true if no data remains in the input buffer - `boolean`"
  ([^java.util.zip.Inflater this]
    (-> this (.needsInput))))

(defn reset
  "Resets inflater so that a new set of input data can be processed."
  ([^java.util.zip.Inflater this]
    (-> this (.reset))))

(defn needs-dictionary
  "Returns true if a preset dictionary is needed for decompression.

  returns: true if a preset dictionary is needed for decompression - `boolean`"
  ([^java.util.zip.Inflater this]
    (-> this (.needsDictionary))))

(defn get-remaining
  "Returns the total number of bytes remaining in the input buffer.
   This can be used to find out what bytes still remain in the input
   buffer after decompression has finished.

  returns: the total number of bytes remaining in the input buffer - `int`"
  ([^java.util.zip.Inflater this]
    (-> this (.getRemaining))))

(defn get-bytes-read
  "Returns the total number of compressed bytes input so far.

  returns: the total (non-negative) number of compressed bytes input so far - `long`"
  ([^java.util.zip.Inflater this]
    (-> this (.getBytesRead))))

(defn get-adler
  "Returns the ADLER-32 value of the uncompressed data.

  returns: the ADLER-32 value of the uncompressed data - `int`"
  ([^java.util.zip.Inflater this]
    (-> this (.getAdler))))

(defn get-total-in
  "Returns the total number of compressed bytes input so far.

   Since the number of bytes may be greater than
   Integer.MAX_VALUE, the getBytesRead() method is now
   the preferred means of obtaining this information.

  returns: the total number of compressed bytes input so far - `int`"
  ([^java.util.zip.Inflater this]
    (-> this (.getTotalIn))))

(defn set-dictionary
  "Sets the preset dictionary to the given array of bytes. Should be
   called when inflate() returns 0 and needsDictionary() returns true
   indicating that a preset dictionary is required. The method getAdler()
   can be used to get the Adler-32 value of the dictionary needed.

  b - the dictionary data bytes - `byte[]`
  off - the start offset of the data - `int`
  len - the length of the data - `int`"
  ([^java.util.zip.Inflater this b ^Integer off ^Integer len]
    (-> this (.setDictionary b off len)))
  ([^java.util.zip.Inflater this b]
    (-> this (.setDictionary b))))

(defn end
  "Closes the decompressor and discards any unprocessed input.
   This method should be called when the decompressor is no longer
   being used, but will also be called automatically by the finalize()
   method. Once this method is called, the behavior of the Inflater
   object is undefined."
  ([^java.util.zip.Inflater this]
    (-> this (.end))))

(defn finished
  "Returns true if the end of the compressed data stream has been
   reached.

  returns: true if the end of the compressed data stream has been
   reached - `boolean`"
  ([^java.util.zip.Inflater this]
    (-> this (.finished))))

