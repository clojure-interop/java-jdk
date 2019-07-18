(ns javax.print.attribute.standard.RequestingUserName
  "Class RequestingUserName is a printing attribute class, a text attribute,
  that specifies the name of the end user that submitted the print job. A
  requesting user name is an arbitrary string defined by the client. The
  printer does not put the client-specified RequestingUserName attribute into
  the Print Job's attribute set; rather, the printer puts in a JobOriginatingUserName attribute.
  This means that services which support specifying a username with this
  attribute should also report a JobOriginatingUserName in the job's
  attribute set. Note that many print services may have a way to independently
  authenticate the user name, and so may state support for a
  requesting user name, but in practice will then report the user name
  authenticated by the service rather than that specified via this
  attribute.

  IPP Compatibility: The string value gives the IPP name value. The
  locale gives the IPP natural language. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard RequestingUserName]))

(defn ->requesting-user-name
  "Constructor.

  Constructs a new requesting user name attribute with the given user
   name and locale.

  user-name - User name. - `java.lang.String`
  locale - Natural language of the text string. null is interpreted to mean the default locale as returned by Locale.getDefault() - `java.util.Locale`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if userName is null."
  (^RequestingUserName [^java.lang.String user-name ^java.util.Locale locale]
    (new RequestingUserName user-name locale)))

(defn equals
  "Returns whether this requesting user name attribute is equivalent to
   the passed in object. To be equivalent, all of the following
   conditions must be true:


   object is not null.

   object is an instance of class RequestingUserName.

   This requesting user name attribute's underlying string and
   object's underlying string are equal.

   This requesting user name attribute's locale and
   object's locale are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this requesting
            user name attribute, false otherwise. - `boolean`"
  (^Boolean [^RequestingUserName this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class RequestingUserName, the
   category is class RequestingUserName itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^RequestingUserName this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class RequestingUserName, the
   category name is `requesting-user-name`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^RequestingUserName this]
    (-> this (.getName))))

