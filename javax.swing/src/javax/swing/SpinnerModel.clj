(ns javax.swing.SpinnerModel
  "A model for a potentially unbounded sequence of object values.  This model
  is similar to ListModel however there are some important differences:

   The number of sequence elements isn't necessarily bounded.
   The model doesn't support indexed random access to sequence elements.
       Only three sequence values are accessible at a time: current, next and
       previous.
   The current sequence element, can be set.


  A SpinnerModel has three properties, only the first is read/write.

    value
    The current element of the sequence.

    nextValue
    The following element or null if value is the
      last element of the sequence.

    previousValue
    The preceding element or null if value is the
      first element of the sequence.

  When the the value property changes,
  ChangeListeners are notified.  SpinnerModel may
  choose to notify the ChangeListeners under other circumstances."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SpinnerModel]))

(defn get-value
  "The current element of the sequence.  This element is usually
   displayed by the editor part of a JSpinner.

  returns: the current spinner value. - `java.lang.Object`"
  ([^. this]
    (-> this (.getValue))))

(defn set-value
  "Changes current value of the model, typically this value is displayed
   by the editor part of a  JSpinner.
   If the SpinnerModel implementation doesn't support
   the specified value then an IllegalArgumentException
   is thrown.  For example a SpinnerModel for numbers might
   only support values that are integer multiples of ten. In
   that case, model.setValue(new Number(11))
   would throw an exception.

  value - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if value isn't allowed"
  ([^. this ^java.lang.Object value]
    (-> this (.setValue value))))

(defn get-next-value
  "Return the object in the sequence that comes after the object returned
   by getValue(). If the end of the sequence has been reached
   then return null.  Calling this method does not effect value.

  returns: the next legal value or null if one doesn't exist - `java.lang.Object`"
  ([^. this]
    (-> this (.getNextValue))))

(defn get-previous-value
  "Return the object in the sequence that comes before the object returned
   by getValue().  If the end of the sequence has been reached then
   return null. Calling this method does not effect value.

  returns: the previous legal value or null if one doesn't exist - `java.lang.Object`"
  ([^. this]
    (-> this (.getPreviousValue))))

(defn add-change-listener
  "Adds a ChangeListener to the model's listener list.  The
   ChangeListeners must be notified when models value
   changes.

  l - the ChangeListener to add - `javax.swing.event.ChangeListener`"
  ([^. this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn remove-change-listener
  "Removes a ChangeListener from the model's listener list.

  l - the ChangeListener to remove - `javax.swing.event.ChangeListener`"
  ([^. this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

