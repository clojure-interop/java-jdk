(ns javax.transaction.xa.Xid
  "The Xid interface is a Java mapping of the X/Open transaction identifier
  XID structure. This interface specifies three accessor methods to
  retrieve a global transaction format ID, global transaction ID,
  and branch qualifier. The Xid interface is used by the transaction
  manager and the resource managers. This interface is not visible to
  the application programs."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.transaction.xa Xid]))

(defn get-format-id
  "Obtain the format identifier part of the XID.

  returns: Format identifier. O means the OSI CCR format. - `int`"
  (^Integer [^javax.transaction.xa.Xid this]
    (-> this (.getFormatId))))

(defn get-global-transaction-id
  "Obtain the global transaction identifier part of XID as an array
   of bytes.

  returns: Global transaction identifier. - `byte[]`"
  ([^javax.transaction.xa.Xid this]
    (-> this (.getGlobalTransactionId))))

(defn get-branch-qualifier
  "Obtain the transaction branch identifier part of XID as an array
   of bytes.

  returns: Global transaction identifier. - `byte[]`"
  ([^javax.transaction.xa.Xid this]
    (-> this (.getBranchQualifier))))

