
public class OOPTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human adrianHuman = new Human();
		System.out.println(adrianHuman.getHeight());
		Human anotherHuman = new Human(72, "blue", 30, "black");
		System.out.println(anotherHuman.getEyeColor());
		Pet myDog = new Pet();
		myDog.setAge(10);
		adrianHuman.adoptPet(myDog);
		for (Pet thisPet : adrianHuman.getPets()) {
			System.out.println(thisPet.getSpecies()); // Type "sysout" then press Ctrl + Space
		}
	}

}
