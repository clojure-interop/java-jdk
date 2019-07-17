(ns javax.naming.InitialContext
  "This class is the starting context for performing naming operations.

  All naming operations are relative to a context.
  The initial context implements the Context interface and
  provides the starting point for resolution of names.


  When the initial context is constructed, its environment
  is initialized with properties defined in the environment parameter
  passed to the constructor, and in any
  application resource files.
  In addition, a small number of standard JNDI properties may
  be specified as system properties or as applet parameters
  (through the use of Context.APPLET).
  These special properties are listed in the field detail sections of the
  Context and
  LdapContext
  interface documentation.

  JNDI determines each property's value by merging
  the values from the following two sources, in order:


  The first occurrence of the property from the constructor's
  environment parameter and (for appropriate properties) the applet
  parameters and system properties.

  The application resource files (jndi.properties).

  For each property found in both of these two sources, or in
  more than one application resource file, the property's value
  is determined as follows.  If the property is
  one of the standard JNDI properties that specify a list of JNDI
  factories (see Context),
  all of the values are
  concatenated into a single colon-separated list.  For other
  properties, only the first value found is used.


  The initial context implementation is determined at runtime.
  The default policy uses the environment property
  `java.naming.factory.initial`,
  which contains the class name of the initial context factory.
  An exception to this policy is made when resolving URL strings, as described
  below.

  When a URL string (a String of the form
  scheme_id:rest_of_name) is passed as a name parameter to
  any method, a URL context factory for handling that scheme is
  located and used to resolve the URL.  If no such factory is found,
  the initial context specified by
  `java.naming.factory.initial` is used.  Similarly, when a
  CompositeName object whose first component is a URL string is
  passed as a name parameter to any method, a URL context factory is
  located and used to resolve the first name component.
  See NamingManager.getURLContext() for a description of how URL
  context factories are located.

  This default policy of locating the initial context and URL context
  factories may be overridden
  by calling
  NamingManager.setInitialContextFactoryBuilder().

  NoInitialContextException is thrown when an initial context cannot
  be instantiated. This exception can be thrown during any interaction
  with the InitialContext, not only when the InitialContext is constructed.
  For example, the implementation of the initial context might lazily
  retrieve the context only when actual methods are invoked on it.
  The application should not have any dependency on when the existence
  of an initial context is determined.

  When the environment property `java.naming.factory.initial` is
  non-null, the InitialContext constructor will attempt to create the
  initial context specified therein. At that time, the initial context factory
  involved might throw an exception if a problem is encountered. However,
  it is provider implementation-dependent when it verifies and indicates
  to the users of the initial context any environment property- or
  connection- related problems. It can do so lazily--delaying until
  an operation is performed on the context, or eagerly, at the time
  the context is constructed.

  An InitialContext instance is not synchronized against concurrent
  access by multiple threads. Multiple threads each manipulating a
  different InitialContext instance need not synchronize.
  Threads that need to access a single InitialContext instance
  concurrently should synchronize amongst themselves and provide the
  necessary locking."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming InitialContext]))

(defn ->initial-context
  "Constructor.

  Constructs an initial context using the supplied environment.
   Environment properties are discussed in the class description.

    This constructor will not modify environment
   or save a reference to it, but may save a clone.
   Caller should not modify mutable keys and values in
   environment after it has been passed to the constructor.

  environment - environment used to create the initial context. Null indicates an empty environment. - `java.util.Hashtable<?,?>`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([environment]
    (new InitialContext environment))
  ([]
    (new InitialContext )))

(defn *do-lookup
  "A static method to retrieve the named object.
   This is a shortcut method equivalent to invoking:


          InitialContext ic = new InitialContext();
          Object obj = ic.lookup();

    If name is empty, returns a new instance of this context
   (which represents the same naming context as this context, but its
   environment may be modified independently and it may be accessed
   concurrently).

  name - the name of the object to look up - `javax.naming.Name`

  returns: the object bound to name - `<T> T`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([name]
    (InitialContext/doLookup name)))

(defn destroy-subcontext
  "Description copied from interface: Context

  name - the name of the context to be destroyed; may not be empty - `java.lang.String`

  throws: javax.naming.NameNotFoundException - if an intermediate context does not exist"
  ([this name]
    (-> this (.destroySubcontext name))))

(defn unbind
  "Description copied from interface: Context

  name - the name to unbind; may not be empty - `java.lang.String`

  throws: javax.naming.NameNotFoundException - if an intermediate context does not exist"
  ([this name]
    (-> this (.unbind name))))

(defn compose-name
  "Composes the name of this context with a name relative to
   this context.
   Since an initial context may never be named relative
   to any context other than itself, the value of the
   prefix parameter must be an empty name (``).

  name - a name relative to this context - `java.lang.String`
  prefix - the name of this context relative to one of its ancestors - `java.lang.String`

  returns: the composition of prefix and name - `java.lang.String`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([this name prefix]
    (-> this (.composeName name prefix))))

(defn rename
  "Description copied from interface: Context

  old-name - the name of the existing binding; may not be empty - `java.lang.String`
  new-name - the name of the new binding; may not be empty - `java.lang.String`

  throws: javax.naming.NameAlreadyBoundException - if newName is already bound"
  ([this old-name new-name]
    (-> this (.rename old-name new-name))))

(defn list
  "Description copied from interface: Context

  name - the name of the context to list - `java.lang.String`

  returns: an enumeration of the names and class names of the
            bindings in this context.  Each element of the
            enumeration is of type NameClassPair. - `javax.naming.NamingEnumeration<javax.naming.NameClassPair>`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([this name]
    (-> this (.list name))))

(defn add-to-environment
  "Description copied from interface: Context

  prop-name - the name of the environment property to add; may not be null - `java.lang.String`
  prop-val - the value of the property to add; may not be null - `java.lang.Object`

  returns: the previous value of the property, or null if the property was
            not in the environment before - `java.lang.Object`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([this prop-name prop-val]
    (-> this (.addToEnvironment prop-name prop-val))))

(defn bind
  "Description copied from interface: Context

  name - the name to bind; may not be empty - `java.lang.String`
  obj - the object to bind; possibly null - `java.lang.Object`

  throws: javax.naming.NameAlreadyBoundException - if name is already bound"
  ([this name obj]
    (-> this (.bind name obj))))

(defn list-bindings
  "Description copied from interface: Context

  name - the name of the context to list - `java.lang.String`

  returns: an enumeration of the bindings in this context.
            Each element of the enumeration is of type
            Binding. - `javax.naming.NamingEnumeration<javax.naming.Binding>`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([this name]
    (-> this (.listBindings name))))

(defn lookup
  "Description copied from interface: Context

  name - the name of the object to look up - `java.lang.String`

  returns: the object bound to name - `java.lang.Object`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([this name]
    (-> this (.lookup name))))

(defn remove-from-environment
  "Description copied from interface: Context

  prop-name - the name of the environment property to remove; may not be null - `java.lang.String`

  returns: the previous value of the property, or null if the property was
            not in the environment - `java.lang.Object`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([this prop-name]
    (-> this (.removeFromEnvironment prop-name))))

(defn create-subcontext
  "Description copied from interface: Context

  name - the name of the context to create; may not be empty - `java.lang.String`

  returns: the newly created context - `javax.naming.Context`

  throws: javax.naming.NameAlreadyBoundException - if name is already bound"
  ([this name]
    (-> this (.createSubcontext name))))

(defn get-name-parser
  "Description copied from interface: Context

  name - the name of the context from which to get the parser - `java.lang.String`

  returns: a name parser that can parse compound names into their atomic
            components - `javax.naming.NameParser`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([this name]
    (-> this (.getNameParser name))))

(defn get-environment
  "Description copied from interface: Context

  returns: the environment of this context; never null - `java.util.Hashtable<?,?>`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([this]
    (-> this (.getEnvironment))))

(defn rebind
  "Description copied from interface: Context

  name - the name to bind; may not be empty - `java.lang.String`
  obj - the object to bind; possibly null - `java.lang.Object`

  throws: javax.naming.directory.InvalidAttributesException - if object did not supply all mandatory attributes"
  ([this name obj]
    (-> this (.rebind name obj))))

(defn close
  "Description copied from interface: Context

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([this]
    (-> this (.close))))

(defn get-name-in-namespace
  "Description copied from interface: Context

  returns: this context's name in its own namespace; never null - `java.lang.String`

  throws: javax.naming.OperationNotSupportedException - if the naming system does not have the notion of a full name"
  ([this]
    (-> this (.getNameInNamespace))))

(defn lookup-link
  "Description copied from interface: Context

  name - the name of the object to look up - `java.lang.String`

  returns: the object bound to name, not following the
            terminal link (if any) - `java.lang.Object`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([this name]
    (-> this (.lookupLink name))))

