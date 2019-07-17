(ns jdk.awt.dnd.DragSourceDragEvent
  "The DragSourceDragEvent is
  delivered from the DragSourceContextPeer,
  via the DragSourceContext, to the DragSourceListener
  registered with that DragSourceContext and with its associated
  DragSource.

  The DragSourceDragEvent reports the target drop action
  and the user drop action that reflect the current state of
  the drag operation.

  Target drop action is one of DnDConstants that represents
  the drop action selected by the current drop target if this drop action is
  supported by the drag source or DnDConstants.ACTION_NONE if this
  drop action is not supported by the drag source.

  User drop action depends on the drop actions supported by the drag
  source and the drop action selected by the user. The user can select a drop
  action by pressing modifier keys during the drag operation:


    Ctrl  Shift -> ACTION_LINK
    Ctrl         -> ACTION_COPY
    Shift        -> ACTION_MOVE
  If the user selects a drop action, the user drop action is one of
  DnDConstants that represents the selected drop action if this
  drop action is supported by the drag source or
  DnDConstants.ACTION_NONE if this drop action is not supported
  by the drag source.

  If the user doesn't select a drop action, the set of
  DnDConstants that represents the set of drop actions supported
  by the drag source is searched for DnDConstants.ACTION_MOVE,
  then for DnDConstants.ACTION_COPY, then for
  DnDConstants.ACTION_LINK and the user drop action is the
  first constant found. If no constant is found the user drop action
  is DnDConstants.ACTION_NONE."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DragSourceDragEvent]))

(defn ->drag-source-drag-event
  "Constructor.

  Constructs a DragSourceDragEvent given the specified
   DragSourceContext, user drop action, target drop action,
   modifiers and coordinates.

   The arguments dropAction and action should
   be one of DnDConstants that represents a single action.
   The argument modifiers should be either a bitwise mask
   of old java.awt.event.InputEvent.*_MASK constants or a
   bitwise mask of extended java.awt.event.InputEvent.*_DOWN_MASK
   constants.
   This constructor does not throw any exception for invalid dropAction,
   action and modifiers.

  dsc - the DragSourceContext associated with this event. - `java.awt.dnd.DragSourceContext`
  drop-action - the user drop action. - `int`
  action - the target drop action. - `int`
  modifiers - the modifier keys down during event (shift, ctrl, alt, meta) Either extended _DOWN_MASK or old _MASK modifiers should be used, but both models should not be mixed in one event. Use of the extended modifiers is preferred. - `int`
  x - the horizontal coordinate for the cursor location - `int`
  y - the vertical coordinate for the cursor location - `int`

  throws: java.lang.IllegalArgumentException - if dsc is null."
  ([^java.awt.dnd.DragSourceContext dsc ^Integer drop-action ^Integer action ^Integer modifiers ^Integer x ^Integer y]
    (new DragSourceDragEvent dsc drop-action action modifiers x y))
  ([^java.awt.dnd.DragSourceContext dsc ^Integer drop-action ^Integer action ^Integer modifiers]
    (new DragSourceDragEvent dsc drop-action action modifiers)))

(defn get-target-actions
  "This method returns the target drop action.

  returns: the target drop action. - `int`"
  (^Integer [^java.awt.dnd.DragSourceDragEvent this]
    (-> this (.getTargetActions))))

(defn get-gesture-modifiers
  "This method returns an int representing
   the current state of the input device modifiers
   associated with the user's gesture. Typically these
   would be mouse buttons or keyboard modifiers.

   If the modifiers passed to the constructor
   are invalid, this method returns them unchanged.

  returns: the current state of the input device modifiers - `int`"
  (^Integer [^java.awt.dnd.DragSourceDragEvent this]
    (-> this (.getGestureModifiers))))

(defn get-gesture-modifiers-ex
  "This method returns an int representing
   the current state of the input device extended modifiers
   associated with the user's gesture.
   See InputEvent.getModifiersEx()

   If the modifiers passed to the constructor
   are invalid, this method returns them unchanged.

  returns: the current state of the input device extended modifiers - `int`"
  (^Integer [^java.awt.dnd.DragSourceDragEvent this]
    (-> this (.getGestureModifiersEx))))

(defn get-user-action
  "This method returns the user drop action.

  returns: the user drop action. - `int`"
  (^Integer [^java.awt.dnd.DragSourceDragEvent this]
    (-> this (.getUserAction))))

(defn get-drop-action
  "This method returns the logical intersection of
   the target drop action and the set of drop actions supported by
   the drag source.

  returns: the logical intersection of the target drop action and
           the set of drop actions supported by the drag source. - `int`"
  (^Integer [^java.awt.dnd.DragSourceDragEvent this]
    (-> this (.getDropAction))))

