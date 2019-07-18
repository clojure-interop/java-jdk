(ns javax.management.modelmbean.ModelMBeanOperationInfo
  "The ModelMBeanOperationInfo object describes a management operation of
  the ModelMBean.  It is a subclass of MBeanOperationInfo with the addition
  of an associated Descriptor and an implementation of the DescriptorAccess
  interface.


  The fields in the descriptor are defined, but not limited to, the following.
  Note that when the Type in this table is Number, a String that is the decimal
  representation of a Long can also be used.


  NameTypeMeaning
  nameString
      Operation name.
  descriptorTypeString
      Must be `operation`.
  classString
      Class where method is defined (fully qualified).
  roleString
      Must be `operation`, `getter`, or `setter`.
  targetObjectObject
      Object on which to execute this method.
  targetTypeString
      type of object reference for targetObject. Can be:
          ObjectReference | Handle | EJBHandle | IOR | RMIReference.
  valueObject
      Cached value for operation.
  displayNameString
      Human readable display name of the operation.
  currencyTimeLimitNumber
      How long cached value is valid.
  lastUpdatedTimeStampNumber
      When cached value was set.
  visibilityNumber
      1-4 where 1: always visible 4: rarely visible.
  presentationStringString
      XML formatted string to describe how to present operation


  The default descriptor will have name, descriptorType, displayName and
  role fields set.  The default value of the name and displayName fields is
  the operation name.

  Note: because of inconsistencies in previous versions of
  this specification, it is recommended not to use negative or zero
  values for currencyTimeLimit.  To indicate that a
  cached value is never valid, omit the
  currencyTimeLimit field.  To indicate that it is
  always valid, use a very large number for this field.

  The serialVersionUID of this class is 6532732096650090465L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.modelmbean ModelMBeanOperationInfo]))

(defn ->model-m-bean-operation-info
  "Constructor.

  Constructs a ModelMBeanOperationInfo object.

  name - The name of the method. - `java.lang.String`
  description - A human readable description of the operation. - `java.lang.String`
  signature - MBeanParameterInfo objects describing the parameters(arguments) of the method. - `javax.management.MBeanParameterInfo[]`
  type - The type of the method's return value. - `java.lang.String`
  impact - The impact of the method, one of INFO, ACTION, ACTION_INFO, UNKNOWN. - `int`
  descriptor - An instance of Descriptor containing the appropriate metadata for this instance of the MBeanOperationInfo. If it is null then a default descriptor will be created. If the descriptor does not contain fields `displayName` or `role`, the missing ones are added with their default values. - `javax.management.Descriptor`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException. The descriptor is invalid; or descriptor field `name` is not equal to operation name; or descriptor field `DescriptorType` is not equal to `operation`; or descriptor optional field `role` is present but not equal to `operation`, `getter`, or `setter`."
  (^ModelMBeanOperationInfo [^java.lang.String name ^java.lang.String description signature ^java.lang.String type ^Integer impact ^javax.management.Descriptor descriptor]
    (new ModelMBeanOperationInfo name description signature type impact descriptor))
  (^ModelMBeanOperationInfo [^java.lang.String name ^java.lang.String description signature ^java.lang.String type ^Integer impact]
    (new ModelMBeanOperationInfo name description signature type impact))
  (^ModelMBeanOperationInfo [^java.lang.String description ^java.lang.reflect.Method operation-method ^javax.management.Descriptor descriptor]
    (new ModelMBeanOperationInfo description operation-method descriptor))
  (^ModelMBeanOperationInfo [^java.lang.String description ^java.lang.reflect.Method operation-method]
    (new ModelMBeanOperationInfo description operation-method))
  (^ModelMBeanOperationInfo [^javax.management.modelmbean.ModelMBeanOperationInfo in-info]
    (new ModelMBeanOperationInfo in-info)))

(defn clone
  "Creates and returns a new ModelMBeanOperationInfo which is a
   duplicate of this ModelMBeanOperationInfo.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^ModelMBeanOperationInfo this]
    (-> this (.clone))))

(defn get-descriptor
  "Returns a copy of the associated Descriptor of the
   ModelMBeanOperationInfo.

  returns: Descriptor associated with the
   ModelMBeanOperationInfo object. - `javax.management.Descriptor`"
  (^javax.management.Descriptor [^ModelMBeanOperationInfo this]
    (-> this (.getDescriptor))))

(defn set-descriptor
  "Sets associated Descriptor (full replace) for the
   ModelMBeanOperationInfo If the new Descriptor is null, then
   the associated Descriptor reverts to a default descriptor.
   The Descriptor is validated before it is assigned.  If the
   new Descriptor is invalid, then a
   RuntimeOperationsException wrapping an
   IllegalArgumentException is thrown.

  in-descriptor - replaces the Descriptor associated with the ModelMBeanOperation. - `javax.management.Descriptor`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException for invalid Descriptor."
  ([^ModelMBeanOperationInfo this ^javax.management.Descriptor in-descriptor]
    (-> this (.setDescriptor in-descriptor))))

(defn to-string
  "Returns a string containing the entire contents of the
   ModelMBeanOperationInfo in human readable form.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^ModelMBeanOperationInfo this]
    (-> this (.toString))))

