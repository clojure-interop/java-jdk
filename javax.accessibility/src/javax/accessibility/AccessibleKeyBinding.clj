(ns javax.accessibility.AccessibleKeyBinding
  "The AccessibleKeyBinding interface should be supported by any object
  that has a keyboard bindings such as a keyboard mnemonic and/or keyboard
  shortcut which can be used to select the object.  This interface provides
  the standard mechanism for an assistive technology to determine the
  key bindings which exist for this object.
  Any object that has such key bindings should support this
  interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleKeyBinding]))

(defn get-accessible-key-binding-count
  "Returns the number of key bindings for this object

  returns: the zero-based number of key bindings for this object - `int`"
  ([^javax.accessibility.AccessibleKeyBinding this]
    (-> this (.getAccessibleKeyBindingCount))))

(defn get-accessible-key-binding
  "Returns a key binding for this object.  The value returned is an
   java.lang.Object which must be cast to appropriate type depending
   on the underlying implementation of the key.

  i - zero-based index of the key bindings - `int`

  returns: a javax.lang.Object which specifies the key binding - `java.lang.Object`"
  ([^javax.accessibility.AccessibleKeyBinding this ^Integer i]
    (-> this (.getAccessibleKeyBinding i))))

