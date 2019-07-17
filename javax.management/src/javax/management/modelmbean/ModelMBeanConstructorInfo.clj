(ns javax.management.modelmbean.ModelMBeanConstructorInfo
  "The ModelMBeanConstructorInfo object describes a constructor of the ModelMBean.
  It is a subclass of MBeanConstructorInfo with the addition of an associated Descriptor
  and an implementation of the DescriptorAccess interface.


  The fields in the descriptor are defined, but not limited to, the following.
  Note that when the Type in this table is Number, a String that is the decimal
  representation of a Long can also be used.


  NameTypeMeaning
  nameString
      Constructor name.
  descriptorTypeString
      Must be `operation`.
  roleString
      Must be `constructor`.
  displayNameString
      Human readable name of constructor.
  visibilityNumber
      1-4 where 1: always visible 4: rarely visible.
  presentationStringString
      XML formatted string to describe how to present operation


  The persistPolicy and currencyTimeLimit fields
  are meaningless for constructors, but are not considered invalid.

  The default descriptor will have the name, descriptorType, displayName and role fields.

  The serialVersionUID of this class is 3862947819818064362L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.modelmbean ModelMBeanConstructorInfo]))

(defn ->model-m-bean-constructor-info
  "Constructor.

  Constructs a ModelMBeanConstructorInfo object.

  name - The name of the constructor. - `java.lang.String`
  description - A human readable description of the constructor. - `java.lang.String`
  signature - MBeanParameterInfo objects describing the parameters(arguments) of the constructor. - `javax.management.MBeanParameterInfo[]`
  descriptor - An instance of Descriptor containing the appropriate metadata for this instance of the MBeanConstructorInfo. If it is null then a default descriptor will be created. If the descriptor does not contain the field `displayName` this field is added in the descriptor with its default value. - `javax.management.Descriptor`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException. The descriptor is invalid, or descriptor field `name` is not equal to name parameter, or descriptor field `descriptorType` is not equal to `operation` or descriptor field `role` is present but not equal to `constructor`."
  ([^java.lang.String name ^java.lang.String description signature ^javax.management.Descriptor descriptor]
    (new ModelMBeanConstructorInfo name description signature descriptor))
  ([^java.lang.String description ^java.lang.reflect.Constructor constructor-method ^javax.management.Descriptor descriptor]
    (new ModelMBeanConstructorInfo description constructor-method descriptor))
  ([^java.lang.String description ^java.lang.reflect.Constructor constructor-method]
    (new ModelMBeanConstructorInfo description constructor-method)))

(defn clone
  "Creates and returns a new ModelMBeanConstructorInfo which is a duplicate of this ModelMBeanConstructorInfo.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^javax.management.modelmbean.ModelMBeanConstructorInfo this]
    (-> this (.clone))))

(defn get-descriptor
  "Returns a copy of the associated Descriptor.

  returns: Descriptor associated with the
   ModelMBeanConstructorInfo object. - `javax.management.Descriptor`"
  (^javax.management.Descriptor [^javax.management.modelmbean.ModelMBeanConstructorInfo this]
    (-> this (.getDescriptor))))

(defn set-descriptor
  "Sets associated Descriptor (full replace) of
   ModelMBeanConstructorInfo.  If the new Descriptor is null,
   then the associated Descriptor reverts to a default
   descriptor.  The Descriptor is validated before it is
   assigned.  If the new Descriptor is invalid, then a
   RuntimeOperationsException wrapping an
   IllegalArgumentException is thrown.

  in-descriptor - replaces the Descriptor associated with the ModelMBeanConstructor. If the descriptor does not contain all the following fields, the missing ones are added with their default values: displayName, name, role, descriptorType. - `javax.management.Descriptor`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException. The descriptor is invalid, or descriptor field `name` is present but not equal to name parameter, or descriptor field `descriptorType` is present but not equal to `operation` or descriptor field `role` is present but not equal to `constructor`."
  ([^javax.management.modelmbean.ModelMBeanConstructorInfo this ^javax.management.Descriptor in-descriptor]
    (-> this (.setDescriptor in-descriptor))))

(defn to-string
  "Returns a string containing the entire contents of the ModelMBeanConstructorInfo in human readable form.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^javax.management.modelmbean.ModelMBeanConstructorInfo this]
    (-> this (.toString))))

