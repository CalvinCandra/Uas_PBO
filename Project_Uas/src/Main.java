import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static Scanner scan = new Scanner(System.in);
	public static Turunan proses = new Turunan();
//	public static test_1 test = new test_1();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		initMakanan();;
		String cobaLagi = "n";
		
		do {
			showMakanan();
			int pilihan = pilihMenu();
			
			switch(pilihan) {
				case 1:
					tambahMenu();
					break;
				case 2:
					updateMenu();
					break;
				case 3:
					deleteMenu();
					break;
				case 4:
					transaksi();
					break;
				case 5:
					proses.test();
					break;
				default:
					System.out.println("Inputan Salah Silakan Pilih Angka 1-3");
					break;
			}
			
			System.out.println("Coba Lagi (y/n)? : ");
			while (!scan.hasNext("[yn]")) {
			    System.out.println("Input harus berupa y atau n!");
			    scan.next();
			}
			
			cobaLagi = scan.next();
		}while (cobaLagi.equals("y"));
		
		

	}
	
//	Menginit  Menu Menu Ke Dalam ArrayList
	public static void initMakanan() {
		//kirim value parameter ke method Makanan (String namaMakanan, int harga)		
		Makanan makan1 = new Makanan("Nasi Ayam", 10000);
		Makanan makan2 = new Makanan("Ayam Geprek", 10000);
		Makanan makan3 = new Makanan("Ayam Bakar", 15000);
		
		Makanan test = new Makanan ();
		test.SetNamaMakanan("Ayam Guling");
		test.SetHarga(10000);
		
		//tambah ke dalam arraylist		
		proses.listMakanan.add(makan1);
		proses.listMakanan.add(makan2);
		proses.listMakanan.add(makan3);
		proses.listMakanan.add(test);
	}
	
	
//	Show Menu Makanan
	public static void showMakanan() {
		System.out.println("=============== DAFTAR MENU SERBA AYAM  ===============");
		System.out.println("No" + "\tNama" + "\t\t\tHarga");
		//init i untuk nomor di depan nama menu		
		int i = 0;
		//melakukan perulangan dimana variabel makan berType class Makanan dan nanti makan akan berisi element dari listMakanan		
		for (Makanan makan : proses.listMakanan) {
			i++;
			System.out.println((i) + "\t" + makan.getNamaMakanan() + "\t\t" + makan.getHarga());
		}
		
	}
	
	
// Memilih Action
	public static int pilihMenu() {
		System.out.println("\nACTION");
		System.out.println("1. Tambah Menu");
		System.out.println("2. Update Menu");
		System.out.println("3. Delete Menu");
		System.out.println("4. Transaksi");
		System.out.println("5. Panggil Interface");
		System.out.println("Masukan Opsi : "); 
		
		//variabel untuk melakukan perulangan		
		boolean isValidMenu = false;
		
		int pilih = 0;
		
		//melakukan perulangan jika isValidMenu tetap false		
		while(!isValidMenu) {
			
			try {
				
				// Validasi Jika User Menginput Huruf pada inputan (Dengan fungsi hasNextInt())   	
				while(!scan.hasNextInt()) {
					System.out.println("\nInput  harus berupa angka!");
					System.out.println("Masukan Opsi : ");
					scan.next();
				}
				
				pilih = scan.nextInt();
				
				if(pilih > 5 || pilih < 0) {
					throw new Exception("Nomor Menu Tidak Ada");
				}
				
				//mengubah isValidMenu agar perulangan tidak berkerja				
				isValidMenu = true;
				
			}catch(Exception e) {
	    		System.out.println(e.getMessage());
	    	}
			
		}
		return pilih;
			
}
	
//	method tambah
	public static void tambahMenu() {
		System.out.println("Anda Memilih Pilihan Tambah Menu");
		
		// membuat hashset dengan nama variabel cek		
		 HashSet<String> cek = new HashSet<String>();
		 //memasukan elemen elemen array ke dalam variabel cek		 
		 for(Makanan makan : proses.listMakanan) {
				cek.add(makan.getNamaMakanan());
			}
		
		System.out.print("Masukan Nama Makanan : ");
		scan.nextLine();
		String namaMakanan = scan.nextLine();
		
		//mencocokan apakah variabel namaMakanan sudah ada pada arralist apa blm dengan perulangan		
		while(cek.contains(namaMakanan)) {
			System.out.println("\nNama Menu Sudah Ada");
			System.out.print("Masukan Nama Makanan : ");
			namaMakanan = scan.nextLine();
		}
		
		String nama = namaMakanan;
		
		
		System.out.print("Masukan Harga Makanan : ");
		
		// Validasi Jika User Menginput Huruf pada inputan harga (Dengan fungsi hasNextInt())   	
    	while(!scan.hasNextInt()) {
    		 System.out.println("\nInput Harga harus berupa angka!");
    		 System.out.print("Masukan Harga Makanan : ");
    	     scan.next();
    	}
    	
		int harga = scan.nextInt();
	   	

		// mengirim inputan ke method Makanan Dengan Parameter (int harga, String makanan)		
		Makanan tambah = new Makanan(harga, nama);
		// Memanggil Method tambahMenu pada Class Crud		
		proses.tambahMenu(tambah);
		
	}
	
//	method Update
	public static void updateMenu() {
	    System.out.println("Anda Memilih Pilihan Update Menu");
	    
	    //variabel untuk melakukan perulangan	
	    boolean ValidNomor = false;
	    
	    // Perulangan Untuk Melakukan Input Nomor Menu Jika Inputan User Lebih
	    while(!ValidNomor) {
	    	
	    	System.out.println("Masukan Nomor Menu Yang Mau di Update : ");
	    	
	    	try {
	    		// Validasi Jika User Menginput Huruf Pada Inputan Memasukan Nomor Menu	    	
	    		while(!scan.hasNextInt()) {
	    			System.out.println("\nInput Nomor Menu harus berupa angka!");
	    			System.out.println("Masukan Nomor Menu Yang Mau di Update : ");
	    			scan.next();
	    		}
	    		
	    		int nomor = scan.nextInt();
	    		
	    		// Pengecekan Jika User Input Menu Lebih dari Seharusnya	    		
	    		if (nomor < 1 || nomor > proses.listMakanan.size()) {
	    			//Jika inputan User Lebih, Maka Akan Melempar Pesan Ke Catch	    			
	    			throw new Exception("Nomor Menu Tidak Ada");
	    		}
	    		
	    		//mengubah ValidNomor agar perulangan tidak berkerja		    		
	    		ValidNomor = true;
	    		
	    		System.out.print("Masukan Nama Makanan Baru : ");
	    		scan.nextLine();
	    		String namaMakanan = scan.nextLine();
	    		
	    		// Jika Inputan Nama Makanan Kosong, maka Data Yang Sebelumnnya Tetap Ada 	        
	    		if (namaMakanan.isEmpty()) {
	    			namaMakanan = proses.listMakanan.get(nomor-1).getNamaMakanan();
	    		}
	    		
	    		System.out.print("Masukan Harga Makanan Baru : ");
	    		String hargaMakanan = scan.nextLine();
	    		
	    		// Jika Inputan Harga Kosong, maka Data Yang Sebelumnnya Tetap Ada dan akan diubah menjadi data tipe String	
	    		if (hargaMakanan.isEmpty()) {
	    			hargaMakanan = Integer.toString(proses.listMakanan.get(nomor-1).getHarga());
	    		}else {	    			
	    			boolean isValid = false;
	    			
	    			// perulangan dengan kondisi tidak sama dengan isValid (jika isValid true maka perulangan selesai)	        	
	    			while(!isValid) {
	    				try {
	    					Integer.parseInt(hargaMakanan);
	    					isValid = true;
	    				} catch (NumberFormatException e) {
	    					System.out.println("Input Harga harus berupa angka!");
	    					System.out.print("Masukan Harga Makanan Baru : ");
	    					hargaMakanan = scan.nextLine();
	    				}
	    			}
	    		}
	    		
	    		// membuat variabel untuk melakukan validasi    	
	    		
	    		int harga = Integer.parseInt(hargaMakanan);
	    		
	    		// mengirim inputan ke method Makanan Dengan Parameter (String Makanan, int harga)	
	    		Makanan edit = new Makanan(namaMakanan, harga);
	    		proses.updateMenu(nomor,edit);
	    		
	    	}catch(Exception e) {
	    		System.out.println(e.getMessage());
	    	}
	    }


	}
	
//	method Delete
	public static void deleteMenu() {
		System.out.println("Anda Memilih Pilihan Delete Menu");
		
		 boolean ValidNomor = false;
		    
		// Perulangan Untuk Melakukan Input Nomor Menu Jika Inputan User Lebih
		 while(!ValidNomor) {
			 System.out.println("Masukan Nomor Menu Yang Mau di Delete : ");
			 
			 try {
				 
				 while(!scan.hasNextInt()) {
					 System.out.println("\nInput harus berupa angka!");
					 System.out.println("Masukan Nomor Menu Yang Mau di Delete : ");
					 scan.next();
				 }
				 
				 int nomor = scan.nextInt();
				 
				 if (nomor < 1 || nomor > proses.listMakanan.size()) {
		    		//Jika inputan User Lebih, Maka Akan Melempar Pesan Ke Catch	    			
		    		throw new Exception("Nomor Menu Tidak Ada");
				 }
		    		
				 // Jika Inputan Nomor Sudah Benar Maka While Yang Sebelumnya Berhenti	    		
				 ValidNomor = true;
				 
				 System.out.println("Apakah Anda Ingin Menghapus Makanan " +proses.listMakanan.get(nomor-1).getNamaMakanan() + " Dari Menu? (y/n)");
					 
				 while (!scan.hasNext("[yn]")) {
					System.out.println("Input harus berupa y atau n!");
					scan.next();
				 }
				 
				String validasi = scan.next();
					
				if(validasi.equals("y") ) {			
					proses.deleteMenu(nomor);
				}
				 
			 }catch(Exception e) {
				 System.out.println("Nomor Menu Tidak Ada");
			 }	
		 }
		
		
	}
	
//	method transaksi
	public static void transaksi() {
        System.out.println("Anda Memilih Pilihan Transaksi");
        
        String validasi = "n";
        int totalHarga = 0;
        do {
        	boolean isValidMenu = false;
	        	showMakanan();
	        	while(!isValidMenu) {        		
	        		System.out.print("Masukan Nomor Menu : ");
	        		try {
	        			// Validasi Jika User Menginput Huruf Pada Inputan Memasukan Nomor Menu Yang Mau Di Update	    	
	        			while(!scan.hasNextInt()) {
	        				System.out.println("\nInput harus berupa angka!");
	        				System.out.print("Masukan Nomor Menu : ");
	        				scan.next();
	        			}
	        			
	        			int nomor = scan.nextInt();
	        			
	        			if (nomor < 0 || nomor > proses.listMakanan.size()) {
	        				//Jika inputan User Lebih, Maka Akan Melempar Pesan Ke Catch	    			
	        				throw new Exception("Nomor Menu Tidak Ada");
	        			}
	        			
	        			isValidMenu = true;
	        			
	        			System.out.print("Masukan Jumlah Pesanan : ");
	        			
	        			while(!scan.hasNextInt()) {
	        				System.out.println("\nInput harus berupa angka!");
	        				System.out.print("Masukan Jumlah Pesanan : ");
	        				scan.next();
	        			}
	        			
	        			int jumlah = scan.nextInt();
	        			
	        			int harga = proses.listMakanan.get(nomor - 1).getHarga();
	        			int total = harga * jumlah;
	        			
	        			totalHarga += total;
	        			
	        		} catch (Exception e) {
	        			System.out.println(e.getMessage());
	        		}
	        	}
	            
	            System.out.print("Pesan lagi? (y/n) : ");
	            while (!scan.hasNext("[yn]")) {
					System.out.println("Input harus berupa y atau n!");
					scan.next();
				 }
	            
				 validasi = scan.next();
            
        } while (validasi.equals("y"));
        
        proses.diskon(totalHarga);
    }
	

}
