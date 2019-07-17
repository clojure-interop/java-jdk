(ns jdk.beans.BeanDescriptor
  "A BeanDescriptor provides global information about a `bean`,
  including its Java class, its displayName, etc.

  This is one of the kinds of descriptor returned by a BeanInfo object,
  which also returns descriptors for properties, method, and events."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans BeanDescriptor]))

(defn ->bean-descriptor
  "Constructor.

  Create a BeanDescriptor for a bean that has a customizer.

  bean-class - The Class object of the Java class that implements the bean. For example sun.beans.OurButton.class. - `java.lang.Class<?>`
  customizer-class - The Class object of the Java class that implements the bean's Customizer. For example sun.beans.OurButtonCustomizer.class. - `java.lang.Class<?>`"
  ([bean-class customizer-class]
    (new BeanDescriptor bean-class customizer-class))
  ([bean-class]
    (new BeanDescriptor bean-class)))

(defn get-bean-class
  "Gets the bean's Class object.

  returns: The Class object for the bean. - `java.lang.Class<?>`"
  ([this]
    (-> this (.getBeanClass))))

(defn get-customizer-class
  "Gets the Class object for the bean's customizer.

  returns: The Class object for the bean's customizer.  This may
   be null if the bean doesn't have a customizer. - `java.lang.Class<?>`"
  ([this]
    (-> this (.getCustomizerClass))))

