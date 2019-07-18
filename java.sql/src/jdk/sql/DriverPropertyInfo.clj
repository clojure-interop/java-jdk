(ns jdk.sql.DriverPropertyInfo
  "Driver properties for making a connection. The
  DriverPropertyInfo class is of interest only to advanced programmers
  who need to interact with a Driver via the method
  getDriverProperties to discover
  and supply properties for connections."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql DriverPropertyInfo]))

(defn ->driver-property-info
  "Constructor.

  Constructs a DriverPropertyInfo object with a  given
   name and value.  The description and choices
   are initialized to null and required is initialized
   to false.

  name - the name of the property - `java.lang.String`
  value - the current value, which may be null - `java.lang.String`"
  (^DriverPropertyInfo [^java.lang.String name ^java.lang.String value]
    (new DriverPropertyInfo name value)))

(defn -name
  "Instance Field.

  The name of the property.

  type: java.lang.String"
  [this]
  (-> this .-name))

(defn -description
  "Instance Field.

  A brief description of the property, which may be null.

  type: java.lang.String"
  [this]
  (-> this .-description))

(defn -required
  "Instance Field.

  The required field is true if a value must be
   supplied for this property
   during Driver.connect and false otherwise.

  type: boolean"
  [this]
  (-> this .-required))

(defn -value
  "Instance Field.

  The value field specifies the current value of
   the property, based on a combination of the information
   supplied to the method getPropertyInfo, the
   Java environment, and the driver-supplied default values.  This field
   may be null if no value is known.

  type: java.lang.String"
  [this]
  (-> this .-value))

(defn -choices
  "Instance Field.

  An array of possible values if the value for the field
   DriverPropertyInfo.value may be selected
   from a particular set of values; otherwise null.

  type: java.lang.String[]"
  [this]
  (-> this .-choices))

