(ns javax.sql.RowSetEvent
  "An Event object generated when an event occurs to a
  RowSet object.  A RowSetEvent object is
  generated when a single row in a rowset is changed, the whole rowset
  is changed, or the rowset cursor moves.

  When an event occurs on a RowSet object, one of the
  RowSetListener methods will be sent to all registered
  listeners to notify them of the event.  An Event object
  is supplied to the RowSetListener method so that the
  listener can use it to find out which RowSet object is
  the source of the event."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql RowSetEvent]))

(defn ->row-set-event
  "Constructor.

  Constructs a RowSetEvent object initialized with the
   given RowSet object.

  source - the RowSet object whose data has changed or whose cursor has moved - `javax.sql.RowSet`

  throws: java.lang.IllegalArgumentException - if source is null."
  ([^javax.sql.RowSet source]
    (new RowSetEvent source)))

