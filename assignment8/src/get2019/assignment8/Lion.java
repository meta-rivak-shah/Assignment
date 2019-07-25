package get2019.assignment8;
/**
 * @param id is the id of Animal
 * @param Name is the name of animal
 * @author Rivak
 *
 */
class Lion extends Mammal{
	Lion(int id ,String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public String getSound() {
		return "roar";
	}

}