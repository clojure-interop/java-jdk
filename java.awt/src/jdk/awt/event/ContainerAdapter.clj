(ns jdk.awt.event.ContainerAdapter
  "An abstract adapter class for receiving container events.
  The methods in this class are empty. This class exists as
  convenience for creating listener objects.

  Extend this class to create a ContainerEvent listener
  and override the methods for the events of interest. (If you implement the
  ContainerListener interface, you have to define all of
  the methods in it. This abstract class defines null methods for them
  all, so you can only have to define methods for events you care about.)

  Create a listener object using the extended class and then register it with
  a component using the component's addContainerListener
  method. When the container's contents change because a component has
  been added or removed, the relevant method in the listener object is invoked,
  and the ContainerEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event ContainerAdapter]))

(defn ->container-adapter
  "Constructor."
  ([]
    (new ContainerAdapter )))

(defn component-added
  "Invoked when a component has been added to the container.

  e - `java.awt.event.ContainerEvent`"
  ([this e]
    (-> this (.componentAdded e))))

(defn component-removed
  "Invoked when a component has been removed from the container.

  e - `java.awt.event.ContainerEvent`"
  ([this e]
    (-> this (.componentRemoved e))))

