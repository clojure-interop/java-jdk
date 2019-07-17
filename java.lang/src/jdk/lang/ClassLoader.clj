(ns jdk.lang.ClassLoader
  "A class loader is an object that is responsible for loading classes. The
  class ClassLoader is an abstract class.  Given the binary name of a class, a class loader should attempt to
  locate or generate data that constitutes a definition for the class.  A
  typical strategy is to transform the name into a file name and then read a
  `class file` of that name from a file system.

   Every Class object contains a reference to the ClassLoader that defined
  it.

   Class objects for array classes are not created by class
  loaders, but are created automatically as required by the Java runtime.
  The class loader for an array class, as returned by Class.getClassLoader() is the same as the class loader for its element
  type; if the element type is a primitive type, then the array class has no
  class loader.

   Applications implement subclasses of ClassLoader in order to
  extend the manner in which the Java virtual machine dynamically loads
  classes.

   Class loaders may typically be used by security managers to indicate
  security domains.

   The ClassLoader class uses a delegation model to search for
  classes and resources.  Each instance of ClassLoader has an
  associated parent class loader.  When requested to find a class or
  resource, a ClassLoader instance will delegate the search for the
  class or resource to its parent class loader before attempting to find the
  class or resource itself.  The virtual machine's built-in class loader,
  called the `bootstrap class loader`, does not itself have a parent but may
  serve as the parent of a ClassLoader instance.

   Class loaders that support concurrent loading of classes are known as
  parallel capable class loaders and are required to register
  themselves at their class initialization time by invoking the
  ClassLoader.registerAsParallelCapable
  method. Note that the ClassLoader class is registered as parallel
  capable by default. However, its subclasses still need to register themselves
  if they are parallel capable.
  In environments in which the delegation model is not strictly
  hierarchical, class loaders need to be parallel capable, otherwise class
  loading can lead to deadlocks because the loader lock is held for the
  duration of the class loading process (see loadClass methods).

   Normally, the Java virtual machine loads classes from the local file
  system in a platform-dependent manner.  For example, on UNIX systems, the
  virtual machine loads classes from the directory defined by the
  CLASSPATH environment variable.

   However, some classes may not originate from a file; they may originate
  from other sources, such as the network, or they could be constructed by an
  application.  The method defineClass converts an array of bytes into an instance of class
  Class. Instances of this newly defined class can be created using
  Class.newInstance.

   The methods and constructors of objects created by a class loader may
  reference other classes.  To determine the class(es) referred to, the Java
  virtual machine invokes the loadClass method of
  the class loader that originally created the class.

   For example, an application could create a network class loader to
  download class files from a server.  Sample code might look like:



    ClassLoader loader = new NetworkClassLoader(host, port);
    Object main = loader.loadClass(`Main`, true).newInstance();
         . . .

   The network class loader subclass must define the methods findClass and loadClassData to load a class
  from the network.  Once it has downloaded the bytes that make up the class,
  it should use the method defineClass to
  create a class instance.  A sample implementation is:



      class NetworkClassLoader extends ClassLoader {
          String host;
          int port;

          public Class findClass(String name) {
              byte[] b = loadClassData(name);
              return defineClass(name, b, 0, b.length);
          }

          private byte[] loadClassData(String name) {
              // load the class data from the connection
               . . .
          }
      }

   Binary names

   Any class name provided as a String parameter to methods in
  ClassLoader must be a binary name as defined by
  The Java™ Language Specification.

   Examples of valid class names include:


    `java.lang.String`
    `javax.swing.JSpinner$DefaultEditor`
    `java.security.KeyStore$Builder$FileBuilder$1`
    `java.net.URLClassLoader$3$1`"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ClassLoader]))

(defn *get-system-resource
  "Find a resource of the specified name from the search path used to load
   classes.  This method locates the resource through the system class
   loader (see getSystemClassLoader()).

  name - The resource name - `java.lang.String`

  returns: A URL object for reading the
            resource, or null if the resource could not be found - `java.net.URL`"
  ([name]
    (ClassLoader/getSystemResource name)))

(defn *get-system-resources
  "Finds all resources of the specified name from the search path used to
   load classes.  The resources thus found are returned as an
   Enumeration of URL objects.

    The search order is described in the documentation for getSystemResource(String).

  name - The resource name - `java.lang.String`

  returns: An enumeration of resource URL
            objects - `java.util.Enumeration<java.net.URL>`

  throws: java.io.IOException - If I/O errors occur"
  ([name]
    (ClassLoader/getSystemResources name)))

(defn *get-system-resource-as-stream
  "Open for reading, a resource of the specified name from the search path
   used to load classes.  This method locates the resource through the
   system class loader (see getSystemClassLoader()).

  name - The resource name - `java.lang.String`

  returns: An input stream for reading the resource, or null
            if the resource could not be found - `java.io.InputStream`"
  ([name]
    (ClassLoader/getSystemResourceAsStream name)))

(defn *get-system-class-loader
  "Returns the system class loader for delegation.  This is the default
   delegation parent for new ClassLoader instances, and is
   typically the class loader used to start the application.

    This method is first invoked early in the runtime's startup
   sequence, at which point it creates the system class loader and sets it
   as the context class loader of the invoking Thread.

    The default system class loader is an implementation-dependent
   instance of this class.

    If the system property `java.system.class.loader` is defined
   when this method is first invoked then the value of that property is
   taken to be the name of a class that will be returned as the system
   class loader.  The class is loaded using the default system class loader
   and must define a public constructor that takes a single parameter of
   type ClassLoader which is used as the delegation parent.  An
   instance is then created using this constructor with the default system
   class loader as the parameter.  The resulting class loader is defined
   to be the system class loader.

    If a security manager is present, and the invoker's class loader is
   not null and the invoker's class loader is not the same as or
   an ancestor of the system class loader, then this method invokes the
   security manager's checkPermission method with a RuntimePermission(`getClassLoader`) permission to verify
   access to the system class loader.  If not, a
   SecurityException will be thrown.

  returns: The system ClassLoader for delegation, or
            null if none - `java.lang.ClassLoader`

  throws: java.lang.SecurityException - If a security manager exists and its checkPermission method doesn't allow access to the system class loader."
  ([]
    (ClassLoader/getSystemClassLoader )))

(defn get-resources
  "Finds all the resources with the given name. A resource is some data
   (images, audio, text, etc) that can be accessed by class code in a way
   that is independent of the location of the code.

   The name of a resource is a /-separated path name that
   identifies the resource.

    The search order is described in the documentation for getResource(String).

  name - The resource name - `java.lang.String`

  returns: An enumeration of URL objects for
            the resource.  If no resources could  be found, the enumeration
            will be empty.  Resources that the class loader doesn't have
            access to will not be in the enumeration. - `java.util.Enumeration<java.net.URL>`

  throws: java.io.IOException - If I/O errors occur"
  ([this name]
    (-> this (.getResources name))))

(defn clear-assertion-status
  "Sets the default assertion status for this class loader to
   false and discards any package defaults or class assertion
   status settings associated with the class loader.  This method is
   provided so that class loaders can be made to ignore any command line or
   persistent assertion status settings and `start with a clean slate.`"
  ([this]
    (-> this (.clearAssertionStatus))))

(defn set-class-assertion-status
  "Sets the desired assertion status for the named top-level class in this
   class loader and any nested classes contained therein.  This setting
   takes precedence over the class loader's default assertion status, and
   over any applicable per-package default.  This method has no effect if
   the named class has already been initialized.  (Once a class is
   initialized, its assertion status cannot change.)

    If the named class is not a top-level class, this invocation will
   have no effect on the actual assertion status of any class.

  class-name - The fully qualified class name of the top-level class whose assertion status is to be set. - `java.lang.String`
  enabled - true if the named class is to have assertions enabled when (and if) it is initialized, false if the class is to have assertions disabled. - `boolean`"
  ([this class-name enabled]
    (-> this (.setClassAssertionStatus class-name enabled))))

(defn get-resource
  "Finds the resource with the given name.  A resource is some data
   (images, audio, text, etc) that can be accessed by class code in a way
   that is independent of the location of the code.

    The name of a resource is a '/'-separated path name that
   identifies the resource.

    This method will first search the parent class loader for the
   resource; if the parent is null the path of the class loader
   built-in to the virtual machine is searched.  That failing, this method
   will invoke findResource(String) to find the resource.

  name - The resource name - `java.lang.String`

  returns: A URL object for reading the resource, or
            null if the resource could not be found or the invoker
            doesn't have adequate  privileges to get the resource. - `java.net.URL`"
  ([this name]
    (-> this (.getResource name))))

(defn get-resource-as-stream
  "Returns an input stream for reading the specified resource.

    The search order is described in the documentation for getResource(String).

  name - The resource name - `java.lang.String`

  returns: An input stream for reading the resource, or null
            if the resource could not be found - `java.io.InputStream`"
  ([this name]
    (-> this (.getResourceAsStream name))))

(defn set-default-assertion-status
  "Sets the default assertion status for this class loader.  This setting
   determines whether classes loaded by this class loader and initialized
   in the future will have assertions enabled or disabled by default.
   This setting may be overridden on a per-package or per-class basis by
   invoking setPackageAssertionStatus(String, boolean) or setClassAssertionStatus(String, boolean).

  enabled - true if classes loaded by this class loader will henceforth have assertions enabled by default, false if they will have assertions disabled by default. - `boolean`"
  ([this enabled]
    (-> this (.setDefaultAssertionStatus enabled))))

(defn load-class
  "Loads the class with the specified binary name.
   This method searches for classes in the same manner as the loadClass(String, boolean) method.  It is invoked by the Java virtual
   machine to resolve class references.  Invoking this method is equivalent
   to invoking loadClass(name,
   false).

  name - The binary name of the class - `java.lang.String`

  returns: The resulting Class object - `java.lang.Class<?>`

  throws: java.lang.ClassNotFoundException - If the class was not found"
  ([this name]
    (-> this (.loadClass name))))

(defn set-package-assertion-status
  "Sets the package default assertion status for the named package.  The
   package default assertion status determines the assertion status for
   classes initialized in the future that belong to the named package or
   any of its `subpackages`.

    A subpackage of a package named p is any package whose name begins
   with `p.`.  For example, javax.swing.text is a
   subpackage of javax.swing, and both java.util and
   java.lang.reflect are subpackages of java.

    In the event that multiple package defaults apply to a given class,
   the package default pertaining to the most specific package takes
   precedence over the others.  For example, if javax.lang and
   javax.lang.reflect both have package defaults associated with
   them, the latter package default applies to classes in
   javax.lang.reflect.

    Package defaults take precedence over the class loader's default
   assertion status, and may be overridden on a per-class basis by invoking
   setClassAssertionStatus(String, boolean).

  package-name - The name of the package whose package default assertion status is to be set. A null value indicates the unnamed package that is `current` (see section 7.4.2 of The Java™ Language Specification.) - `java.lang.String`
  enabled - true if classes loaded by this classloader and belonging to the named package or any of its subpackages will have assertions enabled by default, false if they will have assertions disabled by default. - `boolean`"
  ([this package-name enabled]
    (-> this (.setPackageAssertionStatus package-name enabled))))

(defn get-parent
  "Returns the parent class loader for delegation. Some implementations may
   use null to represent the bootstrap class loader. This method
   will return null in such implementations if this class loader's
   parent is the bootstrap class loader.

    If a security manager is present, and the invoker's class loader is
   not null and is not an ancestor of this class loader, then this
   method invokes the security manager's checkPermission method with a RuntimePermission(`getClassLoader`) permission to verify
   access to the parent class loader is permitted.  If not, a
   SecurityException will be thrown.

  returns: The parent ClassLoader - `java.lang.ClassLoader`

  throws: java.lang.SecurityException - If a security manager exists and its checkPermission method doesn't allow access to this class loader's parent class loader."
  ([this]
    (-> this (.getParent))))

