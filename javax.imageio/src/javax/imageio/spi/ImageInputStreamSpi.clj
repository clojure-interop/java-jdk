(ns javax.imageio.spi.ImageInputStreamSpi
  "The service provider interface (SPI) for
  ImageInputStreams.  For more information on service
  provider interfaces, see the class comment for the
  IIORegistry class.

   This interface allows arbitrary objects to be `wrapped` by
  instances of ImageInputStream.  For example,
  a particular ImageInputStreamSpi might allow
  a generic InputStream to be used as an input source;
  another might take input from a URL.

   By treating the creation of ImageInputStreams as a
  pluggable service, it becomes possible to handle future input
  sources without changing the API.  Also, high-performance
  implementations of ImageInputStream (for example,
  native implementations for a particular platform) can be installed
  and used transparently by applications."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.spi ImageInputStreamSpi]))

(defn ->image-input-stream-spi
  "Constructor.

  Constructs an ImageInputStreamSpi with a given set
   of values.

  vendor-name - the vendor name. - `java.lang.String`
  version - a version identifier. - `java.lang.String`
  input-class - a Class object indicating the legal object type for use by the createInputStreamInstance method. - `java.lang.Class<?>`

  throws: java.lang.IllegalArgumentException - if version is null."
  ([^java.lang.String vendor-name ^java.lang.String version ^java.lang.Class input-class]
    (new ImageInputStreamSpi vendor-name version input-class)))

(defn get-input-class
  "Returns a Class object representing the class or
   interface type that must be implemented by an input source in
   order to be `wrapped` in an ImageInputStream via
   the createInputStreamInstance method.

    Typical return values might include
   InputStream.class or URL.class, but
   any class may be used.

  returns: a Class variable. - `java.lang.Class<?>`"
  (^java.lang.Class [^javax.imageio.spi.ImageInputStreamSpi this]
    (-> this (.getInputClass))))

(defn can-use-cache-file?
  "Returns true if the ImageInputStream
   implementation associated with this service provider can
   optionally make use of a cache file for improved performance
   and/or memory footrprint.  If false, the value of
   the useCache argument to
   createInputStreamInstance will be ignored.

    The default implementation returns false.

  returns: true if a cache file can be used by the
   input streams created by this service provider. - `boolean`"
  (^Boolean [^javax.imageio.spi.ImageInputStreamSpi this]
    (-> this (.canUseCacheFile))))

(defn needs-cache-file
  "Returns true if the ImageInputStream
   implementation associated with this service provider requires
   the use of a cache File.  If true,
   the value of the useCache argument to
   createInputStreamInstance will be ignored.

    The default implementation returns false.

  returns: true if a cache file is needed by the
   input streams created by this service provider. - `boolean`"
  (^Boolean [^javax.imageio.spi.ImageInputStreamSpi this]
    (-> this (.needsCacheFile))))

(defn create-input-stream-instance
  "Returns an instance of the ImageInputStream
   implementation associated with this service provider.  If the
   use of a cache file is optional, the useCache
   parameter will be consulted.  Where a cache is required, or
   not applicable, the value of useCache will be ignored.

  input - an object of the class type returned by getInputClass. - `java.lang.Object`
  use-cache - a boolean indicating whether a cache file should be used, in cases where it is optional. - `boolean`
  cache-dir - a File indicating where the cache file should be created, or null to use the system directory. - `java.io.File`

  returns: an ImageInputStream instance. - `javax.imageio.stream.ImageInputStream`

  throws: java.lang.IllegalArgumentException - if a cache file is needed but cacheDir is non-null and is not a directory."
  (^javax.imageio.stream.ImageInputStream [^javax.imageio.spi.ImageInputStreamSpi this ^java.lang.Object input ^Boolean use-cache ^java.io.File cache-dir]
    (-> this (.createInputStreamInstance input use-cache cache-dir)))
  (^javax.imageio.stream.ImageInputStream [^javax.imageio.spi.ImageInputStreamSpi this ^java.lang.Object input]
    (-> this (.createInputStreamInstance input))))

