(ns javax.xml.xpath.XPathFunction
  "XPathFunction provides access to XPath functions.

  Functions are identified by QName and arity in XPath."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.xpath XPathFunction]))

(defn evaluate
  "Evaluate the function with the specified arguments.

   To the greatest extent possible, side-effects should be avoided in the
   definition of extension functions. The implementation evaluating an
   XPath expression is under no obligation to call extension functions in
   any particular order or any particular number of times.

  args - The arguments, null is a valid value. - `java.util.List`

  returns: The result of evaluating the XPath function as an Object. - `java.lang.Object`

  throws: javax.xml.xpath.XPathFunctionException - If args cannot be evaluated with this XPath function."
  ([^javax.xml.xpath.XPathFunction this ^java.util.List args]
    (-> this (.evaluate args))))

