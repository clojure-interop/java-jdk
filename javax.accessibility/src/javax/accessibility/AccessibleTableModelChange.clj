(ns javax.accessibility.AccessibleTableModelChange
  "The AccessibleTableModelChange interface describes a change to
  the table model.  The attributes of the model change can be
  obtained by the following methods:

   public int getType()
   public int getFirstRow();
   public int getLastRow();
   public int getFirstColumn();
   public int getLastColumn();

  The model change type returned by getType() will be one of:

   INSERT - one or more rows and/or columns have been inserted
   UPDATE - some of the table data has changed
   DELETE - one or more rows and/or columns have been deleted

  The affected area of the table can be determined by the other
  four methods which specify ranges of rows and columns"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleTableModelChange]))

(defn get-type
  "Returns the type of event.

  returns: the type of event - `int`"
  ([^. this]
    (-> this (.getType))))

(defn get-first-row
  "Returns the first row that changed.

  returns: the first row that changed - `int`"
  ([^. this]
    (-> this (.getFirstRow))))

(defn get-last-row
  "Returns the last row that changed.

  returns: the last row that changed - `int`"
  ([^. this]
    (-> this (.getLastRow))))

(defn get-first-column
  "Returns the first column that changed.

  returns: the first column that changed - `int`"
  ([^. this]
    (-> this (.getFirstColumn))))

(defn get-last-column
  "Returns the last column that changed.

  returns: the last column that changed - `int`"
  ([^. this]
    (-> this (.getLastColumn))))

