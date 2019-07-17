(ns jdk.awt.dnd.DropTarget
  "The DropTarget is associated
  with a Component when that Component
  wishes
  to accept drops during Drag and Drop operations.

   Each
  DropTarget is associated with a FlavorMap.
  The default FlavorMap hereafter designates the
  FlavorMap returned by SystemFlavorMap.getDefaultFlavorMap()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DropTarget]))

(defn ->drop-target
  "Constructor.

  Creates a new DropTarget given the Component
   to associate itself with, an int representing
   the default acceptable action(s) to
   support, a DropTargetListener
   to handle event processing, a boolean indicating
   if the DropTarget is currently accepting drops, and
   a FlavorMap to use (or null for the default FlavorMap).

   The Component will receive drops only if it is enabled.

  c - The Component with which this DropTarget is associated - `java.awt.Component`
  ops - The default acceptable actions for this DropTarget - `int`
  dtl - The DropTargetListener for this DropTarget - `java.awt.dnd.DropTargetListener`
  act - Is the DropTarget accepting drops. - `boolean`
  fm - The FlavorMap to use, or null for the default FlavorMap - `java.awt.datatransfer.FlavorMap`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([^java.awt.Component c ^Integer ops ^java.awt.dnd.DropTargetListener dtl ^Boolean act ^java.awt.datatransfer.FlavorMap fm]
    (new DropTarget c ops dtl act fm))
  ([^java.awt.Component c ^Integer ops ^java.awt.dnd.DropTargetListener dtl ^Boolean act]
    (new DropTarget c ops dtl act))
  ([^java.awt.Component c ^Integer ops ^java.awt.dnd.DropTargetListener dtl]
    (new DropTarget c ops dtl))
  ([^java.awt.Component c ^java.awt.dnd.DropTargetListener dtl]
    (new DropTarget c dtl))
  ([]
    (new DropTarget )))

(defn get-component
  "Gets the Component associated
   with this DropTarget.

  returns: the current Component - `java.awt.Component`"
  (^java.awt.Component [^java.awt.dnd.DropTarget this]
    (-> this (.getComponent))))

(defn active?
  "Reports whether or not
   this DropTarget
   is currently active (ready to accept drops).

  returns: true if active, false if not - `boolean`"
  (^Boolean [^java.awt.dnd.DropTarget this]
    (-> this (.isActive))))

(defn get-drop-target-context
  "Gets the DropTargetContext associated
   with this DropTarget.

  returns: the DropTargetContext associated with this DropTarget. - `java.awt.dnd.DropTargetContext`"
  (^java.awt.dnd.DropTargetContext [^java.awt.dnd.DropTarget this]
    (-> this (.getDropTargetContext))))

(defn get-flavor-map
  "Gets the FlavorMap
   associated with this DropTarget.
   If no FlavorMap has been set for this
   DropTarget, it is associated with the default
   FlavorMap.

  returns: the FlavorMap for this DropTarget - `java.awt.datatransfer.FlavorMap`"
  (^java.awt.datatransfer.FlavorMap [^java.awt.dnd.DropTarget this]
    (-> this (.getFlavorMap))))

(defn set-default-actions
  "Sets the default acceptable actions for this DropTarget

  ops - the default actions - `int`"
  ([^java.awt.dnd.DropTarget this ^Integer ops]
    (-> this (.setDefaultActions ops))))

(defn drag-exit
  "Calls dragExit on the registered
   DropTargetListener and passes it
   the specified DropTargetEvent.
   Has no effect if this DropTarget
   is not active.

   This method itself does not throw any exception
   for null parameter but for exceptions thrown by
   the respective method of the listener.

  dte - the DropTargetEvent - `java.awt.dnd.DropTargetEvent`"
  ([^java.awt.dnd.DropTarget this ^java.awt.dnd.DropTargetEvent dte]
    (-> this (.dragExit dte))))

(defn add-notify
  "Notify the DropTarget that it has been associated with a Component


   This method is usually called from java.awt.Component.addNotify() of
   the Component associated with this DropTarget to notify the DropTarget
   that a ComponentPeer has been associated with that Component.

   Calling this method, other than to notify this DropTarget of the
   association of the ComponentPeer with the Component may result in
   a malfunction of the DnD system.

  peer - The Peer of the Component we are associated with! - `java.awt.peer.ComponentPeer`"
  ([^java.awt.dnd.DropTarget this ^java.awt.peer.ComponentPeer peer]
    (-> this (.addNotify peer))))

(defn drop
  "Calls drop on the registered
   DropTargetListener and passes it
   the specified DropTargetDropEvent
   if this DropTarget is active.

  dtde - the DropTargetDropEvent - `java.awt.dnd.DropTargetDropEvent`

  throws: java.lang.NullPointerException - if dtde is null and at least one of the following is true: this DropTarget is not active, or there is no a DropTargetListener registered."
  ([^java.awt.dnd.DropTarget this ^java.awt.dnd.DropTargetDropEvent dtde]
    (-> this (.drop dtde))))

(defn get-default-actions
  "Gets an int representing the
   current action(s) supported by this DropTarget.

  returns: the current default actions - `int`"
  (^Integer [^java.awt.dnd.DropTarget this]
    (-> this (.getDefaultActions))))

(defn remove-notify
  "Notify the DropTarget that it has been disassociated from a Component


   This method is usually called from java.awt.Component.removeNotify() of
   the Component associated with this DropTarget to notify the DropTarget
   that a ComponentPeer has been disassociated with that Component.

   Calling this method, other than to notify this DropTarget of the
   disassociation of the ComponentPeer from the Component may result in
   a malfunction of the DnD system.

  peer - The Peer of the Component we are being disassociated from! - `java.awt.peer.ComponentPeer`"
  ([^java.awt.dnd.DropTarget this ^java.awt.peer.ComponentPeer peer]
    (-> this (.removeNotify peer))))

(defn set-flavor-map
  "Sets the FlavorMap associated
   with this DropTarget.

  fm - the new FlavorMap, or null to associate the default FlavorMap with this DropTarget. - `java.awt.datatransfer.FlavorMap`"
  ([^java.awt.dnd.DropTarget this ^java.awt.datatransfer.FlavorMap fm]
    (-> this (.setFlavorMap fm))))

(defn set-component
  "Note: this interface is required to permit the safe association
   of a DropTarget with a Component in one of two ways, either:
    component.setDropTarget(droptarget);
   or  droptarget.setComponent(component);

   The Component will receive drops only if it is enabled.

  c - The new Component this DropTarget is to be associated with. - `java.awt.Component`"
  ([^java.awt.dnd.DropTarget this ^java.awt.Component c]
    (-> this (.setComponent c))))

(defn drop-action-changed
  "Calls dropActionChanged on the registered
   DropTargetListener and passes it
   the specified DropTargetDragEvent.
   Has no effect if this DropTarget
   is not active.

  dtde - the DropTargetDragEvent - `java.awt.dnd.DropTargetDragEvent`

  throws: java.lang.NullPointerException - if this DropTarget is active and dtde is null"
  ([^java.awt.dnd.DropTarget this ^java.awt.dnd.DropTargetDragEvent dtde]
    (-> this (.dropActionChanged dtde))))

(defn drag-enter
  "Calls dragEnter on the registered
   DropTargetListener and passes it
   the specified DropTargetDragEvent.
   Has no effect if this DropTarget
   is not active.

  dtde - the DropTargetDragEvent - `java.awt.dnd.DropTargetDragEvent`

  throws: java.lang.NullPointerException - if this DropTarget is active and dtde is null"
  ([^java.awt.dnd.DropTarget this ^java.awt.dnd.DropTargetDragEvent dtde]
    (-> this (.dragEnter dtde))))

(defn add-drop-target-listener
  "Adds a new DropTargetListener (UNICAST SOURCE).

  dtl - The new DropTargetListener - `java.awt.dnd.DropTargetListener`

  throws: java.util.TooManyListenersException - if a DropTargetListener is already added to this DropTarget."
  ([^java.awt.dnd.DropTarget this ^java.awt.dnd.DropTargetListener dtl]
    (-> this (.addDropTargetListener dtl))))

(defn set-active
  "Sets the DropTarget active if true,
   inactive if false.

  is-active - sets the DropTarget (in)active. - `boolean`"
  ([^java.awt.dnd.DropTarget this ^Boolean is-active]
    (-> this (.setActive is-active))))

(defn drag-over
  "Calls dragOver on the registered
   DropTargetListener and passes it
   the specified DropTargetDragEvent.
   Has no effect if this DropTarget
   is not active.

  dtde - the DropTargetDragEvent - `java.awt.dnd.DropTargetDragEvent`

  throws: java.lang.NullPointerException - if this DropTarget is active and dtde is null"
  ([^java.awt.dnd.DropTarget this ^java.awt.dnd.DropTargetDragEvent dtde]
    (-> this (.dragOver dtde))))

(defn remove-drop-target-listener
  "Removes the current DropTargetListener (UNICAST SOURCE).

  dtl - the DropTargetListener to deregister. - `java.awt.dnd.DropTargetListener`"
  ([^java.awt.dnd.DropTarget this ^java.awt.dnd.DropTargetListener dtl]
    (-> this (.removeDropTargetListener dtl))))

