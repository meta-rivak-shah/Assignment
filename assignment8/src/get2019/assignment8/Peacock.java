package get2019.assignment8;
/**
 * @param id is the id of animal
 * @param name is the name of animal
 * @func sound is the sound of aniaml
 * @author Rivak
 *
 */
class Peacock extends Bird{
	Peacock(int id ,String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public String getSound() {
		return "Scream";
	}

}