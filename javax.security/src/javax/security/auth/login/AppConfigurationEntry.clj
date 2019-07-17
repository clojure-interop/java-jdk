(ns javax.security.auth.login.AppConfigurationEntry
  "This class represents a single LoginModule entry
  configured for the application specified in the
  getAppConfigurationEntry(String appName)
  method in the Configuration class.  Each respective
  AppConfigurationEntry contains a LoginModule name,
  a control flag (specifying whether this LoginModule is
  REQUIRED, REQUISITE, SUFFICIENT, or OPTIONAL), and LoginModule-specific
  options.  Please refer to the Configuration class for
  more information on the different control flags and their semantics."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login AppConfigurationEntry]))

(defn ->app-configuration-entry
  "Constructor.

  Default constructor for this class.

    This entry represents a single LoginModule
   entry configured for the application specified in the
   getAppConfigurationEntry(String appName)
   method from the Configuration class.

  login-module-name - String representing the class name of the LoginModule configured for the specified application. - `java.lang.String`
  control-flag - either REQUIRED, REQUISITE, SUFFICIENT, or OPTIONAL. - `javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag`
  options - the options configured for this LoginModule. - `java.util.Map<java.lang.String,?>`

  throws: java.lang.IllegalArgumentException - if loginModuleName is null, if LoginModuleName has a length of 0, if controlFlag is not either REQUIRED, REQUISITE, SUFFICIENT or OPTIONAL, or if options is null."
  ([login-module-name control-flag options]
    (new AppConfigurationEntry login-module-name control-flag options)))

(defn get-login-module-name
  "Get the class name of the configured LoginModule.

  returns: the class name of the configured LoginModule as
            a String. - `java.lang.String`"
  ([this]
    (-> this (.getLoginModuleName))))

(defn get-control-flag
  "Return the controlFlag
   (either REQUIRED, REQUISITE, SUFFICIENT, or OPTIONAL)
   for this LoginModule.

  returns: the controlFlag
            (either REQUIRED, REQUISITE, SUFFICIENT, or OPTIONAL)
            for this LoginModule. - `javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag`"
  ([this]
    (-> this (.getControlFlag))))

(defn get-options
  "Get the options configured for this LoginModule.

  returns: the options configured for this LoginModule
            as an unmodifiable Map. - `java.util.Map<java.lang.String,?>`"
  ([this]
    (-> this (.getOptions))))

