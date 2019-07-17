(ns jdk.lang.instrument.ClassDefinition
  "This class serves as a parameter block to the Instrumentation.redefineClasses method.
  Serves to bind the Class that needs redefining together with the new class file bytes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.instrument ClassDefinition]))

(defn ->class-definition
  "Constructor.

  Creates a new ClassDefinition binding using the supplied
    class and class file bytes. Does not copy the supplied buffer, just captures a reference to it.

  the-class - the Class that needs redefining - `java.lang.Class<?>`
  the-class-file - the new class file bytes - `byte[]`

  throws: java.lang.NullPointerException - if the supplied class or array is null."
  ([the-class the-class-file]
    (new ClassDefinition the-class the-class-file)))

(defn get-definition-class
  "Returns the class.

  returns: the Class object referred to. - `java.lang.Class<?>`"
  ([this]
    (-> this (.getDefinitionClass))))

(defn get-definition-class-file
  "Returns the array of bytes that contains the new class file.

  returns: the class file bytes. - `byte[]`"
  ([this]
    (-> this (.getDefinitionClassFile))))

