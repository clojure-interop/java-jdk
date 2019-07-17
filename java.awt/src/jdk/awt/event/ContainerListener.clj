(ns jdk.awt.event.ContainerListener
  "The listener interface for receiving container events.
  The class that is interested in processing a container event
  either implements this interface (and all the methods it
  contains) or extends the abstract ContainerAdapter class
  (overriding only the methods of interest).
  The listener object created from that class is then registered with a
  component using the component's addContainerListener
  method. When the container's contents change because a component
  has been added or removed, the relevant method in the listener object
  is invoked, and the ContainerEvent is passed to it.

  Container events are provided for notification purposes ONLY;
  The AWT will automatically handle add and remove operations
  internally so the program works properly regardless of
  whether the program registers a ContainerListener or not."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event ContainerListener]))

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

