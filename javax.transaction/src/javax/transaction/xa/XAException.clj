(ns javax.transaction.xa.XAException
  "The XAException is thrown by the Resource Manager (RM) to inform the
  Transaction Manager of an error encountered by the involved transaction."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.transaction.xa XAException]))

(defn ->xa-exception
  "Constructor.

  Create an XAException with a given string.

  s - The String object containing the exception message. - `java.lang.String`"
  (^XAException [^java.lang.String s]
    (new XAException s))
  (^XAException []
    (new XAException )))

(defn -error-code
  "Instance Field.

  The error code with which to create the SystemException.

  type: int"
  [this]
  (-> this .-errorCode))

(def *-xa-rbbase
  "Static Constant.

  The inclusive lower bound of the rollback codes.

  type: int"
  XAException/XA_RBBASE)

(def *-xa-rbrollback
  "Static Constant.

  Indicates that the rollback was caused by an unspecified reason.

  type: int"
  XAException/XA_RBROLLBACK)

(def *-xa-rbcommfail
  "Static Constant.

  Indicates that the rollback was caused by a communication failure.

  type: int"
  XAException/XA_RBCOMMFAIL)

(def *-xa-rbdeadlock
  "Static Constant.

  A deadlock was detected.

  type: int"
  XAException/XA_RBDEADLOCK)

(def *-xa-rbintegrity
  "Static Constant.

  A condition that violates the integrity of the resource was detected.

  type: int"
  XAException/XA_RBINTEGRITY)

(def *-xa-rbother
  "Static Constant.

  The resource manager rolled back the transaction branch for a reason
   not on this list.

  type: int"
  XAException/XA_RBOTHER)

(def *-xa-rbproto
  "Static Constant.

  A protocol error occurred in the resource manager.

  type: int"
  XAException/XA_RBPROTO)

(def *-xa-rbtimeout
  "Static Constant.

  A transaction branch took too long.

  type: int"
  XAException/XA_RBTIMEOUT)

(def *-xa-rbtransient
  "Static Constant.

  May retry the transaction branch.

  type: int"
  XAException/XA_RBTRANSIENT)

(def *-xa-rbend
  "Static Constant.

  The inclusive upper bound of the rollback error code.

  type: int"
  XAException/XA_RBEND)

(def *-xa-nomigrate
  "Static Constant.

  Resumption must occur where the suspension occurred.

  type: int"
  XAException/XA_NOMIGRATE)

(def *-xa-heurhaz
  "Static Constant.

  The transaction branch may have been heuristically completed.

  type: int"
  XAException/XA_HEURHAZ)

(def *-xa-heurcom
  "Static Constant.

  The transaction branch has been heuristically committed.

  type: int"
  XAException/XA_HEURCOM)

(def *-xa-heurrb
  "Static Constant.

  The transaction branch has been heuristically rolled back.

  type: int"
  XAException/XA_HEURRB)

(def *-xa-heurmix
  "Static Constant.

  The transaction branch has been heuristically committed and
   rolled back.

  type: int"
  XAException/XA_HEURMIX)

(def *-xa-retry
  "Static Constant.

  Routine returned with no effect and may be reissued.

  type: int"
  XAException/XA_RETRY)

(def *-xa-rdonly
  "Static Constant.

  The transaction branch was read-only and has been committed.

  type: int"
  XAException/XA_RDONLY)

(def *-xaer-async
  "Static Constant.

  There is an asynchronous operation already outstanding.

  type: int"
  XAException/XAER_ASYNC)

(def *-xaer-rmerr
  "Static Constant.

  A resource manager error has occurred in the transaction branch.

  type: int"
  XAException/XAER_RMERR)

(def *-xaer-nota
  "Static Constant.

  The XID is not valid.

  type: int"
  XAException/XAER_NOTA)

(def *-xaer-inval
  "Static Constant.

  Invalid arguments were given.

  type: int"
  XAException/XAER_INVAL)

(def *-xaer-proto
  "Static Constant.

  Routine was invoked in an inproper context.

  type: int"
  XAException/XAER_PROTO)

(def *-xaer-rmfail
  "Static Constant.

  Resource manager is unavailable.

  type: int"
  XAException/XAER_RMFAIL)

(def *-xaer-dupid
  "Static Constant.

  The XID already exists.

  type: int"
  XAException/XAER_DUPID)

(def *-xaer-outside
  "Static Constant.

  The resource manager is doing work outside a global transaction.

  type: int"
  XAException/XAER_OUTSIDE)

