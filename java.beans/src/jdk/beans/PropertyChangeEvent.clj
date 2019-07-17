(ns jdk.beans.PropertyChangeEvent
  "A `PropertyChange` event gets delivered whenever a bean changes a `bound`
  or `constrained` property.  A PropertyChangeEvent object is sent as an
  argument to the PropertyChangeListener and VetoableChangeListener methods.

  Normally PropertyChangeEvents are accompanied by the name and the old
  and new value of the changed property.  If the new value is a primitive
  type (such as int or boolean) it must be wrapped as the
  corresponding java.lang.* Object type (such as Integer or Boolean).

  Null values may be provided for the old and the new values if their
  true values are not known.

  An event source may send a null object as the name to indicate that an
  arbitrary set of if its properties have changed.  In this case the
  old and new values should also be null."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans PropertyChangeEvent]))

(defn ->property-change-event
  "Constructor.

  Constructs a new PropertyChangeEvent.

  source - the bean that fired the event - `java.lang.Object`
  property-name - the programmatic name of the property that was changed - `java.lang.String`
  old-value - the old value of the property - `java.lang.Object`
  new-value - the new value of the property - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if source is null"
  ([source property-name old-value new-value]
    (new PropertyChangeEvent source property-name old-value new-value)))

(defn get-property-name
  "Gets the programmatic name of the property that was changed.

  returns: The programmatic name of the property that was changed.
            May be null if multiple properties have changed. - `java.lang.String`"
  ([this]
    (-> this (.getPropertyName))))

(defn get-new-value
  "Gets the new value for the property, expressed as an Object.

  returns: The new value for the property, expressed as an Object.
            May be null if multiple properties have changed. - `java.lang.Object`"
  ([this]
    (-> this (.getNewValue))))

(defn get-old-value
  "Gets the old value for the property, expressed as an Object.

  returns: The old value for the property, expressed as an Object.
            May be null if multiple properties have changed. - `java.lang.Object`"
  ([this]
    (-> this (.getOldValue))))

(defn set-propagation-id
  "Sets the propagationId object for the event.

  propagation-id - The propagationId object for the event. - `java.lang.Object`"
  ([this propagation-id]
    (-> this (.setPropagationId propagation-id))))

(defn get-propagation-id
  "The `propagationId` field is reserved for future use.  In Beans 1.0
   the sole requirement is that if a listener catches a PropertyChangeEvent
   and then fires a PropertyChangeEvent of its own, then it should
   make sure that it propagates the propagationId field from its
   incoming event to its outgoing event.

  returns: the propagationId object associated with a bound/constrained
            property update. - `java.lang.Object`"
  ([this]
    (-> this (.getPropagationId))))

(defn to-string
  "Returns a string representation of the object.

  returns: a string representation of the object - `java.lang.String`"
  ([this]
    (-> this (.toString))))

