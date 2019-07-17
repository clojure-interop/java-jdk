(ns javax.xml.xpath.XPathExpression
  "XPathExpression provides access to compiled XPath expressions.





        Evaluation of XPath Expressions.




        context

          If a request is made to evaluate the expression in the absence
  of a context item, an empty document node will be used for the context.
  For the purposes of evaluating XPath expressions, a DocumentFragment
  is treated like a Document node.



       variables

         If the expression contains a variable reference, its value will be found through the XPathVariableResolver.
         An XPathExpressionException is raised if the variable resolver is undefined or
         the resolver returns null for the variable.
         The value of a variable must be immutable through the course of any single evaluation.



       functions

         If the expression contains a function reference, the function will be found through the XPathFunctionResolver.
         An XPathExpressionException is raised if the function resolver is undefined or
         the function resolver returns null for the function.



       QNames

         QNames in the expression are resolved against the XPath namespace context.



       result

         This result of evaluating an expression is converted to an instance of the desired return type.
         Valid return types are defined in XPathConstants.
         Conversion to the return type follows XPath conversion rules.




  An XPath expression is not thread-safe and not reentrant.
  In other words, it is the application's responsibility to make
  sure that one XPathExpression object is not used from
  more than one thread at any given time, and while the evaluate
  method is invoked, applications may not recursively call
  the evaluate method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.xpath XPathExpression]))

(defn evaluate
  "Evaluate the compiled XPath expression in the specified context and return the result as the specified type.

   See Evaluation of XPath Expressions for context item evaluation,
   variable, function and QName resolution and return type conversion.

   If returnType is not one of the types defined in XPathConstants,
   then an IllegalArgumentException is thrown.

   If a null value is provided for
   item, an empty document will be used for the
   context.
   If returnType is null, then a NullPointerException is thrown.

  item - The starting context (a node, for example). - `java.lang.Object`
  return-type - The desired return type. - `javax.xml.namespace.QName`

  returns: The Object that is the result of evaluating the expression and converting the result to
     returnType. - `java.lang.Object`

  throws: javax.xml.xpath.XPathExpressionException - If the expression cannot be evaluated."
  ([^. this ^java.lang.Object item ^javax.xml.namespace.QName return-type]
    (-> this (.evaluate item return-type)))
  ([^. this ^java.lang.Object item]
    (-> this (.evaluate item))))

