(ns jdk.awt.event.PaintEvent
  "The component-level paint event.
  This event is a special type which is used to ensure that
  paint/update method calls are serialized along with the other
  events delivered from the event queue.  This event is not
  designed to be used with the Event Listener model; programs
  should continue to override paint/update methods in order
  render themselves properly.

  An unspecified behavior will be caused if the id parameter
  of any particular PaintEvent instance is not
  in the range from PAINT_FIRST to PAINT_LAST."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event PaintEvent]))

(defn ->paint-event
  "Constructor.

  Constructs a PaintEvent object with the specified
   source component and type.
    This method throws an
   IllegalArgumentException if source
   is null.

  source - The object where the event originated - `java.awt.Component`
  id - The integer that identifies the event type. For information on allowable values, see the class description for PaintEvent - `int`
  update-rect - The rectangle area which needs to be repainted - `java.awt.Rectangle`

  throws: java.lang.IllegalArgumentException - if source is null"
  ([source id update-rect]
    (new PaintEvent source id update-rect)))

(def *-paint-first
  "Static Constant.

  Marks the first integer id for the range of paint event ids.

  type: int"
  PaintEvent/PAINT_FIRST)

(def *-paint-last
  "Static Constant.

  Marks the last integer id for the range of paint event ids.

  type: int"
  PaintEvent/PAINT_LAST)

(def *-paint
  "Static Constant.

  The paint event type.

  type: int"
  PaintEvent/PAINT)

(def *-update
  "Static Constant.

  The update event type.

  type: int"
  PaintEvent/UPDATE)

(defn get-update-rect
  "Returns the rectangle representing the area which needs to be
   repainted in response to this event.

  returns: `java.awt.Rectangle`"
  ([this]
    (-> this (.getUpdateRect))))

(defn set-update-rect
  "Sets the rectangle representing the area which needs to be
   repainted in response to this event.

  update-rect - the rectangle area which needs to be repainted - `java.awt.Rectangle`"
  ([this update-rect]
    (-> this (.setUpdateRect update-rect))))

(defn param-string
  "Description copied from class: ComponentEvent

  returns: a string identifying the event and its attributes - `java.lang.String`"
  ([this]
    (-> this (.paramString))))

