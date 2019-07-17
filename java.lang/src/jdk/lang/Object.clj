(ns jdk.lang.Object
  "Class Object is the root of the class hierarchy.
  Every class has Object as a superclass. All objects,
  including arrays, implement the methods of this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Object]))

(defn ->object
  "Constructor."
  ([]
    (new Object )))

(defn get-class
  "Returns the runtime class of this Object. The returned
   Class object is the object that is locked by static synchronized methods of the represented class.

   The actual result type is Class<? extends |X|>
   where |X| is the erasure of the static type of the
   expression on which getClass is called. For
   example, no cast is required in this code fragment:


   Number n = 0;
   Class<? extends Number> c = n.getClass();

  returns: The Class object that represents the runtime
           class of this object. - `java.lang.Class<?>`"
  (^java.lang.Class [^java.lang.Object this]
    (-> this (.getClass))))

(defn hash-code
  "Returns a hash code value for the object. This method is
   supported for the benefit of hash tables such as those provided by
   HashMap.

   The general contract of hashCode is:

   Whenever it is invoked on the same object more than once during
       an execution of a Java application, the hashCode method
       must consistently return the same integer, provided no information
       used in equals comparisons on the object is modified.
       This integer need not remain consistent from one execution of an
       application to another execution of the same application.
   If two objects are equal according to the equals(Object)
       method, then calling the hashCode method on each of
       the two objects must produce the same integer result.
   It is not required that if two objects are unequal
       according to the equals(java.lang.Object)
       method, then calling the hashCode method on each of the
       two objects must produce distinct integer results.  However, the
       programmer should be aware that producing distinct integer results
       for unequal objects may improve the performance of hash tables.


   As much as is reasonably practical, the hashCode method defined by
   class Object does return distinct integers for distinct
   objects. (This is typically implemented by converting the internal
   address of the object into an integer, but this implementation
   technique is not required by the
   Java™ programming language.)

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.lang.Object this]
    (-> this (.hashCode))))

(defn equals
  "Indicates whether some other object is `equal to` this one.

   The equals method implements an equivalence relation
   on non-null object references:

   It is reflexive: for any non-null reference value
       x, x.equals(x) should return
       true.
   It is symmetric: for any non-null reference values
       x and y, x.equals(y)
       should return true if and only if
       y.equals(x) returns true.
   It is transitive: for any non-null reference values
       x, y, and z, if
       x.equals(y) returns true and
       y.equals(z) returns true, then
       x.equals(z) should return true.
   It is consistent: for any non-null reference values
       x and y, multiple invocations of
       x.equals(y) consistently return true
       or consistently return false, provided no
       information used in equals comparisons on the
       objects is modified.
   For any non-null reference value x,
       x.equals(null) should return false.


   The equals method for class Object implements
   the most discriminating possible equivalence relation on objects;
   that is, for any non-null reference values x and
   y, this method returns true if and only
   if x and y refer to the same object
   (x == y has the value true).

   Note that it is generally necessary to override the hashCode
   method whenever this method is overridden, so as to maintain the
   general contract for the hashCode method, which states
   that equal objects must have equal hash codes.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^java.lang.Object this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn to-string
  "Returns a string representation of the object. In general, the
   toString method returns a string that
   `textually represents` this object. The result should
   be a concise but informative representation that is easy for a
   person to read.
   It is recommended that all subclasses override this method.

   The toString method for class Object
   returns a string consisting of the name of the class of which the
   object is an instance, the at-sign character `@', and
   the unsigned hexadecimal representation of the hash code of the
   object. In other words, this method returns a string equal to the
   value of:



   getClass().getName()  '@'  Integer.toHexString(hashCode())

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^java.lang.Object this]
    (-> this (.toString))))

(defn notify
  "Wakes up a single thread that is waiting on this object's
   monitor. If any threads are waiting on this object, one of them
   is chosen to be awakened. The choice is arbitrary and occurs at
   the discretion of the implementation. A thread waits on an object's
   monitor by calling one of the wait methods.

   The awakened thread will not be able to proceed until the current
   thread relinquishes the lock on this object. The awakened thread will
   compete in the usual manner with any other threads that might be
   actively competing to synchronize on this object; for example, the
   awakened thread enjoys no reliable privilege or disadvantage in being
   the next thread to lock this object.

   This method should only be called by a thread that is the owner
   of this object's monitor. A thread becomes the owner of the
   object's monitor in one of three ways:

   By executing a synchronized instance method of that object.
   By executing the body of a synchronized statement
       that synchronizes on the object.
   For objects of type Class, by executing a
       synchronized static method of that class.


   Only one thread at a time can own an object's monitor.

  throws: java.lang.IllegalMonitorStateException - if the current thread is not the owner of this object's monitor."
  ([^java.lang.Object this]
    (-> this (.notify))))

(defn notify-all
  "Wakes up all threads that are waiting on this object's monitor. A
   thread waits on an object's monitor by calling one of the
   wait methods.

   The awakened threads will not be able to proceed until the current
   thread relinquishes the lock on this object. The awakened threads
   will compete in the usual manner with any other threads that might
   be actively competing to synchronize on this object; for example,
   the awakened threads enjoy no reliable privilege or disadvantage in
   being the next thread to lock this object.

   This method should only be called by a thread that is the owner
   of this object's monitor. See the notify method for a
   description of the ways in which a thread can become the owner of
   a monitor.

  throws: java.lang.IllegalMonitorStateException - if the current thread is not the owner of this object's monitor."
  ([^java.lang.Object this]
    (-> this (.notifyAll))))

(defn wait
  "Causes the current thread to wait until another thread invokes the
   notify() method or the
   notifyAll() method for this object, or
   some other thread interrupts the current thread, or a certain
   amount of real time has elapsed.

   This method is similar to the wait method of one
   argument, but it allows finer control over the amount of time to
   wait for a notification before giving up. The amount of real time,
   measured in nanoseconds, is given by:



   1000000*timeout+nanos

   In all other respects, this method does the same thing as the
   method wait(long) of one argument. In particular,
   wait(0, 0) means the same thing as wait(0).

   The current thread must own this object's monitor. The thread
   releases ownership of this monitor and waits until either of the
   following two conditions has occurred:

   Another thread notifies threads waiting on this object's monitor
       to wake up either through a call to the notify method
       or the notifyAll method.
   The timeout period, specified by timeout
       milliseconds plus nanos nanoseconds arguments, has
       elapsed.


   The thread then waits until it can re-obtain ownership of the
   monitor and resumes execution.

   As in the one argument version, interrupts and spurious wakeups are
   possible, and this method should always be used in a loop:


       synchronized (obj) {
           while (<condition does not hold>)
               obj.wait(timeout, nanos);
           ... // Perform action appropriate to condition
       }
   This method should only be called by a thread that is the owner
   of this object's monitor. See the notify method for a
   description of the ways in which a thread can become the owner of
   a monitor.

  timeout - the maximum time to wait in milliseconds. - `long`
  nanos - additional time, in nanoseconds range 0-999999. - `int`

  throws: java.lang.IllegalArgumentException - if the value of timeout is negative or the value of nanos is not in the range 0-999999."
  ([^java.lang.Object this ^Long timeout ^Integer nanos]
    (-> this (.wait timeout nanos)))
  ([^java.lang.Object this ^Long timeout]
    (-> this (.wait timeout)))
  ([^java.lang.Object this]
    (-> this (.wait))))

