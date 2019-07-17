(ns javax.swing.UIDefaults$ProxyLazyValue
  "This class provides an implementation of LazyValue
  which can be
  used to delay loading of the Class for the instance to be created.
  It also avoids creation of an anonymous inner class for the
  LazyValue
  subclass.  Both of these improve performance at the time that a
  a Look and Feel is loaded, at the cost of a slight performance
  reduction the first time createValue is called
  (since Reflection APIs are used)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing UIDefaults$ProxyLazyValue]))

(defn ->proxy-lazy-value
  "Constructor.

  Creates a LazyValue which will construct an instance
   when asked.

  c - a String specifying the classname of the class containing a static method to be called for instance creation. - `java.lang.String`
  m - a String specifying the static method to be called on class c - `java.lang.String`
  o - an array of Objects to be passed as paramaters to the static method in class c - `java.lang.Object[]`"
  ([c m o]
    (new UIDefaults$ProxyLazyValue c m o))
  ([c m]
    (new UIDefaults$ProxyLazyValue c m))
  ([c]
    (new UIDefaults$ProxyLazyValue c)))

(defn create-value
  "Creates the value retrieved from the UIDefaults table.
   The object is created each time it is accessed.

  table - a UIDefaults table - `javax.swing.UIDefaults`

  returns: the created Object - `java.lang.Object`"
  ([this table]
    (-> this (.createValue table))))

