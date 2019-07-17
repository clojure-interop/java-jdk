(ns javax.imageio.IIOImage
  "A simple container class to aggregate an image, a set of
  thumbnail (preview) images, and an object representing metadata
  associated with the image.

   The image data may take the form of either a
  RenderedImage, or a Raster.  Reader
  methods that return an IIOImage will always return a
  BufferedImage using the RenderedImage
  reference.  Writer methods that accept an IIOImage
  will always accept a RenderedImage, and may optionally
  accept a Raster.

   Exactly one of getRenderedImage and
  getRaster will return a non-null value.
  Subclasses are responsible for ensuring this behavior."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio IIOImage]))

(defn ->iio-image
  "Constructor.

  Constructs an IIOImage containing a
   RenderedImage, and thumbnails and metadata
   associated with it.

    All parameters are stored by reference.

    The thumbnails argument must either be
   null or contain only BufferedImage
   objects.

  image - a RenderedImage. - `java.awt.image.RenderedImage`
  thumbnails - a List of BufferedImages, or null. - `java.awt.image.BufferedImage>`
  metadata - an IIOMetadata object, or null. - `javax.imageio.metadata.IIOMetadata`

  throws: java.lang.IllegalArgumentException - if image is null."
  ([^java.awt.image.RenderedImage image ^java.awt.image.BufferedImage> thumbnails ^javax.imageio.metadata.IIOMetadata metadata]
    (new IIOImage image thumbnails metadata)))

(defn get-thumbnail
  "Returns a thumbnail associated with the main image.

  index - the index of the desired thumbnail image. - `int`

  returns: a thumbnail image, as a BufferedImage. - `java.awt.image.BufferedImage`

  throws: java.lang.IndexOutOfBoundsException - if the supplied index is negative or larger than the largest valid index."
  ([^javax.imageio.IIOImage this ^Integer index]
    (-> this (.getThumbnail index))))

(defn has-raster?
  "Returns true if this IIOImage stores
   a Raster rather than a RenderedImage.

  returns: true if a Raster is
   available. - `boolean`"
  ([^javax.imageio.IIOImage this]
    (-> this (.hasRaster))))

(defn get-thumbnails
  "Returns the current List of thumbnail
   BufferedImages, or null if none is
   set.  A live reference is returned.

  returns: the current List of
   BufferedImage thumbnails, or null. - `java.util.List<? extends java.awt.image.BufferedImage>`"
  ([^javax.imageio.IIOImage this]
    (-> this (.getThumbnails))))

(defn get-rendered-image
  "Returns the currently set RenderedImage, or
   null if only a Raster is available.

  returns: a RenderedImage, or null. - `java.awt.image.RenderedImage`"
  ([^javax.imageio.IIOImage this]
    (-> this (.getRenderedImage))))

(defn get-num-thumbnails
  "Returns the number of thumbnails stored in this
   IIOImage.

  returns: the number of thumbnails, as an int. - `int`"
  ([^javax.imageio.IIOImage this]
    (-> this (.getNumThumbnails))))

(defn set-thumbnails
  "Sets the list of thumbnails to a new List of
   BufferedImages, or to null.  The
   reference to the previous List is discarded.

    The thumbnails argument must either be
   null or contain only BufferedImage
   objects.

  thumbnails - a List of BufferedImage thumbnails, or null. - `java.awt.image.BufferedImage>`"
  ([^javax.imageio.IIOImage this ^java.awt.image.BufferedImage> thumbnails]
    (-> this (.setThumbnails thumbnails))))

(defn set-rendered-image
  "Sets the current RenderedImage.  The value is
   stored by reference.  Any existing Raster is
   discarded.

  image - a RenderedImage. - `java.awt.image.RenderedImage`

  throws: java.lang.IllegalArgumentException - if image is null."
  ([^javax.imageio.IIOImage this ^java.awt.image.RenderedImage image]
    (-> this (.setRenderedImage image))))

(defn get-raster
  "Returns the currently set Raster, or
   null if only a RenderedImage is
   available.

  returns: a Raster, or null. - `java.awt.image.Raster`"
  ([^javax.imageio.IIOImage this]
    (-> this (.getRaster))))

(defn get-metadata
  "Returns a reference to the current IIOMetadata
   object, or null is none is set.

  returns: an IIOMetadata object, or null. - `javax.imageio.metadata.IIOMetadata`"
  ([^javax.imageio.IIOImage this]
    (-> this (.getMetadata))))

(defn set-raster
  "Sets the current Raster.  The value is
   stored by reference.  Any existing RenderedImage is
   discarded.

  raster - a Raster. - `java.awt.image.Raster`

  throws: java.lang.IllegalArgumentException - if raster is null."
  ([^javax.imageio.IIOImage this ^java.awt.image.Raster raster]
    (-> this (.setRaster raster))))

(defn set-metadata
  "Sets the IIOMetadata to a new object, or
   null.

  metadata - an IIOMetadata object, or null. - `javax.imageio.metadata.IIOMetadata`"
  ([^javax.imageio.IIOImage this ^javax.imageio.metadata.IIOMetadata metadata]
    (-> this (.setMetadata metadata))))

