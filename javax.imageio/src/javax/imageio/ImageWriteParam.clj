(ns javax.imageio.ImageWriteParam
  "A class describing how a stream is to be encoded.  Instances of
  this class or its subclasses are used to supply prescriptive
  \"how-to\" information to instances of ImageWriter.

   A plug-in for a specific image format may define a subclass of
  this class, and return objects of that class from the
  getDefaultWriteParam method of its
  ImageWriter implementation.  For example, the built-in
  JPEG writer plug-in will return instances of
  javax.imageio.plugins.jpeg.JPEGImageWriteParam.

   The region of the image to be written is determined by first
  intersecting the actual bounds of the image with the rectangle
  specified by IIOParam.setSourceRegion, if any.  If the
  resulting rectangle has a width or height of zero, the writer will
  throw an IIOException. If the intersection is
  non-empty, writing will commence with the first subsampled pixel
  and include additional pixels within the intersected bounds
  according to the horizontal and vertical subsampling factors
  specified by IIOParam.setSourceSubsampling.

   Individual features such as tiling, progressive encoding, and
  compression may be set in one of four modes.
  MODE_DISABLED disables the features;
  MODE_DEFAULT enables the feature with
  writer-controlled parameter values; MODE_EXPLICIT
  enables the feature and allows the use of a set method
  to provide additional parameters; and
  MODE_COPY_FROM_METADATA copies relevant parameter
  values from the stream and image metadata objects passed to the
  writer.  The default for all features is
  MODE_COPY_FROM_METADATA.  Non-standard features
  supplied in subclasses are encouraged, but not required to use a
  similar scheme.

   Plug-in writers may extend the functionality of
  ImageWriteParam by providing a subclass that implements
  additional, plug-in specific interfaces.  It is up to the plug-in
  to document what interfaces are available and how they are to be
  used.  Writers will silently ignore any extended features of an
  ImageWriteParam subclass of which they are not aware.
  Also, they may ignore any optional features that they normally
  disable when creating their own ImageWriteParam
  instances via getDefaultWriteParam.

   Note that unless a query method exists for a capability, it must
  be supported by all ImageWriter implementations
  (e.g. progressive encoding is optional, but subsampling must be
  supported)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio ImageWriteParam]))

(defn ->image-write-param
  "Constructor.

  Constructs an ImageWriteParam set to use a
   given Locale.

  locale - a Locale to be used to localize compression type names and quality descriptions, or null. - `java.util.Locale`"
  (^ImageWriteParam [^java.util.Locale locale]
    (new ImageWriteParam locale)))

(def *-mode-disabled
  "Static Constant.

  A constant value that may be passed into methods such as
   setTilingMode, setProgressiveMode,
   and setCompressionMode to disable a feature for
   future writes.  That is, when this mode is set the stream will
   not be tiled, progressive, or compressed, and the
   relevant accessor methods will throw an
   IllegalStateException.

  type: int"
  ImageWriteParam/MODE_DISABLED)

(def *-mode-default
  "Static Constant.

  A constant value that may be passed into methods such as
   setTilingMode,
   setProgressiveMode, and
   setCompressionMode to enable that feature for
   future writes.  That is, when this mode is enabled the stream
   will be tiled, progressive, or compressed according to a
   sensible default chosen internally by the writer in a plug-in
   dependent way, and the relevant accessor methods will
   throw an IllegalStateException.

  type: int"
  ImageWriteParam/MODE_DEFAULT)

(def *-mode-explicit
  "Static Constant.

  A constant value that may be passed into methods such as
   setTilingMode or setCompressionMode
   to enable a feature for future writes. That is, when this mode
   is set the stream will be tiled or compressed according to
   additional information supplied to the corresponding
   set methods in this class and retrievable from the
   corresponding get methods.  Note that this mode is
   not supported for progressive output.

  type: int"
  ImageWriteParam/MODE_EXPLICIT)

(def *-mode-copy-from-metadata
  "Static Constant.

  A constant value that may be passed into methods such as
   setTilingMode, setProgressiveMode, or
   setCompressionMode to enable that feature for
   future writes.  That is, when this mode is enabled the stream
   will be tiled, progressive, or compressed based on the contents
   of stream and/or image metadata passed into the write
   operation, and any relevant accessor methods will throw an
   IllegalStateException.

    This is the default mode for all features, so that a read
   including metadata followed by a write including metadata will
   preserve as much information as possible.

  type: int"
  ImageWriteParam/MODE_COPY_FROM_METADATA)

(defn get-compression-type
  "Returns the currently set compression type, or
   null if none has been set.  The type is returned
   as a String from among those returned by
   getCompressionTypes.
   If no compression type has been set, null is
   returned.

    The default implementation checks whether compression is
   supported and the compression mode is
   MODE_EXPLICIT.  If so, it returns the value of the
   compressionType instance variable.

  returns: the current compression type as a String,
   or null if no type is set. - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if the writer does not support compression."
  (^java.lang.String [^ImageWriteParam this]
    (-> this (.getCompressionType))))

(defn compression-lossless?
  "Returns true if the current compression type
   provides lossless compression.  If a plug-in provides only
   one mandatory compression type, then this method may be
   called without calling setCompressionType first.

    If there are multiple compression types but none has
   been set, an IllegalStateException is thrown.

    The default implementation checks whether compression is
   supported and the compression mode is
   MODE_EXPLICIT.  If so, if
   getCompressionTypes() is null or
   getCompressionType() is non-null
   true is returned as a convenience.

  returns: true if the current compression type is
   lossless. - `boolean`

  throws: java.lang.UnsupportedOperationException - if the writer does not support compression."
  (^Boolean [^ImageWriteParam this]
    (-> this (.isCompressionLossless))))

(defn set-compression-quality
  "Sets the compression quality to a value between 0
   and 1.  Only a single compression quality setting
   is supported by default; writers can provide extended versions
   of ImageWriteParam that offer more control.  For
   lossy compression schemes, the compression quality should
   control the tradeoff between file size and image quality (for
   example, by choosing quantization tables when writing JPEG
   images).  For lossless schemes, the compression quality may be
   used to control the tradeoff between file size and time taken
   to perform the compression (for example, by optimizing row
   filters and setting the ZLIB compression level when writing
   PNG images).

    A compression quality setting of 0.0 is most generically
   interpreted as \"high compression is important,\" while a setting of
   1.0 is most generically interpreted as \"high image quality is
   important.\"

    If there are multiple compression types but none has been
   set, an IllegalStateException is thrown.

    The default implementation checks that compression is
   supported, and that the compression mode is
   MODE_EXPLICIT.  If so, if
   getCompressionTypes() returns null or
   compressionType is non-null it sets
   the compressionQuality instance variable.

  quality - a float between 0and 1 indicating the desired quality level. - `float`

  throws: java.lang.UnsupportedOperationException - if the writer does not support compression."
  ([^ImageWriteParam this ^Float quality]
    (-> this (.setCompressionQuality quality))))

(defn get-tiling-mode
  "Returns the current tiling mode, if tiling is supported.
   Otherwise throws an UnsupportedOperationException.

  returns: the current tiling mode. - `int`

  throws: java.lang.UnsupportedOperationException - if canWriteTiles returns false."
  (^Integer [^ImageWriteParam this]
    (-> this (.getTilingMode))))

(defn set-tiling-mode
  "Determines whether the image will be tiled in the output
   stream and, if it will, how the tiling parameters will be
   determined.  The modes are interpreted as follows:



   MODE_DISABLED - The image will not be tiled.
   setTiling will throw an
   IllegalStateException.

   MODE_DEFAULT - The image will be tiled using
   default parameters.  setTiling will throw an
   IllegalStateException.

   MODE_EXPLICIT - The image will be tiled
   according to parameters given in the setTiling
   method.  Any previously set tiling parameters are discarded.

   MODE_COPY_FROM_METADATA - The image will
   conform to the metadata object passed in to a write.
   setTiling will throw an
   IllegalStateException.

  mode - The mode to use for tiling. - `int`

  throws: java.lang.UnsupportedOperationException - if canWriteTiles returns false."
  ([^ImageWriteParam this ^Integer mode]
    (-> this (.setTilingMode mode))))

(defn can-offset-tiles?
  "Returns true if the writer can perform tiling with
   non-zero grid offsets while writing.  If this method returns
   false, then setTiling will throw an
   UnsupportedOperationException if the grid offset
   arguments are not both zero.  If canWriteTiles
   returns false, this method will return
   false as well.

  returns: true if the writer supports non-zero tile
   offsets. - `boolean`"
  (^Boolean [^ImageWriteParam this]
    (-> this (.canOffsetTiles))))

(defn get-tile-grid-x-offset
  "Returns the horizontal tile grid offset of an image as it will
   be written to the output stream.  If tiling parameters have not
   been set, an IllegalStateException is thrown.

  returns: the tile grid X offset to be used for encoding. - `int`

  throws: java.lang.UnsupportedOperationException - if the plug-in does not support tiling."
  (^Integer [^ImageWriteParam this]
    (-> this (.getTileGridXOffset))))

(defn get-locale
  "Returns the currently set Locale, or
   null if only a default Locale is
   supported.

  returns: the current Locale, or null. - `java.util.Locale`"
  (^java.util.Locale [^ImageWriteParam this]
    (-> this (.getLocale))))

(defn set-compression-type
  "Sets the compression type to one of the values indicated by
   getCompressionTypes.  If a value of
   null is passed in, any previous setting is
   removed.

    The default implementation checks whether compression is
   supported and the compression mode is
   MODE_EXPLICIT.  If so, it calls
   getCompressionTypes and checks if
   compressionType is one of the legal values.  If it
   is, the compressionType instance variable is set.
   If compressionType is null, the
   instance variable is set without performing any checking.

  compression-type - one of the Strings returned by getCompressionTypes, or null to remove any previous setting. - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if there are no settable compression types."
  ([^ImageWriteParam this ^java.lang.String compression-type]
    (-> this (.setCompressionType compression-type))))

(defn get-compression-quality
  "Returns the current compression quality setting.

    If there are multiple compression types but none has been
   set, an IllegalStateException is thrown.

    The default implementation checks that compression is
   supported and that the compression mode is
   MODE_EXPLICIT.  If so, if
   getCompressionTypes() is null or
   getCompressionType() is non-null, it
   returns the value of the compressionQuality
   instance variable.

  returns: the current compression quality setting. - `float`

  throws: java.lang.UnsupportedOperationException - if the writer does not support compression."
  (^Float [^ImageWriteParam this]
    (-> this (.getCompressionQuality))))

(defn unset-compression
  "Removes any previous compression type and quality settings.

    The default implementation sets the instance variable
   compressionType to null, and the
   instance variable compressionQuality to
   1.0F.

  throws: java.lang.UnsupportedOperationException - if the plug-in does not support compression."
  ([^ImageWriteParam this]
    (-> this (.unsetCompression))))

(defn set-progressive-mode
  "Specifies that the writer is to write the image out in a
   progressive mode such that the stream will contain a series of
   scans of increasing quality.  If progressive encoding is not
   supported, an UnsupportedOperationException will
   be thrown.

     The mode argument determines how
   the progression parameters are chosen, and must be either
   MODE_DISABLED,
   MODE_COPY_FROM_METADATA, or
   MODE_DEFAULT.  Otherwise an
   IllegalArgumentException is thrown.

    The modes are interpreted as follows:


     MODE_DISABLED - No progression.  Use this to
     turn off progression.

     MODE_COPY_FROM_METADATA - The output image
     will use whatever progression parameters are found in the
     metadata objects passed into the writer.

     MODE_DEFAULT - The image will be written
     progressively, with parameters chosen by the writer.


    The default is MODE_COPY_FROM_METADATA.

  mode - The mode for setting progression in the output stream. - `int`

  throws: java.lang.UnsupportedOperationException - if the writer does not support progressive encoding."
  ([^ImageWriteParam this ^Integer mode]
    (-> this (.setProgressiveMode mode))))

(defn get-tile-grid-y-offset
  "Returns the vertical tile grid offset of an image as it will
   be written to the output stream.  If tiling parameters have not
   been set, an IllegalStateException is thrown.

  returns: the tile grid Y offset to be used for encoding. - `int`

  throws: java.lang.UnsupportedOperationException - if the plug-in does not support tiling."
  (^Integer [^ImageWriteParam this]
    (-> this (.getTileGridYOffset))))

(defn get-compression-quality-descriptions
  "Returns an array of Strings that may be used along
   with getCompressionQualityValues as part of a user
   interface for setting or displaying the compression quality
   level.  The String with index i
   provides a description of the range of quality levels between
   getCompressionQualityValues[i] and
   getCompressionQualityValues[i  1].  Note that the
   length of the array returned from
   getCompressionQualityValues will always be one
   greater than that returned from
   getCompressionQualityDescriptions.

    As an example, the strings \"Good\", \"Better\", and \"Best\"
   could be associated with the ranges [0, .33),
   [.33, .66), and [.66, 1.0].  In this
   case, getCompressionQualityDescriptions would
   return { \"Good\", \"Better\", \"Best\" } and
   getCompressionQualityValues would return
   { 0.0F, .33F, .66F, 1.0F }.

    If no descriptions are available, null is
   returned.  If null is returned from
   getCompressionQualityValues, this method must also
   return null.

    The descriptions should be localized for the
   Locale returned by getLocale, if it
   is non-null.

    If there are multiple compression types but none has been set,
   an IllegalStateException is thrown.

    The default implementation checks that compression is
   supported and that the compression mode is
   MODE_EXPLICIT.  If so, if
   getCompressionTypes() is null or
   getCompressionType() is non-null, it
   returns null.

  returns: an array of Strings containing localized
   descriptions of the compression quality levels. - `java.lang.String[]`

  throws: java.lang.UnsupportedOperationException - if the writer does not support compression."
  ([^ImageWriteParam this]
    (-> this (.getCompressionQualityDescriptions))))

(defn get-tile-height
  "Returns the height of each tile in an image as it will be written to
   the output stream.  If tiling parameters have not
   been set, an IllegalStateException is thrown.

  returns: the tile height to be used for encoding. - `int`

  throws: java.lang.UnsupportedOperationException - if the plug-in does not support tiling."
  (^Integer [^ImageWriteParam this]
    (-> this (.getTileHeight))))

(defn can-write-compressed?
  "Returns true if this writer supports compression.

  returns: true if the writer supports compression. - `boolean`"
  (^Boolean [^ImageWriteParam this]
    (-> this (.canWriteCompressed))))

(defn get-progressive-mode
  "Returns the current mode for writing the stream in a
   progressive manner.

  returns: the current mode for progressive encoding. - `int`

  throws: java.lang.UnsupportedOperationException - if the writer does not support progressive encoding."
  (^Integer [^ImageWriteParam this]
    (-> this (.getProgressiveMode))))

(defn get-bit-rate
  "Returns a float indicating an estimate of the
   number of bits of output data for each bit of input image data
   at the given quality level.  The value will typically lie
   between 0 and 1, with smaller values
   indicating more compression.  A special value of
   -1.0F is used to indicate that no estimate is
   available.

    If there are multiple compression types but none has been set,
   an IllegalStateException is thrown.

    The default implementation checks that compression is
   supported and the compression mode is
   MODE_EXPLICIT.  If so, if
   getCompressionTypes() is null or
   getCompressionType() is non-null, and
   quality is within bounds, it returns
   -1.0.

  quality - the quality setting whose bit rate is to be queried. - `float`

  returns: an estimate of the compressed bit rate, or
   -1.0F if no estimate is available. - `float`

  throws: java.lang.UnsupportedOperationException - if the writer does not support compression."
  (^Float [^ImageWriteParam this ^Float quality]
    (-> this (.getBitRate quality))))

(defn unset-tiling
  "Removes any previous tile grid parameters specified by calls to
   setTiling.

    The default implementation sets the instance variables
   tileWidth, tileHeight,
   tileGridXOffset, and
   tileGridYOffset to 0.

  throws: java.lang.UnsupportedOperationException - if the plug-in does not support tiling."
  ([^ImageWriteParam this]
    (-> this (.unsetTiling))))

(defn get-tile-width
  "Returns the width of each tile in an image as it will be
   written to the output stream.  If tiling parameters have not
   been set, an IllegalStateException is thrown.

  returns: the tile width to be used for encoding. - `int`

  throws: java.lang.UnsupportedOperationException - if the plug-in does not support tiling."
  (^Integer [^ImageWriteParam this]
    (-> this (.getTileWidth))))

(defn get-compression-mode
  "Returns the current compression mode, if compression is
   supported.

  returns: the current compression mode. - `int`

  throws: java.lang.UnsupportedOperationException - if the writer does not support compression."
  (^Integer [^ImageWriteParam this]
    (-> this (.getCompressionMode))))

(defn can-write-tiles?
  "Returns true if the writer can perform tiling
   while writing.  If this method returns false, then
   setTiling will throw an
   UnsupportedOperationException.

  returns: true if the writer supports tiling. - `boolean`"
  (^Boolean [^ImageWriteParam this]
    (-> this (.canWriteTiles))))

(defn get-localized-compression-type-name
  "Returns a localized version of the name of the current
   compression type, using the Locale returned by
   getLocale.

    The default implementation checks whether compression is
   supported and the compression mode is
   MODE_EXPLICIT.  If so, if
   compressionType is non-null the value
   of getCompressionType is returned as a
   convenience.

  returns: a String containing a localized version of
   the name of the current compression type. - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if the writer does not support compression."
  (^java.lang.String [^ImageWriteParam this]
    (-> this (.getLocalizedCompressionTypeName))))

(defn set-compression-mode
  "Specifies whether compression is to be performed, and if so how
   compression parameters are to be determined.  The mode
   argument must be one of the four modes, interpreted as follows:


     MODE_DISABLED - If the mode is set to
     MODE_DISABLED, methods that query or modify the
     compression type or parameters will throw an
     IllegalStateException (if compression is
     normally supported by the plug-in). Some writers, such as JPEG,
     do not normally offer uncompressed output. In this case, attempting
     to set the mode to MODE_DISABLED will throw an
     UnsupportedOperationException and the mode will not be
     changed.

     MODE_EXPLICIT - Compress using the
     compression type and quality settings specified in this
     ImageWriteParam.  Any previously set compression
     parameters are discarded.

     MODE_COPY_FROM_METADATA - Use whatever
     compression parameters are specified in metadata objects
     passed in to the writer.

     MODE_DEFAULT - Use default compression
     parameters.


    The default is MODE_COPY_FROM_METADATA.

  mode - The mode for setting compression in the output stream. - `int`

  throws: java.lang.UnsupportedOperationException - if the writer does not support compression, or does not support the requested mode."
  ([^ImageWriteParam this ^Integer mode]
    (-> this (.setCompressionMode mode))))

(defn set-tiling
  "Specifies that the image should be tiled in the output stream.
   The tileWidth and tileHeight
   parameters specify the width and height of the tiles in the
   file.  If the tile width or height is greater than the width or
   height of the image, the image is not tiled in that dimension.

    If canOffsetTiles returns false,
   then the tileGridXOffset and
   tileGridYOffset parameters must be zero.

  tile-width - the width of each tile. - `int`
  tile-height - the height of each tile. - `int`
  tile-grid-x-offset - the horizontal offset of the tile grid. - `int`
  tile-grid-y-offset - the vertical offset of the tile grid. - `int`

  throws: java.lang.UnsupportedOperationException - if the plug-in does not support grid offsets, and the grid offsets are not both zero."
  ([^ImageWriteParam this ^Integer tile-width ^Integer tile-height ^Integer tile-grid-x-offset ^Integer tile-grid-y-offset]
    (-> this (.setTiling tile-width tile-height tile-grid-x-offset tile-grid-y-offset))))

(defn get-preferred-tile-sizes
  "Returns an array of Dimensions indicating the
   legal size ranges for tiles as they will be encoded in the
   output file or stream.  The returned array is a copy.

    The information is returned as a set of pairs; the first
   element of a pair contains an (inclusive) minimum width and
   height, and the second element contains an (inclusive) maximum
   width and height.  Together, each pair defines a valid range of
   sizes.  To specify a fixed size, use the same width and height
   for both elements.  To specify an arbitrary range, a value of
   null is used in place of an actual array of
   Dimensions.

    If no array is specified on the constructor, but tiling is
   allowed, then this method returns null.

  returns: an array of Dimensions with an even length
   of at least two, or null. - `java.awt.Dimension[]`

  throws: java.lang.UnsupportedOperationException - if the plug-in does not support tiling."
  ([^ImageWriteParam this]
    (-> this (.getPreferredTileSizes))))

(defn get-compression-quality-values
  "Returns an array of floats that may be used along
   with getCompressionQualityDescriptions as part of a user
   interface for setting or displaying the compression quality
   level.  See getCompressionQualityDescriptions for more information.

    If no descriptions are available, null is
   returned.  If null is returned from
   getCompressionQualityDescriptions, this method
   must also return null.

    If there are multiple compression types but none has been set,
   an IllegalStateException is thrown.

    The default implementation checks that compression is
   supported and that the compression mode is
   MODE_EXPLICIT.  If so, if
   getCompressionTypes() is null or
   getCompressionType() is non-null, it
   returns null.

  returns: an array of floats indicating the
   boundaries between the compression quality levels as described
   by the Strings from
   getCompressionQualityDescriptions. - `float[]`

  throws: java.lang.UnsupportedOperationException - if the writer does not support compression."
  ([^ImageWriteParam this]
    (-> this (.getCompressionQualityValues))))

(defn can-write-progressive?
  "Returns true if the writer can write out images
   as a series of passes of progressively increasing quality.

  returns: true if the writer supports progressive
   encoding. - `boolean`"
  (^Boolean [^ImageWriteParam this]
    (-> this (.canWriteProgressive))))

(defn get-compression-types
  "Returns a list of available compression types, as an array or
   Strings, or null if a compression
   type may not be chosen using these interfaces.  The array
   returned is a copy.

    If the writer only offers a single, mandatory form of
   compression, it is not necessary to provide any named
   compression types.  Named compression types should only be
   used where the user is able to make a meaningful choice
   between different schemes.

    The default implementation checks if compression is
   supported and throws an
   UnsupportedOperationException if not.  Otherwise,
   it returns a clone of the compressionTypes
   instance variable if it is non-null, or else
   returns null.

  returns: an array of Strings containing the
   (non-localized) names of available compression types, or
   null. - `java.lang.String[]`

  throws: java.lang.UnsupportedOperationException - if the writer does not support compression."
  ([^ImageWriteParam this]
    (-> this (.getCompressionTypes))))

