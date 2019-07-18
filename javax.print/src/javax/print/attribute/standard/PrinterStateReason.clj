(ns javax.print.attribute.standard.PrinterStateReason
  "Class PrinterStateReason is a printing attribute class, an enumeration,
  that provides additional information about the printer's current state,
  i.e., information that augments the value of the printer's
  PrinterState attribute.
  Class PrinterStateReason defines standard printer
  state reason values. A Print Service implementation only needs to report
  those printer state reasons which are appropriate for the particular
  implementation; it does not have to report every defined printer state
  reason.

  Instances of PrinterStateReason do not appear in a Print Service's
  attribute set directly.
  Rather, a PrinterStateReasons
  attribute appears in the Print Service's attribute set. The PrinterStateReasons attribute contains zero, one, or
  more than one PrinterStateReason objects which pertain to the
  Print Service's status, and each PrinterStateReason object is
  associated with a Severity level of REPORT (least severe),
  WARNING, or ERROR (most severe). The printer adds a PrinterStateReason
  object to the Print Service's
  PrinterStateReasons attribute when the
  corresponding condition becomes true of the printer, and the printer
  removes the PrinterStateReason object again when the corresponding
  condition becomes false, regardless of whether the Print Service's overall
  PrinterState also changed.

  IPP Compatibility:
  The string values returned by each individual PrinterStateReason and
  associated Severity object's toString()
  methods, concatenated together with a hyphen (`-`) in
  between, gives the IPP keyword value for a PrinterStateReasons.
  The category name returned by getName() gives the IPP
  attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterStateReason]))

(def *-other
  "Static Constant.

  The printer has detected an error other than ones listed below.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/OTHER)

(def *-media-needed
  "Static Constant.

  A tray has run out of media.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/MEDIA_NEEDED)

(def *-media-jam
  "Static Constant.

  The device has a media jam.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/MEDIA_JAM)

(def *-moving-to-paused
  "Static Constant.

  Someone has paused the printer, but the device(s) are taking an
   appreciable time to stop. Later, when all output has stopped,
   the PrinterState becomes STOPPED,
   and the PAUSED value replaces
   the MOVING_TO_PAUSED value in the PrinterStateReasons attribute. This value must be supported if the
   printer can be paused and the implementation takes significant time to
   pause a device in certain circumstances.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/MOVING_TO_PAUSED)

(def *-paused
  "Static Constant.

  Someone has paused the printer and the printer's PrinterState is STOPPED. In this state, a printer must not produce
   printed output, but it must perform other operations requested by a
   client. If a printer had been printing a job when the printer was
   paused,
   the Printer must resume printing that job when the printer is no longer
   paused and leave no evidence in the printed output of such a pause.
   This value must be supported if the printer can be paused.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/PAUSED)

(def *-shutdown
  "Static Constant.

  Someone has removed a printer from service, and the device may be
   powered down or physically removed.
   In this state, a printer must not produce
   printed output, and unless the printer is realized by a print server
   that is still active, the printer must perform no other operations
   requested by a client.
   If a printer had been printing a job when it was shut down,
   the printer need not resume printing that job when the printer is no
   longer shut down. If the printer resumes printing such a job, it may
   leave evidence in the printed output of such a shutdown, e.g. the part
   printed before the shutdown may be printed a second time after the
   shutdown.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/SHUTDOWN)

(def *-connecting-to-device
  "Static Constant.

  The printer has scheduled a job on the output device and is in the
   process of connecting to a shared network output device (and might not
   be able to actually start printing the job for an arbitrarily long time
   depending on the usage of the output device by other servers on the
   network).

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/CONNECTING_TO_DEVICE)

(def *-timed-out
  "Static Constant.

  The server was able to connect to the output device (or is always
   connected), but was unable to get a response from the output device.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/TIMED_OUT)

(def *-stopping
  "Static Constant.

  The printer is in the process of stopping the device and will be
   stopped in a while.
   When the device is stopped, the printer will change the
   PrinterState to STOPPED. The STOPPING reason is
   never an error, even for a printer with a single output device. When an
   output device ceases accepting jobs, the printer's PrinterStateReasons will have this reason while
   the output device completes printing.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/STOPPING)

(def *-stopped-partly
  "Static Constant.

  When a printer controls more than one output device, this reason
   indicates that one or more output devices are stopped. If the reason's
   severity is a report, fewer than half of the output devices are
   stopped.
   If the reason's severity is a warning, half or more but fewer than
   all of the output devices are stopped.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/STOPPED_PARTLY)

(def *-toner-low
  "Static Constant.

  The device is low on toner.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/TONER_LOW)

(def *-toner-empty
  "Static Constant.

  The device is out of toner.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/TONER_EMPTY)

(def *-spool-area-full
  "Static Constant.

  The limit of persistent storage allocated for spooling has been
   reached.
   The printer is temporarily unable to accept more jobs. The printer will
   remove this reason when it is able to accept more jobs.
   This value should  be used by a non-spooling printer that only
   accepts one or a small number
   jobs at a time or a spooling printer that has filled the spool space.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/SPOOL_AREA_FULL)

(def *-cover-open
  "Static Constant.

  One or more covers on the device are open.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/COVER_OPEN)

(def *-interlock-open
  "Static Constant.

  One or more interlock devices on the printer are unlocked.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/INTERLOCK_OPEN)

(def *-door-open
  "Static Constant.

  One or more doors on the device are open.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/DOOR_OPEN)

(def *-input-tray-missing
  "Static Constant.

  One or more input trays are not in the device.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/INPUT_TRAY_MISSING)

(def *-media-low
  "Static Constant.

  At least one input tray is low on media.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/MEDIA_LOW)

(def *-media-empty
  "Static Constant.

  At least one input tray is empty.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/MEDIA_EMPTY)

(def *-output-tray-missing
  "Static Constant.

  One or more output trays are not in the device.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/OUTPUT_TRAY_MISSING)

(def *-output-area-almost-full
  "Static Constant.

  One or more output areas are almost full
   (e.g. tray, stacker, collator).

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/OUTPUT_AREA_ALMOST_FULL)

(def *-output-area-full
  "Static Constant.

  One or more output areas are full (e.g. tray, stacker, collator).

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/OUTPUT_AREA_FULL)

(def *-marker-supply-low
  "Static Constant.

  The device is low on at least one marker supply (e.g. toner, ink,
   ribbon).

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/MARKER_SUPPLY_LOW)

(def *-marker-supply-empty
  "Static Constant.

  The device is out of at least one marker supply (e.g. toner, ink,
   ribbon).

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/MARKER_SUPPLY_EMPTY)

(def *-marker-waste-almost-full
  "Static Constant.

  The device marker supply waste receptacle is almost full.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/MARKER_WASTE_ALMOST_FULL)

(def *-marker-waste-full
  "Static Constant.

  The device marker supply waste receptacle is full.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/MARKER_WASTE_FULL)

(def *-fuser-over-temp
  "Static Constant.

  The fuser temperature is above normal.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/FUSER_OVER_TEMP)

(def *-fuser-under-temp
  "Static Constant.

  The fuser temperature is below normal.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/FUSER_UNDER_TEMP)

(def *-opc-near-eol
  "Static Constant.

  The optical photo conductor is near end of life.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/OPC_NEAR_EOL)

(def *-opc-life-over
  "Static Constant.

  The optical photo conductor is no longer functioning.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/OPC_LIFE_OVER)

(def *-developer-low
  "Static Constant.

  The device is low on developer.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/DEVELOPER_LOW)

(def *-developer-empty
  "Static Constant.

  The device is out of developer.

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/DEVELOPER_EMPTY)

(def *-interpreter-resource-unavailable
  "Static Constant.

  An interpreter resource is unavailable (e.g., font, form).

  type: javax.print.attribute.standard.PrinterStateReason"
  PrinterStateReason/INTERPRETER_RESOURCE_UNAVAILABLE)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PrinterStateReason and any vendor-defined subclasses, the
   category is class PrinterStateReason itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^PrinterStateReason this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterStateReason and any vendor-defined subclasses, the
   category name is `printer-state-reason`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^PrinterStateReason this]
    (-> this (.getName))))

