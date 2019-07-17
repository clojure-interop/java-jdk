(ns jdk.awt.event.MouseWheelListener
  "The listener interface for receiving mouse wheel events on a component.
  (For clicks and other mouse events, use the MouseListener.
  For mouse movement and drags, use the MouseMotionListener.)

  The class that is interested in processing a mouse wheel event
  implements this interface (and all the methods it contains).

  The listener object created from that class is then registered with a
  component using the component's addMouseWheelListener
  method. A mouse wheel event is generated when the mouse wheel is rotated.
  When a mouse wheel event occurs, that object's mouseWheelMoved
  method is invoked.

  For information on how mouse wheel events are dispatched, see
  the class description for MouseWheelEvent."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event MouseWheelListener]))

(defn mouse-wheel-moved
  "Invoked when the mouse wheel is rotated.

  e - `java.awt.event.MouseWheelEvent`"
  ([^. this ^java.awt.event.MouseWheelEvent e]
    (-> this (.mouseWheelMoved e))))

