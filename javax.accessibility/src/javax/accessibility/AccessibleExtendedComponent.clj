(ns javax.accessibility.AccessibleExtendedComponent
  "The AccessibleExtendedComponent interface should be supported by any object
  that is rendered on the screen.  This interface provides the standard
  mechanism for an assistive technology to determine the extended
  graphical representation of an object.  Applications can determine
  if an object supports the AccessibleExtendedComponent interface by first
  obtaining its AccessibleContext
  and then calling the
  AccessibleContext.getAccessibleComponent() method.
  If the return value is not null and the type of the return value is
  AccessibleExtendedComponent, the object supports this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleExtendedComponent]))

(defn get-tool-tip-text
  "Returns the tool tip text

  returns: the tool tip text, if supported, of the object;
   otherwise, null - `java.lang.String`"
  (^java.lang.String [^javax.accessibility.AccessibleExtendedComponent this]
    (-> this (.getToolTipText))))

(defn get-titled-border-text
  "Returns the titled border text

  returns: the titled border text, if supported, of the object;
   otherwise, null - `java.lang.String`"
  (^java.lang.String [^javax.accessibility.AccessibleExtendedComponent this]
    (-> this (.getTitledBorderText))))

(defn get-accessible-key-binding
  "Returns key bindings associated with this object

  returns: the key bindings, if supported, of the object;
   otherwise, null - `javax.accessibility.AccessibleKeyBinding`"
  (^javax.accessibility.AccessibleKeyBinding [^javax.accessibility.AccessibleExtendedComponent this]
    (-> this (.getAccessibleKeyBinding))))

