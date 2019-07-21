(ns jdk.beans.SimpleBeanInfo
  "This is a support class to make it easier for people to provide
  BeanInfo classes.

  It defaults to providing \"noop\" information, and can be selectively
  overriden to provide more explicit information on chosen topics.
  When the introspector sees the \"noop\" values, it will apply low
  level introspection and design patterns to automatically analyze
  the target bean."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans SimpleBeanInfo]))

(defn ->simple-bean-info
  "Constructor."
  (^SimpleBeanInfo []
    (new SimpleBeanInfo )))

(defn get-bean-descriptor
  "Deny knowledge about the class and customizer of the bean.
   You can override this if you wish to provide explicit info.

  returns: a BeanDescriptor object,
            or null if the information is to
            be obtained through the automatic analysis - `java.beans.BeanDescriptor`"
  (^java.beans.BeanDescriptor [^SimpleBeanInfo this]
    (-> this (.getBeanDescriptor))))

(defn get-property-descriptors
  "Deny knowledge of properties. You can override this
   if you wish to provide explicit property info.

  returns: an array of PropertyDescriptor objects,
            or null if the information is to
            be obtained through the automatic analysis - `java.beans.PropertyDescriptor[]`"
  ([^SimpleBeanInfo this]
    (-> this (.getPropertyDescriptors))))

(defn get-default-property-index
  "Deny knowledge of a default property. You can override this
   if you wish to define a default property for the bean.

  returns: index of the default property in the PropertyDescriptor array
            returned by the getPropertyDescriptors method,
            or -1 if there is no default property - `int`"
  (^Integer [^SimpleBeanInfo this]
    (-> this (.getDefaultPropertyIndex))))

(defn get-event-set-descriptors
  "Deny knowledge of event sets. You can override this
   if you wish to provide explicit event set info.

  returns: an array of EventSetDescriptor objects,
            or null if the information is to
            be obtained through the automatic analysis - `java.beans.EventSetDescriptor[]`"
  ([^SimpleBeanInfo this]
    (-> this (.getEventSetDescriptors))))

(defn get-icon
  "Claim there are no icons available.  You can override
   this if you want to provide icons for your bean.

  icon-kind - the kind of icon requested - `int`

  returns: an image object representing the requested icon,
                     or null if no suitable icon is available - `java.awt.Image`"
  (^java.awt.Image [^SimpleBeanInfo this ^Integer icon-kind]
    (-> this (.getIcon icon-kind))))

(defn get-additional-bean-info
  "Claim there are no other relevant BeanInfo objects.  You
   may override this if you want to (for example) return a
   BeanInfo for a base class.

  returns: an array of BeanInfo objects,
            or null if there are no additional BeanInfo objects - `java.beans.BeanInfo[]`"
  ([^SimpleBeanInfo this]
    (-> this (.getAdditionalBeanInfo))))

(defn load-image
  "This is a utility method to help in loading icon images.
   It takes the name of a resource file associated with the
   current object's class file and loads an image object
   from that file.  Typically images will be GIFs.

  resource-name - A pathname relative to the directory holding the class file of the current class. For example, \"wombat.gif\". - `java.lang.String`

  returns: an image object.  May be null if the load failed. - `java.awt.Image`"
  (^java.awt.Image [^SimpleBeanInfo this ^java.lang.String resource-name]
    (-> this (.loadImage resource-name))))

(defn get-default-event-index
  "Deny knowledge of a default event. You can override this
   if you wish to define a default event for the bean.

  returns: index of the default event in the EventSetDescriptor array
            returned by the getEventSetDescriptors method,
            or -1 if there is no default event - `int`"
  (^Integer [^SimpleBeanInfo this]
    (-> this (.getDefaultEventIndex))))

(defn get-method-descriptors
  "Deny knowledge of methods. You can override this
   if you wish to provide explicit method info.

  returns: an array of MethodDescriptor objects,
            or null if the information is to
            be obtained through the automatic analysis - `java.beans.MethodDescriptor[]`"
  ([^SimpleBeanInfo this]
    (-> this (.getMethodDescriptors))))

