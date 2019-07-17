(ns jdk.beans.beancontext.BeanContextSupport
  "This helper class provides a utility implementation of the
  java.beans.beancontext.BeanContext interface.

  Since this class directly implements the BeanContext interface, the class
  can, and is intended to be used either by subclassing this implementation,
  or via ad-hoc delegation of an instance of this class from another."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextSupport]))

(defn ->bean-context-support
  "Constructor.

  Construct a BeanContextSupport instance

  peer - The peer BeanContext we are supplying an implementation for, or null if this object is its own peer - `java.beans.beancontext.BeanContext`
  lcle - The current Locale for this BeanContext. If lcle is null, the default locale is assigned to the BeanContext instance. - `java.util.Locale`
  d-time - The initial state, true if in design mode, false if runtime. - `boolean`
  visible - The initial visibility. - `boolean`"
  ([peer lcle d-time visible]
    (new BeanContextSupport peer lcle d-time visible))
  ([peer lcle dtime]
    (new BeanContextSupport peer lcle dtime))
  ([peer lcle]
    (new BeanContextSupport peer lcle))
  ([peer]
    (new BeanContextSupport peer))
  ([]
    (new BeanContextSupport )))

(defn add-all
  "add Collection to set of Children (Unsupported)
   implementations must synchronized on the hierarchy lock and `children` protected field

  c - collection containing elements to be added to this collection - `java.util.Collection`

  returns: this implementation unconditionally throws UnsupportedOperationException - `boolean`

  throws: java.lang.UnsupportedOperationException - thrown unconditionally by this implementation"
  ([this c]
    (-> this (.addAll c))))

(defn get-bean-context-peer
  "Gets the instance of BeanContext that
   this object is providing the implementation for.

  returns: the BeanContext instance - `java.beans.beancontext.BeanContext`"
  ([this]
    (-> this (.getBeanContextPeer))))

(defn needs-gui
  "This method is typically called from the environment in order to determine
   if the implementor `needs` a GUI.


   The algorithm used herein tests the BeanContextPeer, and its current children
   to determine if they are either Containers, Components, or if they implement
   Visibility and return needsGui() == true.

  returns: true if the implementor needs a GUI - `boolean`"
  ([this]
    (-> this (.needsGui))))

(defn write-children
  "Used to serialize all children of
   this BeanContext.

  oos - the ObjectOutputStream to use during serialization - `java.io.ObjectOutputStream`

  throws: java.io.IOException - if serialization failed"
  ([this oos]
    (-> this (.writeChildren oos))))

(defn get-resource
  "Description copied from interface: BeanContext

  name - the name of the resource requested. - `java.lang.String`
  bcc - the child object making the request. - `java.beans.beancontext.BeanContextChild`

  returns: the requested resource as an InputStream - `java.net.URL`"
  ([this name bcc]
    (-> this (.getResource name bcc))))

(defn avoiding-gui
  "Used to determine if the BeanContext
   child is avoiding using its GUI.

  returns: is this instance avoiding using its GUI? - `boolean`"
  ([this]
    (-> this (.avoidingGui))))

(defn get-resource-as-stream
  "Description copied from interface: BeanContext

  name - the name of the resource requested. - `java.lang.String`
  bcc - the child object making the request. - `java.beans.beancontext.BeanContextChild`

  returns: the requested resource as an InputStream - `java.io.InputStream`

  throws: java.lang.NullPointerException - if the argument is null"
  ([this name bcc]
    (-> this (.getResourceAsStream name bcc))))

(defn add-bean-context-membership-listener
  "Adds a BeanContextMembershipListener

  bcml - the BeanContextMembershipListener to add - `java.beans.beancontext.BeanContextMembershipListener`

  throws: java.lang.NullPointerException - if the argument is null"
  ([this bcml]
    (-> this (.addBeanContextMembershipListener bcml))))

(defn contains
  "Determines whether or not the specified object
   is currently a child of this BeanContext.

  o - the Object in question - `java.lang.Object`

  returns: if this object is a child - `boolean`"
  ([this o]
    (-> this (.contains o))))

(defn set-design-time
  "Sets the new design time value for this BeanContext.

  d-time - the new designTime value - `boolean`"
  ([this d-time]
    (-> this (.setDesignTime d-time))))

(defn ok-to-use-gui
  "Notify this instance that it may now render a GUI"
  ([this]
    (-> this (.okToUseGui))))

(defn get-locale
  "Gets the locale for this BeanContext.

  returns: the current Locale of the BeanContext - `java.util.Locale`"
  ([this]
    (-> this (.getLocale))))

(defn instantiate-child
  "The instantiateChild method is a convenience hook
   in BeanContext to simplify
   the task of instantiating a Bean, nested,
   into a BeanContext.


   The semantics of the beanName parameter are defined by java.beans.Beans.instantiate.

  bean-name - the name of the Bean to instantiate within this BeanContext - `java.lang.String`

  returns: the new object - `java.lang.Object`

  throws: java.io.IOException - if there is an I/O error when the bean is being deserialized"
  ([this bean-name]
    (-> this (.instantiateChild bean-name))))

(defn iterator
  "Gets all JavaBean or BeanContext instances
   currently nested in this BeanContext.

  returns: an Iterator of the nested children - `java.util.Iterator`"
  ([this]
    (-> this (.iterator))))

(defn dont-use-gui
  "notify this instance that it may no longer render a GUI."
  ([this]
    (-> this (.dontUseGui))))

(defn property-change
  "subclasses may envelope to monitor child property changes.

  pce - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([this pce]
    (-> this (.propertyChange pce))))

(defn remove
  "Removes a child from this BeanContext.  If the child object is not
   for adding then this method throws an IllegalStateException.

  target-child - The child objects to remove - `java.lang.Object`

  returns: true if an element was removed as a result of this call - `boolean`"
  ([this target-child]
    (-> this (.remove target-child))))

(defn set-locale
  "Sets the locale of this BeanContext.

  new-locale - the new locale. This method call will have no effect if newLocale is null. - `java.util.Locale`

  throws: java.beans.PropertyVetoException - if the new value is rejected"
  ([this new-locale]
    (-> this (.setLocale new-locale))))

(defn serializing?
  "Is this BeanContext in the
   process of being serialized?

  returns: if this BeanContext is
   currently being serialized - `boolean`"
  ([this]
    (-> this (.isSerializing))))

(defn remove-bean-context-membership-listener
  "Removes a BeanContextMembershipListener

  bcml - the BeanContextMembershipListener to remove - `java.beans.beancontext.BeanContextMembershipListener`

  throws: java.lang.NullPointerException - if the argument is null"
  ([this bcml]
    (-> this (.removeBeanContextMembershipListener bcml))))

(defn add
  "Adds/nests a child within this BeanContext.

   Invoked as a side effect of java.beans.Beans.instantiate().
   If the child object is not valid for adding then this method
   throws an IllegalStateException.

  target-child - The child objects to nest within this BeanContext - `java.lang.Object`

  returns: true if the child was added successfully. - `boolean`"
  ([this target-child]
    (-> this (.add target-child))))

(defn empty?
  "Reports whether or not this
   BeanContext is empty.
   A BeanContext is considered
   empty when it contains zero
   nested children.

  returns: if there are not children - `boolean`"
  ([this]
    (-> this (.isEmpty))))

(defn size
  "Gets the number of children currently nested in
   this BeanContext.

  returns: number of children - `int`"
  ([this]
    (-> this (.size))))

(defn retain-all
  "retain only specified children (Unsupported)
   implementations must synchronized on the hierarchy lock and `children` protected field

  c - collection containing elements to be retained in this collection - `java.util.Collection`

  returns: this implementation unconditionally throws UnsupportedOperationException - `boolean`

  throws: java.lang.UnsupportedOperationException - thrown unconditionally by this implementation"
  ([this c]
    (-> this (.retainAll c))))

(defn clear
  "clear the children (Unsupported)
   implementations must synchronized on the hierarchy lock and `children` protected field

  throws: java.lang.UnsupportedOperationException - thrown unconditionally by this implementation"
  ([this]
    (-> this (.clear))))

(defn to-array
  "Gets an array containing all children of
   this BeanContext that match
   the types contained in arry.

  arry - The array of object types that are of interest. - `java.lang.Object[]`

  returns: an array of children - `java.lang.Object[]`"
  ([this arry]
    (-> this (.toArray arry)))
  ([this]
    (-> this (.toArray))))

(defn contains-key
  "Determines whether or not the specified object
   is currently a child of this BeanContext.

  o - the Object in question - `java.lang.Object`

  returns: if this object is a child - `boolean`"
  ([this o]
    (-> this (.containsKey o))))

(defn remove-all
  "remove all specified children (Unsupported)
   implementations must synchronized on the hierarchy lock and `children` protected field

  c - collection containing elements to be removed from this collection - `java.util.Collection`

  returns: this implementation unconditionally throws UnsupportedOperationException - `boolean`

  throws: java.lang.UnsupportedOperationException - thrown unconditionally by this implementation"
  ([this c]
    (-> this (.removeAll c))))

(defn read-children
  "When an instance of this class is used as a delegate for the
   implementation of the BeanContext protocols (and its subprotocols)
   there exists a 'chicken and egg' problem during deserialization

  ois - the ObjectInputStream to use - `java.io.ObjectInputStream`

  throws: java.io.IOException - if deserialization failed"
  ([this ois]
    (-> this (.readChildren ois))))

(defn contains-all
  "Tests to see if all objects in the
   specified Collection are children of
   this BeanContext.

  c - the specified Collection - `java.util.Collection`

  returns: true if all objects
   in the collection are children of
   this BeanContext, false if not. - `boolean`"
  ([this c]
    (-> this (.containsAll c))))

(defn vetoable-change
  "subclasses may envelope to monitor veto child property changes.

  pce - a PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`

  throws: java.beans.PropertyVetoException - if the recipient wishes the property change to be rolled back."
  ([this pce]
    (-> this (.vetoableChange pce))))

(defn design-time?
  "Reports whether or not this object is in
   currently in design time mode.

  returns: true if in design time mode,
   false if not - `boolean`"
  ([this]
    (-> this (.isDesignTime))))

