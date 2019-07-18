(ns javax.swing.AbstractSpinnerModel
  "This class provides the ChangeListener part of the
  SpinnerModel interface that should be suitable for most concrete SpinnerModel
  implementations.  Subclasses must provide an implementation of the
  setValue, getValue, getNextValue and
  getPreviousValue methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing AbstractSpinnerModel]))

(defn ->abstract-spinner-model
  "Constructor."
  (^AbstractSpinnerModel []
    (new AbstractSpinnerModel )))

(defn add-change-listener
  "Adds a ChangeListener to the model's listener list.  The
   ChangeListeners must be notified when the models value changes.

  l - the ChangeListener to add - `javax.swing.event.ChangeListener`"
  ([^AbstractSpinnerModel this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn remove-change-listener
  "Removes a ChangeListener from the model's listener list.

  l - the ChangeListener to remove - `javax.swing.event.ChangeListener`"
  ([^AbstractSpinnerModel this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn get-change-listeners
  "Returns an array of all the ChangeListeners added
   to this AbstractSpinnerModel with addChangeListener().

  returns: all of the ChangeListeners added or an empty
           array if no listeners have been added - `javax.swing.event.ChangeListener[]`"
  ([^AbstractSpinnerModel this]
    (-> this (.getChangeListeners))))

(defn get-listeners
  "Return an array of all the listeners of the given type that
   were added to this model.  For example to find all of the
   ChangeListeners added to this model:


   myAbstractSpinnerModel.getListeners(ChangeListener.class);

  listener-type - the type of listeners to return, e.g. ChangeListener.class - `java.lang.Class`

  returns: all of the objects receiving listenerType notifications
           from this model - `<T extends java.util.EventListener> T[]`"
  ([^AbstractSpinnerModel this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

