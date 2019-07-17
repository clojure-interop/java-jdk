(ns javax.swing.UIDefaults$LazyInputMap
  "LazyInputMap will create a InputMap
  in its createValue
  method. The bindings are passed in in the constructor.
  The bindings are an array with
  the even number entries being string KeyStrokes
  (eg `alt SPACE`) and
  the odd number entries being the value to use in the
  InputMap (and the key in the ActionMap)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing UIDefaults$LazyInputMap]))

(defn ->lazy-input-map
  "Constructor.

  bindings - `java.lang.Object[]`"
  ([^java.lang.Object[] bindings]
    (new UIDefaults$LazyInputMap bindings)))

(defn create-value
  "Creates an InputMap with the bindings that are
   passed in.

  table - a UIDefaults table - `javax.swing.UIDefaults`

  returns: the InputMap - `java.lang.Object`"
  ([^javax.swing.UIDefaults$LazyInputMap this ^javax.swing.UIDefaults table]
    (-> this (.createValue table))))

