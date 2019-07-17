(ns javax.naming.spi.DirObjectFactory
  "This interface represents a factory for creating an object given
  an object and attributes about the object.

  The JNDI framework allows for object implementations to
  be loaded in dynamically via object factories. See
  ObjectFactory for details.

  A DirObjectFactory extends ObjectFactory by allowing
  an Attributes instance
  to be supplied to the getObjectInstance() method.
  DirObjectFactory implementations are intended to be used by DirContext
  service providers. The service provider, in addition reading an
  object from the directory, might already have attributes that
  are useful for the object factory to check to see whether the
  factory is supposed to process the object. For instance, an LDAP-style
  service provider might have read the `objectclass` of the object.
  A CORBA object factory might be interested only in LDAP entries
  with `objectclass=corbaObject`. By using the attributes supplied by
  the LDAP service provider, the CORBA object factory can quickly
  eliminate objects that it need not worry about, and non-CORBA object
  factories can quickly eliminate CORBA-related LDAP entries."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.spi DirObjectFactory]))

(defn get-object-instance
  "Creates an object using the location or reference information, and attributes
   specified.

   Special requirements of this object are supplied
   using environment.
   An example of such an environment property is user identity
   information.

   DirectoryManager.getObjectInstance()
   successively loads in object factories. If it encounters a DirObjectFactory,
   it will invoke DirObjectFactory.getObjectInstance();
   otherwise, it invokes
   ObjectFactory.getObjectInstance(). It does this until a factory
   produces a non-null answer.
    When an exception
   is thrown by an object factory, the exception is passed on to the caller
   of DirectoryManager.getObjectInstance(). The search for other factories
   that may produce a non-null answer is halted.
   An object factory should only throw an exception if it is sure that
   it is the only intended factory and that no other object factories
   should be tried.
   If this factory cannot create an object using the arguments supplied,
   it should return null.
  Since DirObjectFactory extends ObjectFactory, it
   effectively
   has two getObjectInstance() methods, where one differs from the other by
   the attributes argument. Given a factory that implements DirObjectFactory,
   DirectoryManager.getObjectInstance() will only
   use the method that accepts the attributes argument, while
   NamingManager.getObjectInstance() will only use the one that does not accept
   the attributes argument.

   See ObjectFactory for a description URL context factories and other
   properties of object factories that apply equally to DirObjectFactory.

   The name, attrs, and environment parameters
   are owned by the caller.
   The implementation will not modify these objects or keep references
   to them, although it may keep references to clones or copies.

  obj - The possibly null object containing location or reference information that can be used in creating an object. - `java.lang.Object`
  name - The name of this object relative to nameCtx, or null if no name is specified. - `javax.naming.Name`
  name-ctx - The context relative to which the name parameter is specified, or null if name is relative to the default initial context. - `javax.naming.Context`
  environment - The possibly null environment that is used in creating the object. - `java.util.Hashtable<?,?>`
  attrs - The possibly null attributes containing some of obj's attributes. attrs might not necessarily have all of obj's attributes. If the object factory requires more attributes, it needs to get it, either using obj, or name and nameCtx. The factory must not modify attrs. - `javax.naming.directory.Attributes`

  returns: The object created; null if an object cannot be created. - `java.lang.Object`

  throws: java.lang.Exception - If this object factory encountered an exception while attempting to create an object, and no other object factories are to be tried."
  ([^javax.naming.spi.DirObjectFactory this ^java.lang.Object obj ^javax.naming.Name name ^javax.naming.Context name-ctx ^java.util.Hashtable environment ^javax.naming.directory.Attributes attrs]
    (-> this (.getObjectInstance obj name name-ctx environment attrs))))

