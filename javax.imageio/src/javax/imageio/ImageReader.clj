(ns javax.imageio.ImageReader
  "An abstract superclass for parsing and decoding of images.  This
  class must be subclassed by classes that read in images in the
  context of the Java Image I/O framework.

   ImageReader objects are normally instantiated by
  the service provider interface (SPI) class for the specific format.
  Service provider classes (e.g., instances of
  ImageReaderSpi) are registered with the
  IIORegistry, which uses them for format recognition
  and presentation of available format readers and writers.

   When an input source is set (using the setInput
  method), it may be marked as `seek forward only`.  This setting
  means that images contained within the input source will only be
  read in order, possibly allowing the reader to avoid caching
  portions of the input containing data associated with images that
  have been read previously."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio ImageReader]))

(defn remove-iio-read-warning-listener
  "Removes an IIOReadWarningListener from the list of
   registered error listeners.  If the listener was not previously
   registered, or if listener is null,
   no exception will be thrown and no action will be taken.

  listener - an IIOReadWarningListener to be unregistered. - `javax.imageio.event.IIOReadWarningListener`"
  ([^javax.imageio.ImageReader this ^javax.imageio.event.IIOReadWarningListener listener]
    (-> this (.removeIIOReadWarningListener listener))))

(defn set-input
  "Sets the input source to use to the given
   ImageInputStream or other Object.
   The input source must be set before any of the query or read
   methods are used.  If input is null,
   any currently set input source will be removed.  In any case,
   the value of minIndex will be initialized to 0.

    The seekForwardOnly parameter controls whether
   the value returned by getMinIndex will be
   increased as each image (or thumbnail, or image metadata) is
   read.  If seekForwardOnly is true, then a call to
   read(index) will throw an
   IndexOutOfBoundsException if index < this.minIndex;
   otherwise, the value of
   minIndex will be set to index.  If
   seekForwardOnly is false, the value of
   minIndex will remain 0 regardless of any read
   operations.

    The ignoreMetadata parameter, if set to
   true, allows the reader to disregard any metadata
   encountered during the read.  Subsequent calls to the
   getStreamMetadata and
   getImageMetadata methods may return
   null, and an IIOImage returned from
   readAll may return null from their
   getMetadata method.  Setting this parameter may
   allow the reader to work more efficiently.  The reader may
   choose to disregard this setting and return metadata normally.

    Subclasses should take care to remove any cached
   information based on the previous stream, such as header
   information or partially decoded image data.

    Use of a general Object other than an
   ImageInputStream is intended for readers that
   interact directly with a capture device or imaging protocol.
   The set of legal classes is advertised by the reader's service
   provider's getInputTypes method; most readers
   will return a single-element array containing only
   ImageInputStream.class to indicate that they
   accept only an ImageInputStream.

    The default implementation checks the input
   argument against the list returned by
   originatingProvider.getInputTypes() and fails
   if the argument is not an instance of one of the classes
   in the list.  If the originating provider is set to
   null, the input is accepted only if it is an
   ImageInputStream.

  input - the ImageInputStream or other Object to use for future decoding. - `java.lang.Object`
  seek-forward-only - if true, images and metadata may only be read in ascending order from this input source. - `boolean`
  ignore-metadata - if true, metadata may be ignored during reads. - `boolean`

  throws: java.lang.IllegalArgumentException - if input is not an instance of one of the classes returned by the originating service provider's getInputTypes method, or is not an ImageInputStream."
  ([^javax.imageio.ImageReader this ^java.lang.Object input ^Boolean seek-forward-only ^Boolean ignore-metadata]
    (-> this (.setInput input seek-forward-only ignore-metadata)))
  ([^javax.imageio.ImageReader this ^java.lang.Object input ^Boolean seek-forward-only]
    (-> this (.setInput input seek-forward-only)))
  ([^javax.imageio.ImageReader this ^java.lang.Object input]
    (-> this (.setInput input))))

(defn add-iio-read-progress-listener
  "Adds an IIOReadProgressListener to the list of
   registered progress listeners.  If listener is
   null, no exception will be thrown and no action
   will be taken.

  listener - an IIOReadProgressListener to be registered. - `javax.imageio.event.IIOReadProgressListener`"
  ([^javax.imageio.ImageReader this ^javax.imageio.event.IIOReadProgressListener listener]
    (-> this (.addIIOReadProgressListener listener))))

(defn read-tile-raster
  "Returns a new Raster object containing the raw
   pixel data from the tile, without any color conversion applied.
   The application must determine how to interpret the pixel data by other
   means.

    If canReadRaster() returns
   false, this method throws an
   UnsupportedOperationException.

    The default implementation checks if reading
   Rasters is supported, and if so calls readRaster(imageIndex, null) if
   tileX and tileY are 0, or throws an
   IllegalArgumentException otherwise.

  image-index - the index of the image to be retrieved. - `int`
  tile-x - the column index (starting with 0) of the tile to be retrieved. - `int`
  tile-y - the row index (starting with 0) of the tile to be retrieved. - `int`

  returns: the tile as a Raster. - `java.awt.image.Raster`

  throws: java.lang.UnsupportedOperationException - if this plug-in does not support reading raw Rasters."
  (^java.awt.image.Raster [^javax.imageio.ImageReader this ^Integer image-index ^Integer tile-x ^Integer tile-y]
    (-> this (.readTileRaster image-index tile-x tile-y))))

(defn add-iio-read-warning-listener
  "Adds an IIOReadWarningListener to the list of
   registered warning listeners.  If listener is
   null, no exception will be thrown and no action
   will be taken.  Messages sent to the given listener will be
   localized, if possible, to match the current
   Locale.  If no Locale has been set,
   warning messages may be localized as the reader sees fit.

  listener - an IIOReadWarningListener to be registered. - `javax.imageio.event.IIOReadWarningListener`"
  ([^javax.imageio.ImageReader this ^javax.imageio.event.IIOReadWarningListener listener]
    (-> this (.addIIOReadWarningListener listener))))

(defn get-width
  "Returns the width in pixels of the given image within the input
   source.

    If the image can be rendered to a user-specified size, then
   this method returns the default width.

  image-index - the index of the image to be queried. - `int`

  returns: the width of the image, as an int. - `int`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^Integer [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.getWidth image-index))))

(defn get-image-types
  "Returns an Iterator containing possible image
   types to which the given image may be decoded, in the form of
   ImageTypeSpecifierss.  At least one legal image
   type will be returned.

    The first element of the iterator should be the most
   `natural` type for decoding the image with as little loss as
   possible.  For example, for a JPEG image the first entry should
   be an RGB image, even though the image data is stored
   internally in a YCbCr color space.

  image-index - the index of the image to be retrieved. - `int`

  returns: an Iterator containing at least one
   ImageTypeSpecifier representing suggested image
   types for decoding the current given image. - `java.util.Iterator<javax.imageio.ImageTypeSpecifier>`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^java.util.Iterator [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.getImageTypes image-index))))

(defn read-tile
  "Reads the tile indicated by the tileX and
   tileY arguments, returning it as a
   BufferedImage.  If the arguments are out of range,
   an IllegalArgumentException is thrown.  If the
   image is not tiled, the values 0, 0 will return the entire
   image; any other values will cause an
   IllegalArgumentException to be thrown.

    This method is merely a convenience equivalent to calling
   read(int, ImageReadParam) with a read param
   specifying a source region having offsets of
   tileX*getTileWidth(imageIndex),
   tileY*getTileHeight(imageIndex) and width and
   height of getTileWidth(imageIndex),
   getTileHeight(imageIndex); and subsampling
   factors of 1 and offsets of 0.  To subsample a tile, call
   read with a read param specifying this region
   and different subsampling parameters.

    The default implementation returns the entire image if
   tileX and tileY are 0, or throws
   an IllegalArgumentException otherwise.

  image-index - the index of the image to be retrieved. - `int`
  tile-x - the column index (starting with 0) of the tile to be retrieved. - `int`
  tile-y - the row index (starting with 0) of the tile to be retrieved. - `int`

  returns: the tile as a BufferedImage. - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^java.awt.image.BufferedImage [^javax.imageio.ImageReader this ^Integer image-index ^Integer tile-x ^Integer tile-y]
    (-> this (.readTile image-index tile-x tile-y))))

(defn read-raster
  "Returns a new Raster object containing the raw pixel data
   from the image stream, without any color conversion applied.  The
   application must determine how to interpret the pixel data by other
   means.  Any destination or image-type parameters in the supplied
   ImageReadParam object are ignored, but all other
   parameters are used exactly as in the read
   method, except that any destination offset is used as a logical rather
   than a physical offset.  The size of the returned Raster
   will always be that of the source region clipped to the actual image.
   Logical offsets in the stream itself are ignored.

    This method allows formats that normally apply a color
   conversion, such as JPEG, and formats that do not normally have an
   associated colorspace, such as remote sensing or medical imaging data,
   to provide access to raw pixel data.

    Any registered readUpdateListeners are ignored, as
   there is no BufferedImage, but all other listeners are
   called exactly as they are for the read method.

    If canReadRaster() returns
   false, this method throws an
   UnsupportedOperationException.

    If the supplied ImageReadParam contains
   optional setting values not supported by this reader (e.g.
   source render size or any format-specific settings), they will
   be ignored.

    The default implementation throws an
   UnsupportedOperationException.

  image-index - the index of the image to be read. - `int`
  param - an ImageReadParam used to control the reading process, or null. - `javax.imageio.ImageReadParam`

  returns: the desired portion of the image as a
   Raster. - `java.awt.image.Raster`

  throws: java.lang.UnsupportedOperationException - if this plug-in does not support reading raw Rasters."
  (^java.awt.image.Raster [^javax.imageio.ImageReader this ^Integer image-index ^javax.imageio.ImageReadParam param]
    (-> this (.readRaster image-index param))))

(defn seek-forward-only?
  "Returns true if the current input source has been
   marked as seek forward only by passing true as the
   seekForwardOnly argument to the
   setInput method.

  returns: true if the input source is seek forward
   only. - `boolean`"
  (^Boolean [^javax.imageio.ImageReader this]
    (-> this (.isSeekForwardOnly))))

(defn dispose
  "Allows any resources held by this object to be released.  The
   result of calling any other method (other than
   finalize) subsequent to a call to this method
   is undefined.

   It is important for applications to call this method when they
   know they will no longer be using this ImageReader.
   Otherwise, the reader may continue to hold on to resources
   indefinitely.

   The default implementation of this method in the superclass does
   nothing.  Subclass implementations should ensure that all resources,
   especially native resources, are released."
  ([^javax.imageio.ImageReader this]
    (-> this (.dispose))))

(defn remove-all-iio-read-warning-listeners
  "Removes all currently registered
   IIOReadWarningListener objects.

    The default implementation sets the
   warningListeners and warningLocales
   instance variables to null."
  ([^javax.imageio.ImageReader this]
    (-> this (.removeAllIIOReadWarningListeners))))

(defn reader-supports-thumbnails
  "Returns true if the image format understood by
   this reader supports thumbnail preview images associated with
   it.  The default implementation returns false.

    If this method returns false,
   hasThumbnails and getNumThumbnails
   will return false and 0,
   respectively, and readThumbnail will throw an
   UnsupportedOperationException, regardless of their
   arguments.

    A reader that does not support thumbnails need not
   implement any of the thumbnail-related methods.

  returns: true if thumbnails are supported. - `boolean`"
  (^Boolean [^javax.imageio.ImageReader this]
    (-> this (.readerSupportsThumbnails))))

(defn get-tile-grid-x-offset
  "Returns the X coordinate of the upper-left corner of tile (0,
   0) in the given image.

    A reader for which the tile grid X offset always has the
   same value (usually 0), may return the value without accessing
   any image data.  In such cases, it is not necessary to throw an
   exception even if no input source has been set or the image
   index is out of bounds.

    The default implementation simply returns 0, which is
   correct for non-tiled images and tiled images in most formats.
   Readers that support tiling with non-(0, 0) offsets should
   override this method.

  image-index - the index of the image to be queried. - `int`

  returns: the X offset of the tile grid. - `int`

  throws: java.lang.IllegalStateException - if an input source is required to determine the return value, but none has been set."
  (^Integer [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.getTileGridXOffset image-index))))

(defn get-locale
  "Returns the currently set Locale, or
   null if none has been set.

  returns: the current Locale, or null. - `java.util.Locale`"
  (^java.util.Locale [^javax.imageio.ImageReader this]
    (-> this (.getLocale))))

(defn get-image-metadata
  "Returns an IIOMetadata object representing the
   metadata associated with the given image, or null
   if the reader does not support reading metadata or none
   is available.

    The resulting metadata object is only responsible for
   returning documents in the format named by
   formatName.  Within any documents that are
   returned, only nodes whose names are members of
   nodeNames are required to be returned.  In this
   way, the amount of metadata processing done by the reader may
   be kept to a minimum, based on what information is actually
   needed.

    If formatName is not the name of a supported
   metadata format, null may be returned.

    In all cases, it is legal to return a more capable metadata
   object than strictly necessary.  The format name and node names
   are merely hints that may be used to reduce the reader's
   workload.

    The default implementation simply returns the result of
   calling getImageMetadata(imageIndex), after
   checking that the format name is supported.  If it is not,
   null is returned.

  image-index - the index of the image whose metadata is to be retrieved. - `int`
  format-name - a metadata format name that may be used to retrieve a document from the returned IIOMetadata object. - `java.lang.String`
  node-names - a Set containing the names of nodes that may be contained in a retrieved document. - `java.util.Set<java.lang.String>`

  returns: an IIOMetadata object, or null. - `javax.imageio.metadata.IIOMetadata`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^javax.imageio.metadata.IIOMetadata [^javax.imageio.ImageReader this ^Integer image-index ^java.lang.String format-name ^java.util.Set node-names]
    (-> this (.getImageMetadata image-index format-name node-names)))
  (^javax.imageio.metadata.IIOMetadata [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.getImageMetadata image-index))))

(defn read
  "Reads the image indexed by imageIndex and returns
   it as a complete BufferedImage, using a supplied
   ImageReadParam.

    The actual BufferedImage returned will be
   chosen using the algorithm defined by the
   getDestination method.

    Any registered IIOReadProgressListener objects
   will be notified by calling their imageStarted
   method, followed by calls to their imageProgress
   method as the read progresses.  Finally their
   imageComplete method will be called.
   IIOReadUpdateListener objects may be updated at
   other times during the read as pixels are decoded.  Finally,
   IIOReadWarningListener objects will receive
   notification of any non-fatal warnings that occur during
   decoding.

    The set of source bands to be read and destination bands to
   be written is determined by calling getSourceBands
   and getDestinationBands on the supplied
   ImageReadParam.  If the lengths of the arrays
   returned by these methods differ, the set of source bands
   contains an index larger that the largest available source
   index, or the set of destination bands contains an index larger
   than the largest legal destination index, an
   IllegalArgumentException is thrown.

    If the supplied ImageReadParam contains
   optional setting values not supported by this reader (e.g.
   source render size or any format-specific settings), they will
   be ignored.

  image-index - the index of the image to be retrieved. - `int`
  param - an ImageReadParam used to control the reading process, or null. - `javax.imageio.ImageReadParam`

  returns: the desired portion of the image as a
   BufferedImage. - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^java.awt.image.BufferedImage [^javax.imageio.ImageReader this ^Integer image-index ^javax.imageio.ImageReadParam param]
    (-> this (.read image-index param)))
  (^java.awt.image.BufferedImage [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.read image-index))))

(defn reset
  "Restores the ImageReader to its initial state.

    The default implementation calls setInput(null,
   false), setLocale(null),
   removeAllIIOReadUpdateListeners(),
   removeAllIIOReadWarningListeners(),
   removeAllIIOReadProgressListeners(), and
   clearAbortRequest."
  ([^javax.imageio.ImageReader this]
    (-> this (.reset))))

(defn get-default-read-param
  "Returns a default ImageReadParam object
   appropriate for this format.  All subclasses should define a
   set of default values for all parameters and return them with
   this call.  This method may be called before the input source
   is set.

    The default implementation constructs and returns a new
   ImageReadParam object that does not allow source
   scaling (i.e., it returns new
   ImageReadParam().

  returns: an ImageReadParam object which may be used
   to control the decoding process using a set of default settings. - `javax.imageio.ImageReadParam`"
  (^javax.imageio.ImageReadParam [^javax.imageio.ImageReader this]
    (-> this (.getDefaultReadParam))))

(defn get-thumbnail-width
  "Returns the width of the thumbnail preview image indexed by
   thumbnailIndex, associated with the image indexed
   by ImageIndex.

    If the reader does not support thumbnails,
   (readerSupportsThumbnails returns
   false), an UnsupportedOperationException
   will be thrown.

    The default implementation simply returns
   readThumbnail(imageindex,
   thumbnailIndex).getWidth().  Subclasses should therefore
   override this method if possible in order to avoid forcing the
   thumbnail to be read.

  image-index - the index of the image to be retrieved. - `int`
  thumbnail-index - the index of the thumbnail to be retrieved. - `int`

  returns: the width of the desired thumbnail as an int. - `int`

  throws: java.lang.UnsupportedOperationException - if thumbnails are not supported."
  (^Integer [^javax.imageio.ImageReader this ^Integer image-index ^Integer thumbnail-index]
    (-> this (.getThumbnailWidth image-index thumbnail-index))))

(defn read-as-rendered-image
  "Returns a RenderedImage object that contains the
   contents of the image indexed by imageIndex.  By
   default, the returned image is simply the
   BufferedImage returned by read(imageIndex,
   param).

    The semantics of this method may differ from those of the
   other read methods in several ways.  First, any
   destination image and/or image type set in the
   ImageReadParam may be ignored.  Second, the usual
   listener calls are not guaranteed to be made, or to be
   meaningful if they are.  This is because the returned image may
   not be fully populated with pixel data at the time it is
   returned, or indeed at any time.

    If the supplied ImageReadParam contains
   optional setting values not supported by this reader (e.g.
   source render size or any format-specific settings), they will
   be ignored.

    The default implementation just calls
   read(imageIndex, param).

  image-index - the index of the image to be retrieved. - `int`
  param - an ImageReadParam used to control the reading process, or null. - `javax.imageio.ImageReadParam`

  returns: a RenderedImage object providing a view of
   the image. - `java.awt.image.RenderedImage`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^java.awt.image.RenderedImage [^javax.imageio.ImageReader this ^Integer image-index ^javax.imageio.ImageReadParam param]
    (-> this (.readAsRenderedImage image-index param))))

(defn remove-iio-read-progress-listener
  "Removes an IIOReadProgressListener from the list
   of registered progress listeners.  If the listener was not
   previously registered, or if listener is
   null, no exception will be thrown and no action
   will be taken.

  listener - an IIOReadProgressListener to be unregistered. - `javax.imageio.event.IIOReadProgressListener`"
  ([^javax.imageio.ImageReader this ^javax.imageio.event.IIOReadProgressListener listener]
    (-> this (.removeIIOReadProgressListener listener))))

(defn get-originating-provider
  "Returns the ImageReaderSpi that was passed in on
   the constructor.  Note that this value may be null.

  returns: an ImageReaderSpi, or null. - `javax.imageio.spi.ImageReaderSpi`"
  (^javax.imageio.spi.ImageReaderSpi [^javax.imageio.ImageReader this]
    (-> this (.getOriginatingProvider))))

(defn has-thumbnails?
  "Returns true if the given image has thumbnail
   preview images associated with it.  If the format does not
   support thumbnails (readerSupportsThumbnails
   returns false), false will be
   returned regardless of whether an input source has been set or
   whether imageIndex is in bounds.

    The default implementation returns true if
   getNumThumbnails returns a value greater than 0.

  image-index - the index of the image being queried. - `int`

  returns: true if the given image has thumbnails. - `boolean`

  throws: java.lang.IllegalStateException - if the reader supports thumbnails but the input source has not been set."
  (^Boolean [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.hasThumbnails image-index))))

(defn get-input
  "Returns the ImageInputStream or other
   Object previously set as the input source.  If the
   input source has not been set, null is returned.

  returns: the Object that will be used for future
   decoding, or null. - `java.lang.Object`"
  (^java.lang.Object [^javax.imageio.ImageReader this]
    (-> this (.getInput))))

(defn image-tiled?
  "Returns true if the image is organized into
   tiles, that is, equal-sized non-overlapping rectangles.

    A reader plug-in may choose whether or not to expose tiling
   that is present in the image as it is stored.  It may even
   choose to advertise tiling when none is explicitly present.  In
   general, tiling should only be advertised if there is some
   advantage (in speed or space) to accessing individual tiles.
   Regardless of whether the reader advertises tiling, it must be
   capable of reading an arbitrary rectangular region specified in
   an ImageReadParam.

    A reader for which all images are guaranteed to be tiled,
   or are guaranteed not to be tiled, may return true
   or false respectively without accessing any image
   data.  In such cases, it is not necessary to throw an exception
   even if no input source has been set or the image index is out
   of bounds.

    The default implementation just returns false.

  image-index - the index of the image to be queried. - `int`

  returns: true if the image is tiled. - `boolean`

  throws: java.lang.IllegalStateException - if an input source is required to determine the return value, but none has been set."
  (^Boolean [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.isImageTiled image-index))))

(defn get-num-thumbnails
  "Returns the number of thumbnail preview images associated with
   the given image.  If the format does not support thumbnails,
   (readerSupportsThumbnails returns
   false), 0 will be returned regardless
   of whether an input source has been set or whether
   imageIndex is in bounds.

    The default implementation returns 0 without checking its
   argument.

  image-index - the index of the image being queried. - `int`

  returns: the number of thumbnails associated with the given
   image. - `int`

  throws: java.lang.IllegalStateException - if the reader supports thumbnails but the input source has not been set."
  (^Integer [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.getNumThumbnails image-index))))

(defn get-num-images
  "Returns the number of images, not including thumbnails, available
   from the current input source.

    Note that some image formats (such as animated GIF) do not
   specify how many images are present in the stream.  Thus
   determining the number of images will require the entire stream
   to be scanned and may require memory for buffering.  If images
   are to be processed in order, it may be more efficient to
   simply call read with increasing indices until an
   IndexOutOfBoundsException is thrown to indicate
   that no more images are available.  The
   allowSearch parameter may be set to
   false to indicate that an exhaustive search is not
   desired; the return value will be -1 to indicate
   that a search is necessary.  If the input has been specified
   with seekForwardOnly set to true,
   this method throws an IllegalStateException if
   allowSearch is set to true.

  allow-search - if true, the true number of images will be returned even if a search is required. If false, the reader may return -1 without performing the search. - `boolean`

  returns: the number of images, as an int, or
   -1 if allowSearch is
   false and a search would be required. - `int`

  throws: java.lang.IllegalStateException - if the input source has not been set, or if the input has been specified with seekForwardOnly set to true."
  (^Integer [^javax.imageio.ImageReader this ^Boolean allow-search]
    (-> this (.getNumImages allow-search))))

(defn get-stream-metadata
  "Returns an IIOMetadata object representing the
   metadata associated with the input source as a whole (i.e.,
   not associated with any particular image).  If no such data
   exists, null is returned.

    The resulting metadata object is only responsible for
   returning documents in the format named by
   formatName.  Within any documents that are
   returned, only nodes whose names are members of
   nodeNames are required to be returned.  In this
   way, the amount of metadata processing done by the reader may
   be kept to a minimum, based on what information is actually
   needed.

    If formatName is not the name of a supported
   metadata format, null is returned.

    In all cases, it is legal to return a more capable metadata
   object than strictly necessary.  The format name and node names
   are merely hints that may be used to reduce the reader's
   workload.

    The default implementation simply returns the result of
   calling getStreamMetadata(), after checking that
   the format name is supported.  If it is not,
   null is returned.

  format-name - a metadata format name that may be used to retrieve a document from the returned IIOMetadata object. - `java.lang.String`
  node-names - a Set containing the names of nodes that may be contained in a retrieved document. - `java.util.Set<java.lang.String>`

  returns: an IIOMetadata object, or null. - `javax.imageio.metadata.IIOMetadata`

  throws: java.lang.IllegalArgumentException - if nodeNames is null."
  (^javax.imageio.metadata.IIOMetadata [^javax.imageio.ImageReader this ^java.lang.String format-name ^java.util.Set node-names]
    (-> this (.getStreamMetadata format-name node-names)))
  (^javax.imageio.metadata.IIOMetadata [^javax.imageio.ImageReader this]
    (-> this (.getStreamMetadata))))

(defn get-tile-grid-y-offset
  "Returns the Y coordinate of the upper-left corner of tile (0,
   0) in the given image.

    A reader for which the tile grid Y offset always has the
   same value (usually 0), may return the value without accessing
   any image data.  In such cases, it is not necessary to throw an
   exception even if no input source has been set or the image
   index is out of bounds.

    The default implementation simply returns 0, which is
   correct for non-tiled images and tiled images in most formats.
   Readers that support tiling with non-(0, 0) offsets should
   override this method.

  image-index - the index of the image to be queried. - `int`

  returns: the Y offset of the tile grid. - `int`

  throws: java.lang.IllegalStateException - if an input source is required to determine the return value, but none has been set."
  (^Integer [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.getTileGridYOffset image-index))))

(defn get-height
  "Returns the height in pixels of the given image within the
   input source.

    If the image can be rendered to a user-specified size, then
   this method returns the default height.

  image-index - the index of the image to be queried. - `int`

  returns: the height of the image, as an int. - `int`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^Integer [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.getHeight image-index))))

(defn get-available-locales
  "Returns an array of Locales that may be used to
   localize warning listeners and compression settings.  A return
   value of null indicates that localization is not
   supported.

    The default implementation returns a clone of the
   availableLocales instance variable if it is
   non-null, or else returns null.

  returns: an array of Locales that may be used as
   arguments to setLocale, or null. - `java.util.Locale[]`"
  ([^javax.imageio.ImageReader this]
    (-> this (.getAvailableLocales))))

(defn get-raw-image-type
  "Returns an ImageTypeSpecifier indicating the
   SampleModel and ColorModel which most
   closely represents the `raw` internal format of the image.  For
   example, for a JPEG image the raw type might have a YCbCr color
   space even though the image would conventionally be transformed
   into an RGB color space prior to display.  The returned value
   should also be included in the list of values returned by
   getImageTypes.

    The default implementation simply returns the first entry
   from the list provided by getImageType.

  image-index - the index of the image to be queried. - `int`

  returns: an ImageTypeSpecifier. - `javax.imageio.ImageTypeSpecifier`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^javax.imageio.ImageTypeSpecifier [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.getRawImageType image-index))))

(defn set-locale
  "Sets the current Locale of this
   ImageReader to the given value.  A value of
   null removes any previous setting, and indicates
   that the reader should localize as it sees fit.

  locale - the desired Locale, or null. - `java.util.Locale`

  throws: java.lang.IllegalArgumentException - if locale is non-null but is not one of the values returned by getAvailableLocales."
  ([^javax.imageio.ImageReader this ^java.util.Locale locale]
    (-> this (.setLocale locale))))

(defn get-aspect-ratio
  "Returns the aspect ratio of the given image (that is, its width
   divided by its height) as a float.  For images
   that are inherently resizable, this method provides a way to
   determine the appropriate width given a desired height, or vice
   versa.  For non-resizable images, the true width and height
   are used.

    The default implementation simply returns
   (float)getWidth(imageIndex)/getHeight(imageIndex).

  image-index - the index of the image to be queried. - `int`

  returns: a float indicating the aspect ratio of the
   given image. - `float`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^Float [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.getAspectRatio image-index))))

(defn remove-all-iio-read-progress-listeners
  "Removes all currently registered
   IIOReadProgressListener objects.

    The default implementation sets the
   progressListeners instance variable to
   null."
  ([^javax.imageio.ImageReader this]
    (-> this (.removeAllIIOReadProgressListeners))))

(defn remove-iio-read-update-listener
  "Removes an IIOReadUpdateListener from the list of
   registered update listeners.  If the listener was not
   previously registered, or if listener is
   null, no exception will be thrown and no action
   will be taken.

  listener - an IIOReadUpdateListener to be unregistered. - `javax.imageio.event.IIOReadUpdateListener`"
  ([^javax.imageio.ImageReader this ^javax.imageio.event.IIOReadUpdateListener listener]
    (-> this (.removeIIOReadUpdateListener listener))))

(defn add-iio-read-update-listener
  "Adds an IIOReadUpdateListener to the list of
   registered update listeners.  If listener is
   null, no exception will be thrown and no action
   will be taken.  The listener will receive notification of pixel
   updates as images and thumbnails are decoded, including the
   starts and ends of progressive passes.

    If no update listeners are present, the reader may choose
   to perform fewer updates to the pixels of the destination
   images and/or thumbnails, which may result in more efficient
   decoding.

    For example, in progressive JPEG decoding each pass
   contains updates to a set of coefficients, which would have to
   be transformed into pixel values and converted to an RGB color
   space for each pass if listeners are present.  If no listeners
   are present, the coefficients may simply be accumulated and the
   final results transformed and color converted one time only.

    The final results of decoding will be the same whether or
   not intermediate updates are performed.  Thus if only the final
   image is desired it may be preferable not to register any
   IIOReadUpdateListeners.  In general, progressive
   updating is most effective when fetching images over a network
   connection that is very slow compared to local CPU processing;
   over a fast connection, progressive updates may actually slow
   down the presentation of the image.

  listener - an IIOReadUpdateListener to be registered. - `javax.imageio.event.IIOReadUpdateListener`"
  ([^javax.imageio.ImageReader this ^javax.imageio.event.IIOReadUpdateListener listener]
    (-> this (.addIIOReadUpdateListener listener))))

(defn get-tile-height
  "Returns the height of a tile in the given image.

    The default implementation simply returns
   getHeight(imageIndex), which is correct for
   non-tiled images.  Readers that support tiling should override
   this method.

  image-index - the index of the image to be queried. - `int`

  returns: the height of a tile. - `int`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^Integer [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.getTileHeight image-index))))

(defn read-thumbnail
  "Returns the thumbnail preview image indexed by
   thumbnailIndex, associated with the image indexed
   by ImageIndex as a BufferedImage.

    Any registered IIOReadProgressListener objects
   will be notified by calling their
   thumbnailStarted, thumbnailProgress,
   and thumbnailComplete methods.

    If the reader does not support thumbnails,
   (readerSupportsThumbnails returns
   false), an UnsupportedOperationException
   will be thrown regardless of whether an input source has been
   set or whether the indices are in bounds.

    The default implementation throws an
   UnsupportedOperationException.

  image-index - the index of the image to be retrieved. - `int`
  thumbnail-index - the index of the thumbnail to be retrieved. - `int`

  returns: the desired thumbnail as a BufferedImage. - `java.awt.image.BufferedImage`

  throws: java.lang.UnsupportedOperationException - if thumbnails are not supported."
  (^java.awt.image.BufferedImage [^javax.imageio.ImageReader this ^Integer image-index ^Integer thumbnail-index]
    (-> this (.readThumbnail image-index thumbnail-index))))

(defn get-tile-width
  "Returns the width of a tile in the given image.

    The default implementation simply returns
   getWidth(imageIndex), which is correct for
   non-tiled images.  Readers that support tiling should override
   this method.

  image-index - the index of the image to be queried. - `int`

  returns: the width of a tile. - `int`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^Integer [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.getTileWidth image-index))))

(defn abort
  "Requests that any current read operation be aborted.  The
   contents of the image following the abort will be undefined.

    Readers should call clearAbortRequest at the
   beginning of each read operation, and poll the value of
   abortRequested regularly during the read."
  ([^javax.imageio.ImageReader this]
    (-> this (.abort))))

(defn get-format-name
  "Returns a String identifying the format of the
   input source.

    The default implementation returns
   originatingProvider.getFormatNames()[0].
   Implementations that may not have an originating service
   provider, or which desire a different naming policy should
   override this method.

  returns: the format name, as a String. - `java.lang.String`

  throws: java.io.IOException - if an error occurs reading the information from the input source."
  (^java.lang.String [^javax.imageio.ImageReader this]
    (-> this (.getFormatName))))

(defn read-all
  "Reads the image indexed by imageIndex and returns
   an IIOImage containing the image, thumbnails, and
   associated image metadata, using a supplied
   ImageReadParam.

    The actual BufferedImage referenced by the
   returned IIOImage will be chosen using the
   algorithm defined by the getDestination method.

    Any registered IIOReadProgressListener objects
   will be notified by calling their imageStarted
   method, followed by calls to their imageProgress
   method as the read progresses.  Finally their
   imageComplete method will be called.
   IIOReadUpdateListener objects may be updated at
   other times during the read as pixels are decoded.  Finally,
   IIOReadWarningListener objects will receive
   notification of any non-fatal warnings that occur during
   decoding.

    The set of source bands to be read and destination bands to
   be written is determined by calling getSourceBands
   and getDestinationBands on the supplied
   ImageReadParam.  If the lengths of the arrays
   returned by these methods differ, the set of source bands
   contains an index larger that the largest available source
   index, or the set of destination bands contains an index larger
   than the largest legal destination index, an
   IllegalArgumentException is thrown.

    Thumbnails will be returned in their entirety regardless of
   the region settings.

    If the supplied ImageReadParam contains
   optional setting values not supported by this reader (e.g.
   source render size or any format-specific settings), those
   values will be ignored.

  image-index - the index of the image to be retrieved. - `int`
  param - an ImageReadParam used to control the reading process, or null. - `javax.imageio.ImageReadParam`

  returns: an IIOImage containing the desired portion
   of the image, a set of thumbnails, and associated image
   metadata. - `javax.imageio.IIOImage`

  throws: java.lang.IllegalStateException - if the input source has not been set."
  (^javax.imageio.IIOImage [^javax.imageio.ImageReader this ^Integer image-index ^javax.imageio.ImageReadParam param]
    (-> this (.readAll image-index param)))
  (^java.util.Iterator [^javax.imageio.ImageReader this ^javax.imageio.ImageReadParam> params]
    (-> this (.readAll params))))

(defn get-thumbnail-height
  "Returns the height of the thumbnail preview image indexed by
   thumbnailIndex, associated with the image indexed
   by ImageIndex.

    If the reader does not support thumbnails,
   (readerSupportsThumbnails returns
   false), an UnsupportedOperationException
   will be thrown.

    The default implementation simply returns
   readThumbnail(imageindex,
   thumbnailIndex).getHeight().  Subclasses should
   therefore override this method if possible in order to avoid
   forcing the thumbnail to be read.

  image-index - the index of the image to be retrieved. - `int`
  thumbnail-index - the index of the thumbnail to be retrieved. - `int`

  returns: the height of the desired thumbnail as an int. - `int`

  throws: java.lang.UnsupportedOperationException - if thumbnails are not supported."
  (^Integer [^javax.imageio.ImageReader this ^Integer image-index ^Integer thumbnail-index]
    (-> this (.getThumbnailHeight image-index thumbnail-index))))

(defn ignoring-metadata?
  "Returns true if the current input source has been
   marked as allowing metadata to be ignored by passing
   true as the ignoreMetadata argument
   to the setInput method.

  returns: true if the metadata may be ignored. - `boolean`"
  (^Boolean [^javax.imageio.ImageReader this]
    (-> this (.isIgnoringMetadata))))

(defn remove-all-iio-read-update-listeners
  "Removes all currently registered
   IIOReadUpdateListener objects.

    The default implementation sets the
   updateListeners instance variable to
   null."
  ([^javax.imageio.ImageReader this]
    (-> this (.removeAllIIOReadUpdateListeners))))

(defn random-access-easy?
  "Returns true if the storage format of the given
   image places no inherent impediment on random access to pixels.
   For most compressed formats, such as JPEG, this method should
   return false, as a large section of the image in
   addition to the region of interest may need to be decoded.

    This is merely a hint for programs that wish to be
   efficient; all readers must be able to read arbitrary regions
   as specified in an ImageReadParam.

    Note that formats that return false from
   this method may nonetheless allow tiling (e.g. Restart
   Markers in JPEG), and random access will likely be reasonably
   efficient on tiles.  See isImageTiled.

    A reader for which all images are guaranteed to support
   easy random access, or are guaranteed not to support easy
   random access, may return true or
   false respectively without accessing any image
   data.  In such cases, it is not necessary to throw an exception
   even if no input source has been set or the image index is out
   of bounds.

    The default implementation returns false.

  image-index - the index of the image to be queried. - `int`

  returns: true if reading a region of interest of
   the given image is likely to be efficient. - `boolean`

  throws: java.lang.IllegalStateException - if an input source is required to determine the return value, but none has been set."
  (^Boolean [^javax.imageio.ImageReader this ^Integer image-index]
    (-> this (.isRandomAccessEasy image-index))))

(defn can-read-raster?
  "Returns true if this plug-in supports reading
   just a Raster of pixel data.
   If this method returns false, calls to
   readRaster or readTileRaster
   will throw an UnsupportedOperationException.

    The default implementation returns false.

  returns: true if this plug-in supports reading raw
   Rasters. - `boolean`"
  (^Boolean [^javax.imageio.ImageReader this]
    (-> this (.canReadRaster))))

(defn get-min-index
  "Returns the lowest valid index for reading an image, thumbnail,
   or image metadata.  If seekForwardOnly() is
   false, this value will typically remain 0,
   indicating that random access is possible.  Otherwise, it will
   contain the value of the most recently accessed index, and
   increase in a monotonic fashion.

  returns: the minimum legal index for reading. - `int`"
  (^Integer [^javax.imageio.ImageReader this]
    (-> this (.getMinIndex))))

