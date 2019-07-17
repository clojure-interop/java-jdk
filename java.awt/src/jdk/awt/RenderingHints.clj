(ns jdk.awt.RenderingHints
  "The RenderingHints class defines and manages collections of
  keys and associated values which allow an application to provide input
  into the choice of algorithms used by other classes which perform
  rendering and image manipulation services.
  The Graphics2D class, and classes that implement
  BufferedImageOp and
  RasterOp all provide methods to get and
  possibly to set individual or groups of RenderingHints
  keys and their associated values.
  When those implementations perform any rendering or image manipulation
  operations they should examine the values of any RenderingHints
  that were requested by the caller and tailor the algorithms used
  accordingly and to the best of their ability.

  Note that since these keys and values are hints, there is
  no requirement that a given implementation supports all possible
  choices indicated below or that it can respond to requests to
  modify its choice of algorithm.
  The values of the various hint keys may also interact such that
  while all variants of a given key are supported in one situation,
  the implementation may be more restricted when the values associated
  with other keys are modified.
  For example, some implementations may be able to provide several
  types of dithering when the antialiasing hint is turned off, but
  have little control over dithering when antialiasing is on.
  The full set of supported keys and hints may also vary by destination
  since runtimes may use different underlying modules to render to
  the screen, or to BufferedImage objects,
  or while printing.

  Implementations are free to ignore the hints completely, but should
  try to use an implementation algorithm that is as close as possible
  to the request.
  If an implementation supports a given algorithm when any value is used
  for an associated hint key, then minimally it must do so when the
  value for that key is the exact value that specifies the algorithm.

  The keys used to control the hints are all special values that
  subclass the associated RenderingHints.Key class.
  Many common hints are expressed below as static constants in this
  class, but the list is not meant to be exhaustive.
  Other hints may be created by other packages by defining new objects
  which subclass the Key class and defining the associated values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt RenderingHints]))

(defn ->rendering-hints
  "Constructor.

  Constructs a new object with the specified key/value pair.

  key - the key of the particular hint property - `java.awt.RenderingHints.Key`
  value - the value of the hint property specified with key - `java.lang.Object`"
  ([^java.awt.RenderingHints.Key key ^java.lang.Object value]
    (new RenderingHints key value))
  ([^java.util.Map init]
    (new RenderingHints init)))

(def *-key-antialiasing
  "Static Constant.

  Antialiasing hint key.
   The ANTIALIASING hint controls whether or not the
   geometry rendering methods of a Graphics2D object
   will attempt to reduce aliasing artifacts along the edges
   of shapes.

   A typical antialiasing algorithm works by blending the existing
   colors of the pixels along the boundary of a shape with the
   requested fill paint according to the estimated partial pixel
   coverage of the shape.

   The allowable values for this hint are

   VALUE_ANTIALIAS_ON
   VALUE_ANTIALIAS_OFF
   VALUE_ANTIALIAS_DEFAULT

  type: java.awt.RenderingHints.Key"
  RenderingHints/KEY_ANTIALIASING)

(def *-value-antialias-on
  "Static Constant.

  Antialiasing hint value -- rendering is done with antialiasing.

  type: java.lang.Object"
  RenderingHints/VALUE_ANTIALIAS_ON)

(def *-value-antialias-off
  "Static Constant.

  Antialiasing hint value -- rendering is done without antialiasing.

  type: java.lang.Object"
  RenderingHints/VALUE_ANTIALIAS_OFF)

(def *-value-antialias-default
  "Static Constant.

  Antialiasing hint value -- rendering is done with a default
   antialiasing mode chosen by the implementation.

  type: java.lang.Object"
  RenderingHints/VALUE_ANTIALIAS_DEFAULT)

(def *-key-rendering
  "Static Constant.

  Rendering hint key.
   The RENDERING hint is a general hint that provides
   a high level recommendation as to whether to bias algorithm
   choices more for speed or quality when evaluating tradeoffs.
   This hint could be consulted for any rendering or image
   manipulation operation, but decisions will usually honor
   other, more specific hints in preference to this hint.

   The allowable values for this hint are

   VALUE_RENDER_SPEED
   VALUE_RENDER_QUALITY
   VALUE_RENDER_DEFAULT

  type: java.awt.RenderingHints.Key"
  RenderingHints/KEY_RENDERING)

(def *-value-render-speed
  "Static Constant.

  Rendering hint value -- rendering algorithms are chosen
   with a preference for output speed.

  type: java.lang.Object"
  RenderingHints/VALUE_RENDER_SPEED)

(def *-value-render-quality
  "Static Constant.

  Rendering hint value -- rendering algorithms are chosen
   with a preference for output quality.

  type: java.lang.Object"
  RenderingHints/VALUE_RENDER_QUALITY)

(def *-value-render-default
  "Static Constant.

  Rendering hint value -- rendering algorithms are chosen
   by the implementation for a good tradeoff of performance
   vs. quality.

  type: java.lang.Object"
  RenderingHints/VALUE_RENDER_DEFAULT)

(def *-key-dithering
  "Static Constant.

  Dithering hint key.
   The DITHERING hint controls how closely to approximate
   a color when storing into a destination with limited color
   resolution.

   Some rendering destinations may support a limited number of
   color choices which may not be able to accurately represent
   the full spectrum of colors that can result during rendering
   operations.
   For such a destination the DITHERING hint controls
   whether rendering is done with a flat solid fill of a single
   pixel value which is the closest supported color to what was
   requested, or whether shapes will be filled with a pattern of
   colors which combine to better approximate that color.

   The allowable values for this hint are

   VALUE_DITHER_DISABLE
   VALUE_DITHER_ENABLE
   VALUE_DITHER_DEFAULT

  type: java.awt.RenderingHints.Key"
  RenderingHints/KEY_DITHERING)

(def *-value-dither-disable
  "Static Constant.

  Dithering hint value -- do not dither when rendering geometry.

  type: java.lang.Object"
  RenderingHints/VALUE_DITHER_DISABLE)

(def *-value-dither-enable
  "Static Constant.

  Dithering hint value -- dither when rendering geometry, if needed.

  type: java.lang.Object"
  RenderingHints/VALUE_DITHER_ENABLE)

(def *-value-dither-default
  "Static Constant.

  Dithering hint value -- use a default for dithering chosen by
   the implementation.

  type: java.lang.Object"
  RenderingHints/VALUE_DITHER_DEFAULT)

(def *-key-text-antialiasing
  "Static Constant.

  Text antialiasing hint key.
   The TEXT_ANTIALIASING hint can control the use of
   antialiasing algorithms for text independently of the
   choice used for shape rendering.
   Often an application may want to use antialiasing for text
   only and not for other shapes.
   Additionally, the algorithms for reducing the aliasing
   artifacts for text are often more sophisticated than those
   that have been developed for general rendering so this
   hint key provides additional values which can control
   the choices of some of those text-specific algorithms.
   If left in the DEFAULT state, this hint will
   generally defer to the value of the regular
   KEY_ANTIALIASING hint key.

   The allowable values for this hint are

   VALUE_TEXT_ANTIALIAS_ON
   VALUE_TEXT_ANTIALIAS_OFF
   VALUE_TEXT_ANTIALIAS_DEFAULT
   VALUE_TEXT_ANTIALIAS_GASP
   VALUE_TEXT_ANTIALIAS_LCD_HRGB
   VALUE_TEXT_ANTIALIAS_LCD_HBGR
   VALUE_TEXT_ANTIALIAS_LCD_VRGB
   VALUE_TEXT_ANTIALIAS_LCD_VBGR

  type: java.awt.RenderingHints.Key"
  RenderingHints/KEY_TEXT_ANTIALIASING)

(def *-value-text-antialias-on
  "Static Constant.

  Text antialiasing hint value -- text rendering is done with
   some form of antialiasing.

  type: java.lang.Object"
  RenderingHints/VALUE_TEXT_ANTIALIAS_ON)

(def *-value-text-antialias-off
  "Static Constant.

  Text antialiasing hint value -- text rendering is done without
   any form of antialiasing.

  type: java.lang.Object"
  RenderingHints/VALUE_TEXT_ANTIALIAS_OFF)

(def *-value-text-antialias-default
  "Static Constant.

  Text antialiasing hint value -- text rendering is done according
   to the KEY_ANTIALIASING hint or a default chosen by the
   implementation.

  type: java.lang.Object"
  RenderingHints/VALUE_TEXT_ANTIALIAS_DEFAULT)

(def *-value-text-antialias-gasp
  "Static Constant.

  Text antialiasing hint value -- text rendering is requested to
   use information in the font resource which specifies for each point
   size whether to apply VALUE_TEXT_ANTIALIAS_ON or
   VALUE_TEXT_ANTIALIAS_OFF.

   TrueType fonts typically provide this information in the 'gasp' table.
   In the absence of this information, the behaviour for a particular
   font and size is determined by implementation defaults.

   Note:A font designer will typically carefully hint a font for
   the most common user interface point sizes. Consequently the 'gasp'
   table will likely specify to use only hinting at those sizes and not
   `smoothing`. So in many cases the resulting text display is
   equivalent to VALUE_TEXT_ANTIALIAS_OFF.
   This may be unexpected but is correct.

   Logical fonts which are composed of multiple physical fonts will for
   consistency will use the setting most appropriate for the overall
   composite font.

  type: java.lang.Object"
  RenderingHints/VALUE_TEXT_ANTIALIAS_GASP)

(def *-value-text-antialias-lcd-hrgb
  "Static Constant.

  Text antialiasing hint value -- request that text be displayed
   optimised for an LCD display with subpixels in order from display
   left to right of R,G,B such that the horizontal subpixel resolution
   is three times that of the full pixel horizontal resolution (HRGB).
   This is the most common configuration.
   Selecting this hint for displays with one of the other LCD subpixel
   configurations will likely result in unfocused text.

   Notes:
   An implementation when choosing whether to apply any of the
   LCD text hint values may take into account factors including requiring
   color depth of the destination to be at least 15 bits per pixel
   (ie 5 bits per color component),
   characteristics of a font such as whether embedded bitmaps may
   produce better results, or when displaying to a non-local networked
   display device enabling it only if suitable protocols are available,
   or ignoring the hint if performing very high resolution rendering
   or the target device is not appropriate: eg when printing.

   These hints can equally be applied when rendering to software images,
   but these images may not then be suitable for general export, as the
   text will have been rendered appropriately for a specific subpixel
   organisation. Also lossy images are not a good choice, nor image
   formats such as GIF which have limited colors.
   So unless the image is destined solely for rendering on a
   display device with the same configuration, some other text
   anti-aliasing hint such as
   VALUE_TEXT_ANTIALIAS_ON
   may be a better choice.
   Selecting a value which does not match the LCD display in use
   will likely lead to a degradation in text quality.
   On display devices (ie CRTs) which do not have the same characteristics
   as LCD displays, the overall effect may appear similar to standard text
   anti-aliasing, but the quality may be degraded by color distortion.
   Analog connected LCD displays may also show little advantage over
   standard text-antialiasing and be similar to CRTs.

   In other words for the best results use an LCD display with a digital
   display connector and specify the appropriate sub-pixel configuration.

  type: java.lang.Object"
  RenderingHints/VALUE_TEXT_ANTIALIAS_LCD_HRGB)

(def *-value-text-antialias-lcd-hbgr
  "Static Constant.

  Text antialiasing hint value -- request that text be displayed
   optimised for an LCD display with subpixels in order from display
   left to right of B,G,R such that the horizontal subpixel resolution
   is three times that of the full pixel horizontal resolution (HBGR).
   This is a much less common configuration than HRGB.
   Selecting this hint for displays with one of the other LCD subpixel
   configurations will likely result in unfocused text.
   See VALUE_TEXT_ANTIALIAS_LCD_HRGB,
   for more information on when this hint is applied.

  type: java.lang.Object"
  RenderingHints/VALUE_TEXT_ANTIALIAS_LCD_HBGR)

(def *-value-text-antialias-lcd-vrgb
  "Static Constant.

  Text antialiasing hint value -- request that text be displayed
   optimised for an LCD display with subpixel organisation from display
   top to bottom of R,G,B such that the vertical subpixel resolution is
   three times that of the full pixel vertical resolution (VRGB).
   Vertical orientation is very uncommon and probably mainly useful
   for a physically rotated display.
   Selecting this hint for displays with one of the other LCD subpixel
   configurations will likely result in unfocused text.
   See VALUE_TEXT_ANTIALIAS_LCD_HRGB,
   for more information on when this hint is applied.

  type: java.lang.Object"
  RenderingHints/VALUE_TEXT_ANTIALIAS_LCD_VRGB)

(def *-value-text-antialias-lcd-vbgr
  "Static Constant.

  Text antialiasing hint value -- request that text be displayed
   optimised for an LCD display with subpixel organisation from display
   top to bottom of B,G,R such that the vertical subpixel resolution is
   three times that of the full pixel vertical resolution (VBGR).
   Vertical orientation is very uncommon and probably mainly useful
   for a physically rotated display.
   Selecting this hint for displays with one of the other LCD subpixel
   configurations will likely result in unfocused text.
   See VALUE_TEXT_ANTIALIAS_LCD_HRGB,
   for more information on when this hint is applied.

  type: java.lang.Object"
  RenderingHints/VALUE_TEXT_ANTIALIAS_LCD_VBGR)

(def *-key-text-lcd-contrast
  "Static Constant.

  LCD text contrast rendering hint key.
   The value is an Integer object which is used as a text
   contrast adjustment when used in conjunction with an LCD text
   anti-aliasing hint such as
   VALUE_TEXT_ANTIALIAS_LCD_HRGB.

   Values should be a positive integer in the range 100 to 250.
   A lower value (eg 100) corresponds to higher contrast text when
   displaying dark text on a light background.
   A higher value (eg 200) corresponds to lower contrast text when
   displaying dark text on a light background.
   A typical useful value is in the narrow range 140-180.
   If no value is specified, a system or implementation default value
   will be applied.

   The default value can be expected to be adequate for most purposes,
   so clients should rarely need to specify a value for this hint unless
   they have concrete information as to an appropriate value.
   A higher value does not mean a higher contrast, in fact the opposite
   is true.
   The correction is applied in a similar manner to a gamma adjustment
   for non-linear perceptual luminance response of display systems, but
   does not indicate a full correction for this.

  type: java.awt.RenderingHints.Key"
  RenderingHints/KEY_TEXT_LCD_CONTRAST)

(def *-key-fractionalmetrics
  "Static Constant.

  Font fractional metrics hint key.
   The FRACTIONALMETRICS hint controls whether the positioning
   of individual character glyphs takes into account the sub-pixel
   accuracy of the scaled character advances of the font or whether
   such advance vectors are rounded to an integer number of whole
   device pixels.
   This hint only recommends how much accuracy should be used to
   position the glyphs and does not specify or recommend whether or
   not the actual rasterization or pixel bounds of the glyph should
   be modified to match.

   Rendering text to a low resolution device like a screen will
   necessarily involve a number of rounding operations as the
   high quality and very precise definition of the shape and
   metrics of the character glyphs must be matched to discrete
   device pixels.
   Ideally the positioning of glyphs during text layout would be
   calculated by scaling the design metrics in the font according
   to the point size, but then the scaled advance width will not
   necessarily be an integer number of pixels.
   If the glyphs are positioned with sub-pixel accuracy according
   to these scaled design metrics then the rasterization would
   ideally need to be adjusted for each possible sub-pixel origin.

   Unfortunately, scaling each glyph customized to its exact
   subpixel origin during text layout would be prohibitively
   expensive so a simplified system based on integer device
   positions is typically used to lay out the text.
   The rasterization of the glyph and the scaled advance width
   are both adjusted together to yield text that looks good at
   device resolution and has consistent integer pixel distances
   between glyphs that help the glyphs look uniformly and
   consistently spaced and readable.

   This process of rounding advance widths for rasterized glyphs
   to integer distances means that the character density and the
   overall length of a string of text will be different from the
   theoretical design measurements due to the accumulation of
   a series of small differences in the adjusted widths of
   each glyph.
   The specific differences will be different for each glyph,
   some being wider and some being narrower than their theoretical
   design measurements.
   Thus the overall difference in character density and length
   will vary by a number of factors including the font, the
   specific device resolution being targeted, and the glyphs
   chosen to represent the string being rendered.
   As a result, rendering the same string at multiple device
   resolutions can yield widely varying metrics for whole strings.

   When FRACTIONALMETRICS are enabled, the true font design
   metrics are scaled by the point size and used for layout with
   sub-pixel accuracy.
   The average density of glyphs and total length of a long
   string of characters will therefore more closely match the
   theoretical design of the font, but readability may be affected
   since individual pairs of characters may not always appear to
   be consistent distances apart depending on how the sub-pixel
   accumulation of the glyph origins meshes with the device pixel
   grid.
   Enabling this hint may be desirable when text layout is being
   performed that must be consistent across a wide variety of
   output resolutions.
   Specifically, this hint may be desirable in situations where
   the layout of text is being previewed on a low resolution
   device like a screen for output that will eventually be
   rendered on a high resolution printer or typesetting device.

   When disabled, the scaled design metrics are rounded or adjusted
   to integer distances for layout.
   The distances between any specific pair of glyphs will be more
   uniform on the device, but the density and total length of long
   strings may no longer match the theoretical intentions of the
   font designer.
   Disabling this hint will typically produce more readable results
   on low resolution devices like computer monitors.

   The allowable values for this key are

   VALUE_FRACTIONALMETRICS_OFF
   VALUE_FRACTIONALMETRICS_ON
   VALUE_FRACTIONALMETRICS_DEFAULT

  type: java.awt.RenderingHints.Key"
  RenderingHints/KEY_FRACTIONALMETRICS)

(def *-value-fractionalmetrics-off
  "Static Constant.

  Font fractional metrics hint value -- character glyphs are
   positioned with advance widths rounded to pixel boundaries.

  type: java.lang.Object"
  RenderingHints/VALUE_FRACTIONALMETRICS_OFF)

(def *-value-fractionalmetrics-on
  "Static Constant.

  Font fractional metrics hint value -- character glyphs are
   positioned with sub-pixel accuracy.

  type: java.lang.Object"
  RenderingHints/VALUE_FRACTIONALMETRICS_ON)

(def *-value-fractionalmetrics-default
  "Static Constant.

  Font fractional metrics hint value -- character glyphs are
   positioned with accuracy chosen by the implementation.

  type: java.lang.Object"
  RenderingHints/VALUE_FRACTIONALMETRICS_DEFAULT)

(def *-key-interpolation
  "Static Constant.

  Interpolation hint key.
   The INTERPOLATION hint controls how image pixels are
   filtered or resampled during an image rendering operation.

   Implicitly images are defined to provide color samples at
   integer coordinate locations.
   When images are rendered upright with no scaling onto a
   destination, the choice of which image pixels map to which
   device pixels is obvious and the samples at the integer
   coordinate locations in the image are transfered to the
   pixels at the corresponding integer locations on the device
   pixel grid one for one.
   When images are rendered in a scaled, rotated, or otherwise
   transformed coordinate system, then the mapping of device
   pixel coordinates back to the image can raise the question
   of what color sample to use for the continuous coordinates
   that lie between the integer locations of the provided image
   samples.
   Interpolation algorithms define functions which provide a
   color sample for any continuous coordinate in an image based
   on the color samples at the surrounding integer coordinates.

   The allowable values for this hint are

   VALUE_INTERPOLATION_NEAREST_NEIGHBOR
   VALUE_INTERPOLATION_BILINEAR
   VALUE_INTERPOLATION_BICUBIC

  type: java.awt.RenderingHints.Key"
  RenderingHints/KEY_INTERPOLATION)

(def *-value-interpolation-nearest-neighbor
  "Static Constant.

  Interpolation hint value -- the color sample of the nearest
   neighboring integer coordinate sample in the image is used.
   Conceptually the image is viewed as a grid of unit-sized
   square regions of color centered around the center of each
   image pixel.

   As the image is scaled up, it will look correspondingly blocky.
   As the image is scaled down, the colors for source pixels will
   be either used unmodified, or skipped entirely in the output
   representation.

  type: java.lang.Object"
  RenderingHints/VALUE_INTERPOLATION_NEAREST_NEIGHBOR)

(def *-value-interpolation-bilinear
  "Static Constant.

  Interpolation hint value -- the color samples of the 4 nearest
   neighboring integer coordinate samples in the image are
   interpolated linearly to produce a color sample.
   Conceptually the image is viewed as a set of infinitely small
   point color samples which have value only at the centers of
   integer coordinate pixels and the space between those pixel
   centers is filled with linear ramps of colors that connect
   adjacent discrete samples in a straight line.

   As the image is scaled up, there are no blocky edges between
   the colors in the image as there are with
   NEAREST_NEIGHBOR,
   but the blending may show some subtle discontinuities along the
   horizontal and vertical edges that line up with the samples
   caused by a sudden change in the slope of the interpolation
   from one side of a sample to the other.
   As the image is scaled down, more image pixels have their
   color samples represented in the resulting output since each
   output pixel receives color information from up to 4 image
   pixels.

  type: java.lang.Object"
  RenderingHints/VALUE_INTERPOLATION_BILINEAR)

(def *-value-interpolation-bicubic
  "Static Constant.

  Interpolation hint value -- the color samples of 9 nearby
   integer coordinate samples in the image are interpolated using
   a cubic function in both X and Y to produce
   a color sample.
   Conceptually the view of the image is very similar to the view
   used in the BILINEAR
   algorithm except that the ramps of colors that connect between
   the samples are curved and have better continuity of slope
   as they cross over between sample boundaries.

   As the image is scaled up, there are no blocky edges and the
   interpolation should appear smoother and with better depictions
   of any edges in the original image than with BILINEAR.
   As the image is scaled down, even more of the original color
   samples from the original image will have their color information
   carried through and represented.

  type: java.lang.Object"
  RenderingHints/VALUE_INTERPOLATION_BICUBIC)

(def *-key-alpha-interpolation
  "Static Constant.

  Alpha interpolation hint key.
   The ALPHA_INTERPOLATION hint is a general hint that
   provides a high level recommendation as to whether to bias
   alpha blending algorithm choices more for speed or quality
   when evaluating tradeoffs.

   This hint could control the choice of alpha blending
   calculations that sacrifice some precision to use fast
   lookup tables or lower precision SIMD instructions.
   This hint could also control whether or not the color
   and alpha values are converted into a linear color space
   during the calculations for a more linear visual effect
   at the expense of additional per-pixel calculations.

   The allowable values for this hint are

   VALUE_ALPHA_INTERPOLATION_SPEED
   VALUE_ALPHA_INTERPOLATION_QUALITY
   VALUE_ALPHA_INTERPOLATION_DEFAULT

  type: java.awt.RenderingHints.Key"
  RenderingHints/KEY_ALPHA_INTERPOLATION)

(def *-value-alpha-interpolation-speed
  "Static Constant.

  Alpha interpolation hint value -- alpha blending algorithms
   are chosen with a preference for calculation speed.

  type: java.lang.Object"
  RenderingHints/VALUE_ALPHA_INTERPOLATION_SPEED)

(def *-value-alpha-interpolation-quality
  "Static Constant.

  Alpha interpolation hint value -- alpha blending algorithms
   are chosen with a preference for precision and visual quality.

  type: java.lang.Object"
  RenderingHints/VALUE_ALPHA_INTERPOLATION_QUALITY)

(def *-value-alpha-interpolation-default
  "Static Constant.

  Alpha interpolation hint value -- alpha blending algorithms
   are chosen by the implementation for a good tradeoff of
   performance vs. quality.

  type: java.lang.Object"
  RenderingHints/VALUE_ALPHA_INTERPOLATION_DEFAULT)

(def *-key-color-rendering
  "Static Constant.

  Color rendering hint key.
   The COLOR_RENDERING hint controls the accuracy of
   approximation and conversion when storing colors into a
   destination image or surface.

   When a rendering or image manipulation operation produces
   a color value that must be stored into a destination, it
   must first convert that color into a form suitable for
   storing into the destination image or surface.
   Minimally, the color components must be converted to bit
   representations and ordered in the correct order or an
   index into a color lookup table must be chosen before
   the data can be stored into the destination memory.
   Without this minimal conversion, the data in the destination
   would likely represent random, incorrect or possibly even
   unsupported values.
   Algorithms to quickly convert the results of rendering
   operations into the color format of most common destinations
   are well known and fairly optimal to execute.

   Simply performing the most basic color format conversion to
   store colors into a destination can potentially ignore a
   difference in the calibration of the
   ColorSpace
   of the source and destination or other factors such as the
   linearity of the gamma correction.
   Unless the source and destination ColorSpace are
   identical, to correctly perform a rendering operation with
   the most care taken for the accuracy of the colors being
   represented, the source colors should be converted to a
   device independent ColorSpace and the results then
   converted back to the destination ColorSpace.
   Furthermore, if calculations such as the blending of multiple
   source colors are to be performed during the rendering
   operation, greater visual clarity can be achieved if the
   intermediate device independent ColorSpace is
   chosen to have a linear relationship between the values
   being calculated and the perception of the human eye to
   the response curves of the output device.

   The allowable values for this hint are

   VALUE_COLOR_RENDER_SPEED
   VALUE_COLOR_RENDER_QUALITY
   VALUE_COLOR_RENDER_DEFAULT

  type: java.awt.RenderingHints.Key"
  RenderingHints/KEY_COLOR_RENDERING)

(def *-value-color-render-speed
  "Static Constant.

  Color rendering hint value -- perform the fastest color
   conversion to the format of the output device.

  type: java.lang.Object"
  RenderingHints/VALUE_COLOR_RENDER_SPEED)

(def *-value-color-render-quality
  "Static Constant.

  Color rendering hint value -- perform the color conversion
   calculations with the highest accuracy and visual quality.

  type: java.lang.Object"
  RenderingHints/VALUE_COLOR_RENDER_QUALITY)

(def *-value-color-render-default
  "Static Constant.

  Color rendering hint value -- perform color conversion
   calculations as chosen by the implementation to represent
   the best available tradeoff between performance and
   accuracy.

  type: java.lang.Object"
  RenderingHints/VALUE_COLOR_RENDER_DEFAULT)

(def *-key-stroke-control
  "Static Constant.

  Stroke normalization control hint key.
   The STROKE_CONTROL hint controls whether a rendering
   implementation should or is allowed to modify the geometry
   of rendered shapes for various purposes.

   Some implementations may be able to use an optimized platform
   rendering library which may be faster than traditional software
   rendering algorithms on a given platform, but which may also
   not support floating point coordinates.
   Some implementations may also have sophisticated algorithms
   which perturb the coordinates of a path so that wide lines
   appear more uniform in width and spacing.

   If an implementation performs any type of modification or
   `normalization` of a path, it should never move the coordinates
   by more than half a pixel in any direction.

   The allowable values for this hint are

   VALUE_STROKE_NORMALIZE
   VALUE_STROKE_PURE
   VALUE_STROKE_DEFAULT

  type: java.awt.RenderingHints.Key"
  RenderingHints/KEY_STROKE_CONTROL)

(def *-value-stroke-default
  "Static Constant.

  Stroke normalization control hint value -- geometry may be
   modified or left pure depending on the tradeoffs in a given
   implementation.
   Typically this setting allows an implementation to use a fast
   integer coordinate based platform rendering library, but does
   not specifically request normalization for uniformity or
   aesthetics.

  type: java.lang.Object"
  RenderingHints/VALUE_STROKE_DEFAULT)

(def *-value-stroke-normalize
  "Static Constant.

  Stroke normalization control hint value -- geometry should
   be normalized to improve uniformity or spacing of lines and
   overall aesthetics.
   Note that different normalization algorithms may be more
   successful than others for given input paths.

  type: java.lang.Object"
  RenderingHints/VALUE_STROKE_NORMALIZE)

(def *-value-stroke-pure
  "Static Constant.

  Stroke normalization control hint value -- geometry should
   be left unmodified and rendered with sub-pixel accuracy.

  type: java.lang.Object"
  RenderingHints/VALUE_STROKE_PURE)

(defn values
  "Returns a Collection view of the values
   contained in this RenderinHints.
   The Collection is backed by the
   RenderingHints, so changes to
   the RenderingHints are reflected in
   the Collection, and vice-versa.
   If the RenderingHints is modified while
   an iteration over the Collection is
   in progress, the results of the iteration are undefined.
   The Collection supports element removal,
   which removes the corresponding mapping from the
   RenderingHints, via the
   Iterator.remove,
   Collection.remove, removeAll,
   retainAll and clear operations.
   It does not support the add or
   addAll operations.

  returns: a Collection view of the values
            contained in this RenderingHints. - `java.util.Collection<java.lang.Object>`"
  ([^java.awt.RenderingHints this]
    (-> this (.values))))

(defn put-all
  "Copies all of the mappings from the specified Map
   to this RenderingHints.  These mappings replace
   any mappings that this RenderingHints had for any
   of the keys currently in the specified Map.

  m - the specified Map - `java.util.Map<?,?>`

  throws: java.lang.ClassCastException - class of a key or value in the specified Map prevents it from being stored in this RenderingHints."
  ([^java.awt.RenderingHints this ^java.util.Map m]
    (-> this (.putAll m))))

(defn put
  "Maps the specified key to the specified
   value in this RenderingHints object.
   Neither the key nor the value can be null.
   The value can be retrieved by calling the get method
   with a key that is equal to the original key.

  key - the rendering hint key. - `java.lang.Object`
  value - the rendering hint value. - `java.lang.Object`

  returns: the previous value of the specified key in this object
               or null if it did not have one. - `java.lang.Object`

  throws: java.lang.NullPointerException - if the key is null."
  ([^java.awt.RenderingHints this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.put key value))))

(defn entry-set
  "Returns a Set view of the mappings contained
   in this RenderingHints.  Each element in the
   returned Set is a Map.Entry.
   The Set is backed by the RenderingHints,
   so changes to the RenderingHints are reflected
   in the Set, and vice-versa.  If the
   RenderingHints is modified while
   while an iteration over the Set is in progress,
   the results of the iteration are undefined.

   The entrySet returned from a RenderingHints object
   is not modifiable.

  returns: a Set view of the mappings contained in
   this RenderingHints. - `java.util.Set<java.util.Map.Entry<java.lang.Object,java.lang.Object>>`"
  ([^java.awt.RenderingHints this]
    (-> this (.entrySet))))

(defn to-string
  "Returns a rather long string representation of the hashmap
   which contains the mappings of keys to values for this
   RenderingHints object.

  returns: a string representation of this object. - `java.lang.String`"
  ([^java.awt.RenderingHints this]
    (-> this (.toString))))

(defn contains-value
  "Returns true if this RenderingHints maps one or more keys to the
   specified value.
   More formally, returns true if and only
   if this RenderingHints
   contains at least one mapping to a value v such that


   (value==null ? v==null : value.equals(v)).
   This operation will probably require time linear in the
   RenderingHints size for most implementations
   of RenderingHints.

  value - value whose presence in this RenderingHints is to be tested. - `java.lang.Object`

  returns: true if this RenderingHints
             maps one or more keys to the specified value. - `boolean`"
  ([^java.awt.RenderingHints this ^java.lang.Object value]
    (-> this (.containsValue value))))

(defn remove
  "Removes the key and its corresponding value from this
   RenderingHints object. This method does nothing if the
   key is not in this RenderingHints object.

  key - the rendering hints key that needs to be removed - `java.lang.Object`

  returns: the value to which the key had previously been mapped in this
            RenderingHints object, or null
            if the key did not have a mapping. - `java.lang.Object`

  throws: java.lang.ClassCastException - if the key can not be cast to RenderingHints.Key"
  ([^java.awt.RenderingHints this ^java.lang.Object key]
    (-> this (.remove key))))

(defn key-set
  "Returns a Set view of the Keys contained in this
   RenderingHints.  The Set is backed by the
   RenderingHints, so changes to the
   RenderingHints are reflected in the Set,
   and vice-versa.  If the RenderingHints is modified
   while an iteration over the Set is in progress,
   the results of the iteration are undefined.  The Set
   supports element removal, which removes the corresponding
   mapping from the RenderingHints, via the
   Iterator.remove, Set.remove,
   removeAll retainAll, and
   clear operations.  It does not support
   the add or addAll operations.

  returns: a Set view of the keys contained
   in this RenderingHints. - `java.util.Set<java.lang.Object>`"
  ([^java.awt.RenderingHints this]
    (-> this (.keySet))))

(defn clone
  "Creates a clone of this RenderingHints object
   that has the same contents as this RenderingHints
   object.

  returns: a clone of this instance. - `java.lang.Object`"
  ([^java.awt.RenderingHints this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code value for this RenderingHints.
   The hash code of a RenderingHints is defined to be
   the sum of the hashCodes of each Entry in the
   RenderingHints object's entrySet view.  This ensures that
   t1.equals(t2) implies that
   t1.hashCode()==t2.hashCode() for any two Map
   objects t1 and t2, as required by the general
   contract of Object.hashCode.

  returns: the hash code value for this RenderingHints. - `int`"
  ([^java.awt.RenderingHints this]
    (-> this (.hashCode))))

(defn add
  "Adds all of the keys and corresponding values from the specified
   RenderingHints object to this
   RenderingHints object. Keys that are present in
   this RenderingHints object, but not in the specified
   RenderingHints object are not affected.

  hints - the set of key/value pairs to be added to this RenderingHints object - `java.awt.RenderingHints`"
  ([^java.awt.RenderingHints this ^java.awt.RenderingHints hints]
    (-> this (.add hints))))

(defn empty?
  "Returns true if this
   RenderingHints contains no key-value mappings.

  returns: true if this
   RenderingHints contains no key-value mappings. - `boolean`"
  ([^java.awt.RenderingHints this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of key-value mappings in this
   RenderingHints.

  returns: the number of key-value mappings in this
   RenderingHints. - `int`"
  ([^java.awt.RenderingHints this]
    (-> this (.size))))

(defn clear
  "Clears this RenderingHints object of all key/value
   pairs."
  ([^java.awt.RenderingHints this]
    (-> this (.clear))))

(defn contains-key
  "Returns true if this RenderingHints
    contains a mapping for the specified key.

  key - key whose presence in this RenderingHints is to be tested. - `java.lang.Object`

  returns: true if this RenderingHints
            contains a mapping for the specified key. - `boolean`

  throws: java.lang.ClassCastException - if the key can not be cast to RenderingHints.Key"
  ([^java.awt.RenderingHints this ^java.lang.Object key]
    (-> this (.containsKey key))))

(defn get
  "Returns the value to which the specified key is mapped.

  key - a rendering hint key - `java.lang.Object`

  returns: the value to which the key is mapped in this object or
            null if the key is not mapped to any value in
            this object. - `java.lang.Object`

  throws: java.lang.ClassCastException - if the key can not be cast to RenderingHints.Key"
  ([^java.awt.RenderingHints this ^java.lang.Object key]
    (-> this (.get key))))

(defn equals
  "Compares the specified Object with this
   RenderingHints for equality.
   Returns true if the specified object is also a
   Map and the two Map objects represent
   the same mappings.  More formally, two Map objects
   t1 and t2 represent the same mappings
   if t1.keySet().equals(t2.keySet()) and for every
   key k in t1.keySet(),


   (t1.get(k)==null ? t2.get(k)==null : t1.get(k).equals(t2.get(k))).
   This ensures that the equals method works properly across
   different implementations of the Map interface.

  o - Object to be compared for equality with this RenderingHints. - `java.lang.Object`

  returns: true if the specified Object
   is equal to this RenderingHints. - `boolean`"
  ([^java.awt.RenderingHints this ^java.lang.Object o]
    (-> this (.equals o))))

