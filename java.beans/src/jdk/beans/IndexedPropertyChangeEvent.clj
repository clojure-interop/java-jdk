(ns jdk.beans.IndexedPropertyChangeEvent
  "An \"IndexedPropertyChange\" event gets delivered whenever a component that
  conforms to the JavaBeans™ specification (a \"bean\") changes a bound
  indexed property. This class is an extension of PropertyChangeEvent
  but contains the index of the property that has changed.

  Null values may be provided for the old and the new values if their
  true values are not known.

  An event source may send a null object as the name to indicate that an
  arbitrary set of if its properties have changed.  In this case the
  old and new values should also be null."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans IndexedPropertyChangeEvent]))

(defn ->indexed-property-change-event
  "Constructor.

  Constructs a new IndexedPropertyChangeEvent object.

  source - The bean that fired the event. - `java.lang.Object`
  property-name - The programmatic name of the property that was changed. - `java.lang.String`
  old-value - The old value of the property. - `java.lang.Object`
  new-value - The new value of the property. - `java.lang.Object`
  index - index of the property element that was changed. - `int`"
  (^IndexedPropertyChangeEvent [^java.lang.Object source ^java.lang.String property-name ^java.lang.Object old-value ^java.lang.Object new-value ^Integer index]
    (new IndexedPropertyChangeEvent source property-name old-value new-value index)))

(defn get-index
  "Gets the index of the property that was changed.

  returns: The index specifying the property element that was
           changed. - `int`"
  (^Integer [^IndexedPropertyChangeEvent this]
    (-> this (.getIndex))))

