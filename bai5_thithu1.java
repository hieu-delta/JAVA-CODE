import java.util.Scanner;

class NhanVien {
    String name, gender, birth, address, productid;

    NhanVien (String name, String gender, String birth, String address, String productid){
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.productid = productid;
    }
}

class KhachHang {
    static int order = 1;
    String id, name, gender, birth, address;

    KhachHang (String name, String gender, String birth, String address){
        this.id = String.format("KH%03d", order++);
        this.name = name;
        this.gender = gender;
        this.address = address;
    }
}

class MatHang {
    static int order = 1;
    String id, name, unit;
    Long buy, sell;

    MatHang (String name, String unit, String buy, String sell){
        this.id = String.format("MH%03d", order++);
        this.name = name;
        this.unit = unit;
        this.buy = Long.valueOf(buy);
        this.sell = Long.valueOf(sell);
    }
}

class HoaDon {
    static int order = 1;
    String id, customerid, productid, customername, customercity, productname, productunit, staffname, staffcity; 
    Long quantity, buy, sell;

    HoaDon (String customerid, String productid, String quantity){
        this.id = String.format("HD%03d", order++);
        this.customerid = customerid;
        this.productid = productid;
        this.quantity = Long.valueOf(quantity);
    }

    public String toString (){
        return id + " " + customername + " " + customercity + " " + productname + " " + productunit + " " + staffname + " " + staffcity + " " + buy + " " + sell + " " + quantity + " " + (sell*quantity);
    }
}

public class bai5_thithu1 {
    static Scanner in = new Scanner (System.in);
    public static void main(String[] args) {
        int m = in.nextInt();
        NhanVien nv[] = new NhanVien[m];
        in.nextLine();
        for (int i=0; i<m; i++){
            String name = in.nextLine();
            String gender = in.nextLine();
            String birth = in.nextLine();
            String address = in.nextLine();
            String productid = in.nextLine();
            nv[i] = new NhanVien(name, gender, birth, address, productid);
        }

        int n = in.nextInt();
        KhachHang kh[] = new KhachHang[n];
        in.nextLine();
        for (int i=0; i<n; i++){
            String name = in.nextLine();
            String gender = in.nextLine();
            String birth = in.nextLine();
            String address = in.nextLine();
            kh[i] = new KhachHang(name, gender, birth, address);
        }

        int p = in.nextInt();
        MatHang mh[] = new MatHang[p];
        in.nextLine();
        for (int i=0; i<p; i++){
            String name = in.nextLine();
            String unit = in.nextLine();
            String buy = in.nextLine();
            String sell = in.nextLine();
            mh[i] = new MatHang(name, unit, buy, sell);
        }

        int q = in.nextInt();
        HoaDon hd[] = new HoaDon[q];
        in.nextLine();
        for (int i=0; i<q; i++){
            String customerid = in.next().trim();
            String productid = in.next().trim();
            String quantity = in.nextLine().trim();
            hd[i] = new HoaDon(customerid, productid, quantity);
            for (KhachHang j : kh)
                if (j.id.equals(customerid)){
                    hd[i].customername = j.name;
                    hd[i].customercity = j.address;
                }
            for (MatHang j : mh)
                if (j.id.equals(productid)){
                    hd[i].productname = j.name;
                    hd[i].productunit = j.unit;
                    hd[i].buy = j.buy;
                    hd[i].sell = j.sell;
                }
            for (NhanVien j : nv)
                if (j.productid.equals(productid)){
                    hd[i].staffname = j.name;
                    hd[i].staffcity = j.address;
                    break;
                }
        }
        
        for (HoaDon i : hd)
            System.out.println(i);
    }
}
