(ns jdk.net.URLClassLoader
  "This class loader is used to load classes and resources from a search
  path of URLs referring to both JAR files and directories. Any URL that
  ends with a '/' is assumed to refer to a directory. Otherwise, the URL
  is assumed to refer to a JAR file which will be opened as needed.

  The AccessControlContext of the thread that created the instance of
  URLClassLoader will be used when subsequently loading classes and
  resources.

  The classes that are loaded are by default granted permission only to
  access the URLs specified when the URLClassLoader was created."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net URLClassLoader]))

(defn ->url-class-loader
  "Constructor.

  Constructs a new URLClassLoader for the specified URLs, parent
   class loader, and URLStreamHandlerFactory. The parent argument
   will be used as the parent class loader for delegation. The
   factory argument will be used as the stream handler factory to
   obtain protocol handlers when creating new jar URLs.

   If there is a security manager, this method first
   calls the security manager's checkCreateClassLoader method
   to ensure creation of a class loader is allowed.

  urls - the URLs from which to load classes and resources - `java.net.URL[]`
  parent - the parent class loader for delegation - `java.lang.ClassLoader`
  factory - the URLStreamHandlerFactory to use when creating URLs - `java.net.URLStreamHandlerFactory`

  throws: java.lang.SecurityException - if a security manager exists and its checkCreateClassLoader method doesn't allow creation of a class loader."
  ([urls parent factory]
    (new URLClassLoader urls parent factory))
  ([urls parent]
    (new URLClassLoader urls parent))
  ([urls]
    (new URLClassLoader urls)))

(defn *new-instance
  "Creates a new instance of URLClassLoader for the specified
   URLs and parent class loader. If a security manager is
   installed, the loadClass method of the URLClassLoader
   returned by this method will invoke the
   SecurityManager.checkPackageAccess method before
   loading the class.

  urls - the URLs to search for classes and resources - `java.net.URL[]`
  parent - the parent class loader for delegation - `java.lang.ClassLoader`

  returns: the resulting class loader - `java.net.URLClassLoader`

  throws: java.lang.NullPointerException - if urls is null."
  ([urls parent]
    (URLClassLoader/newInstance urls parent))
  ([urls]
    (URLClassLoader/newInstance urls)))

(defn get-resource-as-stream
  "Returns an input stream for reading the specified resource.
   If this loader is closed, then any resources opened by this method
   will be closed.

    The search order is described in the documentation for ClassLoader.getResource(String).

  name - The resource name - `java.lang.String`

  returns: An input stream for reading the resource, or null
            if the resource could not be found - `java.io.InputStream`"
  ([this name]
    (-> this (.getResourceAsStream name))))

(defn close
  "Closes this URLClassLoader, so that it can no longer be used to load
   new classes or resources that are defined by this loader.
   Classes and resources defined by any of this loader's parents in the
   delegation hierarchy are still accessible. Also, any classes or resources
   that are already loaded, are still accessible.

   In the case of jar: and file: URLs, it also closes any files
   that were opened by it. If another thread is loading a
   class when the close method is invoked, then the result of
   that load is undefined.

   The method makes a best effort attempt to close all opened files,
   by catching IOExceptions internally. Unchecked exceptions
   and errors are not caught. Calling close on an already closed
   loader has no effect.

  throws: java.io.IOException - if closing any file opened by this class loader resulted in an IOException. Any such exceptions are caught internally. If only one is caught, then it is re-thrown. If more than one exception is caught, then the second and following exceptions are added as suppressed exceptions of the first one caught, which is then re-thrown."
  ([this]
    (-> this (.close))))

(defn get-ur-ls
  "Returns the search path of URLs for loading classes and resources.
   This includes the original list of URLs specified to the constructor,
   along with any URLs subsequently appended by the addURL() method.

  returns: the search path of URLs for loading classes and resources. - `java.net.URL[]`"
  ([this]
    (-> this (.getURLs))))

(defn find-resource
  "Finds the resource with the specified name on the URL search path.

  name - the name of the resource - `java.lang.String`

  returns: a URL for the resource, or null
   if the resource could not be found, or if the loader is closed. - `java.net.URL`"
  ([this name]
    (-> this (.findResource name))))

(defn find-resources
  "Returns an Enumeration of URLs representing all of the resources
   on the URL search path having the specified name.

  name - the resource name - `java.lang.String`

  returns: an Enumeration of URLs
           If the loader is closed, the Enumeration will be empty. - `java.util.Enumeration<java.net.URL>`

  throws: java.io.IOException - if an I/O exception occurs"
  ([this name]
    (-> this (.findResources name))))

