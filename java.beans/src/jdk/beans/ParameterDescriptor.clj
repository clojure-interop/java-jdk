(ns jdk.beans.ParameterDescriptor
  "The ParameterDescriptor class allows bean implementors to provide
  additional information on each of their parameters, beyond the
  low level type information provided by the java.lang.reflect.Method
  class.

  Currently all our state comes from the FeatureDescriptor base class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans ParameterDescriptor]))

(defn ->parameter-descriptor
  "Constructor.

  Public default constructor."
  ([]
    (new ParameterDescriptor )))

