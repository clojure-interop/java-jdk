(ns jdk.awt.PageAttributes
  "A set of attributes which control the output of a printed page.

  Instances of this class control the color state, paper size (media type),
  orientation, logical origin, print quality, and resolution of every
  page which uses the instance. Attribute names are compliant with the
  Internet Printing Protocol (IPP) 1.1 where possible. Attribute values
  are partially compliant where possible.

  To use a method which takes an inner class type, pass a reference to
  one of the constant fields of the inner class. Client code cannot create
  new instances of the inner class types because none of those classes
  has a public constructor. For example, to set the color state to
  monochrome, use the following code:


  import java.awt.PageAttributes;

  public class MonochromeExample {
      public void setMonochrome(PageAttributes pageAttributes) {
          pageAttributes.setColor(PageAttributes.ColorType.MONOCHROME);
      }
  }

  Every IPP attribute which supports an attributeName-default value
  has a corresponding setattributeNameToDefault method.
  Default value fields are not provided."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt PageAttributes]))

(defn ->page-attributes
  "Constructor.

  Constructs a PageAttributes instance with the specified values for
   every attribute.

  color - ColorType.COLOR or ColorType.MONOCHROME. - `java.awt.PageAttributes.ColorType`
  media - one of the constant fields of the MediaType class. - `java.awt.PageAttributes.MediaType`
  orientation-requested - OrientationRequestedType.PORTRAIT or OrientationRequestedType.LANDSCAPE. - `java.awt.PageAttributes.OrientationRequestedType`
  origin - OriginType.PHYSICAL or OriginType.PRINTABLE - `java.awt.PageAttributes.OriginType`
  print-quality - PrintQualityType.DRAFT, PrintQualityType.NORMAL, or PrintQualityType.HIGH - `java.awt.PageAttributes.PrintQualityType`
  printer-resolution - an integer array of 3 elements. The first element must be greater than 0. The second element must be must be greater than 0. The third element must be either 3 or 4. - `int[]`

  throws: java.lang.IllegalArgumentException - if one or more of the above conditions is violated."
  ([^java.awt.PageAttributes.ColorType color ^java.awt.PageAttributes.MediaType media ^java.awt.PageAttributes.OrientationRequestedType orientation-requested ^java.awt.PageAttributes.OriginType origin ^java.awt.PageAttributes.PrintQualityType print-quality printer-resolution]
    (new PageAttributes color media orientation-requested origin print-quality printer-resolution))
  ([^java.awt.PageAttributes obj]
    (new PageAttributes obj))
  ([]
    (new PageAttributes )))

(defn set-media-to-default
  "Sets the paper size for pages using these attributes to the default
   size for the default locale. The default size for locales in the
   United States and Canada is MediaType.NA_LETTER. The default size for
   all other locales is MediaType.ISO_A4."
  ([^java.awt.PageAttributes this]
    (-> this (.setMediaToDefault))))

(defn set-origin
  "Specifies whether drawing at (0, 0) to pages using these attributes
   draws at the upper-left corner of the physical page, or at the
   upper-left corner of the printable area. (Note that these locations
   could be equivalent.) Not specifying the property is equivalent to
   specifying OriginType.PHYSICAL.

  origin - OriginType.PHYSICAL or OriginType.PRINTABLE - `java.awt.PageAttributes.OriginType`

  throws: java.lang.IllegalArgumentException - if origin is null."
  ([^java.awt.PageAttributes this ^java.awt.PageAttributes.OriginType origin]
    (-> this (.setOrigin origin))))

(defn set-orientation-requested-to-default
  "Sets the print orientation for pages using these attributes to the
   default. The default orientation is portrait."
  ([^java.awt.PageAttributes this]
    (-> this (.setOrientationRequestedToDefault))))

(defn set-printer-resolution
  "Specifies the desired print resolution for pages using these attributes.
   The actual resolution will be determined by the limitations of the
   implementation and the target printer. Index 0 of the array specifies
   the cross feed direction resolution (typically the horizontal
   resolution). Index 1 of the array specifies the feed direction
   resolution (typically the vertical resolution). Index 2 of the array
   specifies whether the resolutions are in dots per inch or dots per
   centimeter. 3 denotes dots per inch. 4
   denotes dots per centimeter. Note that the 1.1 printing implementation
   (Toolkit.getPrintJob) requires that the feed and cross feed resolutions
   be the same. Not specifying the property is equivalent to calling
   setPrinterResolution(72).

  printer-resolution - an integer array of 3 elements. The first element must be greater than 0. The second element must be must be greater than 0. The third element must be either 3 or 4. - `int[]`

  throws: java.lang.IllegalArgumentException - if one or more of the above conditions is violated."
  ([^java.awt.PageAttributes this printer-resolution]
    (-> this (.setPrinterResolution printer-resolution))))

(defn get-printer-resolution
  "Returns the print resolution for pages using these attributes.
   Index 0 of the array specifies the cross feed direction resolution
   (typically the horizontal resolution). Index 1 of the array specifies
   the feed direction resolution (typically the vertical resolution).
   Index 2 of the array specifies whether the resolutions are in dots per
   inch or dots per centimeter. 3 denotes dots per inch.
   4 denotes dots per centimeter.

  returns: an integer array of 3 elements. The first
            element must be greater than 0. The second element must be
            must be greater than 0. The third element must be either
            3 or 4. - `int[]`"
  ([^java.awt.PageAttributes this]
    (-> this (.getPrinterResolution))))

(defn get-media
  "Returns the paper size for pages using these attributes. This
   attribute is updated to the value chosen by the user.

  returns: one of the constant fields of the MediaType class. - `java.awt.PageAttributes.MediaType`"
  ([^java.awt.PageAttributes this]
    (-> this (.getMedia))))

(defn set-print-quality-to-default
  "Sets the print quality for pages using these attributes to the default.
   The default print quality is normal."
  ([^java.awt.PageAttributes this]
    (-> this (.setPrintQualityToDefault))))

(defn to-string
  "Returns a string representation of this PageAttributes.

  returns: the string representation. - `java.lang.String`"
  ([^java.awt.PageAttributes this]
    (-> this (.toString))))

(defn set-media
  "Specifies the desired paper size for pages using these attributes. The
   actual paper size will be determined by the limitations of the target
   printer. If an exact match cannot be found, an implementation will
   choose the closest possible match. Not specifying this attribute is
   equivalent to specifying the default size for the default locale. The
   default size for locales in the United States and Canada is
   MediaType.NA_LETTER. The default size for all other locales is
   MediaType.ISO_A4.

  media - one of the constant fields of the MediaType class. - `java.awt.PageAttributes.MediaType`

  throws: java.lang.IllegalArgumentException - if media is null."
  ([^java.awt.PageAttributes this ^java.awt.PageAttributes.MediaType media]
    (-> this (.setMedia media))))

(defn get-origin
  "Returns whether drawing at (0, 0) to pages using these attributes
   draws at the upper-left corner of the physical page, or at the
   upper-left corner of the printable area. (Note that these locations
   could be equivalent.) This attribute cannot be modified by,
   and is not subject to any limitations of, the implementation or the
   target printer.

  returns: OriginType.PHYSICAL or OriginType.PRINTABLE - `java.awt.PageAttributes.OriginType`"
  ([^java.awt.PageAttributes this]
    (-> this (.getOrigin))))

(defn get-orientation-requested
  "Returns the print orientation for pages using these attributes. This
   attribute is updated to the value chosen by the user.

  returns: OrientationRequestedType.PORTRAIT or
            OrientationRequestedType.LANDSCAPE. - `java.awt.PageAttributes.OrientationRequestedType`"
  ([^java.awt.PageAttributes this]
    (-> this (.getOrientationRequested))))

(defn set-color
  "Specifies whether pages using these attributes will be rendered in
   color or monochrome. Not specifying this attribute is equivalent to
   specifying ColorType.MONOCHROME.

  color - ColorType.COLOR or ColorType.MONOCHROME. - `java.awt.PageAttributes.ColorType`

  throws: java.lang.IllegalArgumentException - if color is null."
  ([^java.awt.PageAttributes this ^java.awt.PageAttributes.ColorType color]
    (-> this (.setColor color))))

(defn get-print-quality
  "Returns the print quality for pages using these attributes. This
   attribute is updated to the value chosen by the user.

  returns: PrintQualityType.DRAFT, PrintQualityType.NORMAL, or
            PrintQualityType.HIGH - `java.awt.PageAttributes.PrintQualityType`"
  ([^java.awt.PageAttributes this]
    (-> this (.getPrintQuality))))

(defn set-orientation-requested
  "Specifies the print orientation for pages using these attributes. Not
   specifying the property is equivalent to specifying
   OrientationRequestedType.PORTRAIT.

  orientation-requested - OrientationRequestedType.PORTRAIT or OrientationRequestedType.LANDSCAPE. - `java.awt.PageAttributes.OrientationRequestedType`

  throws: java.lang.IllegalArgumentException - if orientationRequested is null."
  ([^java.awt.PageAttributes this ^java.awt.PageAttributes.OrientationRequestedType orientation-requested]
    (-> this (.setOrientationRequested orientation-requested))))

(defn clone
  "Creates and returns a copy of this PageAttributes.

  returns: the newly created copy. It is safe to cast this Object into
            a PageAttributes. - `java.lang.Object`"
  ([^java.awt.PageAttributes this]
    (-> this (.clone))))

(defn hash-code
  "Returns a hash code value for this PageAttributes.

  returns: the hash code. - `int`"
  ([^java.awt.PageAttributes this]
    (-> this (.hashCode))))

(defn set
  "Sets all of the attributes of this PageAttributes to the same values as
   the attributes of obj.

  obj - the PageAttributes to copy. - `java.awt.PageAttributes`"
  ([^java.awt.PageAttributes this ^java.awt.PageAttributes obj]
    (-> this (.set obj))))

(defn set-print-quality
  "Specifies the print quality for pages using these attributes. Not
   specifying the property is equivalent to specifying
   PrintQualityType.NORMAL.

  print-quality - PrintQualityType.DRAFT, PrintQualityType.NORMAL, or PrintQualityType.HIGH - `java.awt.PageAttributes.PrintQualityType`

  throws: java.lang.IllegalArgumentException - if printQuality is null."
  ([^java.awt.PageAttributes this ^java.awt.PageAttributes.PrintQualityType print-quality]
    (-> this (.setPrintQuality print-quality))))

(defn get-color
  "Returns whether pages using these attributes will be rendered in
   color or monochrome. This attribute is updated to the value chosen
   by the user.

  returns: ColorType.COLOR or ColorType.MONOCHROME. - `java.awt.PageAttributes.ColorType`"
  ([^java.awt.PageAttributes this]
    (-> this (.getColor))))

(defn set-printer-resolution-to-default
  "Sets the printer resolution for pages using these attributes to the
   default. The default is 72 dpi for both the feed and cross feed
   resolutions."
  ([^java.awt.PageAttributes this]
    (-> this (.setPrinterResolutionToDefault))))

(defn equals
  "Determines whether two PageAttributes are equal to each other.

   Two PageAttributes are equal if and only if each of their attributes are
   equal. Attributes of enumeration type are equal if and only if the
   fields refer to the same unique enumeration object. This means that
   an aliased media is equal to its underlying unique media. Printer
   resolutions are equal if and only if the feed resolution, cross feed
   resolution, and units are equal.

  obj - the object whose equality will be checked. - `java.lang.Object`

  returns: whether obj is equal to this PageAttribute according to the
            above criteria. - `boolean`"
  ([^java.awt.PageAttributes this ^java.lang.Object obj]
    (-> this (.equals obj))))

