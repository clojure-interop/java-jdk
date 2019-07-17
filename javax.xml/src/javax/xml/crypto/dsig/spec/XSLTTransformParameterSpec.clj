(ns javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec
  "Parameters for the
  XSLT Transform Algorithm.
  The parameters include a namespace-qualified stylesheet element.

  An XSLTTransformParameterSpec is instantiated with a
  mechanism-dependent (ex: DOM) stylesheet element. For example:


    DOMStructure stylesheet = new DOMStructure(element)
    XSLTTransformParameterSpec spec = new XSLTransformParameterSpec(stylesheet);
  where element is an Element containing
  the namespace-qualified stylesheet element."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.spec XSLTTransformParameterSpec]))

(defn ->xslt-transform-parameter-spec
  "Constructor.

  Creates an XSLTTransformParameterSpec with the specified
   stylesheet.

  stylesheet - the XSLT stylesheet to be used - `javax.xml.crypto.XMLStructure`

  throws: java.lang.NullPointerException - if stylesheet is null"
  ([^javax.xml.crypto.XMLStructure stylesheet]
    (new XSLTTransformParameterSpec stylesheet)))

(defn get-stylesheet
  "Returns the stylesheet.

  returns: the stylesheet - `javax.xml.crypto.XMLStructure`"
  (^javax.xml.crypto.XMLStructure [^javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec this]
    (-> this (.getStylesheet))))

