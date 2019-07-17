(ns javax.xml.transform.URIResolver
  "An object that implements this interface that can be called by the processor
  to turn a URI used in document(), xsl:import, or xsl:include into a Source object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform URIResolver]))

(defn resolve
  "Called by the processor when it encounters
   an xsl:include, xsl:import, or document() function.

  href - An href attribute, which may be relative or absolute. - `java.lang.String`
  base - The base URI against which the first argument will be made absolute if the absolute URI is required. - `java.lang.String`

  returns: A Source object, or null if the href cannot be resolved,
   and the processor should try to resolve the URI itself. - `javax.xml.transform.Source`

  throws: javax.xml.transform.TransformerException - if an error occurs when trying to resolve the URI."
  ([^. this ^java.lang.String href ^java.lang.String base]
    (-> this (.resolve href base))))

