(ns javax.management.relation.RoleInfo
  "A RoleInfo object summarises a role in a relation type.

  The serialVersionUID of this class is 2504952983494636987L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RoleInfo]))

(defn ->role-info
  "Constructor.

  Constructor.

  role-name - name of the role. - `java.lang.String`
  mbean-class-name - name of the class of MBean(s) expected to be referenced in corresponding role. If an MBean M is in this role, then the MBean server must return true for isInstanceOf(M, mbeanClassName). - `java.lang.String`
  read - flag to indicate if the corresponding role can be read - `boolean`
  write - flag to indicate if the corresponding role can be set - `boolean`
  min - minimum degree for role, i.e. minimum number of MBeans to provide in corresponding role Must be less than or equal to max. (ROLE_CARDINALITY_INFINITY for unlimited) - `int`
  max - maximum degree for role, i.e. maximum number of MBeans to provide in corresponding role Must be greater than or equal to min (ROLE_CARDINALITY_INFINITY for unlimited) - `int`
  descr - description of the role (can be null) - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^java.lang.String role-name ^java.lang.String mbean-class-name ^Boolean read ^Boolean write ^Integer min ^Integer max ^java.lang.String descr]
    (new RoleInfo role-name mbean-class-name read write min max descr))
  ([^java.lang.String role-name ^java.lang.String mbean-class-name ^Boolean read ^Boolean write]
    (new RoleInfo role-name mbean-class-name read write))
  ([^java.lang.String role-name ^java.lang.String mbean-class-name]
    (new RoleInfo role-name mbean-class-name))
  ([^javax.management.relation.RoleInfo role-info]
    (new RoleInfo role-info)))

(def *-role-cardinality-infinity
  "Static Constant.

  To specify an unlimited cardinality.

  type: int"
  RoleInfo/ROLE_CARDINALITY_INFINITY)

(defn readable?
  "Returns read access mode for the role (true if it is readable).

  returns: true if the role is readable. - `boolean`"
  (^Boolean [^javax.management.relation.RoleInfo this]
    (-> this (.isReadable))))

(defn get-ref-m-bean-class-name
  "Returns name of type of MBean expected to be referenced in
   corresponding role.

  returns: the name of the referenced type. - `java.lang.String`"
  (^java.lang.String [^javax.management.relation.RoleInfo this]
    (-> this (.getRefMBeanClassName))))

(defn to-string
  "Returns a string describing the role info.

  returns: a description of the role info. - `java.lang.String`"
  (^java.lang.String [^javax.management.relation.RoleInfo this]
    (-> this (.toString))))

(defn check-max-degree
  "Returns true if the value parameter is lower than or equal to
   the expected maximum degree, false otherwise.

  value - the value to be checked - `int`

  returns: true if lower than or equal to maximum degree, false otherwise. - `boolean`"
  (^Boolean [^javax.management.relation.RoleInfo this ^Integer value]
    (-> this (.checkMaxDegree value))))

(defn get-name
  "Returns the name of the role.

  returns: the name of the role. - `java.lang.String`"
  (^java.lang.String [^javax.management.relation.RoleInfo this]
    (-> this (.getName))))

(defn get-description
  "Returns description text for the role.

  returns: the description of the role. - `java.lang.String`"
  (^java.lang.String [^javax.management.relation.RoleInfo this]
    (-> this (.getDescription))))

(defn get-max-degree
  "Returns maximum degree for corresponding role reference.

  returns: the maximum degree. - `int`"
  (^Integer [^javax.management.relation.RoleInfo this]
    (-> this (.getMaxDegree))))

(defn get-min-degree
  "Returns minimum degree for corresponding role reference.

  returns: the minimum degree. - `int`"
  (^Integer [^javax.management.relation.RoleInfo this]
    (-> this (.getMinDegree))))

(defn check-min-degree
  "Returns true if the value parameter is greater than or equal to
   the expected minimum degree, false otherwise.

  value - the value to be checked - `int`

  returns: true if greater than or equal to minimum degree, false otherwise. - `boolean`"
  (^Boolean [^javax.management.relation.RoleInfo this ^Integer value]
    (-> this (.checkMinDegree value))))

(defn writable?
  "Returns write access mode for the role (true if it is writable).

  returns: true if the role is writable. - `boolean`"
  (^Boolean [^javax.management.relation.RoleInfo this]
    (-> this (.isWritable))))

