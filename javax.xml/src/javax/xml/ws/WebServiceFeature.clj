(ns javax.xml.ws.WebServiceFeature
  "A WebServiceFeature is used to represent a feature that can be
  enabled or disabled for a web service.

  The JAX-WS specification will define some standard features and
  JAX-WS implementors are free to define additional features if
  necessary.  Vendor specific features may not be portable so
  caution should be used when using them. Each Feature definition
  MUST define a public static final String ID
  that can be used in the Feature annotation to refer
  to the feature. This ID MUST be unique across all features
  of all vendors.  When defining a vendor specific feature ID,
  use a vendor specific namespace in the ID string."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws WebServiceFeature]))

(defn get-id
  "Get the unique identifier for this WebServiceFeature.

  returns: the unique identifier for this feature. - `java.lang.String`"
  ([^javax.xml.ws.WebServiceFeature this]
    (-> this (.getID))))

(defn enabled?
  "Returns true if this feature is enabled.

  returns: true if and only if the feature is enabled . - `boolean`"
  ([^javax.xml.ws.WebServiceFeature this]
    (-> this (.isEnabled))))

