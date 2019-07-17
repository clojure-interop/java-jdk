(ns javax.accessibility.Accessible
  "Interface Accessible is the main interface for the accessibility package.
  All components that support
  the accessibility package must implement this interface.
  It contains a single method, getAccessibleContext(), which
  returns an instance of the class AccessibleContext."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility Accessible]))

(defn get-accessible-context
  "Returns the AccessibleContext associated with this object.  In most
   cases, the return value should not be null if the object implements
   interface Accessible.  If a component developer creates a subclass
   of an object that implements Accessible, and that subclass
   is not Accessible, the developer should override the
   getAccessibleContext method to return null.

  returns: the AccessibleContext associated with this object - `javax.accessibility.AccessibleContext`"
  ([^javax.accessibility.Accessible this]
    (-> this (.getAccessibleContext))))

