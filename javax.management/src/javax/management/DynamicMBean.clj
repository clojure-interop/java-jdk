(ns javax.management.DynamicMBean
  "Defines the methods that should be implemented by
  a Dynamic MBean (MBean that exposes a dynamic management interface)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management DynamicMBean]))

(defn get-attribute
  "Obtain the value of a specific attribute of the Dynamic MBean.

  attribute - The name of the attribute to be retrieved - `java.lang.String`

  returns: The value of the attribute retrieved. - `java.lang.Object`

  throws: javax.management.AttributeNotFoundException"
  ([this attribute]
    (-> this (.getAttribute attribute))))

(defn set-attribute
  "Set the value of a specific attribute of the Dynamic MBean.

  attribute - The identification of the attribute to be set and the value it is to be set to. - `javax.management.Attribute`

  throws: javax.management.AttributeNotFoundException"
  ([this attribute]
    (-> this (.setAttribute attribute))))

(defn get-attributes
  "Get the values of several attributes of the Dynamic MBean.

  attributes - A list of the attributes to be retrieved. - `java.lang.String[]`

  returns: The list of attributes retrieved. - `javax.management.AttributeList`"
  ([this attributes]
    (-> this (.getAttributes attributes))))

(defn set-attributes
  "Sets the values of several attributes of the Dynamic MBean.

  attributes - A list of attributes: The identification of the attributes to be set and the values they are to be set to. - `javax.management.AttributeList`

  returns: The list of attributes that were set, with their new values. - `javax.management.AttributeList`"
  ([this attributes]
    (-> this (.setAttributes attributes))))

(defn invoke
  "Allows an action to be invoked on the Dynamic MBean.

  action-name - The name of the action to be invoked. - `java.lang.String`
  params - An array containing the parameters to be set when the action is invoked. - `java.lang.Object[]`
  signature - An array containing the signature of the action. The class objects will be loaded through the same class loader as the one used for loading the MBean on which the action is invoked. - `java.lang.String[]`

  returns: The object returned by the action, which represents the result of
   invoking the action on the MBean specified. - `java.lang.Object`

  throws: javax.management.MBeanException - Wraps a java.lang.Exception thrown by the MBean's invoked method."
  ([this action-name params signature]
    (-> this (.invoke action-name params signature))))

(defn get-m-bean-info
  "Provides the exposed attributes and actions of the Dynamic MBean using an MBeanInfo object.

  returns: An instance of MBeanInfo allowing all attributes and actions
   exposed by this Dynamic MBean to be retrieved. - `javax.management.MBeanInfo`"
  ([this]
    (-> this (.getMBeanInfo))))

