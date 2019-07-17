(ns jdk.beans.VetoableChangeSupport
  "This is a utility class that can be used by beans that support constrained
  properties.  It manages a list of listeners and dispatches
  PropertyChangeEvents to them.  You can use an instance of this class
  as a member field of your bean and delegate these types of work to it.
  The VetoableChangeListener can be registered for all properties
  or for a property specified by name.

  Here is an example of VetoableChangeSupport usage that follows
  the rules and recommendations laid out in the JavaBeans™ specification:


  public class MyBean {
      private final VetoableChangeSupport vcs = new VetoableChangeSupport(this);

      public void addVetoableChangeListener(VetoableChangeListener listener) {
          this.vcs.addVetoableChangeListener(listener);
      }

      public void removeVetoableChangeListener(VetoableChangeListener listener) {
          this.vcs.removeVetoableChangeListener(listener);
      }

      private String value;

      public String getValue() {
          return this.value;
      }

      public void setValue(String newValue) throws PropertyVetoException {
          String oldValue = this.value;
          this.vcs.fireVetoableChange(`value`, oldValue, newValue);
          this.value = newValue;
      }

      [...]
  }

  A VetoableChangeSupport instance is thread-safe.

  This class is serializable.  When it is serialized it will save
  (and restore) any listeners that are themselves serializable.  Any
  non-serializable listeners will be skipped during serialization."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans VetoableChangeSupport]))

(defn ->vetoable-change-support
  "Constructor.

  Constructs a VetoableChangeSupport object.

  source-bean - The bean to be given as the source for any events. - `java.lang.Object`"
  ([^java.lang.Object source-bean]
    (new VetoableChangeSupport source-bean)))

(defn add-vetoable-change-listener
  "Add a VetoableChangeListener for a specific property.  The listener
   will be invoked only when a call on fireVetoableChange names that
   specific property.
   The same listener object may be added more than once.  For each
   property,  the listener will be invoked the number of times it was added
   for that property.
   If propertyName or listener is null, no
   exception is thrown and no action is taken.

  property-name - The name of the property to listen on. - `java.lang.String`
  listener - The VetoableChangeListener to be added - `java.beans.VetoableChangeListener`"
  ([^java.beans.VetoableChangeSupport this ^java.lang.String property-name ^java.beans.VetoableChangeListener listener]
    (-> this (.addVetoableChangeListener property-name listener)))
  ([^java.beans.VetoableChangeSupport this ^java.beans.VetoableChangeListener listener]
    (-> this (.addVetoableChangeListener listener))))

(defn remove-vetoable-change-listener
  "Remove a VetoableChangeListener for a specific property.
   If listener was added more than once to the same event
   source for the specified property, it will be notified one less time
   after being removed.
   If propertyName is null, no exception is thrown and no
   action is taken.
   If listener is null, or was never added for the specified
   property, no exception is thrown and no action is taken.

  property-name - The name of the property that was listened on. - `java.lang.String`
  listener - The VetoableChangeListener to be removed - `java.beans.VetoableChangeListener`"
  ([^java.beans.VetoableChangeSupport this ^java.lang.String property-name ^java.beans.VetoableChangeListener listener]
    (-> this (.removeVetoableChangeListener property-name listener)))
  ([^java.beans.VetoableChangeSupport this ^java.beans.VetoableChangeListener listener]
    (-> this (.removeVetoableChangeListener listener))))

(defn get-vetoable-change-listeners
  "Returns an array of all the listeners which have been associated
   with the named property.

  property-name - The name of the property being listened to - `java.lang.String`

  returns: all the VetoableChangeListeners associated with
           the named property.  If no such listeners have been added,
           or if propertyName is null, an empty array is
           returned. - `java.beans.VetoableChangeListener[]`"
  ([^java.beans.VetoableChangeSupport this ^java.lang.String property-name]
    (-> this (.getVetoableChangeListeners property-name)))
  ([^java.beans.VetoableChangeSupport this]
    (-> this (.getVetoableChangeListeners))))

(defn fire-vetoable-change
  "Reports a constrained property update to listeners
   that have been registered to track updates of
   all properties or a property with the specified name.

   Any listener can throw a PropertyVetoException to veto the update.
   If one of the listeners vetoes the update, this method passes
   a new `undo` PropertyChangeEvent that reverts to the old value
   to all listeners that already confirmed this update
   and throws the PropertyVetoException again.

   No event is fired if old and new values are equal and non-null.

   This is merely a convenience wrapper around the more general
   fireVetoableChange(PropertyChangeEvent) method.

  property-name - the programmatic name of the property that is about to change - `java.lang.String`
  old-value - the old value of the property - `java.lang.Object`
  new-value - the new value of the property - `java.lang.Object`

  throws: java.beans.PropertyVetoException - if one of listeners vetoes the property update"
  ([^java.beans.VetoableChangeSupport this ^java.lang.String property-name ^java.lang.Object old-value ^java.lang.Object new-value]
    (-> this (.fireVetoableChange property-name old-value new-value)))
  ([^java.beans.VetoableChangeSupport this ^java.beans.PropertyChangeEvent event]
    (-> this (.fireVetoableChange event))))

(defn has-listeners?
  "Check if there are any listeners for a specific property, including
   those registered on all properties.  If propertyName
   is null, only check for listeners registered on all properties.

  property-name - the property name. - `java.lang.String`

  returns: true if there are one or more listeners for the given property - `boolean`"
  (^Boolean [^java.beans.VetoableChangeSupport this ^java.lang.String property-name]
    (-> this (.hasListeners property-name))))

