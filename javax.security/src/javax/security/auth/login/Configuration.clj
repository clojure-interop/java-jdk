(ns javax.security.auth.login.Configuration
  "A Configuration object is responsible for specifying which LoginModules
  should be used for a particular application, and in what order the
  LoginModules should be invoked.

   A login configuration contains the following information.
  Note that this example only represents the default syntax for the
  Configuration.  Subclass implementations of this class
  may implement alternative syntaxes and may retrieve the
  Configuration from any source such as files, databases,
  or servers.



       Name {
             ModuleClass  Flag    ModuleOptions;
             ModuleClass  Flag    ModuleOptions;
             ModuleClass  Flag    ModuleOptions;
       };
       Name {
             ModuleClass  Flag    ModuleOptions;
             ModuleClass  Flag    ModuleOptions;
       };
       other {
             ModuleClass  Flag    ModuleOptions;
             ModuleClass  Flag    ModuleOptions;
       };

   Each entry in the Configuration is indexed via an
  application name, Name, and contains a list of
  LoginModules configured for that application.  Each LoginModule
  is specified via its fully qualified class name.
  Authentication proceeds down the module list in the exact order specified.
  If an application does not have a specific entry,
  it defaults to the specific entry for `other`.

   The Flag value controls the overall behavior as authentication
  proceeds down the stack.  The following represents a description of the
  valid values for Flag and their respective semantics:



       1) Required     - The  LoginModule is required to succeed.
                       If it succeeds or fails, authentication still continues
                       to proceed down the  LoginModule list.

       2) Requisite    - The  LoginModule is required to succeed.
                       If it succeeds, authentication continues down the
                        LoginModule list.  If it fails,
                       control immediately returns to the application
                       (authentication does not proceed down the
                        LoginModule list).

       3) Sufficient   - The  LoginModule is not required to
                       succeed.  If it does succeed, control immediately
                       returns to the application (authentication does not
                       proceed down the  LoginModule list).
                       If it fails, authentication continues down the
                        LoginModule list.

       4) Optional     - The  LoginModule is not required to
                       succeed.  If it succeeds or fails,
                       authentication still continues to proceed down the
                        LoginModule list.

   The overall authentication succeeds only if all Required and
  Requisite LoginModules succeed.  If a Sufficient
  LoginModule is configured and succeeds,
  then only the Required and Requisite LoginModules prior to
  that Sufficient LoginModule need to have succeeded for
  the overall authentication to succeed. If no Required or
  Requisite LoginModules are configured for an application,
  then at least one Sufficient or Optional
  LoginModule must succeed.

   ModuleOptions is a space separated list of
  LoginModule-specific values which are passed directly to
  the underlying LoginModules.  Options are defined by the
  LoginModule itself, and control the behavior within it.
  For example, a LoginModule may define options to support
  debugging/testing capabilities.  The correct way to specify options in the
  Configuration is by using the following key-value pairing:
  debug=`true`.  The key and value should be separated by an
  'equals' symbol, and the value should be surrounded by double quotes.
  If a String in the form, ${system.property}, occurs in the value,
  it will be expanded to the value of the system property.
  Note that there is no limit to the number of
  options a LoginModule may define.

   The following represents an example Configuration entry
  based on the syntax above:



  Login {
    com.sun.security.auth.module.UnixLoginModule required;
    com.sun.security.auth.module.Krb5LoginModule optional
                    useTicketCache=`true`
                    ticketCache=`${user.home}${/}tickets`;
  };

   This Configuration specifies that an application named,
  `Login`, requires users to first authenticate to the
  com.sun.security.auth.module.UnixLoginModule, which is
  required to succeed.  Even if the UnixLoginModule
  authentication fails, the
  com.sun.security.auth.module.Krb5LoginModule
  still gets invoked.  This helps hide the source of failure.
  Since the Krb5LoginModule is Optional, the overall
  authentication succeeds only if the UnixLoginModule
  (Required) succeeds.

   Also note that the LoginModule-specific options,
  useTicketCache=`true` and
  ticketCache=${user.home}${/}tickets`,
  are passed to the Krb5LoginModule.
  These options instruct the Krb5LoginModule to
  use the ticket cache at the specified location.
  The system properties, user.home and /
  (file.separator), are expanded to their respective values.

   There is only one Configuration object installed in the runtime at any
  given time.  A Configuration object can be installed by calling the
  setConfiguration method.  The installed Configuration object
  can be obtained by calling the getConfiguration method.

   If no Configuration object has been installed in the runtime, a call to
  getConfiguration installs an instance of the default
  Configuration implementation (a default subclass implementation of this
  abstract class).
  The default Configuration implementation can be changed by setting the value
  of the login.configuration.provider security property to the fully
  qualified name of the desired Configuration subclass implementation.

   Application code can directly subclass Configuration to provide a custom
  implementation.  In addition, an instance of a Configuration object can be
  constructed by invoking one of the getInstance factory methods
  with a standard type.  The default policy type is `JavaLoginConfig`.
  See the Configuration section in the
  Java Cryptography Architecture Standard Algorithm Name Documentation
  for a list of standard Configuration types."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login Configuration]))

(defn *get-configuration
  "Get the installed login Configuration.

  returns: the login Configuration.  If a Configuration object was set
            via the Configuration.setConfiguration method,
            then that object is returned.  Otherwise, a default
            Configuration object is returned. - `javax.security.auth.login.Configuration`

  throws: java.lang.SecurityException - if the caller does not have permission to retrieve the Configuration."
  ([]
    (Configuration/getConfiguration )))

(defn *set-configuration
  "Set the login Configuration.

  configuration - the new Configuration - `javax.security.auth.login.Configuration`

  throws: java.lang.SecurityException - if the current thread does not have Permission to set the Configuration."
  ([^javax.security.auth.login.Configuration configuration]
    (Configuration/setConfiguration configuration)))

(defn *get-instance
  "Returns a Configuration object of the specified type.

    A new Configuration object encapsulating the
   ConfigurationSpi implementation from the specified provider
   is returned.   The specified provider must be registered
   in the provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  type - the specified Configuration type. See the Configuration section in the Java Cryptography Architecture Standard Algorithm Name Documentation for a list of standard Configuration types. - `java.lang.String`
  params - parameters for the Configuration, which may be null. - `javax.security.auth.login.Configuration.Parameters`
  provider - the provider. - `java.lang.String`

  returns: the new Configuration object. - `javax.security.auth.login.Configuration`

  throws: java.lang.SecurityException - if the caller does not have permission to get a Configuration instance for the specified type."
  ([^java.lang.String type ^javax.security.auth.login.Configuration.Parameters params ^java.lang.String provider]
    (Configuration/getInstance type params provider))
  ([^java.lang.String type ^javax.security.auth.login.Configuration.Parameters params]
    (Configuration/getInstance type params)))

(defn get-provider
  "Return the Provider of this Configuration.

    This Configuration instance will only have a Provider if it
   was obtained via a call to Configuration.getInstance.
   Otherwise this method returns null.

  returns: the Provider of this Configuration, or null. - `java.security.Provider`"
  ([^javax.security.auth.login.Configuration this]
    (-> this (.getProvider))))

(defn get-type
  "Return the type of this Configuration.

    This Configuration instance will only have a type if it
   was obtained via a call to Configuration.getInstance.
   Otherwise this method returns null.

  returns: the type of this Configuration, or null. - `java.lang.String`"
  ([^javax.security.auth.login.Configuration this]
    (-> this (.getType))))

(defn get-parameters
  "Return Configuration parameters.

    This Configuration instance will only have parameters if it
   was obtained via a call to Configuration.getInstance.
   Otherwise this method returns null.

  returns: Configuration parameters, or null. - `javax.security.auth.login.Configuration.Parameters`"
  ([^javax.security.auth.login.Configuration this]
    (-> this (.getParameters))))

(defn get-app-configuration-entry
  "Retrieve the AppConfigurationEntries for the specified name
   from this Configuration.

  name - the name used to index the Configuration. - `java.lang.String`

  returns: an array of AppConfigurationEntries for the specified name
            from this Configuration, or null if there are no entries
            for the specified name - `javax.security.auth.login.AppConfigurationEntry[]`"
  ([^javax.security.auth.login.Configuration this ^java.lang.String name]
    (-> this (.getAppConfigurationEntry name))))

(defn refresh
  "Refresh and reload the Configuration.

    This method causes this Configuration object to refresh/reload its
   contents in an implementation-dependent manner.
   For example, if this Configuration object stores its entries in a file,
   calling refresh may cause the file to be re-read.

    The default implementation of this method does nothing.
   This method should be overridden if a refresh operation is supported
   by the implementation.

  throws: java.lang.SecurityException - if the caller does not have permission to refresh its Configuration."
  ([^javax.security.auth.login.Configuration this]
    (-> this (.refresh))))

