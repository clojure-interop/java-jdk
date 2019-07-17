(ns jdk.lang.SecurityManager
  "The security manager is a class that allows
  applications to implement a security policy. It allows an
  application to determine, before performing a possibly unsafe or
  sensitive operation, what the operation is and whether
  it is being attempted in a security context that allows the
  operation to be performed. The
  application can allow or disallow the operation.

  The SecurityManager class contains many methods with
  names that begin with the word check. These methods
  are called by various methods in the Java libraries before those
  methods perform certain potentially sensitive operations. The
  invocation of such a check method typically looks like this:


      SecurityManager security = System.getSecurityManager();
      if (security != null) {
          security.checkXXX(argument,  . . . );
      }

  The security manager is thereby given an opportunity to prevent
  completion of the operation by throwing an exception. A security
  manager routine simply returns if the operation is permitted, but
  throws a SecurityException if the operation is not
  permitted. The only exception to this convention is
  checkTopLevelWindow, which returns a
  boolean value.

  The current security manager is set by the
  setSecurityManager method in class
  System. The current security manager is obtained
  by the getSecurityManager method.

  The special method
  checkPermission(java.security.Permission)
  determines whether an access request indicated by a specified
  permission should be granted or denied. The
  default implementation calls



    AccessController.checkPermission(perm);


  If a requested access is allowed,
  checkPermission returns quietly. If denied, a
  SecurityException is thrown.

  As of Java 2 SDK v1.2, the default implementation of each of the other
  check methods in SecurityManager is to
  call the SecurityManager checkPermission method
  to determine if the calling thread has permission to perform the requested
  operation.

  Note that the checkPermission method with
  just a single permission argument always performs security checks
  within the context of the currently executing thread.
  Sometimes a security check that should be made within a given context
  will actually need to be done from within a
  different context (for example, from within a worker thread).
  The getSecurityContext method
  and the checkPermission
  method that includes a context argument are provided
  for this situation. The
  getSecurityContext method returns a `snapshot`
  of the current calling context. (The default implementation
  returns an AccessControlContext object.) A sample call is
  the following:



    Object context = null;
    SecurityManager sm = System.getSecurityManager();
    if (sm != null) context = sm.getSecurityContext();


  The checkPermission method
  that takes a context object in addition to a permission
  makes access decisions based on that context,
  rather than on that of the current execution thread.
  Code within a different context can thus call that method,
  passing the permission and the
  previously-saved context object. A sample call, using the
  SecurityManager sm obtained as in the previous example,
  is the following:



    if (sm != null) sm.checkPermission(permission, context);

  Permissions fall into these categories: File, Socket, Net,
  Security, Runtime, Property, AWT, Reflect, and Serializable.
  The classes managing these various
  permission categories are java.io.FilePermission,
  java.net.SocketPermission,
  java.net.NetPermission,
  java.security.SecurityPermission,
  java.lang.RuntimePermission,
  java.util.PropertyPermission,
  java.awt.AWTPermission,
  java.lang.reflect.ReflectPermission, and
  java.io.SerializablePermission.

  All but the first two (FilePermission and SocketPermission) are
  subclasses of java.security.BasicPermission, which itself
  is an abstract subclass of the
  top-level class for permissions, which is
  java.security.Permission. BasicPermission defines the
  functionality needed for all permissions that contain a name
  that follows the hierarchical property naming convention
  (for example, `exitVM`, `setFactory`, `queuePrintJob`, etc).
  An asterisk
  may appear at the end of the name, following a `.`, or by itself, to
  signify a wildcard match. For example: `a.*` or `*` is valid,
  `*a` or `a*b` is not valid.

  FilePermission and SocketPermission are subclasses of the
  top-level class for permissions
  (java.security.Permission). Classes like these
  that have a more complicated name syntax than that used by
  BasicPermission subclass directly from Permission rather than from
  BasicPermission. For example,
  for a java.io.FilePermission object, the permission name is
  the path name of a file (or directory).

  Some of the permission classes have an `actions` list that tells
  the actions that are permitted for the object.  For example,
  for a java.io.FilePermission object, the actions list
  (such as `read, write`) specifies which actions are granted for the
  specified file (or for files in the specified directory).

  Other permission classes are for `named` permissions -
  ones that contain a name but no actions list; you either have the
  named permission or you don't.

  Note: There is also a java.security.AllPermission
  permission that implies all permissions. It exists to simplify the work
  of system administrators who might need to perform multiple
  tasks that require all (or numerous) permissions.

  See
  Permissions in the JDK for permission-related information.
  This document includes, for example, a table listing the various SecurityManager
  check methods and the permission(s) the default
  implementation of each such method requires.
  It also contains a table of all the version 1.2 methods
  that require permissions, and for each such method tells
  which permission it requires.

  For more information about SecurityManager changes made in
  the JDK and advice regarding porting of 1.1-style security managers,
  see the security documentation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang SecurityManager]))

(defn ->security-manager
  "Constructor.

  Constructs a new SecurityManager.

    If there is a security manager already installed, this method first
   calls the security manager's checkPermission method
   with the RuntimePermission(`createSecurityManager`)
   permission to ensure the calling thread has permission to create a new
   security manager.
   This may result in throwing a SecurityException.

  throws: java.lang.SecurityException - if a security manager already exists and its checkPermission method doesn't allow creation of a new security manager."
  ([]
    (new SecurityManager )))

(defn check-read
  "Throws a SecurityException if the
   specified security context is not allowed to read the file
   specified by the string argument. The context must be a security
   context returned by a previous call to
   getSecurityContext.
    If context is an instance of
   AccessControlContext then the
   AccessControlContext.checkPermission method will
   be invoked with the FilePermission(file,`read`) permission.
    If context is not an instance of
   AccessControlContext then a
   SecurityException is thrown.

   If you override this method, then you should make a call to
   super.checkRead
   at the point the overridden method would normally throw an
   exception.

  file - the system-dependent filename. - `java.lang.String`
  context - a system-dependent security context. - `java.lang.Object`

  throws: java.lang.SecurityException - if the specified security context is not an instance of AccessControlContext (e.g., is null), or does not have permission to read the specified file."
  ([^java.lang.SecurityManager this ^java.lang.String file ^java.lang.Object context]
    (-> this (.checkRead file context)))
  ([^java.lang.SecurityManager this ^java.io.FileDescriptor fd]
    (-> this (.checkRead fd))))

(defn check-connect
  "Throws a SecurityException if the
   specified security context is not allowed to open a socket
   connection to the specified host and port number.

   A port number of -1 indicates that the calling
   method is attempting to determine the IP address of the specified
   host name.
    If context is not an instance of
   AccessControlContext then a
   SecurityException is thrown.

   Otherwise, the port number is checked. If it is not equal
   to -1, the context's checkPermission
   method is called with a
   SocketPermission(host+`:`+port,`connect`) permission.
   If the port is equal to -1, then
   the context's checkPermission method
   is called with a
   SocketPermission(host,`resolve`) permission.

   If you override this method, then you should make a call to
   super.checkConnect
   at the point the overridden method would normally throw an
   exception.

  host - the host name port to connect to. - `java.lang.String`
  port - the protocol port to connect to. - `int`
  context - a system-dependent security context. - `java.lang.Object`

  throws: java.lang.SecurityException - if the specified security context is not an instance of AccessControlContext (e.g., is null), or does not have permission to open a socket connection to the specified host and port."
  ([^java.lang.SecurityManager this ^java.lang.String host ^Integer port ^java.lang.Object context]
    (-> this (.checkConnect host port context)))
  ([^java.lang.SecurityManager this ^java.lang.String host ^Integer port]
    (-> this (.checkConnect host port))))

(defn check-permission
  "Throws a SecurityException if the
   specified security context is denied access to the resource
   specified by the given permission.
   The context must be a security
   context returned by a previous call to
   getSecurityContext and the access control
   decision is based upon the configured security policy for
   that security context.

   If context is an instance of
   AccessControlContext then the
   AccessControlContext.checkPermission method is
   invoked with the specified permission.

   If context is not an instance of
   AccessControlContext then a
   SecurityException is thrown.

  perm - the specified permission - `java.security.Permission`
  context - a system-dependent security context. - `java.lang.Object`

  throws: java.lang.SecurityException - if the specified security context is not an instance of AccessControlContext (e.g., is null), or is denied access to the resource specified by the given permission."
  ([^java.lang.SecurityManager this ^java.security.Permission perm ^java.lang.Object context]
    (-> this (.checkPermission perm context)))
  ([^java.lang.SecurityManager this ^java.security.Permission perm]
    (-> this (.checkPermission perm))))

(defn check-exit
  "Throws a SecurityException if the
   calling thread is not allowed to cause the Java Virtual Machine to
   halt with the specified status code.

   This method is invoked for the current security manager by the
   exit method of class Runtime. A status
   of 0 indicates success; other values indicate various
   errors.

   This method calls checkPermission with the
   RuntimePermission(`exitVM.`+status) permission.

   If you override this method, then you should make a call to
   super.checkExit
   at the point the overridden method would normally throw an
   exception.

  status - the exit status. - `int`

  throws: java.lang.SecurityException - if the calling thread does not have permission to halt the Java Virtual Machine with the specified status."
  ([^java.lang.SecurityManager this ^Integer status]
    (-> this (.checkExit status))))

(defn check-accept
  "Throws a SecurityException if the
   calling thread is not permitted to accept a socket connection from
   the specified host and port number.

   This method is invoked for the current security manager by the
   accept method of class ServerSocket.

   This method calls checkPermission with the
   SocketPermission(host+`:`+port,`accept`) permission.

   If you override this method, then you should make a call to
   super.checkAccept
   at the point the overridden method would normally throw an
   exception.

  host - the host name of the socket connection. - `java.lang.String`
  port - the port number of the socket connection. - `int`

  throws: java.lang.SecurityException - if the calling thread does not have permission to accept the connection."
  ([^java.lang.SecurityManager this ^java.lang.String host ^Integer port]
    (-> this (.checkAccept host port))))

(defn get-thread-group
  "Returns the thread group into which to instantiate any new
   thread being created at the time this is being called.
   By default, it returns the thread group of the current
   thread. This should be overridden by a specific security
   manager to return the appropriate thread group.

  returns: ThreadGroup that new threads are instantiated into - `java.lang.ThreadGroup`"
  ([^java.lang.SecurityManager this]
    (-> this (.getThreadGroup))))

(defn check-system-clipboard-access
  "Deprecated. The dependency on AWTPermission creates an
               impediment to future modularization of the Java platform.
               Users of this method should instead invoke
               checkPermission(java.security.Permission) directly.
               This method will be changed in a future release to check
               the permission java.security.AllPermission.

  returns: `java.lang.  void`

  throws: java.lang.SecurityException - if the calling thread does not have permission to access the system clipboard."
  ([^java.lang.SecurityManager this]
    (-> this (.checkSystemClipboardAccess))))

(defn check-top-level-window
  "Deprecated. The dependency on AWTPermission creates an
               impediment to future modularization of the Java platform.
               Users of this method should instead invoke
               checkPermission(java.security.Permission) directly.
               This method will be changed in a future release to check
               the permission java.security.AllPermission.

  window - the new window that is being created. - `java.lang.Object`

  returns: true if the calling thread is trusted to put up
               top-level windows; false otherwise. - `java.lang.  boolean`

  throws: java.lang.NullPointerException - if the window argument is null."
  ([^java.lang.SecurityManager this ^java.lang.Object window]
    (-> this (.checkTopLevelWindow window))))

(defn check-print-job-access
  "Throws a SecurityException if the
   calling thread is not allowed to initiate a print job request.

   This method calls
   checkPermission with the
   RuntimePermission(`queuePrintJob`) permission.

   If you override this method, then you should make a call to
   super.checkPrintJobAccess
   at the point the overridden method would normally throw an
   exception.

  throws: java.lang.SecurityException - if the calling thread does not have permission to initiate a print job request."
  ([^java.lang.SecurityManager this]
    (-> this (.checkPrintJobAccess))))

(defn check-access
  "Throws a SecurityException if the
   calling thread is not allowed to modify the thread argument.

   This method is invoked for the current security manager by the
   stop, suspend, resume,
   setPriority, setName, and
   setDaemon methods of class Thread.

   If the thread argument is a system thread (belongs to
   the thread group with a null parent) then
   this method calls checkPermission with the
   RuntimePermission(`modifyThread`) permission.
   If the thread argument is not a system thread,
   this method just returns silently.

   Applications that want a stricter policy should override this
   method. If this method is overridden, the method that overrides
   it should additionally check to see if the calling thread has the
   RuntimePermission(`modifyThread`) permission, and
   if so, return silently. This is to ensure that code granted
   that permission (such as the JDK itself) is allowed to
   manipulate any thread.

   If this method is overridden, then
   super.checkAccess should
   be called by the first statement in the overridden method, or the
   equivalent security check should be placed in the overridden method.

  t - the thread to be checked. - `java.lang.Thread`

  throws: java.lang.SecurityException - if the calling thread does not have permission to modify the thread."
  ([^java.lang.SecurityManager this ^java.lang.Thread t]
    (-> this (.checkAccess t))))

(defn check-create-class-loader
  "Throws a SecurityException if the
   calling thread is not allowed to create a new class loader.

   This method calls checkPermission with the
   RuntimePermission(`createClassLoader`)
   permission.

   If you override this method, then you should make a call to
   super.checkCreateClassLoader
   at the point the overridden method would normally throw an
   exception.

  throws: java.lang.SecurityException - if the calling thread does not have permission to create a new class loader."
  ([^java.lang.SecurityManager this]
    (-> this (.checkCreateClassLoader))))

(defn get-security-context
  "Creates an object that encapsulates the current execution
   environment. The result of this method is used, for example, by the
   three-argument checkConnect method and by the
   two-argument checkRead method.
   These methods are needed because a trusted method may be called
   on to read a file or open a socket on behalf of another method.
   The trusted method needs to determine if the other (possibly
   untrusted) method would be allowed to perform the operation on its
   own.
    The default implementation of this method is to return
   an AccessControlContext object.

  returns: an implementation-dependent object that encapsulates
            sufficient information about the current execution environment
            to perform some security checks later. - `java.lang.Object`"
  ([^java.lang.SecurityManager this]
    (-> this (.getSecurityContext))))

(defn check-package-definition
  "Throws a SecurityException if the
   calling thread is not allowed to define classes in the package
   specified by the argument.

   This method is used by the loadClass method of some
   class loaders.

   This method first gets a list of restricted packages by
   obtaining a comma-separated list from a call to
   java.security.Security.getProperty(`package.definition`),
   and checks to see if pkg starts with or equals
   any of the restricted packages. If it does, then
   checkPermission gets called with the
   RuntimePermission(`defineClassInPackage.`+pkg)
   permission.

   If this method is overridden, then
   super.checkPackageDefinition should be called
   as the first line in the overridden method.

  pkg - the package name. - `java.lang.String`

  throws: java.lang.SecurityException - if the calling thread does not have permission to define classes in the specified package."
  ([^java.lang.SecurityManager this ^java.lang.String pkg]
    (-> this (.checkPackageDefinition pkg))))

(defn check-delete
  "Throws a SecurityException if the
   calling thread is not allowed to delete the specified file.

   This method is invoked for the current security manager by the
   delete method of class File.

   This method calls checkPermission with the
   FilePermission(file,`delete`) permission.

   If you override this method, then you should make a call to
   super.checkDelete
   at the point the overridden method would normally throw an
   exception.

  file - the system-dependent filename. - `java.lang.String`

  throws: java.lang.SecurityException - if the calling thread does not have permission to delete the file."
  ([^java.lang.SecurityManager this ^java.lang.String file]
    (-> this (.checkDelete file))))

(defn check-property-access
  "Throws a SecurityException if the
   calling thread is not allowed to access the system property with
   the specified key name.

   This method is used by the getProperty method of
   class System.

   This method calls checkPermission with the
   PropertyPermission(key, `read`) permission.

   If you override this method, then you should make a call to
   super.checkPropertyAccess
   at the point the overridden method would normally throw an
   exception.

  key - a system property key. - `java.lang.String`

  throws: java.lang.SecurityException - if the calling thread does not have permission to access the specified system property."
  ([^java.lang.SecurityManager this ^java.lang.String key]
    (-> this (.checkPropertyAccess key))))

(defn check-properties-access
  "Throws a SecurityException if the
   calling thread is not allowed to access or modify the system
   properties.

   This method is used by the getProperties and
   setProperties methods of class System.

   This method calls checkPermission with the
   PropertyPermission(`*`, `read,write`) permission.

   If you override this method, then you should make a call to
   super.checkPropertiesAccess
   at the point the overridden method would normally throw an
   exception.

  throws: java.lang.SecurityException - if the calling thread does not have permission to access or modify the system properties."
  ([^java.lang.SecurityManager this]
    (-> this (.checkPropertiesAccess))))

(defn check-listen
  "Throws a SecurityException if the
   calling thread is not allowed to wait for a connection request on
   the specified local port number.

   This method calls checkPermission with the
   SocketPermission(`localhost:`+port,`listen`).

   If you override this method, then you should make a call to
   super.checkListen
   at the point the overridden method would normally throw an
   exception.

  port - the local port. - `int`

  throws: java.lang.SecurityException - if the calling thread does not have permission to listen on the specified port."
  ([^java.lang.SecurityManager this ^Integer port]
    (-> this (.checkListen port))))

(defn check-security-access
  "Determines whether the permission with the specified permission target
   name should be granted or denied.

    If the requested permission is allowed, this method returns
   quietly. If denied, a SecurityException is raised.

    This method creates a SecurityPermission object for
   the given permission target name and calls checkPermission
   with it.

    See the documentation for
   SecurityPermission for
   a list of possible permission target names.

    If you override this method, then you should make a call to
   super.checkSecurityAccess
   at the point the overridden method would normally throw an
   exception.

  target - the target name of the SecurityPermission. - `java.lang.String`

  throws: java.lang.SecurityException - if the calling thread does not have permission for the requested access."
  ([^java.lang.SecurityManager this ^java.lang.String target]
    (-> this (.checkSecurityAccess target))))

(defn check-multicast
  "Throws a SecurityException if the
   calling thread is not allowed to use
   (join/leave/send/receive) IP multicast.

   This method calls checkPermission with the
   java.net.SocketPermission(maddr.getHostAddress(),
   `accept,connect`) permission.

   If you override this method, then you should make a call to
   super.checkMulticast
   at the point the overridden method would normally throw an
   exception.

  maddr - Internet group address to be used. - `java.net.InetAddress`

  throws: java.lang.SecurityException - if the calling thread is not allowed to use (join/leave/send/receive) IP multicast."
  ([^java.lang.SecurityManager this ^java.net.InetAddress maddr]
    (-> this (.checkMulticast maddr)))
  ([^java.lang.SecurityManager this ^java.net.InetAddress maddr ^Byte ttl]
    (-> this (.checkMulticast maddr ttl))))

(defn check-exec
  "Throws a SecurityException if the
   calling thread is not allowed to create a subprocess.

   This method is invoked for the current security manager by the
   exec methods of class Runtime.

   This method calls checkPermission with the
   FilePermission(cmd,`execute`) permission
   if cmd is an absolute path, otherwise it calls
   checkPermission with
   FilePermission(`<<ALL FILES>>`,`execute`).

   If you override this method, then you should make a call to
   super.checkExec
   at the point the overridden method would normally throw an
   exception.

  cmd - the specified system command. - `java.lang.String`

  throws: java.lang.SecurityException - if the calling thread does not have permission to create a subprocess."
  ([^java.lang.SecurityManager this ^java.lang.String cmd]
    (-> this (.checkExec cmd))))

(defn check-link
  "Throws a SecurityException if the
   calling thread is not allowed to dynamic link the library code
   specified by the string argument file. The argument is either a
   simple library name or a complete filename.

   This method is invoked for the current security manager by
   methods load and loadLibrary of class
   Runtime.

   This method calls checkPermission with the
   RuntimePermission(`loadLibrary.`+lib) permission.

   If you override this method, then you should make a call to
   super.checkLink
   at the point the overridden method would normally throw an
   exception.

  lib - the name of the library. - `java.lang.String`

  throws: java.lang.SecurityException - if the calling thread does not have permission to dynamically link the library."
  ([^java.lang.SecurityManager this ^java.lang.String lib]
    (-> this (.checkLink lib))))

(defn check-write
  "Throws a SecurityException if the
   calling thread is not allowed to write to the specified file
   descriptor.

   This method calls checkPermission with the
   RuntimePermission(`writeFileDescriptor`)
   permission.

   If you override this method, then you should make a call to
   super.checkWrite
   at the point the overridden method would normally throw an
   exception.

  fd - the system-dependent file descriptor. - `java.io.FileDescriptor`

  throws: java.lang.SecurityException - if the calling thread does not have permission to access the specified file descriptor."
  ([^java.lang.SecurityManager this ^java.io.FileDescriptor fd]
    (-> this (.checkWrite fd))))

(defn check-package-access
  "Throws a SecurityException if the
   calling thread is not allowed to access the package specified by
   the argument.

   This method is used by the loadClass method of class
   loaders.

   This method first gets a list of
   restricted packages by obtaining a comma-separated list from
   a call to
   java.security.Security.getProperty(`package.access`),
   and checks to see if pkg starts with or equals
   any of the restricted packages. If it does, then
   checkPermission gets called with the
   RuntimePermission(`accessClassInPackage.`+pkg)
   permission.

   If this method is overridden, then
   super.checkPackageAccess should be called
   as the first line in the overridden method.

  pkg - the package name. - `java.lang.String`

  throws: java.lang.SecurityException - if the calling thread does not have permission to access the specified package."
  ([^java.lang.SecurityManager this ^java.lang.String pkg]
    (-> this (.checkPackageAccess pkg))))

(defn get-in-check
  "Deprecated. This type of security checking is not recommended.
    It is recommended that the checkPermission
    call be used instead.

  returns: the value of the inCheck field. This field
            should contain true if a security check is
            in progress,
            false otherwise. - `java.lang.  boolean`"
  ([^java.lang.SecurityManager this]
    (-> this (.getInCheck))))

(defn check-awt-event-queue-access
  "Deprecated. The dependency on AWTPermission creates an
               impediment to future modularization of the Java platform.
               Users of this method should instead invoke
               checkPermission(java.security.Permission) directly.
               This method will be changed in a future release to check
               the permission java.security.AllPermission.

  returns: `java.lang.  void`

  throws: java.lang.SecurityException - if the calling thread does not have permission to access the AWT event queue."
  ([^java.lang.SecurityManager this]
    (-> this (.checkAwtEventQueueAccess))))

(defn check-member-access
  "Deprecated. This method relies on the caller being at a stack depth
               of 4 which is error-prone and cannot be enforced by the runtime.
               Users of this method should instead invoke checkPermission(java.security.Permission)
               directly.  This method will be changed in a future release
               to check the permission java.security.AllPermission.

  clazz - the class that reflection is to be performed on. - `java.lang.Class<?>`
  which - type of access, PUBLIC or DECLARED. - `int`

  returns: `java.lang.  void`

  throws: java.lang.SecurityException - if the caller does not have permission to access members."
  ([^java.lang.SecurityManager this ^java.lang.Class clazz ^Integer which]
    (-> this (.checkMemberAccess clazz which))))

(defn check-set-factory
  "Throws a SecurityException if the
   calling thread is not allowed to set the socket factory used by
   ServerSocket or Socket, or the stream
   handler factory used by URL.

   This method calls checkPermission with the
   RuntimePermission(`setFactory`) permission.

   If you override this method, then you should make a call to
   super.checkSetFactory
   at the point the overridden method would normally throw an
   exception.

  throws: java.lang.SecurityException - if the calling thread does not have permission to specify a socket factory or a stream handler factory."
  ([^java.lang.SecurityManager this]
    (-> this (.checkSetFactory))))

