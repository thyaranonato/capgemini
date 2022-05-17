package modificadorProtected;

public class Animal {
	public String especie;
	protected int numeroPatas;
	
	@Override
	public String toString() {
		return "Animal [especie=" + especie + ", numeroPatas=" + numeroPatas + "]";
	}
}
