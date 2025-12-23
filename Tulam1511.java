/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tulam1511;

import java.util.Scanner;

/**
 *
 * @author lamdu
 */
public class Tulam1511 {

    /**
     * @param args the command line arguments
     * Cho mảng 1 chiểu sổ nguyên (n > 0)
a Viết phg thức nhập, xuất mảng 1 chiều số nguyên
b Viết phg thức in ra màn hình các phần tử KHÔNG là số chính phương                công thức math.sqrt(cơ số, số mũ)
c Viết phg thức đếm các phần tử là số nguyên tố tại vị trí chẵn trong mảng
d Viết phg thức tính tổng các phần tử là số hoàn thiện trong mảng các số nguyên
e Viết phg thức chèn phần tử có giá tri X vào vi trí đầu tiên của mảng              cũng có thể dùng trong chèn vị trí bất kỳ
f 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Cau A:");
        int n = NhapN();
        int a[];
        a = new int[n];
        NhapMang(a);
        XuatMang(a);
        //System.out.println("Cau B:");
        //LaSoChinhPhuong(a);
        //System.out.println("Cau C:");
        LaSNTvtLe(a);
        System.out.println("Cau D:");
        int Tong =TongSHT(a);
        System.out.println("Tong cac SHT = " +Tong);
        System.out.println("Cau E:");
        a = chenDau(a);                             //trả lại mảng a[]= hàm chứa mảng a[new] ,,, cập nhật
        XuatMang(a);                                //xuất lại mảng a[] sau khi chèn
    }
    
    
    
    
    //Viết phg thức nhập, xuất mảng 1 chiều số nguyên
    public static int NhapN(){                  //nhập N là số nguyên dương                             câu A
        int n;
        Scanner kb= new Scanner(System.in);
        do{
            n = kb. nextInt();
            if(n<=0)
                System.out.println("N phai la so nguyen duong");
            
        }while(n<=0);
        return n;
    }
    
    public static void NhapMang(int []a){       //nhập từng phần tử trong mảng a[]
        Scanner kb= new Scanner(System.in);
        
        for(int i = 0 ; i<a.length; i++){
            System.out.println("a{"+i+"]= ");
            a[i]=kb.nextInt();                  
            
        }
    }
    public static void XuatMang(int a[]){   // xuất ra màn hình mảng một chiều a[]
        System.out.println("MMC : ");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+"\t");
        }
        
    }
    //Viết phg thức in ra màn hình các phần tử KHÔNG là số chính phương  
    public static boolean XacDinhSoCP(int so){     //Điều kiện Xác dịnh số chính phương   , với int số là từng phần tử a[i]              Câu B   
        double kq = Math.sqrt(so);         // lấy căng nên khai báo kiểu dữ liệu là số thực(double)
        if( kq == (int)kq) {                //
            return true;
        }else
            return false;
                                            
        }
    public static void LaSoChinhPhuong(int []a){
        for(int i=0; i<a.length; i++){
            if(XacDinhSoCP(a[i])){                  //Các số chính phương
                System.out.print("tai vi tri a["+i+"]= ");
                System.out.println(a[i]+"la so chinh phuong ");
            }else{                                  //Các số khong là chính phương thay dk if(!XacDinhSoCP(theo từng phần tử thuộc mảng a[])
                System.out.print("tai vi tri a["+i+"]= ");
                System.out.println(a[i]+" khong la so chinh phuong ");
            }
        }
    }
    //Viết phg thức đếm các phần tử là số nguyên tố tại vị trí chẵn trong mảng                                                   Câu C
    public static boolean XacDinhSNT(int so){   /*Điều kiện xác định số nguyên tố  , với int so là từng phần tử a[i]            
                                                Số nguyên tố là gì ? >>> Là số chỉ chia được với chính nó ngoài ra không chia dc số khác trừ số 1
                                                >>so%i ==0 lập lại 2 lần(int dem ==2) là true (hàm boolean)*/
        int dem = 0;
        for(int i=1;i<=so;i++){                  //int i=1 vì không chia được cho 0,điều kiện i<=số vì còn phải chia cho chính nó khác với Đk số hoàn thiện
        if(so%i==0){                                //chia lấy dư ,không dư( tức = 0 ),trả về true và ngược lại
            
            ++dem;
        }else
            return false;
        }
        if(dem == 2){
            return true;
        }else
            return false;
                                  
    }    
    /*public static void LaSNT(int a[]){          //đưa từng phần tử a[i] vào int số hàm xác định trước đó
        for(int i= 0 ; i<a.length;i++){
            if(XacDinhSNT(a[i])){
               System.out.print("tai vi tri a["+i+"]= ");       //Các phần tử là SNT
                System.out.println(a[i]+" la SNT"); 
            }else
                System.out.print("tai vi tri a["+i+"]= "+a[i]+" khong la SNT \n");      //Các phần tử không là SNT
            
        }
    }*/
    public static void LaSNTvtLe(int a[]){
        for(int i= 0 ; i<a.length;i++){
            if(XacDinhSNT(a[i]) && i%2!=0){                        //dựa vào hàm xác định trước đó tại vị trí (tức a[vị trí(i)] là số lẻ ( tức i%2!=0,số chẵn ngược lại)
               System.out.print("tai vi tri a["+i+"]= ");       //Các phần tử là SNT
                System.out.println(a[i]+" la SNT"); 
            }else
                System.out.print("tai vi tri a["+i+"]= "+a[i]+" khong la SNT \n");      //Các phần tử không là SNT
            
        }
    }  
    
    
    
                                                                                                                                //câu D
    // Viết phg thức tính tổng các phần tử là số hoàn thiện trong mảng các số nguyên                                                                                  //Câu D
    public static boolean XetSHT(int so){                             //số hoàn thiện là tổng các số chia đc với nó cộng lại , vậy int i =1 , đk i<số (không băng với chính nó, i++  
        int S=0;                                                // biến S phải có giá trị ban đầu là 0 , không gía trị thì hàm báo lỗi
        for(int i = 1 ; i<so;i++){
            if(so%i==0){                                        //sau khi chia lấy dư ,để lấy tổng (int Tong) ;Tổng= S(các phần tử SHT) >>>> S = S+ i
                S+=i;                                           //và đẻ là số hoàn thiện thì S = số (int so), quay lại hàm xác định là hàm boolean
            }
        }
        if(S==so){                                              
            return true;
        }else
            return false;
    }
    public static int TongSHT(int[]a){                     //Tổng (các phần tử) SHT cộng lại >> nếu là true ta tiến hành c thức: Tổng +=S(với S thay bằng a[i]) theo từng phần tử mảng a[]
        int Tong = 0;
        for(int i=0;i<a.length;i++){
            if(XetSHT(a[i])){                               //nếu true thì tiến hành công thức
                Tong+=a[i];                                 // trả về giá trị là >>tổng<< ta dùng hàm int
            }
        }return Tong;
    }
    
    
    
    // Viết phg thức chèn phần tử có giá tri X vào vi trí đầu tiên của mảng                             câu E
    public static int [ ] ChenTaiViTri(int [ ] a, int vt, int gt) {       //Hàm chèn vị trí trong mảng [] tên (int các biến trong mảng, int vị trí , int gía trị đưa vào)          
        int[] b = new int[a.length + 1];                                  //tạo mảng b[các phần tử thuộc b] = các giá trị mới thuộc mảng [a.length+1] ,chú thích : vt là vị trí , gt là giá trị
                                                                           //    a[0]    a[1]     a[2]     a[3]     a[n...]
                                                                           //            b[0]    b[1]     b[2]     b[n+1...] 
        
        for (int i = a.length; i > vt; i--) {                            // i = độ rộng n phần tử mảng a[]; giá trị i > vị trí ; i giảm ,,,đưa vào giá trị
        b[i] = a[i - 1];                                                 //             a[0]=gt0    a[1]=gt1    a[2]=gt2    a[3]=gt3    a[n...]=gt... 
        }                                                                //              >>>>>      b[0]=gt0    b[1]=gt1    b[2]=gt2    b[...]
        
        
        b[vt] = gt;                                                     // b[vị trí] = giá trị
        for (int i = 0; i < vt; i++) {                                  // vòng lặp trả lại giá trị mảng a[]
            b[i] = a[i];                                                //       a[0]=gt        a[1]=gt0    a[2]=gt1    a[3]=gt2    a[4]=gt3    a[n...]=gt...
        }                                                               //       nhap X=gt      b[0]=gt0    b[1]=gt1    b[2]=gt2    b[...]
    return b;                                                         // trả về giá trị b dùng sau này
    
    }
    
    
    
    
    
    
    
    public static int[] chenDau(int[] a){
        Scanner kb = new Scanner(System.in); 
        int X,vitri;
        System.out.println(" Nhap X: ");
        X = kb.nextInt();
        System.out.println("Vi Tri can chen vao : ");
        vitri=kb.nextInt();
        a = ChenTaiViTri (a, vitri, X) ;
    return a;
    }
 
    
}

