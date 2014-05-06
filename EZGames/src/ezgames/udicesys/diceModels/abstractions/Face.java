package ezgames.udicesys.diceModels.abstractions;

import ezgames.annotations.Immutable;
import ezgames.utils.collections.SimpleCollection;

@Immutable
public interface Face extends Iterable<FaceValue>
{
	// String name();
	// int getValueForRelationship(Relationship aRelationship) throws IllegalArgumentException;
	// boolean hasRelationship(Relationship rel);
	// /**
	// * @return {@code true} if there is only one {@code FaceValue}, and that
	// {@code FaceValue} is numeric
	// */
	// boolean isNumericFace();
	// boolean isSingleValueFace();
	SimpleCollection<Relationship> listRelationships();
	// Iterable<Effect> listEffects();
}