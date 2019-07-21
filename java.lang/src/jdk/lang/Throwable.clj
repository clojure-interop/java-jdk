(ns jdk.lang.Throwable
  "The Throwable class is the superclass of all errors and
  exceptions in the Java language. Only objects that are instances of this
  class (or one of its subclasses) are thrown by the Java Virtual Machine or
  can be thrown by the Java throw statement. Similarly, only
  this class or one of its subclasses can be the argument type in a
  catch clause.

  For the purposes of compile-time checking of exceptions, Throwable and any subclass of Throwable that is not also a
  subclass of either RuntimeException or Error are
  regarded as checked exceptions.

  Instances of two subclasses, Error and
  Exception, are conventionally used to indicate
  that exceptional situations have occurred. Typically, these instances
  are freshly created in the context of the exceptional situation so
  as to include relevant information (such as stack trace data).

  A throwable contains a snapshot of the execution stack of its
  thread at the time it was created. It can also contain a message
  string that gives more information about the error. Over time, a
  throwable can suppress other
  throwables from being propagated.  Finally, the throwable can also
  contain a cause: another throwable that caused this
  throwable to be constructed.  The recording of this causal information
  is referred to as the chained exception facility, as the
  cause can, itself, have a cause, and so on, leading to a \"chain\" of
  exceptions, each caused by another.

  One reason that a throwable may have a cause is that the class that
  throws it is built atop a lower layered abstraction, and an operation on
  the upper layer fails due to a failure in the lower layer.  It would be bad
  design to let the throwable thrown by the lower layer propagate outward, as
  it is generally unrelated to the abstraction provided by the upper layer.
  Further, doing so would tie the API of the upper layer to the details of
  its implementation, assuming the lower layer's exception was a checked
  exception.  Throwing a \"wrapped exception\" (i.e., an exception containing a
  cause) allows the upper layer to communicate the details of the failure to
  its caller without incurring either of these shortcomings.  It preserves
  the flexibility to change the implementation of the upper layer without
  changing its API (in particular, the set of exceptions thrown by its
  methods).

  A second reason that a throwable may have a cause is that the method
  that throws it must conform to a general-purpose interface that does not
  permit the method to throw the cause directly.  For example, suppose
  a persistent collection conforms to the Collection interface, and that its persistence is implemented atop
  java.io.  Suppose the internals of the add method
  can throw an IOException.  The implementation
  can communicate the details of the IOException to its caller
  while conforming to the Collection interface by wrapping the
  IOException in an appropriate unchecked exception.  (The
  specification for the persistent collection should indicate that it is
  capable of throwing such exceptions.)

  A cause can be associated with a throwable in two ways: via a
  constructor that takes the cause as an argument, or via the
  initCause(Throwable) method.  New throwable classes that
  wish to allow causes to be associated with them should provide constructors
  that take a cause and delegate (perhaps indirectly) to one of the
  Throwable constructors that takes a cause.

  Because the initCause method is public, it allows a cause to be
  associated with any throwable, even a \"legacy throwable\" whose
  implementation predates the addition of the exception chaining mechanism to
  Throwable.

  By convention, class Throwable and its subclasses have two
  constructors, one that takes no arguments and one that takes a
  String argument that can be used to produce a detail message.
  Further, those subclasses that might likely have a cause associated with
  them should have two more constructors, one that takes a
  Throwable (the cause), and one that takes a
  String (the detail message) and a Throwable (the
  cause)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Throwable]))

(defn ->throwable
  "Constructor.

  Constructs a new throwable with the specified detail message and
   cause.  Note that the detail message associated with
   cause is not automatically incorporated in
   this throwable's detail message.

   The fillInStackTrace() method is called to initialize
   the stack trace data in the newly created throwable.

  message - the detail message (which is saved for later retrieval by the getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^Throwable [^java.lang.String message ^java.lang.Throwable cause]
    (new Throwable message cause))
  (^Throwable [^java.lang.String message]
    (new Throwable message))
  (^Throwable []
    (new Throwable )))

(defn get-stack-trace
  "Provides programmatic access to the stack trace information printed by
   printStackTrace().  Returns an array of stack trace elements,
   each representing one stack frame.  The zeroth element of the array
   (assuming the array's length is non-zero) represents the top of the
   stack, which is the last method invocation in the sequence.  Typically,
   this is the point at which this throwable was created and thrown.
   The last element of the array (assuming the array's length is non-zero)
   represents the bottom of the stack, which is the first method invocation
   in the sequence.

   Some virtual machines may, under some circumstances, omit one
   or more stack frames from the stack trace.  In the extreme case,
   a virtual machine that has no stack trace information concerning
   this throwable is permitted to return a zero-length array from this
   method.  Generally speaking, the array returned by this method will
   contain one element for every frame that would be printed by
   printStackTrace.  Writes to the returned array do not
   affect future calls to this method.

  returns: an array of stack trace elements representing the stack trace
           pertaining to this throwable. - `java.lang.StackTraceElement[]`"
  ([^Throwable this]
    (-> this (.getStackTrace))))

(defn add-suppressed
  "Appends the specified exception to the exceptions that were
   suppressed in order to deliver this exception. This method is
   thread-safe and typically called (automatically and implicitly)
   by the try-with-resources statement.

   The suppression behavior is enabled unless disabled
   via
   a constructor.  When suppression is disabled, this method does
   nothing other than to validate its argument.

   Note that when one exception causes another exception, the first
   exception is usually caught and then the second exception is
   thrown in response.  In other words, there is a causal
   connection between the two exceptions.

   In contrast, there are situations where two independent
   exceptions can be thrown in sibling code blocks, in particular
   in the try block of a try-with-resources
   statement and the compiler-generated finally block
   which closes the resource.

   In these situations, only one of the thrown exceptions can be
   propagated.  In the try-with-resources statement, when
   there are two such exceptions, the exception originating from
   the try block is propagated and the exception from the
   finally block is added to the list of exceptions
   suppressed by the exception from the try block.  As an
   exception unwinds the stack, it can accumulate multiple
   suppressed exceptions.

   An exception may have suppressed exceptions while also being
   caused by another exception.  Whether or not an exception has a
   cause is semantically known at the time of its creation, unlike
   whether or not an exception will suppress other exceptions
   which is typically only determined after an exception is
   thrown.

   Note that programmer written code is also able to take
   advantage of calling this method in situations where there are
   multiple sibling exceptions and only one can be propagated.

  exception - the exception to be added to the list of suppressed exceptions - `java.lang.Throwable`

  throws: java.lang.IllegalArgumentException - if exception is this throwable; a throwable cannot suppress itself."
  ([^Throwable this ^java.lang.Throwable exception]
    (-> this (.addSuppressed exception))))

(defn init-cause
  "Initializes the cause of this throwable to the specified value.
   (The cause is the throwable that caused this throwable to get thrown.)

   This method can be called at most once.  It is generally called from
   within the constructor, or immediately after creating the
   throwable.  If this throwable was created
   with Throwable(Throwable) or
   Throwable(String,Throwable), this method cannot be called
   even once.

   An example of using this method on a legacy throwable type
   without other support for setting the cause is:



   try {
       lowLevelOp();
   } catch (LowLevelException le) {
       throw (HighLevelException)
             new HighLevelException().initCause(le); // Legacy constructor
   }

  cause - the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`

  returns: a reference to this Throwable instance. - `java.lang.Throwable`

  throws: java.lang.IllegalArgumentException - if cause is this throwable. (A throwable cannot be its own cause.)"
  (^java.lang.Throwable [^Throwable this ^java.lang.Throwable cause]
    (-> this (.initCause cause))))

(defn to-string
  "Returns a short description of this throwable.
   The result is the concatenation of:

    the name of the class of this object
    \": \" (a colon and a space)
    the result of invoking this object's getLocalizedMessage()
        method

   If getLocalizedMessage returns null, then just
   the class name is returned.

  returns: a string representation of this throwable. - `java.lang.String`"
  (^java.lang.String [^Throwable this]
    (-> this (.toString))))

(defn get-suppressed
  "Returns an array containing all of the exceptions that were
   suppressed, typically by the try-with-resources
   statement, in order to deliver this exception.

   If no exceptions were suppressed or suppression is
   disabled, an empty array is returned.  This method is
   thread-safe.  Writes to the returned array do not affect future
   calls to this method.

  returns: an array containing all of the exceptions that were
           suppressed to deliver this exception. - `java.lang.Throwable[]`"
  ([^Throwable this]
    (-> this (.getSuppressed))))

(defn print-stack-trace
  "Prints this throwable and its backtrace to the specified print stream.

  s - PrintStream to use for output - `java.io.PrintStream`"
  ([^Throwable this ^java.io.PrintStream s]
    (-> this (.printStackTrace s)))
  ([^Throwable this]
    (-> this (.printStackTrace))))

(defn get-localized-message
  "Creates a localized description of this throwable.
   Subclasses may override this method in order to produce a
   locale-specific message.  For subclasses that do not override this
   method, the default implementation returns the same result as
   getMessage().

  returns: The localized description of this throwable. - `java.lang.String`"
  (^java.lang.String [^Throwable this]
    (-> this (.getLocalizedMessage))))

(defn get-message
  "Returns the detail message string of this throwable.

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  (^java.lang.String [^Throwable this]
    (-> this (.getMessage))))

(defn fill-in-stack-trace
  "Fills in the execution stack trace. This method records within this
   Throwable object information about the current state of
   the stack frames for the current thread.

   If the stack trace of this Throwable is not
   writable, calling this method has no effect.

  returns: a reference to this Throwable instance. - `java.lang.Throwable`"
  (^java.lang.Throwable [^Throwable this]
    (-> this (.fillInStackTrace))))

(defn set-stack-trace
  "Sets the stack trace elements that will be returned by
   getStackTrace() and printed by printStackTrace()
   and related methods.

   This method, which is designed for use by RPC frameworks and other
   advanced systems, allows the client to override the default
   stack trace that is either generated by fillInStackTrace()
   when a throwable is constructed or deserialized when a throwable is
   read from a serialization stream.

   If the stack trace of this Throwable is not
   writable, calling this method has no effect other than
   validating its argument.

  stack-trace - the stack trace elements to be associated with this Throwable. The specified array is copied by this call; changes in the specified array after the method invocation returns will have no affect on this Throwable's stack trace. - `java.lang.StackTraceElement[]`

  throws: java.lang.NullPointerException - if stackTrace is null or if any of the elements of stackTrace are null"
  ([^Throwable this stack-trace]
    (-> this (.setStackTrace stack-trace))))

(defn get-cause
  "Returns the cause of this throwable or null if the
   cause is nonexistent or unknown.  (The cause is the throwable that
   caused this throwable to get thrown.)

   This implementation returns the cause that was supplied via one of
   the constructors requiring a Throwable, or that was set after
   creation with the initCause(Throwable) method.  While it is
   typically unnecessary to override this method, a subclass can override
   it to return a cause set by some other means.  This is appropriate for
   a \"legacy chained throwable\" that predates the addition of chained
   exceptions to Throwable.  Note that it is not
   necessary to override any of the PrintStackTrace methods,
   all of which invoke the getCause method to determine the
   cause of a throwable.

  returns: the cause of this throwable or null if the
            cause is nonexistent or unknown. - `java.lang.Throwable`"
  (^java.lang.Throwable [^Throwable this]
    (-> this (.getCause))))

