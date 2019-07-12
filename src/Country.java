
public class Country {
	protected String name;
	protected long population;
	
	
	
	public Country() {
		super();
	}
	public Country(String name, long population) {
		super();
		this.name = name;
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	
}
