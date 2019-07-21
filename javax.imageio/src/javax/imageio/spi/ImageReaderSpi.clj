(ns javax.imageio.spi.ImageReaderSpi
  "The service provider interface (SPI) for ImageReaders.
  For more information on service provider classes, see the class comment
  for the IIORegistry class.

   Each ImageReaderSpi provides several types of information
  about the ImageReader class with which it is associated.

   The name of the vendor who defined the SPI class and a
  brief description of the class are available via the
  getVendorName, getDescription,
  and getVersion methods.
  These methods may be internationalized to provide locale-specific
  output.  These methods are intended mainly to provide short,
  human-readable information that might be used to organize a pop-up
  menu or other list.

   Lists of format names, file suffixes, and MIME types associated
  with the service may be obtained by means of the
  getFormatNames, getFileSuffixes, and
  getMIMETypes methods.  These methods may be used to
  identify candidate ImageReaders for decoding a
  particular file or stream based on manual format selection, file
  naming, or MIME associations (for example, when accessing a file
  over HTTP or as an email attachment).

   A more reliable way to determine which ImageReaders
  are likely to be able to parse a particular data stream is provided
  by the canDecodeInput method.  This methods allows the
  service provider to inspect the actual stream contents.

   Finally, an instance of the ImageReader class
  associated with this service provider may be obtained by calling
  the createReaderInstance method.  Any heavyweight
  initialization, such as the loading of native libraries or creation
  of large tables, should be deferred at least until the first
  invocation of this method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.spi ImageReaderSpi]))

(defn ->image-reader-spi
  "Constructor.

  Constructs an ImageReaderSpi with a given
   set of values.

  vendor-name - the vendor name, as a non-null String. - `java.lang.String`
  version - a version identifier, as a non-null String. - `java.lang.String`
  names - a non-null array of Strings indicating the format names. At least one entry must be present. - `java.lang.String[]`
  suffixes - an array of Strings indicating the common file suffixes. If no suffixes are defined, null should be supplied. An array of length 0 will be normalized to null. - `java.lang.String[]`
  mime-types - an array of Strings indicating the format's MIME types. If no MIME types are defined, null should be supplied. An array of length 0 will be normalized to null. - `java.lang.String[]`
  reader-class-name - the fully-qualified name of the associated ImageReader class, as a non-null String. - `java.lang.String`
  input-types - a non-null array of Class objects of length at least 1 indicating the legal input types. - `java.lang.Class[]`
  writer-spi-names - an array Strings naming the classes of all associated ImageWriters, or null. An array of length 0 is normalized to null. - `java.lang.String[]`
  supports-standard-stream-metadata-format - a boolean that indicates whether a stream metadata object can use trees described by the standard metadata format. - `boolean`
  native-stream-metadata-format-name - a String, or null, to be returned from getNativeStreamMetadataFormatName. - `java.lang.String`
  native-stream-metadata-format-class-name - a String, or null, to be used to instantiate a metadata format object to be returned from getNativeStreamMetadataFormat. - `java.lang.String`
  extra-stream-metadata-format-names - an array of Strings, or null, to be returned from getExtraStreamMetadataFormatNames. An array of length 0 is normalized to null. - `java.lang.String[]`
  extra-stream-metadata-format-class-names - an array of Strings, or null, to be used to instantiate a metadata format object to be returned from getStreamMetadataFormat. An array of length 0 is normalized to null. - `java.lang.String[]`
  supports-standard-image-metadata-format - a boolean that indicates whether an image metadata object can use trees described by the standard metadata format. - `boolean`
  native-image-metadata-format-name - a String, or null, to be returned from getNativeImageMetadataFormatName. - `java.lang.String`
  native-image-metadata-format-class-name - a String, or null, to be used to instantiate a metadata format object to be returned from getNativeImageMetadataFormat. - `java.lang.String`
  extra-image-metadata-format-names - an array of Strings to be returned from getExtraImageMetadataFormatNames. An array of length 0 is normalized to null. - `java.lang.String[]`
  extra-image-metadata-format-class-names - an array of Strings, or null, to be used to instantiate a metadata format object to be returned from getImageMetadataFormat. An array of length 0 is normalized to null. - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - if inputTypes is null or has length 0."
  (^ImageReaderSpi [^java.lang.String vendor-name ^java.lang.String version names suffixes mime-types ^java.lang.String reader-class-name input-types writer-spi-names ^Boolean supports-standard-stream-metadata-format ^java.lang.String native-stream-metadata-format-name ^java.lang.String native-stream-metadata-format-class-name extra-stream-metadata-format-names extra-stream-metadata-format-class-names ^Boolean supports-standard-image-metadata-format ^java.lang.String native-image-metadata-format-name ^java.lang.String native-image-metadata-format-class-name extra-image-metadata-format-names extra-image-metadata-format-class-names]
    (new ImageReaderSpi vendor-name version names suffixes mime-types reader-class-name input-types writer-spi-names supports-standard-stream-metadata-format native-stream-metadata-format-name native-stream-metadata-format-class-name extra-stream-metadata-format-names extra-stream-metadata-format-class-names supports-standard-image-metadata-format native-image-metadata-format-name native-image-metadata-format-class-name extra-image-metadata-format-names extra-image-metadata-format-class-names)))

(def *-standard-input-type
  "Static Constant.

  Deprecated. Instead of using this field, directly create
   the equivalent array { ImageInputStream.class }.

  type: java.lang.Class[]"
  ImageReaderSpi/STANDARD_INPUT_TYPE)

(defn get-input-types
  "Returns an array of Class objects indicating what
   types of objects may be used as arguments to the reader's
   setInput method.

    For most readers, which only accept input from an
   ImageInputStream, a single-element array
   containing ImageInputStream.class should be
   returned.

  returns: a non-null array of
   Classobjects of length at least 1. - `java.lang.Class[]`"
  ([^ImageReaderSpi this]
    (-> this (.getInputTypes))))

(defn can-decode-input?
  "Returns true if the supplied source object appears
   to be of the format supported by this reader.  Returning
   true from this method does not guarantee that
   reading will succeed, only that there appears to be a
   reasonable chance of success based on a brief inspection of the
   stream contents.  If the source is an
   ImageInputStream, implementations will commonly
   check the first several bytes of the stream for a \"magic
   number\" associated with the format.  Once actual reading has
   commenced, the reader may still indicate failure at any time
   prior to the completion of decoding.

    It is important that the state of the object not be
   disturbed in order that other ImageReaderSpis can
   properly determine whether they are able to decode the object.
   In particular, if the source is an
   ImageInputStream, a
   mark/reset pair should be used to
   preserve the stream position.

    Formats such as \"raw,\" which can potentially attempt
   to read nearly any stream, should return false
   in order to avoid being invoked in preference to a closer
   match.

    If source is not an instance of one of the
   classes returned by getInputTypes, the method
   should simply return false.

  source - the object (typically an ImageInputStream) to be decoded. - `java.lang.Object`

  returns: true if it is likely that this stream can
   be decoded. - `boolean`

  throws: java.lang.IllegalArgumentException - if source is null."
  (^Boolean [^ImageReaderSpi this ^java.lang.Object source]
    (-> this (.canDecodeInput source))))

(defn create-reader-instance
  "Returns an instance of the ImageReader
   implementation associated with this service provider.
   The returned object will initially be in an initial state
   as if its reset method had been called.

    An Object may be supplied to the plug-in at
   construction time.  The nature of the object is entirely
   plug-in specific.

    Typically, a plug-in will implement this method using code
   such as return new MyImageReader(this).

  extension - a plug-in specific extension object, which may be null. - `java.lang.Object`

  returns: an ImageReader instance. - `javax.imageio.ImageReader`

  throws: java.io.IOException - if the attempt to instantiate the reader fails."
  (^javax.imageio.ImageReader [^ImageReaderSpi this ^java.lang.Object extension]
    (-> this (.createReaderInstance extension)))
  (^javax.imageio.ImageReader [^ImageReaderSpi this]
    (-> this (.createReaderInstance))))

(defn own-reader?
  "Returns true if the ImageReader object
   passed in is an instance of the ImageReader
   associated with this service provider.

    The default implementation compares the fully-qualified
   class name of the reader argument with the class
   name passed into the constructor.  This method may be overridden
   if more sophisticated checking is required.

  reader - an ImageReader instance. - `javax.imageio.ImageReader`

  returns: true if reader is recognized. - `boolean`

  throws: java.lang.IllegalArgumentException - if reader is null."
  (^Boolean [^ImageReaderSpi this ^javax.imageio.ImageReader reader]
    (-> this (.isOwnReader reader))))

(defn get-image-writer-spi-names
  "Returns an array of Strings containing the fully
   qualified names of all the ImageWriterSpi classes
   that can understand the internal metadata representation used
   by the ImageReader associated with this service
   provider, or null if there are no such
   ImageWriters specified.  If a
   non-null value is returned, it must have non-zero
   length.

    The first item in the array must be the name of the service
   provider for the \"preferred\" writer, as it will be used to
   instantiate the ImageWriter returned by
   ImageIO.getImageWriter(ImageReader).

    This mechanism may be used to obtain
   ImageWriters that will understand the internal
   structure of non-pixel meta-data (see
   IIOTreeInfo) generated by an
   ImageReader.  By obtaining this data from the
   ImageReader and passing it on to one of the
   ImageWriters obtained with this method, a client
   program can read an image, modify it in some way, and write it
   back out while preserving all meta-data, without having to
   understand anything about the internal structure of the
   meta-data, or even about the image format.

  returns: an array of Strings of length at least 1
   containing names of ImageWriterSpi, or
   null. - `java.lang.String[]`"
  ([^ImageReaderSpi this]
    (-> this (.getImageWriterSpiNames))))

