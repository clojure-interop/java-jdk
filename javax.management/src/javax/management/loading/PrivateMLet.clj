(ns javax.management.loading.PrivateMLet
  "An MLet that is not added to the ClassLoaderRepository.
  This class acts exactly like its parent class, MLet, with
  one exception.  When a PrivateMLet is registered in an MBean
  server, it is not added to that MBean server's ClassLoaderRepository.  This is true because this class implements
  the interface PrivateClassLoader."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.loading PrivateMLet]))

(defn ->private-m-let
  "Constructor.

  Constructs a new PrivateMLet for the specified URLs, parent
   class loader, and URLStreamHandlerFactory. The parent argument
   will be used as the parent class loader for delegation. The
   factory argument will be used as the stream handler factory to
   obtain protocol handlers when creating new URLs.

  urls - The URLs from which to load classes and resources. - `java.net.URL[]`
  parent - The parent class loader for delegation. - `java.lang.ClassLoader`
  factory - The URLStreamHandlerFactory to use when creating URLs. - `java.net.URLStreamHandlerFactory`
  delegate-to-clr - True if, when a class is not found in either the parent ClassLoader or the URLs, the MLet should delegate to its containing MBeanServer's ClassLoaderRepository. - `boolean`"
  ([^java.net.URL[] urls ^java.lang.ClassLoader parent ^java.net.URLStreamHandlerFactory factory ^Boolean delegate-to-clr]
    (new PrivateMLet urls parent factory delegate-to-clr))
  ([^java.net.URL[] urls ^java.lang.ClassLoader parent ^Boolean delegate-to-clr]
    (new PrivateMLet urls parent delegate-to-clr))
  ([^java.net.URL[] urls ^Boolean delegate-to-clr]
    (new PrivateMLet urls delegate-to-clr)))

