package Clases;

public class Productor extends Thread{
    int quantity = 0;
    Huerto huerto;

    public Productor(int quantity, Huerto huerto) {
        this.quantity = quantity;
        this.huerto = huerto;
    }
    String vegetales[] = {
            "lettuce",
            "cabbage",
            "onion",
            "spinach",
            "potato",
            "celery",
            "asparagus",
            "radish",
            "broccoli",
            "artichoke",
            "tomato",
            "cucumber",
            "eggplant",
            "carrot",
            "green bean"
    };
    @Override
    public void run (){
        for (int i = 0; i < quantity; i++) {
            try{
                int numeroRandom = (int) (Math.random() * vegetales.length);
                int tiempoCrecimiento = (int) (Math.random() * 5000) + 1;
                Thread.sleep(tiempoCrecimiento);
                String vegetalRadnom = vegetales[numeroRandom];
                System.out.println("Productor ---> " +  vegetalRadnom);
                huerto.saveVegetables(vegetalRadnom);
            } catch (InterruptedException e) {
                System.out.println("CASCASO");
            }
        }
    }
};
