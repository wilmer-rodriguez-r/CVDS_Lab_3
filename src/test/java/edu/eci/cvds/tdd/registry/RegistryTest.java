package edu.eci.cvds.tdd.registry;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class RegistryTest {
    private final Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {
        Person person = new Person();
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
        // TODO Complete with more test cases
    }

    public void validateAgeSuperiorLimit() {
        Person person = new Person("Wilmer Rodriguez", 123456789, 91, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    public void validateAge() {
        Person person = new Person("Wilmer Rodriguez", 123456789, 18, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    public void validateUnderAge() {
        Person person = new Person("Wilmer Rodriguez", 123456789, 17, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    public void validateAgeInferiorLimit() {
        Person person = new Person("Wilmer Rodriguez", 123456789, -1, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
}
