(ns javax.management.modelmbean.DescriptorSupport
  "This class represents the metadata set for a ModelMBean element.  A
  descriptor is part of the ModelMBeanInfo,
  ModelMBeanNotificationInfo, ModelMBeanAttributeInfo,
  ModelMBeanConstructorInfo, and ModelMBeanParameterInfo.

  A descriptor consists of a collection of fields.  Each field is in
  fieldname=fieldvalue format.  Field names are not case sensitive,
  case will be preserved on field values.

  All field names and values are not predefined. New fields can be
  defined and added by any program.  Some fields have been predefined
  for consistency of implementation and support by the
  ModelMBeanInfo, ModelMBeanAttributeInfo, ModelMBeanConstructorInfo,
  ModelMBeanNotificationInfo, ModelMBeanOperationInfo and ModelMBean
  classes.

  The serialVersionUID of this class is -6292969195866300415L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.modelmbean DescriptorSupport]))

(defn ->descriptor-support
  "Constructor.

  Constructor taking field names and field values.  Neither array
   can be null.

  field-names - String array of field names. No elements of this array can be null. - `java.lang.String[]`
  field-values - Object array of the corresponding field values. Elements of the array can be null. The fieldValue must be valid for the fieldName (as defined in method isValid) Note: array sizes of parameters should match. If both arrays are empty, then an empty descriptor is created. - `java.lang.Object[]`

  throws: javax.management.RuntimeOperationsException - for illegal value for field Names or field Values. The array lengths must be equal. If the descriptor construction fails for any reason, this exception will be thrown."
  (^DescriptorSupport [field-names field-values]
    (new DescriptorSupport field-names field-values))
  (^DescriptorSupport [^Integer init-num-fields]
    (new DescriptorSupport init-num-fields))
  (^DescriptorSupport []
    (new DescriptorSupport )))

(defn set-fields
  "Description copied from interface: Descriptor

  field-names - String array of field names. The array and array elements cannot be null. - `java.lang.String[]`
  field-values - Object array of the corresponding field values. The array cannot be null. Elements of the array can be null. - `java.lang.Object[]`

  throws: javax.management.RuntimeOperationsException - if the change fails for any reason. Wrapped exception is IllegalArgumentException if fieldNames or fieldValues is null, or if the arrays are of different lengths, or if there is an illegal value in one of them. Wrapped exception is UnsupportedOperationException if the descriptor is immutable, and the call would change its contents."
  ([^DescriptorSupport this field-names field-values]
    (-> this (.setFields field-names field-values))))

(defn remove-field
  "Description copied from interface: Descriptor

  field-name - String name of the field to be removed. If the field name is illegal or the field is not found, no exception is thrown. - `java.lang.String`"
  ([^DescriptorSupport this ^java.lang.String field-name]
    (-> this (.removeField field-name))))

(defn get-field-names
  "Description copied from interface: Descriptor

  returns: String array of field names. If the descriptor is empty,
   you will get an empty array. - `java.lang.String[]`"
  ([^DescriptorSupport this]
    (-> this (.getFieldNames))))

(defn to-string
  "Returns a human readable string representing the
   descriptor.  The string will be in the format of
   \"fieldName=fieldValue,fieldName2=fieldValue2,...\"

   If there are no fields in the descriptor, then an empty String
   is returned.

   If a fieldValue is an object then the toString() method is
   called on it and its returned value is used as the value for
   the field enclosed in parenthesis.

  returns: a string representation of the object. - `java.lang.String`

  throws: javax.management.RuntimeOperationsException - for illegal value for field Names or field Values. If the descriptor string fails for any reason, this exception will be thrown."
  (^java.lang.String [^DescriptorSupport this]
    (-> this (.toString))))

(defn get-field-value
  "Description copied from interface: Descriptor

  field-name - the field name. - `java.lang.String`

  returns: the corresponding value, or null if the field is not present. - `java.lang.Object`

  throws: javax.management.RuntimeOperationsException - if the field name is illegal."
  (^java.lang.Object [^DescriptorSupport this ^java.lang.String field-name]
    (-> this (.getFieldValue field-name))))

(defn get-field-values
  "Description copied from interface: Descriptor

  field-names - String array of the names of the fields that the values should be returned for. If the array is empty then an empty array will be returned. If the array is null then all values will be returned, as if the parameter were the array returned by Descriptor.getFieldNames(). If a field name in the array does not exist, including the case where it is null or the empty string, then null is returned for the matching array element being returned. - `java.lang.String`

  returns: Object array of field values. If the list of fieldNames
   is empty, you will get an empty array. - `java.lang.Object[]`"
  ([^DescriptorSupport this ^java.lang.String field-names]
    (-> this (.getFieldValues field-names))))

(defn set-field
  "Description copied from interface: Descriptor

  field-name - The field name to be set. Cannot be null or empty. - `java.lang.String`
  field-value - The field value to be set for the field name. Can be null if that is a valid value for the field. - `java.lang.Object`

  throws: javax.management.RuntimeOperationsException - if the field name or field value is illegal (wrapped exception is IllegalArgumentException); or if the descriptor is immutable (wrapped exception is UnsupportedOperationException)."
  ([^DescriptorSupport this ^java.lang.String field-name ^java.lang.Object field-value]
    (-> this (.setField field-name field-value))))

(defn valid?
  "Returns true if all of the fields have legal values given their
   names.

   This implementation does not support  interoperating with a directory
   or lookup service. Thus, conforming to the specification, no checking is
   done on the \"export\" field.

   Otherwise this implementation returns false if:

    name and descriptorType fieldNames are not defined, or
   null, or empty, or not String
    class, role, getMethod, setMethod fieldNames, if defined,
   are null or not String
    persistPeriod, currencyTimeLimit, lastUpdatedTimeStamp,
   lastReturnedTimeStamp if defined, are null, or not a Numeric
   String or not a Numeric Value >= -1
    log fieldName, if defined, is null, or not a Boolean or
   not a String with value \"t\", \"f\", \"true\", \"false\". These String
   values must not be case sensitive.
    visibility fieldName, if defined, is null, or not a
   Numeric String or a not Numeric Value >= 1 and <= 4
    severity fieldName, if defined, is null, or not a Numeric
   String or not a Numeric Value >= 0 and <= 6
    persistPolicy fieldName, if defined, is null, or not one of
   the following strings:
     \"OnUpdate\", \"OnTimer\", \"NoMoreOftenThan\", \"OnUnregister\", \"Always\",
     \"Never\". These String values must not be case sensitive.

  returns: true if the values are legal. - `boolean`

  throws: javax.management.RuntimeOperationsException - If the validity checking fails for any reason, this exception will be thrown."
  (^Boolean [^DescriptorSupport this]
    (-> this (.isValid))))

(defn clone
  "Returns a new Descriptor which is a duplicate of the Descriptor.

  returns: a clone of this instance. - `java.lang.Object`

  throws: javax.management.RuntimeOperationsException - for illegal value for field Names or field Values. If the descriptor construction fails for any reason, this exception will be thrown."
  (^java.lang.Object [^DescriptorSupport this]
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
   Arrays.deepHashCode.
   Otherwise h is v.hashCode().

  returns: A hash code value for this object. - `int`"
  (^Integer [^DescriptorSupport this]
    (-> this (.hashCode))))

(defn get-fields
  "Description copied from interface: Descriptor

  returns: String array of fields in the format fieldName=fieldValue
   If the value of a field is not a String, then the toString() method
   will be called on it and the returned value, enclosed in parentheses,
   used as the value for the field in the returned array. If the value
   of a field is null, then the value of the field in the returned array
   will be empty.  If the descriptor is empty, you will get
   an empty array. - `java.lang.String[]`"
  ([^DescriptorSupport this]
    (-> this (.getFields))))

(defn to-xml-string
  "Returns an XML String representing the descriptor.

   The format is not defined, but an implementation must
   ensure that the string returned by this method can be
   used to build an equivalent descriptor when instantiated
   using the constructor DescriptorSupport(String inStr).

   Fields which are not String objects will have toString()
   called on them to create the value. The value will be
   enclosed in parentheses.  It is not guaranteed that you can
   reconstruct these objects unless they have been
   specifically set up to support toString() in a meaningful
   format and have a matching constructor that accepts a
   String in the same format.

   If the descriptor is empty the following String is
   returned: <Descriptor></Descriptor>

  returns: the XML string. - `java.lang.String`

  throws: javax.management.RuntimeOperationsException - for illegal value for field Names or field Values. If the XML formatted string construction fails for any reason, this exception will be thrown."
  (^java.lang.String [^DescriptorSupport this]
    (-> this (.toXMLString))))

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
   Arrays.deepEquals
   must return true.
   Otherwise Object.equals(Object) must return true.

  o - the object to compare with. - `java.lang.Object`

  returns: true if the objects are the same; false
   otherwise. - `boolean`"
  (^Boolean [^DescriptorSupport this ^java.lang.Object o]
    (-> this (.equals o))))

