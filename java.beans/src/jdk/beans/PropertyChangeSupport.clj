(ns jdk.beans.PropertyChangeSupport
  "This is a utility class that can be used by beans that support bound
  properties.  It manages a list of listeners and dispatches
  PropertyChangeEvents to them.  You can use an instance of this class
  as a member field of your bean and delegate these types of work to it.
  The PropertyChangeListener can be registered for all properties
  or for a property specified by name.

  Here is an example of PropertyChangeSupport usage that follows
  the rules and recommendations laid out in the JavaBeans™ specification:


  public class MyBean {
      private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

      public void addPropertyChangeListener(PropertyChangeListener listener) {
          this.pcs.addPropertyChangeListener(listener);
      }

      public void removePropertyChangeListener(PropertyChangeListener listener) {
          this.pcs.removePropertyChangeListener(listener);
      }

      private String value;

      public String getValue() {
          return this.value;
      }

      public void setValue(String newValue) {
          String oldValue = this.value;
          this.value = newValue;
          this.pcs.firePropertyChange(`value`, oldValue, newValue);
      }

      [...]
  }

  A PropertyChangeSupport instance is thread-safe.

  This class is serializable.  When it is serialized it will save
  (and restore) any listeners that are themselves serializable.  Any
  non-serializable listeners will be skipped during serialization."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans PropertyChangeSupport]))

(defn ->property-change-support
  "Constructor.

  Constructs a PropertyChangeSupport object.

  source-bean - The bean to be given as the source for any events. - `java.lang.Object`"
  ([^java.lang.Object source-bean]
    (new PropertyChangeSupport source-bean)))

(defn add-property-change-listener
  "Add a PropertyChangeListener for a specific property.  The listener
   will be invoked only when a call on firePropertyChange names that
   specific property.
   The same listener object may be added more than once.  For each
   property,  the listener will be invoked the number of times it was added
   for that property.
   If propertyName or listener is null, no
   exception is thrown and no action is taken.

  property-name - The name of the property to listen on. - `java.lang.String`
  listener - The PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([^java.beans.PropertyChangeSupport this ^java.lang.String property-name ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener property-name listener)))
  ([^java.beans.PropertyChangeSupport this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn remove-property-change-listener
  "Remove a PropertyChangeListener for a specific property.
   If listener was added more than once to the same event
   source for the specified property, it will be notified one less time
   after being removed.
   If propertyName is null,  no exception is thrown and no
   action is taken.
   If listener is null, or was never added for the specified
   property, no exception is thrown and no action is taken.

  property-name - The name of the property that was listened on. - `java.lang.String`
  listener - The PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([^java.beans.PropertyChangeSupport this ^java.lang.String property-name ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener property-name listener)))
  ([^java.beans.PropertyChangeSupport this ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener listener))))

(defn get-property-change-listeners
  "Returns an array of all the listeners which have been associated
   with the named property.

  property-name - The name of the property being listened to - `java.lang.String`

  returns: all of the PropertyChangeListeners associated with
           the named property.  If no such listeners have been added,
           or if propertyName is null, an empty array is
           returned. - `java.beans.PropertyChangeListener[]`"
  ([^java.beans.PropertyChangeSupport this ^java.lang.String property-name]
    (-> this (.getPropertyChangeListeners property-name)))
  ([^java.beans.PropertyChangeSupport this]
    (-> this (.getPropertyChangeListeners))))

(defn fire-property-change
  "Reports a bound property update to listeners
   that have been registered to track updates of
   all properties or a property with the specified name.

   No event is fired if old and new values are equal and non-null.

   This is merely a convenience wrapper around the more general
   firePropertyChange(PropertyChangeEvent) method.

  property-name - the programmatic name of the property that was changed - `java.lang.String`
  old-value - the old value of the property - `java.lang.Object`
  new-value - the new value of the property - `java.lang.Object`"
  ([^java.beans.PropertyChangeSupport this ^java.lang.String property-name ^java.lang.Object old-value ^java.lang.Object new-value]
    (-> this (.firePropertyChange property-name old-value new-value)))
  ([^java.beans.PropertyChangeSupport this ^java.beans.PropertyChangeEvent event]
    (-> this (.firePropertyChange event))))

(defn fire-indexed-property-change
  "Reports a bound indexed property update to listeners
   that have been registered to track updates of
   all properties or a property with the specified name.

   No event is fired if old and new values are equal and non-null.

   This is merely a convenience wrapper around the more general
   firePropertyChange(PropertyChangeEvent) method.

  property-name - the programmatic name of the property that was changed - `java.lang.String`
  index - the index of the property element that was changed - `int`
  old-value - the old value of the property - `java.lang.Object`
  new-value - the new value of the property - `java.lang.Object`"
  ([^java.beans.PropertyChangeSupport this ^java.lang.String property-name ^Integer index ^java.lang.Object old-value ^java.lang.Object new-value]
    (-> this (.fireIndexedPropertyChange property-name index old-value new-value))))

(defn has-listeners?
  "Check if there are any listeners for a specific property, including
   those registered on all properties.  If propertyName
   is null, only check for listeners registered on all properties.

  property-name - the property name. - `java.lang.String`

  returns: true if there are one or more listeners for the given property - `boolean`"
  (^Boolean [^java.beans.PropertyChangeSupport this ^java.lang.String property-name]
    (-> this (.hasListeners property-name))))

