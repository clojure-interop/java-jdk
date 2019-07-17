(ns javax.management.MBeanPermission
  "Permission controlling access to MBeanServer operations.  If a
  security manager has been set using System.setSecurityManager(java.lang.SecurityManager), most operations on the MBean Server
  require that the caller's permissions imply an MBeanPermission
  appropriate for the operation.  This is described in detail in the
  documentation for the MBeanServer interface.

  As with other Permission objects, an MBeanPermission can
  represent either a permission that you have or a
  permission that you need.  When a sensitive operation is
  being checked for permission, an MBeanPermission is constructed
  representing the permission you need.  The operation is only
  allowed if the permissions you have imply the
  permission you need.

  An MBeanPermission contains four items of information:



  The action.  For a permission you need,
  this is one of the actions in the list below.  For a permission you have, this is
  a comma-separated list of those actions, or *,
  representing all actions.

  The action is returned by getActions().

  The class name.

  For a permission you need, this is the class name of an MBean
  you are accessing, as returned by MBeanServer.getMBeanInfo(name).getClassName().  Certain operations do not reference a class name,
  in which case the class name is null.

  For a permission you have, this is either empty or a class
  name pattern.  A class name pattern is a string following the
  Java conventions for dot-separated class names.  It may end with
  `.*` meaning that the permission grants access to any
  class that begins with the string preceding `.*`.  For
  instance, `javax.management.*` grants access to
  javax.management.MBeanServerDelegate and
  javax.management.timer.Timer, among other classes.

  A class name pattern can also be empty or the single character
  `*`, both of which grant access to any class.

  The member.

  For a permission you need, this is the name of the attribute or
  operation you are accessing.  For operations that do not reference
  an attribute or operation, the member is null.

  For a permission you have, this is either the name of an attribute
  or operation you can access, or it is empty or the single character
  `*`, both of which grant access to any member.

  The object name.

  For a permission you need, this is the ObjectName of the
  MBean you are accessing.  For operations that do not reference a
  single MBean, it is null.  It is never an object name pattern.

  For a permission you have, this is the ObjectName of the
  MBean or MBeans you can access.  It may be an object name pattern
  to grant access to all MBeans whose names match the pattern.  It
  may also be empty, which grants access to all MBeans whatever their
  name.



  If you have an MBeanPermission, it allows operations only if all
  four of the items match.

  The class name, member, and object name can be written together
  as a single string, which is the name of this permission.
  The name of the permission is the string returned by getName().  The format of the string is:


  className#member[objectName]


  The object name is written using the usual syntax for ObjectName.  It may contain any legal characters, including
  ].  It is terminated by a ] character
  that is the last character in the string.

  One or more of the className, member,
  or objectName may be omitted.  If the
  member is omitted, the # may be too (but
  does not have to be).  If the objectName is omitted,
  the [] may be too (but does not have to be).  It is
  not legal to omit all three items, that is to have a name
  that is the empty string.

  One or more of the className, member,
  or objectName may be the character `-`,
  which is equivalent to a null value.  A null value is implied by
  any value (including another null value) but does not imply any
  other value.

  The possible actions are these:


  addNotificationListener
  getAttribute
  getClassLoader
  getClassLoaderFor
  getClassLoaderRepository
  getDomains
  getMBeanInfo
  getObjectInstance
  instantiate
  invoke
  isInstanceOf
  queryMBeans
  queryNames
  registerMBean
  removeNotificationListener
  setAttribute
  unregisterMBean


  In a comma-separated list of actions, spaces are allowed before
  and after each action."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanPermission]))

(defn ->m-bean-permission
  "Constructor.

  Create a new MBeanPermission object with the specified target name
   (class name, member, object name) and actions.

   The class name, member and object name parameters define a
   target name of the form
   `className#member[objectName]` where each part is
   optional.  This will be the result of Permission.getName() on the
   resultant MBeanPermission.

   The actions parameter contains a comma-separated list of the
   desired actions granted on the target name.  It must not be
   empty or null.

  class-name - the class name to which this permission applies. May be null or `-`, which represents a class name that is implied by any class name but does not imply any other class name. - `java.lang.String`
  member - the member to which this permission applies. May be null or `-`, which represents a member that is implied by any member but does not imply any other member. - `java.lang.String`
  object-name - the object name to which this permission applies. May be null, which represents an object name that is implied by any object name but does not imply any other object name. - `javax.management.ObjectName`
  actions - the action string. - `java.lang.String`"
  ([class-name member object-name actions]
    (new MBeanPermission class-name member object-name actions))
  ([name actions]
    (new MBeanPermission name actions)))

(defn get-actions
  "Returns the `canonical string representation` of the actions. That is,
   this method always returns present actions in alphabetical order.

  returns: the canonical string representation of the actions. - `java.lang.String`"
  ([this]
    (-> this (.getActions))))

(defn hash-code
  "Returns the hash code value for this object.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn implies
  "Checks if this MBeanPermission object `implies` the
   specified permission.

   More specifically, this method returns true if:



    p is an instance of MBeanPermission; and

    p has a null className or p's className
   matches this object's className; and

    p has a null member or p's member matches this
   object's member; and

    p has a null object name or p's
   object name matches this object's object name; and

    p's actions are a subset of this object's actions



   If this object's className is `*`, p's
   className always matches it.  If it is `a.*`, p's
   className matches it if it begins with `a.`.

   If this object's member is `*`, p's
   member always matches it.

   If this object's objectName n1 is an object name pattern,
   p's objectName n2 matches it if
   n1.equals(n2) or if
   n1.apply(n2).

   A permission that includes the queryMBeans action
   is considered to include queryNames as well.

  p - the permission to check against. - `java.security.Permission`

  returns: true if the specified permission is implied by this object,
   false if not. - `boolean`"
  ([this p]
    (-> this (.implies p))))

(defn equals
  "Checks two MBeanPermission objects for equality. Checks
   that obj is an MBeanPermission, and has the same
   name and actions as this object.

  obj - the object we are testing for equality with this object. - `java.lang.Object`

  returns: true if obj is an MBeanPermission, and has the
   same name and actions as this MBeanPermission object. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

