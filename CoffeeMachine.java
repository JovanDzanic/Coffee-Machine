import java.util.Scanner;
import java.lang.Thread;

public class CoffeeMachine {
    int maxWater = 10000; // mL
    int maxCoffee = 1250; // g
    int maxMilk = 5000; // mL
    int maxSugar = 500; // g
    Scanner sc= new Scanner(System.in);

    public int sugarSelect(int a){
 
        Boolean question2 = true;
        do{    
            System.out.println("Koliko zelite kocke secera? 1-5");
            int sugarCube= sc.nextInt();
            if(sugarCube<1 || sugarCube>5){
                System.out.println("Uneli ste nemogucu kolicinu secera, molimo vas unesite opet");
            }else{
                for(int i=1;i<=sugarCube;i++){
                    a = a - 5;
                }
                question2 = false;
            }
        }while(question2==true);
        return a;
    }

    public int addingSubstance(int a, int b, int c){

        boolean question = true;
        
        do{
            
            int insertWater = sc.nextInt();
            if(insertWater > b){
                System.out.println("Nema dovoljno prostora za zadatu kolicinu! Unesite ponovo");
            }else{
                a = a + insertWater;
                System.out.println("Trenutno stanje je: " + a + " , od ukupnog kapaciteta: " + c );
                question=false;    
            }
        }while(question==true);
        return a;
    }
}

class Espresso {
    int water = 200; // mL
    int coffee = 20; // g
    int milk = 0; // mL
    int price = 80; // dinara
}

class Latte {
    int water = 100; // mL
    int coffee = 25; // g
    int milk = 150; // mL
    int price = 130; // dinara
}

class Cappuccino {
    int water = 150; // mL
    int coffee = 25; // g
    int milk = 100; // mL
    int sugar = 0; // g
    int price = 150; // dinara
}

class Main{
    public static void main(String[] args) throws InterruptedException{
        
        // Trenutna kolicina supstanci u aparatu
        int waterInMachine = 5000; // mL
        int coffeeInMachine = 650; // g
        int milkInMachine = 2650; // mL
        int sugarInMachine = 150; // g 
        boolean turnOff = true;
        String password = "password123";
        int moneyInMachine = 0;
        int insertMoney = 0;
        int option;
        boolean question3 = true;
        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        CoffeeMachine cm = new CoffeeMachine();
        Espresso e = new Espresso();
        Latte l = new Latte();
        Cappuccino c = new Cappuccino();
        
        do{         //DOBRODOSLICA ILI UPOZORENJE
            System.out.println();
            if(waterInMachine < 200 ){
                System.out.println("IZVINJAVAMO SE! Trenutno nema dovoljno vode u aparatu, uskoro ce biti dopunjeno");
            }else if(coffeeInMachine < 25){
                System.out.println("IZVINJAVAMO SE! Trenutno nema dovoljno kafe u aparatu, uskoro ce biti dopunjeno");
            }else if(milkInMachine < 150){
                System.out.println("IZVINJAVAMO SE! Trenutno nema dovoljno mleka u aparatu, uskoro ce biti dopunjeno");
            }else{
                System.out.println("DOBRODOSLI!");
            }

            System.out.println();
            if(waterInMachine < 200 || coffeeInMachine < 25 || milkInMachine < 150){
                System.out.println("Molimo vas da ne korisite aparat dok ga operater ne dopuni!");
            }else{      // DODAVANJE NOVCA
                
                System.out.println("Trenutno novcano stanje na aparatu je " + moneyInMachine + " dinara. Da li zelite dodati novac: y/n ");
                char addingMoney=in1.next().charAt(0);
                if(addingMoney=='y' || addingMoney=='Y'){
                System.out.println("Ubacite kolicinu novca koju zelite dodati: ");
                insertMoney= in.nextInt();
                moneyInMachine= moneyInMachine + insertMoney;
                }
                  
            }
                                    //FUNKCIJE APARATA
            int moneyShort = 0;
            System.out.println();
            if(waterInMachine < 200 || coffeeInMachine < 25 || milkInMachine < 150){

                option = 0;
        
            }else{   
                System.out.println("Izaberite 1 od ponudjenih opcija:");
                System.out.println("1.Espresso        2.latte");
                System.out.println("3.Cappuccino      ");
                System.out.println("9.Kusur           0.Settings");
                option = in.nextInt();
            }


            if(option == 1){ // ESPRESSO

                if(moneyInMachine < e.price){
                    moneyShort = e.price - moneyInMachine;
                    System.out.println("Nemate dovoljno novca za ovu kafu, trebate dodati: " + moneyShort );  
                }else{
                    waterInMachine = waterInMachine - e.water;
                    coffeeInMachine = coffeeInMachine - e.coffee;
                    milkInMachine = milkInMachine - e.milk;
                    moneyInMachine = moneyInMachine - e.price;
                    System.out.println("Da li zelite secer? y/n");
                    char wantingSugar = in1.next().charAt(0);
                    if(wantingSugar == 'y' || wantingSugar == 'Y'){
                        if(sugarInMachine<25){
                            System.out.println("Zao nam je ali trenutno je aparat bez secera");
                        }else{    
                            sugarInMachine = cm.sugarSelect(sugarInMachine);  
                        } 
                    }  
                    System.out.println();
                    System.out.println("Molimo sacekajte par sekundi dok se kafa napravi");  
                    Thread.sleep(8000);
                    System.out.println("Vas Espresso je stigao. Prijatno!");  
                }

            }else if(option == 2){ // LATTE

                if(moneyInMachine < l.price){
                    moneyShort = l.price - moneyInMachine;
                    System.out.println("Nemate dovoljno novca za ovu kafu, trebate dodati: " + moneyShort );  
                }else{
                    waterInMachine = waterInMachine - l.water;
                    coffeeInMachine = coffeeInMachine - l.coffee;
                    milkInMachine = milkInMachine - l.milk;
                    moneyInMachine = moneyInMachine - l.price;
                    System.out.println("Da li zelite secer? y/n");
                    char wantingSugar = in1.next().charAt(0);
                    if(wantingSugar == 'y' || wantingSugar == 'Y'){
                        if(sugarInMachine<25){
                            System.out.println("Zao nam je ali trenutno je aparat bez secera");
                        }else{    
                            sugarInMachine = cm.sugarSelect(sugarInMachine);  
                        } 
                    }  
                    System.out.println();
                    System.out.println("Molimo sacekajte par sekundi dok se kafa napravi");  
                    Thread.sleep(10000);
                    System.out.println("Vas Latte je stigao. Prijatno!"); 
                }
            
            }else if(option == 3){ // CAPPUCCINO

                if(moneyInMachine < c.price){
                    moneyShort = c.price - moneyInMachine;
                    System.out.println("Nemate dovoljno novca za ovu kafu, trebate dodati: " + moneyShort );  
                }else{
                    waterInMachine = waterInMachine - c.water;
                    coffeeInMachine = coffeeInMachine - c.coffee;
                    milkInMachine = milkInMachine - c.milk;
                    moneyInMachine = moneyInMachine - c.price;
                    System.out.println("Da li zelite secer? y/n");
                    char wantingSugar = in1.next().charAt(0);
                    if(wantingSugar == 'y' || wantingSugar == 'Y'){
                        if(sugarInMachine<25){
                            System.out.println("Zao nam je ali trenutno je aparat bez secera");
                        }else{    
                            sugarInMachine = cm.sugarSelect(sugarInMachine);  
                        } 
                    }  
                    System.out.println();
                    System.out.println("Molimo sacekajte par sekundi dok se kafa napravi");  
                    Thread.sleep(12000);
                    System.out.println("Vas Cappuccino je stigao. Prijatno!"); 
                }
            }else if(option == 9){ // KUSUR
                
                System.out.println("Vas kusur je: " + moneyInMachine + " dinara, da li zelite da narucite jos nesto? y/n");
                char change = in1.next().charAt(0);
                if(change == 'y' || change == 'Y'){
                    Thread.sleep(1000);
                }else{
                    System.out.println("Preuzmite vas novac. Dovidjenja!");
                    moneyInMachine = 0;
                    Thread.sleep(3000);
                }
                
                
            }else if(option == 0){ // PODESAVANJA U APARATU (SIFRA JE: password123)

                System.out.println("Unesite sifru ako zelite upravljati funkcijama aparata:");
                String passwordInput = in2.nextLine();

                if(passwordInput.equals(password)){
                    do{
                    System.out.println();
                    System.out.println("Trenutno stanje u aparatu: ");
                    System.out.println("voda: " + waterInMachine + "ml, kafa: " + coffeeInMachine + "g, mleko: " + milkInMachine + "ml, secer: "+ sugarInMachine + "g");
                    System.out.println();
                    System.out.println("Koju komandu zelite izvrsiti:");
                    System.out.println("1.Dodavanje vode      2.Dodavanje kafe ");
                    System.out.println("3.Dodavanje mleka     4.Dodavanje secera");
                    System.out.println("5.GASENJE APARATA" );
                    int settingsOption = in.nextInt();
                    System.out.println();
                    
                    switch(settingsOption){
                        case 1:                //DODAVANJE VODE
                            
                            int freeWaterSpace = cm.maxWater - waterInMachine;
                            System.out.println("Preostali prostor za vodu u aparatu je: " + freeWaterSpace +"ml, da li zelite dodati jos vode? y/n");
                            char addWater  = in1.next().charAt(0);
                            if(addWater  == 'Y' || addWater  == 'y'){
                                System.out.println("Unesite kolicinu vode u mililitrima koju zelite dodati:");
                                waterInMachine = cm.addingSubstance(waterInMachine, freeWaterSpace, cm.maxWater);
                                System.out.println();
                            } 
                        break;
                            
                        case 2:                //DODAVANJE KAFE
                            int freeCoffeeSpace = cm.maxCoffee - coffeeInMachine;
                            System.out.println("Preostali prostor za kafu u aparatu je: " + freeCoffeeSpace +"g, da li zelite dodati jos kafe? y/n");
                            char addCoffee = in1.next().charAt(0);
                            if(addCoffee  == 'Y' || addCoffee  == 'y'){
                                System.out.println("Unesite kolicinu kafe u gramu koju zelite dodati:");
                                coffeeInMachine = cm.addingSubstance(coffeeInMachine, freeCoffeeSpace,cm.maxCoffee);
                                System.out.println();
                            } 
                        break;

                        case 3:             // DODAVANJE MLEKA
                            int freeMilkSpace = cm.maxMilk - milkInMachine;
                            System.out.println("Preostali prostor za mleko u aparatu je: " + freeMilkSpace +"ml, da li zelite dodati jos mleka? y/n");
                            char addMilk  = in1.next().charAt(0);
                            if(addMilk  == 'Y' || addMilk  == 'y'){
                                System.out.println("Unesite kolicinu mleka u mililitrima koju zelite dodati:");
                                milkInMachine = cm.addingSubstance(milkInMachine, freeMilkSpace, cm.maxMilk);
                                System.out.println();
                            };
                        break;

                        case 4:             // DODAVANJE SECERA
                            int freeSugarSpace = cm.maxSugar - sugarInMachine;
                            System.out.println("Preostali prostor za secer u aparatu je: " + freeSugarSpace +"g, da li zelite dodati jos secera? y/n");
                            char addSugar = in1.next().charAt(0);
                            if(addSugar  == 'Y' || addSugar  == 'y'){
                                System.out.println("Unesite kolicinu secera u gramu koju zelite dodati:");
                                sugarInMachine = cm.addingSubstance(sugarInMachine, freeSugarSpace, cm.maxSugar);
                                System.out.println();
                            } 
                        break;

                        case 5:             // GASENJE APARATA
                            System.out.println("Da li ste sigurni da zelite da ugasite aparat? y/n");
                            char off = in1.next().charAt(0);
                            if(off =='y' || off == 'Y'){
                                System.out.println("Sacekajte da se aparat ugasi");
                                turnOff=false;
                                Thread.sleep(4000);
                                System.out.println("DOVIDJENJA!");
                            }
                        break;

                        default:
                        System.out.println("Lose uneta komanda");
                    }
                    if(turnOff == true){
                        System.out.println("Da li zelite izaci iz podesavanja? y/n");
                        char settingsExit = in1.next().charAt(0);
                        if(settingsExit == 'Y' || settingsExit == 'y'){
                            question3 = false;
                        }
                    }else{
                        question3 = false;
                    }

                    }while(question3 == true);

                }else{
                    System.out.println("Uneli ste pogresnu sifru!");
                }


            }else{    
                System.out.println("Uneli ste pogresnu komandu!");
            }

        Thread.sleep(1000);    
            
        }while(turnOff == true);

    }
}