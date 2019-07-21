(ns jdk.awt.color.ICC_Profile
  "A representation of color profile data for device independent and
  device dependent color spaces based on the International Color
  Consortium Specification ICC.1:2001-12, File Format for Color Profiles,
  (see  http://www.color.org).

  An ICC_ColorSpace object can be constructed from an appropriate
  ICC_Profile.
  Typically, an ICC_ColorSpace would be associated with an ICC
  Profile which is either an input, display, or output profile (see
  the ICC specification).  There are also device link, abstract,
  color space conversion, and named color profiles.  These are less
  useful for tagging a color or image, but are useful for other
  purposes (in particular device link profiles can provide improved
  performance for converting from one device's color space to
  another's).

  ICC Profiles represent transformations from the color space of
  the profile (e.g. a monitor) to a Profile Connection Space (PCS).
  Profiles of interest for tagging images or colors have a PCS
  which is one of the two specific device independent
  spaces (one CIEXYZ space and one CIELab space) defined in the
  ICC Profile Format Specification.  Most profiles of interest
  either have invertible transformations or explicitly specify
  transformations going both directions."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.color ICC_Profile]))

(def *-class-input
  "Static Constant.

  Profile class is input.

  type: int"
  ICC_Profile/CLASS_INPUT)

(def *-class-display
  "Static Constant.

  Profile class is display.

  type: int"
  ICC_Profile/CLASS_DISPLAY)

(def *-class-output
  "Static Constant.

  Profile class is output.

  type: int"
  ICC_Profile/CLASS_OUTPUT)

(def *-class-devicelink
  "Static Constant.

  Profile class is device link.

  type: int"
  ICC_Profile/CLASS_DEVICELINK)

(def *-class-colorspaceconversion
  "Static Constant.

  Profile class is color space conversion.

  type: int"
  ICC_Profile/CLASS_COLORSPACECONVERSION)

(def *-class-abstract
  "Static Constant.

  Profile class is abstract.

  type: int"
  ICC_Profile/CLASS_ABSTRACT)

(def *-class-namedcolor
  "Static Constant.

  Profile class is named color.

  type: int"
  ICC_Profile/CLASS_NAMEDCOLOR)

(def *-ic-sig-xyz-data
  "Static Constant.

  ICC Profile Color Space Type Signature: 'XYZ '.

  type: int"
  ICC_Profile/icSigXYZData)

(def *-ic-sig-lab-data
  "Static Constant.

  ICC Profile Color Space Type Signature: 'Lab '.

  type: int"
  ICC_Profile/icSigLabData)

(def *-ic-sig-luv-data
  "Static Constant.

  ICC Profile Color Space Type Signature: 'Luv '.

  type: int"
  ICC_Profile/icSigLuvData)

(def *-ic-sig-y-cb-cr-data
  "Static Constant.

  ICC Profile Color Space Type Signature: 'YCbr'.

  type: int"
  ICC_Profile/icSigYCbCrData)

(def *-ic-sig-yxy-data
  "Static Constant.

  ICC Profile Color Space Type Signature: 'Yxy '.

  type: int"
  ICC_Profile/icSigYxyData)

(def *-ic-sig-rgb-data
  "Static Constant.

  ICC Profile Color Space Type Signature: 'RGB '.

  type: int"
  ICC_Profile/icSigRgbData)

(def *-ic-sig-gray-data
  "Static Constant.

  ICC Profile Color Space Type Signature: 'GRAY'.

  type: int"
  ICC_Profile/icSigGrayData)

(def *-ic-sig-hsv-data
  "Static Constant.

  ICC Profile Color Space Type Signature: 'HSV'.

  type: int"
  ICC_Profile/icSigHsvData)

(def *-ic-sig-hls-data
  "Static Constant.

  ICC Profile Color Space Type Signature: 'HLS'.

  type: int"
  ICC_Profile/icSigHlsData)

(def *-ic-sig-cmyk-data
  "Static Constant.

  ICC Profile Color Space Type Signature: 'CMYK'.

  type: int"
  ICC_Profile/icSigCmykData)

(def *-ic-sig-cmy-data
  "Static Constant.

  ICC Profile Color Space Type Signature: 'CMY '.

  type: int"
  ICC_Profile/icSigCmyData)

(def *-ic-sig-space-2-clr
  "Static Constant.

  ICC Profile Color Space Type Signature: '2CLR'.

  type: int"
  ICC_Profile/icSigSpace2CLR)

(def *-ic-sig-space-3-clr
  "Static Constant.

  ICC Profile Color Space Type Signature: '3CLR'.

  type: int"
  ICC_Profile/icSigSpace3CLR)

(def *-ic-sig-space-4-clr
  "Static Constant.

  ICC Profile Color Space Type Signature: '4CLR'.

  type: int"
  ICC_Profile/icSigSpace4CLR)

(def *-ic-sig-space-5-clr
  "Static Constant.

  ICC Profile Color Space Type Signature: '5CLR'.

  type: int"
  ICC_Profile/icSigSpace5CLR)

(def *-ic-sig-space-6-clr
  "Static Constant.

  ICC Profile Color Space Type Signature: '6CLR'.

  type: int"
  ICC_Profile/icSigSpace6CLR)

(def *-ic-sig-space-7-clr
  "Static Constant.

  ICC Profile Color Space Type Signature: '7CLR'.

  type: int"
  ICC_Profile/icSigSpace7CLR)

(def *-ic-sig-space-8-clr
  "Static Constant.

  ICC Profile Color Space Type Signature: '8CLR'.

  type: int"
  ICC_Profile/icSigSpace8CLR)

(def *-ic-sig-space-9-clr
  "Static Constant.

  ICC Profile Color Space Type Signature: '9CLR'.

  type: int"
  ICC_Profile/icSigSpace9CLR)

(def *-ic-sig-space-aclr
  "Static Constant.

  ICC Profile Color Space Type Signature: 'ACLR'.

  type: int"
  ICC_Profile/icSigSpaceACLR)

(def *-ic-sig-space-bclr
  "Static Constant.

  ICC Profile Color Space Type Signature: 'BCLR'.

  type: int"
  ICC_Profile/icSigSpaceBCLR)

(def *-ic-sig-space-cclr
  "Static Constant.

  ICC Profile Color Space Type Signature: 'CCLR'.

  type: int"
  ICC_Profile/icSigSpaceCCLR)

(def *-ic-sig-space-dclr
  "Static Constant.

  ICC Profile Color Space Type Signature: 'DCLR'.

  type: int"
  ICC_Profile/icSigSpaceDCLR)

(def *-ic-sig-space-eclr
  "Static Constant.

  ICC Profile Color Space Type Signature: 'ECLR'.

  type: int"
  ICC_Profile/icSigSpaceECLR)

(def *-ic-sig-space-fclr
  "Static Constant.

  ICC Profile Color Space Type Signature: 'FCLR'.

  type: int"
  ICC_Profile/icSigSpaceFCLR)

(def *-ic-sig-input-class
  "Static Constant.

  ICC Profile Class Signature: 'scnr'.

  type: int"
  ICC_Profile/icSigInputClass)

(def *-ic-sig-display-class
  "Static Constant.

  ICC Profile Class Signature: 'mntr'.

  type: int"
  ICC_Profile/icSigDisplayClass)

(def *-ic-sig-output-class
  "Static Constant.

  ICC Profile Class Signature: 'prtr'.

  type: int"
  ICC_Profile/icSigOutputClass)

(def *-ic-sig-link-class
  "Static Constant.

  ICC Profile Class Signature: 'link'.

  type: int"
  ICC_Profile/icSigLinkClass)

(def *-ic-sig-abstract-class
  "Static Constant.

  ICC Profile Class Signature: 'abst'.

  type: int"
  ICC_Profile/icSigAbstractClass)

(def *-ic-sig-color-space-class
  "Static Constant.

  ICC Profile Class Signature: 'spac'.

  type: int"
  ICC_Profile/icSigColorSpaceClass)

(def *-ic-sig-named-color-class
  "Static Constant.

  ICC Profile Class Signature: 'nmcl'.

  type: int"
  ICC_Profile/icSigNamedColorClass)

(def *-ic-perceptual
  "Static Constant.

  ICC Profile Rendering Intent: Perceptual.

  type: int"
  ICC_Profile/icPerceptual)

(def *-ic-relative-colorimetric
  "Static Constant.

  ICC Profile Rendering Intent: RelativeColorimetric.

  type: int"
  ICC_Profile/icRelativeColorimetric)

(def *-ic-media-relative-colorimetric
  "Static Constant.

  ICC Profile Rendering Intent: Media-RelativeColorimetric.

  type: int"
  ICC_Profile/icMediaRelativeColorimetric)

(def *-ic-saturation
  "Static Constant.

  ICC Profile Rendering Intent: Saturation.

  type: int"
  ICC_Profile/icSaturation)

(def *-ic-absolute-colorimetric
  "Static Constant.

  ICC Profile Rendering Intent: AbsoluteColorimetric.

  type: int"
  ICC_Profile/icAbsoluteColorimetric)

(def *-ic-icc-absolute-colorimetric
  "Static Constant.

  ICC Profile Rendering Intent: ICC-AbsoluteColorimetric.

  type: int"
  ICC_Profile/icICCAbsoluteColorimetric)

(def *-ic-sig-head
  "Static Constant.

  ICC Profile Tag Signature: 'head' - special.

  type: int"
  ICC_Profile/icSigHead)

(def *-ic-sig-a-to-b-0-tag
  "Static Constant.

  ICC Profile Tag Signature: 'A2B0'.

  type: int"
  ICC_Profile/icSigAToB0Tag)

(def *-ic-sig-a-to-b-1-tag
  "Static Constant.

  ICC Profile Tag Signature: 'A2B1'.

  type: int"
  ICC_Profile/icSigAToB1Tag)

(def *-ic-sig-a-to-b-2-tag
  "Static Constant.

  ICC Profile Tag Signature: 'A2B2'.

  type: int"
  ICC_Profile/icSigAToB2Tag)

(def *-ic-sig-blue-colorant-tag
  "Static Constant.

  ICC Profile Tag Signature: 'bXYZ'.

  type: int"
  ICC_Profile/icSigBlueColorantTag)

(def *-ic-sig-blue-matrix-column-tag
  "Static Constant.

  ICC Profile Tag Signature: 'bXYZ'.

  type: int"
  ICC_Profile/icSigBlueMatrixColumnTag)

(def *-ic-sig-blue-trc-tag
  "Static Constant.

  ICC Profile Tag Signature: 'bTRC'.

  type: int"
  ICC_Profile/icSigBlueTRCTag)

(def *-ic-sig-b-to-a-0-tag
  "Static Constant.

  ICC Profile Tag Signature: 'B2A0'.

  type: int"
  ICC_Profile/icSigBToA0Tag)

(def *-ic-sig-b-to-a-1-tag
  "Static Constant.

  ICC Profile Tag Signature: 'B2A1'.

  type: int"
  ICC_Profile/icSigBToA1Tag)

(def *-ic-sig-b-to-a-2-tag
  "Static Constant.

  ICC Profile Tag Signature: 'B2A2'.

  type: int"
  ICC_Profile/icSigBToA2Tag)

(def *-ic-sig-calibration-date-time-tag
  "Static Constant.

  ICC Profile Tag Signature: 'calt'.

  type: int"
  ICC_Profile/icSigCalibrationDateTimeTag)

(def *-ic-sig-char-target-tag
  "Static Constant.

  ICC Profile Tag Signature: 'targ'.

  type: int"
  ICC_Profile/icSigCharTargetTag)

(def *-ic-sig-copyright-tag
  "Static Constant.

  ICC Profile Tag Signature: 'cprt'.

  type: int"
  ICC_Profile/icSigCopyrightTag)

(def *-ic-sig-crd-info-tag
  "Static Constant.

  ICC Profile Tag Signature: 'crdi'.

  type: int"
  ICC_Profile/icSigCrdInfoTag)

(def *-ic-sig-device-mfg-desc-tag
  "Static Constant.

  ICC Profile Tag Signature: 'dmnd'.

  type: int"
  ICC_Profile/icSigDeviceMfgDescTag)

(def *-ic-sig-device-model-desc-tag
  "Static Constant.

  ICC Profile Tag Signature: 'dmdd'.

  type: int"
  ICC_Profile/icSigDeviceModelDescTag)

(def *-ic-sig-device-settings-tag
  "Static Constant.

  ICC Profile Tag Signature: 'devs'.

  type: int"
  ICC_Profile/icSigDeviceSettingsTag)

(def *-ic-sig-gamut-tag
  "Static Constant.

  ICC Profile Tag Signature: 'gamt'.

  type: int"
  ICC_Profile/icSigGamutTag)

(def *-ic-sig-gray-trc-tag
  "Static Constant.

  ICC Profile Tag Signature: 'kTRC'.

  type: int"
  ICC_Profile/icSigGrayTRCTag)

(def *-ic-sig-green-colorant-tag
  "Static Constant.

  ICC Profile Tag Signature: 'gXYZ'.

  type: int"
  ICC_Profile/icSigGreenColorantTag)

(def *-ic-sig-green-matrix-column-tag
  "Static Constant.

  ICC Profile Tag Signature: 'gXYZ'.

  type: int"
  ICC_Profile/icSigGreenMatrixColumnTag)

(def *-ic-sig-green-trc-tag
  "Static Constant.

  ICC Profile Tag Signature: 'gTRC'.

  type: int"
  ICC_Profile/icSigGreenTRCTag)

(def *-ic-sig-luminance-tag
  "Static Constant.

  ICC Profile Tag Signature: 'lumi'.

  type: int"
  ICC_Profile/icSigLuminanceTag)

(def *-ic-sig-measurement-tag
  "Static Constant.

  ICC Profile Tag Signature: 'meas'.

  type: int"
  ICC_Profile/icSigMeasurementTag)

(def *-ic-sig-media-black-point-tag
  "Static Constant.

  ICC Profile Tag Signature: 'bkpt'.

  type: int"
  ICC_Profile/icSigMediaBlackPointTag)

(def *-ic-sig-media-white-point-tag
  "Static Constant.

  ICC Profile Tag Signature: 'wtpt'.

  type: int"
  ICC_Profile/icSigMediaWhitePointTag)

(def *-ic-sig-named-color-2-tag
  "Static Constant.

  ICC Profile Tag Signature: 'ncl2'.

  type: int"
  ICC_Profile/icSigNamedColor2Tag)

(def *-ic-sig-output-response-tag
  "Static Constant.

  ICC Profile Tag Signature: 'resp'.

  type: int"
  ICC_Profile/icSigOutputResponseTag)

(def *-ic-sig-preview-0-tag
  "Static Constant.

  ICC Profile Tag Signature: 'pre0'.

  type: int"
  ICC_Profile/icSigPreview0Tag)

(def *-ic-sig-preview-1-tag
  "Static Constant.

  ICC Profile Tag Signature: 'pre1'.

  type: int"
  ICC_Profile/icSigPreview1Tag)

(def *-ic-sig-preview-2-tag
  "Static Constant.

  ICC Profile Tag Signature: 'pre2'.

  type: int"
  ICC_Profile/icSigPreview2Tag)

(def *-ic-sig-profile-description-tag
  "Static Constant.

  ICC Profile Tag Signature: 'desc'.

  type: int"
  ICC_Profile/icSigProfileDescriptionTag)

(def *-ic-sig-profile-sequence-desc-tag
  "Static Constant.

  ICC Profile Tag Signature: 'pseq'.

  type: int"
  ICC_Profile/icSigProfileSequenceDescTag)

(def *-ic-sig-ps-2-crd-0-tag
  "Static Constant.

  ICC Profile Tag Signature: 'psd0'.

  type: int"
  ICC_Profile/icSigPs2CRD0Tag)

(def *-ic-sig-ps-2-crd-1-tag
  "Static Constant.

  ICC Profile Tag Signature: 'psd1'.

  type: int"
  ICC_Profile/icSigPs2CRD1Tag)

(def *-ic-sig-ps-2-crd-2-tag
  "Static Constant.

  ICC Profile Tag Signature: 'psd2'.

  type: int"
  ICC_Profile/icSigPs2CRD2Tag)

(def *-ic-sig-ps-2-crd-3-tag
  "Static Constant.

  ICC Profile Tag Signature: 'psd3'.

  type: int"
  ICC_Profile/icSigPs2CRD3Tag)

(def *-ic-sig-ps-2-csa-tag
  "Static Constant.

  ICC Profile Tag Signature: 'ps2s'.

  type: int"
  ICC_Profile/icSigPs2CSATag)

(def *-ic-sig-ps-2-rendering-intent-tag
  "Static Constant.

  ICC Profile Tag Signature: 'ps2i'.

  type: int"
  ICC_Profile/icSigPs2RenderingIntentTag)

(def *-ic-sig-red-colorant-tag
  "Static Constant.

  ICC Profile Tag Signature: 'rXYZ'.

  type: int"
  ICC_Profile/icSigRedColorantTag)

(def *-ic-sig-red-matrix-column-tag
  "Static Constant.

  ICC Profile Tag Signature: 'rXYZ'.

  type: int"
  ICC_Profile/icSigRedMatrixColumnTag)

(def *-ic-sig-red-trc-tag
  "Static Constant.

  ICC Profile Tag Signature: 'rTRC'.

  type: int"
  ICC_Profile/icSigRedTRCTag)

(def *-ic-sig-screening-desc-tag
  "Static Constant.

  ICC Profile Tag Signature: 'scrd'.

  type: int"
  ICC_Profile/icSigScreeningDescTag)

(def *-ic-sig-screening-tag
  "Static Constant.

  ICC Profile Tag Signature: 'scrn'.

  type: int"
  ICC_Profile/icSigScreeningTag)

(def *-ic-sig-technology-tag
  "Static Constant.

  ICC Profile Tag Signature: 'tech'.

  type: int"
  ICC_Profile/icSigTechnologyTag)

(def *-ic-sig-ucr-bg-tag
  "Static Constant.

  ICC Profile Tag Signature: 'bfd '.

  type: int"
  ICC_Profile/icSigUcrBgTag)

(def *-ic-sig-viewing-cond-desc-tag
  "Static Constant.

  ICC Profile Tag Signature: 'vued'.

  type: int"
  ICC_Profile/icSigViewingCondDescTag)

(def *-ic-sig-viewing-conditions-tag
  "Static Constant.

  ICC Profile Tag Signature: 'view'.

  type: int"
  ICC_Profile/icSigViewingConditionsTag)

(def *-ic-sig-chromaticity-tag
  "Static Constant.

  ICC Profile Tag Signature: 'chrm'.

  type: int"
  ICC_Profile/icSigChromaticityTag)

(def *-ic-sig-chromatic-adaptation-tag
  "Static Constant.

  ICC Profile Tag Signature: 'chad'.

  type: int"
  ICC_Profile/icSigChromaticAdaptationTag)

(def *-ic-sig-colorant-order-tag
  "Static Constant.

  ICC Profile Tag Signature: 'clro'.

  type: int"
  ICC_Profile/icSigColorantOrderTag)

(def *-ic-sig-colorant-table-tag
  "Static Constant.

  ICC Profile Tag Signature: 'clrt'.

  type: int"
  ICC_Profile/icSigColorantTableTag)

(def *-ic-hdr-size
  "Static Constant.

  ICC Profile Header Location: profile size in bytes.

  type: int"
  ICC_Profile/icHdrSize)

(def *-ic-hdr-cmm-id
  "Static Constant.

  ICC Profile Header Location: CMM for this profile.

  type: int"
  ICC_Profile/icHdrCmmId)

(def *-ic-hdr-version
  "Static Constant.

  ICC Profile Header Location: format version number.

  type: int"
  ICC_Profile/icHdrVersion)

(def *-ic-hdr-device-class
  "Static Constant.

  ICC Profile Header Location: type of profile.

  type: int"
  ICC_Profile/icHdrDeviceClass)

(def *-ic-hdr-color-space
  "Static Constant.

  ICC Profile Header Location: color space of data.

  type: int"
  ICC_Profile/icHdrColorSpace)

(def *-ic-hdr-pcs
  "Static Constant.

  ICC Profile Header Location: PCS - XYZ or Lab only.

  type: int"
  ICC_Profile/icHdrPcs)

(def *-ic-hdr-date
  "Static Constant.

  ICC Profile Header Location: date profile was created.

  type: int"
  ICC_Profile/icHdrDate)

(def *-ic-hdr-magic
  "Static Constant.

  ICC Profile Header Location: icMagicNumber.

  type: int"
  ICC_Profile/icHdrMagic)

(def *-ic-hdr-platform
  "Static Constant.

  ICC Profile Header Location: primary platform.

  type: int"
  ICC_Profile/icHdrPlatform)

(def *-ic-hdr-flags
  "Static Constant.

  ICC Profile Header Location: various bit settings.

  type: int"
  ICC_Profile/icHdrFlags)

(def *-ic-hdr-manufacturer
  "Static Constant.

  ICC Profile Header Location: device manufacturer.

  type: int"
  ICC_Profile/icHdrManufacturer)

(def *-ic-hdr-model
  "Static Constant.

  ICC Profile Header Location: device model number.

  type: int"
  ICC_Profile/icHdrModel)

(def *-ic-hdr-attributes
  "Static Constant.

  ICC Profile Header Location: device attributes.

  type: int"
  ICC_Profile/icHdrAttributes)

(def *-ic-hdr-rendering-intent
  "Static Constant.

  ICC Profile Header Location: rendering intent.

  type: int"
  ICC_Profile/icHdrRenderingIntent)

(def *-ic-hdr-illuminant
  "Static Constant.

  ICC Profile Header Location: profile illuminant.

  type: int"
  ICC_Profile/icHdrIlluminant)

(def *-ic-hdr-creator
  "Static Constant.

  ICC Profile Header Location: profile creator.

  type: int"
  ICC_Profile/icHdrCreator)

(def *-ic-hdr-profile-id
  "Static Constant.

  ICC Profile Header Location: profile's ID.

  type: int"
  ICC_Profile/icHdrProfileID)

(def *-ic-tag-type
  "Static Constant.

  ICC Profile Constant: tag type signaturE.

  type: int"
  ICC_Profile/icTagType)

(def *-ic-tag-reserved
  "Static Constant.

  ICC Profile Constant: reserved.

  type: int"
  ICC_Profile/icTagReserved)

(def *-ic-curve-count
  "Static Constant.

  ICC Profile Constant: curveType count.

  type: int"
  ICC_Profile/icCurveCount)

(def *-ic-curve-data
  "Static Constant.

  ICC Profile Constant: curveType data.

  type: int"
  ICC_Profile/icCurveData)

(def *-ic-xyz-number-x
  "Static Constant.

  ICC Profile Constant: XYZNumber X.

  type: int"
  ICC_Profile/icXYZNumberX)

(defn *get-instance
  "Constructs an ICC_Profile object corresponding to the data in
   a byte array.  Throws an IllegalArgumentException if the data
   does not correspond to a valid ICC Profile.

  data - the specified ICC Profile data - `byte[]`

  returns: an ICC_Profile object corresponding to
            the data in the specified data array. - `java.awt.color.ICC_Profile`"
  (^java.awt.color.ICC_Profile [data]
    (ICC_Profile/getInstance data)))

(defn set-data
  "Sets a particular tagged data element in the profile from
   a byte array. The array should contain data in a format, corresponded
   to the tagSignature as defined in the ICC specification, section 10.
   This method is useful for advanced applets or applications which need to
   access profile data directly.

  tag-signature - The ICC tag signature for the data element you want to set. - `int`
  tag-data - the data to set for the specified tag signature - `byte[]`

  throws: java.lang.IllegalArgumentException - if a content of the tagData array can not be interpreted as valid tag data, corresponding to the tagSignature."
  ([^ICC_Profile this ^Integer tag-signature tag-data]
    (-> this (.setData tag-signature tag-data))))

(defn get-data
  "Returns a particular tagged data element from the profile as
   a byte array.  Elements are identified by signatures
   as defined in the ICC specification.  The signature
   icSigHead can be used to get the header.  This method is useful
   for advanced applets or applications which need to access
   profile data directly.

  tag-signature - The ICC tag signature for the data element you want to get. - `int`

  returns: A byte array that contains the tagged data element. Returns
   null if the specified tag doesn't exist. - `byte[]`"
  ([^ICC_Profile this ^Integer tag-signature]
    (-> this (.getData tag-signature)))
  ([^ICC_Profile this]
    (-> this (.getData))))

(defn get-minor-version
  "Returns profile minor version.

  returns: The minor version of the profile. - `int`"
  (^Integer [^ICC_Profile this]
    (-> this (.getMinorVersion))))

(defn get-profile-class
  "Returns the profile class.

  returns: One of the predefined profile class constants. - `int`"
  (^Integer [^ICC_Profile this]
    (-> this (.getProfileClass))))

(defn get-pcs-type
  "Returns the color space type of the Profile Connection Space (PCS).
   Returns one of the color space type constants defined by the
   ColorSpace class.  This is the \"output\" color space of the
   profile.  For an input, display, or output profile useful
   for tagging colors or images, this will be either TYPE_XYZ or
   TYPE_Lab and should be interpreted as the corresponding specific
   color space defined in the ICC specification.  For a device
   link profile, this could be any of the color space type constants.

  returns: One of the color space type constants defined in the
   ColorSpace class. - `int`"
  (^Integer [^ICC_Profile this]
    (-> this (.getPCSType))))

(defn get-color-space-type
  "Returns the color space type.  Returns one of the color space type
   constants defined by the ColorSpace class.  This is the
   \"input\" color space of the profile.  The type defines the
   number of components of the color space and the interpretation,
   e.g. TYPE_RGB identifies a color space with three components - red,
   green, and blue.  It does not define the particular color
   characteristics of the space, e.g. the chromaticities of the
   primaries.

  returns: One of the color space type constants defined in the
   ColorSpace class. - `int`"
  (^Integer [^ICC_Profile this]
    (-> this (.getColorSpaceType))))

(defn get-num-components
  "Returns the number of color components in the \"input\" color
   space of this profile.  For example if the color space type
   of this profile is TYPE_RGB, then this method will return 3.

  returns: The number of color components in the profile's input
   color space. - `int`

  throws: java.awt.color.ProfileDataException - if color space is in the profile is invalid"
  (^Integer [^ICC_Profile this]
    (-> this (.getNumComponents))))

(defn get-major-version
  "Returns profile major version.

  returns: The major version of the profile. - `int`"
  (^Integer [^ICC_Profile this]
    (-> this (.getMajorVersion))))

(defn write
  "Write this ICC_Profile to a file.

  file-name - The file to write the profile data to. - `java.lang.String`

  throws: java.io.IOException - If the file cannot be opened for writing or an I/O error occurs while writing to the file."
  ([^ICC_Profile this ^java.lang.String file-name]
    (-> this (.write file-name))))

