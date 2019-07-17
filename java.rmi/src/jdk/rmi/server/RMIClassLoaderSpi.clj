(ns jdk.rmi.server.RMIClassLoaderSpi
  "RMIClassLoaderSpi is the service provider interface for
  RMIClassLoader.

  In particular, an RMIClassLoaderSpi instance provides an
  implementation of the following static methods of
  RMIClassLoader:



  RMIClassLoader.loadClass(URL,String)
  RMIClassLoader.loadClass(String,String)
  RMIClassLoader.loadClass(String,String,ClassLoader)
  RMIClassLoader.loadProxyClass(String,String[],ClassLoader)
  RMIClassLoader.getClassLoader(String)
  RMIClassLoader.getClassAnnotation(Class)



  When one of those methods is invoked, its behavior is to delegate
  to a corresponding method on an instance of this class.
  The details of how each method delegates to the provider instance is
  described in the documentation for each particular method.
  See the documentation for RMIClassLoader for a description
  of how a provider instance is chosen."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server RMIClassLoaderSpi]))

(defn ->rmi-class-loader-spi
  "Constructor."
  ([]
    (new RMIClassLoaderSpi )))

(defn load-class
  "Provides the implementation for
   RMIClassLoader.loadClass(URL,String),
   RMIClassLoader.loadClass(String,String), and
   RMIClassLoader.loadClass(String,String,ClassLoader).

   Loads a class from a codebase URL path, optionally using the
   supplied loader.

   Typically, a provider implementation will attempt to
   resolve the named class using the given defaultLoader,
   if specified, before attempting to resolve the class from the
   codebase URL path.

   An implementation of this method must either return a class
   with the given name or throw an exception.

  codebase - the list of URLs (separated by spaces) to load the class from, or null - `java.lang.String`
  name - the name of the class to load - `java.lang.String`
  default-loader - additional contextual class loader to use, or null - `java.lang.ClassLoader`

  returns: the Class object representing the loaded class - `java.lang.Class<?>`

  throws: java.net.MalformedURLException - if codebase is non-null and contains an invalid URL, or if codebase is null and a provider-specific URL used to load classes is invalid"
  ([^java.rmi.server.RMIClassLoaderSpi this ^java.lang.String codebase ^java.lang.String name ^java.lang.ClassLoader default-loader]
    (-> this (.loadClass codebase name default-loader))))

(defn load-proxy-class
  "Provides the implementation for
   RMIClassLoader.loadProxyClass(String,String[],ClassLoader).

   Loads a dynamic proxy class (see Proxy
   that implements a set of interfaces with the given names
   from a codebase URL path, optionally using the supplied loader.

   An implementation of this method must either return a proxy
   class that implements the named interfaces or throw an exception.

  codebase - the list of URLs (space-separated) to load classes from, or null - `java.lang.String`
  interfaces - the names of the interfaces for the proxy class to implement - `java.lang.String[]`
  default-loader - additional contextual class loader to use, or null - `java.lang.ClassLoader`

  returns: a dynamic proxy class that implements the named interfaces - `java.lang.Class<?>`

  throws: java.net.MalformedURLException - if codebase is non-null and contains an invalid URL, or if codebase is null and a provider-specific URL used to load classes is invalid"
  ([^java.rmi.server.RMIClassLoaderSpi this ^java.lang.String codebase ^java.lang.String[] interfaces ^java.lang.ClassLoader default-loader]
    (-> this (.loadProxyClass codebase interfaces default-loader))))

(defn get-class-loader
  "Provides the implementation for
   RMIClassLoader.getClassLoader(String).

   Returns a class loader that loads classes from the given codebase
   URL path.

   If there is a security manger, its checkPermission
   method will be invoked with a
   RuntimePermission(`getClassLoader`) permission;
   this could result in a SecurityException.
   The implementation of this method may also perform further security
   checks to verify that the calling context has permission to connect
   to all of the URLs in the codebase URL path.

  codebase - the list of URLs (space-separated) from which the returned class loader will load classes from, or null - `java.lang.String`

  returns: a class loader that loads classes from the given codebase URL
   path - `java.lang.ClassLoader`

  throws: java.net.MalformedURLException - if codebase is non-null and contains an invalid URL, or if codebase is null and a provider-specific URL used to identify the class loader is invalid"
  ([^java.rmi.server.RMIClassLoaderSpi this ^java.lang.String codebase]
    (-> this (.getClassLoader codebase))))

(defn get-class-annotation
  "Provides the implementation for
   RMIClassLoader.getClassAnnotation(Class).

   Returns the annotation string (representing a location for
   the class definition) that RMI will use to annotate the class
   descriptor when marshalling objects of the given class.

  cl - the class to obtain the annotation for - `java.lang.Class<?>`

  returns: a string to be used to annotate the given class when
   it gets marshalled, or null - `java.lang.String`

  throws: java.lang.NullPointerException - if cl is null"
  ([^java.rmi.server.RMIClassLoaderSpi this ^java.lang.Class cl]
    (-> this (.getClassAnnotation cl))))

