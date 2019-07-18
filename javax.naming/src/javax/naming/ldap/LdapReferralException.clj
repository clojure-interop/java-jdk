(ns javax.naming.ldap.LdapReferralException
  "This abstract class is used to represent an LDAP referral exception.
  It extends the base ReferralException by providing a
  getReferralContext() method that accepts request controls.
  LdapReferralException is an abstract class. Concrete implementations of it
  determine its synchronization and serialization properties.

  A Control[] array passed as a parameter to
  the getReferralContext() method is owned by the caller.
  The service provider will not modify the array or keep a reference to it,
  although it may keep references to the individual Control objects
  in the array."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap LdapReferralException]))

(defn get-referral-context
  "Retrieves the context at which to continue the method using
   request controls and environment properties.
   Regardless of whether a referral is encountered directly during a
   context operation, or indirectly, for example, during a search
   enumeration, the referral exception should provide a context
   at which to continue the operation.
   To continue the operation, the client program should re-invoke
   the method using the same arguments as the original invocation.

   reqCtls is used when creating the connection to the referred
   server. These controls will be used as the connection request controls for
   the context and context instances
   derived from the context.
   reqCtls will also be the context's request controls for
   subsequent context operations. See the LdapContext class
   description for details.

   This method should be used instead of the other two overloaded forms
   when the caller needs to supply request controls for creating
   the referral context. It might need to do this, for example, when
   it needs to supply special controls relating to authentication.

   Service provider implementors should read the `Service Provider` section
   in the LdapContext class description for implementation details.

  env - The possibly null environment properties to use when for the new context. If null, the context is initialized with no environment properties. - `java.util.Hashtable`
  req-ctls - The possibly null request controls to use for the new context. If null or the empty array means use no request controls. - `javax.naming.ldap.Control[]`

  returns: The non-null context at which to continue the method. - `javax.naming.Context`

  throws: javax.naming.NamingException - If a naming exception was encountered. Call either retryReferral() or skipReferral() to continue processing referrals."
  (^javax.naming.Context [^LdapReferralException this ^java.util.Hashtable env req-ctls]
    (-> this (.getReferralContext env req-ctls)))
  (^javax.naming.Context [^LdapReferralException this ^java.util.Hashtable env]
    (-> this (.getReferralContext env)))
  (^javax.naming.Context [^LdapReferralException this]
    (-> this (.getReferralContext))))

