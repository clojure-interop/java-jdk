(ns javax.sql.rowset.RowSetProvider
  "A factory API that enables applications to obtain a
  RowSetFactory implementation  that can be used to create different
  types of RowSet implementations.

  Example:



  RowSetFactory aFactory = RowSetProvider.newFactory();
  CachedRowSet crs = aFactory.createCachedRowSet();
  ...
  RowSetFactory rsf = RowSetProvider.newFactory(`com.sun.rowset.RowSetFactoryImpl`, null);
  WebRowSet wrs = rsf.createWebRowSet();

  Tracing of this class may be enabled by setting the System property
  javax.sql.rowset.RowSetFactory.debug to any value but false."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset RowSetProvider]))

(defn *new-factory
  "Creates  a new instance of a RowSetFactory from the
   specified factory class name.
   This function is useful when there are multiple providers in the classpath.
   It gives more control to the application as it can specify which provider
   should be loaded.

   Once an application has obtained a reference to a RowSetFactory
   it can use the factory to obtain RowSet instances.

  factory-class-name - fully qualified factory class name that provides an implementation of javax.sql.rowset.RowSetFactory. - `java.lang.String`
  cl - ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class. - `java.lang.ClassLoader`

  returns: New instance of a RowSetFactory - `javax.sql.rowset.RowSetFactory`

  throws: java.sql.SQLException - if factoryClassName is null, or the factory class cannot be loaded, instantiated."
  (^javax.sql.rowset.RowSetFactory [^java.lang.String factory-class-name ^java.lang.ClassLoader cl]
    (RowSetProvider/newFactory factory-class-name cl))
  (^javax.sql.rowset.RowSetFactory []
    (RowSetProvider/newFactory )))

