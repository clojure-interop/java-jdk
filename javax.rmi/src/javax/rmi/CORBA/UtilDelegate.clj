(ns javax.rmi.CORBA.UtilDelegate
  "Supports delegation for method implementations in Util.  The
  delegate is a singleton instance of a class that implements this
  interface and provides a replacement implementation for all the
  methods of javax.rmi.CORBA.Util.

  Delegation is enabled by providing the delegate's class name as the
  value of the
  javax.rmi.CORBA.UtilClass
  system property."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.rmi.CORBA UtilDelegate]))

(defn local?
  "Delegation call for Util.isLocal(javax.rmi.CORBA.Stub).

  stub - `javax.rmi.CORBA.Stub`

  returns: `boolean`

  throws: java.rmi.RemoteException"
  (^Boolean [^UtilDelegate this ^javax.rmi.CORBA.Stub stub]
    (-> this (.isLocal stub))))

(defn register-target
  "Delegation call for Util.registerTarget(javax.rmi.CORBA.Tie, java.rmi.Remote).

  tie - `javax.rmi.CORBA.Tie`
  target - `java.rmi.Remote`"
  ([^UtilDelegate this ^javax.rmi.CORBA.Tie tie ^java.rmi.Remote target]
    (-> this (.registerTarget tie target))))

(defn copy-objects
  "Delegation call for Util.copyObjects(java.lang.Object[], org.omg.CORBA.ORB).

  obj - `java.lang.Object[]`
  orb - `org.omg.CORBA.ORB`

  returns: `java.lang.Object[]`

  throws: java.rmi.RemoteException"
  ([^UtilDelegate this obj ^org.omg.CORBA.ORB orb]
    (-> this (.copyObjects obj orb))))

(defn copy-object
  "Delegation call for Util.copyObject(java.lang.Object, org.omg.CORBA.ORB).

  obj - `java.lang.Object`
  orb - `org.omg.CORBA.ORB`

  returns: `java.lang.Object`

  throws: java.rmi.RemoteException"
  (^java.lang.Object [^UtilDelegate this ^java.lang.Object obj ^org.omg.CORBA.ORB orb]
    (-> this (.copyObject obj orb))))

(defn write-any
  "Delegation call for Util.writeAny(org.omg.CORBA.portable.OutputStream, java.lang.Object).

  out - `org.omg.CORBA.portable.OutputStream`
  obj - `java.lang.Object`"
  ([^UtilDelegate this ^org.omg.CORBA.portable.OutputStream out ^java.lang.Object obj]
    (-> this (.writeAny out obj))))

(defn write-abstract-object
  "Delegation call for Util.writeAbstractObject(org.omg.CORBA.portable.OutputStream, java.lang.Object).

  out - `org.omg.CORBA.portable.OutputStream`
  obj - `java.lang.Object`"
  ([^UtilDelegate this ^org.omg.CORBA.portable.OutputStream out ^java.lang.Object obj]
    (-> this (.writeAbstractObject out obj))))

(defn unexport-object
  "Delegation call for Util.unexportObject(java.rmi.Remote).

  target - `java.rmi.Remote`

  throws: java.rmi.NoSuchObjectException"
  ([^UtilDelegate this ^java.rmi.Remote target]
    (-> this (.unexportObject target))))

(defn read-any
  "Delegation call for Util.readAny(org.omg.CORBA.portable.InputStream).

  in - `org.omg.CORBA.portable.InputStream`

  returns: `java.lang.Object`"
  (^java.lang.Object [^UtilDelegate this ^org.omg.CORBA.portable.InputStream in]
    (-> this (.readAny in))))

(defn load-class
  "Delegation call for Util.loadClass(java.lang.String, java.lang.String, java.lang.ClassLoader).

  class-name - `java.lang.String`
  remote-codebase - `java.lang.String`
  loader - `java.lang.ClassLoader`

  returns: `java.lang.Class`

  throws: java.lang.ClassNotFoundException"
  (^java.lang.Class [^UtilDelegate this ^java.lang.String class-name ^java.lang.String remote-codebase ^java.lang.ClassLoader loader]
    (-> this (.loadClass class-name remote-codebase loader))))

(defn create-value-handler
  "Delegation call for Util.createValueHandler().

  returns: `javax.rmi.CORBA.ValueHandler`"
  (^javax.rmi.CORBA.ValueHandler [^UtilDelegate this]
    (-> this (.createValueHandler))))

(defn wrap-exception
  "Delegation call for Util.wrapException(java.lang.Throwable).

  obj - `java.lang.Throwable`

  returns: `java.rmi.RemoteException`"
  (^java.rmi.RemoteException [^UtilDelegate this ^java.lang.Throwable obj]
    (-> this (.wrapException obj))))

(defn get-tie
  "Delegation call for Util.getTie(java.rmi.Remote).

  target - `java.rmi.Remote`

  returns: `javax.rmi.CORBA.Tie`"
  (^javax.rmi.CORBA.Tie [^UtilDelegate this ^java.rmi.Remote target]
    (-> this (.getTie target))))

(defn write-remote-object
  "Delegation call for Util.writeRemoteObject(org.omg.CORBA.portable.OutputStream, java.lang.Object).

  out - `org.omg.CORBA.portable.OutputStream`
  obj - `java.lang.Object`"
  ([^UtilDelegate this ^org.omg.CORBA.portable.OutputStream out ^java.lang.Object obj]
    (-> this (.writeRemoteObject out obj))))

(defn get-codebase
  "Delegation call for Util.getCodebase(java.lang.Class).

  clz - `java.lang.Class`

  returns: `java.lang.String`"
  (^java.lang.String [^UtilDelegate this ^java.lang.Class clz]
    (-> this (.getCodebase clz))))

(defn map-system-exception
  "Delegation call for Util.mapSystemException(org.omg.CORBA.SystemException).

  ex - `org.omg.CORBA.SystemException`

  returns: `java.rmi.RemoteException`"
  (^java.rmi.RemoteException [^UtilDelegate this ^org.omg.CORBA.SystemException ex]
    (-> this (.mapSystemException ex))))

