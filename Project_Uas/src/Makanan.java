
public class Makanan {
	private String namaMakanan;
	private int harga;
	
	public Makanan(String namaMakanan, int harga) {
		this.namaMakanan=namaMakanan;
		this.harga=harga;
	}
	
	//overloading	
	public Makanan(int harga, String makanan) {
		this.namaMakanan=makanan;
		this.harga=harga;
	}
	
//	getter NamaMakanan
	public String getNamaMakanan() {
		return namaMakanan;
	}
	
//	getter harga
	public int getHarga() {
		return harga;
	}
	
}
