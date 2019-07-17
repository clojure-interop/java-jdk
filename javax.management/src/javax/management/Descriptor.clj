(ns javax.management.Descriptor
  "Additional metadata for a JMX element.  A Descriptor
  is associated with a MBeanInfo, MBeanAttributeInfo, etc.
  It consists of a collection of fields.  A field is a name and an
  associated value.

  Field names are not case-sensitive.  The names descriptorType,
  descriptortype, and DESCRIPTORTYPE are all equivalent.
  However, the case that was used when the field was first set is preserved
  in the result of the getFields() and getFieldNames()
  methods.

  Not all field names and values are predefined.
  New fields can be defined and added by any program.

  A descriptor can be mutable or immutable.
  An immutable descriptor, once created, never changes.
  The Descriptor methods that could modify the contents
  of the descriptor will throw an exception
  for an immutable descriptor.  Immutable descriptors are usually
  instances of ImmutableDescriptor or a subclass.  Mutable
  descriptors are usually instances of
  DescriptorSupport or a subclass.

  Certain fields are used by the JMX implementation.  This means
  either that the presence of the field may change the behavior of
  the JMX API or that the field may be set in descriptors returned by
  the JMX API.  These fields appear in italics in the table
  below, and each one has a corresponding constant in the JMX
  class.  For example, the field defaultValue is represented
  by the constant JMX.DEFAULT_VALUE_FIELD.

  Certain other fields have conventional meanings described in the
  table below but they are not required to be understood or set by
  the JMX implementation.

  Field names defined by the JMX specification in this and all
  future versions will never contain a period (.).  Users can safely
  create their own fields by including a period in the name and be
  sure that these names will not collide with any future version of
  the JMX API.  It is recommended to follow the Java package naming
  convention to avoid collisions between field names from different
  origins.  For example, a field created by example.com might
  have the name com.example.interestLevel.

  Note that the values in the defaultValue, legalValues, maxValue, and minValue fields should
  be consistent with the type returned by the getType()
  method for the associated MBeanAttributeInfo or MBeanParameterInfo.  For MXBeans, this means that they should be
  of the mapped Java type, called opendata(J) in the MXBean type mapping rules.



  NameTypeUsed inMeaning

  defaultValueObject
  MBeanAttributeInfoMBeanParameterInfo

  Default value for an attribute or parameter.  See
  javax.management.openmbean.

  deprecatedStringAny

  An indication that this element of the information model is no
  longer recommended for use.  A set of MBeans defined by an
  application is collectively called an information model.
  The convention is for the value of this field to contain a string
  that is the version of the model in which the element was first
  deprecated, followed by a space, followed by an explanation of the
  deprecation, for example `1.3 Replaced by the Capacity
  attribute`.

  descriptionResource
  BundleBaseNameStringAny

  The base name for the ResourceBundle in which the key given in
  the descriptionResourceKey field can be found, for example
  `com.example.myapp.MBeanResources`.  The meaning of this
  field is defined by this specification but the field is not set or
  used by the JMX API itself.

  descriptionResourceKey
  StringAny

  A resource key for the description of this element.  In
  conjunction with the descriptionResourceBundleBaseName,
  this can be used to find a localized version of the description.
  The meaning of this field is defined by this specification but the
  field is not set or used by the JMX API itself.

  enabledString
  MBeanAttributeInfoMBeanNotificationInfoMBeanOperationInfo

  The string `true` or `false` according as this
  item is enabled.  When an attribute or operation is not enabled, it
  exists but cannot currently be accessed.  A user interface might
  present it as a greyed-out item.  For example, an attribute might
  only be meaningful after the start() method of an MBean has
  been called, and is otherwise disabled.  Likewise, a notification
  might be disabled if it cannot currently be emitted but could be in
  other circumstances.

  exceptionsString[]
  MBeanAttributeInfo, MBeanConstructorInfo, MBeanOperationInfo

  The class names of the exceptions that can be thrown when invoking a
  constructor or operation, or getting an attribute. The meaning of this field
  is defined by this specification but the field is not set or used by the
  JMX API itself. Exceptions thrown when
  setting an attribute are specified by the field
  setExceptions.

  immutableInfoString
  MBeanInfo

  The string `true` or `false` according as this
  MBean's MBeanInfo is immutable.  When this field is true,
  the MBeanInfo for the given MBean is guaranteed not to change over
  the lifetime of the MBean.  Hence, a client can read it once and
  cache the read value.  When this field is false or absent, there is
  no such guarantee, although that does not mean that the MBeanInfo
  will necessarily change.  See also the `jmx.mbean.info.changed`
  notification.

  infoTimeoutStringLongMBeanInfo

  The time in milli-seconds that the MBeanInfo can reasonably be
  expected to be unchanged.  The value can be a Long or a
  decimal string.  This provides a hint from a DynamicMBean or any
  MBean that does not define immutableInfo as true
  that the MBeanInfo is not likely to change within this period and
  therefore can be cached.  When this field is missing or has the
  value zero, it is not recommended to cache the MBeanInfo unless it
  has the immutableInfo set to true or it has `jmx.mbean.info.changed` in
  its MBeanNotificationInfo array.

  interfaceClassName
  StringMBeanInfo

  The Java interface name for a Standard MBean or MXBean, as
  returned by Class.getName().  A Standard MBean or MXBean
  registered directly in the MBean Server or created using the StandardMBean class will have this field in its MBeanInfo
  Descriptor.

  legalValues
  Set<?>MBeanAttributeInfoMBeanParameterInfo

  Legal values for an attribute or parameter.  See
  javax.management.openmbean.

  locale
  StringAny

  The java.util.locale of the description in this
  MBeanInfo, MBeanAttributeInfo, etc, as returned
  by Locale.toString().

  maxValueObject
  MBeanAttributeInfoMBeanParameterInfo

  Maximum legal value for an attribute or parameter.  See
  javax.management.openmbean.

  metricTypeString
  MBeanAttributeInfoMBeanOperationInfo

  The type of a metric, one of the strings `counter` or `gauge`.
  A metric is a measurement exported by an MBean, usually an
  attribute but sometimes the result of an operation.  A metric that
  is a counter has a value that never decreases except by
  being reset to a starting value.  Counter metrics are almost always
  non-negative integers.  An example might be the number of requests
  received.  A metric that is a gauge has a numeric value
  that can increase or decrease.  Examples might be the number of
  open connections or a cache hit rate or a temperature reading.

  minValueObject
  MBeanAttributeInfoMBeanParameterInfo

  Minimum legal value for an attribute or parameter.  See
  javax.management.openmbean.

  mxbeanString
  MBeanInfo

  The string `true` or `false` according as this
  MBean is an MXBean.  A Standard MBean or MXBean registered
  directly with the MBean Server or created using the StandardMBean class will have this field in its MBeanInfo
  Descriptor.

  openTypeOpenType
  MBeanAttributeInfoMBeanOperationInfoMBeanParameterInfo

  The Open Type of this element.  In the case of MBeanAttributeInfo and MBeanParameterInfo, this is the
  Open Type of the attribute or parameter.  In the case of MBeanOperationInfo, it is the Open Type of the return value.  This
  field is set in the Descriptor for all instances of OpenMBeanAttributeInfoSupport, OpenMBeanOperationInfoSupport, and OpenMBeanParameterInfoSupport.  It is also set for attributes,
  operations, and parameters of MXBeans.

  This field can be set for an MBeanNotificationInfo, in
  which case it indicates the Open Type that the user data will have.

  originalTypeString
  MBeanAttributeInfoMBeanOperationInfoMBeanParameterInfo

  The original Java type of this element as it appeared in the
  MXBean interface method that produced this MBeanAttributeInfo (etc).  For example, a method public
   MemoryUsage getHeapMemoryUsage();
  in an MXBean interface defines an attribute called HeapMemoryUsage of type CompositeData.  The originalType field in the Descriptor for this attribute will have
  the value `java.lang.management.MemoryUsage`.

  The format of this string is described in the section Type Names of the MXBean
  specification.

  setExceptionsString[]
  MBeanAttributeInfo

  The class names of the exceptions that can be thrown when setting
  an attribute. The meaning of this field
  is defined by this specification but the field is not set or used by the
  JMX API itself.  Exceptions thrown when getting an attribute are specified
  by the field exceptions.

  severityStringInteger
  MBeanNotificationInfo

  The severity of this notification.  It can be 0 to mean
  unknown severity or a value from 1 to 6 representing decreasing
  levels of severity.  It can be represented as a decimal string or
  an Integer.

  sinceStringAny

  The version of the information model in which this element
  was introduced.  A set of MBeans defined by an application is
  collectively called an information model.  The
  application may also define versions of this model, and use the
  `since` field to record the version in which an element
  first appeared.

  unitsString
  MBeanAttributeInfoMBeanParameterInfoMBeanOperationInfo

  The units in which an attribute, parameter, or operation return
  value is measured, for example `bytes` or `seconds`.



  Some additional fields are defined by Model MBeans.  See the
  information for
  ModelMBeanInfo,

  ModelMBeanAttributeInfo,

  ModelMBeanConstructorInfo,

  ModelMBeanNotificationInfo, and

  ModelMBeanOperationInfo, as
  well as the chapter `Model MBeans` of the JMX
  Specification.  The following table summarizes these fields.  Note
  that when the Type in this table is Number, a String that is the decimal
  representation of a Long can also be used.

  Nothing prevents the use of these fields in MBeans that are not Model
  MBeans.  The displayName,
  severity, and visibility fields are of
  interest outside Model MBeans, for example.  But only Model MBeans have
  a predefined behavior for these fields.



  NameTypeUsed inMeaning

  classStringModelMBeanOperationInfo
      Class where method is defined (fully qualified).

  currencyTimeLimitNumber
      ModelMBeanInfoModelMBeanAttributeInfoModelMBeanOperationInfo
      How long cached value is valid: <0 never, =0 always,
          >0 seconds.

  defaultObjectModelMBeanAttributeInfo
      Default value for attribute.

  descriptorTypeStringAny
      Type of descriptor, `mbean`, `attribute`, `constructor`, `operation`,
          or `notification`.

  displayNameStringAny
      Human readable name of this item.

  exportStringModelMBeanInfo
      Name to be used to export/expose this MBean so that it is
          findable by other JMX Agents.

  getMethodStringModelMBeanAttributeInfo
      Name of operation descriptor for get method.

  lastUpdatedTimeStampNumber
      ModelMBeanAttributeInfoModelMBeanOperationInfo
      When value was set.

  logStringModelMBeanInfoModelMBeanNotificationInfo
      t or T: log all notifications, f or F: log no notifications.

  logFileStringModelMBeanInfoModelMBeanNotificationInfo
      Fully qualified filename to log events to.

  messageIDStringModelMBeanNotificationInfo
      Unique key for message text (to allow translation, analysis).

  messageTextStringModelMBeanNotificationInfo
      Text of notification.

  nameStringAny
      Name of this item.

  persistFileStringModelMBeanInfo
      File name into which the MBean should be persisted.

  persistLocationStringModelMBeanInfo
      The fully qualified directory name where the MBean should be
          persisted (if appropriate).

  persistPeriodNumber
      ModelMBeanInfoModelMBeanAttributeInfo
      Frequency of persist cycle in seconds. Used when persistPolicy is
          `OnTimer` or `NoMoreOftenThan`.

  persistPolicyString
      ModelMBeanInfoModelMBeanAttributeInfo
      One of: OnUpdate|OnTimer|NoMoreOftenThan|OnUnregister|Always|Never.
          See the section `MBean Descriptor Fields` in the JMX specification
          document.

  presentationStringStringAny
      XML formatted string to allow presentation of data.

  protocolMapDescriptorModelMBeanAttributeInfo
      See the section `Protocol Map Support` in the JMX specification
          document.  Mappings must be appropriate for the attribute and entries
          can be updated or augmented at runtime.

  roleString
      ModelMBeanConstructorInfoModelMBeanOperationInfo
      One of `constructor`, `operation`, `getter`, or `setter`.

  setMethodStringModelMBeanAttributeInfo
      Name of operation descriptor for set method.

  severityNumber
      ModelMBeanNotificationInfo
      0-6 where 0: unknown; 1: non-recoverable;
          2: critical, failure; 3: major, severe;
          4: minor, marginal, error; 5: warning;
          6: normal, cleared, informative

  targetObjectObjectModelMBeanOperationInfo
      Object on which to execute this method.

  targetTypeStringModelMBeanOperationInfo
      type of object reference for targetObject. Can be:
          ObjectReference | Handle | EJBHandle | IOR | RMIReference.

  valueObject
      ModelMBeanAttributeInfoModelMBeanOperationInfo
      Current (cached) value for attribute or operation.

  visibilityNumberAny
      1-4 where 1: always visible, 4: rarely visible."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management Descriptor]))

(defn set-fields
  "Sets all fields in the field names array to the new value with
   the same index in the field values array. Array sizes must match.

   The field value will be validated before it is set.
   If it is not valid, then an exception will be thrown.
   If the arrays are empty, then no change will take effect.

  field-names - String array of field names. The array and array elements cannot be null. - `java.lang.String[]`
  field-values - Object array of the corresponding field values. The array cannot be null. Elements of the array can be null. - `java.lang.Object[]`

  throws: javax.management.RuntimeOperationsException - if the change fails for any reason. Wrapped exception is IllegalArgumentException if fieldNames or fieldValues is null, or if the arrays are of different lengths, or if there is an illegal value in one of them. Wrapped exception is UnsupportedOperationException if the descriptor is immutable, and the call would change its contents."
  ([^. this ^java.lang.String[] field-names ^java.lang.Object[] field-values]
    (-> this (.setFields field-names field-values))))

(defn remove-field
  "Removes a field from the descriptor.

  field-name - String name of the field to be removed. If the field name is illegal or the field is not found, no exception is thrown. - `java.lang.String`

  throws: javax.management.RuntimeOperationsException - if a field of the given name exists and the descriptor is immutable. The wrapped exception will be an UnsupportedOperationException."
  ([^. this ^java.lang.String field-name]
    (-> this (.removeField field-name))))

(defn get-field-names
  "Returns all the field names in the descriptor.

  returns: String array of field names. If the descriptor is empty,
   you will get an empty array. - `java.lang.String[]`"
  ([^. this]
    (-> this (.getFieldNames))))

(defn get-field-value
  "Returns the value for a specific field name, or null if no value
   is present for that name.

  field-name - the field name. - `java.lang.String`

  returns: the corresponding value, or null if the field is not present. - `java.lang.Object`

  throws: javax.management.RuntimeOperationsException - if the field name is illegal."
  ([^. this ^java.lang.String field-name]
    (-> this (.getFieldValue field-name))))

(defn get-field-values
  "Returns all the field values in the descriptor as an array of Objects. The
   returned values are in the same order as the fieldNames String array parameter.

  field-names - String array of the names of the fields that the values should be returned for. If the array is empty then an empty array will be returned. If the array is null then all values will be returned, as if the parameter were the array returned by getFieldNames(). If a field name in the array does not exist, including the case where it is null or the empty string, then null is returned for the matching array element being returned. - `java.lang.String`

  returns: Object array of field values. If the list of fieldNames
   is empty, you will get an empty array. - `java.lang.Object[]`"
  ([^. this ^java.lang.String field-names]
    (-> this (.getFieldValues field-names))))

(defn set-field
  "Sets the value for a specific field name. This will
   modify an existing field or add a new field.

   The field value will be validated before it is set.
   If it is not valid, then an exception will be thrown.
   The meaning of validity is dependent on the descriptor
   implementation.

  field-name - The field name to be set. Cannot be null or empty. - `java.lang.String`
  field-value - The field value to be set for the field name. Can be null if that is a valid value for the field. - `java.lang.Object`

  throws: javax.management.RuntimeOperationsException - if the field name or field value is illegal (wrapped exception is IllegalArgumentException); or if the descriptor is immutable (wrapped exception is UnsupportedOperationException)."
  ([^. this ^java.lang.String field-name ^java.lang.Object field-value]
    (-> this (.setField field-name field-value))))

(defn valid?
  "Returns true if all of the fields have legal values given their
   names.

  returns: true if the values are legal. - `boolean`

  throws: javax.management.RuntimeOperationsException - If the validity checking fails for any reason, this exception will be thrown. The method returns false if the descriptor is not valid, but throws this exception if the attempt to determine validity fails."
  ([^. this]
    (-> this (.isValid))))

(defn clone
  "Returns a descriptor which is equal to this descriptor.
   Changes to the returned descriptor will have no effect on this
   descriptor, and vice versa.  If this descriptor is immutable,
   it may fulfill this condition by returning itself.

  returns: A descriptor which is equal to this descriptor. - `java.lang.Object`

  throws: javax.management.RuntimeOperationsException - for illegal value for field names or field values. If the descriptor construction fails for any reason, this exception will be thrown."
  ([^. this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code value for this descriptor.  The hash
   code is computed as the sum of the hash codes for each field in
   the descriptor.  The hash code of a field with name n
   and value v is n.toLowerCase().hashCode() ^ h.
   Here h is the hash code of v, computed as
   follows:


   If v is null then h is 0.
   If v is a primitive array then h is computed using
   the appropriate overloading of java.util.Arrays.hashCode.
   If v is an object array then h is computed using
   Arrays.deepHashCode(Object[]).
   Otherwise h is v.hashCode().

  returns: A hash code value for this object. - `int`"
  ([^. this]
    (-> this (.hashCode))))

(defn get-fields
  "Returns all of the fields contained in this descriptor as a string array.

  returns: String array of fields in the format fieldName=fieldValue
   If the value of a field is not a String, then the toString() method
   will be called on it and the returned value, enclosed in parentheses,
   used as the value for the field in the returned array. If the value
   of a field is null, then the value of the field in the returned array
   will be empty.  If the descriptor is empty, you will get
   an empty array. - `java.lang.String[]`"
  ([^. this]
    (-> this (.getFields))))

(defn equals
  "Compares this descriptor to the given object.  The objects are equal if
   the given object is also a Descriptor, and if the two Descriptors have
   the same field names (possibly differing in case) and the same
   associated values.  The respective values for a field in the two
   Descriptors are equal if the following conditions hold:


   If one value is null then the other must be too.
   If one value is a primitive array then the other must be a primitive
   array of the same type with the same elements.
   If one value is an object array then the other must be too and
   Arrays.deepEquals(Object[],Object[]) must return true.
   Otherwise Object.equals(Object) must return true.

  obj - the object to compare with. - `java.lang.Object`

  returns: true if the objects are the same; false
   otherwise. - `boolean`"
  ([^. this ^java.lang.Object obj]
    (-> this (.equals obj))))

