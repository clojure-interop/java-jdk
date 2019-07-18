(ns javax.naming.spi.DirectoryManager
  "This class contains methods for supporting DirContext
  implementations.

  This class is an extension of NamingManager.  It contains methods
  for use by service providers for accessing object factories and
  state factories, and for getting continuation contexts for
  supporting federation.

  DirectoryManager is safe for concurrent access by multiple threads.

  Except as otherwise noted,
  a Name, Attributes, or environment parameter
  passed to any method is owned by the caller.
  The implementation will not modify the object or keep a reference
  to it, although it may keep a reference to a clone or copy."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.spi DirectoryManager]))

(defn *get-continuation-dir-context
  "Creates a context in which to continue a DirContext operation.
   Operates just like NamingManager.getContinuationContext(),
   only the continuation context returned is a DirContext.

  cpe - The non-null exception that triggered this continuation. - `javax.naming.CannotProceedException`

  returns: A non-null DirContext object for continuing the operation. - `javax.naming.directory.DirContext`

  throws: javax.naming.NamingException - If a naming exception occurred."
  (^javax.naming.directory.DirContext [^javax.naming.CannotProceedException cpe]
    (DirectoryManager/getContinuationDirContext cpe)))

(defn *get-object-instance
  "Creates an instance of an object for the specified object,
   attributes, and environment.

   This method is the same as NamingManager.getObjectInstance
   except for the following differences:


   It accepts an Attributes parameter that contains attributes
   associated with the object. The DirObjectFactory might use these
   attributes to save having to look them up from the directory.

   The object factories tried must implement either
   ObjectFactory or DirObjectFactory.
   If it implements DirObjectFactory,
   DirObjectFactory.getObjectInstance() is used, otherwise,
   ObjectFactory.getObjectInstance() is used.

   Service providers that implement the DirContext interface
   should use this method, not NamingManager.getObjectInstance().

  ref-info - The possibly null object for which to create an object. - `java.lang.Object`
  name - The name of this object relative to nameCtx. Specifying a name is optional; if it is omitted, name should be null. - `javax.naming.Name`
  name-ctx - The context relative to which the name parameter is specified. If null, name is relative to the default initial context. - `javax.naming.Context`
  environment - The possibly null environment to be used in the creation of the object factory and the object. - `java.util.Hashtable`
  attrs - The possibly null attributes associated with refInfo. This might not be the complete set of attributes for refInfo; you might be able to read more attributes from the directory. - `javax.naming.directory.Attributes`

  returns: An object created using refInfo and attrs; or
           refInfo if an object cannot be created by
           a factory. - `java.lang.Object`

  throws: javax.naming.NamingException - If a naming exception was encountered while attempting to get a URL context, or if one of the factories accessed throws a NamingException."
  (^java.lang.Object [^java.lang.Object ref-info ^javax.naming.Name name ^javax.naming.Context name-ctx ^java.util.Hashtable environment ^javax.naming.directory.Attributes attrs]
    (DirectoryManager/getObjectInstance ref-info name name-ctx environment attrs)))

(defn *get-state-to-bind
  "Retrieves the state of an object for binding when given the original
   object and its attributes.

   This method is like NamingManager.getStateToBind except
   for the following differences:

  It accepts an Attributes parameter containing attributes
      that were passed to the DirContext.bind() method.
  It returns a non-null DirStateFactory.Result instance
      containing the object to be bound, and the attributes to
      accompany the binding. Either the object or the attributes may be null.

   The state factories tried must each implement either
   StateFactory or DirStateFactory.
   If it implements DirStateFactory, then
   DirStateFactory.getStateToBind() is called; otherwise,
   StateFactory.getStateToBind() is called.


   Service providers that implement the DirContext interface
   should use this method, not NamingManager.getStateToBind().

   See NamingManager.getStateToBind() for a description of how
   the list of state factories to be tried is determined.

   The object returned by this method is owned by the caller.
   The implementation will not subsequently modify it.
   It will contain either a new Attributes object that is
   likewise owned by the caller, or a reference to the original
   attrs parameter.

  obj - The non-null object for which to get state to bind. - `java.lang.Object`
  name - The name of this object relative to nameCtx, or null if no name is specified. - `javax.naming.Name`
  name-ctx - The context relative to which the name parameter is specified, or null if name is relative to the default initial context. - `javax.naming.Context`
  environment - The possibly null environment to be used in the creation of the state factory and the object's state. - `java.util.Hashtable`
  attrs - The possibly null Attributes that is to be bound with the object. - `javax.naming.directory.Attributes`

  returns: A non-null DirStateFactory.Result containing
    the object and attributes to be bound.
    If no state factory returns a non-null answer, the result will contain
    the object (obj) itself with the original attributes. - `javax.naming.spi.DirStateFactory$Result`

  throws: javax.naming.NamingException - If a naming exception was encountered while using the factories. A factory should only throw an exception if it does not want other factories to be used in an attempt to create an object. See DirStateFactory.getStateToBind()."
  (^javax.naming.spi.DirStateFactory$Result [^java.lang.Object obj ^javax.naming.Name name ^javax.naming.Context name-ctx ^java.util.Hashtable environment ^javax.naming.directory.Attributes attrs]
    (DirectoryManager/getStateToBind obj name name-ctx environment attrs)))

