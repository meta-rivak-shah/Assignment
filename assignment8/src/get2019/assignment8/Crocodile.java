package get2019.assignment8;
/**
 * @param Id is the id of crocodile
 * @param name is the name of animal
 * @func getSound is the sound of animal
 * @author Rivak
 *
 */
class Crocodile extends Reptile{
	Crocodile(int id ,String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public String getSound() {
		
		return "Hiss";
	}

}