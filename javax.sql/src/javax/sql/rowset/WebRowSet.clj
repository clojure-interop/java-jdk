(ns javax.sql.rowset.WebRowSet
  "The standard interface that all implementations of a WebRowSet
  must implement.

  1.0 Overview
  The WebRowSetImpl provides the standard
  reference implementation, which may be extended if required.

  The standard WebRowSet XML Schema definition is available at the following
  URI:


  http://java.sun.com/xml/ns/jdbc/webrowset.xsd


  It describes the standard XML document format required when describing a
  RowSet object in XML and must be used be all standard implementations
  of the WebRowSet interface to ensure interoperability. In addition,
  the WebRowSet schema uses specific SQL/XML Schema annotations,
  thus ensuring greater cross
  platform inter-operability. This is an effort currently under way at the ISO
  organization. The SQL/XML definition is available at the following URI:


  http://standards.iso.org/iso/9075/2002/12/sqlxml


  The schema definition describes the internal data of a RowSet object
  in three distinct areas:

  properties - These properties describe the standard synchronization
  provider properties in addition to the more general RowSet properties.

  metadata - This describes the metadata associated with the tabular structure governed by a
  WebRowSet object. The metadata described is closely aligned with the
  metadata accessible in the underlying java.sql.ResultSet interface.

  data - This describes the original data (the state of data since the
  last population
  or last synchronization of the WebRowSet object) and the current
  data. By keeping track of the delta between the original data and the current data,
  a WebRowSet maintains the ability to synchronize changes
  in its data back to the originating data source.



  2.0 WebRowSet States
  The following sections demonstrates how a WebRowSet implementation
  should use the XML Schema to describe update, insert, and delete operations
  and to describe the state of a WebRowSet object in XML.

  2.1 State 1 - Outputting a WebRowSet Object to XML
  In this example, a WebRowSet object is created and populated with a simple 2 column,
  5 row table from a data source. Having the 5 rows in a WebRowSet object
  makes it possible to describe them in XML. The
  metadata describing the various standard JavaBeans properties as defined
  in the RowSet interface plus the standard properties defined in
  the CachedRowSet™ interface
  provide key details that describe WebRowSet
  properties. Outputting the WebRowSet object to XML using the standard
  writeXml methods describes the internal properties as follows:


  <properties>
        <command>select co1, col2 from test_table</command>
       <concurrency>1</concurrency>
       <datasource/>
       <escape-processing>true</escape-processing>
       <fetch-direction>0</fetch-direction>
       <fetch-size>0</fetch-size>
       <isolation-level>1</isolation-level>
       <key-columns/>
       <map/>
       <max-field-size>0</max-field-size>
       <max-rows>0</max-rows>
       <query-timeout>0</query-timeout>
       <read-only>false</read-only>
       <rowset-type>TRANSACTION_READ_UNCOMMITED</rowset-type>
       <show-deleted>false</show-deleted>
       <table-name/>
       <url>jdbc:thin:oracle</url>
       <sync-provider>
               <sync-provider-name>.com.rowset.provider.RIOptimisticProvider</sync-provider-name>
               <sync-provider-vendor>Oracle Corporation</sync-provider-vendor>
               <sync-provider-version>1.0</sync-provider-name>
               <sync-provider-grade>LOW</sync-provider-grade>
               <data-source-lock>NONE</data-source-lock>
       </sync-provider>
  </properties>
  The meta-data describing the make up of the WebRowSet is described
  in XML as detailed below. Note both columns are described between the
  column-definition tags.


  <metadata>
       <column-count>2</column-count>
       <column-definition>
               <column-index>1</column-index>
               <auto-increment>false</auto-increment>
               <case-sensitive>true</case-sensitive>
               <currency>false</currency>
               <nullable>1</nullable>
               <signed>false</signed>
               <searchable>true</searchable>
               <column-display-size>10</column-display-size>
               <column-label>COL1</column-label>
               <column-name>COL1</column-name>
               <schema-name/>
               <column-precision>10</column-precision>
               <column-scale>0</column-scale>
               <table-name/>
               <catalog-name/>
               <column-type>1</column-type>
               <column-type-name>CHAR</column-type-name>
       </column-definition>
       <column-definition>
               <column-index>2</column-index>
               <auto-increment>false</auto-increment>
               <case-sensitive>false</case-sensitive>
               <currency>false</currency>
               <nullable>1</nullable>
               <signed>true</signed>
               <searchable>true</searchable>
               <column-display-size>39</column-display-size>
               <column-label>COL2</column-label>
               <column-name>COL2</column-name>
               <schema-name/>
               <column-precision>38</column-precision>
               <column-scale>0</column-scale>
               <table-name/>
               <catalog-name/>
               <column-type>3</column-type>
               <column-type-name>NUMBER</column-type-name>
       </column-definition>
  </metadata>
  Having detailed how the properties and metadata are described, the following details
  how the contents of a WebRowSet object is described in XML. Note, that
  this describes a WebRowSet object that has not undergone any
  modifications since its instantiation.
  A currentRow tag is mapped to each row of the table structure that the
  WebRowSet object provides. A columnValue tag may contain
  either the stringData or binaryData tag, according to
  the SQL type that
  the XML value is mapping back to. The binaryData tag contains data in the
  Base64 encoding and is typically used for BLOB and CLOB type data.


  <data>
       <currentRow>
               <columnValue>
                       firstrow
               </columnValue>
               <columnValue>
                       1
               </columnValue>
       </currentRow>
       <currentRow>
               <columnValue>
                       secondrow
               </columnValue>
               <columnValue>
                       2
               </columnValue>
       </currentRow>
       <currentRow>
               <columnValue>
                       thirdrow
               </columnValue>
               <columnValue>
                       3
               </columnValue>
       </currentRow>
       <currentRow>
               <columnValue>
                       fourthrow
               </columnValue>
               <columnValue>
                       4
               </columnValue>
       </currentRow>
  </data>
  2.2 State 2 - Deleting a Row
  Deleting a row in a WebRowSet object involves simply moving to the row
  to be deleted and then calling the method deleteRow, as in any other
  RowSet object.  The following
  two lines of code, in which wrs is a WebRowSet object, delete
  the third row.


      wrs.absolute(3);
      wrs.deleteRow();
  The XML description shows the third row is marked as a deleteRow,
   which eliminates the third row in the WebRowSet object.


  <data>
       <currentRow>
               <columnValue>
                       firstrow
               </columnValue>
               <columnValue>
                       1
               </columnValue>
       </currentRow>
       <currentRow>
               <columnValue>
                       secondrow
               </columnValue>
               <columnValue>
                       2
               </columnValue>
       </currentRow>
       <deleteRow>
               <columnValue>
                       thirdrow
               </columnValue>
               <columnValue>
                       3
               </columnValue>
       </deleteRow>
       <currentRow>
               <columnValue>
                       fourthrow
               </columnValue>
               <columnValue>
                       4
               </columnValue>
       </currentRow>
  </data>
  2.3 State 3 - Inserting a Row
  A WebRowSet object can insert a new row by moving to the insert row,
  calling the appropriate updater methods for each column in the row, and then
  calling the method insertRow.


  wrs.moveToInsertRow();
  wrs.updateString(1, `fifththrow`);
  wrs.updateString(2, `5`);
  wrs.insertRow();
  The following code fragment changes the second column value in the row just inserted.
  Note that this code applies when new rows are inserted right after the current row,
  which is why the method next moves the cursor to the correct row.
  Calling the method acceptChanges writes the change to the data source.



   wrs.moveToCurrentRow();
  wrs.next();
  wrs.updateString(2, `V`);
  wrs.acceptChanges();
  Describing this in XML demonstrates where the Java code inserts a new row and then
  performs an update on the newly inserted row on an individual field.


  <data>
       <currentRow>
               <columnValue>
                       firstrow
               </columnValue>
               <columnValue>
                       1
               </columnValue>
       </currentRow>
       <currentRow>
               <columnValue>
                       secondrow
               </columnValue>
               <columnValue>
                       2
               </columnValue>
       </currentRow>
       <currentRow>
               <columnValue>
                       newthirdrow
               </columnValue>
               <columnValue>
                       III
               </columnValue>
       </currentRow>
       <insertRow>
               <columnValue>
                       fifthrow
               </columnValue>
               <columnValue>
                       5
               </columnValue>
               <updateValue>
                       V
               </updateValue>
       </insertRow>
       <currentRow>
               <columnValue>
                       fourthrow
               </columnValue>
               <columnValue>
                       4
               </columnValue>
       </currentRow>
  </date>
  2.4 State 4 - Modifying a Row
  Modifying a row produces specific XML that records both the new value and the
  value that was replaced.  The value that was replaced becomes the original value,
  and the new value becomes the current value. The following
  code moves the cursor to a specific row, performs some modifications, and updates
  the row when complete.


  wrs.absolute(5);
  wrs.updateString(1, `new4thRow`);
  wrs.updateString(2, `IV`);
  wrs.updateRow();
  In XML, this is described by the modifyRow tag. Both the original and new
  values are contained within the tag for original row tracking purposes.


  <data>
       <currentRow>
               <columnValue>
                       firstrow
               </columnValue>
               <columnValue>
                       1
               </columnValue>
       </currentRow>
       <currentRow>
               <columnValue>
                       secondrow
               </columnValue>
               <columnValue>
                       2
               </columnValue>
       </currentRow>
       <currentRow>
               <columnValue>
                       newthirdrow
               </columnValue>
               <columnValue>
                       III
               </columnValue>
       </currentRow>
       <currentRow>
               <columnValue>
                       fifthrow
               </columnValue>
               <columnValue>
                       5
               </columnValue>
       </currentRow>
       <modifyRow>
               <columnValue>
                       fourthrow
               </columnValue>
               <updateValue>
                       new4thRow
               </updateValue>
               <columnValue>
                       4
               </columnValue>
               <updateValue>
                       IV
               </updateValue>
       </modifyRow>
  </data>"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset WebRowSet]))

(defn read-xml
  "Reads a WebRowSet object in its XML format from the given
   Reader object.

  reader - the java.io.Reader stream from which this WebRowSet object will be populated - `java.io.Reader`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this reader]
    (-> this (.readXml reader))))

(defn write-xml
  "Populates this WebRowSet object with
   the contents of the given ResultSet object and writes its
   data, properties, and metadata
   to the given Writer object in XML format.

   NOTE: The WebRowSet cursor may be moved to write out the
   contents to the XML data source. If implemented in this way, the cursor must
   be returned to its position just prior to the writeXml() call.

  rs - the ResultSet object with which to populate this WebRowSet object - `java.sql.ResultSet`
  writer - the java.io.Writer object to write to. - `java.io.Writer`

  throws: java.sql.SQLException - if an error occurs writing out the rowset contents in XML format"
  ([this rs writer]
    (-> this (.writeXml rs writer)))
  ([this writer]
    (-> this (.writeXml writer))))

