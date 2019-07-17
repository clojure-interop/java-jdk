(ns javax.transaction.xa.XAResource
  "The XAResource interface is a Java mapping of the industry standard
  XA interface based on the X/Open CAE Specification (Distributed
  Transaction Processing: The XA Specification).

  The XA interface defines the contract between a Resource Manager
  and a Transaction Manager in a distributed transaction processing
  (DTP) environment. A JDBC driver or a JMS provider implements
  this interface to support the association between a global transaction
  and a database or message service connection.

  The XAResource interface can be supported by any transactional
  resource that is intended to be used by application programs in an
  environment where transactions are controlled by an external
  transaction manager. An example of such a resource is a database
  management system. An application may access data through multiple
  database connections. Each database connection is enlisted with
  the transaction manager as a transactional resource. The transaction
  manager obtains an XAResource for each connection participating
  in a global transaction. The transaction manager uses the
  start method
  to associate the global transaction with the resource, and it uses the
  end method to disassociate the transaction from
  the resource. The resource
  manager is responsible for associating the global transaction to all
  work performed on its data between the start and end method invocations.

  At transaction commit time, the resource managers are informed by
  the transaction manager to prepare, commit, or rollback a transaction
  according to the two-phase commit protocol."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.transaction.xa XAResource]))

(defn recover
  "Obtains a list of prepared transaction branches from a resource
   manager. The transaction manager calls this method during recovery
   to obtain the list of transaction branches that are currently in
   prepared or heuristically completed states.

  flag - One of TMSTARTRSCAN, TMENDRSCAN, TMNOFLAGS. TMNOFLAGS must be used when no other flags are set in the parameter. - `int`

  returns: The resource manager returns zero or more XIDs of the
   transaction branches that are currently in a prepared or
   heuristically completed state. If an error occurs during the
   operation, the resource manager should throw the appropriate
   XAException. - `javax.transaction.xa.Xid[]`

  throws: javax.transaction.xa.XAException - An error has occurred. Possible values are XAER_RMERR, XAER_RMFAIL, XAER_INVAL, and XAER_PROTO."
  ([this flag]
    (-> this (.recover flag))))

(defn forget
  "Tells the resource manager to forget about a heuristically
   completed transaction branch.

  xid - A global transaction identifier. - `javax.transaction.xa.Xid`

  throws: javax.transaction.xa.XAException - An error has occurred. Possible exception values are XAER_RMERR, XAER_RMFAIL, XAER_NOTA, XAER_INVAL, or XAER_PROTO."
  ([this xid]
    (-> this (.forget xid))))

(defn get-transaction-timeout
  "Obtains the current transaction timeout value set for this
   XAResource instance. If XAResource.setTransactionTimeout
   was not used prior to invoking this method, the return value
   is the default timeout set for the resource manager; otherwise,
   the value used in the previous setTransactionTimeout
   call is returned.

  returns: the transaction timeout value in seconds. - `int`

  throws: javax.transaction.xa.XAException - An error has occurred. Possible exception values are XAER_RMERR and XAER_RMFAIL."
  ([this]
    (-> this (.getTransactionTimeout))))

(defn set-transaction-timeout
  "Sets the current transaction timeout value for this XAResource
   instance. Once set, this timeout value is effective until
   setTransactionTimeout is invoked again with a different
   value. To reset the timeout value to the default value used by the resource
   manager, set the value to zero.

   If the timeout operation is performed successfully, the method returns
   true; otherwise false. If a resource manager does not
   support explicitly setting the transaction timeout value, this method
   returns false.

  seconds - The transaction timeout value in seconds. - `int`

  returns: true if the transaction timeout value is set successfully;
         otherwise false. - `boolean`

  throws: javax.transaction.xa.XAException - An error has occurred. Possible exception values are XAER_RMERR, XAER_RMFAIL, or XAER_INVAL."
  ([this seconds]
    (-> this (.setTransactionTimeout seconds))))

(defn commit
  "Commits the global transaction specified by xid.

  xid - A global transaction identifier - `javax.transaction.xa.Xid`
  one-phase - If true, the resource manager should use a one-phase commit protocol to commit the work done on behalf of xid. - `boolean`

  throws: javax.transaction.xa.XAException - An error has occurred. Possible XAExceptions are XA_HEURHAZ, XA_HEURCOM, XA_HEURRB, XA_HEURMIX, XAER_RMERR, XAER_RMFAIL, XAER_NOTA, XAER_INVAL, or XAER_PROTO. If the resource manager did not commit the transaction and the paramether onePhase is set to true, the resource manager may throw one of the XA_RB* exceptions. Upon return, the resource manager has rolled back the branch's work and has released all held resources."
  ([this xid one-phase]
    (-> this (.commit xid one-phase))))

(defn start
  "Starts work on behalf of a transaction branch specified in
   xid.

   If TMJOIN is specified, the start applies to joining a transaction
   previously seen by the resource manager. If TMRESUME is specified,
   the start applies to resuming a suspended transaction specified in the
   parameter xid.

   If neither TMJOIN nor TMRESUME is specified and the transaction
   specified by xid has previously been seen by the resource
   manager, the resource manager throws the XAException exception with
   XAER_DUPID error code.

  xid - A global transaction identifier to be associated with the resource. - `javax.transaction.xa.Xid`
  flags - One of TMNOFLAGS, TMJOIN, or TMRESUME. - `int`

  throws: javax.transaction.xa.XAException - An error has occurred. Possible exceptions are XA_RB*, XAER_RMERR, XAER_RMFAIL, XAER_DUPID, XAER_OUTSIDE, XAER_NOTA, XAER_INVAL, or XAER_PROTO."
  ([this xid flags]
    (-> this (.start xid flags))))

(defn same-rm?
  "This method is called to determine if the resource manager
   instance represented by the target object is the same as the
   resouce manager instance represented by the parameter xares.

  xares - An XAResource object whose resource manager instance is to be compared with the resource manager instance of the target object. - `javax.transaction.xa.XAResource`

  returns: true if it's the same RM instance; otherwise
         false. - `boolean`

  throws: javax.transaction.xa.XAException - An error has occurred. Possible exception values are XAER_RMERR and XAER_RMFAIL."
  ([this xares]
    (-> this (.isSameRM xares))))

(defn rollback
  "Informs the resource manager to roll back work done on behalf
   of a transaction branch.

  xid - A global transaction identifier. - `javax.transaction.xa.Xid`

  throws: javax.transaction.xa.XAException - An error has occurred."
  ([this xid]
    (-> this (.rollback xid))))

(defn prepare
  "Ask the resource manager to prepare for a transaction commit
   of the transaction specified in xid.

  xid - A global transaction identifier. - `javax.transaction.xa.Xid`

  returns: A value indicating the resource manager's vote on the
   outcome of the transaction. The possible values are: XA_RDONLY
   or XA_OK. If the resource manager wants to roll back the
   transaction, it should do so by raising an appropriate XAException
   in the prepare method. - `int`

  throws: javax.transaction.xa.XAException - An error has occurred. Possible exception values are: XA_RB*, XAER_RMERR, XAER_RMFAIL, XAER_NOTA, XAER_INVAL, or XAER_PROTO."
  ([this xid]
    (-> this (.prepare xid))))

(defn end
  "Ends the work performed on behalf of a transaction branch.
   The resource manager disassociates the XA resource from the
   transaction branch specified and lets the transaction
   complete.

   If TMSUSPEND is specified in the flags, the transaction branch
   is temporarily suspended in an incomplete state. The transaction
   context is in a suspended state and must be resumed via the
   start method with TMRESUME specified.

   If TMFAIL is specified, the portion of work has failed.
   The resource manager may mark the transaction as rollback-only

   If TMSUCCESS is specified, the portion of work has completed
   successfully.

  xid - A global transaction identifier that is the same as the identifier used previously in the start method. - `javax.transaction.xa.Xid`
  flags - One of TMSUCCESS, TMFAIL, or TMSUSPEND. - `int`

  throws: javax.transaction.xa.XAException - An error has occurred. Possible XAException values are XAER_RMERR, XAER_RMFAILED, XAER_NOTA, XAER_INVAL, XAER_PROTO, or XA_RB*."
  ([this xid flags]
    (-> this (.end xid flags))))

