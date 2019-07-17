(ns jdk.time.zone.ZoneRulesProvider
  "Provider of time-zone rules to the system.

  This class manages the configuration of time-zone rules.
  The static methods provide the public API that can be used to manage the providers.
  The abstract methods provide the SPI that allows rules to be provided.

  ZoneRulesProvider may be installed in an instance of the Java Platform as
  extension classes, that is, jar files placed into any of the usual extension
  directories. Installed providers are loaded using the service-provider loading
  facility defined by the ServiceLoader class. A ZoneRulesProvider
  identifies itself with a provider configuration file named
  java.time.zone.ZoneRulesProvider in the resource directory
  META-INF/services. The file should contain a line that specifies the
  fully qualified concrete zonerules-provider class name.
  Providers may also be made available by adding them to the class path or by
  registering themselves via registerProvider(java.time.zone.ZoneRulesProvider) method.

  The Java virtual machine has a default provider that provides zone rules
  for the time-zones defined by IANA Time Zone Database (TZDB). If the system
  property java.time.zone.DefaultZoneRulesProvider is defined then
  it is taken to be the fully-qualified name of a concrete ZoneRulesProvider
  class to be loaded as the default provider, using the system class loader.
  If this system property is not defined, a system-default provider will be
  loaded to serve as the default provider.

  Rules are looked up primarily by zone ID, as used by ZoneId.
  Only zone region IDs may be used, zone offset IDs are not used here.

  Time-zone rules are political, thus the data can change at any time.
  Each provider will provide the latest rules for each zone ID, but they
  may also provide the history of how the rules changed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.zone ZoneRulesProvider]))

(defn *get-available-zone-ids
  "Gets the set of available zone IDs.

   These IDs are the string form of a ZoneId.

  returns: a modifiable copy of the set of zone IDs, not null - `java.util.Set<java.lang.String>`"
  ([]
    (ZoneRulesProvider/getAvailableZoneIds )))

(defn *get-rules
  "Gets the rules for the zone ID.

   This returns the latest available rules for the zone ID.

   This method relies on time-zone data provider files that are configured.
   These are loaded using a ServiceLoader.

   The caching flag is designed to allow provider implementations to
   prevent the rules being cached in ZoneId.
   Under normal circumstances, the caching of zone rules is highly desirable
   as it will provide greater performance. However, there is a use case where
   the caching would not be desirable, see provideRules(java.lang.String, boolean).

  zone-id - the zone ID as defined by ZoneId, not null - `java.lang.String`
  for-caching - whether the rules are being queried for caching, true if the returned rules will be cached by ZoneId, false if they will be returned to the user without being cached in ZoneId - `boolean`

  returns: the rules, null if forCaching is true and this
   is a dynamic provider that wants to prevent caching in ZoneId,
   otherwise not null - `java.time.zone.ZoneRules`

  throws: java.time.zone.ZoneRulesException - if rules cannot be obtained for the zone ID"
  ([zone-id for-caching]
    (ZoneRulesProvider/getRules zone-id for-caching)))

(defn *get-versions
  "Gets the history of rules for the zone ID.

   Time-zones are defined by governments and change frequently.
   This method allows applications to find the history of changes to the
   rules for a single zone ID. The map is keyed by a string, which is the
   version string associated with the rules.

   The exact meaning and format of the version is provider specific.
   The version must follow lexicographical order, thus the returned map will
   be order from the oldest known rules to the newest available rules.
   The default 'TZDB' group uses version numbering consisting of the year
   followed by a letter, such as '2009e' or '2012f'.

   Implementations must provide a result for each valid zone ID, however
   they do not have to provide a history of rules.
   Thus the map will always contain one element, and will only contain more
   than one element if historical rule information is available.

  zone-id - the zone ID as defined by ZoneId, not null - `java.lang.String`

  returns: a modifiable copy of the history of the rules for the ID, sorted
    from oldest to newest, not null - `java.util.NavigableMap<java.lang.String,java.time.zone.ZoneRules>`

  throws: java.time.zone.ZoneRulesException - if history cannot be obtained for the zone ID"
  ([zone-id]
    (ZoneRulesProvider/getVersions zone-id)))

(defn *register-provider
  "Registers a zone rules provider.

   This adds a new provider to those currently available.
   A provider supplies rules for one or more zone IDs.
   A provider cannot be registered if it supplies a zone ID that has already been
   registered. See the notes on time-zone IDs in ZoneId, especially
   the section on using the concept of a `group` to make IDs unique.

   To ensure the integrity of time-zones already created, there is no way
   to deregister providers.

  provider - the provider to register, not null - `java.time.zone.ZoneRulesProvider`

  throws: java.time.zone.ZoneRulesException - if a zone ID is already registered"
  ([provider]
    (ZoneRulesProvider/registerProvider provider)))

(defn *refresh
  "Refreshes the rules from the underlying data provider.

   This method allows an application to request that the providers check
   for any updates to the provided rules.
   After calling this method, the offset stored in any ZonedDateTime
   may be invalid for the zone ID.

   Dynamic update of rules is a complex problem and most applications
   should not use this method or dynamic rules.
   To achieve dynamic rules, a provider implementation will have to be written
   as per the specification of this class.
   In addition, instances of ZoneRules must not be cached in the
   application as they will become stale. However, the boolean flag on
   provideRules(String, boolean) allows provider implementations
   to control the caching of ZoneId, potentially ensuring that
   all objects in the system see the new rules.
   Note that there is likely to be a cost in performance of a dynamic rules
   provider. Note also that no dynamic rules provider is in this specification.

  returns: true if the rules were updated - `boolean`

  throws: java.time.zone.ZoneRulesException - if an error occurs during the refresh"
  ([]
    (ZoneRulesProvider/refresh )))

