(ns jdk.beans.MethodDescriptor
  "A MethodDescriptor describes a particular method that a Java Bean
  supports for external access from other components."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans MethodDescriptor]))

(defn ->method-descriptor
  "Constructor.

  Constructs a MethodDescriptor from a
   Method providing descriptive information for each
   of the method's parameters.

  method - The low-level method information. - `java.lang.reflect.Method`
  parameter-descriptors - Descriptive information for each of the method's parameters. - `java.beans.ParameterDescriptor[]`"
  ([method parameter-descriptors]
    (new MethodDescriptor method parameter-descriptors))
  ([method]
    (new MethodDescriptor method)))

(defn get-method
  "Gets the method that this MethodDescriptor encapsulates.

  returns: The low-level description of the method - `java.lang.reflect.Method`"
  ([this]
    (-> this (.getMethod))))

(defn get-parameter-descriptors
  "Gets the ParameterDescriptor for each of this MethodDescriptor's
   method's parameters.

  returns: The locale-independent names of the parameters.  May return
            a null array if the parameter names aren't known. - `java.beans.ParameterDescriptor[]`"
  ([this]
    (-> this (.getParameterDescriptors))))

