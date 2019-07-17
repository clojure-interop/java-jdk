(ns javax.print.attribute.standard.OutputDeviceAssigned
  "Class OutputDeviceAssigned is a printing attribute class, a text attribute,
  that identifies the output device to which the service has assigned this
  job. If an output device implements an embedded Print Service instance, the
  printer need not set this attribute. If a print server implements a
  Print Service instance, the value may be empty (zero- length string) or not
  returned until the service assigns an output device to the job. This
  attribute is particularly useful when a single service supports multiple
  devices (so called `fan-out`).

  IPP Compatibility: The string value gives the IPP name value. The
  locale gives the IPP natural language. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard OutputDeviceAssigned]))

(defn ->output-device-assigned
  "Constructor.

  Constructs a new output device assigned attribute with the given device
   name and locale.

  device-name - Device name. - `java.lang.String`
  locale - Natural language of the text string. null is interpreted to mean the default locale as returned by Locale.getDefault() - `java.util.Locale`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if deviceName is null."
  ([^java.lang.String device-name ^java.util.Locale locale]
    (new OutputDeviceAssigned device-name locale)))

(defn equals
  "Returns whether this output device assigned attribute is equivalent to
   the passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class OutputDeviceAssigned.

   This output device assigned attribute's underlying string and
   object's underlying string are equal.

   This output device assigned attribute's locale and
   object's locale are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this output
            device assigned attribute, false otherwise. - `boolean`"
  (^Boolean [^javax.print.attribute.standard.OutputDeviceAssigned this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class OutputDeviceAssigned, the
   category is class OutputDeviceAssigned itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.OutputDeviceAssigned this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class OutputDeviceAssigned, the
   category name is `output-device-assigned`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.standard.OutputDeviceAssigned this]
    (-> this (.getName))))

