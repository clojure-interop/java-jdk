(ns jdk.beans.beancontext.BeanContext
  " The BeanContext acts a logical hierarchical container for JavaBeans."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContext]))

(defn instantiate-child
  "Instantiate the javaBean named as a
   child of this BeanContext.
   The implementation of the JavaBean is
   derived from the value of the beanName parameter,
   and is defined by the
   java.beans.Beans.instantiate() method.

  bean-name - The name of the JavaBean to instantiate as a child of this BeanContext - `java.lang.String`

  returns: a javaBean named as a child of this
   BeanContext - `java.lang.Object`

  throws: java.io.IOException - if an IO problem occurs"
  ([^. this ^java.lang.String bean-name]
    (-> this (.instantiateChild bean-name))))

(defn get-resource-as-stream
  "Analagous to java.lang.ClassLoader.getResourceAsStream(),
   this method allows a BeanContext implementation
   to interpose behavior between the child Component
   and underlying ClassLoader.

  name - the resource name - `java.lang.String`
  bcc - the specified child - `java.beans.beancontext.BeanContextChild`

  returns: an InputStream for reading the resource,
   or null if the resource could not
   be found. - `java.io.InputStream`

  throws: java.lang.IllegalArgumentException - if the resource is not valid"
  ([^. this ^java.lang.String name ^java.beans.beancontext.BeanContextChild bcc]
    (-> this (.getResourceAsStream name bcc))))

(defn get-resource
  "Analagous to java.lang.ClassLoader.getResource(), this
   method allows a BeanContext implementation to interpose
   behavior between the child Component
   and underlying ClassLoader.

  name - the resource name - `java.lang.String`
  bcc - the specified child - `java.beans.beancontext.BeanContextChild`

  returns: a URL for the named
   resource for the specified child - `java.net.URL`

  throws: java.lang.IllegalArgumentException - if the resource is not valid"
  ([^. this ^java.lang.String name ^java.beans.beancontext.BeanContextChild bcc]
    (-> this (.getResource name bcc))))

(defn add-bean-context-membership-listener
  "Adds the specified BeanContextMembershipListener
   to receive BeanContextMembershipEvents from
   this BeanContext whenever it adds
   or removes a child Component(s).

  bcml - the BeanContextMembershipListener to be added - `java.beans.beancontext.BeanContextMembershipListener`"
  ([^. this ^java.beans.beancontext.BeanContextMembershipListener bcml]
    (-> this (.addBeanContextMembershipListener bcml))))

(defn remove-bean-context-membership-listener
  "Removes the specified BeanContextMembershipListener
   so that it no longer receives BeanContextMembershipEvents
   when the child Component(s) are added or removed.

  bcml - the BeanContextMembershipListener to be removed - `java.beans.beancontext.BeanContextMembershipListener`"
  ([^. this ^java.beans.beancontext.BeanContextMembershipListener bcml]
    (-> this (.removeBeanContextMembershipListener bcml))))

