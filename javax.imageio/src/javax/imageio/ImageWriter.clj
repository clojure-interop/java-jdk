(ns javax.imageio.ImageWriter
  "An abstract superclass for encoding and writing images.  This class
  must be subclassed by classes that write out images in the context
  of the Java Image I/O framework.

   ImageWriter objects are normally instantiated by
  the service provider class for the specific format.  Service
  provider classes are registered with the IIORegistry,
  which uses them for format recognition and presentation of
  available format readers and writers."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio ImageWriter]))

(defn remove-all-iio-write-warning-listeners
  "Removes all currently registered
   IIOWriteWarningListener objects.

    The default implementation sets the
   warningListeners and warningLocales
   instance variables to null."
  ([^javax.imageio.ImageWriter this]
    (-> this (.removeAllIIOWriteWarningListeners))))

(defn replace-stream-metadata
  "Replaces the stream metadata in the output with new
   information.  If the output is an
   ImageOutputStream, the prior contents of the
   stream are examined and possibly edited to make room for the
   new data.  All of the prior contents of the output must be
   available for reading and writing.

    If canReplaceStreamMetadata returns
   false, an
   UnsupportedOperationException will be thrown.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  stream-metadata - an IIOMetadata object representing stream metadata, or null to use default values. - `javax.imageio.metadata.IIOMetadata`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this ^javax.imageio.metadata.IIOMetadata stream-metadata]
    (-> this (.replaceStreamMetadata stream-metadata))))

(defn prepare-write-sequence
  "Prepares a stream to accept a series of subsequent
   writeToSequence calls, using the provided stream
   metadata object.  The metadata will be written to the stream if
   it should precede the image data.  If the argument is null,
   default stream metadata is used.

    If the output is an ImageOutputStream, the existing
   contents of the output prior to the current seek position are
   flushed, and need not be readable or writable.  If the format
   requires that endWriteSequence be able to rewind to
   patch up the header information, such as for a sequence of images
   in a single TIFF file, then the metadata written by this method
   must remain in a writable portion of the stream.  Other formats
   may flush the stream after this method and after each image.

    If canWriteSequence returns false,
   this method will throw an
   UnsupportedOperationException.

    The output must have been set beforehand using either
   the setOutput method.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  stream-metadata - A stream metadata object, or null. - `javax.imageio.metadata.IIOMetadata`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this ^javax.imageio.metadata.IIOMetadata stream-metadata]
    (-> this (.prepareWriteSequence stream-metadata))))

(defn can-insert-empty?
  "Returns true if the writer supports the insertion
   of a new, empty image at the given index.  The pixel values of
   the image are undefined, and may be specified in pieces using
   the replacePixels methods.  Existing images with
   indices greater than or equal to the insertion index will have
   their indices increased by 1.  A value for
   imageIndex of -1 may be used to
   signify an index one larger than the current largest index.

    A writer that does not support insertion of empty images
   may return false without performing bounds
   checking on the index.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise returns false
   without checking the value of imageIndex.

  image-index - the index at which the image is to be inserted. - `int`

  returns: true if an empty image may be inserted at
   the given index. - `boolean`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this ^Integer image-index]
    (-> this (.canInsertEmpty image-index))))

(defn can-write-rasters?
  "Returns true if the methods that take an
   IIOImage parameter are capable of dealing with a
   Raster (as opposed to RenderedImage)
   source image.  If this method returns false, then
   those methods will throw an
   UnsupportedOperationException if supplied with an
   IIOImage containing a Raster.

    The default implementation returns false.

  returns: true if Raster sources are
   supported. - `boolean`"
  ([^javax.imageio.ImageWriter this]
    (-> this (.canWriteRasters))))

(defn get-default-image-metadata
  "Returns an IIOMetadata object containing default
   values for encoding an image of the given type.  The contents
   of the object may be manipulated using either the XML tree
   structure returned by the IIOMetadata.getAsTree
   method, an IIOMetadataController object, or via
   plug-in specific interfaces, and the resulting data supplied to
   one of the write methods that take a stream
   metadata parameter.

    An optional ImageWriteParam may be supplied
   for cases where it may affect the structure of the image
   metadata.

    If the supplied ImageWriteParam contains
   optional setting values not supported by this writer (e.g.
   progressive encoding or any format-specific settings), they
   will be ignored.

  image-type - an ImageTypeSpecifier indicating the format of the image to be written later. - `javax.imageio.ImageTypeSpecifier`
  param - an ImageWriteParam that will be used to encode the image, or null. - `javax.imageio.ImageWriteParam`

  returns: an IIOMetadata object. - `javax.imageio.metadata.IIOMetadata`"
  ([^javax.imageio.ImageWriter this ^javax.imageio.ImageTypeSpecifier image-type ^javax.imageio.ImageWriteParam param]
    (-> this (.getDefaultImageMetadata image-type param))))

(defn add-iio-write-warning-listener
  "Adds an IIOWriteWarningListener to the list of
   registered warning listeners.  If listener is
   null, no exception will be thrown and no action
   will be taken.  Messages sent to the given listener will be
   localized, if possible, to match the current
   Locale.  If no Locale has been set,
   warning messages may be localized as the writer sees fit.

  listener - an IIOWriteWarningListener to be registered. - `javax.imageio.event.IIOWriteWarningListener`"
  ([^javax.imageio.ImageWriter this ^javax.imageio.event.IIOWriteWarningListener listener]
    (-> this (.addIIOWriteWarningListener listener))))

(defn remove-iio-write-progress-listener
  "Removes an IIOWriteProgressListener from the list
   of registered progress listeners.  If the listener was not
   previously registered, or if listener is
   null, no exception will be thrown and no action
   will be taken.

  listener - an IIOWriteProgressListener to be deregistered. - `javax.imageio.event.IIOWriteProgressListener`"
  ([^javax.imageio.ImageWriter this ^javax.imageio.event.IIOWriteProgressListener listener]
    (-> this (.removeIIOWriteProgressListener listener))))

(defn set-output
  "Sets the destination to the given
   ImageOutputStream or other Object.
   The destination is assumed to be ready to accept data, and will
   not be closed at the end of each write. This allows distributed
   imaging applications to transmit a series of images over a
   single network connection.  If output is
   null, any currently set output will be removed.

    If output is an
   ImageOutputStream, calls to the
   write, writeToSequence, and
   prepareWriteEmpty/endWriteEmpty
   methods will preserve the existing contents of the stream.
   Other write methods, such as writeInsert,
   replaceStreamMetadata,
   replaceImageMetadata, replacePixels,
   prepareInsertEmpty/endInsertEmpty,
   and endWriteSequence, require the full contents
   of the stream to be readable and writable, and may alter any
   portion of the stream.

    Use of a general Object other than an
   ImageOutputStream is intended for writers that
   interact directly with an output device or imaging protocol.
   The set of legal classes is advertised by the writer's service
   provider's getOutputTypes method; most writers
   will return a single-element array containing only
   ImageOutputStream.class to indicate that they
   accept only an ImageOutputStream.

    The default implementation sets the output
   instance variable to the value of output after
   checking output against the set of classes
   advertised by the originating provider, if there is one.

  output - the ImageOutputStream or other Object to use for future writing. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if output is not an instance of one of the classes returned by the originating service provider's getOutputTypes method."
  ([^javax.imageio.ImageWriter this ^java.lang.Object output]
    (-> this (.setOutput output))))

(defn prepare-write-empty
  "Begins the writing of a complete image stream, consisting of a
   single image with undefined pixel values and associated
   metadata and thumbnails, to the output.  The pixel values will
   be defined by future calls to the replacePixels
   methods.  If the output is an ImageOutputStream,
   its existing contents prior to the current seek position are
   not affected, and need not be readable or writable.

    The writing is not complete until a call to
   endWriteEmpty occurs.  Calls to
   prepareReplacePixels, replacePixels,
   and endReplacePixels may occur between calls to
   prepareWriteEmpty and endWriteEmpty.
   However, calls to prepareWriteEmpty cannot be
   nested, and calls to prepareWriteEmpty and
   prepareInsertEmpty may not be interspersed.

    If canWriteEmpty returns false,
   an UnsupportedOperationException will be thrown.

    An ImageWriteParam may optionally be supplied
   to control the writing process.  If param is
   null, a default write param will be used.

    If the supplied ImageWriteParam contains
   optional setting values not supported by this writer (e.g.
   progressive encoding or any format-specific settings), they
   will be ignored.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  stream-metadata - an IIOMetadata object representing stream metadata, or null to use default values. - `javax.imageio.metadata.IIOMetadata`
  image-type - an ImageTypeSpecifier describing the layout of the image. - `javax.imageio.ImageTypeSpecifier`
  width - the width of the image. - `int`
  height - the height of the image. - `int`
  image-metadata - an IIOMetadata object representing image metadata, or null. - `javax.imageio.metadata.IIOMetadata`
  thumbnails - a List of BufferedImage thumbnails for this image, or null. - `java.awt.image.BufferedImage>`
  param - an ImageWriteParam, or null to use a default ImageWriteParam. - `javax.imageio.ImageWriteParam`

  throws: java.lang.IllegalStateException - if a previous call to prepareInsertEmpty has been made without a corresponding call to endInsertEmpty."
  ([^javax.imageio.ImageWriter this ^javax.imageio.metadata.IIOMetadata stream-metadata ^javax.imageio.ImageTypeSpecifier image-type ^Integer width ^Integer height ^javax.imageio.metadata.IIOMetadata image-metadata ^java.awt.image.BufferedImage> thumbnails ^javax.imageio.ImageWriteParam param]
    (-> this (.prepareWriteEmpty stream-metadata image-type width height image-metadata thumbnails param))))

(defn dispose
  "Allows any resources held by this object to be released.  The
   result of calling any other method (other than
   finalize) subsequent to a call to this method
   is undefined.

   It is important for applications to call this method when they
   know they will no longer be using this ImageWriter.
   Otherwise, the writer may continue to hold on to resources
   indefinitely.

   The default implementation of this method in the superclass does
   nothing.  Subclass implementations should ensure that all resources,
   especially native resources, are released."
  ([^javax.imageio.ImageWriter this]
    (-> this (.dispose))))

(defn get-default-stream-metadata
  "Returns an IIOMetadata object containing default
   values for encoding a stream of images.  The contents of the
   object may be manipulated using either the XML tree structure
   returned by the IIOMetadata.getAsTree method, an
   IIOMetadataController object, or via plug-in
   specific interfaces, and the resulting data supplied to one of
   the write methods that take a stream metadata
   parameter.

    An optional ImageWriteParam may be supplied
   for cases where it may affect the structure of the stream
   metadata.

    If the supplied ImageWriteParam contains
   optional setting values not supported by this writer (e.g.
   progressive encoding or any format-specific settings), they
   will be ignored.

    Writers that do not make use of stream metadata
   (e.g., writers for single-image formats) should return
   null.

  param - an ImageWriteParam that will be used to encode the image, or null. - `javax.imageio.ImageWriteParam`

  returns: an IIOMetadata object. - `javax.imageio.metadata.IIOMetadata`"
  ([^javax.imageio.ImageWriter this ^javax.imageio.ImageWriteParam param]
    (-> this (.getDefaultStreamMetadata param))))

(defn end-write-sequence
  "Completes the writing of a sequence of images begun with
   prepareWriteSequence.  Any stream metadata that
   should come at the end of the sequence of images is written out,
   and any header information at the beginning of the sequence is
   patched up if necessary.  If the output is an
   ImageOutputStream, data through the stream metadata
   at the end of the sequence are flushed and need not be readable
   or writable.

    If canWriteSequence returns false,
   this method will throw an
   UnsupportedOperationException.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  throws: java.lang.IllegalStateException - if the output has not been set, or prepareWriteSequence has not been called."
  ([^javax.imageio.ImageWriter this]
    (-> this (.endWriteSequence))))

(defn get-locale
  "Returns the currently set Locale, or
   null if none has been set.

    The default implementation returns the value of the
   locale instance variable.

  returns: the current Locale, or null. - `java.util.Locale`"
  ([^javax.imageio.ImageWriter this]
    (-> this (.getLocale))))

(defn prepare-insert-empty
  "Begins the insertion of a new image with undefined pixel values
   into an existing image stream.  Existing images with an index
   greater than imageIndex are preserved, and their
   indices are each increased by 1.  A value for
   imageIndex of -1 may be used to signify an index
   one larger than the previous largest index; that is, it will
   cause the image to be logically appended to the end of the
   sequence.  If the output is an ImageOutputStream,
   the entirety of the stream must be both readable and writeable.

    The image contents may be
   supplied later using the replacePixels method.
   The insertion is not complete until a call to
   endInsertEmpty occurs.  Calls to
   prepareReplacePixels, replacePixels,
   and endReplacePixels may occur between calls to
   prepareInsertEmpty and
   endInsertEmpty.  However, calls to
   prepareInsertEmpty cannot be nested, and calls to
   prepareWriteEmpty and
   prepareInsertEmpty may not be interspersed.

    If canInsertEmpty(imageIndex) returns
   false, an
   UnsupportedOperationException will be thrown.

    An ImageWriteParam may optionally be supplied
   to control the writing process.  If param is
   null, a default write param will be used.

    If the supplied ImageWriteParam contains
   optional setting values not supported by this writer (e.g.
   progressive encoding or any format-specific settings), they
   will be ignored.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  image-index - the index at which to write the image. - `int`
  image-type - an ImageTypeSpecifier describing the layout of the image. - `javax.imageio.ImageTypeSpecifier`
  width - the width of the image. - `int`
  height - the height of the image. - `int`
  image-metadata - an IIOMetadata object representing image metadata, or null. - `javax.imageio.metadata.IIOMetadata`
  thumbnails - a List of BufferedImage thumbnails for this image, or null. - `java.awt.image.BufferedImage>`
  param - an ImageWriteParam, or null to use a default ImageWriteParam. - `javax.imageio.ImageWriteParam`

  throws: java.lang.IllegalStateException - if a previous call to prepareWriteEmpty has been made without a corresponding call to endWriteEmpty."
  ([^javax.imageio.ImageWriter this ^Integer image-index ^javax.imageio.ImageTypeSpecifier image-type ^Integer width ^Integer height ^javax.imageio.metadata.IIOMetadata image-metadata ^java.awt.image.BufferedImage> thumbnails ^javax.imageio.ImageWriteParam param]
    (-> this (.prepareInsertEmpty image-index image-type width height image-metadata thumbnails param))))

(defn reset
  "Restores the ImageWriter to its initial state.

    The default implementation calls
   setOutput(null), setLocale(null),
   removeAllIIOWriteWarningListeners(),
   removeAllIIOWriteProgressListeners(), and
   clearAbortRequest."
  ([^javax.imageio.ImageWriter this]
    (-> this (.reset))))

(defn add-iio-write-progress-listener
  "Adds an IIOWriteProgressListener to the list of
   registered progress listeners.  If listener is
   null, no exception will be thrown and no action
   will be taken.

  listener - an IIOWriteProgressListener to be registered. - `javax.imageio.event.IIOWriteProgressListener`"
  ([^javax.imageio.ImageWriter this ^javax.imageio.event.IIOWriteProgressListener listener]
    (-> this (.addIIOWriteProgressListener listener))))

(defn can-write-empty?
  "Returns true if the writer supports the writing of
   a complete image stream consisting of a single image with
   undefined pixel values and associated metadata and thumbnails
   to the output.  The pixel values may be defined by future
   calls to the replacePixels methods.  If the output
   is an ImageOutputStream, its existing contents
   prior to the current seek position are not affected, and need
   not be readable or writable.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise returns false.

  returns: true if the writing of complete image
   stream with contents to be defined later is supported. - `boolean`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this]
    (-> this (.canWriteEmpty))))

(defn can-replace-stream-metadata?
  "Returns true if it is possible to replace the
   stream metadata already present in the output.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise returns false.

  returns: true if replacement of stream metadata is
   allowed. - `boolean`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this]
    (-> this (.canReplaceStreamMetadata))))

(defn remove-image
  "Removes an image from the stream.

    If canRemoveImage(imageIndex) returns false,
   an UnsupportedOperationExceptionwill be thrown.

    The removal may or may not cause a reduction in the actual
   file size.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  image-index - the index of the image to be removed. - `int`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this ^Integer image-index]
    (-> this (.removeImage image-index))))

(defn can-replace-pixels?
  "Returns true if the writer allows pixels of the
   given image to be replaced using the replacePixels
   methods.

    A writer that does not support any pixel replacement may
   return false without performing bounds checking on
   the index.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise returns false
   without checking the value of imageIndex.

  image-index - the index of the image whose pixels are to be replaced. - `int`

  returns: true if the pixels of the given
   image can be replaced. - `boolean`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this ^Integer image-index]
    (-> this (.canReplacePixels image-index))))

(defn remove-all-iio-write-progress-listeners
  "Removes all currently registered
   IIOWriteProgressListener objects.

    The default implementation sets the
   progressListeners instance variable to
   null."
  ([^javax.imageio.ImageWriter this]
    (-> this (.removeAllIIOWriteProgressListeners))))

(defn convert-stream-metadata
  "Description copied from interface: ImageTranscoder

  in-data - an IIOMetadata object representing stream metadata, used to initialize the state of the returned object. - `javax.imageio.metadata.IIOMetadata`
  param - an ImageWriteParam that will be used to encode the image, or null. - `javax.imageio.ImageWriteParam`

  returns: an IIOMetadata object, or
   null if the plug-in does not provide metadata
   encoding capabilities. - `javax.imageio.metadata.IIOMetadata`"
  ([^javax.imageio.ImageWriter this ^javax.imageio.metadata.IIOMetadata in-data ^javax.imageio.ImageWriteParam param]
    (-> this (.convertStreamMetadata in-data param))))

(defn get-originating-provider
  "Returns the ImageWriterSpi object that created
   this ImageWriter, or null if this
   object was not created through the IIORegistry.

    The default implementation returns the value of the
   originatingProvider instance variable.

  returns: an ImageWriterSpi, or null. - `javax.imageio.spi.ImageWriterSpi`"
  ([^javax.imageio.ImageWriter this]
    (-> this (.getOriginatingProvider))))

(defn get-default-write-param
  "Returns a new ImageWriteParam object of the
   appropriate type for this file format containing default
   values, that is, those values that would be used
   if no ImageWriteParam object were specified.  This
   is useful as a starting point for tweaking just a few parameters
   and otherwise leaving the default settings alone.

    The default implementation constructs and returns a new
   ImageWriteParam object that does not allow tiling,
   progressive encoding, or compression, and that will be
   localized for the current Locale (i.e.,
   what you would get by calling new
   ImageWriteParam(getLocale()).

    Individual plug-ins may return an instance of
   ImageWriteParam with additional optional features
   enabled, or they may return an instance of a plug-in specific
   subclass of ImageWriteParam.

  returns: a new ImageWriteParam object containing
   default values. - `javax.imageio.ImageWriteParam`"
  ([^javax.imageio.ImageWriter this]
    (-> this (.getDefaultWriteParam))))

(defn end-replace-pixels
  "Terminates a sequence of calls to replacePixels.

    If canReplacePixels returns
   false, and
   UnsupportedOperationException will be thrown.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  throws: java.lang.IllegalStateException - if there is no previous call to prepareReplacePixels without a matching call to endReplacePixels."
  ([^javax.imageio.ImageWriter this]
    (-> this (.endReplacePixels))))

(defn end-insert-empty
  "Completes the insertion of a new image that was begun with a
   prior call to prepareInsertEmpty.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  throws: java.lang.IllegalStateException - if a call to prepareReplacePixels has been made without a matching call to endReplacePixels."
  ([^javax.imageio.ImageWriter this]
    (-> this (.endInsertEmpty))))

(defn can-remove-image?
  "Returns true if the writer supports the removal
   of an existing image at the given index.  Existing images with
   indices greater than the insertion index will have
   their indices decreased by 1.

    A writer that does not support any image removal may
   return false without performing bounds checking on
   the index.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise returns false
   without checking the value of imageIndex.

  image-index - the index of the image to be removed. - `int`

  returns: true if it is possible to remove the given
   image. - `boolean`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this ^Integer image-index]
    (-> this (.canRemoveImage image-index))))

(defn prepare-replace-pixels
  "Prepares the writer to handle a series of calls to the
   replacePixels methods.  The affected pixel area
   will be clipped against the supplied

    If canReplacePixels returns
   false, and
   UnsupportedOperationException will be thrown.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  image-index - the index of the image whose pixels are to be replaced. - `int`
  region - a Rectangle that will be used to clip future pixel regions. - `java.awt.Rectangle`

  throws: java.lang.IllegalStateException - if there is a previous call to prepareReplacePixels without a matching call to endReplacePixels (i.e., nesting is not allowed)."
  ([^javax.imageio.ImageWriter this ^Integer image-index ^java.awt.Rectangle region]
    (-> this (.prepareReplacePixels image-index region))))

(defn can-insert-image?
  "Returns true if the writer supports the insertion
   of a new image at the given index.  Existing images with
   indices greater than or equal to the insertion index will have
   their indices increased by 1.  A value for
   imageIndex of -1 may be used to
   signify an index one larger than the current largest index.

    A writer that does not support any image insertion may
   return false without performing bounds checking on
   the index.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise returns false
   without checking the value of imageIndex.

  image-index - the index at which the image is to be inserted. - `int`

  returns: true if an image may be inserted at the
   given index. - `boolean`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this ^Integer image-index]
    (-> this (.canInsertImage image-index))))

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
  ([^javax.imageio.ImageWriter this]
    (-> this (.getAvailableLocales))))

(defn set-locale
  "Sets the current Locale of this
   ImageWriter to the given value.  A value of
   null removes any previous setting, and indicates
   that the writer should localize as it sees fit.

    The default implementation checks locale
   against the values returned by
   getAvailableLocales, and sets the
   locale instance variable if it is found.  If
   locale is null, the instance variable
   is set to null without any checking.

  locale - the desired Locale, or null. - `java.util.Locale`

  throws: java.lang.IllegalArgumentException - if locale is non-null but is not one of the values returned by getAvailableLocales."
  ([^javax.imageio.ImageWriter this ^java.util.Locale locale]
    (-> this (.setLocale locale))))

(defn get-num-thumbnails-supported
  "Returns the number of thumbnails supported by the format being
   written, given the image type and any additional write
   parameters and metadata objects that will be used during
   encoding.  A return value of -1 indicates that
   insufficient information is available.

    An ImageWriteParam may optionally be supplied
   for cases where it may affect thumbnail handling.

    If the supplied ImageWriteParam contains
   optional setting values not supported by this writer (e.g.
   progressive encoding or any format-specific settings), they
   will be ignored.

    The default implementation returns 0.

  image-type - an ImageTypeSpecifier indicating the type of image to be written, or null. - `javax.imageio.ImageTypeSpecifier`
  param - the ImageWriteParam that will be used for writing, or null. - `javax.imageio.ImageWriteParam`
  stream-metadata - an IIOMetadata object that will be used for writing, or null. - `javax.imageio.metadata.IIOMetadata`
  image-metadata - an IIOMetadata object that will be used for writing, or null. - `javax.imageio.metadata.IIOMetadata`

  returns: the number of thumbnails that may be written given the
   supplied parameters, or -1 if insufficient
   information is available. - `int`"
  ([^javax.imageio.ImageWriter this ^javax.imageio.ImageTypeSpecifier image-type ^javax.imageio.ImageWriteParam param ^javax.imageio.metadata.IIOMetadata stream-metadata ^javax.imageio.metadata.IIOMetadata image-metadata]
    (-> this (.getNumThumbnailsSupported image-type param stream-metadata image-metadata))))

(defn convert-image-metadata
  "Description copied from interface: ImageTranscoder

  in-data - an IIOMetadata object representing image metadata, used to initialize the state of the returned object. - `javax.imageio.metadata.IIOMetadata`
  image-type - an ImageTypeSpecifier indicating the layout and color information of the image with which the metadata will be associated. - `javax.imageio.ImageTypeSpecifier`
  param - an ImageWriteParam that will be used to encode the image, or null. - `javax.imageio.ImageWriteParam`

  returns: an IIOMetadata object,
   or null if the plug-in does not provide
   metadata encoding capabilities. - `javax.imageio.metadata.IIOMetadata`"
  ([^javax.imageio.ImageWriter this ^javax.imageio.metadata.IIOMetadata in-data ^javax.imageio.ImageTypeSpecifier image-type ^javax.imageio.ImageWriteParam param]
    (-> this (.convertImageMetadata in-data image-type param))))

(defn write-insert
  "Inserts a new image into an existing image stream.  Existing
   images with an index greater than imageIndex are
   preserved, and their indices are each increased by 1.  A value
   for imageIndex of -1 may be used to signify an
   index one larger than the previous largest index; that is, it
   will cause the image to be logically appended to the end of the
   sequence.  If the output is an ImageOutputStream,
   the entirety of the stream must be both readable and writeable.

    If canInsertImage(imageIndex) returns
   false, an
   UnsupportedOperationException will be thrown.

    An ImageWriteParam may optionally be supplied
   to control the writing process.  If param is
   null, a default write param will be used.

    If the supplied ImageWriteParam contains
   optional setting values not supported by this writer (e.g.
   progressive encoding or any format-specific settings), they
   will be ignored.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  image-index - the index at which to write the image. - `int`
  image - an IIOImage object containing an image, thumbnails, and metadata to be written. - `javax.imageio.IIOImage`
  param - an ImageWriteParam, or null to use a default ImageWriteParam. - `javax.imageio.ImageWriteParam`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this ^Integer image-index ^javax.imageio.IIOImage image ^javax.imageio.ImageWriteParam param]
    (-> this (.writeInsert image-index image param))))

(defn get-preferred-thumbnail-sizes
  "Returns an array of Dimensions indicating the
   legal size ranges for thumbnail images as they will be encoded
   in the output file or stream.  This information is merely
   advisory; the writer will resize any supplied thumbnails as
   necessary.

    The information is returned as a set of pairs; the first
   element of a pair contains an (inclusive) minimum width and
   height, and the second element contains an (inclusive) maximum
   width and height.  Together, each pair defines a valid range of
   sizes.  To specify a fixed size, the same width and height will
   appear for both elements.  A return value of null
   indicates that the size is arbitrary or unknown.

    An ImageWriteParam may optionally be supplied
   for cases where it may affect thumbnail handling.

    If the supplied ImageWriteParam contains
   optional setting values not supported by this writer (e.g.
   progressive encoding or any format-specific settings), they
   will be ignored.

    The default implementation returns null.

  image-type - an ImageTypeSpecifier indicating the type of image to be written, or null. - `javax.imageio.ImageTypeSpecifier`
  param - the ImageWriteParam that will be used for writing, or null. - `javax.imageio.ImageWriteParam`
  stream-metadata - an IIOMetadata object that will be used for writing, or null. - `javax.imageio.metadata.IIOMetadata`
  image-metadata - an IIOMetadata object that will be used for writing, or null. - `javax.imageio.metadata.IIOMetadata`

  returns: an array of Dimensions with an even length
   of at least two, or null. - `java.awt.Dimension[]`"
  ([^javax.imageio.ImageWriter this ^javax.imageio.ImageTypeSpecifier image-type ^javax.imageio.ImageWriteParam param ^javax.imageio.metadata.IIOMetadata stream-metadata ^javax.imageio.metadata.IIOMetadata image-metadata]
    (-> this (.getPreferredThumbnailSizes image-type param stream-metadata image-metadata))))

(defn end-write-empty
  "Completes the writing of a new image that was begun with a
   prior call to prepareWriteEmpty.

    If canWriteEmpty() returns false,
   an UnsupportedOperationException will be thrown.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  throws: java.lang.IllegalStateException - if a call to prepareReiplacePixels has been made without a matching call to endReplacePixels."
  ([^javax.imageio.ImageWriter this]
    (-> this (.endWriteEmpty))))

(defn replace-image-metadata
  "Replaces the image metadata associated with an existing image.

    If canReplaceImageMetadata(imageIndex) returns
   false, an
   UnsupportedOperationException will be thrown.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  image-index - the index of the image whose metadata is to be replaced. - `int`
  image-metadata - an IIOMetadata object representing image metadata, or null. - `javax.imageio.metadata.IIOMetadata`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this ^Integer image-index ^javax.imageio.metadata.IIOMetadata image-metadata]
    (-> this (.replaceImageMetadata image-index image-metadata))))

(defn can-write-sequence?
  "Returns true if the writer is able to append an
   image to an image stream that already contains header
   information and possibly prior images.

    If canWriteSequence returns false,
   writeToSequence and endWriteSequence
   will throw an UnsupportedOperationException.

    The default implementation returns false.

  returns: true if images may be appended sequentially. - `boolean`"
  ([^javax.imageio.ImageWriter this]
    (-> this (.canWriteSequence))))

(defn abort
  "Requests that any current write operation be aborted.  The
   contents of the output following the abort will be undefined.

    Writers should call clearAbortRequest at the
   beginning of each write operation, and poll the value of
   abortRequested regularly during the write."
  ([^javax.imageio.ImageWriter this]
    (-> this (.abort))))

(defn get-output
  "Returns the ImageOutputStream or other
   Object set by the most recent call to the
   setOutput method.  If no destination has been
   set, null is returned.

    The default implementation returns the value of the
   output instance variable.

  returns: the Object that was specified using
   setOutput, or null. - `java.lang.Object`"
  ([^javax.imageio.ImageWriter this]
    (-> this (.getOutput))))

(defn replace-pixels
  "Replaces a portion of an image already present in the output
   with a portion of the given image.  The image data must match,
   or be convertible to, the image layout of the existing image.

    The destination region is specified in the
   param argument, and will be clipped to the image
   boundaries and the region supplied to
   prepareReplacePixels.  At least one pixel of the
   source must not be clipped, or an exception is thrown.

    An ImageWriteParam may optionally be supplied
   to control the writing process.  If param is
   null, a default write param will be used.

    If the supplied ImageWriteParam contains
   optional setting values not supported by this writer (e.g.
   progressive encoding or any format-specific settings), they
   will be ignored.

    This method may only be called after a call to
   prepareReplacePixels, or else an
   IllegalStateException will be thrown.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  image - a RenderedImage containing source pixels. - `java.awt.image.RenderedImage`
  param - an ImageWriteParam, or null to use a default ImageWriteParam. - `javax.imageio.ImageWriteParam`

  throws: java.lang.IllegalStateException - if there is no previous call to prepareReplacePixels without a matching call to endReplacePixels."
  ([^javax.imageio.ImageWriter this ^java.awt.image.RenderedImage image ^javax.imageio.ImageWriteParam param]
    (-> this (.replacePixels image param))))

(defn write
  "Appends a complete image stream containing a single image and
   associated stream and image metadata and thumbnails to the
   output.  Any necessary header information is included.  If the
   output is an ImageOutputStream, its existing
   contents prior to the current seek position are not affected,
   and need not be readable or writable.

    The output must have been set beforehand using the
   setOutput method.

    Stream metadata may optionally be supplied; if it is
   null, default stream metadata will be used.

    If canWriteRasters returns true,
   the IIOImage may contain a Raster
   source.  Otherwise, it must contain a
   RenderedImage source.

    The supplied thumbnails will be resized if needed, and any
   thumbnails in excess of the supported number will be ignored.
   If the format requires additional thumbnails that are not
   provided, the writer should generate them internally.

     An ImageWriteParam may
   optionally be supplied to control the writing process.  If
   param is null, a default write param
   will be used.

    If the supplied ImageWriteParam contains
   optional setting values not supported by this writer (e.g.
   progressive encoding or any format-specific settings), they
   will be ignored.

  stream-metadata - an IIOMetadata object representing stream metadata, or null to use default values. - `javax.imageio.metadata.IIOMetadata`
  image - an IIOImage object containing an image, thumbnails, and metadata to be written. - `javax.imageio.IIOImage`
  param - an ImageWriteParam, or null to use a default ImageWriteParam. - `javax.imageio.ImageWriteParam`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this ^javax.imageio.metadata.IIOMetadata stream-metadata ^javax.imageio.IIOImage image ^javax.imageio.ImageWriteParam param]
    (-> this (.write stream-metadata image param)))
  ([^javax.imageio.ImageWriter this ^javax.imageio.IIOImage image]
    (-> this (.write image))))

(defn remove-iio-write-warning-listener
  "Removes an IIOWriteWarningListener from the list
   of registered warning listeners.  If the listener was not
   previously registered, or if listener is
   null, no exception will be thrown and no action
   will be taken.

  listener - an IIOWriteWarningListener to be deregistered. - `javax.imageio.event.IIOWriteWarningListener`"
  ([^javax.imageio.ImageWriter this ^javax.imageio.event.IIOWriteWarningListener listener]
    (-> this (.removeIIOWriteWarningListener listener))))

(defn can-replace-image-metadata?
  "Returns true if it is possible to replace the
   image metadata associated with an existing image with index
   imageIndex.  If this method returns
   false, a call to
   replaceImageMetadata(imageIndex) will throw an
   UnsupportedOperationException.

    A writer that does not support any image metadata
   replacement may return false without performing
   bounds checking on the index.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise returns false
   without checking the value of imageIndex.

  image-index - the index of the image whose metadata is to be replaced. - `int`

  returns: true if the image metadata of the given
   image can be replaced. - `boolean`

  throws: java.lang.IllegalStateException - if the output has not been set."
  ([^javax.imageio.ImageWriter this ^Integer image-index]
    (-> this (.canReplaceImageMetadata image-index))))

(defn write-to-sequence
  "Appends a single image and possibly associated metadata and
   thumbnails, to the output.  If the output is an
   ImageOutputStream, the existing contents of the
   output prior to the current seek position may be flushed, and
   need not be readable or writable, unless the plug-in needs to
   be able to patch up the header information when
   endWriteSequence is called (e.g. TIFF).

    If canWriteSequence returns false,
   this method will throw an
   UnsupportedOperationException.

    The output must have been set beforehand using
   the setOutput method.

    prepareWriteSequence must have been called
   beforehand, or an IllegalStateException is thrown.

    If canWriteRasters returns true,
   the IIOImage may contain a Raster
   source.  Otherwise, it must contain a
   RenderedImage source.

    The supplied thumbnails will be resized if needed, and any
   thumbnails in excess of the supported number will be ignored.
   If the format requires additional thumbnails that are not
   provided, the writer will generate them internally.

    An ImageWriteParam may optionally be supplied
   to control the writing process.  If param is
   null, a default write param will be used.

    If the supplied ImageWriteParam contains
   optional setting values not supported by this writer (e.g.
   progressive encoding or any format-specific settings), they
   will be ignored.

    The default implementation throws an
   IllegalStateException if the output is
   null, and otherwise throws an
   UnsupportedOperationException.

  image - an IIOImage object containing an image, thumbnails, and metadata to be written. - `javax.imageio.IIOImage`
  param - an ImageWriteParam, or null to use a default ImageWriteParam. - `javax.imageio.ImageWriteParam`

  throws: java.lang.IllegalStateException - if the output has not been set, or prepareWriteSequence has not been called."
  ([^javax.imageio.ImageWriter this ^javax.imageio.IIOImage image ^javax.imageio.ImageWriteParam param]
    (-> this (.writeToSequence image param))))

