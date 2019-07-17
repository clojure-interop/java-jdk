(ns javax.management.MBeanRegistrationException
  "Wraps exceptions thrown by the preRegister(), preDeregister() methods
  of the MBeanRegistration interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanRegistrationException]))

(defn ->m-bean-registration-exception
  "Constructor.

  Creates an MBeanRegistrationException that wraps
   the actual java.lang.Exception with a detailed
   message.

  e - the wrapped exception. - `java.lang.Exception`
  message - the detail message. - `java.lang.String`"
  ([e message]
    (new MBeanRegistrationException e message))
  ([e]
    (new MBeanRegistrationException e)))

