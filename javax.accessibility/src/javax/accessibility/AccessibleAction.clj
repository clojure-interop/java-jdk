(ns javax.accessibility.AccessibleAction
  "The AccessibleAction interface should be supported by any object
  that can perform one or more actions.  This interface
  provides the standard mechanism for an assistive technology to determine
  what those actions are as well as tell the object to perform them.
  Any object that can be manipulated should support this
  interface.  Applications can determine if an object supports the
  AccessibleAction interface by first obtaining its AccessibleContext (see
  Accessible) and then calling the AccessibleContext.getAccessibleAction()
  method.  If the return value is not null, the object supports this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleAction]))

(defn get-accessible-action-count
  "Returns the number of accessible actions available in this object
   If there are more than one, the first one is considered the \"default\"
   action of the object.

  returns: the zero-based number of Actions in this object - `int`"
  (^Integer [^AccessibleAction this]
    (-> this (.getAccessibleActionCount))))

(defn get-accessible-action-description
  "Returns a description of the specified action of the object.

  i - zero-based index of the actions - `int`

  returns: a String description of the action - `java.lang.String`"
  (^java.lang.String [^AccessibleAction this ^Integer i]
    (-> this (.getAccessibleActionDescription i))))

(defn do-accessible-action
  "Performs the specified Action on the object

  i - zero-based index of actions - `int`

  returns: true if the action was performed; otherwise false. - `boolean`"
  (^Boolean [^AccessibleAction this ^Integer i]
    (-> this (.doAccessibleAction i))))

