(ns javax.swing.event.SwingPropertyChangeSupport
  "This subclass of java.beans.PropertyChangeSupport is almost
  identical in functionality. The only difference is if constructed with
  SwingPropertyChangeSupport(sourceBean, true) it ensures
  listeners are only ever notified on the Event Dispatch Thread."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event SwingPropertyChangeSupport]))

(defn ->swing-property-change-support
  "Constructor.

  Constructs a SwingPropertyChangeSupport object.

  source-bean - the bean to be given as the source for any events - `java.lang.Object`
  notify-on-edt - whether to notify listeners on the Event Dispatch Thread only - `boolean`

  throws: java.lang.NullPointerException - if sourceBean is null"
  ([^java.lang.Object source-bean ^Boolean notify-on-edt]
    (new SwingPropertyChangeSupport source-bean notify-on-edt))
  ([^java.lang.Object source-bean]
    (new SwingPropertyChangeSupport source-bean)))

(defn fire-property-change
  "Fires a property change event to listeners
   that have been registered to track updates of
   all properties or a property with the specified name.

   No event is fired if the given event's old and new values are equal and non-null.


   If isNotifyOnEDT() is true and called off the
   Event Dispatch Thread this implementation uses
   SwingUtilities.invokeLater to send out the notification
   on the Event Dispatch Thread. This ensures  listeners
   are only ever notified on the Event Dispatch Thread.

  evt - the PropertyChangeEvent to be fired - `java.beans.PropertyChangeEvent`

  throws: java.lang.NullPointerException - if evt is null"
  ([^javax.swing.event.SwingPropertyChangeSupport this ^java.beans.PropertyChangeEvent evt]
    (-> this (.firePropertyChange evt))))

(defn notify-on-edt?
  "Returns notifyOnEDT property.

  returns: notifyOnEDT property - `boolean`"
  (^Boolean [^javax.swing.event.SwingPropertyChangeSupport this]
    (-> this (.isNotifyOnEDT))))

