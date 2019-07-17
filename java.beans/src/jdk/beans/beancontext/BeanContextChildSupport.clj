(ns jdk.beans.beancontext.BeanContextChildSupport
  " This is a general support class to provide support for implementing the
  BeanContextChild protocol.

  This class may either be directly subclassed, or encapsulated and delegated
  to in order to implement this interface for a given component."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextChildSupport]))

(defn ->bean-context-child-support
  "Constructor.

  construct a BeanContextChildSupport where the JavaBean component
   itself implements BeanContextChild, and encapsulates this, delegating
   that interface to this implementation

  bcc - the underlying bean context child - `java.beans.beancontext.BeanContextChild`"
  ([^java.beans.beancontext.BeanContextChild bcc]
    (new BeanContextChildSupport bcc))
  ([]
    (new BeanContextChildSupport )))

(defn -bean-context-child-peer
  "Instance Field.

  The BeanContext in which
   this BeanContextChild is nested.

  type: java.beans.beancontext.BeanContextChild"
  [this]
  (-> this .-beanContextChildPeer))

(defn fire-property-change
  "Report a bound property update to any registered listeners. No event is
   fired if old and new are equal and non-null.

  name - The programmatic name of the property that was changed - `java.lang.String`
  old-value - The old value of the property - `java.lang.Object`
  new-value - The new value of the property - `java.lang.Object`"
  ([^java.beans.beancontext.BeanContextChildSupport this ^java.lang.String name ^java.lang.Object old-value ^java.lang.Object new-value]
    (-> this (.firePropertyChange name old-value new-value))))

(defn fire-vetoable-change
  "Report a vetoable property update to any registered listeners.
   If anyone vetos the change, then fire a new event
   reverting everyone to the old value and then rethrow
   the PropertyVetoException.

   No event is fired if old and new are equal and non-null.

  name - The programmatic name of the property that is about to change - `java.lang.String`
  old-value - The old value of the property - `java.lang.Object`
  new-value - - The new value of the property - `java.lang.Object`

  throws: java.beans.PropertyVetoException - if the recipient wishes the property change to be rolled back."
  ([^java.beans.beancontext.BeanContextChildSupport this ^java.lang.String name ^java.lang.Object old-value ^java.lang.Object new-value]
    (-> this (.fireVetoableChange name old-value new-value))))

(defn validate-pending-set-bean-context
  "Called from setBeanContext to validate (or otherwise) the
   pending change in the nesting BeanContext property value.
   Returning false will cause setBeanContext to throw
   PropertyVetoException.

  new-value - the new value that has been requested for the BeanContext property - `java.beans.beancontext.BeanContext`

  returns: true if the change operation is to be vetoed - `boolean`"
  (^Boolean [^java.beans.beancontext.BeanContextChildSupport this ^java.beans.beancontext.BeanContext new-value]
    (-> this (.validatePendingSetBeanContext new-value))))

(defn remove-property-change-listener
  "Remove a PropertyChangeListener for a specific property.
   If pcl was added more than once to the same event
   source for the specified property, it will be notified one less time
   after being removed.
   If name is null, no exception is thrown
   and no action is taken.
   If pcl is null, or was never added for the specified
   property, no exception is thrown and no action is taken.

  name - The name of the property that was listened on - `java.lang.String`
  pcl - The PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([^java.beans.beancontext.BeanContextChildSupport this ^java.lang.String name ^java.beans.PropertyChangeListener pcl]
    (-> this (.removePropertyChangeListener name pcl))))

(defn delegated?
  "Reports whether or not this class is a delegate of another.

  returns: true if this class is a delegate of another - `boolean`"
  (^Boolean [^java.beans.beancontext.BeanContextChildSupport this]
    (-> this (.isDelegated))))

(defn set-bean-context
  "Sets the BeanContext for
   this BeanContextChildSupport.

  bc - the new value to be assigned to the BeanContext property - `java.beans.beancontext.BeanContext`

  throws: java.beans.PropertyVetoException - if the change is rejected"
  ([^java.beans.beancontext.BeanContextChildSupport this ^java.beans.beancontext.BeanContext bc]
    (-> this (.setBeanContext bc))))

(defn get-bean-context
  "Gets the nesting BeanContext
   for this BeanContextChildSupport.

  returns: the nesting BeanContext for
   this BeanContextChildSupport. - `java.beans.beancontext.BeanContext`"
  (^java.beans.beancontext.BeanContext [^java.beans.beancontext.BeanContextChildSupport this]
    (-> this (.getBeanContext))))

(defn remove-vetoable-change-listener
  "Removes a VetoableChangeListener.
   If pcl was added more than once to the same event
   source for the specified property, it will be notified one less time
   after being removed.
   If name is null, no exception is thrown
   and no action is taken.
   If vcl is null, or was never added for the specified
   property, no exception is thrown and no action is taken.

  name - The name of the property that was listened on - `java.lang.String`
  vcl - The VetoableChangeListener to be removed - `java.beans.VetoableChangeListener`"
  ([^java.beans.beancontext.BeanContextChildSupport this ^java.lang.String name ^java.beans.VetoableChangeListener vcl]
    (-> this (.removeVetoableChangeListener name vcl))))

(defn add-property-change-listener
  "Add a PropertyChangeListener for a specific property.
   The same listener object may be added more than once.  For each
   property,  the listener will be invoked the number of times it was added
   for that property.
   If name or pcl is null, no exception is thrown
   and no action is taken.

  name - The name of the property to listen on - `java.lang.String`
  pcl - The PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([^java.beans.beancontext.BeanContextChildSupport this ^java.lang.String name ^java.beans.PropertyChangeListener pcl]
    (-> this (.addPropertyChangeListener name pcl))))

(defn get-bean-context-child-peer
  "Gets the BeanContextChild associated with this
   BeanContextChildSupport.

  returns: the BeanContextChild peer of this class - `java.beans.beancontext.BeanContextChild`"
  (^java.beans.beancontext.BeanContextChild [^java.beans.beancontext.BeanContextChildSupport this]
    (-> this (.getBeanContextChildPeer))))

(defn service-available
  "A new service is available from the nesting BeanContext.

   Subclasses may override this method in order to implement their own
   behaviors

  bcsae - The BeanContextServiceAvailableEvent fired as a result of a service becoming available - `java.beans.beancontext.BeanContextServiceAvailableEvent`"
  ([^java.beans.beancontext.BeanContextChildSupport this ^java.beans.beancontext.BeanContextServiceAvailableEvent bcsae]
    (-> this (.serviceAvailable bcsae))))

(defn service-revoked
  "A service provided by the nesting BeanContext has been revoked.

   Subclasses may override this method in order to implement their own
   behaviors.

  bcsre - The BeanContextServiceRevokedEvent fired as a result of a service being revoked - `java.beans.beancontext.BeanContextServiceRevokedEvent`"
  ([^java.beans.beancontext.BeanContextChildSupport this ^java.beans.beancontext.BeanContextServiceRevokedEvent bcsre]
    (-> this (.serviceRevoked bcsre))))

(defn add-vetoable-change-listener
  "Add a VetoableChangeListener for a specific property.
   The same listener object may be added more than once.  For each
   property,  the listener will be invoked the number of times it was added
   for that property.
   If name or vcl is null, no exception is thrown
   and no action is taken.

  name - The name of the property to listen on - `java.lang.String`
  vcl - The VetoableChangeListener to be added - `java.beans.VetoableChangeListener`"
  ([^java.beans.beancontext.BeanContextChildSupport this ^java.lang.String name ^java.beans.VetoableChangeListener vcl]
    (-> this (.addVetoableChangeListener name vcl))))

