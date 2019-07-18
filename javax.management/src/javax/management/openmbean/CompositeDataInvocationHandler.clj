(ns javax.management.openmbean.CompositeDataInvocationHandler
  "An InvocationHandler that forwards getter methods to a
    CompositeData.  If you have an interface that contains
    only getter methods (such as String getName() or
    boolean isActive()) then you can use this class in
    conjunction with the Proxy class to produce an implementation
    of the interface where each getter returns the value of the
    corresponding item in a CompositeData.

    For example, suppose you have an interface like this:




    public interface NamedNumber {
        public int getNumber();
        public String getName();
    }


    and a CompositeData constructed like this:




    CompositeData cd =
        new CompositeDataSupport(
            someCompositeType,
            new String[] {`number`, `name`},
            new Object[] {5, `five`}
        );


    then you can construct an object implementing NamedNumber
    and backed by the object cd like this:




    InvocationHandler handler =
        new CompositeDataInvocationHandler(cd);
    NamedNumber nn = (NamedNumber)
        Proxy.newProxyInstance(NamedNumber.class.getClassLoader(),
                               new Class[] {NamedNumber.class},
                               handler);


    A call to nn.getNumber() will then return 5.

    If the first letter of the property defined by a getter is a
    capital, then this handler will look first for an item in the
    CompositeData beginning with a capital, then, if that is
    not found, for an item beginning with the corresponding lowercase
    letter or code point.  For a getter called getNumber(), the
    handler will first look for an item called Number, then for
    number.  If the getter is called getnumber(), then
    the item must be called number.

    If the method given to invoke is the method
    boolean equals(Object) inherited from Object, then
    it will return true if and only if the argument is a Proxy
    whose InvocationHandler is also a CompositeDataInvocationHandler and whose backing CompositeData is equal (not necessarily identical) to this
    object's.  If the method given to invoke is the method
    int hashCode() inherited from Object, then it will
    return a value that is consistent with this definition of equals: if two objects are equal according to equals, then
    they will have the same hashCode."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean CompositeDataInvocationHandler]))

(defn ->composite-data-invocation-handler
  "Constructor.

  Construct a handler backed by the given CompositeData.

  composite-data - the CompositeData that will supply information to getters. - `javax.management.openmbean.CompositeData`

  throws: java.lang.IllegalArgumentException - if compositeData is null."
  (^CompositeDataInvocationHandler [^javax.management.openmbean.CompositeData composite-data]
    (new CompositeDataInvocationHandler composite-data)))

(defn get-composite-data
  "Return the CompositeData that was supplied to the
         constructor.

  returns: the CompositeData that this handler is backed
         by.  This is never null. - `javax.management.openmbean.CompositeData`"
  (^javax.management.openmbean.CompositeData [^CompositeDataInvocationHandler this]
    (-> this (.getCompositeData))))

(defn invoke
  "Description copied from interface: InvocationHandler

  proxy - the proxy instance that the method was invoked on - `java.lang.Object`
  method - the Method instance corresponding to the interface method invoked on the proxy instance. The declaring class of the Method object will be the interface that the method was declared in, which may be a superinterface of the proxy interface that the proxy class inherits the method through. - `java.lang.reflect.Method`
  args - an array of objects containing the values of the arguments passed in the method invocation on the proxy instance, or null if interface method takes no arguments. Arguments of primitive types are wrapped in instances of the appropriate primitive wrapper class, such as java.lang.Integer or java.lang.Boolean. - `java.lang.Object[]`

  returns: the value to return from the method invocation on the
   proxy instance.  If the declared return type of the interface
   method is a primitive type, then the value returned by
   this method must be an instance of the corresponding primitive
   wrapper class; otherwise, it must be a type assignable to the
   declared return type.  If the value returned by this method is
   null and the interface method's return type is
   primitive, then a NullPointerException will be
   thrown by the method invocation on the proxy instance.  If the
   value returned by this method is otherwise not compatible with
   the interface method's declared return type as described above,
   a ClassCastException will be thrown by the method
   invocation on the proxy instance. - `java.lang.Object`

  throws: java.lang.Throwable - the exception to throw from the method invocation on the proxy instance. The exception's type must be assignable either to any of the exception types declared in the throws clause of the interface method or to the unchecked exception types java.lang.RuntimeException or java.lang.Error. If a checked exception is thrown by this method that is not assignable to any of the exception types declared in the throws clause of the interface method, then an UndeclaredThrowableException containing the exception that was thrown by this method will be thrown by the method invocation on the proxy instance."
  (^java.lang.Object [^CompositeDataInvocationHandler this ^java.lang.Object proxy ^java.lang.reflect.Method method args]
    (-> this (.invoke proxy method args))))

