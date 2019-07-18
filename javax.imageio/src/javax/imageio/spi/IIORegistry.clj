(ns javax.imageio.spi.IIORegistry
  "A registry for service provider instances.  Service provider
  classes may be detected at run time by means of meta-information in
  the JAR files containing them.  The intent is that it be relatively
  inexpensive to load and inspect all available service provider
  classes.  These classes may them be used to locate and instantiate
  more heavyweight classes that will perform actual work, in this
  case instances of ImageReader,
  ImageWriter, ImageTranscoder,
  ImageInputStream, and ImageOutputStream.

   Service providers found on the system classpath (typically
  the lib/ext directory in the Java
  installation directory) are automatically loaded as soon as this class is
  instantiated.

   When the registerApplicationClasspathSpis method
  is called, service provider instances declared in the
  meta-information section of JAR files on the application class path
  are loaded.  To declare a service provider, a services
  subdirectory is placed within the META-INF directory
  that is present in every JAR file.  This directory contains a file
  for each service provider interface that has one or more
  implementation classes present in the JAR file.  For example, if
  the JAR file contained a class named
  com.mycompany.imageio.MyFormatReaderSpi which
  implements the ImageReaderSpi interface, the JAR file
  would contain a file named:



  META-INF/services/javax.imageio.spi.ImageReaderSpi

  containing the line:



  com.mycompany.imageio.MyFormatReaderSpi

   The service provider classes are intended to be lightweight
  and quick to load.  Implementations of these interfaces
  should avoid complex dependencies on other classes and on
  native code.

   It is also possible to manually add service providers not found
  automatically, as well as to remove those that are using the
  interfaces of the ServiceRegistry class.  Thus
  the application may customize the contents of the registry as it
  sees fit.

   For more details on declaring service providers, and the JAR
  format in general, see the
  JAR File Specification."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.spi IIORegistry]))

(defn *get-default-instance
  "Returns the default IIORegistry instance used by
   the Image I/O API.  This instance should be used for all
   registry functions.

    Each ThreadGroup will receive its own
   instance; this allows different Applets in the
   same browser (for example) to each have their own registry.

  returns: the default registry for the current
   ThreadGroup. - `javax.imageio.spi.IIORegistry`"
  (^javax.imageio.spi.IIORegistry []
    (IIORegistry/getDefaultInstance )))

(defn register-application-classpath-spis
  "Registers all available service providers found on the
   application class path, using the default
   ClassLoader.  This method is typically invoked by
   the ImageIO.scanForPlugins method."
  ([^IIORegistry this]
    (-> this (.registerApplicationClasspathSpis))))

