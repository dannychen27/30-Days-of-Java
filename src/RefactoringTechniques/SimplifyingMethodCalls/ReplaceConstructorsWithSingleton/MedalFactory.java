package RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton;

import java.lang.reflect.Method;

class MedalFactory {

    Athlete getMedalType(String medalType, String athleteName) {
        try {
            // use reflections API -- reflections are a kind of "class manipulation."
            Class[] athleteNameParameter = new Class[] {String.class};
            Method getInstanceMethod = Class.forName(medalType).getMethod("getInstance", athleteNameParameter);
            Object[] parameters = new Object[] {athleteName};
            return (Athlete) getInstanceMethod.invoke(null, parameters);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Athlete Type");
        }
    }
}
