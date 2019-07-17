(ns javax.accessibility.AccessibleIcon
  "The AccessibleIcon interface should be supported by any object
  that has an associated icon (e.g., buttons). This interface
  provides the standard mechanism for an assistive technology
  to get descriptive information about icons.
  Applications can determine
  if an object supports the AccessibleIcon interface by first
  obtaining its AccessibleContext (see
  Accessible) and then calling the
  AccessibleContext.getAccessibleIcon() method.
  If the return value is not null, the object supports this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleIcon]))

(defn get-accessible-icon-description
  "Gets the description of the icon.  This is meant to be a brief
   textual description of the object.  For example, it might be
   presented to a blind user to give an indication of the purpose
   of the icon.

  returns: the description of the icon - `java.lang.String`"
  ([^. this]
    (-> this (.getAccessibleIconDescription))))

(defn set-accessible-icon-description
  "Sets the description of the icon.  This is meant to be a brief
   textual description of the object.  For example, it might be
   presented to a blind user to give an indication of the purpose
   of the icon.

  description - the description of the icon - `java.lang.String`"
  ([^. this ^java.lang.String description]
    (-> this (.setAccessibleIconDescription description))))

(defn get-accessible-icon-width
  "Gets the width of the icon

  returns: the width of the icon. - `int`"
  ([^. this]
    (-> this (.getAccessibleIconWidth))))

(defn get-accessible-icon-height
  "Gets the height of the icon

  returns: the height of the icon. - `int`"
  ([^. this]
    (-> this (.getAccessibleIconHeight))))

