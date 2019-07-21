(ns javax.imageio.ImageIO
  "A class containing static convenience methods for locating
  ImageReaders and ImageWriters, and
  performing simple encoding and decoding."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio ImageIO]))

(defn *get-writer-file-suffixes
  "Returns an array of Strings listing all of the
   file suffixes associated with the formats understood
   by the current set of registered writers.

  returns: an array of Strings. - `java.lang.String[]`"
  ([]
    (ImageIO/getWriterFileSuffixes )))

(defn *get-reader-file-suffixes
  "Returns an array of Strings listing all of the
   file suffixes associated with the formats understood
   by the current set of registered readers.

  returns: an array of Strings. - `java.lang.String[]`"
  ([]
    (ImageIO/getReaderFileSuffixes )))

(defn *get-writer-mime-types
  "Returns an array of Strings listing all of the
   MIME types understood by the current set of registered
   writers.

  returns: an array of Strings. - `java.lang.String[]`"
  ([]
    (ImageIO/getWriterMIMETypes )))

(defn *get-reader-mime-types
  "Returns an array of Strings listing all of the
   MIME types understood by the current set of registered
   readers.

  returns: an array of Strings. - `java.lang.String[]`"
  ([]
    (ImageIO/getReaderMIMETypes )))

(defn *create-image-input-stream
  "Returns an ImageInputStream that will take its
   input from the given Object.  The set of
   ImageInputStreamSpis registered with the
   IIORegistry class is queried and the first one
   that is able to take input from the supplied object is used to
   create the returned ImageInputStream.  If no
   suitable ImageInputStreamSpi exists,
   null is returned.

    The current cache settings from getUseCacheand
   getCacheDirectory will be used to control caching.

  input - an Object to be used as an input source, such as a File, readable RandomAccessFile, or InputStream. - `java.lang.Object`

  returns: an ImageInputStream, or null. - `javax.imageio.stream.ImageInputStream`

  throws: java.lang.IllegalArgumentException - if input is null."
  (^javax.imageio.stream.ImageInputStream [^java.lang.Object input]
    (ImageIO/createImageInputStream input)))

(defn *scan-for-plugins
  "Scans for plug-ins on the application class path,
   loads their service provider classes, and registers a service
   provider instance for each one found with the
   IIORegistry.

   This method is needed because the application class path can
   theoretically change, or additional plug-ins may become available.
   Rather than re-scanning the classpath on every invocation of the
   API, the class path is scanned automatically only on the first
   invocation. Clients can call this method to prompt a re-scan.
   Thus this method need only be invoked by sophisticated applications
   which dynamically make new plug-ins available at runtime.

    The getResources method of the context
   ClassLoader is used locate JAR files containing
   files named
   META-INF/services/javax.imageio.spi.classname,
   where classname is one of ImageReaderSpi,
   ImageWriterSpi, ImageTranscoderSpi,
   ImageInputStreamSpi, or
   ImageOutputStreamSpi, along the application class
   path.

    The contents of the located files indicate the names of
   actual implementation classes which implement the
   aforementioned service provider interfaces; the default class
   loader is then used to load each of these classes and to
   instantiate an instance of each class, which is then placed
   into the registry for later retrieval.

    The exact set of locations searched depends on the
   implementation of the Java runtime environment."
  ([]
    (ImageIO/scanForPlugins )))

(defn *get-image-writers-by-mime-type
  "Returns an Iterator containing all currently
   registered ImageWriters that claim to be able to
   encode files with the given MIME type.

  mime-type - a String containing a file suffix (e.g., \"image/jpeg\" or \"image/x-bmp\"). - `java.lang.String`

  returns: an Iterator containing ImageWriters. - `java.util.Iterator<javax.imageio.ImageWriter>`

  throws: java.lang.IllegalArgumentException - if MIMEType is null."
  (^java.util.Iterator [^java.lang.String mime-type]
    (ImageIO/getImageWritersByMIMEType mime-type)))

(defn *read
  "Returns a BufferedImage as the result of decoding
   a supplied File with an ImageReader
   chosen automatically from among those currently registered.
   The File is wrapped in an
   ImageInputStream.  If no registered
   ImageReader claims to be able to read the
   resulting stream, null is returned.

    The current cache settings from getUseCacheand
   getCacheDirectory will be used to control caching in the
   ImageInputStream that is created.

    Note that there is no read method that takes a
   filename as a String; use this method instead after
   creating a File from the filename.

    This method does not attempt to locate
   ImageReaders that can read directly from a
   File; that may be accomplished using
   IIORegistry and ImageReaderSpi.

  input - a File to read from. - `java.io.File`

  returns: a BufferedImage containing the decoded
   contents of the input, or null. - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalArgumentException - if input is null."
  (^java.awt.image.BufferedImage [^java.io.File input]
    (ImageIO/read input)))

(defn *get-image-readers-by-mime-type
  "Returns an Iterator containing all currently
   registered ImageReaders that claim to be able to
   decode files with the given MIME type.

  mime-type - a String containing a file suffix (e.g., \"image/jpeg\" or \"image/x-bmp\"). - `java.lang.String`

  returns: an Iterator containing
   ImageReaders. - `java.util.Iterator<javax.imageio.ImageReader>`

  throws: java.lang.IllegalArgumentException - if MIMEType is null."
  (^java.util.Iterator [^java.lang.String mime-type]
    (ImageIO/getImageReadersByMIMEType mime-type)))

(defn *get-image-writers
  "Returns an Iterator containing all currently
   registered ImageWriters that claim to be able to
   encode images of the given layout (specified using an
   ImageTypeSpecifier) in the given format.

  type - an ImageTypeSpecifier indicating the layout of the image to be written. - `javax.imageio.ImageTypeSpecifier`
  format-name - the informal name of the format. - `java.lang.String`

  returns: an Iterator containing ImageWriters. - `java.util.Iterator<javax.imageio.ImageWriter>`

  throws: java.lang.IllegalArgumentException - if any parameter is null."
  (^java.util.Iterator [^javax.imageio.ImageTypeSpecifier type ^java.lang.String format-name]
    (ImageIO/getImageWriters type format-name)))

(defn *set-use-cache
  "Sets a flag indicating whether a disk-based cache file should
   be used when creating ImageInputStreams and
   ImageOutputStreams.

    When reading from a standard InputStream, it
   may be necessary to save previously read information in a cache
   since the underlying stream does not allow data to be re-read.
   Similarly, when writing to a standard
   OutputStream, a cache may be used to allow a
   previously written value to be changed before flushing it to
   the final destination.

    The cache may reside in main memory or on disk.  Setting
   this flag to false disallows the use of disk for
   future streams, which may be advantageous when working with
   small images, as the overhead of creating and destroying files
   is removed.

    On startup, the value is set to true.

  use-cache - a boolean indicating whether a cache file should be used, in cases where it is optional. - `boolean`"
  ([^Boolean use-cache]
    (ImageIO/setUseCache use-cache)))

(defn *get-writer-format-names
  "Returns an array of Strings listing all of the
   informal format names understood by the current set of registered
   writers.

  returns: an array of Strings. - `java.lang.String[]`"
  ([]
    (ImageIO/getWriterFormatNames )))

(defn *get-cache-directory
  "Returns the current value set by
   setCacheDirectory, or null if no
   explicit setting has been made.

  returns: a File indicating the directory where
   cache files will be created, or null to indicate
   the system-dependent default temporary-file directory. - `java.io.File`"
  (^java.io.File []
    (ImageIO/getCacheDirectory )))

(defn *get-image-transcoders
  "Returns an Iterator containing all currently
   registered ImageTranscoders that claim to be
   able to transcode between the metadata of the given
   ImageReader and ImageWriter.

  reader - an ImageReader. - `javax.imageio.ImageReader`
  writer - an ImageWriter. - `javax.imageio.ImageWriter`

  returns: an Iterator containing
   ImageTranscoders. - `java.util.Iterator<javax.imageio.ImageTranscoder>`

  throws: java.lang.IllegalArgumentException - if reader or writer is null."
  (^java.util.Iterator [^javax.imageio.ImageReader reader ^javax.imageio.ImageWriter writer]
    (ImageIO/getImageTranscoders reader writer)))

(defn *get-image-writers-by-suffix
  "Returns an Iterator containing all currently
   registered ImageWriters that claim to be able to
   encode files with the given suffix.

  file-suffix - a String containing a file suffix (e.g., \"jpg\" or \"tiff\"). - `java.lang.String`

  returns: an Iterator containing ImageWriters. - `java.util.Iterator<javax.imageio.ImageWriter>`

  throws: java.lang.IllegalArgumentException - if fileSuffix is null."
  (^java.util.Iterator [^java.lang.String file-suffix]
    (ImageIO/getImageWritersBySuffix file-suffix)))

(defn *get-image-readers-by-suffix
  "Returns an Iterator containing all currently
   registered ImageReaders that claim to be able to
   decode files with the given suffix.

  file-suffix - a String containing a file suffix (e.g., \"jpg\" or \"tiff\"). - `java.lang.String`

  returns: an Iterator containing
   ImageReaders. - `java.util.Iterator<javax.imageio.ImageReader>`

  throws: java.lang.IllegalArgumentException - if fileSuffix is null."
  (^java.util.Iterator [^java.lang.String file-suffix]
    (ImageIO/getImageReadersBySuffix file-suffix)))

(defn *set-cache-directory
  "Sets the directory where cache files are to be created.  A
   value of null indicates that the system-dependent
   default temporary-file directory is to be used.  If
   getUseCache returns false, this value is ignored.

  cache-directory - a File specifying a directory. - `java.io.File`

  throws: java.lang.SecurityException - if the security manager denies access to the directory."
  ([^java.io.File cache-directory]
    (ImageIO/setCacheDirectory cache-directory)))

(defn *get-image-readers-by-format-name
  "Returns an Iterator containing all currently
   registered ImageReaders that claim to be able to
   decode the named format.

  format-name - a String containing the informal name of a format (e.g., \"jpeg\" or \"tiff\". - `java.lang.String`

  returns: an Iterator containing
   ImageReaders. - `java.util.Iterator<javax.imageio.ImageReader>`

  throws: java.lang.IllegalArgumentException - if formatName is null."
  (^java.util.Iterator [^java.lang.String format-name]
    (ImageIO/getImageReadersByFormatName format-name)))

(defn *get-image-reader
  "Returns an ImageReadercorresponding to the given
   ImageWriter, if there is one, or null
   if the plug-in for this ImageWriter does not
   specify a corresponding ImageReader, or if the
   given ImageWriter is not registered.  This method
   is provided principally for symmetry with
   getImageWriter(ImageReader).  Note that this
   method returns the \"preferred\" reader, which is the first in
   the list returned by
   javax.imageio.spi.ImageWriterSpi.getImageReaderSpiNames().

  writer - an instance of a registered ImageWriter. - `javax.imageio.ImageWriter`

  returns: an ImageReader, or null. - `javax.imageio.ImageReader`

  throws: java.lang.IllegalArgumentException - if writer is null."
  (^javax.imageio.ImageReader [^javax.imageio.ImageWriter writer]
    (ImageIO/getImageReader writer)))

(defn *get-image-readers
  "Returns an Iterator containing all currently
   registered ImageReaders that claim to be able to
   decode the supplied Object, typically an
   ImageInputStream.

    The stream position is left at its prior position upon
   exit from this method.

  input - an ImageInputStream or other Object containing encoded image data. - `java.lang.Object`

  returns: an Iterator containing ImageReaders. - `java.util.Iterator<javax.imageio.ImageReader>`

  throws: java.lang.IllegalArgumentException - if input is null."
  (^java.util.Iterator [^java.lang.Object input]
    (ImageIO/getImageReaders input)))

(defn *write
  "Writes an image using the an arbitrary ImageWriter
   that supports the given format to an
   ImageOutputStream.  The image is written to the
   ImageOutputStream starting at the current stream
   pointer, overwriting existing stream data from that point
   forward, if present.

    This method does not close the provided
   ImageOutputStream after the write operation has completed;
   it is the responsibility of the caller to close the stream, if desired.

  im - a RenderedImage to be written. - `java.awt.image.RenderedImage`
  format-name - a String containing the informal name of the format. - `java.lang.String`
  output - an ImageOutputStream to be written to. - `javax.imageio.stream.ImageOutputStream`

  returns: false if no appropriate writer is found. - `boolean`

  throws: java.lang.IllegalArgumentException - if any parameter is null."
  (^Boolean [^java.awt.image.RenderedImage im ^java.lang.String format-name ^javax.imageio.stream.ImageOutputStream output]
    (ImageIO/write im format-name output)))

(defn *get-image-writers-by-format-name
  "Returns an Iterator containing all currently
   registered ImageWriters that claim to be able to
   encode the named format.

  format-name - a String containing the informal name of a format (e.g., \"jpeg\" or \"tiff\". - `java.lang.String`

  returns: an Iterator containing
   ImageWriters. - `java.util.Iterator<javax.imageio.ImageWriter>`

  throws: java.lang.IllegalArgumentException - if formatName is null."
  (^java.util.Iterator [^java.lang.String format-name]
    (ImageIO/getImageWritersByFormatName format-name)))

(defn *get-image-writer
  "Returns an ImageWritercorresponding to the given
   ImageReader, if there is one, or null
   if the plug-in for this ImageReader does not
   specify a corresponding ImageWriter, or if the
   given ImageReader is not registered.  This
   mechanism may be used to obtain an ImageWriter
   that will understand the internal structure of non-pixel
   metadata (as encoded by IIOMetadata objects)
   generated by the ImageReader.  By obtaining this
   data from the ImageReader and passing it on to the
   ImageWriter obtained with this method, a client
   program can read an image, modify it in some way, and write it
   back out preserving all metadata, without having to understand
   anything about the structure of the metadata, or even about
   the image format.  Note that this method returns the
   \"preferred\" writer, which is the first in the list returned by
   javax.imageio.spi.ImageReaderSpi.getImageWriterSpiNames().

  reader - an instance of a registered ImageReader. - `javax.imageio.ImageReader`

  returns: an ImageWriter, or null. - `javax.imageio.ImageWriter`

  throws: java.lang.IllegalArgumentException - if reader is null."
  (^javax.imageio.ImageWriter [^javax.imageio.ImageReader reader]
    (ImageIO/getImageWriter reader)))

(defn *get-use-cache?
  "Returns the current value set by setUseCache, or
   true if no explicit setting has been made.

  returns: true if a disk-based cache may be used for
   ImageInputStreams and
   ImageOutputStreams. - `boolean`"
  (^Boolean []
    (ImageIO/getUseCache )))

(defn *get-reader-format-names
  "Returns an array of Strings listing all of the
   informal format names understood by the current set of registered
   readers.

  returns: an array of Strings. - `java.lang.String[]`"
  ([]
    (ImageIO/getReaderFormatNames )))

(defn *create-image-output-stream
  "Returns an ImageOutputStream that will send its
   output to the given Object.  The set of
   ImageOutputStreamSpis registered with the
   IIORegistry class is queried and the first one
   that is able to send output from the supplied object is used to
   create the returned ImageOutputStream.  If no
   suitable ImageOutputStreamSpi exists,
   null is returned.

    The current cache settings from getUseCacheand
   getCacheDirectory will be used to control caching.

  output - an Object to be used as an output destination, such as a File, writable RandomAccessFile, or OutputStream. - `java.lang.Object`

  returns: an ImageOutputStream, or
   null. - `javax.imageio.stream.ImageOutputStream`

  throws: java.lang.IllegalArgumentException - if output is null."
  (^javax.imageio.stream.ImageOutputStream [^java.lang.Object output]
    (ImageIO/createImageOutputStream output)))

