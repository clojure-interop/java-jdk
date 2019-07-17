(ns javax.sql.rowset.Joinable
  "1.0 Background
  The Joinable interface provides the methods for getting and
  setting a match column, which is the basis for forming the SQL JOIN
  formed by adding RowSet objects to a JoinRowSet
  object.

  Any standard RowSet implementation may implement
  the Joinable interface in order to be
  added to a JoinRowSet object. Implementing this interface gives
  a RowSet object the ability to use Joinable methods,
  which set, retrieve, and get information about match columns.  An
  application may add a
  RowSet object that has not implemented the Joinable
  interface to a JoinRowSet object, but to do so it must use one
  of the JoinRowSet.addRowSet methods that takes both a
  RowSet object and a match column or an array of RowSet
  objects and an array of match columns.

  To get access to the methods in the Joinable interface, a
  RowSet object implements at least one of the
  five standard RowSet interfaces and also implements the
  Joinable interface.  In addition, most RowSet
  objects extend the BaseRowSet class.  For example:


      class MyRowSetImpl extends BaseRowSet implements CachedRowSet, Joinable {
          :
          :
      }

  2.0 Usage Guidelines

  The methods in the Joinable interface allow a RowSet object
  to set a match column, retrieve a match column, or unset a match column, which is
  the column upon which an SQL JOIN can be based.
  An instance of a class that implements these methods can be added to a
  JoinRowSet object to allow an SQL JOIN relationship to
   be established.



      CachedRowSet crs = new MyRowSetImpl();
      crs.populate((ResultSet)rs);
      (Joinable)crs.setMatchColumnIndex(1);

      JoinRowSet jrs = new JoinRowSetImpl();
      jrs.addRowSet(crs);
  In the previous example, crs is a CachedRowSet object that
  has implemented the Joinable interface.  In the following example,
  crs2 has not, so it must supply the match column as an argument to the
  addRowSet method. This example assumes that column 1 is the match
  column.


      CachedRowSet crs2 = new MyRowSetImpl();
      crs2.populate((ResultSet)rs);

      JoinRowSet jrs2 = new JoinRowSetImpl();
      jrs2.addRowSet(crs2, 1);

  The JoinRowSet interface makes it possible to get data from one or
  more RowSet objects consolidated into one table without having to incur
  the expense of creating a connection to a database. It is therefore ideally suited
  for use by disconnected RowSet objects. Nevertheless, any
  RowSet object may implement this interface
  regardless of whether it is connected or disconnected. Note that a
  JdbcRowSet object, being always connected to its data source, can
  become part of an SQL JOIN directly without having to become part
  of a JoinRowSet object.

  3.0 Managing Multiple Match Columns
  The index array passed into the setMatchColumn methods indicates
  how many match columns are being set (the length of the array) in addition to
  which columns will be used for the match. For example:


      int[] i = {1, 2, 4, 7}; // indicates four match columns, with column
                              // indexes 1, 2, 4, 7 participating in the JOIN.
      Joinable.setMatchColumn(i);
  Subsequent match columns may be added as follows to a different Joinable
  object (a RowSet object that has implemented the Joinable
  interface).


      int[] w = {3, 2, 5, 3};
      Joinable2.setMatchColumn(w);
  When an application adds two or more RowSet objects to a
  JoinRowSet object, the order of the indexes in the array is
  particularly important. Each index of
  the array maps directly to the corresponding index of the previously added
  RowSet object. If overlap or underlap occurs, the match column
  data is maintained in the event an additional Joinable RowSet is
  added and needs to relate to the match column data. Therefore, applications
  can set multiple match columns in any order, but
  this order has a direct effect on the outcome of the SQL JOIN.

  This assertion applies in exactly the same manner when column names are used
  rather than column indexes to indicate match columns."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset Joinable]))

(defn set-match-column
  "Sets the designated column as the match column for this RowSet
   object. A JoinRowSet object can now add this RowSet
   object based on the match column.

   Sub-interfaces such as the CachedRowSet™
   interface define the method CachedRowSet.setKeyColumns, which allows
   primary key semantics to be enforced on specific columns.
   Implementations of the setMatchColumn(int columnIdx) method
   should ensure that the constraints on the key columns are maintained when
   a CachedRowSet object sets a primary key column as a match column.

  column-idx - an int identifying the index of the column to be set as the match column - `int`

  throws: java.sql.SQLException - if an invalid column index is set"
  ([this column-idx]
    (-> this (.setMatchColumn column-idx))))

(defn get-match-column-indexes
  "Retrieves the indexes of the match columns that were set for this
   RowSet object with the method
   setMatchColumn(int[] columnIdxes).

  returns: an int array identifying the indexes of the columns
           that were set as the match columns for this RowSet object - `int[]`

  throws: java.sql.SQLException - if no match column has been set"
  ([this]
    (-> this (.getMatchColumnIndexes))))

(defn get-match-column-names
  "Retrieves the names of the match columns that were set for this
   RowSet object with the method
   setMatchColumn(String [] columnNames).

  returns: an array of String objects giving the names of the columns
           set as the match columns for this RowSet object - `java.lang.String[]`

  throws: java.sql.SQLException - if no match column has been set"
  ([this]
    (-> this (.getMatchColumnNames))))

(defn unset-match-column
  "Unsets the designated column as the match column for this RowSet
   object.

   RowSet objects that implement the Joinable interface
   must ensure that a key-like constraint continues to be enforced until the
   method CachedRowSet.unsetKeyColumns has been called on the
   designated column.

  column-idx - an int that identifies the index of the column that is to be unset as a match column - `int`

  throws: java.sql.SQLException - if an invalid column index is designated or if the designated column was not previously set as a match column"
  ([this column-idx]
    (-> this (.unsetMatchColumn column-idx))))

