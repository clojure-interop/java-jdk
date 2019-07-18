(ns javax.sql.rowset.RowSetFactory
  "An interface that defines the implementation of a factory that is used
  to obtain different types of RowSet implementations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset RowSetFactory]))

(defn create-cached-row-set
  "Creates a new instance of a CachedRowSet.

  returns: A new instance of a CachedRowSet. - `javax.sql.rowset.CachedRowSet`

  throws: java.sql.SQLException - if a CachedRowSet cannot be created."
  (^javax.sql.rowset.CachedRowSet [^RowSetFactory this]
    (-> this (.createCachedRowSet))))

(defn create-filtered-row-set
  "Creates a new instance of a FilteredRowSet.

  returns: A new instance of a FilteredRowSet. - `javax.sql.rowset.FilteredRowSet`

  throws: java.sql.SQLException - if a FilteredRowSet cannot be created."
  (^javax.sql.rowset.FilteredRowSet [^RowSetFactory this]
    (-> this (.createFilteredRowSet))))

(defn create-jdbc-row-set
  "Creates a new instance of a JdbcRowSet.

  returns: A new instance of a JdbcRowSet. - `javax.sql.rowset.JdbcRowSet`

  throws: java.sql.SQLException - if a JdbcRowSet cannot be created."
  (^javax.sql.rowset.JdbcRowSet [^RowSetFactory this]
    (-> this (.createJdbcRowSet))))

(defn create-join-row-set
  "Creates a new instance of a JoinRowSet.

  returns: A new instance of a JoinRowSet. - `javax.sql.rowset.JoinRowSet`

  throws: java.sql.SQLException - if a JoinRowSet cannot be created."
  (^javax.sql.rowset.JoinRowSet [^RowSetFactory this]
    (-> this (.createJoinRowSet))))

(defn create-web-row-set
  "Creates a new instance of a WebRowSet.

  returns: A new instance of a WebRowSet. - `javax.sql.rowset.WebRowSet`

  throws: java.sql.SQLException - if a WebRowSet cannot be created."
  (^javax.sql.rowset.WebRowSet [^RowSetFactory this]
    (-> this (.createWebRowSet))))

