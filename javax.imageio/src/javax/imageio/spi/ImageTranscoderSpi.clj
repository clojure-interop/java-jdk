(ns javax.imageio.spi.ImageTranscoderSpi
  "The service provider interface (SPI) for ImageTranscoders.
  For more information on service provider classes, see the class comment
  for the IIORegistry class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.spi ImageTranscoderSpi]))

(defn ->image-transcoder-spi
  "Constructor.

  Constructs an ImageTranscoderSpi with a given set
   of values.

  vendor-name - the vendor name. - `java.lang.String`
  version - a version identifier. - `java.lang.String`"
  ([^java.lang.String vendor-name ^java.lang.String version]
    (new ImageTranscoderSpi vendor-name version)))

(defn get-reader-service-provider-name
  "Returns the fully qualified class name of an
   ImageReaderSpi class that generates
   IIOMetadata objects that may be used as input to
   this transcoder.

  returns: a String containing the fully-qualified
   class name of the ImageReaderSpi implementation class. - `java.lang.String`"
  (^java.lang.String [^javax.imageio.spi.ImageTranscoderSpi this]
    (-> this (.getReaderServiceProviderName))))

(defn get-writer-service-provider-name
  "Returns the fully qualified class name of an
   ImageWriterSpi class that generates
   IIOMetadata objects that may be used as input to
   this transcoder.

  returns: a String containing the fully-qualified
   class name of the ImageWriterSpi implementation class. - `java.lang.String`"
  (^java.lang.String [^javax.imageio.spi.ImageTranscoderSpi this]
    (-> this (.getWriterServiceProviderName))))

(defn create-transcoder-instance
  "Returns an instance of the ImageTranscoder
   implementation associated with this service provider.

  returns: an ImageTranscoder instance. - `javax.imageio.ImageTranscoder`"
  (^javax.imageio.ImageTranscoder [^javax.imageio.spi.ImageTranscoderSpi this]
    (-> this (.createTranscoderInstance))))

