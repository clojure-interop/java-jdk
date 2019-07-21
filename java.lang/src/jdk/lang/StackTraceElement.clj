(ns jdk.lang.StackTraceElement
  "An element in a stack trace, as returned by Throwable.getStackTrace().  Each element represents a single stack frame.
  All stack frames except for the one at the top of the stack represent
  a method invocation.  The frame at the top of the stack represents the
  execution point at which the stack trace was generated.  Typically,
  this is the point at which the throwable corresponding to the stack trace
  was created."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang StackTraceElement]))

(defn ->stack-trace-element
  "Constructor.

  Creates a stack trace element representing the specified execution
   point.

  declaring-class - the fully qualified name of the class containing the execution point represented by the stack trace element - `java.lang.String`
  method-name - the name of the method containing the execution point represented by the stack trace element - `java.lang.String`
  file-name - the name of the file containing the execution point represented by the stack trace element, or null if this information is unavailable - `java.lang.String`
  line-number - the line number of the source line containing the execution point represented by this stack trace element, or a negative number if this information is unavailable. A value of -2 indicates that the method containing the execution point is a native method - `int`

  throws: java.lang.NullPointerException - if declaringClass or methodName is null"
  (^StackTraceElement [^java.lang.String declaring-class ^java.lang.String method-name ^java.lang.String file-name ^Integer line-number]
    (new StackTraceElement declaring-class method-name file-name line-number)))

(defn get-file-name
  "Returns the name of the source file containing the execution point
   represented by this stack trace element.  Generally, this corresponds
   to the SourceFile attribute of the relevant class
   file (as per The Java Virtual Machine Specification, Section
   4.7.7).  In some systems, the name may refer to some source code unit
   other than a file, such as an entry in source repository.

  returns: the name of the file containing the execution point
           represented by this stack trace element, or null if
           this information is unavailable. - `java.lang.String`"
  (^java.lang.String [^StackTraceElement this]
    (-> this (.getFileName))))

(defn get-line-number
  "Returns the line number of the source line containing the execution
   point represented by this stack trace element.  Generally, this is
   derived from the LineNumberTable attribute of the relevant
   class file (as per The Java Virtual Machine
   Specification, Section 4.7.8).

  returns: the line number of the source line containing the execution
           point represented by this stack trace element, or a negative
           number if this information is unavailable. - `int`"
  (^Integer [^StackTraceElement this]
    (-> this (.getLineNumber))))

(defn get-class-name
  "Returns the fully qualified name of the class containing the
   execution point represented by this stack trace element.

  returns: the fully qualified name of the Class containing
           the execution point represented by this stack trace element. - `java.lang.String`"
  (^java.lang.String [^StackTraceElement this]
    (-> this (.getClassName))))

(defn get-method-name
  "Returns the name of the method containing the execution point
   represented by this stack trace element.  If the execution point is
   contained in an instance or class initializer, this method will return
   the appropriate special method name, <init> or
   <clinit>, as per Section 3.9 of The Java Virtual
   Machine Specification.

  returns: the name of the method containing the execution point
           represented by this stack trace element. - `java.lang.String`"
  (^java.lang.String [^StackTraceElement this]
    (-> this (.getMethodName))))

(defn native-method?
  "Returns true if the method containing the execution point
   represented by this stack trace element is a native method.

  returns: true if the method containing the execution point
           represented by this stack trace element is a native method. - `boolean`"
  (^Boolean [^StackTraceElement this]
    (-> this (.isNativeMethod))))

(defn to-string
  "Returns a string representation of this stack trace element.  The
   format of this string depends on the implementation, but the following
   examples may be regarded as typical:


     \"MyClass.mash(MyClass.java:9)\" - Here, \"MyClass\"
     is the fully-qualified name of the class containing the
     execution point represented by this stack trace element,
     \"mash\" is the name of the method containing the execution
     point, \"MyClass.java\" is the source file containing the
     execution point, and \"9\" is the line number of the source
     line containing the execution point.

     \"MyClass.mash(MyClass.java)\" - As above, but the line
     number is unavailable.

     \"MyClass.mash(Unknown Source)\" - As above, but neither
     the file name nor the line  number are available.

     \"MyClass.mash(Native Method)\" - As above, but neither
     the file name nor the line  number are available, and the method
     containing the execution point is known to be a native method.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^StackTraceElement this]
    (-> this (.toString))))

(defn equals
  "Returns true if the specified object is another
   StackTraceElement instance representing the same execution
   point as this instance.  Two stack trace elements a and
   b are equal if and only if:


       equals(a.getFileName(), b.getFileName()) &&
       a.getLineNumber() == b.getLineNumber()) &&
       equals(a.getClassName(), b.getClassName()) &&
       equals(a.getMethodName(), b.getMethodName())
   where equals has the semantics of Objects.equals.

  obj - the object to be compared with this stack trace element. - `java.lang.Object`

  returns: true if the specified object is another
           StackTraceElement instance representing the same
           execution point as this instance. - `boolean`"
  (^Boolean [^StackTraceElement this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code value for this stack trace element.

  returns: a hash code value for this object. - `int`"
  (^Integer [^StackTraceElement this]
    (-> this (.hashCode))))

