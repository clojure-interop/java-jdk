# Bindings for java.awt

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.awt "0.1.0-SNAPSHOT"]
```

## Class Members Naming Conventions

| Class Member | Java | Clojure |
|:--|:--|:--|
| constructor | new File() | (->file) |
| instance method | getAnyValue() | (get-any-value) |
| instance field | instanceField | -instance-field |
| static method | staticMethod() | (*static-method) |
| static field | ANY_STATIC_FIELD | *-any-static-field |
| boolean field/method | isExists(), canUse() | (exists?), (can-use?) |

## Classes

- class **java.awt.AWTError**
- class **java.awt.AWTEvent**
- class **java.awt.AWTEventMulticaster**
- class **java.awt.AWTException**
- class **java.awt.AWTKeyStroke**
- class **java.awt.AWTPermission**
- interface **java.awt.ActiveEvent**
- interface **java.awt.Adjustable**
- class **java.awt.AlphaComposite**
- class **java.awt.BasicStroke**
- class **java.awt.BorderLayout**
- class **java.awt.BufferCapabilities$FlipContents**
- class **java.awt.BufferCapabilities**
- class **java.awt.Button**
- class **java.awt.Canvas**
- class **java.awt.CardLayout**
- class **java.awt.Checkbox**
- class **java.awt.CheckboxGroup**
- class **java.awt.CheckboxMenuItem**
- class **java.awt.Choice**
- class **java.awt.Color**
- enum **java.awt.Component$BaselineResizeBehavior**
- class **java.awt.Component**
- class **java.awt.ComponentOrientation**
- interface **java.awt.Composite**
- interface **java.awt.CompositeContext**
- class **java.awt.Container**
- class **java.awt.ContainerOrderFocusTraversalPolicy**
- class **java.awt.Cursor**
- class **java.awt.DefaultFocusTraversalPolicy**
- class **java.awt.DefaultKeyboardFocusManager**
- enum **java.awt.Desktop$Action**
- class **java.awt.Desktop**
- enum **java.awt.Dialog$ModalExclusionType**
- enum **java.awt.Dialog$ModalityType**
- class **java.awt.Dialog**
- class **java.awt.Dimension**
- class **java.awt.DisplayMode**
- class **java.awt.Event**
- class **java.awt.EventQueue**
- class **java.awt.FileDialog**
- class **java.awt.FlowLayout**
- class **java.awt.FocusTraversalPolicy**
- class **java.awt.Font**
- class **java.awt.FontFormatException**
- class **java.awt.FontMetrics**
- class **java.awt.Frame**
- class **java.awt.GradientPaint**
- class **java.awt.Graphics**
- class **java.awt.Graphics2D**
- class **java.awt.GraphicsConfigTemplate**
- class **java.awt.GraphicsConfiguration**
- enum **java.awt.GraphicsDevice$WindowTranslucency**
- class **java.awt.GraphicsDevice**
- class **java.awt.GraphicsEnvironment**
- class **java.awt.GridBagConstraints**
- class **java.awt.GridBagLayout**
- class **java.awt.GridBagLayoutInfo**
- class **java.awt.GridLayout**
- class **java.awt.HeadlessException**
- class **java.awt.IllegalComponentStateException**
- class **java.awt.Image**
- class **java.awt.ImageCapabilities**
- class **java.awt.Insets**
- interface **java.awt.ItemSelectable**
- class **java.awt.JobAttributes$DefaultSelectionType**
- class **java.awt.JobAttributes$DestinationType**
- class **java.awt.JobAttributes$DialogType**
- class **java.awt.JobAttributes$MultipleDocumentHandlingType**
- class **java.awt.JobAttributes$SidesType**
- class **java.awt.JobAttributes**
- interface **java.awt.KeyEventDispatcher**
- interface **java.awt.KeyEventPostProcessor**
- class **java.awt.KeyboardFocusManager**
- class **java.awt.Label**
- interface **java.awt.LayoutManager**
- interface **java.awt.LayoutManager2**
- class **java.awt.LinearGradientPaint**
- class **java.awt.List**
- class **java.awt.MediaTracker**
- class **java.awt.Menu**
- class **java.awt.MenuBar**
- class **java.awt.MenuComponent**
- interface **java.awt.MenuContainer**
- class **java.awt.MenuItem**
- class **java.awt.MenuShortcut**
- class **java.awt.MouseInfo**
- enum **java.awt.MultipleGradientPaint$ColorSpaceType**
- enum **java.awt.MultipleGradientPaint$CycleMethod**
- class **java.awt.MultipleGradientPaint**
- class **java.awt.PageAttributes$ColorType**
- class **java.awt.PageAttributes$MediaType**
- class **java.awt.PageAttributes$OrientationRequestedType**
- class **java.awt.PageAttributes$OriginType**
- class **java.awt.PageAttributes$PrintQualityType**
- class **java.awt.PageAttributes**
- interface **java.awt.Paint**
- interface **java.awt.PaintContext**
- class **java.awt.Panel**
- class **java.awt.Point**
- class **java.awt.PointerInfo**
- class **java.awt.Polygon**
- class **java.awt.PopupMenu**
- interface **java.awt.PrintGraphics**
- class **java.awt.PrintJob**
- class **java.awt.RadialGradientPaint**
- class **java.awt.Rectangle**
- class **java.awt.RenderingHints$Key**
- class **java.awt.RenderingHints**
- class **java.awt.Robot**
- class **java.awt.ScrollPane**
- class **java.awt.ScrollPaneAdjustable**
- class **java.awt.Scrollbar**
- interface **java.awt.SecondaryLoop**
- interface **java.awt.Shape**
- class **java.awt.SplashScreen**
- interface **java.awt.Stroke**
- class **java.awt.SystemColor**
- class **java.awt.SystemTray**
- class **java.awt.TextArea**
- class **java.awt.TextComponent**
- class **java.awt.TextField**
- class **java.awt.TexturePaint**
- class **java.awt.Toolkit**
- interface **java.awt.Transparency**
- enum **java.awt.TrayIcon$MessageType**
- class **java.awt.TrayIcon**
- enum **java.awt.Window$Type**
- class **java.awt.Window**
- class **java.awt.color.CMMException**
- class **java.awt.color.ColorSpace**
- class **java.awt.color.ICC_ColorSpace**
- class **java.awt.color.ICC_Profile**
- class **java.awt.color.ICC_ProfileGray**
- class **java.awt.color.ICC_ProfileRGB**
- class **java.awt.color.ProfileDataException**
- class **java.awt.datatransfer.Clipboard**
- interface **java.awt.datatransfer.ClipboardOwner**
- class **java.awt.datatransfer.DataFlavor**
- class **java.awt.datatransfer.FlavorEvent**
- interface **java.awt.datatransfer.FlavorListener**
- interface **java.awt.datatransfer.FlavorMap**
- interface **java.awt.datatransfer.FlavorTable**
- class **java.awt.datatransfer.MimeTypeParseException**
- class **java.awt.datatransfer.StringSelection**
- class **java.awt.datatransfer.SystemFlavorMap**
- interface **java.awt.datatransfer.Transferable**
- class **java.awt.datatransfer.UnsupportedFlavorException**
- interface **java.awt.dnd.Autoscroll**
- class **java.awt.dnd.DnDConstants**
- class **java.awt.dnd.DragGestureEvent**
- interface **java.awt.dnd.DragGestureListener**
- class **java.awt.dnd.DragGestureRecognizer**
- class **java.awt.dnd.DragSource**
- class **java.awt.dnd.DragSourceAdapter**
- class **java.awt.dnd.DragSourceContext**
- class **java.awt.dnd.DragSourceDragEvent**
- class **java.awt.dnd.DragSourceDropEvent**
- class **java.awt.dnd.DragSourceEvent**
- interface **java.awt.dnd.DragSourceListener**
- interface **java.awt.dnd.DragSourceMotionListener**
- class **java.awt.dnd.DropTarget$DropTargetAutoScroller**
- class **java.awt.dnd.DropTarget**
- class **java.awt.dnd.DropTargetAdapter**
- class **java.awt.dnd.DropTargetContext**
- class **java.awt.dnd.DropTargetDragEvent**
- class **java.awt.dnd.DropTargetDropEvent**
- class **java.awt.dnd.DropTargetEvent**
- interface **java.awt.dnd.DropTargetListener**
- class **java.awt.dnd.InvalidDnDOperationException**
- class **java.awt.dnd.MouseDragGestureRecognizer**
- interface **java.awt.event.AWTEventListener**
- class **java.awt.event.AWTEventListenerProxy**
- class **java.awt.event.ActionEvent**
- interface **java.awt.event.ActionListener**
- class **java.awt.event.AdjustmentEvent**
- interface **java.awt.event.AdjustmentListener**
- class **java.awt.event.ComponentAdapter**
- class **java.awt.event.ComponentEvent**
- interface **java.awt.event.ComponentListener**
- class **java.awt.event.ContainerAdapter**
- class **java.awt.event.ContainerEvent**
- interface **java.awt.event.ContainerListener**
- class **java.awt.event.FocusAdapter**
- class **java.awt.event.FocusEvent**
- interface **java.awt.event.FocusListener**
- class **java.awt.event.HierarchyBoundsAdapter**
- interface **java.awt.event.HierarchyBoundsListener**
- class **java.awt.event.HierarchyEvent**
- interface **java.awt.event.HierarchyListener**
- class **java.awt.event.InputEvent**
- class **java.awt.event.InputMethodEvent**
- interface **java.awt.event.InputMethodListener**
- class **java.awt.event.InvocationEvent**
- class **java.awt.event.ItemEvent**
- interface **java.awt.event.ItemListener**
- class **java.awt.event.KeyAdapter**
- class **java.awt.event.KeyEvent**
- interface **java.awt.event.KeyListener**
- class **java.awt.event.MouseAdapter**
- class **java.awt.event.MouseEvent**
- interface **java.awt.event.MouseListener**
- class **java.awt.event.MouseMotionAdapter**
- interface **java.awt.event.MouseMotionListener**
- class **java.awt.event.MouseWheelEvent**
- interface **java.awt.event.MouseWheelListener**
- class **java.awt.event.PaintEvent**
- class **java.awt.event.TextEvent**
- interface **java.awt.event.TextListener**
- class **java.awt.event.WindowAdapter**
- class **java.awt.event.WindowEvent**
- interface **java.awt.event.WindowFocusListener**
- interface **java.awt.event.WindowListener**
- interface **java.awt.event.WindowStateListener**
- class **java.awt.font.FontRenderContext**
- class **java.awt.font.GlyphJustificationInfo**
- class **java.awt.font.GlyphMetrics**
- class **java.awt.font.GlyphVector**
- class **java.awt.font.GraphicAttribute**
- class **java.awt.font.ImageGraphicAttribute**
- class **java.awt.font.LayoutPath**
- class **java.awt.font.LineBreakMeasurer**
- class **java.awt.font.LineMetrics**
- interface **java.awt.font.MultipleMaster**
- enum **java.awt.font.NumericShaper$Range**
- class **java.awt.font.NumericShaper**
- interface **java.awt.font.OpenType**
- class **java.awt.font.ShapeGraphicAttribute**
- class **java.awt.font.TextAttribute**
- class **java.awt.font.TextHitInfo**
- class **java.awt.font.TextLayout$CaretPolicy**
- class **java.awt.font.TextLayout**
- class **java.awt.font.TextMeasurer**
- class **java.awt.font.TransformAttribute**
- class **java.awt.geom.AffineTransform**
- class **java.awt.geom.Arc2D$Double**
- class **java.awt.geom.Arc2D$Float**
- class **java.awt.geom.Arc2D**
- class **java.awt.geom.Area**
- class **java.awt.geom.CubicCurve2D$Double**
- class **java.awt.geom.CubicCurve2D$Float**
- class **java.awt.geom.CubicCurve2D**
- class **java.awt.geom.Dimension2D**
- class **java.awt.geom.Ellipse2D$Double**
- class **java.awt.geom.Ellipse2D$Float**
- class **java.awt.geom.Ellipse2D**
- class **java.awt.geom.FlatteningPathIterator**
- class **java.awt.geom.GeneralPath**
- class **java.awt.geom.IllegalPathStateException**
- class **java.awt.geom.Line2D$Double**
- class **java.awt.geom.Line2D$Float**
- class **java.awt.geom.Line2D**
- class **java.awt.geom.NoninvertibleTransformException**
- class **java.awt.geom.Path2D$Double**
- class **java.awt.geom.Path2D$Float**
- class **java.awt.geom.Path2D**
- interface **java.awt.geom.PathIterator**
- class **java.awt.geom.Point2D$Double**
- class **java.awt.geom.Point2D$Float**
- class **java.awt.geom.Point2D**
- class **java.awt.geom.QuadCurve2D$Double**
- class **java.awt.geom.QuadCurve2D$Float**
- class **java.awt.geom.QuadCurve2D**
- class **java.awt.geom.Rectangle2D$Double**
- class **java.awt.geom.Rectangle2D$Float**
- class **java.awt.geom.Rectangle2D**
- class **java.awt.geom.RectangularShape**
- class **java.awt.geom.RoundRectangle2D$Double**
- class **java.awt.geom.RoundRectangle2D$Float**
- class **java.awt.geom.RoundRectangle2D**
- class **java.awt.im.InputContext**
- class **java.awt.im.InputMethodHighlight**
- interface **java.awt.im.InputMethodRequests**
- class **java.awt.im.InputSubset**
- interface **java.awt.im.spi.InputMethod**
- interface **java.awt.im.spi.InputMethodContext**
- interface **java.awt.im.spi.InputMethodDescriptor**
- class **java.awt.image.AffineTransformOp**
- class **java.awt.image.AreaAveragingScaleFilter**
- class **java.awt.image.BandCombineOp**
- class **java.awt.image.BandedSampleModel**
- class **java.awt.image.BufferStrategy**
- class **java.awt.image.BufferedImage**
- class **java.awt.image.BufferedImageFilter**
- interface **java.awt.image.BufferedImageOp**
- class **java.awt.image.ByteLookupTable**
- class **java.awt.image.ColorConvertOp**
- class **java.awt.image.ColorModel**
- class **java.awt.image.ComponentColorModel**
- class **java.awt.image.ComponentSampleModel**
- class **java.awt.image.ConvolveOp**
- class **java.awt.image.CropImageFilter**
- class **java.awt.image.DataBuffer**
- class **java.awt.image.DataBufferByte**
- class **java.awt.image.DataBufferDouble**
- class **java.awt.image.DataBufferFloat**
- class **java.awt.image.DataBufferInt**
- class **java.awt.image.DataBufferShort**
- class **java.awt.image.DataBufferUShort**
- class **java.awt.image.DirectColorModel**
- class **java.awt.image.FilteredImageSource**
- interface **java.awt.image.ImageConsumer**
- class **java.awt.image.ImageFilter**
- interface **java.awt.image.ImageObserver**
- interface **java.awt.image.ImageProducer**
- class **java.awt.image.ImagingOpException**
- class **java.awt.image.IndexColorModel**
- class **java.awt.image.Kernel**
- class **java.awt.image.LookupOp**
- class **java.awt.image.LookupTable**
- class **java.awt.image.MemoryImageSource**
- class **java.awt.image.MultiPixelPackedSampleModel**
- class **java.awt.image.PackedColorModel**
- class **java.awt.image.PixelGrabber**
- class **java.awt.image.PixelInterleavedSampleModel**
- class **java.awt.image.RGBImageFilter**
- class **java.awt.image.Raster**
- class **java.awt.image.RasterFormatException**
- interface **java.awt.image.RasterOp**
- interface **java.awt.image.RenderedImage**
- class **java.awt.image.ReplicateScaleFilter**
- class **java.awt.image.RescaleOp**
- class **java.awt.image.SampleModel**
- class **java.awt.image.ShortLookupTable**
- class **java.awt.image.SinglePixelPackedSampleModel**
- interface **java.awt.image.TileObserver**
- class **java.awt.image.VolatileImage**
- class **java.awt.image.WritableRaster**
- interface **java.awt.image.WritableRenderedImage**
- interface **java.awt.image.renderable.ContextualRenderedImageFactory**
- class **java.awt.image.renderable.ParameterBlock**
- class **java.awt.image.renderable.RenderContext**
- interface **java.awt.image.renderable.RenderableImage**
- class **java.awt.image.renderable.RenderableImageOp**
- class **java.awt.image.renderable.RenderableImageProducer**
- interface **java.awt.image.renderable.RenderedImageFactory**
- class **java.awt.print.Book**
- class **java.awt.print.PageFormat**
- interface **java.awt.print.Pageable**
- class **java.awt.print.Paper**
- interface **java.awt.print.Printable**
- class **java.awt.print.PrinterAbortException**
- class **java.awt.print.PrinterException**
- interface **java.awt.print.PrinterGraphics**
- class **java.awt.print.PrinterIOException**
- class **java.awt.print.PrinterJob**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
