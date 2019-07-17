(ns javax.annotation.processing.Processor
  "The interface for an annotation processor.

  Annotation processing happens in a sequence of javax.annotation.processing.rounds.  On each
  round, a processor may be asked to process a
  subset of the annotations found on the source and class files
  produced by a prior round.  The inputs to the first round of
  processing are the initial inputs to a run of the tool; these
  initial inputs can be regarded as the output of a virtual zeroth
  round of processing.  If a processor was asked to process on a
  given round, it will be asked to process on subsequent rounds,
  including the last round, even if there are no annotations for it
  to process.  The tool infrastructure may also ask a processor to
  process files generated implicitly by the tool's operation.

   Each implementation of a Processor must provide a
  public no-argument constructor to be used by tools to instantiate
  the processor.  The tool infrastructure will interact with classes
  implementing this interface as follows:



  If an existing Processor object is not being used, to
  create an instance of a processor the tool calls the no-arg
  constructor of the processor class.

  Next, the tool calls the init method with
  an appropriate ProcessingEnvironment.

  Afterwards, the tool calls getSupportedAnnotationTypes, getSupportedOptions, and getSupportedSourceVersion.  These methods are only called once per
  run, not on each round.

  As appropriate, the tool calls the process
  method on the Processor object; a new Processor
  object is not created for each round.



  If a processor object is created and used without the above
  protocol being followed, then the processor's behavior is not
  defined by this interface specification.

   The tool uses a discovery process to find annotation
  processors and decide whether or not they should be run.  By
  configuring the tool, the set of potential processors can be
  controlled.  For example, for a JavaCompiler the list of candidate processors to run can be
  set directly or controlled by a search path
  used for a java.util.service-style
  lookup.  Other tool implementations may have different
  configuration mechanisms, such as command line options; for
  details, refer to the particular tool's documentation.  Which
  processors the tool asks to run is a function
  of the types of the annotations javax.lang.model.present
  on the root elements, what annotation types a processor
  supports, and whether or not a processor claims the annotation types it processes.  A processor will be asked to
  process a subset of the annotation types it supports, possibly an
  empty set.

  For a given round, the tool computes the set of annotation types
  that are present on the elements enclosed within the root elements.
  If there is at least one annotation type present, then as
  processors claim annotation types, they are removed from the set of
  unmatched annotation types.  When the set is empty or no more
  processors are available, the round has run to completion.  If
  there are no annotation types present, annotation processing still
  occurs but only universal processors which support
  processing all annotation types, `*`, can claim the (empty)
  set of annotation types.

  An annotation type is considered present if there is at least
  one annotation of that type present on an element enclosed within
  the root elements of a round. For this purpose, a type parameter is
  considered to be enclosed by its generic
  element. Annotations on type uses, as opposed to
  annotations on elements, are ignored when computing whether or not
  an annotation type is present.

  An annotation is present if it meets the definition of being
  present given in AnnotatedConstruct. In brief, an
  annotation is considered present for the purposes of discovery if
  it is directly present or present via inheritance. An annotation is
  not considered present by virtue of being wrapped by a
  container annotation. Operationally, this is equivalent to an
  annotation being present on an element if and only if it would be
  included in the results of Elements.getAllAnnotationMirrors(Element) called on that element. Since
  annotations inside container annotations are not considered
  present, to properly process java.lang.annotation.repeatable annotation types,
  processors are advised to include both the repeatable annotation
  type and its containing annotation type in the set of supported annotation types of a
  processor.

  Note that if a processor supports `*` and returns true, all annotations are claimed.  Therefore, a universal
  processor being used to, for example, implement additional validity
  checks should return false so as to not prevent other such
  checkers from being able to run.

  If a processor throws an uncaught exception, the tool may cease
  other active annotation processors.  If a processor raises an
  error, the current round will run to completion and the subsequent
  round will indicate an error was raised.  Since annotation processors are run in a
  cooperative environment, a processor should throw an uncaught
  exception only in situations where no error recovery or reporting
  is feasible.

  The tool environment is not required to support annotation
  processors that access environmental resources, either javax.annotation.processing.per round or javax.annotation.processing.cross-round, in a multi-threaded fashion.

  If the methods that return configuration information about the
  annotation processor return null, return other invalid
  input, or throw an exception, the tool infrastructure must treat
  this as an error condition.

  To be robust when running in different tool implementations, an
  annotation processor should have the following properties:



  The result of processing a given input is not a function of the presence or absence
  of other inputs (orthogonality).

  Processing the same input produces the same output (consistency).

  Processing input A followed by processing input B
  is equivalent to processing B then A
  (commutativity)

  Processing an input does not rely on the presence of the output
  of other annotation processors (independence)



  The Filer interface discusses restrictions on how
  processors can operate on files.

  Note that implementors of this interface may find it convenient
  to extend AbstractProcessor rather than implementing this
  interface directly."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.annotation.processing Processor]))

(defn get-supported-options
  "Returns the options recognized by this processor.  An
   implementation of the processing tool must provide a way to
   pass processor-specific options distinctly from options passed
   to the tool itself, see getOptions.

   Each string returned in the set must be a period separated
   sequence of identifiers:



   SupportedOptionString:
   Identifiers

   Identifiers:
    Identifier
    Identifier . Identifiers

   Identifier:
   Syntactic identifier, including keywords and literals



    A tool might use this information to determine if any
   options provided by a user are unrecognized by any processor,
   in which case it may wish to report a warning.

  returns: the options recognized by this processor or an
           empty collection if none - `java.util.Set<java.lang.String>`"
  ([this]
    (-> this (.getSupportedOptions))))

(defn get-supported-annotation-types
  "Returns the names of the annotation types supported by this
   processor.  An element of the result may be the canonical
   (fully qualified) name of a supported annotation type.
   Alternately it may be of the form `name.*`
   representing the set of all annotation types with canonical
   names beginning with `name.`.  Finally, `*` by itself represents the set of all annotation types,
   including the empty set.  Note that a processor should not
   claim `*` unless it is actually processing all files;
   claiming unnecessary annotations may cause a performance
   slowdown in some environments.

   Each string returned in the set must be accepted by the
   following grammar:



   SupportedAnnotationTypeString:
   TypeName DotStaropt
   *

   DotStar:
   . *



   where TypeName is as defined in
   The Java™ Language Specification.

  returns: the names of the annotation types supported by this processor - `java.util.Set<java.lang.String>`"
  ([this]
    (-> this (.getSupportedAnnotationTypes))))

(defn get-supported-source-version
  "Returns the latest source version supported by this annotation
   processor.

  returns: the latest source version supported by this annotation
   processor. - `javax.lang.model.SourceVersion`"
  ([this]
    (-> this (.getSupportedSourceVersion))))

(defn init
  "Initializes the processor with the processing environment.

  processing-env - environment for facilities the tool framework provides to the processor - `javax.annotation.processing.ProcessingEnvironment`"
  ([this processing-env]
    (-> this (.init processing-env))))

(defn process
  "Processes a set of annotation types on type elements
   originating from the prior round and returns whether or not
   these annotation types are claimed by this processor.  If true is returned, the annotation types are claimed and subsequent
   processors will not be asked to process them; if false
   is returned, the annotation types are unclaimed and subsequent
   processors may be asked to process them.  A processor may
   always return the same boolean value or may vary the result
   based on chosen criteria.

   The input set will be empty if the processor supports `*` and the root elements have no annotations.  A Processor must gracefully handle an empty set of annotations.

  annotations - the annotation types requested to be processed - `javax.lang.model.element.TypeElement>`
  round-env - environment for information about the current and prior round - `javax.annotation.processing.RoundEnvironment`

  returns: whether or not the set of annotation types are claimed by this processor - `boolean`"
  ([this annotations round-env]
    (-> this (.process annotations round-env))))

(defn get-completions
  "Returns to the tool infrastructure an iterable of suggested
   completions to an annotation.  Since completions are being asked
   for, the information provided about the annotation may be
   incomplete, as if for a source code fragment. A processor may
   return an empty iterable.  Annotation processors should focus
   their efforts on providing completions for annotation members
   with additional validity constraints known to the processor, for
   example an int member whose value should lie between 1
   and 10 or a string member that should be recognized by a known
   grammar, such as a regular expression or a URL.

   Since incomplete programs are being modeled, some of the
   parameters may only have partial information or may be null.  At least one of element and userText
   must be non-null.  If element is non-null, annotation and member may be null.  Processors may not throw a NullPointerException
   if some parameters are null; if a processor has no
   completions to offer based on the provided information, an
   empty iterable can be returned.  The processor may also return
   a single completion with an empty value string and a message
   describing why there are no completions.

   Completions are informative and may reflect additional
   validity checks performed by annotation processors.  For
   example, consider the simple annotation:




   @MersennePrime {
      int value();
   }


   (A Mersenne prime is prime number of the form
   2n - 1.) Given an AnnotationMirror
   for this annotation type, a list of all such primes in the
   int range could be returned without examining any other
   arguments to getCompletions:




   import static javax.annotation.processing.Completions.*;
   ...
   return Arrays.asList(of(`3`),
                        of(`7`),
                        of(`31`),
                        of(`127`),
                        of(`8191`),
                        of(`131071`),
                        of(`524287`),
                        of(`2147483647`));


   A more informative set of completions would include the number
   of each prime:




   return Arrays.asList(of(`3`,          `M2`),
                        of(`7`,          `M3`),
                        of(`31`,         `M5`),
                        of(`127`,        `M7`),
                        of(`8191`,       `M13`),
                        of(`131071`,     `M17`),
                        of(`524287`,     `M19`),
                        of(`2147483647`, `M31`));


   However, if the userText is available, it can be checked
   to see if only a subset of the Mersenne primes are valid.  For
   example, if the user has typed



   @MersennePrime(1



   the value of userText will be `1`; and only
   two of the primes are possible completions:




   return Arrays.asList(of(`127`,        `M7`),
                        of(`131071`,     `M17`));


   Sometimes no valid completion is possible.  For example, there
   is no in-range Mersenne prime starting with 9:



   @MersennePrime(9



   An appropriate response in this case is to either return an
   empty list of completions,




   return Collections.emptyList();


   or a single empty completion with a helpful message




   return Arrays.asList(of(``, `No in-range Mersenne primes start with 9`));

  element - the element being annotated - `javax.lang.model.element.Element`
  annotation - the (perhaps partial) annotation being applied to the element - `javax.lang.model.element.AnnotationMirror`
  member - the annotation member to return possible completions for - `javax.lang.model.element.ExecutableElement`
  user-text - source code text to be completed - `java.lang.String`

  returns: suggested completions to the annotation - `java.lang.Iterable<? extends javax.annotation.processing.Completion>`"
  ([this element annotation member user-text]
    (-> this (.getCompletions element annotation member user-text))))

