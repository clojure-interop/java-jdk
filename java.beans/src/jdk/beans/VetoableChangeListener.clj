(ns jdk.beans.VetoableChangeListener
  "A VetoableChange event gets fired whenever a bean changes a \"constrained\"
  property.  You can register a VetoableChangeListener with a source bean
  so as to be notified of any constrained property updates."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans VetoableChangeListener]))

(defn vetoable-change
  "This method gets called when a constrained property is changed.

  evt - a PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`

  throws: java.beans.PropertyVetoException - if the recipient wishes the property change to be rolled back."
  ([^VetoableChangeListener this ^java.beans.PropertyChangeEvent evt]
    (-> this (.vetoableChange evt))))

