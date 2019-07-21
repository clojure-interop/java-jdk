(ns javax.security.auth.kerberos.ServicePermission
  "This class is used to protect Kerberos services and the
  credentials necessary to access those services. There is a one to
  one mapping of a service principal and the credentials necessary
  to access the service. Therefore granting access to a service
  principal implicitly grants access to the credential necessary to
  establish a security context with the service principal. This
  applies regardless of whether the credentials are in a cache
  or acquired via an exchange with the KDC. The credential can
  be either a ticket granting ticket, a service ticket or a secret
  key from a key table.

  A ServicePermission contains a service principal name and
  a list of actions which specify the context the credential can be
  used within.

  The service principal name is the canonical name of the
  KerberosPrincipal supplying the service, that is
  the KerberosPrincipal represents a Kerberos service
  principal. This name is treated in a case sensitive manner.
  An asterisk may appear by itself, to signify any service principal.

  Granting this permission implies that the caller can use a cached
  credential (TGT, service ticket or secret key) within the context
  designated by the action. In the case of the TGT, granting this
  permission also implies that the TGT can be obtained by an
  Authentication Service exchange.

  The possible actions are:



     initiate -              allow the caller to use the credential to
                             initiate a security context with a service
                             principal.

     accept -                allow the caller to use the credential to
                             accept security context as a particular
                             principal.

  For example, to specify the permission to access to the TGT to
  initiate a security context the permission is constructed as follows:



      ServicePermission(\"krbtgt/EXAMPLE.COM@EXAMPLE.COM\", \"initiate\");

  To obtain a service ticket to initiate a context with the \"host\"
  service the permission is constructed as follows:


      ServicePermission(\"host/foo.example.com@EXAMPLE.COM\", \"initiate\");

  For a Kerberized server the action is \"accept\". For example, the permission
  necessary to access and use the secret key of the  Kerberized \"host\"
  service (telnet and the likes)  would be constructed as follows:



      ServicePermission(\"host/foo.example.com@EXAMPLE.COM\", \"accept\");"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.kerberos ServicePermission]))

(defn ->service-permission
  "Constructor.

  Create a new ServicePermission
   with the specified servicePrincipal
   and action.

  service-principal - the name of the service principal. An asterisk may appear by itself, to signify any service principal. - `java.lang.String`
  action - the action string - `java.lang.String`"
  (^ServicePermission [^java.lang.String service-principal ^java.lang.String action]
    (new ServicePermission service-principal action)))

(defn implies
  "Checks if this Kerberos service permission object \"implies\" the
   specified permission.

   If none of the above are true, implies returns false.

  p - the permission to check against. - `java.security.Permission`

  returns: true if the specified permission is implied by this object,
   false if not. - `boolean`"
  (^Boolean [^ServicePermission this ^java.security.Permission p]
    (-> this (.implies p))))

(defn equals
  "Checks two ServicePermission objects for equality.

  obj - the object to test for equality with this object. - `java.lang.Object`

  returns: true if obj is a ServicePermission, and has the
    same service principal, and actions as this
   ServicePermission object. - `boolean`"
  (^Boolean [^ServicePermission this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this object.

  returns: a hash code value for this object. - `int`"
  (^Integer [^ServicePermission this]
    (-> this (.hashCode))))

(defn get-actions
  "Returns the canonical string representation of the actions.
   Always returns present actions in the following order:
   initiate, accept.

  returns: the actions of this Permission. - `java.lang.String`"
  (^java.lang.String [^ServicePermission this]
    (-> this (.getActions))))

(defn new-permission-collection
  "Returns a PermissionCollection object for storing
   ServicePermission objects.

   ServicePermission objects must be stored in a manner that
   allows them to be inserted into the collection in any order, but
   that also enables the PermissionCollection implies method to
   be implemented in an efficient (and consistent) manner.

  returns: a new PermissionCollection object suitable for storing
   ServicePermissions. - `java.security.PermissionCollection`"
  (^java.security.PermissionCollection [^ServicePermission this]
    (-> this (.newPermissionCollection))))

