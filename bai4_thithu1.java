import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class TruyVanSinhVien implements Comparable<TruyVanSinhVien>{
    static int order = 1, type;
    String id, name, birth, city, code;
    int day, month, year, stt;

    TruyVanSinhVien (String code, String name, String birth, String city){
        this.stt = order;
        this.id = String.format("SV%02d", order++);
        this.code = code;
        this.name = modify(name);
        this.birth = format(birth);
        this.city = city;
    }

    String modify (String name){
        String temp[] = name.trim().toUpperCase().split("\\s+");
        name = "";
        for (String i : temp)
            name += i.charAt(0) + i.substring(1).toLowerCase() + " ";
        return name.trim();
    }

    String format (String date){
        String temp[] = date.split("/");
        temp[0] = String.format("%02d", Integer.valueOf(temp[0]));
        day = Integer.valueOf(temp[0]);
        temp[1] = String.format("%02d", Integer.valueOf(temp[1]));
        month = Integer.valueOf(temp[1]);
        temp[2] = String.format("%04d", Integer.valueOf(temp[2]));
        year = Integer.valueOf(temp[2]);
        return temp[0] + "/" + temp[1] + "/" + temp[2];
    }

    int query1 (TruyVanSinhVien x){
        return this.name.compareTo(x.name);
    }    

    int query2 (TruyVanSinhVien x){
        if (this.year != x.year)
            return Integer.compare(this.year, x.year);
        else if (this.month != x.month)
            return Integer.compare(this.month, x.month);
        else 
            return Integer.compare(this.day, x.day);
    }

    int query3 (TruyVanSinhVien x){
        return this.code.compareTo(x.code);
    }

    int query4 (TruyVanSinhVien x){
        return Integer.compare(this.stt, x.stt);
    }

    public int compareTo (TruyVanSinhVien x){
        if (type == 1)
            return query1(x);
        else if (type == 2)
            return -query2(x);
        else if (type == 3)
            return query3(x);
        else 
            return query4(x);
    }

    public String toString (){
        return id + " " + code + " " + name + " " + birth + " " + city;
    }
}

public class bai4_thithu1 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        TruyVanSinhVien a[] = new TruyVanSinhVien[n];
        in.nextLine();
        for (int i=0; i<n; i++){
            String code = in.nextLine();
            String name = in.nextLine();
            String birth = in.nextLine();
            String city = in.nextLine();
            a[i] = new TruyVanSinhVien(code, name, birth, city);
        }
        int q = in.nextInt();
        ArrayList<TruyVanSinhVien> s = new ArrayList<>();
        for (int i=0; i<q; i++){
            s.clear();
            int type = in.nextInt();
            String value = in.nextLine().trim();
            TruyVanSinhVien.type = type;
            if (type == 1){
                for (TruyVanSinhVien j : a)
                    if (j.city.equals(value))
                        s.add(j);
                Collections.sort(s);
                if (s.isEmpty())
                    System.out.println("-1");
                else
                    for (TruyVanSinhVien j : s)
                        System.out.println(j);
                System.out.println();
            }
            else if (type == 2){
                int year = Integer.valueOf(value);
                for (TruyVanSinhVien j : a) 
                    if (j.year == year)
                        s.add(j);
                Collections.sort(s);
                if (s.isEmpty())
                    System.out.println("-1");
                else
                    for (TruyVanSinhVien j : s)
                        System.out.println(j);
                System.out.println();
            }
            else if (type == 3){
                Arrays.sort(a);
                for (TruyVanSinhVien j : a)
                    System.out.println(j);
                System.out.println();
            }
            else{
                value = value.toLowerCase();
                for (TruyVanSinhVien j : a)
                    if (j.name.toLowerCase().contains(value))
                        s.add(j);
                Collections.sort(s);   
                if (s.isEmpty())
                    System.out.println("-1");
                else
                    for (TruyVanSinhVien j : s)
                        System.out.println(j);
                System.out.println();
            }
        }
    }
}
