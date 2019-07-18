(ns jdk.util.ResourceBundle
  "Resource bundles contain locale-specific objects.  When your program needs a
  locale-specific resource, a String for example, your program can
  load it from the resource bundle that is appropriate for the current user's
  locale. In this way, you can write program code that is largely independent
  of the user's locale isolating most, if not all, of the locale-specific
  information in resource bundles.


  This allows you to write programs that can:

   be easily localized, or translated, into different languages
   handle multiple locales at once
   be easily modified later to support even more locales



  Resource bundles belong to families whose members share a common base
  name, but whose names also have additional components that identify
  their locales. For example, the base name of a family of resource
  bundles might be `MyResources`. The family should have a default
  resource bundle which simply has the same name as its family -
  `MyResources` - and will be used as the bundle of last resort if a
  specific locale is not supported. The family can then provide as
  many locale-specific members as needed, for example a German one
  named `MyResources_de`.


  Each resource bundle in a family contains the same items, but the items have
  been translated for the locale represented by that resource bundle.
  For example, both `MyResources` and `MyResources_de` may have a
  String that's used on a button for canceling operations.
  In `MyResources` the String may contain `Cancel` and in
  `MyResources_de` it may contain `Abbrechen`.


  If there are different resources for different countries, you
  can make specializations: for example, `MyResources_de_CH` contains objects for
  the German language (de) in Switzerland (CH). If you want to only
  modify some of the resources
  in the specialization, you can do so.


  When your program needs a locale-specific object, it loads
  the ResourceBundle class using the
  getBundle
  method:



  ResourceBundle myResources =
       ResourceBundle.getBundle(`MyResources`, currentLocale);



  Resource bundles contain key/value pairs. The keys uniquely
  identify a locale-specific object in the bundle. Here's an
  example of a ListResourceBundle that contains
  two key/value pairs:



  public class MyResources extends ListResourceBundle {
      protected Object[][] getContents() {
          return new Object[][] {
              // LOCALIZE THE SECOND STRING OF EACH ARRAY (e.g., `OK`)
              {`OkKey`, `OK`},
              {`CancelKey`, `Cancel`},
              // END OF MATERIAL TO LOCALIZE
         };
      }
  }

  Keys are always Strings.
  In this example, the keys are `OkKey` and `CancelKey`.
  In the above example, the values
  are also Strings--`OK` and `Cancel`--but
  they don't have to be. The values can be any type of object.


  You retrieve an object from resource bundle using the appropriate
  getter method. Because `OkKey` and `CancelKey`
  are both strings, you would use getString to retrieve them:



  button1 = new Button(myResources.getString(`OkKey`));
  button2 = new Button(myResources.getString(`CancelKey`));

  The getter methods all require the key as an argument and return
  the object if found. If the object is not found, the getter method
  throws a MissingResourceException.


  Besides getString, ResourceBundle also provides
  a method for getting string arrays, getStringArray,
  as well as a generic getObject method for any other
  type of object. When using getObject, you'll
  have to cast the result to the appropriate type. For example:



  int[] myIntegers = (int[]) myResources.getObject(`intList`);



  The Java Platform provides two subclasses of ResourceBundle,
  ListResourceBundle and PropertyResourceBundle,
  that provide a fairly simple way to create resources.
  As you saw briefly in a previous example, ListResourceBundle
  manages its resource as a list of key/value pairs.
  PropertyResourceBundle uses a properties file to manage
  its resources.


  If ListResourceBundle or PropertyResourceBundle
  do not suit your needs, you can write your own ResourceBundle
  subclass.  Your subclasses must override two methods: handleGetObject
  and getKeys().


  The implementation of a ResourceBundle subclass must be thread-safe
  if it's simultaneously used by multiple threads. The default implementations
  of the non-abstract methods in this class, and the methods in the direct
  known concrete subclasses ListResourceBundle and
  PropertyResourceBundle are thread-safe.

  ResourceBundle.Control

  The ResourceBundle.Control class provides information necessary
  to perform the bundle loading process by the getBundle
  factory methods that take a ResourceBundle.Control
  instance. You can implement your own subclass in order to enable
  non-standard resource bundle formats, change the search strategy, or
  define caching parameters. Refer to the descriptions of the class and the
  getBundle
  factory method for details.

  For the getBundle factory
  methods that take no ResourceBundle.Control instance, their  default behavior of resource bundle loading
  can be modified with installed ResourceBundleControlProvider implementations. Any installed providers are
  detected at the ResourceBundle class loading time. If any of the
  providers provides a ResourceBundle.Control for the given base name, that ResourceBundle.Control will be used instead of the default ResourceBundle.Control. If there is
  more than one service provider installed for supporting the same base name,
  the first one returned from ServiceLoader will be used.

  Cache Management

  Resource bundle instances created by the getBundle factory
  methods are cached by default, and the factory methods return the same
  resource bundle instance multiple times if it has been
  cached. getBundle clients may clear the cache, manage the
  lifetime of cached resource bundle instances using time-to-live values,
  or specify not to cache resource bundle instances. Refer to the
  descriptions of the getBundle factory method, clearCache, ResourceBundle.Control.getTimeToLive, and ResourceBundle.Control.needsReload for details.

  Example

  The following is a very simple example of a ResourceBundle
  subclass, MyResources, that manages two resources (for a larger number of
  resources you would probably use a Map).
  Notice that you don't need to supply a value if
  a `parent-level` ResourceBundle handles the same
  key with the same value (as for the okKey below).



  // default (English language, United States)
  public class MyResources extends ResourceBundle {
      public Object handleGetObject(String key) {
          if (key.equals(`okKey`)) return `Ok`;
          if (key.equals(`cancelKey`)) return `Cancel`;
          return null;
      }

      public Enumeration<String> getKeys() {
          return Collections.enumeration(keySet());
      }

      // Overrides handleKeySet() so that the getKeys() implementation
      // can rely on the keySet() value.
      protected Set<String> handleKeySet() {
          return new HashSet<String>(Arrays.asList(`okKey`, `cancelKey`));
      }
  }

  // German language
  public class MyResources_de extends MyResources {
      public Object handleGetObject(String key) {
          // don't need okKey, since parent level handles it.
          if (key.equals(`cancelKey`)) return `Abbrechen`;
          return null;
      }

      protected Set<String> handleKeySet() {
          return new HashSet<String>(Arrays.asList(`cancelKey`));
      }
  }

  You do not have to restrict yourself to using a single family of
  ResourceBundles. For example, you could have a set of bundles for
  exception messages, ExceptionResources
  (ExceptionResources_fr, ExceptionResources_de, ...),
  and one for widgets, WidgetResource (WidgetResources_fr,
  WidgetResources_de, ...); breaking up the resources however you like."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util ResourceBundle]))

(defn ->resource-bundle
  "Constructor.

  Sole constructor.  (For invocation by subclass constructors, typically
   implicit.)"
  (^ResourceBundle []
    (new ResourceBundle )))

(defn *get-bundle
  "Returns a resource bundle using the specified base name, target
   locale, class loader and control. Unlike the getBundle
   factory methods with no control argument, the given
   control specifies how to locate and instantiate resource
   bundles. Conceptually, the bundle loading process with the given
   control is performed in the following steps.


   This factory method looks up the resource bundle in the cache for
   the specified baseName, targetLocale and
   loader.  If the requested resource bundle instance is
   found in the cache and the time-to-live periods of the instance and
   all of its parent instances have not expired, the instance is returned
   to the caller. Otherwise, this factory method proceeds with the
   loading process below.

   The control.getFormats method is called to get resource bundle formats
   to produce bundle or resource names. The strings
   `java.class` and `java.properties`
   designate class-based and java.util.property-based resource bundles, respectively. Other strings
   starting with `java.` are reserved for future extensions
   and must not be used for application-defined formats. Other strings
   designate application-defined formats.

   The control.getCandidateLocales method is called with the target
   locale to get a list of candidate Locales for
   which resource bundles are searched.

   The control.newBundle method is called to
   instantiate a ResourceBundle for the base bundle name, a
   candidate locale, and a format. (Refer to the note on the cache
   lookup below.) This step is iterated over all combinations of the
   candidate locales and formats until the newBundle method
   returns a ResourceBundle instance or the iteration has
   used up all the combinations. For example, if the candidate locales
   are Locale(`de`, `DE`), Locale(`de`) and
   Locale(``) and the formats are `java.class`
   and `java.properties`, then the following is the
   sequence of locale-format combinations to be used to call
   control.newBundle.




   Locale

   format



   Locale(`de`, `DE`)

   java.class



   Locale(`de`, `DE`)
   java.properties



   Locale(`de`)
   java.class


   Locale(`de`)
   java.properties


   Locale(``)

   java.class


   Locale(``)
   java.properties





   If the previous step has found no resource bundle, proceed to
   Step 6. If a bundle has been found that is a base bundle (a bundle
   for Locale(``)), and the candidate locale list only contained
   Locale(``), return the bundle to the caller. If a bundle
   has been found that is a base bundle, but the candidate locale list
   contained locales other than Locale(``), put the bundle on hold and
   proceed to Step 6. If a bundle has been found that is not a base
   bundle, proceed to Step 7.

   The control.getFallbackLocale method is called to get a fallback
   locale (alternative to the current target locale) to try further
   finding a resource bundle. If the method returns a non-null locale,
   it becomes the next target locale and the loading process starts over
   from Step 3. Otherwise, if a base bundle was found and put on hold in
   a previous Step 5, it is returned to the caller now. Otherwise, a
   MissingResourceException is thrown.

   At this point, we have found a resource bundle that's not the
   base bundle. If this bundle set its parent during its instantiation,
   it is returned to the caller. Otherwise, its parent chain is
   instantiated based on the list of candidate locales from which it was
   found. Finally, the bundle is returned to the caller.


   During the resource bundle loading process above, this factory
   method looks up the cache before calling the control.newBundle method.  If the time-to-live period of the
   resource bundle found in the cache has expired, the factory method
   calls the control.needsReload
   method to determine whether the resource bundle needs to be reloaded.
   If reloading is required, the factory method calls
   control.newBundle to reload the resource bundle.  If
   control.newBundle returns null, the factory
   method puts a dummy resource bundle in the cache as a mark of
   nonexistent resource bundles in order to avoid lookup overhead for
   subsequent requests. Such dummy resource bundles are under the same
   expiration control as specified by control.

   All resource bundles loaded are cached by default. Refer to
   control.getTimeToLive for details.

   The following is an example of the bundle loading process with the
   default ResourceBundle.Control implementation.

   Conditions:

   Base bundle name: foo.bar.Messages
   Requested Locale: Locale.ITALY
   Default Locale: Locale.FRENCH
   Available resource bundles:
   foo/bar/Messages_fr.properties and
   foo/bar/Messages.properties


   First, getBundle tries loading a resource bundle in
   the following sequence.


   class foo.bar.Messages_it_IT
   file foo/bar/Messages_it_IT.properties
   class foo.bar.Messages_it
   file foo/bar/Messages_it.properties
   class foo.bar.Messages
   file foo/bar/Messages.properties


   At this point, getBundle finds
   foo/bar/Messages.properties, which is put on hold
   because it's the base bundle.  getBundle calls control.getFallbackLocale(`foo.bar.Messages`, Locale.ITALY) which
   returns Locale.FRENCH. Next, getBundle
   tries loading a bundle in the following sequence.


   class foo.bar.Messages_fr
   file foo/bar/Messages_fr.properties
   class foo.bar.Messages
   file foo/bar/Messages.properties


   getBundle finds
   foo/bar/Messages_fr.properties and creates a
   ResourceBundle instance. Then, getBundle
   sets up its parent chain from the list of the candidate locales.  Only
   foo/bar/Messages.properties is found in the list and
   getBundle creates a ResourceBundle instance
   that becomes the parent of the instance for
   foo/bar/Messages_fr.properties.

  base-name - the base name of the resource bundle, a fully qualified class name - `java.lang.String`
  target-locale - the locale for which a resource bundle is desired - `java.util.Locale`
  loader - the class loader from which to load the resource bundle - `java.lang.ClassLoader`
  control - the control which gives information for the resource bundle loading process - `java.util.ResourceBundle$Control`

  returns: a resource bundle for the given base name and locale - `java.util.ResourceBundle`

  throws: java.lang.NullPointerException - if baseName, targetLocale, loader, or control is null"
  (^java.util.ResourceBundle [^java.lang.String base-name ^java.util.Locale target-locale ^java.lang.ClassLoader loader ^java.util.ResourceBundle$Control control]
    (ResourceBundle/getBundle base-name target-locale loader control))
  (^java.util.ResourceBundle [^java.lang.String base-name ^java.util.Locale target-locale ^java.util.ResourceBundle$Control control]
    (ResourceBundle/getBundle base-name target-locale control))
  (^java.util.ResourceBundle [^java.lang.String base-name ^java.util.ResourceBundle$Control control]
    (ResourceBundle/getBundle base-name control))
  (^java.util.ResourceBundle [^java.lang.String base-name]
    (ResourceBundle/getBundle base-name)))

(defn *clear-cache
  "Removes all resource bundles from the cache that have been loaded
   using the given class loader.

  loader - the class loader - `java.lang.ClassLoader`

  throws: java.lang.NullPointerException - if loader is null"
  ([^java.lang.ClassLoader loader]
    (ResourceBundle/clearCache loader))
  ([]
    (ResourceBundle/clearCache )))

(defn get-base-bundle-name
  "Returns the base name of this bundle, if known, or null if unknown.

   If not null, then this is the value of the baseName parameter
   that was passed to the ResourceBundle.getBundle(...) method
   when the resource bundle was loaded.

  returns: The base name of the resource bundle, as provided to and expected
   by the ResourceBundle.getBundle(...) methods. - `java.lang.String`"
  (^java.lang.String [^ResourceBundle this]
    (-> this (.getBaseBundleName))))

(defn get-string
  "Gets a string for the given key from this resource bundle or one of its parents.
   Calling this method is equivalent to calling

   (String) getObject(key).

  key - the key for the desired string - `java.lang.String`

  returns: the string for the given key - `java.lang.String`

  throws: java.lang.NullPointerException - if key is null"
  (^java.lang.String [^ResourceBundle this ^java.lang.String key]
    (-> this (.getString key))))

(defn get-string-array
  "Gets a string array for the given key from this resource bundle or one of its parents.
   Calling this method is equivalent to calling

   (String[]) getObject(key).

  key - the key for the desired string array - `java.lang.String`

  returns: the string array for the given key - `java.lang.String[]`

  throws: java.lang.NullPointerException - if key is null"
  ([^ResourceBundle this ^java.lang.String key]
    (-> this (.getStringArray key))))

(defn get-object
  "Gets an object for the given key from this resource bundle or one of its parents.
   This method first tries to obtain the object from this resource bundle using
   handleGetObject.
   If not successful, and the parent resource bundle is not null,
   it calls the parent's getObject method.
   If still not successful, it throws a MissingResourceException.

  key - the key for the desired object - `java.lang.String`

  returns: the object for the given key - `java.lang.Object`

  throws: java.lang.NullPointerException - if key is null"
  (^java.lang.Object [^ResourceBundle this ^java.lang.String key]
    (-> this (.getObject key))))

(defn get-locale
  "Returns the locale of this resource bundle. This method can be used after a
   call to getBundle() to determine whether the resource bundle returned really
   corresponds to the requested locale or is a fallback.

  returns: the locale of this resource bundle - `java.util.Locale`"
  (^java.util.Locale [^ResourceBundle this]
    (-> this (.getLocale))))

(defn get-keys
  "Returns an enumeration of the keys.

  returns: an Enumeration of the keys contained in
           this ResourceBundle and its parent bundles. - `java.util.Enumeration<java.lang.String>`"
  (^java.util.Enumeration [^ResourceBundle this]
    (-> this (.getKeys))))

(defn contains-key
  "Determines whether the given key is contained in
   this ResourceBundle or its parent bundles.

  key - the resource key - `java.lang.String`

  returns: true if the given key is
          contained in this ResourceBundle or its
          parent bundles; false otherwise. - `boolean`

  throws: java.lang.NullPointerException - if key is null"
  (^Boolean [^ResourceBundle this ^java.lang.String key]
    (-> this (.containsKey key))))

(defn key-set
  "Returns a Set of all keys contained in this
   ResourceBundle and its parent bundles.

  returns: a Set of all keys contained in this
           ResourceBundle and its parent bundles. - `java.util.Set<java.lang.String>`"
  (^java.util.Set [^ResourceBundle this]
    (-> this (.keySet))))

