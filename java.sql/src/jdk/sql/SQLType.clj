(ns jdk.sql.SQLType
  "An object that is used to identify a generic SQL type, called a JDBC type or
  a vendor specific data type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLType]))

(defn get-name
  "Returns the SQLType name that represents a SQL data type.

  returns: The name of this SQLType. - `java.lang.String`"
  ([^java.sql.SQLType this]
    (-> this (.getName))))

(defn get-vendor
  "Returns the name of the vendor that supports this data type. The value
   returned typically is the package name for this vendor.

  returns: The name of the vendor for this data type - `java.lang.String`"
  ([^java.sql.SQLType this]
    (-> this (.getVendor))))

(defn get-vendor-type-number
  "Returns the vendor specific type number for the data type.

  returns: An Integer representing the vendor specific data type - `java.lang.Integer`"
  ([^java.sql.SQLType this]
    (-> this (.getVendorTypeNumber))))

