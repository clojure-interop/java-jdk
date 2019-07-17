(ns javax.naming.ReferralException
  "This abstract class is used to represent a referral exception,
  which is generated in response to a referral
  such as that returned by LDAP v3 servers.

  A service provider provides
  a subclass of ReferralException by providing implementations
  for getReferralInfo() and getReferralContext() (and appropriate
  constructors and/or corresponding `set` methods).

  The following code sample shows how ReferralException can be used.
  while (true) {
           try {
               bindings = ctx.listBindings(name);
               while (bindings.hasMore()) {
                   b = bindings.next();
                   ...
               }
               break;
           } catch (ReferralException e) {
               ctx = e.getReferralContext();
           }
       }


  ReferralException is an abstract class. Concrete implementations
  determine its synchronization and serialization properties.

  An environment parameter passed to the getReferralContext()
  method is owned by the caller.
  The service provider will not modify the object or keep a reference to it,
  but may keep a reference to a clone of it."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming ReferralException]))

(defn get-referral-info
  "Retrieves information (such as URLs) related to this referral.
   The program may examine or display this information
   to the user to determine whether to continue with the referral,
   or to determine additional information needs to be supplied in order
   to continue with the referral.

  returns: Non-null referral information related to this referral. - `java.lang.Object`"
  ([^javax.naming.ReferralException this]
    (-> this (.getReferralInfo))))

(defn get-referral-context
  "Retrieves the context at which to continue the method using
   environment properties.
   Regardless of whether a referral is encountered directly during a
   context operation, or indirectly, for example, during a search
   enumeration, the referral exception should provide a context
   at which to continue the operation.

   The referral context is created using env as its environment
   properties.
   This method should be used instead of the no-arg overloaded form
   when the caller needs to use different environment properties for
   the referral context. It might need to do this, for example, when
   it needs to supply different authentication information to the referred
   server in order to create the referral context.

   To continue the operation, the client program should re-invoke
   the method using the same arguments as the original invocation.

  env - The possibly null environment to use when retrieving the referral context. If null, no environment properties will be used. - `java.util.Hashtable<?,?>`

  returns: The non-null context at which to continue the method. - `javax.naming.Context`

  throws: javax.naming.NamingException - If a naming exception was encountered. Call either retryReferral() or skipReferral() to continue processing referrals."
  ([^javax.naming.ReferralException this ^java.util.Hashtable env]
    (-> this (.getReferralContext env)))
  ([^javax.naming.ReferralException this]
    (-> this (.getReferralContext))))

(defn skip-referral
  "Discards the referral about to be processed.
   A call to this method should be followed by a call to
   getReferralContext to allow the processing of
   other referrals to continue.
   The following code fragment shows a typical usage pattern.


    } catch (ReferralException e) {
        if (!shallIFollow(e.getReferralInfo())) {
            if (!e.skipReferral()) {
                return;
            }
        }
        ctx = e.getReferralContext();
    }

  returns: true If more referral processing is pending; false otherwise. - `boolean`"
  ([^javax.naming.ReferralException this]
    (-> this (.skipReferral))))

(defn retry-referral
  "Retries the referral currently being processed.
   A call to this method should be followed by a call to
   getReferralContext to allow the current
   referral to be retried.
   The following code fragment shows a typical usage pattern.


    } catch (ReferralException e) {
        while (true) {
            try {
                ctx = e.getReferralContext(env);
                break;
            } catch (NamingException ne) {
                if (! shallIRetry()) {
                    return;
                }
                // modify environment properties (env), if necessary
                e.retryReferral();
            }
        }
    }"
  ([^javax.naming.ReferralException this]
    (-> this (.retryReferral))))

