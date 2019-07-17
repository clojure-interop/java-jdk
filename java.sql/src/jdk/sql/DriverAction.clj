(ns jdk.sql.DriverAction
  "An interface that must be implemented when a java.sql.Driver wants to be
  notified by DriverManager.

  A DriverAction implementation is not intended to be used
  directly by applications. A JDBC Driver  may choose
  to create its DriverAction implementation in a private class
  to avoid it being called directly.

  The JDBC driver's static initialization block must call
  DriverManager.registerDriver(java.sql.Driver, java.sql.DriverAction) in order
  to inform DriverManager which DriverAction implementation to
  call when the JDBC driver is de-registered."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql DriverAction]))

(defn deregister
  "Method called by
   DriverManager.deregisterDriver(Driver)
    to notify the JDBC driver that it was de-registered.

   The deregister method is intended only to be used by JDBC Drivers
   and not by applications.  JDBC drivers are recommended to not implement
   DriverAction in a public class.  If there are active
   connections to the database at the time that the deregister
   method is called, it is implementation specific as to whether the
   connections are closed or allowed to continue. Once this method is
   called, it is implementation specific as to whether the driver may
   limit the ability to create new connections to the database, invoke
   other Driver methods or throw a SQLException.
   Consult your JDBC driver's documentation for additional information
   on its behavior."
  ([^. this]
    (-> this (.deregister))))

