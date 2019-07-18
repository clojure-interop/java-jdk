(ns javax.xml.xpath.XPath
  "XPath provides access to the XPath evaluation environment and expressions.





        Evaluation of XPath Expressions.




        context

          If a request is made to evaluate the expression in the absence
  of a context item, an empty document node will be used for the context.
  For the purposes of evaluating XPath expressions, a DocumentFragment
  is treated like a Document node.



       variables

         If the expression contains a variable reference, its value will be found through the XPathVariableResolver
         set with setXPathVariableResolver(XPathVariableResolver resolver).
         An XPathExpressionException is raised if the variable resolver is undefined or
         the resolver returns null for the variable.
         The value of a variable must be immutable through the course of any single evaluation.



       functions

         If the expression contains a function reference, the function will be found through the XPathFunctionResolver
         set with setXPathFunctionResolver(XPathFunctionResolver resolver).
         An XPathExpressionException is raised if the function resolver is undefined or
         the function resolver returns null for the function.



       QNames

         QNames in the expression are resolved against the XPath namespace context
         set with setNamespaceContext(NamespaceContext nsContext).



       result

         This result of evaluating an expression is converted to an instance of the desired return type.
         Valid return types are defined in XPathConstants.
         Conversion to the return type follows XPath conversion rules.




  An XPath object is not thread-safe and not reentrant.
  In other words, it is the application's responsibility to make
  sure that one XPath object is not used from
  more than one thread at any given time, and while the evaluate
  method is invoked, applications may not recursively call
  the evaluate method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.xpath XPath]))

(defn set-x-path-function-resolver
  "Establish a function resolver.

   A NullPointerException is thrown if resolver is null.

  resolver - XPath function resolver. - `javax.xml.xpath.XPathFunctionResolver`

  throws: java.lang.NullPointerException - If resolver is null."
  ([^XPath this ^javax.xml.xpath.XPathFunctionResolver resolver]
    (-> this (.setXPathFunctionResolver resolver))))

(defn set-x-path-variable-resolver
  "Establish a variable resolver.

   A NullPointerException is thrown if resolver is null.

  resolver - Variable resolver. - `javax.xml.xpath.XPathVariableResolver`

  throws: java.lang.NullPointerException - If resolver is null."
  ([^XPath this ^javax.xml.xpath.XPathVariableResolver resolver]
    (-> this (.setXPathVariableResolver resolver))))

(defn set-namespace-context
  "Establish a namespace context.

   A NullPointerException is thrown if nsContext is null.

  ns-context - Namespace context to use. - `javax.xml.namespace.NamespaceContext`

  throws: java.lang.NullPointerException - If nsContext is null."
  ([^XPath this ^javax.xml.namespace.NamespaceContext ns-context]
    (-> this (.setNamespaceContext ns-context))))

(defn reset
  "Reset this XPath to its original configuration.

   XPath is reset to the same state as when it was created with
   XPathFactory.newXPath().
   reset() is designed to allow the reuse of existing XPaths
   thus saving resources associated with the creation of new XPaths.

   The reset XPath is not guaranteed to have the same XPathFunctionResolver, XPathVariableResolver
   or NamespaceContext Objects, e.g. Object.equals(Object obj).
   It is guaranteed to have a functionally equal XPathFunctionResolver, XPathVariableResolver
   and NamespaceContext."
  ([^XPath this]
    (-> this (.reset))))

(defn evaluate
  "Evaluate an XPath expression in the specified context and return the result as the specified type.

   See Evaluation of XPath Expressions for context item evaluation,
   variable, function and QName resolution and return type conversion.

   If returnType is not one of the types defined in XPathConstants (
   NUMBER,
   STRING,
   BOOLEAN,
   NODE or
   NODESET)
   then an IllegalArgumentException is thrown.

   If a null value is provided for
   item, an empty document will be used for the
   context.
   If expression or returnType is null, then a
   NullPointerException is thrown.

  expression - The XPath expression. - `java.lang.String`
  item - The starting context (a node, for example). - `java.lang.Object`
  return-type - The desired return type. - `javax.xml.namespace.QName`

  returns: Result of evaluating an XPath expression as an Object of returnType. - `java.lang.Object`

  throws: javax.xml.xpath.XPathExpressionException - If expression cannot be evaluated."
  (^java.lang.Object [^XPath this ^java.lang.String expression ^java.lang.Object item ^javax.xml.namespace.QName return-type]
    (-> this (.evaluate expression item return-type)))
  (^java.lang.String [^XPath this ^java.lang.String expression ^java.lang.Object item]
    (-> this (.evaluate expression item))))

(defn get-namespace-context
  "Return the current namespace context.

   null is returned in no namespace context is in effect.

  returns: Current Namespace context. - `javax.xml.namespace.NamespaceContext`"
  (^javax.xml.namespace.NamespaceContext [^XPath this]
    (-> this (.getNamespaceContext))))

(defn compile
  "Compile an XPath expression for later evaluation.

   If expression contains any XPathFunctions,
   they must be available via the XPathFunctionResolver.
   An XPathExpressionException will be thrown if the
   XPathFunction
   cannot be resovled with the XPathFunctionResolver.

   If expression contains any variables, the
   XPathVariableResolver in effect
   at compile time will be used to resolve them.

   If expression is null, a NullPointerException is thrown.

  expression - The XPath expression. - `java.lang.String`

  returns: Compiled XPath expression. - `javax.xml.xpath.XPathExpression`

  throws: javax.xml.xpath.XPathExpressionException - If expression cannot be compiled."
  (^javax.xml.xpath.XPathExpression [^XPath this ^java.lang.String expression]
    (-> this (.compile expression))))

(defn get-x-path-function-resolver
  "Return the current function resolver.

   null is returned in no function resolver is in effect.

  returns: Current function resolver. - `javax.xml.xpath.XPathFunctionResolver`"
  (^javax.xml.xpath.XPathFunctionResolver [^XPath this]
    (-> this (.getXPathFunctionResolver))))

(defn get-x-path-variable-resolver
  "Return the current variable resolver.

   null is returned in no variable resolver is in effect.

  returns: Current variable resolver. - `javax.xml.xpath.XPathVariableResolver`"
  (^javax.xml.xpath.XPathVariableResolver [^XPath this]
    (-> this (.getXPathVariableResolver))))

