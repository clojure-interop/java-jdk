(ns javax.imageio.spi.ImageWriterSpi
  "The service provider interface (SPI) for ImageWriters.
  For more information on service provider classes, see the class comment
  for the IIORegistry class.

   Each ImageWriterSpi provides several types of information
  about the ImageWriter class with which it is associated.

   The name of the vendor who defined the SPI class and a
  brief description of the class are available via the
  getVendorName, getDescription,
  and getVersion methods.
  These methods may be internationalized to provide locale-specific
  output.  These methods are intended mainly to provide short,
  human-writable information that might be used to organize a pop-up
  menu or other list.

   Lists of format names, file suffixes, and MIME types associated
  with the service may be obtained by means of the
  getFormatNames, getFileSuffixes, and
  getMIMEType methods.  These methods may be used to
  identify candidate ImageWriters for writing a
  particular file or stream based on manual format selection, file
  naming, or MIME associations.

   A more reliable way to determine which ImageWriters
  are likely to be able to parse a particular data stream is provided
  by the canEncodeImage method.  This methods allows the
  service provider to inspect the actual image contents.

   Finally, an instance of the ImageWriter class
  associated with this service provider may be obtained by calling
  the createWriterInstance method.  Any heavyweight
  initialization, such as the loading of native libraries or creation
  of large tables, should be deferred at least until the first
  invocation of this method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.spi ImageWriterSpi]))

(defn ->image-writer-spi
  "Constructor.

  Constructs an ImageWriterSpi with a given
   set of values.

  vendor-name - the vendor name, as a non-null String. - `java.lang.String`
  version - a version identifier, as a non-null String. - `java.lang.String`
  names - a non-null array of Strings indicating the format names. At least one entry must be present. - `java.lang.String[]`
  suffixes - an array of Strings indicating the common file suffixes. If no suffixes are defined, null should be supplied. An array of length 0 will be normalized to null. - `java.lang.String[]`
  mime-types - an array of Strings indicating the format's MIME types. If no suffixes are defined, null should be supplied. An array of length 0 will be normalized to null. - `java.lang.String[]`
  writer-class-name - the fully-qualified name of the associated ImageWriterSpi class, as a non-null String. - `java.lang.String`
  output-types - an array of Class objects of length at least 1 indicating the legal output types. - `java.lang.Class[]`
  reader-spi-names - an array Strings of length at least 1 naming the classes of all associated ImageReaders, or null. An array of length 0 is normalized to null. - `java.lang.String[]`
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

  throws: java.lang.IllegalArgumentException - if outputTypes is null or has length 0."
  (^ImageWriterSpi [^java.lang.String vendor-name ^java.lang.String version names suffixes mime-types ^java.lang.String writer-class-name output-types reader-spi-names ^Boolean supports-standard-stream-metadata-format ^java.lang.String native-stream-metadata-format-name ^java.lang.String native-stream-metadata-format-class-name extra-stream-metadata-format-names extra-stream-metadata-format-class-names ^Boolean supports-standard-image-metadata-format ^java.lang.String native-image-metadata-format-name ^java.lang.String native-image-metadata-format-class-name extra-image-metadata-format-names extra-image-metadata-format-class-names]
    (new ImageWriterSpi vendor-name version names suffixes mime-types writer-class-name output-types reader-spi-names supports-standard-stream-metadata-format native-stream-metadata-format-name native-stream-metadata-format-class-name extra-stream-metadata-format-names extra-stream-metadata-format-class-names supports-standard-image-metadata-format native-image-metadata-format-name native-image-metadata-format-class-name extra-image-metadata-format-names extra-image-metadata-format-class-names)))

(def *-standard-output-type
  "Static Constant.

  Deprecated. Instead of using this field, directly create
   the equivalent array { ImageOutputStream.class }.

  type: java.lang.Class[]"
  ImageWriterSpi/STANDARD_OUTPUT_TYPE)

(defn format-lossless?
  "Returns true if the format that this writer
   outputs preserves pixel data bit-accurately.  The default
   implementation returns true.

  returns: true if the format preserves full pixel
   accuracy. - `boolean`"
  (^Boolean [^ImageWriterSpi this]
    (-> this (.isFormatLossless))))

(defn get-output-types
  "Returns an array of Class objects indicating what
   types of objects may be used as arguments to the writer's
   setOutput method.

    For most writers, which only output to an
   ImageOutputStream, a single-element array
   containing ImageOutputStream.class should be
   returned.

  returns: a non-null array of
   Classobjects of length at least 1. - `java.lang.Class[]`"
  ([^ImageWriterSpi this]
    (-> this (.getOutputTypes))))

(defn can-encode-image?
  "Returns true if the ImageWriter
   implementation associated with this service provider is able to
   encode an image with the given layout.  The layout
   (i.e., the image's SampleModel and
   ColorModel) is described by an
   ImageTypeSpecifier object.

    A return value of true is not an absolute
   guarantee of successful encoding; the encoding process may still
   produce errors due to factors such as I/O errors, inconsistent
   or malformed data structures, etc.  The intent is that a
   reasonable inspection of the basic structure of the image be
   performed in order to determine if it is within the scope of
   the encoding format.  For example, a service provider for a
   format that can only encode greyscale would return
   false if handed an RGB BufferedImage.
   Similarly, a service provider for a format that can encode
   8-bit RGB imagery might refuse to encode an image with an
   associated alpha channel.

    Different ImageWriters, and thus service
   providers, may choose to be more or less strict.  For example,
   they might accept an image with premultiplied alpha even though
   it will have to be divided out of each pixel, at some loss of
   precision, in order to be stored.

  type - an ImageTypeSpecifier specifying the layout of the image to be written. - `javax.imageio.ImageTypeSpecifier`

  returns: true if this writer is likely to be able
   to encode images with the given layout. - `boolean`

  throws: java.lang.IllegalArgumentException - if type is null."
  (^Boolean [^ImageWriterSpi this ^javax.imageio.ImageTypeSpecifier type]
    (-> this (.canEncodeImage type))))

(defn create-writer-instance
  "Returns an instance of the ImageWriter
   implementation associated with this service provider.
   The returned object will initially be in an initial state
   as if its reset method had been called.

    An Object may be supplied to the plug-in at
   construction time.  The nature of the object is entirely
   plug-in specific.

    Typically, a plug-in will implement this method using code
   such as return new MyImageWriter(this).

  extension - a plug-in specific extension object, which may be null. - `java.lang.Object`

  returns: an ImageWriter instance. - `javax.imageio.ImageWriter`

  throws: java.io.IOException - if the attempt to instantiate the writer fails."
  (^javax.imageio.ImageWriter [^ImageWriterSpi this ^java.lang.Object extension]
    (-> this (.createWriterInstance extension)))
  (^javax.imageio.ImageWriter [^ImageWriterSpi this]
    (-> this (.createWriterInstance))))

(defn own-writer?
  "Returns true if the ImageWriter object
   passed in is an instance of the ImageWriter
   associated with this service provider.

  writer - an ImageWriter instance. - `javax.imageio.ImageWriter`

  returns: true if writer is recognized - `boolean`

  throws: java.lang.IllegalArgumentException - if writer is null."
  (^Boolean [^ImageWriterSpi this ^javax.imageio.ImageWriter writer]
    (-> this (.isOwnWriter writer))))

(defn get-image-reader-spi-names
  "Returns an array of Strings containing all the
   fully qualified names of all the ImageReaderSpi
   classes that can understand the internal metadata
   representation used by the ImageWriter associated
   with this service provider, or null if there are
   no such ImageReaders specified.  If a
   non-null value is returned, it must have non-zero
   length.

    The first item in the array must be the name of the service
   provider for the `preferred` reader, as it will be used to
   instantiate the ImageReader returned by
   ImageIO.getImageReader(ImageWriter).

    This mechanism may be used to obtain
   ImageReaders that will generated non-pixel
   meta-data (see IIOExtraDataInfo) in a structure
   understood by an ImageWriter.  By reading the
   image and obtaining this data from one of the
   ImageReaders obtained with this method and passing
   it on to the ImageWriter, a client program can
   read an image, modify it in some way, and write it back out
   preserving all meta-data, without having to understand anything
   about the internal structure of the meta-data, or even about
   the image format.

  returns: an array of Strings of length at least 1
   containing names of ImageReaderSpis, or
   null. - `java.lang.String[]`"
  ([^ImageWriterSpi this]
    (-> this (.getImageReaderSpiNames))))

