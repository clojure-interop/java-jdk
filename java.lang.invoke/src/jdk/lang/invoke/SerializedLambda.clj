(ns jdk.lang.invoke.SerializedLambda
  "Serialized form of a lambda expression.  The properties of this class
  represent the information that is present at the lambda factory site, including
  static metafactory arguments such as the identity of the primary functional
  interface method and the identity of the implementation method, as well as
  dynamic metafactory arguments such as values captured from the lexical scope
  at the time of lambda capture.

  Implementors of serializable lambdas, such as compilers or language
  runtime libraries, are expected to ensure that instances deserialize properly.
  One means to do so is to ensure that the writeReplace method returns
  an instance of SerializedLambda, rather than allowing default
  serialization to proceed.

  SerializedLambda has a readResolve method that looks for
  a (possibly private) static method called
  $deserializeLambda$(SerializedLambda) in the capturing class, invokes
  that with itself as the first argument, and returns the result.  Lambda classes
  implementing $deserializeLambda$ are responsible for validating
  that the properties of the SerializedLambda are consistent with a
  lambda actually captured by that class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.invoke SerializedLambda]))

(defn ->serialized-lambda
  "Constructor.

  Create a SerializedLambda from the low-level information present
   at the lambda factory site.

  capturing-class - The class in which the lambda expression appears - `java.lang.Class`
  functional-interface-class - Name, in slash-delimited form, of static type of the returned lambda object - `java.lang.String`
  functional-interface-method-name - Name of the functional interface method for the present at the lambda factory site - `java.lang.String`
  functional-interface-method-signature - Signature of the functional interface method present at the lambda factory site - `java.lang.String`
  impl-method-kind - Method handle kind for the implementation method - `int`
  impl-class - Name, in slash-delimited form, for the class holding the implementation method - `java.lang.String`
  impl-method-name - Name of the implementation method - `java.lang.String`
  impl-method-signature - Signature of the implementation method - `java.lang.String`
  instantiated-method-type - The signature of the primary functional interface method after type variables are substituted with their instantiation from the capture site - `java.lang.String`
  captured-args - The dynamic arguments to the lambda factory site, which represent variables captured by the lambda - `java.lang.Object[]`"
  (^SerializedLambda [^java.lang.Class capturing-class ^java.lang.String functional-interface-class ^java.lang.String functional-interface-method-name ^java.lang.String functional-interface-method-signature ^Integer impl-method-kind ^java.lang.String impl-class ^java.lang.String impl-method-name ^java.lang.String impl-method-signature ^java.lang.String instantiated-method-type captured-args]
    (new SerializedLambda capturing-class functional-interface-class functional-interface-method-name functional-interface-method-signature impl-method-kind impl-class impl-method-name impl-method-signature instantiated-method-type captured-args)))

(defn get-functional-interface-method-signature
  "Get the signature of the primary method for the functional
   interface to which this lambda has been converted.

  returns: the signature of the primary method of the functional
   interface - `java.lang.String`"
  (^java.lang.String [^SerializedLambda this]
    (-> this (.getFunctionalInterfaceMethodSignature))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^SerializedLambda this]
    (-> this (.toString))))

(defn get-impl-method-kind
  "Get the method handle kind (see MethodHandleInfo) of
   the implementation method.

  returns: the method handle kind of the implementation method - `int`"
  (^Integer [^SerializedLambda this]
    (-> this (.getImplMethodKind))))

(defn get-captured-arg-count
  "Get the count of dynamic arguments to the lambda capture site.

  returns: the count of dynamic arguments to the lambda capture site - `int`"
  (^Integer [^SerializedLambda this]
    (-> this (.getCapturedArgCount))))

(defn get-impl-method-name
  "Get the name of the implementation method.

  returns: the name of the implementation method - `java.lang.String`"
  (^java.lang.String [^SerializedLambda this]
    (-> this (.getImplMethodName))))

(defn get-impl-class
  "Get the name of the class containing the implementation
   method.

  returns: the name of the class containing the implementation
   method - `java.lang.String`"
  (^java.lang.String [^SerializedLambda this]
    (-> this (.getImplClass))))

(defn get-functional-interface-class
  "Get the name of the invoked type to which this
   lambda has been converted

  returns: the name of the functional interface class to which
   this lambda has been converted - `java.lang.String`"
  (^java.lang.String [^SerializedLambda this]
    (-> this (.getFunctionalInterfaceClass))))

(defn get-capturing-class
  "Get the name of the class that captured this lambda.

  returns: the name of the class that captured this lambda - `java.lang.String`"
  (^java.lang.String [^SerializedLambda this]
    (-> this (.getCapturingClass))))

(defn get-instantiated-method-type
  "Get the signature of the primary functional interface method
   after type variables are substituted with their instantiation
   from the capture site.

  returns: the signature of the primary functional interface method
   after type variable processing - `java.lang.String`"
  (^java.lang.String [^SerializedLambda this]
    (-> this (.getInstantiatedMethodType))))

(defn get-captured-arg
  "Get a dynamic argument to the lambda capture site.

  i - the argument to capture - `int`

  returns: a dynamic argument to the lambda capture site - `java.lang.Object`"
  (^java.lang.Object [^SerializedLambda this ^Integer i]
    (-> this (.getCapturedArg i))))

(defn get-functional-interface-method-name
  "Get the name of the primary method for the functional interface
   to which this lambda has been converted.

  returns: the name of the primary methods of the functional interface - `java.lang.String`"
  (^java.lang.String [^SerializedLambda this]
    (-> this (.getFunctionalInterfaceMethodName))))

(defn get-impl-method-signature
  "Get the signature of the implementation method.

  returns: the signature of the implementation method - `java.lang.String`"
  (^java.lang.String [^SerializedLambda this]
    (-> this (.getImplMethodSignature))))

