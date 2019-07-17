(ns javax.management.loading.MLetMBean
  "Exposes the remote management interface of the MLet
  MBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.loading MLetMBean]))

(defn get-m-beans-from-url
  "Loads a text file containing MLET tags that define the MBeans
   to be added to the MBean server. The location of the text file is
   specified by a URL. The text file is read using the UTF-8
   encoding. The MBeans specified in the MLET file will be
   instantiated and registered in the MBean server.

  url - The URL of the text file to be loaded as String object. - `java.lang.String`

  returns: A set containing one entry per MLET tag in the m-let
   text file loaded.  Each entry specifies either the
   ObjectInstance for the created MBean, or a throwable object
   (that is, an error or an exception) if the MBean could not be
   created. - `java.util.Set<java.lang.Object>`

  throws: javax.management.ServiceNotFoundException - One of the following errors has occurred: The m-let text file does not contain an MLET tag, the m-let text file is not found, a mandatory attribute of the MLET tag is not specified, the value of url is malformed."
  (^java.util.Set [^javax.management.loading.MLetMBean this ^java.lang.String url]
    (-> this (.getMBeansFromURL url))))

(defn add-url
  "Appends the specified URL to the list of URLs to search for classes and
   resources.

  url - the URL to add. - `java.net.URL`"
  ([^javax.management.loading.MLetMBean this ^java.net.URL url]
    (-> this (.addURL url))))

(defn get-ur-ls
  "Returns the search path of URLs for loading classes and resources.
   This includes the original list of URLs specified to the constructor,
   along with any URLs subsequently appended by the addURL() method.

  returns: the list of URLs. - `java.net.URL[]`"
  ([^javax.management.loading.MLetMBean this]
    (-> this (.getURLs))))

(defn get-resource
  "Finds the resource with the given name.
   A resource is some data (images, audio, text, etc) that can be accessed by class code in a way that is
     independent of the location of the code.
     The name of a resource is a `/`-separated path name that identifies the resource.

  name - The resource name - `java.lang.String`

  returns: An URL for reading the resource, or null if the resource could not be found or the caller doesn't have adequate privileges to get the
   resource. - `java.net.URL`"
  (^java.net.URL [^javax.management.loading.MLetMBean this ^java.lang.String name]
    (-> this (.getResource name))))

(defn get-resource-as-stream
  "Returns an input stream for reading the specified resource. The search order is described in the documentation for
    getResource(String).

  name - The resource name - `java.lang.String`

  returns: An input stream for reading the resource, or null if the resource could not be found - `java.io.InputStream`"
  (^java.io.InputStream [^javax.management.loading.MLetMBean this ^java.lang.String name]
    (-> this (.getResourceAsStream name))))

(defn get-resources
  "Finds all the resources with the given name. A resource is some
   data (images, audio, text, etc) that can be accessed by class
   code in a way that is independent of the location of the code.
   The name of a resource is a `/`-separated path name that
   identifies the resource.

  name - The resource name. - `java.lang.String`

  returns: An enumeration of URL to the resource. If no resources
   could be found, the enumeration will be empty. Resources that
   cannot be accessed will not be in the enumeration. - `java.util.Enumeration<java.net.URL>`

  throws: java.io.IOException - if an I/O exception occurs when searching for resources."
  (^java.util.Enumeration [^javax.management.loading.MLetMBean this ^java.lang.String name]
    (-> this (.getResources name))))

(defn get-library-directory
  "Gets the current directory used by the library loader for
   storing native libraries before they are loaded into memory.

  returns: The current directory used by the library loader. - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if this implementation does not support storing native libraries in this way."
  (^java.lang.String [^javax.management.loading.MLetMBean this]
    (-> this (.getLibraryDirectory))))

(defn set-library-directory
  "Sets the directory used by the library loader for storing
   native libraries before they are loaded into memory.

  libdir - The directory used by the library loader. - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if this implementation does not support storing native libraries in this way."
  ([^javax.management.loading.MLetMBean this ^java.lang.String libdir]
    (-> this (.setLibraryDirectory libdir))))

