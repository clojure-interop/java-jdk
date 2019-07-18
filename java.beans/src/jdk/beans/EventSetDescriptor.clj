(ns jdk.beans.EventSetDescriptor
  "An EventSetDescriptor describes a group of events that a given Java
  bean fires.

  The given group of events are all delivered as method calls on a single
  event listener interface, and an event listener object can be registered
  via a call on a registration method supplied by the event source."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans EventSetDescriptor]))

(defn ->event-set-descriptor
  "Constructor.

  This constructor creates an EventSetDescriptor from scratch using
   string names.

  source-class - The class firing the event. - `java.lang.Class`
  event-set-name - The programmatic name of the event set. Note that this should normally start with a lower-case character. - `java.lang.String`
  listener-type - The Class of the target interface that events will get delivered to. - `java.lang.Class`
  listener-method-names - The names of the methods that will get called when the event gets delivered to its target listener interface. - `java.lang.String[]`
  add-listener-method-name - The name of the method on the event source that can be used to register an event listener object. - `java.lang.String`
  remove-listener-method-name - The name of the method on the event source that can be used to de-register an event listener object. - `java.lang.String`
  get-listener-method-name - The method on the event source that can be used to access the array of event listener objects. - `java.lang.String`

  throws: java.beans.IntrospectionException - if an exception occurs during introspection."
  (^EventSetDescriptor [^java.lang.Class source-class ^java.lang.String event-set-name ^java.lang.Class listener-type listener-method-names ^java.lang.String add-listener-method-name ^java.lang.String remove-listener-method-name ^java.lang.String get-listener-method-name]
    (new EventSetDescriptor source-class event-set-name listener-type listener-method-names add-listener-method-name remove-listener-method-name get-listener-method-name))
  (^EventSetDescriptor [^java.lang.Class source-class ^java.lang.String event-set-name ^java.lang.Class listener-type listener-method-names ^java.lang.String add-listener-method-name ^java.lang.String remove-listener-method-name]
    (new EventSetDescriptor source-class event-set-name listener-type listener-method-names add-listener-method-name remove-listener-method-name))
  (^EventSetDescriptor [^java.lang.String event-set-name ^java.lang.Class listener-type listener-methods ^java.lang.reflect.Method add-listener-method ^java.lang.reflect.Method remove-listener-method]
    (new EventSetDescriptor event-set-name listener-type listener-methods add-listener-method remove-listener-method))
  (^EventSetDescriptor [^java.lang.Class source-class ^java.lang.String event-set-name ^java.lang.Class listener-type ^java.lang.String listener-method-name]
    (new EventSetDescriptor source-class event-set-name listener-type listener-method-name)))

(defn get-listener-methods
  "Gets the methods of the target listener interface.

  returns: An array of Method objects for the target methods
   within the target listener interface that will get called when
   events are fired. - `java.lang.reflect.Method[]`"
  ([^EventSetDescriptor this]
    (-> this (.getListenerMethods))))

(defn set-in-default-event-set
  "Marks an event set as being in the `default` set (or not).
   By default this is true.

  in-default-event-set - true if the event set is in the `default` set, false if not - `boolean`"
  ([^EventSetDescriptor this ^Boolean in-default-event-set]
    (-> this (.setInDefaultEventSet in-default-event-set))))

(defn get-add-listener-method
  "Gets the method used to add event listeners.

  returns: The method used to register a listener at the event source. - `java.lang.reflect.Method`"
  (^java.lang.reflect.Method [^EventSetDescriptor this]
    (-> this (.getAddListenerMethod))))

(defn set-unicast
  "Mark an event set as unicast (or not).

  unicast - True if the event set is unicast. - `boolean`"
  ([^EventSetDescriptor this ^Boolean unicast]
    (-> this (.setUnicast unicast))))

(defn get-listener-type
  "Gets the Class object for the target interface.

  returns: The Class object for the target interface that will
   get invoked when the event is fired. - `java.lang.Class<?>`"
  (^java.lang.Class [^EventSetDescriptor this]
    (-> this (.getListenerType))))

(defn in-default-event-set?
  "Reports if an event set is in the `default` set.

  returns: true if the event set is in
            the `default` set.  Defaults to true. - `boolean`"
  (^Boolean [^EventSetDescriptor this]
    (-> this (.isInDefaultEventSet))))

(defn get-remove-listener-method
  "Gets the method used to remove event listeners.

  returns: The method used to remove a listener at the event source. - `java.lang.reflect.Method`"
  (^java.lang.reflect.Method [^EventSetDescriptor this]
    (-> this (.getRemoveListenerMethod))))

(defn unicast?
  "Normally event sources are multicast.  However there are some
   exceptions that are strictly unicast.

  returns: true if the event set is unicast.
            Defaults to false. - `boolean`"
  (^Boolean [^EventSetDescriptor this]
    (-> this (.isUnicast))))

(defn get-listener-method-descriptors
  "Gets the MethodDescriptors of the target listener interface.

  returns: An array of MethodDescriptor objects for the target methods
   within the target listener interface that will get called when
   events are fired. - `java.beans.MethodDescriptor[]`"
  ([^EventSetDescriptor this]
    (-> this (.getListenerMethodDescriptors))))

(defn get-get-listener-method
  "Gets the method used to access the registered event listeners.

  returns: The method used to access the array of listeners at the event
           source or null if it doesn't exist. - `java.lang.reflect.Method`"
  (^java.lang.reflect.Method [^EventSetDescriptor this]
    (-> this (.getGetListenerMethod))))

