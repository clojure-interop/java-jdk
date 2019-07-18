(ns javax.xml.xpath.XPathVariableResolver
  "XPathVariableResolver provides access to the set of user defined XPath variables.

  The XPathVariableResolver and the XPath evaluator must adhere to a contract that
  cannot be directly enforced by the API.  Although variables may be mutable,
  that is, an application may wish to evaluate the same XPath expression more
  than once with different variable values, in the course of evaluating any
  single XPath expression, a variable's value must
  not change."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.xpath XPathVariableResolver]))

(defn resolve-variable
  "Find a variable in the set of available variables.

   If variableName is null, then a NullPointerException is thrown.

  variable-name - The QName of the variable name. - `javax.xml.namespace.QName`

  returns: The variables value, or null if no variable named variableName
     exists.  The value returned must be of a type appropriate for the underlying object model. - `java.lang.Object`

  throws: java.lang.NullPointerException - If variableName is null."
  (^java.lang.Object [^XPathVariableResolver this ^javax.xml.namespace.QName variable-name]
    (-> this (.resolveVariable variable-name))))

