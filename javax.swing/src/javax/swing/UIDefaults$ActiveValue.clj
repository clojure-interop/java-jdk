(ns javax.swing.UIDefaults$ActiveValue
  "This class enables one to store an entry in the defaults
  table that's constructed each time it's looked up with one of
  the getXXX(key) methods. Here's an example of
  an ActiveValue that constructs a
  DefaultListCellRenderer:


   Object cellRendererActiveValue = new UIDefaults.ActiveValue() {
       public Object createValue(UIDefaults table) {
           return new DefaultListCellRenderer();
       }
   };

   uiDefaultsTable.put(`MyRenderer`, cellRendererActiveValue);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing UIDefaults$ActiveValue]))

(defn create-value
  "Creates the value retrieved from the UIDefaults table.
   The object is created each time it is accessed.

  table - a UIDefaults table - `javax.swing.UIDefaults`

  returns: the created Object - `java.lang.Object`"
  ([^javax.swing.UIDefaults$ActiveValue this ^javax.swing.UIDefaults table]
    (-> this (.createValue table))))

