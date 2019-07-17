(ns jdk.awt.dnd.Autoscroll
  "During DnD operations it is possible that a user may wish to drop the
  subject of the operation on a region of a scrollable GUI control that is
  not currently visible to the user.

  In such situations it is desirable that the GUI control detect this
  and institute a scroll operation in order to make obscured region(s)
  visible to the user. This feature is known as autoscrolling.

  If a GUI control is both an active DropTarget
  and is also scrollable, it
  can receive notifications of autoscrolling gestures by the user from
  the DnD system by implementing this interface.

  An autoscrolling gesture is initiated by the user by keeping the drag
  cursor motionless with a border region of the Component,
  referred to as
  the `autoscrolling region`, for a predefined period of time, this will
  result in repeated scroll requests to the Component
  until the drag Cursor resumes its motion."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd Autoscroll]))

(defn get-autoscroll-insets
  "This method returns the Insets describing
   the autoscrolling region or border relative
   to the geometry of the implementing Component.

   This value is read once by the DropTarget
   upon entry of the drag Cursor
   into the associated Component.

  returns: the Insets - `java.awt.Insets`"
  ([this]
    (-> this (.getAutoscrollInsets))))

(defn autoscroll
  "notify the Component to autoscroll

  cursor-locn - A Point indicating the location of the cursor that triggered this operation. - `java.awt.Point`"
  ([this cursor-locn]
    (-> this (.autoscroll cursor-locn))))

