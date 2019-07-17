(ns javax.swing.event.AncestorListener
  "AncestorListener

  Interface to support notification when changes occur to a JComponent or one
  of its ancestors.  These include movement and when the component becomes
  visible or invisible, either by the setVisible() method or by being added
  or removed from the component hierarchy."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event AncestorListener]))

(defn ancestor-added
  "Called when the source or one of its ancestors is made visible
   either by setVisible(true) being called or by its being
   added to the component hierarchy.  The method is only called
   if the source has actually become visible.  For this to be true
   all its parents must be visible and it must be in a hierarchy
   rooted at a Window

  event - `javax.swing.event.AncestorEvent`"
  ([^. this ^javax.swing.event.AncestorEvent event]
    (-> this (.ancestorAdded event))))

(defn ancestor-removed
  "Called when the source or one of its ancestors is made invisible
   either by setVisible(false) being called or by its being
   remove from the component hierarchy.  The method is only called
   if the source has actually become invisible.  For this to be true
   at least one of its parents must by invisible or it is not in
   a hierarchy rooted at a Window

  event - `javax.swing.event.AncestorEvent`"
  ([^. this ^javax.swing.event.AncestorEvent event]
    (-> this (.ancestorRemoved event))))

(defn ancestor-moved
  "Called when either the source or one of its ancestors is moved.

  event - `javax.swing.event.AncestorEvent`"
  ([^. this ^javax.swing.event.AncestorEvent event]
    (-> this (.ancestorMoved event))))

