(ns jdk.lang.reflect.ReflectPermission
  "The Permission class for reflective operations.

  The following table
  provides a summary description of what the permission allows,
  and discusses the risks of granting code the permission.



  Permission Target Name
  What the Permission Allows
  Risks of Allowing this Permission



    suppressAccessChecks
    ability to suppress the standard Java language access checks
        on fields and methods in a class; allow access not only public members
        but also allow access to default (package) access, protected,
        and private members.
    This is dangerous in that information (possibly confidential) and
        methods normally unavailable would be accessible to malicious code.


    newProxyInPackage.{package name}
    ability to create a proxy instance in the specified package of which
        the non-public interface that the proxy class implements.
    This gives code access to classes in packages to which it normally
        does not have access and the dynamic proxy class is in the system
        protection domain. Malicious code may use these classes to
        help in its attempt to compromise security in the system."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect ReflectPermission]))

(defn ->reflect-permission
  "Constructor.

  Constructs a ReflectPermission with the specified name and actions.
   The actions should be null; they are ignored.

  name - the name of the ReflectPermission - `java.lang.String`
  actions - should be null - `java.lang.String`

  throws: java.lang.NullPointerException - if name is null."
  (^ReflectPermission [^java.lang.String name ^java.lang.String actions]
    (new ReflectPermission name actions))
  (^ReflectPermission [^java.lang.String name]
    (new ReflectPermission name)))

