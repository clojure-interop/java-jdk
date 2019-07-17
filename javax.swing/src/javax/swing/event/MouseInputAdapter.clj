(ns javax.swing.event.MouseInputAdapter
  "An empty implementation of the MouseInputListener interface, provided
  as a convenience to simplify the task of creating listeners, by extending
  and implementing only the methods of interest. This class also provides an
  empty implementation of the MouseWheelListener interface, through
  its extension from AWT's MouseAdapter."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event MouseInputAdapter]))

(defn ->mouse-input-adapter
  "Constructor."
  ([]
    (new MouseInputAdapter )))

