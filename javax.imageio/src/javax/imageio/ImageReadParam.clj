(ns javax.imageio.ImageReadParam
  "A class describing how a stream is to be decoded.  Instances of
  this class or its subclasses are used to supply prescriptive
  `how-to` information to instances of ImageReader.

   An image encoded as part of a file or stream may be thought of
  extending out in multiple dimensions: the spatial dimensions of
  width and height, a number of bands, and a number of progressive
  decoding passes.  This class allows a contiguous (hyper)rectangular
  subarea of the image in all of these dimensions to be selected for
  decoding.  Additionally, the spatial dimensions may be subsampled
  discontinuously.  Finally, color and format conversions may be
  specified by controlling the ColorModel and
  SampleModel of the destination image, either by
  providing a BufferedImage or by using an
  ImageTypeSpecifier.

   An ImageReadParam object is used to specify how an
  image, or a set of images, will be converted on input from
  a stream in the context of the Java Image I/O framework.  A plug-in for a
  specific image format will return instances of
  ImageReadParam from the
  getDefaultReadParam method of its
  ImageReader implementation.

   The state maintained by an instance of
  ImageReadParam is independent of any particular image
  being decoded.  When actual decoding takes place, the values set in
  the read param are combined with the actual properties of the image
  being decoded from the stream and the destination
  BufferedImage that will receive the decoded pixel
  data.  For example, the source region set using
  setSourceRegion will first be intersected with the
  actual valid source area.  The result will be translated by the
  value returned by getDestinationOffset, and the
  resulting rectangle intersected with the actual valid destination
  area to yield the destination area that will be written.

   The parameters specified by an ImageReadParam are
  applied to an image as follows.  First, if a rendering size has
  been set by setSourceRenderSize, the entire decoded
  image is rendered at the size given by
  getSourceRenderSize.  Otherwise, the image has its
  natural size given by ImageReader.getWidth and
  ImageReader.getHeight.

   Next, the image is clipped against the source region
  specified by getSourceXOffset, getSourceYOffset,
  getSourceWidth, and getSourceHeight.

   The resulting region is then subsampled according to the
  factors given in IIOParam.setSourceSubsampling.  The first pixel,
  the number of pixels per row, and the number of rows all depend
  on the subsampling settings.
  Call the minimum X and Y coordinates of the resulting rectangle
  (minX, minY), its width w
  and its height h.

   This rectangle is offset by
  (getDestinationOffset().x,
  getDestinationOffset().y) and clipped against the
  destination bounds.  If no destination image has been set, the
  destination is defined to have a width of
  getDestinationOffset().x  w, and a
  height of getDestinationOffset().y  h so
  that all pixels of the source region may be written to the
  destination.

   Pixels that land, after subsampling, within the destination
  image, and that are written in one of the progressive passes
  specified by getSourceMinProgressivePass and
  getSourceNumProgressivePasses are passed along to the
  next step.

   Finally, the source samples of each pixel are mapped into
  destination bands according to the algorithm described in the
  comment for setDestinationBands.

   Plug-in writers may extend the functionality of
  ImageReadParam by providing a subclass that implements
  additional, plug-in specific interfaces.  It is up to the plug-in
  to document what interfaces are available and how they are to be
  used.  Readers will silently ignore any extended features of an
  ImageReadParam subclass of which they are not aware.
  Also, they may ignore any optional features that they normally
  disable when creating their own ImageReadParam
  instances via getDefaultReadParam.

   Note that unless a query method exists for a capability, it must
  be supported by all ImageReader implementations
  (e.g. source render size is optional, but subsampling must be
  supported)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio ImageReadParam]))

(defn ->image-read-param
  "Constructor.

  Constructs an ImageReadParam."
  ([]
    (new ImageReadParam )))

(defn set-destination
  "Supplies a BufferedImage to be used as the
   destination for decoded pixel data.  The currently set image
   will be written to by the read,
   readAll, and readRaster methods, and
   a reference to it will be returned by those methods.

    Pixel data from the aforementioned methods will be written
   starting at the offset specified by
   getDestinationOffset.

    If destination is null, a
   newly-created BufferedImage will be returned by
   those methods.

    At the time of reading, the image is checked to verify that
   its ColorModel and SampleModel
   correspond to one of the ImageTypeSpecifiers
   returned from the ImageReader's
   getImageTypes method.  If it does not, the reader
   will throw an IIOException.

  destination - the BufferedImage to be written to, or null. - `java.awt.image.BufferedImage`"
  ([^javax.imageio.ImageReadParam this ^java.awt.image.BufferedImage destination]
    (-> this (.setDestination destination))))

(defn get-source-min-progressive-pass
  "Returns the index of the first progressive pass that will be
   decoded. If no value has been set, 0 will be returned (which is
   the correct value).

  returns: the index of the first pass that will be decoded. - `int`"
  ([^javax.imageio.ImageReadParam this]
    (-> this (.getSourceMinProgressivePass))))

(defn get-source-max-progressive-pass
  "If getSourceNumProgressivePasses is equal to
   Integer.MAX_VALUE, returns
   Integer.MAX_VALUE.  Otherwise, returns
   getSourceMinProgressivePass()
   getSourceNumProgressivePasses() - 1.

  returns: the index of the last pass to be read, or
   Integer.MAX_VALUE. - `int`"
  ([^javax.imageio.ImageReadParam this]
    (-> this (.getSourceMaxProgressivePass))))

(defn set-destination-type
  "Description copied from class: IIOParam

  destination-type - the ImageTypeSpecifier to be used to determine the destination layout and color type. - `javax.imageio.ImageTypeSpecifier`"
  ([^javax.imageio.ImageReadParam this ^javax.imageio.ImageTypeSpecifier destination-type]
    (-> this (.setDestinationType destination-type))))

(defn get-destination
  "Returns the BufferedImage currently set by the
   setDestination method, or null
   if none is set.

  returns: the BufferedImage to be written to. - `java.awt.image.BufferedImage`"
  ([^javax.imageio.ImageReadParam this]
    (-> this (.getDestination))))

(defn can-set-source-render-size?
  "Returns true if this reader allows the source
   image to be rendered at an arbitrary size as part of the
   decoding process, by means of the
   setSourceRenderSize method.  If this method
   returns false, calls to
   setSourceRenderSize will throw an
   UnsupportedOperationException.

  returns: true if setting source rendering size is
   supported. - `boolean`"
  ([^javax.imageio.ImageReadParam this]
    (-> this (.canSetSourceRenderSize))))

(defn get-source-num-progressive-passes
  "Returns the number of the progressive passes that will be
   decoded. If no value has been set,
   Integer.MAX_VALUE will be returned (which is the
   correct value).

  returns: the number of the passes that will be decoded. - `int`"
  ([^javax.imageio.ImageReadParam this]
    (-> this (.getSourceNumProgressivePasses))))

(defn get-source-render-size
  "Returns the width and height of the source image as it
   will be rendered during decoding, if they have been set via the
   setSourceRenderSize method.  A
   nullvalue indicates that no setting has been made.

  returns: the rendered width and height of the source image
   as a Dimension. - `java.awt.Dimension`"
  ([^javax.imageio.ImageReadParam this]
    (-> this (.getSourceRenderSize))))

(defn set-source-render-size
  "If the image is able to be rendered at an arbitrary size, sets
   the source width and height to the supplied values.  Note that
   the values returned from the getWidth and
   getHeight methods on ImageReader are
   not affected by this method; they will continue to return the
   default size for the image.  Similarly, if the image is also
   tiled the tile width and height are given in terms of the default
   size.

    Typically, the width and height should be chosen such that
   the ratio of width to height closely approximates the aspect
   ratio of the image, as returned from
   ImageReader.getAspectRatio.

    If this plug-in does not allow the rendering size to be
   set, an UnsupportedOperationException will be
   thrown.

    To remove the render size setting, pass in a value of
   null for size.

  size - a Dimension indicating the desired width and height. - `java.awt.Dimension`

  throws: java.lang.IllegalArgumentException - if either the width or the height is negative or 0."
  ([^javax.imageio.ImageReadParam this ^java.awt.Dimension size]
    (-> this (.setSourceRenderSize size))))

(defn get-destination-bands
  "Returns the set of band indices where data will be placed.
   If no value has been set, null is returned to
   indicate that all destination bands will be used.

  returns: the indices of the destination bands to be used,
   or null. - `int[]`"
  ([^javax.imageio.ImageReadParam this]
    (-> this (.getDestinationBands))))

(defn set-destination-bands
  "Sets the indices of the destination bands where data
   will be placed.  Duplicate indices are not allowed.

    A null value indicates that all destination
   bands will be used.

    Choosing a destination band subset will not affect the
   number of bands in the output image of a read if no destination
   image is specified; the created destination image will still
   have the same number of bands as if this method had never been
   called.  If a different number of bands in the destination
   image is desired, an image must be supplied using the
   ImageReadParam.setDestination method.

    At the time of reading or writing, an
   IllegalArgumentException will be thrown by the
   reader or writer if a value larger than the largest destination
   band index has been specified, or if the number of source bands
   and destination bands to be used differ.  The
   ImageReader.checkReadParamBandSettings method may
   be used to automate this test.

  destination-bands - an array of integer band indices to be used. - `int[]`

  throws: java.lang.IllegalArgumentException - if destinationBands contains a negative or duplicate value."
  ([^javax.imageio.ImageReadParam this destination-bands]
    (-> this (.setDestinationBands destination-bands))))

(defn set-source-progressive-passes
  "Sets the range of progressive passes that will be decoded.
   Passes outside of this range will be ignored.

    A progressive pass is a re-encoding of the entire image,
   generally at progressively higher effective resolutions, but
   requiring greater transmission bandwidth.  The most common use
   of progressive encoding is found in the JPEG format, where
   successive passes include more detailed representations of the
   high-frequency image content.

    The actual number of passes to be decoded is determined
   during decoding, based on the number of actual passes available
   in the stream.  Thus if minPass  numPasses - 1 is
   larger than the index of the last available passes, decoding
   will end with that pass.

    A value of numPasses of
   Integer.MAX_VALUE indicates that all passes from
   minPass forward should be read.  Otherwise, the
   index of the last pass (i.e., minPass  numPasses
   - 1) must not exceed Integer.MAX_VALUE.

    There is no unsetSourceProgressivePasses
   method; the same effect may be obtained by calling
   setSourceProgressivePasses(0, Integer.MAX_VALUE).

  min-pass - the index of the first pass to be decoded. - `int`
  num-passes - the maximum number of passes to be decoded. - `int`

  throws: java.lang.IllegalArgumentException - if minPass is negative, numPasses is negative or 0, or numPasses is smaller than Integer.MAX_VALUE but minPass numPasses - 1 is greater than INTEGER.MAX_VALUE."
  ([^javax.imageio.ImageReadParam this ^Integer min-pass ^Integer num-passes]
    (-> this (.setSourceProgressivePasses min-pass num-passes))))

