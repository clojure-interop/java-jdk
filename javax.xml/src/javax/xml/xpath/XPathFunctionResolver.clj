(ns javax.xml.xpath.XPathFunctionResolver
  "XPathFunctionResolver provides access to the set of user defined XPathFunctions.

  XPath functions are resolved by name and arity.
  The resolver is not needed for XPath built-in functions and the resolver
  cannot be used to override those functions.

  In particular, the resolver is only called for functions in an another
  namespace (functions with an explicit prefix). This means that you cannot
  use the XPathFunctionResolver to implement specifications
  like XML-Signature Syntax
  and Processing which extend the function library of XPath 1.0 in the
  same namespace. This is a consequence of the design of the resolver.

  If you wish to implement additional built-in functions, you will have to
  extend the underlying implementation directly."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.xpath XPathFunctionResolver]))

(defn resolve-function
  "Find a function in the set of available functions.

   If functionName or arity is null, then a NullPointerException is thrown.

  function-name - The function name. - `javax.xml.namespace.QName`
  arity - The number of arguments that the returned function must accept. - `int`

  returns: The function or null if no function named functionName with arity arguments exists. - `javax.xml.xpath.XPathFunction`

  throws: java.lang.NullPointerException - If functionName or arity is null."
  (^javax.xml.xpath.XPathFunction [^javax.xml.xpath.XPathFunctionResolver this ^javax.xml.namespace.QName function-name ^Integer arity]
    (-> this (.resolveFunction function-name arity))))

