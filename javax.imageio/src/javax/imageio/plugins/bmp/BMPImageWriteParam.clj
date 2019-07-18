(ns javax.imageio.plugins.bmp.BMPImageWriteParam
  "A subclass of ImageWriteParam for encoding images in
  the BMP format.

   This class allows for the specification of various parameters
  while writing a BMP format image file.  By default, the data layout
  is bottom-up, such that the pixels are stored in bottom-up order,
  the first scanline being stored last.

  The particular compression scheme to be used can be specified by using
  the setCompressionType() method with the appropriate type
  string.  The compression scheme specified will be honored if and only if it
  is compatible with the type of image being written. If the specified
  compression scheme is not compatible with the type of image being written
  then the IOException will be thrown by the BMP image writer.
  If the compression type is not set explicitly then getCompressionType()
  will return null. In this case the BMP image writer will select
  a compression type that supports encoding of the given image without loss
  of the color resolution.
  The compression type strings and the image type(s) each supports are
  listed in the following
  table:


  Compression Types
  Type String Description  Image Types
  BI_RGB  Uncompressed RLE <=  8-bits/sample
  BI_RLE8 8-bit Run Length Encoding <= 8-bits/sample
  BI_RLE4 4-bit Run Length Encoding <= 4-bits/sample
  BI_BITFIELDS Packed data  16 or 32 bits/sample"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.plugins.bmp BMPImageWriteParam]))

(defn ->bmp-image-write-param
  "Constructor.

  Constructs a BMPImageWriteParam set to use a given
   Locale and with default values for all parameters.

  locale - a Locale to be used to localize compression type names and quality descriptions, or null. - `java.util.Locale`"
  (^BMPImageWriteParam [^java.util.Locale locale]
    (new BMPImageWriteParam locale))
  (^BMPImageWriteParam []
    (new BMPImageWriteParam )))

(defn set-top-down
  "If set, the data will be written out in a top-down manner, the first
   scanline being written first.

  top-down - whether the data are written in top-down order. - `boolean`"
  ([^BMPImageWriteParam this ^Boolean top-down]
    (-> this (.setTopDown top-down))))

(defn top-down?
  "Returns the value of the topDown parameter.
   The default is false.

  returns: whether the data are written in top-down order. - `boolean`"
  (^Boolean [^BMPImageWriteParam this]
    (-> this (.isTopDown))))

