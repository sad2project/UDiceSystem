package ezgames.udicesys.diceModels.abstractions;

import static ezgames.testing.matchers.exceptions.ThrowsA.throwsAn;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * A base class for testing implementations of {@code Die}. All test classes 
 * for {@code Die} implementations should inherit from this test to make 
 * certain that they are following certain invariants.
 */
abstract public class AbstractDieTest
{
	/**
	 * Factory method to create a new {@code Die} of the implementation under 
	 * test with the given name.
	 * <p>
	 * Used by DieTest to test that certain invariants are upheld in all 
	 * implementations</p>
	 * @param name
	 * @return
	 */
	abstract protected Die createTestDie(String name);
	
	/** Die names cannot be blank */
	@Test
	public void blankName()
	{
		assertThat(() -> createTestDie(""), throwsAn(IllegalArgumentException.class));
	}
}
