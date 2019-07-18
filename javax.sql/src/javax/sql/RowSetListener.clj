(ns javax.sql.RowSetListener
  "An interface that must be implemented by a
  component that wants to be notified when a significant
  event happens in the life of a RowSet object.
  A component becomes a listener by being registered with a
  RowSet object via the method RowSet.addRowSetListener.
  How a registered component implements this interface determines what it does
  when it is notified of an event."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql RowSetListener]))

(defn row-set-changed
  "Notifies registered listeners that a RowSet object
   in the given RowSetEvent object has changed its entire contents.

   The source of the event can be retrieved with the method
   event.getSource.

  event - a RowSetEvent object that contains the RowSet object that is the source of the event - `javax.sql.RowSetEvent`"
  ([^RowSetListener this ^javax.sql.RowSetEvent event]
    (-> this (.rowSetChanged event))))

(defn row-changed
  "Notifies registered listeners that a RowSet object
   has had a change in one of its rows.

   The source of the event can be retrieved with the method
   event.getSource.

  event - a RowSetEvent object that contains the RowSet object that is the source of the event - `javax.sql.RowSetEvent`"
  ([^RowSetListener this ^javax.sql.RowSetEvent event]
    (-> this (.rowChanged event))))

(defn cursor-moved
  "Notifies registered listeners that a RowSet object's
   cursor has moved.

   The source of the event can be retrieved with the method
   event.getSource.

  event - a RowSetEvent object that contains the RowSet object that is the source of the event - `javax.sql.RowSetEvent`"
  ([^RowSetListener this ^javax.sql.RowSetEvent event]
    (-> this (.cursorMoved event))))

