(ns jdk.lang.System
  "The System class contains several useful class fields
  and methods. It cannot be instantiated.

  Among the facilities provided by the System class
  are standard input, standard output, and error output streams;
  access to externally defined properties and environment
  variables; a means of loading files and libraries; and a utility
  method for quickly copying a portion of an array."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang System]))

(def *-in
  "Static Constant.

  The `standard` input stream. This stream is already
   open and ready to supply input data. Typically this stream
   corresponds to keyboard input or another input source specified by
   the host environment or user.

  type: java.io.InputStream"
  System/in)

(def *-out
  "Static Constant.

  The `standard` output stream. This stream is already
   open and ready to accept output data. Typically this stream
   corresponds to display output or another output destination
   specified by the host environment or user.

   For simple stand-alone Java applications, a typical way to write
   a line of output data is:


       System.out.println(data)

   See the println methods in class PrintStream.

  type: java.io.PrintStream"
  System/out)

(def *-err
  "Static Constant.

  The `standard` error output stream. This stream is already
   open and ready to accept output data.

   Typically this stream corresponds to display output or another
   output destination specified by the host environment or user. By
   convention, this output stream is used to display error messages
   or other information that should come to the immediate attention
   of a user even if the principal output stream, the value of the
   variable out, has been redirected to a file or other
   destination that is typically not continuously monitored.

  type: java.io.PrintStream"
  System/err)

(defn *set-security-manager
  "Sets the System security.

    If there is a security manager already installed, this method first
   calls the security manager's checkPermission method
   with a RuntimePermission(`setSecurityManager`)
   permission to ensure it's ok to replace the existing
   security manager.
   This may result in throwing a SecurityException.

    Otherwise, the argument is established as the current
   security manager. If the argument is null and no
   security manager has been established, then no action is taken and
   the method simply returns.

  s - the security manager. - `java.lang.SecurityManager`

  throws: java.lang.SecurityException - if the security manager has already been set and its checkPermission method doesn't allow it to be replaced."
  ([s]
    (System/setSecurityManager s)))

(defn *map-library-name
  "Maps a library name into a platform-specific string representing
   a native library.

  libname - the name of the library. - `java.lang.String`

  returns: a platform-dependent native library name. - `java.lang.String`

  throws: java.lang.NullPointerException - if libname is null"
  ([libname]
    (System/mapLibraryName libname)))

(defn *arraycopy
  "Copies an array from the specified source array, beginning at the
   specified position, to the specified position of the destination array.
   A subsequence of array components are copied from the source
   array referenced by src to the destination array
   referenced by dest. The number of components copied is
   equal to the length argument. The components at
   positions srcPos through
   srcPos+length-1 in the source array are copied into
   positions destPos through
   destPos+length-1, respectively, of the destination
   array.

   If the src and dest arguments refer to the
   same array object, then the copying is performed as if the
   components at positions srcPos through
   srcPos+length-1 were first copied to a temporary
   array with length components and then the contents of
   the temporary array were copied into positions
   destPos through destPos+length-1 of the
   destination array.

   If dest is null, then a
   NullPointerException is thrown.

   If src is null, then a
   NullPointerException is thrown and the destination
   array is not modified.

   Otherwise, if any of the following is true, an
   ArrayStoreException is thrown and the destination is
   not modified:

   The src argument refers to an object that is not an
       array.
   The dest argument refers to an object that is not an
       array.
   The src argument and dest argument refer
       to arrays whose component types are different primitive types.
   The src argument refers to an array with a primitive
      component type and the dest argument refers to an array
       with a reference component type.
   The src argument refers to an array with a reference
      component type and the dest argument refers to an array
       with a primitive component type.


   Otherwise, if any of the following is true, an
   IndexOutOfBoundsException is
   thrown and the destination is not modified:

   The srcPos argument is negative.
   The destPos argument is negative.
   The length argument is negative.
   srcPos+length is greater than
       src.length, the length of the source array.
   destPos+length is greater than
       dest.length, the length of the destination array.


   Otherwise, if any actual component of the source array from
   position srcPos through
   srcPos+length-1 cannot be converted to the component
   type of the destination array by assignment conversion, an
   ArrayStoreException is thrown. In this case, let
   k be the smallest nonnegative integer less than
   length such that src[srcPos+k]
   cannot be converted to the component type of the destination
   array; when the exception is thrown, source array components from
   positions srcPos through
   srcPos+k-1
   will already have been copied to destination array positions
   destPos through
   destPos+k-1 and no other
   positions of the destination array will have been modified.
   (Because of the restrictions already itemized, this
   paragraph effectively applies only to the situation where both
   arrays have component types that are reference types.)

  src - the source array. - `java.lang.Object`
  src-pos - starting position in the source array. - `int`
  dest - the destination array. - `java.lang.Object`
  dest-pos - starting position in the destination data. - `int`
  length - the number of array elements to be copied. - `int`

  throws: java.lang.IndexOutOfBoundsException - if copying would cause access of data outside array bounds."
  ([src src-pos dest dest-pos length]
    (System/arraycopy src src-pos dest dest-pos length)))

(defn *inherited-channel
  "Returns the channel inherited from the entity that created this
   Java virtual machine.

    This method returns the channel obtained by invoking the
   inheritedChannel method of the system-wide default
   SelectorProvider object.

    In addition to the network-oriented channels described in
   inheritedChannel, this method may return other kinds of
   channels in the future.

  returns: The inherited channel, if any, otherwise null. - `java.nio.channels.Channel`

  throws: java.io.IOException - If an I/O error occurs"
  ([]
    (System/inheritedChannel )))

(defn *load
  "Loads the native library specified by the filename argument.  The filename
   argument must be an absolute path name.

   If the filename argument, when stripped of any platform-specific library
   prefix, path, and file extension, indicates a library whose name is,
   for example, L, and a native library called L is statically linked
   with the VM, then the JNI_OnLoad_L function exported by the library
   is invoked rather than attempting to load a dynamic library.
   A filename matching the argument does not have to exist in the
   file system.
   See the JNI Specification for more details.

   Otherwise, the filename argument is mapped to a native library image in
   an implementation-dependent manner.


   The call System.load(name) is effectively equivalent
   to the call:


   Runtime.getRuntime().load(name)

  filename - the file to load. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkLink method doesn't allow loading of the specified dynamic library"
  ([filename]
    (System/load filename)))

(defn *run-finalizers-on-exit
  "Deprecated. This method is inherently unsafe.  It may result in
        finalizers being called on live objects while other threads are
        concurrently manipulating those objects, resulting in erratic
        behavior or deadlock.

  value - indicating enabling or disabling of finalization - `boolean`

  returns: `java.lang.   void`

  throws: java.lang.SecurityException - if a security manager exists and its checkExit method doesn't allow the exit."
  ([value]
    (System/runFinalizersOnExit value)))

(defn *clear-property
  "Removes the system property indicated by the specified key.

   First, if a security manager exists, its
   SecurityManager.checkPermission method
   is called with a PropertyPermission(key, `write`)
   permission. This may result in a SecurityException being thrown.
   If no exception is thrown, the specified property is removed.

  key - the name of the system property to be removed. - `java.lang.String`

  returns: the previous string value of the system property,
               or null if there was no property with that key. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertyAccess method doesn't allow access to the specified system property."
  ([key]
    (System/clearProperty key)))

(defn *current-time-millis
  "Returns the current time in milliseconds.  Note that
   while the unit of time of the return value is a millisecond,
   the granularity of the value depends on the underlying
   operating system and may be larger.  For example, many
   operating systems measure time in units of tens of
   milliseconds.

    See the description of the class Date for
   a discussion of slight discrepancies that may arise between
   `computer time` and coordinated universal time (UTC).

  returns: the difference, measured in milliseconds, between
            the current time and midnight, January 1, 1970 UTC. - `long`"
  ([]
    (System/currentTimeMillis )))

(defn *get-security-manager
  "Gets the system security interface.

  returns: if a security manager has already been established for the
            current application, then that security manager is returned;
            otherwise, null is returned. - `java.lang.SecurityManager`"
  ([]
    (System/getSecurityManager )))

(defn *set-in
  "Reassigns the `standard` input stream.

   First, if there is a security manager, its checkPermission
   method is called with a RuntimePermission(`setIO`) permission
    to see if it's ok to reassign the `standard` input stream.

  in - the new standard input stream. - `java.io.InputStream`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow reassigning of the standard input stream."
  ([in]
    (System/setIn in)))

(defn *console
  "Returns the unique Console object associated
   with the current Java virtual machine, if any.

  returns: The system console, if any, otherwise null. - `java.io.Console`"
  ([]
    (System/console )))

(defn *getenv
  "Gets the value of the specified environment variable. An
   environment variable is a system-dependent external named
   value.

   If a security manager exists, its
   checkPermission
   method is called with a
   RuntimePermission(`getenv.`+name)
   permission.  This may result in a SecurityException
   being thrown.  If no exception is thrown the value of the
   variable name is returned.

   System
   properties and environment variables are both
   conceptually mappings between names and values.  Both
   mechanisms can be used to pass user-defined information to a
   Java process.  Environment variables have a more global effect,
   because they are visible to all descendants of the process
   which defines them, not just the immediate Java subprocess.
   They can have subtly different semantics, such as case
   insensitivity, on different operating systems.  For these
   reasons, environment variables are more likely to have
   unintended side effects.  It is best to use system properties
   where possible.  Environment variables should be used when a
   global effect is desired, or when an external system interface
   requires an environment variable (such as PATH).

   On UNIX systems the alphabetic case of name is
   typically significant, while on Microsoft Windows systems it is
   typically not.  For example, the expression
   System.getenv(`FOO`).equals(System.getenv(`foo`))
   is likely to be true on Microsoft Windows.

  name - the name of the environment variable - `java.lang.String`

  returns: the string value of the variable, or null
           if the variable is not defined in the system environment - `java.lang.String`

  throws: java.lang.NullPointerException - if name is null"
  ([name]
    (System/getenv name))
  ([]
    (System/getenv )))

(defn *get-properties
  "Determines the current system properties.

   First, if there is a security manager, its
   checkPropertiesAccess method is called with no
   arguments. This may result in a security exception.

   The current set of system properties for use by the
   getProperty(String) method is returned as a
   Properties object. If there is no current set of
   system properties, a set of system properties is first created and
   initialized. This set of system properties always includes values
   for the following keys:

   Key
       Description of Associated Value
   java.version
       Java Runtime Environment version
   java.vendor
       Java Runtime Environment vendor
   java.vendor.url
       Java vendor URL
   java.home
       Java installation directory
   java.vm.specification.version
       Java Virtual Machine specification version
   java.vm.specification.vendor
       Java Virtual Machine specification vendor
   java.vm.specification.name
       Java Virtual Machine specification name
   java.vm.version
       Java Virtual Machine implementation version
   java.vm.vendor
       Java Virtual Machine implementation vendor
   java.vm.name
       Java Virtual Machine implementation name
   java.specification.version
       Java Runtime Environment specification  version
   java.specification.vendor
       Java Runtime Environment specification  vendor
   java.specification.name
       Java Runtime Environment specification  name
   java.class.version
       Java class format version number
   java.class.path
       Java class path
   java.library.path
       List of paths to search when loading libraries
   java.io.tmpdir
       Default temp file path
   java.compiler
       Name of JIT compiler to use
   java.ext.dirs
       Path of extension directory or directories
           Deprecated. This property, and the mechanism
              which implements it, may be removed in a future
              release.
   os.name
       Operating system name
   os.arch
       Operating system architecture
   os.version
       Operating system version
   file.separator
       File separator (`/` on UNIX)
   path.separator
       Path separator (`:` on UNIX)
   line.separator
       Line separator (`\n` on UNIX)
   user.name
       User's account name
   user.home
       User's home directory
   user.dir
       User's current working directory


   Multiple paths in a system property value are separated by the path
   separator character of the platform.

   Note that even if the security manager does not permit the
   getProperties operation, it may choose to permit the
   getProperty(String) operation.

  returns: the system properties - `java.util.Properties`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to the system properties."
  ([]
    (System/getProperties )))

(defn *nano-time
  "Returns the current value of the running Java Virtual Machine's
   high-resolution time source, in nanoseconds.

   This method can only be used to measure elapsed time and is
   not related to any other notion of system or wall-clock time.
   The value returned represents nanoseconds since some fixed but
   arbitrary origin time (perhaps in the future, so values
   may be negative).  The same origin is used by all invocations of
   this method in an instance of a Java virtual machine; other
   virtual machine instances are likely to use a different origin.

   This method provides nanosecond precision, but not necessarily
   nanosecond resolution (that is, how frequently the value changes)
   - no guarantees are made except that the resolution is at least as
   good as that of currentTimeMillis().

   Differences in successive calls that span greater than
   approximately 292 years (263 nanoseconds) will not
   correctly compute elapsed time due to numerical overflow.

   The values returned by this method become meaningful only when
   the difference between two such values, obtained within the same
   instance of a Java virtual machine, is computed.

    For example, to measure how long some code takes to execute:


   long startTime = System.nanoTime();
   // ... the code being measured ...
   long estimatedTime = System.nanoTime() - startTime;

   To compare two nanoTime values


   long t0 = System.nanoTime();
   ...
   long t1 = System.nanoTime();

   one should use t1 - t0 < 0, not t1 < t0,
   because of the possibility of numerical overflow.

  returns: the current value of the running Java Virtual Machine's
           high-resolution time source, in nanoseconds - `long`"
  ([]
    (System/nanoTime )))

(defn *load-library
  "Loads the native library specified by the libname
   argument.  The libname argument must not contain any platform
   specific prefix, file extension or path. If a native library
   called libname is statically linked with the VM, then the
   JNI_OnLoad_libname function exported by the library is invoked.
   See the JNI Specification for more details.

   Otherwise, the libname argument is loaded from a system library
   location and mapped to a native library image in an implementation-
   dependent manner.

   The call System.loadLibrary(name) is effectively
   equivalent to the call


   Runtime.getRuntime().loadLibrary(name)

  libname - the name of the library. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkLink method doesn't allow loading of the specified dynamic library"
  ([libname]
    (System/loadLibrary libname)))

(defn *set-err
  "Reassigns the `standard` error output stream.

   First, if there is a security manager, its checkPermission
   method is called with a RuntimePermission(`setIO`) permission
    to see if it's ok to reassign the `standard` error output stream.

  err - the new standard error output stream. - `java.io.PrintStream`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow reassigning of the standard error output stream."
  ([err]
    (System/setErr err)))

(defn *set-properties
  "Sets the system properties to the Properties
   argument.

   First, if there is a security manager, its
   checkPropertiesAccess method is called with no
   arguments. This may result in a security exception.

   The argument becomes the current set of system properties for use
   by the getProperty(String) method. If the argument is
   null, then the current set of system properties is
   forgotten.

  props - the new system properties. - `java.util.Properties`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to the system properties."
  ([props]
    (System/setProperties props)))

(defn *identity-hash-code
  "Returns the same hash code for the given object as
   would be returned by the default method hashCode(),
   whether or not the given object's class overrides
   hashCode().
   The hash code for the null reference is zero.

  x - object for which the hashCode is to be calculated - `java.lang.Object`

  returns: the hashCode - `int`"
  ([x]
    (System/identityHashCode x)))

(defn *get-property
  "Gets the system property indicated by the specified key.

   First, if there is a security manager, its
   checkPropertyAccess method is called with the
   key as its argument.

   If there is no current set of system properties, a set of system
   properties is first created and initialized in the same manner as
   for the getProperties method.

  key - the name of the system property. - `java.lang.String`
  def - a default value. - `java.lang.String`

  returns: the string value of the system property,
               or the default value if there is no property with that key. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertyAccess method doesn't allow access to the specified system property."
  ([key def]
    (System/getProperty key def))
  ([key]
    (System/getProperty key)))

(defn *line-separator
  "Returns the system-dependent line separator string.  It always
   returns the same value - the initial value of the system property line.separator.

   On UNIX systems, it returns `\n`; on Microsoft
   Windows systems it returns `\r\n`.

  returns: the system-dependent line separator string - `java.lang.String`"
  ([]
    (System/lineSeparator )))

(defn *exit
  "Terminates the currently running Java Virtual Machine. The
   argument serves as a status code; by convention, a nonzero status
   code indicates abnormal termination.

   This method calls the exit method in class
   Runtime. This method never returns normally.

   The call System.exit(n) is effectively equivalent to
   the call:


   Runtime.getRuntime().exit(n)

  status - exit status. - `int`

  throws: java.lang.SecurityException - if a security manager exists and its checkExit method doesn't allow exit with the specified status."
  ([status]
    (System/exit status)))

(defn *set-property
  "Sets the system property indicated by the specified key.

   First, if a security manager exists, its
   SecurityManager.checkPermission method
   is called with a PropertyPermission(key, `write`)
   permission. This may result in a SecurityException being thrown.
   If no exception is thrown, the specified property is set to the given
   value.

  key - the name of the system property. - `java.lang.String`
  value - the value of the system property. - `java.lang.String`

  returns: the previous value of the system property,
               or null if it did not have one. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow setting of the specified property."
  ([key value]
    (System/setProperty key value)))

(defn *run-finalization
  "Runs the finalization methods of any objects pending finalization.

   Calling this method suggests that the Java Virtual Machine expend
   effort toward running the finalize methods of objects
   that have been found to be discarded but whose finalize
   methods have not yet been run. When control returns from the
   method call, the Java Virtual Machine has made a best effort to
   complete all outstanding finalizations.

   The call System.runFinalization() is effectively
   equivalent to the call:


   Runtime.getRuntime().runFinalization()"
  ([]
    (System/runFinalization )))

(defn *gc
  "Runs the garbage collector.

   Calling the gc method suggests that the Java Virtual
   Machine expend effort toward recycling unused objects in order to
   make the memory they currently occupy available for quick reuse.
   When control returns from the method call, the Java Virtual
   Machine has made a best effort to reclaim space from all discarded
   objects.

   The call System.gc() is effectively equivalent to the
   call:


   Runtime.getRuntime().gc()"
  ([]
    (System/gc )))

(defn *set-out
  "Reassigns the `standard` output stream.

   First, if there is a security manager, its checkPermission
   method is called with a RuntimePermission(`setIO`) permission
    to see if it's ok to reassign the `standard` output stream.

  out - the new standard output stream - `java.io.PrintStream`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow reassigning of the standard output stream."
  ([out]
    (System/setOut out)))

