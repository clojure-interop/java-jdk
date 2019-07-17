(ns jdk.util.TooManyListenersException
  " The  TooManyListenersException  Exception is used as part of
  the Java Event model to annotate and implement a unicast special case of
  a multicast Event Source.


  The presence of a `throws TooManyListenersException` clause on any given
  concrete implementation of the normally multicast `void addXyzEventListener`
  event listener registration pattern is used to annotate that interface as
  implementing a unicast Listener special case, that is, that one and only
  one Listener may be registered on the particular event listener source
  concurrently."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util TooManyListenersException]))

(defn ->too-many-listeners-exception
  "Constructor.

  Constructs a TooManyListenersException with the specified detail message.
   A detail message is a String that describes this particular exception.

  s - the detail message - `java.lang.String`"
  ([^java.lang.String s]
    (new TooManyListenersException s))
  ([]
    (new TooManyListenersException )))

