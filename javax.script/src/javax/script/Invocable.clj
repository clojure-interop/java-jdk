(ns javax.script.Invocable
  "The optional interface implemented by ScriptEngines whose methods allow the invocation of
  procedures in scripts that have previously been executed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script Invocable]))

(defn invoke-method
  "Calls a method on a script object compiled during a previous script execution,
   which is retained in the state of the ScriptEngine.

  thiz - If the procedure is a member of a class defined in the script and thiz is an instance of that class returned by a previous execution or invocation, the named method is called through that instance. - `java.lang.Object`
  name - The name of the procedure to be called. - `java.lang.String`
  args - Arguments to pass to the procedure. The rules for converting the arguments to scripting variables are implementation-specific. - `java.lang.Object`

  returns: The value returned by the procedure.  The rules for converting the scripting
   variable returned by the script method to a Java Object are implementation-specific. - `java.lang.Object`

  throws: javax.script.ScriptException - if an error occurs during invocation of the method."
  ([^. this ^java.lang.Object thiz ^java.lang.String name ^java.lang.Object args]
    (-> this (.invokeMethod thiz name args))))

(defn invoke-function
  "Used to call top-level procedures and functions defined in scripts.

  name - of the procedure or function to call - `java.lang.String`
  args - Arguments to pass to the procedure or function - `java.lang.Object`

  returns: The value returned by the procedure or function - `java.lang.Object`

  throws: javax.script.ScriptException - if an error occurs during invocation of the method."
  ([^. this ^java.lang.String name ^java.lang.Object args]
    (-> this (.invokeFunction name args))))

(defn get-interface
  "Returns an implementation of an interface using member functions of
   a scripting object compiled in the interpreter. The methods of the
   interface may be implemented using the invokeMethod method.

  thiz - The scripting object whose member functions are used to implement the methods of the interface. - `java.lang.Object`
  clasz - The Class object of the interface to return. - `java.lang.Class<T>`

  returns: An instance of requested interface - null if the requested interface is unavailable,
   i. e. if compiled methods in the ScriptEngine cannot be found matching
   the ones in the requested interface. - `<T> T`

  throws: java.lang.IllegalArgumentException - if the specified Class object is null or is not an interface, or if the specified Object is null or does not represent a scripting object."
  ([^. this ^java.lang.Object thiz ^java.lang.Class clasz]
    (-> this (.getInterface thiz clasz)))
  ([^. this ^java.lang.Class clasz]
    (-> this (.getInterface clasz))))

