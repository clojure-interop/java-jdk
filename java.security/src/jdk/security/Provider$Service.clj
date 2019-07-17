(ns jdk.security.Provider$Service
  "The description of a security service. It encapsulates the properties
  of a service and contains a factory method to obtain new implementation
  instances of this service.

  Each service has a provider that offers the service, a type,
  an algorithm name, and the name of the class that implements the
  service. Optionally, it also includes a list of alternate algorithm
  names for this service (aliases) and attributes, which are a map of
  (name, value) String pairs.

  This class defines the methods supportsParameter() and newInstance()
  which are used by the Java security framework when it searches for
  suitable services and instantiates them. The valid arguments to those
  methods depend on the type of service. For the service types defined
  within Java SE, see the

  Java Cryptography Architecture API Specification & Reference
  for the valid values.
  Note that components outside of Java SE can define additional types of
  services and their behavior.

  Instances of this class are immutable."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Provider$Service]))

(defn ->service
  "Constructor.

  Construct a new service.

  provider - the provider that offers this service - `java.security.Provider`
  type - the type of this service - `java.lang.String`
  algorithm - the algorithm name - `java.lang.String`
  class-name - the name of the class implementing this service - `java.lang.String`
  aliases - List of aliases or null if algorithm has no aliases - `java.util.List<java.lang.String>`
  attributes - Map of attributes or null if this implementation has no attributes - `java.util.Map<java.lang.String,java.lang.String>`

  throws: java.lang.NullPointerException - if provider, type, algorithm, or className is null"
  ([provider type algorithm class-name aliases attributes]
    (new Provider$Service provider type algorithm class-name aliases attributes)))

(defn get-type
  "Get the type of this service. For example, MessageDigest.

  returns: the type of this service - `java.lang.String`"
  ([this]
    (-> this (.getType))))

(defn get-algorithm
  "Return the name of the algorithm of this service. For example,
   SHA-1.

  returns: the algorithm of this service - `java.lang.String`"
  ([this]
    (-> this (.getAlgorithm))))

(defn get-provider
  "Return the Provider of this service.

  returns: the Provider of this service - `java.security.Provider`"
  ([this]
    (-> this (.getProvider))))

(defn get-class-name
  "Return the name of the class implementing this service.

  returns: the name of the class implementing this service - `java.lang.String`"
  ([this]
    (-> this (.getClassName))))

(defn get-attribute
  "Return the value of the specified attribute or null if this
   attribute is not set for this Service.

  name - the name of the requested attribute - `java.lang.String`

  returns: the value of the specified attribute or null if the
           attribute is not present - `java.lang.String`

  throws: java.lang.NullPointerException - if name is null"
  ([this name]
    (-> this (.getAttribute name))))

(defn new-instance
  "Return a new instance of the implementation described by this
   service. The security provider framework uses this method to
   construct implementations. Applications will typically not need
   to call it.

   The default implementation uses reflection to invoke the
   standard constructor for this type of service.
   Security providers can override this method to implement
   instantiation in a different way.
   For details and the values of constructorParameter that are
   valid for the various types of services see the

   Java Cryptography Architecture API Specification &
   Reference.

  constructor-parameter - the value to pass to the constructor, or null if this type of service does not use a constructorParameter. - `java.lang.Object`

  returns: a new implementation of this service - `java.lang.Object`

  throws: java.security.InvalidParameterException - if the value of constructorParameter is invalid for this type of service."
  ([this constructor-parameter]
    (-> this (.newInstance constructor-parameter))))

(defn supports-parameter
  "Test whether this Service can use the specified parameter.
   Returns false if this service cannot use the parameter. Returns
   true if this service can use the parameter, if a fast test is
   infeasible, or if the status is unknown.

   The security provider framework uses this method with
   some types of services to quickly exclude non-matching
   implementations for consideration.
   Applications will typically not need to call it.

   For details and the values of parameter that are valid for the
   various types of services see the top of this class and the

   Java Cryptography Architecture API Specification &
   Reference.
   Security providers can override it to implement their own test.

  parameter - the parameter to test - `java.lang.Object`

  returns: false if this this service cannot use the specified
   parameter; true if it can possibly use the parameter - `boolean`

  throws: java.security.InvalidParameterException - if the value of parameter is invalid for this type of service or if this method cannot be used with this type of service"
  ([this parameter]
    (-> this (.supportsParameter parameter))))

(defn to-string
  "Return a String representation of this service.

  returns: a String representation of this service. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

