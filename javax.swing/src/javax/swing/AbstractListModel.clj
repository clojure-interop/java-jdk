(ns javax.swing.AbstractListModel
  "The abstract definition for the data model that provides
  a List with its contents.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing AbstractListModel]))

(defn ->abstract-list-model
  "Constructor."
  ([]
    (new AbstractListModel )))

(defn add-list-data-listener
  "Adds a listener to the list that's notified each time a change
   to the data model occurs.

  l - the ListDataListener to be added - `javax.swing.event.ListDataListener`"
  ([^javax.swing.AbstractListModel this ^javax.swing.event.ListDataListener l]
    (-> this (.addListDataListener l))))

(defn remove-list-data-listener
  "Removes a listener from the list that's notified each time a
   change to the data model occurs.

  l - the ListDataListener to be removed - `javax.swing.event.ListDataListener`"
  ([^javax.swing.AbstractListModel this ^javax.swing.event.ListDataListener l]
    (-> this (.removeListDataListener l))))

(defn get-list-data-listeners
  "Returns an array of all the list data listeners
   registered on this AbstractListModel.

  returns: all of this model's ListDataListeners,
           or an empty array if no list data listeners
           are currently registered - `javax.swing.event.ListDataListener[]`"
  ([^javax.swing.AbstractListModel this]
    (-> this (.getListDataListeners))))

(defn get-listeners
  "Returns an array of all the objects currently registered as
   FooListeners
   upon this model.
   FooListeners
   are registered using the addFooListener method.

   You can specify the listenerType argument
   with a class literal, such as FooListener.class.
   For example, you can query a list model
   m
   for its list data listeners
   with the following code:



  ListDataListener[] ldls = (ListDataListener[])(m.getListeners(ListDataListener.class));

   If no such listeners exist,
   this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners
            on this model,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^javax.swing.AbstractListModel this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

