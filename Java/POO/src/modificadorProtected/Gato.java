package modificadorProtected;

public class Gato extends Animal {
	   public String cordopelo;
	     
	     public void setNumerodePatas(int numero) {
	    	 this.numeroPatas = numero;
	     }

		@Override
		public String toString() {
			return "Gato [cordopelo=" + cordopelo + ", especie=" + especie + ", numeropatas=" + numeroPatas + "]";
		}
}
