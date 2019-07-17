(ns javax.swing.DefaultSingleSelectionModel
  "A generic implementation of SingleSelectionModel.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DefaultSingleSelectionModel]))

(defn ->default-single-selection-model
  "Constructor."
  ([]
    (new DefaultSingleSelectionModel )))

(defn get-selected-index
  "Description copied from interface: SingleSelectionModel

  returns: the model's selection, or -1 if there is no selection - `int`"
  (^Integer [^javax.swing.DefaultSingleSelectionModel this]
    (-> this (.getSelectedIndex))))

(defn set-selected-index
  "Description copied from interface: SingleSelectionModel

  index - an int specifying the model selection - `int`"
  ([^javax.swing.DefaultSingleSelectionModel this ^Integer index]
    (-> this (.setSelectedIndex index))))

(defn clear-selection
  "Description copied from interface: SingleSelectionModel"
  ([^javax.swing.DefaultSingleSelectionModel this]
    (-> this (.clearSelection))))

(defn selected?
  "Description copied from interface: SingleSelectionModel

  returns: true if a value is currently selected - `boolean`"
  (^Boolean [^javax.swing.DefaultSingleSelectionModel this]
    (-> this (.isSelected))))

(defn add-change-listener
  "Adds a ChangeListener to the button.

  l - the ChangeListener to add - `javax.swing.event.ChangeListener`"
  ([^javax.swing.DefaultSingleSelectionModel this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn remove-change-listener
  "Removes a ChangeListener from the button.

  l - the ChangeListener to remove - `javax.swing.event.ChangeListener`"
  ([^javax.swing.DefaultSingleSelectionModel this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn get-change-listeners
  "Returns an array of all the change listeners
   registered on this DefaultSingleSelectionModel.

  returns: all of this model's ChangeListeners
           or an empty
           array if no change listeners are currently registered - `javax.swing.event.ChangeListener[]`"
  ([^javax.swing.DefaultSingleSelectionModel this]
    (-> this (.getChangeListeners))))

(defn get-listeners
  "Returns an array of all the objects currently registered as
   FooListeners
   upon this model.
   FooListeners
   are registered using the addFooListener method.

   You can specify the listenerType argument
   with a class literal, such as FooListener.class.
   For example, you can query a DefaultSingleSelectionModel
   instance m
   for its change listeners
   with the following code:



  ChangeListener[] cls = (ChangeListener[])(m.getListeners(ChangeListener.class));

   If no such listeners exist,
   this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners
            on this model,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^javax.swing.DefaultSingleSelectionModel this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

