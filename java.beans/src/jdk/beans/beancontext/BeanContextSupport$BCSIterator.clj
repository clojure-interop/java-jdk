(ns jdk.beans.beancontext.BeanContextSupport$BCSIterator
  "protected final subclass that encapsulates an iterator but implements
  a noop remove() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextSupport$BCSIterator]))

(defn has-next?
  "Description copied from interface: Iterator

  returns: true if the iteration has more elements - `boolean`"
  ([this]
    (-> this (.hasNext))))

(defn next
  "Description copied from interface: Iterator

  returns: the next element in the iteration - `java.lang.Object`"
  ([this]
    (-> this (.next))))

(defn remove
  "Description copied from interface: Iterator"
  ([this]
    (-> this (.remove))))

