(ns jdk.util.Observer
  "A class can implement the Observer interface when it
  wants to be informed of changes in observable objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Observer]))

(defn update
  "This method is called whenever the observed object is changed. An
   application calls an Observable object's
   notifyObservers method to have all the object's
   observers notified of the change.

  o - the observable object. - `java.util.Observable`
  arg - an argument passed to the notifyObservers method. - `java.lang.Object`"
  ([this o arg]
    (-> this (.update o arg))))

