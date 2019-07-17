(ns javax.management.loading.ClassLoaderRepository
  "Instances of this interface are used to keep the list of ClassLoaders
  registered in an MBean Server.
  They provide the necessary methods to load classes using the registered
  ClassLoaders.

  The first ClassLoader in a ClassLoaderRepository is
  always the MBean Server's own ClassLoader.

  When an MBean is registered in an MBean Server, if it is of a
  subclass of ClassLoader and if it does not
  implement the interface PrivateClassLoader, it is added to
  the end of the MBean Server's ClassLoaderRepository.
  If it is subsequently unregistered from the MBean Server, it is
  removed from the ClassLoaderRepository.

  The order of MBeans in the ClassLoaderRepository is
  significant.  For any two MBeans X and Y in the
  ClassLoaderRepository, X must appear before
  Y if the registration of X was completed before
  the registration of Y started.  If X and
  Y were registered concurrently, their order is
  indeterminate.  The registration of an MBean corresponds to the
  call to MBeanServer.registerMBean(java.lang.Object, javax.management.ObjectName) or one of the MBeanServer.createMBean methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.loading ClassLoaderRepository]))

(defn load-class
  "Load the given class name through the list of class loaders.
   Each ClassLoader in turn from the ClassLoaderRepository is
   asked to load the class via its ClassLoader.loadClass(String) method.  If it successfully
   returns a Class object, that is the result of this
   method.  If it throws a ClassNotFoundException, the
   search continues with the next ClassLoader.  If it throws
   another exception, the exception is propagated from this
   method.  If the end of the list is reached, a ClassNotFoundException is thrown.

  class-name - The name of the class to be loaded. - `java.lang.String`

  returns: the loaded class. - `java.lang.Class<?>`

  throws: java.lang.ClassNotFoundException - The specified class could not be found."
  ([this class-name]
    (-> this (.loadClass class-name))))

(defn load-class-without
  "Load the given class name through the list of class loaders,
   excluding the given one.  Each ClassLoader in turn from the
   ClassLoaderRepository, except exclude, is asked to
   load the class via its ClassLoader.loadClass(String)
   method.  If it successfully returns a Class object,
   that is the result of this method.  If it throws a ClassNotFoundException, the search continues with the next
   ClassLoader.  If it throws another exception, the exception is
   propagated from this method.  If the end of the list is
   reached, a ClassNotFoundException is thrown.

   Be aware that if a ClassLoader in the ClassLoaderRepository
   calls this method from its loadClass method, it exposes itself to a deadlock if another
   ClassLoader in the ClassLoaderRepository does the same thing at
   the same time.  The loadClassBefore(java.lang.ClassLoader, java.lang.String) method is
   recommended to avoid the risk of deadlock.

  exclude - The class loader to be excluded. May be null, in which case this method is equivalent to loadClass(className). - `java.lang.ClassLoader`
  class-name - The name of the class to be loaded. - `java.lang.String`

  returns: the loaded class. - `java.lang.Class<?>`

  throws: java.lang.ClassNotFoundException - The specified class could not be found."
  ([this exclude class-name]
    (-> this (.loadClassWithout exclude class-name))))

(defn load-class-before
  "Load the given class name through the list of class loaders,
   stopping at the given one.  Each ClassLoader in turn from the
   ClassLoaderRepository is asked to load the class via its ClassLoader.loadClass(String) method.  If it successfully
   returns a Class object, that is the result of this
   method.  If it throws a ClassNotFoundException, the
   search continues with the next ClassLoader.  If it throws
   another exception, the exception is propagated from this
   method.  If the search reaches stop or the end of
   the list, a ClassNotFoundException is thrown.

   Typically this method is called from the loadClass method of
   stop, to consult loaders that appear before it
   in the ClassLoaderRepository.  By stopping the
   search as soon as stop is reached, a potential
   deadlock with concurrent class loading is avoided.

  stop - The class loader at which to stop. May be null, in which case this method is equivalent to loadClass(className). - `java.lang.ClassLoader`
  class-name - The name of the class to be loaded. - `java.lang.String`

  returns: the loaded class. - `java.lang.Class<?>`

  throws: java.lang.ClassNotFoundException - The specified class could not be found."
  ([this stop class-name]
    (-> this (.loadClassBefore stop class-name))))

