(ns javax.swing.UIDefaults$LazyValue
  "This class enables one to store an entry in the defaults
  table that isn't constructed until the first time it's
  looked up with one of the getXXX(key) methods.
  Lazy values are useful for defaults that are expensive
  to construct or are seldom retrieved.  The first time
  a LazyValue is retrieved its \"real value\" is computed
  by calling LazyValue.createValue() and the real
  value is used to replace the LazyValue in the
  UIDefaults
  table.  Subsequent lookups for the same key return
  the real value.  Here's an example of a LazyValue
  that constructs a Border:


   Object borderLazyValue = new UIDefaults.LazyValue() {
       public Object createValue(UIDefaults table) {
           return new BorderFactory.createLoweredBevelBorder();
       }
   };

   uiDefaultsTable.put(\"MyBorder\", borderLazyValue);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing UIDefaults$LazyValue]))

(defn create-value
  "Creates the actual value retrieved from the UIDefaults
   table. When an object that implements this interface is
   retrieved from the table, this method is used to create
   the real value, which is then stored in the table and
   returned to the calling method.

  table - a UIDefaults table - `javax.swing.UIDefaults`

  returns: the created Object - `java.lang.Object`"
  (^java.lang.Object [^UIDefaults$LazyValue this ^javax.swing.UIDefaults table]
    (-> this (.createValue table))))

