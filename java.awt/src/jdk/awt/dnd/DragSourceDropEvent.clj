(ns jdk.awt.dnd.DragSourceDropEvent
  "The DragSourceDropEvent is delivered
  from the DragSourceContextPeer,
  via the DragSourceContext, to the dragDropEnd
  method of DragSourceListeners registered with that
  DragSourceContext and with its associated
  DragSource.
  It contains sufficient information for the
  originator of the operation
  to provide appropriate feedback to the end user
  when the operation completes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DragSourceDropEvent]))

(defn ->drag-source-drop-event
  "Constructor.

  Construct a DragSourceDropEvent for a drop, given the
   DragSourceContext, the drop action, a boolean
   indicating if the drop was successful, and coordinates.

   The argument action should be one of DnDConstants
   that represents a single action.
   This constructor does not throw any exception for invalid action.

  dsc - the DragSourceContext associated with this DragSourceDropEvent - `java.awt.dnd.DragSourceContext`
  action - the drop action - `int`
  success - a boolean indicating if the drop was successful - `boolean`
  x - the horizontal coordinate for the cursor location - `int`
  y - the vertical coordinate for the cursor location - `int`

  throws: java.lang.IllegalArgumentException - if dsc is null."
  ([dsc action success x y]
    (new DragSourceDropEvent dsc action success x y))
  ([dsc action success]
    (new DragSourceDropEvent dsc action success))
  ([dsc]
    (new DragSourceDropEvent dsc)))

(defn get-drop-success?
  "This method returns a boolean indicating
   if the drop was successful.

  returns: true if the drop target accepted the drop and
           successfully performed a drop action;
           false if the drop target rejected the drop or
           if the drop target accepted the drop, but failed to perform
           a drop action. - `boolean`"
  ([this]
    (-> this (.getDropSuccess))))

(defn get-drop-action
  "This method returns an int representing
   the action performed by the target on the subject of the drop.

  returns: the action performed by the target on the subject of the drop
           if the drop target accepted the drop and the target drop action
           is supported by the drag source; otherwise,
           DnDConstants.ACTION_NONE. - `int`"
  ([this]
    (-> this (.getDropAction))))

