(ns javax.management.loading.MLet
  "Allows you to instantiate and register one or several MBeans in the MBean server
  coming from a remote URL. M-let is a shortcut for management applet. The m-let service does this
  by loading an m-let text file, which specifies information on the MBeans to be obtained.
  The information on each MBean is specified in a single instance of a tag, called the MLET tag.
  The location of the m-let text file is specified by a URL.

  The MLET tag has the following syntax:

  <MLET
       CODE = class | OBJECT = serfile
       ARCHIVE = \"archiveList\"
       [CODEBASE = codebaseURL]
       [NAME = mbeanname]
       [VERSION = version]
  >
       [arglist]
  </MLET>

  where:

  CODE = class

  This attribute specifies the full Java class name, including package name, of the MBean to be obtained.
  The compiled .class file of the MBean must be contained in one of the .jar files specified by the ARCHIVE
  attribute. Either CODE or OBJECT must be present.

  OBJECT = serfile

  This attribute specifies the .ser file that contains a serialized representation of the MBean to be obtained.
  This file must be contained in one of the .jar files specified by the ARCHIVE attribute. If the .jar file contains a directory hierarchy, specify the path of the file within this hierarchy. Otherwise  a match will not be found. Either CODE or OBJECT must be present.

  ARCHIVE = \"archiveList\"

  This mandatory attribute specifies one or more .jar files
  containing MBeans or other resources used by
  the MBean to be obtained. One of the .jar files must contain the file specified by the CODE or OBJECT attribute.
  If archivelist contains more than one file:

  Each file must be separated from the one that follows it by a comma (,).
  archivelist must be enclosed in double quote marks.

  All .jar files in archivelist must be stored in the directory specified by the code base URL.

  CODEBASE = codebaseURL

  This optional attribute specifies the code base URL of the MBean to be obtained. It identifies the directory that contains
  the .jar files specified by the ARCHIVE attribute. Specify this attribute only if the .jar files are not in the same
  directory as the m-let text file. If this attribute is not specified, the base URL of the m-let text file is used.

  NAME = mbeanname

  This optional attribute specifies the object name to be assigned to the
  MBean instance when the m-let service registers it. If
  mbeanname starts with the colon character (:), the domain
  part of the object name is the default domain of the MBean server,
  as returned by MBeanServer.getDefaultDomain().

  VERSION = version

  This optional attribute specifies the version number of the MBean and
  associated .jar files to be obtained. This version number can
  be used to specify that the .jar files are loaded from the
  server to update those stored locally in the cache the next time the m-let
  text file is loaded. version must be a series of non-negative
  decimal integers each separated by a period from the one that precedes it.

  arglist

  This optional attribute specifies a list of one or more parameters for the
  MBean to be instantiated. This list describes the parameters to be passed the MBean's constructor.
  Use the following syntax to specify each item in
  arglist:

  <ARG TYPE=argumentType VALUE=value>
  where:

  argumentType is the type of the argument that will be passed as parameter to the MBean's constructor.


  The arguments' type in the argument list should be a Java primitive type or a Java basic type
  (java.lang.Boolean, java.lang.Byte, java.lang.Short, java.lang.Long, java.lang.Integer, java.lang.Float, java.lang.Double, java.lang.String).



  When an m-let text file is loaded, an
  instance of each MBean specified in the file is created and registered.

  The m-let service extends the java.net.URLClassLoader and can be used to load remote classes
  and jar files in the VM of the agent.
  Note -  The MLet class loader uses the MBeanServerFactory.getClassLoaderRepository(javax.management.MBeanServer)
  to load classes that could not be found in the loaded jar files."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.loading MLet]))

(defn ->m-let
  "Constructor.

  Constructs a new MLet for the specified URLs, parent class
   loader, and URLStreamHandlerFactory. The parent argument will
   be used as the parent class loader for delegation. The factory
   argument will be used as the stream handler factory to obtain
   protocol handlers when creating new URLs.

  urls - The URLs from which to load classes and resources. - `java.net.URL[]`
  parent - The parent class loader for delegation. - `java.lang.ClassLoader`
  factory - The URLStreamHandlerFactory to use when creating URLs. - `java.net.URLStreamHandlerFactory`
  delegate-to-clr - True if, when a class is not found in either the parent ClassLoader or the URLs, the MLet should delegate to its containing MBeanServer's ClassLoaderRepository. - `boolean`"
  (^MLet [urls ^java.lang.ClassLoader parent ^java.net.URLStreamHandlerFactory factory ^Boolean delegate-to-clr]
    (new MLet urls parent factory delegate-to-clr))
  (^MLet [urls ^java.lang.ClassLoader parent ^java.net.URLStreamHandlerFactory factory]
    (new MLet urls parent factory))
  (^MLet [urls ^java.lang.ClassLoader parent]
    (new MLet urls parent))
  (^MLet [urls]
    (new MLet urls))
  (^MLet []
    (new MLet )))

(defn add-url
  "Appends the specified URL to the list of URLs to search for classes and
   resources.

  url - the URL to be added to the search path of URLs - `java.net.URL`"
  ([^MLet this ^java.net.URL url]
    (-> this (.addURL url))))

(defn write-external
  "Save this MLet's contents to the given ObjectOutput.
   Not all implementations support this method.  Those that do not
   throw UnsupportedOperationException.  A subclass may
   override this method to support it or to change the format of
   the written data.

   The format of the written data is not specified, but if
   an implementation supports writeExternal(java.io.ObjectOutput) it must
   also support readExternal(java.io.ObjectInput) in such a way that what is
   written by the former can be read by the latter.

  out - The object output stream to write to. - `java.io.ObjectOutput`

  throws: java.io.IOException - If a problem occurred while writing."
  ([^MLet this ^java.io.ObjectOutput out]
    (-> this (.writeExternal out))))

(defn post-deregister
  "Allows the m-let to perform any operations needed after having been
   unregistered in the MBean server."
  ([^MLet this]
    (-> this (.postDeregister))))

(defn pre-deregister
  "Allows the m-let to perform any operations it needs before being unregistered
   by the MBean server.

  throws: java.lang.Exception - This exception should be caught by the MBean server and re-thrown as an MBeanRegistrationException."
  ([^MLet this]
    (-> this (.preDeregister))))

(defn get-ur-ls
  "Returns the search path of URLs for loading classes and resources.
   This includes the original list of URLs specified to the constructor,
   along with any URLs subsequently appended by the addURL() method.

  returns: the search path of URLs for loading classes and resources. - `java.net.URL[]`"
  ([^MLet this]
    (-> this (.getURLs))))

(defn get-m-beans-from-url
  "Loads a text file containing MLET tags that define the MBeans to
   be added to the MBean server. The location of the text file is specified by
   a URL. The MBeans specified in the MLET file will be instantiated and
   registered in the MBean server.

  url - The URL of the text file to be loaded as URL object. - `java.net.URL`

  returns: A set containing one entry per MLET tag in the m-let text file loaded.
   Each entry specifies either the ObjectInstance for the created MBean, or a throwable object
   (that is, an error or an exception) if the MBean could not be created. - `java.util.Set<java.lang.Object>`

  throws: javax.management.ServiceNotFoundException - One of the following errors has occurred: The m-let text file does not contain an MLET tag, the m-let text file is not found, a mandatory attribute of the MLET tag is not specified, the value of url is null."
  (^java.util.Set [^MLet this ^java.net.URL url]
    (-> this (.getMBeansFromURL url))))

(defn get-library-directory
  "Gets the current directory used by the library loader for
   storing native libraries before they are loaded into memory.

  returns: The current directory used by the library loader. - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if this implementation does not support storing native libraries in this way."
  (^java.lang.String [^MLet this]
    (-> this (.getLibraryDirectory))))

(defn load-class
  "Load a class, using the given ClassLoaderRepository if
   the class is not found in this MLet's URLs.  The given
   ClassLoaderRepository can be null, in which case a ClassNotFoundException occurs immediately if the class is not
   found in this MLet's URLs.

  name - The name of the class we want to load. - `java.lang.String`
  clr - The ClassLoaderRepository that will be used to search for the given class, if it is not found in this ClassLoader. May be null. - `javax.management.loading.ClassLoaderRepository`

  returns: The resulting Class object. - `java.lang.Class<?>`

  throws: java.lang.ClassNotFoundException - The specified class could not be found in this ClassLoader nor in the given ClassLoaderRepository."
  (^java.lang.Class [^MLet this ^java.lang.String name ^javax.management.loading.ClassLoaderRepository clr]
    (-> this (.loadClass name clr))))

(defn post-register
  "Allows the m-let to perform any operations needed after having been
   registered in the MBean server or after the registration has failed.

  registration-done - Indicates whether or not the m-let has been successfully registered in the MBean server. The value false means that either the registration phase has failed. - `java.lang.Boolean`"
  ([^MLet this ^java.lang.Boolean registration-done]
    (-> this (.postRegister registration-done))))

(defn set-library-directory
  "Sets the directory used by the library loader for storing
   native libraries before they are loaded into memory.

  libdir - The directory used by the library loader. - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if this implementation does not support storing native libraries in this way."
  ([^MLet this ^java.lang.String libdir]
    (-> this (.setLibraryDirectory libdir))))

(defn read-external
  "Restore this MLet's contents from the given ObjectInput.
   Not all implementations support this method.  Those that do not
   throw UnsupportedOperationException.  A subclass may
   override this method to support it or to change the format of
   the read data.

   The format of the read data is not specified, but if an
   implementation supports readExternal(java.io.ObjectInput) it must also
   support writeExternal(java.io.ObjectOutput) in such a way that what is
   written by the latter can be read by the former.

  in - The object input stream to read from. - `java.io.ObjectInput`

  throws: java.io.IOException - if a problem occurred while reading."
  ([^MLet this ^java.io.ObjectInput in]
    (-> this (.readExternal in))))

(defn pre-register
  "Allows the m-let to perform any operations it needs before
   being registered in the MBean server. If the ObjectName is
   null, the m-let provides a default name for its registration
   <defaultDomain>:type=MLet

  server - The MBean server in which the m-let will be registered. - `javax.management.MBeanServer`
  name - The object name of the m-let. - `javax.management.ObjectName`

  returns: The name of the m-let registered. - `javax.management.ObjectName`

  throws: java.lang.Exception - This exception should be caught by the MBean server and re-thrownas an MBeanRegistrationException."
  (^javax.management.ObjectName [^MLet this ^javax.management.MBeanServer server ^javax.management.ObjectName name]
    (-> this (.preRegister server name))))

