(ns jdk.rmi.activation.ActivationMonitor
  "An ActivationMonitor is specific to an
  ActivationGroup and is obtained when a group is
  reported active via a call to
  ActivationSystem.activeGroup (this is done
  internally). An activation group is responsible for informing its
  ActivationMonitor when either: its objects become active or
  inactive, or the group as a whole becomes inactive."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivationMonitor]))

(defn inactive-object
  "An activation group calls its monitor's
   inactiveObject method when an object in its group
   becomes inactive (deactivates).  An activation group discovers
   that an object (that it participated in activating) in its VM
   is no longer active, via calls to the activation group's
   inactiveObject method.

   The inactiveObject call informs the
   ActivationMonitor that the remote object reference
   it holds for the object with the activation identifier,
   id, is no longer valid. The monitor considers the
   reference associated with id as a stale reference.
   Since the reference is considered stale, a subsequent
   activate call for the same activation identifier
   results in re-activating the remote object.

  id - the object's activation identifier - `java.rmi.activation.ActivationID`

  throws: java.rmi.activation.UnknownObjectException - if object is unknown"
  ([this id]
    (-> this (.inactiveObject id))))

(defn active-object
  "Informs that an object is now active. An ActivationGroup
   informs its monitor if an object in its group becomes active by
   other means than being activated directly (i.e., the object
   is registered and `activated` itself).

  id - the active object's id - `java.rmi.activation.ActivationID`
  obj - the marshalled form of the object's stub - `java.rmi.Remote>`

  throws: java.rmi.activation.UnknownObjectException - if object is unknown"
  ([this id obj]
    (-> this (.activeObject id obj))))

(defn inactive-group
  "Informs that the group is now inactive. The group will be
   recreated upon a subsequent request to activate an object
   within the group. A group becomes inactive when all objects
   in the group report that they are inactive.

  id - the group's id - `java.rmi.activation.ActivationGroupID`
  incarnation - the group's incarnation number - `long`

  throws: java.rmi.activation.UnknownGroupException - if group is unknown"
  ([this id incarnation]
    (-> this (.inactiveGroup id incarnation))))

