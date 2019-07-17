(ns javax.imageio.event.IIOReadUpdateListener
  "An interface used by ImageReader implementations to
  notify callers of their image and thumbnail reading methods of
  pixel updates."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.event IIOReadUpdateListener]))

(defn pass-started
  "Reports that the current read operation is about to begin a
   progressive pass.  Readers of formats that support progressive
   encoding should use this to notify clients when each pass is
   completed when reading a progressively encoded image.

    An estimate of the area that will be updated by the pass is
   indicated by the minX, minY,
   width, and height parameters.  If the
   pass is interlaced, that is, it only updates selected rows or
   columns, the periodX and periodY
   parameters will indicate the degree of subsampling.  The set of
   bands that may be affected is indicated by the value of
   bands.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  the-image - the BufferedImage being updated. - `java.awt.image.BufferedImage`
  pass - the number of the pass that is about to begin, starting with 0. - `int`
  min-pass - the index of the first pass that will be decoded. - `int`
  max-pass - the index of the last pass that will be decoded. - `int`
  min-x - the X coordinate of the leftmost updated column of pixels. - `int`
  min-y - the Y coordinate of the uppermost updated row of pixels. - `int`
  period-x - the horizontal spacing between updated pixels; a value of 1 means no gaps. - `int`
  period-y - the vertical spacing between updated pixels; a value of 1 means no gaps. - `int`
  bands - an array of ints indicating the the set bands that may be updated. - `int[]`"
  ([this source the-image pass min-pass max-pass min-x min-y period-x period-y bands]
    (-> this (.passStarted source the-image pass min-pass max-pass min-x min-y period-x period-y bands))))

(defn image-update
  "Reports that a given region of the image has been updated.
   The application might choose to redisplay the specified area,
   for example, in order to provide a progressive display effect,
   or perform other incremental processing.

    Note that different image format readers may produce
   decoded pixels in a variety of different orders.  Many readers
   will produce pixels in a simple top-to-bottom,
   left-to-right-order, but others may use multiple passes of
   interlacing, tiling, etc.  The sequence of updates may even
   differ from call to call depending on network speeds, for
   example.  A call to this method does not guarantee that all the
   specified pixels have actually been updated, only that some
   activity has taken place within some subregion of the one
   specified.

    The particular ImageReader implementation may
   choose how often to provide updates.  Each update specifies
   that a given region of the image has been updated since the
   last update.  A region is described by its spatial bounding box
   (minX, minY, width, and
   height); X and Y subsampling factors
   (periodX and periodY); and a set of
   updated bands (bands).  For example, the update:



   minX = 10
   minY = 20
   width = 3
   height = 4
   periodX = 2
   periodY = 3
   bands = { 1, 3 }

   would indicate that bands 1 and 3 of the following pixels were
   updated:



   (10, 20) (12, 20) (14, 20)
   (10, 23) (12, 23) (14, 23)
   (10, 26) (12, 26) (14, 26)
   (10, 29) (12, 29) (14, 29)

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  the-image - the BufferedImage being updated. - `java.awt.image.BufferedImage`
  min-x - the X coordinate of the leftmost updated column of pixels. - `int`
  min-y - the Y coordinate of the uppermost updated row of pixels. - `int`
  width - the number of updated pixels horizontally. - `int`
  height - the number of updated pixels vertically. - `int`
  period-x - the horizontal spacing between updated pixels; a value of 1 means no gaps. - `int`
  period-y - the vertical spacing between updated pixels; a value of 1 means no gaps. - `int`
  bands - an array of ints indicating which bands are being updated. - `int[]`"
  ([this source the-image min-x min-y width height period-x period-y bands]
    (-> this (.imageUpdate source the-image min-x min-y width height period-x period-y bands))))

(defn pass-complete
  "Reports that the current read operation has completed a
   progressive pass.  Readers of formats that support
   progressive encoding should use this to notify clients when
   each pass is completed when reading a progressively
   encoded image.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  the-image - the BufferedImage being updated. - `java.awt.image.BufferedImage`"
  ([this source the-image]
    (-> this (.passComplete source the-image))))

(defn thumbnail-pass-started
  "Reports that the current thumbnail read operation is about to
   begin a progressive pass.  Readers of formats that support
   progressive encoding should use this to notify clients when
   each pass is completed when reading a progressively encoded
   thumbnail image.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  the-thumbnail - the BufferedImage thumbnail being updated. - `java.awt.image.BufferedImage`
  pass - the number of the pass that is about to begin, starting with 0. - `int`
  min-pass - the index of the first pass that will be decoded. - `int`
  max-pass - the index of the last pass that will be decoded. - `int`
  min-x - the X coordinate of the leftmost updated column of pixels. - `int`
  min-y - the Y coordinate of the uppermost updated row of pixels. - `int`
  period-x - the horizontal spacing between updated pixels; a value of 1 means no gaps. - `int`
  period-y - the vertical spacing between updated pixels; a value of 1 means no gaps. - `int`
  bands - an array of ints indicating the the set bands that may be updated. - `int[]`"
  ([this source the-thumbnail pass min-pass max-pass min-x min-y period-x period-y bands]
    (-> this (.thumbnailPassStarted source the-thumbnail pass min-pass max-pass min-x min-y period-x period-y bands))))

(defn thumbnail-update
  "Reports that a given region of a thumbnail image has been updated.
   The application might choose to redisplay the specified area,
   for example, in order to provide a progressive display effect,
   or perform other incremental processing.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  the-thumbnail - the BufferedImage thumbnail being updated. - `java.awt.image.BufferedImage`
  min-x - the X coordinate of the leftmost updated column of pixels. - `int`
  min-y - the Y coordinate of the uppermost updated row of pixels. - `int`
  width - the number of updated pixels horizontally. - `int`
  height - the number of updated pixels vertically. - `int`
  period-x - the horizontal spacing between updated pixels; a value of 1 means no gaps. - `int`
  period-y - the vertical spacing between updated pixels; a value of 1 means no gaps. - `int`
  bands - an array of ints indicating which bands are being updated. - `int[]`"
  ([this source the-thumbnail min-x min-y width height period-x period-y bands]
    (-> this (.thumbnailUpdate source the-thumbnail min-x min-y width height period-x period-y bands))))

(defn thumbnail-pass-complete
  "Reports that the current thumbnail read operation has completed
   a progressive pass.  Readers of formats that support
   progressive encoding should use this to notify clients when
   each pass is completed when reading a progressively encoded
   thumbnail image.

  source - the ImageReader object calling this method. - `javax.imageio.ImageReader`
  the-thumbnail - the BufferedImage thumbnail being updated. - `java.awt.image.BufferedImage`"
  ([this source the-thumbnail]
    (-> this (.thumbnailPassComplete source the-thumbnail))))

