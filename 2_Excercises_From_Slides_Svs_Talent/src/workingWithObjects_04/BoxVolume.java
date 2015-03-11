package workingWithObjects_04;

public class BoxVolume {

	private int height;
	private int depth;
	private int weight;

	public BoxVolume(int height, int depth, int weight) {
		super();
		this.height = height;
		this.depth = depth;
		this.weight = weight;
	}


	public int vratiVolumen() {
		int volumen = this.depth * this.height * this.weight;
		return volumen;
	}

	public void pecati() {
		System.out.println("The height is: " + this.height);
		System.out.println("The weight is: " + this.weight);
		System.out.println("The depth is: " + this.depth);
	}

	public static void main(String[] args) {

		BoxVolume box1 = new BoxVolume(12, 34, 55);
		BoxVolume box2 = new BoxVolume(11, 45, 43);

		if (box1.vratiVolumen() > box2.vratiVolumen()) {
			box1.pecati();
		} else {
			box2.pecati();
		}

	}

}
