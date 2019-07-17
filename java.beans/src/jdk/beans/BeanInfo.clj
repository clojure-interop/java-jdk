(ns jdk.beans.BeanInfo
  "Use the BeanInfo interface
  to create a BeanInfo class
  and provide explicit information about the methods,
  properties, events, and other features of your beans.

  When developing your bean, you can implement
  the bean features required for your application task
  omitting the rest of the BeanInfo features.
  They will be obtained through the automatic analysis
  by using the low-level reflection of the bean methods
  and applying standard design patterns.
  You have an opportunity to provide additional bean information
  through various descriptor classes.

  See the SimpleBeanInfo class that is
  a convenient basic class for BeanInfo classes.
  You can override the methods and properties of
  the SimpleBeanInfo class to define specific information.

  See also the Introspector class to learn more about bean behavior."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans BeanInfo]))

(defn get-bean-descriptor
  "Returns the bean descriptor
   that provides overall information about the bean,
   such as its display name or its customizer.

  returns: a BeanDescriptor object,
            or null if the information is to
            be obtained through the automatic analysis - `java.beans.BeanDescriptor`"
  ([this]
    (-> this (.getBeanDescriptor))))

(defn get-event-set-descriptors
  "Returns the event descriptors of the bean
   that define the types of events fired by this bean.

  returns: an array of EventSetDescriptor objects,
            or null if the information is to
            be obtained through the automatic analysis - `java.beans.EventSetDescriptor[]`"
  ([this]
    (-> this (.getEventSetDescriptors))))

(defn get-default-event-index
  "A bean may have a default event typically applied when this bean is used.

  returns: index of the default event in the EventSetDescriptor array
            returned by the getEventSetDescriptors method,
            or -1 if there is no default event - `int`"
  ([this]
    (-> this (.getDefaultEventIndex))))

(defn get-property-descriptors
  "Returns descriptors for all properties of the bean.

   If a property is indexed, then its entry in the result array
   belongs to the IndexedPropertyDescriptor subclass
   of the PropertyDescriptor class.
   A client of the getPropertyDescriptors method
   can use the instanceof operator to check
   whether a given PropertyDescriptor
   is an IndexedPropertyDescriptor.

  returns: an array of PropertyDescriptor objects,
            or null if the information is to
            be obtained through the automatic analysis - `java.beans.PropertyDescriptor[]`"
  ([this]
    (-> this (.getPropertyDescriptors))))

(defn get-default-property-index
  "A bean may have a default property commonly updated when this bean is customized.

  returns: index of the default property in the PropertyDescriptor array
            returned by the getPropertyDescriptors method,
            or -1 if there is no default property - `int`"
  ([this]
    (-> this (.getDefaultPropertyIndex))))

(defn get-method-descriptors
  "Returns the method descriptors of the bean
   that define the externally visible methods supported by this bean.

  returns: an array of MethodDescriptor objects,
            or null if the information is to
            be obtained through the automatic analysis - `java.beans.MethodDescriptor[]`"
  ([this]
    (-> this (.getMethodDescriptors))))

(defn get-additional-bean-info
  "This method enables the current BeanInfo object
   to return an arbitrary collection of other BeanInfo objects
   that provide additional information about the current bean.

   If there are conflicts or overlaps between the information
   provided by different BeanInfo objects,
   the current BeanInfo object takes priority
   over the additional BeanInfo objects.
   Array elements with higher indices take priority
   over the elements with lower indices.

  returns: an array of BeanInfo objects,
            or null if there are no additional BeanInfo objects - `java.beans.BeanInfo[]`"
  ([this]
    (-> this (.getAdditionalBeanInfo))))

(defn get-icon
  "Returns an image that can be used to represent the bean in toolboxes or toolbars.

   There are four possible types of icons:
   16 x 16 color, 32 x 32 color, 16 x 16 mono, and 32 x 32 mono.
   If you implement a bean so that it supports a single icon,
   it is recommended to use 16 x 16 color.
   Another recommendation is to set a transparent background for the icons.

  icon-kind - the kind of icon requested - `int`

  returns: an image object representing the requested icon,
                     or null if no suitable icon is available - `java.awt.Image`"
  ([this icon-kind]
    (-> this (.getIcon icon-kind))))

