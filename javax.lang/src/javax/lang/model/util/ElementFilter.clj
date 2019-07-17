(ns javax.lang.model.util.ElementFilter
  "Filters for selecting just the elements of interest from a
  collection of elements.  The returned sets and lists are new
  collections and do use the argument as a backing store.  The
  methods in this class do not make any attempts to guard against
  concurrent modifications of the arguments.  The returned sets and
  lists are mutable but unsafe for concurrent access.  A returned set
  has the same iteration order as the argument set to a method.

  If iterables and sets containing null are passed as
  arguments to methods in this class, a NullPointerException
  will be thrown.

  Note that a static import statement can make the text of
  calls to the methods in this class more concise; for example:



      import static javax.lang.model.util.ElementFilter.*;
      ...
           List<VariableElement> fs = fieldsIn(someClass.getEnclosedElements());"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.util ElementFilter]))

(defn *fields-in
  "Returns a list of fields in elements.

  elements - the elements to filter - `javax.lang.model.element.Element>`

  returns: a list of fields in elements - `java.util.List<javax.lang.model.element.VariableElement>`"
  (^java.util.List [^javax.lang.model.element.Element> elements]
    (ElementFilter/fieldsIn elements)))

(defn *constructors-in
  "Returns a list of constructors in elements.

  elements - the elements to filter - `javax.lang.model.element.Element>`

  returns: a list of constructors in elements - `java.util.List<javax.lang.model.element.ExecutableElement>`"
  (^java.util.List [^javax.lang.model.element.Element> elements]
    (ElementFilter/constructorsIn elements)))

(defn *methods-in
  "Returns a list of methods in elements.

  elements - the elements to filter - `javax.lang.model.element.Element>`

  returns: a list of methods in elements - `java.util.List<javax.lang.model.element.ExecutableElement>`"
  (^java.util.List [^javax.lang.model.element.Element> elements]
    (ElementFilter/methodsIn elements)))

(defn *types-in
  "Returns a list of types in elements.

  elements - the elements to filter - `javax.lang.model.element.Element>`

  returns: a list of types in elements - `java.util.List<javax.lang.model.element.TypeElement>`"
  (^java.util.List [^javax.lang.model.element.Element> elements]
    (ElementFilter/typesIn elements)))

(defn *packages-in
  "Returns a list of packages in elements.

  elements - the elements to filter - `javax.lang.model.element.Element>`

  returns: a list of packages in elements - `java.util.List<javax.lang.model.element.PackageElement>`"
  (^java.util.List [^javax.lang.model.element.Element> elements]
    (ElementFilter/packagesIn elements)))

