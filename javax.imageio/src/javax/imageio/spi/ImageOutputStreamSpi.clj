(ns javax.imageio.spi.ImageOutputStreamSpi
  "The service provider interface (SPI) for
  ImageOutputStreams.  For more information on service
  provider interfaces, see the class comment for the
  IIORegistry class.

   This interface allows arbitrary objects to be `wrapped` by
  instances of ImageOutputStream.  For example, a
  particular ImageOutputStreamSpi might allow a generic
  OutputStream to be used as a destination; another
  might output to a File or to a device such as a serial
  port.

   By treating the creation of ImageOutputStreams as
  a pluggable service, it becomes possible to handle future output
  destinations without changing the API.  Also, high-performance
  implementations of ImageOutputStream (for example,
  native implementations for a particular platform) can be installed
  and used transparently by applications."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.spi ImageOutputStreamSpi]))

(defn ->image-output-stream-spi
  "Constructor.

  Constructs an ImageOutputStreamSpi with a given
   set of values.

  vendor-name - the vendor name. - `java.lang.String`
  version - a version identifier. - `java.lang.String`
  output-class - a Class object indicating the legal object type for use by the createOutputStreamInstance method. - `java.lang.Class<?>`

  throws: java.lang.IllegalArgumentException - if version is null."
  ([^java.lang.String vendor-name ^java.lang.String version ^java.lang.Class output-class]
    (new ImageOutputStreamSpi vendor-name version output-class)))

(defn get-output-class
  "Returns a Class object representing the class or
   interface type that must be implemented by an output
   destination in order to be `wrapped` in an
   ImageOutputStream via the
   createOutputStreamInstance method.

    Typical return values might include
   OutputStream.class or File.class, but
   any class may be used.

  returns: a Class variable. - `java.lang.Class<?>`"
  (^java.lang.Class [^javax.imageio.spi.ImageOutputStreamSpi this]
    (-> this (.getOutputClass))))

(defn can-use-cache-file?
  "Returns true if the ImageOutputStream
   implementation associated with this service provider can
   optionally make use of a cache File for improved
   performance and/or memory footrprint.  If false,
   the value of the cacheFile argument to
   createOutputStreamInstance will be ignored.

    The default implementation returns false.

  returns: true if a cache file can be used by the
   output streams created by this service provider. - `boolean`"
  (^Boolean [^javax.imageio.spi.ImageOutputStreamSpi this]
    (-> this (.canUseCacheFile))))

(defn needs-cache-file
  "Returns true if the ImageOutputStream
   implementation associated with this service provider requires
   the use of a cache File.

    The default implementation returns false.

  returns: true if a cache file is needed by the
   output streams created by this service provider. - `boolean`"
  (^Boolean [^javax.imageio.spi.ImageOutputStreamSpi this]
    (-> this (.needsCacheFile))))

(defn create-output-stream-instance
  "Returns an instance of the ImageOutputStream
   implementation associated with this service provider.  If the
   use of a cache file is optional, the useCache
   parameter will be consulted.  Where a cache is required, or
   not applicable, the value of useCache will be ignored.

  output - an object of the class type returned by getOutputClass. - `java.lang.Object`
  use-cache - a boolean indicating whether a cache file should be used, in cases where it is optional. - `boolean`
  cache-dir - a File indicating where the cache file should be created, or null to use the system directory. - `java.io.File`

  returns: an ImageOutputStream instance. - `javax.imageio.stream.ImageOutputStream`

  throws: java.lang.IllegalArgumentException - if a cache file is needed, but cacheDir is non-null and is not a directory."
  (^javax.imageio.stream.ImageOutputStream [^javax.imageio.spi.ImageOutputStreamSpi this ^java.lang.Object output ^Boolean use-cache ^java.io.File cache-dir]
    (-> this (.createOutputStreamInstance output use-cache cache-dir)))
  (^javax.imageio.stream.ImageOutputStream [^javax.imageio.spi.ImageOutputStreamSpi this ^java.lang.Object output]
    (-> this (.createOutputStreamInstance output))))

