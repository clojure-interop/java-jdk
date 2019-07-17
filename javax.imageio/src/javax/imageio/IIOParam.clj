(ns javax.imageio.IIOParam
  "A superclass of all classes describing how streams should be
  decoded or encoded.  This class contains all the variables and
  methods that are shared by ImageReadParam and
  ImageWriteParam.

   This class provides mechanisms to specify a source region and a
  destination region.  When reading, the source is the stream and
  the in-memory image is the destination.  When writing, these are
  reversed.  In the case of writing, destination regions may be used
  only with a writer that supports pixel replacement.

  Decimation subsampling may be specified for both readers
  and writers, using a movable subsampling grid.

  Subsets of the source and destination bands may be selected."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio IIOParam]))

(defn has-controller?
  "Returns true if there is a controller installed
   for this IIOParam object.  This will return
   true if getController would not
   return null.

  returns: true if a controller is installed. - `boolean`"
  ([this]
    (-> this (.hasController))))

(defn get-subsampling-x-offset
  "Returns the horizontal offset of the subsampling grid.

   If setSourceSubsampling has not been called, 0
   is returned (which is the correct value).

  returns: the source subsampling grid X offset. - `int`"
  ([this]
    (-> this (.getSubsamplingXOffset))))

(defn get-destination-type
  "Returns the type of image to be returned by the read, if one
   was set by a call to
   setDestination(ImageTypeSpecifier), as an
   ImageTypeSpecifier.  If none was set,
   null is returned.

  returns: an ImageTypeSpecifier describing the
   destination type, or null. - `javax.imageio.ImageTypeSpecifier`"
  ([this]
    (-> this (.getDestinationType))))

(defn activate-controller
  "Activates the installed IIOParamController for
   this IIOParam object and returns the resulting
   value.  When this method returns true, all values
   for this IIOParam object will be ready for the
   next read or write operation.  If false is
   returned, no settings in this object will have been disturbed
   (i.e., the user canceled the operation).

    Ordinarily, the controller will be a GUI providing a user
   interface for a subclass of IIOParam for a
   particular plug-in.  Controllers need not be GUIs, however.

  returns: true if the controller completed normally. - `boolean`

  throws: java.lang.IllegalStateException - if there is no controller currently installed."
  ([this]
    (-> this (.activateController))))

(defn get-destination-offset
  "Returns the offset in the destination image at which pixels are
   to be placed.

    If setDestinationOffsets has not been called,
   a Point with zero X and Y values is returned
   (which is the correct value).

  returns: the destination offset as a Point. - `java.awt.Point`"
  ([this]
    (-> this (.getDestinationOffset))))

(defn get-source-y-subsampling
  "Returns the number of rows to advance for each pixel.

   If setSourceSubsampling has not been called, 1
   is returned (which is the correct value).

  returns: the source subsampling Y period. - `int`"
  ([this]
    (-> this (.getSourceYSubsampling))))

(defn set-source-region
  "Sets the source region of interest.  The region of interest is
   described as a rectangle, with the upper-left corner of the
   source image as pixel (0, 0) and increasing values down and to
   the right.  The actual number of pixels used will depend on
   the subsampling factors set by setSourceSubsampling.
   If subsampling has been set such that this number is zero,
   an IllegalStateException will be thrown.

    The source region of interest specified by this method will
   be clipped as needed to fit within the source bounds, as well
   as the destination offsets, width, and height at the time of
   actual I/O.

    A value of null for sourceRegion
   will remove any region specification, causing the entire image
   to be used.

  source-region - a Rectangle specifying the source region of interest, or null. - `java.awt.Rectangle`

  throws: java.lang.IllegalArgumentException - if sourceRegion is non-null and either sourceRegion.width or sourceRegion.height is negative or 0."
  ([this source-region]
    (-> this (.setSourceRegion source-region))))

(defn set-destination-type
  "Sets the desired image type for the destination image, using an
   ImageTypeSpecifier.

    When reading, if the layout of the destination has been set
   using this method, each call to an ImageReader
   read method will return a new
   BufferedImage using the format specified by the
   supplied type specifier.  As a side effect, any destination
   BufferedImage set by
   ImageReadParam.setDestination(BufferedImage) will
   no longer be set as the destination.  In other words, this
   method may be thought of as calling
   setDestination((BufferedImage)null).

    When writing, the destination type maybe used to determine
   the color type of the image.  The SampleModel
   information will be ignored, and may be null.  For
   example, a 4-banded image could represent either CMYK or RGBA
   data.  If a destination type is set, its
   ColorModel will override any
   ColorModel on the image itself.  This is crucial
   when setSourceBands is used since the image's
   ColorModel will refer to the entire image rather
   than to the subset of bands being written.

  destination-type - the ImageTypeSpecifier to be used to determine the destination layout and color type. - `javax.imageio.ImageTypeSpecifier`"
  ([this destination-type]
    (-> this (.setDestinationType destination-type))))

(defn set-source-subsampling
  "Specifies a decimation subsampling to apply on I/O.  The
   sourceXSubsampling and
   sourceYSubsampling parameters specify the
   subsampling period (i.e., the number of rows and columns
   to advance after every source pixel).  Specifically, a period of
   1 will use every row or column; a period of 2 will use every
   other row or column.  The subsamplingXOffset and
   subsamplingYOffset parameters specify an offset
   from the region (or image) origin for the first subsampled pixel.
   Adjusting the origin of the subsample grid is useful for avoiding
   seams when subsampling a very large source image into destination
   regions that will be assembled into a complete subsampled image.
   Most users will want to simply leave these parameters at 0.

    The number of pixels and scanlines to be used are calculated
   as follows.

   The number of subsampled pixels in a scanline is given by

   truncate[(width - subsamplingXOffset  sourceXSubsampling - 1)
   / sourceXSubsampling].

   If the region is such that this width is zero, an
   IllegalStateException is thrown.

   The number of scanlines to be used can be computed similarly.

   The ability to set the subsampling grid to start somewhere
   other than the source region origin is useful if the
   region is being used to create subsampled tiles of a large image,
   where the tile width and height are not multiples of the
   subsampling periods.  If the subsampling grid does not remain
   consistent from tile to tile, there will be artifacts at the tile
   boundaries.  By adjusting the subsampling grid offset for each
   tile to compensate, these artifacts can be avoided.  The tradeoff
   is that in order to avoid these artifacts, the tiles are not all
   the same size.  The grid offset to use in this case is given by:

   grid offset = [period - (region offset modulo period)] modulo period)

    If either sourceXSubsampling or
   sourceYSubsampling is 0 or negative, an
   IllegalArgumentException will be thrown.

    If either subsamplingXOffset or
   subsamplingYOffset is negative or greater than or
   equal to the corresponding period, an
   IllegalArgumentException will be thrown.

    There is no unsetSourceSubsampling method;
   simply call setSourceSubsampling(1, 1, 0, 0) to
   restore default values.

  source-x-subsampling - the number of columns to advance between pixels. - `int`
  source-y-subsampling - the number of rows to advance between pixels. - `int`
  subsampling-x-offset - the horizontal offset of the first subsample within the region, or within the image if no region is set. - `int`
  subsampling-y-offset - the horizontal offset of the first subsample within the region, or within the image if no region is set. - `int`

  throws: java.lang.IllegalArgumentException - if either period is negative or 0, or if either grid offset is negative or greater than the corresponding period."
  ([this source-x-subsampling source-y-subsampling subsampling-x-offset subsampling-y-offset]
    (-> this (.setSourceSubsampling source-x-subsampling source-y-subsampling subsampling-x-offset subsampling-y-offset))))

(defn set-source-bands
  "Sets the indices of the source bands to be used.  Duplicate
   indices are not allowed.

    A null value indicates that all source bands
   will be used.

    At the time of reading, an
   IllegalArgumentException will be thrown by the
   reader or writer if a value larger than the largest available
   source band index has been specified or if the number of source
   bands and destination bands to be used differ.  The
   ImageReader.checkReadParamBandSettings method may
   be used to automate this test.

    Semantically, a copy is made of the array; changes to the
   array contents subsequent to this call have no effect on
   this IIOParam.

  source-bands - an array of integer band indices to be used. - `int[]`

  throws: java.lang.IllegalArgumentException - if sourceBands contains a negative or duplicate value."
  ([this source-bands]
    (-> this (.setSourceBands source-bands))))

(defn get-source-x-subsampling
  "Returns the number of source columns to advance for each pixel.

   If setSourceSubsampling has not been called, 1
   is returned (which is the correct value).

  returns: the source subsampling X period. - `int`"
  ([this]
    (-> this (.getSourceXSubsampling))))

(defn set-controller
  "Sets the IIOParamController to be used
   to provide settings for this IIOParam
   object when the activateController method
   is called, overriding any default controller.  If the
   argument is null, no controller will be
   used, including any default.  To restore the default, use
   setController(getDefaultController()).

  controller - An appropriate IIOParamController, or null. - `javax.imageio.IIOParamController`"
  ([this controller]
    (-> this (.setController controller))))

(defn get-source-region
  "Returns the source region to be used.  The returned value is
   that set by the most recent call to
   setSourceRegion, and will be null if
   there is no region set.

  returns: the source region of interest as a
   Rectangle, or null. - `java.awt.Rectangle`"
  ([this]
    (-> this (.getSourceRegion))))

(defn get-subsampling-y-offset
  "Returns the vertical offset of the subsampling grid.

   If setSourceSubsampling has not been called, 0
   is returned (which is the correct value).

  returns: the source subsampling grid Y offset. - `int`"
  ([this]
    (-> this (.getSubsamplingYOffset))))

(defn get-default-controller
  "Returns the default IIOParamController, if there
   is one, regardless of the currently installed controller.  If
   there is no default controller, returns null.

  returns: the default IIOParamController, or
   null. - `javax.imageio.IIOParamController`"
  ([this]
    (-> this (.getDefaultController))))

(defn set-destination-offset
  "Specifies the offset in the destination image at which future
   decoded pixels are to be placed, when reading, or where a
   region will be written, when writing.

    When reading, the region to be written within the
   destination BufferedImage will start at this
   offset and have a width and height determined by the source
   region of interest, the subsampling parameters, and the
   destination bounds.

    Normal writes are not affected by this method, only writes
   performed using ImageWriter.replacePixels.  For
   such writes, the offset specified is within the output stream
   image whose pixels are being modified.

    There is no unsetDestinationOffset method;
   simply call setDestinationOffset(new Point(0, 0)) to
   restore default values.

  destination-offset - the offset in the destination, as a Point. - `java.awt.Point`

  throws: java.lang.IllegalArgumentException - if destinationOffset is null."
  ([this destination-offset]
    (-> this (.setDestinationOffset destination-offset))))

(defn get-source-bands
  "Returns the set of of source bands to be used. The returned
   value is that set by the most recent call to
   setSourceBands, or null if there have
   been no calls to setSourceBands.

    Semantically, the array returned is a copy; changes to
   array contents subsequent to this call have no effect on this
   IIOParam.

  returns: the set of source bands to be used, or
   null. - `int[]`"
  ([this]
    (-> this (.getSourceBands))))

(defn get-controller
  "Returns whatever IIOParamController is currently
   installed.  This could be the default if there is one,
   null, or the argument of the most recent call
   to setController.

  returns: the currently installed
   IIOParamController, or null. - `javax.imageio.IIOParamController`"
  ([this]
    (-> this (.getController))))

