(ns jdk.util.Observable
  "This class represents an observable object, or `data`
  in the model-view paradigm. It can be subclassed to represent an
  object that the application wants to have observed.

  An observable object can have one or more observers. An observer
  may be any object that implements interface Observer. After an
  observable instance changes, an application calling the
  Observable's notifyObservers method
  causes all of its observers to be notified of the change by a call
  to their update method.

  The order in which notifications will be delivered is unspecified.
  The default implementation provided in the Observable class will
  notify Observers in the order in which they registered interest, but
  subclasses may change this order, use no guaranteed order, deliver
  notifications on separate threads, or may guarantee that their
  subclass follows this order, as they choose.

  Note that this notification mechanism has nothing to do with threads
  and is completely separate from the wait and notify
  mechanism of class Object.

  When an observable object is newly created, its set of observers is
  empty. Two observers are considered the same if and only if the
  equals method returns true for them."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Observable]))

(defn ->observable
  "Constructor.

  Construct an Observable with zero Observers."
  ([]
    (new Observable )))

(defn add-observer
  "Adds an observer to the set of observers for this object, provided
   that it is not the same as some observer already in the set.
   The order in which notifications will be delivered to multiple
   observers is not specified. See the class comment.

  o - an observer to be added. - `java.util.Observer`

  throws: java.lang.NullPointerException - if the parameter o is null."
  ([this o]
    (-> this (.addObserver o))))

(defn delete-observer
  "Deletes an observer from the set of observers of this object.
   Passing null to this method will have no effect.

  o - the observer to be deleted. - `java.util.Observer`"
  ([this o]
    (-> this (.deleteObserver o))))

(defn notify-observers
  "If this object has changed, as indicated by the
   hasChanged method, then notify all of its observers
   and then call the clearChanged method to indicate
   that this object has no longer changed.

   Each observer has its update method called with two
   arguments: this observable object and the arg argument.

  arg - any object. - `java.lang.Object`"
  ([this arg]
    (-> this (.notifyObservers arg)))
  ([this]
    (-> this (.notifyObservers))))

(defn delete-observers
  "Clears the observer list so that this object no longer has any observers."
  ([this]
    (-> this (.deleteObservers))))

(defn has-changed?
  "Tests if this object has changed.

  returns: true if and only if the setChanged
            method has been called more recently than the
            clearChanged method on this object;
            false otherwise. - `boolean`"
  ([this]
    (-> this (.hasChanged))))

(defn count-observers
  "Returns the number of observers of this Observable object.

  returns: the number of observers of this object. - `int`"
  ([this]
    (-> this (.countObservers))))

