(ns jdk.util.prefs.Preferences
  "A node in a hierarchical collection of preference data.  This class
  allows applications to store and retrieve user and system
  preference and configuration data.  This data is stored
  persistently in an implementation-dependent backing store.  Typical
  implementations include flat files, OS-specific registries,
  directory servers and SQL databases.  The user of this class needn't
  be concerned with details of the backing store.

  There are two separate trees of preference nodes, one for user
  preferences and one for system preferences.  Each user has a separate user
  preference tree, and all users in a given system share the same system
  preference tree.  The precise description of `user` and `system` will vary
  from implementation to implementation.  Typical information stored in the
  user preference tree might include font choice, color choice, or preferred
  window location and size for a particular application.  Typical information
  stored in the system preference tree might include installation
  configuration data for an application.

  Nodes in a preference tree are named in a similar fashion to
  directories in a hierarchical file system.   Every node in a preference
  tree has a node name (which is not necessarily unique),
  a unique absolute path name, and a path name relative to each
  ancestor including itself.

  The root node has a node name of the empty string (``).  Every other
  node has an arbitrary node name, specified at the time it is created.  The
  only restrictions on this name are that it cannot be the empty string, and
  it cannot contain the slash character ('/').

  The root node has an absolute path name of `/`.  Children of
  the root node have absolute path names of `/`  <node
  name>.  All other nodes have absolute path names of <parent's
  absolute path name>  `/`  <node name>.
  Note that all absolute path names begin with the slash character.

  A node n's path name relative to its ancestor a
  is simply the string that must be appended to a's absolute path name
  in order to form n's absolute path name, with the initial slash
  character (if present) removed.  Note that:

  No relative path names begin with the slash character.
  Every node's path name relative to itself is the empty string.
  Every node's path name relative to its parent is its node name (except
  for the root node, which does not have a parent).
  Every node's path name relative to the root is its absolute path name
  with the initial slash character removed.


  Note finally that:

  No path name contains multiple consecutive slash characters.
  No path name with the exception of the root's absolute path name
  ends in the slash character.
  Any string that conforms to these two rules is a valid path name.


  All of the methods that modify preferences data are permitted to operate
  asynchronously; they may return immediately, and changes will eventually
  propagate to the persistent backing store with an implementation-dependent
  delay.  The flush method may be used to synchronously force
  updates to the backing store.  Normal termination of the Java Virtual
  Machine will not result in the loss of pending updates -- an explicit
  flush invocation is not required upon termination to ensure
  that pending updates are made persistent.

  All of the methods that read preferences from a Preferences
  object require the invoker to provide a default value.  The default value is
  returned if no value has been previously set or if the backing store is
  unavailable.  The intent is to allow applications to operate, albeit
  with slightly degraded functionality, even if the backing store becomes
  unavailable.  Several methods, like flush, have semantics that
  prevent them from operating if the backing store is unavailable.  Ordinary
  applications should have no need to invoke any of these methods, which can
  be identified by the fact that they are declared to throw BackingStoreException.

  The methods in this class may be invoked concurrently by multiple threads
  in a single JVM without the need for external synchronization, and the
  results will be equivalent to some serial execution.  If this class is used
  concurrently by multiple JVMs that store their preference data in
  the same backing store, the data store will not be corrupted, but no
  other guarantees are made concerning the consistency of the preference
  data.

  This class contains an export/import facility, allowing preferences
  to be `exported` to an XML document, and XML documents representing
  preferences to be `imported` back into the system.  This facility
  may be used to back up all or part of a preference tree, and
  subsequently restore from the backup.

  The XML document has the following DOCTYPE declaration:


  <!DOCTYPE preferences SYSTEM `http://java.sun.com/dtd/preferences.dtd`>
  Note that the system URI (http://java.sun.com/dtd/preferences.dtd) is
  not accessed when exporting or importing preferences; it merely
  serves as a string to uniquely identify the DTD, which is:


     <?xml version=`1.0` encoding=`UTF-8`?>

     <!-- DTD for a Preferences tree. -->

     <!-- The preferences element is at the root of an XML document
          representing a Preferences tree. -->
     <!ELEMENT preferences (root)>

     <!-- The preferences element contains an optional version attribute,
           which specifies version of DTD. -->
     <!ATTLIST preferences EXTERNAL_XML_VERSION CDATA `0.0` >

     <!-- The root element has a map representing the root's preferences
          (if any), and one node for each child of the root (if any). -->
     <!ELEMENT root (map, node*) >

     <!-- Additionally, the root contains a type attribute, which
          specifies whether it's the system or user root. -->
     <!ATTLIST root
               type (system|user) #REQUIRED >

     <!-- Each node has a map representing its preferences (if any),
          and one node for each child (if any). -->
     <!ELEMENT node (map, node*) >

     <!-- Additionally, each node has a name attribute -->
     <!ATTLIST node
               name CDATA #REQUIRED >

     <!-- A map represents the preferences stored at a node (if any). -->
     <!ELEMENT map (entry*) >

     <!-- An entry represents a single preference, which is simply
           a key-value pair. -->
     <!ELEMENT entry EMPTY >
     <!ATTLIST entry
               key   CDATA #REQUIRED
               value CDATA #REQUIRED >

  Every Preferences implementation must have an associated PreferencesFactory implementation.  Every Java(TM) SE implementation must provide
  some means of specifying which PreferencesFactory implementation
  is used to generate the root preferences nodes.  This allows the
  administrator to replace the default preferences implementation with an
  alternative implementation.

  Implementation note: In Sun's JRE, the PreferencesFactory
  implementation is located as follows:



  If the system property
  java.util.prefs.PreferencesFactory is defined, then it is
  taken to be the fully-qualified name of a class implementing the
  PreferencesFactory interface.  The class is loaded and
  instantiated; if this process fails then an unspecified error is
  thrown.

   If a PreferencesFactory implementation class file
  has been installed in a jar file that is visible to the
  system class loader,
  and that jar file contains a provider-configuration file named
  java.util.prefs.PreferencesFactory in the resource
  directory META-INF/services, then the first class name
  specified in that file is taken.  If more than one such jar file is
  provided, the first one found will be used.  The class is loaded
  and instantiated; if this process fails then an unspecified error
  is thrown.

  Finally, if neither the above-mentioned system property nor
  an extension jar file is provided, then the system-wide default
  PreferencesFactory implementation for the underlying
  platform is loaded and instantiated."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.prefs Preferences]))

(def *-max-key-length
  "Static Constant.

  Maximum length of string allowed as a key (80 characters).

  type: int"
  Preferences/MAX_KEY_LENGTH)

(def *-max-value-length
  "Static Constant.

  Maximum length of string allowed as a value (8192 characters).

  type: int"
  Preferences/MAX_VALUE_LENGTH)

(def *-max-name-length
  "Static Constant.

  Maximum length of a node name (80 characters).

  type: int"
  Preferences/MAX_NAME_LENGTH)

(defn *user-node-for-package
  "Returns the preference node from the calling user's preference tree
   that is associated (by convention) with the specified class's package.
   The convention is as follows: the absolute path name of the node is the
   fully qualified package name, preceded by a slash ('/'), and
   with each period ('.') replaced by a slash.  For example the
   absolute path name of the node associated with the class
   com.acme.widget.Foo is /com/acme/widget.

   This convention does not apply to the unnamed package, whose
   associated preference node is <unnamed>.  This node
   is not intended for long term use, but for convenience in the early
   development of programs that do not yet belong to a package, and
   for `throwaway` programs.  Valuable data should not be stored
   at this node as it is shared by all programs that use it.

   A class Foo wishing to access preferences pertaining to its
   package can obtain a preference node as follows:

      static Preferences prefs = Preferences.userNodeForPackage(Foo.class);
   This idiom obviates the need for using a string to describe the
   preferences node and decreases the likelihood of a run-time failure.
   (If the class name is misspelled, it will typically result in a
   compile-time error.)

   Invoking this method will result in the creation of the returned
   node and its ancestors if they do not already exist.  If the returned
   node did not exist prior to this call, this node and any ancestors that
   were created by this call are not guaranteed to become permanent until
   the flush method is called on the returned node (or one of its
   ancestors or descendants).

  c - the class for whose package a user preference node is desired. - `java.lang.Class`

  returns: the user preference node associated with the package of which
           c is a member. - `java.util.prefs.Preferences`

  throws: java.lang.NullPointerException - if c is null."
  (^java.util.prefs.Preferences [^java.lang.Class c]
    (Preferences/userNodeForPackage c)))

(defn *system-node-for-package
  "Returns the preference node from the system preference tree that is
   associated (by convention) with the specified class's package.  The
   convention is as follows: the absolute path name of the node is the
   fully qualified package name, preceded by a slash ('/'), and
   with each period ('.') replaced by a slash.  For example the
   absolute path name of the node associated with the class
   com.acme.widget.Foo is /com/acme/widget.

   This convention does not apply to the unnamed package, whose
   associated preference node is <unnamed>.  This node
   is not intended for long term use, but for convenience in the early
   development of programs that do not yet belong to a package, and
   for `throwaway` programs.  Valuable data should not be stored
   at this node as it is shared by all programs that use it.

   A class Foo wishing to access preferences pertaining to its
   package can obtain a preference node as follows:

    static Preferences prefs = Preferences.systemNodeForPackage(Foo.class);
   This idiom obviates the need for using a string to describe the
   preferences node and decreases the likelihood of a run-time failure.
   (If the class name is misspelled, it will typically result in a
   compile-time error.)

   Invoking this method will result in the creation of the returned
   node and its ancestors if they do not already exist.  If the returned
   node did not exist prior to this call, this node and any ancestors that
   were created by this call are not guaranteed to become permanent until
   the flush method is called on the returned node (or one of its
   ancestors or descendants).

  c - the class for whose package a system preference node is desired. - `java.lang.Class`

  returns: the system preference node associated with the package of which
           c is a member. - `java.util.prefs.Preferences`

  throws: java.lang.NullPointerException - if c is null."
  (^java.util.prefs.Preferences [^java.lang.Class c]
    (Preferences/systemNodeForPackage c)))

(defn *user-root
  "Returns the root preference node for the calling user.

  returns: the root preference node for the calling user. - `java.util.prefs.Preferences`

  throws: java.lang.SecurityException - If a security manager is present and it denies RuntimePermission(`preferences`)."
  (^java.util.prefs.Preferences []
    (Preferences/userRoot )))

(defn *system-root
  "Returns the root preference node for the system.

  returns: the root preference node for the system. - `java.util.prefs.Preferences`

  throws: java.lang.SecurityException - If a security manager is present and it denies RuntimePermission(`preferences`)."
  (^java.util.prefs.Preferences []
    (Preferences/systemRoot )))

(defn *import-preferences
  "Imports all of the preferences represented by the XML document on the
   specified input stream.  The document may represent user preferences or
   system preferences.  If it represents user preferences, the preferences
   will be imported into the calling user's preference tree (even if they
   originally came from a different user's preference tree).  If any of
   the preferences described by the document inhabit preference nodes that
   do not exist, the nodes will be created.

   The XML document must have the following DOCTYPE declaration:


   <!DOCTYPE preferences SYSTEM `http://java.sun.com/dtd/preferences.dtd`>
   (This method is designed for use in conjunction with
   exportNode(OutputStream) and
   exportSubtree(OutputStream).

   This method is an exception to the general rule that the results of
   concurrently executing multiple methods in this class yields
   results equivalent to some serial execution.  The method behaves
   as if implemented on top of the other public methods in this class,
   notably node(String) and put(String, String).

  is - the input stream from which to read the XML document. - `java.io.InputStream`

  throws: java.io.IOException - if reading from the specified input stream results in an IOException."
  ([^java.io.InputStream is]
    (Preferences/importPreferences is)))

(defn put-int
  "Associates a string representing the specified int value with the
   specified key in this preference node.  The associated string is the
   one that would be returned if the int value were passed to
   Integer.toString(int).  This method is intended for use in
   conjunction with getInt(java.lang.String, int).

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `int`

  throws: java.lang.NullPointerException - if key is null."
  ([^Preferences this ^java.lang.String key ^Integer value]
    (-> this (.putInt key value))))

(defn keys
  "Returns all of the keys that have an associated value in this
   preference node.  (The returned array will be of size zero if
   this node has no preferences.)

   If the implementation supports stored defaults and there
   are any such defaults at this node that have not been overridden,
   by explicit preferences, the defaults are returned in the array in
   addition to any explicit preferences.

  returns: an array of the keys that have an associated value in this
           preference node. - `java.lang.String[]`

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  ([^Preferences this]
    (-> this (.keys))))

(defn children-names
  "Returns the names of the children of this preference node, relative to
   this node.  (The returned array will be of size zero if this node has
   no children.)

  returns: the names of the children of this preference node. - `java.lang.String[]`

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  ([^Preferences this]
    (-> this (.childrenNames))))

(defn put-boolean
  "Associates a string representing the specified boolean value with the
   specified key in this preference node.  The associated string is
   `true` if the value is true, and `false` if it is
   false.  This method is intended for use in conjunction with
   getBoolean(java.lang.String, boolean).

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `boolean`

  throws: java.lang.NullPointerException - if key is null."
  ([^Preferences this ^java.lang.String key ^Boolean value]
    (-> this (.putBoolean key value))))

(defn export-node
  "Emits on the specified output stream an XML document representing all
   of the preferences contained in this node (but not its descendants).
   This XML document is, in effect, an offline backup of the node.

   The XML document will have the following DOCTYPE declaration:


   <!DOCTYPE preferences SYSTEM `http://java.sun.com/dtd/preferences.dtd`>
   The UTF-8 character encoding will be used.

   This method is an exception to the general rule that the results of
   concurrently executing multiple methods in this class yields
   results equivalent to some serial execution.  If the preferences
   at this node are modified concurrently with an invocation of this
   method, the exported preferences comprise a `fuzzy snapshot` of the
   preferences contained in the node; some of the concurrent modifications
   may be reflected in the exported data while others may not.

  os - the output stream on which to emit the XML document. - `java.io.OutputStream`

  throws: java.io.IOException - if writing to the specified output stream results in an IOException."
  ([^Preferences this ^java.io.OutputStream os]
    (-> this (.exportNode os))))

(defn put
  "Associates the specified value with the specified key in this
   preference node.

  key - key with which the specified value is to be associated. - `java.lang.String`
  value - value to be associated with the specified key. - `java.lang.String`

  throws: java.lang.NullPointerException - if key or value is null."
  ([^Preferences this ^java.lang.String key ^java.lang.String value]
    (-> this (.put key value))))

(defn node-exists
  "Returns true if the named preference node exists in the same tree
   as this node.  Relative path names (which do not begin with the slash
   character ('/')) are interpreted relative to this preference
   node.

   If this node (or an ancestor) has already been removed with the
   removeNode() method, it is legal to invoke this method,
   but only with the path name ``; the invocation will return
   false.  Thus, the idiom p.nodeExists(``) may be
   used to test whether p has been removed.

  path-name - the path name of the node whose existence is to be checked. - `java.lang.String`

  returns: true if the specified node exists. - `boolean`

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  (^Boolean [^Preferences this ^java.lang.String path-name]
    (-> this (.nodeExists path-name))))

(defn parent
  "Returns the parent of this preference node, or null if this is
   the root.

  returns: the parent of this preference node. - `java.util.prefs.Preferences`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^java.util.prefs.Preferences [^Preferences this]
    (-> this (.parent))))

(defn absolute-path
  "Returns this preference node's absolute path name.

  returns: this preference node's absolute path name. - `java.lang.String`"
  (^java.lang.String [^Preferences this]
    (-> this (.absolutePath))))

(defn flush
  "Forces any changes in the contents of this preference node and its
   descendants to the persistent store.  Once this method returns
   successfully, it is safe to assume that all changes made in the
   subtree rooted at this node prior to the method invocation have become
   permanent.

   Implementations are free to flush changes into the persistent store
   at any time.  They do not need to wait for this method to be called.

   When a flush occurs on a newly created node, it is made persistent,
   as are any ancestors (and descendants) that have yet to be made
   persistent.  Note however that any preference value changes in
   ancestors are not guaranteed to be made persistent.

    If this method is invoked on a node that has been removed with
   the removeNode() method, flushSpi() is invoked on this node,
   but not on others.

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  ([^Preferences this]
    (-> this (.flush))))

(defn to-string
  "Returns a string representation of this preferences node,
   as if computed by the expression:(this.isUserNode() ? `User` :
   `System`)  ` Preference Node: `  this.absolutePath().

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^Preferences this]
    (-> this (.toString))))

(defn put-float
  "Associates a string representing the specified float value with the
   specified key in this preference node.  The associated string is the
   one that would be returned if the float value were passed to
   Float.toString(float).  This method is intended for use in
   conjunction with getFloat(java.lang.String, float).

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `float`

  throws: java.lang.NullPointerException - if key is null."
  ([^Preferences this ^java.lang.String key ^Float value]
    (-> this (.putFloat key value))))

(defn add-node-change-listener
  "Registers the specified listener to receive node change events
   for this node.  A node change event is generated when a child node is
   added to or removed from this node.  (A single removeNode()
   invocation results in multiple node change events, one for every
   node in the subtree rooted at the removed node.)

   Events are only guaranteed for changes made within the same JVM
   as the registered listener, though some implementations may generate
   events for changes made outside this JVM.  Events may be generated
   before the changes have become permanent.  Events are not generated
   when indirect descendants of this node are added or removed; a
   caller desiring such events must register with each descendant.

   Few guarantees can be made regarding node creation.  Because nodes
   are created implicitly upon access, it may not be feasible for an
   implementation to determine whether a child node existed in the backing
   store prior to access (for example, because the backing store is
   unreachable or cached information is out of date).  Under these
   circumstances, implementations are neither required to generate node
   change events nor prohibited from doing so.

  ncl - The NodeChangeListener to add. - `java.util.prefs.NodeChangeListener`

  throws: java.lang.NullPointerException - if ncl is null."
  ([^Preferences this ^java.util.prefs.NodeChangeListener ncl]
    (-> this (.addNodeChangeListener ncl))))

(defn put-byte-array
  "Associates a string representing the specified byte array with the
   specified key in this preference node.  The associated string is
   the Base64 encoding of the byte array, as defined in RFC 2045, Section 6.8,
   with one minor change: the string will consist solely of characters
   from the Base64 Alphabet; it will not contain any newline
   characters.  Note that the maximum length of the byte array is limited
   to three quarters of MAX_VALUE_LENGTH so that the length
   of the Base64 encoded String does not exceed MAX_VALUE_LENGTH.
   This method is intended for use in conjunction with
   getByteArray(java.lang.String, byte[]).

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `byte[]`

  throws: java.lang.NullPointerException - if key or value is null."
  ([^Preferences this ^java.lang.String key value]
    (-> this (.putByteArray key value))))

(defn name
  "Returns this preference node's name, relative to its parent.

  returns: this preference node's name, relative to its parent. - `java.lang.String`"
  (^java.lang.String [^Preferences this]
    (-> this (.name))))

(defn get-long
  "Returns the long value represented by the string associated with the
   specified key in this preference node.  The string is converted to
   a long as by Long.parseLong(String).  Returns the
   specified default if there is no value associated with the key,
   the backing store is inaccessible, or if
   Long.parseLong(String) would throw a NumberFormatException if the associated value were passed.  This
   method is intended for use in conjunction with putLong(java.lang.String, long).

   If the implementation supports stored defaults and such a
   default exists, is accessible, and could be converted to a long
   with Long.parseLong, this long is returned in preference to
   the specified default.

  key - key whose associated value is to be returned as a long. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as a long, or the backing store is inaccessible. - `long`

  returns: the long value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           a long. - `long`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^Long [^Preferences this ^java.lang.String key ^Long def]
    (-> this (.getLong key def))))

(defn sync
  "Ensures that future reads from this preference node and its
   descendants reflect any changes that were committed to the persistent
   store (from any VM) prior to the sync invocation.  As a
   side-effect, forces any changes in the contents of this preference node
   and its descendants to the persistent store, as if the flush
   method had been invoked on this node.

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  ([^Preferences this]
    (-> this (.sync))))

(defn get-int
  "Returns the int value represented by the string associated with the
   specified key in this preference node.  The string is converted to
   an integer as by Integer.parseInt(String).  Returns the
   specified default if there is no value associated with the key,
   the backing store is inaccessible, or if
   Integer.parseInt(String) would throw a NumberFormatException if the associated value were passed.  This
   method is intended for use in conjunction with putInt(java.lang.String, int).

   If the implementation supports stored defaults and such a
   default exists, is accessible, and could be converted to an int
   with Integer.parseInt, this int is returned in preference to
   the specified default.

  key - key whose associated value is to be returned as an int. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as an int, or the backing store is inaccessible. - `int`

  returns: the int value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           an int. - `int`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^Integer [^Preferences this ^java.lang.String key ^Integer def]
    (-> this (.getInt key def))))

(defn remove-node
  "Removes this preference node and all of its descendants, invalidating
   any preferences contained in the removed nodes.  Once a node has been
   removed, attempting any method other than name(),
   absolutePath(), isUserNode(), flush() or
   nodeExists(``) on the corresponding
   Preferences instance will fail with an
   IllegalStateException.  (The methods defined on Object
   can still be invoked on a node after it has been removed; they will not
   throw IllegalStateException.)

   The removal is not guaranteed to be persistent until the
   flush method is called on this node (or an ancestor).

   If this implementation supports stored defaults, removing a
   node exposes any stored defaults at or below this node.  Thus, a
   subsequent call to nodeExists on this node's path name may
   return true, and a subsequent call to node on this
   path name may return a (different) Preferences instance
   representing a non-empty collection of preferences and/or children.

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  ([^Preferences this]
    (-> this (.removeNode))))

(defn put-double
  "Associates a string representing the specified double value with the
   specified key in this preference node.  The associated string is the
   one that would be returned if the double value were passed to
   Double.toString(double).  This method is intended for use in
   conjunction with getDouble(java.lang.String, double).

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `double`

  throws: java.lang.NullPointerException - if key is null."
  ([^Preferences this ^java.lang.String key ^Double value]
    (-> this (.putDouble key value))))

(defn remove
  "Removes the value associated with the specified key in this preference
   node, if any.

   If this implementation supports stored defaults, and there is
   such a default for the specified preference, the stored default will be
   `exposed` by this call, in the sense that it will be returned
   by a succeeding call to get.

  key - key whose mapping is to be removed from the preference node. - `java.lang.String`

  throws: java.lang.NullPointerException - if key is null."
  ([^Preferences this ^java.lang.String key]
    (-> this (.remove key))))

(defn add-preference-change-listener
  "Registers the specified listener to receive preference change
   events for this preference node.  A preference change event is
   generated when a preference is added to this node, removed from this
   node, or when the value associated with a preference is changed.
   (Preference change events are not generated by the removeNode() method, which generates a node change event.
   Preference change events are generated by the clear
   method.)

   Events are only guaranteed for changes made within the same JVM
   as the registered listener, though some implementations may generate
   events for changes made outside this JVM.  Events may be generated
   before the changes have been made persistent.  Events are not generated
   when preferences are modified in descendants of this node; a caller
   desiring such events must register with each descendant.

  pcl - The preference change listener to add. - `java.util.prefs.PreferenceChangeListener`

  throws: java.lang.NullPointerException - if pcl is null."
  ([^Preferences this ^java.util.prefs.PreferenceChangeListener pcl]
    (-> this (.addPreferenceChangeListener pcl))))

(defn export-subtree
  "Emits an XML document representing all of the preferences contained
   in this node and all of its descendants.  This XML document is, in
   effect, an offline backup of the subtree rooted at the node.

   The XML document will have the following DOCTYPE declaration:


   <!DOCTYPE preferences SYSTEM `http://java.sun.com/dtd/preferences.dtd`>
   The UTF-8 character encoding will be used.

   This method is an exception to the general rule that the results of
   concurrently executing multiple methods in this class yields
   results equivalent to some serial execution.  If the preferences
   or nodes in the subtree rooted at this node are modified concurrently
   with an invocation of this method, the exported preferences comprise a
   `fuzzy snapshot` of the subtree; some of the concurrent modifications
   may be reflected in the exported data while others may not.

  os - the output stream on which to emit the XML document. - `java.io.OutputStream`

  throws: java.io.IOException - if writing to the specified output stream results in an IOException."
  ([^Preferences this ^java.io.OutputStream os]
    (-> this (.exportSubtree os))))

(defn user-node?
  "Returns true if this preference node is in the user
   preference tree, false if it's in the system preference tree.

  returns: true if this preference node is in the user
           preference tree, false if it's in the system
           preference tree. - `boolean`"
  (^Boolean [^Preferences this]
    (-> this (.isUserNode))))

(defn remove-preference-change-listener
  "Removes the specified preference change listener, so it no longer
   receives preference change events.

  pcl - The preference change listener to remove. - `java.util.prefs.PreferenceChangeListener`

  throws: java.lang.IllegalArgumentException - if pcl was not a registered preference change listener on this node."
  ([^Preferences this ^java.util.prefs.PreferenceChangeListener pcl]
    (-> this (.removePreferenceChangeListener pcl))))

(defn get-byte-array
  "Returns the byte array value represented by the string associated with
   the specified key in this preference node.  Valid strings are
   Base64 encoded binary data, as defined in RFC 2045, Section 6.8,
   with one minor change: the string must consist solely of characters
   from the Base64 Alphabet; no newline characters or
   extraneous characters are permitted.  This method is intended for use
   in conjunction with putByteArray(java.lang.String, byte[]).

   Returns the specified default if there is no value
   associated with the key, the backing store is inaccessible, or if the
   associated value is not a valid Base64 encoded byte array
   (as defined above).

   If the implementation supports stored defaults and such a
   default exists and is accessible, it is used in preference to the
   specified default, unless the stored default is not a valid Base64
   encoded byte array (as defined above), in which case the
   specified default is used.

  key - key whose associated value is to be returned as a byte array. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as a byte array, or the backing store is inaccessible. - `byte[]`

  returns: the byte array value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           a byte array. - `byte[]`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  ([^Preferences this ^java.lang.String key def]
    (-> this (.getByteArray key def))))

(defn get-boolean?
  "Returns the boolean value represented by the string associated with the
   specified key in this preference node.  Valid strings
   are `true`, which represents true, and `false`, which
   represents false.  Case is ignored, so, for example, `TRUE`
   and `False` are also valid.  This method is intended for use in
   conjunction with putBoolean(java.lang.String, boolean).

   Returns the specified default if there is no value
   associated with the key, the backing store is inaccessible, or if the
   associated value is something other than `true` or
   `false`, ignoring case.

   If the implementation supports stored defaults and such a
   default exists and is accessible, it is used in preference to the
   specified default, unless the stored default is something other than
   `true` or `false`, ignoring case, in which case the
   specified default is used.

  key - key whose associated value is to be returned as a boolean. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as a boolean, or the backing store is inaccessible. - `boolean`

  returns: the boolean value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           a boolean. - `boolean`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^Boolean [^Preferences this ^java.lang.String key ^Boolean def]
    (-> this (.getBoolean key def))))

(defn clear
  "Removes all of the preferences (key-value associations) in this
   preference node.  This call has no effect on any descendants
   of this node.

   If this implementation supports stored defaults, and this
   node in the preferences hierarchy contains any such defaults,
   the stored defaults will be `exposed` by this call, in the sense that
   they will be returned by succeeding calls to get.

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  ([^Preferences this]
    (-> this (.clear))))

(defn get-float
  "Returns the float value represented by the string associated with the
   specified key in this preference node.  The string is converted to an
   integer as by Float.parseFloat(String).  Returns the specified
   default if there is no value associated with the key, the backing store
   is inaccessible, or if Float.parseFloat(String) would throw a
   NumberFormatException if the associated value were passed.
   This method is intended for use in conjunction with putFloat(java.lang.String, float).

   If the implementation supports stored defaults and such a
   default exists, is accessible, and could be converted to a float
   with Float.parseFloat, this float is returned in preference to
   the specified default.

  key - key whose associated value is to be returned as a float. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as a float, or the backing store is inaccessible. - `float`

  returns: the float value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           a float. - `float`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^Float [^Preferences this ^java.lang.String key ^Float def]
    (-> this (.getFloat key def))))

(defn get-double
  "Returns the double value represented by the string associated with the
   specified key in this preference node.  The string is converted to an
   integer as by Double.parseDouble(String).  Returns the specified
   default if there is no value associated with the key, the backing store
   is inaccessible, or if Double.parseDouble(String) would throw a
   NumberFormatException if the associated value were passed.
   This method is intended for use in conjunction with putDouble(java.lang.String, double).

   If the implementation supports stored defaults and such a
   default exists, is accessible, and could be converted to a double
   with Double.parseDouble, this double is returned in preference
   to the specified default.

  key - key whose associated value is to be returned as a double. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as a double, or the backing store is inaccessible. - `double`

  returns: the double value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           a double. - `double`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^Double [^Preferences this ^java.lang.String key ^Double def]
    (-> this (.getDouble key def))))

(defn put-long
  "Associates a string representing the specified long value with the
   specified key in this preference node.  The associated string is the
   one that would be returned if the long value were passed to
   Long.toString(long).  This method is intended for use in
   conjunction with getLong(java.lang.String, long).

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `long`

  throws: java.lang.NullPointerException - if key is null."
  ([^Preferences this ^java.lang.String key ^Long value]
    (-> this (.putLong key value))))

(defn get
  "Returns the value associated with the specified key in this preference
   node.  Returns the specified default if there is no value associated
   with the key, or the backing store is inaccessible.

   Some implementations may store default values in their backing
   stores.  If there is no value associated with the specified key
   but there is such a stored default, it is returned in
   preference to the specified default.

  key - key whose associated value is to be returned. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key. - `java.lang.String`

  returns: the value associated with key, or def
           if no value is associated with key, or the backing
           store is inaccessible. - `java.lang.String`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^java.lang.String [^Preferences this ^java.lang.String key ^java.lang.String def]
    (-> this (.get key def))))

(defn remove-node-change-listener
  "Removes the specified NodeChangeListener, so it no longer
   receives change events.

  ncl - The NodeChangeListener to remove. - `java.util.prefs.NodeChangeListener`

  throws: java.lang.IllegalArgumentException - if ncl was not a registered NodeChangeListener on this node."
  ([^Preferences this ^java.util.prefs.NodeChangeListener ncl]
    (-> this (.removeNodeChangeListener ncl))))

(defn node
  "Returns the named preference node in the same tree as this node,
   creating it and any of its ancestors if they do not already exist.
   Accepts a relative or absolute path name.  Relative path names
   (which do not begin with the slash character ('/')) are
   interpreted relative to this preference node.

   If the returned node did not exist prior to this call, this node and
   any ancestors that were created by this call are not guaranteed
   to become permanent until the flush method is called on
   the returned node (or one of its ancestors or descendants).

  path-name - the path name of the preference node to return. - `java.lang.String`

  returns: the specified preference node. - `java.util.prefs.Preferences`

  throws: java.lang.IllegalArgumentException - if the path name is invalid (i.e., it contains multiple consecutive slash characters, or ends with a slash character and is more than one character long)."
  (^java.util.prefs.Preferences [^Preferences this ^java.lang.String path-name]
    (-> this (.node path-name))))

