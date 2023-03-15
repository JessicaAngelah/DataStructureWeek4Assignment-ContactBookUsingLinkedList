import java.io.*;
import java.util.*;

class Directory implements Comparable {
	String name;
	String emai;
	int phoneNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}



public class ContactBook {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		System.out.println();
		System.out.println("========== Contact Book ==========");
		System.out.println("1. Accept Data");
		System.out.println("2. Search");
		System.out.println("3. Sort Data");
		System.out.println("4. List of all persons");
		System.out.println("5. Exit");
		System.out.println("==================================");
		boolean quit = false;
		do {
			System.out.print("Please enter a command: ");
			menu = scan.nextInt();
			System.out.println();

			switch (menu) {
			case 1:
				System.out.print("Enter Name: ");
				String name = scan.next();
				System.out.print("Enter Email: ");
				String Email = scan.next();
				System.out.println("Enter Phone No: ");
				int no = scan.nextInt();
				FileWriter fw = new FileWriter(new File("directory.txt"), true);
				BufferedWriter out = new BufferedWriter(fw);
				out.write(name + " " + email + " " + no);
				out.newLine();
				out.close();
				break;
			case 2:
				System.out.print("Enter name to search information: ");
				String n = scan.next();
				File f = new File("directory.txt");
				try {
					BufferedReader freader = new BufferedReader(new FileReader(
							f));
					String s;
					while ((s = freader.readLine()) != null) {
						String[] st = s.split(" ");
						String nm = st[0];
						String ema = st[1];
						String phoneNo = st[2];
						if (n.equals(nm)) {
							System.out.println("========== Information ==========");
							System.out.println("Name : " + nm);
							System.out.println("Email : " + ema);
							System.out.println("PhoneNo : " + phoneNo);
						}
					}
					freader.close();
				} catch (Exception e) {
				}
				break;
			case 3:
				File file = new File("directory.txt");
				FileInputStream fstream = new FileInputStream(file);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(
						new InputStreamReader(in));
				String strLine;
				ArrayList list = new ArrayList();
				while ((strLine = br.readLine()) != null) {
					list.add(strLine);
				}
				int j = 0;
				Directory data[] = new Directory[list.size()];
				try {
					Iterator itr;
					for (itr = list.iterator(); itr.hasNext();) {
						String str = itr.next().toString();
						String[] splitSt = str.split(" ");
						String nn = "", ema = "", pno = "";
						for (int i = 0; i < splitSt.length; i++) {
							nn = splitSt[0];
							ema = splitSt[1];
							pno = splitSt[2];

						}
						data[j] = new Directory();
						data[j].setName(nn);
						data[j].setEmail(ema);
						data[j].setPhoneNo(Integer.parseInt(pno));

						j++;
					}

					BufferedWriter bw = new BufferedWriter(new FileWriter(file,
							true));
					Arrays.sort(data);
					System.out.println("========== Sorted Data ==========");
					String strVal = "";
					for (int i = 0; i < 8; i++) {
						Directory show = data[i];
						String nnn = show.getName();
						String ema = show.getEmail();
						int phone = show.getPhoneNo();
						System.out.println(nnn + " " + ema + " "
								+ phone);
					}
				} catch (Exception e) {
				}
				break;

			case 4:
				FileInputStream fis = new FileInputStream(new File(
						"directory.txt"));
				DataInputStream dis = new DataInputStream(fis);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(dis));
				String st;
				ArrayList al = new ArrayList();
				while ((st = reader.readLine()) != null) {
					al.add(st);
				}
				Iterator itr;
				for (itr = al.iterator(); itr.hasNext();) {
					String str = itr.next().toString();
					String[] splitSt = str.split(" ");
					String na = "", emm = "", ph = "";
					for (int i = 0; i < splitSt.length; i++) {
						na = splitSt[0];
						emm = splitSt[1];
						ph = splitSt[2];
					}
					System.out.println(na + " " + emm + " " + ph);
				}
				break;
			case 5:
				quit = true;
				break;
			default:
				System.out.println("Invalid Entry!");
			}
		} while (!quit);
	}
}
}
