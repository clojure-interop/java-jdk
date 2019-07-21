(ns javax.imageio.spi.ImageReaderWriterSpi
  "A superclass containing instance variables and methods common to
  ImageReaderSpi and ImageWriterSpi."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.spi ImageReaderWriterSpi]))

(defn ->image-reader-writer-spi
  "Constructor.

  Constructs an ImageReaderWriterSpi with a given
   set of values.

  vendor-name - the vendor name, as a non-null String. - `java.lang.String`
  version - a version identifier, as a non-null String. - `java.lang.String`
  names - a non-null array of Strings indicating the format names. At least one entry must be present. - `java.lang.String[]`
  suffixes - an array of Strings indicating the common file suffixes. If no suffixes are defined, null should be supplied. An array of length 0 will be normalized to null. - `java.lang.String[]`
  mime-types - an array of Strings indicating the format's MIME types. If no MIME types are defined, null should be supplied. An array of length 0 will be normalized to null. - `java.lang.String[]`
  plugin-class-name - the fully-qualified name of the associated ImageReader or ImageWriter class, as a non-null String. - `java.lang.String`
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

  throws: java.lang.IllegalArgumentException - if pluginClassName is null."
  (^ImageReaderWriterSpi [^java.lang.String vendor-name ^java.lang.String version names suffixes mime-types ^java.lang.String plugin-class-name ^Boolean supports-standard-stream-metadata-format ^java.lang.String native-stream-metadata-format-name ^java.lang.String native-stream-metadata-format-class-name extra-stream-metadata-format-names extra-stream-metadata-format-class-names ^Boolean supports-standard-image-metadata-format ^java.lang.String native-image-metadata-format-name ^java.lang.String native-image-metadata-format-class-name extra-image-metadata-format-names extra-image-metadata-format-class-names]
    (new ImageReaderWriterSpi vendor-name version names suffixes mime-types plugin-class-name supports-standard-stream-metadata-format native-stream-metadata-format-name native-stream-metadata-format-class-name extra-stream-metadata-format-names extra-stream-metadata-format-class-names supports-standard-image-metadata-format native-image-metadata-format-name native-image-metadata-format-class-name extra-image-metadata-format-names extra-image-metadata-format-class-names))
  (^ImageReaderWriterSpi []
    (new ImageReaderWriterSpi )))

(defn get-stream-metadata-format
  "Returns an IIOMetadataFormat object describing the
   given stream metadata format, or null if no
   description is available.  The supplied name must be the native
   stream metadata format name, the standard metadata format name,
   or one of those returned by
   getExtraStreamMetadataFormatNames.

  format-name - the desired stream metadata format. - `java.lang.String`

  returns: an IIOMetadataFormat object. - `javax.imageio.metadata.IIOMetadataFormat`

  throws: java.lang.IllegalArgumentException - if formatName is null or is not a supported name."
  (^javax.imageio.metadata.IIOMetadataFormat [^ImageReaderWriterSpi this ^java.lang.String format-name]
    (-> this (.getStreamMetadataFormat format-name))))

(defn get-native-image-metadata-format-name
  "Returns the name of the \"native\" image metadata format for
   this plug-in, which typically allows for lossless encoding and
   transmission of the image metadata stored in the format handled by
   this plug-in.  If no such format is supported,
   nullwill be returned.

    The default implementation returns the
   nativeImageMetadataFormatName instance variable,
   which is typically set by the constructor.

  returns: the name of the native image metadata format, or
   null. - `java.lang.String`"
  (^java.lang.String [^ImageReaderWriterSpi this]
    (-> this (.getNativeImageMetadataFormatName))))

(defn get-file-suffixes
  "Returns an array of Strings containing a list of
   file suffixes associated with the formats that are generally
   usable by the ImageReader or
   ImageWriter implementation associated with this
   service provider.  For example, a single
   ImageReader might be able to process files with
   '.pbm' and '.pnm' suffixes, or both '.jpg' and '.jpeg'
   suffixes.  If there are no known file suffixes,
   null will be returned.

    Returning a particular suffix does not guarantee that files
   with that suffix can be processed; it merely indicates that it
   may be worthwhile attempting to decode or encode such files
   using this service provider.

  returns: an array of Strings or length at least 1
   containing common file suffixes associated with this reader or
   writer, or null. - `java.lang.String[]`"
  ([^ImageReaderWriterSpi this]
    (-> this (.getFileSuffixes))))

(defn get-mime-types
  "Returns an array of Strings containing a list of
   MIME types associated with the formats that are generally
   usable by the ImageReader or
   ImageWriter implementation associated with this
   service provider.

    Ideally, only a single MIME type would be required in order
   to describe a particular format.  However, for several reasons
   it is necessary to associate a list of types with each service
   provider.  First, many common image file formats do not have
   standard MIME types, so a list of commonly used unofficial
   names will be required, such as image/x-pbm and
   image/x-portable-bitmap.  Some file formats have
   official MIME types but may sometimes be referred to using
   their previous unofficial designations, such as
   image/x-png instead of the official
   image/png.  Finally, a single service provider may
   be capable of parsing multiple distinct types from the MIME
   point of view, for example image/x-xbitmap and
   image/x-xpixmap.

    Returning a particular MIME type does not guarantee that
   files claiming to be of that type can be processed; it merely
   indicates that it may be worthwhile attempting to decode or
   encode such files using this service provider.

  returns: an array of Strings or length at least 1
   containing MIME types associated with this reader or writer, or
   null. - `java.lang.String[]`"
  ([^ImageReaderWriterSpi this]
    (-> this (.getMIMETypes))))

(defn standard-image-metadata-format-supported?
  "Returns true if the standard metadata format is
   among the document formats recognized by the
   getAsTree and setFromTree methods on
   the image metadata objects produced or consumed by this
   plug-in.

  returns: true if the standard format is supported
   for image metadata. - `boolean`"
  (^Boolean [^ImageReaderWriterSpi this]
    (-> this (.isStandardImageMetadataFormatSupported))))

(defn get-extra-stream-metadata-format-names
  "Returns an array of Strings containing the names
   of additional document formats, other than the native and
   standard formats, recognized by the
   getAsTree and setFromTree methods on
   the stream metadata objects produced or consumed by this
   plug-in.

    If the plug-in does not handle metadata, null should be
   returned.

    The set of formats may differ according to the particular
   images being read or written; this method should indicate all
   the additional formats supported by the plug-in under any
   circumstances.

    The default implementation returns a clone of the
   extraStreamMetadataFormatNames instance variable,
   which is typically set by the constructor.

  returns: an array of Strings, or null. - `java.lang.String[]`"
  ([^ImageReaderWriterSpi this]
    (-> this (.getExtraStreamMetadataFormatNames))))

(defn get-extra-image-metadata-format-names
  "Returns an array of Strings containing the names
   of additional document formats, other than the native and
   standard formats, recognized by the
   getAsTree and setFromTree methods on
   the image metadata objects produced or consumed by this
   plug-in.

    If the plug-in does not handle image metadata, null should
   be returned.

    The set of formats may differ according to the particular
   images being read or written; this method should indicate all
   the additional formats supported by the plug-in under any circumstances.

    The default implementation returns a clone of the
   extraImageMetadataFormatNames instance variable,
   which is typically set by the constructor.

  returns: an array of Strings, or null. - `java.lang.String[]`"
  ([^ImageReaderWriterSpi this]
    (-> this (.getExtraImageMetadataFormatNames))))

(defn get-image-metadata-format
  "Returns an IIOMetadataFormat object describing the
   given image metadata format, or null if no
   description is available.  The supplied name must be the native
   image metadata format name, the standard metadata format name,
   or one of those returned by
   getExtraImageMetadataFormatNames.

  format-name - the desired image metadata format. - `java.lang.String`

  returns: an IIOMetadataFormat object. - `javax.imageio.metadata.IIOMetadataFormat`

  throws: java.lang.IllegalArgumentException - if formatName is null or is not a supported name."
  (^javax.imageio.metadata.IIOMetadataFormat [^ImageReaderWriterSpi this ^java.lang.String format-name]
    (-> this (.getImageMetadataFormat format-name))))

(defn get-native-stream-metadata-format-name
  "Returns the name of the \"native\" stream metadata format for
   this plug-in, which typically allows for lossless encoding and
   transmission of the stream metadata stored in the format handled by
   this plug-in.  If no such format is supported,
   nullwill be returned.

    The default implementation returns the
   nativeStreamMetadataFormatName instance variable,
   which is typically set by the constructor.

  returns: the name of the native stream metadata format, or
   null. - `java.lang.String`"
  (^java.lang.String [^ImageReaderWriterSpi this]
    (-> this (.getNativeStreamMetadataFormatName))))

(defn get-plugin-class-name
  "Returns the fully-qualified class name of the
   ImageReader or ImageWriter plug-in
   associated with this service provider.

  returns: the class name, as a non-null
   String. - `java.lang.String`"
  (^java.lang.String [^ImageReaderWriterSpi this]
    (-> this (.getPluginClassName))))

(defn get-format-names
  "Returns an array of Strings containing
   human-readable names for the formats that are generally usable
   by the ImageReader or ImageWriter
   implementation associated with this service provider.  For
   example, a single ImageReader might be able to
   process both PBM and PNM files.

  returns: a non-null array of Strings
   or length at least 1 containing informal format names
   associated with this reader or writer. - `java.lang.String[]`"
  ([^ImageReaderWriterSpi this]
    (-> this (.getFormatNames))))

(defn standard-stream-metadata-format-supported?
  "Returns true if the standard metadata format is
   among the document formats recognized by the
   getAsTree and setFromTree methods on
   the stream metadata objects produced or consumed by this
   plug-in.

  returns: true if the standard format is supported
   for stream metadata. - `boolean`"
  (^Boolean [^ImageReaderWriterSpi this]
    (-> this (.isStandardStreamMetadataFormatSupported))))

