(ns jdk.util.prefs.AbstractPreferences
  "This class provides a skeletal implementation of the Preferences
  class, greatly easing the task of implementing it.

  This class is for Preferences implementers only.
  Normal users of the Preferences facility should have no need to
  consult this documentation.  The Preferences documentation
  should suffice.

  Implementors must override the nine abstract service-provider interface
  (SPI) methods: getSpi(String), putSpi(String,String),
  removeSpi(String), childSpi(String), removeNodeSpi(), keysSpi(), childrenNamesSpi(), syncSpi() and flushSpi().  All of the concrete methods specify
  precisely how they are implemented atop these SPI methods.  The implementor
  may, at his discretion, override one or more of the concrete methods if the
  default implementation is unsatisfactory for any reason, such as
  performance.

  The SPI methods fall into three groups concerning exception
  behavior. The getSpi method should never throw exceptions, but it
  doesn't really matter, as any exception thrown by this method will be
  intercepted by get(String,String), which will return the specified
  default value to the caller.  The removeNodeSpi, keysSpi,
  childrenNamesSpi, syncSpi and flushSpi methods are specified
  to throw BackingStoreException, and the implementation is required
  to throw this checked exception if it is unable to perform the operation.
  The exception propagates outward, causing the corresponding API method
  to fail.

  The remaining SPI methods putSpi(String,String), removeSpi(String) and childSpi(String) have more complicated
  exception behavior.  They are not specified to throw
  BackingStoreException, as they can generally obey their contracts
  even if the backing store is unavailable.  This is true because they return
  no information and their effects are not required to become permanent until
  a subsequent call to Preferences.flush() or
  Preferences.sync(). Generally speaking, these SPI methods should not
  throw exceptions.  In some implementations, there may be circumstances
  under which these calls cannot even enqueue the requested operation for
  later processing.  Even under these circumstances it is generally better to
  simply ignore the invocation and return, rather than throwing an
  exception.  Under these circumstances, however, all subsequent invocations
  of flush() and sync should return false, as
  returning true would imply that all previous operations had
  successfully been made permanent.

  There is one circumstance under which putSpi, removeSpi and
  childSpi should throw an exception: if the caller lacks
  sufficient privileges on the underlying operating system to perform the
  requested operation.  This will, for instance, occur on most systems
  if a non-privileged user attempts to modify system preferences.
  (The required privileges will vary from implementation to
  implementation.  On some implementations, they are the right to modify the
  contents of some directory in the file system; on others they are the right
  to modify contents of some key in a registry.)  Under any of these
  circumstances, it would generally be undesirable to let the program
  continue executing as if these operations would become permanent at a later
  time.  While implementations are not required to throw an exception under
  these circumstances, they are encouraged to do so.  A SecurityException would be appropriate.

  Most of the SPI methods require the implementation to read or write
  information at a preferences node.  The implementor should beware of the
  fact that another VM may have concurrently deleted this node from the
  backing store.  It is the implementation's responsibility to recreate the
  node if it has been deleted.

  Implementation note: In Sun's default Preferences
  implementations, the user's identity is inherited from the underlying
  operating system and does not change for the lifetime of the virtual
  machine.  It is recognized that server-side Preferences
  implementations may have the user identity change from request to request,
  implicitly passed to Preferences methods via the use of a
  static ThreadLocal instance.  Authors of such implementations are
  strongly encouraged to determine the user at the time preferences
  are accessed (for example by the get(String,String) or put(String,String) method) rather than permanently associating a user
  with each Preferences instance.  The latter behavior conflicts
  with normal Preferences usage and would lead to great confusion."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.prefs AbstractPreferences]))

(defn put-int
  "Implements the putInt method as per the specification in
   Preferences.putInt(String,int).

   This implementation translates value to a string with
   Integer.toString(int) and invokes put(String,String)
   on the result.

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `int`

  throws: java.lang.NullPointerException - if key is null."
  ([^AbstractPreferences this ^java.lang.String key ^Integer value]
    (-> this (.putInt key value))))

(defn keys
  "Implements the keys method as per the specification in
   Preferences.keys().

   This implementation obtains this preference node's lock, checks that
   the node has not been removed and invokes keysSpi().

  returns: an array of the keys that have an associated value in this
           preference node. - `java.lang.String[]`

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  ([^AbstractPreferences this]
    (-> this (.keys))))

(defn children-names
  "Implements the children method as per the specification in
   Preferences.childrenNames().

   This implementation obtains this preference node's lock, checks that
   the node has not been removed, constructs a TreeSet initialized
   to the names of children already cached (the children in this node's
   \"child-cache\"), invokes childrenNamesSpi(), and adds all of the
   returned child-names into the set.  The elements of the tree set are
   dumped into a String array using the toArray method,
   and this array is returned.

  returns: the names of the children of this preference node. - `java.lang.String[]`

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  ([^AbstractPreferences this]
    (-> this (.childrenNames))))

(defn put-boolean
  "Implements the putBoolean method as per the specification in
   Preferences.putBoolean(String,boolean).

   This implementation translates value to a string with
   String.valueOf(boolean) and invokes put(String,String)
   on the result.

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `boolean`

  throws: java.lang.NullPointerException - if key is null."
  ([^AbstractPreferences this ^java.lang.String key ^Boolean value]
    (-> this (.putBoolean key value))))

(defn export-node
  "Implements the exportNode method as per the specification in
   Preferences.exportNode(OutputStream).

  os - the output stream on which to emit the XML document. - `java.io.OutputStream`

  throws: java.io.IOException - if writing to the specified output stream results in an IOException."
  ([^AbstractPreferences this ^java.io.OutputStream os]
    (-> this (.exportNode os))))

(defn put
  "Implements the put method as per the specification in
   Preferences.put(String,String).

   This implementation checks that the key and value are legal,
   obtains this preference node's lock, checks that the node
   has not been removed, invokes putSpi(String,String), and if
   there are any preference change listeners, enqueues a notification
   event for processing by the event dispatch thread.

  key - key with which the specified value is to be associated. - `java.lang.String`
  value - value to be associated with the specified key. - `java.lang.String`

  throws: java.lang.NullPointerException - if key or value is null."
  ([^AbstractPreferences this ^java.lang.String key ^java.lang.String value]
    (-> this (.put key value))))

(defn node-exists
  "Implements the nodeExists method as per the specification in
   Preferences.nodeExists(String).

   This implementation is very similar to node(String),
   except that getChild(String) is used instead of childSpi(String).

  path - the path name of the node whose existence is to be checked. - `java.lang.String`

  returns: true if the specified node exists. - `boolean`

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  (^Boolean [^AbstractPreferences this ^java.lang.String path]
    (-> this (.nodeExists path))))

(defn parent
  "Implements the parent method as per the specification in
   Preferences.parent().

   This implementation obtains this preference node's lock, checks that
   the node has not been removed and returns the parent value that was
   passed to this node's constructor.

  returns: the parent of this preference node. - `java.util.prefs.Preferences`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^java.util.prefs.Preferences [^AbstractPreferences this]
    (-> this (.parent))))

(defn absolute-path
  "Implements the absolutePath method as per the specification in
   Preferences.absolutePath().

   This implementation merely returns the absolute path name that
   was computed at the time that this node was constructed (based on
   the name that was passed to this node's constructor, and the names
   that were passed to this node's ancestors' constructors).

  returns: this preference node's absolute path name. - `java.lang.String`"
  (^java.lang.String [^AbstractPreferences this]
    (-> this (.absolutePath))))

(defn flush
  "Implements the flush method as per the specification in
   Preferences.flush().

   This implementation calls a recursive helper method that locks this
   node, invokes flushSpi() on it, unlocks this node, and recursively
   invokes this method on each \"cached child.\"  A cached child is a child
   of this node that has been created in this VM and not subsequently
   removed.  In effect, this method does a depth first traversal of the
   \"cached subtree\" rooted at this node, calling flushSpi() on each node in
   the subTree while only that node is locked. Note that flushSpi() is
   invoked top-down.

    If this method is invoked on a node that has been removed with
   the removeNode() method, flushSpi() is invoked on this node,
   but not on others.

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  ([^AbstractPreferences this]
    (-> this (.flush))))

(defn to-string
  "Returns the absolute path name of this preferences node.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^AbstractPreferences this]
    (-> this (.toString))))

(defn put-float
  "Implements the putFloat method as per the specification in
   Preferences.putFloat(String,float).

   This implementation translates value to a string with
   Float.toString(float) and invokes put(String,String)
   on the result.

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `float`

  throws: java.lang.NullPointerException - if key is null."
  ([^AbstractPreferences this ^java.lang.String key ^Float value]
    (-> this (.putFloat key value))))

(defn add-node-change-listener
  "Description copied from class: Preferences

  ncl - The NodeChangeListener to add. - `java.util.prefs.NodeChangeListener`"
  ([^AbstractPreferences this ^java.util.prefs.NodeChangeListener ncl]
    (-> this (.addNodeChangeListener ncl))))

(defn put-byte-array
  "Implements the putByteArray method as per the specification in
   Preferences.putByteArray(String,byte[]).

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `byte[]`

  throws: java.lang.NullPointerException - if key or value is null."
  ([^AbstractPreferences this ^java.lang.String key value]
    (-> this (.putByteArray key value))))

(defn name
  "Implements the name method as per the specification in
   Preferences.name().

   This implementation merely returns the name that was
   passed to this node's constructor.

  returns: this preference node's name, relative to its parent. - `java.lang.String`"
  (^java.lang.String [^AbstractPreferences this]
    (-> this (.name))))

(defn get-long
  "Implements the getLong method as per the specification in
   Preferences.getLong(String,long).

   This implementation invokes get(key,
   null).  If the return value is non-null, the implementation
   attempts to translate it to a long with
   Long.parseLong(String).  If the attempt succeeds, the return
   value is returned by this method.  Otherwise, def is returned.

  key - key whose associated value is to be returned as a long. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as a long. - `long`

  returns: the long value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           a long. - `long`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^Long [^AbstractPreferences this ^java.lang.String key ^Long def]
    (-> this (.getLong key def))))

(defn sync
  "Implements the sync method as per the specification in
   Preferences.sync().

   This implementation calls a recursive helper method that locks this
   node, invokes syncSpi() on it, unlocks this node, and recursively
   invokes this method on each \"cached child.\"  A cached child is a child
   of this node that has been created in this VM and not subsequently
   removed.  In effect, this method does a depth first traversal of the
   \"cached subtree\" rooted at this node, calling syncSpi() on each node in
   the subTree while only that node is locked. Note that syncSpi() is
   invoked top-down.

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  ([^AbstractPreferences this]
    (-> this (.sync))))

(defn get-int
  "Implements the getInt method as per the specification in
   Preferences.getInt(String,int).

   This implementation invokes get(key,
   null).  If the return value is non-null, the implementation
   attempts to translate it to an int with
   Integer.parseInt(String).  If the attempt succeeds, the return
   value is returned by this method.  Otherwise, def is returned.

  key - key whose associated value is to be returned as an int. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as an int. - `int`

  returns: the int value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           an int. - `int`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^Integer [^AbstractPreferences this ^java.lang.String key ^Integer def]
    (-> this (.getInt key def))))

(defn remove-node
  "Implements the removeNode() method as per the specification in
   Preferences.removeNode().

   This implementation checks to see that this node is the root; if so,
   it throws an appropriate exception.  Then, it locks this node's parent,
   and calls a recursive helper method that traverses the subtree rooted at
   this node.  The recursive method locks the node on which it was called,
   checks that it has not already been removed, and then ensures that all
   of its children are cached: The childrenNamesSpi() method is
   invoked and each returned child name is checked for containment in the
   child-cache.  If a child is not already cached, the childSpi(String) method is invoked to create a Preferences
   instance for it, and this instance is put into the child-cache.  Then
   the helper method calls itself recursively on each node contained in its
   child-cache.  Next, it invokes removeNodeSpi(), marks itself
   as removed, and removes itself from its parent's child-cache.  Finally,
   if there are any node change listeners, it enqueues a notification
   event for processing by the event dispatch thread.

   Note that the helper method is always invoked with all ancestors up
   to the \"closest non-removed ancestor\" locked.

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has already been removed with the removeNode() method."
  ([^AbstractPreferences this]
    (-> this (.removeNode))))

(defn put-double
  "Implements the putDouble method as per the specification in
   Preferences.putDouble(String,double).

   This implementation translates value to a string with
   Double.toString(double) and invokes put(String,String)
   on the result.

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `double`

  throws: java.lang.NullPointerException - if key is null."
  ([^AbstractPreferences this ^java.lang.String key ^Double value]
    (-> this (.putDouble key value))))

(defn remove
  "Implements the remove(String) method as per the specification
   in Preferences.remove(String).

   This implementation obtains this preference node's lock,
   checks that the node has not been removed, invokes
   removeSpi(String) and if there are any preference
   change listeners, enqueues a notification event for processing by the
   event dispatch thread.

  key - key whose mapping is to be removed from the preference node. - `java.lang.String`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  ([^AbstractPreferences this ^java.lang.String key]
    (-> this (.remove key))))

(defn add-preference-change-listener
  "Description copied from class: Preferences

  pcl - The preference change listener to add. - `java.util.prefs.PreferenceChangeListener`"
  ([^AbstractPreferences this ^java.util.prefs.PreferenceChangeListener pcl]
    (-> this (.addPreferenceChangeListener pcl))))

(defn export-subtree
  "Implements the exportSubtree method as per the specification in
   Preferences.exportSubtree(OutputStream).

  os - the output stream on which to emit the XML document. - `java.io.OutputStream`

  throws: java.io.IOException - if writing to the specified output stream results in an IOException."
  ([^AbstractPreferences this ^java.io.OutputStream os]
    (-> this (.exportSubtree os))))

(defn user-node?
  "Implements the isUserNode method as per the specification in
   Preferences.isUserNode().

   This implementation compares this node's root node (which is stored
   in a private field) with the value returned by
   Preferences.userRoot().  If the two object references are
   identical, this method returns true.

  returns: true if this preference node is in the user
           preference tree, false if it's in the system
           preference tree. - `boolean`"
  (^Boolean [^AbstractPreferences this]
    (-> this (.isUserNode))))

(defn remove-preference-change-listener
  "Description copied from class: Preferences

  pcl - The preference change listener to remove. - `java.util.prefs.PreferenceChangeListener`"
  ([^AbstractPreferences this ^java.util.prefs.PreferenceChangeListener pcl]
    (-> this (.removePreferenceChangeListener pcl))))

(defn get-byte-array
  "Implements the getByteArray method as per the specification in
   Preferences.getByteArray(String,byte[]).

  key - key whose associated value is to be returned as a byte array. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as a byte array. - `byte[]`

  returns: the byte array value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           a byte array. - `byte[]`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  ([^AbstractPreferences this ^java.lang.String key def]
    (-> this (.getByteArray key def))))

(defn get-boolean?
  "Implements the getBoolean method as per the specification in
   Preferences.getBoolean(String,boolean).

   This implementation invokes get(key,
   null).  If the return value is non-null, it is compared with
   \"true\" using String.equalsIgnoreCase(String).  If the
   comparison returns true, this invocation returns
   true.  Otherwise, the original return value is compared with
   \"false\", again using String.equalsIgnoreCase(String).
   If the comparison returns true, this invocation returns
   false.  Otherwise, this invocation returns def.

  key - key whose associated value is to be returned as a boolean. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as a boolean. - `boolean`

  returns: the boolean value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           a boolean. - `boolean`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^Boolean [^AbstractPreferences this ^java.lang.String key ^Boolean def]
    (-> this (.getBoolean key def))))

(defn clear
  "Implements the clear method as per the specification in
   Preferences.clear().

   This implementation obtains this preference node's lock,
   invokes keys() to obtain an array of keys, and
   iterates over the array invoking remove(String) on each key.

  throws: java.util.prefs.BackingStoreException - if this operation cannot be completed due to a failure in the backing store, or inability to communicate with it."
  ([^AbstractPreferences this]
    (-> this (.clear))))

(defn get-float
  "Implements the getFloat method as per the specification in
   Preferences.getFloat(String,float).

   This implementation invokes get(key,
   null).  If the return value is non-null, the implementation
   attempts to translate it to an float with
   Float.parseFloat(String).  If the attempt succeeds, the return
   value is returned by this method.  Otherwise, def is returned.

  key - key whose associated value is to be returned as a float. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as a float. - `float`

  returns: the float value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           a float. - `float`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^Float [^AbstractPreferences this ^java.lang.String key ^Float def]
    (-> this (.getFloat key def))))

(defn get-double
  "Implements the getDouble method as per the specification in
   Preferences.getDouble(String,double).

   This implementation invokes get(key,
   null).  If the return value is non-null, the implementation
   attempts to translate it to an double with
   Double.parseDouble(String).  If the attempt succeeds, the return
   value is returned by this method.  Otherwise, def is returned.

  key - key whose associated value is to be returned as a double. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key or the associated value cannot be interpreted as a double. - `double`

  returns: the double value represented by the string associated with
           key in this preference node, or def if the
           associated value does not exist or cannot be interpreted as
           a double. - `double`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^Double [^AbstractPreferences this ^java.lang.String key ^Double def]
    (-> this (.getDouble key def))))

(defn put-long
  "Implements the putLong method as per the specification in
   Preferences.putLong(String,long).

   This implementation translates value to a string with
   Long.toString(long) and invokes put(String,String)
   on the result.

  key - key with which the string form of value is to be associated. - `java.lang.String`
  value - value whose string form is to be associated with key. - `long`

  throws: java.lang.NullPointerException - if key is null."
  ([^AbstractPreferences this ^java.lang.String key ^Long value]
    (-> this (.putLong key value))))

(defn get
  "Implements the get method as per the specification in
   Preferences.get(String,String).

   This implementation first checks to see if key is
   null throwing a NullPointerException if this is
   the case.  Then it obtains this preference node's lock,
   checks that the node has not been removed, invokes getSpi(String), and returns the result, unless the getSpi
   invocation returns null or throws an exception, in which case
   this invocation returns def.

  key - key whose associated value is to be returned. - `java.lang.String`
  def - the value to be returned in the event that this preference node has no value associated with key. - `java.lang.String`

  returns: the value associated with key, or def
           if no value is associated with key. - `java.lang.String`

  throws: java.lang.IllegalStateException - if this node (or an ancestor) has been removed with the removeNode() method."
  (^java.lang.String [^AbstractPreferences this ^java.lang.String key ^java.lang.String def]
    (-> this (.get key def))))

(defn remove-node-change-listener
  "Description copied from class: Preferences

  ncl - The NodeChangeListener to remove. - `java.util.prefs.NodeChangeListener`"
  ([^AbstractPreferences this ^java.util.prefs.NodeChangeListener ncl]
    (-> this (.removeNodeChangeListener ncl))))

(defn node
  "Implements the node method as per the specification in
   Preferences.node(String).

   This implementation obtains this preference node's lock and checks
   that the node has not been removed.  If path is \"\",
   this node is returned; if path is \"/\", this node's
   root is returned.  If the first character in path is
   not '/', the implementation breaks path into
   tokens and recursively traverses the path from this node to the
   named node, \"consuming\" a name and a slash from path at
   each step of the traversal.  At each step, the current node is locked
   and the node's child-cache is checked for the named node.  If it is
   not found, the name is checked to make sure its length does not
   exceed MAX_NAME_LENGTH.  Then the childSpi(String)
   method is invoked, and the result stored in this node's child-cache.
   If the newly created Preferences object's newNode
   field is true and there are any node change listeners,
   a notification event is enqueued for processing by the event dispatch
   thread.

   When there are no more tokens, the last value found in the
   child-cache or returned by childSpi is returned by this
   method.  If during the traversal, two \"/\" tokens occur
   consecutively, or the final token is \"/\" (rather than a name),
   an appropriate IllegalArgumentException is thrown.

    If the first character of path is '/'
   (indicating an absolute path name) this preference node's
   lock is dropped prior to breaking path into tokens, and
   this method recursively traverses the path starting from the root
   (rather than starting from this node).  The traversal is otherwise
   identical to the one described for relative path names.  Dropping
   the lock on this node prior to commencing the traversal at the root
   node is essential to avoid the possibility of deadlock, as per the
   locking invariant.

  path - the path name of the preference node to return. - `java.lang.String`

  returns: the specified preference node. - `java.util.prefs.Preferences`

  throws: java.lang.IllegalArgumentException - if the path name is invalid (i.e., it contains multiple consecutive slash characters, or ends with a slash character and is more than one character long)."
  (^java.util.prefs.Preferences [^AbstractPreferences this ^java.lang.String path]
    (-> this (.node path))))

