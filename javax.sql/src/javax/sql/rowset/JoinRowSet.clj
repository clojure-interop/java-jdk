(ns javax.sql.rowset.JoinRowSet
  "The JoinRowSet interface provides a mechanism for combining related
  data from different RowSet objects into one JoinRowSet
  object, which represents an SQL JOIN.
  In other words, a JoinRowSet object acts as a
  container for the data from RowSet objects that form an SQL
  JOIN relationship.

  The Joinable interface provides the methods for setting,
  retrieving, and unsetting a match column, the basis for
  establishing an SQL JOIN relationship. The match column may
  alternatively be set by supplying it to the appropriate version of the
  JointRowSet method addRowSet.

  1.0 Overview
  Disconnected RowSet objects (CachedRowSet objects
  and implementations extending the CachedRowSet interface)
  do not have a standard way to establish an SQL JOIN between
  RowSet objects without the expensive operation of
  reconnecting to the data source. The JoinRowSet
  interface is specifically designed to address this need.

  Any RowSet object
  can be added to a JoinRowSet object to become
  part of an SQL JOIN relationship. This means that both connected
  and disconnected RowSet objects can be part of a JOIN.
  RowSet objects operating in a connected environment
  (JdbcRowSet objects) are
  encouraged to use the database to which they are already
  connected to establish SQL JOIN relationships between
  tables directly. However, it is possible for a
  JdbcRowSet object to be added to a JoinRowSet object
  if necessary.

  Any number of RowSet objects can be added to an
  instance of JoinRowSet provided that they
  can be related in an SQL JOIN.
  By definition, the SQL JOIN statement is used to
  combine the data contained in two or more relational database tables based
  upon a common attribute. The Joinable interface provides the methods
  for establishing a common attribute, which is done by setting a
  match column. The match column commonly coincides with
  the primary key, but there is
  no requirement that the match column be the same as the primary key.
  By establishing and then enforcing column matches,
  a JoinRowSet object establishes JOIN relationships
  between RowSet objects without the assistance of an available
  relational database.

  The type of JOIN to be established is determined by setting
  one of the JoinRowSet constants using the method
  setJoinType. The following SQL JOIN types can be set:

   CROSS_JOIN
   FULL_JOIN
   INNER_JOIN - the default if no JOIN type has been set
   LEFT_OUTER_JOIN
   RIGHT_OUTER_JOIN

  Note that if no type is set, the JOIN will automatically be an
  inner join. The comments for the fields in the
  JoinRowSet interface explain these JOIN types, which are
  standard SQL JOIN types.

  2.0 Using a JoinRowSet Object for Creating a JOIN
  When a JoinRowSet object is created, it is empty.
  The first RowSet object to be added becomes the basis for the
  JOIN relationship.
  Applications must determine which column in each of the
  RowSet objects to be added to the JoinRowSet object
  should be the match column. All of the
  RowSet objects must contain a match column, and the values in
  each match column must be ones that can be compared to values in the other match
  columns. The columns do not have to have the same name, though they often do,
  and they do not have to store the exact same data type as long as the data types
  can be compared.

  A match column can be be set in two ways:

   By calling the Joinable method setMatchColumn
   This is the only method that can set the match column before a RowSet
   object is added to a JoinRowSet object. The RowSet object
   must have implemented the Joinable interface in order to use the method
   setMatchColumn. Once the match column value
   has been set, this method can be used to reset the match column at any time.
   By calling one of the versions of the JoinRowSet method
   addRowSet that takes a column name or number (or an array of
   column names or numbers)
   Four of the five addRowSet methods take a match column as a parameter.
   These four methods set or reset the match column at the time a RowSet
   object is being added to a JoinRowSet object.

  3.0 Sample Usage

  The following code fragment adds two CachedRowSet
  objects to a JoinRowSet object. Note that in this example,
  no SQL JOIN type is set, so the default JOIN type,
  which is INNER_JOIN, is established.

  In the following code fragment, the table EMPLOYEES, whose match
  column is set to the first column (EMP_ID), is added to the
  JoinRowSet object jrs. Then
  the table ESSP_BONUS_PLAN, whose match column is likewise
  the EMP_ID column, is added. When this second
  table is added to jrs, only the rows in
  ESSP_BONUS_PLAN whose EMP_ID value matches an
  EMP_ID value in the EMPLOYEES table are added.
  In this case, everyone in the bonus plan is an employee, so all of the rows
  in the table ESSP_BONUS_PLAN are added to the JoinRowSet
  object.  In this example, both CachedRowSet objects being added
  have implemented the Joinable interface and can therefore call
  the Joinable method setMatchColumn.


      JoinRowSet jrs = new JoinRowSetImpl();

      ResultSet rs1 = stmt.executeQuery(`SELECT * FROM EMPLOYEES`);
      CachedRowSet empl = new CachedRowSetImpl();
      empl.populate(rs1);
      empl.setMatchColumn(1);
      jrs.addRowSet(empl);

      ResultSet rs2 = stmt.executeQuery(`SELECT * FROM ESSP_BONUS_PLAN`);
      CachedRowSet bonus = new CachedRowSetImpl();
      bonus.populate(rs2);
      bonus.setMatchColumn(1); // EMP_ID is the first column
      jrs.addRowSet(bonus);

  At this point, jrs is an inside JOIN of the two RowSet objects
  based on their EMP_ID columns. The application can now browse the
  combined data as if it were browsing one single RowSet object.
  Because jrs is itself a RowSet object, an application can
  navigate or modify it using RowSet methods.


      jrs.first();
      int employeeID = jrs.getInt(1);
      String employeeName = jrs.getString(2);

  Note that because the SQL JOIN must be enforced when an application
  adds a second or subsequent RowSet object, there
  may be an initial degradation in performance while the JOIN is
  being performed.

  The following code fragment adds an additional CachedRowSet object.
  In this case, the match column (EMP_ID) is set when the
  CachedRowSet object is added to the JoinRowSet object.


      ResultSet rs3 = stmt.executeQuery(`SELECT * FROM 401K_CONTRIB`);
      CachedRowSet fourO1k = new CachedRowSetImpl();
      four01k.populate(rs3);
      jrs.addRowSet(four01k, 1);

  The JoinRowSet object jrs now contains values from all three
  tables. The data in each row in four01k in which the value for the
  EMP_ID column matches a value for the EMP_ID column
  in jrs has been added to jrs.

  4.0 JoinRowSet Methods
  The JoinRowSet interface supplies several methods for adding
  RowSet objects and for getting information about the
  JoinRowSet object.

    Methods for adding one or more RowSet objects
        These methods allow an application to add one RowSet object
        at a time or to add multiple RowSet objects at one time. In
        either case, the methods may specify the match column for each
        RowSet object being added.
    Methods for getting information
        One method retrieves the RowSet objects in the
        JoinRowSet object, and another method retrieves the
        RowSet names.  A third method retrieves either the SQL
        WHERE clause used behind the scenes to form the
        JOIN or a text description of what the WHERE
        clause does.
    Methods related to the type of JOIN
        One method sets the JOIN type, and five methods find out whether
        the JoinRowSet object supports a given type.
    A method to make a separate copy of the JoinRowSet object
        This method creates a copy that can be persisted to the data source."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset JoinRowSet]))

(defn supports-cross-join
  "Indicates if CROSS_JOIN is supported by a JoinRowSet
   implementation

  returns: true if the CROSS_JOIN is supported; false otherwise - `boolean`"
  (^Boolean [^javax.sql.rowset.JoinRowSet this]
    (-> this (.supportsCrossJoin))))

(defn supports-left-outer-join
  "Indicates if LEFT_OUTER_JOIN is supported by a JoinRowSet
   implementation

  returns: true is the LEFT_OUTER_JOIN is supported; false otherwise - `boolean`"
  (^Boolean [^javax.sql.rowset.JoinRowSet this]
    (-> this (.supportsLeftOuterJoin))))

(defn get-where-clause
  "Return a SQL-like description of the WHERE clause being used
   in a JoinRowSet object. An implementation can describe
   the WHERE clause of the SQL JOIN by supplying a SQL
   strings description of JOIN or provide a textual
   description to assist applications using a JoinRowSet

  returns: whereClause a textual or SQL description of the logical
   WHERE clause used in the JoinRowSet instance - `java.lang.String`

  throws: java.sql.SQLException - if an error occurs in generating a representation of the WHERE clause."
  (^java.lang.String [^javax.sql.rowset.JoinRowSet this]
    (-> this (.getWhereClause))))

(defn supports-full-join
  "Indicates if FULL_JOIN is supported by a JoinRowSet
   implementation

  returns: true is the FULL_JOIN is supported; false otherwise - `boolean`"
  (^Boolean [^javax.sql.rowset.JoinRowSet this]
    (-> this (.supportsFullJoin))))

(defn get-join-type
  "Returns a int describing the set SQL JOIN type
   governing this JoinRowSet instance. The returned type will be one of
   standard JoinRowSet types: CROSS_JOIN, INNER_JOIN,
   LEFT_OUTER_JOIN, RIGHT_OUTER_JOIN or
   FULL_JOIN.

  returns: joinType one of the standard JoinRowSet static field
       definitions of a SQL JOIN. JoinRowSet.INNER_JOIN
       is returned as the default JOIN type is no type has been
       explicitly set. - `int`

  throws: java.sql.SQLException - if an error occurs determining the SQL JOIN type supported by the JoinRowSet instance."
  (^Integer [^javax.sql.rowset.JoinRowSet this]
    (-> this (.getJoinType))))

(defn get-row-sets
  "Returns a Collection object containing the
   RowSet objects that have been added to this
   JoinRowSet object.
   This should return the 'n' number of RowSet contained
   within the JOIN and maintain any updates that have occurred while in
   this union.

  returns: a Collection object consisting of the
          RowSet objects added to this JoinRowSet
          object - `java.util.Collection<?>`

  throws: java.sql.SQLException - if an error occurs generating the Collection object to be returned"
  (^java.util.Collection [^javax.sql.rowset.JoinRowSet this]
    (-> this (.getRowSets))))

(defn set-join-type
  "Allow the application to adjust the type of JOIN imposed
   on tables contained within the JoinRowSet object instance.
   Implementations should throw a SQLException if they do
   not support a given JOIN type.

  join-type - the standard JoinRowSet.XXX static field definition of a SQL JOIN to re-configure a JoinRowSet instance on the fly. - `int`

  throws: java.sql.SQLException - if an unsupported JOIN type is set"
  ([^javax.sql.rowset.JoinRowSet this ^Integer join-type]
    (-> this (.setJoinType join-type))))

(defn get-row-set-names
  "Returns a String array containing the names of the
           RowSet objects added to this JoinRowSet
           object.

  returns: a String array of the names of the
           RowSet objects in this JoinRowSet
           object - `java.lang.String[]`

  throws: java.sql.SQLException - if an error occurs retrieving the names of the RowSet objects"
  ([^javax.sql.rowset.JoinRowSet this]
    (-> this (.getRowSetNames))))

(defn to-cached-row-set
  "Creates a new CachedRowSet object containing the
   data in this JoinRowSet object, which can be saved
   to a data source using the SyncProvider object for
   the CachedRowSet object.

   If any updates or modifications have been applied to the JoinRowSet
   the CachedRowSet returned by the method will not be able to persist
   it's changes back to the originating rows and tables in the
   in the datasource. The CachedRowSet instance returned should not
   contain modification data and it should clear all properties of
   it's originating SQL statement. An application should reset the
   SQL statement using the RowSet.setCommand method.

   In order to allow changes to be persisted back to the datasource
   to the originating tables, the acceptChanges method
   should be used and called on a JoinRowSet object instance. Implementations
   can leverage the internal data and update tracking in their
   implementations to interact with the SyncProvider to persist any
   changes.

  returns: a CachedRowSet containing the contents of the JoinRowSet - `javax.sql.rowset.CachedRowSet`

  throws: java.sql.SQLException - if an error occurs assembling the CachedRowSet object"
  (^javax.sql.rowset.CachedRowSet [^javax.sql.rowset.JoinRowSet this]
    (-> this (.toCachedRowSet))))

(defn add-row-set
  "Adds the given RowSet object to this JoinRowSet
   object and sets the designated column as the match column for
   the RowSet object. If the RowSet object
   is the first to be added to this JoinRowSet
   object, it forms the basis of the JOIN relationship to be
   established.

   This method should be used when RowSet does not already have a match
   column set.

  rowset - the RowSet object that is to be added to this JoinRowSet object; it may implement the Joinable interface - `javax.sql.RowSet`
  column-idx - an int that identifies the column to become the match column - `int`

  throws: java.sql.SQLException - if (1) rowset is an empty rowset or (2) rowset violates the active JOIN"
  ([^javax.sql.rowset.JoinRowSet this ^javax.sql.RowSet rowset ^Integer column-idx]
    (-> this (.addRowSet rowset column-idx)))
  ([^javax.sql.rowset.JoinRowSet this ^javax.sql.rowset.Joinable rowset]
    (-> this (.addRowSet rowset))))

(defn supports-inner-join
  "Indicates if INNER_JOIN is supported by a JoinRowSet
   implementation

  returns: true is the INNER_JOIN is supported; false otherwise - `boolean`"
  (^Boolean [^javax.sql.rowset.JoinRowSet this]
    (-> this (.supportsInnerJoin))))

(defn supports-right-outer-join
  "Indicates if RIGHT_OUTER_JOIN is supported by a JoinRowSet
   implementation

  returns: true is the RIGHT_OUTER_JOIN is supported; false otherwise - `boolean`"
  (^Boolean [^javax.sql.rowset.JoinRowSet this]
    (-> this (.supportsRightOuterJoin))))

