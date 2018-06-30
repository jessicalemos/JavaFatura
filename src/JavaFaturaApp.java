
/**
 * Write a description of class JavaFaturaApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
public class JavaFaturaApp{
    private JavaFaturaApp() {} 
    private static JavaFatura javaFatura = new JavaFatura();
   // private static JavaFatura javaFatura;
    private static Menu menuInicial, menuContribuinteI, menuContribuinteC, menuAdministrador, menuNatureza;
    private static Administrador administrador;
    
    public static void main(String[] args){
        carregaMenu();
        carregaEstado();
    /**   
       new JavaFaturaApp();
       Cabeleireiros f1 = new Cabeleireiros(0,"1","123543214","Fatura/Recibo", LocalDate.of(2018,5,23),"525365282","Descrição",25);
       Cabeleireiros f2 = new Cabeleireiros(0,"2","123543214","Fatura/Recibo", LocalDate.of(2018,6,22),"321563435","Descrição",45);
       Cabeleireiros f3 = new Cabeleireiros(0,"3","123543214","Fatura/Recibo", LocalDate.of(2018,2,13),"354265456","Descrição",60);
       Cabeleireiros f4 = new Cabeleireiros(0,"4","123543214","Fatura/Recibo", LocalDate.of(2018,3,23),"546485133","Descrição",10);       
       Cabeleireiros f5 = new Cabeleireiros(0,"5","123543214","Fatura/Recibo", LocalDate.of(2018,12,3),"547864566","Descrição",25);
       DespesasGerais f6 = new DespesasGerais(0,"6","132582138","Fatura/Recibo", LocalDate.of(2018,6,2),"456875456","Descrição",150);
       DespesasGerais f7 = new DespesasGerais(0,"7","132582138","Fatura/Recibo", LocalDate.of(2018,1,14),"678697899","Descrição",10);
       DespesasGerais f8 = new DespesasGerais(0,"8","132582138","Fatura/Recibo", LocalDate.of(2018,11,11),"404567786","Descrição",1050);
       DespesasGerais f9 = new DespesasGerais(0,"9","132582138","Fatura/Recibo", LocalDate.of(2018,2,28),"678654646","Descrição",2500);
       DespesasGerais f10 = new DespesasGerais(0,"10","132582138","Fatura/Recibo", LocalDate.of(2018,6,4),"456756787","Descrição",50);
       Pendentes f11 = new Pendentes(0,"11","123265814","Fatura/Recibo", LocalDate.of(2018,3,16),"678676857","Descrição",1400);
       Pendentes f12 = new Pendentes(0,"12","123265814","Fatura/Recibo", LocalDate.of(2018,1,2),"678645678","Descrição",400);
       Pendentes f13 = new Pendentes(0,"13","123265814","Fatura/Recibo", LocalDate.of(2018,7,6),"546786546","Descrição",600);
       Pendentes f14 = new Pendentes(0,"14","123265814","Fatura/Recibo", LocalDate.of(2018,8,31),"546786546","Descrição",1500);
       Pendentes f15 = new Pendentes(0,"15","123265814","Fatura/Recibo", LocalDate.of(2018,9,22),"678697899","Descrição",2500);
       Pendentes f16 = new Pendentes(0,"16","564521384","Fatura/Recibo", LocalDate.of(2018,4,9),"867945645","Descrição",90);
       Pendentes f17 = new Pendentes(0,"17","564521384","Fatura/Recibo", LocalDate.of(2018,6,6),"678654654","Descrição",15);
       Pendentes f18 = new Pendentes(0,"18","564521384","Fatura/Recibo", LocalDate.of(2018,3,25),"678522456","Descrição",10);
       Pendentes f19 = new Pendentes(0,"19","564521384","Fatura/Recibo", LocalDate.of(2018,3,12),"675614565","Descrição",30);
       Pendentes f20 = new Pendentes(0,"20","564521384","Fatura/Recibo", LocalDate.of(2018,12,1),"645645645","Descrição",20);
       ReparaçãoMotociclos f21 = new ReparaçãoMotociclos(0,"21","320505005","Fatura/Recibo", LocalDate.of(2018,9,23),"340467866","t",250);
       ReparaçãoMotociclos f22 = new ReparaçãoMotociclos(0,"22","320505005","Fatura/Recibo", LocalDate.of(2018,1,28),"645645664","t",343);
       ReparaçãoMotociclos f23 = new ReparaçãoMotociclos(0,"23","320505005","Fatura/Recibo", LocalDate.of(2018,2,9),"645678674","t",100);
       ReparaçãoMotociclos f24 = new ReparaçãoMotociclos(0,"24","320505005","Fatura/Recibo", LocalDate.of(2018,3,20),"678645678","t",2500);
       ReparaçãoMotociclos f25 = new ReparaçãoMotociclos(0,"25","320505005","Fatura/Recibo", LocalDate.of(2018,3,20),"404567786","t",400);
       Pendentes f26 = new Pendentes(0,"26","205350564","Fatura/Recibo", LocalDate.of(2018,8,2),"546785677","Descrição",400);
       Pendentes f27 = new Pendentes(0,"27","205350564","Fatura/Recibo", LocalDate.of(2018,7,2),"456786745","Descrição",600);
       Pendentes f28 = new Pendentes(0,"28","205350564","Fatura/Recibo", LocalDate.of(2018,4,30),"354265456","Descrição",1500);
       Pendentes f29 = new Pendentes(0,"29","205350564","Fatura/Recibo", LocalDate.of(2018,9,2),"678676857","Descrição",2500);
       Pendentes f30 = new Pendentes(0,"30","205350564","Fatura/Recibo", LocalDate.of(2018,2,27),"546485133","Descrição",1000);
       Pendentes f31 = new Pendentes(0,"31","321654132","Fatura/Recibo", LocalDate.of(2018,2,6),"546786546","Descrição",600);
       Pendentes f32 = new Pendentes(0,"32","321654132","Fatura/Recibo", LocalDate.of(2018,3,31),"525365282","Descrição",1500);
       Pendentes f33 = new Pendentes(0,"33","321654132","Fatura/Recibo", LocalDate.of(2018,4,22),"456875456","Descrição",2500);
       Pendentes f34 = new Pendentes(0,"34","321654132","Fatura/Recibo", LocalDate.of(2018,7,3),"546485133","Descrição",1600);
       Pendentes f35 = new Pendentes(0,"35","321654132","Fatura/Recibo", LocalDate.of(2018,8,12),"321563435","Descrição",500);
       Pendentes f36 = new Pendentes(0,"36","925465521","Fatura/Recibo", LocalDate.of(2018,5,22),"678697899","Descrição",500);
       Pendentes f37 = new Pendentes(0,"37","925465521","Fatura/Recibo", LocalDate.of(2018,7,22),"546485133","Descrição",3500);
       Pendentes f38 = new Pendentes(0,"38","925465521","Fatura/Recibo", LocalDate.of(2018,8,22),"645645645","Descrição",1500);
       Pendentes f39 = new Pendentes(0,"39","925465521","Fatura/Recibo", LocalDate.of(2018,9,22),"456875456","Descrição",2500);
       Pendentes f40 = new Pendentes(0,"40","925465521","Fatura/Recibo", LocalDate.of(2018,8,31),"456875456","Descrição",1500);
       AtividadesVeterinárias f41 = new AtividadesVeterinárias(0,"41","978564581","Fatura/Recibo", LocalDate.of(2018,9,2),"456786745","Descrição",30);
       AtividadesVeterinárias f42 = new AtividadesVeterinárias(0,"42","978564581","Fatura/Recibo", LocalDate.of(2018,7,7),"456875456","Descrição",10);
       AtividadesVeterinárias f43 = new AtividadesVeterinárias(0,"43","978564581","Fatura/Recibo", LocalDate.of(2018,8,21),"456875456","Descrição",150);
       AtividadesVeterinárias f44 = new AtividadesVeterinárias(0,"44","978564581","Fatura/Recibo", LocalDate.of(2018,9,2),"678654654","Descrição",500);
       AtividadesVeterinárias f45 = new AtividadesVeterinárias(0,"45","978564581","Fatura/Recibo", LocalDate.of(2018,9,7),"456787765","Descrição",50);
       Pendentes f46 = new Pendentes(0,"46","123265814","Fatura/Recibo", LocalDate.of(2018,9,15),"456787765","Descrição",500);
       Pendentes f47 = new Pendentes(0,"47","123265814","Fatura/Recibo", LocalDate.of(2018,9,2),"678645678","Descrição",50);
       Pendentes f48 = new Pendentes(0,"48","123265814","Fatura/Recibo", LocalDate.of(2018,7,7),"645645645","Descrição",1000);
       Pendentes f49 = new Pendentes(0,"49","123265814","Fatura/Recibo", LocalDate.of(2018,8,21),"678524654","Descrição",1545);
       Pendentes f50 = new Pendentes(0,"50","123265814","Fatura/Recibo", LocalDate.of(2018,9,5),"547864566","Descrição",90);
       Educação f51 = new Educação(0,"51","546852512","Fatura/Recibo", LocalDate.of(2018,9,6),"547864566","Descrição",50);
       Pendentes f52 = new Pendentes(0,"52","321654132","Fatura/Recibo", LocalDate.of(2018,9,5),"645645655","Descrição",500);
       Pendentes f53 = new Pendentes(0,"53","321654132","Fatura/Recibo", LocalDate.of(2018,9,6),"678645678","Descrição",160);
       Pendentes f54 = new Pendentes(0,"54","321654132","Fatura/Recibo", LocalDate.of(2018,9,2),"456786745","Descrição",1100);       
       Pendentes f55 = new Pendentes(0,"55","321654132","Fatura/Recibo", LocalDate.of(2018,9,17),"645045645","Descrição",500);  
       Cabeleireiros f56 = new Cabeleireiros(0,"56","123543214","Fatura/Recibo", LocalDate.of(2018,8,15),"678678655","Descrição",358);
       Cabeleireiros f57 = new Cabeleireiros(0,"57","123543214","Fatura/Recibo", LocalDate.of(2018,4,23),"456875456","Descrição",8);
       Cabeleireiros f58 = new Cabeleireiros(0,"58","123543214","Fatura/Recibo", LocalDate.of(2018,11,1),"546786546","Descrição",205);
       Cabeleireiros f59 = new Cabeleireiros(0,"59","123543214","Fatura/Recibo", LocalDate.of(2018,1,23),"645045645","Descrição",35);
       Cabeleireiros f60 = new Cabeleireiros(0,"60","123543214","Fatura/Recibo", LocalDate.of(2018,4,2),"546786546","Descrição",28);
       DespesasGerais f61 = new DespesasGerais(0,"61","132582138","Fatura/Recibo", LocalDate.of(2018,4,18),"456756787","Descrição",2585);
       DespesasGerais f62 = new DespesasGerais(0,"62","132582138","Fatura/Recibo", LocalDate.of(2018,8,11),"678524654","Descrição",1568);
       DespesasGerais f63 = new DespesasGerais(0,"63","132582138","Fatura/Recibo", LocalDate.of(2018,2,2),"340467866","Descrição",856);
       DespesasGerais f64 = new DespesasGerais(0,"64","132582138","Fatura/Recibo", LocalDate.of(2018,9,11),"645678674","Descrição",7851);
       DespesasGerais f65 = new DespesasGerais(0,"65","132582138","Fatura/Recibo", LocalDate.of(2018,1,21),"678676857","Descrição",145);
       Pendentes f66 = new Pendentes(0,"66","123265814","Fatura/Recibo", LocalDate.of(2018,3,13),"645678674","Descrição",2150);
       Pendentes f67 = new Pendentes(0,"67","123265814","Fatura/Recibo", LocalDate.of(2018,7,12),"452145645","Descrição",1853);
       Pendentes f68 = new Pendentes(0,"68","123265814","Fatura/Recibo", LocalDate.of(2018,1,5),"867945645","Descrição",258);
       Pendentes f69 = new Pendentes(0,"69","123265814","Fatura/Recibo", LocalDate.of(2018,6,19),"678522456","Descrição",3250);
       Pendentes f70 = new Pendentes(0,"70","123265814","Fatura/Recibo", LocalDate.of(2018,1,3),"645645664","Descrição",225);
       Pendentes f71 = new Pendentes(0,"71","564521384","Fatura/Recibo", LocalDate.of(2018,3,15),"645678674","Descrição",145);
       Pendentes f72 = new Pendentes(0,"72","564521384","Fatura/Recibo", LocalDate.of(2018,4,28),"789456799","Descrição",30);
       Pendentes f73 = new Pendentes(0,"73","564521384","Fatura/Recibo", LocalDate.of(2018,2,18),"679676546","Descrição",40);
       Pendentes f74 = new Pendentes(0,"74","564521384","Fatura/Recibo", LocalDate.of(2018,6,3),"245642343","Descrição",35);
       Pendentes f75 = new Pendentes(0,"75","564521384","Fatura/Recibo", LocalDate.of(2018,12,24),"546786546","Descrição",50);
       Pendentes f76 = new Pendentes(0,"76","925465521","Fatura/Recibo", LocalDate.of(2018,12,30),"645645664","Descrição",125);
       Pendentes f77 = new Pendentes(0,"77","925465521","Fatura/Recibo", LocalDate.of(2018,10,15),"340467866","Descrição",2555);
       Pendentes f78 = new Pendentes(0,"78","925465521","Fatura/Recibo", LocalDate.of(2018,11,2),"867945645","Descrição",350);
       Pendentes f79 = new Pendentes(0,"79","925465521","Fatura/Recibo", LocalDate.of(2018,2,23),"456787765","Descrição",550);
       Pendentes f80 = new Pendentes(0,"80","925465521","Fatura/Recibo", LocalDate.of(2018,4,13),"244245645","Descrição",3560);
       Pendentes f81 = new Pendentes(0,"81","123265814","Fatura/Recibo", LocalDate.of(2018,3,14),"645645655","Descrição",2500);
       Pendentes f82 = new Pendentes(0,"82","123265814","Fatura/Recibo", LocalDate.of(2018,3,25),"452145645","Descrição",13000);
       Pendentes f83 = new Pendentes(0,"83","123265814","Fatura/Recibo", LocalDate.of(2018,5,28),"456782545","Descrição",400);
       Pendentes f84 = new Pendentes(0,"84","321652135","Fatura/Recibo", LocalDate.of(2018,4,29),"321563435","Descrição",800);
       Pendentes f85 = new Pendentes(0,"85","321652135","Fatura/Recibo", LocalDate.of(2018,9,12),"456782545","Descrição",2250);
       Pendentes f86 = new Pendentes(0,"86","123525545","Fatura/Recibo", LocalDate.of(2018,11,11),"547864566","Descrição",250);
       Pendentes f87 = new Pendentes(0,"87","123525545","Fatura/Recibo", LocalDate.of(2018,9,15),"867945645","Descrição",50);
       Pendentes f88 = new Pendentes(0,"88","321654132","Fatura/Recibo", LocalDate.of(2018,8,3),"456787765","Descrição",13);
       Pendentes f89 = new Pendentes(0,"89","321654132","Fatura/Recibo", LocalDate.of(2018,10,9),"546786546","Descrição",24);
       Pendentes f90 = new Pendentes(0,"90","321654132","Fatura/Recibo", LocalDate.of(2018,1,8),"678524654","Descrição",20);
       ReparaçãoMotociclos f91 = new ReparaçãoMotociclos(0,"91","320505005","Fatura/Recibo", LocalDate.of(2018,2,7),"789456799","Descrição",150);
       ReparaçãoMotociclos f92 = new ReparaçãoMotociclos(0,"92","320505005","Fatura/Recibo", LocalDate.of(2018,2,5),"645645666","Descrição",75);
       ReparaçãoMotociclos f93 = new ReparaçãoMotociclos(0,"93","320505005","Fatura/Recibo", LocalDate.of(2018,4,1),"678654646","Descrição",90);
       ReparaçãoMotociclos f94 = new ReparaçãoMotociclos(0,"94","320505005","Fatura/Recibo", LocalDate.of(2018,4,6),"678522456","Descrição",230);
       ReparaçãoMotociclos f95 = new ReparaçãoMotociclos(0,"95","320505005","Fatura/Recibo", LocalDate.of(2018,9,2),"546786546","Descrição",250);
       AtividadesVeterinárias f96 = new AtividadesVeterinárias(0,"96","978564581","Fatura/Recibo", LocalDate.of(2018,2,17),"645678674","Descrição",40);
       AtividadesVeterinárias f97 = new AtividadesVeterinárias(0,"97","978564581","Fatura/Recibo", LocalDate.of(2018,11,13),"244245645","Descrição",85);
       AtividadesVeterinárias f98 = new AtividadesVeterinárias(0,"98","978564581","Fatura/Recibo", LocalDate.of(2018,12,11),"678654646","Descrição",70);
       AtividadesVeterinárias f99 = new AtividadesVeterinárias(0,"99","978564581","Fatura/Recibo", LocalDate.of(2018,2,23),"645045645","Descrição",84);
       AtividadesVeterinárias f100 = new AtividadesVeterinárias(0,"100","978564581","Fatura/Recibo", LocalDate.of(2018,12,17),"678654654","Descrição",110);
       Pendentes f101 = new Pendentes(0,"101","205350564","Fatura/Recibo", LocalDate.of(2018,6,13),"354265456","Descrição",45);
       Pendentes f102 = new Pendentes(0,"102","205350564","Fatura/Recibo", LocalDate.of(2018,4,23),"678645364","Descrição",25);
       Pendentes f103 = new Pendentes(0,"103","205350564","Fatura/Recibo", LocalDate.of(2018,3,18),"645645655","Descrição",40);
       Pendentes f104 = new Pendentes(0,"104","205350564","Fatura/Recibo", LocalDate.of(2018,9,16),"645645666","Descrição",100);
       Pendentes f105 = new Pendentes(0,"105","205350564","Fatura/Recibo", LocalDate.of(2018,5,13),"678546786","Descrição",95);
       Pendentes f106 = new Pendentes(0,"106","123525545","Fatura/Recibo", LocalDate.of(2018,6,15),"678678655","Descrição",150);
       Pendentes f107 = new Pendentes(0,"107","123525545","Fatura/Recibo", LocalDate.of(2018,1,31),"456787765","Descrição",125);
       Pendentes f108 = new Pendentes(0,"108","123525545","Fatura/Recibo", LocalDate.of(2018,4,23),"456782545","Descrição",285);
       Educação f109 = new Educação(0,"109","546852512","Fatura/Recibo", LocalDate.of(2018,5,12),"642324564","Descrição",155);
       Educação f110 = new Educação(0,"110","546852512","Fatura/Recibo", LocalDate.of(2018,5,20),"678694564","Descrição",800);
       Pendentes f111 = new Pendentes(0,"111","321652135","Fatura/Recibo", LocalDate.of(2018,5,19),"321563435","Descrição",365);
       Pendentes f112 = new Pendentes(0,"112","321652135","Fatura/Recibo", LocalDate.of(2018,7,14),"456786745","Descrição",50);
       Pendentes f113 = new Pendentes(0,"113","321652135","Fatura/Recibo", LocalDate.of(2018,4,11),"678654654","Descrição",5);
       Pendentes f114 = new Pendentes(0,"114","321652135","Fatura/Recibo", LocalDate.of(2018,3,4),"642324564","Descrição",45);
       Pendentes f115 = new Pendentes(0,"115","321652135","Fatura/Recibo", LocalDate.of(2018,2,3),"456786745","Descrição",25);
       Pendentes f116 = new Pendentes(0,"116","564521384","Fatura/Recibo", LocalDate.of(2018,4,8),"642324564","Descrição",2550);
       Pendentes f117 = new Pendentes(0,"117","564521384","Fatura/Recibo", LocalDate.of(2018,8,18),"675614565","Descrição",300);
       Pendentes f118 = new Pendentes(0,"118","564521384","Fatura/Recibo", LocalDate.of(2018,9,15),"678654654","Descrição",250);
       Pendentes f119 = new Pendentes(0,"119","564521384","Fatura/Recibo", LocalDate.of(2018,12,18),"678654654","Descrição",352);
       Pendentes f120 = new Pendentes(0,"120","564521384","Fatura/Recibo", LocalDate.of(2018,11,29),"354265456","Descrição",467);
       Pendentes f121 = new Pendentes(0,"121","123265814","Fatura/Recibo", LocalDate.of(2018,10,26),"675614565","Descrição",850);
       Pendentes f122 = new Pendentes(0,"122","123265814","Fatura/Recibo", LocalDate.of(2018,10,24),"546785677","Descrição",456);
       Pendentes f123 = new Pendentes(0,"123","123265814","Fatura/Recibo", LocalDate.of(2018,12,15),"245642343","Descrição",550);
       Pendentes f124 = new Pendentes(0,"124","123265814","Fatura/Recibo", LocalDate.of(2018,8,17),"452145645","Descrição",250);
       Pendentes f125 = new Pendentes(0,"125","123265814","Fatura/Recibo", LocalDate.of(2018,7,11),"678694564","Descrição",110);
       Pendentes f126 = new Pendentes(0,"126","564521384","Fatura/Recibo", LocalDate.of(2018,4,4),"675614565","Descrição",65);
       Pendentes f127 = new Pendentes(0,"127","564521384","Fatura/Recibo", LocalDate.of(2018,7,18),"456875456","Descrição",80);
       Pendentes f128 = new Pendentes(0,"128","564521384","Fatura/Recibo", LocalDate.of(2018,8,25),"456786745","Descrição",10);
       Pendentes f129 = new Pendentes(0,"129","564521384","Fatura/Recibo", LocalDate.of(2018,7,26),"456782545","Descrição",90);
       Pendentes f130 = new Pendentes(0,"130","564521384","Fatura/Recibo", LocalDate.of(2018,2,28),"546786455","Descrição",5);
       Pendentes f131 = new Pendentes(0,"131","925465521","Fatura/Recibo", LocalDate.of(2018,4,28),"244245645","Descrição",400);
       Pendentes f132 = new Pendentes(0,"132","925465521","Fatura/Recibo", LocalDate.of(2018,6,13),"642324564","Descrição",150);
       Pendentes f133 = new Pendentes(0,"133","925465521","Fatura/Recibo", LocalDate.of(2018,5,15),"546785677","Descrição",80);
       Pendentes f134 = new Pendentes(0,"134","925465521","Fatura/Recibo", LocalDate.of(2018,8,11),"645045645","Descrição",40);
       Pendentes f135 = new Pendentes(0,"135","925465521","Fatura/Recibo", LocalDate.of(2018,4,26),"456756787","Descrição",62);
       Pendentes f136 = new Pendentes(0,"136","123525545","Fatura/Recibo", LocalDate.of(2018,3,14),"678678655","Descrição",1500);
       Pendentes f137 = new Pendentes(0,"137","123525545","Fatura/Recibo", LocalDate.of(2018,2,14),"678697899","Descrição",400);
       Pendentes f138 = new Pendentes(0,"138","123525545","Fatura/Recibo", LocalDate.of(2018,1,16),"340467866","Descrição",860);
       Pendentes f139 = new Pendentes(0,"139","123525545","Fatura/Recibo", LocalDate.of(2018,2,17),"679676546","Descrição",90);
       Pendentes f140 = new Pendentes(0,"140","123265814","Fatura/Recibo", LocalDate.of(2018,8,15),"678678655","Descrição",140);
       Pendentes f141 = new Pendentes(0,"141","123525545","Fatura/Recibo", LocalDate.of(2018,7,17),"546785677","Descrição",35);
       Pendentes f142 = new Pendentes(0,"142","123525545","Fatura/Recibo", LocalDate.of(2018,12,18),"678676857","Descrição",260);
       Pendentes f143 = new Pendentes(0,"143","123525545","Fatura/Recibo", LocalDate.of(2018,10,10),"678697899","Descrição",110);
       Pendentes f144 = new Pendentes(0,"144","123525545","Fatura/Recibo", LocalDate.of(2018,10,1),"340467866","Descrição",50);
       Pendentes f145 = new Pendentes(0,"145","123525545","Fatura/Recibo", LocalDate.of(2018,2,5),"679676546","Descrição",78);
       Pendentes f146 = new Pendentes(0,"146","925465521","Fatura/Recibo", LocalDate.of(2018,5,2),"678546786","Descrição",400);
       Pendentes f147 = new Pendentes(0,"147","925465521","Fatura/Recibo", LocalDate.of(2018,4,18),"245642343","Descrição",150);
       Pendentes f148 = new Pendentes(0,"148","925465521","Fatura/Recibo", LocalDate.of(2018,6,2),"675614565","Descrição",90);
       Pendentes f149 = new Pendentes(0,"149","925465521","Fatura/Recibo", LocalDate.of(2018,10,1),"404567786","Descrição",18);
       Pendentes f150 = new Pendentes(0,"150","925465521","Fatura/Recibo", LocalDate.of(2018,12,28),"675614565","Descrição",180);
       AtividadesVeterinárias f151 = new AtividadesVeterinárias(0,"151","978564581","Fatura/Recibo", LocalDate.of(2018,11,2),"678522456","Descrição",62);
       AtividadesVeterinárias f152 = new AtividadesVeterinárias(0,"152","978564581","Fatura/Recibo", LocalDate.of(2018,9,11),"244245645","Descrição",35);
       AtividadesVeterinárias f153 = new AtividadesVeterinárias(0,"153","978564581","Fatura/Recibo", LocalDate.of(2018,7,4),"678645364","Descrição",70);
       AtividadesVeterinárias f154 = new AtividadesVeterinárias(0,"154","978564581","Fatura/Recibo", LocalDate.of(2018,5,16),"456875456","Descrição",90);
       AtividadesVeterinárias f155 = new AtividadesVeterinárias(0,"155","978564581","Fatura/Recibo", LocalDate.of(2018,5,19),"456786745","Descrição",100);
       Pendentes f156 = new Pendentes(0,"156","205350564","Fatura/Recibo", LocalDate.of(2018,6,21),"456875456","Descrição",140);
       Pendentes f157 = new Pendentes(0,"157","205350564","Fatura/Recibo", LocalDate.of(2018,2,12),"452145645","Descrição",120);
       Pendentes f158 = new Pendentes(0,"158","205350564","Fatura/Recibo", LocalDate.of(2018,12,16),"547864566","Descrição",90);
       Pendentes f159 = new Pendentes(0,"159","205350564","Fatura/Recibo", LocalDate.of(2018,3,15),"525365282","Descrição",80);
       Pendentes f160 = new Pendentes(0,"160","205350564","Fatura/Recibo", LocalDate.of(2018,4,22),"321563435","Descrição",100);
       Educação f161 = new Educação(0,"161","925462521","Fatura/Recibo", LocalDate.of(2018,10,2),"354265456","Descrição",250);
       Educação f162 = new Educação(0,"162","925462521","Fatura/Recibo", LocalDate.of(2018,12,20),"546485133","Descrição",330);
       Educação f163 = new Educação(0,"163","925462521","Fatura/Recibo", LocalDate.of(2018,1,15),"547864566","Descrição",180);
       Educação f164 = new Educação(0,"164","956465465","Fatura/Recibo", LocalDate.of(2018,8,16),"546786455","Descrição",50);
       Educação f165 = new Educação(0,"165","956465465","Fatura/Recibo", LocalDate.of(2018,4,24),"678694564","Descrição",45);
       Pendentes f166 = new Pendentes(0,"166","321652135","Fatura/Recibo", LocalDate.of(2018,4,2),"678645364","Descrição",26);
       Pendentes f167 = new Pendentes(0,"167","321652135","Fatura/Recibo", LocalDate.of(2018,3,4),"456875456","Descrição",35);
       Pendentes f168 = new Pendentes(0,"168","321652135","Fatura/Recibo", LocalDate.of(2018,5,24),"675614565","Descrição",5);
       Pendentes f169 = new Pendentes(0,"169","321652135","Fatura/Recibo", LocalDate.of(2018,9,6),"404567786","Descrição",8);
       Pendentes f170 = new Pendentes(0,"170","321652135","Fatura/Recibo", LocalDate.of(2018,2,24),"642324564","Descrição",12);
       DespesasGerais f171 = new DespesasGerais(0,"171","250369825","Fatura/Recibo", LocalDate.of(2018,2,22),"245642343","Descrição",40);
       DespesasGerais f172 = new DespesasGerais(0,"172","250369825","Fatura/Recibo", LocalDate.of(2018,5,30),"244245645","Descrição",60);
       DespesasGerais f173 = new DespesasGerais(0,"173","250369825","Fatura/Recibo", LocalDate.of(2018,9,30),"678654654","Descrição",80);
       DespesasGerais f174 = new DespesasGerais(0,"174","250369825","Fatura/Recibo", LocalDate.of(2018,8,12),"678694564","Descrição",33);
       DespesasGerais f175 = new DespesasGerais(0,"175","250369825","Fatura/Recibo", LocalDate.of(2018,2,2),"456787765","Descrição",400);
       Pendentes f176 = new Pendentes(0,"176","123265814","Fatura/Recibo", LocalDate.of(2018,2,12),"546786455","Descrição",450);
       Pendentes f177 = new Pendentes(0,"177","123265814","Fatura/Recibo", LocalDate.of(2018,4,15),"456875456","Descrição",220);
       Pendentes f178 = new Pendentes(0,"178","123265814","Fatura/Recibo", LocalDate.of(2018,10,24),"546786455","Descrição",46);
       Pendentes f179 = new Pendentes(0,"179","123265814","Fatura/Recibo", LocalDate.of(2018,11,16),"678694564","Descrição",90);
       Pendentes f180 = new Pendentes(0,"180","123265814","Fatura/Recibo", LocalDate.of(2018,3,20),"321563435","Descrição",40);
       Pendentes f181 = new Pendentes(0,"181","564521384","Fatura/Recibo", LocalDate.of(2018,5,30),"678654654","Descrição",90);
       Pendentes f182 = new Pendentes(0,"182","564521384","Fatura/Recibo", LocalDate.of(2018,4,28),"678645364","Descrição",35);
       Pendentes f183 = new Pendentes(0,"183","564521384","Fatura/Recibo", LocalDate.of(2018,4,1),"678697899","Descrição",80);
       Pendentes f184 = new Pendentes(0,"184","564521384","Fatura/Recibo", LocalDate.of(2018,4,12),"244245645","Descrição",90);
       Pendentes f185 = new Pendentes(0,"185","564521384","Fatura/Recibo", LocalDate.of(2018,8,12),"546785677","Descrição",40);
       RestauraçãoAlojamento f186 = new RestauraçãoAlojamento(0,"186","658235478","Fatura/Recibo", LocalDate.of(2018,5,19),"456875456","Descrição",35);
       RestauraçãoAlojamento f187 = new RestauraçãoAlojamento(0,"187","658235478","Fatura/Recibo", LocalDate.of(2018,7,8),"321563435","Descrição",450);
       DespesasGerais f188 = new DespesasGerais(0,"188","235842585","Fatura/Recibo", LocalDate.of(2018,3,5),"678694564","Descrição",1000);
       DespesasGerais f189 = new DespesasGerais(0,"189","235842585","Fatura/Recibo", LocalDate.of(2018,12,1),"678546786","Descrição",350);
       DespesasGerais f190 = new DespesasGerais(0,"190","235842585","Fatura/Recibo", LocalDate.of(2018,2,2),"456875456","Descrição",740);
       AtividadesVeterinárias f191 = new AtividadesVeterinárias(0,"191","325843252","Fatura/Recibo", LocalDate.of(2018,4,2),"675614565","Descrição",38);
       AtividadesVeterinárias f192 = new AtividadesVeterinárias(0,"192","325843252","Fatura/Recibo", LocalDate.of(2018,3,17),"789456799","Descrição",45);
       Saúde f193 = new Saúde(0,"193","211542122","Fatura/Recibo", LocalDate.of(2018,5,23),"678645364","Descrição",150);
       Saúde f194 = new Saúde(0,"194","211542122","Fatura/Recibo", LocalDate.of(2018,8,22),"678694564","Descrição",110);
       Saúde f195 = new Saúde(0,"195","211542122","Fatura/Recibo", LocalDate.of(2018,4,17),"456756787","Descrição",25);
       Habitação f196 = new Habitação(0,"196","325421521","Fatura/Recibo", LocalDate.of(2018,10,11),"456756787","Descrição",40);
       Habitação f197 = new Habitação(0,"197","325421521", "Fatura/Recibo",LocalDate.of(2018,7,29),"546786546","Descrição",85);
       Habitação f198 = new Habitação(0,"198","325421521", "Fatura/Recibo",LocalDate.of(2018,1,31),"678697899","Descrição",600);
       Habitação f199 = new Habitação(0,"199","325421521","Fatura/Recibo", LocalDate.of(2018,5,1),"245642343","Descrição",55);
       Educação f200 = new Educação(0,"200","925462521","Fatura/Recibo", LocalDate.of(2018,5,12),"956465465","Descrição",1500);
       Educação f201 = new Educação(0,"201","956465465","Fatura/Recibo", LocalDate.of(2018,4,13),"123525545","Descrição",2000);
       Pendentes f202 = new Pendentes(0,"202","123525545","Fatura/Recibo", LocalDate.of(2018,3,25),"925465521","Descrição",3500);
       Pendentes f203 = new Pendentes(0,"203","925465521","Fatura/Recibo", LocalDate.of(2018,2,12),"123543214","Descrição",1200);
       Cabeleireiros f204 = new Cabeleireiros(0,"204","123543214","Fatura/Recibo", LocalDate.of(2018,1,19),"546852512","Descrição",3400);
       Educação f205 = new Educação(0,"205","546852512","Fatura/Recibo", LocalDate.of(2018,12,25),"123265814","Descrição",500);
       Pendentes f206 = new Pendentes(0,"206","123265814","Fatura/Recibo", LocalDate.of(2018,11,14),"978564581","Descrição",600);
       AtividadesVeterinárias f207 = new AtividadesVeterinárias(0,"207","978564581","Fatura/Recibo", LocalDate.of(2018,10,2),"132582138","Descrição",250);
       DespesasGerais f208 = new DespesasGerais(0,"208","132582138","Fatura/Recibo", LocalDate.of(2018,9,3),"321654132","Descrição",120);
       Pendentes f209 = new Pendentes(0,"209","564521384","Fatura/Recibo", LocalDate.of(2018,8,9),"205350564","Descrição",500);
       Pendentes f210 = new Pendentes(0,"210","564521384","Fatura/Recibo", LocalDate.of(2018,6,17),"925462521","Descrição",700);
       Pendentes f211 = new Pendentes(0,"211","321654132","Fatura/Recibo", LocalDate.of(2018,7,11),"564521384","Descrição",1400);
       Pendentes f212 = new Pendentes(0,"212","321654132","Fatura/Recibo", LocalDate.of(2018,5,21),"321652135","Descrição",1200);
       Pendentes f213 = new Pendentes(0,"213","321652135","Fatura/Recibo", LocalDate.of(2018,11,22),"205350564","Descrição",2500);
       Pendentes f214 = new Pendentes(0,"214","205350564","Fatura/Recibo", LocalDate.of(2018,12,28),"321654132","Descrição",115);
       Pendentes f215 = new Pendentes(0,"215","205350564","Fatura/Recibo", LocalDate.of(2018,10,27),"321652135","Descrição",870);
       Pendentes f216 = new Pendentes(0,"216","205350564","Fatura/Recibo", LocalDate.of(2018,1,20),"546852512","Descrição",980);
       ReparaçãoMotociclos f217 = new ReparaçãoMotociclos(0,"217","320505005","Fatura/Recibo", LocalDate.of(2018,2,10),"250369825","Descrição",1200);
       DespesasGerais f218 = new DespesasGerais(0,"218","250369825","Fatura/Recibo", LocalDate.of(2018,3,10),"320505005","Descrição",985);
       DespesasGerais f219 = new DespesasGerais(0,"219","250369825","Fatura/Recibo", LocalDate.of(2018,10,25),"658235478","Descrição",340);
       RestauraçãoAlojamento f220 = new RestauraçãoAlojamento(0,"220","658235478","Fatura/Recibo", LocalDate.of(2018,5,30),"235842585","Descrição",65);
       DespesasGerais f221 = new DespesasGerais(0,"221","235842585","Fatura/Recibo", LocalDate.of(2018,9,14),"325421521","Descrição",80);
       AtividadesVeterinárias f222 = new AtividadesVeterinárias(0,"222","325843252", "Fatura/Recibo", LocalDate.of(2018,8,7),"211542122","Descrição",1000);
       AtividadesVeterinárias f223 = new AtividadesVeterinárias(0,"223","325843252","Fatura/Recibo", LocalDate.of(2018,7,11),"956465465","Descrição",150);
       Habitação f224 = new Habitação(0,"224","325421521","Fatura/Recibo", LocalDate.of(2018,7,18),"325843252","Descrição",600);
       Habitação f225 = new Habitação(0,"225","325421521","Fatura/Recibo", LocalDate.of(2018,8,19),"211542122","Descrição",200);
       Habitação f226 = new Habitação(0,"226","325421521","Fatura/Recibo", LocalDate.of(2018,4,15),"546852512","Descrição",150);
       Saúde f227 = new Saúde(0,"227","211542122","Fatura/Recibo", LocalDate.of(2018,1,4),"325843252","Descrição",200);
       Saúde f228 = new Saúde(0,"228","211542122","Fatura/Recibo", LocalDate.of(2018,5,1),"658235478","Descrição",800);
       Saúde f229 = new Saúde(0,"229","211542122","Fatura/Recibo", LocalDate.of(2018,5,16),"325421521","Descrição",400);

       ArrayList <String> AtividadeAdegasCosta = new ArrayList<String>();
       AtividadeAdegasCosta.add("RA897");
       ArrayList <String> AtividadeQuintaDaSertã = new ArrayList<String>();
       AtividadeQuintaDaSertã.add("DG678");
       ArrayList <String> AtividadeSuínosECompanhia = new ArrayList<String>();
       AtividadeSuínosECompanhia.add("AV292");
       ArrayList <String> AtividadePaletesEMadeiras = new ArrayList<String>();
       AtividadePaletesEMadeiras.add("H512");
       ArrayList <String> AtividadePomarCarvalho = new ArrayList<String>();
       AtividadePomarCarvalho.add("S126");
       ArrayList <String> AtividadeEduca = new ArrayList<String>();
       AtividadeEduca.add("E478");
       ArrayList <String> AtividadeTuna = new ArrayList<String>();       
       AtividadeTuna.add("E478");
       ArrayList <String> AtividadeHPedriatrico = new ArrayList<String>();       
       AtividadeHPedriatrico.add("E478");
       AtividadeHPedriatrico.add("H512");
       AtividadeHPedriatrico.add("S126");
       ArrayList <String> AtividadeOficina = new ArrayList<String>();       
       AtividadeOficina.add("RM333");
       AtividadeOficina.add("RA1278");
       ArrayList <String> AtividadeCabeleireiro = new ArrayList<String>();       
       AtividadeCabeleireiro.add("C201");
       ArrayList <String> AtividadeVideoNorte = new ArrayList<String>();
       AtividadeVideoNorte.add("E478");
       ArrayList <String> AtividadeHotel = new ArrayList<String>();       
       AtividadeHotel.add("H512");
       AtividadeHotel.add("L502");
       AtividadeHotel.add("RA897");
       ArrayList <String> AtividadeVeterinário = new ArrayList<String>();       
       AtividadeVeterinário.add("AV292");
       ArrayList <String> AtividadePapelaria = new ArrayList<String>();       
       AtividadePapelaria.add("DG678");
       ArrayList <String> AtividadeTransdev = new ArrayList<String>();       
       AtividadeTransdev.add("DG678");
       AtividadeTransdev.add("PM354");
       ArrayList <String> AtividadeCamara = new ArrayList<String>();       
       AtividadeCamara.add("E478");
       AtividadeCamara.add("S126");
       ArrayList <String> AtividadeCabeloSolto = new ArrayList<String>();       
       AtividadeCabeloSolto.add("C201");
       AtividadeCabeloSolto.add("H512");
       ArrayList <String> AtividadeMotel = new ArrayList<String>();       
       AtividadeMotel.add("RA897");
       AtividadeMotel.add("L502");
       AtividadeMotel.add("H512");
       ArrayList <String> AtividadeGaragemCunha = new ArrayList<String>();       
       AtividadeGaragemCunha.add("RM333");
       ArrayList <String> AtividadeCaféDoLuís = new ArrayList<String>();       
       AtividadeCaféDoLuís.add("DG678");

       ContribuintesColetivos cc1 = new ContribuintesColetivos (null,null,null,"925462521","educa@gmail.com","Educa","Rua do Almada","123asd",AtividadeEduca,0.2,0,0,"Porto");
       ContribuintesColetivos cc2 = new ContribuintesColetivos (null,null,null,"956465465","tuna@gmail.com","Tuna","Avenida dos Aliados","103asd",AtividadeTuna,0.1,0,0,"Espinho");
       ContribuintesColetivos cc3 = new ContribuintesColetivos (null,null,null,"123525545","hopitalpediatrico@gmail.com","Hospital Pedidatrico","Rua Escura","12d",AtividadeHPedriatrico,0.3,0,0,"Esmoriz");
       ContribuintesColetivos cc4 = new ContribuintesColetivos (null,null,null,"925465521","oficina@gmail.com","Oficina Cruzinha","Rua das Flores","123asd",AtividadeOficina,0.4,0,0,"Braga");
       ContribuintesColetivos cc5 = new ContribuintesColetivos (null,null,null,"123543214","cabeleireiro@gmail.com","cabeleireiro","Rua do Major David Magno","1asasd",AtividadeCabeleireiro, 0.1,0,0,"Barcelos");
       ContribuintesColetivos cc6 = new ContribuintesColetivos (null,null,null,"546852512","videonorte@gmail.com","Video Norte","Rua 24 de Abril","trocatintas",AtividadeVideoNorte,0.3,0,0,"Lisboa");
       ContribuintesColetivos cc7 = new ContribuintesColetivos (null,null,null,"123265814","hotel@gmail.com","Hotel Martins","Rua de Passps Manuel","hotel12",AtividadeHotel,0.4,0,0,"Esposende");
       ContribuintesColetivos cc8 = new ContribuintesColetivos (null,null,null,"978564581","veterinário@gmail.com","veterinário","Rua de Celorico","animais",AtividadeVeterinário,0.4,0,0,"Povoa de Varzim");
       ContribuintesColetivos cc9 = new ContribuintesColetivos (null,null,null,"132582138","papelaria@gmail.com","Papelaria Machado","Rua Cerpa Pinto","raspadinhasdasorte",AtividadePapelaria,0.2,0,0,"Povoa de Lanhoso");
       ContribuintesColetivos cc10 = new ContribuintesColetivos (null,null,null,"564521384","transdev@gmail.com","Transdev","Rua dos Bacalhoeiros","gasoleo",AtividadeTransdev,0.1,0,0,"Amarante");
       ContribuintesColetivos cc11 = new ContribuintesColetivos (null,null,null,"321654132","camara@gmail.com","Camara","Rua Augusta","CC234",AtividadeCamara,0.1,0,0,"Beiriz");
       ContribuintesColetivos cc12 = new ContribuintesColetivos (null,null,null,"321652135","cabelo@gmail.com","Cabelo Solto","Rua Cidade de Bolama","1234",AtividadeCabeloSolto,0.3,0,0,"Arnozela");
       ContribuintesColetivos cc13 = new ContribuintesColetivos (null,null,null,"205350564","motel@gmail.com","Motel","Rua Garrett","noitepacifica",AtividadeMotel,0.4,0,0,"Trofa");
       ContribuintesColetivos cc14 = new ContribuintesColetivos (null,null,null,"320505005","garagem@gmail.com","Garagem Cunha","Rua dos Heróis de Quionga","geladodemorango",AtividadeGaragemCunha,0.2,0,0,"Barcelos");
       ContribuintesColetivos cc15 = new ContribuintesColetivos (null,null,null,"250369825","cafe@gmail.com","Café do Luís","Avenida dos Aliados","1232",AtividadeCaféDoLuís,0.2,0,0,"Trofa");
       EmpresaInterior cc16 = new EmpresaInterior (null,null,null,"658235478","adegas@gmail.com","Adegas Costa","Rua da Saúde","hehea",AtividadeAdegasCosta,0.4,0,0,"Trancoso");
       EmpresaInterior cc17 = new EmpresaInterior (null,null,null,"235842585","quinta@gmail.com","Quinta da Sertã","Rua da Saudade","adafq",AtividadeQuintaDaSertã,0.4,0,0,"Sertã");
       EmpresaInterior cc18 = new EmpresaInterior (null,null,null,"325843252","suinos@gmail.com","Suínos e Companhia","Rua de Nossa Senhora","hefashea",AtividadeSuínosECompanhia,0.2,0,0,"Fornos de Algodres");
       EmpresaInterior cc19 = new EmpresaInterior (null,null,null,"325421521","paletes@gmail.com","Paletes e Madeiras","Rua da Tribuna","hfasehea",AtividadePaletesEMadeiras,0.3,0,0,"Vila Velha de Ródão");
       EmpresaInterior cc20 = new EmpresaInterior (null,null,null,"211542122","pomar@gmail.com","Pomar Carvalho","Rua do Coreto","heashea",AtividadePomarCarvalho,0.3,0,0,"Pampilhosa da Serra");

       ArrayList <String> CódigoDanielaFerreira = new ArrayList<String>();       
       CódigoDanielaFerreira.add("DG678");
       CódigoDanielaFerreira.add("L502");
       CódigoDanielaFerreira.add("H512");
       
       ArrayList <String> CódigoBeatrizMonteiro = new ArrayList<String>();       
       CódigoBeatrizMonteiro.add("AV292");
       CódigoBeatrizMonteiro.add("RM333");
       CódigoBeatrizMonteiro.add("RA897");
       CódigoBeatrizMonteiro.add("RA1278");
       
       ArrayList <String> CódigoDanielMota = new ArrayList<String>();       
       CódigoDanielMota.add("L502");
       CódigoDanielMota.add("C201");
       
       ArrayList <String> CódigoPedroPinto = new ArrayList<String>();       
       CódigoPedroPinto.add("H512");
       
       ArrayList <String> CódigoFranciscoLaço = new ArrayList<String>();       
       CódigoFranciscoLaço.add("S126");

       ArrayList <String> AgregadoDiogoTeixeira = new ArrayList<String>();
       AgregadoDiogoTeixeira.add("456875456");
       
       ArrayList <String> AgregadoHoracioTeixeira = new ArrayList<String>();
       AgregadoHoracioTeixeira.add("678654654");

       ArrayList <String> AgregadoMiguelBarbosa = new ArrayList<String>();
       AgregadoMiguelBarbosa.add("867945645");

       ArrayList <String> AgregadoJoaoBarbosa = new ArrayList<String>();
       AgregadoJoaoBarbosa.add("678645364");

       ArrayList <String> AgregadoSofiaGonçalves = new ArrayList<String>();
       AgregadoSofiaGonçalves.add("244245645");

       ArrayList <String> AgregadoDércioGonçalves = new ArrayList<String>();
       AgregadoDércioGonçalves.add("245642343");

       ArrayList <String> AgregadoCristianoMonteiro = new ArrayList<String>();
       AgregadoCristianoMonteiro.add("645645655");
       AgregadoCristianoMonteiro.add("678697899");
       AgregadoCristianoMonteiro.add("645645666");
       AgregadoCristianoMonteiro.add("340467866");
       AgregadoCristianoMonteiro.add("789456799");
       AgregadoCristianoMonteiro.add("546786546");

       ArrayList <String> AgregadoJorgeMonteiro = new ArrayList<String>();
       AgregadoJorgeMonteiro.add("645645645");
       AgregadoJorgeMonteiro.add("678697899");
       AgregadoJorgeMonteiro.add("645645666");
       AgregadoJorgeMonteiro.add("340467866");
       AgregadoJorgeMonteiro.add("789456799");
       AgregadoJorgeMonteiro.add("546786546");

       ArrayList <String> AgregadoClaúdiaMonteiro = new ArrayList<String>();
       AgregadoClaúdiaMonteiro.add("645645645");
       AgregadoClaúdiaMonteiro.add("645645655");
       AgregadoClaúdiaMonteiro.add("645645666");
       AgregadoClaúdiaMonteiro.add("340467866");
       AgregadoClaúdiaMonteiro.add("789456799");
       AgregadoClaúdiaMonteiro.add("546786546");

       ArrayList <String> AgregadoBeatrizMonteiro = new ArrayList<String>();
       AgregadoBeatrizMonteiro.add("645645645");
       AgregadoBeatrizMonteiro.add("645645655");
       AgregadoBeatrizMonteiro.add("678697899");
       AgregadoBeatrizMonteiro.add("340467866");
       AgregadoBeatrizMonteiro.add("789456799");
       AgregadoBeatrizMonteiro.add("546786546");

       ArrayList <String> AgregadoXavierMonteiro = new ArrayList<String>();
       AgregadoXavierMonteiro.add("645645645");
       AgregadoXavierMonteiro.add("645645655");
       AgregadoXavierMonteiro.add("678697899");
       AgregadoXavierMonteiro.add("645645666");
       AgregadoXavierMonteiro.add("789456799");
       AgregadoXavierMonteiro.add("546786546");

       ArrayList <String> AgregadoFábioMonteiro = new ArrayList<String>();
       AgregadoFábioMonteiro.add("645645645");
       AgregadoFábioMonteiro.add("645645655");
       AgregadoFábioMonteiro.add("678697899");
       AgregadoFábioMonteiro.add("645645666");
       AgregadoFábioMonteiro.add("340467866");
       AgregadoFábioMonteiro.add("546786546");

       ArrayList <String> AgregadoJoaoMonteiro = new ArrayList<String>();
       AgregadoJoaoMonteiro.add("645645645");
       AgregadoJoaoMonteiro.add("645645655");
       AgregadoJoaoMonteiro.add("678697899");
       AgregadoJoaoMonteiro.add("645645666");
       AgregadoJoaoMonteiro.add("340467866");
       AgregadoJoaoMonteiro.add("789456799");

       ArrayList <String> AgregadoFranciscoLaço = new ArrayList<String>();
       AgregadoFranciscoLaço.add("456787765");
       AgregadoFranciscoLaço.add("642324564"); 

       ArrayList <String> AgregadoMariaLaço = new ArrayList<String>();
       AgregadoMariaLaço.add("642324564");
       AgregadoMariaLaço.add("404567786"); 

       ArrayList <String> AgregadoJoanaLaço = new ArrayList<String>();
       AgregadoJoanaLaço.add("456787765");
       AgregadoJoanaLaço.add("404567786"); 

       ArrayList <String> AgregadoDanielaFerreira = new ArrayList<String>();
       AgregadoDanielaFerreira.add("456756787");
       AgregadoDanielaFerreira.add("678645678"); 
       AgregadoDanielaFerreira.add("679676546");
       AgregadoDanielaFerreira.add("678676857");
       AgregadoDanielaFerreira.add("678524654");
       AgregadoDanielaFerreira.add("678522456");

       ArrayList <String> AgregadoGonçaloFerreira = new ArrayList<String>();
       AgregadoGonçaloFerreira.add("645678674");
       AgregadoGonçaloFerreira.add("678645678");
       AgregadoGonçaloFerreira.add("678676857");
       AgregadoGonçaloFerreira.add("679676546");
       AgregadoGonçaloFerreira.add("678524654");
       AgregadoGonçaloFerreira.add("678522456");

       ArrayList <String> AgregadoMónicaFerreira = new ArrayList<String>();
       AgregadoMónicaFerreira.add("645678674");
       AgregadoMónicaFerreira.add("456756787");
       AgregadoMónicaFerreira.add("678676857");
       AgregadoMónicaFerreira.add("679676546");
       AgregadoMónicaFerreira.add("678524654");
       AgregadoMónicaFerreira.add("678522456");

       ArrayList <String> AgregadoAlbertoFerreira = new ArrayList<String>();
       AgregadoAlbertoFerreira.add("645678674");
       AgregadoAlbertoFerreira.add("456756787");
       AgregadoAlbertoFerreira.add("678645678");
       AgregadoAlbertoFerreira.add("678676857");
       AgregadoAlbertoFerreira.add("678524654");
       AgregadoAlbertoFerreira.add("678522456");

       ArrayList <String> AgregadoAnaFerreira = new ArrayList<String>();
       AgregadoAnaFerreira.add("645678674");
       AgregadoAnaFerreira.add("456756787");
       AgregadoAnaFerreira.add("678645678");
       AgregadoAnaFerreira.add("679676546");
       AgregadoAnaFerreira.add("678524654");
       AgregadoAnaFerreira.add("678522456"); 

       ArrayList <String> AgregadoPedroFerreira = new ArrayList<String>();
       AgregadoPedroFerreira.add("645678674");
       AgregadoPedroFerreira.add("456756787");
       AgregadoPedroFerreira.add("678645678");
       AgregadoPedroFerreira.add("679676546");
       AgregadoPedroFerreira.add("678676857");
       AgregadoPedroFerreira.add("678522456");

       ArrayList <String> AgregadoRodrigoFerreira = new ArrayList<String>();
       AgregadoRodrigoFerreira.add("645678674");
       AgregadoRodrigoFerreira.add("456756787");
       AgregadoRodrigoFerreira.add("678645678");
       AgregadoRodrigoFerreira.add("679676546");
       AgregadoRodrigoFerreira.add("678676857");
       AgregadoRodrigoFerreira.add("678524654");


       
       ContribuintesIndividuais ci1 = new ContribuintesIndividuais (null,null,"525365282","pedro@gmail.com","Pedro Pinto","Rua das Carmelitas","trocas",0,null,0.2,CódigoPedroPinto,0,0);
       ContribuintesIndividuais ci2 = new ContribuintesIndividuais (null,null,"321563435","jose@gmail.com","José Carreira","Rua do Comércio do Porto","trump",0,null,0.3,null,0,0);
       ContribuintesIndividuais ci3 = new ContribuintesIndividuais (null,null,"354265456","fatima@gmail.com","Fátima Cabral","Rua do Almada","marega",0,null,0.2,null,0,0);
       ContribuintesIndividuais ci4 = new ContribuintesIndividuais (null,null,"546485133","carina@gmail.com","Carina Ramos","Avenida da Républica","passoriginal",0,null,0.4,null,0,0);
       ContribuintesIndividuais ci5 = new ContribuintesIndividuais (null,null,"547864566","paulo@gmail.com","Paulo Carvalho","Rua Carlos Carvalho","",0,null,0.3,null,0,0);
       ContribuintesIndividuais ci6 = new ContribuintesIndividuais (null,null,"456782545","francisco@gmail.com","Francisco Alves","Rua de Sta. Cruz","pata",0,null,0.4,null,0,0);
       ContribuintesIndividuais ci7 = new ContribuintesIndividuais (null,null,"546786455","pedropinto@gmail.com","Pedro Campos","Rua nr 45","tromba",0,null,0.3,null,0,0);
       ContribuintesIndividuais ci8 = new ContribuintesIndividuais (null,null,"678694564","jessica@gmail.com","Jéssica Moreira","Rua de D. Hugo","papagaio",0,null,0.1,null,0,0);
       ContribuintesIndividuais ci9 = new ContribuintesIndividuais (null,null,"456786745","marta@gmail.com","Marta Campos","Rua da Madalena","informatica",0,null,0.1,null,0,0);
       ContribuintesIndividuais ci10 = new ContribuintesIndividuais (null,null,"678654654","diogo@gmail.com","Diogo Teixeira","Rua de Belomonte","eraumavez",1,AgregadoDiogoTeixeira,0.2,null,0,0);
       ContribuintesIndividuais ci11 = new ContribuintesIndividuais (null,null,"678645364","miguel@gmail.com","Miguel Barbosa","Rua do Breiner","salas24",1,AgregadoMiguelBarbosa,0.4,null,0,0);
       ContribuintesIndividuais ci12 = new ContribuintesIndividuais (null,null,"867945645","barbosa@gmail.com","João Barbosa","Rua do Breiner","biblioteca",1,AgregadoJoaoBarbosa,0.3,null,0,0);
       ContribuintesIndividuais ci13 = new ContribuintesIndividuais (null,null,"456875456","horacio@gmail.com","Horácio Teixeira","Rua de Belomonte","passesfixes",1,AgregadoHoracioTeixeira,0.2,null,0,0);
       ContribuintesIndividuais ci14 = new ContribuintesIndividuais (null,null,"675614565","lima@gmail.com","Jorge Lima","Praça do Rossio","sooriginalidade",0,null,0.1,null,0,0);
       ContribuintesIndividuais ci15 = new ContribuintesIndividuais (null,null,"452145645","teixeira@gmail.com","Armando Teixeira","Rua da Prata","metadejafoi",0,null,0.4,null,0,0);
       ContribuintesIndividuais ci16 = new ContribuintesIndividuais (null,null,"404567786","laco@gmail.com","Francisco Laço","Rua do Carvalhido","POO",2,AgregadoFranciscoLaço,0.2,CódigoFranciscoLaço,1,0);
       ContribuintesIndividuais ci17 = new ContribuintesIndividuais (null,null,"456787765","maria@gmail.com","Maria Laço","Rua do Carvalhido","2ano",2,AgregadoMariaLaço,0.4,null,1,0);
       ContribuintesIndividuais ci18 = new ContribuintesIndividuais (null,null,"642324564","joana@gmail.com","Joana Laço","Rua do Carvalhido","Porto",2,AgregadoJoanaLaço,0.2,null,0,0);
       ContribuintesIndividuais ci19 = new ContribuintesIndividuais (null,null,"245642343","sofia@gmail.com","Sofia Gonçalves","Rua de Cedofeita","xanax",1,AgregadoSofiaGonçalves,0.3,null,0,0);
       ContribuintesIndividuais ci20 = new ContribuintesIndividuais (null,null,"244245645","dercio@gmail.com","Dércio Gonçalves","Rua de Cedofeita","sopasses",1,AgregadoDércioGonçalves,0.4,null,0,0);
       ContribuintesIndividuais ci21 = new ContribuintesIndividuais (null,null,"645045645","tomas@gmail.com","Tomás Ornelas","Rua do Ouro","jafaltoumais",0,null,0.2,null,0,0);
       ContribuintesIndividuais ci22 = new ContribuintesIndividuais (null,null,"546785677","lucas@gmail.com","LucasCosta","Avenida de Camões","nevergiveup",0,null,0.4,null,0,0);
       ContribuintesIndividuais ci23 = new ContribuintesIndividuais (null,null,"678654646","ines@gmail.com","Inês Sobral","Rua Júlio Cesar","siga",0,null,0.1,null,0,0);
       ContribuintesIndividuais ci24 = new ContribuintesIndividuais (null,null,"678546786","dias@gmail.com","Fernando Dias","Lapa","somais1",0,null,0.3,null,0,0);
       ContribuintesIndividuais ci25 = new ContribuintesIndividuais (null,null,"678522456","rodrigo@gmail.com","Rodrigo Ferreira","Rua do Carmo","rumoao20",6,AgregadoRodrigoFerreira,0.3,null,0,0);
       ContribuintesIndividuais ci26 = new ContribuintesIndividuais (null,null,"546786546","joão@gmail.com","João Monteiro","Rua Faria Guimarães","ervilhas",6,AgregadoJoaoMonteiro,0.3,null,0,0);
       ContribuintesIndividuais ci27 = new ContribuintesIndividuais (null,null,"678678655","daniel@gmail.com","Daniel Mota","Molares","arrozdepato",0,null,0.1,CódigoDanielMota,0,0);
       ContribuintesIndividuais ci28 = new ContribuintesIndividuais (null,null,"645678674","daniela@gmail.com","Daniela Ferreira","Rua do Carmo","carmo",6,AgregadoDanielaFerreira,0.3,CódigoDanielaFerreira,0,0);
       ContribuintesIndividuais ci29 = new ContribuintesIndividuais (null,null,"456756787","freitas@gmail.com","Gonçalo Ferreira","Rua do Carmo","carminda",6,AgregadoGonçaloFerreira,0.3,null,0,0);
       ContribuintesIndividuais ci30 = new ContribuintesIndividuais (null,null,"678645678","carvalho@gmail.com","Mónica Ferreira","Rua do Carmo","familiacarmo",6,AgregadoMónicaFerreira,0.4,null,0,0);
       ContribuintesIndividuais ci31 = new ContribuintesIndividuais (null,null,"679676546","magalhaes@gmail.com","Alberto Ferreira","Rua do Carmo","feelfree",6,AgregadoAlbertoFerreira,0.3,null,0,0);
       FamiliaNumerosa ci32 = new FamiliaNumerosa (null,null,"678676857","silva@gmail.com","Ana Ferreira","Rua do Carmo","youwillneverfind",6,AgregadoAnaFerreira,0.3,null,5,0);
       FamiliaNumerosa ci33 = new FamiliaNumerosa (null,null,"678524654","vila@gmail.com","Pedro Ferreira","Rua do Carmo","maio",6,AgregadoPedroFerreira,0.1,null,5,0);
       ContribuintesIndividuais ci34 = new ContribuintesIndividuais (null,null,"645645664","ronaldo@gmail.com","Roberto Ronaldo","Rua de São Mamede","enterrodagata",0,null,0.2,null,0,0);
       ContribuintesIndividuais ci35 = new ContribuintesIndividuais (null,null,"645645645","cristiano@gmail.com","Cristiano Monteiro","Rua Faria Guimarães","freecamisolas",6,AgregadoCristianoMonteiro,0.4,null,0,0);
       FamiliaNumerosa ci36 = new FamiliaNumerosa (null,null,"645645655","jesus@gmail.com","Jorge Monteiro","Rua Faria Guimarães","estafeito",6,AgregadoJorgeMonteiro,0.4,null,5,0);
       FamiliaNumerosa ci37 = new FamiliaNumerosa (null,null,"678697899","claudia@gmail.com","Claúdia Monteiro","Rua Faria Guimarães","upsafinalnao",6,AgregadoClaúdiaMonteiro,0.2,null,5,0);
       ContribuintesIndividuais ci38 = new ContribuintesIndividuais (null,null,"645645666","beatriz@gmail.com","Beatriz Monteiro","Rua Faria Guimarães","tenhofome",6,AgregadoBeatrizMonteiro,0.1,CódigoBeatrizMonteiro,0,0);
       ContribuintesIndividuais ci39 = new ContribuintesIndividuais (null,null,"340467866","xavier@gmail.com","Xavier Monteiro","Rua Faria Guimarães","aquehoraseoalmoço",6,AgregadoXavierMonteiro,0.4,null,0,0);
       ContribuintesIndividuais ci40 = new ContribuintesIndividuais (null,null,"789456799","fabio@gmail.com","Fábio Monteiro","Rua Faria Guimarães","password",6,AgregadoFábioMonteiro,0.1,null,0,0);

       Contribuinte c1 = (Contribuinte) cc1;
       Contribuinte c2 = (Contribuinte) cc2;
       Contribuinte c3 = (Contribuinte) cc3;
       Contribuinte c4 = (Contribuinte) cc4;
       Contribuinte c5 = (Contribuinte) cc5;
       Contribuinte c6 = (Contribuinte) cc6;
       Contribuinte c7 = (Contribuinte) cc7;
       Contribuinte c8 = (Contribuinte) cc8;
       Contribuinte c9 = (Contribuinte) cc9;
       Contribuinte c10 = (Contribuinte) cc10;
       Contribuinte c11 = (Contribuinte) cc11;
       Contribuinte c12 = (Contribuinte) cc12;
       Contribuinte c13 = (Contribuinte) cc13;
       Contribuinte c14 = (Contribuinte) cc14;
       Contribuinte c15 = (Contribuinte) cc15;
       Contribuinte c16 = (Contribuinte) cc16;
       Contribuinte c17 = (Contribuinte) cc17;
       Contribuinte c18 = (Contribuinte) cc18;
       Contribuinte c19 = (Contribuinte) cc19;
       Contribuinte c20 = (Contribuinte) cc20;
       Contribuinte c21 = (Contribuinte) ci1;
       Contribuinte c22 = (Contribuinte) ci2;
       Contribuinte c23 = (Contribuinte) ci3;
       Contribuinte c24 = (Contribuinte) ci4;
       Contribuinte c25 = (Contribuinte) ci5;
       Contribuinte c26 = (Contribuinte) ci6;
       Contribuinte c27 = (Contribuinte) ci7;
       Contribuinte c28 = (Contribuinte) ci8;
       Contribuinte c29 = (Contribuinte) ci9;
       Contribuinte c30 = (Contribuinte) ci10;
       Contribuinte c31 = (Contribuinte) ci11;
       Contribuinte c32 = (Contribuinte) ci12;
       Contribuinte c33 = (Contribuinte) ci13;
       Contribuinte c34 = (Contribuinte) ci14;
       Contribuinte c35 = (Contribuinte) ci15;
       Contribuinte c36 = (Contribuinte) ci16;
       Contribuinte c37 = (Contribuinte) ci17;
       Contribuinte c38 = (Contribuinte) ci18;
       Contribuinte c39 = (Contribuinte) ci19;
       Contribuinte c40 = (Contribuinte) ci20;
       Contribuinte c41 = (Contribuinte) ci21;
       Contribuinte c42 = (Contribuinte) ci22;
       Contribuinte c43 = (Contribuinte) ci23;
       Contribuinte c44 = (Contribuinte) ci24;
       Contribuinte c45 = (Contribuinte) ci25;
       Contribuinte c46 = (Contribuinte) ci26;
       Contribuinte c47 = (Contribuinte) ci27;
       Contribuinte c48 = (Contribuinte) ci28;
       Contribuinte c49 = (Contribuinte) ci29;
       Contribuinte c50 = (Contribuinte) ci30;
       Contribuinte c51 = (Contribuinte) ci31;
       Contribuinte c52 = (Contribuinte) ci32;
       Contribuinte c53 = (Contribuinte) ci33;
       Contribuinte c54 = (Contribuinte) ci34;
       Contribuinte c55 = (Contribuinte) ci35;
       Contribuinte c56 = (Contribuinte) ci36;
       Contribuinte c57 = (Contribuinte) ci37;
       Contribuinte c58 = (Contribuinte) ci38;
       Contribuinte c59 = (Contribuinte) ci39;
       Contribuinte c60 = (Contribuinte) ci40;
    
       Fatura ff1 = (Fatura) f1;
       Fatura ff2 = (Fatura) f2;
       Fatura ff3 = (Fatura) f3;
       Fatura ff4 = (Fatura) f4;
       Fatura ff5 = (Fatura) f5;       
       Fatura ff6 = (Fatura) f6;
       Fatura ff7 = (Fatura) f7;
       Fatura ff8 = (Fatura) f8;
       Fatura ff9 = (Fatura) f9;
       Fatura ff10 = (Fatura) f10;
       Fatura ff11 = (Fatura) f11;
       Fatura ff12 = (Fatura) f12;
       Fatura ff13 = (Fatura) f13;
       Fatura ff14 = (Fatura) f14;
       Fatura ff15 = (Fatura) f15;
       Fatura ff16 = (Fatura) f16;
       Fatura ff17 = (Fatura) f17;
       Fatura ff18 = (Fatura) f18;
       Fatura ff19 = (Fatura) f19;
       Fatura ff20 = (Fatura) f20;
       Fatura ff21 = (Fatura) f21;
       Fatura ff22 = (Fatura) f22;
       Fatura ff23 = (Fatura) f23;
       Fatura ff24 = (Fatura) f24;
       Fatura ff25 = (Fatura) f25;
       Fatura ff26 = (Fatura) f26;
       Fatura ff27 = (Fatura) f27;
       Fatura ff28 = (Fatura) f28;
       Fatura ff29 = (Fatura) f29;
       Fatura ff30 = (Fatura) f30;
       Fatura ff31 = (Fatura) f31;
       Fatura ff32 = (Fatura) f32;
       Fatura ff33 = (Fatura) f33;
       Fatura ff34 = (Fatura) f34;
       Fatura ff35 = (Fatura) f35;
       Fatura ff36 = (Fatura) f36;
       Fatura ff37 = (Fatura) f37;
       Fatura ff38 = (Fatura) f38;
       Fatura ff39 = (Fatura) f39;
       Fatura ff40 = (Fatura) f40;
       Fatura ff41 = (Fatura) f41;
       Fatura ff42 = (Fatura) f42;
       Fatura ff43 = (Fatura) f43;
       Fatura ff44 = (Fatura) f44;
       Fatura ff45 = (Fatura) f45;
       Fatura ff46 = (Fatura) f46;
       Fatura ff47 = (Fatura) f47;
       Fatura ff48 = (Fatura) f48;
       Fatura ff49 = (Fatura) f49;
       Fatura ff50 = (Fatura) f50;
       Fatura ff51 = (Fatura) f51;
       Fatura ff52 = (Fatura) f52;
       Fatura ff53 = (Fatura) f53;
       Fatura ff54 = (Fatura) f54;
       Fatura ff55 = (Fatura) f55;
       Fatura ff56 = (Fatura) f56;
       Fatura ff57 = (Fatura) f57;
       Fatura ff58 = (Fatura) f58;
       Fatura ff59 = (Fatura) f59;
       Fatura ff60 = (Fatura) f60;
       Fatura ff61 = (Fatura) f61;
       Fatura ff62 = (Fatura) f62;
       Fatura ff63 = (Fatura) f63;
       Fatura ff64 = (Fatura) f64;
       Fatura ff65 = (Fatura) f65;
       Fatura ff66 = (Fatura) f66;
       Fatura ff67 = (Fatura) f67;
       Fatura ff68 = (Fatura) f68;
       Fatura ff69 = (Fatura) f69;
       Fatura ff70 = (Fatura) f70;
       Fatura ff71 = (Fatura) f71;
       Fatura ff72 = (Fatura) f72;
       Fatura ff73 = (Fatura) f73;
       Fatura ff74 = (Fatura) f74;
       Fatura ff75 = (Fatura) f75;
       Fatura ff76 = (Fatura) f76;
       Fatura ff77 = (Fatura) f77;
       Fatura ff78 = (Fatura) f78;
       Fatura ff79 = (Fatura) f79;
       Fatura ff80 = (Fatura) f80;
       Fatura ff81 = (Fatura) f81;
       Fatura ff82 = (Fatura) f82;
       Fatura ff83 = (Fatura) f83;
       Fatura ff84 = (Fatura) f84;
       Fatura ff85 = (Fatura) f85;
       Fatura ff86 = (Fatura) f86;
       Fatura ff87 = (Fatura) f87;
       Fatura ff88 = (Fatura) f88;
       Fatura ff89 = (Fatura) f89;
       Fatura ff90 = (Fatura) f90;
       Fatura ff91 = (Fatura) f91;
       Fatura ff92 = (Fatura) f92;
       Fatura ff93 = (Fatura) f93;
       Fatura ff94 = (Fatura) f94;
       Fatura ff95 = (Fatura) f95;
       Fatura ff96 = (Fatura) f96;
       Fatura ff97 = (Fatura) f97;
       Fatura ff98 = (Fatura) f98;
       Fatura ff99 = (Fatura) f99;
       Fatura ff100 = (Fatura) f100;
       Fatura ff101 = (Fatura) f101;
       Fatura ff102 = (Fatura) f102;
       Fatura ff103 = (Fatura) f103;
       Fatura ff104 = (Fatura) f104;
       Fatura ff105 = (Fatura) f105;
       Fatura ff106 = (Fatura) f106;
       Fatura ff107 = (Fatura) f107;
       Fatura ff108 = (Fatura) f108;
       Fatura ff109 = (Fatura) f109;
       Fatura ff110 = (Fatura) f110;
       Fatura ff111 = (Fatura) f111;
       Fatura ff112 = (Fatura) f112;
       Fatura ff113 = (Fatura) f113;
       Fatura ff114 = (Fatura) f114;
       Fatura ff115 = (Fatura) f115;
       Fatura ff116 = (Fatura) f116;
       Fatura ff117 = (Fatura) f117;
       Fatura ff118 = (Fatura) f118;
       Fatura ff119 = (Fatura) f119;
       Fatura ff120 = (Fatura) f120;
       Fatura ff121 = (Fatura) f121;
       Fatura ff122 = (Fatura) f122;
       Fatura ff123 = (Fatura) f123;
       Fatura ff124 = (Fatura) f124;
       Fatura ff125 = (Fatura) f125;
       Fatura ff126 = (Fatura) f126;
       Fatura ff127 = (Fatura) f127;
       Fatura ff128 = (Fatura) f128;
       Fatura ff129 = (Fatura) f129;
       Fatura ff130 = (Fatura) f130;
       Fatura ff131 = (Fatura) f131;
       Fatura ff132 = (Fatura) f132;
       Fatura ff133 = (Fatura) f133;
       Fatura ff134 = (Fatura) f134;
       Fatura ff135 = (Fatura) f135;
       Fatura ff136 = (Fatura) f136;
       Fatura ff137 = (Fatura) f137;
       Fatura ff138 = (Fatura) f138;
       Fatura ff139 = (Fatura) f139;
       Fatura ff140 = (Fatura) f140;
       Fatura ff141 = (Fatura) f141;
       Fatura ff142 = (Fatura) f142;
       Fatura ff143 = (Fatura) f143;
       Fatura ff144 = (Fatura) f144;
       Fatura ff145 = (Fatura) f145;
       Fatura ff146 = (Fatura) f146;
       Fatura ff147 = (Fatura) f147;
       Fatura ff148 = (Fatura) f148;
       Fatura ff149 = (Fatura) f149;
       Fatura ff150 = (Fatura) f150;
       Fatura ff151 = (Fatura) f151;
       Fatura ff152 = (Fatura) f152;
       Fatura ff153 = (Fatura) f153;
       Fatura ff154 = (Fatura) f154;
       Fatura ff155 = (Fatura) f155;
       Fatura ff156 = (Fatura) f156;
       Fatura ff157 = (Fatura) f157;
       Fatura ff158 = (Fatura) f158;
       Fatura ff159 = (Fatura) f159;
       Fatura ff160 = (Fatura) f160;
       Fatura ff161 = (Fatura) f161;
       Fatura ff162 = (Fatura) f162;
       Fatura ff163 = (Fatura) f163;
       Fatura ff164 = (Fatura) f164;
       Fatura ff165 = (Fatura) f165;
       Fatura ff166 = (Fatura) f166;
       Fatura ff167 = (Fatura) f167;
       Fatura ff168 = (Fatura) f168;
       Fatura ff169 = (Fatura) f169;
       Fatura ff170 = (Fatura) f170;
       Fatura ff171 = (Fatura) f171;
       Fatura ff172 = (Fatura) f172;
       Fatura ff173 = (Fatura) f173;
       Fatura ff174 = (Fatura) f174;
       Fatura ff175 = (Fatura) f175;
       Fatura ff176 = (Fatura) f176;
       Fatura ff177 = (Fatura) f177;
       Fatura ff178 = (Fatura) f178;
       Fatura ff179 = (Fatura) f179;
       Fatura ff180 = (Fatura) f180;
       Fatura ff181 = (Fatura) f181;
       Fatura ff182 = (Fatura) f182;
       Fatura ff183 = (Fatura) f183;
       Fatura ff184 = (Fatura) f184;
       Fatura ff185 = (Fatura) f185;
       Fatura ff186 = (Fatura) f186;
       Fatura ff187 = (Fatura) f187;
       Fatura ff188 = (Fatura) f188;
       Fatura ff189 = (Fatura) f189;
       Fatura ff190 = (Fatura) f190;
       Fatura ff191 = (Fatura) f191;
       Fatura ff192 = (Fatura) f192;
       Fatura ff193 = (Fatura) f193;
       Fatura ff194 = (Fatura) f194;
       Fatura ff195 = (Fatura) f195;
       Fatura ff196 = (Fatura) f196;
       Fatura ff197 = (Fatura) f197;
       Fatura ff198 = (Fatura) f198;
       Fatura ff199 = (Fatura) f199;
       Fatura ff200 = (Fatura) f200;
       Fatura ff201 = (Fatura) f201;
       Fatura ff202 = (Fatura) f202;
       Fatura ff203 = (Fatura) f203;
       Fatura ff204 = (Fatura) f204;
       Fatura ff205 = (Fatura) f205;
       Fatura ff206 = (Fatura) f206;
       Fatura ff207 = (Fatura) f207;
       Fatura ff208 = (Fatura) f208;
       Fatura ff209 = (Fatura) f209;
       Fatura ff210 = (Fatura) f210;
       Fatura ff211 = (Fatura) f211;
       Fatura ff212 = (Fatura) f212;
       Fatura ff213 = (Fatura) f213;
       Fatura ff214 = (Fatura) f214;
       Fatura ff215 = (Fatura) f215;
       Fatura ff216 = (Fatura) f216;
       Fatura ff217 = (Fatura) f217;
       Fatura ff218 = (Fatura) f218;
       Fatura ff219 = (Fatura) f219;
       Fatura ff220 = (Fatura) f220;
       Fatura ff221 = (Fatura) f221;
       Fatura ff222 = (Fatura) f222;
       Fatura ff223 = (Fatura) f223;
       Fatura ff224 = (Fatura) f224;
       Fatura ff225 = (Fatura) f225;
       Fatura ff226 = (Fatura) f226;
       Fatura ff227 = (Fatura) f227;
       Fatura ff228 = (Fatura) f228;
       Fatura ff229 = (Fatura) f229;


       try{
           javaFatura.registaContribuinte(c1);
           javaFatura.registaContribuinte(c2);
           javaFatura.registaContribuinte(c3);
           javaFatura.registaContribuinte(c4);
           javaFatura.registaContribuinte(c5);
           javaFatura.registaContribuinte(c6);
           javaFatura.registaContribuinte(c7);
           javaFatura.registaContribuinte(c8);
           javaFatura.registaContribuinte(c9);
           javaFatura.registaContribuinte(c10);
           javaFatura.registaContribuinte(c11);
           javaFatura.registaContribuinte(c12);
           javaFatura.registaContribuinte(c13);
           javaFatura.registaContribuinte(c14);
           javaFatura.registaContribuinte(c15);
           javaFatura.registaContribuinte(c16);
           javaFatura.registaContribuinte(c17);
           javaFatura.registaContribuinte(c18);
           javaFatura.registaContribuinte(c19);
           javaFatura.registaContribuinte(c20);
           javaFatura.registaContribuinte(c21);
           javaFatura.registaContribuinte(c22);
           javaFatura.registaContribuinte(c23);
           javaFatura.registaContribuinte(c24);
           javaFatura.registaContribuinte(c25);
           javaFatura.registaContribuinte(c26);
           javaFatura.registaContribuinte(c27);
           javaFatura.registaContribuinte(c28);
           javaFatura.registaContribuinte(c29);
           javaFatura.registaContribuinte(c30);
           javaFatura.registaContribuinte(c31);
           javaFatura.registaContribuinte(c32);
           javaFatura.registaContribuinte(c33);
           javaFatura.registaContribuinte(c34);
           javaFatura.registaContribuinte(c35);
           javaFatura.registaContribuinte(c36);
           javaFatura.registaContribuinte(c37);
           javaFatura.registaContribuinte(c38);
           javaFatura.registaContribuinte(c39);
           javaFatura.registaContribuinte(c40);
           javaFatura.registaContribuinte(c41);
           javaFatura.registaContribuinte(c42);
           javaFatura.registaContribuinte(c43);
           javaFatura.registaContribuinte(c44);
           javaFatura.registaContribuinte(c45);
           javaFatura.registaContribuinte(c46);
           javaFatura.registaContribuinte(c47);
           javaFatura.registaContribuinte(c48);
           javaFatura.registaContribuinte(c49);
           javaFatura.registaContribuinte(c50);
           javaFatura.registaContribuinte(c51);
           javaFatura.registaContribuinte(c52);
           javaFatura.registaContribuinte(c53);
           javaFatura.registaContribuinte(c54);
           javaFatura.registaContribuinte(c55);
           javaFatura.registaContribuinte(c56);
           javaFatura.registaContribuinte(c57);
           javaFatura.registaContribuinte(c58);
           javaFatura.registaContribuinte(c59);
           javaFatura.registaContribuinte(c60);
       }
       catch (ContribuinteExistenteException e){
              System.out.println("fail regista contribuinte");
       }

       try{
            javaFatura.login("925462521","123asd");  //System.out.println("Login");
       }
       catch (SemAutorizaçãoException e){
            System.out.println("fail login 925462521");
       }
       
       try{
           javaFatura.registaFatura(ff161);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff162);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff163);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff200);  //System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("956465465","103asd");  //System.out.println("Login");
       }
       catch (SemAutorizaçãoException e){
            System.out.println("fail login 956465465");
       }
       
       try{
           javaFatura.registaFatura(ff164);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff165);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff201);  //System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("123525545","12d");  //System.out.println("Login");
       }
       catch (SemAutorizaçãoException e){
            System.out.println("fail login 123525545");
       }
       
       try{
           javaFatura.registaFatura(ff86);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff87);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff106);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff107);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff108); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff136);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff137);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff138);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff139);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff141);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff142); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff143);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff144);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff145);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff202);  //System.out.println("Regista fatura");

        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("925465521","123asd");  //System.out.println("Login");
       }
       catch (SemAutorizaçãoException e){
            System.out.println("fail login 925465521");
       }
       
       try{
           javaFatura.registaFatura(ff36);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff37);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff38);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff39);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff40);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff76);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff77);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff78);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff79);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff80);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff131); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff132); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff133);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff134); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff135); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff146); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff147); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff148); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff149);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff150); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff203);  //System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("123543214","1asasd");  //System.out.println("Login");
       }
       catch (SemAutorizaçãoException e){
            System.out.println("fail login 123543214");
       }
       
       try{
           javaFatura.registaFatura(ff1);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff2); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff3); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff4); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff5); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff56);//  System.out.println("Regista fatura");
           javaFatura.registaFatura(ff57);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff58);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff59);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff60);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff204); // System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("546852512","trocatintas");  //System.out.println("Login");
       }
       catch (SemAutorizaçãoException e){
            System.out.println("fail login 546852512");
       }
       
       try{
           javaFatura.registaFatura(ff51);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff109);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff110); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff205);  //System.out.println("Regista fatura");

        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("123265814","hotel12");  //System.out.println("Login");
       }
       catch (SemAutorizaçãoException e){
            System.out.println("fail login 123265814");
       }
       
       try{
           javaFatura.registaFatura(ff11);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff12);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff13);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff14);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff15);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff46);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff47);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff48);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff49);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff50);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff66);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff67);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff68);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff69);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff70);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff81);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff82);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff83);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff121);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff122);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff123);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff124);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff125);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff140);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff176);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff177);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff178);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff179);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff180);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff206);  //System.out.println("Regista fatura");


        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("978564581","animais");  //System.out.println("Login");
       }
       catch (SemAutorizaçãoException e){
            System.out.println("fail login 978564581");
       }
       
       try{
           javaFatura.registaFatura(ff41);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff42);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff43);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff44);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff45);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff96);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff97);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff98);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff99);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff100);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff151);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff152);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff153);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff154);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff155);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff207);  //System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
           javaFatura.login("132582138","raspadinhasdasorte");  //System.out.println("Login");       
        }
       catch (SemAutorizaçãoException e){
            System.out.println("fail login 132582138");
       }
       
       try{
           javaFatura.registaFatura(ff6);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff7);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff8);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff9);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff10);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff61);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff62);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff63);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff64);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff65);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff208);  //System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("564521384","gasoleo");  //System.out.println("Login");
        }
       catch (SemAutorizaçãoException e){
            System.out.println("fail login 564521384");
       }
       
       try{
       	   javaFatura.registaFatura(ff16);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff17);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff18);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff19);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff20);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff71);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff72);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff73); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff74);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff75);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff116); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff117); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff118);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff119); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff120);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff126); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff127);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff128);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff129);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff130);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff181);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff182); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff183);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff184); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff185);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff209);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff210);  //System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("321654132","CC234"); // System.out.println("Login");
        }
        catch (SemAutorizaçãoException e){
            System.out.println("fail login 321654132");
       }
       
       try{
           javaFatura.registaFatura(ff31);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff32);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff33);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff34); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff35);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff52);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff53);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff54);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff55);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff88);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff89);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff90); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff211); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff212); // System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();


       try{
            javaFatura.login("321652135","1234");  //System.out.println("Login");
        }
        catch (SemAutorizaçãoException e){
            System.out.println("fail login 321652135");
       }
       
       try{
           javaFatura.registaFatura(ff84);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff85);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff111); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff112); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff113);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff114);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff115);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff166); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff167); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff168); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff169); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff170);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff213); // System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("205350564","noitepacifica");  //System.out.println("Login");
        }
        catch (SemAutorizaçãoException e){
            System.out.println("fail login");
       }
       
       try{
           javaFatura.registaFatura(ff26);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff27);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff28); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff29); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff30);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff101); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff102); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff103); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff104);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff105);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff156);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff157); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff158); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff159);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff160);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff214); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff215); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff216); // System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("320505005","geladodemorango");  //System.out.println("Login");
        }
        catch (SemAutorizaçãoException e){
            System.out.println("fail login");
       }
       
       try{
           javaFatura.registaFatura(ff21);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff22);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff23);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff24);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff25);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff91);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff92);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff93);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff94);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff95);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff217); // System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();


       try{
            javaFatura.login("250369825","1232");  //System.out.println("Login");
        }
        catch (SemAutorizaçãoException e){
            System.out.println("fail login 250369825");
       }
       
       try{
           javaFatura.registaFatura(ff171);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff172);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff173);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff174);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff175);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff218);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff219);  //System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("658235478","hehea");  //System.out.println("Login");
        }
        catch (SemAutorizaçãoException e){
            System.out.println("fail login 658235478");
       }
       
       try{
           javaFatura.registaFatura(ff186);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff187);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff220); // System.out.println("Regista fatura");

        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("235842585","adafq"); // System.out.println("Login");
        }
        catch (SemAutorizaçãoException e){
            System.out.println("fail login 235842585");
       }
       
       try{
           javaFatura.registaFatura(ff188); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff189); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff190); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff221); // System.out.println("Regista fatura");


        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("325843252","hefashea");  //System.out.println("Login");
        }
        catch (SemAutorizaçãoException e){
            System.out.println("fail login 325843252");
       }
       
       try{
           javaFatura.registaFatura(ff191);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff192);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff222);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff223);  //System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();

       try{
            javaFatura.login("325421521","hfasehea");  //System.out.println("Login");
        }
        catch (SemAutorizaçãoException e){
            System.out.println("fail login 325421521");
       }
       
       try{
           javaFatura.registaFatura(ff196); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff197); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff198); // System.out.println("Regista fatura");
           javaFatura.registaFatura(ff199);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff224);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff225);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff226);  //System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout();
       
       try{
            javaFatura.login("211542122","heashea");  //System.out.println("Login");
        }
        catch (SemAutorizaçãoException e){
            System.out.println("fail login 211542122");
       }
       
       try{
           javaFatura.registaFatura(ff193);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff194);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff195);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff227);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff228);  //System.out.println("Regista fatura");
           javaFatura.registaFatura(ff229);  //System.out.println("Regista fatura");
        }
        catch (Exception e){
            System.out.println("fail regista fatura");
       }  
       
       javaFatura.logout(); 
   */
        executaMenuInicial();
        try{
            javaFatura.gravaEstado();
        }
        catch (IOException e){
             System.out.println("Erro ao guardar os dados");
        }
    }
   
   /**
    * Carrega todos os menus
    */
     private static void carregaMenu(){
        String[] inicial = {"Login", "Registar Contribuinte Individual", "Registar Contribuinte Coletivo", "Modo Administrador"};
        String[] contribuinteI = {"Devolver as faturas emitidas","Devolver as faturas pendentes","Devolver as faturas de uma dada natureza","Associar classificação de atividade económica",
                                    "Altera classificação de atividade económica",
                                    "Montante de dedução fiscal acumulado",
                                    "Montante de dedução fiscal acumulado pelo agregado familiar",
                                    "Listagem das faturas emitidas por um determinado contribuinte ordenadas por data de emissão",  
                                    "Listagem das faturas emitidas por um determinado contribuinte ordenadas por valor decrescente de despesa",
                                    "Logout"};
        String[] contribuinteC = {"Registar fatura","Devolver as faturas emitidas","Devolver as faturas pendentes","Devolver as faturas de uma dada natureza",
                                   "Associar classificação de atividade económica","Altera classificação de atividade económica","Montante de dedução fiscal acumulado",
                                   "Listagem das faturas emitidas por um determinado contribuinte ordenadas por data de emissão",  
                                   "Listagem das faturas emitidas por um determinado contribuinte ordenadas por valor decrescente de despesa",
                                   "Listagem das faturas registadas ordenadas por data de emissão",  
                                   "Listagem das faturas registadas ordenadas por valor decrescente de despesa",
                                   "Listagem das faturas por contribuinte num determinado intervalo de datas",  
                                  "Listagem das faturas por contribuinte ordenadas por valor decrescente de despesa",
                                  "Total facturado","Logout"};      
        String[] administrador = {"10 contribuintes que mais gastam em todo o sistema", "X empresas que mais facturam em todo o sistema", 
                                  "Montante de deduções fiscais que as despesas registadas representam","Número de contribuintes na aplicação","Faturas alteradas",
                                  "Empresas com bonificação","Famílias com bonificação" ,"Contribuintes com bonificação","Logout"}; 
        String[] naturezaOp = {"Cabeleireiros", "Lares", "PassesMensais", "Educação", "DespesasGerais", "RestauraçãoAlojamento", 
                                "AtividadesVeterinárias", "Habitação", "ReparaçãoAutomóveis", "ReparaçãoMotociclos", "Saúde"};
        menuNatureza = new Menu(naturezaOp);
        menuInicial = new Menu(inicial);
        menuContribuinteI = new Menu(contribuinteI);
        menuContribuinteC = new Menu(contribuinteC);
        menuAdministrador = new Menu(administrador);
    }
    
    /**
    * Executa o menu inical, que e o primeiro a surgir ao utilizador
    */
    private static void executaMenuInicial(){
        do{
            menuInicial.executaHomeMenu();
            switch(menuInicial.getOp()){
                case 1: login(); break;
                case 2: registaContribuinteI(); break;
                case 3: registaContribuinteC(); break;
                case 4: loginAdministrador(); break;
            }
        } while(menuInicial.getOp()!=0);
    }
    
    /**
    * Executa o menu do contribuinte individual, que surge quando um utilizador deste tipo faz login
    */
    private static void executaMenuContribuinteI(){
        do{
            menuContribuinteI.executaHomeMenu();
            switch(menuContribuinteI.getOp()){
                case 1: getFaturas(); break;
                case 2: getFaturasPendentes(); break;
                case 3: getFaturasNatureza(); break;
                case 4: associaNatureza(); break;
                case 5: setNatureza(); break;
                case 6: deduçãoFiscalIndividual(); break;
                case 7: deduçãoFiscalAgregado(); break;
                case 8: getFaturasData(); break;
                case 9: getFaturasValor(); break;
                case 10: logout(); break;
            }
        }  while(menuContribuinteI.getOp()!=10);
    }
    /**
    * Executa o menu do contribuinte coletivo, que surge quando um utilizador deste tipo faz login
    */                      
     private static void executaMenuContribuinteC(){
        do{
            menuContribuinteC.executaHomeMenu();
            switch(menuContribuinteC.getOp()){
                case 1: registaFatura(); break;
                case 2: getFaturas(); break;
                case 3: getFaturasPendentes(); break;
                case 4: getFaturasNatureza(); break;
                case 5: associaNatureza(); break;
                case 6: setNatureza(); break;
                case 7: deduçãoFiscalIndividual(); break;
                case 8: getFaturasData(); break;
                case 9: getFaturasValor(); break;
                case 10: faturasEmitidasData(); break;
                case 11: faturasEmitidasValor(); break;
                case 12: faturasContribuinteData(); break;
                case 13: faturasContribuinteValor(); break;
                case 14: totalFaturado(); break;
                case 15: logout(); break;
            }
        }  while(menuContribuinteC.getOp()!=15);
    }
    
    /**
    * Executa o menu do administrador, que surge quando este entra na aplicação
    */
    private static void executaMenuAdministrador(){
        do{
            menuAdministrador.executaHomeMenu();
            switch(menuAdministrador.getOp()){
                case 1: top10(); break;
                case 2: topX(); break;
                case 3: deduçaoTopX(); break;
                case 4: numContribuintes(); break;
                case 5: faturasAlteradas(); break;
                case 6: daoReduçaoEmpresas(); break;
                case 7: daoReduçaoFamilias(); break;
                case 8: daoReduçao(); break;
                case 9: logoutAdministrador(); break;
             }
        }  while(menuAdministrador.getOp()!=9);
    }
    
    /**
    * Inicia a sessão de um contribuinte na aplicação
    */
    private static void login(){
        Scanner sc = new Scanner(System.in);
        String nif, password;   
        System.out.print("Nif: ");
        nif = sc.nextLine();   
        System.out.print("Password: ");
        password = sc.nextLine();
        try{
            javaFatura.login(nif,password);
        }
        catch (SemAutorizaçãoException e){
            System.out.println(e.getMessage());
        }
        finally{
            sc.close();
        }
        switch (javaFatura.getTContribuinte()){
            case 0: executaMenuContribuinteC(); break;
            case 1: executaMenuContribuinteI(); break;
        }
    }
    
    /**
    * Inicia a sessão do administrador na aplicação
    */
    private static void loginAdministrador(){
        administrador = new Administrador();
        Scanner sc = new Scanner(System.in);
        int codigo;   
        System.out.print("Indique o código: ");
        codigo = sc.nextInt();   
        try{
            if(codigo == administrador.getCodigo())
                executaMenuAdministrador();
            else System.out.println("Código errado!");
        }
        catch (InputMismatchException e){
            System.out.println("Código inválido!");
        }
        finally{
            sc.close();
        }
    }
    
    /**
    * Regista um contribuinte individual na aplicação
    */
    private static void registaContribuinteI(){
        Scanner sc = new Scanner(System.in);
        Contribuinte c = null;
        ArrayList<String> nifs = new ArrayList<String>();
        ArrayList<String> codigos = new ArrayList<String>();
        int dependentes, filhos = 0, numCodigos;
        double coeffiscal = 0; 
        String nif, email, nome, morada, password, nifDependente, cod;
        
        if(menuInicial.getOp() ==0){
            System.out.println("Registo cancelado");
            return;
        }
        
        System.out.print("Nif: ");
        nif = sc.nextLine();
        
        System.out.print("Email: ");
        email = sc.nextLine();
        
        System.out.print("Nome: ");
        nome = sc.nextLine();
        
        System.out.print("Morada: ");
        morada = sc.nextLine();
        
        System.out.print("Password: ");
        password = sc.nextLine();
        
        System.out.print("Número de dependentes: ");
        dependentes = sc.nextInt();
        
        for(int i=0; i<dependentes;i++){
             System.out.println("Nif dos dependentes: ");
             nifDependente = sc.next();
             nifs.add(nifDependente);
        }
        
        System.out.print("Número de filhos do agregado: ");
        filhos = sc.nextInt();
        
        if(filhos>dependentes){
            System.out.println("Número inválido!");
            System.out.print("Número de filhos do agregado: ");
            filhos = sc.nextInt();
}
        
        System.out.print("Número de códigos das atividades ecónomicas: ");
        numCodigos = sc.nextInt();

        while(numCodigos!=0){
             System.out.println("Códigos: ");
             cod = sc.next();
             nifs.add(cod);
             numCodigos--;
        }
        
        System.out.print("Coeficiente fiscal em decimal: ");
        try{
        coeffiscal = sc.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Tipo inválido");// Não foi inscrito um double
            executaMenuInicial();
        }
        if (filhos>4) c = new FamiliaNumerosa(null,null,nif,email,nome,morada,password,dependentes,nifs,coeffiscal,codigos,filhos,0);
        else c = new ContribuintesIndividuais(null,null,nif,email,nome,morada,password,dependentes,nifs,coeffiscal,codigos,filhos,0); 
        
        try{
            javaFatura.registaContribuinte(c);
        }
        catch (ContribuinteExistenteException e){
            System.out.println(e.getMessage());
        } 
        
        finally {
            sc.close();
        }
    }
     
    /**
    * Regista um contribuinte coletivo na aplicação
    */
     private static void registaContribuinteC(){
        Scanner sc = new Scanner(System.in);
        Contribuinte c = null;
        int numAtividades;
        double fator = 0;
        ArrayList<String> atividadeEcon = new ArrayList<String>();
        String nif, email, nome, morada, password, atividades, concelho;
        
        if(menuInicial.getOp() ==0){
            System.out.println("Registo cancelado");
            return;
        }
        
        System.out.print("Nif: ");
        nif = sc.nextLine();
        
        System.out.print("Email: ");
        email = sc.nextLine();
        
        System.out.print("Nome: ");
        nome = sc.nextLine();
        
        System.out.print("Concelho: ");
        concelho = sc.nextLine();
        
        System.out.print("Morada: ");
        morada = sc.nextLine();
        
        System.out.print("Password: ");
        password = sc.nextLine();

        System.out.print("Número de atividades económicas: ");
        numAtividades = sc.nextInt();
        
        while(numAtividades!=0){
             System.out.print("Código: ");
             atividades = sc.next();
             if(javaFatura.codigoToNatureza(atividades)==null){
                 System.out.println("Código inválido");
                 System.out.print("Código: ");
                 atividades = sc.next();
             }
             if(javaFatura.codigoToNatureza(atividades)==null){
                 System.out.println("Código inválido");
                 executaMenuInicial();
             }
             atividadeEcon.add(atividades);
             numAtividades--;
        }
        
        System.out.print("Fator no cálculo de dedução fiscal em decimal: ");
        try{
        fator = sc.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Tipo inválido");// Não foi inscrito um double
            executaMenuContribuinteC();
        }
        
        
        if(javaFatura.concelhosDeducao().contains(concelho)){
            c = new EmpresaInterior(null,null,null,nif,email,nome,morada,password,atividadeEcon,fator,0,0,concelho);
        }
        else c = new ContribuintesColetivos(null,null,null,nif,email,nome,morada,password,atividadeEcon,fator,0,0,concelho);
        
        try{
            javaFatura.registaContribuinte(c);
        }
        catch (ContribuinteExistenteException e){
            System.out.println(e.getMessage());
        } 
        
        finally {
            sc.close();
        }
    }
    
    /**
    * Lista as despesas que foram emitidas em nome do contribuinte com sessão iniciada
    */
    private static void getFaturas(){
       List<Fatura> faturas = new ArrayList<Fatura>();
       try{
           faturas = javaFatura.getFaturas();
           for(Fatura f: faturas)
                System.out.println(f.toString());
        }
        catch (FaturaInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
    * Lista as faturas pendentes que foram emitidas em nome do contribuinte com sessão iniciada
    */
    private static void getFaturasPendentes(){
       List<Fatura> faturas = new ArrayList<Fatura>();
       try{
           faturas = javaFatura.getFaturasPendentes();
           for(Fatura f: faturas)
                System.out.println(f.toString());
        }
        catch (FaturaInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
    
   /**
    * Associa a classificação de atividade económica a uma fatura escolhida pelo contribuinte
    */
    private static void associaNatureza(){
        String natureza = null, id;
        Scanner sc = new Scanner(System.in);
        Fatura fatura = null ; 
        System.out.print("Id da fatura: ");
        id = sc.nextLine();
        
            menuNatureza.executaHomeMenu2();
            switch(menuNatureza.getOp()){
                case 1: natureza = "Cabeleireiros"; break;
                case 2: natureza = "Lares"; break;
                case 3: natureza = "PassesMensais"; break;
                case 4: natureza = "Educação"; break;
                case 5: natureza = "DespesasGerais"; break;
                case 6: natureza = "RestauraçãoAlojamento"; break;
                case 7: natureza = "AtividadesVeterinárias"; break;
                case 8: natureza = "Habitação"; break;
                case 9: natureza = "ReparaçãoAutomóveis"; break;
                case 10: natureza = "ReparaçãoMotociclos"; break;
                case 11: natureza = "Saúde"; break;
            }
        
        if(javaFatura.getContribuinte().getFatura().containsKey(id))
            fatura = javaFatura.getContribuinte().getFatura().get(id);
        else if(javaFatura.getContribuinte().getPendentes().containsKey(id))
               fatura = javaFatura.getContribuinte().getPendentes().get(id);
            
        try{
            javaFatura.associaNatureza(fatura,natureza);
        }
        catch (FaturaInexistenteException e){
             System.out.println(e.getMessage());
        }
        catch (AtividadeInexistenteException e){
             System.out.println(e.getMessage());
        }
    }
    
    /**
    * Altera a classificação de atividade económica a uma fatura escolhida pelo contribuinte
    */
    private static void setNatureza(){
        String natureza = null, id; 
        Scanner sc = new Scanner(System.in);
        Fatura fatura = null; 
        System.out.print("Id da fatura: ");
        id = sc.nextLine();

            menuNatureza.executaHomeMenu2();
            switch(menuNatureza.getOp()){
                case 1: natureza = "Cabeleireiros"; break;
                case 2: natureza = "Lares"; break;
                case 3: natureza = "PassesMensais"; break;
                case 4: natureza = "Educação"; break;
                case 5: natureza = "DespesasGerais"; break;
                case 6: natureza = "RestauraçãoAlojamento"; break;
                case 7: natureza = "AtividadesVeterinárias"; break;
                case 8: natureza = "Habitação"; break;
                case 9: natureza = "ReparaçãoAutomóveis"; break;
                case 10: natureza = "ReparaçãoMotociclos"; break;
                case 11: natureza = "Saúde"; break;
            }
        
        if(javaFatura.getContribuinte().getFatura().containsKey(id))
            fatura = javaFatura.getContribuinte().getFatura().get(id);
        
        try{
            javaFatura.setNatureza(fatura,natureza);
        }
        catch (FaturaInexistenteException e){
             System.out.println(e.getMessage());
        }
        catch (AtividadeInexistenteException e){
             System.out.println(e.getMessage());
        }
        catch (NaturezaInexistenteException e){
             System.out.println(e.getMessage());
        }
    }
    
     /**
     * Lista as faturas de uma atividade económica requerida pelo contribuinte com sessão iniciada
     */
    private static void getFaturasNatureza(){
        String natureza = null;
        Fatura fatura = null; 

            menuNatureza.executaHomeMenu2();
            switch(menuNatureza.getOp()){
                case 1: natureza = "Cabeleireiros"; break;
                case 2: natureza = "Lares"; break;
                case 3: natureza = "PassesMensais"; break;
                case 4: natureza = "Educação"; break;
                case 5: natureza = "DespesasGerais"; break;
                case 6: natureza = "RestauraçãoAlojamento"; break;
                case 7: natureza = "AtividadesVeterinárias"; break;
                case 8: natureza = "Habitação"; break;
                case 9: natureza = "ReparaçãoAutomóveis"; break;
                case 10: natureza = "ReparaçãoMotociclos"; break;
                case 11: natureza = "Saúde"; break;
            }
         
         ArrayList<Fatura> faturas = new ArrayList<Fatura>();
         try{
             faturas = javaFatura.getFaturasNatureza(natureza);
             for(Fatura f: faturas)
                   System.out.println(f.toString());
             
         }
         catch (FaturaInexistenteException e){
             System.out.println(e.getMessage());
         }
   }
    /**
    * Indica o montante de dedução fiscal acumulado pelo contribuinte com sessão iniciada
    */
    public static void deduçãoFiscalIndividual(){
        double x = javaFatura.deduçãoFiscalIndividual();
        System.out.println(x);
    }
    
    /**
    * Indica o montante de dedução fiscal acumulado pelo contribuinte com sessão iniciada e pelo seu agregado
    */
    public static void deduçãoFiscalAgregado(){
        try{
            double x = javaFatura.deduçãoFiscalAgregado();  
            System.out.println(x);
        }
        catch (AgregadoInexistenteException e){
             System.out.println(e.getMessage());
        }
    }
    /**
    * Permite converter uma data do tipo string num localDate
    */
    private static LocalDate obterData(String m){
        Scanner sc = new Scanner(System.in);
        LocalDate data;
        System.out.print(m);
        String s = sc.nextLine();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try{
            data = LocalDate.parse(s,f);
        }
        catch(DateTimeParseException e){
            System.out.println("Formato da data incorreto");
            data = obterData(m);
        }
        finally{
            sc.close();
        }   
        return data;
    }
    
    /**
    * Indica o total faturado pela empresa com sessão iniciada
    */
    private static void totalFaturado(){
        LocalDate begin,end;
        Scanner sc = new Scanner(System.in);
        begin = obterData("Data de inicio (dd-MM-yyyy): ");
        end = obterData("Data de fim (dd-MM-yyyy): ");
        try{
           double x = javaFatura.totalFaturado(begin,end);
           System.out.println(x);
        }
        catch (SemAutorizaçãoException e){
            System.out.println(e.getMessage());
        }
    }
    
   /**
    * Permite ao contribuinte terminar sessão
    */
    private static void logout(){
        javaFatura.logout();
    }
    
   /**
    * Permite ao administrador terminar sessão
    */
    private static void logoutAdministrador(){
        administrador = null;
    }
    
   /**
    * Permite ao contribuinte coletivo com sessão iniciada registar uma fatura
    */
    private static void registaFatura(){
        Scanner sc = new Scanner(System.in);
        String natureza = null, descricao, nifCliente, desig, id;
        double valor;
        LocalDate data;
        Fatura f = null;
        if(menuInicial.getOp() ==0){
            System.out.println("Registo cancelado");
            return;
        }
        data = obterData("Data de emissão (dd-MM-yyyy): ");
        System.out.print("Designaçao: ");
        desig = sc.nextLine(); 
        System.out.print("Nif do cliente: ");
        nifCliente = sc.nextLine(); 
        System.out.print("Descricao: ");
        descricao = sc.nextLine();
        
        System.out.print("Valor da despesa: ");
        valor = sc.nextDouble();
            
        id = Integer.toString(javaFatura.getId());
        f = new Pendentes();
        f.setNifEmitente(javaFatura.getContribuinte().getNif());
        f.setDesig(desig);
        f.setDataDespesa(data);
        f.setNifCliente(nifCliente);
        f.setDescricao(descricao);
        f.setValor(valor);
        f.setIdFatura(id);
        f.setNatureza("");

        try{
            javaFatura.registaFatura(f);
        }
        catch (FaturaExisteException e){
            System.out.println(e.getMessage());
        } 
        catch (ContribuinteInexistenteException e){
            System.out.println(e.getMessage());
        }  
        finally {
            sc.close();
        }
    }
    
    /**
    * Lista as facturas de uma dado contribuinte num determinado intervalo de datas emitidas pela empresa com sessão iniciada
    */
    private static void faturasContribuinteData(){
        LocalDate begin, end;
        Scanner sc = new Scanner(System.in);
        begin = obterData("Data de inicio (dd-MM-yyyy): ");
        end = obterData("Data de fim (dd-MM-yyyy): ");
        System.out.print("Nif do cliente: ");
        String nif = sc.nextLine();
        List<Fatura> faturas = new ArrayList<Fatura>();
        try{
           faturas = javaFatura.faturasContribuinteData(nif,begin,end);
           for(Fatura f: faturas)
                System.out.println(f.toString());
        }
        catch (ContribuinteInexistenteException e){
            System.out.println(e.getMessage());
        }
        catch (FaturaInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
    
   /**
    * Lista as facturas de uma dado contribuinte ordenadas por valor emitidas pela empresa com sessão iniciada
    */
    private static void faturasContribuinteValor(){
       Scanner sc = new Scanner(System.in);
       ArrayList<Fatura> faturas = new ArrayList<Fatura>();
       System.out.print("Nif do cliente: ");
       String nif = sc.nextLine();
       try{
           faturas = javaFatura.faturasContribuinteValor(nif);
           for(Fatura f: faturas)
                System.out.println(f.toString());
        }
        catch (ContribuinteInexistenteException e){
            System.out.println(e.getMessage());
        }
        catch (FaturaInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
    
        /**
         * Lista as facturas emitidas pela empresa com sessão iniciada ordenadas por valor 
         */
        private static void faturasEmitidasValor(){
          TreeSet<Fatura> faturas;
          try{
           faturas = javaFatura.getEmitidasValor();
           for(Fatura f: faturas)
                System.out.println(f.toString());
        }
        catch (FaturaInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
    
   /**
    * Lista as facturas emitidas pela empresa com sessão iniciada ordenadas por data 
    */
    private static void faturasEmitidasData(){
          TreeSet<Fatura> faturas;
          try{
           faturas = javaFatura.getEmitidasData();
           for(Fatura f: faturas)
                System.out.println(f.toString());
        }
        catch (FaturaInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Lista as faturas cuja atividade económica foi alterada pelos contribuintes
     */
    private static void faturasAlteradas(){
        ArrayList<Fatura> f = new ArrayList<Fatura>();
        try{
            f = javaFatura.faturasAlteradas();
            for(Fatura i: f)
                System.out.println(i.toString());
        }
        catch (FaturaInexistenteException e){
            System.out.println(e.getMessage());
        }
        catch (ContribuinteInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Lista as faturas emitidas por um dado contribuinte
     */
    private static void getFaturasData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nif do emitente: ");
        String nif = sc.nextLine();
        ArrayList<Fatura> f = new ArrayList<Fatura>();
        try{
            f = javaFatura.getFaturasData(nif);
            for(Fatura i: f)
                System.out.println(i.toString());
        }
        catch (FaturaInexistenteException e){
            System.out.println(e.getMessage());
        }
        catch (ContribuinteInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Lista as faturas emitidas por um dado contribuinte
     */
    private static void getFaturasValor(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nif do emitente: ");
        String nif = sc.nextLine();
        ArrayList<Fatura> f = new ArrayList<Fatura>();
        try{
            f = javaFatura.getFaturasValor(nif);
            for(Fatura i: f)
                System.out.println(i.toString());
        }
        catch (FaturaInexistenteException e){
            System.out.println(e.getMessage());
        }
        catch (ContribuinteInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
    * Lista os dez contribuintes que mais gastam em todo o sistema
    */
    private static void top10(){
        int conta = 0;
        ArrayList<Contribuinte> c;
       try{
           c = javaFatura.top10(); 
           for(Contribuinte i: c){
                if(conta<10) System.out.println(i.toString());
                else break;
                conta++;
            }
        }
        catch(ContribuinteException e){
            System.out.println(e.getMessage());  
        }
    }
    
    /**
    * Lista as X empresas que mais faturam em todo o sistema
    */
    private static void topX(){
       int conta = 0;
       TreeSet<ContribuintesColetivos> c;
       Scanner sc = new Scanner(System.in);
       int empresas;
       System.out.print("Numero de empresas: ");
       empresas = sc.nextInt();
       try{
           c = javaFatura.topX(empresas);  
           for(ContribuintesColetivos i: c){
                if(conta<empresas) System.out.println(i.toString());
                else break;
                conta++;
           }
        }
        catch(ContribuinteException e){
            System.out.println(e.getMessage());  
        }
        finally{
            sc.close();
        }
    }
    
   /**
    * Indica o montande de dedução fiscal das X empresas com maior faturacão
    */
    private static void deduçaoTopX(){
        Scanner sc = new Scanner(System.in);
        int empresas;
        System.out.print("Numero de empresas: ");
        empresas = sc.nextInt();
        try{
        javaFatura.deduçaoTopX(javaFatura.topX(empresas),empresas);
        }
        catch(ContribuinteException e){
            System.out.println(e.getMessage());  
        }
        finally{
            sc.close();
        }
    }
    
   /**
    * Indica o número de contribuintes individuais e coletivos registados na aplicação
    */
    private static void numContribuintes(){
        System.out.println("Estao registados: " + javaFatura.numContribuintesIndividuais() + " contribuintes individuais e " + 
        javaFatura.numContribuintesColetivos() + " contribuintes coletivos."); 
    }
    
    /**
     * Carrega o estado da aplicação da última vez que esta foi fechada.
     * @param fich
     */
    private static void carregaEstado() {
        try {
            javaFatura = JavaFatura.initApp();
        }
        catch(IOException e) {
            javaFatura = new JavaFatura();
            System.out.println("Não foi possível ler os dados guardados!\nErro de leitura!");
        }
        catch(ClassNotFoundException e) {
            javaFatura = new JavaFatura();
            System.out.println("Não foi possível ler os dados guardados!\nFicheiro com formato desconhecido!");
        }
        catch(ClassCastException e) {
            javaFatura = new JavaFatura();
            System.out.println("Não foi possível ler os dados guardados!\nErro de formato!");
        }
    }
    
   /**
    * Lista os contribuintes individuais com incentivo fiscal, ou seja, as famílias numerosas
    */
    private static void daoReduçaoFamilias(){
     List<FamiliaNumerosa> faturas = new ArrayList<FamiliaNumerosa>();
     try{
           faturas = javaFatura.daoReduçaoFamilias();
           for(FamiliaNumerosa f: faturas)
                System.out.println(f.toString());
     }
     catch (FamíliasInexistenteException e){
            System.out.println(e.getMessage());
     }
            }
    
   /**
    * Lista os contribuintes coletivos com incentivo fiscal, ou seja, as empresas do interior
    */
    private static void daoReduçaoEmpresas(){
     List<EmpresaInterior> faturas = new ArrayList<EmpresaInterior>();
     try{
            faturas = javaFatura.daoReduçaoEmpresas();
            for(EmpresaInterior f: faturas)
                 System.out.println(f.toString());
     }
    catch (EmpresasInexistenteException e){
           System.out.println(e.getMessage());
    }
   }
   
   /**
    * Lista todos os contribuintes com incentivo fiscal
    */
   private static void daoReduçao(){
     List<IncentivoFiscal> faturas = new ArrayList<IncentivoFiscal>();
     try{
            faturas = javaFatura.daoReduçao();
            for(IncentivoFiscal f: faturas)
                 System.out.println(f.toString());
     }
    catch (IncentivoInexistenteException e){
           System.out.println(e.getMessage());
    }
   }
         
         
}
