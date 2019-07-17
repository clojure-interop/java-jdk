(ns javax.swing.text.LayoutQueue
  "A queue of text layout tasks."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text LayoutQueue]))

(defn ->layout-queue
  "Constructor.

  Construct a layout queue."
  ([]
    (new LayoutQueue )))

(defn *get-default-queue
  "Fetch the default layout queue.

  returns: `javax.swing.text.LayoutQueue`"
  ([]
    (LayoutQueue/getDefaultQueue )))

(defn *set-default-queue
  "Set the default layout queue.

  q - the new queue. - `javax.swing.text.LayoutQueue`"
  ([q]
    (LayoutQueue/setDefaultQueue q)))

(defn add-task
  "Add a task that is not needed immediately because
   the results are not believed to be visible.

  task - `java.lang.Runnable`"
  ([this task]
    (-> this (.addTask task))))

