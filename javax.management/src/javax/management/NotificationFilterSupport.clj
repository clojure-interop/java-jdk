(ns javax.management.NotificationFilterSupport
  "Provides an implementation of the NotificationFilter interface.
  The filtering is performed on the notification type attribute.

  Manages a list of enabled notification types.
  A method allows users to enable/disable as many notification types as required.

  Then, before sending a notification to a listener registered with a filter,
  the notification broadcaster compares this notification type with all notification types
  enabled by the filter. The notification will be sent to the listener
  only if its filter enables this notification type.

  Example:



  NotificationFilterSupport myFilter = new NotificationFilterSupport();
  myFilter.enableType(`my_example.my_type`);
  myBroadcaster.addListener(myListener, myFilter, null);

  The listener myListener will only receive notifications the type of which equals/starts with `my_example.my_type`."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management NotificationFilterSupport]))

(defn ->notification-filter-support
  "Constructor."
  ([]
    (new NotificationFilterSupport )))

(defn notification-enabled?
  "Invoked before sending the specified notification to the listener.
   This filter compares the type of the specified notification with each enabled type.
   If the notification type matches one of the enabled types,
   the notification should be sent to the listener and this method returns true.

  notification - The notification to be sent. - `javax.management.Notification`

  returns: true if the notification should be sent to the listener, false otherwise. - `boolean`"
  ([^javax.management.NotificationFilterSupport this ^javax.management.Notification notification]
    (-> this (.isNotificationEnabled notification))))

(defn enable-type
  "Enables all the notifications the type of which starts with the specified prefix
   to be sent to the listener.
   If the specified prefix is already in the list of enabled notification types,
   this method has no effect.

   Example:



   // Enables all notifications the type of which starts with `my_example` to be sent.
   myFilter.enableType(`my_example`);
   // Enables all notifications the type of which is `my_example.my_type` to be sent.
   myFilter.enableType(`my_example.my_type`);


   Note that:

   myFilter.enableType(`my_example.*`);

   will no match any notification type.

  prefix - The prefix. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - The prefix parameter is null."
  ([^javax.management.NotificationFilterSupport this ^java.lang.String prefix]
    (-> this (.enableType prefix))))

(defn disable-type
  "Removes the given prefix from the prefix list.
   If the specified prefix is not in the list of enabled notification types,
   this method has no effect.

  prefix - The prefix. - `java.lang.String`"
  ([^javax.management.NotificationFilterSupport this ^java.lang.String prefix]
    (-> this (.disableType prefix))))

(defn disable-all-types
  "Disables all notification types."
  ([^javax.management.NotificationFilterSupport this]
    (-> this (.disableAllTypes))))

(defn get-enabled-types
  "Gets all the enabled notification types for this filter.

  returns: The list containing all the enabled notification types. - `java.util.Vector<java.lang.String>`"
  ([^javax.management.NotificationFilterSupport this]
    (-> this (.getEnabledTypes))))

