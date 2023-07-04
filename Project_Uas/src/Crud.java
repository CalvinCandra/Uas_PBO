import java.util.ArrayList;

interface Test{
	public void test();
} 

abstract class Crud {
	public ArrayList<Makanan> listMakanan = new ArrayList<Makanan>();
	
	public abstract void tambahMenu(Makanan listMakanan);
	public abstract void updateMenu(int nomor, Makanan listMakanan);
	public abstract void deleteMenu(int nomor);
	
	public void diskon(int totalHarga) {
		if(totalHarga >= 100000) {
			int diskon = totalHarga * 20/100;
			int HargaDiskon = totalHarga - diskon;
			
			System.out.println("============================ TOTAL PEMBAYARAN =============================");
			System.out.println("Total Harga : " +totalHarga);
			System.out.println("Selamat Anda Mendapatkan Diskon Sebesar 20%");
			
			System.out.println("\nTotal pembayaran Anda Menjadi : Rp. " +HargaDiskon);
			System.out.println("======================== TERIMA KASIH =========================");
		}else if(totalHarga >= 50000) {
			int diskon = totalHarga * 10/100;
			int HargaDiskon = totalHarga - diskon;
			
			System.out.println("============================ TOTAL PEMBAYARAN =============================");
			System.out.println("Total Harga : " +totalHarga);
			System.out.println("Selamat Anda Mendapatkan Diskon Sebesar 10%");
			System.out.println("\nTotal pembayaran Anda Menjadi : Rp. " +HargaDiskon);
			System.out.println("======================== TERIMA KASIH =========================");
		}else {
			System.out.println("============================ TOTAL PEMBAYARAN =============================");
			System.out.println("\nTotal pembayaran Anda Menjadi : Rp. " +totalHarga);
			System.out.println("======================== TERIMA KASIH =========================");
		}
	}
	
}



class Turunan extends Crud implements Test{

	@Override
	public void tambahMenu(Makanan listMakanan) {
		this.listMakanan.add(listMakanan);
	}

	@Override
	public void updateMenu(int nomor, Makanan listMakanan) {
		this.listMakanan.set((nomor-1), listMakanan);
		
	}

	@Override
	public void deleteMenu(int nomor) {
		listMakanan.remove(nomor-1);
		System.out.println("Menu Makanan Berhasil Di Delete");
	}

	@Override
	public void test() {
		System.out.println("Ini Merupakan Teks Dari Override Method Test Pada Interface");
		
	}


}
