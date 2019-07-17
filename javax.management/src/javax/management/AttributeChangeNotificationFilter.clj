(ns javax.management.AttributeChangeNotificationFilter
  "This class implements of the NotificationFilter
  interface for the attribute change notification.
  The filtering is performed on the name of the observed attribute.

  It manages a list of enabled attribute names.
  A method allows users to enable/disable as many attribute names as required."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management AttributeChangeNotificationFilter]))

(defn ->attribute-change-notification-filter
  "Constructor."
  ([]
    (new AttributeChangeNotificationFilter )))

(defn notification-enabled?
  "Invoked before sending the specified notification to the listener.
   This filter compares the attribute name of the specified attribute change notification
   with each enabled attribute name.
   If the attribute name equals one of the enabled attribute names,
   the notification must be sent to the listener and this method returns true.

  notification - The attribute change notification to be sent. - `javax.management.Notification`

  returns: true if the notification has to be sent to the listener, false otherwise. - `boolean`"
  ([this notification]
    (-> this (.isNotificationEnabled notification))))

(defn enable-attribute
  "Enables all the attribute change notifications the attribute name of which equals
   the specified name to be sent to the listener.
   If the specified name is already in the list of enabled attribute names,
   this method has no effect.

  name - The attribute name. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - The attribute name parameter is null."
  ([this name]
    (-> this (.enableAttribute name))))

(defn disable-attribute
  "Disables all the attribute change notifications the attribute name of which equals
   the specified attribute name to be sent to the listener.
   If the specified name is not in the list of enabled attribute names,
   this method has no effect.

  name - The attribute name. - `java.lang.String`"
  ([this name]
    (-> this (.disableAttribute name))))

(defn disable-all-attributes
  "Disables all the attribute names."
  ([this]
    (-> this (.disableAllAttributes))))

(defn get-enabled-attributes
  "Gets all the enabled attribute names for this filter.

  returns: The list containing all the enabled attribute names. - `java.util.Vector<java.lang.String>`"
  ([this]
    (-> this (.getEnabledAttributes))))

