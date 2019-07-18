(ns javax.security.auth.login.AppConfigurationEntry$LoginModuleControlFlag
  "This class represents whether or not a LoginModule
  is REQUIRED, REQUISITE, SUFFICIENT or OPTIONAL."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login AppConfigurationEntry$LoginModuleControlFlag]))

(def *-required
  "Static Constant.

  Required LoginModule.

  type: javax.security.auth.login.AppConfigurationEntry$LoginModuleControlFlag"
  AppConfigurationEntry$LoginModuleControlFlag/REQUIRED)

(def *-requisite
  "Static Constant.

  Requisite LoginModule.

  type: javax.security.auth.login.AppConfigurationEntry$LoginModuleControlFlag"
  AppConfigurationEntry$LoginModuleControlFlag/REQUISITE)

(def *-sufficient
  "Static Constant.

  Sufficient LoginModule.

  type: javax.security.auth.login.AppConfigurationEntry$LoginModuleControlFlag"
  AppConfigurationEntry$LoginModuleControlFlag/SUFFICIENT)

(def *-optional
  "Static Constant.

  Optional LoginModule.

  type: javax.security.auth.login.AppConfigurationEntry$LoginModuleControlFlag"
  AppConfigurationEntry$LoginModuleControlFlag/OPTIONAL)

(defn to-string
  "Return a String representation of this controlFlag.

    The String has the format, `LoginModuleControlFlag: flag`,
   where flag is either required, requisite,
   sufficient, or optional.

  returns: a String representation of this controlFlag. - `java.lang.String`"
  (^java.lang.String [^AppConfigurationEntry$LoginModuleControlFlag this]
    (-> this (.toString))))

