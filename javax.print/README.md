# Bindings for javax.print

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 

## Clojars

You can find clojars in README of packages.

## Usage

```
(require '[jdk.io.File :as f])

(-> "./resource/MyFile.txt"
  f/->file
  f/exists?)

(-> "./resource/MyAnotherFile.txt"
  f/->file
  f/mkdirs)
```




## Clojars

```
[clojure-interop/javax.print "0.1.0-SNAPSHOT"]
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

- interface **javax.print.AttributeException**
- interface **javax.print.CancelablePrintJob**
- interface **javax.print.Doc**
- class **javax.print.DocFlavor$BYTE_ARRAY**
- class **javax.print.DocFlavor$CHAR_ARRAY**
- class **javax.print.DocFlavor$INPUT_STREAM**
- class **javax.print.DocFlavor$READER**
- class **javax.print.DocFlavor$SERVICE_FORMATTED**
- class **javax.print.DocFlavor$STRING**
- class **javax.print.DocFlavor$URL**
- class **javax.print.DocFlavor**
- interface **javax.print.DocPrintJob**
- interface **javax.print.FlavorException**
- interface **javax.print.MultiDoc**
- interface **javax.print.MultiDocPrintJob**
- interface **javax.print.MultiDocPrintService**
- class **javax.print.PrintException**
- interface **javax.print.PrintService**
- class **javax.print.PrintServiceLookup**
- class **javax.print.ServiceUI**
- class **javax.print.ServiceUIFactory**
- class **javax.print.SimpleDoc**
- class **javax.print.StreamPrintService**
- class **javax.print.StreamPrintServiceFactory**
- interface **javax.print.URIException**
- interface **javax.print.attribute.Attribute**
- interface **javax.print.attribute.AttributeSet**
- class **javax.print.attribute.AttributeSetUtilities**
- class **javax.print.attribute.DateTimeSyntax**
- interface **javax.print.attribute.DocAttribute**
- interface **javax.print.attribute.DocAttributeSet**
- class **javax.print.attribute.EnumSyntax**
- class **javax.print.attribute.HashAttributeSet**
- class **javax.print.attribute.HashDocAttributeSet**
- class **javax.print.attribute.HashPrintJobAttributeSet**
- class **javax.print.attribute.HashPrintRequestAttributeSet**
- class **javax.print.attribute.HashPrintServiceAttributeSet**
- class **javax.print.attribute.IntegerSyntax**
- interface **javax.print.attribute.PrintJobAttribute**
- interface **javax.print.attribute.PrintJobAttributeSet**
- interface **javax.print.attribute.PrintRequestAttribute**
- interface **javax.print.attribute.PrintRequestAttributeSet**
- interface **javax.print.attribute.PrintServiceAttribute**
- interface **javax.print.attribute.PrintServiceAttributeSet**
- class **javax.print.attribute.ResolutionSyntax**
- class **javax.print.attribute.SetOfIntegerSyntax**
- class **javax.print.attribute.Size2DSyntax**
- interface **javax.print.attribute.SupportedValuesAttribute**
- class **javax.print.attribute.TextSyntax**
- class **javax.print.attribute.URISyntax**
- class **javax.print.attribute.UnmodifiableSetException**
- class **javax.print.attribute.standard.Chromaticity**
- class **javax.print.attribute.standard.ColorSupported**
- class **javax.print.attribute.standard.Compression**
- class **javax.print.attribute.standard.Copies**
- class **javax.print.attribute.standard.CopiesSupported**
- class **javax.print.attribute.standard.DateTimeAtCompleted**
- class **javax.print.attribute.standard.DateTimeAtCreation**
- class **javax.print.attribute.standard.DateTimeAtProcessing**
- class **javax.print.attribute.standard.Destination**
- class **javax.print.attribute.standard.DialogTypeSelection**
- class **javax.print.attribute.standard.DocumentName**
- class **javax.print.attribute.standard.Fidelity**
- class **javax.print.attribute.standard.Finishings**
- class **javax.print.attribute.standard.JobHoldUntil**
- class **javax.print.attribute.standard.JobImpressions**
- class **javax.print.attribute.standard.JobImpressionsCompleted**
- class **javax.print.attribute.standard.JobImpressionsSupported**
- class **javax.print.attribute.standard.JobKOctets**
- class **javax.print.attribute.standard.JobKOctetsProcessed**
- class **javax.print.attribute.standard.JobKOctetsSupported**
- class **javax.print.attribute.standard.JobMediaSheets**
- class **javax.print.attribute.standard.JobMediaSheetsCompleted**
- class **javax.print.attribute.standard.JobMediaSheetsSupported**
- class **javax.print.attribute.standard.JobMessageFromOperator**
- class **javax.print.attribute.standard.JobName**
- class **javax.print.attribute.standard.JobOriginatingUserName**
- class **javax.print.attribute.standard.JobPriority**
- class **javax.print.attribute.standard.JobPrioritySupported**
- class **javax.print.attribute.standard.JobSheets**
- class **javax.print.attribute.standard.JobState**
- class **javax.print.attribute.standard.JobStateReason**
- class **javax.print.attribute.standard.JobStateReasons**
- class **javax.print.attribute.standard.Media**
- class **javax.print.attribute.standard.MediaName**
- class **javax.print.attribute.standard.MediaPrintableArea**
- class **javax.print.attribute.standard.MediaSize$Engineering**
- class **javax.print.attribute.standard.MediaSize$ISO**
- class **javax.print.attribute.standard.MediaSize$JIS**
- class **javax.print.attribute.standard.MediaSize$NA**
- class **javax.print.attribute.standard.MediaSize$Other**
- class **javax.print.attribute.standard.MediaSize**
- class **javax.print.attribute.standard.MediaSizeName**
- class **javax.print.attribute.standard.MediaTray**
- class **javax.print.attribute.standard.MultipleDocumentHandling**
- class **javax.print.attribute.standard.NumberOfDocuments**
- class **javax.print.attribute.standard.NumberOfInterveningJobs**
- class **javax.print.attribute.standard.NumberUp**
- class **javax.print.attribute.standard.NumberUpSupported**
- class **javax.print.attribute.standard.OrientationRequested**
- class **javax.print.attribute.standard.OutputDeviceAssigned**
- class **javax.print.attribute.standard.PDLOverrideSupported**
- class **javax.print.attribute.standard.PageRanges**
- class **javax.print.attribute.standard.PagesPerMinute**
- class **javax.print.attribute.standard.PagesPerMinuteColor**
- class **javax.print.attribute.standard.PresentationDirection**
- class **javax.print.attribute.standard.PrintQuality**
- class **javax.print.attribute.standard.PrinterInfo**
- class **javax.print.attribute.standard.PrinterIsAcceptingJobs**
- class **javax.print.attribute.standard.PrinterLocation**
- class **javax.print.attribute.standard.PrinterMakeAndModel**
- class **javax.print.attribute.standard.PrinterMessageFromOperator**
- class **javax.print.attribute.standard.PrinterMoreInfo**
- class **javax.print.attribute.standard.PrinterMoreInfoManufacturer**
- class **javax.print.attribute.standard.PrinterName**
- class **javax.print.attribute.standard.PrinterResolution**
- class **javax.print.attribute.standard.PrinterState**
- class **javax.print.attribute.standard.PrinterStateReason**
- class **javax.print.attribute.standard.PrinterStateReasons**
- class **javax.print.attribute.standard.PrinterURI**
- class **javax.print.attribute.standard.QueuedJobCount**
- class **javax.print.attribute.standard.ReferenceUriSchemesSupported**
- class **javax.print.attribute.standard.RequestingUserName**
- class **javax.print.attribute.standard.Severity**
- class **javax.print.attribute.standard.SheetCollate**
- class **javax.print.attribute.standard.Sides**
- class **javax.print.event.PrintEvent**
- class **javax.print.event.PrintJobAdapter**
- class **javax.print.event.PrintJobAttributeEvent**
- interface **javax.print.event.PrintJobAttributeListener**
- class **javax.print.event.PrintJobEvent**
- interface **javax.print.event.PrintJobListener**
- class **javax.print.event.PrintServiceAttributeEvent**
- interface **javax.print.event.PrintServiceAttributeListener**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
