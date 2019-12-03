import java.util.Arrays;
import java.util.function.Supplier;

public class mainForm {

	public static String compute(final String type) {
		System.out.println("computed " + type);
		return "Executed method compute() of type: " + type;
	}

	public static int[] createData(final String type) {
		System.out.println("CREATED ARRAY \"DATA\" of type: " + type);
		return new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	}

	public static void main(final String[] args) {
		System.out.println("FIRST LINE ON MAIN");
		// LAZY EVALUATION
		// WILL ONLY EXECUTE COMPUTE WHEN THE GET METHOD IS CALLED
		final Supplier<String> lazyComp = () -> compute("LAZY");

		// EAGER EVALUATION
		// WILL RUN COMPUTE AS SOON AS THIS VARIABLE IS CREATED
		final var eagerComp = compute("EAGER");

		// LAZY EVALUATION
		// NO NEED FOR THE BRACKETS, IM ONLY USING THEM FOR SHOWING WHEN ITS CREATED
		// WITH SYSOUT
		final Supplier<int[]> lazyData = () -> createData("LAZY");

		final int[] eagerData = createData("EAGER");

		System.out.println('\n');
		System.out.println("--------- CALLING VARIABLES ---------");
		System.out.println("eagerComp: " + eagerComp + '\n');
		System.out.println("calling lazyComp: ");
		System.out.println(lazyComp.get() + '\n');
		System.out.println("calling eagerData: " + Arrays.toString(eagerData) + '\n');
		System.out.println("calling lazyData: ");
		System.out.println(Arrays.toString(lazyData.get()));

	}
}
