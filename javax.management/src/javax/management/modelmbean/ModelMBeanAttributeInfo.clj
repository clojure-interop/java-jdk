(ns javax.management.modelmbean.ModelMBeanAttributeInfo
  "The ModelMBeanAttributeInfo object describes an attribute of the ModelMBean.
  It is a subclass of MBeanAttributeInfo with the addition of an associated Descriptor
  and an implementation of the DescriptorAccess interface.


  The fields in the descriptor are defined, but not limited to, the following.
  Note that when the Type in this table is Number, a String that is the decimal
  representation of a Long can also be used.


  NameTypeMeaning
  nameString
      Attribute name.
  descriptorTypeString
      Must be `attribute`.
  valueObject
      Current (cached) value for attribute.
  defaultObject
      Default value for attribute.
  displayNameString
      Name of attribute to be used in displays.
  getMethodString
      Name of operation descriptor for get method.
  setMethodString
      Name of operation descriptor for set method.
  protocolMapDescriptor
      See the section `Protocol Map Support` in the JMX specification
          document.  Mappings must be appropriate for the attribute and entries
          can be updated or augmented at runtime.
  persistPolicyString
      One of: OnUpdate|OnTimer|NoMoreOftenThan|OnUnregister|Always|Never.
          See the section `MBean Descriptor Fields` in the JMX specification
          document.
  persistPeriodNumber
      Frequency of persist cycle in seconds. Used when persistPolicy is
          `OnTimer` or `NoMoreOftenThan`.
  currencyTimeLimitNumber
      How long value is valid: <0 never,
          =0 always, >0 seconds.
  lastUpdatedTimeStampNumber
      When value was set.
  visibilityNumber
      1-4 where 1: always visible, 4: rarely visible.
  presentationStringString
      XML formatted string to allow presentation of data.


  The default descriptor contains the name, descriptorType and displayName
  fields.  The default value of the name and displayName fields is the name of
  the attribute.

  Note: because of inconsistencies in previous versions of
  this specification, it is recommended not to use negative or zero
  values for currencyTimeLimit.  To indicate that a
  cached value is never valid, omit the
  currencyTimeLimit field.  To indicate that it is
  always valid, use a very large number for this field.

  The serialVersionUID of this class is 6181543027787327345L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.modelmbean ModelMBeanAttributeInfo]))

(defn ->model-m-bean-attribute-info
  "Constructor.

  Constructs a ModelMBeanAttributeInfo object.

  name - The name of the attribute - `java.lang.String`
  type - The type or class name of the attribute - `java.lang.String`
  description - A human readable description of the attribute. - `java.lang.String`
  is-readable - True if the attribute has a getter method, false otherwise. - `boolean`
  is-writable - True if the attribute has a setter method, false otherwise. - `boolean`
  is-is - True if the attribute has an `is` getter, false otherwise. - `boolean`
  descriptor - An instance of Descriptor containing the appropriate metadata for this instance of the Attribute. If it is null then a default descriptor will be created. If the descriptor does not contain the field `displayName` this field is added in the descriptor with its default value. - `javax.management.Descriptor`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException. The descriptor is invalid, or descriptor field `name` is not equal to name parameter, or descriptor field `descriptorType` is not equal to `attribute`."
  ([^java.lang.String name ^java.lang.String type ^java.lang.String description ^Boolean is-readable ^Boolean is-writable ^Boolean is-is ^javax.management.Descriptor descriptor]
    (new ModelMBeanAttributeInfo name type description is-readable is-writable is-is descriptor))
  ([^java.lang.String name ^java.lang.String type ^java.lang.String description ^Boolean is-readable ^Boolean is-writable ^Boolean is-is]
    (new ModelMBeanAttributeInfo name type description is-readable is-writable is-is))
  ([^java.lang.String name ^java.lang.String description ^java.lang.reflect.Method getter ^java.lang.reflect.Method setter ^javax.management.Descriptor descriptor]
    (new ModelMBeanAttributeInfo name description getter setter descriptor))
  ([^java.lang.String name ^java.lang.String description ^java.lang.reflect.Method getter ^java.lang.reflect.Method setter]
    (new ModelMBeanAttributeInfo name description getter setter))
  ([^javax.management.modelmbean.ModelMBeanAttributeInfo in-info]
    (new ModelMBeanAttributeInfo in-info)))

(defn get-descriptor
  "Gets a copy of the associated Descriptor for the
   ModelMBeanAttributeInfo.

  returns: Descriptor associated with the
   ModelMBeanAttributeInfo object. - `javax.management.Descriptor`"
  ([^javax.management.modelmbean.ModelMBeanAttributeInfo this]
    (-> this (.getDescriptor))))

(defn set-descriptor
  "Sets associated Descriptor (full replace) for the
   ModelMBeanAttributeDescriptor.  If the new Descriptor is
   null, then the associated Descriptor reverts to a default
   descriptor.  The Descriptor is validated before it is
   assigned.  If the new Descriptor is invalid, then a
   RuntimeOperationsException wrapping an
   IllegalArgumentException is thrown.

  in-descriptor - replaces the Descriptor associated with the ModelMBeanAttributeInfo - `javax.management.Descriptor`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException for an invalid Descriptor"
  ([^javax.management.modelmbean.ModelMBeanAttributeInfo this ^javax.management.Descriptor in-descriptor]
    (-> this (.setDescriptor in-descriptor))))

(defn clone
  "Creates and returns a new ModelMBeanAttributeInfo which is a duplicate of this ModelMBeanAttributeInfo.

  returns: a clone of this instance. - `java.lang.Object`

  throws: javax.management.RuntimeOperationsException - for illegal value for field Names or field Values. If the descriptor construction fails for any reason, this exception will be thrown."
  ([^javax.management.modelmbean.ModelMBeanAttributeInfo this]
    (-> this (.clone))))

(defn to-string
  "Returns a human-readable version of the
   ModelMBeanAttributeInfo instance.

  returns: a string representation of the object. - `java.lang.String`"
  ([^javax.management.modelmbean.ModelMBeanAttributeInfo this]
    (-> this (.toString))))

