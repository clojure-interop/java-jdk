(ns jdk.beans.beancontext.BeanContextChild
  " JavaBeans wishing to be nested within, and obtain a reference to their
  execution environment, or context, as defined by the BeanContext
  sub-interface shall implement this interface.


  Conformant BeanContexts shall as a side effect of adding a BeanContextChild
  object shall pass a reference to itself via the setBeanContext() method of
  this interface.


  Note that a BeanContextChild may refuse a change in state by throwing
  PropertyVetoedException in response.


  In order for persistence mechanisms to function properly on BeanContextChild
  instances across a broad variety of scenarios, implementing classes of this
  interface are required to define as transient, any or all fields, or
  instance variables, that may contain, or represent, references to the
  nesting BeanContext instance or other resources obtained
  from the BeanContext via any unspecified mechanisms."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextChild]))

(defn set-bean-context
  "Objects that implement this interface,
   shall fire a java.beans.PropertyChangeEvent, with parameters:

   propertyName `beanContext`, oldValue (the previous nesting
   BeanContext instance, or null),
   newValue (the current nesting
   BeanContext instance, or null).

   A change in the value of the nesting BeanContext property of this
   BeanContextChild may be vetoed by throwing the appropriate exception.

  bc - The BeanContext with which to associate this BeanContextChild. - `java.beans.beancontext.BeanContext`

  throws: java.beans.PropertyVetoException - if the addition of the specified BeanContext is refused."
  ([^BeanContextChild this ^java.beans.beancontext.BeanContext bc]
    (-> this (.setBeanContext bc))))

(defn get-bean-context
  "Gets the BeanContext associated
   with this BeanContextChild.

  returns: the BeanContext associated
   with this BeanContextChild. - `java.beans.beancontext.BeanContext`"
  (^java.beans.beancontext.BeanContext [^BeanContextChild this]
    (-> this (.getBeanContext))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener
   to this BeanContextChild
   in order to receive a PropertyChangeEvent
   whenever the specified property has changed.

  name - the name of the property to listen on - `java.lang.String`
  pcl - the PropertyChangeListener to add - `java.beans.PropertyChangeListener`"
  ([^BeanContextChild this ^java.lang.String name ^java.beans.PropertyChangeListener pcl]
    (-> this (.addPropertyChangeListener name pcl))))

(defn remove-property-change-listener
  "Removes a PropertyChangeListener from this
   BeanContextChild  so that it no longer
   receives PropertyChangeEvents when the
   specified property is changed.

  name - the name of the property that was listened on - `java.lang.String`
  pcl - the PropertyChangeListener to remove - `java.beans.PropertyChangeListener`"
  ([^BeanContextChild this ^java.lang.String name ^java.beans.PropertyChangeListener pcl]
    (-> this (.removePropertyChangeListener name pcl))))

(defn add-vetoable-change-listener
  "Adds a VetoableChangeListener to
   this BeanContextChild
   to receive events whenever the specified property changes.

  name - the name of the property to listen on - `java.lang.String`
  vcl - the VetoableChangeListener to add - `java.beans.VetoableChangeListener`"
  ([^BeanContextChild this ^java.lang.String name ^java.beans.VetoableChangeListener vcl]
    (-> this (.addVetoableChangeListener name vcl))))

(defn remove-vetoable-change-listener
  "Removes a VetoableChangeListener from this
   BeanContextChild so that it no longer receives
   events when the specified property changes.

  name - the name of the property that was listened on. - `java.lang.String`
  vcl - the VetoableChangeListener to remove. - `java.beans.VetoableChangeListener`"
  ([^BeanContextChild this ^java.lang.String name ^java.beans.VetoableChangeListener vcl]
    (-> this (.removeVetoableChangeListener name vcl))))

