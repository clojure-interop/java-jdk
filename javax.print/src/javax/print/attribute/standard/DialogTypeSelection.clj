(ns javax.print.attribute.standard.DialogTypeSelection
  "Class DialogTypeSelection is a printing attribute class, an enumeration,
  that indicates the user dialog type to be used for specifying
  printing options.
  If NATIVE is specified, then where available, a native
  platform dialog is displayed.
  If COMMON is specified, a cross-platform print dialog is displayed.

  This option to specify a native dialog for use with an IPP attribute
  set provides a standard way to reflect back of the setting and option
  changes made by a user to the calling application, and integrates
  the native dialog into the Java printing APIs.
  But note that some options and settings in a native dialog may not
  necessarily map to IPP attributes as they may be non-standard platform,
  or even printer specific options.

  IPP Compatibility: This is not an IPP attribute."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard DialogTypeSelection]))

(def *-native
  "Static Constant.

  type: javax.print.attribute.standard.DialogTypeSelection"
  DialogTypeSelection/NATIVE)

(def *-common
  "Static Constant.

  type: javax.print.attribute.standard.DialogTypeSelection"
  DialogTypeSelection/COMMON)

(defn get-category
  "Get the printing attribute class which is to be used as the \"category\"
   for this printing attribute value.

   For class DialogTypeSelection the category is class
   DialogTypeSelection itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class`"
  (^java.lang.Class [^DialogTypeSelection this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class DialogTypeSelection the category name is
   \"dialog-type-selection\".

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^DialogTypeSelection this]
    (-> this (.getName))))

