package abstracao;

public class Buldogue extends Cachorro {

	@Override
	public void latido() {
		System.out.println("au au au");
		
	}

	@Override
	public void barulho() {
		System.out.println("ronc ronc");
		
	}

	@Override
	public void barulho(String x) {
		System.out.println(x);
		
	}

}
