(ns javax.swing.text.ChangedCharSetException
  "ChangedCharSetException as the name indicates is an exception
  thrown when the charset is changed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text ChangedCharSetException]))

(defn ->changed-char-set-exception
  "Constructor.

  char-set-spec - `java.lang.String`
  char-set-key - `boolean`"
  (^ChangedCharSetException [^java.lang.String char-set-spec ^Boolean char-set-key]
    (new ChangedCharSetException char-set-spec char-set-key)))

(defn get-char-set-spec
  "returns: `java.lang.String`"
  (^java.lang.String [^ChangedCharSetException this]
    (-> this (.getCharSetSpec))))

(defn key-equals-char-set
  "returns: `boolean`"
  (^Boolean [^ChangedCharSetException this]
    (-> this (.keyEqualsCharSet))))

