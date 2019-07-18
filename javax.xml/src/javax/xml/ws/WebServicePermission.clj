(ns javax.xml.ws.WebServicePermission
  "This class defines web service permissions.

  Web service Permissions are identified by name (also referred to as
  a `target name`) alone. There are no actions associated
  with them.

  The following permission target name is defined:


    publishEndpoint


  The publishEndpoint permission allows publishing a
  web service endpoint using the publish methods
  defined by the javax.xml.ws.Endpoint class.

  Granting publishEndpoint allows the application to be
  exposed as a network service. Depending on the security of the runtime and
  the security of the application, this may introduce a security hole that
  is remotely exploitable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws WebServicePermission]))

(defn ->web-service-permission
  "Constructor.

  Creates a new permission with the specified name and actions.

   The actions parameter is currently unused and
   it should be null.

  name - the name of the WebServicePermission - `java.lang.String`
  actions - should be null - `java.lang.String`"
  (^WebServicePermission [^java.lang.String name ^java.lang.String actions]
    (new WebServicePermission name actions))
  (^WebServicePermission [^java.lang.String name]
    (new WebServicePermission name)))

