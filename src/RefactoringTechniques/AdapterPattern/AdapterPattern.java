package RefactoringTechniques.AdapterPattern;

class AdapterPattern {
    // sources:
    // https://www.youtube.com/watch?v=cBEUlEHZuqw&list=PLGLfVvz_LVvSuz6NuHAzpM52qKM6bPlCV&index=14&t=20s
    // https://www.baeldung.com/java-adapter-pattern


    // - the adapter pattern connects two incompatible interfaces together that otherwise
    // cannot be connected directly
    // - it wraps an existing class with a new interfaces to make them compatible with the client interface
    // essentially converting an existing interface into another interface that the client expects.

    // why use adapter pattern?
    // - want to reuse legacy code that's incompatible with our current application,
    // without modifying the legacy code directly

    // - make it easier to swap code without disrupting superclass at runtime???
    // - with adapter, can create different methods, so no need to name them the same as a superclass or interface
}
