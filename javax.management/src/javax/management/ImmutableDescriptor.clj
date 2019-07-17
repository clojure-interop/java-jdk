(ns javax.management.ImmutableDescriptor
  "An immutable descriptor."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management ImmutableDescriptor]))

(defn ->immutable-descriptor
  "Constructor.

  Construct a descriptor containing the given fields and values.

  field-names - `java.lang.String[]`
  field-values - `java.lang.Object[]`

  throws: java.lang.IllegalArgumentException - if either array is null, or if the arrays have different sizes, or if a field name is null or empty, or if the same field name appears more than once."
  ([field-names field-values]
    (new ImmutableDescriptor field-names field-values))
  ([^java.lang.String fields]
    (new ImmutableDescriptor fields)))

(def *-empty-descriptor
  "Static Constant.

  An empty descriptor.

  type: javax.management.ImmutableDescriptor"
  ImmutableDescriptor/EMPTY_DESCRIPTOR)

(defn *union
  "Return an ImmutableDescriptor whose contents are the union of
   the given descriptors.  Every field name that appears in any of
   the descriptors will appear in the result with the
   value that it has when the method is called.  Subsequent changes
   to any of the descriptors do not affect the ImmutableDescriptor
   returned here.

   In the simplest case, there is only one descriptor and the
   returned ImmutableDescriptor is a copy of its fields at the
   time this method is called:



   Descriptor d = something();
   ImmutableDescriptor copy = ImmutableDescriptor.union(d);

  descriptors - the descriptors to be combined. Any of the descriptors can be null, in which case it is skipped. - `javax.management.Descriptor`

  returns: an ImmutableDescriptor that is the union of the given
   descriptors.  The returned object may be identical to one of the
   input descriptors if it is an ImmutableDescriptor that contains all of
   the required fields. - `javax.management.ImmutableDescriptor`

  throws: java.lang.IllegalArgumentException - if two Descriptors contain the same field name with different associated values. Primitive array values are considered the same if they are of the same type with the same elements. Object array values are considered the same if Arrays.deepEquals(Object[],Object[]) returns true."
  (^javax.management.ImmutableDescriptor [^javax.management.Descriptor descriptors]
    (ImmutableDescriptor/union descriptors)))

(defn set-fields
  "This operation is unsupported since this class is immutable.  If
   this call would change a mutable descriptor with the same contents,
   then a RuntimeOperationsException wrapping an
   UnsupportedOperationException is thrown.  Otherwise,
   the behavior is the same as it would be for a mutable descriptor:
   either an exception is thrown because of illegal parameters, or
   there is no effect.

  field-names - String array of field names. The array and array elements cannot be null. - `java.lang.String[]`
  field-values - Object array of the corresponding field values. The array cannot be null. Elements of the array can be null. - `java.lang.Object[]`

  throws: javax.management.RuntimeOperationsException - if the change fails for any reason. Wrapped exception is IllegalArgumentException if fieldNames or fieldValues is null, or if the arrays are of different lengths, or if there is an illegal value in one of them. Wrapped exception is UnsupportedOperationException if the descriptor is immutable, and the call would change its contents."
  ([^javax.management.ImmutableDescriptor this field-names field-values]
    (-> this (.setFields field-names field-values))))

(defn remove-field
  "Removes a field from the descriptor.

  field-name - String name of the field to be removed. If the field name is illegal or the field is not found, no exception is thrown. - `java.lang.String`

  throws: javax.management.RuntimeOperationsException - if a field of the given name exists and the descriptor is immutable. The wrapped exception will be an UnsupportedOperationException."
  ([^javax.management.ImmutableDescriptor this ^java.lang.String field-name]
    (-> this (.removeField field-name))))

(defn get-field-names
  "Description copied from interface: Descriptor

  returns: String array of field names. If the descriptor is empty,
   you will get an empty array. - `java.lang.String[]`"
  ([^javax.management.ImmutableDescriptor this]
    (-> this (.getFieldNames))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^javax.management.ImmutableDescriptor this]
    (-> this (.toString))))

(defn get-field-value
  "Description copied from interface: Descriptor

  field-name - the field name. - `java.lang.String`

  returns: the corresponding value, or null if the field is not present. - `java.lang.Object`"
  (^java.lang.Object [^javax.management.ImmutableDescriptor this ^java.lang.String field-name]
    (-> this (.getFieldValue field-name))))

(defn get-field-values
  "Description copied from interface: Descriptor

  field-names - String array of the names of the fields that the values should be returned for. If the array is empty then an empty array will be returned. If the array is null then all values will be returned, as if the parameter were the array returned by Descriptor.getFieldNames(). If a field name in the array does not exist, including the case where it is null or the empty string, then null is returned for the matching array element being returned. - `java.lang.String`

  returns: Object array of field values. If the list of fieldNames
   is empty, you will get an empty array. - `java.lang.Object[]`"
  ([^javax.management.ImmutableDescriptor this ^java.lang.String field-names]
    (-> this (.getFieldValues field-names))))

(defn set-field
  "This operation is unsupported since this class is immutable.  If
   this call would change a mutable descriptor with the same contents,
   then a RuntimeOperationsException wrapping an
   UnsupportedOperationException is thrown.  Otherwise,
   the behavior is the same as it would be for a mutable descriptor:
   either an exception is thrown because of illegal parameters, or
   there is no effect.

  field-name - The field name to be set. Cannot be null or empty. - `java.lang.String`
  field-value - The field value to be set for the field name. Can be null if that is a valid value for the field. - `java.lang.Object`

  throws: javax.management.RuntimeOperationsException - if the field name or field value is illegal (wrapped exception is IllegalArgumentException); or if the descriptor is immutable (wrapped exception is UnsupportedOperationException)."
  ([^javax.management.ImmutableDescriptor this ^java.lang.String field-name ^java.lang.Object field-value]
    (-> this (.setField field-name field-value))))

(defn valid?
  "Returns true if all of the fields have legal values given their
   names.  This method always returns true, but a subclass can
   override it to return false when appropriate.

  returns: true if the values are legal. - `boolean`

  throws: javax.management.RuntimeOperationsException - if the validity checking fails. The method returns false if the descriptor is not valid, but throws this exception if the attempt to determine validity fails."
  (^Boolean [^javax.management.ImmutableDescriptor this]
    (-> this (.isValid))))

(defn clone
  "Returns a descriptor which is equal to this descriptor.
   Changes to the returned descriptor will have no effect on this
   descriptor, and vice versa.

   This method returns the object on which it is called.
   A subclass can override it
   to return another object provided the contract is respected.

  returns: a clone of this instance. - `javax.management.Descriptor`

  throws: javax.management.RuntimeOperationsException - for illegal value for field Names or field Values. If the descriptor construction fails for any reason, this exception will be thrown."
  (^javax.management.Descriptor [^javax.management.ImmutableDescriptor this]
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
  (^Integer [^javax.management.ImmutableDescriptor this]
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
  ([^javax.management.ImmutableDescriptor this]
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

  o - the object to compare with. - `java.lang.Object`

  returns: true if the objects are the same; false
   otherwise. - `boolean`"
  (^Boolean [^javax.management.ImmutableDescriptor this ^java.lang.Object o]
    (-> this (.equals o))))

